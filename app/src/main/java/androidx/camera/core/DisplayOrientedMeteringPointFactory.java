package androidx.camera.core;

import android.graphics.PointF;
import android.view.Display;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.CameraInfoInternal;

/* loaded from: classes.dex */
public final class DisplayOrientedMeteringPointFactory extends MeteringPointFactory {

    @NonNull
    private final CameraInfoInternal mCameraInfo;
    private final CameraSelector mCameraSelector;

    @NonNull
    private final Display mDisplay;
    private final float mHeight;
    private final float mWidth;

    public DisplayOrientedMeteringPointFactory(@NonNull Display display, @NonNull CameraSelector cameraSelector, float f2, float f3) {
        this.mWidth = f2;
        this.mHeight = f3;
        this.mCameraSelector = cameraSelector;
        this.mDisplay = display;
        try {
            this.mCameraInfo = CameraX.getCameraInfo(CameraX.getCameraWithCameraSelector(this.mCameraSelector));
        } catch (Exception e2) {
            throw new IllegalArgumentException("Unable to get camera id for the CameraSelector.", e2);
        }
    }

    @Nullable
    private Integer getLensFacing() {
        return this.mCameraInfo.getLensFacing();
    }

    private int getRelativeCameraOrientation(boolean z) {
        try {
            int sensorRotationDegrees = this.mCameraInfo.getSensorRotationDegrees(this.mDisplay.getRotation());
            return z ? (360 - sensorRotationDegrees) % 360 : sensorRotationDegrees;
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // androidx.camera.core.MeteringPointFactory
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected PointF convertPoint(float f2, float f3) {
        float f4 = this.mWidth;
        float f5 = this.mHeight;
        Integer lensFacing = getLensFacing();
        boolean z = lensFacing != null && lensFacing.intValue() == 0;
        int relativeCameraOrientation = getRelativeCameraOrientation(z);
        if (relativeCameraOrientation != 90 && relativeCameraOrientation != 270) {
            f3 = f2;
            f2 = f3;
            f5 = f4;
            f4 = f5;
        }
        if (relativeCameraOrientation == 90) {
            f2 = f4 - f2;
        } else if (relativeCameraOrientation == 180) {
            f3 = f5 - f3;
            f2 = f4 - f2;
        } else if (relativeCameraOrientation == 270) {
            f3 = f5 - f3;
        }
        if (z) {
            f3 = f5 - f3;
        }
        return new PointF(f3 / f5, f2 / f4);
    }
}
