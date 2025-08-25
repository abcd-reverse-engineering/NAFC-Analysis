package g.a.y0.h;

import g.a.y0.j.v;
import h.q2.t.m0;

/* compiled from: QueueDrainSubscriber.java */
/* loaded from: classes2.dex */
public abstract class m<T, U, V> extends q implements g.a.q<T>, g.a.y0.j.u<U, V> {
    protected final i.d.c<? super V> h0;
    protected final g.a.y0.c.n<U> i0;
    protected volatile boolean j0;
    protected volatile boolean k0;
    protected Throwable l0;

    public m(i.d.c<? super V> cVar, g.a.y0.c.n<U> nVar) {
        this.h0 = cVar;
        this.i0 = nVar;
    }

    protected final void a(U u, boolean z, g.a.u0.c cVar) {
        i.d.c<? super V> cVar2 = this.h0;
        g.a.y0.c.n<U> nVar = this.i0;
        if (this.p.get() == 0 && this.p.compareAndSet(0, 1)) {
            long j2 = this.F.get();
            if (j2 == 0) {
                cVar.dispose();
                cVar2.onError(new g.a.v0.c("Could not emit buffer due to lack of requests"));
                return;
            } else {
                if (a(cVar2, u) && j2 != m0.f16408b) {
                    a(1L);
                }
                if (a(-1) == 0) {
                    return;
                }
            }
        } else {
            nVar.offer(u);
            if (!b()) {
                return;
            }
        }
        v.a(nVar, cVar2, z, cVar, this);
    }

    public boolean a(i.d.c<? super V> cVar, U u) {
        return false;
    }

    @Override // g.a.y0.j.u
    public final boolean b() {
        return this.p.getAndIncrement() == 0;
    }

    @Override // g.a.y0.j.u
    public final boolean c() {
        return this.k0;
    }

    @Override // g.a.y0.j.u
    public final boolean d() {
        return this.j0;
    }

    public final boolean e() {
        return this.p.get() == 0 && this.p.compareAndSet(0, 1);
    }

    @Override // g.a.y0.j.u
    public final long requested() {
        return this.F.get();
    }

    protected final void b(U u, boolean z, g.a.u0.c cVar) {
        i.d.c<? super V> cVar2 = this.h0;
        g.a.y0.c.n<U> nVar = this.i0;
        if (this.p.get() == 0 && this.p.compareAndSet(0, 1)) {
            long j2 = this.F.get();
            if (j2 == 0) {
                this.j0 = true;
                cVar.dispose();
                cVar2.onError(new g.a.v0.c("Could not emit buffer due to lack of requests"));
                return;
            } else if (nVar.isEmpty()) {
                if (a(cVar2, u) && j2 != m0.f16408b) {
                    a(1L);
                }
                if (a(-1) == 0) {
                    return;
                }
            } else {
                nVar.offer(u);
            }
        } else {
            nVar.offer(u);
            if (!b()) {
                return;
            }
        }
        v.a(nVar, cVar2, z, cVar, this);
    }

    @Override // g.a.y0.j.u
    public final Throwable a() {
        return this.l0;
    }

    @Override // g.a.y0.j.u
    public final int a(int i2) {
        return this.p.addAndGet(i2);
    }

    @Override // g.a.y0.j.u
    public final long a(long j2) {
        return this.F.addAndGet(-j2);
    }

    public final void b(long j2) {
        if (g.a.y0.i.j.validate(j2)) {
            g.a.y0.j.d.a(this.F, j2);
        }
    }
}
