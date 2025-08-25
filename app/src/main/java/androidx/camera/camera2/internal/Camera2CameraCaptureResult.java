package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.camera.core.impl.CameraCaptureResult;

/* loaded from: classes.dex */
public class Camera2CameraCaptureResult implements CameraCaptureResult {
    private static final String TAG = "C2CameraCaptureResult";
    private final CaptureResult mCaptureResult;
    private final Object mTag;

    public Camera2CameraCaptureResult(@Nullable Object obj, @NonNull CaptureResult captureResult) {
        this.mTag = obj;
        this.mCaptureResult = captureResult;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public CameraCaptureMetaData.AeState getAeState() {
        Integer num = (Integer) this.mCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        if (num == null) {
            return CameraCaptureMetaData.AeState.UNKNOWN;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0) {
            return CameraCaptureMetaData.AeState.INACTIVE;
        }
        if (iIntValue != 1) {
            if (iIntValue == 2) {
                return CameraCaptureMetaData.AeState.CONVERGED;
            }
            if (iIntValue == 3) {
                return CameraCaptureMetaData.AeState.LOCKED;
            }
            if (iIntValue == 4) {
                return CameraCaptureMetaData.AeState.FLASH_REQUIRED;
            }
            if (iIntValue != 5) {
                String str = "Undefined ae state: " + num;
                return CameraCaptureMetaData.AeState.UNKNOWN;
            }
        }
        return CameraCaptureMetaData.AeState.SEARCHING;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public CameraCaptureMetaData.AfMode getAfMode() {
        Integer num = (Integer) this.mCaptureResult.get(CaptureResult.CONTROL_AF_MODE);
        if (num == null) {
            return CameraCaptureMetaData.AfMode.UNKNOWN;
        }
        int iIntValue = num.intValue();
        if (iIntValue != 0) {
            if (iIntValue == 1 || iIntValue == 2) {
                return CameraCaptureMetaData.AfMode.ON_MANUAL_AUTO;
            }
            if (iIntValue == 3 || iIntValue == 4) {
                return CameraCaptureMetaData.AfMode.ON_CONTINUOUS_AUTO;
            }
            if (iIntValue != 5) {
                String str = "Undefined af mode: " + num;
                return CameraCaptureMetaData.AfMode.UNKNOWN;
            }
        }
        return CameraCaptureMetaData.AfMode.OFF;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public CameraCaptureMetaData.AfState getAfState() {
        Integer num = (Integer) this.mCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        if (num == null) {
            return CameraCaptureMetaData.AfState.UNKNOWN;
        }
        switch (num.intValue()) {
            case 0:
                break;
            case 1:
            case 3:
            case 6:
                break;
            case 2:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                String str = "Undefined af state: " + num;
                break;
        }
        return CameraCaptureMetaData.AfState.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public CameraCaptureMetaData.AwbState getAwbState() {
        Integer num = (Integer) this.mCaptureResult.get(CaptureResult.CONTROL_AWB_STATE);
        if (num == null) {
            return CameraCaptureMetaData.AwbState.UNKNOWN;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0) {
            return CameraCaptureMetaData.AwbState.INACTIVE;
        }
        if (iIntValue == 1) {
            return CameraCaptureMetaData.AwbState.METERING;
        }
        if (iIntValue == 2) {
            return CameraCaptureMetaData.AwbState.CONVERGED;
        }
        if (iIntValue == 3) {
            return CameraCaptureMetaData.AwbState.LOCKED;
        }
        String str = "Undefined awb state: " + num;
        return CameraCaptureMetaData.AwbState.UNKNOWN;
    }

    @NonNull
    public CaptureResult getCaptureResult() {
        return this.mCaptureResult;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public CameraCaptureMetaData.FlashState getFlashState() {
        Integer num = (Integer) this.mCaptureResult.get(CaptureResult.FLASH_STATE);
        if (num == null) {
            return CameraCaptureMetaData.FlashState.UNKNOWN;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0 || iIntValue == 1) {
            return CameraCaptureMetaData.FlashState.NONE;
        }
        if (iIntValue == 2) {
            return CameraCaptureMetaData.FlashState.READY;
        }
        if (iIntValue == 3 || iIntValue == 4) {
            return CameraCaptureMetaData.FlashState.FIRED;
        }
        String str = "Undefined flash state: " + num;
        return CameraCaptureMetaData.FlashState.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @Nullable
    public Object getTag() {
        return this.mTag;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public long getTimestamp() {
        Long l2 = (Long) this.mCaptureResult.get(CaptureResult.SENSOR_TIMESTAMP);
        if (l2 == null) {
            return -1L;
        }
        return l2.longValue();
    }
}
