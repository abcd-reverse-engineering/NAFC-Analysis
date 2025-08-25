package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableDebounce.java */
/* loaded from: classes2.dex */
public final class d0<T, U> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends i.d.b<U>> f14164c;

    /* compiled from: FlowableDebounce.java */
    static final class a<T, U> extends AtomicLong implements g.a.q<T>, i.d.d {
        private static final long serialVersionUID = 6725975399620862591L;
        final i.d.c<? super T> actual;
        final g.a.x0.o<? super T, ? extends i.d.b<U>> debounceSelector;
        final AtomicReference<g.a.u0.c> debouncer = new AtomicReference<>();
        boolean done;
        volatile long index;
        i.d.d s;

        /* compiled from: FlowableDebounce.java */
        /* renamed from: g.a.y0.e.b.d0$a$a, reason: collision with other inner class name */
        static final class C0189a<T, U> extends g.a.g1.b<U> {

            /* renamed from: b, reason: collision with root package name */
            final a<T, U> f14165b;

            /* renamed from: c, reason: collision with root package name */
            final long f14166c;

            /* renamed from: d, reason: collision with root package name */
            final T f14167d;

            /* renamed from: e, reason: collision with root package name */
            boolean f14168e;

            /* renamed from: f, reason: collision with root package name */
            final AtomicBoolean f14169f = new AtomicBoolean();

            C0189a(a<T, U> aVar, long j2, T t) {
                this.f14165b = aVar;
                this.f14166c = j2;
                this.f14167d = t;
            }

            void c() {
                if (this.f14169f.compareAndSet(false, true)) {
                    this.f14165b.emit(this.f14166c, this.f14167d);
                }
            }

            @Override // i.d.c
            public void onComplete() {
                if (this.f14168e) {
                    return;
                }
                this.f14168e = true;
                c();
            }

            @Override // i.d.c
            public void onError(Throwable th) {
                if (this.f14168e) {
                    g.a.c1.a.b(th);
                } else {
                    this.f14168e = true;
                    this.f14165b.onError(th);
                }
            }

            @Override // i.d.c
            public void onNext(U u) {
                if (this.f14168e) {
                    return;
                }
                this.f14168e = true;
                a();
                c();
            }
        }

        a(i.d.c<? super T> cVar, g.a.x0.o<? super T, ? extends i.d.b<U>> oVar) {
            this.actual = cVar;
            this.debounceSelector = oVar;
        }

        @Override // i.d.d
        public void cancel() {
            this.s.cancel();
            g.a.y0.a.d.dispose(this.debouncer);
        }

        void emit(long j2, T t) {
            if (j2 == this.index) {
                if (get() != 0) {
                    this.actual.onNext(t);
                    g.a.y0.j.d.c(this, 1L);
                } else {
                    cancel();
                    this.actual.onError(new g.a.v0.c("Could not deliver value due to lack of requests"));
                }
            }
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            g.a.u0.c cVar = this.debouncer.get();
            if (g.a.y0.a.d.isDisposed(cVar)) {
                return;
            }
            ((C0189a) cVar).c();
            g.a.y0.a.d.dispose(this.debouncer);
            this.actual.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            g.a.y0.a.d.dispose(this.debouncer);
            this.actual.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j2 = this.index + 1;
            this.index = j2;
            g.a.u0.c cVar = this.debouncer.get();
            if (cVar != null) {
                cVar.dispose();
            }
            try {
                i.d.b bVar = (i.d.b) g.a.y0.b.b.a(this.debounceSelector.apply(t), "The publisher supplied is null");
                C0189a c0189a = new C0189a(this, j2, t);
                if (this.debouncer.compareAndSet(cVar, c0189a)) {
                    bVar.subscribe(c0189a);
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                cancel();
                this.actual.onError(th);
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

    public d0(g.a.l<T> lVar, g.a.x0.o<? super T, ? extends i.d.b<U>> oVar) {
        super(lVar);
        this.f14164c = oVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(new g.a.g1.e(cVar), this.f14164c));
    }
}
