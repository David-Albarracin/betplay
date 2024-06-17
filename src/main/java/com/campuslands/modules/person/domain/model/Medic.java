package com.campuslands.modules.person.domain.model;

public class Medic extends Person {
    int yearsExperience; // Atributo específico de Medic

    // Constructor de Medic
    public Medic(int id, String name, String surName, int age, String dateInit, String nationality, String rol, int yearsExperience) {
        super(id, name, surName, age, dateInit, nationality, rol);
        this.yearsExperience = yearsExperience;
    }

    // Getter y setter para yearsExperience
    public int getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }
}
