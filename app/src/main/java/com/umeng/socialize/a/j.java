package com.umeng.socialize.a;

import android.os.AsyncTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: UMExecutor.java */
/* loaded from: classes2.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static final String f11572a = "UMExecutor";

    /* renamed from: b, reason: collision with root package name */
    private static volatile ScheduledThreadPoolExecutor f11573b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile ExecutorService f11574c;

    /* renamed from: d, reason: collision with root package name */
    private static final ThreadFactory f11575d = new ThreadFactory() { // from class: com.umeng.socialize.a.j.1

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f11576a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Azx-" + this.f11576a.incrementAndGet());
        }
    };

    /* compiled from: UMExecutor.java */
    private static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Runnable f11577a;

        public a(Runnable runnable) {
            this.f11577a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (this.f11577a != null) {
                    this.f11577a.run();
                }
            } catch (Throwable th) {
                m.d(j.f11572a, "error:", th.getMessage());
            }
        }
    }

    private static ScheduledThreadPoolExecutor a() {
        if (f11573b == null) {
            synchronized (j.class) {
                if (f11573b == null) {
                    f11573b = new ScheduledThreadPoolExecutor(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors(), 4)), f11575d);
                    f11573b.setKeepAliveTime(3L, TimeUnit.SECONDS);
                    f11573b.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f11573b;
    }

    private static ExecutorService b() {
        if (f11574c == null) {
            synchronized (j.class) {
                if (f11574c == null) {
                    f11574c = Executors.newSingleThreadExecutor(f11575d);
                }
            }
        }
        return f11574c;
    }

    public static Future<?> c(Runnable runnable) {
        try {
            return a().submit(d(runnable));
        } catch (Throwable th) {
            m.d(f11572a, "submit error:", th.getMessage());
            return null;
        }
    }

    private static Runnable d(Runnable runnable) {
        return new a(runnable);
    }

    public static void b(Runnable runnable) {
        try {
            a().execute(d(runnable));
        } catch (Throwable th) {
            m.d(f11572a, "execute error:", th.getMessage());
        }
    }

    @SafeVarargs
    public static <Params, Progress, Result> void a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        if (asyncTask == null) {
            return;
        }
        try {
            asyncTask.executeOnExecutor(a(), paramsArr);
        } catch (Throwable th) {
            m.d(f11572a, "executeOnExecutor error:", th.getMessage());
        }
    }

    public static Future<?> a(Runnable runnable) {
        try {
            return b().submit(d(runnable));
        } catch (Throwable th) {
            m.d(f11572a, "submitSingleTask error:", th.getMessage());
            return null;
        }
    }

    public static void a(Runnable runnable, long j2, TimeUnit timeUnit) {
        try {
            a().schedule(runnable, j2, timeUnit);
        } catch (Throwable th) {
            m.d(f11572a, "schedule error:", th.getMessage());
        }
    }
}
