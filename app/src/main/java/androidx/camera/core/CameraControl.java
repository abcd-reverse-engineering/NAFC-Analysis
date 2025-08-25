package androidx.camera.core;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* loaded from: classes.dex */
public interface CameraControl {

    public static final class OperationCanceledException extends Exception {
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public OperationCanceledException(@NonNull String str) {
            super(str);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public OperationCanceledException(@NonNull String str, @NonNull Throwable th) {
            super(str, th);
        }
    }

    @NonNull
    c.b.b.a.a.a<Void> cancelFocusAndMetering();

    @NonNull
    c.b.b.a.a.a<Void> enableTorch(boolean z);

    @NonNull
    c.b.b.a.a.a<Void> setLinearZoom(@FloatRange(from = 0.0d, to = 1.0d) float f2);

    @NonNull
    c.b.b.a.a.a<Void> setZoomRatio(float f2);

    @NonNull
    c.b.b.a.a.a<FocusMeteringResult> startFocusAndMetering(@NonNull FocusMeteringAction focusMeteringAction);
}
