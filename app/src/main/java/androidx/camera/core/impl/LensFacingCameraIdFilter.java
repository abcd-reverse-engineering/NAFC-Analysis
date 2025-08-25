package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.CameraX;
import java.util.Set;

/* loaded from: classes.dex */
public class LensFacingCameraIdFilter implements CameraIdFilter {
    private int mLensFacing;

    public LensFacingCameraIdFilter(int i2) {
        this.mLensFacing = i2;
    }

    @Override // androidx.camera.core.impl.CameraIdFilter
    @NonNull
    public Set<String> filter(@NonNull Set<String> set) {
        return CameraX.getCameraFactory().getLensFacingCameraIdFilter(this.mLensFacing).filter(set);
    }

    public int getLensFacing() {
        return this.mLensFacing;
    }
}
