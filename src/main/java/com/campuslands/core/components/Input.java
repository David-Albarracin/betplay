package com.campuslands.core.components;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Input {

    private JPanel input;
    private JTextField inputText;

    public Input(String title, int fieldCol){
        inputText = new JTextField(fieldCol);
        input = new JPanel(new FlowLayout());
        input.add(new JLabel(title));
        input.add(inputText);
    }

    public JPanel getInput() {
        return input;
    }

    public String valueTxt() {
        return inputText.getText();
    }

    public int valueInt() {
        try {
            int data = Integer.parseInt(inputText.getText());
            return data;
        } catch (Exception e) {
            return -1;
        }
         
    }

    public class QuantityInput extends Input {

        JButton more;
        JButton minus;
        
        public QuantityInput(String title, int fieldCol){
            super(title, fieldCol);
            inputText.setEditable(false);
            inputText.setText("0");

            more = new JButton("+");
            more.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Incrementa la cantidad en 1
                    int currentValue = Integer.parseInt(inputText.getText());
                    inputText.setText(String.valueOf(currentValue + 1));
                }
            });

            minus = new JButton("-");
            minus.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Decrementa la cantidad en 1, evitando que sea menor que 0
                    int currentValue = Integer.parseInt(inputText.getText());
                    if (currentValue > 0) {
                        inputText.setText(String.valueOf(currentValue - 1));
                    }
                }
            });

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(more);
            buttonPanel.add(minus);

            input.add(buttonPanel);

        }
        
    }
    
}
