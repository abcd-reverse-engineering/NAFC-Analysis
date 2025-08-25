package h.a3;

import h.q2.t.v;

/* compiled from: TimeSource.kt */
@j
/* loaded from: classes2.dex */
final class c extends o {

    /* renamed from: a, reason: collision with root package name */
    @i.c.a.d
    private final o f16076a;

    /* renamed from: b, reason: collision with root package name */
    private final double f16077b;

    private c(o oVar, double d2) {
        this.f16076a = oVar;
        this.f16077b = d2;
    }

    @Override // h.a3.o
    public double a() {
        return d.e(this.f16076a.a(), this.f16077b);
    }

    @Override // h.a3.o
    @i.c.a.d
    public o b(double d2) {
        return new c(this.f16076a, d.f(this.f16077b, d2), null);
    }

    public final double d() {
        return this.f16077b;
    }

    @i.c.a.d
    public final o e() {
        return this.f16076a;
    }

    public /* synthetic */ c(o oVar, double d2, v vVar) {
        this(oVar, d2);
    }
}
