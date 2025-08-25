package com.youth.banner.transformer;

import android.view.View;

/* loaded from: classes2.dex */
public class RotateUpTransformer extends ABaseTransformer {
    private static final float ROT_MOD = -15.0f;

    @Override // com.youth.banner.transformer.ABaseTransformer
    protected boolean isPagingEnabled() {
        return true;
    }

    @Override // com.youth.banner.transformer.ABaseTransformer
    protected void onTransform(View view, float f2) {
        float width = view.getWidth();
        float f3 = f2 * ROT_MOD;
        view.setPivotX(width * 0.5f);
        view.setPivotY(0.0f);
        view.setTranslationX(0.0f);
        view.setRotation(f3);
    }
}
