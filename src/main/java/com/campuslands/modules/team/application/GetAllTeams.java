package com.campuslands.modules.team.application;

import java.util.List;
import java.util.ArrayList;

import com.campuslands.modules.team.domain.models.Team;
import com.campuslands.modules.team.infrastructure.out.MySQLTeamAdapter;

public class GetAllTeams {

       public ArrayList<String> findAllTeamOptions(){
        ArrayList<String> options = new ArrayList<>();
        MySQLTeamAdapter mySQLTeamAdapter = new MySQLTeamAdapter();
        List<Team> teams = mySQLTeamAdapter.findAll();
        for (int index = 0; index < teams.size(); index++) {
            options.add(teams.get(index).getId() + " " + teams.get(index).getName());
        }
 
        return options;
    }
    
}
