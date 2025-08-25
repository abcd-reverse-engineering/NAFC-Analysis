package com.lxj.xpopup.photoview;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;

/* compiled from: Compat.java */
/* loaded from: classes.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int f8093a = 16;

    a() {
    }

    public static void a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            b(view, runnable);
        } else {
            view.postDelayed(runnable, 16L);
        }
    }

    @TargetApi(16)
    private static void b(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
