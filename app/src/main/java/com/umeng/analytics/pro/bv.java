package com.umeng.analytics.pro;

import java.lang.reflect.InvocationTargetException;

/* compiled from: TEnumHelper.java */
/* loaded from: classes2.dex */
public class bv {
    public static bu a(Class<? extends bu> cls, int i2) {
        try {
            return (bu) cls.getMethod("findByValue", Integer.TYPE).invoke(null, Integer.valueOf(i2));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }
}
