package g.a.w0;

import g.a.l;
import g.a.t0.f;
import g.a.u0.c;
import g.a.y0.e.b.k;
import g.a.y0.e.b.t2;
import g.a.y0.j.g;

/* compiled from: ConnectableFlowable.java */
/* loaded from: classes2.dex */
public abstract class a<T> extends l<T> {
    @f
    public l<T> T() {
        return m(1);
    }

    public final c U() {
        g gVar = new g();
        l((g.a.x0.g<? super c>) gVar);
        return gVar.f16043a;
    }

    @f
    public l<T> V() {
        return g.a.c1.a.a(new t2(this));
    }

    @f
    public l<T> a(int i2, @f g.a.x0.g<? super c> gVar) {
        if (i2 > 0) {
            return g.a.c1.a.a(new k(this, i2, gVar));
        }
        l(gVar);
        return g.a.c1.a.a((a) this);
    }

    public abstract void l(@f g.a.x0.g<? super c> gVar);

    @f
    public l<T> m(int i2) {
        return a(i2, g.a.y0.b.a.d());
    }
}
