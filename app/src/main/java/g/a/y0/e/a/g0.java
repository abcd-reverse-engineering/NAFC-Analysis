package g.a.y0.e.a;

/* compiled from: CompletablePeek.java */
/* loaded from: classes2.dex */
public final class g0 extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final g.a.i f14013a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.g<? super g.a.u0.c> f14014b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.g<? super Throwable> f14015c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.x0.a f14016d;

    /* renamed from: e, reason: collision with root package name */
    final g.a.x0.a f14017e;

    /* renamed from: f, reason: collision with root package name */
    final g.a.x0.a f14018f;

    /* renamed from: g, reason: collision with root package name */
    final g.a.x0.a f14019g;

    /* compiled from: CompletablePeek.java */
    final class a implements g.a.f, g.a.u0.c {

        /* renamed from: a, reason: collision with root package name */
        final g.a.f f14020a;

        /* renamed from: b, reason: collision with root package name */
        g.a.u0.c f14021b;

        a(g.a.f fVar) {
            this.f14020a = fVar;
        }

        void a() {
            try {
                g0.this.f14018f.run();
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                g.a.c1.a.b(th);
            }
        }

        @Override // g.a.u0.c
        public void dispose() {
            try {
                g0.this.f14019g.run();
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                g.a.c1.a.b(th);
            }
            this.f14021b.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14021b.isDisposed();
        }

        @Override // g.a.f
        public void onComplete() {
            if (this.f14021b == g.a.y0.a.d.DISPOSED) {
                return;
            }
            try {
                g0.this.f14016d.run();
                g0.this.f14017e.run();
                this.f14020a.onComplete();
                a();
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f14020a.onError(th);
            }
        }

        @Override // g.a.f
        public void onError(Throwable th) {
            if (this.f14021b == g.a.y0.a.d.DISPOSED) {
                g.a.c1.a.b(th);
                return;
            }
            try {
                g0.this.f14015c.accept(th);
                g0.this.f14017e.run();
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                th = new g.a.v0.a(th, th2);
            }
            this.f14020a.onError(th);
            a();
        }

        @Override // g.a.f
        public void onSubscribe(g.a.u0.c cVar) {
            try {
                g0.this.f14014b.accept(cVar);
                if (g.a.y0.a.d.validate(this.f14021b, cVar)) {
                    this.f14021b = cVar;
                    this.f14020a.onSubscribe(this);
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                cVar.dispose();
                this.f14021b = g.a.y0.a.d.DISPOSED;
                g.a.y0.a.e.error(th, this.f14020a);
            }
        }
    }

    public g0(g.a.i iVar, g.a.x0.g<? super g.a.u0.c> gVar, g.a.x0.g<? super Throwable> gVar2, g.a.x0.a aVar, g.a.x0.a aVar2, g.a.x0.a aVar3, g.a.x0.a aVar4) {
        this.f14013a = iVar;
        this.f14014b = gVar;
        this.f14015c = gVar2;
        this.f14016d = aVar;
        this.f14017e = aVar2;
        this.f14018f = aVar3;
        this.f14019g = aVar4;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        this.f14013a.a(new a(fVar));
    }
}
