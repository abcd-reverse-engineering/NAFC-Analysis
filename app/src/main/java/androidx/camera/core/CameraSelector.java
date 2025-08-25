package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.CameraIdFilter;
import androidx.camera.core.impl.LensFacingCameraIdFilter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class CameraSelector {
    public static final int LENS_FACING_BACK = 1;
    public static final int LENS_FACING_FRONT = 0;
    private LinkedHashSet<CameraIdFilter> mCameraFilterSet;

    @NonNull
    public static final CameraSelector DEFAULT_FRONT_CAMERA = new Builder().requireLensFacing(0).build();

    @NonNull
    public static final CameraSelector DEFAULT_BACK_CAMERA = new Builder().requireLensFacing(1).build();

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface LensFacing {
    }

    CameraSelector(LinkedHashSet<CameraIdFilter> linkedHashSet) {
        this.mCameraFilterSet = linkedHashSet;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public LinkedHashSet<CameraIdFilter> getCameraFilterSet() {
        return this.mCameraFilterSet;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Integer getLensFacing() {
        Iterator<CameraIdFilter> it = this.mCameraFilterSet.iterator();
        Integer num = null;
        while (it.hasNext()) {
            CameraIdFilter next = it.next();
            if (next instanceof LensFacingCameraIdFilter) {
                Integer numValueOf = Integer.valueOf(((LensFacingCameraIdFilter) next).getLensFacing());
                if (num == null) {
                    num = numValueOf;
                } else if (!num.equals(numValueOf)) {
                    throw new IllegalStateException("Multiple conflicting lens facing requirements exist.");
                }
            }
        }
        return num;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String select(@NonNull Set<String> set) {
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Iterator<CameraIdFilter> it = this.mCameraFilterSet.iterator();
        while (it.hasNext()) {
            linkedHashSet = it.next().filter(set);
            if (linkedHashSet.isEmpty()) {
                throw new IllegalArgumentException("No available camera can be found.");
            }
            if (!set.containsAll(linkedHashSet)) {
                throw new IllegalArgumentException("The output isn't contained in the input.");
            }
            set = linkedHashSet;
        }
        return linkedHashSet.iterator().next();
    }

    public static final class Builder {
        private final LinkedHashSet<CameraIdFilter> mCameraFilterSet;

        public Builder() {
            this.mCameraFilterSet = new LinkedHashSet<>();
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static Builder fromSelector(@NonNull CameraSelector cameraSelector) {
            return new Builder(cameraSelector.getCameraFilterSet());
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder appendFilter(@NonNull CameraIdFilter cameraIdFilter) {
            this.mCameraFilterSet.add(cameraIdFilter);
            return this;
        }

        @NonNull
        public CameraSelector build() {
            return new CameraSelector(this.mCameraFilterSet);
        }

        @NonNull
        public Builder requireLensFacing(int i2) {
            this.mCameraFilterSet.add(new LensFacingCameraIdFilter(i2));
            return this;
        }

        private Builder(@NonNull LinkedHashSet<CameraIdFilter> linkedHashSet) {
            this.mCameraFilterSet = new LinkedHashSet<>(linkedHashSet);
        }
    }
}
