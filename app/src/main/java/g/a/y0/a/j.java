package g.a.y0.a;

import g.a.i0;
import g.a.y0.j.q;

/* compiled from: ObserverFullArbiter.java */
/* loaded from: classes2.dex */
public final class j<T> extends g implements g.a.u0.c {
    final i0<? super T> F;
    final g.a.y0.f.c<Object> G;
    volatile g.a.u0.c H = e.INSTANCE;
    g.a.u0.c I;
    volatile boolean J;

    public j(i0<? super T> i0Var, g.a.u0.c cVar, int i2) {
        this.F = i0Var;
        this.I = cVar;
        this.G = new g.a.y0.f.c<>(i2);
    }

    void a() {
        g.a.u0.c cVar = this.I;
        this.I = null;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    public boolean b(g.a.u0.c cVar) {
        if (this.J) {
            return false;
        }
        this.G.offer(this.H, q.disposable(cVar));
        b();
        return true;
    }

    @Override // g.a.u0.c
    public void dispose() {
        if (this.J) {
            return;
        }
        this.J = true;
        a();
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        g.a.u0.c cVar = this.I;
        return cVar != null ? cVar.isDisposed() : this.J;
    }

    public boolean a(T t, g.a.u0.c cVar) {
        if (this.J) {
            return false;
        }
        this.G.offer(cVar, q.next(t));
        b();
        return true;
    }

    void b() {
        if (this.p.getAndIncrement() != 0) {
            return;
        }
        g.a.y0.f.c<Object> cVar = this.G;
        i0<? super T> i0Var = this.F;
        int iAddAndGet = 1;
        while (true) {
            Object objPoll = cVar.poll();
            if (objPoll == null) {
                iAddAndGet = this.p.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                Object objPoll2 = cVar.poll();
                if (objPoll == this.H) {
                    if (q.isDisposable(objPoll2)) {
                        g.a.u0.c disposable = q.getDisposable(objPoll2);
                        this.H.dispose();
                        if (!this.J) {
                            this.H = disposable;
                        } else {
                            disposable.dispose();
                        }
                    } else if (q.isError(objPoll2)) {
                        cVar.clear();
                        a();
                        Throwable error = q.getError(objPoll2);
                        if (!this.J) {
                            this.J = true;
                            i0Var.onError(error);
                        } else {
                            g.a.c1.a.b(error);
                        }
                    } else if (q.isComplete(objPoll2)) {
                        cVar.clear();
                        a();
                        if (!this.J) {
                            this.J = true;
                            i0Var.onComplete();
                        }
                    } else {
                        i0Var.onNext((Object) q.getValue(objPoll2));
                    }
                }
            }
        }
    }

    public void a(Throwable th, g.a.u0.c cVar) {
        if (this.J) {
            g.a.c1.a.b(th);
        } else {
            this.G.offer(cVar, q.error(th));
            b();
        }
    }

    public void a(g.a.u0.c cVar) {
        this.G.offer(cVar, q.complete());
        b();
    }
}
