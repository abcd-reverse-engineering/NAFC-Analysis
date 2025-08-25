package g.a.g1;

import g.a.q;
import g.a.y0.i.j;
import g.a.y0.j.i;
import h.q2.t.m0;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: DisposableSubscriber.java */
/* loaded from: classes2.dex */
public abstract class b<T> implements q<T>, g.a.u0.c {

    /* renamed from: a, reason: collision with root package name */
    final AtomicReference<i.d.d> f13816a = new AtomicReference<>();

    protected final void a(long j2) {
        this.f13816a.get().request(j2);
    }

    protected void b() {
        this.f13816a.get().request(m0.f16408b);
    }

    @Override // g.a.u0.c
    public final void dispose() {
        j.cancel(this.f13816a);
    }

    @Override // g.a.u0.c
    public final boolean isDisposed() {
        return this.f13816a.get() == j.CANCELLED;
    }

    @Override // g.a.q
    public final void onSubscribe(i.d.d dVar) {
        if (i.a(this.f13816a, dVar, getClass())) {
            b();
        }
    }

    protected final void a() {
        dispose();
    }
}
