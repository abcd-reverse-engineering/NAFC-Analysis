package h.q2.t;

import h.w2.j;
import h.w2.o;

/* compiled from: MutablePropertyReference1.java */
/* loaded from: classes2.dex */
public abstract class s0 extends w0 implements h.w2.j {
    public s0() {
    }

    @Override // h.q2.t.p
    protected h.w2.b computeReflected() {
        return h1.a(this);
    }

    @Override // h.w2.o
    @h.t0(version = "1.1")
    public Object getDelegate(Object obj) {
        return ((h.w2.j) getReflected()).getDelegate(obj);
    }

    @Override // h.q2.s.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    @h.t0(version = "1.1")
    public s0(Object obj) {
        super(obj);
    }

    @Override // h.w2.m
    public o.a getGetter() {
        return ((h.w2.j) getReflected()).getGetter();
    }

    @Override // h.w2.h
    public j.a getSetter() {
        return ((h.w2.j) getReflected()).getSetter();
    }
}
