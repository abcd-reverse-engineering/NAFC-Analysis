package g.a.y0.e.e;

/* compiled from: ParallelMapTry.java */
/* loaded from: classes2.dex */
public final class k<T, R> extends g.a.b1.b<R> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.b1.b<T> f15687a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends R> f15688b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.c<? super Long, ? super Throwable, g.a.b1.a> f15689c;

    /* compiled from: ParallelMapTry.java */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f15690a = new int[g.a.b1.a.values().length];

        static {
            try {
                f15690a[g.a.b1.a.RETRY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15690a[g.a.b1.a.SKIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15690a[g.a.b1.a.STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: ParallelMapTry.java */
    static final class b<T, R> implements g.a.y0.c.a<T>, i.d.d {

        /* renamed from: a, reason: collision with root package name */
        final g.a.y0.c.a<? super R> f15691a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.o<? super T, ? extends R> f15692b;

        /* renamed from: c, reason: collision with root package name */
        final g.a.x0.c<? super Long, ? super Throwable, g.a.b1.a> f15693c;

        /* renamed from: d, reason: collision with root package name */
        i.d.d f15694d;

        /* renamed from: e, reason: collision with root package name */
        boolean f15695e;

        b(g.a.y0.c.a<? super R> aVar, g.a.x0.o<? super T, ? extends R> oVar, g.a.x0.c<? super Long, ? super Throwable, g.a.b1.a> cVar) {
            this.f15691a = aVar;
            this.f15692b = oVar;
            this.f15693c = cVar;
        }

        @Override // i.d.d
        public void cancel() {
            this.f15694d.cancel();
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f15695e) {
                return;
            }
            this.f15695e = true;
            this.f15691a.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f15695e) {
                g.a.c1.a.b(th);
            } else {
                this.f15695e = true;
                this.f15691a.onError(th);
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (tryOnNext(t) || this.f15695e) {
                return;
            }
            this.f15694d.request(1L);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f15694d, dVar)) {
                this.f15694d = dVar;
                this.f15691a.onSubscribe(this);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            this.f15694d.request(j2);
        }

        @Override // g.a.y0.c.a
        public boolean tryOnNext(T t) {
            int i2;
            if (this.f15695e) {
                return false;
            }
            long j2 = 0;
            do {
                try {
                    return this.f15691a.tryOnNext(g.a.y0.b.b.a(this.f15692b.apply(t), "The mapper returned a null value"));
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    try {
                        j2++;
                        i2 = a.f15690a[((g.a.b1.a) g.a.y0.b.b.a(this.f15693c.apply(Long.valueOf(j2), th), "The errorHandler returned a null item")).ordinal()];
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

    /* compiled from: ParallelMapTry.java */
    static final class c<T, R> implements g.a.y0.c.a<T>, i.d.d {

        /* renamed from: a, reason: collision with root package name */
        final i.d.c<? super R> f15696a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.o<? super T, ? extends R> f15697b;

        /* renamed from: c, reason: collision with root package name */
        final g.a.x0.c<? super Long, ? super Throwable, g.a.b1.a> f15698c;

        /* renamed from: d, reason: collision with root package name */
        i.d.d f15699d;

        /* renamed from: e, reason: collision with root package name */
        boolean f15700e;

        c(i.d.c<? super R> cVar, g.a.x0.o<? super T, ? extends R> oVar, g.a.x0.c<? super Long, ? super Throwable, g.a.b1.a> cVar2) {
            this.f15696a = cVar;
            this.f15697b = oVar;
            this.f15698c = cVar2;
        }

        @Override // i.d.d
        public void cancel() {
            this.f15699d.cancel();
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f15700e) {
                return;
            }
            this.f15700e = true;
            this.f15696a.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f15700e) {
                g.a.c1.a.b(th);
            } else {
                this.f15700e = true;
                this.f15696a.onError(th);
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (tryOnNext(t) || this.f15700e) {
                return;
            }
            this.f15699d.request(1L);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f15699d, dVar)) {
                this.f15699d = dVar;
                this.f15696a.onSubscribe(this);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            this.f15699d.request(j2);
        }

        @Override // g.a.y0.c.a
        public boolean tryOnNext(T t) {
            int i2;
            if (this.f15700e) {
                return false;
            }
            long j2 = 0;
            do {
                try {
                    this.f15696a.onNext(g.a.y0.b.b.a(this.f15697b.apply(t), "The mapper returned a null value"));
                    return true;
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    try {
                        j2++;
                        i2 = a.f15690a[((g.a.b1.a) g.a.y0.b.b.a(this.f15698c.apply(Long.valueOf(j2), th), "The errorHandler returned a null item")).ordinal()];
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

    public k(g.a.b1.b<T> bVar, g.a.x0.o<? super T, ? extends R> oVar, g.a.x0.c<? super Long, ? super Throwable, g.a.b1.a> cVar) {
        this.f15687a = bVar;
        this.f15688b = oVar;
        this.f15689c = cVar;
    }

    @Override // g.a.b1.b
    public void a(i.d.c<? super R>[] cVarArr) {
        if (b(cVarArr)) {
            int length = cVarArr.length;
            i.d.c<? super T>[] cVarArr2 = new i.d.c[length];
            for (int i2 = 0; i2 < length; i2++) {
                i.d.c<? super R> cVar = cVarArr[i2];
                if (cVar instanceof g.a.y0.c.a) {
                    cVarArr2[i2] = new b((g.a.y0.c.a) cVar, this.f15688b, this.f15689c);
                } else {
                    cVarArr2[i2] = new c(cVar, this.f15688b, this.f15689c);
                }
            }
            this.f15687a.a(cVarArr2);
        }
    }

    @Override // g.a.b1.b
    public int a() {
        return this.f15687a.a();
    }
}
