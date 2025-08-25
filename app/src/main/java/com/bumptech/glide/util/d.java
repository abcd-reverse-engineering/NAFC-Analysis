package com.bumptech.glide.util;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: Executors.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final Executor f5371a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final Executor f5372b = new b();

    /* compiled from: Executors.java */
    class a implements Executor {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f5373a = new Handler(Looper.getMainLooper());

        a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            this.f5373a.post(runnable);
        }
    }

    /* compiled from: Executors.java */
    class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            runnable.run();
        }
    }

    private d() {
    }

    public static Executor a() {
        return f5372b;
    }

    public static Executor b() {
        return f5371a;
    }

    @VisibleForTesting
    public static void a(ExecutorService executorService) {
        executorService.shutdownNow();
        try {
            if (executorService.awaitTermination(5L, TimeUnit.SECONDS)) {
                return;
            }
            executorService.shutdownNow();
            if (executorService.awaitTermination(5L, TimeUnit.SECONDS)) {
            } else {
                throw new RuntimeException("Failed to shutdown");
            }
        } catch (InterruptedException e2) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e2);
        }
    }
}
