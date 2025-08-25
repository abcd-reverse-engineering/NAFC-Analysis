package g.a.y0.a;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: DisposableHelper.java */
/* loaded from: classes2.dex */
public enum d implements g.a.u0.c {
    DISPOSED;

    public static boolean dispose(AtomicReference<g.a.u0.c> atomicReference) {
        g.a.u0.c andSet;
        g.a.u0.c cVar = atomicReference.get();
        d dVar = DISPOSED;
        if (cVar == dVar || (andSet = atomicReference.getAndSet(dVar)) == dVar) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.dispose();
        return true;
    }

    public static boolean isDisposed(g.a.u0.c cVar) {
        return cVar == DISPOSED;
    }

    public static boolean replace(AtomicReference<g.a.u0.c> atomicReference, g.a.u0.c cVar) {
        g.a.u0.c cVar2;
        do {
            cVar2 = atomicReference.get();
            if (cVar2 == DISPOSED) {
                if (cVar == null) {
                    return false;
                }
                cVar.dispose();
                return false;
            }
        } while (!atomicReference.compareAndSet(cVar2, cVar));
        return true;
    }

    public static void reportDisposableSet() {
        g.a.c1.a.b(new g.a.v0.e("Disposable already set!"));
    }

    public static boolean set(AtomicReference<g.a.u0.c> atomicReference, g.a.u0.c cVar) {
        g.a.u0.c cVar2;
        do {
            cVar2 = atomicReference.get();
            if (cVar2 == DISPOSED) {
                if (cVar == null) {
                    return false;
                }
                cVar.dispose();
                return false;
            }
        } while (!atomicReference.compareAndSet(cVar2, cVar));
        if (cVar2 == null) {
            return true;
        }
        cVar2.dispose();
        return true;
    }

    public static boolean setOnce(AtomicReference<g.a.u0.c> atomicReference, g.a.u0.c cVar) {
        g.a.y0.b.b.a(cVar, "d is null");
        if (atomicReference.compareAndSet(null, cVar)) {
            return true;
        }
        cVar.dispose();
        if (atomicReference.get() == DISPOSED) {
            return false;
        }
        reportDisposableSet();
        return false;
    }

    public static boolean trySet(AtomicReference<g.a.u0.c> atomicReference, g.a.u0.c cVar) {
        if (atomicReference.compareAndSet(null, cVar)) {
            return true;
        }
        if (atomicReference.get() != DISPOSED) {
            return false;
        }
        cVar.dispose();
        return false;
    }

    public static boolean validate(g.a.u0.c cVar, g.a.u0.c cVar2) {
        if (cVar2 == null) {
            g.a.c1.a.b(new NullPointerException("next is null"));
            return false;
        }
        if (cVar == null) {
            return true;
        }
        cVar2.dispose();
        reportDisposableSet();
        return false;
    }

    @Override // g.a.u0.c
    public void dispose() {
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return true;
    }
}
