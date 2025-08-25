package com.youth.banner.transformer;

import android.view.View;

/* loaded from: classes2.dex */
public class ForegroundToBackgroundTransformer extends ABaseTransformer {
    @Override // com.youth.banner.transformer.ABaseTransformer
    protected void onTransform(View view, float f2) {
        float height = view.getHeight();
        float width = view.getWidth();
        float fMin = ABaseTransformer.min(f2 <= 0.0f ? Math.abs(1.0f + f2) : 1.0f, 0.5f);
        view.setScaleX(fMin);
        view.setScaleY(fMin);
        view.setPivotX(width * 0.5f);
        view.setPivotY(height * 0.5f);
        view.setTranslationX(f2 > 0.0f ? width * f2 : (-width) * f2 * 0.25f);
    }
}
