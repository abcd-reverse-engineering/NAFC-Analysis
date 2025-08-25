package com.vivo.push.util;

import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: ClientReportUtil.java */
/* loaded from: classes2.dex */
public final class f {
    public static boolean a(long j2, long j3) {
        u.d("ClientReportUtil", "report message: " + j2 + ", reportType: " + j3);
        com.vivo.push.b.x xVar = new com.vivo.push.b.x(j3);
        HashMap<String, String> map = new HashMap<>();
        map.put(com.heytap.mcssdk.constant.b.f5825c, String.valueOf(j2));
        String strA = com.vivo.push.restructure.a.a().e().a();
        if (!TextUtils.isEmpty(strA)) {
            map.put("remoteAppId", strA);
        }
        xVar.a(map);
        com.vivo.push.m.a().a(xVar);
        return true;
    }

    public static boolean a(long j2, HashMap<String, String> map) {
        com.vivo.push.b.x xVar = new com.vivo.push.b.x(j2);
        xVar.a(map);
        xVar.d();
        com.vivo.push.m.a().a(xVar);
        return true;
    }
}
