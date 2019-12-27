package com.hblg.entity;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

/**
 * 需要创建出画飞机所有的变量及常量
 * 常量:
 *      飞机的图片
 * 画飞机时需要的变量.
 *  坐标及大小
 *
 *
 *
 */
public class Flight {

    public static Image img_1 = null ;
    public static Image img_2 = null ;

    static{
        img_1 = new ImageIcon("D:\\IdeaProjects\\com.hblg.gitee\\com.hblg.game\\src\\main\\resources\\img\\flight_1.png").getImage();
        img_2 = new ImageIcon("D:\\IdeaProjects\\com.hblg.gitee\\com.hblg.game\\src\\main\\resources\\img\\flight_2.png").getImage();
    }

    //同时生成的.并不是在静态域中生成.
//    Date date = new Date();
//    {}


    private int x ;
    private int y ;
    private int width;
    private int height;
    private Image img;

    public Flight(){
        //图片的宽度及高度的赋值
        width = 60;
        height = 80;
        //实现飞机图片的切换
        imageChange();
    }

    private void imageChange(){
        new Thread(()->{
            int i = 0 ;
            while(true){
                i++;
                if(i%2==0){
                    img = img_1;
                }else{
                    img = img_2;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
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
