package g.a.y0.e.a;

/* compiled from: CompletableResumeNext.java */
/* loaded from: classes2.dex */
public final class h0 extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final g.a.i f14034a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super Throwable, ? extends g.a.i> f14035b;

    /* compiled from: CompletableResumeNext.java */
    final class a implements g.a.f {

        /* renamed from: a, reason: collision with root package name */
        final g.a.f f14036a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.y0.a.k f14037b;

        /* compiled from: CompletableResumeNext.java */
        /* renamed from: g.a.y0.e.a.h0$a$a, reason: collision with other inner class name */
        final class C0184a implements g.a.f {
            C0184a() {
            }

            @Override // g.a.f
            public void onComplete() {
                a.this.f14036a.onComplete();
            }

            @Override // g.a.f
            public void onError(Throwable th) {
                a.this.f14036a.onError(th);
            }

            @Override // g.a.f
            public void onSubscribe(g.a.u0.c cVar) {
                a.this.f14037b.update(cVar);
            }
        }

        a(g.a.f fVar, g.a.y0.a.k kVar) {
            this.f14036a = fVar;
            this.f14037b = kVar;
        }

        @Override // g.a.f
        public void onComplete() {
            this.f14036a.onComplete();
        }

        @Override // g.a.f
        public void onError(Throwable th) {
            try {
                g.a.i iVarApply = h0.this.f14035b.apply(th);
                if (iVarApply != null) {
                    iVarApply.a(new C0184a());
                    return;
                }
                NullPointerException nullPointerException = new NullPointerException("The CompletableConsumable returned is null");
                nullPointerException.initCause(th);
                this.f14036a.onError(nullPointerException);
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                this.f14036a.onError(new g.a.v0.a(th2, th));
            }
        }

        @Override // g.a.f
        public void onSubscribe(g.a.u0.c cVar) {
            this.f14037b.update(cVar);
        }
    }

    public h0(g.a.i iVar, g.a.x0.o<? super Throwable, ? extends g.a.i> oVar) {
        this.f14034a = iVar;
        this.f14035b = oVar;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        g.a.y0.a.k kVar = new g.a.y0.a.k();
        fVar.onSubscribe(kVar);
        this.f14034a.a(new a(fVar, kVar));
    }
}
