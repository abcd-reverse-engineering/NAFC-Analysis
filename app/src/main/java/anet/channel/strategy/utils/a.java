package anet.channel.strategy.utils;

import anet.channel.util.ALog;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static AtomicInteger f2026a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    private static ScheduledThreadPoolExecutor f2027b = null;

    static ScheduledThreadPoolExecutor a() {
        if (f2027b == null) {
            synchronized (a.class) {
                if (f2027b == null) {
                    f2027b = new ScheduledThreadPoolExecutor(2, new b());
                    f2027b.setKeepAliveTime(60L, TimeUnit.SECONDS);
                    f2027b.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f2027b;
    }

    public static void a(Runnable runnable) {
        try {
            a().submit(runnable);
        } catch (Exception e2) {
            ALog.e(anet.channel.strategy.dispatch.a.TAG, "submit task failed", null, e2, new Object[0]);
        }
    }

    public static void a(Runnable runnable, long j2) {
        try {
            a().schedule(runnable, j2, TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            ALog.e(anet.channel.strategy.dispatch.a.TAG, "schedule task failed", null, e2, new Object[0]);
        }
    }
}
