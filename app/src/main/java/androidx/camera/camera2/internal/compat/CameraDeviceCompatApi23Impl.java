package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;
import androidx.camera.camera2.internal.compat.params.InputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import androidx.core.util.Preconditions;
import java.util.List;

@RequiresApi(23)
/* loaded from: classes.dex */
class CameraDeviceCompatApi23Impl extends CameraDeviceCompatBaseImpl {
    CameraDeviceCompatApi23Impl() {
    }

    @Override // androidx.camera.camera2.internal.compat.CameraDeviceCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraDeviceCompat.CameraDeviceCompatImpl
    public void createCaptureSession(@NonNull CameraDevice cameraDevice, @NonNull SessionConfigurationCompat sessionConfigurationCompat) throws CameraAccessException {
        CameraDeviceCompatBaseImpl.checkPreconditions(cameraDevice, sessionConfigurationCompat);
        CameraCaptureSessionCompat.StateCallbackExecutorWrapper stateCallbackExecutorWrapper = new CameraCaptureSessionCompat.StateCallbackExecutorWrapper(sessionConfigurationCompat.getExecutor(), sessionConfigurationCompat.getStateCallback());
        List<Surface> listUnpackSurfaces = CameraDeviceCompatBaseImpl.unpackSurfaces(sessionConfigurationCompat.getOutputConfigurations());
        Handler mainThreadAsyncHandler = MainThreadAsyncHandler.getInstance();
        InputConfigurationCompat inputConfiguration = sessionConfigurationCompat.getInputConfiguration();
        if (inputConfiguration != null) {
            InputConfiguration inputConfiguration2 = (InputConfiguration) inputConfiguration.unwrap();
            Preconditions.checkNotNull(inputConfiguration2);
            cameraDevice.createReprocessableCaptureSession(inputConfiguration2, listUnpackSurfaces, stateCallbackExecutorWrapper, mainThreadAsyncHandler);
        } else if (sessionConfigurationCompat.getSessionType() == 1) {
            cameraDevice.createConstrainedHighSpeedCaptureSession(listUnpackSurfaces, stateCallbackExecutorWrapper, mainThreadAsyncHandler);
        } else {
            createBaseCaptureSession(cameraDevice, listUnpackSurfaces, stateCallbackExecutorWrapper, mainThreadAsyncHandler);
        }
    }
}
