package com.heytap.mcssdk.k;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static final ExecutorService f5915a = Executors.newSingleThreadExecutor();

    /* renamed from: b, reason: collision with root package name */
    private static Handler f5916b = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        f5915a.execute(runnable);
    }

    public static void b(Runnable runnable) {
        f5916b.post(runnable);
    }
}
