package g.a.y0.e.a;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: CompletableMergeDelayErrorArray.java */
/* loaded from: classes2.dex */
public final class a0 extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final g.a.i[] f13987a;

    /* compiled from: CompletableMergeDelayErrorArray.java */
    static final class a implements g.a.f {

        /* renamed from: a, reason: collision with root package name */
        final g.a.f f13988a;

        /* renamed from: b, reason: collision with root package name */
        final g.a.u0.b f13989b;

        /* renamed from: c, reason: collision with root package name */
        final g.a.y0.j.c f13990c;

        /* renamed from: d, reason: collision with root package name */
        final AtomicInteger f13991d;

        a(g.a.f fVar, g.a.u0.b bVar, g.a.y0.j.c cVar, AtomicInteger atomicInteger) {
            this.f13988a = fVar;
            this.f13989b = bVar;
            this.f13990c = cVar;
            this.f13991d = atomicInteger;
        }

        void a() {
            if (this.f13991d.decrementAndGet() == 0) {
                Throwable thTerminate = this.f13990c.terminate();
                if (thTerminate == null) {
                    this.f13988a.onComplete();
                } else {
                    this.f13988a.onError(thTerminate);
                }
            }
        }

        @Override // g.a.f
        public void onComplete() {
            a();
        }

        @Override // g.a.f
        public void onError(Throwable th) {
            if (this.f13990c.addThrowable(th)) {
                a();
            } else {
                g.a.c1.a.b(th);
            }
        }

        @Override // g.a.f
        public void onSubscribe(g.a.u0.c cVar) {
            this.f13989b.b(cVar);
        }
    }

    public a0(g.a.i[] iVarArr) {
        this.f13987a = iVarArr;
    }

    @Override // g.a.c
    public void b(g.a.f fVar) {
        g.a.u0.b bVar = new g.a.u0.b();
        AtomicInteger atomicInteger = new AtomicInteger(this.f13987a.length + 1);
        g.a.y0.j.c cVar = new g.a.y0.j.c();
        fVar.onSubscribe(bVar);
        for (g.a.i iVar : this.f13987a) {
            if (bVar.isDisposed()) {
                return;
            }
            if (iVar == null) {
                cVar.addThrowable(new NullPointerException("A completable source is null"));
                atomicInteger.decrementAndGet();
            } else {
                iVar.a(new a(fVar, bVar, cVar, atomicInteger));
            }
        }
        if (atomicInteger.decrementAndGet() == 0) {
            Throwable thTerminate = cVar.terminate();
            if (thTerminate == null) {
                fVar.onComplete();
            } else {
                fVar.onError(thTerminate);
            }
        }
    }
}
