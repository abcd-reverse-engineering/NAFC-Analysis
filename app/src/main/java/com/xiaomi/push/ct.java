package com.xiaomi.push;

import android.content.Context;

/* loaded from: classes2.dex */
public class ct {

    /* renamed from: a, reason: collision with root package name */
    private static cl f12591a;

    /* renamed from: a, reason: collision with other field name */
    private static cm f285a;

    public static void a(Context context, fa faVar) {
        if (m253b(context)) {
            if (f12591a == null) {
                f12591a = new cl(context);
            }
            if (f285a == null) {
                f285a = new cm(context);
            }
            cl clVar = f12591a;
            faVar.a(clVar, clVar);
            cm cmVar = f285a;
            faVar.b(cmVar, cmVar);
            a("startStats");
        }
    }

    public static void b(Context context, fa faVar) {
        cl clVar = f12591a;
        if (clVar != null) {
            faVar.a(clVar);
            f12591a = null;
        }
        cm cmVar = f285a;
        if (cmVar != null) {
            faVar.b(cmVar);
            f285a = null;
        }
        a("stopStats");
    }

    public static void c(Context context) {
        a("onPing");
        if (m253b(context)) {
            cw.c(context, System.currentTimeMillis(), m252a(context));
        }
    }

    public static void d(Context context) {
        a("onPong");
        if (m253b(context)) {
            cw.d(context, System.currentTimeMillis(), m252a(context));
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    private static boolean m253b(Context context) {
        return ck.a(context);
    }

    public static void a(Context context) {
        a("onSendMsg");
        if (m253b(context)) {
            cw.a(context, System.currentTimeMillis(), m252a(context));
        }
    }

    public static void b(Context context) {
        a("onReceiveMsg");
        if (m253b(context)) {
            cw.b(context, System.currentTimeMillis(), m252a(context));
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m252a(Context context) {
        return i.m620b(context);
    }

    static void a(String str) {
        ck.a("Push-PowerStats", str);
    }
}
