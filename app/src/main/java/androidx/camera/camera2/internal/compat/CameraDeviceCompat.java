package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import java.util.concurrent.Executor;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class CameraDeviceCompat {
    private static final CameraDeviceCompatImpl IMPL = chooseImplementation();

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int SESSION_OPERATION_MODE_CONSTRAINED_HIGH_SPEED = 1;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int SESSION_OPERATION_MODE_NORMAL = 0;

    interface CameraDeviceCompatImpl {
        void createCaptureSession(@NonNull CameraDevice cameraDevice, @NonNull SessionConfigurationCompat sessionConfigurationCompat) throws CameraAccessException;
    }

    static final class StateCallbackExecutorWrapper extends CameraDevice.StateCallback {
        private final Executor mExecutor;
        final CameraDevice.StateCallback mWrappedCallback;

        StateCallbackExecutorWrapper(@NonNull Executor executor, @NonNull CameraDevice.StateCallback stateCallback) {
            this.mExecutor = executor;
            this.mWrappedCallback = stateCallback;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(@NonNull final CameraDevice cameraDevice) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraDeviceCompat.StateCallbackExecutorWrapper.4
                @Override // java.lang.Runnable
                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onClosed(cameraDevice);
                }
            });
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(@NonNull final CameraDevice cameraDevice) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraDeviceCompat.StateCallbackExecutorWrapper.2
                @Override // java.lang.Runnable
                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onDisconnected(cameraDevice);
                }
            });
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(@NonNull final CameraDevice cameraDevice, final int i2) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraDeviceCompat.StateCallbackExecutorWrapper.3
                @Override // java.lang.Runnable
                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onError(cameraDevice, i2);
                }
            });
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(@NonNull final CameraDevice cameraDevice) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraDeviceCompat.StateCallbackExecutorWrapper.1
                @Override // java.lang.Runnable
                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onOpened(cameraDevice);
                }
            });
        }
    }

    private CameraDeviceCompat() {
    }

    private static CameraDeviceCompatImpl chooseImplementation() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 >= 28 ? new CameraDeviceCompatApi28Impl() : i2 >= 24 ? new CameraDeviceCompatApi24Impl() : i2 >= 23 ? new CameraDeviceCompatApi23Impl() : new CameraDeviceCompatBaseImpl();
    }

    public static void createCaptureSession(@NonNull CameraDevice cameraDevice, @NonNull SessionConfigurationCompat sessionConfigurationCompat) throws CameraAccessException {
        IMPL.createCaptureSession(cameraDevice, sessionConfigurationCompat);
    }
}
