package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Looper;
import androidx.annotation.FloatRange;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.camera.camera2.internal.Camera2CameraControl;
import androidx.camera.core.CameraControl;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.ImmutableZoomState;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/* loaded from: classes.dex */
final class ZoomControl {
    public static final float DEFAULT_ZOOM_RATIO = 1.0f;
    public static final float MIN_ZOOM = 1.0f;
    private static final String TAG = "ZoomControl";
    private final Camera2CameraControl mCamera2CameraControl;

    @GuardedBy("mActiveLock")
    private final ZoomStateImpl mCurrentZoomState;

    @GuardedBy("mCompleterLock")
    CallbackToFutureAdapter.Completer<Void> mPendingZoomRatioCompleter;
    private final MutableLiveData<ZoomState> mZoomStateLiveData;
    final Object mCompleterLock = new Object();

    @GuardedBy("mCompleterLock")
    Rect mPendingZoomCropRegion = null;
    final Object mActiveLock = new Object();

    @GuardedBy("mActiveLock")
    private boolean mIsActive = false;
    private Camera2CameraControl.CaptureResultListener mCaptureResultListener = new Camera2CameraControl.CaptureResultListener() { // from class: androidx.camera.camera2.internal.ZoomControl.1
        /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
        @Override // androidx.camera.camera2.internal.Camera2CameraControl.CaptureResultListener
        @androidx.annotation.WorkerThread
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onCaptureResult(@androidx.annotation.NonNull android.hardware.camera2.TotalCaptureResult r4) {
            /*
                r3 = this;
                androidx.camera.camera2.internal.ZoomControl r0 = androidx.camera.camera2.internal.ZoomControl.this
                java.lang.Object r0 = r0.mCompleterLock
                monitor-enter(r0)
                androidx.camera.camera2.internal.ZoomControl r1 = androidx.camera.camera2.internal.ZoomControl.this     // Catch: java.lang.Throwable -> L42
                androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.lang.Void> r1 = r1.mPendingZoomRatioCompleter     // Catch: java.lang.Throwable -> L42
                r2 = 0
                if (r1 == 0) goto L39
                android.hardware.camera2.CaptureRequest r4 = r4.getRequest()     // Catch: java.lang.Throwable -> L42
                if (r4 != 0) goto L14
                r4 = r2
                goto L1c
            L14:
                android.hardware.camera2.CaptureRequest$Key r1 = android.hardware.camera2.CaptureRequest.SCALER_CROP_REGION     // Catch: java.lang.Throwable -> L42
                java.lang.Object r4 = r4.get(r1)     // Catch: java.lang.Throwable -> L42
                android.graphics.Rect r4 = (android.graphics.Rect) r4     // Catch: java.lang.Throwable -> L42
            L1c:
                androidx.camera.camera2.internal.ZoomControl r1 = androidx.camera.camera2.internal.ZoomControl.this     // Catch: java.lang.Throwable -> L42
                android.graphics.Rect r1 = r1.mPendingZoomCropRegion     // Catch: java.lang.Throwable -> L42
                if (r1 == 0) goto L39
                androidx.camera.camera2.internal.ZoomControl r1 = androidx.camera.camera2.internal.ZoomControl.this     // Catch: java.lang.Throwable -> L42
                android.graphics.Rect r1 = r1.mPendingZoomCropRegion     // Catch: java.lang.Throwable -> L42
                boolean r4 = r1.equals(r4)     // Catch: java.lang.Throwable -> L42
                if (r4 == 0) goto L39
                androidx.camera.camera2.internal.ZoomControl r4 = androidx.camera.camera2.internal.ZoomControl.this     // Catch: java.lang.Throwable -> L42
                androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.lang.Void> r4 = r4.mPendingZoomRatioCompleter     // Catch: java.lang.Throwable -> L42
                androidx.camera.camera2.internal.ZoomControl r1 = androidx.camera.camera2.internal.ZoomControl.this     // Catch: java.lang.Throwable -> L42
                r1.mPendingZoomRatioCompleter = r2     // Catch: java.lang.Throwable -> L42
                androidx.camera.camera2.internal.ZoomControl r1 = androidx.camera.camera2.internal.ZoomControl.this     // Catch: java.lang.Throwable -> L42
                r1.mPendingZoomCropRegion = r2     // Catch: java.lang.Throwable -> L42
                goto L3a
            L39:
                r4 = r2
            L3a:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L42
                if (r4 == 0) goto L40
                r4.set(r2)
            L40:
                r4 = 0
                return r4
            L42:
                r4 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L42
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.ZoomControl.AnonymousClass1.onCaptureResult(android.hardware.camera2.TotalCaptureResult):boolean");
        }
    };

    ZoomControl(@NonNull Camera2CameraControl camera2CameraControl, @NonNull CameraCharacteristics cameraCharacteristics) throws IllegalArgumentException {
        this.mCamera2CameraControl = camera2CameraControl;
        this.mCurrentZoomState = new ZoomStateImpl(getMaxDigitalZoom(cameraCharacteristics), 1.0f);
        this.mCurrentZoomState.setZoomRatio(1.0f);
        this.mZoomStateLiveData = new MutableLiveData<>(ImmutableZoomState.create(this.mCurrentZoomState));
        camera2CameraControl.addCaptureResultListener(this.mCaptureResultListener);
    }

    @NonNull
    @VisibleForTesting
    static Rect getCropRectByRatio(@NonNull Rect rect, float f2) {
        float fWidth = rect.width() / f2;
        float fHeight = rect.height() / f2;
        float fWidth2 = (rect.width() - fWidth) / 2.0f;
        float fHeight2 = (rect.height() - fHeight) / 2.0f;
        return new Rect((int) fWidth2, (int) fHeight2, (int) (fWidth2 + fWidth), (int) (fHeight2 + fHeight));
    }

    private static float getMaxDigitalZoom(CameraCharacteristics cameraCharacteristics) {
        Float f2 = (Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        if (f2 == null) {
            return 1.0f;
        }
        return f2.floatValue();
    }

    @NonNull
    @GuardedBy("mActiveLock")
    private c.b.b.a.a.a<Void> submitCameraZoomRatio(float f2) {
        final Rect cropRectByRatio = getCropRectByRatio(this.mCamera2CameraControl.getSensorRect(), f2);
        this.mCamera2CameraControl.setCropRegion(cropRectByRatio);
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.internal.a0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f1383a.a(cropRectByRatio, completer);
            }
        });
    }

    private void updateLiveData(ZoomState zoomState) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.mZoomStateLiveData.setValue(zoomState);
        } else {
            this.mZoomStateLiveData.postValue(zoomState);
        }
    }

    public /* synthetic */ Object a(Rect rect, CallbackToFutureAdapter.Completer completer) throws Exception {
        CallbackToFutureAdapter.Completer<Void> completer2;
        synchronized (this.mCompleterLock) {
            if (this.mPendingZoomRatioCompleter != null) {
                completer2 = this.mPendingZoomRatioCompleter;
                this.mPendingZoomRatioCompleter = null;
            } else {
                completer2 = null;
            }
            this.mPendingZoomCropRegion = rect;
            this.mPendingZoomRatioCompleter = completer;
        }
        if (completer2 == null) {
            return "setZoomRatio";
        }
        completer2.setException(new CameraControl.OperationCanceledException("There is a new zoomRatio being set"));
        return "setZoomRatio";
    }

    LiveData<ZoomState> getZoomState() {
        return this.mZoomStateLiveData;
    }

    @WorkerThread
    void setActive(boolean z) {
        boolean z2;
        CallbackToFutureAdapter.Completer<Void> completer;
        synchronized (this.mActiveLock) {
            if (this.mIsActive == z) {
                return;
            }
            this.mIsActive = z;
            if (this.mIsActive) {
                z2 = false;
                completer = null;
            } else {
                synchronized (this.mCompleterLock) {
                    if (this.mPendingZoomRatioCompleter != null) {
                        completer = this.mPendingZoomRatioCompleter;
                        this.mPendingZoomRatioCompleter = null;
                        this.mPendingZoomCropRegion = null;
                    } else {
                        completer = null;
                    }
                }
                z2 = true;
                this.mCurrentZoomState.setZoomRatio(1.0f);
                updateLiveData(ImmutableZoomState.create(this.mCurrentZoomState));
            }
            if (z2) {
                this.mCamera2CameraControl.setCropRegion(null);
            }
            if (completer != null) {
                completer.setException(new CameraControl.OperationCanceledException("Camera is not active."));
            }
        }
    }

    @NonNull
    c.b.b.a.a.a<Void> setLinearZoom(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        synchronized (this.mActiveLock) {
            if (!this.mIsActive) {
                return Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active."));
            }
            try {
                this.mCurrentZoomState.setLinearZoom(f2);
                updateLiveData(ImmutableZoomState.create(this.mCurrentZoomState));
                return submitCameraZoomRatio(this.mCurrentZoomState.getZoomRatio());
            } catch (IllegalArgumentException e2) {
                return Futures.immediateFailedFuture(e2);
            }
        }
    }

    @NonNull
    c.b.b.a.a.a<Void> setZoomRatio(float f2) {
        synchronized (this.mActiveLock) {
            if (!this.mIsActive) {
                return Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active."));
            }
            try {
                this.mCurrentZoomState.setZoomRatio(f2);
                updateLiveData(ImmutableZoomState.create(this.mCurrentZoomState));
                return submitCameraZoomRatio(f2);
            } catch (IllegalArgumentException e2) {
                return Futures.immediateFailedFuture(e2);
            }
        }
    }
}
