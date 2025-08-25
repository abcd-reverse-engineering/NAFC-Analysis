package h.k2.n.a;

import h.q0;
import h.r0;
import h.y1;

/* compiled from: RunSuspend.kt */
/* loaded from: classes2.dex */
final class l implements h.k2.d<y1> {

    /* renamed from: a, reason: collision with root package name */
    @i.c.a.e
    private q0<y1> f16308a;

    public final void a(@i.c.a.e q0<y1> q0Var) {
        this.f16308a = q0Var;
    }

    @i.c.a.e
    public final q0<y1> b() {
        return this.f16308a;
    }

    @Override // h.k2.d
    @i.c.a.d
    public h.k2.g getContext() {
        return h.k2.i.INSTANCE;
    }

    @Override // h.k2.d
    public void resumeWith(@i.c.a.d Object obj) {
        synchronized (this) {
            this.f16308a = q0.m771boximpl(obj);
            notifyAll();
            y1 y1Var = y1.f16671a;
        }
    }

    public final void a() {
        synchronized (this) {
            while (true) {
                q0<y1> q0Var = this.f16308a;
                if (q0Var == null) {
                    wait();
                } else {
                    r0.b(q0Var.m780unboximpl());
                }
            }
        }
    }
}
