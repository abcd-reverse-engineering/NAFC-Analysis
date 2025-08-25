package g.a;

/* compiled from: MaybeObserver.java */
/* loaded from: classes2.dex */
public interface v<T> {
    void onComplete();

    void onError(@g.a.t0.f Throwable th);

    void onSubscribe(@g.a.t0.f g.a.u0.c cVar);

    void onSuccess(@g.a.t0.f T t);
}
