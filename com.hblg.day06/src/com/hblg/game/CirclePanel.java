package com.hblg.game;

import javax.swing.*;
import java.awt.*;

public class CirclePanel extends JPanel {
    Circle c;

    Circle [] cs;

    public CirclePanel() {
        cs = new Circle[10];
        createCircles(cs);
        c = new Circle();
        circlesMove();
    }
    private void createCircles(Circle [] cs) {
        for (int i = 0; i < cs.length; i++) {
                cs[i] = new Circle();
        }
    }
    private void circlesMove() {
        new Thread(() -> {
            while (true) {
                //判定移动到指定条件时转换方向=======记得注释
//                c.driecption = Circle.RIGHT_DOWN;

                for (int i = 0; i < cs.length; i++) {
                    Circle c = cs[i];
                    switch (c.driecption) {
                        case Circle.RIGHT_DOWN:
                            c.x+=c.speed;
                            c.y+=c.speed;
                            if(c.y>(GameFrame.H-c.r*2)){
                                c.driecption=Circle.RIGHT_UP;
                            }
                            if(c.x>(GameFrame.W-c.r*2)){
                                c.driecption=Circle.LEFT_DOWN;
                            }
                            break;
                        case Circle.LEFT_DOWN:
                            c.y+=c.speed;
                            c.x-=c.speed;
                            if(c.y>(GameFrame.H-c.r*2)){
                                c.driecption=Circle.LEFT_UP;
                            }
                            if(c.x<0){
                                c.driecption=Circle.RIGHT_DOWN;
                            }
                            break;
                        case Circle.LEFT_UP:
                            c.x-=c.speed;
                            c.y-=c.speed;
                            if(c.y<0){
                                c.driecption=Circle.LEFT_DOWN;
                            }
                            if(c.x<0){
                                c.driecption=Circle.RIGHT_UP;
                            }
                            break;
                        case Circle.RIGHT_UP:
                            c.y-=c.speed;
                            c.x+=c.speed;
                            if(c.y<0){
                                c.driecption=Circle.RIGHT_DOWN;
                            }
                            if(c.x>(GameFrame.W-c.r*2)){
                                c.driecption=Circle.LEFT_UP;
                            }
                            break;
                    }
                }



                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }
        }).start();
    }



    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.BLACK);

        for (int i = 0; i < cs.length; i++) {
            Circle c = cs[i];
            g.setColor(c.color);
            g.fillOval(c.x, c.y, c.r * 2, c.r * 2);
        }

    }
}
