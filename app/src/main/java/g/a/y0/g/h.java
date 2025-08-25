package g.a.y0.g;

import g.a.j0;
import java.util.concurrent.ThreadFactory;

/* compiled from: NewThreadScheduler.java */
/* loaded from: classes2.dex */
public final class h extends j0 {

    /* renamed from: b, reason: collision with root package name */
    final ThreadFactory f15960b;

    /* renamed from: c, reason: collision with root package name */
    private static final String f15957c = "RxNewThreadScheduler";

    /* renamed from: e, reason: collision with root package name */
    private static final String f15959e = "rx2.newthread-priority";

    /* renamed from: d, reason: collision with root package name */
    private static final k f15958d = new k(f15957c, Math.max(1, Math.min(10, Integer.getInteger(f15959e, 5).intValue())));

    public h() {
        this(f15958d);
    }

    @Override // g.a.j0
    @g.a.t0.f
    public j0.c a() {
        return new i(this.f15960b);
    }

    public h(ThreadFactory threadFactory) {
        this.f15960b = threadFactory;
    }
}
