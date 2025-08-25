package com.bumptech.glide.load.p.d0;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.j;

/* compiled from: PreFillType.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: e, reason: collision with root package name */
    @VisibleForTesting
    static final Bitmap.Config f4513e = Bitmap.Config.RGB_565;

    /* renamed from: a, reason: collision with root package name */
    private final int f4514a;

    /* renamed from: b, reason: collision with root package name */
    private final int f4515b;

    /* renamed from: c, reason: collision with root package name */
    private final Bitmap.Config f4516c;

    /* renamed from: d, reason: collision with root package name */
    private final int f4517d;

    /* compiled from: PreFillType.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f4518a;

        /* renamed from: b, reason: collision with root package name */
        private final int f4519b;

        /* renamed from: c, reason: collision with root package name */
        private Bitmap.Config f4520c;

        /* renamed from: d, reason: collision with root package name */
        private int f4521d;

        public a(int i2) {
            this(i2, i2);
        }

        public a a(@Nullable Bitmap.Config config) {
            this.f4520c = config;
            return this;
        }

        Bitmap.Config b() {
            return this.f4520c;
        }

        public a(int i2, int i3) {
            this.f4521d = 1;
            if (i2 <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            }
            if (i3 <= 0) {
                throw new IllegalArgumentException("Height must be > 0");
            }
            this.f4518a = i2;
            this.f4519b = i3;
        }

        public a a(int i2) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("Weight must be > 0");
            }
            this.f4521d = i2;
            return this;
        }

        d a() {
            return new d(this.f4518a, this.f4519b, this.f4520c, this.f4521d);
        }
    }

    d(int i2, int i3, Bitmap.Config config, int i4) {
        this.f4516c = (Bitmap.Config) j.a(config, "Config must not be null");
        this.f4514a = i2;
        this.f4515b = i3;
        this.f4517d = i4;
    }

    Bitmap.Config a() {
        return this.f4516c;
    }

    int b() {
        return this.f4515b;
    }

    int c() {
        return this.f4517d;
    }

    int d() {
        return this.f4514a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f4515b == dVar.f4515b && this.f4514a == dVar.f4514a && this.f4517d == dVar.f4517d && this.f4516c == dVar.f4516c;
    }

    public int hashCode() {
        return (((((this.f4514a * 31) + this.f4515b) * 31) + this.f4516c.hashCode()) * 31) + this.f4517d;
    }

    public String toString() {
        return "PreFillSize{width=" + this.f4514a + ", height=" + this.f4515b + ", config=" + this.f4516c + ", weight=" + this.f4517d + '}';
    }
}
