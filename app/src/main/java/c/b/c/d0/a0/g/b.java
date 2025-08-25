package c.b.c.d0.a0.g;

/* compiled from: ExpandedPair.java */
/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f2477a;

    /* renamed from: b, reason: collision with root package name */
    private final c.b.c.d0.a0.b f2478b;

    /* renamed from: c, reason: collision with root package name */
    private final c.b.c.d0.a0.b f2479c;

    /* renamed from: d, reason: collision with root package name */
    private final c.b.c.d0.a0.c f2480d;

    b(c.b.c.d0.a0.b bVar, c.b.c.d0.a0.b bVar2, c.b.c.d0.a0.c cVar, boolean z) {
        this.f2478b = bVar;
        this.f2479c = bVar2;
        this.f2480d = cVar;
        this.f2477a = z;
    }

    c.b.c.d0.a0.c a() {
        return this.f2480d;
    }

    c.b.c.d0.a0.b b() {
        return this.f2478b;
    }

    c.b.c.d0.a0.b c() {
        return this.f2479c;
    }

    boolean d() {
        return this.f2477a;
    }

    public boolean e() {
        return this.f2479c == null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return a(this.f2478b, bVar.f2478b) && a(this.f2479c, bVar.f2479c) && a(this.f2480d, bVar.f2480d);
    }

    public int hashCode() {
        return (a(this.f2478b) ^ a(this.f2479c)) ^ a(this.f2480d);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        sb.append(this.f2478b);
        sb.append(" , ");
        sb.append(this.f2479c);
        sb.append(" : ");
        c.b.c.d0.a0.c cVar = this.f2480d;
        sb.append(cVar == null ? c.c.a.b.a.a.f3101h : Integer.valueOf(cVar.c()));
        sb.append(" ]");
        return sb.toString();
    }

    private static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    private static int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}
