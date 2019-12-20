package com.hblg.game;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * 画板       ====>     画纸
 */
public class MyPanel extends JPanel {
    private int xs [] = new int[300];
    private int ys [] = new int[300];
    private Random ran ;

    public MyPanel (){
        ran = new Random();
        //通过构造器给数组中的每一个位置去赋值
        for (int i = 0; i < 300; i++) {
            xs[i] = ran.nextInt(501);//0~500
            ys[i] = ran.nextInt(389)+12;//12~400
        }
        
    }


    /***
     * 父类帮助子类创建空画纸实现了一系统的设置.
     * super.paint(g);
     *
     * Graphics g 父类帮子类将画笔初始化好了.
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        /**设置画纸的背景颜色为黑色*/
        this.setBackground(Color.BLACK);
        g.setColor(Color.WHITE);
       /* g.drawLine(0,0,100,100);
        g.drawOval(100,100 ,100,100);
        g.drawRect(100,100,100,100);
        g.drawString("*",0,12);*/

        for (int i = 0; i < 300; i++) {
            g.drawString("*",xs[i],ys[i]);//需要300个x坐标及y坐标
        }


    }
}
