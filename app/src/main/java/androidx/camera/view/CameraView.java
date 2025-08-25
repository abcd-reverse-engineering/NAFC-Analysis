package androidx.camera.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.DisplayOrientedMeteringPointFactory;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.MeteringPoint;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.impl.LensFacingConverter;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.lifecycle.LifecycleOwner;
import com.luck.picture.lib.R;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class CameraView extends FrameLayout {
    static final boolean DEBUG = false;
    private static final String EXTRA_CAMERA_DIRECTION = "camera_direction";
    private static final String EXTRA_CAPTURE_MODE = "captureMode";
    private static final String EXTRA_FLASH = "flash";
    private static final String EXTRA_MAX_VIDEO_DURATION = "max_video_duration";
    private static final String EXTRA_MAX_VIDEO_SIZE = "max_video_size";
    private static final String EXTRA_PINCH_TO_ZOOM_ENABLED = "pinch_to_zoom_enabled";
    private static final String EXTRA_SCALE_TYPE = "scale_type";
    private static final String EXTRA_SUPER = "super";
    private static final String EXTRA_ZOOM_RATIO = "zoom_ratio";
    private static final int FLASH_MODE_AUTO = 1;
    private static final int FLASH_MODE_OFF = 4;
    private static final int FLASH_MODE_ON = 2;
    static final int INDEFINITE_VIDEO_DURATION = -1;
    static final int INDEFINITE_VIDEO_SIZE = -1;
    private static final int LENS_FACING_BACK = 2;
    private static final int LENS_FACING_FRONT = 1;
    private static final int LENS_FACING_NONE = 0;
    static final String TAG = CameraView.class.getSimpleName();
    CameraXModule mCameraModule;
    private final DisplayManager.DisplayListener mDisplayListener;
    private long mDownEventTimestamp;
    private boolean mIsPinchToZoomEnabled;
    private PinchToZoomGestureDetector mPinchToZoomGestureDetector;
    private WeakReference<ImageCapture.OnImageSavedCallback> mReferenceImageSavedCallback;
    private ScaleType mScaleType;
    private MotionEvent mUpEvent;
    private WeakReference<PreviewView> mWeakReferencePreviewView;

    public enum CaptureMode {
        IMAGE(0),
        VIDEO(1),
        MIXED(2);

        private final int mId;

        CaptureMode(int i2) {
            this.mId = i2;
        }

        static CaptureMode fromId(int i2) {
            for (CaptureMode captureMode : values()) {
                if (captureMode.mId == i2) {
                    return captureMode;
                }
            }
            throw new IllegalArgumentException();
        }

        int getId() {
            return this.mId;
        }
    }

    private class PinchToZoomGestureDetector extends ScaleGestureDetector implements ScaleGestureDetector.OnScaleGestureListener {
        PinchToZoomGestureDetector(CameraView cameraView, Context context) {
            this(context, new S());
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            float zoomRatio = CameraView.this.getZoomRatio() * (scaleFactor > 1.0f ? ((scaleFactor - 1.0f) * 2.0f) + 1.0f : 1.0f - ((1.0f - scaleFactor) * 2.0f));
            CameraView cameraView = CameraView.this;
            CameraView.this.setZoomRatio(cameraView.rangeLimit(zoomRatio, cameraView.getMaxZoomRatio(), CameraView.this.getMinZoomRatio()));
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }

        PinchToZoomGestureDetector(Context context, S s) {
            super(context, s);
            s.setRealGestureDetector(this);
        }
    }

    static class S extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private ScaleGestureDetector.OnScaleGestureListener mListener;

        S() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            return this.mListener.onScale(scaleGestureDetector);
        }

        void setRealGestureDetector(ScaleGestureDetector.OnScaleGestureListener onScaleGestureListener) {
            this.mListener = onScaleGestureListener;
        }
    }

    public enum ScaleType {
        CENTER_CROP(0),
        CENTER_INSIDE(1);

        private final int mId;

        ScaleType(int i2) {
            this.mId = i2;
        }

        static ScaleType fromId(int i2) {
            for (ScaleType scaleType : values()) {
                if (scaleType.mId == i2) {
                    return scaleType;
                }
            }
            throw new IllegalArgumentException();
        }

        int getId() {
            return this.mId;
        }
    }

    public CameraView(@NonNull Context context) {
        this(context, null);
    }

    private long delta() {
        return System.currentTimeMillis() - this.mDownEventTimestamp;
    }

    private long getMaxVideoSize() {
        return this.mCameraModule.getMaxVideoSize();
    }

    private void init(Context context, @Nullable AttributeSet attributeSet) {
        WeakReference weakReference = new WeakReference(context);
        this.mWeakReferencePreviewView = new WeakReference<>(new PreviewView((Context) weakReference.get()));
        addView(this.mWeakReferencePreviewView.get(), 0);
        this.mCameraModule = new CameraXModule(this);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = ((Context) weakReference.get()).obtainStyledAttributes(attributeSet, R.styleable.CameraView);
            setScaleType(ScaleType.fromId(typedArrayObtainStyledAttributes.getInteger(R.styleable.CameraView_scaleType, getScaleType().getId())));
            setPinchToZoomEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.CameraView_pinchToZoomEnabled, isPinchToZoomEnabled()));
            setCaptureMode(CaptureMode.fromId(typedArrayObtainStyledAttributes.getInteger(R.styleable.CameraView_captureMode, getCaptureMode().getId())));
            int i2 = typedArrayObtainStyledAttributes.getInt(R.styleable.CameraView_lensFacing, 2);
            if (i2 == 0) {
                setCameraLensFacing(null);
            } else if (i2 == 1) {
                setCameraLensFacing(0);
            } else if (i2 == 2) {
                setCameraLensFacing(1);
            }
            int i3 = typedArrayObtainStyledAttributes.getInt(R.styleable.CameraView_flash, 0);
            if (i3 == 1) {
                setFlash(0);
            } else if (i3 == 2) {
                setFlash(1);
            } else if (i3 == 4) {
                setFlash(2);
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        if (getBackground() == null) {
            setBackgroundColor(-15658735);
        }
        this.mPinchToZoomGestureDetector = new PinchToZoomGestureDetector(this, (Context) weakReference.get());
    }

    private void setMaxVideoDuration(long j2) {
        this.mCameraModule.setMaxVideoDuration(j2);
    }

    private void setMaxVideoSize(long j2) {
        this.mCameraModule.setMaxVideoSize(j2);
    }

    @RequiresPermission(util.permissionutil.a.f20909c)
    public void bindToLifecycle(@NonNull LifecycleOwner lifecycleOwner) {
        this.mCameraModule.bindToLifecycle(lifecycleOwner);
    }

    public void enableTorch(boolean z) {
        this.mCameraModule.enableTorch(z);
    }

    @Nullable
    public Integer getCameraLensFacing() {
        return this.mCameraModule.getLensFacing();
    }

    @NonNull
    public CaptureMode getCaptureMode() {
        return this.mCameraModule.getCaptureMode();
    }

    int getDisplaySurfaceRotation() {
        Display display = getDisplay();
        if (display == null) {
            return 0;
        }
        return display.getRotation();
    }

    public int getFlash() {
        return this.mCameraModule.getFlash();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public long getMaxVideoDuration() {
        return this.mCameraModule.getMaxVideoDuration();
    }

    public float getMaxZoomRatio() {
        return this.mCameraModule.getMaxZoomRatio();
    }

    public float getMinZoomRatio() {
        return this.mCameraModule.getMinZoomRatio();
    }

    PreviewView getPreviewView() {
        return this.mWeakReferencePreviewView.get();
    }

    @NonNull
    public ScaleType getScaleType() {
        return this.mScaleType;
    }

    public float getZoomRatio() {
        return this.mCameraModule.getZoomRatio();
    }

    @RequiresPermission(util.permissionutil.a.f20909c)
    public boolean hasCameraWithLensFacing(int i2) {
        return this.mCameraModule.hasCameraWithLensFacing(i2);
    }

    public boolean isPinchToZoomEnabled() {
        return this.mIsPinchToZoomEnabled;
    }

    public boolean isRecording() {
        return this.mCameraModule.isRecording();
    }

    public boolean isTorchOn() {
        return this.mCameraModule.isTorchOn();
    }

    public boolean isZoomSupported() {
        return this.mCameraModule.isZoomSupported();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((DisplayManager) getContext().getApplicationContext().getSystemService("display")).registerDisplayListener(this.mDisplayListener, new Handler(Looper.getMainLooper()));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ((DisplayManager) getContext().getApplicationContext().getSystemService("display")).unregisterDisplayListener(this.mDisplayListener);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    @SuppressLint({"MissingPermission"})
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.mCameraModule.bindToLifecycleAfterViewMeasured();
        this.mCameraModule.invalidateView();
        super.onLayout(z, i2, i3, i4, i5);
    }

    @Override // android.widget.FrameLayout, android.view.View
    @SuppressLint({"MissingPermission"})
    protected void onMeasure(int i2, int i3) {
        if (getMeasuredWidth() > 0 && getMeasuredHeight() > 0) {
            this.mCameraModule.bindToLifecycleAfterViewMeasured();
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable(EXTRA_SUPER));
        setScaleType(ScaleType.fromId(bundle.getInt(EXTRA_SCALE_TYPE)));
        setZoomRatio(bundle.getFloat(EXTRA_ZOOM_RATIO));
        setPinchToZoomEnabled(bundle.getBoolean(EXTRA_PINCH_TO_ZOOM_ENABLED));
        setFlash(FlashModeConverter.valueOf(bundle.getString(EXTRA_FLASH)));
        setMaxVideoDuration(bundle.getLong(EXTRA_MAX_VIDEO_DURATION));
        setMaxVideoSize(bundle.getLong(EXTRA_MAX_VIDEO_SIZE));
        String string = bundle.getString(EXTRA_CAMERA_DIRECTION);
        setCameraLensFacing(TextUtils.isEmpty(string) ? null : Integer.valueOf(LensFacingConverter.valueOf(string)));
        setCaptureMode(CaptureMode.fromId(bundle.getInt(EXTRA_CAPTURE_MODE)));
    }

    @Override // android.view.View
    @NonNull
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(EXTRA_SUPER, super.onSaveInstanceState());
        bundle.putInt(EXTRA_SCALE_TYPE, getScaleType().getId());
        bundle.putFloat(EXTRA_ZOOM_RATIO, getZoomRatio());
        bundle.putBoolean(EXTRA_PINCH_TO_ZOOM_ENABLED, isPinchToZoomEnabled());
        bundle.putString(EXTRA_FLASH, FlashModeConverter.nameOf(getFlash()));
        bundle.putLong(EXTRA_MAX_VIDEO_DURATION, getMaxVideoDuration());
        bundle.putLong(EXTRA_MAX_VIDEO_SIZE, getMaxVideoSize());
        if (getCameraLensFacing() != null) {
            bundle.putString(EXTRA_CAMERA_DIRECTION, LensFacingConverter.nameOf(getCameraLensFacing().intValue()));
        }
        bundle.putInt(EXTRA_CAPTURE_MODE, getCaptureMode().getId());
        return bundle;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (this.mCameraModule.isPaused()) {
            return false;
        }
        if (isPinchToZoomEnabled()) {
            this.mPinchToZoomGestureDetector.onTouchEvent(motionEvent);
        }
        if (motionEvent.getPointerCount() == 2 && isPinchToZoomEnabled() && isZoomSupported()) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mDownEventTimestamp = System.currentTimeMillis();
        } else {
            if (action != 1) {
                return false;
            }
            if (delta() < ViewConfiguration.getLongPressTimeout()) {
                this.mUpEvent = motionEvent;
                performClick();
            }
        }
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        MotionEvent motionEvent = this.mUpEvent;
        float x = motionEvent != null ? motionEvent.getX() : getX() + (getWidth() / 2.0f);
        MotionEvent motionEvent2 = this.mUpEvent;
        float y = motionEvent2 != null ? motionEvent2.getY() : getY() + (getHeight() / 2.0f);
        this.mUpEvent = null;
        DisplayOrientedMeteringPointFactory displayOrientedMeteringPointFactory = new DisplayOrientedMeteringPointFactory(getDisplay(), new CameraSelector.Builder().requireLensFacing(this.mCameraModule.getLensFacing().intValue()).build(), getPreviewView().getWidth(), getPreviewView().getHeight());
        MeteringPoint meteringPointCreatePoint = displayOrientedMeteringPointFactory.createPoint(x, y, 0.16666667f);
        MeteringPoint meteringPointCreatePoint2 = displayOrientedMeteringPointFactory.createPoint(x, y, 0.25f);
        Camera camera = this.mCameraModule.getCamera();
        if (camera != null) {
            Futures.addCallback(camera.getCameraControl().startFocusAndMetering(new FocusMeteringAction.Builder(meteringPointCreatePoint, 1).addPoint(meteringPointCreatePoint2, 2).build()), new FutureCallback<FocusMeteringResult>() { // from class: androidx.camera.view.CameraView.2
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(Throwable th) {
                    throw new RuntimeException(th);
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(@Nullable FocusMeteringResult focusMeteringResult) {
                }
            }, CameraXExecutors.directExecutor());
        }
        return true;
    }

    float rangeLimit(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f4), f3);
    }

    public void setCameraLensFacing(@Nullable Integer num) {
        this.mCameraModule.setCameraLensFacing(num);
    }

    public void setCaptureMode(@NonNull CaptureMode captureMode) {
        this.mCameraModule.setCaptureMode(captureMode);
    }

    public void setFlash(int i2) {
        this.mCameraModule.setFlash(i2);
    }

    public void setPinchToZoomEnabled(boolean z) {
        this.mIsPinchToZoomEnabled = z;
    }

    public void setScaleType(@NonNull ScaleType scaleType) {
        if (scaleType != this.mScaleType) {
            this.mScaleType = scaleType;
            requestLayout();
        }
    }

    public void setZoomRatio(float f2) {
        this.mCameraModule.setZoomRatio(f2);
    }

    public void startRecording(@NonNull File file, @NonNull Executor executor, @NonNull VideoCapture.OnVideoSavedCallback onVideoSavedCallback) {
        this.mCameraModule.startRecording(file, executor, onVideoSavedCallback);
    }

    public void stopRecording() {
        this.mCameraModule.stopRecording();
    }

    public void takePicture(@NonNull Executor executor, @NonNull ImageCapture.OnImageCapturedCallback onImageCapturedCallback) {
        this.mCameraModule.takePicture(executor, onImageCapturedCallback);
    }

    public void toggleCamera() {
        this.mCameraModule.toggleCamera();
    }

    public CameraView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    @NonNull
    public FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public void takePicture(@NonNull File file, @NonNull Executor executor, @NonNull ImageCapture.OnImageSavedCallback onImageSavedCallback) {
        this.mCameraModule.takePicture(file, executor, (ImageCapture.OnImageSavedCallback) new WeakReference(onImageSavedCallback).get());
    }

    public CameraView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mIsPinchToZoomEnabled = true;
        this.mDisplayListener = new DisplayManager.DisplayListener() { // from class: androidx.camera.view.CameraView.1
            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayAdded(int i3) {
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayChanged(int i3) {
                CameraView.this.mCameraModule.invalidateView();
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayRemoved(int i3) {
            }
        };
        this.mScaleType = ScaleType.CENTER_CROP;
        init(context, attributeSet);
    }

    @RequiresApi(21)
    public CameraView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.mIsPinchToZoomEnabled = true;
        this.mDisplayListener = new DisplayManager.DisplayListener() { // from class: androidx.camera.view.CameraView.1
            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayAdded(int i32) {
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayChanged(int i32) {
                CameraView.this.mCameraModule.invalidateView();
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayRemoved(int i32) {
            }
        };
        this.mScaleType = ScaleType.CENTER_CROP;
        init(context, attributeSet);
    }
}
