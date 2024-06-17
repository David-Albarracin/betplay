package com.campuslands.modules.team.infrastructure;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.campuslands.core.helpers.HandleErrors;
import com.campuslands.modules.team.domain.models.Team;
import com.campuslands.modules.window.domain.entities.Input;
import com.campuslands.modules.window.domain.entities.Swal;
import com.campuslands.modules.window.domain.entities.View;

public class ViewTeam extends View{

    Swal swal;
    Input input;

   

    public ViewTeam(){
        swal = Swal.getInstance("Nuevo Equipo");
        input = new Input("Nombre del Equipo", 30);
        JButton addButton = new JButton("Agregar Equipo");
        addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String name = input.getText();
                        if (name != null) {
                            MySQLTeamAdapter mySQLTeamAdapter = new MySQLTeamAdapter();
                            mySQLTeamAdapter.save(new Team(input.getText()));
                            HandleErrors.showSuccessful("Se Guardo", "Nuevo equipo creado correctamente");
                            swal.close();
                        }else{
                            HandleErrors.showError("Nombre incorrecto", "Ingresa un Nombre Valido");
                        }
                    } catch (Exception a) {
                        HandleErrors.showError("Error", a.getMessage());
                    }
                }
        });
        swal.setBodySwal(input.getDiv());
        swal.setAddButton(addButton);

    }


    public void showViewTeam(){
        swal.fire();
    }
   


}
