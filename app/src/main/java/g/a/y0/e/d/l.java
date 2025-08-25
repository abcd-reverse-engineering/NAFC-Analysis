package g.a.y0.e.d;

import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: ObservableBlockingSubscribe.java */
/* loaded from: classes2.dex */
public final class l {
    private l() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> void a(g.a.g0<? extends T> g0Var, g.a.i0<? super T> i0Var) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        g.a.y0.d.i iVar = new g.a.y0.d.i(linkedBlockingQueue);
        i0Var.onSubscribe(iVar);
        g0Var.subscribe(iVar);
        while (!iVar.isDisposed()) {
            Object objPoll = linkedBlockingQueue.poll();
            if (objPoll == null) {
                try {
                    objPoll = linkedBlockingQueue.take();
                } catch (InterruptedException e2) {
                    iVar.dispose();
                    i0Var.onError(e2);
                    return;
                }
            }
            if (iVar.isDisposed() || g0Var == g.a.y0.d.i.TERMINATED || g.a.y0.j.q.acceptFull(objPoll, i0Var)) {
                return;
            }
        }
    }

    public static <T> void a(g.a.g0<? extends T> g0Var) {
        g.a.y0.j.f fVar = new g.a.y0.j.f();
        g.a.y0.d.v vVar = new g.a.y0.d.v(g.a.y0.b.a.d(), fVar, fVar, g.a.y0.b.a.d());
        g0Var.subscribe(vVar);
        g.a.y0.j.e.a(fVar, vVar);
        Throwable th = fVar.f16042a;
        if (th != null) {
            throw g.a.y0.j.k.c(th);
        }
    }

    public static <T> void a(g.a.g0<? extends T> g0Var, g.a.x0.g<? super T> gVar, g.a.x0.g<? super Throwable> gVar2, g.a.x0.a aVar) {
        g.a.y0.b.b.a(gVar, "onNext is null");
        g.a.y0.b.b.a(gVar2, "onError is null");
        g.a.y0.b.b.a(aVar, "onComplete is null");
        a(g0Var, new g.a.y0.d.v(gVar, gVar2, aVar, g.a.y0.b.a.d()));
    }
}
