package androidx.camera.camera2.internal.compat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import java.util.concurrent.Executor;
import util.permissionutil.a;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class CameraManagerCompat {
    private final CameraManagerCompatImpl mImpl;

    static final class AvailabilityCallbackExecutorWrapper extends CameraManager.AvailabilityCallback {
        private final Executor mExecutor;
        final CameraManager.AvailabilityCallback mWrappedCallback;

        AvailabilityCallbackExecutorWrapper(@NonNull Executor executor, @NonNull CameraManager.AvailabilityCallback availabilityCallback) {
            this.mExecutor = executor;
            this.mWrappedCallback = availabilityCallback;
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        @RequiresApi(29)
        public void onCameraAccessPrioritiesChanged() {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraManagerCompat.AvailabilityCallbackExecutorWrapper.1
                @Override // java.lang.Runnable
                public void run() {
                    AvailabilityCallbackExecutorWrapper.this.mWrappedCallback.onCameraAccessPrioritiesChanged();
                }
            });
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraAvailable(@NonNull final String str) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraManagerCompat.AvailabilityCallbackExecutorWrapper.2
                @Override // java.lang.Runnable
                public void run() {
                    AvailabilityCallbackExecutorWrapper.this.mWrappedCallback.onCameraAvailable(str);
                }
            });
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraUnavailable(@NonNull final String str) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraManagerCompat.AvailabilityCallbackExecutorWrapper.3
                @Override // java.lang.Runnable
                public void run() {
                    AvailabilityCallbackExecutorWrapper.this.mWrappedCallback.onCameraUnavailable(str);
                }
            });
        }
    }

    interface CameraManagerCompatImpl {
        @NonNull
        CameraManager getCameraManager();

        @RequiresPermission(a.f20909c)
        void openCamera(@NonNull String str, @NonNull Executor executor, @NonNull CameraDevice.StateCallback stateCallback) throws CameraAccessException;

        void registerAvailabilityCallback(@NonNull Executor executor, @NonNull CameraManager.AvailabilityCallback availabilityCallback);

        void unregisterAvailabilityCallback(@NonNull CameraManager.AvailabilityCallback availabilityCallback);
    }

    private CameraManagerCompat(CameraManagerCompatImpl cameraManagerCompatImpl) {
        this.mImpl = cameraManagerCompatImpl;
    }

    @NonNull
    public static CameraManagerCompat from(@NonNull Context context) {
        return Build.VERSION.SDK_INT >= 28 ? new CameraManagerCompat(new CameraManagerCompatApi28Impl(context)) : new CameraManagerCompat(new CameraManagerCompatBaseImpl(context));
    }

    @RequiresPermission(a.f20909c)
    public void openCamera(@NonNull String str, @NonNull Executor executor, @NonNull CameraDevice.StateCallback stateCallback) throws CameraAccessException {
        this.mImpl.openCamera(str, executor, stateCallback);
    }

    @SuppressLint({"LambdaLast"})
    public void registerAvailabilityCallback(@NonNull Executor executor, @NonNull CameraManager.AvailabilityCallback availabilityCallback) {
        this.mImpl.registerAvailabilityCallback(executor, availabilityCallback);
    }

    public void unregisterAvailabilityCallback(@NonNull CameraManager.AvailabilityCallback availabilityCallback) {
        this.mImpl.unregisterAvailabilityCallback(availabilityCallback);
    }

    @NonNull
    public CameraManager unwrap() {
        return this.mImpl.getCameraManager();
    }
}
