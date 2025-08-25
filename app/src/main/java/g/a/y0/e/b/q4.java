package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableWithLatestFrom.java */
/* loaded from: classes2.dex */
public final class q4<T, U, R> extends g.a.y0.e.b.a<T, R> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.c<? super T, ? super U, ? extends R> f14543c;

    /* renamed from: d, reason: collision with root package name */
    final i.d.b<? extends U> f14544d;

    /* compiled from: FlowableWithLatestFrom.java */
    final class a implements g.a.q<U> {

        /* renamed from: a, reason: collision with root package name */
        private final b<T, U, R> f14545a;

        a(b<T, U, R> bVar) {
            this.f14545a = bVar;
        }

        @Override // i.d.c
        public void onComplete() {
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.f14545a.otherError(th);
        }

        @Override // i.d.c
        public void onNext(U u) {
            this.f14545a.lazySet(u);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (this.f14545a.setOther(dVar)) {
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    /* compiled from: FlowableWithLatestFrom.java */
    static final class b<T, U, R> extends AtomicReference<U> implements g.a.y0.c.a<T>, i.d.d {
        private static final long serialVersionUID = -312246233408980075L;
        final i.d.c<? super R> actual;
        final g.a.x0.c<? super T, ? super U, ? extends R> combiner;
        final AtomicReference<i.d.d> s = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<i.d.d> other = new AtomicReference<>();

        b(i.d.c<? super R> cVar, g.a.x0.c<? super T, ? super U, ? extends R> cVar2) {
            this.actual = cVar;
            this.combiner = cVar2;
        }

        @Override // i.d.d
        public void cancel() {
            g.a.y0.i.j.cancel(this.s);
            g.a.y0.i.j.cancel(this.other);
        }

        @Override // i.d.c
        public void onComplete() {
            g.a.y0.i.j.cancel(this.other);
            this.actual.onComplete();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            g.a.y0.i.j.cancel(this.other);
            this.actual.onError(th);
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

        public void otherError(Throwable th) {
            g.a.y0.i.j.cancel(this.s);
            this.actual.onError(th);
        }

        @Override // i.d.d
        public void request(long j2) {
            g.a.y0.i.j.deferredRequest(this.s, this.requested, j2);
        }

        public boolean setOther(i.d.d dVar) {
            return g.a.y0.i.j.setOnce(this.other, dVar);
        }

        @Override // g.a.y0.c.a
        public boolean tryOnNext(T t) {
            U u = get();
            if (u != null) {
                try {
                    this.actual.onNext(g.a.y0.b.b.a(this.combiner.apply(t, u), "The combiner returned a null value"));
                    return true;
                } catch (Throwable th) {
                    g.a.v0.b.b(th);
                    cancel();
                    this.actual.onError(th);
                }
            }
            return false;
        }
    }

    public q4(g.a.l<T> lVar, g.a.x0.c<? super T, ? super U, ? extends R> cVar, i.d.b<? extends U> bVar) {
        super(lVar);
        this.f14543c = cVar;
        this.f14544d = bVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super R> cVar) {
        g.a.g1.e eVar = new g.a.g1.e(cVar);
        b bVar = new b(eVar, this.f14543c);
        eVar.onSubscribe(bVar);
        this.f14544d.subscribe(new a(bVar));
        this.f14110b.a((g.a.q) bVar);
    }
}
