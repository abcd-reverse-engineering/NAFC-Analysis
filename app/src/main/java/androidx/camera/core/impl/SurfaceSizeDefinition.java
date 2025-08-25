package androidx.camera.core.impl;

import android.util.Size;

@c.b.a.a.c
/* loaded from: classes.dex */
public abstract class SurfaceSizeDefinition {
    SurfaceSizeDefinition() {
    }

    public static SurfaceSizeDefinition create(Size size, Size size2, Size size3) {
        return new AutoValue_SurfaceSizeDefinition(size, size2, size3);
    }

    public abstract Size getAnalysisSize();

    public abstract Size getPreviewSize();

    public abstract Size getRecordSize();
}
