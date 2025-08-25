package com.youth.banner.transformer;

import android.view.View;

/* loaded from: classes2.dex */
public class DepthPageTransformer extends ABaseTransformer {
    private static final float MIN_SCALE = 0.75f;

    @Override // com.youth.banner.transformer.ABaseTransformer
    protected boolean isPagingEnabled() {
        return true;
    }

    @Override // com.youth.banner.transformer.ABaseTransformer
    protected void onTransform(View view, float f2) {
        if (f2 <= 0.0f) {
            view.setTranslationX(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
        } else if (f2 <= 1.0f) {
            float fAbs = ((1.0f - Math.abs(f2)) * 0.25f) + MIN_SCALE;
            view.setAlpha(1.0f - f2);
            view.setPivotY(view.getHeight() * 0.5f);
            view.setTranslationX(view.getWidth() * (-f2));
            view.setScaleX(fAbs);
            view.setScaleY(fAbs);
        }
    }
}
