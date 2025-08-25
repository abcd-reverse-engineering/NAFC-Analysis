package g.a.y0.d;

/* compiled from: BlockingFirstObserver.java */
/* loaded from: classes2.dex */
public final class f<T> extends e<T> {
    @Override // g.a.i0
    public void onError(Throwable th) {
        if (this.f13949a == null) {
            this.f13950b = th;
        }
        countDown();
    }

    @Override // g.a.i0
    public void onNext(T t) {
        if (this.f13949a == null) {
            this.f13949a = t;
            this.f13951c.dispose();
            countDown();
        }
    }
}
