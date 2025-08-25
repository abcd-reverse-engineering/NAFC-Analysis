package h.q2.t;

import h.w2.n;

/* compiled from: PropertyReference0.java */
/* loaded from: classes2.dex */
public abstract class z0 extends f1 implements h.w2.n {
    public z0() {
    }

    @Override // h.q2.t.p
    protected h.w2.b computeReflected() {
        return h1.a(this);
    }

    @Override // h.w2.n
    @h.t0(version = "1.1")
    public Object getDelegate() {
        return ((h.w2.n) getReflected()).getDelegate();
    }

    @Override // h.q2.s.a
    public Object invoke() {
        return get();
    }

    @h.t0(version = "1.1")
    public z0(Object obj) {
        super(obj);
    }

    @Override // h.w2.m
    public n.a getGetter() {
        return ((h.w2.n) getReflected()).getGetter();
    }
}
