package g.a.y0.d;

import g.a.i0;

/* compiled from: QueueDrainObserver.java */
/* loaded from: classes2.dex */
public abstract class w<T, U, V> extends y implements i0<T>, g.a.y0.j.r<U, V> {
    protected final i0<? super V> F;
    protected final g.a.y0.c.n<U> G;
    protected volatile boolean H;
    protected volatile boolean I;
    protected Throwable J;

    public w(i0<? super V> i0Var, g.a.y0.c.n<U> nVar) {
        this.F = i0Var;
        this.G = nVar;
    }

    @Override // g.a.y0.j.r
    public void a(i0<? super V> i0Var, U u) {
    }

    protected final void a(U u, boolean z, g.a.u0.c cVar) {
        i0<? super V> i0Var = this.F;
        g.a.y0.c.n<U> nVar = this.G;
        if (this.p.get() == 0 && this.p.compareAndSet(0, 1)) {
            a(i0Var, u);
            if (a(-1) == 0) {
                return;
            }
        } else {
            nVar.offer(u);
            if (!b()) {
                return;
            }
        }
        g.a.y0.j.v.a(nVar, i0Var, z, cVar, this);
    }

    @Override // g.a.y0.j.r
    public final boolean b() {
        return this.p.getAndIncrement() == 0;
    }

    @Override // g.a.y0.j.r
    public final boolean c() {
        return this.I;
    }

    @Override // g.a.y0.j.r
    public final boolean d() {
        return this.H;
    }

    public final boolean e() {
        return this.p.get() == 0 && this.p.compareAndSet(0, 1);
    }

    protected final void b(U u, boolean z, g.a.u0.c cVar) {
        i0<? super V> i0Var = this.F;
        g.a.y0.c.n<U> nVar = this.G;
        if (this.p.get() != 0 || !this.p.compareAndSet(0, 1)) {
            nVar.offer(u);
            if (!b()) {
                return;
            }
        } else if (nVar.isEmpty()) {
            a(i0Var, u);
            if (a(-1) == 0) {
                return;
            }
        } else {
            nVar.offer(u);
        }
        g.a.y0.j.v.a(nVar, i0Var, z, cVar, this);
    }

    @Override // g.a.y0.j.r
    public final Throwable a() {
        return this.J;
    }

    @Override // g.a.y0.j.r
    public final int a(int i2) {
        return this.p.addAndGet(i2);
    }
}
