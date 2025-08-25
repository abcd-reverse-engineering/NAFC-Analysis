package g.a.y0.d;

/* compiled from: InnerQueuedObserverSupport.java */
/* loaded from: classes2.dex */
public interface u<T> {
    void drain();

    void innerComplete(t<T> tVar);

    void innerError(t<T> tVar, Throwable th);

    void innerNext(t<T> tVar, T t);
}
