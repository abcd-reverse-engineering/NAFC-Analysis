package com.xiaomi.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes2.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static volatile Handler f13252a;

    /* renamed from: a, reason: collision with other field name */
    private static final Object f910a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static volatile Handler f13253b;

    public static Handler a() {
        if (f13253b == null) {
            synchronized (f910a) {
                if (f13253b == null) {
                    HandlerThread handlerThread = new HandlerThread("receiver_task");
                    handlerThread.start();
                    f13253b = new Handler(handlerThread.getLooper());
                }
            }
        }
        return f13253b;
    }

    private static Handler b() {
        if (f13252a == null) {
            synchronized (m.class) {
                if (f13252a == null) {
                    HandlerThread handlerThread = new HandlerThread("handle_receiver");
                    handlerThread.start();
                    f13252a = new Handler(handlerThread.getLooper());
                }
            }
        }
        return f13252a;
    }

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i2) {
        return a(context, broadcastReceiver, intentFilter, (String) null, i2);
    }

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, int i2) {
        return a(context, broadcastReceiver, intentFilter, str, b(), i2);
    }

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        return a(context, broadcastReceiver, intentFilter, str, handler, 2);
    }

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i2) {
        if (context == null || broadcastReceiver == null || intentFilter == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i2);
        }
        return context.registerReceiver(broadcastReceiver, intentFilter, str, handler);
    }
}
