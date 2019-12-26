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
}
