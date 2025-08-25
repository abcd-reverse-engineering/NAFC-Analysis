package androidx.camera.core.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraInfo;

/* loaded from: classes.dex */
public interface UseCaseConfigFactory {

    public interface Provider {
        @NonNull
        UseCaseConfigFactory newInstance(@NonNull Context context);
    }

    @Nullable
    <C extends UseCaseConfig<?>> C getConfig(@NonNull Class<C> cls, @Nullable CameraInfo cameraInfo);
}
