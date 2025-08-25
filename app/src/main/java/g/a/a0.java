package g.a;

/* compiled from: Notification.java */
/* loaded from: classes2.dex */
public final class a0<T> {

    /* renamed from: b, reason: collision with root package name */
    static final a0<Object> f13613b = new a0<>(null);

    /* renamed from: a, reason: collision with root package name */
    final Object f13614a;

    private a0(Object obj) {
        this.f13614a = obj;
    }

    @g.a.t0.f
    public static <T> a0<T> f() {
        return (a0<T>) f13613b;
    }

    @g.a.t0.g
    public Throwable a() {
        Object obj = this.f13614a;
        if (g.a.y0.j.q.isError(obj)) {
            return g.a.y0.j.q.getError(obj);
        }
        return null;
    }

    @g.a.t0.g
    public T b() {
        Object obj = this.f13614a;
        if (obj == null || g.a.y0.j.q.isError(obj)) {
            return null;
        }
        return (T) this.f13614a;
    }

    public boolean c() {
        return this.f13614a == null;
    }

    public boolean d() {
        return g.a.y0.j.q.isError(this.f13614a);
    }

    public boolean e() {
        Object obj = this.f13614a;
        return (obj == null || g.a.y0.j.q.isError(obj)) ? false : true;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a0) {
            return g.a.y0.b.b.a(this.f13614a, ((a0) obj).f13614a);
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.f13614a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.f13614a;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (g.a.y0.j.q.isError(obj)) {
            return "OnErrorNotification[" + g.a.y0.j.q.getError(obj) + "]";
        }
        return "OnNextNotification[" + this.f13614a + "]";
    }

    @g.a.t0.f
    public static <T> a0<T> a(@g.a.t0.f T t) {
        g.a.y0.b.b.a((Object) t, "value is null");
        return new a0<>(t);
    }

    @g.a.t0.f
    public static <T> a0<T> a(@g.a.t0.f Throwable th) {
        g.a.y0.b.b.a(th, "error is null");
        return new a0<>(g.a.y0.j.q.error(th));
    }
}
