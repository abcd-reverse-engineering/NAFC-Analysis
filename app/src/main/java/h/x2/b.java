package h.x2;

import h.q2.t.i0;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: Sequences.kt */
/* loaded from: classes2.dex */
final class b<T, K> extends h.g2.c<T> {

    /* renamed from: c, reason: collision with root package name */
    private final HashSet<K> f16572c;

    /* renamed from: d, reason: collision with root package name */
    private final Iterator<T> f16573d;

    /* renamed from: e, reason: collision with root package name */
    private final h.q2.s.l<T, K> f16574e;

    /* JADX WARN: Multi-variable type inference failed */
    public b(@i.c.a.d Iterator<? extends T> it, @i.c.a.d h.q2.s.l<? super T, ? extends K> lVar) {
        i0.f(it, "source");
        i0.f(lVar, "keySelector");
        this.f16573d = it;
        this.f16574e = lVar;
        this.f16572c = new HashSet<>();
    }

    @Override // h.g2.c
    protected void b() {
        while (this.f16573d.hasNext()) {
            T next = this.f16573d.next();
            if (this.f16572c.add(this.f16574e.invoke(next))) {
                b(next);
                return;
            }
        }
        c();
    }
}
