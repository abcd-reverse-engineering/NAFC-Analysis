package g.a.y0.d;

/* compiled from: SubscriberCompletableObserver.java */
/* loaded from: classes2.dex */
public final class b0<T> implements g.a.f, i.d.d {

    /* renamed from: a, reason: collision with root package name */
    final i.d.c<? super T> f13947a;

    /* renamed from: b, reason: collision with root package name */
    g.a.u0.c f13948b;

    public b0(i.d.c<? super T> cVar) {
        this.f13947a = cVar;
    }

    @Override // i.d.d
    public void cancel() {
        this.f13948b.dispose();
    }

    @Override // g.a.f
    public void onComplete() {
        this.f13947a.onComplete();
    }

    @Override // g.a.f
    public void onError(Throwable th) {
        this.f13947a.onError(th);
    }

    @Override // g.a.f
    public void onSubscribe(g.a.u0.c cVar) {
        if (g.a.y0.a.d.validate(this.f13948b, cVar)) {
            this.f13948b = cVar;
            this.f13947a.onSubscribe(this);
        }
    }

    @Override // i.d.d
    public void request(long j2) {
    }
}
