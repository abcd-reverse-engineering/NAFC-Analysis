package g.a.y0.e.e;

/* compiled from: ParallelDoOnNextTry.java */
/* loaded from: classes2.dex */
public final class c<T> extends g.a.b1.b<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.b1.b<T> f15631a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.g<? super T> f15632b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.c<? super Long, ? super Throwable, g.a.b1.a> f15633c;

    /* compiled from: ParallelDoOnNextTry.java */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f15634a = new int[g.a.b1.a.values().length];

        static {
            try {
                f15634a[g.a.b1.a.RETRY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15634a[g.a.b1.a.SKIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15634a[g.a.b1.a.STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: ParallelDoOnNextTry.java */
    static final class b<T> implements g.a.y0.c.a<T>, i.d.d {

        /* renamed from: a, reason: collision with root package name */
        final g.a.y0.c.a<? super T> f15635a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.g<? super T> f15636b;

        /* renamed from: c, reason: collision with root package name */
        final g.a.x0.c<? super Long, ? super Throwable, g.a.b1.a> f15637c;

        /* renamed from: d, reason: collision with root package name */
        i.d.d f15638d;

        /* renamed from: e, reason: collision with root package name */
        boolean f15639e;

        b(g.a.y0.c.a<? super T> aVar, g.a.x0.g<? super T> gVar, g.a.x0.c<? super Long, ? super Throwable, g.a.b1.a> cVar) {
            this.f15635a = aVar;
            this.f15636b = gVar;
            this.f15637c = cVar;
        }

        @Override // i.d.d
        public void cancel() {
            this.f15638d.cancel();
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f15639e) {
                return;
            }
            this.f15639e = true;
            this.f15635a.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f15639e) {
                g.a.c1.a.b(th);
            } else {
                this.f15639e = true;
                this.f15635a.onError(th);
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (tryOnNext(t) || this.f15639e) {
                return;
            }
            this.f15638d.request(1L);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f15638d, dVar)) {
                this.f15638d = dVar;
                this.f15635a.onSubscribe(this);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            this.f15638d.request(j2);
        }

        @Override // g.a.y0.c.a
        public boolean tryOnNext(T t) {
            int i2;
            if (this.f15639e) {
                return false;
            }
            long j2 = 0;
            do {
                try {
                    this.f15636b.accept(t);
                    return this.f15635a.tryOnNext(t);
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    try {
                        j2++;
                        i2 = a.f15634a[((g.a.b1.a) g.a.y0.b.b.a(this.f15637c.apply(Long.valueOf(j2), th), "The errorHandler returned a null item")).ordinal()];
                    } catch (Throwable th2) {
                        g.a.v0.b.b(th2);
                        cancel();
                        onError(new g.a.v0.a(th, th2));
                        return false;
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
    }

    /* compiled from: ParallelDoOnNextTry.java */
    /* renamed from: g.a.y0.e.e.c$c, reason: collision with other inner class name */
    static final class C0223c<T> implements g.a.y0.c.a<T>, i.d.d {

        /* renamed from: a, reason: collision with root package name */
        final i.d.c<? super T> f15640a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.g<? super T> f15641b;

        /* renamed from: c, reason: collision with root package name */
        final g.a.x0.c<? super Long, ? super Throwable, g.a.b1.a> f15642c;

        /* renamed from: d, reason: collision with root package name */
        i.d.d f15643d;

        /* renamed from: e, reason: collision with root package name */
        boolean f15644e;

        C0223c(i.d.c<? super T> cVar, g.a.x0.g<? super T> gVar, g.a.x0.c<? super Long, ? super Throwable, g.a.b1.a> cVar2) {
            this.f15640a = cVar;
            this.f15641b = gVar;
            this.f15642c = cVar2;
        }

        @Override // i.d.d
        public void cancel() {
            this.f15643d.cancel();
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f15644e) {
                return;
            }
            this.f15644e = true;
            this.f15640a.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f15644e) {
                g.a.c1.a.b(th);
            } else {
                this.f15644e = true;
                this.f15640a.onError(th);
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (tryOnNext(t)) {
                return;
            }
            this.f15643d.request(1L);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f15643d, dVar)) {
                this.f15643d = dVar;
                this.f15640a.onSubscribe(this);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            this.f15643d.request(j2);
        }

        @Override // g.a.y0.c.a
        public boolean tryOnNext(T t) {
            int i2;
            if (this.f15644e) {
                return false;
            }
            long j2 = 0;
            do {
                try {
                    this.f15641b.accept(t);
                    this.f15640a.onNext(t);
                    return true;
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    try {
                        j2++;
                        i2 = a.f15634a[((g.a.b1.a) g.a.y0.b.b.a(this.f15642c.apply(Long.valueOf(j2), th), "The errorHandler returned a null item")).ordinal()];
                    } catch (Throwable th2) {
                        g.a.v0.b.b(th2);
                        cancel();
                        onError(new g.a.v0.a(th, th2));
                        return false;
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
    }

    public c(g.a.b1.b<T> bVar, g.a.x0.g<? super T> gVar, g.a.x0.c<? super Long, ? super Throwable, g.a.b1.a> cVar) {
        this.f15631a = bVar;
        this.f15632b = gVar;
        this.f15633c = cVar;
    }

    @Override // g.a.b1.b
    public void a(i.d.c<? super T>[] cVarArr) {
        if (b(cVarArr)) {
            int length = cVarArr.length;
            i.d.c<? super T>[] cVarArr2 = new i.d.c[length];
            for (int i2 = 0; i2 < length; i2++) {
                i.d.c<? super T> cVar = cVarArr[i2];
                if (cVar instanceof g.a.y0.c.a) {
                    cVarArr2[i2] = new b((g.a.y0.c.a) cVar, this.f15632b, this.f15633c);
                } else {
                    cVarArr2[i2] = new C0223c(cVar, this.f15632b, this.f15633c);
                }
            }
            this.f15631a.a(cVarArr2);
        }
    }

    @Override // g.a.b1.b
    public int a() {
        return this.f15631a.a();
    }
}
