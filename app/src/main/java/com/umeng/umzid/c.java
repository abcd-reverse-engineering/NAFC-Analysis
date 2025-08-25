package com.umeng.umzid;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static volatile ScheduledThreadPoolExecutor f11888a;

    /* renamed from: b, reason: collision with root package name */
    public static ThreadFactory f11889b = new a();

    public static class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public AtomicInteger f11890a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("ZIDThreadPoolExecutor" + this.f11890a.addAndGet(1));
            return thread;
        }
    }

    public static ScheduledThreadPoolExecutor a() {
        if (f11888a == null) {
            synchronized (c.class) {
                if (f11888a == null) {
                    f11888a = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 4, f11889b);
                }
            }
        }
        return f11888a;
    }

    public static void a(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Throwable unused) {
        }
    }
}
