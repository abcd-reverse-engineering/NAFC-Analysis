package com.hihonor.push.sdk;

/* loaded from: classes.dex */
public class c {
    public static void a(String str) {
        String strSubstring;
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i2 = 2;
        while (true) {
            if (i2 >= stackTrace.length) {
                strSubstring = "";
                break;
            } else {
                if (!stackTrace[i2].getClass().equals(c.class)) {
                    String className = stackTrace[i2].getClassName();
                    strSubstring = className.substring(className.lastIndexOf(46) + 1);
                    break;
                }
                i2++;
            }
        }
        a("HonorPush_" + strSubstring, str, null);
    }

    public static void a(String str, String str2, Throwable th) {
        if (str2.length() > 4000) {
            int i2 = 0;
            while (i2 < str2.length()) {
                int i3 = i2 + 4000;
                if (str2.length() > i3) {
                    str2.substring(i2, i3);
                } else {
                    str2.substring(i2);
                }
                i2 = i3;
            }
        }
    }
}
