package g.a.y0.e.b;

/* compiled from: FlowableFlatMapPublisher.java */
/* loaded from: classes2.dex */
public final class a1<T, U> extends g.a.l<U> {

    /* renamed from: b, reason: collision with root package name */
    final i.d.b<T> f14111b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends i.d.b<? extends U>> f14112c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f14113d;

    /* renamed from: e, reason: collision with root package name */
    final int f14114e;

    /* renamed from: f, reason: collision with root package name */
    final int f14115f;

    public a1(i.d.b<T> bVar, g.a.x0.o<? super T, ? extends i.d.b<? extends U>> oVar, boolean z, int i2, int i3) {
        this.f14111b = bVar;
        this.f14112c = oVar;
        this.f14113d = z;
        this.f14114e = i2;
        this.f14115f = i3;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super U> cVar) {
        if (d3.a(this.f14111b, cVar, this.f14112c)) {
            return;
        }
        this.f14111b.subscribe(w0.a(cVar, this.f14112c, this.f14113d, this.f14114e, this.f14115f));
    }
}
