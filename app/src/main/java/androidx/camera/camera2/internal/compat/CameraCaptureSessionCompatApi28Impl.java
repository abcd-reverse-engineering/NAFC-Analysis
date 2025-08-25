package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.util.List;
import java.util.concurrent.Executor;

@RequiresApi(28)
/* loaded from: classes.dex */
class CameraCaptureSessionCompatApi28Impl extends CameraCaptureSessionCompatBaseImpl {
    CameraCaptureSessionCompatApi28Impl() {
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCaptureSessionCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl
    public int captureBurstRequests(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull List<CaptureRequest> list, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        Preconditions.checkNotNull(cameraCaptureSession);
        return cameraCaptureSession.captureBurstRequests(list, executor, captureCallback);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCaptureSessionCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl
    public int captureSingleRequest(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        Preconditions.checkNotNull(cameraCaptureSession);
        return cameraCaptureSession.captureSingleRequest(captureRequest, executor, captureCallback);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCaptureSessionCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl
    public int setRepeatingBurstRequests(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull List<CaptureRequest> list, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        Preconditions.checkNotNull(cameraCaptureSession);
        return cameraCaptureSession.setRepeatingBurstRequests(list, executor, captureCallback);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCaptureSessionCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl
    public int setSingleRepeatingRequest(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        Preconditions.checkNotNull(cameraCaptureSession);
        return cameraCaptureSession.setSingleRepeatingRequest(captureRequest, executor, captureCallback);
    }
}
