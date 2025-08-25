package g.a.a1;

import g.a.i0;
import g.a.n0;
import g.a.v;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: TestObserver.java */
/* loaded from: classes2.dex */
public class n<T> extends g.a.a1.a<T, n<T>> implements i0<T>, g.a.u0.c, v<T>, n0<T>, g.a.f {

    /* renamed from: k, reason: collision with root package name */
    private final i0<? super T> f13649k;

    /* renamed from: l, reason: collision with root package name */
    private final AtomicReference<g.a.u0.c> f13650l;

    /* renamed from: m, reason: collision with root package name */
    private g.a.y0.c.j<T> f13651m;

    /* compiled from: TestObserver.java */
    enum a implements i0<Object> {
        INSTANCE;

        @Override // g.a.i0
        public void onComplete() {
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
        }

        @Override // g.a.i0
        public void onNext(Object obj) {
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
        }
    }

    public n() {
        this(a.INSTANCE);
    }

    public static <T> n<T> B() {
        return new n<>();
    }

    public static <T> n<T> a(i0<? super T> i0Var) {
        return new n<>(i0Var);
    }

    static String e(int i2) {
        if (i2 == 0) {
            return "NONE";
        }
        if (i2 == 1) {
            return "SYNC";
        }
        if (i2 == 2) {
            return "ASYNC";
        }
        return "Unknown(" + i2 + ")";
    }

    public final boolean A() {
        return isDisposed();
    }

    final n<T> c(int i2) {
        int i3 = this.f13622h;
        if (i3 == i2) {
            return this;
        }
        if (this.f13651m == null) {
            throw b("Upstream is not fuseable");
        }
        throw new AssertionError("Fusion mode different. Expected: " + e(i2) + ", actual: " + e(i3));
    }

    public final void cancel() {
        dispose();
    }

    final n<T> d(int i2) {
        this.f13621g = i2;
        return this;
    }

    @Override // g.a.u0.c
    public final void dispose() {
        g.a.y0.a.d.dispose(this.f13650l);
    }

    @Override // g.a.u0.c
    public final boolean isDisposed() {
        return g.a.y0.a.d.isDisposed(this.f13650l.get());
    }

    @Override // g.a.i0
    public void onComplete() {
        if (!this.f13620f) {
            this.f13620f = true;
            if (this.f13650l.get() == null) {
                this.f13617c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f13619e = Thread.currentThread();
            this.f13618d++;
            this.f13649k.onComplete();
        } finally {
            this.f13615a.countDown();
        }
    }

    @Override // g.a.i0
    public void onError(Throwable th) {
        if (!this.f13620f) {
            this.f13620f = true;
            if (this.f13650l.get() == null) {
                this.f13617c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f13619e = Thread.currentThread();
            if (th == null) {
                this.f13617c.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.f13617c.add(th);
            }
            this.f13649k.onError(th);
        } finally {
            this.f13615a.countDown();
        }
    }

    @Override // g.a.i0
    public void onNext(T t) {
        if (!this.f13620f) {
            this.f13620f = true;
            if (this.f13650l.get() == null) {
                this.f13617c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.f13619e = Thread.currentThread();
        if (this.f13622h != 2) {
            this.f13616b.add(t);
            if (t == null) {
                this.f13617c.add(new NullPointerException("onNext received a null value"));
            }
            this.f13649k.onNext(t);
            return;
        }
        while (true) {
            try {
                T tPoll = this.f13651m.poll();
                if (tPoll == null) {
                    return;
                } else {
                    this.f13616b.add(tPoll);
                }
            } catch (Throwable th) {
                this.f13617c.add(th);
                this.f13651m.dispose();
                return;
            }
        }
    }

    @Override // g.a.i0
    public void onSubscribe(g.a.u0.c cVar) {
        this.f13619e = Thread.currentThread();
        if (cVar == null) {
            this.f13617c.add(new NullPointerException("onSubscribe received a null Subscription"));
            return;
        }
        if (!this.f13650l.compareAndSet(null, cVar)) {
            cVar.dispose();
            if (this.f13650l.get() != g.a.y0.a.d.DISPOSED) {
                this.f13617c.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + cVar));
                return;
            }
            return;
        }
        int i2 = this.f13621g;
        if (i2 != 0 && (cVar instanceof g.a.y0.c.j)) {
            this.f13651m = (g.a.y0.c.j) cVar;
            int iRequestFusion = this.f13651m.requestFusion(i2);
            this.f13622h = iRequestFusion;
            if (iRequestFusion == 1) {
                this.f13620f = true;
                this.f13619e = Thread.currentThread();
                while (true) {
                    try {
                        T tPoll = this.f13651m.poll();
                        if (tPoll == null) {
                            this.f13618d++;
                            this.f13650l.lazySet(g.a.y0.a.d.DISPOSED);
                            return;
                        }
                        this.f13616b.add(tPoll);
                    } catch (Throwable th) {
                        this.f13617c.add(th);
                        return;
                    }
                }
            }
        }
        this.f13649k.onSubscribe(cVar);
    }

    @Override // g.a.v, g.a.n0
    public void onSuccess(T t) {
        onNext(t);
        onComplete();
    }

    final n<T> x() {
        if (this.f13651m != null) {
            return this;
        }
        throw new AssertionError("Upstream is not fuseable.");
    }

    final n<T> y() {
        if (this.f13651m == null) {
            return this;
        }
        throw new AssertionError("Upstream is fuseable.");
    }

    public final boolean z() {
        return this.f13650l.get() != null;
    }

    public n(i0<? super T> i0Var) {
        this.f13650l = new AtomicReference<>();
        this.f13649k = i0Var;
    }

    public final n<T> a(g.a.x0.g<? super n<T>> gVar) {
        try {
            gVar.accept(this);
            return this;
        } catch (Throwable th) {
            throw g.a.y0.j.k.c(th);
        }
    }

    @Override // g.a.a1.a
    public final n<T> g() {
        if (this.f13650l.get() != null) {
            throw b("Subscribed!");
        }
        if (this.f13617c.isEmpty()) {
            return this;
        }
        throw b("Not subscribed but errors found");
    }

    @Override // g.a.a1.a
    public final n<T> i() {
        if (this.f13650l.get() != null) {
            return this;
        }
        throw b("Not subscribed!");
    }
}
