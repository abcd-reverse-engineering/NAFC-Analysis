package com.alibaba.sdk.android.utils.crashdefend;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: CrashDispatcher.java */
/* loaded from: classes.dex */
final class f {

    /* renamed from: a, reason: collision with root package name */
    private final ThreadFactory f4144a = new ThreadFactory() { // from class: com.alibaba.sdk.android.utils.crashdefend.f.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "safe_thread");
            thread.setDaemon(false);
            return thread;
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private ExecutorService f4145b;

    f() {
    }

    synchronized ExecutorService a() {
        if (this.f4145b == null) {
            this.f4145b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 1L, TimeUnit.SECONDS, new SynchronousQueue(), this.f4144a);
        }
        return this.f4145b;
    }
}
