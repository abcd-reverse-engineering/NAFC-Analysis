package g.a.y0.g;

import g.a.j0;
import java.util.concurrent.TimeUnit;

/* compiled from: ImmediateThinScheduler.java */
/* loaded from: classes2.dex */
public final class e extends j0 {

    /* renamed from: b, reason: collision with root package name */
    public static final j0 f15926b = new e();

    /* renamed from: c, reason: collision with root package name */
    static final j0.c f15927c = new a();

    /* renamed from: d, reason: collision with root package name */
    static final g.a.u0.c f15928d = g.a.u0.d.b();

    static {
        f15928d.dispose();
    }

    private e() {
    }

    @Override // g.a.j0
    @g.a.t0.f
    public g.a.u0.c a(@g.a.t0.f Runnable runnable) {
        runnable.run();
        return f15928d;
    }

    /* compiled from: ImmediateThinScheduler.java */
    static final class a extends j0.c {
        a() {
        }

        @Override // g.a.j0.c
        @g.a.t0.f
        public g.a.u0.c a(@g.a.t0.f Runnable runnable) {
            runnable.run();
            return e.f15928d;
        }

        @Override // g.a.u0.c
        public void dispose() {
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return false;
        }

        @Override // g.a.j0.c
        @g.a.t0.f
        public g.a.u0.c a(@g.a.t0.f Runnable runnable, long j2, @g.a.t0.f TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
        }

        @Override // g.a.j0.c
        @g.a.t0.f
        public g.a.u0.c a(@g.a.t0.f Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
        }
    }

    @Override // g.a.j0
    @g.a.t0.f
    public g.a.u0.c a(@g.a.t0.f Runnable runnable, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
    }

    @Override // g.a.j0
    @g.a.t0.f
    public g.a.u0.c a(@g.a.t0.f Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
    }

    @Override // g.a.j0
    @g.a.t0.f
    public j0.c a() {
        return f15927c;
    }
}
