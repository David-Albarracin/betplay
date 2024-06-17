package com.campuslands.modules.window.domain.entities;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.campuslands.modules.team.domain.models.Team;
import com.campuslands.modules.team.infrastructure.MySQLTeamAdapter;


public class Header {

    private static Header instance;
    public JMenuBar mb;
  

    public Header(){
        //header options
        mb = new JMenuBar();
        JMenu option = new JMenu("inicio");

        option.add(new JMenuItem(new AbstractAction("Salir") {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getInstance().close();
            }
        }));

        mb.add(option);

        option = new JMenu("Equipos");

        option.add(new JMenuItem(new AbstractAction("Nuevo Equipo") {
            @Override
            public void actionPerformed(ActionEvent e) {
                MySQLTeamAdapter mySQLTeamAdapter = new MySQLTeamAdapter();
                mySQLTeamAdapter.save(new Team("Bucaramanga"));
                Swal swal = Swal.getInstance("Nuevo Equipo");
                // swal.setBodySwal(viewTeam);
                // swal.setAddButton(viewTeam.getAddButton());
                swal.fire();
            }
        }));
        mb.add(option);
    }


    public JMenuBar getMb() {
        return mb;
    }


    // Method to get the Singleton instance
    public static synchronized Header getInstance() {
        if (instance == null) {
            instance = new Header();
        }
        return instance;
    }



    public void addOption(JMenu option) {
        mb.add(option);
    }



}

