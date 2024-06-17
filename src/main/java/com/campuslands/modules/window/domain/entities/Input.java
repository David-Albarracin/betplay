package com.campuslands.modules.window.domain.entities;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.campuslands.core.helpers.HandleErrors;

public class Input {

    private JTextField input;
    private JPanel div;

    public Input(String labelText, int labelColumns) {
        input = new JTextField(labelColumns);
        div = new JPanel();
        div.add(new JLabel(labelText));
        div.add(input);
    }

    public JPanel getInput() {
        return div;
    }

    public void offEdit(){
        input.setEditable(false);
    }

    public JPanel getDiv() {
        return div;
    }

    public String getText() {
        return input.getText();
    }

    public int getInt(){
        try {
            return Integer.parseInt(getText());
        } catch (Exception e) {
            HandleErrors.showError("Error Dato no valido", e.getMessage());
            return -1;
        }
    }


    public void setText(String text) {
        input.setText(text);
    }
}

