package g.a.y0.e.d;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: ObservableFromFuture.java */
/* loaded from: classes2.dex */
public final class c1<T> extends g.a.b0<T> {

    /* renamed from: a, reason: collision with root package name */
    final Future<? extends T> f15004a;

    /* renamed from: b, reason: collision with root package name */
    final long f15005b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f15006c;

    public c1(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        this.f15004a = future;
        this.f15005b = j2;
        this.f15006c = timeUnit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g.a.b0
    public void d(g.a.i0<? super T> i0Var) {
        g.a.y0.d.l lVar = new g.a.y0.d.l(i0Var);
        i0Var.onSubscribe(lVar);
        if (lVar.isDisposed()) {
            return;
        }
        try {
            lVar.complete(g.a.y0.b.b.a((Object) (this.f15006c != null ? this.f15004a.get(this.f15005b, this.f15006c) : this.f15004a.get()), "Future returned null"));
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            if (lVar.isDisposed()) {
                return;
            }
            i0Var.onError(th);
        }
    }
}
