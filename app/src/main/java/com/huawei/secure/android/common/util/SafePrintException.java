package com.huawei.secure.android.common.util;

import android.text.TextUtils;

/* loaded from: classes.dex */
public abstract class SafePrintException {
    private static boolean a(String str) {
        for (String str2 : new String[]{"java.io.FileNotFoundException", "java.util.jar.JarException", "java.util.MissingResourceException", "java.security.acl.NotOwnerException", "java.util.ConcurrentModificationException", "javax.naming.InsufficientResourcesException", "java.net.BindException", "java.lang.OutOfMemoryError", "java.lang.StackOverflowError", "java.sql.SQLException"}) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public static String getStackTrace(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append(c.c.a.b.a.a.f3100g);
        }
        sb.append("Exception: ");
        sb.append(th.getClass().getName());
        sb.append('\n');
        if (!a(th.getClass().getCanonicalName())) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace == null) {
                sb.append("Stack trace is NULL!");
                sb.append('\n');
            } else {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb.append(stackTraceElement.toString());
                    sb.append('\n');
                }
            }
        }
        return sb.toString();
    }

    public static void print(String str, String str2, Throwable th) {
        if (th == null) {
            return;
        }
        getStackTrace(str2, th);
    }
}
