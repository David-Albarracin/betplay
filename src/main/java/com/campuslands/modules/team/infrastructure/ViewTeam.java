package com.campuslands.modules.team.infrastructure;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.campuslands.core.helpers.HandleErrors;
import com.campuslands.modules.window.domain.entities.Input;
import com.campuslands.modules.window.domain.entities.View;

public class ViewTeam extends View{

    Input input;
   

    public ViewTeam(){
        super();
        input = new Input("Nombre del Equipo", 30);
        addButton = new JButton("Agregar Equipo MySQL");
        addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String name = input.getText();
                        if (name != null) {
                            if (name != "") {
                                HandleErrors.showError("Duplicate entry", name + " Exist");
                                return;
                            }else{
                                HandleErrors.showError("Duplicate entry", name + " Exist");
                            }
                        } 
                    } catch (Exception a) {
                        HandleErrors.showError("Error", a.getMessage());
                    }
                }
        });
        div.add(input.getDiv());
    }


   
   


}
