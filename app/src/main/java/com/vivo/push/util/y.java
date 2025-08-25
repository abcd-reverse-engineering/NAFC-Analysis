package com.vivo.push.util;

/* compiled from: OperateUtil.java */
/* loaded from: classes2.dex */
public final class y {
    public static int a(com.vivo.push.b.c cVar) {
        ad adVarB = ad.b();
        int iB = cVar.b();
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iB2 = adVarB.b("com.vivo.push_preferences.operate." + iB + "OPERATE_COUNT", 0);
        long jB = jCurrentTimeMillis - adVarB.b("com.vivo.push_preferences.operate." + iB + "START_TIME", 0L);
        if (jB > 86400000 || jB < 0) {
            adVarB.a("com.vivo.push_preferences.operate." + iB + "START_TIME", System.currentTimeMillis());
            adVarB.a("com.vivo.push_preferences.operate." + iB + "OPERATE_COUNT", 1);
        } else {
            if (iB2 >= cVar.d()) {
                return 1001;
            }
            adVarB.a("com.vivo.push_preferences.operate." + iB + "OPERATE_COUNT", iB2 + 1);
        }
        return 0;
    }
}
