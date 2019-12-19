package com.hblg.game;

import javax.swing.*;
import java.awt.*;

/**
 *  窗口...    ===>   画板   固定纸张
 *
 *  窗体 添加 画板     ====>   画板固定一张画纸
 *
 *  javap -c
 *         #1       JFrame init()
 *         #2
 *
 */
public class MyFrame extends JFrame {
    //声明需要的变量-- 画板对象
    private MyPanel panel;
    public MyFrame() {
        panel = new MyPanel();
        /**设置窗体的大小*/
        this.setSize(500,400);
        /**设置窗体位置*/
        this.setLocation(262,(768-400)/2);
        /**显示在屏幕之前添加画板对象*/
        this.add(panel);

        /**设置显示在屏幕*/
        this.setVisible(true);

        /**设置点击关闭时的默认动作*/
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setResizable(true);
        //上述的设置没有问题.程序运行在内存中,没有让它显示的设置.

    }
}
