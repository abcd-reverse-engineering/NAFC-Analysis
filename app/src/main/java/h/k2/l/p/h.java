package h.k2.l.p;

import h.q2.s.l;
import h.q2.t.i0;

/* compiled from: CoroutinesMigration.kt */
/* loaded from: classes2.dex */
final class h<R> implements l<h.k2.l.c<? super R>, Object> {

    /* renamed from: a, reason: collision with root package name */
    @i.c.a.d
    private final l<h.k2.d<? super R>, Object> f16295a;

    /* JADX WARN: Multi-variable type inference failed */
    public h(@i.c.a.d l<? super h.k2.d<? super R>, ? extends Object> lVar) {
        i0.f(lVar, "function");
        this.f16295a = lVar;
    }

    @i.c.a.d
    public final l<h.k2.d<? super R>, Object> a() {
        return this.f16295a;
    }

    @Override // h.q2.s.l
    @i.c.a.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object invoke(@i.c.a.d h.k2.l.c<? super R> cVar) {
        i0.f(cVar, "continuation");
        return this.f16295a.invoke(d.a(cVar));
    }
}
