package com.umeng.commonsdk.config;

import android.content.Context;
import android.util.Pair;
import com.umeng.commonsdk.config.d;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class FieldManager {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10668a = "cfgfd";

    /* renamed from: b, reason: collision with root package name */
    private static b f10669b = b.b();

    /* renamed from: c, reason: collision with root package name */
    private static boolean f10670c = false;

    /* renamed from: d, reason: collision with root package name */
    private static Object f10671d = new Object();

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final FieldManager f10672a = new FieldManager();

        private a() {
        }
    }

    public static FieldManager a() {
        return a.f10672a;
    }

    public static boolean allow(String str) {
        synchronized (f10671d) {
            if (!f10670c) {
                return false;
            }
            return b.a(str);
        }
    }

    public static boolean b() {
        boolean z;
        synchronized (f10671d) {
            z = f10670c;
        }
        return z;
    }

    private FieldManager() {
    }

    public void a(Context context) {
        String str;
        String[] strArr = {d.a.class.getName(), d.b.class.getName(), d.c.class.getName(), d.EnumC0140d.class.getName()};
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(context, "cfgfd", "1001@3749699455,2130669566,262139,1983");
        synchronized (f10671d) {
            Pair<Long, String> pairA = a(strImprintProperty);
            if (((Long) pairA.first).longValue() <= 1000 || (str = (String) pairA.second) == null || str.length() <= 0) {
                str = "1001@3749699455,2130669566,262139,1983";
            }
            String[] strArrSplit = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            int length = strArrSplit.length;
            if (length > 0) {
                ArrayList arrayList = new ArrayList();
                g gVar = new g();
                for (int i2 = 0; i2 < length; i2++) {
                    arrayList.add(gVar);
                    ((e) arrayList.get(i2)).a(strArrSplit[i2], f10669b, d.b(strArr[i2]));
                }
            }
            f10670c = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.content.Context r11, java.lang.String r12) {
        /*
            r10 = this;
            r11 = 4
            java.lang.String[] r11 = new java.lang.String[r11]
            java.lang.Class<com.umeng.commonsdk.config.d$a> r0 = com.umeng.commonsdk.config.d.a.class
            java.lang.String r0 = r0.getName()
            r1 = 0
            r11[r1] = r0
            java.lang.Class<com.umeng.commonsdk.config.d$b> r0 = com.umeng.commonsdk.config.d.b.class
            java.lang.String r0 = r0.getName()
            r2 = 1
            r11[r2] = r0
            java.lang.Class<com.umeng.commonsdk.config.d$c> r0 = com.umeng.commonsdk.config.d.c.class
            java.lang.String r0 = r0.getName()
            r3 = 2
            r11[r3] = r0
            java.lang.Class<com.umeng.commonsdk.config.d$d> r0 = com.umeng.commonsdk.config.d.EnumC0140d.class
            java.lang.String r0 = r0.getName()
            r3 = 3
            r11[r3] = r0
            java.lang.Object r0 = com.umeng.commonsdk.config.FieldManager.f10671d
            monitor-enter(r0)
            com.umeng.commonsdk.config.b r3 = com.umeng.commonsdk.config.FieldManager.f10669b     // Catch: java.lang.Throwable -> L84
            r3.a()     // Catch: java.lang.Throwable -> L84
            if (r12 == 0) goto L50
            android.util.Pair r12 = a(r12)     // Catch: java.lang.Throwable -> L84
            java.lang.Object r3 = r12.first     // Catch: java.lang.Throwable -> L84
            java.lang.Long r3 = (java.lang.Long) r3     // Catch: java.lang.Throwable -> L84
            long r3 = r3.longValue()     // Catch: java.lang.Throwable -> L84
            r5 = 1000(0x3e8, double:4.94E-321)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L50
            java.lang.Object r12 = r12.second     // Catch: java.lang.Throwable -> L84
            java.lang.String r12 = (java.lang.String) r12     // Catch: java.lang.Throwable -> L84
            if (r12 == 0) goto L50
            int r3 = r12.length()     // Catch: java.lang.Throwable -> L84
            if (r3 <= 0) goto L50
            goto L52
        L50:
            java.lang.String r12 = "1001@3749699455,2130669566,262139,1983"
        L52:
            java.lang.String r3 = ","
            java.lang.String[] r12 = r12.split(r3)     // Catch: java.lang.Throwable -> L84
            int r3 = r12.length     // Catch: java.lang.Throwable -> L84
            if (r3 <= 0) goto L80
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L84
            r4.<init>()     // Catch: java.lang.Throwable -> L84
            com.umeng.commonsdk.config.g r5 = new com.umeng.commonsdk.config.g     // Catch: java.lang.Throwable -> L84
            r5.<init>()     // Catch: java.lang.Throwable -> L84
        L65:
            if (r1 >= r3) goto L80
            r4.add(r5)     // Catch: java.lang.Throwable -> L84
            java.lang.Object r6 = r4.get(r1)     // Catch: java.lang.Throwable -> L84
            com.umeng.commonsdk.config.e r6 = (com.umeng.commonsdk.config.e) r6     // Catch: java.lang.Throwable -> L84
            r7 = r12[r1]     // Catch: java.lang.Throwable -> L84
            com.umeng.commonsdk.config.b r8 = com.umeng.commonsdk.config.FieldManager.f10669b     // Catch: java.lang.Throwable -> L84
            r9 = r11[r1]     // Catch: java.lang.Throwable -> L84
            java.lang.String[] r9 = com.umeng.commonsdk.config.d.b(r9)     // Catch: java.lang.Throwable -> L84
            r6.a(r7, r8, r9)     // Catch: java.lang.Throwable -> L84
            int r1 = r1 + 1
            goto L65
        L80:
            com.umeng.commonsdk.config.FieldManager.f10670c = r2     // Catch: java.lang.Throwable -> L84
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L84
            return
        L84:
            r11 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L84
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.config.FieldManager.a(android.content.Context, java.lang.String):void");
    }

    private static Pair<Long, String> a(String str) {
        Pair<Long, String> pair = new Pair<>(-1L, null);
        if (str != null && str.length() >= 2) {
            String[] strArrSplit = str.split("@");
            if (strArrSplit.length < 2) {
                return pair;
            }
            try {
                long j2 = Long.parseLong(strArrSplit[0]);
                return new Pair<>(Long.valueOf(j2), strArrSplit[1]);
            } catch (Throwable unused) {
            }
        }
        return pair;
    }
}
