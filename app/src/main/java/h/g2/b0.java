package h.g2;

import java.util.Iterator;

/* compiled from: Iterators.kt */
/* loaded from: classes2.dex */
class b0 extends a0 {
    /* JADX WARN: Multi-variable type inference failed */
    @h.m2.f
    private static final <T> Iterator<T> a(@i.c.a.d Iterator<? extends T> it) {
        h.q2.t.i0.f(it, "$this$iterator");
        return it;
    }

    public static final <T> void a(@i.c.a.d Iterator<? extends T> it, @i.c.a.d h.q2.s.l<? super T, h.y1> lVar) {
        h.q2.t.i0.f(it, "$this$forEach");
        h.q2.t.i0.f(lVar, "operation");
        while (it.hasNext()) {
            lVar.invoke(it.next());
        }
    }

    @i.c.a.d
    public static final <T> Iterator<r0<T>> b(@i.c.a.d Iterator<? extends T> it) {
        h.q2.t.i0.f(it, "$this$withIndex");
        return new t0(it);
    }
}
