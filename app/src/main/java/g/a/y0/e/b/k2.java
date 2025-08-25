package g.a.y0.e.b;

/* compiled from: FlowableOnErrorReturn.java */
/* loaded from: classes2.dex */
public final class k2<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super Throwable, ? extends T> f14326c;

    /* compiled from: FlowableOnErrorReturn.java */
    static final class a<T> extends g.a.y0.h.s<T, T> {
        private static final long serialVersionUID = -3740826063558713822L;
        final g.a.x0.o<? super Throwable, ? extends T> valueSupplier;

        a(i.d.c<? super T> cVar, g.a.x0.o<? super Throwable, ? extends T> oVar) {
            super(cVar);
            this.valueSupplier = oVar;
        }

        @Override // i.d.c
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            try {
                complete(g.a.y0.b.b.a((Object) this.valueSupplier.apply(th), "The valueSupplier returned a null value"));
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                this.actual.onError(new g.a.v0.a(th, th2));
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            this.produced++;
            this.actual.onNext(t);
        }
    }

    public k2(g.a.l<T> lVar, g.a.x0.o<? super Throwable, ? extends T> oVar) {
        super(lVar);
        this.f14326c = oVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(cVar, this.f14326c));
    }
}
