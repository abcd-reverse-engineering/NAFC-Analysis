package g.a;

/* compiled from: ObservableEmitter.java */
/* loaded from: classes2.dex */
public interface d0<T> extends k<T> {
    boolean isDisposed();

    @g.a.t0.f
    d0<T> serialize();

    void setCancellable(@g.a.t0.g g.a.x0.f fVar);

    void setDisposable(@g.a.t0.g g.a.u0.c cVar);

    @g.a.t0.e
    boolean tryOnError(@g.a.t0.f Throwable th);
}
