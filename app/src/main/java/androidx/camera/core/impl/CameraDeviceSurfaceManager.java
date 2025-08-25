package androidx.camera.core.impl;

import android.content.Context;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.UseCase;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public interface CameraDeviceSurfaceManager {

    public interface Provider {
        @NonNull
        CameraDeviceSurfaceManager newInstance(@NonNull Context context);
    }

    boolean checkSupported(String str, List<SurfaceConfig> list);

    @Nullable
    Rational getCorrectedAspectRatio(@NonNull String str, int i2);

    @Nullable
    Size getMaxOutputSize(String str, int i2);

    Size getPreviewSize();

    Map<UseCase, Size> getSuggestedResolutions(String str, List<UseCase> list, List<UseCase> list2);

    boolean requiresCorrectedAspectRatio(@NonNull String str);

    SurfaceConfig transformSurfaceConfig(String str, int i2, Size size);
}
