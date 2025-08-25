package androidx.camera.core;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* loaded from: classes.dex */
public interface ImageInfo {
    int getRotationDegrees();

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    Object getTag();

    long getTimestamp();
}
