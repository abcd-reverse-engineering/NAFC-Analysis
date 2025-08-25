package g.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeDelayOtherPublisher.java */
/* loaded from: classes2.dex */
public final class m<T, U> extends g.a.y0.e.c.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final i.d.b<U> f14841b;

    /* compiled from: MaybeDelayOtherPublisher.java */
    static final class a<T, U> implements g.a.v<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final b<T> f14842a;

        /* renamed from: b, reason: collision with root package name */
        final i.d.b<U> f14843b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f14844c;

        a(g.a.v<? super T> vVar, i.d.b<U> bVar) {
            this.f14842a = new b<>(vVar);
            this.f14843b = bVar;
        }

        void a() {
            this.f14843b.subscribe(this.f14842a);
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14844c.dispose();
            this.f14844c = g.a.y0.a.d.DISPOSED;
            g.a.y0.i.j.cancel(this.f14842a);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.i.j.isCancelled(this.f14842a.get());
        }

        @Override // g.a.v
        public void onComplete() {
            this.f14844c = g.a.y0.a.d.DISPOSED;
            a();
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.f14844c = g.a.y0.a.d.DISPOSED;
            this.f14842a.error = th;
            a();
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14844c, cVar)) {
                this.f14844c = cVar;
                this.f14842a.actual.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            this.f14844c = g.a.y0.a.d.DISPOSED;
            this.f14842a.value = t;
            a();
        }
    }

    /* compiled from: MaybeDelayOtherPublisher.java */
    static final class b<T> extends AtomicReference<i.d.d> implements g.a.q<Object> {
        private static final long serialVersionUID = -1215060610805418006L;
        final g.a.v<? super T> actual;
        Throwable error;
        T value;

        b(g.a.v<? super T> vVar) {
            this.actual = vVar;
        }

        @Override // i.d.c
        public void onComplete() {
            Throwable th = this.error;
            if (th != null) {
                this.actual.onError(th);
                return;
            }
            T t = this.value;
            if (t != null) {
                this.actual.onSuccess(t);
            } else {
                this.actual.onComplete();
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            Throwable th2 = this.error;
            if (th2 == null) {
                this.actual.onError(th);
            } else {
                this.actual.onError(new g.a.v0.a(th2, th));
            }
        }

        @Override // i.d.c
        public void onNext(Object obj) {
            i.d.d dVar = get();
            g.a.y0.i.j jVar = g.a.y0.i.j.CANCELLED;
            if (dVar != jVar) {
                lazySet(jVar);
                dVar.cancel();
                onComplete();
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.setOnce(this, dVar)) {
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    public m(g.a.y<T> yVar, i.d.b<U> bVar) {
        super(yVar);
        this.f14841b = bVar;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        this.f14742a.a(new a(vVar, this.f14841b));
    }
}
