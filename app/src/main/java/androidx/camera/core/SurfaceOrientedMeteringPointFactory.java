package androidx.camera.core;

import android.graphics.PointF;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public class SurfaceOrientedMeteringPointFactory extends MeteringPointFactory {
    private final float mHeight;
    private final float mWidth;

    public SurfaceOrientedMeteringPointFactory(float f2, float f3) {
        this.mWidth = f2;
        this.mHeight = f3;
    }

    @Nullable
    private static Rational getUseCaseAspectRatio(@Nullable UseCase useCase) {
        if (useCase == null) {
            return null;
        }
        Set<String> attachedCameraIds = useCase.getAttachedCameraIds();
        if (attachedCameraIds.isEmpty()) {
            throw new IllegalStateException("UseCase " + useCase + " is not bound.");
        }
        Iterator<String> it = attachedCameraIds.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Size attachedSurfaceResolution = useCase.getAttachedSurfaceResolution(it.next());
        return new Rational(attachedSurfaceResolution.getWidth(), attachedSurfaceResolution.getHeight());
    }

    @Override // androidx.camera.core.MeteringPointFactory
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected PointF convertPoint(float f2, float f3) {
        return new PointF(f2 / this.mWidth, f3 / this.mHeight);
    }

    public SurfaceOrientedMeteringPointFactory(float f2, float f3, @NonNull UseCase useCase) {
        super(getUseCaseAspectRatio(useCase));
        this.mWidth = f2;
        this.mHeight = f3;
    }
}
