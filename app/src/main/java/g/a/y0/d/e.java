package g.a.y0.d;

import g.a.i0;
import java.util.concurrent.CountDownLatch;

/* compiled from: BlockingBaseObserver.java */
/* loaded from: classes2.dex */
public abstract class e<T> extends CountDownLatch implements i0<T>, g.a.u0.c {

    /* renamed from: a, reason: collision with root package name */
    T f13949a;

    /* renamed from: b, reason: collision with root package name */
    Throwable f13950b;

    /* renamed from: c, reason: collision with root package name */
    g.a.u0.c f13951c;

    /* renamed from: d, reason: collision with root package name */
    volatile boolean f13952d;

    public e() {
        super(1);
    }

    public final T a() throws InterruptedException {
        if (getCount() != 0) {
            try {
                g.a.y0.j.e.a();
                await();
            } catch (InterruptedException e2) {
                dispose();
                throw g.a.y0.j.k.c(e2);
            }
        }
        Throwable th = this.f13950b;
        if (th == null) {
            return this.f13949a;
        }
        throw g.a.y0.j.k.c(th);
    }

    @Override // g.a.u0.c
    public final void dispose() {
        this.f13952d = true;
        g.a.u0.c cVar = this.f13951c;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    @Override // g.a.u0.c
    public final boolean isDisposed() {
        return this.f13952d;
    }

    @Override // g.a.i0
    public final void onComplete() {
        countDown();
    }

    @Override // g.a.i0
    public final void onSubscribe(g.a.u0.c cVar) {
        this.f13951c = cVar;
        if (this.f13952d) {
            cVar.dispose();
        }
    }
}
