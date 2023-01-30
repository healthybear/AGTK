package com.healthybear.module_base.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程工厂
 * create by guojianhong
 * on 2021/6/15
 */
public class DefaultThradFactory implements ThreadFactory {
    private static final AtomicInteger poolNumber = new AtomicInteger(1);

    private String groupName;

    public DefaultThradFactory(String name) {
        groupName = name;
    }


    @Override
    public Thread newThread(Runnable r) {
        String threadName = groupName + poolNumber.incrementAndGet();
        Thread thread = new Thread(null, r, threadName, 0);
        return thread;
    }
}
