package g.a.y0.e.b;

/* compiled from: FlowableConcatMapPublisher.java */
/* loaded from: classes2.dex */
public final class z<T, R> extends g.a.l<R> {

    /* renamed from: b, reason: collision with root package name */
    final i.d.b<T> f14729b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends i.d.b<? extends R>> f14730c;

    /* renamed from: d, reason: collision with root package name */
    final int f14731d;

    /* renamed from: e, reason: collision with root package name */
    final g.a.y0.j.j f14732e;

    public z(i.d.b<T> bVar, g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar, int i2, g.a.y0.j.j jVar) {
        this.f14729b = bVar;
        this.f14730c = oVar;
        this.f14731d = i2;
        this.f14732e = jVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super R> cVar) {
        if (d3.a(this.f14729b, cVar, this.f14730c)) {
            return;
        }
        this.f14729b.subscribe(w.a(cVar, this.f14730c, this.f14731d, this.f14732e));
    }
}
