package com.umeng.socialize.tracker.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: TaskPool.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final int f11857a = 1;

    /* renamed from: b, reason: collision with root package name */
    private static ExecutorService f11858b = Executors.newFixedThreadPool(1);

    public static void a(Runnable runnable) {
        if (runnable != null) {
            f11858b.execute(runnable);
        }
    }
}
