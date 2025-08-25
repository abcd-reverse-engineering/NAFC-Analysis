package g.a.y0.e.f;

import java.util.NoSuchElementException;

/* compiled from: SingleFromPublisher.java */
/* loaded from: classes2.dex */
public final class b0<T> extends g.a.k0<T> {

    /* renamed from: a, reason: collision with root package name */
    final i.d.b<? extends T> f15734a;

    /* compiled from: SingleFromPublisher.java */
    static final class a<T> implements g.a.q<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.n0<? super T> f15735a;

        /* renamed from: b, reason: collision with root package name */
        i.d.d f15736b;

        /* renamed from: c, reason: collision with root package name */
        T f15737c;

        /* renamed from: d, reason: collision with root package name */
        boolean f15738d;

        /* renamed from: e, reason: collision with root package name */
        volatile boolean f15739e;

        a(g.a.n0<? super T> n0Var) {
            this.f15735a = n0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15739e = true;
            this.f15736b.cancel();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15739e;
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f15738d) {
                return;
            }
            this.f15738d = true;
            T t = this.f15737c;
            this.f15737c = null;
            if (t == null) {
                this.f15735a.onError(new NoSuchElementException("The source Publisher is empty"));
            } else {
                this.f15735a.onSuccess(t);
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f15738d) {
                g.a.c1.a.b(th);
                return;
            }
            this.f15738d = true;
            this.f15737c = null;
            this.f15735a.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.f15738d) {
                return;
            }
            if (this.f15737c == null) {
                this.f15737c = t;
                return;
            }
            this.f15736b.cancel();
            this.f15738d = true;
            this.f15737c = null;
            this.f15735a.onError(new IndexOutOfBoundsException("Too many elements in the Publisher"));
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f15736b, dVar)) {
                this.f15736b = dVar;
                this.f15735a.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    public b0(i.d.b<? extends T> bVar) {
        this.f15734a = bVar;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        this.f15734a.subscribe(new a(n0Var));
    }
}
