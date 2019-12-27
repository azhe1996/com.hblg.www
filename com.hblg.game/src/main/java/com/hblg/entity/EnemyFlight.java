package com.hblg.entity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class EnemyFlight {
    public static final Image img = new ImageIcon("D:\\IdeaProjects\\com.hblg.gitee\\com.hblg.game\\src\\main\\resources\\img\\enemyPlane.gif").getImage();

    private int x ;
    private int y ;
    private int width;
    private int height;
    private int speed;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public EnemyFlight (){
        width = 30;
        height = 30;
        speed = 3 ;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
