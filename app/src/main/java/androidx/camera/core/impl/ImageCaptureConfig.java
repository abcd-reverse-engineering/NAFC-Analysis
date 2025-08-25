package androidx.camera.core.impl;

import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.internal.IoConfig;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.UseCaseEventConfig;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class ImageCaptureConfig implements UseCaseConfig<ImageCapture>, ImageOutputConfig, IoConfig {
    private final OptionsBundle mConfig;
    public static final Config.Option<Integer> OPTION_IMAGE_CAPTURE_MODE = Config.Option.create("camerax.core.imageCapture.captureMode", Integer.TYPE);
    public static final Config.Option<Integer> OPTION_FLASH_MODE = Config.Option.create("camerax.core.imageCapture.flashMode", Integer.TYPE);
    public static final Config.Option<CaptureBundle> OPTION_CAPTURE_BUNDLE = Config.Option.create("camerax.core.imageCapture.captureBundle", CaptureBundle.class);
    public static final Config.Option<CaptureProcessor> OPTION_CAPTURE_PROCESSOR = Config.Option.create("camerax.core.imageCapture.captureProcessor", CaptureProcessor.class);
    public static final Config.Option<Integer> OPTION_BUFFER_FORMAT = Config.Option.create("camerax.core.imageCapture.bufferFormat", Integer.class);
    public static final Config.Option<Integer> OPTION_MAX_CAPTURE_STAGES = Config.Option.create("camerax.core.imageCapture.maxCaptureStages", Integer.class);

    public ImageCaptureConfig(@NonNull OptionsBundle optionsBundle) {
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

    @Nullable
    public Integer getBufferFormat(@Nullable Integer num) {
        return (Integer) retrieveOption(OPTION_BUFFER_FORMAT, num);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    @Nullable
    public CameraSelector getCameraSelector(@Nullable CameraSelector cameraSelector) {
        return (CameraSelector) retrieveOption(UseCaseConfig.OPTION_CAMERA_SELECTOR, cameraSelector);
    }

    @Nullable
    public CaptureBundle getCaptureBundle(@Nullable CaptureBundle captureBundle) {
        return (CaptureBundle) retrieveOption(OPTION_CAPTURE_BUNDLE, captureBundle);
    }

    public int getCaptureMode() {
        return ((Integer) retrieveOption(OPTION_IMAGE_CAPTURE_MODE)).intValue();
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    @Nullable
    public CaptureConfig.OptionUnpacker getCaptureOptionUnpacker(@Nullable CaptureConfig.OptionUnpacker optionUnpacker) {
        return (CaptureConfig.OptionUnpacker) retrieveOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, optionUnpacker);
    }

    @Nullable
    public CaptureProcessor getCaptureProcessor(@Nullable CaptureProcessor captureProcessor) {
        return (CaptureProcessor) retrieveOption(OPTION_CAPTURE_PROCESSOR, captureProcessor);
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

    public int getFlashMode() {
        return ((Integer) retrieveOption(OPTION_FLASH_MODE)).intValue();
    }

    @Override // androidx.camera.core.internal.IoConfig
    @Nullable
    public Executor getIoExecutor(@Nullable Executor executor) {
        return (Executor) retrieveOption(IoConfig.OPTION_IO_EXECUTOR, executor);
    }

    public int getMaxCaptureStages(int i2) {
        return ((Integer) retrieveOption(OPTION_MAX_CAPTURE_STAGES, Integer.valueOf(i2))).intValue();
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
    public Class<ImageCapture> getTargetClass(@Nullable Class<ImageCapture> cls) {
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

    public boolean hasCaptureMode() {
        return containsOption(OPTION_IMAGE_CAPTURE_MODE);
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

    @NonNull
    public Integer getBufferFormat() {
        return (Integer) retrieveOption(OPTION_BUFFER_FORMAT);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    @NonNull
    public CameraSelector getCameraSelector() {
        return (CameraSelector) retrieveOption(UseCaseConfig.OPTION_CAMERA_SELECTOR);
    }

    @NonNull
    public CaptureBundle getCaptureBundle() {
        return (CaptureBundle) retrieveOption(OPTION_CAPTURE_BUNDLE);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig
    @NonNull
    public CaptureConfig.OptionUnpacker getCaptureOptionUnpacker() {
        return (CaptureConfig.OptionUnpacker) retrieveOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER);
    }

    @NonNull
    public CaptureProcessor getCaptureProcessor() {
        return (CaptureProcessor) retrieveOption(OPTION_CAPTURE_PROCESSOR);
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

    @Override // androidx.camera.core.internal.IoConfig
    @NonNull
    public Executor getIoExecutor() {
        return (Executor) retrieveOption(IoConfig.OPTION_IO_EXECUTOR);
    }

    public int getMaxCaptureStages() {
        return ((Integer) retrieveOption(OPTION_MAX_CAPTURE_STAGES)).intValue();
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
    public Class<ImageCapture> getTargetClass() {
        return (Class) retrieveOption(TargetConfig.OPTION_TARGET_CLASS);
    }
}
