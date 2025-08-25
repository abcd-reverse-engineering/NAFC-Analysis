package androidx.camera.camera2.internal;

import android.annotation.SuppressLint;
import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeviceProperties;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.UseCaseConfig;

/* loaded from: classes.dex */
final class ImageCaptureOptionUnpacker extends Camera2CaptureOptionUnpacker {
    static final ImageCaptureOptionUnpacker INSTANCE = new ImageCaptureOptionUnpacker();
    private DeviceProperties mDeviceProperties = DeviceProperties.create();

    ImageCaptureOptionUnpacker() {
    }

    @SuppressLint({"NewApi"})
    private void applyPixelHdrPlusChangeForCaptureMode(int i2, Camera2ImplConfig.Builder builder) {
        if ("Google".equals(this.mDeviceProperties.manufacturer())) {
            if (("Pixel 2".equals(this.mDeviceProperties.model()) || "Pixel 3".equals(this.mDeviceProperties.model())) && this.mDeviceProperties.sdkVersion() >= 26) {
                if (i2 == 0) {
                    builder.setCaptureRequestOption(CaptureRequest.CONTROL_ENABLE_ZSL, true);
                } else {
                    if (i2 != 1) {
                        return;
                    }
                    builder.setCaptureRequestOption(CaptureRequest.CONTROL_ENABLE_ZSL, false);
                }
            }
        }
    }

    void setDeviceProperty(DeviceProperties deviceProperties) {
        this.mDeviceProperties = deviceProperties;
    }

    @Override // androidx.camera.camera2.internal.Camera2CaptureOptionUnpacker, androidx.camera.core.impl.CaptureConfig.OptionUnpacker
    public void unpack(@NonNull UseCaseConfig<?> useCaseConfig, @NonNull CaptureConfig.Builder builder) {
        super.unpack(useCaseConfig, builder);
        if (!(useCaseConfig instanceof ImageCaptureConfig)) {
            throw new IllegalArgumentException("config is not ImageCaptureConfig");
        }
        ImageCaptureConfig imageCaptureConfig = (ImageCaptureConfig) useCaseConfig;
        Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
        if (imageCaptureConfig.hasCaptureMode()) {
            applyPixelHdrPlusChangeForCaptureMode(imageCaptureConfig.getCaptureMode(), builder2);
        }
        builder.addImplementationOptions(builder2.build());
    }
}
