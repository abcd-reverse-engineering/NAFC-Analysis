package h.k2.l.p;

import h.q2.s.q;
import h.q2.t.i0;

/* compiled from: CoroutinesMigration.kt */
/* loaded from: classes2.dex */
final class j<T1, T2, R> implements q<T1, T2, h.k2.l.c<? super R>, Object> {

    /* renamed from: a, reason: collision with root package name */
    @i.c.a.d
    private final q<T1, T2, h.k2.d<? super R>, Object> f16297a;

    /* JADX WARN: Multi-variable type inference failed */
    public j(@i.c.a.d q<? super T1, ? super T2, ? super h.k2.d<? super R>, ? extends Object> qVar) {
        i0.f(qVar, "function");
        this.f16297a = qVar;
    }

    @i.c.a.d
    public final q<T1, T2, h.k2.d<? super R>, Object> a() {
        return this.f16297a;
    }

    @Override // h.q2.s.q
    @i.c.a.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object invoke(T1 t1, T2 t2, @i.c.a.d h.k2.l.c<? super R> cVar) {
        i0.f(cVar, "continuation");
        return this.f16297a.invoke(t1, t2, d.a(cVar));
    }
}
