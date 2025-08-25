package g.a.y0.h;

/* compiled from: BlockingLastSubscriber.java */
/* loaded from: classes2.dex */
public final class e<T> extends c<T> {
    @Override // i.d.c
    public void onError(Throwable th) {
        this.f16015a = null;
        this.f16016b = th;
        countDown();
    }

    @Override // i.d.c
    public void onNext(T t) {
        this.f16015a = t;
    }
}
