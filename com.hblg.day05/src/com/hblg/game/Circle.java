package com.hblg.game;

import java.util.Random;

public class Circle {
    public static final int LEFT_UP = 0 ;
    public static final int LEFT_DOWN = 1 ;
    public static final int RIGHT_UP = 2 ;
    public static final int RIGHT_DOWN = 3 ;
    public int driecption;
    Random ran ;

    int x , y , r ;

    public Circle (){
        ran = new Random();
        r = 30;
        x = ran.nextInt(GameFrame.W-r*2);
        y = ran.nextInt(GameFrame.H-r*2);
        driecption = ran.nextInt(4);
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
