package com.healthybear.module_base.thread;

import android.text.TextUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池工具类
 * create by guojianhong
 * on 2021/6/15
 */
public class ThreadPoolUtil {
    private final static String TAG = ThreadPoolUtil.class.getSimpleName();

    private final static String SINGLE_THREAD_POOL = "singleThreadPool";
    private final static String COMMON_FIX_THREAD_POOL = "commonFixThreadPool";


    private final static int COMMON_FIX_THREAD_MAX_SIZE = 30;

    private ExecutorService mSingleThreadPool;
    private ExecutorService mFixThreadPool;

    private ThreadPoolUtil(){}
    public static ThreadPoolUtil getInstance() {
        return Singleton.INSTANCE;
    }
    private static final class Singleton {
        private final static ThreadPoolUtil INSTANCE = new ThreadPoolUtil();
    }

    public ExecutorService getSingleThreadPool() {
        if (mSingleThreadPool != null) {
            return mSingleThreadPool;
        } else {
            return getSingleThreadPool(SINGLE_THREAD_POOL);
        }
    }

    public ExecutorService getCommonFixThreadPool() {
        if (mFixThreadPool != null) {
            return mFixThreadPool;
        } else {
            return getFixThreadPool(COMMON_FIX_THREAD_POOL);
        }
    }

    private ExecutorService getSingleThreadPool(String name) {
        return new ThreadPoolExecutor(
                1,
                1,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                new DefaultThradFactory(TextUtils.isEmpty(name) ? "未命名" : name)
        );
    }


    private ExecutorService getFixThreadPool(String name) {
        return new ThreadPoolExecutor(
                10,
                COMMON_FIX_THREAD_MAX_SIZE,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                new DefaultThradFactory(TextUtils.isEmpty(name) ? "未命名" : name)
        );
    }


    private ScheduledThreadPoolExecutor getScheduledThreadPoolExecutor(int corePoolSize, String name) {
        return new ScheduledThreadPoolExecutor(
                corePoolSize,
                new DefaultThradFactory(TextUtils.isEmpty(name) ? "未命名" : name)
        );
    }

}
