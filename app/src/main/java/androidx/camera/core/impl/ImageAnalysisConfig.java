package androidx.camera.core.impl;

import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.ThreadConfig;
import androidx.camera.core.internal.UseCaseEventConfig;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class ImageAnalysisConfig implements UseCaseConfig<ImageAnalysis>, ImageOutputConfig, ThreadConfig {
    public static final Config.Option<Integer> OPTION_BACKPRESSURE_STRATEGY = Config.Option.create("camerax.core.imageAnalysis.backpressureStrategy", ImageAnalysis.BackpressureStrategy.class);
    public static final Config.Option<Integer> OPTION_IMAGE_QUEUE_DEPTH = Config.Option.create("camerax.core.imageAnalysis.imageQueueDepth", Integer.TYPE);
    private final OptionsBundle mConfig;

    public ImageAnalysisConfig(@NonNull OptionsBundle optionsBundle) {
        this.mConfig = optionsBundle;
    }

    @Override // androidx.camera.core.impl.Config
    public boolean containsOption(@NonNull Config.Option<?> option) {
        return this.mConfig.containsOption(option);
    }

    @Override // androidx.camera.core.impl.Config
    public void findOptions(@NonNull String str, @NonNull Config.OptionMatcher optionMatcher) {
        this.mConfig.findOptions(str, optionMatcher);
    }

    @Override // androidx.camera.core.internal.ThreadConfig
    @Nullable
    public Executor getBackgroundExecutor(@Nullable Executor executor) {
        return (Executor) retrieveOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR, executor);
    }

    public int getBackpressureStrategy(int i2) {
        return ((Integer) retrieveOption(OPTION_BACKPRESSURE_STRATEGY, Integer.valueOf(i2))).intValue();
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public CameraSelector getCameraSelector(@Nullable CameraSelector cameraSelector) {
        return (CameraSelector) retrieveOption(UseCaseConfig.OPTION_CAMERA_SELECTOR, cameraSelector);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    @Nullable
    public CaptureConfig.OptionUnpacker getCaptureOptionUnpacker(@Nullable CaptureConfig.OptionUnpacker optionUnpacker) {
        return (CaptureConfig.OptionUnpacker) retrieveOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, optionUnpacker);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    @Nullable
    public CaptureConfig getDefaultCaptureConfig(@Nullable CaptureConfig captureConfig) {
        return (CaptureConfig) retrieveOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, captureConfig);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    @Nullable
    public Size getDefaultResolution(@Nullable Size size) {
        return (Size) retrieveOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION, size);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    @Nullable
    public SessionConfig getDefaultSessionConfig(@Nullable SessionConfig sessionConfig) {
        return (SessionConfig) retrieveOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, sessionConfig);
    }

    public int getImageQueueDepth(int i2) {
        return ((Integer) retrieveOption(OPTION_IMAGE_QUEUE_DEPTH, Integer.valueOf(i2))).intValue();
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    @Nullable
    public Size getMaxResolution(@Nullable Size size) {
        return (Size) retrieveOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, size);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    @Nullable
    public SessionConfig.OptionUnpacker getSessionOptionUnpacker(@Nullable SessionConfig.OptionUnpacker optionUnpacker) {
        return (SessionConfig.OptionUnpacker) retrieveOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, optionUnpacker);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    @Nullable
    public List<Pair<Integer, Size[]>> getSupportedResolutions(@Nullable List<Pair<Integer, Size[]>> list) {
        return (List) retrieveOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, list);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public int getSurfaceOccupancyPriority(int i2) {
        return ((Integer) retrieveOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(i2))).intValue();
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public int getTargetAspectRatio() {
        return ((Integer) retrieveOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO)).intValue();
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    @Nullable
    public Rational getTargetAspectRatioCustom(@Nullable Rational rational) {
        return (Rational) retrieveOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO_CUSTOM, rational);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    @Nullable
    public Class<ImageAnalysis> getTargetClass(@Nullable Class<ImageAnalysis> cls) {
        return (Class) retrieveOption(TargetConfig.OPTION_TARGET_CLASS, cls);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    @Nullable
    public String getTargetName(@Nullable String str) {
        return (String) retrieveOption(TargetConfig.OPTION_TARGET_NAME, str);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    @Nullable
    public Size getTargetResolution(@Nullable Size size) {
        return (Size) retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, size);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public int getTargetRotation(int i2) {
        return ((Integer) retrieveOption(ImageOutputConfig.OPTION_TARGET_ROTATION, Integer.valueOf(i2))).intValue();
    }

    @Override // androidx.camera.core.internal.UseCaseEventConfig
    @Nullable
    public UseCase.EventCallback getUseCaseEventCallback(@Nullable UseCase.EventCallback eventCallback) {
        return (UseCase.EventCallback) retrieveOption(UseCaseEventConfig.OPTION_USE_CASE_EVENT_CALLBACK, eventCallback);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public boolean hasTargetAspectRatio() {
        return containsOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO);
    }

    @Override // androidx.camera.core.impl.Config
    @NonNull
    public Set<Config.Option<?>> listOptions() {
        return this.mConfig.listOptions();
    }

    @Override // androidx.camera.core.impl.Config
    @Nullable
    public <ValueT> ValueT retrieveOption(@NonNull Config.Option<ValueT> option) {
        return (ValueT) this.mConfig.retrieveOption(option);
    }

    @Override // androidx.camera.core.internal.ThreadConfig
    @NonNull
    public Executor getBackgroundExecutor() {
        return (Executor) retrieveOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR);
    }

    public int getBackpressureStrategy() {
        return ((Integer) retrieveOption(OPTION_BACKPRESSURE_STRATEGY)).intValue();
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public CameraSelector getCameraSelector() {
        return (CameraSelector) retrieveOption(UseCaseConfig.OPTION_CAMERA_SELECTOR);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    @NonNull
    public CaptureConfig.OptionUnpacker getCaptureOptionUnpacker() {
        return (CaptureConfig.OptionUnpacker) retrieveOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    @NonNull
    public CaptureConfig getDefaultCaptureConfig() {
        return (CaptureConfig) retrieveOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    @NonNull
    public Size getDefaultResolution() {
        return (Size) retrieveOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    @NonNull
    public SessionConfig getDefaultSessionConfig() {
        return (SessionConfig) retrieveOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG);
    }

    public int getImageQueueDepth() {
        return ((Integer) retrieveOption(OPTION_IMAGE_QUEUE_DEPTH)).intValue();
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    @NonNull
    public Size getMaxResolution() {
        return (Size) retrieveOption(ImageOutputConfig.OPTION_MAX_RESOLUTION);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    @NonNull
    public SessionConfig.OptionUnpacker getSessionOptionUnpacker() {
        return (SessionConfig.OptionUnpacker) retrieveOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    @NonNull
    public List<Pair<Integer, Size[]>> getSupportedResolutions() {
        return (List) retrieveOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    public int getSurfaceOccupancyPriority() {
        return ((Integer) retrieveOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY)).intValue();
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    @NonNull
    public Rational getTargetAspectRatioCustom() {
        return (Rational) retrieveOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO_CUSTOM);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    @NonNull
    public String getTargetName() {
        return (String) retrieveOption(TargetConfig.OPTION_TARGET_NAME);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    @NonNull
    public Size getTargetResolution() {
        return (Size) retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION);
    }

    @Override // androidx.camera.core.impl.ImageOutputConfig
    public int getTargetRotation() {
        return ((Integer) retrieveOption(ImageOutputConfig.OPTION_TARGET_ROTATION)).intValue();
    }

    @Override // androidx.camera.core.internal.UseCaseEventConfig
    @NonNull
    public UseCase.EventCallback getUseCaseEventCallback() {
        return (UseCase.EventCallback) retrieveOption(UseCaseEventConfig.OPTION_USE_CASE_EVENT_CALLBACK);
    }

    @Override // androidx.camera.core.impl.Config
    @Nullable
    public <ValueT> ValueT retrieveOption(@NonNull Config.Option<ValueT> option, @Nullable ValueT valuet) {
        return (ValueT) this.mConfig.retrieveOption(option, valuet);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    @NonNull
    public Class<ImageAnalysis> getTargetClass() {
        return (Class) retrieveOption(TargetConfig.OPTION_TARGET_CLASS);
    }
}
