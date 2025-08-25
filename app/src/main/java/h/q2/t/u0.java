package h.q2.t;

import h.w2.k;
import h.w2.p;

/* compiled from: MutablePropertyReference2.java */
/* loaded from: classes2.dex */
public abstract class u0 extends w0 implements h.w2.k {
    @Override // h.q2.t.p
    protected h.w2.b computeReflected() {
        return h1.a(this);
    }

    @Override // h.w2.p
    @h.t0(version = "1.1")
    public Object getDelegate(Object obj, Object obj2) {
        return ((h.w2.k) getReflected()).getDelegate(obj, obj2);
    }

    @Override // h.q2.s.p
    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    @Override // h.w2.m
    public p.a getGetter() {
        return ((h.w2.k) getReflected()).getGetter();
    }

    @Override // h.w2.h
    public k.a getSetter() {
        return ((h.w2.k) getReflected()).getSetter();
    }
}
