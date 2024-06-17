package com.campuslands.modules.person.domain.model;

public class Player extends Person {

    int goals; 
    String position; 
    int shirtNumber; 
    int redTargets;
    int yellowTargets;

    // Constructor de Player
    public Player(int id, String name, String surName, int age, String dateInit, String nationality, String rol, int goals, String position, int shirtNumber) {
        super(id, name, surName, age, dateInit, nationality, rol);
        this.goals = goals;
        this.position = position;
        this.shirtNumber = shirtNumber;
    }

    
}
