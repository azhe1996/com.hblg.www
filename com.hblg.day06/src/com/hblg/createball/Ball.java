package com.hblg.createball;

import java.awt.*;

/**
 *  自己的球,生成的球都用当前的类来实现
 *  自己球颜色为绿,大一些,
 *  生成的球为蓝色,小一些.
 */
public class Ball {
    int x,y,r,speed;
    Color color;
    public Ball(int r ){
        this.r = r ;
        x = 0 ;
        y = 0 ;
        speed = 1 ;
        color = Color.GREEN;
    }
    public Ball(int r ,Color color){
        speed = 1 ;
        this.r = r;
        this.color = color;
    }
}
