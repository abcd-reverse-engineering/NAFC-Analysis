package g.a.y0.d;

import g.a.n0;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: BlockingMultiObserver.java */
/* loaded from: classes2.dex */
public final class h<T> extends CountDownLatch implements n0<T>, g.a.f, g.a.v<T> {

    /* renamed from: a, reason: collision with root package name */
    T f13953a;

    /* renamed from: b, reason: collision with root package name */
    Throwable f13954b;

    /* renamed from: c, reason: collision with root package name */
    g.a.u0.c f13955c;

    /* renamed from: d, reason: collision with root package name */
    volatile boolean f13956d;

    public h() {
        super(1);
    }

    public T a() throws InterruptedException {
        if (getCount() != 0) {
            try {
                g.a.y0.j.e.a();
                await();
            } catch (InterruptedException e2) {
                c();
                throw g.a.y0.j.k.c(e2);
            }
        }
        Throwable th = this.f13954b;
        if (th == null) {
            return this.f13953a;
        }
        throw g.a.y0.j.k.c(th);
    }

    public Throwable b() throws InterruptedException {
        if (getCount() != 0) {
            try {
                g.a.y0.j.e.a();
                await();
            } catch (InterruptedException e2) {
                c();
                return e2;
            }
        }
        return this.f13954b;
    }

    void c() {
        this.f13956d = true;
        g.a.u0.c cVar = this.f13955c;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    @Override // g.a.f
    public void onComplete() {
        countDown();
    }

    @Override // g.a.n0
    public void onError(Throwable th) {
        this.f13954b = th;
        countDown();
    }

    @Override // g.a.n0
    public void onSubscribe(g.a.u0.c cVar) {
        this.f13955c = cVar;
        if (this.f13956d) {
            cVar.dispose();
        }
    }

    @Override // g.a.n0
    public void onSuccess(T t) {
        this.f13953a = t;
        countDown();
    }

    public Throwable b(long j2, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                g.a.y0.j.e.a();
                if (!await(j2, timeUnit)) {
                    c();
                    throw g.a.y0.j.k.c(new TimeoutException());
                }
            } catch (InterruptedException e2) {
                c();
                throw g.a.y0.j.k.c(e2);
            }
        }
        return this.f13954b;
    }

    public T a(T t) throws InterruptedException {
        if (getCount() != 0) {
            try {
                g.a.y0.j.e.a();
                await();
            } catch (InterruptedException e2) {
                c();
                throw g.a.y0.j.k.c(e2);
            }
        }
        Throwable th = this.f13954b;
        if (th == null) {
            T t2 = this.f13953a;
            return t2 != null ? t2 : t;
        }
        throw g.a.y0.j.k.c(th);
    }

    public boolean a(long j2, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                g.a.y0.j.e.a();
                if (!await(j2, timeUnit)) {
                    c();
                    return false;
                }
            } catch (InterruptedException e2) {
                c();
                throw g.a.y0.j.k.c(e2);
            }
        }
        Throwable th = this.f13954b;
        if (th == null) {
            return true;
        }
        throw g.a.y0.j.k.c(th);
    }
}
