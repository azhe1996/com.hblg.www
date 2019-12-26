package com.hblg.game;

import javax.swing.*;

public class FlightFrame extends JFrame {

    public FlightFrame(){

        FlightPanel fp = new FlightPanel();
        this.add(fp);
        this.setBounds(300,20,400,700);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
