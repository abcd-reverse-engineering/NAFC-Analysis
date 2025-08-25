package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.Config;

/* loaded from: classes.dex */
public interface ConfigProvider<C extends Config> {
    @NonNull
    C getConfig(@Nullable CameraInfo cameraInfo);
}
