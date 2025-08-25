package com.umeng.socialize.a;

import java.lang.ref.WeakReference;
import java.util.concurrent.Future;

/* compiled from: UMAppScanner.java */
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static WeakReference<Future<?>> f11571a;

    public static void a() {
        Future<?> future;
        WeakReference<Future<?>> weakReference = f11571a;
        if (weakReference == null || (future = weakReference.get()) == null || future.isDone() || future.isCancelled()) {
            f11571a = new WeakReference<>(j.a(new g()));
        }
    }
}
