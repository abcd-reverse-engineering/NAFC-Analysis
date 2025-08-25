package com.umeng.analytics.pro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FieldMetaData.java */
/* loaded from: classes2.dex */
public class cc implements Serializable {

    /* renamed from: d, reason: collision with root package name */
    private static Map<Class<? extends bq>, Map<? extends bx, cc>> f10210d = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final String f10211a;

    /* renamed from: b, reason: collision with root package name */
    public final byte f10212b;

    /* renamed from: c, reason: collision with root package name */
    public final cd f10213c;

    public cc(String str, byte b2, cd cdVar) {
        this.f10211a = str;
        this.f10212b = b2;
        this.f10213c = cdVar;
    }

    public static void a(Class<? extends bq> cls, Map<? extends bx, cc> map) {
        f10210d.put(cls, map);
    }

    public static Map<? extends bx, cc> a(Class<? extends bq> cls) throws IllegalAccessException, InstantiationException {
        if (!f10210d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("IllegalAccessException for TBase class: " + cls.getName() + ", message: " + e2.getMessage());
            } catch (InstantiationException e3) {
                throw new RuntimeException("InstantiationException for TBase class: " + cls.getName() + ", message: " + e3.getMessage());
            }
        }
        return f10210d.get(cls);
    }
}
