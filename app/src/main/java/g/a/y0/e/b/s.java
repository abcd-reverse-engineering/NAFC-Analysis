package g.a.y0.e.b;

import java.util.concurrent.Callable;

/* compiled from: FlowableCollect.java */
/* loaded from: classes2.dex */
public final class s<T, U> extends g.a.y0.e.b.a<T, U> {

    /* renamed from: c, reason: collision with root package name */
    final Callable<? extends U> f14585c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.x0.b<? super U, ? super T> f14586d;

    /* compiled from: FlowableCollect.java */
    static final class a<T, U> extends g.a.y0.i.f<U> implements g.a.q<T> {
        private static final long serialVersionUID = -3589550218733891694L;
        final g.a.x0.b<? super U, ? super T> collector;
        boolean done;
        i.d.d s;
        final U u;

        a(i.d.c<? super U> cVar, U u, g.a.x0.b<? super U, ? super T> bVar) {
            super(cVar);
            this.collector = bVar;
            this.u = u;
        }

        @Override // g.a.y0.i.f, i.d.d
        public void cancel() {
            super.cancel();
            this.s.cancel();
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            complete(this.u);
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.done) {
                g.a.c1.a.b(th);
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                this.collector.a(this.u, t);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.s.cancel();
                onError(th);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    public s(g.a.l<T> lVar, Callable<? extends U> callable, g.a.x0.b<? super U, ? super T> bVar) {
        super(lVar);
        this.f14585c = callable;
        this.f14586d = bVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super U> cVar) {
        try {
            this.f14110b.a((g.a.q) new a(cVar, g.a.y0.b.b.a(this.f14585c.call(), "The initial value supplied is null"), this.f14586d));
        } catch (Throwable th) {
            g.a.y0.i.g.error(th, cVar);
        }
    }
}
