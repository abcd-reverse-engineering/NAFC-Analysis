package g.a.u0;

import java.util.concurrent.Future;

/* compiled from: Disposables.java */
/* loaded from: classes2.dex */
public final class d {
    private d() {
        throw new IllegalStateException("No instances!");
    }

    @g.a.t0.f
    public static c a(@g.a.t0.f Runnable runnable) {
        g.a.y0.b.b.a(runnable, "run is null");
        return new g(runnable);
    }

    @g.a.t0.f
    public static c b() {
        return a(g.a.y0.b.a.f13898b);
    }

    @g.a.t0.f
    public static c a(@g.a.t0.f g.a.x0.a aVar) {
        g.a.y0.b.b.a(aVar, "run is null");
        return new a(aVar);
    }

    @g.a.t0.f
    public static c a(@g.a.t0.f Future<?> future) {
        g.a.y0.b.b.a(future, "future is null");
        return a(future, true);
    }

    @g.a.t0.f
    public static c a(@g.a.t0.f Future<?> future, boolean z) {
        g.a.y0.b.b.a(future, "future is null");
        return new e(future, z);
    }

    @g.a.t0.f
    public static c a(@g.a.t0.f i.d.d dVar) {
        g.a.y0.b.b.a(dVar, "subscription is null");
        return new i(dVar);
    }

    @g.a.t0.f
    public static c a() {
        return g.a.y0.a.e.INSTANCE;
    }
}
