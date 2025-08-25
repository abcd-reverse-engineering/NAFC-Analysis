package com.lxj.xpopup.photoview;

import android.widget.ImageView;
import androidx.core.view.MotionEventCompat;

/* compiled from: Util.java */
/* loaded from: classes.dex */
class l {

    /* compiled from: Util.java */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8133a = new int[ImageView.ScaleType.values().length];

        static {
            try {
                f8133a[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    l() {
    }

    static int a(int i2) {
        return (i2 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    static void a(float f2, float f3, float f4) {
        if (f2 >= f3) {
            throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        }
        if (f3 >= f4) {
            throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
    }

    static boolean a(ImageView imageView) {
        return imageView.getDrawable() != null;
    }

    static boolean a(ImageView.ScaleType scaleType) {
        return (scaleType == null || a.f8133a[scaleType.ordinal()] == 1) ? false : true;
    }
}
