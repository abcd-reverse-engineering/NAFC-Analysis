package g.a.y0.h;

/* compiled from: BlockingFirstSubscriber.java */
/* loaded from: classes2.dex */
public final class d<T> extends c<T> {
    @Override // i.d.c
    public void onError(Throwable th) {
        if (this.f16015a == null) {
            this.f16016b = th;
        } else {
            g.a.c1.a.b(th);
        }
        countDown();
    }

    @Override // i.d.c
    public void onNext(T t) {
        if (this.f16015a == null) {
            this.f16015a = t;
            this.f16017c.cancel();
            countDown();
        }
    }
}
