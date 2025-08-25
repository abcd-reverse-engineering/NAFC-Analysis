package androidx.camera.lifecycle;

import androidx.annotation.NonNull;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.UseCase;

/* loaded from: classes.dex */
interface LifecycleCameraProvider {
    boolean hasCamera(@NonNull CameraSelector cameraSelector) throws CameraInfoUnavailableException;

    boolean isBound(@NonNull UseCase useCase);

    void unbind(@NonNull UseCase... useCaseArr);

    void unbindAll();
}
