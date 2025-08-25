package com.bumptech.glide.r.m;

import android.graphics.drawable.Drawable;

/* compiled from: DrawableCrossFadeFactory.java */
/* loaded from: classes.dex */
public class c implements g<Drawable> {

    /* renamed from: a, reason: collision with root package name */
    private final int f5328a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f5329b;

    /* renamed from: c, reason: collision with root package name */
    private d f5330c;

    /* compiled from: DrawableCrossFadeFactory.java */
    public static class a {

        /* renamed from: c, reason: collision with root package name */
        private static final int f5331c = 300;

        /* renamed from: a, reason: collision with root package name */
        private final int f5332a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f5333b;

        public a() {
            this(300);
        }

        public a a(boolean z) {
            this.f5333b = z;
            return this;
        }

        public a(int i2) {
            this.f5332a = i2;
        }

        public c a() {
            return new c(this.f5332a, this.f5333b);
        }
    }

    protected c(int i2, boolean z) {
        this.f5328a = i2;
        this.f5329b = z;
    }

    @Override // com.bumptech.glide.r.m.g
    public f<Drawable> a(com.bumptech.glide.load.a aVar, boolean z) {
        return aVar == com.bumptech.glide.load.a.MEMORY_CACHE ? e.a() : a();
    }

    private f<Drawable> a() {
        if (this.f5330c == null) {
            this.f5330c = new d(this.f5328a, this.f5329b);
        }
        return this.f5330c;
    }
}
