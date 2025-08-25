package g.a.a1;

import g.a.i0;

/* compiled from: SafeObserver.java */
/* loaded from: classes2.dex */
public final class l<T> implements i0<T>, g.a.u0.c {

    /* renamed from: a, reason: collision with root package name */
    final i0<? super T> f13639a;

    /* renamed from: b, reason: collision with root package name */
    g.a.u0.c f13640b;

    /* renamed from: c, reason: collision with root package name */
    boolean f13641c;

    public l(@g.a.t0.f i0<? super T> i0Var) {
        this.f13639a = i0Var;
    }

    void a() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f13639a.onSubscribe(g.a.y0.a.e.INSTANCE);
            try {
                this.f13639a.onError(nullPointerException);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                g.a.c1.a.b(new g.a.v0.a(nullPointerException, th));
            }
        } catch (Throwable th2) {
            g.a.v0.b.b(th2);
            g.a.c1.a.b(new g.a.v0.a(nullPointerException, th2));
        }
    }

    void b() {
        this.f13641c = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f13639a.onSubscribe(g.a.y0.a.e.INSTANCE);
            try {
                this.f13639a.onError(nullPointerException);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                g.a.c1.a.b(new g.a.v0.a(nullPointerException, th));
            }
        } catch (Throwable th2) {
            g.a.v0.b.b(th2);
            g.a.c1.a.b(new g.a.v0.a(nullPointerException, th2));
        }
    }

    @Override // g.a.u0.c
    public void dispose() {
        this.f13640b.dispose();
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return this.f13640b.isDisposed();
    }

    @Override // g.a.i0
    public void onComplete() {
        if (this.f13641c) {
            return;
        }
        this.f13641c = true;
        if (this.f13640b == null) {
            a();
            return;
        }
        try {
            this.f13639a.onComplete();
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.c1.a.b(th);
        }
    }

    @Override // g.a.i0
    public void onError(@g.a.t0.f Throwable th) {
        if (this.f13641c) {
            g.a.c1.a.b(th);
            return;
        }
        this.f13641c = true;
        if (this.f13640b != null) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                this.f13639a.onError(th);
                return;
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                g.a.c1.a.b(new g.a.v0.a(th, th2));
                return;
            }
        }
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f13639a.onSubscribe(g.a.y0.a.e.INSTANCE);
            try {
                this.f13639a.onError(new g.a.v0.a(th, nullPointerException));
            } catch (Throwable th3) {
                g.a.v0.b.b(th3);
                g.a.c1.a.b(new g.a.v0.a(th, nullPointerException, th3));
            }
        } catch (Throwable th4) {
            g.a.v0.b.b(th4);
            g.a.c1.a.b(new g.a.v0.a(th, nullPointerException, th4));
        }
    }

    @Override // g.a.i0
    public void onNext(@g.a.t0.f T t) {
        if (this.f13641c) {
            return;
        }
        if (this.f13640b == null) {
            b();
            return;
        }
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            try {
                this.f13640b.dispose();
                onError(nullPointerException);
                return;
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                onError(new g.a.v0.a(nullPointerException, th));
                return;
            }
        }
        try {
            this.f13639a.onNext(t);
        } catch (Throwable th2) {
            g.a.v0.b.b(th2);
            try {
                this.f13640b.dispose();
                onError(th2);
            } catch (Throwable th3) {
                g.a.v0.b.b(th3);
                onError(new g.a.v0.a(th2, th3));
            }
        }
    }

    @Override // g.a.i0
    public void onSubscribe(@g.a.t0.f g.a.u0.c cVar) {
        if (g.a.y0.a.d.validate(this.f13640b, cVar)) {
            this.f13640b = cVar;
            try {
                this.f13639a.onSubscribe(this);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f13641c = true;
                try {
                    cVar.dispose();
                    g.a.c1.a.b(th);
                } catch (Throwable th2) {
                    g.a.v0.b.b(th2);
                    g.a.c1.a.b(new g.a.v0.a(th, th2));
                }
            }
        }
    }
}
