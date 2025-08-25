package g.a.y0.e.b;

/* compiled from: FlowableTakeWhile.java */
/* loaded from: classes2.dex */
public final class b4<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.r<? super T> f14137c;

    /* compiled from: FlowableTakeWhile.java */
    static final class a<T> implements g.a.q<T>, i.d.d {

        /* renamed from: a, reason: collision with root package name */
        final i.d.c<? super T> f14138a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.x0.r<? super T> f14139b;

        /* renamed from: c, reason: collision with root package name */
        i.d.d f14140c;

        /* renamed from: d, reason: collision with root package name */
        boolean f14141d;

        a(i.d.c<? super T> cVar, g.a.x0.r<? super T> rVar) {
            this.f14138a = cVar;
            this.f14139b = rVar;
        }

        @Override // i.d.d
        public void cancel() {
            this.f14140c.cancel();
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.f14141d) {
                return;
            }
            this.f14141d = true;
            this.f14138a.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.f14141d) {
                g.a.c1.a.b(th);
            } else {
                this.f14141d = true;
                this.f14138a.onError(th);
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.f14141d) {
                return;
            }
            try {
                if (this.f14139b.test(t)) {
                    this.f14138a.onNext(t);
                    return;
                }
                this.f14141d = true;
                this.f14140c.cancel();
                this.f14138a.onComplete();
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f14140c.cancel();
                onError(th);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.f14140c, dVar)) {
                this.f14140c = dVar;
                this.f14138a.onSubscribe(this);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            this.f14140c.request(j2);
        }
    }

    public b4(g.a.l<T> lVar, g.a.x0.r<? super T> rVar) {
        super(lVar);
        this.f14137c = rVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(cVar, this.f14137c));
    }
}
