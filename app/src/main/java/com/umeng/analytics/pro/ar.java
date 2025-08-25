package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMRTLog;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: UMExecutor.java */
/* loaded from: classes2.dex */
public class ar {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10063a = "UMExecutor";

    /* renamed from: b, reason: collision with root package name */
    private static volatile ScheduledThreadPoolExecutor f10064b;

    /* renamed from: c, reason: collision with root package name */
    private static final ThreadFactory f10065c = new ThreadFactory() { // from class: com.umeng.analytics.pro.ar.1

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f10066a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ccg-" + this.f10066a.incrementAndGet());
        }
    };

    private static ScheduledThreadPoolExecutor a() {
        if (f10064b == null) {
            synchronized (ar.class) {
                if (f10064b == null) {
                    f10064b = new ScheduledThreadPoolExecutor(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors(), 4)), f10065c);
                    f10064b.setKeepAliveTime(3L, TimeUnit.SECONDS);
                    f10064b.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f10064b;
    }

    public static void a(Runnable runnable, long j2, TimeUnit timeUnit) {
        try {
            a().schedule(runnable, j2, timeUnit);
        } catch (Throwable th) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "schedule error:" + th.getMessage());
        }
    }
}
