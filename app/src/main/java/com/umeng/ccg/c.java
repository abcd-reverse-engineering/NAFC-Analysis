package com.umeng.ccg;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.HashMap;

/* compiled from: Dispatch.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final int f10610a = 101;

    /* renamed from: b, reason: collision with root package name */
    public static final int f10611b = 102;

    /* renamed from: c, reason: collision with root package name */
    public static final int f10612c = 103;

    /* renamed from: d, reason: collision with root package name */
    public static final int f10613d = 104;

    /* renamed from: e, reason: collision with root package name */
    public static final int f10614e = 105;

    /* renamed from: f, reason: collision with root package name */
    public static final int f10615f = 106;

    /* renamed from: g, reason: collision with root package name */
    public static final int f10616g = 107;

    /* renamed from: h, reason: collision with root package name */
    public static final int f10617h = 0;

    /* renamed from: i, reason: collision with root package name */
    public static final int f10618i = 1;

    /* renamed from: j, reason: collision with root package name */
    public static final int f10619j = 2;

    /* renamed from: k, reason: collision with root package name */
    public static final int f10620k = 201;

    /* renamed from: l, reason: collision with root package name */
    public static final int f10621l = 202;

    /* renamed from: m, reason: collision with root package name */
    public static final int f10622m = 203;
    public static final int n = 301;
    public static final int o = 302;
    public static final int p = 303;
    private static HandlerThread q = null;
    private static Handler r = null;
    private static HashMap<Integer, a> s = null;
    private static final int t = 256;

    /* compiled from: Dispatch.java */
    public interface a {
        void a(Object obj, int i2);
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Message message) {
        int i2 = message.arg1;
        Object obj = message.obj;
        Integer numValueOf = Integer.valueOf(i2 / 100);
        HashMap<Integer, a> map = s;
        if (map == null) {
            return;
        }
        a aVar = map.containsKey(numValueOf) ? s.get(numValueOf) : null;
        if (aVar != null) {
            aVar.a(obj, i2);
        }
    }

    public static void a(Context context, int i2, int i3, a aVar, Object obj, long j2) {
        if (context == null || aVar == null) {
            return;
        }
        if (s == null) {
            s = new HashMap<>();
        }
        Integer numValueOf = Integer.valueOf(i3 / 100);
        if (!s.containsKey(numValueOf)) {
            s.put(numValueOf, aVar);
        }
        if (q == null || r == null) {
            a();
        }
        try {
            if (r != null) {
                Message messageObtainMessage = r.obtainMessage();
                messageObtainMessage.what = i2;
                messageObtainMessage.arg1 = i3;
                messageObtainMessage.obj = obj;
                r.sendMessageDelayed(messageObtainMessage, j2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, int i2, a aVar, Object obj) {
        a(context, 256, i2, aVar, obj, 0L);
    }

    public static void a(Context context, int i2, a aVar, Object obj, long j2) {
        a(context, 256, i2, aVar, obj, j2);
    }

    private static synchronized void a() {
        try {
            if (q == null) {
                q = new HandlerThread("ccg_dispatch");
                q.start();
                if (r == null) {
                    r = new Handler(q.getLooper()) { // from class: com.umeng.ccg.c.1
                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            if (message.what != 256) {
                                return;
                            }
                            c.b(message);
                        }
                    };
                }
            }
        } catch (Throwable unused) {
        }
    }
}
