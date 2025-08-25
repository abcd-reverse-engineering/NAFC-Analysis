package com.bumptech.glide.load.p.a0;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;

/* compiled from: AttributeStrategy.java */
/* loaded from: classes.dex */
class c implements l {

    /* renamed from: a, reason: collision with root package name */
    private final b f4333a = new b();

    /* renamed from: b, reason: collision with root package name */
    private final h<a, Bitmap> f4334b = new h<>();

    /* compiled from: AttributeStrategy.java */
    @VisibleForTesting
    static class a implements m {

        /* renamed from: a, reason: collision with root package name */
        private final b f4335a;

        /* renamed from: b, reason: collision with root package name */
        private int f4336b;

        /* renamed from: c, reason: collision with root package name */
        private int f4337c;

        /* renamed from: d, reason: collision with root package name */
        private Bitmap.Config f4338d;

        public a(b bVar) {
            this.f4335a = bVar;
        }

        public void a(int i2, int i3, Bitmap.Config config) {
            this.f4336b = i2;
            this.f4337c = i3;
            this.f4338d = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f4336b == aVar.f4336b && this.f4337c == aVar.f4337c && this.f4338d == aVar.f4338d;
        }

        public int hashCode() {
            int i2 = ((this.f4336b * 31) + this.f4337c) * 31;
            Bitmap.Config config = this.f4338d;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        @Override // com.bumptech.glide.load.p.a0.m
        public void offer() {
            this.f4335a.a(this);
        }

        public String toString() {
            return c.c(this.f4336b, this.f4337c, this.f4338d);
        }
    }

    /* compiled from: AttributeStrategy.java */
    @VisibleForTesting
    static class b extends d<a> {
        b() {
        }

        a a(int i2, int i3, Bitmap.Config config) {
            a aVarB = b();
            aVarB.a(i2, i3, config);
            return aVarB;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.p.a0.d
        public a a() {
            return new a(this);
        }
    }

    c() {
    }

    private static String d(Bitmap bitmap) {
        return c(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.p.a0.l
    public void a(Bitmap bitmap) {
        this.f4334b.a(this.f4333a.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.bumptech.glide.load.p.a0.l
    public String b(int i2, int i3, Bitmap.Config config) {
        return c(i2, i3, config);
    }

    @Override // com.bumptech.glide.load.p.a0.l
    public String c(Bitmap bitmap) {
        return d(bitmap);
    }

    @Override // com.bumptech.glide.load.p.a0.l
    public Bitmap removeLast() {
        return this.f4334b.a();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f4334b;
    }

    static String c(int i2, int i3, Bitmap.Config config) {
        return "[" + i2 + "x" + i3 + "], " + config;
    }

    @Override // com.bumptech.glide.load.p.a0.l
    public int b(Bitmap bitmap) {
        return com.bumptech.glide.util.l.a(bitmap);
    }

    @Override // com.bumptech.glide.load.p.a0.l
    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        return this.f4334b.a((h<a, Bitmap>) this.f4333a.a(i2, i3, config));
    }
}
