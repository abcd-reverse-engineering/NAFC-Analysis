package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableTakeUntil.java */
/* loaded from: classes2.dex */
public final class z3<T, U> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final i.d.b<? extends U> f14741c;

    /* compiled from: FlowableTakeUntil.java */
    static final class a<T> extends AtomicInteger implements g.a.q<T>, i.d.d {
        private static final long serialVersionUID = -4945480365982832967L;
        final i.d.c<? super T> actual;
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<i.d.d> s = new AtomicReference<>();
        final a<T>.C0199a other = new C0199a();
        final g.a.y0.j.c error = new g.a.y0.j.c();

        /* compiled from: FlowableTakeUntil.java */
        /* renamed from: g.a.y0.e.b.z3$a$a, reason: collision with other inner class name */
        final class C0199a extends AtomicReference<i.d.d> implements g.a.q<Object> {
            private static final long serialVersionUID = -3592821756711087922L;

            C0199a() {
            }

            @Override // i.d.c
            public void onComplete() {
                g.a.y0.i.j.cancel(a.this.s);
                a aVar = a.this;
                g.a.y0.j.l.a(aVar.actual, aVar, aVar.error);
            }

            @Override // i.d.c
            public void onError(Throwable th) {
                g.a.y0.i.j.cancel(a.this.s);
                a aVar = a.this;
                g.a.y0.j.l.a((i.d.c<?>) aVar.actual, th, (AtomicInteger) aVar, aVar.error);
            }

            @Override // i.d.c
            public void onNext(Object obj) {
                g.a.y0.i.j.cancel(this);
                onComplete();
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
            g.a.y0.j.l.a(this.actual, t, this, this.error);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            g.a.y0.i.j.deferredSetOnce(this.s, this.requested, dVar);
        }

        @Override // i.d.d
        public void request(long j2) {
            g.a.y0.i.j.deferredRequest(this.s, this.requested, j2);
        }
    }

    public z3(g.a.l<T> lVar, i.d.b<? extends U> bVar) {
        super(lVar);
        this.f14741c = bVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        a aVar = new a(cVar);
        cVar.onSubscribe(aVar);
        this.f14741c.subscribe(aVar.other);
        this.f14110b.a((g.a.q) aVar);
    }
}
