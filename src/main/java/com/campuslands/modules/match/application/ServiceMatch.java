package com.campuslands.modules.match.application;


import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import com.campuslands.Main;
import com.campuslands.core.helpers.HandleErrors;
import com.campuslands.modules.match.domain.models.Match;
import com.campuslands.modules.match.infrastructure.out.MySQLMatchAdapter;
import com.campuslands.modules.team.application.GetAllTeams;


public class ServiceMatch {
    
    public ArrayList<String> findAllTeamOptions(){
        return new GetAllTeams().findAllTeamOptions();
    }

    public void createMatch(String local_team, String visitor_team, Date match_date, Time match_time, String stadium) {
        String[] localTeamInfo = local_team.split(" ");
        int lt = Integer.parseInt(localTeamInfo[0]);

        String[] visitorTeamInfo = visitor_team.split(" ");
        int vt = Integer.parseInt(visitorTeamInfo[0]);

        new MySQLMatchAdapter().save(new Match(lt, vt, match_date, match_time, stadium));

        HandleErrors.showSuccessful("Se Guardo", "Nuevo Partido creado correctamente");
        Main.reload(Main.homeView());
    }


    


}
