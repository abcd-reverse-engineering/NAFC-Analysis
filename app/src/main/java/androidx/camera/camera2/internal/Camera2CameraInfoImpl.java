package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LiveData;

/* loaded from: classes.dex */
public final class Camera2CameraInfoImpl implements CameraInfoInternal {
    private static final String TAG = "Camera2CameraInfo";
    private final CameraCharacteristics mCameraCharacteristics;
    private final String mCameraId;
    private final TorchControl mTorchControl;
    private final ZoomControl mZoomControl;

    Camera2CameraInfoImpl(@NonNull String str, @NonNull CameraCharacteristics cameraCharacteristics, @NonNull ZoomControl zoomControl, @NonNull TorchControl torchControl) {
        Preconditions.checkNotNull(cameraCharacteristics, "Camera characteristics map is missing");
        this.mCameraId = (String) Preconditions.checkNotNull(str);
        this.mCameraCharacteristics = cameraCharacteristics;
        this.mZoomControl = zoomControl;
        this.mTorchControl = torchControl;
        logDeviceInfo();
    }

    private void logDeviceInfo() {
        logDeviceLevel();
    }

    private void logDeviceLevel() {
        String str;
        int supportedHardwareLevel = getSupportedHardwareLevel();
        if (supportedHardwareLevel == 0) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED";
        } else if (supportedHardwareLevel == 1) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_FULL";
        } else if (supportedHardwareLevel == 2) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY";
        } else if (supportedHardwareLevel == 3) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_3";
        } else if (supportedHardwareLevel != 4) {
            str = "Unknown value: " + supportedHardwareLevel;
        } else {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_EXTERNAL";
        }
        String str2 = "Device Level: " + str;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    @NonNull
    public String getCameraId() {
        return this.mCameraId;
    }

    @Override // androidx.camera.core.CameraInfo
    @NonNull
    public String getImplementationType() {
        return getSupportedHardwareLevel() == 2 ? CameraInfo.IMPLEMENTATION_TYPE_CAMERA2_LEGACY : CameraInfo.IMPLEMENTATION_TYPE_CAMERA2;
    }

    @Override // androidx.camera.core.impl.CameraInfoInternal
    @Nullable
    public Integer getLensFacing() {
        Integer num = (Integer) this.mCameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
        Preconditions.checkNotNull(num);
        int iIntValue = num.intValue();
        if (iIntValue != 0) {
            return iIntValue != 1 ? null : 1;
        }
        return 0;
    }

    int getSensorOrientation() {
        Integer num = (Integer) this.mCameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
        Preconditions.checkNotNull(num);
        return num.intValue();
    }

    @Override // androidx.camera.core.CameraInfo
    public int getSensorRotationDegrees(int i2) {
        Integer numValueOf = Integer.valueOf(getSensorOrientation());
        int iSurfaceRotationToDegrees = CameraOrientationUtil.surfaceRotationToDegrees(i2);
        Integer lensFacing = getLensFacing();
        return CameraOrientationUtil.getRelativeImageRotation(iSurfaceRotationToDegrees, numValueOf.intValue(), lensFacing != null && 1 == lensFacing.intValue());
    }

    int getSupportedHardwareLevel() {
        Integer num = (Integer) this.mCameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        Preconditions.checkNotNull(num);
        return num.intValue();
    }

    @Override // androidx.camera.core.CameraInfo
    @NonNull
    public LiveData<Integer> getTorchState() {
        return this.mTorchControl.getTorchState();
    }

    @Override // androidx.camera.core.CameraInfo
    @NonNull
    public LiveData<ZoomState> getZoomState() {
        return this.mZoomControl.getZoomState();
    }

    @Override // androidx.camera.core.CameraInfo
    public boolean hasFlashUnit() {
        Boolean bool = (Boolean) this.mCameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        Preconditions.checkNotNull(bool);
        return bool.booleanValue();
    }

    @Override // androidx.camera.core.CameraInfo
    public int getSensorRotationDegrees() {
        return getSensorRotationDegrees(0);
    }
}
