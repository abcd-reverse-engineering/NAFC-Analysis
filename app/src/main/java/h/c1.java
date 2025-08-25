package h;

import java.util.List;

/* compiled from: Tuples.kt */
@h.q2.e(name = "TuplesKt")
/* loaded from: classes2.dex */
public final class c1 {
    @i.c.a.d
    public static final <A, B> i0<A, B> a(A a2, B b2) {
        return new i0<>(a2, b2);
    }

    @i.c.a.d
    public static final <T> List<T> a(@i.c.a.d i0<? extends T, ? extends T> i0Var) {
        h.q2.t.i0.f(i0Var, "$this$toList");
        return h.g2.y.c(i0Var.getFirst(), i0Var.getSecond());
    }

    @i.c.a.d
    public static final <T> List<T> a(@i.c.a.d b1<? extends T, ? extends T, ? extends T> b1Var) {
        h.q2.t.i0.f(b1Var, "$this$toList");
        return h.g2.y.c(b1Var.getFirst(), b1Var.getSecond(), b1Var.getThird());
    }
}
