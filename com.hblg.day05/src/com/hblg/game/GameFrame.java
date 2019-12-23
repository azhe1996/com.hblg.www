package com.hblg.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 当前类转换成窗体类需要继承JFrame
 *
 * 完成模拟屏保的实现思路
 */
public class GameFrame extends JFrame implements MouseListener {
    /**获取到工具箱*/
    private static Toolkit kit = Toolkit.getDefaultToolkit();
    public static int W = kit.getScreenSize().width;
    public static int H = kit.getScreenSize().height;

    public GameFrame(){
        /*GamePanel gp = new GamePanel();
        this.add(gp);*/


        CirclePanel cp = new CirclePanel();
        this.add(cp);




        //设置窗体的位置及大小
        this.setBounds(0,0,W,H);
        //去掉边框显示
        this.setUndecorated(true);
        this.setVisible(true);
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //clicked 必须是在原坐标上按下并抬起的一个完整的动作.
        System.out.println("mouseClicked()....");
        //退出JVM
        System.exit(0);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mousePressed()....按下");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouseReleased()....抬起");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouseEntered()....移入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouseExited()....移出");
    }
}
