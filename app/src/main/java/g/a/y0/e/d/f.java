package g.a.y0.e.d;

/* compiled from: ObservableAll.java */
/* loaded from: classes2.dex */
public final class f<T> extends g.a.y0.e.d.a<T, Boolean> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.r<? super T> f15099b;

    /* compiled from: ObservableAll.java */
    static final class a<T> implements g.a.i0<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.i0<? super Boolean> f15100a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.r<? super T> f15101b;

        /* renamed from: c, reason: collision with root package name */
        g.a.u0.c f15102c;

        /* renamed from: d, reason: collision with root package name */
        boolean f15103d;

        a(g.a.i0<? super Boolean> i0Var, g.a.x0.r<? super T> rVar) {
            this.f15100a = i0Var;
            this.f15101b = rVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f15102c.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f15102c.isDisposed();
        }

        @Override // g.a.i0
        public void onComplete() {
            if (this.f15103d) {
                return;
            }
            this.f15103d = true;
            this.f15100a.onNext(true);
            this.f15100a.onComplete();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            if (this.f15103d) {
                g.a.c1.a.b(th);
            } else {
                this.f15103d = true;
                this.f15100a.onError(th);
            }
        }

        @Override // g.a.i0
        public void onNext(T t) {
            if (this.f15103d) {
                return;
            }
            try {
                if (this.f15101b.test(t)) {
                    return;
                }
                this.f15103d = true;
                this.f15102c.dispose();
                this.f15100a.onNext(false);
                this.f15100a.onComplete();
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f15102c.dispose();
                onError(th);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15102c, cVar)) {
                this.f15102c = cVar;
                this.f15100a.onSubscribe(this);
            }
        }
    }

    public f(g.a.g0<T> g0Var, g.a.x0.r<? super T> rVar) {
        super(g0Var);
        this.f15099b = rVar;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super Boolean> i0Var) {
        this.f14934a.subscribe(new a(i0Var, this.f15099b));
    }
}
