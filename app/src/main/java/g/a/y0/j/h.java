package g.a.y0.j;

import g.a.i0;
import g.a.n0;

/* compiled from: EmptyComponent.java */
/* loaded from: classes2.dex */
public enum h implements g.a.q<Object>, i0<Object>, g.a.v<Object>, n0<Object>, g.a.f, i.d.d, g.a.u0.c {
    INSTANCE;

    public static <T> i0<T> asObserver() {
        return INSTANCE;
    }

    public static <T> i.d.c<T> asSubscriber() {
        return INSTANCE;
    }

    @Override // i.d.d
    public void cancel() {
    }

    @Override // g.a.u0.c
    public void dispose() {
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return true;
    }

    @Override // i.d.c
    public void onComplete() {
    }

    @Override // i.d.c
    public void onError(Throwable th) {
        g.a.c1.a.b(th);
    }

    @Override // i.d.c
    public void onNext(Object obj) {
    }

    @Override // g.a.i0
    public void onSubscribe(g.a.u0.c cVar) {
        cVar.dispose();
    }

    @Override // g.a.v, g.a.n0
    public void onSuccess(Object obj) {
    }

    @Override // i.d.d
    public void request(long j2) {
    }

    @Override // g.a.q
    public void onSubscribe(i.d.d dVar) {
        dVar.cancel();
    }
}
