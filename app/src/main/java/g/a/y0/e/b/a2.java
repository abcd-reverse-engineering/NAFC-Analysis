package g.a.y0.e.b;

import g.a.y0.e.b.y1;

/* compiled from: FlowableMapPublisher.java */
/* loaded from: classes2.dex */
public final class a2<T, U> extends g.a.l<U> {

    /* renamed from: b, reason: collision with root package name */
    final i.d.b<T> f14116b;

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends U> f14117c;

    public a2(i.d.b<T> bVar, g.a.x0.o<? super T, ? extends U> oVar) {
        this.f14116b = bVar;
        this.f14117c = oVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super U> cVar) {
        this.f14116b.subscribe(new y1.b(cVar, this.f14117c));
    }
}
