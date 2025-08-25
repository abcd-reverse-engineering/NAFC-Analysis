package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.concurrent.locks.Lock;

/* compiled from: DrawableToBitmapConverter.java */
/* loaded from: classes.dex */
final class r {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4940a = "DrawableToBitmap";

    /* renamed from: b, reason: collision with root package name */
    private static final com.bumptech.glide.load.p.a0.e f4941b = new a();

    /* compiled from: DrawableToBitmapConverter.java */
    class a extends com.bumptech.glide.load.p.a0.f {
        a() {
        }

        @Override // com.bumptech.glide.load.p.a0.f, com.bumptech.glide.load.p.a0.e
        public void a(Bitmap bitmap) {
        }
    }

    private r() {
    }

    @Nullable
    static com.bumptech.glide.load.p.v<Bitmap> a(com.bumptech.glide.load.p.a0.e eVar, Drawable drawable, int i2, int i3) {
        Bitmap bitmapB;
        Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof BitmapDrawable) {
            bitmapB = ((BitmapDrawable) current).getBitmap();
        } else if (current instanceof Animatable) {
            bitmapB = null;
        } else {
            bitmapB = b(eVar, current, i2, i3);
            z = true;
        }
        if (!z) {
            eVar = f4941b;
        }
        return g.a(bitmapB, eVar);
    }

    @Nullable
    private static Bitmap b(com.bumptech.glide.load.p.a0.e eVar, Drawable drawable, int i2, int i3) {
        if (i2 == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable(f4940a, 5)) {
                String str = "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width";
            }
            return null;
        }
        if (i3 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
            if (Log.isLoggable(f4940a, 5)) {
                String str2 = "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height";
            }
            return null;
        }
        if (drawable.getIntrinsicWidth() > 0) {
            i2 = drawable.getIntrinsicWidth();
        }
        if (drawable.getIntrinsicHeight() > 0) {
            i3 = drawable.getIntrinsicHeight();
        }
        Lock lockA = g0.a();
        lockA.lock();
        Bitmap bitmapA = eVar.a(i2, i3, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(bitmapA);
            drawable.setBounds(0, 0, i2, i3);
            drawable.draw(canvas);
            canvas.setBitmap(null);
            return bitmapA;
        } finally {
            lockA.unlock();
        }
    }
}
