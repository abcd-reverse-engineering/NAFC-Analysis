package com.hihonor.cloudservice.tasks.q;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ExecutorSingle.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    private static final g f6067b = new g();

    /* renamed from: c, reason: collision with root package name */
    private static final int f6068c;

    /* renamed from: d, reason: collision with root package name */
    static final int f6069d;

    /* renamed from: e, reason: collision with root package name */
    static final int f6070e;

    /* renamed from: a, reason: collision with root package name */
    private final Executor f6071a = new b();

    /* compiled from: ExecutorSingle.java */
    private static class b implements Executor {
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }

        private b() {
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f6068c = iAvailableProcessors;
        f6069d = iAvailableProcessors + 1;
        f6070e = (iAvailableProcessors * 2) + 1;
    }

    public static Executor a() {
        return f6067b.f6071a;
    }

    public static ExecutorService b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f6069d, f6070e, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
}
