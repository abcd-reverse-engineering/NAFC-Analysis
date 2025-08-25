package androidx.camera.core.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraInfoUnavailableException;
import java.util.Set;

/* loaded from: classes.dex */
public interface CameraFactory {

    public interface Provider {
        @NonNull
        CameraFactory newInstance(@NonNull Context context);
    }

    @Nullable
    String cameraIdForLensFacing(int i2) throws CameraInfoUnavailableException;

    @NonNull
    Set<String> getAvailableCameraIds() throws CameraInfoUnavailableException;

    @NonNull
    CameraInternal getCamera(@NonNull String str) throws CameraInfoUnavailableException;

    @NonNull
    LensFacingCameraIdFilter getLensFacingCameraIdFilter(int i2);
}
