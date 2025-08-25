package g.a.y0.e.b;

import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableTakeLast.java */
/* loaded from: classes2.dex */
public final class v3<T> extends g.a.y0.e.b.a<T, T> {

    /* renamed from: c, reason: collision with root package name */
    final int f14667c;

    /* compiled from: FlowableTakeLast.java */
    static final class a<T> extends ArrayDeque<T> implements g.a.q<T>, i.d.d {
        private static final long serialVersionUID = 7240042530241604978L;
        final i.d.c<? super T> actual;
        volatile boolean cancelled;
        final int count;
        volatile boolean done;
        i.d.d s;
        final AtomicLong requested = new AtomicLong();
        final AtomicInteger wip = new AtomicInteger();

        a(i.d.c<? super T> cVar, int i2) {
            this.actual = cVar;
            this.count = i2;
        }

        @Override // i.d.d
        public void cancel() {
            this.cancelled = true;
            this.s.cancel();
        }

        void drain() {
            if (this.wip.getAndIncrement() == 0) {
                i.d.c<? super T> cVar = this.actual;
                long jAddAndGet = this.requested.get();
                while (!this.cancelled) {
                    if (this.done) {
                        long j2 = 0;
                        while (j2 != jAddAndGet) {
                            if (this.cancelled) {
                                return;
                            }
                            T tPoll = poll();
                            if (tPoll == null) {
                                cVar.onComplete();
                                return;
                            } else {
                                cVar.onNext(tPoll);
                                j2++;
                            }
                        }
                        if (j2 != 0 && jAddAndGet != h.q2.t.m0.f16408b) {
                            jAddAndGet = this.requested.addAndGet(-j2);
                        }
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // i.d.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.count == size()) {
                poll();
            }
            offer(t);
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
                g.a.y0.j.d.a(this.requested, j2);
                drain();
            }
        }
    }

    public v3(g.a.l<T> lVar, int i2) {
        super(lVar);
        this.f14667c = i2;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14110b.a((g.a.q) new a(cVar, this.f14667c));
    }
}
