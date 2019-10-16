package com.bytedance.thread;

public class SynchronizedTest {

    public synchronized void get(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sdflsdj");
    }

    public  synchronized static void get2()  {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("static");
    }

    public static void main(String[] args) throws InterruptedException {

        SynchronizedTest s1 = new SynchronizedTest();
        SynchronizedTest s2 = new SynchronizedTest();
        new Thread(() -> {s1.get2();}).start();
        new Thread(() -> {s2.get2();}).start();

    }
}
