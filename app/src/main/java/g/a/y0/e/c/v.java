package g.a.y0.e.c;

/* compiled from: MaybeError.java */
/* loaded from: classes2.dex */
public final class v<T> extends g.a.s<T> {

    /* renamed from: a, reason: collision with root package name */
    final Throwable f14908a;

    public v(Throwable th) {
        this.f14908a = th;
    }

    @Override // g.a.s
    protected void b(g.a.v<? super T> vVar) {
        vVar.onSubscribe(g.a.u0.d.a());
        vVar.onError(this.f14908a);
    }
}
