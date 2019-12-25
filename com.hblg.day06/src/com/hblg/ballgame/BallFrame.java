package com.hblg.ballgame;

import javax.swing.*;
import java.awt.*;

public class BallFrame extends JFrame {
    private static Toolkit kit = Toolkit.getDefaultToolkit();
    public static final int W = kit.getScreenSize().width*2/5;
    public static final int H = kit.getScreenSize().height*4/5;
    public BallFrame (){

        BallPanel bp = new BallPanel();
        this.add(bp);

        int screenW = kit.getScreenSize().width;
        int screenH = kit.getScreenSize().height;
        this.setSize(W,H);
        this.setLocation((screenW-W)/2,(screenH-H)/2);
        //禁止更改窗体的大小.
        this.setResizable(false);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


}
