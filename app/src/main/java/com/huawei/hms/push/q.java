package com.huawei.hms.push;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ReceiverThreadPoolExecutor.java */
/* loaded from: classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f7225a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static ThreadPoolExecutor f7226b = new ThreadPoolExecutor(1, 50, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public static ThreadPoolExecutor a() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (f7225a) {
            threadPoolExecutor = f7226b;
        }
        return threadPoolExecutor;
    }
}
