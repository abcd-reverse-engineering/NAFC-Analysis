package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import androidx.core.util.Preconditions;
import java.util.List;
import java.util.concurrent.Executor;

@RequiresApi(21)
/* loaded from: classes.dex */
class CameraCaptureSessionCompatBaseImpl implements CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl {
    CameraCaptureSessionCompatBaseImpl() {
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl
    public int captureBurstRequests(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull List<CaptureRequest> list, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        Preconditions.checkNotNull(cameraCaptureSession);
        return cameraCaptureSession.captureBurst(list, new CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper(executor, captureCallback), MainThreadAsyncHandler.getInstance());
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl
    public int captureSingleRequest(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        Preconditions.checkNotNull(cameraCaptureSession);
        return cameraCaptureSession.capture(captureRequest, new CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper(executor, captureCallback), MainThreadAsyncHandler.getInstance());
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl
    public int setRepeatingBurstRequests(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull List<CaptureRequest> list, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        Preconditions.checkNotNull(cameraCaptureSession);
        return cameraCaptureSession.setRepeatingBurst(list, new CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper(executor, captureCallback), MainThreadAsyncHandler.getInstance());
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl
    public int setSingleRepeatingRequest(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        Preconditions.checkNotNull(cameraCaptureSession);
        return cameraCaptureSession.setRepeatingRequest(captureRequest, new CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper(executor, captureCallback), MainThreadAsyncHandler.getInstance());
    }
}
