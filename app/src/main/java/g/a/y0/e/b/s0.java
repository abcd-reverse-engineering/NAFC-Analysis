package g.a.y0.e.b;

import java.util.NoSuchElementException;

/* compiled from: FlowableElementAtSingle.java */
/* loaded from: classes2.dex */
public final class s0<T> extends g.a.k0<T> implements g.a.y0.c.b<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.l<T> f14587a;

    /* renamed from: b, reason: collision with root package name */
    final long f14588b;

    /* renamed from: c, reason: collision with root package name */
    final T f14589c;

    /* compiled from: FlowableElementAtSingle.java */
    static final class a<T> implements g.a.q<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.n0<? super T> f14590a;

        /* renamed from: b, reason: collision with root package name */
        final long f14591b;

        /* renamed from: c, reason: collision with root package name */
        final T f14592c;

        /* renamed from: d, reason: collision with root package name */
        i.d.d f14593d;

        /* renamed from: e, reason: collision with root package name */
        long f14594e;

        /* renamed from: f, reason: collision with root package name */
        boolean f14595f;

        a(g.a.n0<? super T> n0Var, long j2, T t) {
            this.f14590a = n0Var;
            this.f14591b = j2;
            this.f14592c = t;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14593d.cancel();
            this.f14593d = g.a.y0.i.j.CANCELLED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14593d == g.a.y0.i.j.CANCELLED;
        }

        @Override // i.d.c
        public void onComplete() {
            this.f14593d = g.a.y0.i.j.CANCELLED;
            if (this.f14595f) {
                return;
            }
            this.f14595f = true;
            T t = this.f14592c;
            if (t != null) {
                this.f14590a.onSuccess(t);
            } else {
                this.f14590a.onError(new NoSuchElementException());
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f14595f) {
                g.a.c1.a.b(th);
                return;
            }
            this.f14595f = true;
            this.f14593d = g.a.y0.i.j.CANCELLED;
            this.f14590a.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.f14595f) {
                return;
            }
            long j2 = this.f14594e;
            if (j2 != this.f14591b) {
                this.f14594e = j2 + 1;
                return;
            }
            this.f14595f = true;
            this.f14593d.cancel();
            this.f14593d = g.a.y0.i.j.CANCELLED;
            this.f14590a.onSuccess(t);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14593d, dVar)) {
                this.f14593d = dVar;
                this.f14590a.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    public s0(g.a.l<T> lVar, long j2, T t) {
        this.f14587a = lVar;
        this.f14588b = j2;
        this.f14589c = t;
    }

    @Override // g.a.k0
    protected void b(g.a.n0<? super T> n0Var) {
        this.f14587a.a((g.a.q) new a(n0Var, this.f14588b, this.f14589c));
    }

    @Override // g.a.y0.c.b
    public g.a.l<T> b() {
        return g.a.c1.a.a(new q0(this.f14587a, this.f14588b, this.f14589c, true));
    }
}
