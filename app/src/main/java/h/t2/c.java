package h.t2;

import h.q2.t.i0;
import h.w2.m;

/* compiled from: ObservableProperty.kt */
/* loaded from: classes2.dex */
public abstract class c<T> implements e<Object, T> {

    /* renamed from: a, reason: collision with root package name */
    private T f16491a;

    public c(T t) {
        this.f16491a = t;
    }

    @Override // h.t2.e
    public T a(@i.c.a.e Object obj, @i.c.a.d m<?> mVar) {
        i0.f(mVar, "property");
        return this.f16491a;
    }

    protected void a(@i.c.a.d m<?> mVar, T t, T t2) {
        i0.f(mVar, "property");
    }

    protected boolean b(@i.c.a.d m<?> mVar, T t, T t2) {
        i0.f(mVar, "property");
        return true;
    }

    @Override // h.t2.e
    public void a(@i.c.a.e Object obj, @i.c.a.d m<?> mVar, T t) {
        i0.f(mVar, "property");
        T t2 = this.f16491a;
        if (b(mVar, t2, t)) {
            this.f16491a = t;
            a(mVar, t2, t);
        }
    }
}
