package com.hblg.createball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class BallPanel extends JPanel {
    //自己的球
    Ball ball ;
    //生成的球
    List<Ball> balls;
    //是否生成小球的开关
    boolean flag ;

    //定义生成小球时的x坐标及y坐标
    int x,y;

    public BallPanel(){
        balls = new ArrayList<Ball>();
        ball = new Ball(30);
        createBall();
        isCreateBalls();






        new Thread(()->{
            int i = 0 ;
            while(true){
                i++;
                if(flag){
                    if(i%15==0){
                        createSmallBall();
                    }
                }
                if(balls.size()>0){
                    for (int j = 0; j < balls.size(); j++) {
                        Ball ball = balls.get(j);
                        ball.y-=ball.speed;
                        if(ball.y+ball.r*2<0){
                            balls.remove(j);
                        }
                    }
                }




                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }
        }).start();

    }

    void createSmallBall(){
        Ball ball = new Ball(15,Color.BLUE);
        ball.x = x;
        ball.y = y;
        balls.add(ball);

    }



    private void isCreateBalls() {
        //添加小球.
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                flag = true;

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                flag = false;

            }
        });
    }

    private void createBall() {
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                ballmove(e);
            }
            @Override
            public void mouseMoved(MouseEvent e) {
                ballmove(e);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.BLACK);
        g.setColor(ball.color);
        g.fillOval(ball.x,ball.y, ball.r*2,ball.r*2);

        if(balls.size()>0){
            for (int i = 0; i < balls.size(); i++) {
                Ball ball = balls.get(i);
                g.setColor(ball.color);

                g.fillOval(ball.x,ball.y,ball.r*2,ball.r*2);
            }
                System.out.println("当前集合中的值为"+balls.size());
        }

    }

    public void ballmove(MouseEvent e){
        x = ball.x = e.getX()-ball.r;
        y = ball.y = e.getY()-ball.r;
        repaint();
    }

}
