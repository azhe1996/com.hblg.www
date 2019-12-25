package com.hblg.test;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FrameTest extends JFrame {

    public FrameTest(){
        this.setBounds(300,200,500,500);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        this.addMouseMotionListener(new MouseAdapter() {

        });


        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        new FrameTest();
    }

}
