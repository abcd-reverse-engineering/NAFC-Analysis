package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: FlowableTake.java */
/* loaded from: classes2.dex */
public final class u3<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final long f14654c;

    /* compiled from: FlowableTake.java */
    static final class a<T> extends AtomicBoolean implements g.a.q<T>, i.d.d {
        private static final long serialVersionUID = -5636543848937116287L;
        final i.d.c<? super T> actual;
        boolean done;
        final long limit;
        long remaining;
        i.d.d subscription;

        a(i.d.c<? super T> cVar, long j2) {
            this.actual = cVar;
            this.limit = j2;
            this.remaining = j2;
        }

        @Override // i.d.d
        public void cancel() {
            this.subscription.cancel();
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
                return;
            }
            this.done = true;
            this.subscription.cancel();
            this.actual.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j2 = this.remaining;
            this.remaining = j2 - 1;
            if (j2 > 0) {
                boolean z = this.remaining == 0;
                this.actual.onNext(t);
                if (z) {
                    this.subscription.cancel();
                    onComplete();
                }
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.subscription, dVar)) {
                this.subscription = dVar;
                if (this.limit != 0) {
                    this.actual.onSubscribe(this);
                    return;
                }
                dVar.cancel();
                this.done = true;
                g.a.y0.i.g.complete(this.actual);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                if (get() || !compareAndSet(false, true) || j2 < this.limit) {
                    this.subscription.request(j2);
                } else {
                    this.subscription.request(h.q2.t.m0.f16408b);
                }
            }
        }
    }

    public u3(g.a.l<T> lVar, long j2) {
        super(lVar);
        this.f14654c = j2;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(cVar, this.f14654c));
    }
}
