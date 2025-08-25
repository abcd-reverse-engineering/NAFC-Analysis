package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.Config;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class CaptureConfig {
    public static final Config.Option<Integer> OPTION_ROTATION = Config.Option.create("camerax.core.captureConfig.rotation", Integer.TYPE);
    final List<CameraCaptureCallback> mCameraCaptureCallbacks;
    final Config mImplementationOptions;
    final List<DeferrableSurface> mSurfaces;
    private final Object mTag;
    final int mTemplateType;
    private final boolean mUseRepeatingSurface;

    public interface OptionUnpacker {
        void unpack(@NonNull UseCaseConfig<?> useCaseConfig, @NonNull Builder builder);
    }

    CaptureConfig(List<DeferrableSurface> list, Config config, int i2, List<CameraCaptureCallback> list2, boolean z, Object obj) {
        this.mSurfaces = list;
        this.mImplementationOptions = config;
        this.mTemplateType = i2;
        this.mCameraCaptureCallbacks = Collections.unmodifiableList(list2);
        this.mUseRepeatingSurface = z;
        this.mTag = obj;
    }

    @NonNull
    public static CaptureConfig defaultEmptyCaptureConfig() {
        return new Builder().build();
    }

    @NonNull
    public List<CameraCaptureCallback> getCameraCaptureCallbacks() {
        return this.mCameraCaptureCallbacks;
    }

    @NonNull
    public Config getImplementationOptions() {
        return this.mImplementationOptions;
    }

    @NonNull
    public List<DeferrableSurface> getSurfaces() {
        return Collections.unmodifiableList(this.mSurfaces);
    }

    @Nullable
    public Object getTag() {
        return this.mTag;
    }

    public int getTemplateType() {
        return this.mTemplateType;
    }

    public boolean isUseRepeatingSurface() {
        return this.mUseRepeatingSurface;
    }

    public static final class Builder {
        private List<CameraCaptureCallback> mCameraCaptureCallbacks;
        private MutableConfig mImplementationOptions;
        private final Set<DeferrableSurface> mSurfaces;
        private Object mTag;
        private int mTemplateType;
        private boolean mUseRepeatingSurface;

        public Builder() {
            this.mSurfaces = new HashSet();
            this.mImplementationOptions = MutableOptionsBundle.create();
            this.mTemplateType = -1;
            this.mCameraCaptureCallbacks = new ArrayList();
            this.mUseRepeatingSurface = false;
            this.mTag = null;
        }

        @NonNull
        public static Builder createFrom(@NonNull UseCaseConfig<?> useCaseConfig) {
            OptionUnpacker captureOptionUnpacker = useCaseConfig.getCaptureOptionUnpacker(null);
            if (captureOptionUnpacker != null) {
                Builder builder = new Builder();
                captureOptionUnpacker.unpack(useCaseConfig, builder);
                return builder;
            }
            throw new IllegalStateException("Implementation is missing option unpacker for " + useCaseConfig.getTargetName(useCaseConfig.toString()));
        }

        @NonNull
        public static Builder from(@NonNull CaptureConfig captureConfig) {
            return new Builder(captureConfig);
        }

        public void addAllCameraCaptureCallbacks(@NonNull Collection<CameraCaptureCallback> collection) {
            Iterator<CameraCaptureCallback> it = collection.iterator();
            while (it.hasNext()) {
                addCameraCaptureCallback(it.next());
            }
        }

        public void addCameraCaptureCallback(@NonNull CameraCaptureCallback cameraCaptureCallback) {
            if (this.mCameraCaptureCallbacks.contains(cameraCaptureCallback)) {
                throw new IllegalArgumentException("duplicate camera capture callback");
            }
            this.mCameraCaptureCallbacks.add(cameraCaptureCallback);
        }

        public <T> void addImplementationOption(@NonNull Config.Option<T> option, @NonNull T t) {
            this.mImplementationOptions.insertOption(option, t);
        }

        public void addImplementationOptions(@NonNull Config config) {
            for (Config.Option<?> option : config.listOptions()) {
                Object objRetrieveOption = this.mImplementationOptions.retrieveOption(option, null);
                Object objRetrieveOption2 = config.retrieveOption(option);
                if (objRetrieveOption instanceof MultiValueSet) {
                    ((MultiValueSet) objRetrieveOption).addAll(((MultiValueSet) objRetrieveOption2).getAllItems());
                } else {
                    if (objRetrieveOption2 instanceof MultiValueSet) {
                        objRetrieveOption2 = ((MultiValueSet) objRetrieveOption2).mo0clone();
                    }
                    this.mImplementationOptions.insertOption(option, objRetrieveOption2);
                }
            }
        }

        public void addSurface(@NonNull DeferrableSurface deferrableSurface) {
            this.mSurfaces.add(deferrableSurface);
        }

        @NonNull
        public CaptureConfig build() {
            return new CaptureConfig(new ArrayList(this.mSurfaces), OptionsBundle.from(this.mImplementationOptions), this.mTemplateType, this.mCameraCaptureCallbacks, this.mUseRepeatingSurface, this.mTag);
        }

        public void clearSurfaces() {
            this.mSurfaces.clear();
        }

        @NonNull
        public Config getImplementationOptions() {
            return this.mImplementationOptions;
        }

        @NonNull
        public Set<DeferrableSurface> getSurfaces() {
            return this.mSurfaces;
        }

        public int getTemplateType() {
            return this.mTemplateType;
        }

        boolean isUseRepeatingSurface() {
            return this.mUseRepeatingSurface;
        }

        public void removeSurface(@NonNull DeferrableSurface deferrableSurface) {
            this.mSurfaces.remove(deferrableSurface);
        }

        public void setImplementationOptions(@NonNull Config config) {
            this.mImplementationOptions = MutableOptionsBundle.from(config);
        }

        public void setTag(@NonNull Object obj) {
            this.mTag = obj;
        }

        public void setTemplateType(int i2) {
            this.mTemplateType = i2;
        }

        public void setUseRepeatingSurface(boolean z) {
            this.mUseRepeatingSurface = z;
        }

        private Builder(CaptureConfig captureConfig) {
            this.mSurfaces = new HashSet();
            this.mImplementationOptions = MutableOptionsBundle.create();
            this.mTemplateType = -1;
            this.mCameraCaptureCallbacks = new ArrayList();
            this.mUseRepeatingSurface = false;
            this.mTag = null;
            this.mSurfaces.addAll(captureConfig.mSurfaces);
            this.mImplementationOptions = MutableOptionsBundle.from(captureConfig.mImplementationOptions);
            this.mTemplateType = captureConfig.mTemplateType;
            this.mCameraCaptureCallbacks.addAll(captureConfig.getCameraCaptureCallbacks());
            this.mUseRepeatingSurface = captureConfig.isUseRepeatingSurface();
            this.mTag = captureConfig.getTag();
        }
    }
}
