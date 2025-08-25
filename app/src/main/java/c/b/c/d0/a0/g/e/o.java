package c.b.c.d0.a0.g.e;

/* compiled from: DecodedInformation.java */
/* loaded from: classes.dex */
final class o extends q {

    /* renamed from: b, reason: collision with root package name */
    private final String f2511b;

    /* renamed from: c, reason: collision with root package name */
    private final int f2512c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f2513d;

    o(int i2, String str) {
        super(i2);
        this.f2511b = str;
        this.f2513d = false;
        this.f2512c = 0;
    }

    String b() {
        return this.f2511b;
    }

    int c() {
        return this.f2512c;
    }

    boolean d() {
        return this.f2513d;
    }

    o(int i2, String str, int i3) {
        super(i2);
        this.f2513d = true;
        this.f2512c = i3;
        this.f2511b = str;
    }
}
