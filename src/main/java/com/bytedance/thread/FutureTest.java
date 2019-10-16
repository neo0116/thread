package com.bytedance.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTest implements Callable<SynchronizedTest> {
    @Override
    public SynchronizedTest call() throws Exception {
        Thread.sleep(2000);
        return new SynchronizedTest();
    }


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTest futureTest = new FutureTest();
        FutureTask<SynchronizedTest> futureTask = new FutureTask<>(futureTest);
        new Thread(futureTask).start();


        //状态机制，检查有没有set（return value），还是“NEW” or “COMPLITE”状态则LockSupport.park；
        // set方法改变状态为“NORMAL”后会调用LockSupport.unpark
        System.out.println(futureTask.get());
    }
}
