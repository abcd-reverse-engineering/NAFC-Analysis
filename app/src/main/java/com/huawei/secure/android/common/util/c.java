package com.huawei.secure.android.common.util;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static Handler f7718a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        f7718a.post(runnable);
    }
}
