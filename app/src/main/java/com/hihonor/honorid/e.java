package com.hihonor.honorid;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: UseCaseThreadPoolScheduler.java */
/* loaded from: classes.dex */
public final class e implements c {

    /* renamed from: b, reason: collision with root package name */
    private static final BlockingQueue<Runnable> f6224b = new LinkedBlockingQueue();

    /* renamed from: c, reason: collision with root package name */
    private static final int f6225c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f6226d;

    /* renamed from: e, reason: collision with root package name */
    private static final int f6227e;

    /* renamed from: f, reason: collision with root package name */
    private static e f6228f;

    /* renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f6229a;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f6225c = iAvailableProcessors;
        f6226d = Math.max(2, Math.min(iAvailableProcessors - 1, 4));
        f6227e = (f6225c * 2) + 1;
    }

    private e() {
        new Handler(Looper.getMainLooper());
        this.f6229a = new ThreadPoolExecutor(f6226d, f6227e, 30L, TimeUnit.SECONDS, f6224b);
    }

    public static e a() {
        e eVar;
        synchronized (e.class) {
            if (f6228f == null) {
                f6228f = new e();
            }
            eVar = f6228f;
        }
        return eVar;
    }

    @Override // com.hihonor.honorid.c
    public void execute(Runnable runnable) {
        this.f6229a.execute(runnable);
    }
}
