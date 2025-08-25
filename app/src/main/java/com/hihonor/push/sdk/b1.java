package com.hihonor.push.sdk;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class b1 {

    /* renamed from: d, reason: collision with root package name */
    public static final b1 f6254d = new b1();

    /* renamed from: a, reason: collision with root package name */
    public volatile Executor f6255a;

    /* renamed from: b, reason: collision with root package name */
    public volatile ExecutorService f6256b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f6257c = new Object();

    public static class a implements Executor {
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    public static Executor a() {
        b1 b1Var = f6254d;
        if (b1Var.f6255a == null) {
            synchronized (b1Var.f6257c) {
                if (b1Var.f6255a == null) {
                    b1Var.f6255a = new a();
                }
            }
        }
        return b1Var.f6255a;
    }

    public static ExecutorService c() {
        return f6254d.b();
    }

    public final ExecutorService b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 10, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static void a(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            a().execute(runnable);
        }
    }
}
