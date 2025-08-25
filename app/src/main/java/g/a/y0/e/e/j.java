package g.a.y0.e.e;

import g.a.q;

/* compiled from: ParallelMap.java */
/* loaded from: classes2.dex */
public final class j<T, R> extends g.a.b1.b<R> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.b1.b<T> f15677a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends R> f15678b;

    /* compiled from: ParallelMap.java */
    static final class a<T, R> implements g.a.y0.c.a<T>, i.d.d {

        /* renamed from: a, reason: collision with root package name */
        final g.a.y0.c.a<? super R> f15679a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.o<? super T, ? extends R> f15680b;

        /* renamed from: c, reason: collision with root package name */
        i.d.d f15681c;

        /* renamed from: d, reason: collision with root package name */
        boolean f15682d;

        a(g.a.y0.c.a<? super R> aVar, g.a.x0.o<? super T, ? extends R> oVar) {
            this.f15679a = aVar;
            this.f15680b = oVar;
        }

        @Override // i.d.d
        public void cancel() {
            this.f15681c.cancel();
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f15682d) {
                return;
            }
            this.f15682d = true;
            this.f15679a.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f15682d) {
                g.a.c1.a.b(th);
            } else {
                this.f15682d = true;
                this.f15679a.onError(th);
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.f15682d) {
                return;
            }
            try {
                this.f15679a.onNext(g.a.y0.b.b.a(this.f15680b.apply(t), "The mapper returned a null value"));
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                cancel();
                onError(th);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f15681c, dVar)) {
                this.f15681c = dVar;
                this.f15679a.onSubscribe(this);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            this.f15681c.request(j2);
        }

        @Override // g.a.y0.c.a
        public boolean tryOnNext(T t) {
            if (this.f15682d) {
                return false;
            }
            try {
                return this.f15679a.tryOnNext(g.a.y0.b.b.a(this.f15680b.apply(t), "The mapper returned a null value"));
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                cancel();
                onError(th);
                return false;
            }
        }
    }

    /* compiled from: ParallelMap.java */
    static final class b<T, R> implements q<T>, i.d.d {

        /* renamed from: a, reason: collision with root package name */
        final i.d.c<? super R> f15683a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.o<? super T, ? extends R> f15684b;

        /* renamed from: c, reason: collision with root package name */
        i.d.d f15685c;

        /* renamed from: d, reason: collision with root package name */
        boolean f15686d;

        b(i.d.c<? super R> cVar, g.a.x0.o<? super T, ? extends R> oVar) {
            this.f15683a = cVar;
            this.f15684b = oVar;
        }

        @Override // i.d.d
        public void cancel() {
            this.f15685c.cancel();
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f15686d) {
                return;
            }
            this.f15686d = true;
            this.f15683a.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f15686d) {
                g.a.c1.a.b(th);
            } else {
                this.f15686d = true;
                this.f15683a.onError(th);
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.f15686d) {
                return;
            }
            try {
                this.f15683a.onNext(g.a.y0.b.b.a(this.f15684b.apply(t), "The mapper returned a null value"));
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                cancel();
                onError(th);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f15685c, dVar)) {
                this.f15685c = dVar;
                this.f15683a.onSubscribe(this);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            this.f15685c.request(j2);
        }
    }

    public j(g.a.b1.b<T> bVar, g.a.x0.o<? super T, ? extends R> oVar) {
        this.f15677a = bVar;
        this.f15678b = oVar;
    }

    @Override // g.a.b1.b
    public void a(i.d.c<? super R>[] cVarArr) {
        if (b(cVarArr)) {
            int length = cVarArr.length;
            i.d.c<? super T>[] cVarArr2 = new i.d.c[length];
            for (int i2 = 0; i2 < length; i2++) {
                i.d.c<? super R> cVar = cVarArr[i2];
                if (cVar instanceof g.a.y0.c.a) {
                    cVarArr2[i2] = new a((g.a.y0.c.a) cVar, this.f15678b);
                } else {
                    cVarArr2[i2] = new b(cVar, this.f15678b);
                }
            }
            this.f15677a.a(cVarArr2);
        }
    }

    @Override // g.a.b1.b
    public int a() {
        return this.f15677a.a();
    }
}
