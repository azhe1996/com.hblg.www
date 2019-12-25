package com.hblg.ballgame;

import com.hblg.game.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 每个组件的默认布局都是将父级组件的空间填充满.
 * 而自定义布局时,所有的组件,都是按照开发的需求进行定义.
 * 如果未定义,组件的大小及位置都是默认的0
 */
public class BallPanel extends JPanel {
    /**
     * 开始按钮
     */
    JButton jbtStart;
    /**
     * 历史成绩
     */
    JButton jbtLog;
    /**
     * 退出按钮
     */
    JButton jbtExit;


    /**
     * 游戏开始的开关
     */
    private boolean start;

    /**
     * 创建一个板的对象
     */
    Ban ban;

    /***
     * 定义一个球的变量
     */
    Ball ball;

    public BallPanel() {
        ball = new Ball();
        ban = new Ban();
        //设置当前组件内部的布局方式
        this.setLayout(null);
        //创建按钮
        createButtons();
        //添加鼠标动作监听器
        banMove();
        //小球移动
        ballMove();


    }

    private void ballMove() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("run");
                    switch (ball.driecption) {
                        case Ball.LEFT_UP:
                            ball.x -= ball.speed;
                            ball.y -= ball.speed;
                            if (ball.x < 0) {
                                ball.driecption = Ball.RIGHT_UP;
                            }
                            if (ball.y < 0) {
                                ball.driecption = Ball.LEFT_DOWN;
                            }
                            break;
                        case Ball.RIGHT_UP:
                            ball.x += ball.speed;
                            ball.y -= ball.speed;
                            if (ball.x > BallFrame.W - ball.r * 2 - 17) {
                                ball.driecption = Ball.LEFT_UP;
                            }
                            if (ball.y < 0) {
                                ball.driecption = Ball.RIGHT_DOWN;
                            }
                            break;
                        case Ball.LEFT_DOWN:
                            ball.x -= ball.speed;
                            ball.y += ball.speed;
                            if (ball.x < 0) {
                                ball.driecption = Ball.RIGHT_DOWN;
                            }
                            if (ball.y > BallFrame.H - 28 - ball.r * 2 - ban.height&&ball.y<BallFrame.H - ball.r * 2 - 28) {
                                int cL = ball.x;
                                int cR = ball.x+ball.r*2;
                                int bL = ban.x;
                                int bR = ban.x+ban.width;

                                if(cL<bR&&bL<cR){
                                    ball.driecption = Ball.LEFT_UP;
                                }else{
                                    start = false;
                                    repaint();
                                    JOptionPane.showMessageDialog(BallPanel.this,"游戏结束");
                                    return;
                                }

                            }
                            break;
                        case Ball.RIGHT_DOWN:
                            ball.x += ball.speed;
                            ball.y += ball.speed;
                            if (ball.x > BallFrame.W - ball.r * 2 - 17) {
                                ball.driecption = Ball.LEFT_DOWN;
                            }
                            if (ball.y > BallFrame.H - ball.r * 2 - 28 - ban.height&&ball.y<BallFrame.H - ball.r * 2 - 28 ) {
                                int cL = ball.x;
                                int cR = ball.x+ball.r*2;
                                int bL = ban.x;
                                int bR = ban.x+ban.width;

                                if(cL<bR&&bL<cR){
                                    ball.driecption = Ball.RIGHT_UP;
                                }else{
                                    start = false;
                                    repaint();
                                    //需要拿到所有的成绩与本身的成绩进行比较,
                                    //如果当前的成绩超过了某个人的成绩,就需要将用户名及成绩,替换掉相应的人.
                                    JOptionPane.showMessageDialog(BallPanel.this,"游戏结束");
                                    return;

                                }

                            }

                            break;
                        default:
                            break;
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    BallPanel.this.repaint();
                }
            }
        }).start();
    }

    private void banMove() {
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (e.getX() > 0 & e.getX() < BallFrame.W) {
                    ban.x = e.getX() - ban.width / 2;
                }
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if (e.getX() > 0 & e.getX() < BallFrame.W) {
                    ban.x = e.getX() - ban.width / 2;
                }
                repaint();
            }
        });
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.BLACK);
        g.setColor(Color.CYAN);
        if (start) {
            //28像素代表上下标题栏的高度和.
            //30代表栏板的高度.
            g.fillRect(ban.x, ban.y, ban.width, ban.height);
            g.fillOval(ball.x, ball.y, ball.r * 2, ball.r * 2);
        }
    }


    /**
     * 添加开始,记录,退出三个按钮及具体的实现
     */
    public void createButtons() {
        /**添加按钮*/
        jbtStart = new JButton("开始游戏");
        jbtStart.setBounds((BallFrame.W - BallFrame.W / 4) / 2, 270, BallFrame.W / 4, BallFrame.H / 15);
        jbtStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //开始游戏
                //外部类名.this来表示外部类的实例对象地址
                BallPanel.this.remove(jbtStart);
                BallPanel.this.remove(jbtLog);
                BallPanel.this.remove(jbtExit);
                start = true;
                //画板对象重画
                BallPanel.this.repaint();
            }
        });
        this.add(jbtStart);

        jbtLog = new JButton("游戏纪录");
        jbtLog.setBounds((BallFrame.W - BallFrame.W / 4) / 2, 330, BallFrame.W / 4, BallFrame.H / 15);
        jbtLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //查看所有的用户记录
            }
        });
        this.add(jbtLog);

        jbtExit = new JButton("退出游戏");
        jbtExit.setBounds((BallFrame.W - BallFrame.W / 4) / 2, 390, BallFrame.W / 4, BallFrame.H / 15);
        jbtExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.add(jbtExit);
    }

}
