package h.k2.l.o.a;

import h.k2.l.c;
import h.q2.e;
import h.q2.t.i0;
import i.c.a.d;

/* compiled from: CoroutineIntrinsics.kt */
@e(name = "CoroutineIntrinsics")
/* loaded from: classes2.dex */
public final class b {
    /* JADX WARN: Multi-variable type inference failed */
    @d
    public static final <T> c<T> a(@d c<? super T> cVar) {
        c<T> cVar2;
        i0.f(cVar, "continuation");
        a aVar = !(cVar instanceof a) ? null : cVar;
        return (aVar == null || (cVar2 = (c<T>) aVar.getFacade()) == null) ? cVar : cVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @d
    public static final <T> c<T> a(@d h.k2.l.e eVar, @d c<? super T> cVar) {
        c<T> cVarA;
        i0.f(eVar, com.umeng.analytics.pro.d.R);
        i0.f(cVar, "continuation");
        h.k2.l.d dVar = (h.k2.l.d) eVar.a(h.k2.l.d.f16255a);
        return (dVar == null || (cVarA = dVar.a(cVar)) == null) ? cVar : cVarA;
    }
}
