package g.a.y0.e.b;

/* compiled from: FlowableScan.java */
/* loaded from: classes2.dex */
public final class e3<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.c<T, T, T> f14201c;

    /* compiled from: FlowableScan.java */
    static final class a<T> implements g.a.q<T>, i.d.d {

        /* renamed from: a, reason: collision with root package name */
        final i.d.c<? super T> f14202a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.c<T, T, T> f14203b;

        /* renamed from: c, reason: collision with root package name */
        i.d.d f14204c;

        /* renamed from: d, reason: collision with root package name */
        T f14205d;

        /* renamed from: e, reason: collision with root package name */
        boolean f14206e;

        a(i.d.c<? super T> cVar, g.a.x0.c<T, T, T> cVar2) {
            this.f14202a = cVar;
            this.f14203b = cVar2;
        }

        @Override // i.d.d
        public void cancel() {
            this.f14204c.cancel();
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f14206e) {
                return;
            }
            this.f14206e = true;
            this.f14202a.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f14206e) {
                g.a.c1.a.b(th);
            } else {
                this.f14206e = true;
                this.f14202a.onError(th);
            }
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.Object] */
        @Override // i.d.c
        public void onNext(T t) {
            if (this.f14206e) {
                return;
            }
            i.d.c<? super T> cVar = this.f14202a;
            T t2 = this.f14205d;
            if (t2 == null) {
                this.f14205d = t;
                cVar.onNext(t);
                return;
            }
            try {
                ?? r4 = (T) g.a.y0.b.b.a((Object) this.f14203b.apply(t2, t), "The value returned by the accumulator is null");
                this.f14205d = r4;
                cVar.onNext(r4);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f14204c.cancel();
                onError(th);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14204c, dVar)) {
                this.f14204c = dVar;
                this.f14202a.onSubscribe(this);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            this.f14204c.request(j2);
        }
    }

    public e3(g.a.l<T> lVar, g.a.x0.c<T, T, T> cVar) {
        super(lVar);
        this.f14201c = cVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(cVar, this.f14201c));
    }
}
