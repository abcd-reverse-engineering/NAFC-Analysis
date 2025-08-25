package g.a.y0.e.b;

/* compiled from: FlowableLift.java */
/* loaded from: classes2.dex */
public final class w1<R, T> extends a<T, R> {

    /* renamed from: c, reason: collision with root package name */
    final g.a.p<? extends R, ? super T> f14679c;

    public w1(g.a.l<T> lVar, g.a.p<? extends R, ? super T> pVar) {
        super(lVar);
        this.f14679c = pVar;
    }

    @Override // g.a.l
    public void d(i.d.c<? super R> cVar) {
        try {
            i.d.c<? super Object> cVarA = this.f14679c.a(cVar);
            if (cVarA != null) {
                this.f14110b.subscribe(cVarA);
                return;
            }
            throw new NullPointerException("Operator " + this.f14679c + " returned a null Subscriber");
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            g.a.c1.a.b(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
