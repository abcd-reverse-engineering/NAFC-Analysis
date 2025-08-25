package com.xiaomi.push;

import android.os.SystemClock;
import com.xiaomi.push.em;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public class ep {

    /* renamed from: a, reason: collision with root package name */
    private static final int f12782a = ei.PING_RTT.a();

    /* renamed from: a, reason: collision with other field name */
    private static long f460a = 0;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        static Hashtable<Integer, Long> f12783a = new Hashtable<>();
    }

    public static void a(String str, Exception exc) {
        try {
            em.a aVarB = em.b(exc);
            ej ejVarM384a = eo.m382a().m384a();
            ejVarM384a.a(aVarB.f12772a.a());
            ejVarM384a.c(aVarB.f449a);
            ejVarM384a.b(str);
            if (eo.a() != null && eo.a().f452a != null) {
                ejVarM384a.c(au.b(eo.a().f452a) ? 1 : 0);
            }
            eo.m382a().a(ejVarM384a);
        } catch (NullPointerException unused) {
        }
    }

    public static void b(String str, Exception exc) {
        try {
            em.a aVarD = em.d(exc);
            ej ejVarM384a = eo.m382a().m384a();
            ejVarM384a.a(aVarD.f12772a.a());
            ejVarM384a.c(aVarD.f449a);
            ejVarM384a.b(str);
            if (eo.a() != null && eo.a().f452a != null) {
                ejVarM384a.c(au.b(eo.a().f452a) ? 1 : 0);
            }
            eo.m382a().a(ejVarM384a);
        } catch (NullPointerException unused) {
        }
    }

    public static void a(String str, int i2, Exception exc) {
        ej ejVarM384a = eo.m382a().m384a();
        if (eo.a() != null && eo.a().f452a != null) {
            ejVarM384a.c(au.b(eo.a().f452a) ? 1 : 0);
        }
        if (i2 > 0) {
            ejVarM384a.a(ei.GSLB_REQUEST_SUCCESS.a());
            ejVarM384a.b(str);
            ejVarM384a.b(i2);
            eo.m382a().a(ejVarM384a);
            return;
        }
        try {
            em.a aVarA = em.a(exc);
            ejVarM384a.a(aVarA.f12772a.a());
            ejVarM384a.c(aVarA.f449a);
            ejVarM384a.b(str);
            eo.m382a().a(ejVarM384a);
        } catch (NullPointerException unused) {
        }
    }

    public static void b() {
        a(0, f12782a, null, -1);
    }

    public static void a(XMPushService xMPushService, am.b bVar) {
        new el(xMPushService, bVar).a();
    }

    public static synchronized void a(int i2, int i3) {
        if (i3 < 16777215) {
            a.f12783a.put(Integer.valueOf((i2 << 24) | i3), Long.valueOf(System.currentTimeMillis()));
        } else {
            com.xiaomi.channel.commonutils.logger.b.d("stats key should less than 16777215");
        }
    }

    public static synchronized void a(int i2, int i3, String str, int i4) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i5 = (i2 << 24) | i3;
        if (a.f12783a.containsKey(Integer.valueOf(i5))) {
            ej ejVarM384a = eo.m382a().m384a();
            ejVarM384a.a(i3);
            ejVarM384a.b((int) (jCurrentTimeMillis - a.f12783a.get(Integer.valueOf(i5)).longValue()));
            ejVarM384a.b(str);
            if (i4 > -1) {
                ejVarM384a.c(i4);
            }
            eo.m382a().a(ejVarM384a);
            a.f12783a.remove(Integer.valueOf(i3));
        } else {
            com.xiaomi.channel.commonutils.logger.b.d("stats key not found");
        }
    }

    public static void a() {
        if (f460a == 0 || SystemClock.elapsedRealtime() - f460a > com.heytap.mcssdk.constant.a.n) {
            f460a = SystemClock.elapsedRealtime();
            a(0, f12782a);
        }
    }

    public static void a(int i2, int i3, int i4, String str, int i5) {
        ej ejVarM384a = eo.m382a().m384a();
        ejVarM384a.a((byte) i2);
        ejVarM384a.a(i3);
        ejVarM384a.b(i4);
        ejVarM384a.b(str);
        ejVarM384a.c(i5);
        eo.m382a().a(ejVarM384a);
    }

    public static void a(int i2) {
        ej ejVarM384a = eo.m382a().m384a();
        ejVarM384a.a(ei.CHANNEL_STATS_COUNTER.a());
        ejVarM384a.c(i2);
        eo.m382a().a(ejVarM384a);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static byte[] m388a() {
        ek ekVarM385a = eo.m382a().m385a();
        if (ekVarM385a != null) {
            return hp.a(ekVarM385a);
        }
        return null;
    }
}
