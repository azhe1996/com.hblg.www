package com.hblg.thead;
/**
 * 创建线程的方式1
 *   通过继承,表述的关系是   is  a
 *
 *
 *  创建一个线程的准备工作
 * */
public class Thread1 extends Thread {
    /****
     * 线程在创建后需要执行的代码.
     */
    @Override
    public void run() {
        for (int i = 0; i <10; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread1.... run()..."+(i+1)+"次");
        }
    }
}
