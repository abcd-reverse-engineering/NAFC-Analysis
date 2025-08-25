package g.a.b1;

import g.a.t0.e;

/* compiled from: ParallelFailureHandling.java */
@e
/* loaded from: classes2.dex */
public enum a implements g.a.x0.c<Long, Throwable, a> {
    STOP,
    ERROR,
    SKIP,
    RETRY;

    @Override // g.a.x0.c
    public a apply(Long l2, Throwable th) {
        return this;
    }
}
