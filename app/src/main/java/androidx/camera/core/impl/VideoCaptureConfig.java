package androidx.camera.core.impl;

import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.UseCase;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.ThreadConfig;
import androidx.camera.core.internal.UseCaseEventConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class VideoCaptureConfig implements UseCaseConfig<VideoCapture>, ImageOutputConfig, ThreadConfig {
    private final OptionsBundle mConfig;
    static final Config.Option<Integer> OPTION_VIDEO_FRAME_RATE = Config.Option.create("camerax.core.videoCapture.recordingFrameRate", Integer.TYPE);
    static final Config.Option<Integer> OPTION_BIT_RATE = Config.Option.create("camerax.core.videoCapture.bitRate", Integer.TYPE);
    static final Config.Option<Integer> OPTION_INTRA_FRAME_INTERVAL = Config.Option.create("camerax.core.videoCapture.intraFrameInterval", Integer.TYPE);
    static final Config.Option<Integer> OPTION_AUDIO_BIT_RATE = Config.Option.create("camerax.core.videoCapture.audioBitRate", Integer.TYPE);
    static final Config.Option<Integer> OPTION_AUDIO_SAMPLE_RATE = Config.Option.create("camerax.core.videoCapture.audioSampleRate", Integer.TYPE);
    static final Config.Option<Integer> OPTION_AUDIO_CHANNEL_COUNT = Config.Option.create("camerax.core.videoCapture.audioChannelCount", Integer.TYPE);
    static final Config.Option<Integer> OPTION_AUDIO_RECORD_SOURCE = Config.Option.create("camerax.core.videoCapture.audioRecordSource", Integer.TYPE);
    static final Config.Option<Integer> OPTION_AUDIO_MIN_BUFFER_SIZE = Config.Option.create("camerax.core.videoCapture.audioMinBufferSize", Integer.TYPE);

    public static final class Builder implements UseCaseConfig.Builder<VideoCapture, VideoCaptureConfig, Builder>, ImageOutputConfig.Builder<Builder>, ThreadConfig.Builder<Builder> {
        private final MutableOptionsBundle mMutableConfig;

        public Builder() {
            this(MutableOptionsBundle.create());
        }

        @NonNull
        public static Builder fromConfig(@NonNull VideoCaptureConfig videoCaptureConfig) {
            return new Builder(MutableOptionsBundle.from((Config) videoCaptureConfig));
        }

        @Override // androidx.camera.core.ExtendableBuilder
        @NonNull
        public MutableConfig getMutableConfig() {
            return this.mMutableConfig;
        }

        @NonNull
        public Builder setAudioBitRate(int i2) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_AUDIO_BIT_RATE, Integer.valueOf(i2));
            return this;
        }

        @NonNull
        public Builder setAudioChannelCount(int i2) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_AUDIO_CHANNEL_COUNT, Integer.valueOf(i2));
            return this;
        }

        @NonNull
        public Builder setAudioMinBufferSize(int i2) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_AUDIO_MIN_BUFFER_SIZE, Integer.valueOf(i2));
            return this;
        }

        @NonNull
        public Builder setAudioRecordSource(int i2) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_AUDIO_RECORD_SOURCE, Integer.valueOf(i2));
            return this;
        }

        @NonNull
        public Builder setAudioSampleRate(int i2) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_AUDIO_SAMPLE_RATE, Integer.valueOf(i2));
            return this;
        }

        @NonNull
        public Builder setBitRate(int i2) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_BIT_RATE, Integer.valueOf(i2));
            return this;
        }

        @NonNull
        public Builder setIFrameInterval(int i2) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_INTRA_FRAME_INTERVAL, Integer.valueOf(i2));
            return this;
        }

        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        public /* bridge */ /* synthetic */ Builder setSupportedResolutions(@NonNull List list) {
            return setSupportedResolutions((List<Pair<Integer, Size[]>>) list);
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        @NonNull
        public /* bridge */ /* synthetic */ Object setTargetClass(@NonNull Class cls) {
            return setTargetClass((Class<VideoCapture>) cls);
        }

        @NonNull
        public Builder setVideoFrameRate(int i2) {
            getMutableConfig().insertOption(VideoCaptureConfig.OPTION_VIDEO_FRAME_RATE, Integer.valueOf(i2));
            return this;
        }

        private Builder(MutableOptionsBundle mutableOptionsBundle) {
            this.mMutableConfig = mutableOptionsBundle;
            Class cls = (Class) mutableOptionsBundle.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
            if (cls == null || cls.equals(VideoCapture.class)) {
                setTargetClass(VideoCapture.class);
                return;
            }
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
        }

        @Override // androidx.camera.core.ExtendableBuilder
        @NonNull
        public VideoCapture build() {
            if (getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO, null) == null || getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, null) == null) {
                return new VideoCapture(getUseCaseConfig());
            }
            throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        public VideoCaptureConfig getUseCaseConfig() {
            return new VideoCaptureConfig(OptionsBundle.from(this.mMutableConfig));
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
        public Builder setCaptureOptionUnpacker(@NonNull CaptureConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        public Builder setDefaultCaptureConfig(@NonNull CaptureConfig captureConfig) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, captureConfig);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        public Builder setDefaultResolution(@NonNull Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION, size);
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        public Builder setDefaultSessionConfig(@NonNull SessionConfig sessionConfig) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, sessionConfig);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        public Builder setMaxResolution(@NonNull Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, size);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        public Builder setSessionOptionUnpacker(@NonNull SessionConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.ImageOutputConfig.Builder
        @NonNull
        public Builder setSupportedResolutions(@NonNull List<Pair<Integer, Size[]>> list) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, list);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
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
        public Builder setTargetAspectRatioCustom(@NonNull Rational rational) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO_CUSTOM, rational);
            getMutableConfig().removeOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO);
            return this;
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        @NonNull
        public Builder setTargetClass(@NonNull Class<VideoCapture> cls) {
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
        public Builder setUseCaseEventCallback(@NonNull UseCase.EventCallback eventCallback) {
            getMutableConfig().insertOption(UseCaseEventConfig.OPTION_USE_CASE_EVENT_CALLBACK, eventCallback);
            return this;
        }
    }

    VideoCaptureConfig(OptionsBundle optionsBundle) {
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

    public int getAudioBitRate(int i2) {
        return ((Integer) retrieveOption(OPTION_AUDIO_BIT_RATE, Integer.valueOf(i2))).intValue();
    }

    public int getAudioChannelCount(int i2) {
        return ((Integer) retrieveOption(OPTION_AUDIO_CHANNEL_COUNT, Integer.valueOf(i2))).intValue();
    }

    public int getAudioMinBufferSize(int i2) {
        return ((Integer) retrieveOption(OPTION_AUDIO_MIN_BUFFER_SIZE, Integer.valueOf(i2))).intValue();
    }

    public int getAudioRecordSource(int i2) {
        return ((Integer) retrieveOption(OPTION_AUDIO_RECORD_SOURCE, Integer.valueOf(i2))).intValue();
    }

    public int getAudioSampleRate(int i2) {
        return ((Integer) retrieveOption(OPTION_AUDIO_SAMPLE_RATE, Integer.valueOf(i2))).intValue();
    }

    @Override // androidx.camera.core.internal.ThreadConfig
    @Nullable
    public Executor getBackgroundExecutor(@Nullable Executor executor) {
        return (Executor) retrieveOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR, executor);
    }

    public int getBitRate(int i2) {
        return ((Integer) retrieveOption(OPTION_BIT_RATE, Integer.valueOf(i2))).intValue();
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

    public int getIFrameInterval(int i2) {
        return ((Integer) retrieveOption(OPTION_INTRA_FRAME_INTERVAL, Integer.valueOf(i2))).intValue();
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
    public Class<VideoCapture> getTargetClass(@Nullable Class<VideoCapture> cls) {
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

    public int getVideoFrameRate(int i2) {
        return ((Integer) retrieveOption(OPTION_VIDEO_FRAME_RATE, Integer.valueOf(i2))).intValue();
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

    public int getAudioBitRate() {
        return ((Integer) retrieveOption(OPTION_AUDIO_BIT_RATE)).intValue();
    }

    public int getAudioChannelCount() {
        return ((Integer) retrieveOption(OPTION_AUDIO_CHANNEL_COUNT)).intValue();
    }

    public int getAudioMinBufferSize() {
        return ((Integer) retrieveOption(OPTION_AUDIO_MIN_BUFFER_SIZE)).intValue();
    }

    public int getAudioRecordSource() {
        return ((Integer) retrieveOption(OPTION_AUDIO_RECORD_SOURCE)).intValue();
    }

    public int getAudioSampleRate() {
        return ((Integer) retrieveOption(OPTION_AUDIO_SAMPLE_RATE)).intValue();
    }

    @Override // androidx.camera.core.internal.ThreadConfig
    @NonNull
    public Executor getBackgroundExecutor() {
        return (Executor) retrieveOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR);
    }

    public int getBitRate() {
        return ((Integer) retrieveOption(OPTION_BIT_RATE)).intValue();
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

    public int getIFrameInterval() {
        return ((Integer) retrieveOption(OPTION_INTRA_FRAME_INTERVAL)).intValue();
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

    public int getVideoFrameRate() {
        return ((Integer) retrieveOption(OPTION_VIDEO_FRAME_RATE)).intValue();
    }

    @Override // androidx.camera.core.impl.Config
    @Nullable
    public <ValueT> ValueT retrieveOption(@NonNull Config.Option<ValueT> option, @Nullable ValueT valuet) {
        return (ValueT) this.mConfig.retrieveOption(option, valuet);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    @NonNull
    public Class<VideoCapture> getTargetClass() {
        return (Class) retrieveOption(TargetConfig.OPTION_TARGET_CLASS);
    }
}
