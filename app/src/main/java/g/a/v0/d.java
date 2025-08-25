package g.a.v0;

/* compiled from: OnErrorNotImplementedException.java */
@g.a.t0.c
/* loaded from: classes2.dex */
public final class d extends RuntimeException {
    private static final long serialVersionUID = -6298857009889503852L;

    public d(String str, @g.a.t0.f Throwable th) {
        super(str, th == null ? new NullPointerException() : th);
    }

    public d(@g.a.t0.f Throwable th) {
        super(th != null ? th.getMessage() : null, th == null ? new NullPointerException() : th);
    }
}
