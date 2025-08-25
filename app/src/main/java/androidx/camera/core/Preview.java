package androidx.camera.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageInfoProcessor;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.ThreadConfig;
import androidx.camera.core.internal.UseCaseEventConfig;
import androidx.core.util.Preconditions;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class Preview extends UseCase {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Defaults DEFAULT_CONFIG = new Defaults();
    private static final String TAG = "Preview";

    @Nullable
    private Size mLatestResolution;

    @Nullable
    Executor mPreviewSurfaceProviderExecutor;

    @Nullable
    private Handler mProcessingPreviewHandler;

    @Nullable
    private HandlerThread mProcessingPreviewThread;
    private DeferrableSurface mSessionDeferrableSurface;

    @Nullable
    SurfaceProvider mSurfaceProvider;

    public static final class Builder implements UseCaseConfig.Builder<Preview, PreviewConfig, Builder>, ImageOutputConfig.Builder<Builder>, ThreadConfig.Builder<Builder> {
        private final MutableOptionsBundle mMutableConfig;

        public Builder() {
            this(MutableOptionsBundle.create());
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static Builder fromConfig(@NonNull PreviewConfig previewConfig) {
            return new Builder(MutableOptionsBundle.from((Config) previewConfig));
        }

        @Override // androidx.camera.core.ExtendableBuilder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public MutableConfig getMutableConfig() {
            return this.mMutableConfig;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setCaptureProcessor(@NonNull CaptureProcessor captureProcessor) {
            getMutableConfig().insertOption(PreviewConfig.OPTION_PREVIEW_CAPTURE_PROCESSOR, captureProcessor);
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setImageInfoProcessor(@NonNull ImageInfoProcessor imageInfoProcessor) {
            getMutableConfig().insertOption(PreviewConfig.IMAGE_INFO_PROCESSOR, imageInfoProcessor);
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
            return setTargetClass((Class<Preview>) cls);
        }

        private Builder(MutableOptionsBundle mutableOptionsBundle) {
            this.mMutableConfig = mutableOptionsBundle;
            Class cls = (Class) mutableOptionsBundle.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
            if (cls == null || cls.equals(Preview.class)) {
                setTargetClass(Preview.class);
                return;
            }
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
        }

        @Override // androidx.camera.core.ExtendableBuilder
        @NonNull
        public Preview build() {
            if (getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO, null) == null || getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, null) == null) {
                return new Preview(getUseCaseConfig());
            }
            throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public PreviewConfig getUseCaseConfig() {
            return new PreviewConfig(OptionsBundle.from(this.mMutableConfig));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.internal.ThreadConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setBackgroundExecutor(@NonNull Executor executor) {
            getMutableConfig().insertOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR, executor);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
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
        public Builder setTargetClass(@NonNull Class<Preview> cls) {
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
            if (size != null) {
                getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO_CUSTOM, new Rational(size.getWidth(), size.getHeight()));
            }
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
    public static final class Defaults implements ConfigProvider<PreviewConfig> {
        private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 2;
        private static final Size DEFAULT_MAX_RESOLUTION = CameraX.getSurfaceManager().getPreviewSize();
        private static final PreviewConfig DEFAULT_CONFIG = new Builder().setMaxResolution(DEFAULT_MAX_RESOLUTION).setSurfaceOccupancyPriority(2).getUseCaseConfig();

        @Override // androidx.camera.core.impl.ConfigProvider
        @NonNull
        public PreviewConfig getConfig(@Nullable CameraInfo cameraInfo) {
            return DEFAULT_CONFIG;
        }
    }

    public interface SurfaceProvider {
        void onSurfaceRequested(@NonNull SurfaceRequest surfaceRequest);
    }

    @MainThread
    Preview(@NonNull PreviewConfig previewConfig) {
        super(previewConfig);
    }

    private void updateConfigAndOutput(@NonNull String str, @NonNull PreviewConfig previewConfig, @NonNull Size size) {
        Preconditions.checkState(isPreviewSurfaceProviderSet());
        attachToCamera(str, createPipeline(str, previewConfig, size).build());
    }

    public /* synthetic */ void a(SurfaceRequest surfaceRequest) {
        this.mSurfaceProvider.onSurfaceRequested(surfaceRequest);
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected UseCaseConfig<?> applyDefaults(@NonNull UseCaseConfig<?> useCaseConfig, @Nullable UseCaseConfig.Builder<?, ?, ?> builder) {
        Rational correctedAspectRatio;
        PreviewConfig previewConfig = (PreviewConfig) super.applyDefaults(useCaseConfig, builder);
        CameraInternal boundCamera = getBoundCamera();
        if (boundCamera == null || !CameraX.getSurfaceManager().requiresCorrectedAspectRatio(boundCamera.getCameraInfoInternal().getCameraId()) || (correctedAspectRatio = CameraX.getSurfaceManager().getCorrectedAspectRatio(boundCamera.getCameraInfoInternal().getCameraId(), previewConfig.getTargetRotation(0))) == null) {
            return previewConfig;
        }
        Builder builderFromConfig = Builder.fromConfig(previewConfig);
        builderFromConfig.setTargetAspectRatioCustom(correctedAspectRatio);
        return builderFromConfig.getUseCaseConfig();
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void clear() {
        notifyInactive();
        DeferrableSurface deferrableSurface = this.mSessionDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
        super.clear();
    }

    SessionConfig.Builder createPipeline(@NonNull final String str, @NonNull final PreviewConfig previewConfig, @NonNull final Size size) {
        Threads.checkMainThread();
        Preconditions.checkState(isPreviewSurfaceProviderSet());
        SessionConfig.Builder builderCreateFrom = SessionConfig.Builder.createFrom(previewConfig);
        CaptureProcessor captureProcessor = previewConfig.getCaptureProcessor(null);
        final SurfaceRequest surfaceRequest = new SurfaceRequest(size);
        this.mPreviewSurfaceProviderExecutor.execute(new Runnable() { // from class: androidx.camera.core.g0
            @Override // java.lang.Runnable
            public final void run() {
                this.f1475a.a(surfaceRequest);
            }
        });
        if (captureProcessor != null) {
            CaptureStage.DefaultCaptureStage defaultCaptureStage = new CaptureStage.DefaultCaptureStage();
            if (this.mProcessingPreviewHandler == null) {
                this.mProcessingPreviewThread = new HandlerThread("ProcessingSurfaceTexture");
                this.mProcessingPreviewThread.start();
                this.mProcessingPreviewHandler = new Handler(this.mProcessingPreviewThread.getLooper());
            }
            ProcessingSurface processingSurface = new ProcessingSurface(size.getWidth(), size.getHeight(), 35, this.mProcessingPreviewHandler, defaultCaptureStage, captureProcessor, surfaceRequest.getDeferrableSurface());
            builderCreateFrom.addCameraCaptureCallback(processingSurface.getCameraCaptureCallback());
            this.mSessionDeferrableSurface = processingSurface;
            builderCreateFrom.setTag(Integer.valueOf(defaultCaptureStage.getId()));
        } else {
            final ImageInfoProcessor imageInfoProcessor = previewConfig.getImageInfoProcessor(null);
            if (imageInfoProcessor != null) {
                builderCreateFrom.addCameraCaptureCallback(new CameraCaptureCallback() { // from class: androidx.camera.core.Preview.1
                    @Override // androidx.camera.core.impl.CameraCaptureCallback
                    public void onCaptureCompleted(@NonNull CameraCaptureResult cameraCaptureResult) {
                        super.onCaptureCompleted(cameraCaptureResult);
                        if (imageInfoProcessor.process(new CameraCaptureResultImageInfo(cameraCaptureResult))) {
                            Preview.this.notifyUpdated();
                        }
                    }
                });
            }
            this.mSessionDeferrableSurface = surfaceRequest.getDeferrableSurface();
        }
        builderCreateFrom.addSurface(this.mSessionDeferrableSurface);
        builderCreateFrom.addErrorListener(new SessionConfig.ErrorListener() { // from class: androidx.camera.core.Preview.2
            @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
            public void onError(@NonNull SessionConfig sessionConfig, @NonNull SessionConfig.SessionError sessionError) {
                if (Preview.this.isCurrentlyBoundCamera(str)) {
                    Preview.this.attachToCamera(str, Preview.this.createPipeline(str, previewConfig, size).build());
                    Preview.this.notifyReset();
                }
            }
        });
        return builderCreateFrom;
    }

    @Override // androidx.camera.core.UseCase
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected UseCaseConfig.Builder<?, ?, ?> getDefaultBuilder(@Nullable CameraInfo cameraInfo) {
        PreviewConfig previewConfig = (PreviewConfig) CameraX.getDefaultUseCaseConfig(PreviewConfig.class, cameraInfo);
        if (previewConfig != null) {
            return Builder.fromConfig(previewConfig);
        }
        return null;
    }

    public int getTargetRotation() {
        return ((PreviewConfig) getUseCaseConfig()).getTargetRotation();
    }

    boolean isPreviewSurfaceProviderSet() {
        return (this.mSurfaceProvider == null || this.mPreviewSurfaceProviderExecutor == null) ? false : true;
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected Map<String, Size> onSuggestedResolutionUpdated(@NonNull Map<String, Size> map) {
        String boundCameraId = getBoundCameraId();
        Size size = map.get(boundCameraId);
        if (size != null) {
            this.mLatestResolution = size;
            if (isPreviewSurfaceProviderSet()) {
                updateConfigAndOutput(boundCameraId, (PreviewConfig) getUseCaseConfig(), size);
            }
            return map;
        }
        throw new IllegalArgumentException("Suggested resolution map missing resolution for camera " + boundCameraId);
    }

    @UiThread
    public void setSurfaceProvider(@NonNull Executor executor, @Nullable SurfaceProvider surfaceProvider) {
        Threads.checkMainThread();
        if (surfaceProvider == null) {
            this.mSurfaceProvider = null;
            notifyInactive();
            return;
        }
        this.mSurfaceProvider = surfaceProvider;
        this.mPreviewSurfaceProviderExecutor = executor;
        notifyActive();
        if (this.mLatestResolution != null) {
            updateConfigAndOutput(getBoundCameraId(), (PreviewConfig) getUseCaseConfig(), this.mLatestResolution);
        }
    }

    @NonNull
    public String toString() {
        return "Preview:" + getName();
    }

    @UiThread
    public void setSurfaceProvider(@Nullable SurfaceProvider surfaceProvider) {
        setSurfaceProvider(CameraXExecutors.mainThreadExecutor(), surfaceProvider);
    }
}
