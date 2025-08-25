package androidx.camera.camera2.internal;

import android.content.Context;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.SessionConfig;

/* loaded from: classes.dex */
public final class ImageCaptureConfigProvider implements ConfigProvider<ImageCaptureConfig> {
    private static final String TAG = "ImageCaptureProvider";
    private final WindowManager mWindowManager;

    public ImageCaptureConfigProvider(@NonNull Context context) {
        this.mWindowManager = (WindowManager) context.getSystemService("window");
    }

    @Override // androidx.camera.core.impl.ConfigProvider
    @NonNull
    public ImageCaptureConfig getConfig(@Nullable CameraInfo cameraInfo) {
        ImageCapture.Builder builderFromConfig = ImageCapture.Builder.fromConfig(ImageCapture.DEFAULT_CONFIG.getConfig(cameraInfo));
        SessionConfig.Builder builder = new SessionConfig.Builder();
        boolean z = true;
        builder.setTemplateType(1);
        builderFromConfig.setDefaultSessionConfig(builder.build());
        builderFromConfig.setSessionOptionUnpacker((SessionConfig.OptionUnpacker) Camera2SessionOptionUnpacker.INSTANCE);
        CaptureConfig.Builder builder2 = new CaptureConfig.Builder();
        builder2.setTemplateType(2);
        builderFromConfig.setDefaultCaptureConfig(builder2.build());
        builderFromConfig.setCaptureOptionUnpacker((CaptureConfig.OptionUnpacker) ImageCaptureOptionUnpacker.INSTANCE);
        int rotation = this.mWindowManager.getDefaultDisplay().getRotation();
        builderFromConfig.setTargetRotation(rotation);
        if (cameraInfo != null) {
            int sensorRotationDegrees = cameraInfo.getSensorRotationDegrees(rotation);
            if (sensorRotationDegrees != 90 && sensorRotationDegrees != 270) {
                z = false;
            }
            builderFromConfig.setTargetAspectRatioCustom(z ? ImageOutputConfig.DEFAULT_ASPECT_RATIO_PORTRAIT : ImageOutputConfig.DEFAULT_ASPECT_RATIO_LANDSCAPE);
        }
        return builderFromConfig.getUseCaseConfig();
    }
}
