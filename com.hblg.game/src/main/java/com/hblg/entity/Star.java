package com.hblg.entity;

import com.hblg.game.GameFrame;

import java.awt.*;
import java.util.Random;

public class Star {
    public static final Font font = new Font("微软雅黑",Font.BOLD,20);
    private Random ran;
    private int x ;
    private int y ;
    private int speed;
    private Color color;

    Star stars [] = new Star[300];

    public Star(){
        ran = new Random();
        x = ran.nextInt(GameFrame.W);
        y = ran.nextInt(GameFrame.H-20)+20;
        speed = 5;
        color = Color.WHITE;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * 实现背景图星星的下落
     */
    public void starsDwon(){
        for (int i = 0; i < stars.length; i++) {
            Star star = stars[i];
            int y = star.getY()+star.getSpeed();
            if (y>GameFrame.H){
                y = 0 ;
            }
            star.setY(y);
        }
    }


    public void createStars(){
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star();
        }
    }

    /**
     * 实现画背景图的星星
     * @param g
     */
    public void drawStars(Graphics g){
        for (int i = 0; i < stars.length; i++) {
            Star star = stars[i];
            g.setColor(star.getColor());
            Color color = new Color(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256));
            g.setColor(color);
            g.drawString("*",star.getX(),star.getY());
        }
    }
}



