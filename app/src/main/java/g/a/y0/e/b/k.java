package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: FlowableAutoConnect.java */
/* loaded from: classes2.dex */
public final class k<T> extends g.a.l<T> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.w0.a<? extends T> f14313b;

    /* renamed from: c, reason: collision with root package name */
    final int f14314c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.x0.g<? super g.a.u0.c> f14315d;

    /* renamed from: e, reason: collision with root package name */
    final AtomicInteger f14316e = new AtomicInteger();

    public k(g.a.w0.a<? extends T> aVar, int i2, g.a.x0.g<? super g.a.u0.c> gVar) {
        this.f14313b = aVar;
        this.f14314c = i2;
        this.f14315d = gVar;
    }

    @Override // g.a.l
    public void d(i.d.c<? super T> cVar) {
        this.f14313b.subscribe(cVar);
        if (this.f14316e.incrementAndGet() == this.f14314c) {
            this.f14313b.l(this.f14315d);
        }
    }
}
