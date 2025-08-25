package com.xiaomi.push.service;

import android.text.TextUtils;

/* loaded from: classes2.dex */
public class aj {

    /* renamed from: a, reason: collision with root package name */
    private static long f13340a = 0;

    /* renamed from: a, reason: collision with other field name */
    private static String f987a = "";

    public static String a() {
        if (TextUtils.isEmpty(f987a)) {
            f987a = com.xiaomi.push.bb.a(4);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f987a);
        long j2 = f13340a;
        f13340a = 1 + j2;
        sb.append(j2);
        return sb.toString();
    }

    public static String b() {
        return com.xiaomi.push.bb.a(32);
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 32) {
            return str;
        }
        try {
            return "BlockId_" + str.substring(8);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.d("Exception occurred when filtering registration packet id for log. " + e2);
            return "UnexpectedId";
        }
    }
}
