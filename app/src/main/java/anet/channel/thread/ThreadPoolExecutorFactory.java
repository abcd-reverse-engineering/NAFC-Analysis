package anet.channel.thread;

import anet.channel.util.ALog;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ThreadPoolExecutorFactory {

    /* renamed from: a, reason: collision with root package name */
    private static ScheduledThreadPoolExecutor f2028a = new ScheduledThreadPoolExecutor(1, new b("AWCN Scheduler"));

    /* renamed from: b, reason: collision with root package name */
    private static ThreadPoolExecutor f2029b = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingDeque(), new b("AWCN Worker(H)"));

    /* renamed from: c, reason: collision with root package name */
    private static ThreadPoolExecutor f2030c = new anet.channel.thread.a(16, 16, 60, TimeUnit.SECONDS, new PriorityBlockingQueue(), new b("AWCN Worker(M)"));

    /* renamed from: d, reason: collision with root package name */
    private static ThreadPoolExecutor f2031d = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingDeque(), new b("AWCN Worker(L)"));

    /* renamed from: e, reason: collision with root package name */
    private static ThreadPoolExecutor f2032e = new ThreadPoolExecutor(32, 32, 60, TimeUnit.SECONDS, new LinkedBlockingDeque(), new b("AWCN Worker(Backup)"));

    /* renamed from: f, reason: collision with root package name */
    private static ThreadPoolExecutor f2033f = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new LinkedBlockingDeque(), new b("AWCN Detector"));

    /* renamed from: g, reason: collision with root package name */
    private static ThreadPoolExecutor f2034g = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new LinkedBlockingDeque(), new b("AWCN HR"));

    /* renamed from: h, reason: collision with root package name */
    private static ThreadPoolExecutor f2035h = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new LinkedBlockingDeque(), new b("AWCN Cookie"));

    /* compiled from: Taobao */
    public static class Priority {
        public static int HIGH = 0;
        public static int LOW = 9;
        public static int NORMAL = 1;
    }

    /* compiled from: Taobao */
    static class a implements Comparable<a>, Runnable {

        /* renamed from: a, reason: collision with root package name */
        Runnable f2036a;

        /* renamed from: b, reason: collision with root package name */
        int f2037b;

        /* renamed from: c, reason: collision with root package name */
        long f2038c;

        public a(Runnable runnable, int i2) {
            this.f2036a = null;
            this.f2037b = 0;
            this.f2038c = System.currentTimeMillis();
            this.f2036a = runnable;
            this.f2037b = i2;
            this.f2038c = System.currentTimeMillis();
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            int i2 = this.f2037b;
            int i3 = aVar.f2037b;
            return i2 != i3 ? i2 - i3 : (int) (aVar.f2038c - this.f2038c);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2036a.run();
        }
    }

    /* compiled from: Taobao */
    private static class b implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        AtomicInteger f2039a = new AtomicInteger(0);

        /* renamed from: b, reason: collision with root package name */
        String f2040b;

        b(String str) {
            this.f2040b = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f2040b + this.f2039a.incrementAndGet());
            ALog.i("awcn.ThreadPoolExecutorFactory", "thread created!", null, CommonNetImpl.NAME, thread.getName());
            thread.setPriority(5);
            return thread;
        }
    }

    static {
        f2029b.allowCoreThreadTimeOut(true);
        f2030c.allowCoreThreadTimeOut(true);
        f2031d.allowCoreThreadTimeOut(true);
        f2032e.allowCoreThreadTimeOut(true);
        f2033f.allowCoreThreadTimeOut(true);
        f2034g.allowCoreThreadTimeOut(true);
        f2035h.allowCoreThreadTimeOut(true);
    }

    public static void removeScheduleTask(Runnable runnable) {
        f2028a.remove(runnable);
    }

    public static synchronized void setNormalExecutorPoolSize(int i2) {
        if (i2 < 6) {
            i2 = 6;
        }
        f2030c.setCorePoolSize(i2);
        f2030c.setMaximumPoolSize(i2);
    }

    public static Future<?> submitBackupTask(Runnable runnable) {
        return f2032e.submit(runnable);
    }

    public static Future<?> submitCookieMonitor(Runnable runnable) {
        return f2035h.submit(runnable);
    }

    public static Future<?> submitDetectTask(Runnable runnable) {
        return f2033f.submit(runnable);
    }

    public static Future<?> submitHRTask(Runnable runnable) {
        return f2034g.submit(runnable);
    }

    public static Future<?> submitPriorityTask(Runnable runnable, int i2) {
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.ThreadPoolExecutorFactory", "submit priority task", null, RemoteMessageConst.Notification.PRIORITY, Integer.valueOf(i2));
        }
        if (i2 < Priority.HIGH || i2 > Priority.LOW) {
            i2 = Priority.LOW;
        }
        return i2 == Priority.HIGH ? f2029b.submit(runnable) : i2 == Priority.LOW ? f2031d.submit(runnable) : f2030c.submit(new a(runnable, i2));
    }

    public static Future<?> submitScheduledTask(Runnable runnable) {
        return f2028a.submit(runnable);
    }

    public static Future<?> submitScheduledTask(Runnable runnable, long j2, TimeUnit timeUnit) {
        return f2028a.schedule(runnable, j2, timeUnit);
    }
}
