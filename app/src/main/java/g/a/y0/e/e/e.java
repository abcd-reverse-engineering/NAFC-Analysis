package g.a.y0.e.e;

import g.a.x0.r;

/* compiled from: ParallelFilterTry.java */
/* loaded from: classes2.dex */
public final class e<T> extends g.a.b1.b<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.b1.b<T> f15652a;

    /* renamed from: b, reason: collision with root package name */
    final r<? super T> f15653b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.c<? super Long, ? super Throwable, g.a.b1.a> f15654c;

    /* compiled from: ParallelFilterTry.java */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f15655a = new int[g.a.b1.a.values().length];

        static {
            try {
                f15655a[g.a.b1.a.RETRY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15655a[g.a.b1.a.SKIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15655a[g.a.b1.a.STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: ParallelFilterTry.java */
    static abstract class b<T> implements g.a.y0.c.a<T>, i.d.d {

        /* renamed from: a, reason: collision with root package name */
        final r<? super T> f15656a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.c<? super Long, ? super Throwable, g.a.b1.a> f15657b;

        /* renamed from: c, reason: collision with root package name */
        i.d.d f15658c;

        /* renamed from: d, reason: collision with root package name */
        boolean f15659d;

        b(r<? super T> rVar, g.a.x0.c<? super Long, ? super Throwable, g.a.b1.a> cVar) {
            this.f15656a = rVar;
            this.f15657b = cVar;
        }

        @Override // i.d.d
        public final void cancel() {
            this.f15658c.cancel();
        }

        @Override // i.d.c
        public final void onNext(T t) {
            if (tryOnNext(t) || this.f15659d) {
                return;
            }
            this.f15658c.request(1L);
        }

        @Override // i.d.d
        public final void request(long j2) {
            this.f15658c.request(j2);
        }
    }

    /* compiled from: ParallelFilterTry.java */
    static final class c<T> extends b<T> {

        /* renamed from: e, reason: collision with root package name */
        final g.a.y0.c.a<? super T> f15660e;

        c(g.a.y0.c.a<? super T> aVar, r<? super T> rVar, g.a.x0.c<? super Long, ? super Throwable, g.a.b1.a> cVar) {
            super(rVar, cVar);
            this.f15660e = aVar;
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f15659d) {
                return;
            }
            this.f15659d = true;
            this.f15660e.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f15659d) {
                g.a.c1.a.b(th);
            } else {
                this.f15659d = true;
                this.f15660e.onError(th);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f15658c, dVar)) {
                this.f15658c = dVar;
                this.f15660e.onSubscribe(this);
            }
        }

        @Override // g.a.y0.c.a
        public boolean tryOnNext(T t) {
            int i2;
            if (!this.f15659d) {
                long j2 = 0;
                do {
                    try {
                        return this.f15656a.test(t) && this.f15660e.tryOnNext(t);
                    } catch (Throwable th) {
                        g.a.v0.b.b(th);
                        try {
                            j2++;
                            i2 = a.f15655a[((g.a.b1.a) g.a.y0.b.b.a(this.f15657b.apply(Long.valueOf(j2), th), "The errorHandler returned a null item")).ordinal()];
                        } catch (Throwable th2) {
                            g.a.v0.b.b(th2);
                            cancel();
                            onError(new g.a.v0.a(th, th2));
                        }
                    }
                } while (i2 == 1);
                if (i2 != 2) {
                    if (i2 != 3) {
                        cancel();
                        onError(th);
                        return false;
                    }
                    cancel();
                    onComplete();
                }
                return false;
            }
            return false;
        }
    }

    /* compiled from: ParallelFilterTry.java */
    static final class d<T> extends b<T> {

        /* renamed from: e, reason: collision with root package name */
        final i.d.c<? super T> f15661e;

        d(i.d.c<? super T> cVar, r<? super T> rVar, g.a.x0.c<? super Long, ? super Throwable, g.a.b1.a> cVar2) {
            super(rVar, cVar2);
            this.f15661e = cVar;
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f15659d) {
                return;
            }
            this.f15659d = true;
            this.f15661e.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f15659d) {
                g.a.c1.a.b(th);
            } else {
                this.f15659d = true;
                this.f15661e.onError(th);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f15658c, dVar)) {
                this.f15658c = dVar;
                this.f15661e.onSubscribe(this);
            }
        }

        @Override // g.a.y0.c.a
        public boolean tryOnNext(T t) {
            int i2;
            if (!this.f15659d) {
                long j2 = 0;
                do {
                    try {
                        if (!this.f15656a.test(t)) {
                            return false;
                        }
                        this.f15661e.onNext(t);
                        return true;
                    } catch (Throwable th) {
                        g.a.v0.b.b(th);
                        try {
                            j2++;
                            i2 = a.f15655a[((g.a.b1.a) g.a.y0.b.b.a(this.f15657b.apply(Long.valueOf(j2), th), "The errorHandler returned a null item")).ordinal()];
                        } catch (Throwable th2) {
                            g.a.v0.b.b(th2);
                            cancel();
                            onError(new g.a.v0.a(th, th2));
                        }
                    }
                } while (i2 == 1);
                if (i2 != 2) {
                    if (i2 != 3) {
                        cancel();
                        onError(th);
                        return false;
                    }
                    cancel();
                    onComplete();
                }
                return false;
            }
            return false;
        }
    }

    public e(g.a.b1.b<T> bVar, r<? super T> rVar, g.a.x0.c<? super Long, ? super Throwable, g.a.b1.a> cVar) {
        this.f15652a = bVar;
        this.f15653b = rVar;
        this.f15654c = cVar;
    }

    @Override // g.a.b1.b
    public void a(i.d.c<? super T>[] cVarArr) {
        if (b(cVarArr)) {
            int length = cVarArr.length;
            i.d.c<? super T>[] cVarArr2 = new i.d.c[length];
            for (int i2 = 0; i2 < length; i2++) {
                i.d.c<? super T> cVar = cVarArr[i2];
                if (cVar instanceof g.a.y0.c.a) {
                    cVarArr2[i2] = new c((g.a.y0.c.a) cVar, this.f15653b, this.f15654c);
                } else {
                    cVarArr2[i2] = new d(cVar, this.f15653b, this.f15654c);
                }
            }
            this.f15652a.a(cVarArr2);
        }
    }

    @Override // g.a.b1.b
    public int a() {
        return this.f15652a.a();
    }
}
