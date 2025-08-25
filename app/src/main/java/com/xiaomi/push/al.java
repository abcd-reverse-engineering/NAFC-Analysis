package com.xiaomi.push;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
class al implements ai {

    /* renamed from: a, reason: collision with root package name */
    private Context f12439a;

    /* renamed from: a, reason: collision with other field name */
    private Class<?> f179a;

    /* renamed from: a, reason: collision with other field name */
    private Object f180a;

    /* renamed from: a, reason: collision with other field name */
    private Method f181a = null;

    /* renamed from: b, reason: collision with root package name */
    private Method f12440b = null;

    /* renamed from: c, reason: collision with root package name */
    private Method f12441c = null;

    /* renamed from: d, reason: collision with root package name */
    private Method f12442d = null;

    public al(Context context) {
        this.f12439a = context;
        a(context);
    }

    private void a(Context context) {
        try {
            this.f179a = C0343r.a(context, "com.android.id.impl.IdProviderImpl");
            this.f180a = this.f179a.newInstance();
            this.f12440b = this.f179a.getMethod("getOAID", Context.class);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a("miui load class error", e2);
        }
    }

    @Override // com.xiaomi.push.ai
    /* renamed from: a */
    public boolean mo137a() {
        return (this.f179a == null || this.f180a == null) ? false : true;
    }

    @Override // com.xiaomi.push.ai
    /* renamed from: a */
    public String mo136a() {
        return a(this.f12439a, this.f12440b);
    }

    private String a(Context context, Method method) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object obj = this.f180a;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(obj, context);
            if (objInvoke != null) {
                return (String) objInvoke;
            }
            return null;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a("miui invoke error", e2);
            return null;
        }
    }
}
