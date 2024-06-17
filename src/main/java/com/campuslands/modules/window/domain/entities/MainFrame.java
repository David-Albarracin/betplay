package com.campuslands.modules.window.domain.entities;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;



public class MainFrame {

    private static MainFrame instance;
    private JFrame frame;
    private JPanel mainPanel;
    
    public MainFrame() {
        frame = new JFrame("BetPlay");
        mainPanel = new JPanel(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        frame.getContentPane().add(BorderLayout.NORTH, Header.getInstance().getMb());
        reload(); // Load initial data
        frame.add(mainPanel);

        frame.setVisible(true);
    }

     // Method to reload the center panel
     public void reload() {

        // Remove existing center component
        if (mainPanel.getComponentCount() > 0) {
            mainPanel.remove(0);
        }

        // Add the new component
        //mainPanel.add(teamController.getTeamTable(), BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    

    // Method to get the Singleton instance
    public static synchronized MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
        }
        return instance;
    }


    public void close(){
        frame.setVisible(false);
    }

}
