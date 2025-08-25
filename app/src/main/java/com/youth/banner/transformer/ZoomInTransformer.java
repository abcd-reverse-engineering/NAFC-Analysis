package com.youth.banner.transformer;

import android.view.View;

/* loaded from: classes2.dex */
public class ZoomInTransformer extends ABaseTransformer {
    @Override // com.youth.banner.transformer.ABaseTransformer
    protected void onTransform(View view, float f2) {
        float f3 = 0.0f;
        float fAbs = f2 < 0.0f ? f2 + 1.0f : Math.abs(1.0f - f2);
        view.setScaleX(fAbs);
        view.setScaleY(fAbs);
        view.setPivotX(view.getWidth() * 0.5f);
        view.setPivotY(view.getHeight() * 0.5f);
        if (f2 >= -1.0f && f2 <= 1.0f) {
            f3 = 1.0f - (fAbs - 1.0f);
        }
        view.setAlpha(f3);
    }
}
