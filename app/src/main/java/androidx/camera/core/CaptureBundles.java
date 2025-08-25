package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureStage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class CaptureBundles {

    static final class CaptureBundleImpl implements CaptureBundle {
        final List<CaptureStage> mCaptureStageList;

        CaptureBundleImpl(List<CaptureStage> list) {
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("Cannot set an empty CaptureStage list.");
            }
            this.mCaptureStageList = Collections.unmodifiableList(new ArrayList(list));
        }

        @Override // androidx.camera.core.impl.CaptureBundle
        public List<CaptureStage> getCaptureStages() {
            return this.mCaptureStageList;
        }
    }

    private CaptureBundles() {
    }

    @NonNull
    static CaptureBundle createCaptureBundle(@NonNull CaptureStage... captureStageArr) {
        return new CaptureBundleImpl(Arrays.asList(captureStageArr));
    }

    @NonNull
    static CaptureBundle singleDefaultCaptureBundle() {
        return createCaptureBundle(new CaptureStage.DefaultCaptureStage());
    }

    @NonNull
    static CaptureBundle createCaptureBundle(@NonNull List<CaptureStage> list) {
        return new CaptureBundleImpl(list);
    }
}
