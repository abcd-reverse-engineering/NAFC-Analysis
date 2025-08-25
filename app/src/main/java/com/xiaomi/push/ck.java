package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class ck {

    /* renamed from: a, reason: collision with other field name */
    private static final List<String> f269a = Arrays.asList("001", "002", "003", "004", "005");

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f12560a = null;

    public static void a(String str, String str2) {
    }

    public static boolean a(Context context) {
        if (f12560a == null) {
            try {
                if (!j.m627a(context)) {
                    f12560a = false;
                }
                String strM742a = com.xiaomi.push.service.q.m742a(context);
                if (TextUtils.isEmpty(strM742a) || strM742a.length() < 3) {
                    f12560a = false;
                } else {
                    f12560a = Boolean.valueOf(f269a.contains(strM742a.substring(strM742a.length() - 3)));
                }
                a("Sampling statistical connection quality: " + f12560a);
            } catch (Throwable th) {
                f12560a = false;
                com.xiaomi.channel.commonutils.logger.b.c("Push-ConnectionQualityStatsHelper", "Determine sampling switch error: " + th);
            }
        }
        return f12560a.booleanValue();
    }

    static void a(String str) {
        a("Push-ConnectionQualityStatsHelper", str);
    }
}
