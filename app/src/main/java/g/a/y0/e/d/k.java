package g.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableAutoConnect.java */
/* loaded from: classes2.dex */
public final class k<T> extends g.a.b0<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.z0.a<? extends T> f15232a;

    /* renamed from: b, reason: collision with root package name */
    final int f15233b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.g<? super g.a.u0.c> f15234c;

    /* renamed from: d, reason: collision with root package name */
    final AtomicInteger f15235d = new AtomicInteger();

    public k(g.a.z0.a<? extends T> aVar, int i2, g.a.x0.g<? super g.a.u0.c> gVar) {
        this.f15232a = aVar;
        this.f15233b = i2;
        this.f15234c = gVar;
    }

    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        this.f15232a.subscribe(i0Var);
        if (this.f15235d.incrementAndGet() == this.f15233b) {
            this.f15232a.k(this.f15234c);
        }
    }
}
