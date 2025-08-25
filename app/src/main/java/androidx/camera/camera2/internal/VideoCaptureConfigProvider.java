package androidx.camera.camera2.internal;

import android.content.Context;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.VideoCaptureConfig;

/* loaded from: classes.dex */
public final class VideoCaptureConfigProvider implements ConfigProvider<VideoCaptureConfig> {
    private static final String TAG = "VideoCaptureProvider";
    private final WindowManager mWindowManager;

    public VideoCaptureConfigProvider(@NonNull Context context) {
        this.mWindowManager = (WindowManager) context.getSystemService("window");
    }

    @Override // androidx.camera.core.impl.ConfigProvider
    @NonNull
    public VideoCaptureConfig getConfig(@Nullable CameraInfo cameraInfo) {
        VideoCaptureConfig.Builder builderFromConfig = VideoCaptureConfig.Builder.fromConfig(VideoCapture.DEFAULT_CONFIG.getConfig(cameraInfo));
        SessionConfig.Builder builder = new SessionConfig.Builder();
        boolean z = true;
        builder.setTemplateType(1);
        builderFromConfig.setDefaultSessionConfig(builder.build());
        builderFromConfig.setSessionOptionUnpacker((SessionConfig.OptionUnpacker) Camera2SessionOptionUnpacker.INSTANCE);
        CaptureConfig.Builder builder2 = new CaptureConfig.Builder();
        builder2.setTemplateType(1);
        builderFromConfig.setDefaultCaptureConfig(builder2.build());
        builderFromConfig.setCaptureOptionUnpacker((CaptureConfig.OptionUnpacker) Camera2CaptureOptionUnpacker.INSTANCE);
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
