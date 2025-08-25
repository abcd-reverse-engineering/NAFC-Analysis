package com.bumptech.glide.load.r.d;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* compiled from: BitmapTransformation.java */
/* loaded from: classes.dex */
public abstract class h implements com.bumptech.glide.load.n<Bitmap> {
    protected abstract Bitmap a(@NonNull com.bumptech.glide.load.p.a0.e eVar, @NonNull Bitmap bitmap, int i2, int i3);

    @Override // com.bumptech.glide.load.n
    @NonNull
    public final com.bumptech.glide.load.p.v<Bitmap> a(@NonNull Context context, @NonNull com.bumptech.glide.load.p.v<Bitmap> vVar, int i2, int i3) {
        if (!com.bumptech.glide.util.l.b(i2, i3)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i2 + " or height: " + i3 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        com.bumptech.glide.load.p.a0.e eVarD = com.bumptech.glide.b.a(context).d();
        Bitmap bitmap = vVar.get();
        if (i2 == Integer.MIN_VALUE) {
            i2 = bitmap.getWidth();
        }
        if (i3 == Integer.MIN_VALUE) {
            i3 = bitmap.getHeight();
        }
        Bitmap bitmapA = a(eVarD, bitmap, i2, i3);
        return bitmap.equals(bitmapA) ? vVar : g.a(bitmapA, eVarD);
    }
}
