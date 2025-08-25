package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import java.util.Set;

/* loaded from: classes.dex */
public interface CameraIdFilter {
    @NonNull
    Set<String> filter(@NonNull Set<String> set);
}
