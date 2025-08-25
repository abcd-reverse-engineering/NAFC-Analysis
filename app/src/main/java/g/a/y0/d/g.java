package g.a.y0.d;

/* compiled from: BlockingLastObserver.java */
/* loaded from: classes2.dex */
public final class g<T> extends e<T> {
    @Override // g.a.i0
    public void onError(Throwable th) {
        this.f13949a = null;
        this.f13950b = th;
        countDown();
    }

    @Override // g.a.i0
    public void onNext(T t) {
        this.f13949a = t;
    }
}
