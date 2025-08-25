package h.k2.n.a;

import h.t0;

/* compiled from: ContinuationImpl.kt */
@t0(version = "1.3")
/* loaded from: classes2.dex */
public abstract class j extends a {
    public j(@i.c.a.e h.k2.d<Object> dVar) {
        super(dVar);
        if (dVar != null) {
            if (!(dVar.getContext() == h.k2.i.INSTANCE)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // h.k2.d
    @i.c.a.d
    public h.k2.g getContext() {
        return h.k2.i.INSTANCE;
    }
}
