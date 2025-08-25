package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableSkipUntil.java */
/* loaded from: classes2.dex */
public final class p3<T, U> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final i.d.b<U> f14501c;

    /* compiled from: FlowableSkipUntil.java */
    static final class a<T> extends AtomicInteger implements g.a.y0.c.a<T>, i.d.d {
        private static final long serialVersionUID = -6270983465606289181L;
        final i.d.c<? super T> actual;
        volatile boolean gate;
        final AtomicReference<i.d.d> s = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();
        final a<T>.C0193a other = new C0193a();
        final g.a.y0.j.c error = new g.a.y0.j.c();

        /* compiled from: FlowableSkipUntil.java */
        /* renamed from: g.a.y0.e.b.p3$a$a, reason: collision with other inner class name */
        final class C0193a extends AtomicReference<i.d.d> implements g.a.q<Object> {
            private static final long serialVersionUID = -5592042965931999169L;

            C0193a() {
            }

            @Override // i.d.c
            public void onComplete() {
                a.this.gate = true;
            }

            @Override // i.d.c
            public void onError(Throwable th) {
                g.a.y0.i.j.cancel(a.this.s);
                a aVar = a.this;
                g.a.y0.j.l.a((i.d.c<?>) aVar.actual, th, (AtomicInteger) aVar, aVar.error);
            }

            @Override // i.d.c
            public void onNext(Object obj) {
                a.this.gate = true;
                get().cancel();
            }

            @Override // g.a.q
            public void onSubscribe(i.d.d dVar) {
                if (g.a.y0.i.j.setOnce(this, dVar)) {
                    dVar.request(h.q2.t.m0.f16408b);
                }
            }
        }

        a(i.d.c<? super T> cVar) {
            this.actual = cVar;
        }

        @Override // i.d.d
        public void cancel() {
            g.a.y0.i.j.cancel(this.s);
            g.a.y0.i.j.cancel(this.other);
        }

        @Override // i.d.c
        public void onComplete() {
            g.a.y0.i.j.cancel(this.other);
            g.a.y0.j.l.a(this.actual, this, this.error);
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            g.a.y0.i.j.cancel(this.other);
            g.a.y0.j.l.a((i.d.c<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (tryOnNext(t)) {
                return;
            }
            this.s.get().request(1L);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            g.a.y0.i.j.deferredSetOnce(this.s, this.requested, dVar);
        }

        @Override // i.d.d
        public void request(long j2) {
            g.a.y0.i.j.deferredRequest(this.s, this.requested, j2);
        }

        @Override // g.a.y0.c.a
        public boolean tryOnNext(T t) {
            if (!this.gate) {
                return false;
            }
            g.a.y0.j.l.a(this.actual, t, this, this.error);
            return true;
        }
    }

    public p3(g.a.l<T> lVar, i.d.b<U> bVar) {
        super(lVar);
        this.f14501c = bVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        a aVar = new a(cVar);
        cVar.onSubscribe(aVar);
        this.f14501c.subscribe(aVar.other);
        this.f14110b.a((g.a.q) aVar);
    }
}
