package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.LensFacingCameraIdFilter;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
final class Camera2LensFacingCameraIdFilter extends LensFacingCameraIdFilter {
    private static final String TAG = "Camera2LensFacingCIF";
    private CameraManager mCameraManager;

    Camera2LensFacingCameraIdFilter(int i2, @NonNull CameraManager cameraManager) {
        super(i2);
        this.mCameraManager = cameraManager;
    }

    private Integer cameraXLensFacingToCamera2LensFacing(int i2) {
        if (i2 != 0) {
            return i2 != 1 ? -1 : 1;
        }
        return 0;
    }

    @Override // androidx.camera.core.impl.LensFacingCameraIdFilter, androidx.camera.core.impl.CameraIdFilter
    @NonNull
    public Set<String> filter(@NonNull Set<String> set) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str : set) {
            Integer num = null;
            try {
                num = (Integer) this.mCameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING);
            } catch (CameraAccessException unused) {
                String str2 = "Unable to retrieve info for camera with id " + str + ".";
            }
            if (num != null && num.equals(cameraXLensFacingToCamera2LensFacing(getLensFacing()))) {
                linkedHashSet.add(str);
            }
        }
        return linkedHashSet;
    }
}
