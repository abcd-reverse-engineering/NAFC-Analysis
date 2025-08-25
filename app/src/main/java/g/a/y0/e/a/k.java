package g.a.y0.e.a;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: CompletableDoFinally.java */
@g.a.t0.e
/* loaded from: classes2.dex */
public final class k extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final g.a.i f14064a;

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.a f14065b;

    /* compiled from: CompletableDoFinally.java */
    static final class a extends AtomicInteger implements g.a.f, g.a.u0.c {
        private static final long serialVersionUID = 4109457741734051389L;
        final g.a.f actual;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f14066d;
        final g.a.x0.a onFinally;

        a(g.a.f fVar, g.a.x0.a aVar) {
            this.actual = fVar;
            this.onFinally = aVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.f14066d.dispose();
            runFinally();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.f14066d.isDisposed();
        }

        @Override // g.a.f
        public void onComplete() {
            this.actual.onComplete();
            runFinally();
        }

        @Override // g.a.f
        public void onError(Throwable th) {
            this.actual.onError(th);
            runFinally();
        }

        @Override // g.a.f
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f14066d, cVar)) {
                this.f14066d = cVar;
                this.actual.onSubscribe(this);
            }
        }

        void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    g.a.c1.a.b(th);
                }
            }
        }
    }

    public k(g.a.i iVar, g.a.x0.a aVar) {
        this.f14064a = iVar;
        this.f14065b = aVar;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        this.f14064a.a(new a(fVar, this.f14065b));
    }
}
