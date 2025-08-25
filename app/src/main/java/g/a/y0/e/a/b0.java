package g.a.y0.e.a;

import g.a.y0.e.a.a0;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: CompletableMergeDelayErrorIterable.java */
/* loaded from: classes2.dex */
public final class b0 extends g.a.c {

    /* renamed from: a, reason: collision with root package name */
    final Iterable<? extends g.a.i> f13998a;

    public b0(Iterable<? extends g.a.i> iterable) {
        this.f13998a = iterable;
    }

    @Override // g.a.c
    public void b(g.a.f fVar) {
        g.a.u0.b bVar = new g.a.u0.b();
        fVar.onSubscribe(bVar);
        try {
            Iterator it = (Iterator) g.a.y0.b.b.a(this.f13998a.iterator(), "The source iterator returned is null");
            AtomicInteger atomicInteger = new AtomicInteger(1);
            g.a.y0.j.c cVar = new g.a.y0.j.c();
            while (!bVar.isDisposed()) {
                try {
                    if (it.hasNext()) {
                        if (bVar.isDisposed()) {
                            return;
                        }
                        try {
                            g.a.i iVar = (g.a.i) g.a.y0.b.b.a(it.next(), "The iterator returned a null CompletableSource");
                            if (bVar.isDisposed()) {
                                return;
                            }
                            atomicInteger.getAndIncrement();
                            iVar.a(new a0.a(fVar, bVar, cVar, atomicInteger));
                        } catch (Throwable th) {
                            g.a.v0.b.b(th);
                            cVar.addThrowable(th);
                        }
                    }
                } catch (Throwable th2) {
                    g.a.v0.b.b(th2);
                    cVar.addThrowable(th2);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    Throwable thTerminate = cVar.terminate();
                    if (thTerminate == null) {
                        fVar.onComplete();
                        return;
                    } else {
                        fVar.onError(thTerminate);
                        return;
                    }
                }
                return;
            }
        } catch (Throwable th3) {
            g.a.v0.b.b(th3);
            fVar.onError(th3);
        }
    }
}
