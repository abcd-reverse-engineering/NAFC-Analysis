package g.a.y0.e.c;

import java.util.Iterator;

/* compiled from: MaybeFlatMapIterableObservable.java */
/* loaded from: classes2.dex */
public final class c0<T, R> extends g.a.b0<R> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.y<T> f14769a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends Iterable<? extends R>> f14770b;

    /* compiled from: MaybeFlatMapIterableObservable.java */
    static final class a<T, R> extends g.a.y0.d.c<R> implements g.a.v<T> {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super R> f14771a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.o<? super T, ? extends Iterable<? extends R>> f14772b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f14773c;

        /* renamed from: d, reason: collision with root package name */
        volatile Iterator<? extends R> f14774d;

        /* renamed from: e, reason: collision with root package name */
        volatile boolean f14775e;

        /* renamed from: f, reason: collision with root package name */
        boolean f14776f;

        a(g.a.i0<? super R> i0Var, g.a.x0.o<? super T, ? extends Iterable<? extends R>> oVar) {
            this.f14771a = i0Var;
            this.f14772b = oVar;
        }

        @Override // g.a.y0.c.o
        public void clear() {
            this.f14774d = null;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14775e = true;
            this.f14773c.dispose();
            this.f14773c = g.a.y0.a.d.DISPOSED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14775e;
        }

        @Override // g.a.y0.c.o
        public boolean isEmpty() {
            return this.f14774d == null;
        }

        @Override // g.a.v
        public void onComplete() {
            this.f14771a.onComplete();
        }

        @Override // g.a.v
        public void onError(Throwable th) {
            this.f14773c = g.a.y0.a.d.DISPOSED;
            this.f14771a.onError(th);
        }

        @Override // g.a.v
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14773c, cVar)) {
                this.f14773c = cVar;
                this.f14771a.onSubscribe(this);
            }
        }

        @Override // g.a.v, g.a.n0
        public void onSuccess(T t) {
            g.a.i0<? super R> i0Var = this.f14771a;
            try {
                Iterator<? extends R> it = this.f14772b.apply(t).iterator();
                if (!it.hasNext()) {
                    i0Var.onComplete();
                    return;
                }
                this.f14774d = it;
                if (this.f14776f) {
                    i0Var.onNext(null);
                    i0Var.onComplete();
                    return;
                }
                while (!this.f14775e) {
                    try {
                        i0Var.onNext(it.next());
                        if (this.f14775e) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                i0Var.onComplete();
                                return;
                            }
                        } catch (Throwable th) {
                            g.a.v0.b.b(th);
                            i0Var.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        g.a.v0.b.b(th2);
                        i0Var.onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                g.a.v0.b.b(th3);
                i0Var.onError(th3);
            }
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public R poll() throws Exception {
            Iterator<? extends R> it = this.f14774d;
            if (it == null) {
                return null;
            }
            R r = (R) g.a.y0.b.b.a(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f14774d = null;
            }
            return r;
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.f14776f = true;
            return 2;
        }
    }

    public c0(g.a.y<T> yVar, g.a.x0.o<? super T, ? extends Iterable<? extends R>> oVar) {
        this.f14769a = yVar;
        this.f14770b = oVar;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super R> i0Var) {
        this.f14769a.a(new a(i0Var, this.f14770b));
    }
}
