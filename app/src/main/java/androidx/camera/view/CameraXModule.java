package androidx.camera.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.impl.LensFacingConverter;
import androidx.camera.core.impl.VideoCaptureConfig;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.CameraView;
import androidx.core.util.Preconditions;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
final class CameraXModule {
    public static final String TAG = "CameraXModule";
    private static final float UNITY_ZOOM_SCALE = 1.0f;
    private static final float ZOOM_NOT_SUPPORTED = 1.0f;

    @Nullable
    Camera mCamera;

    @Nullable
    ProcessCameraProvider mCameraProvider;

    @Nullable
    LifecycleOwner mCurrentLifecycle;

    @Nullable
    private ImageCapture mImageCapture;
    private final ImageCapture.Builder mImageCaptureBuilder;

    @Nullable
    private LifecycleOwner mNewLifecycle;

    @Nullable
    Preview mPreview;
    private final Preview.Builder mPreviewBuilder;

    @Nullable
    private VideoCapture mVideoCapture;
    private final VideoCaptureConfig.Builder mVideoCaptureConfigBuilder;
    private WeakReference<CameraView> mWeakReferenceCameraView;
    private static final Rational ASPECT_RATIO_16_9 = new Rational(16, 9);
    private static final Rational ASPECT_RATIO_4_3 = new Rational(4, 3);
    private static final Rational ASPECT_RATIO_9_16 = new Rational(9, 16);
    private static final Rational ASPECT_RATIO_3_4 = new Rational(3, 4);
    final AtomicBoolean mVideoIsRecording = new AtomicBoolean(false);
    private CameraView.CaptureMode mCaptureMode = CameraView.CaptureMode.IMAGE;
    private long mMaxVideoDuration = -1;
    private long mMaxVideoSize = -1;
    private int mFlash = 2;
    private final LifecycleObserver mCurrentLifecycleObserver = new LifecycleObserver() { // from class: androidx.camera.view.CameraXModule.1
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy(LifecycleOwner lifecycleOwner) {
            CameraXModule cameraXModule = CameraXModule.this;
            if (lifecycleOwner == cameraXModule.mCurrentLifecycle) {
                cameraXModule.clearCurrentLifecycle();
                CameraXModule.this.mPreview.setSurfaceProvider(null);
            }
        }
    };

    @Nullable
    Integer mCameraLensFacing = 1;

    CameraXModule(CameraView cameraView) {
        this.mWeakReferenceCameraView = new WeakReference<>(cameraView);
        Futures.addCallback(ProcessCameraProvider.getInstance(getCameraView().getContext()), new FutureCallback<ProcessCameraProvider>() { // from class: androidx.camera.view.CameraXModule.2
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                throw new RuntimeException("CameraX failed to initialize.", th);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            @SuppressLint({"MissingPermission"})
            public void onSuccess(@Nullable ProcessCameraProvider processCameraProvider) {
                Preconditions.checkNotNull(processCameraProvider);
                CameraXModule cameraXModule = CameraXModule.this;
                cameraXModule.mCameraProvider = processCameraProvider;
                LifecycleOwner lifecycleOwner = cameraXModule.mCurrentLifecycle;
                if (lifecycleOwner != null) {
                    cameraXModule.bindToLifecycle(lifecycleOwner);
                }
            }
        }, CameraXExecutors.mainThreadExecutor());
        this.mPreviewBuilder = new Preview.Builder().setTargetName("Preview");
        this.mImageCaptureBuilder = new ImageCapture.Builder().setTargetName("ImageCapture");
        this.mVideoCaptureConfigBuilder = new VideoCaptureConfig.Builder().setTargetName("VideoCapture");
    }

    @RequiresPermission(util.permissionutil.a.f20909c)
    private Set<Integer> getAvailableCameraLensFacing() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(LensFacingConverter.values()));
        if (this.mCurrentLifecycle != null) {
            if (!hasCameraWithLensFacing(1)) {
                linkedHashSet.remove(1);
            }
            if (!hasCameraWithLensFacing(0)) {
                linkedHashSet.remove(0);
            }
        }
        return linkedHashSet;
    }

    private CameraView getCameraView() {
        return this.mWeakReferenceCameraView.get();
    }

    private int getMeasuredHeight() {
        return getCameraView().getMeasuredHeight();
    }

    private int getMeasuredWidth() {
        return getCameraView().getMeasuredWidth();
    }

    @SuppressLint({"MissingPermission"})
    private void rebindToLifecycle() {
        LifecycleOwner lifecycleOwner = this.mCurrentLifecycle;
        if (lifecycleOwner != null) {
            bindToLifecycle(lifecycleOwner);
        }
    }

    private void updateViewInfo() {
        ImageCapture imageCapture = this.mImageCapture;
        if (imageCapture != null) {
            imageCapture.setCropAspectRatio(new Rational(getWidth(), getHeight()));
            this.mImageCapture.setTargetRotation(getDisplaySurfaceRotation());
        }
        VideoCapture videoCapture = this.mVideoCapture;
        if (videoCapture != null) {
            videoCapture.setTargetRotation(getDisplaySurfaceRotation());
        }
    }

    @RequiresPermission(util.permissionutil.a.f20909c)
    void bindToLifecycle(LifecycleOwner lifecycleOwner) {
        this.mNewLifecycle = lifecycleOwner;
        if (getMeasuredWidth() <= 0 || getMeasuredHeight() <= 0) {
            return;
        }
        bindToLifecycleAfterViewMeasured();
    }

    @RequiresPermission(util.permissionutil.a.f20909c)
    void bindToLifecycleAfterViewMeasured() {
        Rational rational;
        if (this.mNewLifecycle == null) {
            return;
        }
        clearCurrentLifecycle();
        this.mCurrentLifecycle = this.mNewLifecycle;
        this.mNewLifecycle = null;
        if (this.mCurrentLifecycle.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            this.mCurrentLifecycle = null;
            throw new IllegalArgumentException("Cannot BindView to lifecycle in a destroyed state.");
        }
        if (this.mCameraProvider == null) {
            return;
        }
        Set<Integer> availableCameraLensFacing = getAvailableCameraLensFacing();
        if (availableCameraLensFacing.isEmpty()) {
            this.mCameraLensFacing = null;
        }
        Integer num = this.mCameraLensFacing;
        if (num != null && !availableCameraLensFacing.contains(num)) {
            String str = "Camera does not exist with direction " + this.mCameraLensFacing;
            this.mCameraLensFacing = availableCameraLensFacing.iterator().next();
            String str2 = "Defaulting to primary camera with direction " + this.mCameraLensFacing;
        }
        if (this.mCameraLensFacing == null) {
            return;
        }
        boolean z = getDisplayRotationDegrees() == 0 || getDisplayRotationDegrees() == 180;
        if (getCaptureMode() == CameraView.CaptureMode.IMAGE) {
            this.mImageCaptureBuilder.setTargetAspectRatio(0);
            rational = z ? ASPECT_RATIO_3_4 : ASPECT_RATIO_4_3;
        } else {
            this.mImageCaptureBuilder.setTargetAspectRatio(1);
            rational = z ? ASPECT_RATIO_9_16 : ASPECT_RATIO_16_9;
        }
        this.mImageCaptureBuilder.setTargetRotation(getDisplaySurfaceRotation());
        this.mImageCapture = this.mImageCaptureBuilder.build();
        this.mVideoCaptureConfigBuilder.setTargetRotation(getDisplaySurfaceRotation());
        this.mVideoCapture = this.mVideoCaptureConfigBuilder.build();
        this.mPreviewBuilder.setTargetResolution(new Size(getMeasuredWidth(), (int) (getMeasuredWidth() / rational.floatValue())));
        this.mPreview = this.mPreviewBuilder.build();
        this.mPreview.setSurfaceProvider(getCameraView().getPreviewView().getPreviewSurfaceProvider());
        CameraSelector cameraSelectorBuild = new CameraSelector.Builder().requireLensFacing(this.mCameraLensFacing.intValue()).build();
        if (getCaptureMode() == CameraView.CaptureMode.IMAGE) {
            this.mCamera = this.mCameraProvider.bindToLifecycle(this.mCurrentLifecycle, cameraSelectorBuild, this.mImageCapture, this.mPreview);
        } else if (getCaptureMode() == CameraView.CaptureMode.VIDEO) {
            this.mCamera = this.mCameraProvider.bindToLifecycle(this.mCurrentLifecycle, cameraSelectorBuild, this.mVideoCapture, this.mPreview);
        } else {
            this.mCamera = this.mCameraProvider.bindToLifecycle(this.mCurrentLifecycle, cameraSelectorBuild, this.mImageCapture, this.mVideoCapture, this.mPreview);
        }
        setZoomRatio(1.0f);
        this.mCurrentLifecycle.getLifecycle().addObserver(this.mCurrentLifecycleObserver);
        setFlash(getFlash());
    }

    void clearCurrentLifecycle() {
        if (this.mCurrentLifecycle != null && this.mCameraProvider != null) {
            ArrayList arrayList = new ArrayList();
            ImageCapture imageCapture = this.mImageCapture;
            if (imageCapture != null && this.mCameraProvider.isBound(imageCapture)) {
                arrayList.add(this.mImageCapture);
            }
            VideoCapture videoCapture = this.mVideoCapture;
            if (videoCapture != null && this.mCameraProvider.isBound(videoCapture)) {
                arrayList.add(this.mVideoCapture);
            }
            Preview preview = this.mPreview;
            if (preview != null && this.mCameraProvider.isBound(preview)) {
                arrayList.add(this.mPreview);
            }
            if (!arrayList.isEmpty()) {
                this.mCameraProvider.unbind((UseCase[]) arrayList.toArray(new UseCase[0]));
            }
        }
        this.mCamera = null;
        this.mCurrentLifecycle = null;
    }

    public void close() {
        throw new UnsupportedOperationException("Explicit open/close of camera not yet supported. Use bindtoLifecycle() instead.");
    }

    public void enableTorch(boolean z) {
        Camera camera = this.mCamera;
        if (camera == null) {
            return;
        }
        Futures.addCallback(camera.getCameraControl().enableTorch(z), new FutureCallback<Void>() { // from class: androidx.camera.view.CameraXModule.5
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                throw new RuntimeException(th);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable Void r1) {
            }
        }, CameraXExecutors.directExecutor());
    }

    @Nullable
    public Camera getCamera() {
        return this.mCamera;
    }

    @NonNull
    public CameraView.CaptureMode getCaptureMode() {
        return this.mCaptureMode;
    }

    public Context getContext() {
        return getCameraView().getContext();
    }

    public int getDisplayRotationDegrees() {
        return CameraOrientationUtil.surfaceRotationToDegrees(getDisplaySurfaceRotation());
    }

    protected int getDisplaySurfaceRotation() {
        return getCameraView().getDisplaySurfaceRotation();
    }

    public int getFlash() {
        return this.mFlash;
    }

    public int getHeight() {
        return getCameraView().getHeight();
    }

    @Nullable
    public Integer getLensFacing() {
        return this.mCameraLensFacing;
    }

    public long getMaxVideoDuration() {
        return this.mMaxVideoDuration;
    }

    public long getMaxVideoSize() {
        return this.mMaxVideoSize;
    }

    public float getMaxZoomRatio() {
        Camera camera = this.mCamera;
        if (camera != null) {
            return camera.getCameraInfo().getZoomState().getValue().getMaxZoomRatio();
        }
        return 1.0f;
    }

    public float getMinZoomRatio() {
        Camera camera = this.mCamera;
        if (camera != null) {
            return camera.getCameraInfo().getZoomState().getValue().getMinZoomRatio();
        }
        return 1.0f;
    }

    int getRelativeCameraOrientation(boolean z) {
        Camera camera = this.mCamera;
        if (camera == null) {
            return 0;
        }
        int sensorRotationDegrees = camera.getCameraInfo().getSensorRotationDegrees(getDisplaySurfaceRotation());
        return z ? (360 - sensorRotationDegrees) % 360 : sensorRotationDegrees;
    }

    public int getWidth() {
        return getCameraView().getWidth();
    }

    public float getZoomRatio() {
        Camera camera = this.mCamera;
        if (camera != null) {
            return camera.getCameraInfo().getZoomState().getValue().getZoomRatio();
        }
        return 1.0f;
    }

    @RequiresPermission(util.permissionutil.a.f20909c)
    public boolean hasCameraWithLensFacing(int i2) {
        try {
            return CameraX.getCameraWithLensFacing(i2) != null;
        } catch (Exception e2) {
            throw new IllegalStateException("Unable to query lens facing.", e2);
        }
    }

    public void invalidateView() {
        updateViewInfo();
    }

    public boolean isPaused() {
        return false;
    }

    public boolean isRecording() {
        return this.mVideoIsRecording.get();
    }

    public boolean isTorchOn() {
        Camera camera = this.mCamera;
        return camera != null && camera.getCameraInfo().getTorchState().getValue().intValue() == 1;
    }

    public boolean isZoomSupported() {
        return getMaxZoomRatio() != 1.0f;
    }

    public void open() {
        throw new UnsupportedOperationException("Explicit open/close of camera not yet supported. Use bindtoLifecycle() instead.");
    }

    @SuppressLint({"MissingPermission"})
    public void setCameraLensFacing(@Nullable Integer num) {
        if (Objects.equals(this.mCameraLensFacing, num)) {
            return;
        }
        this.mCameraLensFacing = num;
        LifecycleOwner lifecycleOwner = this.mCurrentLifecycle;
        if (lifecycleOwner != null) {
            bindToLifecycle(lifecycleOwner);
        }
    }

    public void setCaptureMode(@NonNull CameraView.CaptureMode captureMode) {
        this.mCaptureMode = captureMode;
        rebindToLifecycle();
    }

    public void setFlash(int i2) {
        this.mFlash = i2;
        ImageCapture imageCapture = this.mImageCapture;
        if (imageCapture == null) {
            return;
        }
        imageCapture.setFlashMode(i2);
    }

    public void setMaxVideoDuration(long j2) {
        this.mMaxVideoDuration = j2;
    }

    public void setMaxVideoSize(long j2) {
        this.mMaxVideoSize = j2;
    }

    public void setZoomRatio(float f2) {
        Camera camera = this.mCamera;
        if (camera != null) {
            Futures.addCallback(camera.getCameraControl().setZoomRatio(f2), new FutureCallback<Void>() { // from class: androidx.camera.view.CameraXModule.4
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(Throwable th) {
                    throw new RuntimeException(th);
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(@Nullable Void r1) {
                }
            }, CameraXExecutors.directExecutor());
        }
    }

    public void startRecording(File file, Executor executor, final VideoCapture.OnVideoSavedCallback onVideoSavedCallback) {
        if (this.mVideoCapture == null) {
            return;
        }
        if (getCaptureMode() == CameraView.CaptureMode.IMAGE) {
            throw new IllegalStateException("Can not record video under IMAGE capture mode.");
        }
        if (onVideoSavedCallback == null) {
            throw new IllegalArgumentException("OnVideoSavedCallback should not be empty");
        }
        this.mVideoIsRecording.set(true);
        this.mVideoCapture.startRecording(file, executor, new VideoCapture.OnVideoSavedCallback() { // from class: androidx.camera.view.CameraXModule.3
            @Override // androidx.camera.core.VideoCapture.OnVideoSavedCallback
            public void onError(int i2, @NonNull String str, @Nullable Throwable th) {
                CameraXModule.this.mVideoIsRecording.set(false);
                onVideoSavedCallback.onError(i2, str, th);
            }

            @Override // androidx.camera.core.VideoCapture.OnVideoSavedCallback
            public void onVideoSaved(@NonNull File file2) {
                CameraXModule.this.mVideoIsRecording.set(false);
                onVideoSavedCallback.onVideoSaved(file2);
            }
        });
    }

    public void stopRecording() {
        VideoCapture videoCapture = this.mVideoCapture;
        if (videoCapture == null) {
            return;
        }
        videoCapture.stopRecording();
    }

    public void takePicture(Executor executor, ImageCapture.OnImageCapturedCallback onImageCapturedCallback) {
        if (this.mImageCapture == null) {
            return;
        }
        if (getCaptureMode() == CameraView.CaptureMode.VIDEO) {
            throw new IllegalStateException("Can not take picture under VIDEO capture mode.");
        }
        if (onImageCapturedCallback == null) {
            throw new IllegalArgumentException("OnImageCapturedCallback should not be empty");
        }
        this.mImageCapture.a(executor, onImageCapturedCallback);
    }

    public void toggleCamera() {
        Set<Integer> availableCameraLensFacing = getAvailableCameraLensFacing();
        if (availableCameraLensFacing.isEmpty()) {
            return;
        }
        Integer num = this.mCameraLensFacing;
        if (num == null) {
            setCameraLensFacing(availableCameraLensFacing.iterator().next());
            return;
        }
        if (num.intValue() == 1 && availableCameraLensFacing.contains(0)) {
            setCameraLensFacing(0);
        } else if (this.mCameraLensFacing.intValue() == 0 && availableCameraLensFacing.contains(1)) {
            setCameraLensFacing(1);
        }
    }

    public void takePicture(File file, Executor executor, ImageCapture.OnImageSavedCallback onImageSavedCallback) {
        if (this.mImageCapture == null) {
            return;
        }
        if (getCaptureMode() == CameraView.CaptureMode.VIDEO) {
            throw new IllegalStateException("Can not take picture under VIDEO capture mode.");
        }
        if (onImageSavedCallback != null) {
            ImageCapture.Metadata metadata = new ImageCapture.Metadata();
            Integer num = this.mCameraLensFacing;
            metadata.setReversedHorizontal(num != null && num.intValue() == 0);
            this.mImageCapture.a(new ImageCapture.OutputFileOptions.Builder(file).setMetadata(metadata).build(), executor, onImageSavedCallback);
            return;
        }
        throw new IllegalArgumentException("OnImageSavedCallback should not be empty");
    }
}
