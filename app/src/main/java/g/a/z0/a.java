package g.a.z0;

import g.a.b0;
import g.a.t0.f;
import g.a.u0.c;
import g.a.y0.e.d.i2;
import g.a.y0.e.d.k;
import g.a.y0.j.g;

/* compiled from: ConnectableObservable.java */
/* loaded from: classes2.dex */
public abstract class a<T> extends b0<T> {
    @f
    public b0<T> O() {
        return i(1);
    }

    public final c P() {
        g gVar = new g();
        k((g.a.x0.g<? super c>) gVar);
        return gVar.f16043a;
    }

    @f
    public b0<T> Q() {
        return g.a.c1.a.a(new i2(this));
    }

    @f
    public b0<T> a(int i2, @f g.a.x0.g<? super c> gVar) {
        if (i2 > 0) {
            return g.a.c1.a.a(new k(this, i2, gVar));
        }
        k(gVar);
        return g.a.c1.a.a((a) this);
    }

    @f
    public b0<T> i(int i2) {
        return a(i2, g.a.y0.b.a.d());
    }

    public abstract void k(@f g.a.x0.g<? super c> gVar);
}
