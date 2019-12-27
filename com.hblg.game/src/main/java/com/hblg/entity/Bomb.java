package com.hblg.entity;

import javax.swing.*;
import java.awt.*;

public class Bomb {
    public static final Image img_0 = new ImageIcon("D:\\IdeaProjects\\com.hblg.gitee\\com.hblg.game\\src\\main\\resources\\img\\bomb_0.gif").getImage();
    public static final Image img_1 = new ImageIcon("D:\\IdeaProjects\\com.hblg.gitee\\com.hblg.game\\src\\main\\resources\\img\\bomb_1.gif").getImage();
    public static final Image img_2 = new ImageIcon("D:\\IdeaProjects\\com.hblg.gitee\\com.hblg.game\\src\\main\\resources\\img\\bomb_2.gif").getImage();
    public static final Image img_3 = new ImageIcon("D:\\IdeaProjects\\com.hblg.gitee\\com.hblg.game\\src\\main\\resources\\img\\bomb_3.gif").getImage();

    private int x;
    private int y ;
    private int width;
    private int height;
    private Image img;

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public Bomb() {
        width = 30;
        height = 30;
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
