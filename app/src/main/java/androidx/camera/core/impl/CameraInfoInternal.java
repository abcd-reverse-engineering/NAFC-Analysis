package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraInfo;

/* loaded from: classes.dex */
public interface CameraInfoInternal extends CameraInfo {
    @NonNull
    String getCameraId();

    @Nullable
    Integer getLensFacing();
}
