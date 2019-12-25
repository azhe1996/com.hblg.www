package com.hblg.ballgame;

import com.hblg.game.GameFrame;

import java.util.Random;

public class Ball {
    public static final int LEFT_UP = 0 ;
    public static final int RIGHT_UP = 1 ;
    public static final int LEFT_DOWN = 2 ;
    public static final int RIGHT_DOWN = 3 ;
    public int driecption;
    public int speed;
    Random ran ;
    int x , y , r ;
    public Ball (){
        ran = new Random();
        r = 30;
        x = ran.nextInt(BallFrame.W-r*2);
        y = ran.nextInt(BallFrame.H-r*2);
        driecption = ran.nextInt(2);
        speed = 1 ;
    }
}
