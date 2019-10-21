package com.bytedance.thread.linkedBlockingQueueChain;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

public class RuleThread implements Callable<Boolean> {

    LinkedBlockingQueue<IRule> queue;

    String msg;

    RuleContext ruleContext;

    public RuleThread(LinkedBlockingQueue<IRule> queue, String msg, RuleContext ruleContext) {
        this.queue = queue;
        this.msg = msg;
        this.ruleContext = ruleContext;
    }

    @Override
    public Boolean call() throws Exception {
        try {
            IRule rule = queue.take();
            return rule.process(ruleContext);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }
}
