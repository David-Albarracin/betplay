package com.campuslands.modules.window.domain.repositories;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class ViewRepository {

    JPanel div;
    JButton addMySQLButton;
    JButton addGjsonButton;

    public ViewRepository(){
        div = new JPanel(new GridLayout(0, 1));
    }


    public JPanel getDiv() {
        return div;
    }


    public JButton getAddMySQLButton() {
        return addMySQLButton;
    }

    public JButton getAddGjsonButton() {
        return addGjsonButton;
    }



}
