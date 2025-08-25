package g.a.f1;

import g.a.b0;
import g.a.i0;
import g.a.y0.c.o;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: UnicastSubject.java */
/* loaded from: classes2.dex */
public final class j<T> extends i<T> {

    /* renamed from: a, reason: collision with root package name */
    final g.a.y0.f.c<T> f13805a;

    /* renamed from: b, reason: collision with root package name */
    final AtomicReference<i0<? super T>> f13806b;

    /* renamed from: c, reason: collision with root package name */
    final AtomicReference<Runnable> f13807c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f13808d;

    /* renamed from: e, reason: collision with root package name */
    volatile boolean f13809e;

    /* renamed from: f, reason: collision with root package name */
    volatile boolean f13810f;

    /* renamed from: g, reason: collision with root package name */
    Throwable f13811g;

    /* renamed from: h, reason: collision with root package name */
    final AtomicBoolean f13812h;

    /* renamed from: i, reason: collision with root package name */
    final g.a.y0.d.b<T> f13813i;

    /* renamed from: j, reason: collision with root package name */
    boolean f13814j;

    /* compiled from: UnicastSubject.java */
    final class a extends g.a.y0.d.b<T> {
        private static final long serialVersionUID = 7926949470189395511L;

        a() {
        }

        @Override // g.a.y0.c.o
        public void clear() {
            j.this.f13805a.clear();
        }

        @Override // g.a.u0.c
        public void dispose() {
            if (j.this.f13809e) {
                return;
            }
            j jVar = j.this;
            jVar.f13809e = true;
            jVar.T();
            j.this.f13806b.lazySet(null);
            if (j.this.f13813i.getAndIncrement() == 0) {
                j.this.f13806b.lazySet(null);
                j.this.f13805a.clear();
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return j.this.f13809e;
        }

        @Override // g.a.y0.c.o
        public boolean isEmpty() {
            return j.this.f13805a.isEmpty();
        }

        @Override // g.a.y0.c.o
        @g.a.t0.g
        public T poll() throws Exception {
            return j.this.f13805a.poll();
        }

        @Override // g.a.y0.c.k
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            j.this.f13814j = true;
            return 2;
        }
    }

    j(int i2, boolean z) {
        this.f13805a = new g.a.y0.f.c<>(g.a.y0.b.b.a(i2, "capacityHint"));
        this.f13807c = new AtomicReference<>();
        this.f13808d = z;
        this.f13806b = new AtomicReference<>();
        this.f13812h = new AtomicBoolean();
        this.f13813i = new a();
    }

    @g.a.t0.d
    public static <T> j<T> V() {
        return new j<>(b0.L(), true);
    }

    @g.a.t0.d
    public static <T> j<T> a(int i2, Runnable runnable) {
        return new j<>(i2, runnable, true);
    }

    @g.a.t0.e
    @g.a.t0.d
    public static <T> j<T> b(boolean z) {
        return new j<>(b0.L(), z);
    }

    @g.a.t0.d
    public static <T> j<T> i(int i2) {
        return new j<>(i2, true);
    }

    @Override // g.a.f1.i
    public Throwable O() {
        if (this.f13810f) {
            return this.f13811g;
        }
        return null;
    }

    @Override // g.a.f1.i
    public boolean P() {
        return this.f13810f && this.f13811g == null;
    }

    @Override // g.a.f1.i
    public boolean Q() {
        return this.f13806b.get() != null;
    }

    @Override // g.a.f1.i
    public boolean R() {
        return this.f13810f && this.f13811g != null;
    }

    void T() {
        Runnable runnable = this.f13807c.get();
        if (runnable == null || !this.f13807c.compareAndSet(runnable, null)) {
            return;
        }
        runnable.run();
    }

    void U() {
        if (this.f13813i.getAndIncrement() != 0) {
            return;
        }
        i0<? super T> i0Var = this.f13806b.get();
        int iAddAndGet = 1;
        while (i0Var == null) {
            iAddAndGet = this.f13813i.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            } else {
                i0Var = this.f13806b.get();
            }
        }
        if (this.f13814j) {
            f((i0) i0Var);
        } else {
            g((i0) i0Var);
        }
    }

    @Override // g.a.b0
    protected void d(i0<? super T> i0Var) {
        if (this.f13812h.get() || !this.f13812h.compareAndSet(false, true)) {
            g.a.y0.a.e.error(new IllegalStateException("Only a single observer allowed."), i0Var);
            return;
        }
        i0Var.onSubscribe(this.f13813i);
        this.f13806b.lazySet(i0Var);
        if (this.f13809e) {
            this.f13806b.lazySet(null);
        } else {
            U();
        }
    }

    void f(i0<? super T> i0Var) {
        g.a.y0.f.c<T> cVar = this.f13805a;
        int iAddAndGet = 1;
        boolean z = !this.f13808d;
        while (!this.f13809e) {
            boolean z2 = this.f13810f;
            if (z && z2 && a((o) cVar, (i0) i0Var)) {
                return;
            }
            i0Var.onNext(null);
            if (z2) {
                h((i0) i0Var);
                return;
            } else {
                iAddAndGet = this.f13813i.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }
        this.f13806b.lazySet(null);
        cVar.clear();
    }

    void g(i0<? super T> i0Var) {
        g.a.y0.f.c<T> cVar = this.f13805a;
        boolean z = !this.f13808d;
        boolean z2 = true;
        int iAddAndGet = 1;
        while (!this.f13809e) {
            boolean z3 = this.f13810f;
            T tPoll = this.f13805a.poll();
            boolean z4 = tPoll == null;
            if (z3) {
                if (z && z2) {
                    if (a((o) cVar, (i0) i0Var)) {
                        return;
                    } else {
                        z2 = false;
                    }
                }
                if (z4) {
                    h((i0) i0Var);
                    return;
                }
            }
            if (z4) {
                iAddAndGet = this.f13813i.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                i0Var.onNext(tPoll);
            }
        }
        this.f13806b.lazySet(null);
        cVar.clear();
    }

    void h(i0<? super T> i0Var) {
        this.f13806b.lazySet(null);
        Throwable th = this.f13811g;
        if (th != null) {
            i0Var.onError(th);
        } else {
            i0Var.onComplete();
        }
    }

    @Override // g.a.i0
    public void onComplete() {
        if (this.f13810f || this.f13809e) {
            return;
        }
        this.f13810f = true;
        T();
        U();
    }

    @Override // g.a.i0
    public void onError(Throwable th) {
        if (this.f13810f || this.f13809e) {
            g.a.c1.a.b(th);
            return;
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        this.f13811g = th;
        this.f13810f = true;
        T();
        U();
    }

    @Override // g.a.i0
    public void onNext(T t) {
        if (this.f13810f || this.f13809e) {
            return;
        }
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        } else {
            this.f13805a.offer(t);
            U();
        }
    }

    @Override // g.a.i0
    public void onSubscribe(g.a.u0.c cVar) {
        if (this.f13810f || this.f13809e) {
            cVar.dispose();
        }
    }

    @g.a.t0.e
    @g.a.t0.d
    public static <T> j<T> a(int i2, Runnable runnable, boolean z) {
        return new j<>(i2, runnable, z);
    }

    boolean a(o<T> oVar, i0<? super T> i0Var) {
        Throwable th = this.f13811g;
        if (th == null) {
            return false;
        }
        this.f13806b.lazySet(null);
        oVar.clear();
        i0Var.onError(th);
        return true;
    }

    j(int i2, Runnable runnable) {
        this(i2, runnable, true);
    }

    j(int i2, Runnable runnable, boolean z) {
        this.f13805a = new g.a.y0.f.c<>(g.a.y0.b.b.a(i2, "capacityHint"));
        this.f13807c = new AtomicReference<>(g.a.y0.b.b.a(runnable, "onTerminate"));
        this.f13808d = z;
        this.f13806b = new AtomicReference<>();
        this.f13812h = new AtomicBoolean();
        this.f13813i = new a();
    }
}
