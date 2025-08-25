package com.umeng.commonsdk.internal.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.NotificationCompat;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;

/* compiled from: BatteryUtils.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10800a = "BatteryUtils";

    /* renamed from: b, reason: collision with root package name */
    private static boolean f10801b = false;

    /* renamed from: c, reason: collision with root package name */
    private static Context f10802c;

    /* renamed from: d, reason: collision with root package name */
    private BroadcastReceiver f10803d;

    /* compiled from: BatteryUtils.java */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final c f10805a = new c();

        private a() {
        }
    }

    public static c a(Context context) {
        if (f10802c == null && context != null) {
            f10802c = context.getApplicationContext();
        }
        return a.f10805a;
    }

    public synchronized void b() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            f10802c.registerReceiver(this.f10803d, intentFilter);
            f10801b = true;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f10802c, th);
        }
    }

    public synchronized void c() {
        try {
            f10802c.unregisterReceiver(this.f10803d);
            f10801b = false;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f10802c, th);
        }
    }

    private c() {
        this.f10803d = new BroadcastReceiver() { // from class: com.umeng.commonsdk.internal.utils.c.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "ACTION_BATTERY_CHANGED：battery info cc.");
                        int i2 = 0;
                        int intExtra = intent.getIntExtra("level", 0);
                        int intExtra2 = intent.getIntExtra("voltage", 0);
                        int intExtra3 = intent.getIntExtra("temperature", 0);
                        int intExtra4 = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, 0);
                        int i3 = -1;
                        if (intExtra4 != 1) {
                            if (intExtra4 == 2) {
                                i3 = 1;
                            } else if (intExtra4 != 3) {
                                if (intExtra4 == 4) {
                                    i3 = 0;
                                } else if (intExtra4 == 5) {
                                    i3 = 2;
                                }
                            }
                        }
                        int intExtra5 = intent.getIntExtra("plugged", 0);
                        if (intExtra5 == 1) {
                            i2 = 1;
                        } else if (intExtra5 == 2) {
                            i2 = 2;
                        }
                        b bVar = new b();
                        bVar.f10794a = intExtra;
                        bVar.f10795b = intExtra2;
                        bVar.f10797d = i3;
                        bVar.f10796c = intExtra3;
                        bVar.f10798e = i2;
                        bVar.f10799f = System.currentTimeMillis();
                        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.f10762h, com.umeng.commonsdk.internal.b.a(c.f10802c).a(), bVar);
                        c.this.c();
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(c.f10802c, th);
                }
            }
        };
    }

    public synchronized boolean a() {
        return f10801b;
    }
}
