package h.x2;

import h.t0;
import h.y1;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: SequenceBuilder.kt */
@t0(version = "1.3")
@h.k2.j
/* loaded from: classes2.dex */
public abstract class o<T> {
    @i.c.a.e
    public final Object a(@i.c.a.d Iterable<? extends T> iterable, @i.c.a.d h.k2.d<? super y1> dVar) {
        Object objA;
        return (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) && (objA = a((Iterator) iterable.iterator(), dVar)) == h.k2.m.d.b()) ? objA : y1.f16671a;
    }

    @i.c.a.e
    public abstract Object a(T t, @i.c.a.d h.k2.d<? super y1> dVar);

    @i.c.a.e
    public abstract Object a(@i.c.a.d Iterator<? extends T> it, @i.c.a.d h.k2.d<? super y1> dVar);

    @i.c.a.e
    public final Object a(@i.c.a.d m<? extends T> mVar, @i.c.a.d h.k2.d<? super y1> dVar) {
        Object objA = a((Iterator) mVar.iterator(), dVar);
        return objA == h.k2.m.d.b() ? objA : y1.f16671a;
    }
}
