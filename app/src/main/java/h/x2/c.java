package h.x2;

import h.q2.t.i0;
import java.util.Iterator;

/* compiled from: Sequences.kt */
/* loaded from: classes2.dex */
public final class c<T, K> implements m<T> {

    /* renamed from: a, reason: collision with root package name */
    private final m<T> f16575a;

    /* renamed from: b, reason: collision with root package name */
    private final h.q2.s.l<T, K> f16576b;

    /* JADX WARN: Multi-variable type inference failed */
    public c(@i.c.a.d m<? extends T> mVar, @i.c.a.d h.q2.s.l<? super T, ? extends K> lVar) {
        i0.f(mVar, "source");
        i0.f(lVar, "keySelector");
        this.f16575a = mVar;
        this.f16576b = lVar;
    }

    @Override // h.x2.m
    @i.c.a.d
    public Iterator<T> iterator() {
        return new b(this.f16575a.iterator(), this.f16576b);
    }
}
