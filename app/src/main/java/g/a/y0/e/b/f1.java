package g.a.y0.e.b;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: FlowableFromFuture.java */
/* loaded from: classes2.dex */
public final class f1<T> extends g.a.l<T> {

    /* renamed from: b, reason: collision with root package name */
    final Future<? extends T> f14212b;

    /* renamed from: c, reason: collision with root package name */
    final long f14213c;

    /* renamed from: d, reason: collision with root package name */
    final TimeUnit f14214d;

    public f1(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        this.f14212b = future;
        this.f14213c = j2;
        this.f14214d = timeUnit;
    }

    @Override // g.a.l
    public void d(i.d.c<? super T> cVar) {
        g.a.y0.i.f fVar = new g.a.y0.i.f(cVar);
        cVar.onSubscribe(fVar);
        try {
            T t = this.f14214d != null ? this.f14212b.get(this.f14213c, this.f14214d) : this.f14212b.get();
            if (t == null) {
                cVar.onError(new NullPointerException("The future returned null"));
            } else {
                fVar.complete(t);
            }
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            if (fVar.isCancelled()) {
                return;
            }
            cVar.onError(th);
        }
    }
}
