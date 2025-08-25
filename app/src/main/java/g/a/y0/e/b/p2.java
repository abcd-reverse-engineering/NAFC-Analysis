package g.a.y0.e.b;

/* compiled from: FlowableReduce.java */
/* loaded from: classes2.dex */
public final class p2<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.c<T, T, T> f14500c;

    /* compiled from: FlowableReduce.java */
    static final class a<T> extends g.a.y0.i.f<T> implements g.a.q<T> {
        private static final long serialVersionUID = -4663883003264602070L;
        final g.a.x0.c<T, T, T> reducer;
        i.d.d s;

        a(i.d.c<? super T> cVar, g.a.x0.c<T, T, T> cVar2) {
            super(cVar);
            this.reducer = cVar2;
        }

        @Override // g.a.y0.i.f, i.d.d
        public void cancel() {
            super.cancel();
            this.s.cancel();
            this.s = g.a.y0.i.j.CANCELLED;
        }

        @Override // i.d.c
        public void onComplete() {
            i.d.d dVar = this.s;
            g.a.y0.i.j jVar = g.a.y0.i.j.CANCELLED;
            if (dVar == jVar) {
                return;
            }
            this.s = jVar;
            T t = this.value;
            if (t != null) {
                complete(t);
            } else {
                this.actual.onComplete();
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            i.d.d dVar = this.s;
            g.a.y0.i.j jVar = g.a.y0.i.j.CANCELLED;
            if (dVar == jVar) {
                g.a.c1.a.b(th);
            } else {
                this.s = jVar;
                this.actual.onError(th);
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.s == g.a.y0.i.j.CANCELLED) {
                return;
            }
            T t2 = this.value;
            if (t2 == null) {
                this.value = t;
                return;
            }
            try {
                this.value = (T) g.a.y0.b.b.a((Object) this.reducer.apply(t2, t), "The reducer returned a null value");
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.s.cancel();
                onError(th);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    public p2(g.a.l<T> lVar, g.a.x0.c<T, T, T> cVar) {
        super(lVar);
        this.f14500c = cVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(cVar, this.f14500c));
    }
}
