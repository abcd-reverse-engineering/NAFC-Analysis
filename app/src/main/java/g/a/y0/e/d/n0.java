package g.a.y0.e.d;

/* compiled from: ObservableDoOnLifecycle.java */
/* loaded from: classes2.dex */
public final class n0<T> extends a<T, T> {

    /* renamed from: b, reason: collision with root package name */
    private final g.a.x0.g<? super g.a.u0.c> f15338b;

    /* renamed from: c, reason: collision with root package name */
    private final g.a.x0.a f15339c;

    public n0(g.a.b0<T> b0Var, g.a.x0.g<? super g.a.u0.c> gVar, g.a.x0.a aVar) {
        super(b0Var);
        this.f15338b = gVar;
        this.f15339c = aVar;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super T> i0Var) {
        this.f14934a.subscribe(new g.a.y0.d.n(i0Var, this.f15338b, this.f15339c));
    }
}
