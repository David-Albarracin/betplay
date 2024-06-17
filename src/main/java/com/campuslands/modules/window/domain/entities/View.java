package com.campuslands.modules.window.domain.entities;

import java.awt.GridLayout;


import javax.swing.JPanel;

public class View {

    public JPanel div;

    public View(){
        div = new JPanel(new GridLayout(0, 1));
    }

    public JPanel getDiv() {
        return div;
    }

}
