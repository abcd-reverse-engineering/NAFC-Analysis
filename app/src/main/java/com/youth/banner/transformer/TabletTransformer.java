package com.youth.banner.transformer;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes2.dex */
public class TabletTransformer extends ABaseTransformer {
    private static final Matrix OFFSET_MATRIX = new Matrix();
    private static final Camera OFFSET_CAMERA = new Camera();
    private static final float[] OFFSET_TEMP_FLOAT = new float[2];

    protected static final float getOffsetXForRotation(float f2, int i2, int i3) {
        OFFSET_MATRIX.reset();
        OFFSET_CAMERA.save();
        OFFSET_CAMERA.rotateY(Math.abs(f2));
        OFFSET_CAMERA.getMatrix(OFFSET_MATRIX);
        OFFSET_CAMERA.restore();
        OFFSET_MATRIX.preTranslate((-i2) * 0.5f, (-i3) * 0.5f);
        float f3 = i2;
        float f4 = i3;
        OFFSET_MATRIX.postTranslate(f3 * 0.5f, 0.5f * f4);
        float[] fArr = OFFSET_TEMP_FLOAT;
        fArr[0] = f3;
        fArr[1] = f4;
        OFFSET_MATRIX.mapPoints(fArr);
        return (f3 - OFFSET_TEMP_FLOAT[0]) * (f2 > 0.0f ? 1.0f : -1.0f);
    }

    @Override // com.youth.banner.transformer.ABaseTransformer
    protected void onTransform(View view, float f2) {
        float fAbs = (f2 < 0.0f ? 30.0f : -30.0f) * Math.abs(f2);
        view.setTranslationX(getOffsetXForRotation(fAbs, view.getWidth(), view.getHeight()));
        view.setPivotX(view.getWidth() * 0.5f);
        view.setPivotY(0.0f);
        view.setRotationY(fAbs);
    }
}
