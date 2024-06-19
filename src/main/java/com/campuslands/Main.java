package com.campuslands;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.campuslands.modules.match.infrastructure.in.MatchView;
import com.campuslands.modules.team.infrastructure.in.TableTeam;
import com.campuslands.modules.team.infrastructure.in.ViewTeam;
import com.campuslands.modules.team.infrastructure.out.MySQLTeamAdapter;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main implements Runnable  {

    
    private static JFrame frame;
    private static JPanel mainPanel;
    private static JMenuBar menuBar;


    @Override
    public void run() {
        System.out.println("Hello world!");
    }


    public static void main(String[] args) {
        window();
        frame.setVisible(true);
    }


    public static void window(){
        frame = new JFrame("BetPlay");
        mainPanel = new JPanel(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        //ADD HEADER
        header();
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        reload(homeView());
      
        frame.add(mainPanel);
    }

    // Method to reload the center panel
    public static void reload(JPanel div) {

        // Remove existing center component
        if (mainPanel.getComponentCount() > 0) {
            mainPanel.remove(0);
        }

        // Add the new component
        mainPanel.add(div, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }


    public static JPanel homeView(){
        MySQLTeamAdapter mySQLTeamAdapter = new MySQLTeamAdapter();
        JPanel div = new TableTeam(mySQLTeamAdapter.findAll()).getDiv();
        return div;
    }

    public static JButton backButton(){
        JButton buttonBack = new JButton("Regresar");
        buttonBack.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    reload(homeView());
                }
        });
        return buttonBack;
    }


    public static void header(){
        menuBar = new JMenuBar();
        JMenu option = new JMenu("Inicio");
        
        option.add(new JMenuItem(new AbstractAction("Salir") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        }));
        menuBar.add(option);
        //Teams
        option = new JMenu("Equipos");
        option.add(new JMenuItem(new AbstractAction("Nuevo Equipo") {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewTeam viewTeam = new ViewTeam(backButton());
                Main.reload(viewTeam.getContainer());
            }
        }));
        menuBar.add(option);

        //Matchs
        option = new JMenu("Partidos");

        option.add(new JMenuItem(new AbstractAction("Nuevo Partido") {
            @Override
            public void actionPerformed(ActionEvent e) {
                MatchView matchView = new MatchView(backButton());
                Main.reload(matchView.getContainer());
            }
        }));

        option.add(new JMenuItem(new AbstractAction("Resultado de Partido") {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ViewTeam viewTeam = new ViewTeam(backButton());
                // Main.reload(viewTeam.getContainer());
            }
        }));

        menuBar.add(option);

        // menuBar.add(Teams());
        // menuBar.add(Match());
        // menuBar.add(Person());
        // menuBar.add(reportTeams());
        // menuBar.add(reportPersons());


        

    
    }



}