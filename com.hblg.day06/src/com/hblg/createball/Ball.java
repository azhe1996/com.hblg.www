package com.hblg.createball;

import java.awt.*;

/**
 *  自己的球,生成的球都用当前的类来实现
 *  自己球颜色为绿,大一些,
 *  生成的球为蓝色,小一些.
 */
public class Ball {
    //应该是声明两个图片的常量
    public static final Color COLOR_1 =Color.GREEN;
    public static final Color COLOR_2 =Color.CYAN;


    int x,y,r,speed;
    //应该声明一个飞机的变量
    Color color;
    public Ball(int r ){
        this.r = r ;
        x = 0 ;
        y = 0 ;
        speed = 1 ;
//        color = Color.GREEN;
        colorChage();
    }
    public Ball(int r ,Color color){
        speed = 1 ;
        this.r = r;
        this.color = color;
    }

    /***
     * 自己的飞机创建独有的线程.
     *  前提:
     *      在当前程序中,只需要一次线程的启动.
     *  应对的是程序不结束,线程一直存在的情况.
     *
     */
    public void colorChage(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;; i++) {
                    if(i%2==0){
                        Ball.this.color = Ball.COLOR_1;
                    }else{
                        Ball.this.color = Ball.COLOR_2;
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


}
