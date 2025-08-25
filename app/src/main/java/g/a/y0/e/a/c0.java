package g.a.y0.e.a;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: CompletableMergeIterable.java */
/* loaded from: classes2.dex */
public final class c0 extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final Iterable<? extends g.a.i> f14001a;

    /* compiled from: CompletableMergeIterable.java */
    static final class a extends AtomicBoolean implements g.a.f {
        private static final long serialVersionUID = -7730517613164279224L;
        final g.a.f actual;
        final g.a.u0.b set;
        final AtomicInteger wip;

        a(g.a.f fVar, g.a.u0.b bVar, AtomicInteger atomicInteger) {
            this.actual = fVar;
            this.set = bVar;
            this.wip = atomicInteger;
        }

        @Override // g.a.f
        public void onComplete() {
            if (this.wip.decrementAndGet() == 0 && compareAndSet(false, true)) {
                this.actual.onComplete();
            }
        }

        @Override // g.a.f
        public void onError(Throwable th) {
            this.set.dispose();
            if (compareAndSet(false, true)) {
                this.actual.onError(th);
            } else {
                g.a.c1.a.b(th);
            }
        }

        @Override // g.a.f
        public void onSubscribe(g.a.u0.c cVar) {
            this.set.b(cVar);
        }
    }

    public c0(Iterable<? extends g.a.i> iterable) {
        this.f14001a = iterable;
    }

    @Override // g.a.c
    public void b(g.a.f fVar) {
        g.a.u0.b bVar = new g.a.u0.b();
        fVar.onSubscribe(bVar);
        try {
            Iterator it = (Iterator) g.a.y0.b.b.a(this.f14001a.iterator(), "The source iterator returned is null");
            AtomicInteger atomicInteger = new AtomicInteger(1);
            a aVar = new a(fVar, bVar, atomicInteger);
            while (!bVar.isDisposed()) {
                try {
                    if (!it.hasNext()) {
                        aVar.onComplete();
                        return;
                    }
                    if (bVar.isDisposed()) {
                        return;
                    }
                    try {
                        g.a.i iVar = (g.a.i) g.a.y0.b.b.a(it.next(), "The iterator returned a null CompletableSource");
                        if (bVar.isDisposed()) {
                            return;
                        }
                        atomicInteger.getAndIncrement();
                        iVar.a(aVar);
                    } catch (Throwable th) {
                        g.a.v0.b.b(th);
                        bVar.dispose();
                        aVar.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    g.a.v0.b.b(th2);
                    bVar.dispose();
                    aVar.onError(th2);
                    return;
                }
            }
        } catch (Throwable th3) {
            g.a.v0.b.b(th3);
            fVar.onError(th3);
        }
    }
}
