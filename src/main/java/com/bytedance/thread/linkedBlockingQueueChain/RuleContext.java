package com.bytedance.thread.linkedBlockingQueueChain;

public class RuleContext {

    int num;

    String name;

    public RuleContext(int num) {
        this.num = num;
    }

    public RuleContext(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
