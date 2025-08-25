package h.k2;

import h.k2.g;
import h.k2.g.b;
import h.q2.s.l;
import h.q2.t.i0;
import h.t0;

/* compiled from: CoroutineContextImpl.kt */
@t0(version = "1.3")
@h.j
/* loaded from: classes2.dex */
public abstract class b<B extends g.b, E extends B> implements g.c<E> {

    /* renamed from: a, reason: collision with root package name */
    private final g.c<?> f16243a;

    /* renamed from: b, reason: collision with root package name */
    private final l<g.b, E> f16244b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [h.k2.g$c<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [h.q2.s.l<? super h.k2.g$b, ? extends E extends B>, h.q2.s.l<h.k2.g$b, E extends B>, java.lang.Object] */
    public b(@i.c.a.d g.c<B> cVar, @i.c.a.d l<? super g.b, ? extends E> lVar) {
        i0.f(cVar, "baseKey");
        i0.f(lVar, "safeCast");
        this.f16244b = lVar;
        this.f16243a = cVar instanceof b ? (g.c<B>) ((b) cVar).f16243a : cVar;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lh/k2/g$b;)TE; */
    @i.c.a.e
    public final g.b a(@i.c.a.d g.b bVar) {
        i0.f(bVar, "element");
        return (g.b) this.f16244b.invoke(bVar);
    }

    public final boolean a(@i.c.a.d g.c<?> cVar) {
        i0.f(cVar, "key");
        return cVar == this || this.f16243a == cVar;
    }
}
