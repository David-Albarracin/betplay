package com.campuslands.server.modules.person.domain.model;

import java.util.UUID;

public class Person {
    private int id;
    private String code;



   

    public Person(){this.code =  UUID.randomUUID().toString();}

}
