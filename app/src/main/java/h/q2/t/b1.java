package h.q2.t;

import h.w2.o;

/* compiled from: PropertyReference1.java */
/* loaded from: classes2.dex */
public abstract class b1 extends f1 implements h.w2.o {
    public b1() {
    }

    @Override // h.q2.t.p
    protected h.w2.b computeReflected() {
        return h1.a(this);
    }

    @Override // h.w2.o
    @h.t0(version = "1.1")
    public Object getDelegate(Object obj) {
        return ((h.w2.o) getReflected()).getDelegate(obj);
    }

    @Override // h.q2.s.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    @h.t0(version = "1.1")
    public b1(Object obj) {
        super(obj);
    }

    @Override // h.w2.m
    public o.a getGetter() {
        return ((h.w2.o) getReflected()).getGetter();
    }
}
