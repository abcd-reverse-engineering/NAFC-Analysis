package h.k2;

import h.k2.g;
import h.q2.t.i0;
import h.t0;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes2.dex */
public final class h {
    /* JADX WARN: Multi-variable type inference failed */
    @t0(version = "1.3")
    @h.j
    @i.c.a.e
    public static final <E extends g.b> E a(@i.c.a.d g.b bVar, @i.c.a.d g.c<E> cVar) {
        i0.f(bVar, "$this$getPolymorphicElement");
        i0.f(cVar, "key");
        if (!(cVar instanceof b)) {
            if (bVar.getKey() == cVar) {
                return bVar;
            }
            return null;
        }
        b bVar2 = (b) cVar;
        if (!bVar2.a(bVar.getKey())) {
            return null;
        }
        E e2 = (E) bVar2.a(bVar);
        if (e2 instanceof g.b) {
            return e2;
        }
        return null;
    }

    @t0(version = "1.3")
    @h.j
    @i.c.a.d
    public static final g b(@i.c.a.d g.b bVar, @i.c.a.d g.c<?> cVar) {
        i0.f(bVar, "$this$minusPolymorphicKey");
        i0.f(cVar, "key");
        if (!(cVar instanceof b)) {
            return bVar.getKey() == cVar ? i.INSTANCE : bVar;
        }
        b bVar2 = (b) cVar;
        return (!bVar2.a(bVar.getKey()) || bVar2.a(bVar) == null) ? bVar : i.INSTANCE;
    }
}
