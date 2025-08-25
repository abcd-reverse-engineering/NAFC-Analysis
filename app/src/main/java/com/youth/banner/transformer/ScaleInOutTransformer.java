package com.youth.banner.transformer;

import android.view.View;

/* loaded from: classes2.dex */
public class ScaleInOutTransformer extends ABaseTransformer {
    @Override // com.youth.banner.transformer.ABaseTransformer
    protected void onTransform(View view, float f2) {
        view.setPivotX(f2 >= 0.0f ? view.getWidth() : 0.0f);
        view.setPivotY(view.getHeight() / 2.0f);
        float f3 = f2 < 0.0f ? f2 + 1.0f : 1.0f - f2;
        view.setScaleX(f3);
        view.setScaleY(f3);
    }
}
