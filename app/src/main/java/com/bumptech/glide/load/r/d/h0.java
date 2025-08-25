package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* compiled from: UnitBitmapDecoder.java */
/* loaded from: classes.dex */
public final class h0 implements com.bumptech.glide.load.l<Bitmap, Bitmap> {

    /* compiled from: UnitBitmapDecoder.java */
    private static final class a implements com.bumptech.glide.load.p.v<Bitmap> {

        /* renamed from: a, reason: collision with root package name */
        private final Bitmap f4879a;

        a(@NonNull Bitmap bitmap) {
            this.f4879a = bitmap;
        }

        @Override // com.bumptech.glide.load.p.v
        public int a() {
            return com.bumptech.glide.util.l.a(this.f4879a);
        }

        @Override // com.bumptech.glide.load.p.v
        @NonNull
        public Class<Bitmap> b() {
            return Bitmap.class;
        }

        @Override // com.bumptech.glide.load.p.v
        public void recycle() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.load.p.v
        @NonNull
        public Bitmap get() {
            return this.f4879a;
        }
    }

    @Override // com.bumptech.glide.load.l
    public boolean a(@NonNull Bitmap bitmap, @NonNull com.bumptech.glide.load.j jVar) {
        return true;
    }

    @Override // com.bumptech.glide.load.l
    public com.bumptech.glide.load.p.v<Bitmap> a(@NonNull Bitmap bitmap, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) {
        return new a(bitmap);
    }
}
