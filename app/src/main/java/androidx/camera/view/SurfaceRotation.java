package androidx.camera.view;

import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;

/* loaded from: classes.dex */
final class SurfaceRotation {
    private SurfaceRotation() {
    }

    static int rotationDegreesFromSurfaceRotation(int i2) {
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
        throw new UnsupportedOperationException("Unsupported surface rotation constant: " + i2);
    }
}
