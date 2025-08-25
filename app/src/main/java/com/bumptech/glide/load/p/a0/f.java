package com.bumptech.glide.load.p.a0;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* compiled from: BitmapPoolAdapter.java */
/* loaded from: classes.dex */
public class f implements e {
    @Override // com.bumptech.glide.load.p.a0.e
    public void a() {
    }

    @Override // com.bumptech.glide.load.p.a0.e
    public void a(float f2) {
    }

    @Override // com.bumptech.glide.load.p.a0.e
    public void a(int i2) {
    }

    @Override // com.bumptech.glide.load.p.a0.e
    public void a(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.bumptech.glide.load.p.a0.e
    public long b() {
        return 0L;
    }

    @Override // com.bumptech.glide.load.p.a0.e
    @NonNull
    public Bitmap b(int i2, int i3, Bitmap.Config config) {
        return a(i2, i3, config);
    }

    @Override // com.bumptech.glide.load.p.a0.e
    @NonNull
    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        return Bitmap.createBitmap(i2, i3, config);
    }
}
