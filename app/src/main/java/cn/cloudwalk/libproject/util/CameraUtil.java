package cn.cloudwalk.libproject.util;

import android.hardware.Camera;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;

/* loaded from: classes.dex */
public class CameraUtil {
    public static boolean isHasCamera(int i2) {
        if (UIUtils.getSdkVersion() < 9) {
            return false;
        }
        int numberOfCameras = Camera.getNumberOfCameras();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i3 = 0; i3 < numberOfCameras; i3++) {
            Camera.getCameraInfo(i3, cameraInfo);
            if (i2 == cameraInfo.facing) {
                return true;
            }
        }
        return false;
    }

    public static void setCameraDisplayOrientation(int i2, int i3, Camera camera) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i3, cameraInfo);
        int i4 = 0;
        if (i2 != 0) {
            if (i2 == 1) {
                i4 = 90;
            } else if (i2 == 2) {
                i4 = 180;
            } else if (i2 == 3) {
                i4 = SubsamplingScaleImageView.ORIENTATION_270;
            }
        }
        camera.setDisplayOrientation(cameraInfo.facing == 1 ? (360 - ((cameraInfo.orientation + i4) % 360)) % 360 : ((cameraInfo.orientation - i4) + 360) % 360);
    }
}
