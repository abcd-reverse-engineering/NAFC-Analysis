package g.a;

/* compiled from: Observer.java */
/* loaded from: classes2.dex */
public interface i0<T> {
    void onComplete();

    void onError(@g.a.t0.f Throwable th);

    void onNext(@g.a.t0.f T t);

    void onSubscribe(@g.a.t0.f g.a.u0.c cVar);
}
