package com.umeng.message.proguard;

import java.lang.ref.WeakReference;
import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private static WeakReference<Future<?>> f11384a;

    public static synchronized void a() {
        Future<?> future;
        if (f11384a == null || (future = f11384a.get()) == null || future.isDone() || future.isCancelled()) {
            f11384a = new WeakReference<>(b.b(new m()));
        }
    }
}
