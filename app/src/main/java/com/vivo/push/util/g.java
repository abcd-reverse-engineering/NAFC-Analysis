package com.vivo.push.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ConcurrentUtils.java */
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static final int f12267a = Runtime.getRuntime().availableProcessors();

    /* renamed from: b, reason: collision with root package name */
    private static final int f12268b = Math.max(2, Math.min(f12267a - 1, 4));

    /* renamed from: c, reason: collision with root package name */
    private static final int f12269c = (f12267a * 2) + 1;

    /* renamed from: d, reason: collision with root package name */
    private static ExecutorService f12270d = new ThreadPoolExecutor(f12268b, f12269c, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new h("COMMON_THREAD"), new ThreadPoolExecutor.DiscardPolicy());

    public static ExecutorService a() {
        return f12270d;
    }
}
