package g.a.y0.e.b;

import g.a.j0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableDebounceTimed.java */
/* loaded from: classes2.dex */
public final class e0<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final long f14193c;

    /* renamed from: d, reason: collision with root package name */
    final TimeUnit f14194d;

    /* renamed from: e, reason: collision with root package name */
    final g.a.j0 f14195e;

    /* compiled from: FlowableDebounceTimed.java */
    static final class a<T> extends AtomicReference<g.a.u0.c> implements Runnable, g.a.u0.c {
        private static final long serialVersionUID = 6812032969491025141L;
        final long idx;
        final AtomicBoolean once = new AtomicBoolean();
        final b<T> parent;
        final T value;

        a(T t, long j2, b<T> bVar) {
            this.value = t;
            this.idx = j2;
            this.parent = bVar;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.a.d.dispose(this);
        }

        void emit() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.emit(this.idx, this.value, this);
            }
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return get() == g.a.y0.a.d.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            emit();
        }

        public void setResource(g.a.u0.c cVar) {
            g.a.y0.a.d.replace(this, cVar);
        }
    }

    /* compiled from: FlowableDebounceTimed.java */
    static final class b<T> extends AtomicLong implements g.a.q<T>, i.d.d {
        private static final long serialVersionUID = -9102637559663639004L;
        final i.d.c<? super T> actual;
        boolean done;
        volatile long index;
        i.d.d s;
        final long timeout;
        final g.a.y0.a.k timer = new g.a.y0.a.k();
        final TimeUnit unit;
        final j0.c worker;

        b(i.d.c<? super T> cVar, long j2, TimeUnit timeUnit, j0.c cVar2) {
            this.actual = cVar;
            this.timeout = j2;
            this.unit = timeUnit;
            this.worker = cVar2;
        }

        @Override // i.d.d
        public void cancel() {
            this.s.cancel();
            this.worker.dispose();
        }

        void emit(long j2, T t, a<T> aVar) {
            if (j2 == this.index) {
                if (get() == 0) {
                    cancel();
                    this.actual.onError(new g.a.v0.c("Could not deliver value due to lack of requests"));
                } else {
                    this.actual.onNext(t);
                    g.a.y0.j.d.c(this, 1L);
                    aVar.dispose();
                }
            }
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            g.a.u0.c cVar = this.timer.get();
            if (g.a.y0.a.d.isDisposed(cVar)) {
                return;
            }
            a aVar = (a) cVar;
            if (aVar != null) {
                aVar.emit();
            }
            g.a.y0.a.d.dispose(this.timer);
            this.actual.onComplete();
            this.worker.dispose();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.done) {
                g.a.c1.a.b(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
            this.worker.dispose();
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j2 = this.index + 1;
            this.index = j2;
            g.a.u0.c cVar = this.timer.get();
            if (cVar != null) {
                cVar.dispose();
            }
            a aVar = new a(t, j2, this);
            if (this.timer.replace(aVar)) {
                aVar.setResource(this.worker.a(aVar, this.timeout, this.unit));
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(h.q2.t.m0.f16408b);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                g.a.y0.j.d.a(this, j2);
            }
        }
    }

    public e0(g.a.l<T> lVar, long j2, TimeUnit timeUnit, g.a.j0 j0Var) {
        super(lVar);
        this.f14193c = j2;
        this.f14194d = timeUnit;
        this.f14195e = j0Var;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new b(new g.a.g1.e(cVar), this.f14193c, this.f14194d, this.f14195e.a()));
    }
}
