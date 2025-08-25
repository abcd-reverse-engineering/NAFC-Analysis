package g.a.y0.e.a;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: CompletableTimeout.java */
/* loaded from: classes2.dex */
public final class j0 extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final g.a.i f14051a;

    /* renamed from: b, reason: collision with root package name */
    final long f14052b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f14053c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.j0 f14054d;

    /* renamed from: e, reason: collision with root package name */
    final g.a.i f14055e;

    /* compiled from: CompletableTimeout.java */
    final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicBoolean f14056a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.u0.b f14057b;

        /* renamed from: c, reason: collision with root package name */
        final g.a.f f14058c;

        /* compiled from: CompletableTimeout.java */
        /* renamed from: g.a.y0.e.a.j0$a$a, reason: collision with other inner class name */
        final class C0185a implements g.a.f {
            C0185a() {
            }

            @Override // g.a.f
            public void onComplete() {
                a.this.f14057b.dispose();
                a.this.f14058c.onComplete();
            }

            @Override // g.a.f
            public void onError(Throwable th) {
                a.this.f14057b.dispose();
                a.this.f14058c.onError(th);
            }

            @Override // g.a.f
            public void onSubscribe(g.a.u0.c cVar) {
                a.this.f14057b.b(cVar);
            }
        }

        a(AtomicBoolean atomicBoolean, g.a.u0.b bVar, g.a.f fVar) {
            this.f14056a = atomicBoolean;
            this.f14057b = bVar;
            this.f14058c = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f14056a.compareAndSet(false, true)) {
                this.f14057b.a();
                g.a.i iVar = j0.this.f14055e;
                if (iVar == null) {
                    this.f14058c.onError(new TimeoutException());
                } else {
                    iVar.a(new C0185a());
                }
            }
        }
    }

    /* compiled from: CompletableTimeout.java */
    static final class b implements g.a.f {

        /* renamed from: a, reason: collision with root package name */
        private final g.a.u0.b f14061a;

        /* renamed from: b, reason: collision with root package name */
        private final AtomicBoolean f14062b;

        /* renamed from: c, reason: collision with root package name */
        private final g.a.f f14063c;

        b(g.a.u0.b bVar, AtomicBoolean atomicBoolean, g.a.f fVar) {
            this.f14061a = bVar;
            this.f14062b = atomicBoolean;
            this.f14063c = fVar;
        }

        @Override // g.a.f
        public void onComplete() {
            if (this.f14062b.compareAndSet(false, true)) {
                this.f14061a.dispose();
                this.f14063c.onComplete();
            }
        }

        @Override // g.a.f
        public void onError(Throwable th) {
            if (!this.f14062b.compareAndSet(false, true)) {
                g.a.c1.a.b(th);
            } else {
                this.f14061a.dispose();
                this.f14063c.onError(th);
            }
        }

        @Override // g.a.f
        public void onSubscribe(g.a.u0.c cVar) {
            this.f14061a.b(cVar);
        }
    }

    public j0(g.a.i iVar, long j2, TimeUnit timeUnit, g.a.j0 j0Var, g.a.i iVar2) {
        this.f14051a = iVar;
        this.f14052b = j2;
        this.f14053c = timeUnit;
        this.f14054d = j0Var;
        this.f14055e = iVar2;
    }

    @Override // g.a.c
    public void b(g.a.f fVar) {
        g.a.u0.b bVar = new g.a.u0.b();
        fVar.onSubscribe(bVar);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        bVar.b(this.f14054d.a(new a(atomicBoolean, bVar, fVar), this.f14052b, this.f14053c));
        this.f14051a.a(new b(bVar, atomicBoolean, fVar));
    }
}
