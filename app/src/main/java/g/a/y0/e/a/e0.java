package g.a.y0.e.a;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CompletableObserveOn.java */
/* loaded from: classes2.dex */
public final class e0 extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final g.a.i f14005a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.j0 f14006b;

    /* compiled from: CompletableObserveOn.java */
    static final class a extends AtomicReference<g.a.u0.c> implements g.a.f, g.a.u0.c, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;
        final g.a.f actual;
        Throwable error;
        final g.a.j0 scheduler;

        a(g.a.f fVar, g.a.j0 j0Var) {
            this.actual = fVar;
            this.scheduler = j0Var;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.a.d.isDisposed(get());
        }

        @Override // g.a.f
        public void onComplete() {
            g.a.y0.a.d.replace(this, this.scheduler.a(this));
        }

        @Override // g.a.f
        public void onError(Throwable th) {
            this.error = th;
            g.a.y0.a.d.replace(this, this.scheduler.a(this));
        }

        @Override // g.a.f
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.setOnce(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.error;
            if (th == null) {
                this.actual.onComplete();
            } else {
                this.error = null;
                this.actual.onError(th);
            }
        }
    }

    public e0(g.a.i iVar, g.a.j0 j0Var) {
        this.f14005a = iVar;
        this.f14006b = j0Var;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        this.f14005a.a(new a(fVar, this.f14006b));
    }
}
