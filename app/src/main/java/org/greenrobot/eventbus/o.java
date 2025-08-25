package org.greenrobot.eventbus;

import java.lang.reflect.Method;

/* compiled from: SubscriberMethod.java */
/* loaded from: classes2.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    final Method f17422a;

    /* renamed from: b, reason: collision with root package name */
    final ThreadMode f17423b;

    /* renamed from: c, reason: collision with root package name */
    final Class<?> f17424c;

    /* renamed from: d, reason: collision with root package name */
    final int f17425d;

    /* renamed from: e, reason: collision with root package name */
    final boolean f17426e;

    /* renamed from: f, reason: collision with root package name */
    String f17427f;

    public o(Method method, Class<?> cls, ThreadMode threadMode, int i2, boolean z) {
        this.f17422a = method;
        this.f17423b = threadMode;
        this.f17424c = cls;
        this.f17425d = i2;
        this.f17426e = z;
    }

    private synchronized void a() {
        if (this.f17427f == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f17422a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f17422a.getName());
            sb.append('(');
            sb.append(this.f17424c.getName());
            this.f17427f = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        a();
        o oVar = (o) obj;
        oVar.a();
        return this.f17427f.equals(oVar.f17427f);
    }

    public int hashCode() {
        return this.f17422a.hashCode();
    }
}
