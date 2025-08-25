package h.k2.l.p;

import h.q2.s.p;
import h.q2.t.i0;

/* compiled from: CoroutinesMigration.kt */
/* loaded from: classes2.dex */
final class i<T1, R> implements p<T1, h.k2.l.c<? super R>, Object> {

    /* renamed from: a, reason: collision with root package name */
    @i.c.a.d
    private final p<T1, h.k2.d<? super R>, Object> f16296a;

    /* JADX WARN: Multi-variable type inference failed */
    public i(@i.c.a.d p<? super T1, ? super h.k2.d<? super R>, ? extends Object> pVar) {
        i0.f(pVar, "function");
        this.f16296a = pVar;
    }

    @i.c.a.d
    public final p<T1, h.k2.d<? super R>, Object> a() {
        return this.f16296a;
    }

    @Override // h.q2.s.p
    @i.c.a.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object invoke(T1 t1, @i.c.a.d h.k2.l.c<? super R> cVar) {
        i0.f(cVar, "continuation");
        return this.f16296a.invoke(t1, d.a(cVar));
    }
}
