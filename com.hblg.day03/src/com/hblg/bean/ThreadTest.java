package com.hblg.bean;

public class ThreadTest extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread... run()...."+i);
        }
    }

    public static void main(String[] args) {

        Thread t = new ThreadTest();
        t.start();
        /**匿名内部类.*/
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("匿名内部类" + i);
                }
            }
        }).start();


    }

}
