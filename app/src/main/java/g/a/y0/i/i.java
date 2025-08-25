package g.a.y0.i;

import h.q2.t.m0;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SubscriptionArbiter.java */
/* loaded from: classes2.dex */
public class i extends AtomicInteger implements i.d.d {
    private static final long serialVersionUID = -2189523197179400958L;
    i.d.d actual;
    volatile boolean cancelled;
    long requested;
    protected boolean unbounded;
    final AtomicReference<i.d.d> missedSubscription = new AtomicReference<>();
    final AtomicLong missedRequested = new AtomicLong();
    final AtomicLong missedProduced = new AtomicLong();

    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        drain();
    }

    final void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        drainLoop();
    }

    final void drainLoop() {
        i.d.d dVar = null;
        long jA = 0;
        int iAddAndGet = 1;
        do {
            i.d.d andSet = this.missedSubscription.get();
            if (andSet != null) {
                andSet = this.missedSubscription.getAndSet(null);
            }
            long andSet2 = this.missedRequested.get();
            if (andSet2 != 0) {
                andSet2 = this.missedRequested.getAndSet(0L);
            }
            long andSet3 = this.missedProduced.get();
            if (andSet3 != 0) {
                andSet3 = this.missedProduced.getAndSet(0L);
            }
            i.d.d dVar2 = this.actual;
            if (this.cancelled) {
                if (dVar2 != null) {
                    dVar2.cancel();
                    this.actual = null;
                }
                if (andSet != null) {
                    andSet.cancel();
                }
            } else {
                long jA2 = this.requested;
                if (jA2 != m0.f16408b) {
                    jA2 = g.a.y0.j.d.a(jA2, andSet2);
                    if (jA2 != m0.f16408b) {
                        long j2 = jA2 - andSet3;
                        if (j2 < 0) {
                            j.reportMoreProduced(j2);
                            j2 = 0;
                        }
                        jA2 = j2;
                    }
                    this.requested = jA2;
                }
                if (andSet != null) {
                    if (dVar2 != null) {
                        dVar2.cancel();
                    }
                    this.actual = andSet;
                    if (jA2 != 0) {
                        jA = g.a.y0.j.d.a(jA, jA2);
                        dVar = andSet;
                    }
                } else if (dVar2 != null && andSet2 != 0) {
                    jA = g.a.y0.j.d.a(jA, andSet2);
                    dVar = dVar2;
                }
            }
            iAddAndGet = addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
        if (jA != 0) {
            dVar.request(jA);
        }
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }

    public final boolean isUnbounded() {
        return this.unbounded;
    }

    public final void produced(long j2) {
        if (this.unbounded) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            g.a.y0.j.d.a(this.missedProduced, j2);
            drain();
            return;
        }
        long j3 = this.requested;
        if (j3 != m0.f16408b) {
            long j4 = j3 - j2;
            long j5 = 0;
            if (j4 < 0) {
                j.reportMoreProduced(j4);
            } else {
                j5 = j4;
            }
            this.requested = j5;
        }
        if (decrementAndGet() == 0) {
            return;
        }
        drainLoop();
    }

    @Override // i.d.d
    public final void request(long j2) {
        if (!j.validate(j2) || this.unbounded) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            g.a.y0.j.d.a(this.missedRequested, j2);
            drain();
            return;
        }
        long j3 = this.requested;
        if (j3 != m0.f16408b) {
            long jA = g.a.y0.j.d.a(j3, j2);
            this.requested = jA;
            if (jA == m0.f16408b) {
                this.unbounded = true;
            }
        }
        i.d.d dVar = this.actual;
        if (decrementAndGet() != 0) {
            drainLoop();
        }
        if (dVar != null) {
            dVar.request(j2);
        }
    }

    public final void setSubscription(i.d.d dVar) {
        if (this.cancelled) {
            dVar.cancel();
            return;
        }
        g.a.y0.b.b.a(dVar, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            i.d.d andSet = this.missedSubscription.getAndSet(dVar);
            if (andSet != null) {
                andSet.cancel();
            }
            drain();
            return;
        }
        i.d.d dVar2 = this.actual;
        if (dVar2 != null) {
            dVar2.cancel();
        }
        this.actual = dVar;
        long j2 = this.requested;
        if (decrementAndGet() != 0) {
            drainLoop();
        }
        if (j2 != 0) {
            dVar.request(j2);
        }
    }
}
