package g.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeDelaySubscriptionOtherPublisher.java */
/* loaded from: classes2.dex */
public final class n<T, U> extends g.a.y0.e.c.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final i.d.b<U> f14849b;

    /* compiled from: MaybeDelaySubscriptionOtherPublisher.java */
    static final class a<T> extends AtomicReference<g.a.u0.c> implements g.a.v<T> {
        private static final long serialVersionUID = 706635022205076709L;
        final g.a.v<? super T> actual;

        a(g.a.v<? super T> vVar) {
            this.actual = vVar;
        }

        @Override // g.a.v
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this, cVar);
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }
    }

    /* compiled from: MaybeDelaySubscriptionOtherPublisher.java */
    static final class b<T> implements g.a.q<Object>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final a<T> f14850a;

        /* renamed from: b, reason: collision with root package name */
        g.a.y<T> f14851b;

        /* renamed from: c, reason: collision with root package name */
        i.d.d f14852c;

        b(g.a.v<? super T> vVar, g.a.y<T> yVar) {
            this.f14850a = new a<>(vVar);
            this.f14851b = yVar;
        }

        void a() {
            g.a.y<T> yVar = this.f14851b;
            this.f14851b = null;
            yVar.a(this.f14850a);
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14852c.cancel();
            this.f14852c = g.a.y0.i.j.CANCELLED;
            g.a.y0.a.d.dispose(this.f14850a);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(this.f14850a.get());
        }

        @Override // i.d.c
        public void onComplete() {
            i.d.d dVar = this.f14852c;
            g.a.y0.i.j jVar = g.a.y0.i.j.CANCELLED;
            if (dVar != jVar) {
                this.f14852c = jVar;
                a();
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            i.d.d dVar = this.f14852c;
            g.a.y0.i.j jVar = g.a.y0.i.j.CANCELLED;
            if (dVar == jVar) {
                g.a.c1.a.b(th);
            } else {
                this.f14852c = jVar;
                this.f14850a.actual.onError(th);
            }
        }

        @Override // i.d.c
        public void onNext(Object obj) {
            i.d.d dVar = this.f14852c;
            if (dVar != g.a.y0.i.j.CANCELLED) {
                dVar.cancel();
                this.f14852c = g.a.y0.i.j.CANCELLED;
                a();
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14852c, dVar)) {
                this.f14852c = dVar;
                this.f14850a.actual.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    public n(g.a.y<T> yVar, i.d.b<U> bVar) {
        super(yVar);
        this.f14849b = bVar;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        this.f14849b.subscribe(new b(vVar, this.f14742a));
    }
}
