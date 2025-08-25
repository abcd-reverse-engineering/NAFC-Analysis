package h.w2;

import h.e1;
import h.q2.t.i0;
import h.t0;

/* compiled from: KClasses.kt */
@h.q2.e(name = "KClasses")
/* loaded from: classes2.dex */
public final class d {
    /* JADX WARN: Multi-variable type inference failed */
    @h.j
    @t0(version = "1.3")
    @h.m2.g
    @i.c.a.d
    public static final <T> T a(@i.c.a.d c<T> cVar, @i.c.a.e Object obj) {
        i0.f(cVar, "$this$cast");
        if (cVar.a(obj)) {
            if (obj != 0) {
                return obj;
            }
            throw new e1("null cannot be cast to non-null type T");
        }
        throw new ClassCastException("Value cannot be cast to " + cVar.b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.j
    @t0(version = "1.3")
    @i.c.a.e
    @h.m2.g
    public static final <T> T b(@i.c.a.d c<T> cVar, @i.c.a.e Object obj) {
        i0.f(cVar, "$this$safeCast");
        if (!cVar.a(obj)) {
            return null;
        }
        if (obj != 0) {
            return obj;
        }
        throw new e1("null cannot be cast to non-null type T");
    }
}
