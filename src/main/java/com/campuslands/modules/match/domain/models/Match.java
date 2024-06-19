package com.campuslands.modules.match.domain.models;

import java.sql.Time;
import java.sql.Date;


public class Match {

    int id;
    int localTeam;
    int visitorTeam;
    Date date;
    Time time;
    String stadium;



    public Match(int localTeam, int visitorTeam, Date date, Time time, String stadium) {
        this.localTeam = localTeam;
        this.visitorTeam = visitorTeam;
        this.date = date;
        this.time = time;
        this.stadium = stadium;
    }
    
    public Match(int id, int localTeam, int visitorTeam, Date date, Time time, String stadium) {
        this.id = id;
        this.localTeam = localTeam;
        this.visitorTeam = visitorTeam;
        this.date = date;
        this.time = time;
        this.stadium = stadium;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getLocalTeam() {
        return localTeam;
    }
    public void setLocalTeam(int localTeam) {
        this.localTeam = localTeam;
    }
    public int getVisitorTeam() {
        return visitorTeam;
    }
    public void setVisitorTeam(int visitorTeam) {
        this.visitorTeam = visitorTeam;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Time getTime() {
        return time;
    }
    public void setTime(Time time) {
        this.time = time;
    }
    public String getStadium() {
        return stadium;
    }
    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    
    
}
