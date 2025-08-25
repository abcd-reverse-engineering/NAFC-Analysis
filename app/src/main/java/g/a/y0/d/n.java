package g.a.y0.d;

import g.a.i0;

/* compiled from: DisposableLambdaObserver.java */
/* loaded from: classes2.dex */
public final class n<T> implements i0<T>, g.a.u0.c {

    /* renamed from: a, reason: collision with root package name */
    final i0<? super T> f13957a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.g<? super g.a.u0.c> f13958b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.a f13959c;

    /* renamed from: d, reason: collision with root package name */
    g.a.u0.c f13960d;

    public n(i0<? super T> i0Var, g.a.x0.g<? super g.a.u0.c> gVar, g.a.x0.a aVar) {
        this.f13957a = i0Var;
        this.f13958b = gVar;
        this.f13959c = aVar;
    }

    @Override // g.a.u0.c
    public void dispose() {
        try {
            this.f13959c.run();
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.c1.a.b(th);
        }
        this.f13960d.dispose();
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return this.f13960d.isDisposed();
    }

    @Override // g.a.i0
    public void onComplete() {
        if (this.f13960d != g.a.y0.a.d.DISPOSED) {
            this.f13957a.onComplete();
        }
    }

    @Override // g.a.i0
    public void onError(Throwable th) {
        if (this.f13960d != g.a.y0.a.d.DISPOSED) {
            this.f13957a.onError(th);
        } else {
            g.a.c1.a.b(th);
        }
    }

    @Override // g.a.i0
    public void onNext(T t) {
        this.f13957a.onNext(t);
    }

    @Override // g.a.i0
    public void onSubscribe(g.a.u0.c cVar) {
        try {
            this.f13958b.accept(cVar);
            if (g.a.y0.a.d.validate(this.f13960d, cVar)) {
                this.f13960d = cVar;
                this.f13957a.onSubscribe(this);
            }
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            cVar.dispose();
            this.f13960d = g.a.y0.a.d.DISPOSED;
            g.a.y0.a.e.error(th, this.f13957a);
        }
    }
}
