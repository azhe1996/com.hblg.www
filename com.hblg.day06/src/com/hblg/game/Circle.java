package com.hblg.game;

import java.awt.*;
import java.util.Random;

public class Circle {
    public static final int LEFT_UP = 0 ;
    public static final int LEFT_DOWN = 1 ;
    public static final int RIGHT_UP = 2 ;
    public static final int RIGHT_DOWN = 3 ;
    public int driecption;
    Random ran ;

    int x , y , r ;
    Color color ; //单个圆的颜色
    int speed;  //单个圆的速度
    public Circle (){
        ran = new Random();
        r = ran.nextInt(76)+25;
        x = ran.nextInt(GameFrame.W-r*2);
        y = ran.nextInt(GameFrame.H-r*2);
        driecption = ran.nextInt(4);
        color = new Color(ran.nextInt(256),ran.nextInt(256),ran.nextInt(256));
        speed = ran.nextInt(10)+1;
    }
    public Circle(int x ,int y ){
        this();
        this.x = x ;
        this.y = y ;
    }
    public Circle(int x, int y ,int r ){
        this.x = x ;
        this.y = y ;
        this.r = r ;
    }

}
