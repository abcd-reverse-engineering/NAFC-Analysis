package g.a.y0.h;

/* compiled from: BasicFuseableConditionalSubscriber.java */
/* loaded from: classes2.dex */
public abstract class a<T, R> implements g.a.y0.c.a<T>, g.a.y0.c.l<R> {

    /* renamed from: a, reason: collision with root package name */
    protected final g.a.y0.c.a<? super R> f16005a;

    /* renamed from: b, reason: collision with root package name */
    protected i.d.d f16006b;

    /* renamed from: c, reason: collision with root package name */
    protected g.a.y0.c.l<T> f16007c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f16008d;

    /* renamed from: e, reason: collision with root package name */
    protected int f16009e;

    public a(g.a.y0.c.a<? super R> aVar) {
        this.f16005a = aVar;
    }

    protected void a() {
    }

    protected final void a(Throwable th) {
        g.a.v0.b.b(th);
        this.f16006b.cancel();
        onError(th);
    }

    protected boolean b() {
        return true;
    }

    @Override // i.d.d
    public void cancel() {
        this.f16006b.cancel();
    }

    @Override // g.a.y0.c.o
    public void clear() {
        this.f16007c.clear();
    }

    @Override // g.a.y0.c.o
    public boolean isEmpty() {
        return this.f16007c.isEmpty();
    }

    @Override // g.a.y0.c.o
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // i.d.c
    public void onComplete() {
        if (this.f16008d) {
            return;
        }
        this.f16008d = true;
        this.f16005a.onComplete();
    }

    @Override // i.d.c
    public void onError(Throwable th) {
        if (this.f16008d) {
            g.a.c1.a.b(th);
        } else {
            this.f16008d = true;
            this.f16005a.onError(th);
        }
    }

    @Override // g.a.q
    public final void onSubscribe(i.d.d dVar) {
        if (g.a.y0.i.j.validate(this.f16006b, dVar)) {
            this.f16006b = dVar;
            if (dVar instanceof g.a.y0.c.l) {
                this.f16007c = (g.a.y0.c.l) dVar;
            }
            if (b()) {
                this.f16005a.onSubscribe(this);
                a();
            }
        }
    }

    @Override // i.d.d
    public void request(long j2) {
        this.f16006b.request(j2);
    }

    @Override // g.a.y0.c.o
    public final boolean offer(R r, R r2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    protected final int a(int i2) {
        g.a.y0.c.l<T> lVar = this.f16007c;
        if (lVar == null || (i2 & 4) != 0) {
            return 0;
        }
        int iRequestFusion = lVar.requestFusion(i2);
        if (iRequestFusion != 0) {
            this.f16009e = iRequestFusion;
        }
        return iRequestFusion;
    }
}
