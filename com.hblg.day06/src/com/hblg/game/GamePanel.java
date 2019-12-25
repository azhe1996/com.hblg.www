package com.hblg.game;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/***
 * 画板类.
 */
public class GamePanel extends JPanel {

    Snow [] snows ;
    Random ran;
    public GamePanel(){
        ran = new Random();
        snows = new Snow[500];
        createSnows(ran);


        new Thread(()->{
            while(true){
                for (int i = 0; i < snows.length; i++) {
                    Snow snow = snows[i];
                    int y = snow.getY();
                    if (y>GameFrame.H){
                        y=0;
                    }
                    snow.setY(++y);
                    int x = 0 ;
                    if(i%2==0){
                        x = snow.getX();
                        if (x<-30){
                            x = GameFrame.W;
                        }
                        snow.setX(--x);
                    }else{
                        x = snow.getX();
                        if (x>GameFrame.W){
                            x = -30;
                        }
                        snow.setX(++x);
                    }

                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                repaint();

            }
        }).start();
    }

    public void createSnows(Random ran){
        for (int i = 0; i < snows.length; i++) {
            snows[i] = new Snow();
            snows[i].setX(ran.nextInt(GameFrame.W));
            snows[i].setY(ran.nextInt(GameFrame.H-30)+30);
        }
    }



    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.BLACK);
        g.setColor(Color.CYAN);
        g.setFont(Snow.FONT);

        for (int i = 0; i < snows.length; i++) {
            g.drawString(
                    Snow.STR,snows[i].getX(),snows[i].getY());
        }


    }
}
