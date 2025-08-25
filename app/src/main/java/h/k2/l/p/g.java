package h.k2.l.p;

import h.q0;
import h.q2.t.i0;
import h.r0;

/* compiled from: CoroutinesMigration.kt */
/* loaded from: classes2.dex */
final class g<T> implements h.k2.l.c<T> {

    /* renamed from: a, reason: collision with root package name */
    @i.c.a.d
    private final h.k2.l.e f16293a;

    /* renamed from: b, reason: collision with root package name */
    @i.c.a.d
    private final h.k2.d<T> f16294b;

    /* JADX WARN: Multi-variable type inference failed */
    public g(@i.c.a.d h.k2.d<? super T> dVar) {
        i0.f(dVar, "continuation");
        this.f16294b = dVar;
        this.f16293a = d.a(this.f16294b.getContext());
    }

    @i.c.a.d
    public final h.k2.d<T> a() {
        return this.f16294b;
    }

    @Override // h.k2.l.c
    @i.c.a.d
    public h.k2.l.e getContext() {
        return this.f16293a;
    }

    @Override // h.k2.l.c
    public void resume(T t) {
        h.k2.d<T> dVar = this.f16294b;
        q0.a aVar = q0.Companion;
        dVar.resumeWith(q0.m772constructorimpl(t));
    }

    @Override // h.k2.l.c
    public void resumeWithException(@i.c.a.d Throwable th) {
        i0.f(th, "exception");
        h.k2.d<T> dVar = this.f16294b;
        q0.a aVar = q0.Companion;
        dVar.resumeWith(q0.m772constructorimpl(r0.a(th)));
    }
}
