package com.vivo.push;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* compiled from: PushClientThread.java */
/* loaded from: classes2.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    private static final Handler f12219a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    private static final HandlerThread f12220b;

    /* renamed from: c, reason: collision with root package name */
    private static final Handler f12221c;

    static {
        HandlerThread handlerThread = new HandlerThread("push_client_thread");
        f12220b = handlerThread;
        handlerThread.start();
        f12221c = new u(f12220b.getLooper());
    }

    public static void a(s sVar) {
        if (sVar == null) {
            com.vivo.push.util.u.a("PushClientThread", "client thread error, task is null!");
            return;
        }
        int iA = sVar.a();
        Message message = new Message();
        message.what = iA;
        message.obj = sVar;
        f12221c.sendMessageDelayed(message, 0L);
    }

    public static void b(Runnable runnable) {
        f12219a.post(runnable);
    }

    public static void c(Runnable runnable) {
        Handler handler = f12221c;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public static void a(Runnable runnable) {
        f12221c.removeCallbacks(runnable);
        f12221c.postDelayed(runnable, 15000L);
    }
}
