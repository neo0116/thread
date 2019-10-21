package com.bytedance.thread;

public class App {

    public synchronized void getApp() {
        System.out.println("hhh");
        demo();
    }

    private void demo() {
        synchronized (this) {
            System.out.println("hahh aja");
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.getApp();
    }

}
