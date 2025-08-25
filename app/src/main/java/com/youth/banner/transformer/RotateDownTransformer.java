package com.youth.banner.transformer;

import android.view.View;

/* loaded from: classes2.dex */
public class RotateDownTransformer extends ABaseTransformer {
    private static final float ROT_MOD = -15.0f;

    @Override // com.youth.banner.transformer.ABaseTransformer
    protected boolean isPagingEnabled() {
        return true;
    }

    @Override // com.youth.banner.transformer.ABaseTransformer
    protected void onTransform(View view, float f2) {
        float width = view.getWidth();
        float height = view.getHeight();
        float f3 = f2 * ROT_MOD * (-1.25f);
        view.setPivotX(width * 0.5f);
        view.setPivotY(height);
        view.setRotation(f3);
    }
}
