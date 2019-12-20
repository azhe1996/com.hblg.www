package com.hblg.object;

import java.awt.*;

/**
 * 定义一个星星的对象类模板.
 */
public class Star {
    public static final String STR = "*";
    private int x ;
    private int y ;
    private Color color ;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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
}
