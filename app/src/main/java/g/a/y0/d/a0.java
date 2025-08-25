package g.a.y0.d;

import g.a.n0;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ResumeSingleObserver.java */
/* loaded from: classes2.dex */
public final class a0<T> implements n0<T> {

    /* renamed from: a, reason: collision with root package name */
    final AtomicReference<g.a.u0.c> f13945a;

    /* renamed from: b, reason: collision with root package name */
    final n0<? super T> f13946b;

    public a0(AtomicReference<g.a.u0.c> atomicReference, n0<? super T> n0Var) {
        this.f13945a = atomicReference;
        this.f13946b = n0Var;
    }

    @Override // g.a.n0
    public void onError(Throwable th) {
        this.f13946b.onError(th);
    }

    @Override // g.a.n0
    public void onSubscribe(g.a.u0.c cVar) {
        g.a.y0.a.d.replace(this.f13945a, cVar);
    }

    @Override // g.a.n0
    public void onSuccess(T t) {
        this.f13946b.onSuccess(t);
    }
}
