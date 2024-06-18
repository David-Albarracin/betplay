package com.campuslands.modules.team.infrastructure.out;

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
        int id = resultSet.getInt("team_id");
        String name = resultSet.getString("team_name");
        int pj = resultSet.getInt("pj");
        int pg = resultSet.getInt("pg");
        int pp = resultSet.getInt("pp");
        int pe = resultSet.getInt("pe");
        int gf = resultSet.getInt("gf");
        int gc = resultSet.getInt("gc");
        int tp = resultSet.getInt("tp");
        boolean active = resultSet.getBoolean("active");
        String stadium = resultSet.getString("team_stadium");
    
        return new Team(id, name, pj, pg, pp, pe, gf, gc, tp, active, stadium);
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
        String query = "INSERT INTO teams (team_id, team_name, pj, pg, pp, pe, gf, gc, tp, active, team_stadium) VALUES (?, ?, 0, 0, 0, 0, 0, 0, 0, 1, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, team.getId());
        statement.setString(2, team.getName());
        statement.setString(3, team.getStadium());
        return statement;
    }

    @Override
    protected String getTableName() {
        return "teams";
    }

}
