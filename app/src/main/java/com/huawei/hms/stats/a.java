package com.huawei.hms.stats;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: AnalyticsCacheManager.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: f, reason: collision with root package name */
    private static final a f7252f = new a();

    /* renamed from: a, reason: collision with root package name */
    private final Object f7253a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private boolean f7254b = false;

    /* renamed from: c, reason: collision with root package name */
    private final List<Runnable> f7255c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final Handler f7256d = new Handler(Looper.getMainLooper());

    /* renamed from: e, reason: collision with root package name */
    private final Runnable f7257e = new RunnableC0106a();

    /* compiled from: AnalyticsCacheManager.java */
    /* renamed from: com.huawei.hms.stats.a$a, reason: collision with other inner class name */
    class RunnableC0106a implements Runnable {
        RunnableC0106a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLog.i("AnalyticsCacheManager", "Timeout execCacheBi.");
            if (HiAnalyticsUtils.getInstance().getInitFlag()) {
                a.this.b();
            } else {
                a.this.a();
            }
        }
    }

    private a() {
    }

    public static a c() {
        return f7252f;
    }

    public void a(Runnable runnable) {
        synchronized (this.f7253a) {
            if (runnable == null) {
                return;
            }
            if (this.f7254b) {
                return;
            }
            if (this.f7255c.size() >= 60) {
                return;
            }
            this.f7255c.add(runnable);
            this.f7256d.removeCallbacks(this.f7257e);
            this.f7256d.postDelayed(this.f7257e, com.heytap.mcssdk.constant.a.q);
        }
    }

    public void b() {
        synchronized (this.f7253a) {
            HMSLog.i("AnalyticsCacheManager", "execCacheBi: cache size: " + this.f7255c.size());
            this.f7254b = true;
            try {
                Iterator<Runnable> it = this.f7255c.iterator();
                while (it.hasNext()) {
                    it.next().run();
                    it.remove();
                }
            } catch (Throwable th) {
                HMSLog.e("AnalyticsCacheManager", "<execCacheBi> failed. " + th.getMessage());
                a();
            }
            this.f7254b = false;
        }
    }

    public void a() {
        synchronized (this.f7253a) {
            HMSLog.i("AnalyticsCacheManager", "clear AnalyticsCache.");
            this.f7255c.clear();
        }
    }
}
