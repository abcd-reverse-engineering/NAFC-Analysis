package com.youth.banner.transformer;

import android.view.View;

/* loaded from: classes2.dex */
public class CubeInTransformer extends ABaseTransformer {
    @Override // com.youth.banner.transformer.ABaseTransformer
    public boolean isPagingEnabled() {
        return true;
    }

    @Override // com.youth.banner.transformer.ABaseTransformer
    protected void onTransform(View view, float f2) {
        view.setPivotX(f2 > 0.0f ? 0.0f : view.getWidth());
        view.setPivotY(0.0f);
        view.setRotationY(f2 * (-90.0f));
    }
}
