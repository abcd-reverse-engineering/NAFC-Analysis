package com.vivo.push.cache;

import android.content.Context;
import com.vivo.push.util.u;
import java.lang.reflect.Method;

/* compiled from: ConfigManagerFactory.java */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f11990a;

    /* renamed from: b, reason: collision with root package name */
    private d f11991b;

    private b() {
    }

    public static synchronized b a() {
        if (f11990a == null) {
            f11990a = new b();
        }
        return f11990a;
    }

    public final d a(Context context) throws NoSuchMethodException, SecurityException {
        d dVar = this.f11991b;
        if (dVar != null) {
            return dVar;
        }
        try {
            Method method = Class.forName("com.vivo.push.cache.ClientConfigManagerImpl").getMethod("getInstance", Context.class);
            u.d("ConfigManagerFactory", "createConfig success is ".concat("com.vivo.push.cache.ClientConfigManagerImpl"));
            this.f11991b = (d) method.invoke(null, context);
            return this.f11991b;
        } catch (Exception e2) {
            e2.printStackTrace();
            u.b("ConfigManagerFactory", "createConfig error", e2);
            return null;
        }
    }
}
