package g.a.y0.e.b;

import g.a.y0.e.b.u3;

/* compiled from: FlowableTakePublisher.java */
/* loaded from: classes2.dex */
public final class y3<T> extends g.a.l<T> {

    /* renamed from: b, reason: collision with root package name */
    final i.d.b<T> f14727b;

    /* renamed from: c, reason: collision with root package name */
    final long f14728c;

    public y3(i.d.b<T> bVar, long j2) {
        this.f14727b = bVar;
        this.f14728c = j2;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14727b.subscribe(new u3.a(cVar, this.f14728c));
    }
}
