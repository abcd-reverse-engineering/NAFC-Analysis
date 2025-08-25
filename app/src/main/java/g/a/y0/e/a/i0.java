package g.a.y0.e.a;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CompletableSubscribeOn.java */
/* loaded from: classes2.dex */
public final class i0 extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final g.a.i f14043a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.j0 f14044b;

    /* compiled from: CompletableSubscribeOn.java */
    static final class a extends AtomicReference<g.a.u0.c> implements g.a.f, g.a.u0.c, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        final g.a.f actual;
        final g.a.i source;
        final g.a.y0.a.k task = new g.a.y0.a.k();

        a(g.a.f fVar, g.a.i iVar) {
            this.actual = fVar;
            this.source = iVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this);
            this.task.dispose();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(get());
        }

        @Override // g.a.f
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // g.a.f
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // g.a.f
        public void onSubscribe(g.a.u0.c cVar) {
            g.a.y0.a.d.setOnce(this, cVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.source.a(this);
        }
    }

    public i0(g.a.i iVar, g.a.j0 j0Var) {
        this.f14043a = iVar;
        this.f14044b = j0Var;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        a aVar = new a(fVar, this.f14043a);
        fVar.onSubscribe(aVar);
        aVar.task.replace(this.f14044b.a(aVar));
    }
}
