package g.a;

/* compiled from: SingleEmitter.java */
/* loaded from: classes2.dex */
public interface m0<T> {
    boolean isDisposed();

    void onError(@g.a.t0.f Throwable th);

    void onSuccess(@g.a.t0.f T t);

    void setCancellable(@g.a.t0.g g.a.x0.f fVar);

    void setDisposable(@g.a.t0.g g.a.u0.c cVar);

    @g.a.t0.e
    boolean tryOnError(@g.a.t0.f Throwable th);
}
