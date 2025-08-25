package g.a.y0.e.b;

/* compiled from: FlowableElementAtMaybe.java */
/* loaded from: classes2.dex */
public final class r0<T> extends g.a.s<T> implements g.a.y0.c.b<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.l<T> f14557a;

    /* renamed from: b, reason: collision with root package name */
    final long f14558b;

    /* compiled from: FlowableElementAtMaybe.java */
    static final class a<T> implements g.a.q<T>, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.v<? super T> f14559a;

        /* renamed from: b, reason: collision with root package name */
        final long f14560b;

        /* renamed from: c, reason: collision with root package name */
        i.d.d f14561c;

        /* renamed from: d, reason: collision with root package name */
        long f14562d;

        /* renamed from: e, reason: collision with root package name */
        boolean f14563e;

        a(g.a.v<? super T> vVar, long j2) {
            this.f14559a = vVar;
            this.f14560b = j2;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14561c.cancel();
            this.f14561c = g.a.y0.i.j.CANCELLED;
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14561c == g.a.y0.i.j.CANCELLED;
        }

        @Override // i.d.c
        public void onComplete() {
            this.f14561c = g.a.y0.i.j.CANCELLED;
            if (this.f14563e) {
                return;
            }
            this.f14563e = true;
            this.f14559a.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f14563e) {
                g.a.c1.a.b(th);
                return;
            }
            this.f14563e = true;
            this.f14561c = g.a.y0.i.j.CANCELLED;
            this.f14559a.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.f14563e) {
                return;
            }
            long j2 = this.f14562d;
            if (j2 != this.f14560b) {
                this.f14562d = j2 + 1;
                return;
            }
            this.f14563e = true;
            this.f14561c.cancel();
            this.f14561c = g.a.y0.i.j.CANCELLED;
            this.f14559a.onSuccess(t);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14561c, dVar)) {
                this.f14561c = dVar;
                this.f14559a.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    public r0(g.a.l<T> lVar, long j2) {
        this.f14557a = lVar;
        this.f14558b = j2;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        this.f14557a.a((g.a.q) new a(vVar, this.f14558b));
    }

    @Override // g.a.y0.c.b
    public g.a.l<T> b() {
        return g.a.c1.a.a(new q0(this.f14557a, this.f14558b, null, false));
    }
}
