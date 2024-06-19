package com.campuslands.core.components;


import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class Select {
    protected JPanel div;
    protected JComboBox<String> select;
    protected List<String> options;
    protected String labelText;

    public Select(String labelText, List<String> options) {
        this.labelText = labelText;
        this.options = options;
        select = new JComboBox<>();
        div = new JPanel();
        div.add(new JLabel(labelText));

        // Añadir las opciones al JComboBox
        for (String option : this.options) {
            select.addItem(option);
        }

        div.add(select);
    }

    public String getValue() {
        return (String) select.getSelectedItem();
    }

    public JPanel getSelect() {
        return div;
    }
}
