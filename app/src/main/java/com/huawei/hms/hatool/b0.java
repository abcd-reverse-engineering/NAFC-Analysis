package com.huawei.hms.hatool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class b0 {

    /* renamed from: b, reason: collision with root package name */
    private static b0 f6947b;

    /* renamed from: c, reason: collision with root package name */
    private static b0 f6948c;

    /* renamed from: d, reason: collision with root package name */
    private static b0 f6949d;

    /* renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f6950a = new ThreadPoolExecutor(0, 1, com.heytap.mcssdk.constant.a.f5800d, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5000), new b());

    private static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private Runnable f6951a;

        public a(Runnable runnable) {
            this.f6951a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.f6951a;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Exception unused) {
                    v.e("hmsSdk", "InnerTask : Exception has happened,From internal operations!");
                }
            }
        }
    }

    static class b implements ThreadFactory {

        /* renamed from: d, reason: collision with root package name */
        private static final AtomicInteger f6952d = new AtomicInteger(1);

        /* renamed from: a, reason: collision with root package name */
        private final ThreadGroup f6953a;

        /* renamed from: b, reason: collision with root package name */
        private final AtomicInteger f6954b = new AtomicInteger(1);

        /* renamed from: c, reason: collision with root package name */
        private final String f6955c;

        b() {
            SecurityManager securityManager = System.getSecurityManager();
            this.f6953a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.f6955c = "FormalHASDK-base-" + f6952d.getAndIncrement();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(this.f6953a, runnable, this.f6955c + this.f6954b.getAndIncrement(), 0L);
        }
    }

    static {
        new b0();
        new b0();
        f6947b = new b0();
        f6948c = new b0();
        f6949d = new b0();
    }

    private b0() {
    }

    public static b0 a() {
        return f6949d;
    }

    public static b0 b() {
        return f6948c;
    }

    public static b0 c() {
        return f6947b;
    }

    public void a(g gVar) {
        try {
            this.f6950a.execute(new a(gVar));
        } catch (RejectedExecutionException unused) {
            v.e("hmsSdk", "addToQueue() Exception has happened!Form rejected execution");
        }
    }
}
