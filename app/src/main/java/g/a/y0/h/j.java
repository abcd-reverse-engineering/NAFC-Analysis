package g.a.y0.h;

import g.a.y0.j.v;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: InnerQueuedSubscriber.java */
/* loaded from: classes2.dex */
public final class j<T> extends AtomicReference<i.d.d> implements g.a.q<T>, i.d.d {
    private static final long serialVersionUID = 22876611072430776L;
    volatile boolean done;
    int fusionMode;
    final int limit;
    final k<T> parent;
    final int prefetch;
    long produced;
    volatile g.a.y0.c.o<T> queue;

    public j(k<T> kVar, int i2) {
        this.parent = kVar;
        this.prefetch = i2;
        this.limit = i2 - (i2 >> 2);
    }

    @Override // i.d.d
    public void cancel() {
        g.a.y0.i.j.cancel(this);
    }

    public boolean isDone() {
        return this.done;
    }

    @Override // i.d.c
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    @Override // i.d.c
    public void onError(Throwable th) {
        this.parent.innerError(this, th);
    }

    @Override // i.d.c
    public void onNext(T t) {
        if (this.fusionMode == 0) {
            this.parent.innerNext(this, t);
        } else {
            this.parent.drain();
        }
    }

    @Override // g.a.q
    public void onSubscribe(i.d.d dVar) {
        if (g.a.y0.i.j.setOnce(this, dVar)) {
            if (dVar instanceof g.a.y0.c.l) {
                g.a.y0.c.l lVar = (g.a.y0.c.l) dVar;
                int iRequestFusion = lVar.requestFusion(3);
                if (iRequestFusion == 1) {
                    this.fusionMode = iRequestFusion;
                    this.queue = lVar;
                    this.done = true;
                    this.parent.innerComplete(this);
                    return;
                }
                if (iRequestFusion == 2) {
                    this.fusionMode = iRequestFusion;
                    this.queue = lVar;
                    v.a(dVar, this.prefetch);
                    return;
                }
            }
            this.queue = v.a(this.prefetch);
            v.a(dVar, this.prefetch);
        }
    }

    public g.a.y0.c.o<T> queue() {
        return this.queue;
    }

    @Override // i.d.d
    public void request(long j2) {
        if (this.fusionMode != 1) {
            long j3 = this.produced + j2;
            if (j3 < this.limit) {
                this.produced = j3;
            } else {
                this.produced = 0L;
                get().request(j3);
            }
        }
    }

    public void requestOne() {
        if (this.fusionMode != 1) {
            long j2 = this.produced + 1;
            if (j2 != this.limit) {
                this.produced = j2;
            } else {
                this.produced = 0L;
                get().request(j2);
            }
        }
    }

    public void setDone() {
        this.done = true;
    }
}
