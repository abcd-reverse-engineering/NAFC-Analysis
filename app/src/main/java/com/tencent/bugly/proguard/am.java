package com.tencent.bugly.proguard;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class am {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f9248a = new AtomicInteger(1);

    /* renamed from: b, reason: collision with root package name */
    private static am f9249b;

    /* renamed from: c, reason: collision with root package name */
    private ScheduledExecutorService f9250c;

    protected am() {
        this.f9250c = null;
        this.f9250c = Executors.newScheduledThreadPool(3, new ThreadFactory() { // from class: com.tencent.bugly.proguard.am.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("BuglyThread-" + am.f9248a.getAndIncrement());
                return thread;
            }
        });
        ScheduledExecutorService scheduledExecutorService = this.f9250c;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            an.d("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
        }
    }

    public static synchronized am a() {
        if (f9249b == null) {
            f9249b = new am();
        }
        return f9249b;
    }

    public synchronized void b() {
        if (this.f9250c != null && !this.f9250c.isShutdown()) {
            an.c("[AsyncTaskHandler] Close async handler.", new Object[0]);
            this.f9250c.shutdownNow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean c() {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.concurrent.ScheduledExecutorService r0 = r1.f9250c     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto Lf
            java.util.concurrent.ScheduledExecutorService r0 = r1.f9250c     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isShutdown()     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto Lf
            r0 = 1
            goto L10
        Lf:
            r0 = 0
        L10:
            monitor-exit(r1)
            return r0
        L12:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.am.c():boolean");
    }

    public synchronized boolean a(Runnable runnable, long j2) {
        if (!c()) {
            an.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (runnable == null) {
            an.d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        }
        if (j2 <= 0) {
            j2 = 0;
        }
        an.c("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", Long.valueOf(j2), runnable.getClass().getName());
        try {
            this.f9250c.schedule(runnable, j2, TimeUnit.MILLISECONDS);
            return true;
        } catch (Throwable th) {
            if (com.tencent.bugly.b.f8759c) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public synchronized boolean a(Runnable runnable) {
        if (!c()) {
            an.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (runnable == null) {
            an.d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        }
        an.c("[AsyncTaskHandler] Post a normal task: %s", runnable.getClass().getName());
        try {
            this.f9250c.execute(runnable);
            return true;
        } catch (Throwable th) {
            if (com.tencent.bugly.b.f8759c) {
                th.printStackTrace();
            }
            return false;
        }
    }
}
