package h;

/* compiled from: Preconditions.kt */
/* loaded from: classes2.dex */
class m0 extends l0 {
    @h.m2.f
    private static final void a(boolean z) {
        if (!z) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    @h.m2.f
    private static final void b(boolean z) {
        if (!z) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    @h.m2.f
    private static final <T> T c(T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @h.m2.f
    private static final void a(boolean z, h.q2.s.a<? extends Object> aVar) {
        if (!z) {
            throw new IllegalStateException(aVar.invoke().toString());
        }
    }

    @h.m2.f
    private static final void b(boolean z, h.q2.s.a<? extends Object> aVar) {
        if (!z) {
            throw new IllegalArgumentException(aVar.invoke().toString());
        }
    }

    @h.m2.f
    private static final <T> T a(T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @h.m2.f
    private static final <T> T b(T t, h.q2.s.a<? extends Object> aVar) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(aVar.invoke().toString());
    }

    @h.m2.f
    private static final <T> T a(T t, h.q2.s.a<? extends Object> aVar) {
        if (t != null) {
            return t;
        }
        throw new IllegalStateException(aVar.invoke().toString());
    }

    @h.m2.f
    private static final Void b(Object obj) {
        throw new IllegalStateException(obj.toString());
    }
}
