package com.campuslands.modules.person.domain.model;

import java.util.UUID;

public class Person {
    int id;
    String code;
    String name;
    String surName;
    int age; 
    String dateInit;
    String nationality;
    String rol;

    public Person(int id, String name, String surName, int age, String dateInit, String nationality, String rol){
        this.id = id;
        this.code =  UUID.randomUUID().toString();
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.dateInit = dateInit;
        this.nationality = nationality;
        this.rol = rol;
    
    }

}
