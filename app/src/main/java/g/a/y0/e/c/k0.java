package g.a.y0.e.c;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: MaybeFromFuture.java */
/* loaded from: classes2.dex */
public final class k0<T> extends g.a.s<T> {

    /* renamed from: a, reason: collision with root package name */
    final Future<? extends T> f14830a;

    /* renamed from: b, reason: collision with root package name */
    final long f14831b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f14832c;

    public k0(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        this.f14830a = future;
        this.f14831b = j2;
        this.f14832c = timeUnit;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        g.a.u0.c cVarB = g.a.u0.d.b();
        vVar.onSubscribe(cVarB);
        if (cVarB.isDisposed()) {
            return;
        }
        try {
            T t = this.f14831b <= 0 ? this.f14830a.get() : this.f14830a.get(this.f14831b, this.f14832c);
            if (cVarB.isDisposed()) {
                return;
            }
            if (t == null) {
                vVar.onComplete();
            } else {
                vVar.onSuccess(t);
            }
        } catch (InterruptedException e2) {
            if (cVarB.isDisposed()) {
                return;
            }
            vVar.onError(e2);
        } catch (ExecutionException e3) {
            if (cVarB.isDisposed()) {
                return;
            }
            vVar.onError(e3.getCause());
        } catch (TimeoutException e4) {
            if (cVarB.isDisposed()) {
                return;
            }
            vVar.onError(e4);
        }
    }
}
