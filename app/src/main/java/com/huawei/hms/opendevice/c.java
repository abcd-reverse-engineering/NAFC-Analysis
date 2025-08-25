package com.huawei.hms.opendevice;

import java.util.concurrent.ThreadFactory;

/* compiled from: AsyncThreadFactory.java */
/* loaded from: classes.dex */
public class c implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private final ThreadGroup f7125a;

    /* renamed from: b, reason: collision with root package name */
    private int f7126b = 1;

    /* renamed from: c, reason: collision with root package name */
    private final String f7127c;

    public c(String str) {
        SecurityManager securityManager = System.getSecurityManager();
        this.f7125a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.f7127c = str + "-pool-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        synchronized (this) {
            this.f7126b++;
        }
        Thread thread = new Thread(this.f7125a, runnable, this.f7127c + this.f7126b, 0L);
        thread.setUncaughtExceptionHandler(null);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        return thread;
    }
}
