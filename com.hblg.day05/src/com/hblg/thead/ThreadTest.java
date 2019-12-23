package com.hblg.thead;

import com.hblg.cls.Outer;

import java.sql.SQLOutput;

public class ThreadTest {
    public static void main(String[] args) {
        //内部类的调用测试

       /*Outer outer = new Outer();
       Outer say = outer.say(1,2,3);*/



        //新建一个线程
        Thread t1 = new Thread1();
        //让线程可运行.   ===   就绪

        //向上转型成Runnable对象
        Runnable r = new Thread2 ();
        //再通过Runnable对象转成线程对象.
        Thread t2 = new Thread(r);
        //就绪
        t1.start();
        t2.start();
        //匿名内部类的方式
        /**
         * ()代表的是接口里面的方法
         * {}代表的是方法里面的代码块
         * ()->{}是lamda表达式的书写格式
         */
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {

                }
                System.out.println("lamda...." + (i + 1));
            }
        }).start();



    }
}
