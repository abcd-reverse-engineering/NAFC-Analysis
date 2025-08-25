package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* loaded from: classes2.dex */
public class cw {

    /* renamed from: a, reason: collision with root package name */
    private static int f12615a = 0;

    /* renamed from: a, reason: collision with other field name */
    private static boolean f290a = true;

    private static int a(boolean z) {
        return z ? 1 : 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static SharedPreferences m258a(Context context) {
        return context.getSharedPreferences("sp_power_stats", 0);
    }

    public static void b(final Context context, final long j2, final boolean z) {
        ae.a(context).a(new Runnable() { // from class: com.xiaomi.push.cw.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cw.j(context, j2, z);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("PowerStatsSP onReceiveMsg exception: " + e2.getMessage());
                }
            }
        });
    }

    public static void c(final Context context, final long j2, final boolean z) {
        ae.a(context).a(new Runnable() { // from class: com.xiaomi.push.cw.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cw.k(context, j2, z);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("PowerStatsSP onPing exception: " + e2.getMessage());
                }
            }
        });
    }

    public static void d(final Context context, final long j2, final boolean z) {
        ae.a(context).a(new Runnable() { // from class: com.xiaomi.push.cw.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cw.l(context, j2, z);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("PowerStatsSP onPong exception: " + e2.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void i(Context context, long j2, boolean z) {
        int i2;
        ct.a("recordSendMsg start");
        int iA = a(z);
        SharedPreferences sharedPreferencesM258a = m258a(context);
        long j3 = sharedPreferencesM258a.getLong(com.umeng.analytics.pro.d.p, 0L);
        if (j3 <= 0) {
            a(context, sharedPreferencesM258a, j2, iA);
        }
        if (iA == 1) {
            i2 = sharedPreferencesM258a.getInt("on_up_count", 0) + 1;
            sharedPreferencesM258a.edit().putInt("on_up_count", i2).apply();
        } else {
            i2 = sharedPreferencesM258a.getInt("off_up_count", 0) + 1;
            sharedPreferencesM258a.edit().putInt("off_up_count", i2).apply();
        }
        a(context, j3, j2, i2, iA);
        ct.a("recordSendMsg complete");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void j(Context context, long j2, boolean z) {
        int i2;
        ct.a("recordReceiveMsg start");
        int iA = a(z);
        SharedPreferences sharedPreferencesM258a = m258a(context);
        long j3 = sharedPreferencesM258a.getLong(com.umeng.analytics.pro.d.p, 0L);
        if (j3 <= 0) {
            a(context, sharedPreferencesM258a, j2, iA);
        }
        if (iA == 1) {
            i2 = sharedPreferencesM258a.getInt("on_down_count", 0) + 1;
            sharedPreferencesM258a.edit().putInt("on_down_count", i2).apply();
        } else {
            i2 = sharedPreferencesM258a.getInt("off_down_count", 0) + 1;
            sharedPreferencesM258a.edit().putInt("off_down_count", i2).apply();
        }
        a(context, j3, j2, i2, iA);
        ct.a("recordReceiveMsg complete");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void k(Context context, long j2, boolean z) {
        int i2;
        ct.a("recordPing start");
        int iA = a(z);
        SharedPreferences sharedPreferencesM258a = m258a(context);
        long j3 = sharedPreferencesM258a.getLong(com.umeng.analytics.pro.d.p, 0L);
        if (j3 <= 0) {
            a(context, sharedPreferencesM258a, j2, iA);
        }
        if (iA == 1) {
            i2 = sharedPreferencesM258a.getInt("on_ping_count", 0) + 1;
            sharedPreferencesM258a.edit().putInt("on_ping_count", i2).apply();
        } else {
            i2 = sharedPreferencesM258a.getInt("off_ping_count", 0) + 1;
            sharedPreferencesM258a.edit().putInt("off_ping_count", i2).apply();
        }
        a(context, j3, j2, i2, iA);
        ct.a("recordPing complete");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void l(Context context, long j2, boolean z) {
        int i2;
        ct.a("recordPong start");
        int iA = a(z);
        SharedPreferences sharedPreferencesM258a = m258a(context);
        long j3 = sharedPreferencesM258a.getLong(com.umeng.analytics.pro.d.p, 0L);
        if (j3 <= 0) {
            a(context, sharedPreferencesM258a, j2, iA);
        }
        if (iA == 1) {
            i2 = sharedPreferencesM258a.getInt("on_pong_count", 0) + 1;
            sharedPreferencesM258a.edit().putInt("on_pong_count", i2).apply();
        } else {
            i2 = sharedPreferencesM258a.getInt("off_pong_count", 0) + 1;
            sharedPreferencesM258a.edit().putInt("off_pong_count", i2).apply();
        }
        a(context, j3, j2, i2, iA);
        ct.a("recordPong complete");
    }

    public static void a(final Context context, final long j2, final boolean z) {
        ae.a(context).a(new Runnable() { // from class: com.xiaomi.push.cw.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cw.i(context, j2, z);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("PowerStatsSP onSendMsg exception: " + e2.getMessage());
                }
            }
        });
    }

    private static void b(Context context, long j2, int i2) {
        ct.a("reset");
        m258a(context).edit().clear().putLong(com.umeng.analytics.pro.d.p, j2).putInt("current_screen_state", i2).putLong("current_screen_state_start_time", j2).putInt("xmsf_vc", a(context)).putInt("android_vc", Build.VERSION.SDK_INT).apply();
    }

    private static void a(Context context, SharedPreferences sharedPreferences, long j2, int i2) {
        ct.a("recordInit");
        sharedPreferences.edit().putLong(com.umeng.analytics.pro.d.p, j2).putInt("current_screen_state", i2).putLong("current_screen_state_start_time", j2).putInt("xmsf_vc", a(context)).putInt("android_vc", Build.VERSION.SDK_INT).apply();
    }

    private static void a(Context context, long j2, long j3, int i2, int i3) {
        if (j2 > 0) {
            if (m260a(context) || i2 >= 1073741823 || j3 - j2 >= 86400000) {
                m258a(context).edit().putLong(com.umeng.analytics.pro.d.q, j3).apply();
                a(context, j3, i3);
            }
        }
    }

    private static void a(Context context, long j2, int i2) {
        ct.a("upload");
        new cv().a(context, m259a(context));
        b(context, j2, i2);
    }

    /* renamed from: a, reason: collision with other method in class */
    private static cu m259a(Context context) {
        SharedPreferences sharedPreferencesM258a = m258a(context);
        cu cuVar = new cu();
        cuVar.a(sharedPreferencesM258a.getInt("off_up_count", 0));
        cuVar.b(sharedPreferencesM258a.getInt("off_down_count", 0));
        cuVar.c(sharedPreferencesM258a.getInt("off_ping_count", 0));
        cuVar.d(sharedPreferencesM258a.getInt("off_pong_count", 0));
        cuVar.a(sharedPreferencesM258a.getLong("off_duration", 0L));
        cuVar.e(sharedPreferencesM258a.getInt("on_up_count", 0));
        cuVar.f(sharedPreferencesM258a.getInt("on_down_count", 0));
        cuVar.g(sharedPreferencesM258a.getInt("on_ping_count", 0));
        cuVar.h(sharedPreferencesM258a.getInt("on_pong_count", 0));
        cuVar.b(sharedPreferencesM258a.getLong("on_duration", 0L));
        cuVar.c(sharedPreferencesM258a.getLong(com.umeng.analytics.pro.d.p, 0L));
        cuVar.d(sharedPreferencesM258a.getLong(com.umeng.analytics.pro.d.q, 0L));
        cuVar.i(sharedPreferencesM258a.getInt("xmsf_vc", 0));
        cuVar.j(sharedPreferencesM258a.getInt("android_vc", 0));
        return cuVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m260a(Context context) {
        boolean z = false;
        if (f290a) {
            f290a = false;
            SharedPreferences sharedPreferencesM258a = m258a(context);
            int i2 = sharedPreferencesM258a.getInt("xmsf_vc", 0);
            int i3 = sharedPreferencesM258a.getInt("android_vc", 0);
            if (i2 != 0 && i3 != 0 && (i2 != a(context) || i3 != Build.VERSION.SDK_INT)) {
                z = true;
            }
        }
        ct.a("isVcChanged = " + z);
        return z;
    }

    private static int a(Context context) {
        if (f12615a <= 0) {
            f12615a = j.b(context);
        }
        return f12615a;
    }
}
