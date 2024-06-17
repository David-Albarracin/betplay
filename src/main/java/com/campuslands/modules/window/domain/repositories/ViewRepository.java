package com.campuslands.modules.window.domain.repositories;

import javax.swing.JPanel;

public interface ViewRepository<addMySQLButton, addGjsonButton> {


    JPanel getDiv();

    void setAddMySQLButton();

    void setAddGjsonButton();



}
