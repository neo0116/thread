package com.bytedance.thread.linkedBlockingQueueChain;

public class ThreeRule implements IRule {
    @Override
    public boolean process(RuleContext ruleContext) {
        int i = ruleContext.getNum() - 1;
        return i < 0;
    }
}
