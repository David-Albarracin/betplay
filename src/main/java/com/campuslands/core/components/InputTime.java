package com.campuslands.core.components;

import java.sql.Date;
import java.sql.Time;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.time.LocalDate;

public class InputTime {

    JSpinner date;
    JPanel DatePanel;

    public InputTime(String title, String format){
        switch (format) {
            case "date":
                format =  "dd/MM/yyyy";
                break;
        
            case "time":
                format =  "HH:mm";
                break;
        }
        date = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(date,format);
        date.setEditor(dateEditor);

        // Establece la fecha actual como valor inicial del JSpinner
        date.setValue(Date.valueOf(LocalDate.now()));

        DatePanel = new JPanel();
        DatePanel.add(new JLabel(title));
        DatePanel.add(date);
    }

    public JPanel getDatePanel() {
        return DatePanel;
    }

     // Método para obtener la fecha seleccionada como java.sql.Date
     public Date getValue() {
        // Obtener el valor del JSpinner (debe ser un java.util.Date)
        java.util.Date utilDate = (java.util.Date) date.getValue();
        
        // Convertir java.util.Date a java.sql.Date
        return new Date(utilDate.getTime());
    }

    // Método para obtener la hora seleccionada como java.sql.Time
    public Time getTime() {
        // Obtener el valor del JSpinner (debe ser un java.util.Date)
        java.util.Date utilDate = (java.util.Date) date.getValue();
        
        // Convertir java.util.Date a java.sql.Time
        return new Time(utilDate.getTime());
    }
}
