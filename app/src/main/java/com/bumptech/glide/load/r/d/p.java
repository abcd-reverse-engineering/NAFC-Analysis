package com.bumptech.glide.load.r.d;

import android.os.Build;

/* compiled from: DownsampleStrategy.java */
/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static final p f4917a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final p f4918b = new b();

    /* renamed from: c, reason: collision with root package name */
    public static final p f4919c = new e();

    /* renamed from: d, reason: collision with root package name */
    public static final p f4920d = new c();

    /* renamed from: e, reason: collision with root package name */
    public static final p f4921e = new d();

    /* renamed from: f, reason: collision with root package name */
    public static final p f4922f = new f();

    /* renamed from: g, reason: collision with root package name */
    public static final p f4923g = f4921e;

    /* renamed from: h, reason: collision with root package name */
    public static final com.bumptech.glide.load.i<p> f4924h = com.bumptech.glide.load.i.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", f4923g);

    /* renamed from: i, reason: collision with root package name */
    static final boolean f4925i;

    /* compiled from: DownsampleStrategy.java */
    private static class a extends p {
        a() {
        }

        @Override // com.bumptech.glide.load.r.d.p
        public g a(int i2, int i3, int i4, int i5) {
            return g.QUALITY;
        }

        @Override // com.bumptech.glide.load.r.d.p
        public float b(int i2, int i3, int i4, int i5) {
            if (Math.min(i3 / i5, i2 / i4) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r1);
        }
    }

    /* compiled from: DownsampleStrategy.java */
    private static class b extends p {
        b() {
        }

        @Override // com.bumptech.glide.load.r.d.p
        public g a(int i2, int i3, int i4, int i5) {
            return g.MEMORY;
        }

        @Override // com.bumptech.glide.load.r.d.p
        public float b(int i2, int i3, int i4, int i5) {
            int iCeil = (int) Math.ceil(Math.max(i3 / i5, i2 / i4));
            return 1.0f / (r2 << (Math.max(1, Integer.highestOneBit(iCeil)) >= iCeil ? 0 : 1));
        }
    }

    /* compiled from: DownsampleStrategy.java */
    private static class c extends p {
        c() {
        }

        @Override // com.bumptech.glide.load.r.d.p
        public g a(int i2, int i3, int i4, int i5) {
            return b(i2, i3, i4, i5) == 1.0f ? g.QUALITY : p.f4919c.a(i2, i3, i4, i5);
        }

        @Override // com.bumptech.glide.load.r.d.p
        public float b(int i2, int i3, int i4, int i5) {
            return Math.min(1.0f, p.f4919c.b(i2, i3, i4, i5));
        }
    }

    /* compiled from: DownsampleStrategy.java */
    private static class d extends p {
        d() {
        }

        @Override // com.bumptech.glide.load.r.d.p
        public g a(int i2, int i3, int i4, int i5) {
            return g.QUALITY;
        }

        @Override // com.bumptech.glide.load.r.d.p
        public float b(int i2, int i3, int i4, int i5) {
            return Math.max(i4 / i2, i5 / i3);
        }
    }

    /* compiled from: DownsampleStrategy.java */
    private static class e extends p {
        e() {
        }

        @Override // com.bumptech.glide.load.r.d.p
        public g a(int i2, int i3, int i4, int i5) {
            return p.f4925i ? g.QUALITY : g.MEMORY;
        }

        @Override // com.bumptech.glide.load.r.d.p
        public float b(int i2, int i3, int i4, int i5) {
            if (p.f4925i) {
                return Math.min(i4 / i2, i5 / i3);
            }
            if (Math.max(i3 / i5, i2 / i4) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r2);
        }
    }

    /* compiled from: DownsampleStrategy.java */
    private static class f extends p {
        f() {
        }

        @Override // com.bumptech.glide.load.r.d.p
        public g a(int i2, int i3, int i4, int i5) {
            return g.QUALITY;
        }

        @Override // com.bumptech.glide.load.r.d.p
        public float b(int i2, int i3, int i4, int i5) {
            return 1.0f;
        }
    }

    /* compiled from: DownsampleStrategy.java */
    public enum g {
        MEMORY,
        QUALITY
    }

    static {
        f4925i = Build.VERSION.SDK_INT >= 19;
    }

    public abstract g a(int i2, int i3, int i4, int i5);

    public abstract float b(int i2, int i3, int i4, int i5);
}
