package g.a.y0.e.e;

import g.a.x0.r;

/* compiled from: ParallelFilter.java */
/* loaded from: classes2.dex */
public final class d<T> extends g.a.b1.b<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.b1.b<T> f15645a;

    /* renamed from: b, reason: collision with root package name */
    final r<? super T> f15646b;

    /* compiled from: ParallelFilter.java */
    static abstract class a<T> implements g.a.y0.c.a<T>, i.d.d {

        /* renamed from: a, reason: collision with root package name */
        final r<? super T> f15647a;

        /* renamed from: b, reason: collision with root package name */
        i.d.d f15648b;

        /* renamed from: c, reason: collision with root package name */
        boolean f15649c;

        a(r<? super T> rVar) {
            this.f15647a = rVar;
        }

        @Override // i.d.d
        public final void cancel() {
            this.f15648b.cancel();
        }

        @Override // i.d.c
        public final void onNext(T t) {
            if (tryOnNext(t) || this.f15649c) {
                return;
            }
            this.f15648b.request(1L);
        }

        @Override // i.d.d
        public final void request(long j2) {
            this.f15648b.request(j2);
        }
    }

    /* compiled from: ParallelFilter.java */
    static final class b<T> extends a<T> {

        /* renamed from: d, reason: collision with root package name */
        final g.a.y0.c.a<? super T> f15650d;

        b(g.a.y0.c.a<? super T> aVar, r<? super T> rVar) {
            super(rVar);
            this.f15650d = aVar;
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f15649c) {
                return;
            }
            this.f15649c = true;
            this.f15650d.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f15649c) {
                g.a.c1.a.b(th);
            } else {
                this.f15649c = true;
                this.f15650d.onError(th);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f15648b, dVar)) {
                this.f15648b = dVar;
                this.f15650d.onSubscribe(this);
            }
        }

        @Override // g.a.y0.c.a
        public boolean tryOnNext(T t) {
            if (!this.f15649c) {
                try {
                    if (this.f15647a.test(t)) {
                        return this.f15650d.tryOnNext(t);
                    }
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    cancel();
                    onError(th);
                }
            }
            return false;
        }
    }

    /* compiled from: ParallelFilter.java */
    static final class c<T> extends a<T> {

        /* renamed from: d, reason: collision with root package name */
        final i.d.c<? super T> f15651d;

        c(i.d.c<? super T> cVar, r<? super T> rVar) {
            super(rVar);
            this.f15651d = cVar;
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f15649c) {
                return;
            }
            this.f15649c = true;
            this.f15651d.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f15649c) {
                g.a.c1.a.b(th);
            } else {
                this.f15649c = true;
                this.f15651d.onError(th);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f15648b, dVar)) {
                this.f15648b = dVar;
                this.f15651d.onSubscribe(this);
            }
        }

        @Override // g.a.y0.c.a
        public boolean tryOnNext(T t) {
            if (!this.f15649c) {
                try {
                    if (this.f15647a.test(t)) {
                        this.f15651d.onNext(t);
                        return true;
                    }
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    cancel();
                    onError(th);
                }
            }
            return false;
        }
    }

    public d(g.a.b1.b<T> bVar, r<? super T> rVar) {
        this.f15645a = bVar;
        this.f15646b = rVar;
    }

    @Override // g.a.b1.b
    public void a(i.d.c<? super T>[] cVarArr) {
        if (b(cVarArr)) {
            int length = cVarArr.length;
            i.d.c<? super T>[] cVarArr2 = new i.d.c[length];
            for (int i2 = 0; i2 < length; i2++) {
                i.d.c<? super T> cVar = cVarArr[i2];
                if (cVar instanceof g.a.y0.c.a) {
                    cVarArr2[i2] = new b((g.a.y0.c.a) cVar, this.f15646b);
                } else {
                    cVarArr2[i2] = new c(cVar, this.f15646b);
                }
            }
            this.f15645a.a(cVarArr2);
        }
    }

    @Override // g.a.b1.b
    public int a() {
        return this.f15645a.a();
    }
}
