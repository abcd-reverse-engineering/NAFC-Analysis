package com.umeng.analytics.pro;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.ArrayList;

/* compiled from: BackgroundMonitor.java */
@TargetApi(14)
/* loaded from: classes2.dex */
public class m implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private static m f10452a = new m();

    /* renamed from: b, reason: collision with root package name */
    private final int f10453b = PathInterpolatorCompat.MAX_NUM_POINTS;

    /* renamed from: c, reason: collision with root package name */
    private boolean f10454c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f10455d = true;

    /* renamed from: e, reason: collision with root package name */
    private Handler f10456e = new Handler(Looper.getMainLooper());

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<n> f10457f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private a f10458g = new a();

    /* compiled from: BackgroundMonitor.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!m.this.f10454c || !m.this.f10455d) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> still foreground.");
                return;
            }
            m.this.f10454c = false;
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> went background.");
            for (int i2 = 0; i2 < m.this.f10457f.size(); i2++) {
                ((n) m.this.f10457f.get(i2)).n();
            }
        }
    }

    private m() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.f10455d = true;
        a aVar = this.f10458g;
        if (aVar != null) {
            this.f10456e.removeCallbacks(aVar);
            this.f10456e.postDelayed(this.f10458g, 3000L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.f10455d = false;
        this.f10454c = true;
        a aVar = this.f10458g;
        if (aVar != null) {
            this.f10456e.removeCallbacks(aVar);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public synchronized void b(n nVar) {
        if (nVar != null) {
            for (int i2 = 0; i2 < this.f10457f.size(); i2++) {
                if (this.f10457f.get(i2) == nVar) {
                    this.f10457f.remove(i2);
                }
            }
        }
    }

    public static void a(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(f10452a);
        }
    }

    public static m a() {
        return f10452a;
    }

    public synchronized void a(n nVar) {
        if (nVar != null) {
            this.f10457f.add(nVar);
        }
    }
}
