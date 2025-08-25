package com.just.agentweb;

import c.c.a.b.a.a;

/* loaded from: classes.dex */
class LogUtils {
    private static final String PREFIX = "agentweb-";

    LogUtils() {
    }

    static void e(String str, String str2) {
        if (isDebug()) {
            PREFIX.concat(str);
        }
    }

    static void e(String str, String str2, Throwable th) {
    }

    static void i(String str, String str2) {
        if (isDebug()) {
            PREFIX.concat(str);
        }
    }

    static boolean isDebug() {
        return AgentWebConfig.DEBUG;
    }

    static void safeCheckCrash(String str, String str2, Throwable th) {
        if (!isDebug()) {
            PREFIX.concat(str);
            return;
        }
        throw new RuntimeException(PREFIX.concat(str) + a.f3100g + str2, th);
    }

    static void v(String str, String str2) {
        if (isDebug()) {
            PREFIX.concat(str);
        }
    }
}
