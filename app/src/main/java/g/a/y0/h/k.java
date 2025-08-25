package g.a.y0.h;

/* compiled from: InnerQueuedSubscriberSupport.java */
/* loaded from: classes2.dex */
public interface k<T> {
    void drain();

    void innerComplete(j<T> jVar);

    void innerError(j<T> jVar, Throwable th);

    void innerNext(j<T> jVar, T t);
}
