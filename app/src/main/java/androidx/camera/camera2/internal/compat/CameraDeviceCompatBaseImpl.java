package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;
import androidx.camera.camera2.internal.compat.CameraDeviceCompat;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RequiresApi(21)
/* loaded from: classes.dex */
class CameraDeviceCompatBaseImpl implements CameraDeviceCompat.CameraDeviceCompatImpl {
    CameraDeviceCompatBaseImpl() {
    }

    private static void checkPhysicalCameraIdValid(CameraDevice cameraDevice, @NonNull List<OutputConfigurationCompat> list) {
        String id = cameraDevice.getId();
        Iterator<OutputConfigurationCompat> it = list.iterator();
        while (it.hasNext()) {
            String physicalCameraId = it.next().getPhysicalCameraId();
            if (physicalCameraId != null && !physicalCameraId.isEmpty()) {
                String str = "Camera " + id + ": Camera doesn't support physicalCameraId " + physicalCameraId + ". Ignoring.";
            }
        }
    }

    static void checkPreconditions(CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat) {
        Preconditions.checkNotNull(cameraDevice);
        Preconditions.checkNotNull(sessionConfigurationCompat);
        Preconditions.checkNotNull(sessionConfigurationCompat.getStateCallback());
        List<OutputConfigurationCompat> outputConfigurations = sessionConfigurationCompat.getOutputConfigurations();
        if (outputConfigurations == null) {
            throw new IllegalArgumentException("Invalid output configurations");
        }
        if (sessionConfigurationCompat.getExecutor() == null) {
            throw new IllegalArgumentException("Invalid executor");
        }
        checkPhysicalCameraIdValid(cameraDevice, outputConfigurations);
    }

    static List<Surface> unpackSurfaces(@NonNull List<OutputConfigurationCompat> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<OutputConfigurationCompat> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getSurface());
        }
        return arrayList;
    }

    void createBaseCaptureSession(@NonNull CameraDevice cameraDevice, @NonNull List<Surface> list, @NonNull CameraCaptureSession.StateCallback stateCallback, @NonNull Handler handler) throws CameraAccessException {
        cameraDevice.createCaptureSession(list, stateCallback, handler);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraDeviceCompat.CameraDeviceCompatImpl
    public void createCaptureSession(@NonNull CameraDevice cameraDevice, @NonNull SessionConfigurationCompat sessionConfigurationCompat) throws CameraAccessException {
        checkPreconditions(cameraDevice, sessionConfigurationCompat);
        if (sessionConfigurationCompat.getInputConfiguration() != null) {
            throw new IllegalArgumentException("Reprocessing sessions not supported until API 23");
        }
        if (sessionConfigurationCompat.getSessionType() == 1) {
            throw new IllegalArgumentException("High speed capture sessions not supported until API 23");
        }
        createBaseCaptureSession(cameraDevice, unpackSurfaces(sessionConfigurationCompat.getOutputConfigurations()), new CameraCaptureSessionCompat.StateCallbackExecutorWrapper(sessionConfigurationCompat.getExecutor(), sessionConfigurationCompat.getStateCallback()), MainThreadAsyncHandler.getInstance());
    }
}
