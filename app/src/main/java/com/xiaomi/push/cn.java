package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public class cn {

    /* renamed from: a, reason: collision with root package name */
    private static int f12563a = -1;

    /* renamed from: a, reason: collision with other field name */
    private static cr f270a;

    /* renamed from: a, reason: collision with other field name */
    private static String f271a;

    public static void a(Context context, fa faVar) {
        if (m242a(context)) {
            if (f270a == null) {
                f270a = new cr(context);
            }
            faVar.a(f270a);
            a("startStats");
        }
    }

    public static void b(Context context, fa faVar) {
        cr crVar = f270a;
        if (crVar != null) {
            faVar.b(crVar);
            f270a = null;
            a("stopStats");
        }
    }

    private static synchronized void b(String str) {
        if ("WIFI-ID-UNKNOWN".equals(str)) {
            if (f271a == null || !f271a.startsWith("W-")) {
                f271a = null;
            }
        } else {
            f271a = str;
        }
        a("updateNetId new networkId = " + str + ", finally netId = " + f271a);
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m242a(Context context) {
        return ck.a(context);
    }

    public static void a(Context context, String str, int i2) {
        if (!m242a(context)) {
            a("onDisconnection shouldSampling = false");
            return;
        }
        cq.a(context, str, au.b(context), System.currentTimeMillis(), i2, com.xiaomi.push.service.m.a(context).m726b(), a(context), a(), f12563a);
        a("onDisconnection");
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m241a(Context context) {
        if (!m242a(context)) {
            a("onReconnection shouldSampling = false");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        f12563a = a(context);
        cq.a(context, jCurrentTimeMillis);
        a("onReconnection connectedNetworkType = " + f12563a);
    }

    public static void a(Context context, String str) {
        if (!m242a(context)) {
            a("onWifiChanged shouldSampling = false");
            return;
        }
        a("onWifiChanged wifiDigest = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b("W-" + str);
    }

    private static int a(Context context) {
        String str;
        try {
            av avVarM144a = au.m144a();
            if (avVarM144a != null) {
                if (avVarM144a.a() == 0) {
                    String strM156b = avVarM144a.m156b();
                    if (TextUtils.isEmpty(strM156b) || "UNKNOWN".equalsIgnoreCase(strM156b)) {
                        str = null;
                    } else {
                        str = "M-" + strM156b;
                    }
                    b(str);
                    return 0;
                }
                if (avVarM144a.a() != 1 && avVarM144a.a() != 6) {
                    b(null);
                    return -1;
                }
                b("WIFI-ID-UNKNOWN");
                return 1;
            }
            b(null);
            return -1;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.d("DisconnectStatsHelper getNetType occurred error: " + e2.getMessage());
            b(null);
            return -1;
        }
    }

    private static synchronized String a() {
        return f271a;
    }

    static void a(String str) {
        ck.a("Push-DiscntStats", str);
    }
}
