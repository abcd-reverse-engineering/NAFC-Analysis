package g.a.y0.e.b;

/* compiled from: FlowableMaterialize.java */
/* loaded from: classes2.dex */
public final class b2<T> extends g.a.y0.e.b.a<T, g.a.a0<T>> {

    /* compiled from: FlowableMaterialize.java */
    static final class a<T> extends g.a.y0.h.s<T, g.a.a0<T>> {
        private static final long serialVersionUID = -3740826063558713822L;

        a(i.d.c<? super g.a.a0<T>> cVar) {
            super(cVar);
        }

        @Override // i.d.c
        public void onComplete() {
            complete(g.a.a0.f());
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            complete(g.a.a0.a(th));
        }

        @Override // i.d.c
        public void onNext(T t) {
            this.produced++;
            this.actual.onNext(g.a.a0.a(t));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // g.a.y0.h.s
        public void onDrop(g.a.a0<T> a0Var) {
            if (a0Var.d()) {
                g.a.c1.a.b(a0Var.a());
            }
        }
    }

    public b2(g.a.l<T> lVar) {
        super(lVar);
    }

    @Override // g.a.l
    protected void d(i.d.c<? super g.a.a0<T>> cVar) {
        this.f14110b.a((g.a.q) new a(cVar));
    }
}
