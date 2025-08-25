package g.a.y0.e.a;

import java.util.concurrent.TimeUnit;

/* compiled from: CompletableDelay.java */
/* loaded from: classes2.dex */
public final class h extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final g.a.i f14023a;

    /* renamed from: b, reason: collision with root package name */
    final long f14024b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f14025c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.j0 f14026d;

    /* renamed from: e, reason: collision with root package name */
    final boolean f14027e;

    /* compiled from: CompletableDelay.java */
    final class a implements g.a.f {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.u0.b f14028a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.f f14029b;

        /* compiled from: CompletableDelay.java */
        /* renamed from: g.a.y0.e.a.h$a$a, reason: collision with other inner class name */
        final class RunnableC0183a implements Runnable {
            RunnableC0183a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f14029b.onComplete();
            }
        }

        /* compiled from: CompletableDelay.java */
        final class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            private final Throwable f14032a;

            b(Throwable th) {
                this.f14032a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f14029b.onError(this.f14032a);
            }
        }

        a(g.a.u0.b bVar, g.a.f fVar) {
            this.f14028a = bVar;
            this.f14029b = fVar;
        }

        @Override // g.a.f
        public void onComplete() {
            g.a.u0.b bVar = this.f14028a;
            g.a.j0 j0Var = h.this.f14026d;
            RunnableC0183a runnableC0183a = new RunnableC0183a();
            h hVar = h.this;
            bVar.b(j0Var.a(runnableC0183a, hVar.f14024b, hVar.f14025c));
        }

        @Override // g.a.f
        public void onError(Throwable th) {
            g.a.u0.b bVar = this.f14028a;
            g.a.j0 j0Var = h.this.f14026d;
            b bVar2 = new b(th);
            h hVar = h.this;
            bVar.b(j0Var.a(bVar2, hVar.f14027e ? hVar.f14024b : 0L, h.this.f14025c));
        }

        @Override // g.a.f
        public void onSubscribe(g.a.u0.c cVar) {
            this.f14028a.b(cVar);
            this.f14029b.onSubscribe(this.f14028a);
        }
    }

    public h(g.a.i iVar, long j2, TimeUnit timeUnit, g.a.j0 j0Var, boolean z) {
        this.f14023a = iVar;
        this.f14024b = j2;
        this.f14025c = timeUnit;
        this.f14026d = j0Var;
        this.f14027e = z;
    }

    @Override // g.a.c
    protected void b(g.a.f fVar) {
        this.f14023a.a(new a(new g.a.u0.b(), fVar));
    }
}
