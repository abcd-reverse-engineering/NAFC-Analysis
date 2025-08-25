package l;

/* compiled from: HttpException.java */
/* loaded from: classes2.dex */
public class h extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    private final transient m<?> f17102a;
    private final int code;
    private final String message;

    public h(m<?> mVar) {
        super(a(mVar));
        this.code = mVar.b();
        this.message = mVar.f();
        this.f17102a = mVar;
    }

    private static String a(m<?> mVar) {
        p.a(mVar, "response == null");
        return "HTTP " + mVar.b() + c.c.a.b.a.a.f3100g + mVar.f();
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public m<?> response() {
        return this.f17102a;
    }
}
