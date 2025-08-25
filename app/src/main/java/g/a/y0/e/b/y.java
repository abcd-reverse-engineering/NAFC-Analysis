package g.a.y0.e.b;

import g.a.y0.e.b.x;

/* compiled from: FlowableConcatMapEagerPublisher.java */
/* loaded from: classes2.dex */
public final class y<T, R> extends g.a.l<R> {

    /* renamed from: b, reason: collision with root package name */
    final i.d.b<T> f14714b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends i.d.b<? extends R>> f14715c;

    /* renamed from: d, reason: collision with root package name */
    final int f14716d;

    /* renamed from: e, reason: collision with root package name */
    final int f14717e;

    /* renamed from: f, reason: collision with root package name */
    final g.a.y0.j.j f14718f;

    public y(i.d.b<T> bVar, g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar, int i2, int i3, g.a.y0.j.j jVar) {
        this.f14714b = bVar;
        this.f14715c = oVar;
        this.f14716d = i2;
        this.f14717e = i3;
        this.f14718f = jVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super R> cVar) {
        this.f14714b.subscribe(new x.a(cVar, this.f14715c, this.f14716d, this.f14717e, this.f14718f));
    }
}
