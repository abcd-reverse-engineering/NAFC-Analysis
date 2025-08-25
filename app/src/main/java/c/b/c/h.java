package c.b.c;

/* compiled from: FormatException.java */
/* loaded from: classes.dex */
public final class h extends q {

    /* renamed from: a, reason: collision with root package name */
    private static final h f2824a = new h();

    static {
        f2824a.setStackTrace(q.NO_TRACE);
    }

    private h() {
    }

    public static h getFormatInstance() {
        return q.isStackTrace ? new h() : f2824a;
    }

    private h(Throwable th) {
        super(th);
    }

    public static h getFormatInstance(Throwable th) {
        return q.isStackTrace ? new h(th) : f2824a;
    }
}
