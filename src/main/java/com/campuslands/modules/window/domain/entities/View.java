package com.campuslands.modules.window.domain.entities;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class View {


    public JPanel div;
    public JButton addButton;

    public View(){
        div = new JPanel(new GridLayout(0, 1));
    }


    public JPanel getDiv() {
        return div;
    }


    public JButton getAddButton() {
        return addButton;
    }
}
