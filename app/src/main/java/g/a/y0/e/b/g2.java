package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableOnBackpressureDrop.java */
/* loaded from: classes2.dex */
public final class g2<T> extends g.a.y0.e.b.a<T, T> implements g.a.x0.g<T> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.g<? super T> f14251c;

    /* compiled from: FlowableOnBackpressureDrop.java */
    static final class a<T> extends AtomicLong implements g.a.q<T>, i.d.d {
        private static final long serialVersionUID = -6246093802440953054L;
        final i.d.c<? super T> actual;
        boolean done;
        final g.a.x0.g<? super T> onDrop;
        i.d.d s;

        a(i.d.c<? super T> cVar, g.a.x0.g<? super T> gVar) {
            this.actual = cVar;
            this.onDrop = gVar;
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
            if (get() != 0) {
                this.actual.onNext(t);
                g.a.y0.j.d.c(this, 1L);
                return;
            }
            try {
                this.onDrop.accept(t);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                cancel();
                onError(th);
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

    public g2(g.a.l<T> lVar) {
        super(lVar);
        this.f14251c = this;
    }

    @Override // g.a.x0.g
    public void accept(T t) {
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(cVar, this.f14251c));
    }

    public g2(g.a.l<T> lVar, g.a.x0.g<? super T> gVar) {
        super(lVar);
        this.f14251c = gVar;
    }
}
