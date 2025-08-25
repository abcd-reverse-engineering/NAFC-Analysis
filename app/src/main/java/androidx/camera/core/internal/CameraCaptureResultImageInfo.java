package androidx.camera.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.impl.CameraCaptureResult;

/* loaded from: classes.dex */
public final class CameraCaptureResultImageInfo implements ImageInfo {
    private final CameraCaptureResult mCameraCaptureResult;

    public CameraCaptureResultImageInfo(@NonNull CameraCaptureResult cameraCaptureResult) {
        this.mCameraCaptureResult = cameraCaptureResult;
    }

    @NonNull
    public CameraCaptureResult getCameraCaptureResult() {
        return this.mCameraCaptureResult;
    }

    @Override // androidx.camera.core.ImageInfo
    public int getRotationDegrees() {
        return 0;
    }

    @Override // androidx.camera.core.ImageInfo
    @Nullable
    public Object getTag() {
        return this.mCameraCaptureResult.getTag();
    }

    @Override // androidx.camera.core.ImageInfo
    public long getTimestamp() {
        return this.mCameraCaptureResult.getTimestamp();
    }
}
