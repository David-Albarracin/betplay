package com.campuslands.modules.window.infrastructure;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.campuslands.modules.team.infrastructure.ViewTeam;
import com.campuslands.modules.window.domain.entities.Header;


/**
 * ViewAdapter
 */
public class ViewAdapter {


    public ViewAdapter(){
        Header.getInstance().teams.add(new JMenuItem(new AbstractAction("Nuevo Equipo") {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewTeam viewTeam = new ViewTeam();
                viewTeam.showViewTeam();
            }   
        }));

        
    }

 
    
}