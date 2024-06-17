package com.campuslands.modules.person.domain.model;

public class Technical extends Person {
    String idFederation; // Atributo específico de Technical

    // Constructor de Technical
    public Technical(int id, String name, String surName, int age, String dateInit, String nationality, String rol, String idFederation) {
        super(id, name, surName, age, dateInit, nationality, rol);
        this.idFederation = idFederation;
    }

  
}
