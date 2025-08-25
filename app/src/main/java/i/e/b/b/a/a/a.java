package i.e.b.b.a.a;

/* loaded from: classes2.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    long f16900a;

    /* renamed from: b, reason: collision with root package name */
    String f16901b;

    /* renamed from: c, reason: collision with root package name */
    String f16902c;

    /* renamed from: d, reason: collision with root package name */
    int f16903d;

    a(String str) {
        this.f16902c = str;
    }

    void a(int i2) {
        this.f16903d = i2;
    }

    void a(long j2) {
        this.f16900a = j2;
    }

    void a(String str) {
        this.f16901b = str;
    }

    boolean a() {
        return this.f16900a > System.currentTimeMillis();
    }

    void b() {
        this.f16900a = 0L;
    }
}
