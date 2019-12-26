package com.hblg.game;

import javax.swing.*;
import java.awt.*;

public class FlightPanel extends JPanel {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.BLACK);
        //创建一张图片
        Image img = new ImageIcon("hero.gif").getImage();
        //画一张图片在自己的窗口内
        g.drawImage(img,0,0,100,100,this);


    }
}
