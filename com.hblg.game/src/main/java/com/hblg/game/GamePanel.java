package com.hblg.game;

import com.hblg.entity.*;

import javax.swing.*;
import java.awt.*;
import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.*;
import java.util.Random;

/**
 *  将GamePanel设计成了控制类.
 *  所有的具体实现,都不会在当前类中写实现的代码.
 *
 */
public class GamePanel extends JPanel {
    Star star ; //背景图的星星
    Flight flight;//自己的飞机
    GameFrame gameFrame; //窗体的对象
    boolean isCreate ;//创建子弹的开关
    List<Bullet> bulletList;//创建一个自己子弹的集合
    Random ran;//声明一个随机数对象
    List<EnemyFlight> enemyFlightList;//声明一个敌机的集合

    //声明一个爆炸效果的对象
    Bomb bomb ;
    public GamePanel(GameFrame gameFrame){

        enemyFlightList = new ArrayList();
        ran = new Random();
        bulletList = new ArrayList<Bullet>();
        this.gameFrame = gameFrame;
        star = new Star();
        star.createStars();

        //实现飞机实例的创建及鼠标及键盘操作飞机的实现
        flight = new Flight();
        flightKeyMove();
        flightMouseMove();

        threadCreate();
    }



    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.BLACK);
        g.setFont(Star.font);
        star.drawStars(g);//画背景图
        drawBullets(g);//画自己子弹
        drawEnemyFlights(g);//画敌机
        //画自己的飞机
        g.drawImage(flight.getImg(),flight.getX(),flight.getY(),flight.getWidth(),flight.getHeight(),this);

        if(bomb != null){
            g.drawImage(bomb.getImg(), bomb.getX(), bomb.getY(), bomb.getWidth(), bomb.getHeight(), this);
        }

    }







    /**线程的创建*/
    private void threadCreate(){
        new Thread(()->{
            int i = 0 ;
            while(true){
                i++;
                if(i%4==0&&isCreate){
                    createBullet();
                }
                bulletsUp();

                if(i%10==0){
                    createEnemyFlight();//生成敌机
                }


                enemyFlightDown();//敌机下落

                isHit();


                star.starsDwon();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }
        }).start();
    }

    private synchronized void isHit() {
        //以敌机为基准
        if (enemyFlightList.size()>0){
            for (int i = 0; i < enemyFlightList.size(); i++) {
            //获取到每一个敌机
                EnemyFlight ef = enemyFlightList.get(i);
                for (int j = 0; j < bulletList.size(); j++) {
                    Bullet b = bulletList.get(j);
                    int efD = ef.getY()+ef.getHeight();
                    int efL = ef.getX();
                    int efR = ef.getX()+ef.getWidth();
                    int bL = b.getX();
                    int bR = b.getX()+b.getWidth();
                    if(bL<efR&&efL<bR){
                        if(b.getY()-efD<=5){
                            bulletList.remove(b);
                            enemyFlightList.remove(ef);
                            new Thread(()->{
                                bomb = new Bomb();
                                bomb.setX(b.getX());
                                bomb.setY(b.getY());
                                for (int k = 0; k < 5; k++) {
                                    try {
                                        Thread.sleep(50);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    switch (k){
                                        case 0:
                                            bomb.setImg(Bomb.img_0);
                                            break;
                                        case 1:
                                            bomb.setImg(Bomb.img_1);
                                            break;
                                        case 2:
                                            bomb.setImg(Bomb.img_2);
                                            break;
                                        case 3:
                                            bomb.setImg(Bomb.img_3);
                                            break;
                                        default:
                                            bomb.setImg(null);
                                            break;
                                    }
                                }
                            }).start();
                        }
                    }

                }
                
            }
        }

    }


    /**敌机的创建**/
    private void createEnemyFlight(){
        EnemyFlight ef = new EnemyFlight();
        ef.setX(ran.nextInt(GameFrame.W-ef.getWidth()-17));
        ef.setY(-ef.getHeight());
        enemyFlightList.add(ef);
    }
    
    /**画敌机**/
    
    public void drawEnemyFlights(Graphics g ){
        if(enemyFlightList.size()>0){
            for (int i = 0; i < enemyFlightList.size(); i++) {
                EnemyFlight ef = enemyFlightList.get(i);
                g.drawImage(EnemyFlight.img,ef.getX(),ef.getY(),ef.getWidth(),ef.getHeight(),this);
            }
        }
    }

    public void enemyFlightDown( ){
        if(enemyFlightList.size()>0){
            for (int i = 0; i < enemyFlightList.size(); i++) {
                EnemyFlight ef = enemyFlightList.get(i);
                int y = ef.getY()+ef.getSpeed();
                ef.setY(y);
                if(y>GameFrame.H){
                    enemyFlightList.remove(i);
                }
            }
        }
    }


    private void bulletsUp() {
        if(bulletList.size()>0){
            for (int i = 0; i < bulletList.size(); i++) {
                Bullet b = bulletList.get(i);
                int y = b.getY()-7;
                b.setY(y);
            }
        }

    }

    int count ;
    private void createBullet(){
        Bullet bullet = new Bullet();
        count++;
            bullet.setImg(Bullet.img_1);
        /*if(count%2!=0){
        }else{
            bullet.setImg(Bullet.img_2);
        }*/
        bullet.setX(flight.getX()+bullet.getWidth()-2);
        bullet.setY(flight.getY());
        bulletList.add(bullet);
    }

    private void drawBullets(Graphics g){
        if (bulletList.size()>0){
            for (int i = 0; i < bulletList.size(); i++) {
                Bullet b = bulletList.get(i);
                g.drawImage(b.getImg(),b.getX(),b.getY(),b.getWidth(),b.getHeight(),this);
            }

        }
    }



    private void flightMove(MouseEvent e){
        flight.setX(e.getX()-flight.getWidth()/2);
        flight.setY(e.getY()-flight.getHeight()*3/4);
    }

    /**监听鼠标的动作*/
    public void flightMouseMove(){
        gameFrame.addMouseMotionListener(new MouseMotionListener() {
            //实现鼠标操作飞机
            @Override
            public void mouseDragged(MouseEvent e) {

                flightMove(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {

                flightMove(e);
            }
        });

        gameFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

//                System.out.println(e.getButton());

                //占击右键
                if(e.getButton()==3){
                    //todo:实现飞机发保险
                    /*
                    *  发保险意味屏幕中所有的敌机都需要销毁.
                    *   操作是将集合中所有的敌机都删除,
                    *   在删除时,都产生爆炸效果.
                    *
                    * */
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                isCreate = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isCreate = false;
            }
        });
    }



    /**监听键盘的动作*/
    public void flightKeyMove(){
        gameFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyChar()=='j'){
                    isCreate = false;
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                //实现键盘操作飞机
                int x = flight.getX();
                int y = flight.getY();
                int speed = 5;
                switch (e.getKeyChar()){
                    case 'a':
                        flight.setX(x-speed);
                        break;
                    case 's':
                        flight.setY(y+speed);
                        break;
                    case 'd':
                        flight.setX(x+speed);
                        break;
                    case 'w':
                        flight.setY(y-speed);
                        break;
                    case 'j':
                        isCreate = true;
                        break;
                    case 'k':
                        //todo:实现飞机发保险
                        break;
                    default:
                        break;
                }
            }
        });
    }

}
