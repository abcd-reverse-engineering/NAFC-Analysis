package androidx.camera.core;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.location.Location;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.arch.core.util.Function;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageSaver;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageCaptureConfig;
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
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.IoConfig;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.UseCaseEventConfig;
import androidx.camera.core.internal.utils.UseCaseConfigUtil;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class ImageCapture extends UseCase {
    public static final int CAPTURE_MODE_MAXIMIZE_QUALITY = 0;
    public static final int CAPTURE_MODE_MINIMIZE_LATENCY = 1;
    private static final long CHECK_3A_TIMEOUT_IN_MS = 1000;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Defaults DEFAULT_CONFIG = new Defaults();
    public static final int ERROR_CAMERA_CLOSED = 3;
    public static final int ERROR_CAPTURE_FAILED = 2;
    public static final int ERROR_FILE_IO = 1;
    public static final int ERROR_INVALID_CAMERA = 4;
    public static final int ERROR_UNKNOWN = 0;
    public static final int FLASH_MODE_AUTO = 0;
    public static final int FLASH_MODE_OFF = 2;
    public static final int FLASH_MODE_ON = 1;
    private static final int MAX_IMAGES = 2;
    private static final String TAG = "ImageCapture";
    private final CaptureBundle mCaptureBundle;
    private final CaptureConfig mCaptureConfig;
    private final int mCaptureMode;
    private final CaptureProcessor mCaptureProcessor;
    private final ImageReaderProxy.OnImageAvailableListener mClosingListener;
    private ImageCaptureConfig mConfig;
    private DeferrableSurface mDeferrableSurface;
    private boolean mEnableCheck3AConverged;
    private final ExecutorService mExecutor;
    private int mFlashMode;
    ImageReaderProxy mImageReader;

    @NonNull
    final Executor mIoExecutor;
    private final int mMaxCaptureStages;
    private CameraCaptureCallback mMetadataMatchingCaptureCallback;
    final ForwardingImageProxy.OnImageCloseListener mOnImageCloseListener;
    final Deque<ImageCaptureRequest> mPendingImageCaptureRequests;
    private final CaptureCallbackChecker mSessionCallbackChecker;
    SessionConfig.Builder mSessionConfigBuilder;

    @NonNull
    final TakePictureLock mTakePictureLock;

    /* renamed from: androidx.camera.core.ImageCapture$4, reason: invalid class name */
    class AnonymousClass4 implements FutureCallback<Void> {
        final /* synthetic */ ImageCaptureRequest val$imageCaptureRequest;
        final /* synthetic */ TakePictureState val$state;

        AnonymousClass4(TakePictureState takePictureState, ImageCaptureRequest imageCaptureRequest) {
            this.val$state = takePictureState;
            this.val$imageCaptureRequest = imageCaptureRequest;
        }

        public /* synthetic */ void a(ImageCaptureRequest imageCaptureRequest, Throwable th) {
            imageCaptureRequest.notifyCallbackError(ImageCapture.getError(th), th != null ? th.getMessage() : "Unknown error", th);
            ImageCapture.this.mTakePictureLock.unlockTakePicture(imageCaptureRequest);
        }

        @Override // androidx.camera.core.impl.utils.futures.FutureCallback
        public void onFailure(final Throwable th) {
            ImageCapture.this.postTakePicture(this.val$state);
            ScheduledExecutorService scheduledExecutorServiceMainThreadExecutor = CameraXExecutors.mainThreadExecutor();
            final ImageCaptureRequest imageCaptureRequest = this.val$imageCaptureRequest;
            scheduledExecutorServiceMainThreadExecutor.execute(new Runnable() { // from class: androidx.camera.core.o
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1524a.a(imageCaptureRequest, th);
                }
            });
        }

        @Override // androidx.camera.core.impl.utils.futures.FutureCallback
        public void onSuccess(Void r2) {
            ImageCapture.this.postTakePicture(this.val$state);
        }
    }

    /* renamed from: androidx.camera.core.ImageCapture$5, reason: invalid class name */
    class AnonymousClass5 implements ForwardingImageProxy.OnImageCloseListener {
        AnonymousClass5() {
        }

        @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
        /* renamed from: onImageClose, reason: merged with bridge method [inline-methods] */
        public void a(final ImageProxy imageProxy) {
            if (Looper.getMainLooper() != Looper.myLooper()) {
                CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.core.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f1531a.a(imageProxy);
                    }
                });
            } else {
                ImageCapture.this.issueImageCaptureRequests();
            }
        }
    }

    /* renamed from: androidx.camera.core.ImageCapture$9, reason: invalid class name */
    static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$ImageSaver$SaveError = new int[ImageSaver.SaveError.values().length];

        static {
            try {
                $SwitchMap$androidx$camera$core$ImageSaver$SaveError[ImageSaver.SaveError.FILE_IO_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static final class Builder implements UseCaseConfig.Builder<ImageCapture, ImageCaptureConfig, Builder>, ImageOutputConfig.Builder<Builder>, IoConfig.Builder<Builder> {
        private final MutableOptionsBundle mMutableConfig;

        public Builder() {
            this(MutableOptionsBundle.create());
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static Builder fromConfig(@NonNull ImageCaptureConfig imageCaptureConfig) {
            return new Builder(MutableOptionsBundle.from((Config) imageCaptureConfig));
        }

        @Override // androidx.camera.core.ExtendableBuilder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public MutableConfig getMutableConfig() {
            return this.mMutableConfig;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setBufferFormat(int i2) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT, Integer.valueOf(i2));
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setCaptureBundle(@NonNull CaptureBundle captureBundle) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_CAPTURE_BUNDLE, captureBundle);
            return this;
        }

        @NonNull
        public Builder setCaptureMode(int i2) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE, Integer.valueOf(i2));
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setCaptureProcessor(@NonNull CaptureProcessor captureProcessor) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_CAPTURE_PROCESSOR, captureProcessor);
            return this;
        }

        @NonNull
        public Builder setFlashMode(int i2) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_FLASH_MODE, Integer.valueOf(i2));
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setMaxCaptureStages(int i2) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_MAX_CAPTURE_STAGES, Integer.valueOf(i2));
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
            return setTargetClass((Class<ImageCapture>) cls);
        }

        private Builder(MutableOptionsBundle mutableOptionsBundle) {
            this.mMutableConfig = mutableOptionsBundle;
            Class cls = (Class) mutableOptionsBundle.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
            if (cls == null || cls.equals(ImageCapture.class)) {
                setTargetClass(ImageCapture.class);
                return;
            }
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
        }

        @Override // androidx.camera.core.ExtendableBuilder
        @NonNull
        public ImageCapture build() {
            if (getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO, null) == null || getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, null) == null) {
                return new ImageCapture(getUseCaseConfig());
            }
            throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
        }

        @Override // androidx.camera.core.impl.UseCaseConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public ImageCaptureConfig getUseCaseConfig() {
            return new ImageCaptureConfig(OptionsBundle.from(this.mMutableConfig));
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
        @Override // androidx.camera.core.internal.IoConfig.Builder
        @NonNull
        public Builder setIoExecutor(@NonNull Executor executor) {
            getMutableConfig().insertOption(IoConfig.OPTION_IO_EXECUTOR, executor);
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
        public Builder setTargetClass(@NonNull Class<ImageCapture> cls) {
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

    static final class CaptureCallbackChecker extends CameraCaptureCallback {
        private static final long NO_TIMEOUT = 0;
        private final Set<CaptureResultListener> mCaptureResultListeners = new HashSet();

        public interface CaptureResultChecker<T> {
            @Nullable
            T check(@NonNull CameraCaptureResult cameraCaptureResult);
        }

        private interface CaptureResultListener {
            boolean onCaptureResult(@NonNull CameraCaptureResult cameraCaptureResult);
        }

        CaptureCallbackChecker() {
        }

        private void deliverCaptureResultToListeners(@NonNull CameraCaptureResult cameraCaptureResult) {
            synchronized (this.mCaptureResultListeners) {
                HashSet hashSet = null;
                Iterator it = new HashSet(this.mCaptureResultListeners).iterator();
                while (it.hasNext()) {
                    CaptureResultListener captureResultListener = (CaptureResultListener) it.next();
                    if (captureResultListener.onCaptureResult(cameraCaptureResult)) {
                        if (hashSet == null) {
                            hashSet = new HashSet();
                        }
                        hashSet.add(captureResultListener);
                    }
                }
                if (hashSet != null) {
                    this.mCaptureResultListeners.removeAll(hashSet);
                }
            }
        }

        public /* synthetic */ Object a(final CaptureResultChecker captureResultChecker, final long j2, final long j3, final Object obj, final CallbackToFutureAdapter.Completer completer) throws Exception {
            addListener(new CaptureResultListener() { // from class: androidx.camera.core.ImageCapture.CaptureCallbackChecker.1
                @Override // androidx.camera.core.ImageCapture.CaptureCallbackChecker.CaptureResultListener
                public boolean onCaptureResult(@NonNull CameraCaptureResult cameraCaptureResult) {
                    Object objCheck = captureResultChecker.check(cameraCaptureResult);
                    if (objCheck != null) {
                        completer.set(objCheck);
                        return true;
                    }
                    if (j2 <= 0 || SystemClock.elapsedRealtime() - j2 <= j3) {
                        return false;
                    }
                    completer.set(obj);
                    return true;
                }
            });
            return "checkCaptureResult";
        }

        void addListener(CaptureResultListener captureResultListener) {
            synchronized (this.mCaptureResultListeners) {
                this.mCaptureResultListeners.add(captureResultListener);
            }
        }

        <T> c.b.b.a.a.a<T> checkCaptureResult(CaptureResultChecker<T> captureResultChecker) {
            return checkCaptureResult(captureResultChecker, 0L, null);
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureCompleted(@NonNull CameraCaptureResult cameraCaptureResult) {
            deliverCaptureResultToListeners(cameraCaptureResult);
        }

        <T> c.b.b.a.a.a<T> checkCaptureResult(final CaptureResultChecker<T> captureResultChecker, final long j2, final T t) {
            if (j2 >= 0) {
                final long jElapsedRealtime = j2 != 0 ? SystemClock.elapsedRealtime() : 0L;
                return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.s
                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                        return this.f1543a.a(captureResultChecker, jElapsedRealtime, j2, t, completer);
                    }
                });
            }
            throw new IllegalArgumentException("Invalid timeout value: " + j2);
        }
    }

    static final class CaptureFailedException extends RuntimeException {
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        CaptureFailedException(String str, Throwable th) {
            super(str, th);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        CaptureFailedException(String str) {
            super(str);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface CaptureMode {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Defaults implements ConfigProvider<ImageCaptureConfig> {
        private static final int DEFAULT_CAPTURE_MODE = 1;
        private static final ImageCaptureConfig DEFAULT_CONFIG = new Builder().setCaptureMode(1).setFlashMode(2).setSurfaceOccupancyPriority(4).getUseCaseConfig();
        private static final int DEFAULT_FLASH_MODE = 2;
        private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 4;

        @Override // androidx.camera.core.impl.ConfigProvider
        @NonNull
        public ImageCaptureConfig getConfig(@Nullable CameraInfo cameraInfo) {
            return DEFAULT_CONFIG;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface FlashMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ImageCaptureError {
    }

    public static final class Metadata {
        private boolean mIsReversedHorizontal;
        private boolean mIsReversedVertical;

        @Nullable
        private Location mLocation;

        @Nullable
        public Location getLocation() {
            return this.mLocation;
        }

        public boolean isReversedHorizontal() {
            return this.mIsReversedHorizontal;
        }

        public boolean isReversedVertical() {
            return this.mIsReversedVertical;
        }

        public void setLocation(@Nullable Location location) {
            this.mLocation = location;
        }

        public void setReversedHorizontal(boolean z) {
            this.mIsReversedHorizontal = z;
        }

        public void setReversedVertical(boolean z) {
            this.mIsReversedVertical = z;
        }
    }

    public static abstract class OnImageCapturedCallback {
        public void onCaptureSuccess(@NonNull ImageProxy imageProxy) {
            imageProxy.close();
        }

        public void onError(@NonNull ImageCaptureException imageCaptureException) {
        }
    }

    public interface OnImageSavedCallback {
        void onError(@NonNull ImageCaptureException imageCaptureException);

        void onImageSaved(@NonNull OutputFileResults outputFileResults);
    }

    public static final class OutputFileOptions {
        private static final Metadata EMPTY_METADATA = new Metadata();

        @Nullable
        private final ContentResolver mContentResolver;

        @Nullable
        private final ContentValues mContentValues;

        @Nullable
        private final File mFile;

        @NonNull
        private final Metadata mMetadata;

        @Nullable
        private final OutputStream mOutputStream;

        @Nullable
        private final Uri mSaveCollection;

        OutputFileOptions(@Nullable File file, @Nullable ContentResolver contentResolver, @Nullable Uri uri, @Nullable ContentValues contentValues, @Nullable OutputStream outputStream, @Nullable Metadata metadata) {
            this.mFile = file;
            this.mContentResolver = contentResolver;
            this.mSaveCollection = uri;
            this.mContentValues = contentValues;
            this.mOutputStream = outputStream;
            this.mMetadata = metadata == null ? EMPTY_METADATA : metadata;
        }

        @Nullable
        ContentResolver getContentResolver() {
            return this.mContentResolver;
        }

        @Nullable
        ContentValues getContentValues() {
            return this.mContentValues;
        }

        @Nullable
        File getFile() {
            return this.mFile;
        }

        @NonNull
        Metadata getMetadata() {
            return this.mMetadata;
        }

        @Nullable
        OutputStream getOutputStream() {
            return this.mOutputStream;
        }

        @Nullable
        Uri getSaveCollection() {
            return this.mSaveCollection;
        }

        public static final class Builder {

            @Nullable
            private ContentResolver mContentResolver;

            @Nullable
            private ContentValues mContentValues;

            @Nullable
            private File mFile;

            @Nullable
            private Metadata mMetadata;

            @Nullable
            private OutputStream mOutputStream;

            @Nullable
            private Uri mSaveCollection;

            public Builder(@NonNull File file) {
                this.mFile = file;
            }

            @NonNull
            public OutputFileOptions build() {
                return new OutputFileOptions(this.mFile, this.mContentResolver, this.mSaveCollection, this.mContentValues, this.mOutputStream, this.mMetadata);
            }

            @NonNull
            public Builder setMetadata(@NonNull Metadata metadata) {
                this.mMetadata = metadata;
                return this;
            }

            public Builder(@NonNull ContentResolver contentResolver, @NonNull Uri uri, @NonNull ContentValues contentValues) {
                this.mContentResolver = contentResolver;
                this.mSaveCollection = uri;
                this.mContentValues = contentValues;
            }

            public Builder(@NonNull OutputStream outputStream) {
                this.mOutputStream = outputStream;
            }
        }
    }

    public static class OutputFileResults {

        @Nullable
        private Uri mSavedUri;

        OutputFileResults(@Nullable Uri uri) {
            this.mSavedUri = uri;
        }

        @Nullable
        public Uri getSavedUri() {
            return this.mSavedUri;
        }
    }

    private static class TakePictureLock implements ForwardingImageProxy.OnImageCloseListener {

        @GuardedBy("mLock")
        private final ImageCapture mImageCapture;
        private final int mMaxImages;

        @GuardedBy("mLock")
        private ImageCaptureRequest mCurrentRequest = null;

        @GuardedBy("mLock")
        private int mOutstandingImages = 0;
        private final Object mLock = new Object();

        TakePictureLock(int i2, ImageCapture imageCapture) {
            this.mMaxImages = i2;
            this.mImageCapture = imageCapture;
        }

        void cancelTakePicture(Throwable th) {
            synchronized (this.mLock) {
                if (this.mCurrentRequest != null) {
                    this.mCurrentRequest.notifyCallbackError(ImageCapture.getError(th), th.getMessage(), th);
                }
                this.mCurrentRequest = null;
            }
        }

        boolean lockTakePicture(ImageCaptureRequest imageCaptureRequest) {
            synchronized (this.mLock) {
                if (this.mOutstandingImages < this.mMaxImages && this.mCurrentRequest == null) {
                    this.mCurrentRequest = imageCaptureRequest;
                    return true;
                }
                return false;
            }
        }

        @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
        /* renamed from: onImageClose */
        public void a(ImageProxy imageProxy) {
            synchronized (this.mLock) {
                this.mOutstandingImages--;
                ScheduledExecutorService scheduledExecutorServiceMainThreadExecutor = CameraXExecutors.mainThreadExecutor();
                ImageCapture imageCapture = this.mImageCapture;
                imageCapture.getClass();
                scheduledExecutorServiceMainThreadExecutor.execute(new t0(imageCapture));
            }
        }

        @Nullable
        ImageProxy tryAcquireImage(ImageReaderProxy imageReaderProxy, ImageCaptureRequest imageCaptureRequest) {
            SingleCloseImageProxy singleCloseImageProxy;
            ImageProxy imageProxyAcquireLatestImage;
            synchronized (this.mLock) {
                if (this.mCurrentRequest != imageCaptureRequest) {
                    return null;
                }
                try {
                    imageProxyAcquireLatestImage = imageReaderProxy.acquireLatestImage();
                } catch (IllegalStateException unused) {
                }
                if (imageProxyAcquireLatestImage != null) {
                    singleCloseImageProxy = new SingleCloseImageProxy(imageProxyAcquireLatestImage);
                    try {
                        singleCloseImageProxy.addOnImageCloseListener(this);
                        this.mOutstandingImages++;
                    } catch (IllegalStateException unused2) {
                    }
                } else {
                    singleCloseImageProxy = null;
                }
                return singleCloseImageProxy;
            }
        }

        boolean unlockTakePicture(ImageCaptureRequest imageCaptureRequest) {
            synchronized (this.mLock) {
                if (this.mCurrentRequest != imageCaptureRequest) {
                    return false;
                }
                this.mCurrentRequest = null;
                ScheduledExecutorService scheduledExecutorServiceMainThreadExecutor = CameraXExecutors.mainThreadExecutor();
                ImageCapture imageCapture = this.mImageCapture;
                imageCapture.getClass();
                scheduledExecutorServiceMainThreadExecutor.execute(new t0(imageCapture));
                return true;
            }
        }
    }

    static final class TakePictureState {
        CameraCaptureResult mPreCaptureState = CameraCaptureResult.EmptyCameraCaptureResult.create();
        boolean mIsAfTriggered = false;
        boolean mIsAePrecaptureTriggered = false;
        boolean mIsFlashTriggered = false;

        TakePictureState() {
        }
    }

    ImageCapture(@NonNull ImageCaptureConfig imageCaptureConfig) {
        super(imageCaptureConfig);
        this.mTakePictureLock = new TakePictureLock(2, this);
        this.mPendingImageCaptureRequests = new ConcurrentLinkedDeque();
        this.mExecutor = Executors.newFixedThreadPool(1, new ThreadFactory() { // from class: androidx.camera.core.ImageCapture.1
            private final AtomicInteger mId = new AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(@NonNull Runnable runnable) {
                return new Thread(runnable, "CameraX-image_capture_" + this.mId.getAndIncrement());
            }
        });
        this.mSessionCallbackChecker = new CaptureCallbackChecker();
        this.mClosingListener = new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.core.m
            @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
            public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
                ImageCapture.a(imageReaderProxy);
            }
        };
        this.mOnImageCloseListener = new AnonymousClass5();
        this.mConfig = (ImageCaptureConfig) getUseCaseConfig();
        this.mCaptureMode = this.mConfig.getCaptureMode();
        this.mFlashMode = this.mConfig.getFlashMode();
        this.mCaptureProcessor = this.mConfig.getCaptureProcessor(null);
        this.mMaxCaptureStages = this.mConfig.getMaxCaptureStages(2);
        Preconditions.checkArgument(this.mMaxCaptureStages >= 1, "Maximum outstanding image count must be at least 1");
        Integer bufferFormat = this.mConfig.getBufferFormat(null);
        if (bufferFormat != null) {
            Preconditions.checkArgument(this.mCaptureProcessor == null, "Cannot set buffer format with CaptureProcessor defined.");
            setImageFormat(bufferFormat.intValue());
        } else if (this.mCaptureProcessor != null) {
            setImageFormat(35);
        } else {
            setImageFormat(ImageReaderFormatRecommender.chooseCombo().imageCaptureFormat());
        }
        this.mCaptureBundle = this.mConfig.getCaptureBundle(CaptureBundles.singleDefaultCaptureBundle());
        this.mIoExecutor = (Executor) Preconditions.checkNotNull(this.mConfig.getIoExecutor(CameraXExecutors.ioExecutor()));
        int i2 = this.mCaptureMode;
        if (i2 == 0) {
            this.mEnableCheck3AConverged = true;
        } else if (i2 == 1) {
            this.mEnableCheck3AConverged = false;
        }
        this.mCaptureConfig = CaptureConfig.Builder.createFrom(this.mConfig).build();
    }

    static /* synthetic */ Void a(Boolean bool) {
        return null;
    }

    static /* synthetic */ Void a(List list) {
        return null;
    }

    static /* synthetic */ void a(ImageReaderProxy imageReaderProxy) {
        try {
            ImageProxy imageProxyAcquireLatestImage = imageReaderProxy.acquireLatestImage();
            try {
                String str = "Discarding ImageProxy which was inadvertently acquired: " + imageProxyAcquireLatestImage;
                if (imageProxyAcquireLatestImage != null) {
                    imageProxyAcquireLatestImage.close();
                }
            } finally {
            }
        } catch (IllegalStateException unused) {
        }
    }

    private void abortImageCaptureRequests() {
        CameraClosedException cameraClosedException = new CameraClosedException("Camera is closed.");
        Iterator<ImageCaptureRequest> it = this.mPendingImageCaptureRequests.iterator();
        while (it.hasNext()) {
            it.next().notifyCallbackError(getError(cameraClosedException), cameraClosedException.getMessage(), cameraClosedException);
        }
        this.mPendingImageCaptureRequests.clear();
        this.mTakePictureLock.cancelTakePicture(cameraClosedException);
    }

    private CaptureBundle getCaptureBundle(CaptureBundle captureBundle) {
        List<CaptureStage> captureStages = this.mCaptureBundle.getCaptureStages();
        return (captureStages == null || captureStages.isEmpty()) ? captureBundle : CaptureBundles.createCaptureBundle(captureStages);
    }

    private CameraControlInternal getCurrentCameraControl() {
        return getCameraControl(getBoundCameraId());
    }

    static int getError(Throwable th) {
        if (th instanceof CameraClosedException) {
            return 3;
        }
        return th instanceof CaptureFailedException ? 2 : 0;
    }

    private c.b.b.a.a.a<CameraCaptureResult> getPreCaptureStateIfNeeded() {
        return (this.mEnableCheck3AConverged || getFlashMode() == 0) ? this.mSessionCallbackChecker.checkCaptureResult(new CaptureCallbackChecker.CaptureResultChecker<CameraCaptureResult>() { // from class: androidx.camera.core.ImageCapture.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.camera.core.ImageCapture.CaptureCallbackChecker.CaptureResultChecker
            public CameraCaptureResult check(@NonNull CameraCaptureResult cameraCaptureResult) {
                return cameraCaptureResult;
            }
        }) : Futures.immediateFuture(null);
    }

    private c.b.b.a.a.a<Void> preTakePicture(final TakePictureState takePictureState) {
        return FutureChain.from(getPreCaptureStateIfNeeded()).transformAsync(new AsyncFunction() { // from class: androidx.camera.core.a0
            @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
            public final c.b.b.a.a.a apply(Object obj) {
                return this.f1445a.a(takePictureState, (CameraCaptureResult) obj);
            }
        }, this.mExecutor).transform(new Function() { // from class: androidx.camera.core.r
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return ImageCapture.a((Boolean) obj);
            }
        }, this.mExecutor);
    }

    @UiThread
    private void sendImageCaptureRequest(@Nullable Executor executor, OnImageCapturedCallback onImageCapturedCallback) {
        CameraInternal boundCamera = getBoundCamera();
        if (boundCamera != null) {
            int sensorRotationDegrees = boundCamera.getCameraInfoInternal().getSensorRotationDegrees(this.mConfig.getTargetRotation(0));
            this.mPendingImageCaptureRequests.offer(new ImageCaptureRequest(sensorRotationDegrees, ImageUtil.rotate(this.mConfig.getTargetAspectRatioCustom(null), sensorRotationDegrees), executor, onImageCapturedCallback));
            issueImageCaptureRequests();
            return;
        }
        onImageCapturedCallback.onError(new ImageCaptureException(4, "Not bound to a valid Camera [" + this + "]", null));
    }

    private boolean takePictureInternal(@NonNull final ImageCaptureRequest imageCaptureRequest) {
        if (!this.mTakePictureLock.lockTakePicture(imageCaptureRequest)) {
            return false;
        }
        this.mImageReader.setOnImageAvailableListener(new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.core.y
            @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
            public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
                this.f1564a.a(imageCaptureRequest, imageReaderProxy);
            }
        }, CameraXExecutors.mainThreadExecutor());
        TakePictureState takePictureState = new TakePictureState();
        FutureChain.from(preTakePicture(takePictureState)).transformAsync(new AsyncFunction() { // from class: androidx.camera.core.u
            @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
            public final c.b.b.a.a.a apply(Object obj) {
                return this.f1552a.a(imageCaptureRequest, (Void) obj);
            }
        }, this.mExecutor).addCallback(new AnonymousClass4(takePictureState, imageCaptureRequest), this.mExecutor);
        return true;
    }

    private void triggerAf(TakePictureState takePictureState) {
        takePictureState.mIsAfTriggered = true;
        getCurrentCameraControl().triggerAf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cancelAfAeTrigger, reason: merged with bridge method [inline-methods] */
    public void a(TakePictureState takePictureState) {
        if (takePictureState.mIsAfTriggered || takePictureState.mIsAePrecaptureTriggered) {
            getCurrentCameraControl().cancelAfAeTrigger(takePictureState.mIsAfTriggered, takePictureState.mIsAePrecaptureTriggered);
            takePictureState.mIsAfTriggered = false;
            takePictureState.mIsAePrecaptureTriggered = false;
        }
    }

    c.b.b.a.a.a<Boolean> check3AConverged(TakePictureState takePictureState) {
        return (this.mEnableCheck3AConverged || takePictureState.mIsFlashTriggered) ? is3AConverged(takePictureState.mPreCaptureState) ? Futures.immediateFuture(true) : this.mSessionCallbackChecker.checkCaptureResult(new CaptureCallbackChecker.CaptureResultChecker<Boolean>() { // from class: androidx.camera.core.ImageCapture.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.camera.core.ImageCapture.CaptureCallbackChecker.CaptureResultChecker
            public Boolean check(@NonNull CameraCaptureResult cameraCaptureResult) {
                return ImageCapture.this.is3AConverged(cameraCaptureResult) ? true : null;
            }
        }, 1000L, false) : Futures.immediateFuture(false);
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void clear() {
        clearPipeline();
        this.mExecutor.shutdown();
        super.clear();
    }

    void clearPipeline() {
        Threads.checkMainThread();
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        this.mDeferrableSurface = null;
        this.mImageReader = null;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
    }

    SessionConfig.Builder createPipeline(@NonNull final String str, @NonNull final ImageCaptureConfig imageCaptureConfig, @NonNull final Size size) {
        Threads.checkMainThread();
        SessionConfig.Builder builderCreateFrom = SessionConfig.Builder.createFrom(imageCaptureConfig);
        builderCreateFrom.addRepeatingCameraCaptureCallback(this.mSessionCallbackChecker);
        final HandlerThread handlerThread = new HandlerThread("OnImageAvailableHandlerThread");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        if (this.mCaptureProcessor != null) {
            ProcessingImageReader processingImageReader = new ProcessingImageReader(size.getWidth(), size.getHeight(), getImageFormat(), this.mMaxCaptureStages, handler, getCaptureBundle(CaptureBundles.singleDefaultCaptureBundle()), this.mCaptureProcessor);
            this.mMetadataMatchingCaptureCallback = processingImageReader.getCameraCaptureCallback();
            this.mImageReader = processingImageReader;
        } else {
            MetadataImageReader metadataImageReader = new MetadataImageReader(size.getWidth(), size.getHeight(), getImageFormat(), 2, handler);
            this.mMetadataMatchingCaptureCallback = metadataImageReader.getCameraCaptureCallback();
            this.mImageReader = metadataImageReader;
        }
        this.mImageReader.setOnImageAvailableListener(this.mClosingListener, CameraXExecutors.mainThreadExecutor());
        final ImageReaderProxy imageReaderProxy = this.mImageReader;
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
        this.mDeferrableSurface = new ImmediateSurface(this.mImageReader.getSurface());
        this.mDeferrableSurface.getTerminationFuture().addListener(new Runnable() { // from class: androidx.camera.core.t
            @Override // java.lang.Runnable
            public final void run() {
                ImageCapture.a(imageReaderProxy, handlerThread);
            }
        }, CameraXExecutors.mainThreadExecutor());
        builderCreateFrom.addNonRepeatingSurface(this.mDeferrableSurface);
        builderCreateFrom.addErrorListener(new SessionConfig.ErrorListener() { // from class: androidx.camera.core.b0
            @Override // androidx.camera.core.impl.SessionConfig.ErrorListener
            public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                this.f1450a.a(str, imageCaptureConfig, size, sessionConfig, sessionError);
            }
        });
        return builderCreateFrom;
    }

    public int getCaptureMode() {
        return this.mCaptureMode;
    }

    @Override // androidx.camera.core.UseCase
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected UseCaseConfig.Builder<?, ?, ?> getDefaultBuilder(@Nullable CameraInfo cameraInfo) {
        ImageCaptureConfig imageCaptureConfig = (ImageCaptureConfig) CameraX.getDefaultUseCaseConfig(ImageCaptureConfig.class, cameraInfo);
        if (imageCaptureConfig != null) {
            return Builder.fromConfig(imageCaptureConfig);
        }
        return null;
    }

    public int getFlashMode() {
        return this.mFlashMode;
    }

    public int getTargetRotation() {
        return ((ImageOutputConfig) getUseCaseConfig()).getTargetRotation();
    }

    boolean is3AConverged(CameraCaptureResult cameraCaptureResult) {
        if (cameraCaptureResult == null) {
            return false;
        }
        return (cameraCaptureResult.getAfMode() == CameraCaptureMetaData.AfMode.ON_CONTINUOUS_AUTO || cameraCaptureResult.getAfMode() == CameraCaptureMetaData.AfMode.OFF || cameraCaptureResult.getAfMode() == CameraCaptureMetaData.AfMode.UNKNOWN || cameraCaptureResult.getAfState() == CameraCaptureMetaData.AfState.FOCUSED || cameraCaptureResult.getAfState() == CameraCaptureMetaData.AfState.LOCKED_FOCUSED || cameraCaptureResult.getAfState() == CameraCaptureMetaData.AfState.LOCKED_NOT_FOCUSED) && (cameraCaptureResult.getAeState() == CameraCaptureMetaData.AeState.CONVERGED || cameraCaptureResult.getAeState() == CameraCaptureMetaData.AeState.UNKNOWN) && (cameraCaptureResult.getAwbState() == CameraCaptureMetaData.AwbState.CONVERGED || cameraCaptureResult.getAwbState() == CameraCaptureMetaData.AwbState.UNKNOWN);
    }

    boolean isFlashRequired(TakePictureState takePictureState) {
        int flashMode = getFlashMode();
        if (flashMode == 0) {
            return takePictureState.mPreCaptureState.getAeState() == CameraCaptureMetaData.AeState.FLASH_REQUIRED;
        }
        if (flashMode == 1) {
            return true;
        }
        if (flashMode == 2) {
            return false;
        }
        throw new AssertionError(getFlashMode());
    }

    @UiThread
    void issueImageCaptureRequests() {
        ImageCaptureRequest imageCaptureRequestPoll = this.mPendingImageCaptureRequests.poll();
        if (imageCaptureRequestPoll == null) {
            return;
        }
        if (!takePictureInternal(imageCaptureRequestPoll)) {
            this.mPendingImageCaptureRequests.offerFirst(imageCaptureRequestPoll);
        }
        String str = "Size of image capture request queue: " + this.mPendingImageCaptureRequests.size();
    }

    c.b.b.a.a.a<Void> issueTakePicture(@NonNull ImageCaptureRequest imageCaptureRequest) {
        CaptureBundle captureBundle;
        ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        if (this.mCaptureProcessor != null) {
            captureBundle = getCaptureBundle(null);
            if (captureBundle == null) {
                return Futures.immediateFailedFuture(new IllegalArgumentException("ImageCapture cannot set empty CaptureBundle."));
            }
            if (captureBundle.getCaptureStages().size() > this.mMaxCaptureStages) {
                return Futures.immediateFailedFuture(new IllegalArgumentException("ImageCapture has CaptureStages > Max CaptureStage size"));
            }
            ((ProcessingImageReader) this.mImageReader).setCaptureBundle(captureBundle);
        } else {
            captureBundle = getCaptureBundle(CaptureBundles.singleDefaultCaptureBundle());
            if (captureBundle.getCaptureStages().size() > 1) {
                return Futures.immediateFailedFuture(new IllegalArgumentException("ImageCapture have no CaptureProcess set with CaptureBundle size > 1."));
            }
        }
        for (final CaptureStage captureStage : captureBundle.getCaptureStages()) {
            final CaptureConfig.Builder builder = new CaptureConfig.Builder();
            builder.setTemplateType(this.mCaptureConfig.getTemplateType());
            builder.addImplementationOptions(this.mCaptureConfig.getImplementationOptions());
            builder.addAllCameraCaptureCallbacks(this.mSessionConfigBuilder.getSingleCameraCaptureCallbacks());
            builder.addSurface(this.mDeferrableSurface);
            builder.addImplementationOption(CaptureConfig.OPTION_ROTATION, Integer.valueOf(imageCaptureRequest.mRotationDegrees));
            builder.addImplementationOptions(captureStage.getCaptureConfig().getImplementationOptions());
            builder.setTag(captureStage.getCaptureConfig().getTag());
            builder.addCameraCaptureCallback(this.mMetadataMatchingCaptureCallback);
            arrayList.add(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.q
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return this.f1535a.a(builder, arrayList2, captureStage, completer);
                }
            }));
        }
        getCurrentCameraControl().submitCaptureRequests(arrayList2);
        return Futures.transform(Futures.allAsList(arrayList), new Function() { // from class: androidx.camera.core.z
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return ImageCapture.a((List) obj);
            }
        }, CameraXExecutors.directExecutor());
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void onCameraControlReady(@NonNull String str) {
        getCameraControl(str).setFlashMode(this.mFlashMode);
    }

    @Override // androidx.camera.core.UseCase
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @UiThread
    public void onStateOffline(@NonNull String str) {
        super.onStateOffline(str);
        abortImageCaptureRequests();
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected Map<String, Size> onSuggestedResolutionUpdated(@NonNull Map<String, Size> map) {
        String boundCameraId = getBoundCameraId();
        Size size = map.get(boundCameraId);
        if (size != null) {
            this.mSessionConfigBuilder = createPipeline(boundCameraId, this.mConfig, size);
            attachToCamera(boundCameraId, this.mSessionConfigBuilder.build());
            notifyActive();
            return map;
        }
        throw new IllegalArgumentException("Suggested resolution map missing resolution for camera " + boundCameraId);
    }

    void postTakePicture(final TakePictureState takePictureState) {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.core.c0
            @Override // java.lang.Runnable
            public final void run() {
                this.f1458a.a(takePictureState);
            }
        });
    }

    public void setCropAspectRatio(@NonNull Rational rational) {
        ImageCaptureConfig imageCaptureConfig = (ImageCaptureConfig) getUseCaseConfig();
        Builder builderFromConfig = Builder.fromConfig(imageCaptureConfig);
        if (rational.equals(imageCaptureConfig.getTargetAspectRatioCustom(null))) {
            return;
        }
        builderFromConfig.setTargetAspectRatioCustom(rational);
        updateUseCaseConfig(builderFromConfig.getUseCaseConfig());
        this.mConfig = (ImageCaptureConfig) getUseCaseConfig();
    }

    public void setFlashMode(int i2) {
        this.mFlashMode = i2;
        if (getBoundCamera() != null) {
            getCurrentCameraControl().setFlashMode(i2);
        }
    }

    public void setTargetRotation(int i2) {
        ImageCaptureConfig imageCaptureConfig = (ImageCaptureConfig) getUseCaseConfig();
        Builder builderFromConfig = Builder.fromConfig(imageCaptureConfig);
        int targetRotation = imageCaptureConfig.getTargetRotation(-1);
        if (targetRotation == -1 || targetRotation != i2) {
            UseCaseConfigUtil.updateTargetRotationAndRelatedConfigs(builderFromConfig, i2);
            updateUseCaseConfig(builderFromConfig.getUseCaseConfig());
            this.mConfig = (ImageCaptureConfig) getUseCaseConfig();
        }
    }

    /* renamed from: takePicture, reason: merged with bridge method [inline-methods] */
    public void a(@NonNull final Executor executor, @NonNull final OnImageCapturedCallback onImageCapturedCallback) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.core.n
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1519a.a(executor, onImageCapturedCallback);
                }
            });
        } else {
            sendImageCaptureRequest(executor, onImageCapturedCallback);
        }
    }

    @NonNull
    public String toString() {
        return "ImageCapture:" + getName();
    }

    void triggerAePrecapture(TakePictureState takePictureState) {
        takePictureState.mIsAePrecaptureTriggered = true;
        getCurrentCameraControl().triggerAePrecapture();
    }

    void triggerAfIfNeeded(TakePictureState takePictureState) {
        if (this.mEnableCheck3AConverged && takePictureState.mPreCaptureState.getAfMode() == CameraCaptureMetaData.AfMode.ON_MANUAL_AUTO && takePictureState.mPreCaptureState.getAfState() == CameraCaptureMetaData.AfState.INACTIVE) {
            triggerAf(takePictureState);
        }
    }

    /* renamed from: takePicture, reason: merged with bridge method [inline-methods] */
    public void a(@NonNull final OutputFileOptions outputFileOptions, @NonNull final Executor executor, @NonNull final OnImageSavedCallback onImageSavedCallback) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.core.v
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1554a.a(outputFileOptions, executor, onImageSavedCallback);
                }
            });
            return;
        }
        final ImageSaver.OnImageSavedCallback onImageSavedCallback2 = new ImageSaver.OnImageSavedCallback() { // from class: androidx.camera.core.ImageCapture.2
            @Override // androidx.camera.core.ImageSaver.OnImageSavedCallback
            public void onError(ImageSaver.SaveError saveError, String str, @Nullable Throwable th) {
                onImageSavedCallback.onError(new ImageCaptureException(AnonymousClass9.$SwitchMap$androidx$camera$core$ImageSaver$SaveError[saveError.ordinal()] != 1 ? 0 : 1, str, th));
            }

            @Override // androidx.camera.core.ImageSaver.OnImageSavedCallback
            public void onImageSaved(@NonNull OutputFileResults outputFileResults) {
                onImageSavedCallback.onImageSaved(outputFileResults);
            }
        };
        sendImageCaptureRequest(CameraXExecutors.mainThreadExecutor(), new OnImageCapturedCallback() { // from class: androidx.camera.core.ImageCapture.3
            @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
            public void onCaptureSuccess(@NonNull ImageProxy imageProxy) {
                ImageCapture.this.mIoExecutor.execute(new ImageSaver(imageProxy, outputFileOptions, imageProxy.getImageInfo().getRotationDegrees(), executor, onImageSavedCallback2));
            }

            @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
            public void onError(@NonNull ImageCaptureException imageCaptureException) {
                onImageSavedCallback.onError(imageCaptureException);
            }
        });
    }

    static /* synthetic */ void a(ImageReaderProxy imageReaderProxy, HandlerThread handlerThread) {
        imageReaderProxy.close();
        handlerThread.quitSafely();
    }

    public /* synthetic */ void a(String str, ImageCaptureConfig imageCaptureConfig, Size size, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        clearPipeline();
        if (isCurrentlyBoundCamera(str)) {
            this.mSessionConfigBuilder = createPipeline(str, imageCaptureConfig, size);
            attachToCamera(str, this.mSessionConfigBuilder.build());
            notifyReset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class ImageCaptureRequest {

        @NonNull
        private final OnImageCapturedCallback mCallback;
        AtomicBoolean mDispatched = new AtomicBoolean(false);

        @NonNull
        private final Executor mListenerExecutor;
        final int mRotationDegrees;
        private final Rational mTargetRatio;

        ImageCaptureRequest(int i2, Rational rational, @NonNull Executor executor, @NonNull OnImageCapturedCallback onImageCapturedCallback) {
            this.mRotationDegrees = i2;
            this.mTargetRatio = rational;
            this.mListenerExecutor = executor;
            this.mCallback = onImageCapturedCallback;
        }

        public /* synthetic */ void a(ImageProxy imageProxy) {
            Size size = new Size(imageProxy.getWidth(), imageProxy.getHeight());
            if (ImageUtil.isAspectRatioValid(size, this.mTargetRatio)) {
                imageProxy.setCropRect(ImageUtil.computeCropRectFromAspectRatio(size, this.mTargetRatio));
            }
            this.mCallback.onCaptureSuccess(new SettableImageProxy(imageProxy, ImmutableImageInfo.create(imageProxy.getImageInfo().getTag(), imageProxy.getImageInfo().getTimestamp(), this.mRotationDegrees)));
        }

        void dispatchImage(final ImageProxy imageProxy) {
            if (this.mDispatched.compareAndSet(false, true)) {
                try {
                    this.mListenerExecutor.execute(new Runnable() { // from class: androidx.camera.core.x
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f1562a.a(imageProxy);
                        }
                    });
                } catch (RejectedExecutionException unused) {
                    imageProxy.close();
                }
            }
        }

        void notifyCallbackError(final int i2, final String str, final Throwable th) {
            if (this.mDispatched.compareAndSet(false, true)) {
                try {
                    this.mListenerExecutor.execute(new Runnable() { // from class: androidx.camera.core.w
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f1558a.a(i2, str, th);
                        }
                    });
                } catch (RejectedExecutionException unused) {
                }
            }
        }

        public /* synthetic */ void a(int i2, String str, Throwable th) {
            this.mCallback.onError(new ImageCaptureException(i2, str, th));
        }
    }

    public /* synthetic */ void a(ImageCaptureRequest imageCaptureRequest, ImageReaderProxy imageReaderProxy) {
        ImageProxy imageProxyTryAcquireImage = this.mTakePictureLock.tryAcquireImage(imageReaderProxy, imageCaptureRequest);
        if (imageProxyTryAcquireImage != null) {
            imageCaptureRequest.dispatchImage(imageProxyTryAcquireImage);
        }
        this.mTakePictureLock.unlockTakePicture(imageCaptureRequest);
    }

    public /* synthetic */ c.b.b.a.a.a a(ImageCaptureRequest imageCaptureRequest, Void r2) throws Exception {
        return issueTakePicture(imageCaptureRequest);
    }

    public /* synthetic */ c.b.b.a.a.a a(TakePictureState takePictureState, CameraCaptureResult cameraCaptureResult) throws Exception {
        takePictureState.mPreCaptureState = cameraCaptureResult;
        triggerAfIfNeeded(takePictureState);
        if (isFlashRequired(takePictureState)) {
            takePictureState.mIsFlashTriggered = true;
            triggerAePrecapture(takePictureState);
        }
        return check3AConverged(takePictureState);
    }

    public /* synthetic */ Object a(CaptureConfig.Builder builder, List list, CaptureStage captureStage, final CallbackToFutureAdapter.Completer completer) throws Exception {
        builder.addCameraCaptureCallback(new CameraCaptureCallback() { // from class: androidx.camera.core.ImageCapture.8
            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void onCaptureCancelled() {
                completer.setException(new CameraClosedException("Capture request is cancelled because camera is closed"));
            }

            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void onCaptureCompleted(@NonNull CameraCaptureResult cameraCaptureResult) {
                completer.set(null);
            }

            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void onCaptureFailed(@NonNull CameraCaptureFailure cameraCaptureFailure) {
                completer.setException(new CaptureFailedException("Capture request failed with reason " + cameraCaptureFailure.getReason()));
            }
        });
        list.add(builder.build());
        return "issueTakePicture[stage=" + captureStage.getId() + "]";
    }
}
