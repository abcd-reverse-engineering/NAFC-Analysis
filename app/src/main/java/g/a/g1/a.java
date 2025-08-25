package g.a.g1;

import g.a.q;
import g.a.y0.i.j;
import g.a.y0.j.i;
import h.q2.t.m0;

/* compiled from: DefaultSubscriber.java */
/* loaded from: classes2.dex */
public abstract class a<T> implements q<T> {

    /* renamed from: a, reason: collision with root package name */
    private i.d.d f13815a;

    protected final void a(long j2) {
        i.d.d dVar = this.f13815a;
        if (dVar != null) {
            dVar.request(j2);
        }
    }

    protected void b() {
        a(m0.f16408b);
    }

    @Override // g.a.q
    public final void onSubscribe(i.d.d dVar) {
        if (i.a(this.f13815a, dVar, getClass())) {
            this.f13815a = dVar;
            b();
        }
    }

    protected final void a() {
        i.d.d dVar = this.f13815a;
        this.f13815a = j.CANCELLED;
        dVar.cancel();
    }
}
