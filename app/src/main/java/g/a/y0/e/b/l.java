package g.a.y0.e.b;

import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: FlowableBlockingSubscribe.java */
/* loaded from: classes2.dex */
public final class l {
    private l() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> void a(i.d.b<? extends T> bVar, i.d.c<? super T> cVar) {
        Object objPoll;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        g.a.y0.h.f fVar = new g.a.y0.h.f(linkedBlockingQueue);
        bVar.subscribe(fVar);
        do {
            try {
                if (fVar.isCancelled()) {
                    return;
                }
                objPoll = linkedBlockingQueue.poll();
                if (objPoll == null) {
                    if (fVar.isCancelled()) {
                        return;
                    }
                    g.a.y0.j.e.a();
                    objPoll = linkedBlockingQueue.take();
                }
                if (fVar.isCancelled() || bVar == g.a.y0.h.f.TERMINATED) {
                    return;
                }
            } catch (InterruptedException e2) {
                fVar.cancel();
                cVar.onError(e2);
                return;
            }
        } while (!g.a.y0.j.q.acceptFull(objPoll, cVar));
    }

    public static <T> void a(i.d.b<? extends T> bVar) {
        g.a.y0.j.f fVar = new g.a.y0.j.f();
        g.a.y0.h.l lVar = new g.a.y0.h.l(g.a.y0.b.a.d(), fVar, fVar, g.a.y0.b.a.f13908l);
        bVar.subscribe(lVar);
        g.a.y0.j.e.a(fVar, lVar);
        Throwable th = fVar.f16042a;
        if (th != null) {
            throw g.a.y0.j.k.c(th);
        }
    }

    public static <T> void a(i.d.b<? extends T> bVar, g.a.x0.g<? super T> gVar, g.a.x0.g<? super Throwable> gVar2, g.a.x0.a aVar) {
        g.a.y0.b.b.a(gVar, "onNext is null");
        g.a.y0.b.b.a(gVar2, "onError is null");
        g.a.y0.b.b.a(aVar, "onComplete is null");
        a(bVar, new g.a.y0.h.l(gVar, gVar2, aVar, g.a.y0.b.a.f13908l));
    }
}
