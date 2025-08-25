package h;

/* compiled from: AssertionsJVM.kt */
/* loaded from: classes2.dex */
class l0 {
    @h.m2.f
    private static final void a(boolean z) {
        if (e2.f16096a && !z) {
            throw new AssertionError("Assertion failed");
        }
    }

    @h.m2.f
    private static final void a(boolean z, h.q2.s.a<? extends Object> aVar) {
        if (e2.f16096a && !z) {
            throw new AssertionError(aVar.invoke());
        }
    }
}
