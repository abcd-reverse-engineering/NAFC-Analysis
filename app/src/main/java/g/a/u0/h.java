package g.a.u0;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SerialDisposable.java */
/* loaded from: classes2.dex */
public final class h implements c {

    /* renamed from: a, reason: collision with root package name */
    final AtomicReference<c> f13876a;

    public h() {
        this.f13876a = new AtomicReference<>();
    }

    public boolean a(@g.a.t0.g c cVar) {
        return g.a.y0.a.d.replace(this.f13876a, cVar);
    }

    public boolean b(@g.a.t0.g c cVar) {
        return g.a.y0.a.d.set(this.f13876a, cVar);
    }

    @Override // g.a.u0.c
    public void dispose() {
        g.a.y0.a.d.dispose(this.f13876a);
    }

    @Override // g.a.u0.c
    public boolean isDisposed() {
        return g.a.y0.a.d.isDisposed(this.f13876a.get());
    }

    @g.a.t0.g
    public c a() {
        c cVar = this.f13876a.get();
        return cVar == g.a.y0.a.d.DISPOSED ? d.a() : cVar;
    }

    public h(@g.a.t0.g c cVar) {
        this.f13876a = new AtomicReference<>(cVar);
    }
}
