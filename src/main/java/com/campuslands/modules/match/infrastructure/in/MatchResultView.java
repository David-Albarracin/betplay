package com.campuslands.modules.match.infrastructure.in;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.campuslands.core.components.Input;
import com.campuslands.core.components.InputTime;
import com.campuslands.core.components.Select;
import com.campuslands.core.helpers.HandleErrors;
import com.campuslands.modules.match.application.ServiceMatch;

public class MatchResultView {
    

    JPanel bodyContainer;
    JPanel container;
    JPanel buttons;
    JButton backButton;
    JButton addButton;

    Select localTeamSelect;
    Select visitorTeamSelect;

    InputTime match_date;
    InputTime match_time;

    Input stadium;


     public MatchResultView(JButton buttonBack) {
        container = new JPanel(new BorderLayout());
        bodyContainer = new JPanel(new GridLayout(0, 1));


        localTeamSelect = new Select("Equipo Local", new ServiceMatch().findAllTeamOptions());
        visitorTeamSelect = new Select("Equipo Visitante", new ServiceMatch().findAllTeamOptions());
        match_date = new InputTime("Fecha del Partido", "date");
        match_time = new InputTime("Hora del Partido", "time");

        stadium = new Input("Estadio", 30);

        buttons = new JPanel(new FlowLayout());
        addButton = addButton();
        backButton = buttonBack;
        buttons.add(backButton);
        buttons.add(addButton);

        bodyContainer.add(localTeamSelect.getSelect());
        bodyContainer.add(visitorTeamSelect.getSelect());
        bodyContainer.add(match_date.getDatePanel());
        bodyContainer.add(match_time.getDatePanel());
        bodyContainer.add(stadium.getInput());

        container.add(BorderLayout.CENTER, bodyContainer);
        container.add(BorderLayout.SOUTH, buttons);

    }

    public JPanel getContainer() {
        return container;
    }

    public JButton addButton() {
        JButton buttonAdd = new JButton("Agregar Partido");
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String local_team = localTeamSelect.getValue();
                String visitor_team = visitorTeamSelect.getValue();
                if (local_team.equals(visitor_team)) {
                    HandleErrors.showError("ErrorTeam", "Error el equipo local no se puede enfrentar contra el mismo");
                } else {
                   new ServiceMatch().createMatch(local_team, visitor_team, match_date.getValue(), match_time.getTime(), stadium.valueTxt());
                }
            }
        });
        return buttonAdd;
    }


}
