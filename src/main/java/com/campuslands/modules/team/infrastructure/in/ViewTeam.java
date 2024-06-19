package com.campuslands.modules.team.infrastructure.in;



import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


import com.campuslands.core.components.Input;
import com.campuslands.modules.team.application.ServiceTeam;


public class ViewTeam{

    JPanel bodyContainer;
    JPanel container;
    JPanel buttons;
    JButton backButton;
    JButton addButton;

    Input inputName;
    Input inputStadium;

    public ViewTeam(JButton buttonBack){
        container = new JPanel(new BorderLayout());
        bodyContainer = new JPanel(new GridLayout(0, 1));

        inputName = new Input("Nombre del Equipo", 30);
        inputStadium = new Input("Nombre del Estadio", 30);

        buttons = new JPanel(new FlowLayout());
        addButton = addButton();
        backButton = buttonBack;
        buttons.add(backButton);
        buttons.add(addButton);


        bodyContainer.add(inputName.getInput());
        bodyContainer.add(inputStadium.getInput());

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
                   new ServiceTeam().createTeam(inputName.valueTxt(), inputStadium.valueTxt());
                }
        });
        return buttonAdd;
    }

   


}
