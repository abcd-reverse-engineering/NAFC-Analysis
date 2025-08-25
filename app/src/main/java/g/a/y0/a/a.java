package g.a.y0.a;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: ArrayCompositeDisposable.java */
/* loaded from: classes2.dex */
public final class a extends AtomicReferenceArray<g.a.u0.c> implements g.a.u0.c {
    private static final long serialVersionUID = 2746389416410565408L;

    public a(int i2) {
        super(i2);
    }

    @Override // g.a.u0.c
    public void dispose() {
        g.a.u0.c andSet;
        if (get(0) != d.DISPOSED) {
            int length = length();
            for (int i2 = 0; i2 < length; i2++) {
                g.a.u0.c cVar = get(i2);
                d dVar = d.DISPOSED;
                if (cVar != dVar && (andSet = getAndSet(i2, dVar)) != d.DISPOSED && andSet != null) {
                    andSet.dispose();
                }
            }
        }
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return get(0) == d.DISPOSED;
    }

    public g.a.u0.c replaceResource(int i2, g.a.u0.c cVar) {
        g.a.u0.c cVar2;
        do {
            cVar2 = get(i2);
            if (cVar2 == d.DISPOSED) {
                cVar.dispose();
                return null;
            }
        } while (!compareAndSet(i2, cVar2, cVar));
        return cVar2;
    }

    public boolean setResource(int i2, g.a.u0.c cVar) {
        g.a.u0.c cVar2;
        do {
            cVar2 = get(i2);
            if (cVar2 == d.DISPOSED) {
                cVar.dispose();
                return false;
            }
        } while (!compareAndSet(i2, cVar2, cVar));
        if (cVar2 == null) {
            return true;
        }
        cVar2.dispose();
        return true;
    }
}
