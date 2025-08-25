package androidx.camera.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.SurfaceView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
final class TransformableSurfaceView extends SurfaceView {
    private RectF mOverriddenLayoutRect;

    TransformableSurfaceView(@NonNull Context context) {
        super(context);
    }

    private boolean hasRotation(Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return Math.round((-Math.atan2((double) fArr[1], (double) fArr[0])) * 57.29577951308232d) != 0;
    }

    private void overrideLayout(RectF rectF) {
        this.mOverriddenLayoutRect = rectF;
        setX(rectF.left);
        setY(rectF.top);
        requestLayout();
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i2, int i3) {
        RectF rectF = this.mOverriddenLayoutRect;
        if (rectF == null) {
            super.onMeasure(i2, i3);
        } else {
            setMeasuredDimension((int) rectF.width(), (int) this.mOverriddenLayoutRect.height());
        }
    }

    void setTransform(Matrix matrix) {
        if (hasRotation(matrix)) {
            throw new IllegalArgumentException("TransformableSurfaceView does not support rotation transformations.");
        }
        RectF rectF = new RectF(getLeft(), getTop(), getRight(), getBottom());
        matrix.mapRect(rectF);
        overrideLayout(rectF);
    }

    TransformableSurfaceView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    TransformableSurfaceView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    TransformableSurfaceView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }
}
