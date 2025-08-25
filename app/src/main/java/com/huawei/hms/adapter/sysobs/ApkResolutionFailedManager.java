package com.huawei.hms.adapter.sysobs;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.support.log.HMSLog;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ApkResolutionFailedManager {

    /* renamed from: c, reason: collision with root package name */
    private static final ApkResolutionFailedManager f6584c = new ApkResolutionFailedManager();

    /* renamed from: a, reason: collision with root package name */
    private final Handler f6585a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, Runnable> f6586b = new HashMap(2);

    private ApkResolutionFailedManager() {
    }

    public static ApkResolutionFailedManager getInstance() {
        return f6584c;
    }

    public void postTask(String str, Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HMSLog.e("ApkResolutionFailedManager", "postTask is not in main thread");
        } else {
            this.f6586b.put(str, runnable);
            this.f6585a.postDelayed(runnable, 2000L);
        }
    }

    public void removeTask(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HMSLog.e("ApkResolutionFailedManager", "removeTask is not in main thread");
            return;
        }
        Runnable runnableRemove = this.f6586b.remove(str);
        if (runnableRemove == null) {
            HMSLog.e("ApkResolutionFailedManager", "cancel runnable is null");
        } else {
            this.f6585a.removeCallbacks(runnableRemove);
        }
    }

    public void removeValueOnly(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HMSLog.e("ApkResolutionFailedManager", "removeValueOnly is not in main thread");
        } else {
            this.f6586b.remove(str);
        }
    }
}
