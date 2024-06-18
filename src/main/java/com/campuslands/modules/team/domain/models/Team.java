package com.campuslands.modules.team.domain.models;

import java.util.List;



import com.campuslands.modules.person.domain.model.Person;


public class Team {

    int id;
    String name;
    String stadium;
    int pj;
    int pg;
    int pp;
    int pe;
    int gf;
    int gc;
    int tp;
    boolean active;
    List<Person>persons;

    public Team(String name, String stadium){
        //this.id = Data.teams.size() + 1;
        this.name = name;
        this.stadium = stadium;
    }

    

    public Team(int id, String name, int pj, int pg, int pp, int pe, int gf, int gc, int tp, boolean active, String stadium) {
        this.id = id;
        this.name = name;
        this.stadium = stadium;
        this.pj = pj;
        this.pg = pg;
        this.pp = pp;
        this.pe = pe;
        this.gf = gf;
        this.gc = gc;
        this.tp = tp;
    }



    public String getStadium() {
        return stadium;
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

    public int getPj() {
        return pj;
    }

    public void setPj(int pj) {
        this.pj = pj;
    }

    public int getPg() {
        return pg;
    }

    public void setPg(int pg) {
        this.pg = pg;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public int getPe() {
        return pe;
    }

    public void setPe(int pe) {
        this.pe = pe;
    }

    public int getGf() {
        return gf;
    }

    public void setGf(int gf) {
        this.gf = gf;
    }

    public int getGc() {
        return gc;
    }

    public void setGc(int gc) {
        this.gc = gc;
    }

    public int getTp() {
        return tp;
    }

    public void setTp(int tp) {
        this.tp = tp;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    

    
}
