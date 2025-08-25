package g.a.y0.d;

import g.a.i0;

/* compiled from: BasicFuseableObserver.java */
/* loaded from: classes2.dex */
public abstract class a<T, R> implements i0<T>, g.a.y0.c.j<R> {

    /* renamed from: a, reason: collision with root package name */
    protected final i0<? super R> f13940a;

    /* renamed from: b, reason: collision with root package name */
    protected g.a.u0.c f13941b;

    /* renamed from: c, reason: collision with root package name */
    protected g.a.y0.c.j<T> f13942c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f13943d;

    /* renamed from: e, reason: collision with root package name */
    protected int f13944e;

    public a(i0<? super R> i0Var) {
        this.f13940a = i0Var;
    }

    protected void a() {
    }

    protected final void a(Throwable th) {
        g.a.v0.b.b(th);
        this.f13941b.dispose();
        onError(th);
    }

    protected boolean b() {
        return true;
    }

    @Override // g.a.y0.c.o
    public void clear() {
        this.f13942c.clear();
    }

    @Override // g.a.u0.c
    public void dispose() {
        this.f13941b.dispose();
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return this.f13941b.isDisposed();
    }

    @Override // g.a.y0.c.o
    public boolean isEmpty() {
        return this.f13942c.isEmpty();
    }

    @Override // g.a.y0.c.o
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // g.a.i0
    public void onComplete() {
        if (this.f13943d) {
            return;
        }
        this.f13943d = true;
        this.f13940a.onComplete();
    }

    @Override // g.a.i0
    public void onError(Throwable th) {
        if (this.f13943d) {
            g.a.c1.a.b(th);
        } else {
            this.f13943d = true;
            this.f13940a.onError(th);
        }
    }

    @Override // g.a.i0
    public final void onSubscribe(g.a.u0.c cVar) {
        if (g.a.y0.a.d.validate(this.f13941b, cVar)) {
            this.f13941b = cVar;
            if (cVar instanceof g.a.y0.c.j) {
                this.f13942c = (g.a.y0.c.j) cVar;
            }
            if (b()) {
                this.f13940a.onSubscribe(this);
                a();
            }
        }
    }

    @Override // g.a.y0.c.o
    public final boolean offer(R r, R r2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    protected final int a(int i2) {
        g.a.y0.c.j<T> jVar = this.f13942c;
        if (jVar == null || (i2 & 4) != 0) {
            return 0;
        }
        int iRequestFusion = jVar.requestFusion(i2);
        if (iRequestFusion != 0) {
            this.f13944e = iRequestFusion;
        }
        return iRequestFusion;
    }
}
