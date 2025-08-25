package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableConcatMapEager.java */
/* loaded from: classes2.dex */
public final class x<T, R> extends g.a.y0.e.b.a<T, R> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends i.d.b<? extends R>> f14682c;

    /* renamed from: d, reason: collision with root package name */
    final int f14683d;

    /* renamed from: e, reason: collision with root package name */
    final int f14684e;

    /* renamed from: f, reason: collision with root package name */
    final g.a.y0.j.j f14685f;

    /* compiled from: FlowableConcatMapEager.java */
    static final class a<T, R> extends AtomicInteger implements g.a.q<T>, i.d.d, g.a.y0.h.k<R> {
        private static final long serialVersionUID = -4255299542215038287L;
        final i.d.c<? super R> actual;
        volatile boolean cancelled;
        volatile g.a.y0.h.j<R> current;
        volatile boolean done;
        final g.a.y0.j.j errorMode;
        final g.a.x0.o<? super T, ? extends i.d.b<? extends R>> mapper;
        final int maxConcurrency;
        final int prefetch;
        i.d.d s;
        final g.a.y0.f.c<g.a.y0.h.j<R>> subscribers;
        final g.a.y0.j.c errors = new g.a.y0.j.c();
        final AtomicLong requested = new AtomicLong();

        a(i.d.c<? super R> cVar, g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar, int i2, int i3, g.a.y0.j.j jVar) {
            this.actual = cVar;
            this.mapper = oVar;
            this.maxConcurrency = i2;
            this.prefetch = i3;
            this.errorMode = jVar;
            this.subscribers = new g.a.y0.f.c<>(Math.min(i3, i2));
        }

        @Override // i.d.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.cancel();
            drainAndCancel();
        }

        void cancelAll() {
            while (true) {
                g.a.y0.h.j<R> jVarPoll = this.subscribers.poll();
                if (jVarPoll == null) {
                    return;
                } else {
                    jVarPoll.cancel();
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:72:0x0110  */
        @Override // g.a.y0.h.k
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void drain() {
            /*
                Method dump skipped, instructions count: 315
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.y0.e.b.x.a.drain():void");
        }

        void drainAndCancel() {
            if (getAndIncrement() == 0) {
                do {
                    cancelAll();
                } while (decrementAndGet() != 0);
            }
        }

        @Override // g.a.y0.h.k
        public void innerComplete(g.a.y0.h.j<R> jVar) {
            jVar.setDone();
            drain();
        }

        @Override // g.a.y0.h.k
        public void innerError(g.a.y0.h.j<R> jVar, Throwable th) {
            if (!this.errors.addThrowable(th)) {
                g.a.c1.a.b(th);
                return;
            }
            jVar.setDone();
            if (this.errorMode != g.a.y0.j.j.END) {
                this.s.cancel();
            }
            drain();
        }

        @Override // g.a.y0.h.k
        public void innerNext(g.a.y0.h.j<R> jVar, R r) {
            if (jVar.queue().offer(r)) {
                drain();
            } else {
                jVar.cancel();
                innerError(jVar, new g.a.v0.c());
            }
        }

        @Override // i.d.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                g.a.c1.a.b(th);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            try {
                i.d.b bVar = (i.d.b) g.a.y0.b.b.a(this.mapper.apply(t), "The mapper returned a null Publisher");
                g.a.y0.h.j<R> jVar = new g.a.y0.h.j<>(this, this.prefetch);
                if (this.cancelled) {
                    return;
                }
                this.subscribers.offer(jVar);
                if (this.cancelled) {
                    return;
                }
                bVar.subscribe(jVar);
                if (this.cancelled) {
                    jVar.cancel();
                    drainAndCancel();
                }
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.s.cancel();
                onError(th);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                int i2 = this.maxConcurrency;
                dVar.request(i2 == Integer.MAX_VALUE ? h.q2.t.m0.f16408b : i2);
            }
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                g.a.y0.j.d.a(this.requested, j2);
                drain();
            }
        }
    }

    public x(g.a.l<T> lVar, g.a.x0.o<? super T, ? extends i.d.b<? extends R>> oVar, int i2, int i3, g.a.y0.j.j jVar) {
        super(lVar);
        this.f14682c = oVar;
        this.f14683d = i2;
        this.f14684e = i3;
        this.f14685f = jVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super R> cVar) {
        this.f14110b.a((g.a.q) new a(cVar, this.f14682c, this.f14683d, this.f14684e, this.f14685f));
    }
}
