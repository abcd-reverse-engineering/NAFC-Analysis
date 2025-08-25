package com.alibaba.sdk.android.httpdns;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with other field name */
    private static final TimeUnit f10a = TimeUnit.SECONDS;

    /* renamed from: a, reason: collision with other field name */
    private static final ThreadFactory f9a = new ThreadFactory() { // from class: com.alibaba.sdk.android.httpdns.c.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("httpdns worker");
            thread.setDaemon(false);
            thread.setUncaughtExceptionHandler(new k());
            return thread;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private static final ExecutorService f4011a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 1, f10a, new SynchronousQueue(), f9a);

    public static ExecutorService a() {
        return f4011a;
    }
}
