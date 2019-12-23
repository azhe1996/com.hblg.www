package com.hblg.game;

import javax.swing.*;
import java.awt.*;

public class CirclePanel extends JPanel {
    Circle c;

    public CirclePanel() {
        c = new Circle();
        new Thread(() -> {
            while (true) {
                //判定移动到指定条件时转换方向=======记得注释
//                c.driecption = Circle.RIGHT_DOWN;
                switch (c.driecption) {
                    case Circle.RIGHT_DOWN:
                        c.x++;
                        c.y++;
                        if(c.y>(GameFrame.H-c.r*2)){
                            c.driecption=Circle.RIGHT_UP;
                        }
                        if(c.x>(GameFrame.W-c.r*2)){
                            c.driecption=Circle.LEFT_DOWN;
                        }
                        break;
                    case Circle.LEFT_DOWN:
                        c.y++;
                        c.x--;
                        if(c.y>(GameFrame.H-c.r*2)){
                            c.driecption=Circle.LEFT_UP;
                        }
                        if(c.x<0){
                            c.driecption=Circle.RIGHT_DOWN;
                        }
                        break;
                    case Circle.LEFT_UP:
                        c.x--;
                        c.y--;
                        if(c.y<0){
                            c.driecption=Circle.LEFT_DOWN;
                        }
                        if(c.x<0){
                            c.driecption=Circle.RIGHT_UP;
                        }
                        break;
                    case Circle.RIGHT_UP:
                        c.y--;
                        c.x++;
                        if(c.y<0){
                            c.driecption=Circle.RIGHT_DOWN;
                        }
                        if(c.x>(GameFrame.W-c.r*2)){
                            c.driecption=Circle.LEFT_UP;
                        }
                        break;
                }




                try {
                    Thread.sleep(1);
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
        g.setColor(Color.BLUE);

        g.fillOval(c.x, c.y, c.r * 2, c.r * 2);

    }
}
