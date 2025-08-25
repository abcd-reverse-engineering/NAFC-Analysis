package g.a.g1;

import g.a.q;
import g.a.x0.g;
import g.a.y0.c.l;
import g.a.y0.i.j;
import g.a.y0.j.k;
import h.q2.t.m0;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: TestSubscriber.java */
/* loaded from: classes2.dex */
public class f<T> extends g.a.a1.a<T, f<T>> implements q<T>, i.d.d, g.a.u0.c {

    /* renamed from: k, reason: collision with root package name */
    private final i.d.c<? super T> f13830k;

    /* renamed from: l, reason: collision with root package name */
    private volatile boolean f13831l;

    /* renamed from: m, reason: collision with root package name */
    private final AtomicReference<i.d.d> f13832m;
    private final AtomicLong n;
    private l<T> o;

    /* compiled from: TestSubscriber.java */
    enum a implements q<Object> {
        INSTANCE;

        @Override // i.d.c
        public void onComplete() {
        }

        @Override // i.d.c
        public void onError(Throwable th) {
        }

        @Override // i.d.c
        public void onNext(Object obj) {
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
        }
    }

    public f() {
        this(a.INSTANCE, m0.f16408b);
    }

    public static <T> f<T> C() {
        return new f<>();
    }

    public static <T> f<T> a(i.d.c<? super T> cVar) {
        return new f<>(cVar);
    }

    public static <T> f<T> b(long j2) {
        return new f<>(j2);
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
        return this.f13831l;
    }

    protected void B() {
    }

    final f<T> c(int i2) {
        int i3 = this.f13622h;
        if (i3 == i2) {
            return this;
        }
        if (this.o == null) {
            throw b("Upstream is not fuseable");
        }
        throw new AssertionError("Fusion mode different. Expected: " + e(i2) + ", actual: " + e(i3));
    }

    @Override // i.d.d
    public final void cancel() {
        if (this.f13831l) {
            return;
        }
        this.f13831l = true;
        j.cancel(this.f13832m);
    }

    final f<T> d(int i2) {
        this.f13621g = i2;
        return this;
    }

    @Override // g.a.u0.c
    public final void dispose() {
        cancel();
    }

    @Override // g.a.u0.c
    public final boolean isDisposed() {
        return this.f13831l;
    }

    @Override // i.d.c
    public void onComplete() {
        if (!this.f13620f) {
            this.f13620f = true;
            if (this.f13832m.get() == null) {
                this.f13617c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f13619e = Thread.currentThread();
            this.f13618d++;
            this.f13830k.onComplete();
        } finally {
            this.f13615a.countDown();
        }
    }

    @Override // i.d.c
    public void onError(Throwable th) {
        if (!this.f13620f) {
            this.f13620f = true;
            if (this.f13832m.get() == null) {
                this.f13617c.add(new NullPointerException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f13619e = Thread.currentThread();
            this.f13617c.add(th);
            if (th == null) {
                this.f13617c.add(new IllegalStateException("onError received a null Throwable"));
            }
            this.f13830k.onError(th);
        } finally {
            this.f13615a.countDown();
        }
    }

    @Override // i.d.c
    public void onNext(T t) {
        if (!this.f13620f) {
            this.f13620f = true;
            if (this.f13832m.get() == null) {
                this.f13617c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.f13619e = Thread.currentThread();
        if (this.f13622h != 2) {
            this.f13616b.add(t);
            if (t == null) {
                this.f13617c.add(new NullPointerException("onNext received a null value"));
            }
            this.f13830k.onNext(t);
            return;
        }
        while (true) {
            try {
                T tPoll = this.o.poll();
                if (tPoll == null) {
                    return;
                } else {
                    this.f13616b.add(tPoll);
                }
            } catch (Throwable th) {
                this.f13617c.add(th);
                this.o.cancel();
                return;
            }
        }
    }

    @Override // g.a.q
    public void onSubscribe(i.d.d dVar) {
        this.f13619e = Thread.currentThread();
        if (dVar == null) {
            this.f13617c.add(new NullPointerException("onSubscribe received a null Subscription"));
            return;
        }
        if (!this.f13832m.compareAndSet(null, dVar)) {
            dVar.cancel();
            if (this.f13832m.get() != j.CANCELLED) {
                this.f13617c.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + dVar));
                return;
            }
            return;
        }
        int i2 = this.f13621g;
        if (i2 != 0 && (dVar instanceof l)) {
            this.o = (l) dVar;
            int iRequestFusion = this.o.requestFusion(i2);
            this.f13622h = iRequestFusion;
            if (iRequestFusion == 1) {
                this.f13620f = true;
                this.f13619e = Thread.currentThread();
                while (true) {
                    try {
                        T tPoll = this.o.poll();
                        if (tPoll == null) {
                            this.f13618d++;
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
        this.f13830k.onSubscribe(dVar);
        long andSet = this.n.getAndSet(0L);
        if (andSet != 0) {
            dVar.request(andSet);
        }
        B();
    }

    @Override // i.d.d
    public final void request(long j2) {
        j.deferredRequest(this.f13832m, this.n, j2);
    }

    final f<T> x() {
        if (this.o != null) {
            return this;
        }
        throw new AssertionError("Upstream is not fuseable.");
    }

    final f<T> y() {
        if (this.o == null) {
            return this;
        }
        throw new AssertionError("Upstream is fuseable.");
    }

    public final boolean z() {
        return this.f13832m.get() != null;
    }

    public f(long j2) {
        this(a.INSTANCE, j2);
    }

    public final f<T> a(g<? super f<T>> gVar) {
        try {
            gVar.accept(this);
            return this;
        } catch (Throwable th) {
            throw k.c(th);
        }
    }

    @Override // g.a.a1.a
    public final f<T> g() {
        if (this.f13832m.get() != null) {
            throw b("Subscribed!");
        }
        if (this.f13617c.isEmpty()) {
            return this;
        }
        throw b("Not subscribed but errors found");
    }

    @Override // g.a.a1.a
    public final f<T> i() {
        if (this.f13832m.get() != null) {
            return this;
        }
        throw b("Not subscribed!");
    }

    public f(i.d.c<? super T> cVar) {
        this(cVar, m0.f16408b);
    }

    public f(i.d.c<? super T> cVar, long j2) {
        if (j2 >= 0) {
            this.f13830k = cVar;
            this.f13832m = new AtomicReference<>();
            this.n = new AtomicLong(j2);
            return;
        }
        throw new IllegalArgumentException("Negative initial request not allowed");
    }

    public final f<T> a(long j2) {
        request(j2);
        return this;
    }
}
