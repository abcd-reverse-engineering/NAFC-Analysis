package c.b.c.e0.e;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* compiled from: Codeword.java */
/* loaded from: classes.dex */
final class d {

    /* renamed from: f, reason: collision with root package name */
    private static final int f2644f = -1;

    /* renamed from: a, reason: collision with root package name */
    private final int f2645a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2646b;

    /* renamed from: c, reason: collision with root package name */
    private final int f2647c;

    /* renamed from: d, reason: collision with root package name */
    private final int f2648d;

    /* renamed from: e, reason: collision with root package name */
    private int f2649e = -1;

    d(int i2, int i3, int i4, int i5) {
        this.f2645a = i2;
        this.f2646b = i3;
        this.f2647c = i4;
        this.f2648d = i5;
    }

    boolean a(int i2) {
        return i2 != -1 && this.f2647c == (i2 % 3) * 3;
    }

    int b() {
        return this.f2646b;
    }

    int c() {
        return this.f2649e;
    }

    int d() {
        return this.f2645a;
    }

    int e() {
        return this.f2648d;
    }

    int f() {
        return this.f2646b - this.f2645a;
    }

    boolean g() {
        return a(this.f2649e);
    }

    void h() {
        this.f2649e = ((this.f2648d / 30) * 3) + (this.f2647c / 3);
    }

    public String toString() {
        return this.f2649e + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.f2648d;
    }

    int a() {
        return this.f2647c;
    }

    void b(int i2) {
        this.f2649e = i2;
    }
}
