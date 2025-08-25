package com.umeng.message.proguard;

import com.umeng.message.common.UPLog;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import ui.activity.SmsRecordSelectActivity;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile ScheduledThreadPoolExecutor f11326a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile ExecutorService f11327b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile ExecutorService f11328c;

    static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Runnable f11329a;

        public a(Runnable runnable) {
            this.f11329a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (this.f11329a != null) {
                    this.f11329a.run();
                }
            } catch (Throwable th) {
                UPLog.e("Executors", th);
            }
        }
    }

    /* renamed from: com.umeng.message.proguard.b$b, reason: collision with other inner class name */
    static final class ThreadFactoryC0152b implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f11330a = new AtomicInteger();

        /* renamed from: b, reason: collision with root package name */
        private final String f11331b;

        ThreadFactoryC0152b(String str) {
            this.f11331b = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, this.f11331b + c.c.a.b.a.a.f3100g + this.f11330a.incrementAndGet());
        }
    }

    private static ScheduledThreadPoolExecutor a() {
        if (f11326a == null) {
            synchronized (b.class) {
                if (f11326a == null) {
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors(), 4)), new ThreadFactoryC0152b("pool"));
                    f11326a = scheduledThreadPoolExecutor;
                    scheduledThreadPoolExecutor.setKeepAliveTime(3L, TimeUnit.SECONDS);
                    f11326a.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f11326a;
    }

    private static ExecutorService b() {
        if (f11327b == null) {
            synchronized (b.class) {
                if (f11327b == null) {
                    f11327b = Executors.newSingleThreadExecutor(new ThreadFactoryC0152b(SmsRecordSelectActivity.f19032l));
                }
            }
        }
        return f11327b;
    }

    private static ExecutorService c() {
        if (f11328c == null) {
            synchronized (b.class) {
                if (f11328c == null) {
                    f11328c = Executors.newSingleThreadExecutor(new ThreadFactoryC0152b("msg"));
                }
            }
        }
        return f11328c;
    }

    private static Runnable d(Runnable runnable) {
        return new a(runnable);
    }

    public static Future<?> b(Runnable runnable) {
        try {
            return b().submit(d(runnable));
        } catch (Throwable th) {
            UPLog.e("Executors", th);
            return null;
        }
    }

    public static void c(Runnable runnable) {
        try {
            a().execute(d(runnable));
        } catch (Throwable th) {
            UPLog.e("Executors", th);
        }
    }

    public static void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            c().execute(d(runnable));
        } catch (Throwable th) {
            UPLog.e("Executors", th);
        }
    }

    public static ScheduledFuture<?> a(Runnable runnable, long j2, TimeUnit timeUnit) {
        try {
            return a().schedule(d(runnable), j2, timeUnit);
        } catch (Throwable th) {
            UPLog.e("Executors", th);
            return null;
        }
    }
}
