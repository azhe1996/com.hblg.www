package com.hblg.game;

import javax.swing.*;
import java.awt.*;

/**
 * 画板       ====>     画纸
 */
public class MyPanel extends JPanel {
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
        g.drawLine(0,0,100,100);
        g.drawOval(100,100 ,100,100);
        g.drawRect(100,100,100,100);
        g.drawString("*",0,12);
    }
}
