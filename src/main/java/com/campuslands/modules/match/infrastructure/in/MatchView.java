package com.campuslands.modules.match.infrastructure.in;



import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.campuslands.Main;
import com.campuslands.core.helpers.HandleErrors;
import com.campuslands.modules.team.domain.models.Team;
import com.campuslands.modules.team.infrastructure.out.MySQLTeamAdapter;

public class MatchView {

    JPanel bodyContainer;
    JPanel container;
    JPanel buttons;
    JButton backButton;
    JButton addButton;

    JTextField inputName;
    JTextField inputStadium;

    public MatchView(JButton buttonBack){

        container = new JPanel(new BorderLayout());
        bodyContainer = new JPanel(new GridLayout(0, 1));

        inputName = new JTextField(30);
        JPanel input_container_name = new JPanel(new FlowLayout());
        input_container_name.add(new JLabel("Nombre del Equipo"));
        input_container_name.add(inputName);

        inputStadium = new JTextField(30);
        JPanel input_container_stadium = new JPanel(new FlowLayout());
        input_container_stadium.add(new JLabel("Nombre del Estadio"));
        input_container_stadium.add(inputStadium);

        buttons = new JPanel(new FlowLayout());
        addButton = addButton();
        backButton = buttonBack;
        buttons.add(backButton);
        buttons.add(addButton);


        bodyContainer.add(input_container_name);
        bodyContainer.add(input_container_stadium);

        container.add(BorderLayout.CENTER, bodyContainer);
        container.add(BorderLayout.SOUTH, buttons);

    }



    public JPanel getContainer() {
        return container;
    }

  

    public JButton addButton(){
        JButton buttonAdd = new JButton("Agregar Equipo");
        buttonAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String name = inputName.getText();
                        String stadium = inputStadium.getText();
                        if (name != null) {
                            MySQLTeamAdapter mySQLTeamAdapter = new MySQLTeamAdapter();
                            mySQLTeamAdapter.save(new Team(name, stadium));
                            HandleErrors.showSuccessful("Se Guardo", "Nuevo equipo creado correctamente");
                            Main.reload(Main.homeView());
                        }else{
                            HandleErrors.showError("Nombre incorrecto", "Ingresa un Nombre Valido");
                        }
                    } catch (Exception a) {
                        HandleErrors.showError("Error", a.getMessage());
                    }
                }
        });
        return buttonAdd;
    }


    
    
}
