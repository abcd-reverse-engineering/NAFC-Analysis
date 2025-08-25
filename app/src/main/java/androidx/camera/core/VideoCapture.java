package androidx.camera.core;

import android.location.Location;
import android.media.AudioRecord;
import android.media.CamcorderProfile;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.VideoCaptureConfig;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.utils.UseCaseConfigUtil;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class VideoCapture extends UseCase {
    private static final String AUDIO_MIME_TYPE = "audio/mp4a-latm";
    private static final int DEQUE_TIMEOUT_USEC = 10000;
    public static final int ERROR_ENCODER = 1;
    public static final int ERROR_MUXER = 2;
    public static final int ERROR_RECORDING_IN_PROGRESS = 3;
    public static final int ERROR_UNKNOWN = 0;
    private static final String TAG = "VideoCapture";
    private static final String VIDEO_MIME_TYPE = "video/avc";
    private int mAudioBitRate;
    private final MediaCodec.BufferInfo mAudioBufferInfo;
    private int mAudioBufferSize;
    private int mAudioChannelCount;

    @NonNull
    private MediaCodec mAudioEncoder;
    private final Handler mAudioHandler;
    private final HandlerThread mAudioHandlerThread;

    @NonNull
    private AudioRecord mAudioRecorder;
    private int mAudioSampleRate;
    private int mAudioTrackIndex;
    Surface mCameraSurface;
    private DeferrableSurface mDeferrableSurface;
    private final AtomicBoolean mEndOfAudioStreamSignal;
    private final AtomicBoolean mEndOfAudioVideoSignal;
    private final AtomicBoolean mEndOfVideoStreamSignal;
    private final AtomicBoolean mIsFirstAudioSampleWrite;
    private final AtomicBoolean mIsFirstVideoSampleWrite;
    private boolean mIsRecording;

    @GuardedBy("mMuxerLock")
    private MediaMuxer mMuxer;
    private final Object mMuxerLock;
    private boolean mMuxerStarted;
    private final MediaCodec.BufferInfo mVideoBufferInfo;

    @NonNull
    MediaCodec mVideoEncoder;
    private final Handler mVideoHandler;
    private final HandlerThread mVideoHandlerThread;
    private int mVideoTrackIndex;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Defaults DEFAULT_CONFIG = new Defaults();
    private static final Metadata EMPTY_METADATA = new Metadata();
    private static final int[] CamcorderQuality = {8, 6, 5, 4};
    private static final short[] sAudioEncoding = {2, 3, 4};

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Defaults implements ConfigProvider<VideoCaptureConfig> {
        private static final int DEFAULT_AUDIO_CHANNEL_COUNT = 1;
        private static final int DEFAULT_AUDIO_MIN_BUFFER_SIZE = 1024;
        private static final int DEFAULT_AUDIO_RECORD_SOURCE = 1;
        private static final int DEFAULT_AUDIO_SAMPLE_RATE = 8000;
        private static final int DEFAULT_BIT_RATE = 8388608;
        private static final int DEFAULT_INTRA_FRAME_INTERVAL = 1;
        private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 3;
        private static final int DEFAULT_VIDEO_FRAME_RATE = 30;
        private static final Size DEFAULT_MAX_RESOLUTION = new Size(1920, 1080);
        private static final int DEFAULT_AUDIO_BIT_RATE = 64000;
        private static final VideoCaptureConfig DEFAULT_CONFIG = new VideoCaptureConfig.Builder().setVideoFrameRate(30).setBitRate(8388608).setIFrameInterval(1).setAudioBitRate(DEFAULT_AUDIO_BIT_RATE).setAudioSampleRate(8000).setAudioChannelCount(1).setAudioRecordSource(1).setAudioMinBufferSize(1024).setMaxResolution(DEFAULT_MAX_RESOLUTION).setSurfaceOccupancyPriority(3).getUseCaseConfig();

        @Override // androidx.camera.core.impl.ConfigProvider
        @NonNull
        public VideoCaptureConfig getConfig(@Nullable CameraInfo cameraInfo) {
            return DEFAULT_CONFIG;
        }
    }

    public static final class Metadata {

        @Nullable
        public Location location;
    }

    public interface OnVideoSavedCallback {
        void onError(int i2, @NonNull String str, @Nullable Throwable th);

        void onVideoSaved(@NonNull File file);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface VideoCaptureError {
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class VideoSavedListenerWrapper implements OnVideoSavedCallback {

        @NonNull
        Executor mExecutor;

        @NonNull
        OnVideoSavedCallback mOnVideoSavedCallback;

        VideoSavedListenerWrapper(@NonNull Executor executor, @NonNull OnVideoSavedCallback onVideoSavedCallback) {
            this.mExecutor = executor;
            this.mOnVideoSavedCallback = onVideoSavedCallback;
        }

        public /* synthetic */ void a(File file) {
            this.mOnVideoSavedCallback.onVideoSaved(file);
        }

        @Override // androidx.camera.core.VideoCapture.OnVideoSavedCallback
        public void onError(final int i2, @NonNull final String str, @Nullable final Throwable th) {
            try {
                this.mExecutor.execute(new Runnable() { // from class: androidx.camera.core.o0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f1527a.a(i2, str, th);
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // androidx.camera.core.VideoCapture.OnVideoSavedCallback
        public void onVideoSaved(@NonNull final File file) {
            try {
                this.mExecutor.execute(new Runnable() { // from class: androidx.camera.core.p0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f1533a.a(file);
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        public /* synthetic */ void a(int i2, String str, Throwable th) {
            this.mOnVideoSavedCallback.onError(i2, str, th);
        }
    }

    public VideoCapture(VideoCaptureConfig videoCaptureConfig) {
        super(videoCaptureConfig);
        this.mVideoBufferInfo = new MediaCodec.BufferInfo();
        this.mMuxerLock = new Object();
        this.mVideoHandlerThread = new HandlerThread("CameraX-video encoding thread");
        this.mAudioHandlerThread = new HandlerThread("CameraX-audio encoding thread");
        this.mEndOfVideoStreamSignal = new AtomicBoolean(true);
        this.mEndOfAudioStreamSignal = new AtomicBoolean(true);
        this.mEndOfAudioVideoSignal = new AtomicBoolean(true);
        this.mAudioBufferInfo = new MediaCodec.BufferInfo();
        this.mIsFirstVideoSampleWrite = new AtomicBoolean(false);
        this.mIsFirstAudioSampleWrite = new AtomicBoolean(false);
        this.mMuxerStarted = false;
        this.mIsRecording = false;
        this.mVideoHandlerThread.start();
        this.mVideoHandler = new Handler(this.mVideoHandlerThread.getLooper());
        this.mAudioHandlerThread.start();
        this.mAudioHandler = new Handler(this.mAudioHandlerThread.getLooper());
    }

    static /* synthetic */ void a(boolean z, MediaCodec mediaCodec) {
        if (!z || mediaCodec == null) {
            return;
        }
        mediaCodec.release();
    }

    private AudioRecord autoConfigAudioRecordSource(VideoCaptureConfig videoCaptureConfig) {
        int i2;
        AudioRecord audioRecord;
        for (short s : sAudioEncoding) {
            int i3 = this.mAudioChannelCount == 1 ? 16 : 12;
            int audioRecordSource = videoCaptureConfig.getAudioRecordSource();
            try {
                int minBufferSize = AudioRecord.getMinBufferSize(this.mAudioSampleRate, i3, s);
                if (minBufferSize <= 0) {
                    minBufferSize = videoCaptureConfig.getAudioMinBufferSize();
                }
                i2 = minBufferSize;
                audioRecord = new AudioRecord(audioRecordSource, this.mAudioSampleRate, i3, s, i2 * 2);
            } catch (Exception unused) {
            }
            if (audioRecord.getState() == 1) {
                this.mAudioBufferSize = i2;
                String str = "source: " + audioRecordSource + " audioSampleRate: " + this.mAudioSampleRate + " channelConfig: " + i3 + " audioFormat: " + ((int) s) + " bufferSize: " + i2;
                return audioRecord;
            }
            continue;
        }
        return null;
    }

    private MediaFormat createAudioMediaFormat() {
        MediaFormat mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat(AUDIO_MIME_TYPE, this.mAudioSampleRate, this.mAudioChannelCount);
        mediaFormatCreateAudioFormat.setInteger("aac-profile", 2);
        mediaFormatCreateAudioFormat.setInteger("bitrate", this.mAudioBitRate);
        return mediaFormatCreateAudioFormat;
    }

    private static MediaFormat createMediaFormat(VideoCaptureConfig videoCaptureConfig, Size size) {
        MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(VIDEO_MIME_TYPE, size.getWidth(), size.getHeight());
        mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
        mediaFormatCreateVideoFormat.setInteger("bitrate", videoCaptureConfig.getBitRate());
        mediaFormatCreateVideoFormat.setInteger("frame-rate", videoCaptureConfig.getVideoFrameRate());
        mediaFormatCreateVideoFormat.setInteger("i-frame-interval", videoCaptureConfig.getIFrameInterval());
        return mediaFormatCreateVideoFormat;
    }

    private ByteBuffer getInputBuffer(MediaCodec mediaCodec, int i2) {
        return mediaCodec.getInputBuffer(i2);
    }

    private ByteBuffer getOutputBuffer(MediaCodec mediaCodec, int i2) {
        return mediaCodec.getOutputBuffer(i2);
    }

    private void releaseCameraSurface(final boolean z) {
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface == null) {
            return;
        }
        final MediaCodec mediaCodec = this.mVideoEncoder;
        deferrableSurface.close();
        this.mDeferrableSurface.getTerminationFuture().addListener(new Runnable() { // from class: androidx.camera.core.q0
            @Override // java.lang.Runnable
            public final void run() {
                VideoCapture.a(z, mediaCodec);
            }
        }, CameraXExecutors.mainThreadExecutor());
        if (z) {
            this.mVideoEncoder = null;
        }
        this.mCameraSurface = null;
        this.mDeferrableSurface = null;
    }

    private void setAudioParametersByCamcorderProfile(Size size, String str) {
        int[] iArr = CamcorderQuality;
        int length = iArr.length;
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            int i3 = iArr[i2];
            if (CamcorderProfile.hasProfile(Integer.parseInt(str), i3)) {
                CamcorderProfile camcorderProfile = CamcorderProfile.get(Integer.parseInt(str), i3);
                if (size.getWidth() == camcorderProfile.videoFrameWidth && size.getHeight() == camcorderProfile.videoFrameHeight) {
                    this.mAudioChannelCount = camcorderProfile.audioChannels;
                    this.mAudioSampleRate = camcorderProfile.audioSampleRate;
                    this.mAudioBitRate = camcorderProfile.audioBitRate;
                    z = true;
                    break;
                }
            }
            i2++;
        }
        if (z) {
            return;
        }
        VideoCaptureConfig videoCaptureConfig = (VideoCaptureConfig) getUseCaseConfig();
        this.mAudioChannelCount = videoCaptureConfig.getAudioChannelCount();
        this.mAudioSampleRate = videoCaptureConfig.getAudioSampleRate();
        this.mAudioBitRate = videoCaptureConfig.getAudioBitRate();
    }

    private boolean writeAudioEncodedBuffer(int i2) {
        ByteBuffer outputBuffer = getOutputBuffer(this.mAudioEncoder, i2);
        outputBuffer.position(this.mAudioBufferInfo.offset);
        if (this.mAudioTrackIndex >= 0 && this.mVideoTrackIndex >= 0) {
            MediaCodec.BufferInfo bufferInfo = this.mAudioBufferInfo;
            if (bufferInfo.size > 0 && bufferInfo.presentationTimeUs > 0) {
                try {
                    synchronized (this.mMuxerLock) {
                        if (!this.mIsFirstAudioSampleWrite.get()) {
                            this.mIsFirstAudioSampleWrite.set(true);
                        }
                        this.mMuxer.writeSampleData(this.mAudioTrackIndex, outputBuffer, this.mAudioBufferInfo);
                    }
                } catch (Exception e2) {
                    String str = "audio error:size=" + this.mAudioBufferInfo.size + "/offset=" + this.mAudioBufferInfo.offset + "/timeUs=" + this.mAudioBufferInfo.presentationTimeUs;
                    e2.printStackTrace();
                }
            }
        }
        this.mAudioEncoder.releaseOutputBuffer(i2, false);
        return (this.mAudioBufferInfo.flags & 4) != 0;
    }

    private boolean writeVideoEncodedBuffer(int i2) {
        if (i2 < 0) {
            String str = "Output buffer should not have negative index: " + i2;
            return false;
        }
        ByteBuffer outputBuffer = this.mVideoEncoder.getOutputBuffer(i2);
        if (outputBuffer == null) {
            return false;
        }
        if (this.mAudioTrackIndex >= 0 && this.mVideoTrackIndex >= 0) {
            MediaCodec.BufferInfo bufferInfo = this.mVideoBufferInfo;
            if (bufferInfo.size > 0) {
                outputBuffer.position(bufferInfo.offset);
                MediaCodec.BufferInfo bufferInfo2 = this.mVideoBufferInfo;
                outputBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                this.mVideoBufferInfo.presentationTimeUs = System.nanoTime() / 1000;
                synchronized (this.mMuxerLock) {
                    if (!this.mIsFirstVideoSampleWrite.get()) {
                        this.mIsFirstVideoSampleWrite.set(true);
                    }
                    this.mMuxer.writeSampleData(this.mVideoTrackIndex, outputBuffer, this.mVideoBufferInfo);
                }
            }
        }
        this.mVideoEncoder.releaseOutputBuffer(i2, false);
        return (this.mVideoBufferInfo.flags & 4) != 0;
    }

    boolean audioEncode(OnVideoSavedCallback onVideoSavedCallback) throws IllegalStateException, MediaCodec.CryptoException {
        boolean zWriteAudioEncodedBuffer = false;
        while (!zWriteAudioEncodedBuffer && this.mIsRecording) {
            if (this.mEndOfAudioStreamSignal.get()) {
                this.mEndOfAudioStreamSignal.set(false);
                this.mIsRecording = false;
            }
            MediaCodec mediaCodec = this.mAudioEncoder;
            if (mediaCodec != null && this.mAudioRecorder != null) {
                int iDequeueInputBuffer = mediaCodec.dequeueInputBuffer(-1L);
                if (iDequeueInputBuffer >= 0) {
                    ByteBuffer inputBuffer = getInputBuffer(this.mAudioEncoder, iDequeueInputBuffer);
                    inputBuffer.clear();
                    int i2 = this.mAudioRecorder.read(inputBuffer, this.mAudioBufferSize);
                    if (i2 > 0) {
                        this.mAudioEncoder.queueInputBuffer(iDequeueInputBuffer, 0, i2, System.nanoTime() / 1000, this.mIsRecording ? 0 : 4);
                    }
                }
                do {
                    int iDequeueOutputBuffer = this.mAudioEncoder.dequeueOutputBuffer(this.mAudioBufferInfo, 0L);
                    if (iDequeueOutputBuffer == -2) {
                        synchronized (this.mMuxerLock) {
                            this.mAudioTrackIndex = this.mMuxer.addTrack(this.mAudioEncoder.getOutputFormat());
                            if (this.mAudioTrackIndex >= 0 && this.mVideoTrackIndex >= 0) {
                                this.mMuxerStarted = true;
                                this.mMuxer.start();
                            }
                        }
                    } else if (iDequeueOutputBuffer != -1) {
                        zWriteAudioEncodedBuffer = writeAudioEncodedBuffer(iDequeueOutputBuffer);
                    }
                    if (iDequeueOutputBuffer >= 0) {
                    }
                } while (!zWriteAudioEncodedBuffer);
            }
        }
        try {
            this.mAudioRecorder.stop();
        } catch (IllegalStateException e2) {
            onVideoSavedCallback.onError(1, "Audio recorder stop failed!", e2);
        }
        try {
            this.mAudioEncoder.stop();
        } catch (IllegalStateException e3) {
            onVideoSavedCallback.onError(1, "Audio encoder stop failed!", e3);
        }
        this.mEndOfVideoStreamSignal.set(true);
        return false;
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void clear() {
        this.mVideoHandlerThread.quitSafely();
        this.mAudioHandlerThread.quitSafely();
        MediaCodec mediaCodec = this.mAudioEncoder;
        if (mediaCodec != null) {
            mediaCodec.release();
            this.mAudioEncoder = null;
        }
        AudioRecord audioRecord = this.mAudioRecorder;
        if (audioRecord != null) {
            audioRecord.release();
            this.mAudioRecorder = null;
        }
        if (this.mCameraSurface != null) {
            releaseCameraSurface(true);
        }
        super.clear();
    }

    @Override // androidx.camera.core.UseCase
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected UseCaseConfig.Builder<?, ?, ?> getDefaultBuilder(@Nullable CameraInfo cameraInfo) {
        VideoCaptureConfig videoCaptureConfig = (VideoCaptureConfig) CameraX.getDefaultUseCaseConfig(VideoCaptureConfig.class, cameraInfo);
        if (videoCaptureConfig != null) {
            return VideoCaptureConfig.Builder.fromConfig(videoCaptureConfig);
        }
        return null;
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected Map<String, Size> onSuggestedResolutionUpdated(@NonNull Map<String, Size> map) {
        if (this.mCameraSurface != null) {
            this.mVideoEncoder.stop();
            this.mVideoEncoder.release();
            this.mAudioEncoder.stop();
            this.mAudioEncoder.release();
            releaseCameraSurface(false);
        }
        try {
            this.mVideoEncoder = MediaCodec.createEncoderByType(VIDEO_MIME_TYPE);
            this.mAudioEncoder = MediaCodec.createEncoderByType(AUDIO_MIME_TYPE);
            String boundCameraId = getBoundCameraId();
            Size size = map.get(boundCameraId);
            if (size != null) {
                setupEncoder(boundCameraId, size);
                return map;
            }
            throw new IllegalArgumentException("Suggested resolution map missing resolution for camera " + boundCameraId);
        } catch (IOException e2) {
            throw new IllegalStateException("Unable to create MediaCodec due to: " + e2.getCause());
        }
    }

    public void setTargetRotation(int i2) {
        VideoCaptureConfig videoCaptureConfig = (VideoCaptureConfig) getUseCaseConfig();
        VideoCaptureConfig.Builder builderFromConfig = VideoCaptureConfig.Builder.fromConfig(videoCaptureConfig);
        int targetRotation = videoCaptureConfig.getTargetRotation(-1);
        if (targetRotation == -1 || targetRotation != i2) {
            UseCaseConfigUtil.updateTargetRotationAndRelatedConfigs(builderFromConfig, i2);
            updateUseCaseConfig(builderFromConfig.getUseCaseConfig());
        }
    }

    void setupEncoder(@NonNull final String str, @NonNull final Size size) {
        VideoCaptureConfig videoCaptureConfig = (VideoCaptureConfig) getUseCaseConfig();
        this.mVideoEncoder.reset();
        this.mVideoEncoder.configure(createMediaFormat(videoCaptureConfig, size), (Surface) null, (MediaCrypto) null, 1);
        if (this.mCameraSurface != null) {
            releaseCameraSurface(false);
        }
        final Surface surfaceCreateInputSurface = this.mVideoEncoder.createInputSurface();
        this.mCameraSurface = surfaceCreateInputSurface;
        SessionConfig.Builder builderCreateFrom = SessionConfig.Builder.createFrom(videoCaptureConfig);
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
        this.mDeferrableSurface = new ImmediateSurface(this.mCameraSurface);
        c.b.b.a.a.a<Void> terminationFuture = this.mDeferrableSurface.getTerminationFuture();
        surfaceCreateInputSurface.getClass();
        terminationFuture.addListener(new Runnable() { // from class: androidx.camera.core.s0
            @Override // java.lang.Runnable
            public final void run() {
                surfaceCreateInputSurface.release();
            }
        }, CameraXExecutors.mainThreadExecutor());
        builderCreateFrom.addSurface(this.mDeferrableSurface);
        builderCreateFrom.addErrorListener(new SessionConfig.ErrorListener() { // from class: androidx.camera.core.VideoCapture.3
            @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
            public void onError(@NonNull SessionConfig sessionConfig, @NonNull SessionConfig.SessionError sessionError) {
                if (VideoCapture.this.isCurrentlyBoundCamera(str)) {
                    VideoCapture.this.setupEncoder(str, size);
                }
            }
        });
        attachToCamera(str, builderCreateFrom.build());
        setAudioParametersByCamcorderProfile(size, str);
        this.mAudioEncoder.reset();
        this.mAudioEncoder.configure(createAudioMediaFormat(), (Surface) null, (MediaCrypto) null, 1);
        AudioRecord audioRecord = this.mAudioRecorder;
        if (audioRecord != null) {
            audioRecord.release();
        }
        this.mAudioRecorder = autoConfigAudioRecordSource(videoCaptureConfig);
        AudioRecord audioRecord2 = this.mAudioRecorder;
        this.mVideoTrackIndex = -1;
        this.mAudioTrackIndex = -1;
        this.mIsRecording = false;
    }

    public void startRecording(@NonNull File file, @NonNull Executor executor, @NonNull OnVideoSavedCallback onVideoSavedCallback) throws IllegalStateException {
        this.mIsFirstVideoSampleWrite.set(false);
        this.mIsFirstAudioSampleWrite.set(false);
        startRecording(file, EMPTY_METADATA, executor, onVideoSavedCallback);
    }

    public void stopRecording() {
        notifyInactive();
        if (this.mEndOfAudioVideoSignal.get() || !this.mIsRecording) {
            return;
        }
        this.mEndOfAudioStreamSignal.set(true);
    }

    boolean videoEncode(@NonNull OnVideoSavedCallback onVideoSavedCallback, @NonNull String str, @NonNull Size size) {
        boolean zWriteVideoEncodedBuffer = false;
        boolean z = false;
        while (!zWriteVideoEncodedBuffer && !z) {
            if (this.mEndOfVideoStreamSignal.get()) {
                this.mVideoEncoder.signalEndOfInputStream();
                this.mEndOfVideoStreamSignal.set(false);
            }
            int iDequeueOutputBuffer = this.mVideoEncoder.dequeueOutputBuffer(this.mVideoBufferInfo, com.heytap.mcssdk.constant.a.q);
            if (iDequeueOutputBuffer != -2) {
                zWriteVideoEncodedBuffer = writeVideoEncodedBuffer(iDequeueOutputBuffer);
            } else {
                if (this.mMuxerStarted) {
                    onVideoSavedCallback.onError(1, "Unexpected change in video encoding format.", null);
                    z = true;
                }
                synchronized (this.mMuxerLock) {
                    this.mVideoTrackIndex = this.mMuxer.addTrack(this.mVideoEncoder.getOutputFormat());
                    if (this.mAudioTrackIndex >= 0 && this.mVideoTrackIndex >= 0) {
                        this.mMuxerStarted = true;
                        this.mMuxer.start();
                    }
                }
            }
        }
        try {
            this.mVideoEncoder.stop();
        } catch (IllegalStateException e2) {
            onVideoSavedCallback.onError(1, "Video encoder stop failed!", e2);
            z = true;
        }
        try {
            synchronized (this.mMuxerLock) {
                if (this.mMuxer != null) {
                    if (this.mMuxerStarted) {
                        this.mMuxer.stop();
                    }
                    this.mMuxer.release();
                    this.mMuxer = null;
                }
            }
        } catch (IllegalStateException e3) {
            onVideoSavedCallback.onError(2, "Muxer stop failed!", e3);
            z = true;
        }
        this.mMuxerStarted = false;
        setupEncoder(str, size);
        notifyReset();
        this.mEndOfAudioVideoSignal.set(true);
        return z;
    }

    public void startRecording(@NonNull final File file, @NonNull Metadata metadata, @NonNull Executor executor, @NonNull OnVideoSavedCallback onVideoSavedCallback) throws IllegalStateException {
        final VideoSavedListenerWrapper videoSavedListenerWrapper = new VideoSavedListenerWrapper(executor, onVideoSavedCallback);
        if (!this.mEndOfAudioVideoSignal.get()) {
            videoSavedListenerWrapper.onError(3, "It is still in video recording!", null);
            return;
        }
        try {
            this.mAudioRecorder.startRecording();
            CameraInternal boundCamera = getBoundCamera();
            final String boundCameraId = getBoundCameraId();
            final Size attachedSurfaceResolution = getAttachedSurfaceResolution(boundCameraId);
            try {
                this.mVideoEncoder.start();
                this.mAudioEncoder.start();
                int sensorRotationDegrees = boundCamera.getCameraInfoInternal().getSensorRotationDegrees(((ImageOutputConfig) getUseCaseConfig()).getTargetRotation(0));
                try {
                    synchronized (this.mMuxerLock) {
                        this.mMuxer = new MediaMuxer(file.getAbsolutePath(), 0);
                        this.mMuxer.setOrientationHint(sensorRotationDegrees);
                        if (metadata.location != null) {
                            this.mMuxer.setLocation((float) metadata.location.getLatitude(), (float) metadata.location.getLongitude());
                        }
                    }
                    this.mEndOfVideoStreamSignal.set(false);
                    this.mEndOfAudioStreamSignal.set(false);
                    this.mEndOfAudioVideoSignal.set(false);
                    this.mIsRecording = true;
                    notifyActive();
                    this.mAudioHandler.post(new Runnable() { // from class: androidx.camera.core.VideoCapture.1
                        @Override // java.lang.Runnable
                        public void run() throws IllegalStateException, MediaCodec.CryptoException {
                            VideoCapture.this.audioEncode(videoSavedListenerWrapper);
                        }
                    });
                    this.mVideoHandler.post(new Runnable() { // from class: androidx.camera.core.VideoCapture.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoCapture.this.videoEncode(videoSavedListenerWrapper, boundCameraId, attachedSurfaceResolution)) {
                                return;
                            }
                            videoSavedListenerWrapper.onVideoSaved(file);
                        }
                    });
                } catch (IOException e2) {
                    setupEncoder(boundCameraId, attachedSurfaceResolution);
                    videoSavedListenerWrapper.onError(2, "MediaMuxer creation failed!", e2);
                }
            } catch (IllegalStateException e3) {
                setupEncoder(boundCameraId, attachedSurfaceResolution);
                videoSavedListenerWrapper.onError(1, "Audio/Video encoder start fail", e3);
            }
        } catch (IllegalStateException e4) {
            videoSavedListenerWrapper.onError(1, "AudioRecorder start fail", e4);
        }
    }
}
