package com.hblg.object;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
/**
 * 通过implements Runnable让当前类变成线程类.
 * */
public class MyPanel extends JPanel implements Runnable {
    private Star  [] stars ;
    private Random ran ;

    public MyPanel (){
        //300是画多少个星星的控制
        stars = new Star[300];
        ran = new Random();
        createStars(stars);
    }

    /**
     * 根据stars创建每一个星星.
     * @param stars
     */
    public void createStars(Star[] stars){
        for (int i = 0; i < stars.length; i++) {
            Star star = stars[i] = new Star();
            star.setX(ran.nextInt(MyFrame.W/2));
            star.setY(ran.nextInt(MyFrame.H/2-12)+12);
            Color color = new Color(ran.nextInt(255),ran.nextInt(255),ran.nextInt(255));
            star.setColor(color);
        }
    }



    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.BLACK);
        //画出相应的星星.
        drawStars(g);
    }

    public void drawStars(Graphics g){
        for (int i = 0; i < stars.length; i++) {
            Star star = stars[i];
//            g.setColor(star.getColor());
            changeGraphics(g);
            g.drawString(Star.STR,star.getX(),star.getY());
        }
    }

    private void changeGraphics(Graphics g){
        g.setColor(new Color(ran.nextInt(255),ran.nextInt(255),ran.nextInt(255)));
    }
    @Override
    public void run() {
        //创建一个死循环
        while(true){
            //实现每一个星星的下落  ==>y坐标变动
            for (int i = 0; i < stars.length; i++) {
                Star star = stars[i];
                int y = star.getY();
                if ((y+12)>MyFrame.H/2){
                    y = 0 ;
                }
                star.setY(++y);
            }
            //让每一个循环的速度慢下来
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //当前赋值是在内存中实现的,并没有显示在屏幕中,重画
            repaint();
        }
    }
}
