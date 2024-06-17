package com.campuslands.modules.team.domain.models;

import java.util.ArrayList;
import java.util.List;



import com.campuslands.modules.person.domain.model.Person;


public class Team {

    int id;
    String name;
    int pj;
    int pg;
    int pp;
    int pe;
    int gf;
    int gc;
    int tp;
    List<Person>persons;

     public Team(String name){
        //this.id = Data.teams.size() + 1;
        this.name = name;
        this.persons = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    
}
