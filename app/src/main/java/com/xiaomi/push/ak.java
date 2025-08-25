package com.xiaomi.push;

import android.content.Context;

/* loaded from: classes2.dex */
class ak {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f12438a = false;

    private static void a(Class<?> cls, Context context) {
        if (f12438a) {
            return;
        }
        try {
            f12438a = true;
            cls.getDeclaredMethod("InitEntry", Context.class).invoke(cls, context);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m50a("mdid:load lib error " + th);
        }
    }

    public static boolean a(Context context) {
        try {
            Class<?> clsA = C0343r.a(context, "com.bun.miitmdid.core.JLibrary");
            if (clsA == null) {
                return false;
            }
            a(clsA, context);
            return true;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m50a("mdid:check error " + th);
            return false;
        }
    }
}
