package g.a.y0.i;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SubscriptionHelper.java */
/* loaded from: classes2.dex */
public enum j implements i.d.d {
    CANCELLED;

    public static boolean cancel(AtomicReference<i.d.d> atomicReference) {
        i.d.d andSet;
        i.d.d dVar = atomicReference.get();
        j jVar = CANCELLED;
        if (dVar == jVar || (andSet = atomicReference.getAndSet(jVar)) == CANCELLED) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.cancel();
        return true;
    }

    public static void deferredRequest(AtomicReference<i.d.d> atomicReference, AtomicLong atomicLong, long j2) {
        i.d.d dVar = atomicReference.get();
        if (dVar != null) {
            dVar.request(j2);
            return;
        }
        if (validate(j2)) {
            g.a.y0.j.d.a(atomicLong, j2);
            i.d.d dVar2 = atomicReference.get();
            if (dVar2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    dVar2.request(andSet);
                }
            }
        }
    }

    public static boolean deferredSetOnce(AtomicReference<i.d.d> atomicReference, AtomicLong atomicLong, i.d.d dVar) {
        if (!setOnce(atomicReference, dVar)) {
            return false;
        }
        long andSet = atomicLong.getAndSet(0L);
        if (andSet == 0) {
            return true;
        }
        dVar.request(andSet);
        return true;
    }

    public static boolean isCancelled(i.d.d dVar) {
        return dVar == CANCELLED;
    }

    public static boolean replace(AtomicReference<i.d.d> atomicReference, i.d.d dVar) {
        i.d.d dVar2;
        do {
            dVar2 = atomicReference.get();
            if (dVar2 == CANCELLED) {
                if (dVar == null) {
                    return false;
                }
                dVar.cancel();
                return false;
            }
        } while (!atomicReference.compareAndSet(dVar2, dVar));
        return true;
    }

    public static void reportMoreProduced(long j2) {
        g.a.c1.a.b(new g.a.v0.e("More produced than requested: " + j2));
    }

    public static void reportSubscriptionSet() {
        g.a.c1.a.b(new g.a.v0.e("Subscription already set!"));
    }

    public static boolean set(AtomicReference<i.d.d> atomicReference, i.d.d dVar) {
        i.d.d dVar2;
        do {
            dVar2 = atomicReference.get();
            if (dVar2 == CANCELLED) {
                if (dVar == null) {
                    return false;
                }
                dVar.cancel();
                return false;
            }
        } while (!atomicReference.compareAndSet(dVar2, dVar));
        if (dVar2 == null) {
            return true;
        }
        dVar2.cancel();
        return true;
    }

    public static boolean setOnce(AtomicReference<i.d.d> atomicReference, i.d.d dVar) {
        g.a.y0.b.b.a(dVar, "s is null");
        if (atomicReference.compareAndSet(null, dVar)) {
            return true;
        }
        dVar.cancel();
        if (atomicReference.get() == CANCELLED) {
            return false;
        }
        reportSubscriptionSet();
        return false;
    }

    public static boolean validate(i.d.d dVar, i.d.d dVar2) {
        if (dVar2 == null) {
            g.a.c1.a.b(new NullPointerException("next is null"));
            return false;
        }
        if (dVar == null) {
            return true;
        }
        dVar2.cancel();
        reportSubscriptionSet();
        return false;
    }

    @Override // i.d.d
    public void cancel() {
    }

    @Override // i.d.d
    public void request(long j2) {
    }

    public static boolean validate(long j2) {
        if (j2 > 0) {
            return true;
        }
        g.a.c1.a.b(new IllegalArgumentException("n > 0 required but it was " + j2));
        return false;
    }
}
