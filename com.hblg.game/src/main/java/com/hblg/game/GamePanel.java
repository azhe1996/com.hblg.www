package com.hblg.game;

import com.hblg.entity.Back;
import com.hblg.entity.Star;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel {

    Star stars [] ;
    Random ran ;

    Back back;

    public GamePanel(){
        back = new Back();
        ran = new Random();
        stars = new Star[300];
        createStars();
        threadCreate();
    }



    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.BLACK);
        /*g.setFont(Star.font);
        drawStars(g);*/
        g.drawImage(Back.IMG2,back.getX(),back.getY(),back.getWidth(),back.getHeight(),null);

        g.setColor(Color.RED);
        g.fillOval(100,400,100,100);

    }







    /**线程的创建*/
    private void threadCreate(){
        new Thread(()->{
            while(true){


                int y = back.getY();
                if(y>0){
                    y=-back.getHeight()+GameFrame.H;
                }
                back.setY(++y);

                starsDwon();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }
        }).start();
    }
    
    
    private void starsDwon(){
        for (int i = 0; i < stars.length; i++) {
            Star star = stars[i];
            int y = star.getY()+star.getSpeed();
            if (y>GameFrame.H){
                y = 0 ;
            }
            star.setY(y);
        }
    }
    

    private void createStars(){
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star();
        }
    }

    private void drawStars(Graphics g){
        for (int i = 0; i < stars.length; i++) {
            Star star = stars[i];
            g.setColor(star.getColor());
            Color color = new Color(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256));
            g.setColor(color);
            g.drawString("*",star.getX(),star.getY());
        }
    }
}
