package com.hblg.thead;

public class Thread2 implements Runnable {
    /**
     * 通过接口的方式实现线程.
     *
     * 实现线程需要执行的代码
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Runnable... run()...."+(i+1)+"次");
        }
    }
}
