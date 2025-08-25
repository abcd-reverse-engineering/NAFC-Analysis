package g.a.a1;

import g.a.i0;

/* compiled from: DefaultObserver.java */
/* loaded from: classes2.dex */
public abstract class b<T> implements i0<T> {

    /* renamed from: a, reason: collision with root package name */
    private g.a.u0.c f13626a;

    protected final void a() {
        g.a.u0.c cVar = this.f13626a;
        this.f13626a = g.a.y0.a.d.DISPOSED;
        cVar.dispose();
    }

    protected void b() {
    }

    @Override // g.a.i0
    public final void onSubscribe(@g.a.t0.f g.a.u0.c cVar) {
        if (g.a.y0.j.i.a(this.f13626a, cVar, getClass())) {
            this.f13626a = cVar;
            b();
        }
    }
}
