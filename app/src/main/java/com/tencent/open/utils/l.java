package com.tencent.open.utils;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public final class l {

    /* renamed from: c, reason: collision with root package name */
    private static Handler f9936c;

    /* renamed from: d, reason: collision with root package name */
    private static HandlerThread f9937d;

    /* renamed from: b, reason: collision with root package name */
    private static Object f9935b = new Object();

    /* renamed from: a, reason: collision with root package name */
    public static final Executor f9934a = c();

    /* compiled from: ProGuard */
    private static class a implements Executor {

        /* renamed from: a, reason: collision with root package name */
        final Queue<Runnable> f9938a;

        /* renamed from: b, reason: collision with root package name */
        Runnable f9939b;

        private a() {
            this.f9938a = new LinkedList();
        }

        protected synchronized void a() {
            Runnable runnablePoll = this.f9938a.poll();
            this.f9939b = runnablePoll;
            if (runnablePoll != null) {
                l.f9934a.execute(this.f9939b);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.f9938a.offer(new Runnable() { // from class: com.tencent.open.utils.l.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        a.this.a();
                    }
                }
            });
            if (this.f9939b == null) {
                a();
            }
        }
    }

    public static void a(Runnable runnable) {
        try {
            f9934a.execute(runnable);
        } catch (RejectedExecutionException unused) {
        }
    }

    public static void b(Runnable runnable) {
        a().post(runnable);
    }

    private static Executor c() {
        return new ThreadPoolExecutor(0, 3, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public static Handler a() {
        if (f9936c == null) {
            synchronized (l.class) {
                f9937d = new HandlerThread("SDK_SUB");
                f9937d.start();
                f9936c = new Handler(f9937d.getLooper());
            }
        }
        return f9936c;
    }

    public static Executor b() {
        return new a();
    }
}
