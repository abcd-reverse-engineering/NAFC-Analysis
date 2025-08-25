package g.a.y0.h;

/* compiled from: BasicFuseableSubscriber.java */
/* loaded from: classes2.dex */
public abstract class b<T, R> implements g.a.q<T>, g.a.y0.c.l<R> {

    /* renamed from: a, reason: collision with root package name */
    protected final i.d.c<? super R> f16010a;

    /* renamed from: b, reason: collision with root package name */
    protected i.d.d f16011b;

    /* renamed from: c, reason: collision with root package name */
    protected g.a.y0.c.l<T> f16012c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f16013d;

    /* renamed from: e, reason: collision with root package name */
    protected int f16014e;

    public b(i.d.c<? super R> cVar) {
        this.f16010a = cVar;
    }

    protected void a() {
    }

    protected final void a(Throwable th) {
        g.a.v0.b.b(th);
        this.f16011b.cancel();
        onError(th);
    }

    protected boolean b() {
        return true;
    }

    @Override // i.d.d
    public void cancel() {
        this.f16011b.cancel();
    }

    public void clear() {
        this.f16012c.clear();
    }

    @Override // g.a.y0.c.o
    public boolean isEmpty() {
        return this.f16012c.isEmpty();
    }

    @Override // g.a.y0.c.o
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // i.d.c
    public void onComplete() {
        if (this.f16013d) {
            return;
        }
        this.f16013d = true;
        this.f16010a.onComplete();
    }

    @Override // i.d.c
    public void onError(Throwable th) {
        if (this.f16013d) {
            g.a.c1.a.b(th);
        } else {
            this.f16013d = true;
            this.f16010a.onError(th);
        }
    }

    @Override // g.a.q
    public final void onSubscribe(i.d.d dVar) {
        if (g.a.y0.i.j.validate(this.f16011b, dVar)) {
            this.f16011b = dVar;
            if (dVar instanceof g.a.y0.c.l) {
                this.f16012c = (g.a.y0.c.l) dVar;
            }
            if (b()) {
                this.f16010a.onSubscribe(this);
                a();
            }
        }
    }

    @Override // i.d.d
    public void request(long j2) {
        this.f16011b.request(j2);
    }

    @Override // g.a.y0.c.o
    public final boolean offer(R r, R r2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    protected final int a(int i2) {
        g.a.y0.c.l<T> lVar = this.f16012c;
        if (lVar == null || (i2 & 4) != 0) {
            return 0;
        }
        int iRequestFusion = lVar.requestFusion(i2);
        if (iRequestFusion != 0) {
            this.f16014e = iRequestFusion;
        }
        return iRequestFusion;
    }
}
