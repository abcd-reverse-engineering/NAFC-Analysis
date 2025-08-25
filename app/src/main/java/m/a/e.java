package m.a;

import android.annotation.SuppressLint;
import android.hardware.Camera;

/* compiled from: OpenCameraInterface.java */
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17279a = "m.a.e";

    private e() {
    }

    @SuppressLint({"NewApi"})
    public static Camera a(int i2) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            return null;
        }
        boolean z = i2 >= 0;
        if (!z) {
            i2 = 0;
            while (i2 < numberOfCameras) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == 0) {
                    break;
                }
                i2++;
            }
        }
        if (i2 < numberOfCameras) {
            String str = "Opening camera #" + i2;
            return Camera.open(i2);
        }
        if (!z) {
            return Camera.open(0);
        }
        String str2 = "Requested camera does not exist: " + i2;
        return null;
    }

    public static Camera a() {
        return a(-1);
    }
}
