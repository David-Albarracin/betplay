package com.campuslands.modules.match.infrastructure.out;

import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import com.campuslands.core.contracts.MySQLRepository;
import com.campuslands.modules.match.domain.models.Match;


public class MySQLMatchAdapter extends MySQLRepository<Match, Long> {

     public MySQLMatchAdapter() {
        super();
    }


    @Override
    protected Match mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("match_id");
        int team_local = resultSet.getInt("team_local_id");
        int team_visitor = resultSet.getInt("team_visitor_id");
        Date match_date = resultSet.getDate("match_date");
        Time match_time = resultSet.getTime("match_time");
        String stadium = resultSet.getString("stadium");
    
        return new Match(id, team_local, team_visitor, match_date, match_time, stadium);
    }

    @Override
    protected PreparedStatement createFindByIdStatement(Connection connection, Long id) throws SQLException {
        String query = "SELECT *  FROM match WHERE match_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        return statement;
    }

    protected PreparedStatement getMatchForNotResult(Connection connection) throws SQLException {
        String query = "SELECT *  FROM match WHERE match_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        //statement.setLong(1, id);
        return statement;
    }

    @Override
    protected PreparedStatement createSaveStatement(Connection connection, Match match) throws SQLException {
        String query = "INSERT INTO matchs (match_id, team_local_id, team_visitor_id, match_date, match_time, stadium) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, match.getId());
        statement.setInt(2, match.getLocalTeam());
        statement.setInt(3, match.getVisitorTeam());
        statement.setDate(4, match.getDate());
        statement.setTime(5, match.getTime());
        statement.setString(6, match.getStadium());
        return statement;
    }

    @Override
    protected String getTableName() {
        return "matchs";
    }
}
