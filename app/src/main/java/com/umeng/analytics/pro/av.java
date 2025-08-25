package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Looper;
import com.umeng.commonsdk.debug.UMRTLog;

/* compiled from: OpenDeviceId.java */
/* loaded from: classes2.dex */
public class av {

    /* renamed from: a, reason: collision with root package name */
    private static au f10081a = null;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f10082b = false;

    public static synchronized String a(Context context) {
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** real call OpenDeviceId.getOaid()");
        if (context == null) {
            throw new RuntimeException("Context is null");
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        b(context);
        if (f10081a != null) {
            try {
                return f10081a.a(context);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static void b(Context context) {
        if (f10081a != null || f10082b) {
            return;
        }
        synchronized (av.class) {
            if (f10081a == null && !f10082b) {
                f10081a = ax.a(context);
                f10082b = true;
            }
        }
    }
}
