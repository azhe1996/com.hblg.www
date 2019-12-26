package com.hblg.ball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BallFrame extends JFrame {

    private static Toolkit kit = Toolkit.getDefaultToolkit();
    public static final int W = kit.getScreenSize().width*2/5;
    public static final int H = kit.getScreenSize().height*4/5;


    Ball ball ;
    KeyPanel kp;
    public BallFrame (){
        ball = new Ball(0,0,20);
        kp = new KeyPanel(ball);
        this.add(kp);






        /*BallPanel bp = new BallPanel();
        this.add(bp);*/

        int screenW = kit.getScreenSize().width;
        int screenH = kit.getScreenSize().height;
        this.setSize(W,H);
        this.setLocation((screenW-W)/2,(screenH-H)/2);
        //禁止更改窗体的大小.
        this.setResizable(false);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public void keyMove(){
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("键盘连按");
                switch(e.getKeyChar()){
                    case 'a':
                        ball.x-=5;
                        kp.repaint();
                        break;
                    case 's':
                        ball.y+=5;
                        kp.repaint();
                        break;
                    case 'd':
                        ball.x+=5;
                        kp.repaint();
                        break;
                    case 'w':
                        ball.y-=5;
                        kp.repaint();
                        break;

                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("键盘抬起");
            }
        });

    }



}
