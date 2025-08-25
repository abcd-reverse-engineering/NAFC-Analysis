package c.b.c;

/* compiled from: ChecksumException.java */
/* loaded from: classes.dex */
public final class d extends q {

    /* renamed from: a, reason: collision with root package name */
    private static final d f2446a = new d();

    static {
        f2446a.setStackTrace(q.NO_TRACE);
    }

    private d() {
    }

    public static d getChecksumInstance() {
        return q.isStackTrace ? new d() : f2446a;
    }

    private d(Throwable th) {
        super(th);
    }

    public static d getChecksumInstance(Throwable th) {
        return q.isStackTrace ? new d(th) : f2446a;
    }
}
