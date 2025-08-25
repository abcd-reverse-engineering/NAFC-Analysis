package androidx.camera.core.impl.utils;

import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;

/* loaded from: classes.dex */
public final class CameraOrientationUtil {
    private static final boolean DEBUG = false;
    private static final String TAG = "CameraOrientationUtil";

    private CameraOrientationUtil() {
    }

    public static int getRelativeImageRotation(int i2, int i3, boolean z) {
        return z ? ((i3 - i2) + 360) % 360 : (i3 + i2) % 360;
    }

    public static int surfaceRotationToDegrees(int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (i2 == 1) {
            return 90;
        }
        if (i2 == 2) {
            return 180;
        }
        if (i2 == 3) {
            return SubsamplingScaleImageView.ORIENTATION_270;
        }
        throw new IllegalArgumentException("Unsupported surface rotation: " + i2);
    }
}
