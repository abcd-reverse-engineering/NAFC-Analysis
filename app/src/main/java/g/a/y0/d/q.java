package g.a.y0.d;

import g.a.i0;

/* compiled from: FullArbiterObserver.java */
/* loaded from: classes2.dex */
public final class q<T> implements i0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.y0.a.j<T> f13961a;

    /* renamed from: b, reason: collision with root package name */
    g.a.u0.c f13962b;

    public q(g.a.y0.a.j<T> jVar) {
        this.f13961a = jVar;
    }

    @Override // g.a.i0
    public void onComplete() {
        this.f13961a.a(this.f13962b);
    }

    @Override // g.a.i0
    public void onError(Throwable th) {
        this.f13961a.a(th, this.f13962b);
    }

    @Override // g.a.i0
    public void onNext(T t) {
        this.f13961a.a((g.a.y0.a.j<T>) t, this.f13962b);
    }

    @Override // g.a.i0
    public void onSubscribe(g.a.u0.c cVar) {
        if (g.a.y0.a.d.validate(this.f13962b, cVar)) {
            this.f13962b = cVar;
            this.f13961a.b(cVar);
        }
    }
}
