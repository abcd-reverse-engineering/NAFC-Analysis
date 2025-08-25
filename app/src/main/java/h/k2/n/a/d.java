package h.k2.n.a;

import h.k2.g;
import h.q2.t.i0;
import h.t0;

/* compiled from: ContinuationImpl.kt */
@t0(version = "1.3")
/* loaded from: classes2.dex */
public abstract class d extends a {
    private final h.k2.g _context;

    /* renamed from: a, reason: collision with root package name */
    private transient h.k2.d<Object> f16300a;

    public d(@i.c.a.e h.k2.d<Object> dVar, @i.c.a.e h.k2.g gVar) {
        super(dVar);
        this._context = gVar;
    }

    @Override // h.k2.d
    @i.c.a.d
    public h.k2.g getContext() {
        h.k2.g gVar = this._context;
        if (gVar == null) {
            i0.f();
        }
        return gVar;
    }

    @i.c.a.d
    public final h.k2.d<Object> intercepted() {
        h.k2.d<Object> dVarB = this.f16300a;
        if (dVarB == null) {
            h.k2.e eVar = (h.k2.e) getContext().get(h.k2.e.V);
            if (eVar == null || (dVarB = eVar.b(this)) == null) {
                dVarB = this;
            }
            this.f16300a = dVarB;
        }
        return dVarB;
    }

    @Override // h.k2.n.a.a
    protected void releaseIntercepted() {
        h.k2.d<?> dVar = this.f16300a;
        if (dVar != null && dVar != this) {
            g.b bVar = getContext().get(h.k2.e.V);
            if (bVar == null) {
                i0.f();
            }
            ((h.k2.e) bVar).a(dVar);
        }
        this.f16300a = c.f16299a;
    }

    public d(@i.c.a.e h.k2.d<Object> dVar) {
        this(dVar, dVar != null ? dVar.getContext() : null);
    }
}
