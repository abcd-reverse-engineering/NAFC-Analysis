package g.a.y0.e.b;

/* compiled from: FlowableFromPublisher.java */
/* loaded from: classes2.dex */
public final class i1<T> extends g.a.l<T> {

    /* renamed from: b, reason: collision with root package name */
    final i.d.b<? extends T> f14285b;

    public i1(i.d.b<? extends T> bVar) {
        this.f14285b = bVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14285b.subscribe(cVar);
    }
}
