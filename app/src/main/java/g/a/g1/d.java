package g.a.g1;

import g.a.q;
import g.a.y0.i.g;
import g.a.y0.i.j;

/* compiled from: SafeSubscriber.java */
/* loaded from: classes2.dex */
public final class d<T> implements q<T>, i.d.d {

    /* renamed from: a, reason: collision with root package name */
    final i.d.c<? super T> f13820a;

    /* renamed from: b, reason: collision with root package name */
    i.d.d f13821b;

    /* renamed from: c, reason: collision with root package name */
    boolean f13822c;

    public d(i.d.c<? super T> cVar) {
        this.f13820a = cVar;
    }

    void a() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f13820a.onSubscribe(g.INSTANCE);
            try {
                this.f13820a.onError(nullPointerException);
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
        this.f13822c = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f13820a.onSubscribe(g.INSTANCE);
            try {
                this.f13820a.onError(nullPointerException);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                g.a.c1.a.b(new g.a.v0.a(nullPointerException, th));
            }
        } catch (Throwable th2) {
            g.a.v0.b.b(th2);
            g.a.c1.a.b(new g.a.v0.a(nullPointerException, th2));
        }
    }

    @Override // i.d.d
    public void cancel() {
        try {
            this.f13821b.cancel();
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.c1.a.b(th);
        }
    }

    @Override // i.d.c
    public void onComplete() {
        if (this.f13822c) {
            return;
        }
        this.f13822c = true;
        if (this.f13821b == null) {
            a();
            return;
        }
        try {
            this.f13820a.onComplete();
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.c1.a.b(th);
        }
    }

    @Override // i.d.c
    public void onError(Throwable th) {
        if (this.f13822c) {
            g.a.c1.a.b(th);
            return;
        }
        this.f13822c = true;
        if (this.f13821b != null) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                this.f13820a.onError(th);
                return;
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                g.a.c1.a.b(new g.a.v0.a(th, th2));
                return;
            }
        }
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f13820a.onSubscribe(g.INSTANCE);
            try {
                this.f13820a.onError(new g.a.v0.a(th, nullPointerException));
            } catch (Throwable th3) {
                g.a.v0.b.b(th3);
                g.a.c1.a.b(new g.a.v0.a(th, nullPointerException, th3));
            }
        } catch (Throwable th4) {
            g.a.v0.b.b(th4);
            g.a.c1.a.b(new g.a.v0.a(th, nullPointerException, th4));
        }
    }

    @Override // i.d.c
    public void onNext(T t) {
        if (this.f13822c) {
            return;
        }
        if (this.f13821b == null) {
            b();
            return;
        }
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            try {
                this.f13821b.cancel();
                onError(nullPointerException);
                return;
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                onError(new g.a.v0.a(nullPointerException, th));
                return;
            }
        }
        try {
            this.f13820a.onNext(t);
        } catch (Throwable th2) {
            g.a.v0.b.b(th2);
            try {
                this.f13821b.cancel();
                onError(th2);
            } catch (Throwable th3) {
                g.a.v0.b.b(th3);
                onError(new g.a.v0.a(th2, th3));
            }
        }
    }

    @Override // g.a.q
    public void onSubscribe(i.d.d dVar) {
        if (j.validate(this.f13821b, dVar)) {
            this.f13821b = dVar;
            try {
                this.f13820a.onSubscribe(this);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f13822c = true;
                try {
                    dVar.cancel();
                    g.a.c1.a.b(th);
                } catch (Throwable th2) {
                    g.a.v0.b.b(th2);
                    g.a.c1.a.b(new g.a.v0.a(th, th2));
                }
            }
        }
    }

    @Override // i.d.d
    public void request(long j2) {
        try {
            this.f13821b.request(j2);
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            try {
                this.f13821b.cancel();
                g.a.c1.a.b(th);
            } catch (Throwable th2) {
                g.a.v0.b.b(th2);
                g.a.c1.a.b(new g.a.v0.a(th, th2));
            }
        }
    }
}
