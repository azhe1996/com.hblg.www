package com.hblg.entity;

import com.hblg.game.GameFrame;

import javax.swing.*;
import java.awt.*;

public class Back {
    public static final Image IMG = new ImageIcon("D:\\IdeaProjects\\com.hblg.gitee\\com.hblg.game\\src\\main\\resources\\img\\back.JPG").getImage();
    public static final Image IMG1 = new ImageIcon("D:\\IdeaProjects\\com.hblg.gitee\\com.hblg.game\\src\\main\\resources\\img\\background_1.png").getImage();
    public static final Image IMG2 = new ImageIcon("D:\\IdeaProjects\\com.hblg.gitee\\com.hblg.game\\src\\main\\resources\\img\\background_2.png").getImage();
    public static final Image IMG3 = new ImageIcon("D:\\IdeaProjects\\com.hblg.gitee\\com.hblg.game\\src\\main\\resources\\img\\background_3.png").getImage();
    public static final Image IMG4 = new ImageIcon("D:\\IdeaProjects\\com.hblg.gitee\\com.hblg.game\\src\\main\\resources\\img\\background_4.png").getImage();


    private int x ;
    private int y ;
    private int width;
    private int height;

    public Back(){
        width = GameFrame.W;
        height = 6000;
        x = 0 ;
        y = -height+GameFrame.H;
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
