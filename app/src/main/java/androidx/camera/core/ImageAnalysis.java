package androidx.camera.core;

import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageAnalysisConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.ThreadConfig;
import androidx.camera.core.internal.UseCaseEventConfig;
import androidx.camera.core.internal.utils.UseCaseConfigUtil;
import androidx.core.util.Preconditions;
import cn.cloudwalk.libproject.Contants;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class ImageAnalysis extends UseCase {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Defaults DEFAULT_CONFIG = new Defaults();
    private static final int NON_BLOCKING_IMAGE_DEPTH = 4;
    public static final int STRATEGY_BLOCK_PRODUCER = 1;
    public static final int STRATEGY_KEEP_ONLY_LATEST = 0;
    private static final String TAG = "ImageAnalysis";
    private final Object mAnalysisLock;

    @Nullable
    private DeferrableSurface mDeferrableSurface;
    final ImageAnalysisAbstractAnalyzer mImageAnalysisAbstractAnalyzer;

    @GuardedBy("mAnalysisLock")
    private Analyzer mSubscribedAnalyzer;

    public interface Analyzer {
        void analyze(@NonNull ImageProxy imageProxy);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface BackpressureStrategy {
    }

    public static final class Builder implements ImageOutputConfig.Builder<Builder>, ThreadConfig.Builder<Builder>, UseCaseConfig.Builder<ImageAnalysis, ImageAnalysisConfig, Builder> {
        private final MutableOptionsBundle mMutableConfig;

        public Builder() {
            this(MutableOptionsBundle.create());
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static Builder fromConfig(@NonNull ImageAnalysisConfig imageAnalysisConfig) {
            return new Builder(MutableOptionsBundle.from((Config) imageAnalysisConfig));
        }

        @Override // androidx.camera.core.ExtendableBuilder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public MutableConfig getMutableConfig() {
            return this.mMutableConfig;
        }

        @NonNull
        public Builder setBackpressureStrategy(int i2) {
            getMutableConfig().insertOption(ImageAnalysisConfig.OPTION_BACKPRESSURE_STRATEGY, Integer.valueOf(i2));
            return this;
        }

        @NonNull
        public Builder setImageQueueDepth(int i2) {
            getMutableConfig().insertOption(ImageAnalysisConfig.OPTION_IMAGE_QUEUE_DEPTH, Integer.valueOf(i2));
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public /* bridge */ /* synthetic */ Builder setSupportedResolutions(@NonNull List list) {
            return setSupportedResolutions((List<Pair<Integer, Size[]>>) list);
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public /* bridge */ /* synthetic */ Object setTargetClass(@NonNull Class cls) {
            return setTargetClass((Class<ImageAnalysis>) cls);
        }

        private Builder(MutableOptionsBundle mutableOptionsBundle) {
            this.mMutableConfig = mutableOptionsBundle;
            Class cls = (Class) mutableOptionsBundle.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
            if (cls == null || cls.equals(ImageAnalysis.class)) {
                setTargetClass(ImageAnalysis.class);
                return;
            }
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
        }

        @Override // androidx.camera.core.ExtendableBuilder
        @NonNull
        public ImageAnalysis build() {
            if (getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO, null) == null || getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, null) == null) {
                return new ImageAnalysis(getUseCaseConfig());
            }
            throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public ImageAnalysisConfig getUseCaseConfig() {
            return new ImageAnalysisConfig(OptionsBundle.from(this.mMutableConfig));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.internal.ThreadConfig.Builder
        @NonNull
        public Builder setBackgroundExecutor(@NonNull Executor executor) {
            getMutableConfig().insertOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR, executor);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public Builder setCameraSelector(@NonNull CameraSelector cameraSelector) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAMERA_SELECTOR, cameraSelector);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setCaptureOptionUnpacker(@NonNull CaptureConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setDefaultCaptureConfig(@NonNull CaptureConfig captureConfig) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, captureConfig);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setDefaultResolution(@NonNull Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION, size);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setDefaultSessionConfig(@NonNull SessionConfig sessionConfig) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, sessionConfig);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setMaxResolution(@NonNull Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, size);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setSessionOptionUnpacker(@NonNull SessionConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setSupportedResolutions(@NonNull List<Pair<Integer, Size[]>> list) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, list);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setSurfaceOccupancyPriority(int i2) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(i2));
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        public Builder setTargetAspectRatio(int i2) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO, Integer.valueOf(i2));
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setTargetAspectRatioCustom(@NonNull Rational rational) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO_CUSTOM, rational);
            getMutableConfig().removeOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO);
            return this;
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setTargetClass(@NonNull Class<ImageAnalysis> cls) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_CLASS, cls);
            if (getMutableConfig().retrieveOption(TargetConfig.OPTION_TARGET_NAME, null) == null) {
                setTargetName(cls.getCanonicalName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + UUID.randomUUID());
            }
            return this;
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        @NonNull
        public Builder setTargetName(@NonNull String str) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_NAME, str);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        public Builder setTargetResolution(@NonNull Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, size);
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO_CUSTOM, new Rational(size.getWidth(), size.getHeight()));
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        public Builder setTargetRotation(int i2) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ROTATION, Integer.valueOf(i2));
            return this;
        }

        @Override // androidx.camera.core.internal.UseCaseEventConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setUseCaseEventCallback(@NonNull UseCase.EventCallback eventCallback) {
            getMutableConfig().insertOption(UseCaseEventConfig.OPTION_USE_CASE_EVENT_CALLBACK, eventCallback);
            return this;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Defaults implements ConfigProvider<ImageAnalysisConfig> {
        private static final int DEFAULT_BACKPRESSURE_STRATEGY = 0;
        private static final int DEFAULT_IMAGE_QUEUE_DEPTH = 6;
        private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 1;
        private static final Size DEFAULT_TARGET_RESOLUTION = new Size(Contants.PREVIEW_W, 480);
        private static final Size DEFAULT_MAX_RESOLUTION = new Size(1920, 1080);
        private static final ImageAnalysisConfig DEFAULT_CONFIG = new Builder().setBackpressureStrategy(0).setImageQueueDepth(6).setDefaultResolution(DEFAULT_TARGET_RESOLUTION).setMaxResolution(DEFAULT_MAX_RESOLUTION).setSurfaceOccupancyPriority(1).getUseCaseConfig();

        @Override // androidx.camera.core.impl.ConfigProvider
        @NonNull
        public ImageAnalysisConfig getConfig(@Nullable CameraInfo cameraInfo) {
            return DEFAULT_CONFIG;
        }
    }

    ImageAnalysis(@NonNull ImageAnalysisConfig imageAnalysisConfig) {
        super(imageAnalysisConfig);
        this.mAnalysisLock = new Object();
        ImageAnalysisConfig imageAnalysisConfig2 = (ImageAnalysisConfig) getUseCaseConfig();
        setImageFormat(ImageReaderFormatRecommender.chooseCombo().imageAnalysisFormat());
        if (imageAnalysisConfig2.getBackpressureStrategy() == 1) {
            this.mImageAnalysisAbstractAnalyzer = new ImageAnalysisBlockingAnalyzer();
        } else {
            this.mImageAnalysisAbstractAnalyzer = new ImageAnalysisNonBlockingAnalyzer(imageAnalysisConfig.getBackgroundExecutor(CameraXExecutors.highPriorityExecutor()));
        }
    }

    private void tryUpdateRelativeRotation() {
        ImageOutputConfig imageOutputConfig = (ImageOutputConfig) getUseCaseConfig();
        this.mImageAnalysisAbstractAnalyzer.setRelativeRotation(getBoundCamera().getCameraInfoInternal().getSensorRotationDegrees(imageOutputConfig.getTargetRotation(0)));
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void clear() {
        clearPipeline();
        super.clear();
    }

    public void clearAnalyzer() {
        synchronized (this.mAnalysisLock) {
            this.mImageAnalysisAbstractAnalyzer.setAnalyzer(null, null);
            if (this.mSubscribedAnalyzer != null) {
                notifyInactive();
            }
            this.mSubscribedAnalyzer = null;
        }
    }

    void clearPipeline() {
        Threads.checkMainThread();
        this.mImageAnalysisAbstractAnalyzer.close();
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
            this.mDeferrableSurface = null;
        }
    }

    SessionConfig.Builder createPipeline(@NonNull final String str, @NonNull final ImageAnalysisConfig imageAnalysisConfig, @NonNull final Size size) {
        Threads.checkMainThread();
        Executor executor = (Executor) Preconditions.checkNotNull(imageAnalysisConfig.getBackgroundExecutor(CameraXExecutors.highPriorityExecutor()));
        final ImageReaderProxy imageReaderProxyCreateIsolatedReader = ImageReaderProxys.createIsolatedReader(size.getWidth(), size.getHeight(), getImageFormat(), imageAnalysisConfig.getBackpressureStrategy() == 1 ? imageAnalysisConfig.getImageQueueDepth() : 4);
        tryUpdateRelativeRotation();
        this.mImageAnalysisAbstractAnalyzer.open();
        imageReaderProxyCreateIsolatedReader.setOnImageAvailableListener(this.mImageAnalysisAbstractAnalyzer, executor);
        SessionConfig.Builder builderCreateFrom = SessionConfig.Builder.createFrom(imageAnalysisConfig);
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
        this.mDeferrableSurface = new ImmediateSurface(imageReaderProxyCreateIsolatedReader.getSurface());
        c.b.b.a.a.a<Void> terminationFuture = this.mDeferrableSurface.getTerminationFuture();
        imageReaderProxyCreateIsolatedReader.getClass();
        terminationFuture.addListener(new Runnable() { // from class: androidx.camera.core.f0
            @Override // java.lang.Runnable
            public final void run() {
                imageReaderProxyCreateIsolatedReader.close();
            }
        }, CameraXExecutors.mainThreadExecutor());
        builderCreateFrom.addSurface(this.mDeferrableSurface);
        builderCreateFrom.addErrorListener(new SessionConfig.ErrorListener() { // from class: androidx.camera.core.ImageAnalysis.1
            @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
            public void onError(@NonNull SessionConfig sessionConfig, @NonNull SessionConfig.SessionError sessionError) {
                ImageAnalysis.this.clearPipeline();
                if (ImageAnalysis.this.isCurrentlyBoundCamera(str)) {
                    ImageAnalysis.this.attachToCamera(str, ImageAnalysis.this.createPipeline(str, imageAnalysisConfig, size).build());
                    ImageAnalysis.this.notifyReset();
                }
            }
        });
        return builderCreateFrom;
    }

    public int getBackpressureStrategy() {
        return ((ImageAnalysisConfig) getUseCaseConfig()).getBackpressureStrategy();
    }

    @Override // androidx.camera.core.UseCase
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected UseCaseConfig.Builder<?, ?, ?> getDefaultBuilder(@Nullable CameraInfo cameraInfo) {
        ImageAnalysisConfig imageAnalysisConfig = (ImageAnalysisConfig) CameraX.getDefaultUseCaseConfig(ImageAnalysisConfig.class, cameraInfo);
        if (imageAnalysisConfig != null) {
            return Builder.fromConfig(imageAnalysisConfig);
        }
        return null;
    }

    public int getImageQueueDepth() {
        return ((ImageAnalysisConfig) getUseCaseConfig()).getImageQueueDepth();
    }

    public int getTargetRotation() {
        return ((ImageAnalysisConfig) getUseCaseConfig()).getTargetRotation();
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected Map<String, Size> onSuggestedResolutionUpdated(@NonNull Map<String, Size> map) {
        ImageAnalysisConfig imageAnalysisConfig = (ImageAnalysisConfig) getUseCaseConfig();
        String boundCameraId = getBoundCameraId();
        Size size = map.get(boundCameraId);
        if (size != null) {
            attachToCamera(boundCameraId, createPipeline(boundCameraId, imageAnalysisConfig, size).build());
            return map;
        }
        throw new IllegalArgumentException("Suggested resolution map missing resolution for camera " + boundCameraId);
    }

    public void setAnalyzer(@NonNull Executor executor, @NonNull Analyzer analyzer) {
        synchronized (this.mAnalysisLock) {
            this.mImageAnalysisAbstractAnalyzer.setAnalyzer(executor, analyzer);
            if (this.mSubscribedAnalyzer == null) {
                notifyActive();
            }
            this.mSubscribedAnalyzer = analyzer;
        }
    }

    public void setTargetRotation(int i2) {
        ImageAnalysisConfig imageAnalysisConfig = (ImageAnalysisConfig) getUseCaseConfig();
        Builder builderFromConfig = Builder.fromConfig(imageAnalysisConfig);
        int targetRotation = imageAnalysisConfig.getTargetRotation(-1);
        if (targetRotation == -1 || targetRotation != i2) {
            UseCaseConfigUtil.updateTargetRotationAndRelatedConfigs(builderFromConfig, i2);
            updateUseCaseConfig(builderFromConfig.getUseCaseConfig());
            try {
                tryUpdateRelativeRotation();
            } catch (Exception unused) {
            }
        }
    }

    @NonNull
    public String toString() {
        return "ImageAnalysis:" + getName();
    }
}
