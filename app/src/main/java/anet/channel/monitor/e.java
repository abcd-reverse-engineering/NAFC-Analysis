package anet.channel.monitor;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class e {

    /* renamed from: b, reason: collision with root package name */
    private double f1827b;

    /* renamed from: c, reason: collision with root package name */
    private double f1828c;

    /* renamed from: d, reason: collision with root package name */
    private double f1829d;

    /* renamed from: e, reason: collision with root package name */
    private double f1830e;

    /* renamed from: f, reason: collision with root package name */
    private double f1831f;

    /* renamed from: g, reason: collision with root package name */
    private double f1832g;

    /* renamed from: h, reason: collision with root package name */
    private double f1833h;

    /* renamed from: a, reason: collision with root package name */
    private long f1826a = 0;

    /* renamed from: i, reason: collision with root package name */
    private double f1834i = 0.0d;

    /* renamed from: j, reason: collision with root package name */
    private double f1835j = 0.0d;

    /* renamed from: k, reason: collision with root package name */
    private double f1836k = 0.0d;

    e() {
    }

    public double a(double d2, double d3) {
        double d4 = d2 / d3;
        if (d4 < 8.0d) {
            if (this.f1826a != 0) {
                return this.f1836k;
            }
            this.f1836k = d4;
            return this.f1836k;
        }
        long j2 = this.f1826a;
        if (j2 == 0) {
            this.f1834i = d4;
            this.f1833h = this.f1834i;
            double d5 = this.f1833h;
            this.f1829d = d5 * 0.1d;
            this.f1828c = 0.02d * d5;
            this.f1830e = 0.1d * d5 * d5;
        } else if (j2 == 1) {
            this.f1835j = d4;
            this.f1833h = this.f1835j;
        } else {
            double d6 = this.f1835j;
            double d7 = d4 - d6;
            this.f1834i = d6;
            this.f1835j = d4;
            this.f1827b = d4 / 0.95d;
            this.f1832g = this.f1827b - (this.f1833h * 0.95d);
            char c2 = 0;
            double dSqrt = Math.sqrt(this.f1829d);
            double d8 = this.f1832g;
            if (d8 >= 4.0d * dSqrt) {
                this.f1832g = (d8 * 0.75d) + (dSqrt * 2.0d);
                c2 = 1;
            } else if (d8 <= (-4.0d) * dSqrt) {
                this.f1832g = (dSqrt * (-1.0d)) + (d8 * 0.75d);
                c2 = 2;
            }
            double d9 = this.f1829d * 1.05d;
            double d10 = this.f1832g;
            this.f1829d = Math.min(Math.max(Math.abs(d9 - ((0.0025d * d10) * d10)), this.f1829d * 0.8d), this.f1829d * 1.25d);
            double d11 = this.f1830e;
            this.f1831f = d11 / ((0.9025d * d11) + this.f1829d);
            this.f1833h = this.f1833h + (1.0526315789473684d * d7) + (this.f1831f * this.f1832g);
            if (c2 == 1) {
                this.f1833h = Math.min(this.f1833h, this.f1827b);
            } else if (c2 == 2) {
                this.f1833h = Math.max(this.f1833h, this.f1827b);
            }
            this.f1830e = (1.0d - (0.95d * this.f1831f)) * (this.f1830e + this.f1828c);
        }
        double d12 = this.f1833h;
        if (d12 < 0.0d) {
            this.f1836k = this.f1835j * 0.7d;
            this.f1833h = this.f1836k;
        } else {
            this.f1836k = d12;
        }
        return this.f1836k;
    }

    public void a() {
        this.f1826a = 0L;
        this.f1836k = 0.0d;
    }
}
