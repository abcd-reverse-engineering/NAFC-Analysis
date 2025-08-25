package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.camera.camera2.internal.compat.CameraDeviceCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import util.permissionutil.a;

@RequiresApi(21)
/* loaded from: classes.dex */
class CameraManagerCompatBaseImpl implements CameraManagerCompat.CameraManagerCompatImpl {
    final CameraManager mCameraManager;
    final Object mObject;

    static final class CameraManagerCompatParamsApi21 {

        @GuardedBy("mWrapperMap")
        final Map<CameraManager.AvailabilityCallback, CameraManagerCompat.AvailabilityCallbackExecutorWrapper> mWrapperMap = new HashMap();

        CameraManagerCompatParamsApi21() {
        }
    }

    CameraManagerCompatBaseImpl(@NonNull Context context, @Nullable Object obj) {
        this.mCameraManager = (CameraManager) context.getSystemService("camera");
        this.mObject = obj;
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    @NonNull
    public CameraManager getCameraManager() {
        return this.mCameraManager;
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    @RequiresPermission(a.f20909c)
    public void openCamera(@NonNull String str, @NonNull Executor executor, @NonNull CameraDevice.StateCallback stateCallback) throws CameraAccessException {
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(stateCallback);
        this.mCameraManager.openCamera(str, new CameraDeviceCompat.StateCallbackExecutorWrapper(executor, stateCallback), MainThreadAsyncHandler.getInstance());
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public void registerAvailabilityCallback(@NonNull Executor executor, @NonNull CameraManager.AvailabilityCallback availabilityCallback) {
        if (executor == null) {
            throw new IllegalArgumentException("executor was null");
        }
        CameraManagerCompat.AvailabilityCallbackExecutorWrapper availabilityCallbackExecutorWrapper = null;
        if (availabilityCallback != null) {
            CameraManagerCompatParamsApi21 cameraManagerCompatParamsApi21 = (CameraManagerCompatParamsApi21) this.mObject;
            synchronized (cameraManagerCompatParamsApi21.mWrapperMap) {
                CameraManagerCompat.AvailabilityCallbackExecutorWrapper availabilityCallbackExecutorWrapper2 = cameraManagerCompatParamsApi21.mWrapperMap.get(availabilityCallback);
                if (availabilityCallbackExecutorWrapper2 == null) {
                    availabilityCallbackExecutorWrapper2 = new CameraManagerCompat.AvailabilityCallbackExecutorWrapper(executor, availabilityCallback);
                    cameraManagerCompatParamsApi21.mWrapperMap.put(availabilityCallback, availabilityCallbackExecutorWrapper2);
                }
                availabilityCallbackExecutorWrapper = availabilityCallbackExecutorWrapper2;
            }
        }
        this.mCameraManager.registerAvailabilityCallback(availabilityCallbackExecutorWrapper, MainThreadAsyncHandler.getInstance());
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public void unregisterAvailabilityCallback(@NonNull CameraManager.AvailabilityCallback availabilityCallback) {
        CameraManagerCompat.AvailabilityCallbackExecutorWrapper availabilityCallbackExecutorWrapperRemove;
        if (availabilityCallback != null) {
            CameraManagerCompatParamsApi21 cameraManagerCompatParamsApi21 = (CameraManagerCompatParamsApi21) this.mObject;
            synchronized (cameraManagerCompatParamsApi21.mWrapperMap) {
                availabilityCallbackExecutorWrapperRemove = cameraManagerCompatParamsApi21.mWrapperMap.remove(availabilityCallback);
            }
        } else {
            availabilityCallbackExecutorWrapperRemove = null;
        }
        this.mCameraManager.unregisterAvailabilityCallback(availabilityCallbackExecutorWrapperRemove);
    }

    CameraManagerCompatBaseImpl(@NonNull Context context) {
        this.mCameraManager = (CameraManager) context.getSystemService("camera");
        this.mObject = new CameraManagerCompatParamsApi21();
    }
}
