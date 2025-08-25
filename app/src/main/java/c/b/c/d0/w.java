package c.b.c.d0;

/* compiled from: UPCEANExtensionSupport.java */
/* loaded from: classes.dex */
final class w {

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f2597c = {1, 1, 2};

    /* renamed from: a, reason: collision with root package name */
    private final u f2598a = new u();

    /* renamed from: b, reason: collision with root package name */
    private final v f2599b = new v();

    w() {
    }

    c.b.c.r a(int i2, c.b.c.z.a aVar, int i3) throws c.b.c.m {
        int[] iArrA = x.a(aVar, i3, false, f2597c);
        try {
            return this.f2599b.a(i2, aVar, iArrA);
        } catch (c.b.c.q unused) {
            return this.f2598a.a(i2, aVar, iArrA);
        }
    }
}
