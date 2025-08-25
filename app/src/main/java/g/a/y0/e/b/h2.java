package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableOnBackpressureError.java */
/* loaded from: classes2.dex */
public final class h2<T> extends g.a.y0.e.b.a<T, T> {

    /* compiled from: FlowableOnBackpressureError.java */
    static final class a<T> extends AtomicLong implements g.a.q<T>, i.d.d {
        private static final long serialVersionUID = -3176480756392482682L;
        final i.d.c<? super T> actual;
        boolean done;
        i.d.d s;

        a(i.d.c<? super T> cVar) {
            this.actual = cVar;
        }

        @Override // i.d.d
        public void cancel() {
            this.s.cancel();
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.done) {
                g.a.c1.a.b(th);
            } else {
                this.done = true;
                this.actual.onError(th);
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (get() == 0) {
                onError(new g.a.v0.c("could not emit value due to lack of requests"));
            } else {
                this.actual.onNext(t);
                g.a.y0.j.d.c(this, 1L);
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

    public h2(g.a.l<T> lVar) {
        super(lVar);
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(cVar));
    }
}
