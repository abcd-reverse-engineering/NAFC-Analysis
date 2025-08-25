package com.huawei.hmf.tasks.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final a f6443a = new a();

    /* renamed from: c, reason: collision with root package name */
    private static final int f6444c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f6445d;

    /* renamed from: e, reason: collision with root package name */
    private static final int f6446e;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f6447b = new ExecutorC0102a(0);

    /* renamed from: com.huawei.hmf.tasks.a.a$a, reason: collision with other inner class name */
    static class ExecutorC0102a implements Executor {
        private ExecutorC0102a() {
        }

        /* synthetic */ ExecutorC0102a(byte b2) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f6444c = iAvailableProcessors;
        f6445d = iAvailableProcessors + 1;
        f6446e = (f6444c * 2) + 1;
    }

    public static ExecutorService a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f6445d, f6446e, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static Executor b() {
        return f6443a.f6447b;
    }
}
