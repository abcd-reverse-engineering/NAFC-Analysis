package h.q2.t;

import h.w2.i;
import h.w2.n;

/* compiled from: MutablePropertyReference0.java */
/* loaded from: classes2.dex */
public abstract class q0 extends w0 implements h.w2.i {
    public q0() {
    }

    @Override // h.q2.t.p
    protected h.w2.b computeReflected() {
        return h1.a(this);
    }

    @Override // h.w2.n
    @h.t0(version = "1.1")
    public Object getDelegate() {
        return ((h.w2.i) getReflected()).getDelegate();
    }

    @Override // h.q2.s.a
    public Object invoke() {
        return get();
    }

    @h.t0(version = "1.1")
    public q0(Object obj) {
        super(obj);
    }

    @Override // h.w2.m
    public n.a getGetter() {
        return ((h.w2.i) getReflected()).getGetter();
    }

    @Override // h.w2.h
    public i.a getSetter() {
        return ((h.w2.i) getReflected()).getSetter();
    }
}
