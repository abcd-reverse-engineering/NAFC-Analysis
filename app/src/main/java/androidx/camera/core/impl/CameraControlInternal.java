package androidx.camera.core.impl;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraControl;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.impl.utils.futures.Futures;
import java.util.List;

/* loaded from: classes.dex */
public interface CameraControlInternal extends CameraControl {
    public static final CameraControlInternal DEFAULT_EMPTY_INSTANCE = new CameraControlInternal() { // from class: androidx.camera.core.impl.CameraControlInternal.1
        @Override // androidx.camera.core.impl.CameraControlInternal
        public void cancelAfAeTrigger(boolean z, boolean z2) {
        }

        @Override // androidx.camera.core.CameraControl
        @NonNull
        public c.b.b.a.a.a<Void> cancelFocusAndMetering() {
            return Futures.immediateFuture(null);
        }

        @Override // androidx.camera.core.CameraControl
        @NonNull
        public c.b.b.a.a.a<Void> enableTorch(boolean z) {
            return Futures.immediateFuture(null);
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public int getFlashMode() {
            return 2;
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void setCropRegion(@Nullable Rect rect) {
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void setFlashMode(int i2) {
        }

        @Override // androidx.camera.core.CameraControl
        @NonNull
        public c.b.b.a.a.a<Void> setLinearZoom(float f2) {
            return Futures.immediateFuture(null);
        }

        @Override // androidx.camera.core.CameraControl
        @NonNull
        public c.b.b.a.a.a<Void> setZoomRatio(float f2) {
            return Futures.immediateFuture(null);
        }

        @Override // androidx.camera.core.CameraControl
        @NonNull
        public c.b.b.a.a.a<FocusMeteringResult> startFocusAndMetering(@NonNull FocusMeteringAction focusMeteringAction) {
            return Futures.immediateFuture(FocusMeteringResult.emptyInstance());
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void submitCaptureRequests(@NonNull List<CaptureConfig> list) {
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void triggerAePrecapture() {
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void triggerAf() {
        }
    };

    public interface ControlUpdateCallback {
        void onCameraControlCaptureRequests(@NonNull List<CaptureConfig> list);

        void onCameraControlUpdateSessionConfig(@NonNull SessionConfig sessionConfig);
    }

    void cancelAfAeTrigger(boolean z, boolean z2);

    int getFlashMode();

    void setCropRegion(@Nullable Rect rect);

    void setFlashMode(int i2);

    void submitCaptureRequests(@NonNull List<CaptureConfig> list);

    void triggerAePrecapture();

    void triggerAf();
}
