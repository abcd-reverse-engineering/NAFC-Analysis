package g.a.y0.i;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: ArrayCompositeSubscription.java */
/* loaded from: classes2.dex */
public final class a extends AtomicReferenceArray<i.d.d> implements g.a.u0.c {
    private static final long serialVersionUID = 2746389416410565408L;

    public a(int i2) {
        super(i2);
    }

    @Override // g.a.u0.c
    public void dispose() {
        i.d.d andSet;
        if (get(0) != j.CANCELLED) {
            int length = length();
            for (int i2 = 0; i2 < length; i2++) {
                i.d.d dVar = get(i2);
                j jVar = j.CANCELLED;
                if (dVar != jVar && (andSet = getAndSet(i2, jVar)) != j.CANCELLED && andSet != null) {
                    andSet.cancel();
                }
            }
        }
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return get(0) == j.CANCELLED;
    }

    public i.d.d replaceResource(int i2, i.d.d dVar) {
        i.d.d dVar2;
        do {
            dVar2 = get(i2);
            if (dVar2 == j.CANCELLED) {
                if (dVar == null) {
                    return null;
                }
                dVar.cancel();
                return null;
            }
        } while (!compareAndSet(i2, dVar2, dVar));
        return dVar2;
    }

    public boolean setResource(int i2, i.d.d dVar) {
        i.d.d dVar2;
        do {
            dVar2 = get(i2);
            if (dVar2 == j.CANCELLED) {
                if (dVar == null) {
                    return false;
                }
                dVar.cancel();
                return false;
            }
        } while (!compareAndSet(i2, dVar2, dVar));
        if (dVar2 == null) {
            return true;
        }
        dVar2.cancel();
        return true;
    }
}
