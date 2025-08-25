package c.b.c.y.a;

/* compiled from: ParsedResult.java */
/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    private final r f2984a;

    protected q(r rVar) {
        this.f2984a = rVar;
    }

    public static void a(String str, StringBuilder sb) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append('\n');
        }
        sb.append(str);
    }

    public abstract String a();

    public final r b() {
        return this.f2984a;
    }

    public final String toString() {
        return a();
    }

    public static void a(String[] strArr, StringBuilder sb) {
        if (strArr != null) {
            for (String str : strArr) {
                a(str, sb);
            }
        }
    }
}
