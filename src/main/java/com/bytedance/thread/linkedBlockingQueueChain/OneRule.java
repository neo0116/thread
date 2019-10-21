package com.bytedance.thread.linkedBlockingQueueChain;

public class OneRule implements IRule {


    @Override
    public boolean process(RuleContext ruleContext) {
        int i = ruleContext.getNum() - 1;
        return i > 0;
    }
}
