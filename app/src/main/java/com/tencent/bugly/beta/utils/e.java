package com.tencent.bugly.beta.utils;

import android.os.Handler;
import android.os.Looper;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static Handler f8922a;

    private static Handler a() {
        if (f8922a == null && Looper.getMainLooper() != null) {
            f8922a = new Handler(Looper.getMainLooper());
        }
        return f8922a;
    }

    public static void b(Runnable runnable) {
        if (a() != null) {
            f8922a.removeCallbacks(runnable);
        }
    }

    public static void a(Runnable runnable) {
        if (a() != null) {
            f8922a.post(runnable);
        }
    }

    public static void a(Runnable runnable, long j2) {
        if (a() != null) {
            f8922a.postDelayed(runnable, j2);
        }
    }
}
