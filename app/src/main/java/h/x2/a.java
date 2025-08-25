package h.x2;

import h.q2.t.i0;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SequencesJVM.kt */
/* loaded from: classes2.dex */
public final class a<T> implements m<T> {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<m<T>> f16571a;

    public a(@i.c.a.d m<? extends T> mVar) {
        i0.f(mVar, "sequence");
        this.f16571a = new AtomicReference<>(mVar);
    }

    @Override // h.x2.m
    @i.c.a.d
    public Iterator<T> iterator() {
        m<T> andSet = this.f16571a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
