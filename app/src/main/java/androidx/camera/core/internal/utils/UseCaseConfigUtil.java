package androidx.camera.core.internal.utils;

import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.CameraOrientationUtil;

/* loaded from: classes.dex */
public final class UseCaseConfigUtil {
    private UseCaseConfigUtil() {
    }

    public static void updateTargetRotationAndRelatedConfigs(@NonNull UseCaseConfig.Builder<?, ?, ?> builder, int i2) {
        ImageOutputConfig imageOutputConfig = (ImageOutputConfig) builder.getUseCaseConfig();
        int targetRotation = imageOutputConfig.getTargetRotation(-1);
        if (targetRotation == -1 || targetRotation != i2) {
            ((ImageOutputConfig.Builder) builder).setTargetRotation(i2);
        }
        if (targetRotation == -1 || i2 == -1 || targetRotation == i2) {
            return;
        }
        if (Math.abs(CameraOrientationUtil.surfaceRotationToDegrees(i2) - CameraOrientationUtil.surfaceRotationToDegrees(targetRotation)) % 180 == 90) {
            Size targetResolution = imageOutputConfig.getTargetResolution(null);
            Rational targetAspectRatioCustom = imageOutputConfig.getTargetAspectRatioCustom(null);
            if (targetResolution != null) {
                ((ImageOutputConfig.Builder) builder).setTargetResolution(new Size(targetResolution.getHeight(), targetResolution.getWidth()));
            }
            if (targetAspectRatioCustom != null) {
                ((ImageOutputConfig.Builder) builder).setTargetAspectRatioCustom(new Rational(targetAspectRatioCustom.getDenominator(), targetAspectRatioCustom.getNumerator()));
            }
        }
    }
}
