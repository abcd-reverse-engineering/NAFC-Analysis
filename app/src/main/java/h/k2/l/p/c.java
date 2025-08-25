package h.k2.l.p;

import h.q0;
import h.q2.t.i0;

/* compiled from: CoroutinesMigration.kt */
/* loaded from: classes2.dex */
final class c<T> implements h.k2.d<T> {

    /* renamed from: a, reason: collision with root package name */
    @i.c.a.d
    private final h.k2.g f16288a;

    /* renamed from: b, reason: collision with root package name */
    @i.c.a.d
    private final h.k2.l.c<T> f16289b;

    /* JADX WARN: Multi-variable type inference failed */
    public c(@i.c.a.d h.k2.l.c<? super T> cVar) {
        i0.f(cVar, "continuation");
        this.f16289b = cVar;
        this.f16288a = d.a(this.f16289b.getContext());
    }

    @i.c.a.d
    public final h.k2.l.c<T> a() {
        return this.f16289b;
    }

    @Override // h.k2.d
    @i.c.a.d
    public h.k2.g getContext() {
        return this.f16288a;
    }

    @Override // h.k2.d
    public void resumeWith(@i.c.a.d Object obj) {
        if (q0.m778isSuccessimpl(obj)) {
            this.f16289b.resume(obj);
        }
        Throwable thM775exceptionOrNullimpl = q0.m775exceptionOrNullimpl(obj);
        if (thM775exceptionOrNullimpl != null) {
            this.f16289b.resumeWithException(thM775exceptionOrNullimpl);
        }
    }
}
