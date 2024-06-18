package com.campuslands.modules.team.infrastructure.in;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.campuslands.modules.team.domain.models.Team;

public class TableTeam {

    DefaultTableModel model;
    JTable table;
    JScrollPane scrollPane;
    JPanel div;

    public TableTeam(List<Team> teams){
        div = new JPanel(new GridLayout(0, 1));
         String[] columnNames = {"NOMBRE DEL EQUIPO", "PJ", "PG", "PP", "PE", "GF", "GC", "TP"};
            Object[][] data = new Object[teams.size()][8];
            for (int i = 0; i < teams.size(); i++) {
                Team team = teams.get(i);
                data[i][0] = team.getName();
                data[i][1] = team.getPj();
                data[i][2] = team.getPg();
                data[i][3] = team.getPp();
                data[i][4] = team.getPe();
                data[i][5] = team.getGf();
                data[i][6] = team.getGc();
                data[i][7] = team.getTp();
            }

            model = new DefaultTableModel(data, columnNames);
            table = new JTable(model);
            table.setBorder(new EmptyBorder(100, 10, 10, 10));
            scrollPane = new JScrollPane(table);
            div.add(scrollPane);
    }

    public JPanel getDiv() {
        return div;
    }


    
}
