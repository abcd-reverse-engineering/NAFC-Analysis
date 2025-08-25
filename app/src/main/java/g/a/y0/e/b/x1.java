package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableLimit.java */
@g.a.t0.e
/* loaded from: classes2.dex */
public final class x1<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final long f14689c;

    /* compiled from: FlowableLimit.java */
    static final class a<T> extends AtomicLong implements g.a.q<T>, i.d.d {
        private static final long serialVersionUID = 2288246011222124525L;
        final i.d.c<? super T> actual;
        long remaining;
        i.d.d upstream;

        a(i.d.c<? super T> cVar, long j2) {
            this.actual = cVar;
            this.remaining = j2;
            lazySet(j2);
        }

        @Override // i.d.d
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.remaining > 0) {
                this.remaining = 0L;
                this.actual.onComplete();
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.remaining <= 0) {
                g.a.c1.a.b(th);
            } else {
                this.remaining = 0L;
                this.actual.onError(th);
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            long j2 = this.remaining;
            if (j2 > 0) {
                long j3 = j2 - 1;
                this.remaining = j3;
                this.actual.onNext(t);
                if (j3 == 0) {
                    this.upstream.cancel();
                    this.actual.onComplete();
                }
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.upstream, dVar)) {
                if (this.remaining == 0) {
                    dVar.cancel();
                    g.a.y0.i.g.complete(this.actual);
                } else {
                    this.upstream = dVar;
                    this.actual.onSubscribe(this);
                }
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            long j3;
            long j4;
            if (g.a.y0.i.j.validate(j2)) {
                do {
                    j3 = get();
                    if (j3 == 0) {
                        return;
                    } else {
                        j4 = j3 <= j2 ? j3 : j2;
                    }
                } while (!compareAndSet(j3, j3 - j4));
                this.upstream.request(j4);
            }
        }
    }

    public x1(g.a.l<T> lVar, long j2) {
        super(lVar);
        this.f14689c = j2;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(cVar, this.f14689c));
    }
}
