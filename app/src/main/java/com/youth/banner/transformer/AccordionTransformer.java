package com.youth.banner.transformer;

import android.view.View;

/* loaded from: classes2.dex */
public class AccordionTransformer extends ABaseTransformer {
    @Override // com.youth.banner.transformer.ABaseTransformer
    protected void onTransform(View view, float f2) {
        view.setPivotX(f2 >= 0.0f ? view.getWidth() : 0.0f);
        view.setScaleX(f2 < 0.0f ? f2 + 1.0f : 1.0f - f2);
    }
}
