package g.a;

/* compiled from: FlowableEmitter.java */
/* loaded from: classes2.dex */
public interface n<T> extends k<T> {
    boolean isCancelled();

    long requested();

    @g.a.t0.f
    n<T> serialize();

    void setCancellable(@g.a.t0.g g.a.x0.f fVar);

    void setDisposable(@g.a.t0.g g.a.u0.c cVar);

    @g.a.t0.e
    boolean tryOnError(@g.a.t0.f Throwable th);
}
