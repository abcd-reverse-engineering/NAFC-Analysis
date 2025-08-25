package h.g2;

import java.util.Iterator;

/* compiled from: Iterables.kt */
/* loaded from: classes2.dex */
public final class s0<T> implements Iterable<r0<? extends T>>, h.q2.t.q1.a {

    /* renamed from: a, reason: collision with root package name */
    private final h.q2.s.a<Iterator<T>> f16194a;

    /* JADX WARN: Multi-variable type inference failed */
    public s0(@i.c.a.d h.q2.s.a<? extends Iterator<? extends T>> aVar) {
        h.q2.t.i0.f(aVar, "iteratorFactory");
        this.f16194a = aVar;
    }

    @Override // java.lang.Iterable
    @i.c.a.d
    public Iterator<r0<T>> iterator() {
        return new t0(this.f16194a.invoke());
    }
}
