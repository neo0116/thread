package com.bytedance.thread;

import java.util.concurrent.TimeUnit;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    System.out.println("中断前" + Thread.currentThread().isInterrupted());
                    Thread.sleep(5000);
                    System.out.println("是否唤醒阻塞" + Thread.currentThread().isInterrupted());
                    System.out.println("???");
                } catch (InterruptedException e) {
                    System.out.println("中断异常" + Thread.currentThread().isInterrupted());
                    Thread.currentThread().interrupt();
                    System.out.println("中断异常2" + Thread.currentThread().isInterrupted());
                    e.printStackTrace();
                }
            }
        }, "demoThread");

        thread.start();

        TimeUnit.SECONDS.sleep(2);

        thread.interrupt();
        System.out.println(" 123" + thread.isInterrupted());
        System.out.println((16 >>> 2));
    }

}
