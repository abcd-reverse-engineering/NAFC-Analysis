package h;

/* compiled from: Synchronized.kt */
/* loaded from: classes2.dex */
class w0 extends v0 {
    @h.m2.f
    private static final <R> R a(Object obj, h.q2.s.a<? extends R> aVar) {
        R rInvoke;
        synchronized (obj) {
            try {
                rInvoke = aVar.invoke();
                h.q2.t.f0.b(1);
            } catch (Throwable th) {
                h.q2.t.f0.b(1);
                h.q2.t.f0.a(1);
                throw th;
            }
        }
        h.q2.t.f0.a(1);
        return rInvoke;
    }
}
