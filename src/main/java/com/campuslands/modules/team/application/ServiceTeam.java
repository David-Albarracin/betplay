package com.campuslands.modules.team.application;

import com.campuslands.Main;
import com.campuslands.core.helpers.HandleErrors;
import com.campuslands.modules.team.domain.models.Team;
import com.campuslands.modules.team.infrastructure.out.MySQLTeamAdapter;

public class ServiceTeam {

    public void createTeam(String name, String stadium) {
        try {
            if (name != null) {
                MySQLTeamAdapter mySQLTeamAdapter = new MySQLTeamAdapter();
                mySQLTeamAdapter.save(new Team(name, stadium));
                HandleErrors.showSuccessful("Se Guardo", "Nuevo equipo creado correctamente");
                Main.reload(Main.homeView());
            } else {
                HandleErrors.showError("Nombre incorrecto", "Ingresa un Nombre Valido");
            }
        } catch (Exception a) {
            HandleErrors.showError("Error", a.getMessage());
        }
    }
    
}
