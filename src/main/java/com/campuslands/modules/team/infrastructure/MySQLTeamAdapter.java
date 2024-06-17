package com.campuslands.modules.team.infrastructure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.campuslands.core.contracts.MySQLRepository;
import com.campuslands.modules.team.domain.models.Team;

public class MySQLTeamAdapter extends MySQLRepository<Team, Long> {

     public MySQLTeamAdapter() {
        super(); 
    }

    @Override
    protected Team mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return new Team(resultSet.getString("name"));
    }

    @Override
    protected PreparedStatement createFindByIdStatement(Connection connection, Long id) throws SQLException {
        String query = "SELECT team_id, team_name  FROM teams WHERE team_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        return statement;
    }

    @Override
    protected PreparedStatement createSaveStatement(Connection connection, Team team) throws SQLException {
        String query = "INSERT INTO teams (team_id, team_name) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, team.getId());
        statement.setString(2, team.getName());
        return statement;
    }

    @Override
    protected String getTableName() {
        return "teams";
    }

  
}
