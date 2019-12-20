package com.hblg.object;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.jar.JarFile;

public class MyFrame extends JFrame {
    /**工具箱 帮助获取到相关的电脑信息.*/
    private static Toolkit kit=Toolkit.getDefaultToolkit();

    public static final int W = kit.getScreenSize().width;
    public static final int H = kit.getScreenSize().height;

    public MyFrame (){
        this.setSize(W/2,H/2);
        this.setLocation(W/4,H/5);
        MyPanel mp = new MyPanel();
        this.add(mp);
        //启动线程
        new Thread(mp).start();
        this.setVisible(true);
        //退出程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        //点击不产生任何效果
////        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//        //点击产生隐藏效果,程序在后台运行
////        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//        //屏幕退出 程序无运行.虚拟机无执行代码后关闭.
//        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
