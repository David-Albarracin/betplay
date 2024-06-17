package com.campuslands;

import javax.swing.SwingUtilities;

import com.campuslands.modules.window.domain.entities.MainFrame;
import com.campuslands.modules.window.infrastructure.ViewAdapter;

public class Main implements Runnable  {

    @Override
    public void run() {
        System.out.println("Hello world!");
    }


    public static void main(String[] args) {
        new ViewAdapter();
        SwingUtilities.invokeLater(MainFrame::getInstance);
    }


}