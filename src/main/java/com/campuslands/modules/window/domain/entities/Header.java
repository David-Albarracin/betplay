package com.campuslands.modules.window.domain.entities;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



public class Header {

    private static Header instance;
    public JMenuBar mb;
    public JMenu home;
    public JMenu teams;
    public JMenu match;
    public JMenu person;
    public JMenu reportTeams;
    public JMenu reportPersons;

    public Header(){
        //header options
        mb = new JMenuBar();
        home = new JMenu("inicio");
        teams = new JMenu("equipos");
        match = new JMenu("partidos");
        person = new JMenu("jugadores");
        reportTeams = new JMenu("reporte equipos");
        reportPersons = new JMenu("reporte personas");

        home.add(new JMenuItem(new AbstractAction("Salir") {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getInstance().close();
            }
        }));

        mb.add(home);
        mb.add(teams);
        mb.add(match);
        mb.add(person);
        mb.add(reportTeams);
        mb.add(reportPersons);
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


}

