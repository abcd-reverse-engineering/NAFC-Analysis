package ui.view;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes2.dex */
public class ZoomOutPageTransformer implements ViewPager.PageTransformer {

    /* renamed from: a, reason: collision with root package name */
    private static float f20477a = 0.85f;

    /* renamed from: b, reason: collision with root package name */
    private static float f20478b = 0.5f;

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f2) {
        view.getWidth();
        view.getHeight();
        if (f2 < -1.0f) {
            view.setAlpha(0.0f);
            view.setTranslationX(0.0f);
        } else if (f2 > 1.0f) {
            view.setAlpha(0.0f);
            view.setTranslationX(0.0f);
        } else {
            float fMax = Math.max(f20477a, 1.0f - Math.abs(f2));
            float f3 = f20478b;
            float f4 = f20477a;
            view.setAlpha(f3 + (((fMax - f4) / (1.0f - f4)) * (1.0f - f3)));
        }
    }
}
