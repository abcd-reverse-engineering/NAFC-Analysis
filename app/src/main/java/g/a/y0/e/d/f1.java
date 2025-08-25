package g.a.y0.e.d;

/* compiled from: ObservableFromUnsafeSource.java */
/* loaded from: classes2.dex */
public final class f1<T> extends g.a.b0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.g0<T> f15111a;

    public f1(g.a.g0<T> g0Var) {
        this.f15111a = g0Var;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super T> i0Var) {
        this.f15111a.subscribe(i0Var);
    }
}
