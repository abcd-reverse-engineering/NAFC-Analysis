package h;

/* compiled from: Standard.kt */
/* loaded from: classes2.dex */
class v0 {
    @h.m2.f
    private static final Void a() {
        throw new a0(null, 1, 0 == true ? 1 : 0);
    }

    @h.m2.f
    private static final <T> T b(T t, h.q2.s.l<? super T, y1> lVar) {
        lVar.invoke(t);
        return t;
    }

    @h.m2.f
    private static final <T, R> R c(T t, h.q2.s.l<? super T, ? extends R> lVar) {
        return lVar.invoke(t);
    }

    @h.m2.f
    private static final <T, R> R d(T t, h.q2.s.l<? super T, ? extends R> lVar) {
        return lVar.invoke(t);
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final <T> T e(T t, h.q2.s.l<? super T, Boolean> lVar) {
        if (lVar.invoke(t).booleanValue()) {
            return t;
        }
        return null;
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final <T> T f(T t, h.q2.s.l<? super T, Boolean> lVar) {
        if (lVar.invoke(t).booleanValue()) {
            return null;
        }
        return t;
    }

    @h.m2.f
    private static final <T, R> R g(T t, h.q2.s.l<? super T, ? extends R> lVar) {
        return lVar.invoke(t);
    }

    @h.m2.f
    private static final Void a(String str) {
        throw new a0("An operation is not implemented: " + str);
    }

    @h.m2.f
    private static final <R> R a(h.q2.s.a<? extends R> aVar) {
        return aVar.invoke();
    }

    @h.m2.f
    @t0(version = "1.1")
    private static final <T> T a(T t, h.q2.s.l<? super T, y1> lVar) {
        lVar.invoke(t);
        return t;
    }

    @h.m2.f
    private static final void a(int i2, h.q2.s.l<? super Integer, y1> lVar) {
        for (int i3 = 0; i3 < i2; i3++) {
            lVar.invoke(Integer.valueOf(i3));
        }
    }
}
