package com.hblg.ball;

import javafx.scene.control.ProgressBar;

import javax.swing.*;
import java.awt.*;

public class BallPanel extends JPanel {

    JProgressBar jpb ;



    public BallPanel(){

        this.setLayout(null);

        jpb = new JProgressBar();
        jpb.setSize(100,15);
        jpb.setLocation(300,5);
        //设置是否显示进度条的边框
        jpb.setBorderPainted(false);
        //设置是否在进度条内部显示文字
        jpb.setStringPainted(true);
        //设置显示的文字内容
        jpb.setString("血量");
        //设置前景色
        jpb.setForeground(Color.BLUE);
        //设置背景色为蓝色
        jpb.setBackground(Color.RED);
        jpb.setValue(0);
        /*new Thread(()->{
            int i = 0 ;
            while(i<100){
                i++;
                jpb.setValue(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
*/

        this.add(jpb);




    }




    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.BLACK);
        g.setColor(Color.CYAN);
        g.setFont(new Font("微软雅黑",Font.BOLD,30));
        g.drawString("雷电",0,30);



    }
}
