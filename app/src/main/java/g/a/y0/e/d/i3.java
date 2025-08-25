package g.a.y0.e.d;

/* compiled from: ObservableTake.java */
/* loaded from: classes2.dex */
public final class i3<T> extends g.a.y0.e.d.a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final long f15211b;

    /* compiled from: ObservableTake.java */
    static final class a<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super T> f15212a;

        /* renamed from: b, reason: collision with root package name */
        boolean f15213b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f15214c;

        /* renamed from: d, reason: collision with root package name */
        long f15215d;

        a(g.a.i0<? super T> i0Var, long j2) {
            this.f15212a = i0Var;
            this.f15215d = j2;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15214c.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15214c.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f15213b) {
                return;
            }
            this.f15213b = true;
            this.f15214c.dispose();
            this.f15212a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f15213b) {
                g.a.c1.a.b(th);
                return;
            }
            this.f15213b = true;
            this.f15214c.dispose();
            this.f15212a.onError(th);
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f15213b) {
                return;
            }
            long j2 = this.f15215d;
            this.f15215d = j2 - 1;
            if (j2 > 0) {
                boolean z = this.f15215d == 0;
                this.f15212a.onNext(t);
                if (z) {
                    onComplete();
                }
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15214c, cVar)) {
                this.f15214c = cVar;
                if (this.f15215d != 0) {
                    this.f15212a.onSubscribe(this);
                    return;
                }
                this.f15213b = true;
                cVar.dispose();
                g.a.y0.a.e.complete(this.f15212a);
            }
        }
    }

    public i3(g.a.g0<T> g0Var, long j2) {
        super(g0Var);
        this.f15211b = j2;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super T> i0Var) {
        this.f14934a.subscribe(new a(i0Var, this.f15211b));
    }
}
