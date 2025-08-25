package g.a.y0.h;

import h.q2.t.m0;
import java.util.concurrent.CountDownLatch;

/* compiled from: BlockingBaseSubscriber.java */
/* loaded from: classes2.dex */
public abstract class c<T> extends CountDownLatch implements g.a.q<T> {

    /* renamed from: a, reason: collision with root package name */
    T f16015a;

    /* renamed from: b, reason: collision with root package name */
    Throwable f16016b;

    /* renamed from: c, reason: collision with root package name */
    i.d.d f16017c;

    /* renamed from: d, reason: collision with root package name */
    volatile boolean f16018d;

    public c() {
        super(1);
    }

    public final T a() {
        if (getCount() != 0) {
            try {
                g.a.y0.j.e.a();
                await();
            } catch (InterruptedException e2) {
                i.d.d dVar = this.f16017c;
                this.f16017c = g.a.y0.i.j.CANCELLED;
                if (dVar != null) {
                    dVar.cancel();
                }
                throw g.a.y0.j.k.c(e2);
            }
        }
        Throwable th = this.f16016b;
        if (th == null) {
            return this.f16015a;
        }
        throw g.a.y0.j.k.c(th);
    }

    @Override // i.d.c
    public final void onComplete() {
        countDown();
    }

    @Override // g.a.q
    public final void onSubscribe(i.d.d dVar) {
        if (g.a.y0.i.j.validate(this.f16017c, dVar)) {
            this.f16017c = dVar;
            if (this.f16018d) {
                return;
            }
            dVar.request(m0.f16408b);
            if (this.f16018d) {
                this.f16017c = g.a.y0.i.j.CANCELLED;
                dVar.cancel();
            }
        }
    }
}
