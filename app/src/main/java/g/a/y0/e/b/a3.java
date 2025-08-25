package g.a.y0.e.b;

import g.a.y0.e.b.w2;

/* compiled from: FlowableRetryWhen.java */
/* loaded from: classes2.dex */
public final class a3<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super g.a.l<Throwable>, ? extends i.d.b<?>> f14118c;

    /* compiled from: FlowableRetryWhen.java */
    static final class a<T> extends w2.c<T, Throwable> {
        private static final long serialVersionUID = -2680129890138081029L;

        a(i.d.c<? super T> cVar, g.a.d1.c<Throwable> cVar2, i.d.d dVar) {
            super(cVar, cVar2, dVar);
        }

        @Override // i.d.c
        public void onComplete() {
            this.f14681receiver.cancel();
            ((w2.c) this).actual.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            again(th);
        }
    }

    public a3(g.a.l<T> lVar, g.a.x0.o<? super g.a.l<Throwable>, ? extends i.d.b<?>> oVar) {
        super(lVar);
        this.f14118c = oVar;
    }

    @Override // g.a.l
    public void d(i.d.c<? super T> cVar) {
        g.a.g1.e eVar = new g.a.g1.e(cVar);
        g.a.d1.c<T> cVarX = g.a.d1.g.m(8).X();
        try {
            i.d.b bVar = (i.d.b) g.a.y0.b.b.a(this.f14118c.apply(cVarX), "handler returned a null Publisher");
            w2.b bVar2 = new w2.b(this.f14110b);
            a aVar = new a(eVar, cVarX, bVar2);
            bVar2.subscriber = aVar;
            cVar.onSubscribe(aVar);
            bVar.subscribe(bVar2);
            bVar2.onNext(0);
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.y0.i.g.error(th, cVar);
        }
    }
}
