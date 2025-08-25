package com.luck.picture.lib.tools;

import a.a.u.a;

/* loaded from: classes.dex */
public class ValueOf {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T to(Object obj, T t) {
        return obj == 0 ? t : obj;
    }

    public static boolean toBoolean(Object obj) {
        return toBoolean(obj, false);
    }

    public static double toDouble(Object obj) {
        return toDouble(obj, 0);
    }

    public static float toFloat(Object obj, long j2) {
        if (obj == null) {
            return j2;
        }
        try {
            return Float.valueOf(obj.toString().trim()).floatValue();
        } catch (Exception unused) {
            return j2;
        }
    }

    public static int toInt(Object obj, int i2) {
        if (obj == null) {
            return i2;
        }
        try {
            String strTrim = obj.toString().trim();
            return strTrim.contains(".") ? Integer.valueOf(strTrim.substring(0, strTrim.lastIndexOf("."))).intValue() : Integer.valueOf(strTrim).intValue();
        } catch (Exception unused) {
            return i2;
        }
    }

    public static long toLong(Object obj, long j2) {
        if (obj == null) {
            return j2;
        }
        try {
            String strTrim = obj.toString().trim();
            return strTrim.contains(".") ? Long.valueOf(strTrim.substring(0, strTrim.lastIndexOf("."))).longValue() : Long.valueOf(strTrim).longValue();
        } catch (Exception unused) {
            return j2;
        }
    }

    public static String toString(Object obj) {
        try {
            return obj.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean toBoolean(Object obj, boolean z) {
        if (obj == null) {
            return false;
        }
        try {
            return !a.f1254k.equals(obj.toString().trim().trim());
        } catch (Exception unused) {
            return z;
        }
    }

    public static double toDouble(Object obj, int i2) {
        if (obj == null) {
            return i2;
        }
        try {
            return Double.valueOf(obj.toString().trim()).doubleValue();
        } catch (Exception unused) {
            return i2;
        }
    }

    public static float toFloat(Object obj) {
        return toFloat(obj, 0L);
    }

    public static int toInt(Object obj) {
        return toInt(obj, 0);
    }

    public static long toLong(Object obj) {
        return toLong(obj, 0L);
    }
}
