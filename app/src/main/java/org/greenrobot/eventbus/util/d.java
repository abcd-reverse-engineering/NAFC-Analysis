package org.greenrobot.eventbus.util;

import java.util.HashMap;
import java.util.Map;

/* compiled from: ExceptionToResourceMapping.java */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final Map<Class<? extends Throwable>, Integer> f17495a = new HashMap();

    public Integer a(Throwable th) {
        Throwable cause = th;
        int i2 = 20;
        do {
            Integer numB = b(cause);
            if (numB != null) {
                return numB;
            }
            cause = cause.getCause();
            i2--;
            if (i2 <= 0 || cause == th) {
                break;
            }
        } while (cause != null);
        String str = "No specific message resource ID found for " + th;
        return null;
    }

    protected Integer b(Throwable th) {
        Class<?> cls = th.getClass();
        Integer value = this.f17495a.get(cls);
        if (value == null) {
            Class<? extends Throwable> cls2 = null;
            for (Map.Entry<Class<? extends Throwable>, Integer> entry : this.f17495a.entrySet()) {
                Class<? extends Throwable> key = entry.getKey();
                if (key.isAssignableFrom(cls) && (cls2 == null || cls2.isAssignableFrom(key))) {
                    value = entry.getValue();
                    cls2 = key;
                }
            }
        }
        return value;
    }

    public d a(Class<? extends Throwable> cls, int i2) {
        this.f17495a.put(cls, Integer.valueOf(i2));
        return this;
    }
}
