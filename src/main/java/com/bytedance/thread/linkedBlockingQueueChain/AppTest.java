package com.bytedance.thread.linkedBlockingQueueChain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;

public class AppTest {
    static List<IRule> rules;

    static {
        rules = new ArrayList<>(16);
        rules.add(new OneRule());
        rules.add(new TwoRule());
        rules.add(new ThreeRule());
        rules.add(new FourRule());
        rules.add(new FiveRule());
    }

    public static void main(String[] args) {
        LinkedBlockingQueue<IRule> queue = new LinkedBlockingQueue<>();

        String msg = null;
        RuleContext ruleContext = new RuleContext(3);
        RuleThread ruleThread = new RuleThread(queue, msg, ruleContext);
        FutureTask<Boolean> futureTask = new FutureTask<>(ruleThread);



        for (IRule rule : rules) {
            Boolean b = rule.process(ruleContext);
            if (!b) {
                System.out.println("false");
                break;
            }
//            Thread thread = new Thread(futureTask);
//            thread.start();
//            //数据库查询配置的规则名称
//            //以规则名称从spring中取出bean
//            //一个个添加到队列中，按序执行process方法
//            queue.add(rule);
//            try {
//                Boolean b = futureTask.get();
//                if (!b) {
//                    System.out.println("false");
//                    break;
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println(msg);
    }
}
