package com.campuslands;

import javax.swing.SwingUtilities;

import com.campuslands.modules.window.domain.entities.MainFrame;

public class Main implements Runnable  {

    @Override
    public void run() {
        System.out.println("Hello world!");
    }


    public static void main(String[] args) {   
        SwingUtilities.invokeLater(MainFrame::getInstance);
    }


}