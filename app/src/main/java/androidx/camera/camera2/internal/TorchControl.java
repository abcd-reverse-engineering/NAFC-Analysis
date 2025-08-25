package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.Camera2CameraControl;
import androidx.camera.core.CameraControl;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/* loaded from: classes.dex */
final class TorchControl {
    private static final String TAG = "TorchControl";
    private final Camera2CameraControl mCamera2CameraControl;

    @GuardedBy("mEnableTorchLock")
    CallbackToFutureAdapter.Completer<Void> mEnableTorchCompleter;
    private final boolean mHasFlashUnit;

    @GuardedBy("mActiveLock")
    private boolean mIsActive;

    @GuardedBy("mEnableTorchLock")
    boolean mTargetTorchEnabled;
    private final MutableLiveData<Integer> mTorchState;
    final Object mEnableTorchLock = new Object();
    private final Object mActiveLock = new Object();
    private final Camera2CameraControl.CaptureResultListener mCaptureResultListener = new Camera2CameraControl.CaptureResultListener() { // from class: androidx.camera.camera2.internal.TorchControl.1
        /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
        @Override // androidx.camera.camera2.internal.Camera2CameraControl.CaptureResultListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onCaptureResult(@androidx.annotation.NonNull android.hardware.camera2.TotalCaptureResult r5) {
            /*
                r4 = this;
                androidx.camera.camera2.internal.TorchControl r0 = androidx.camera.camera2.internal.TorchControl.this
                java.lang.Object r0 = r0.mEnableTorchLock
                monitor-enter(r0)
                androidx.camera.camera2.internal.TorchControl r1 = androidx.camera.camera2.internal.TorchControl.this     // Catch: java.lang.Throwable -> L3c
                androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.lang.Void> r1 = r1.mEnableTorchCompleter     // Catch: java.lang.Throwable -> L3c
                r2 = 0
                r3 = 0
                if (r1 == 0) goto L34
                android.hardware.camera2.CaptureRequest r5 = r5.getRequest()     // Catch: java.lang.Throwable -> L3c
                android.hardware.camera2.CaptureRequest$Key r1 = android.hardware.camera2.CaptureRequest.FLASH_MODE     // Catch: java.lang.Throwable -> L3c
                java.lang.Object r5 = r5.get(r1)     // Catch: java.lang.Throwable -> L3c
                java.lang.Integer r5 = (java.lang.Integer) r5     // Catch: java.lang.Throwable -> L3c
                if (r5 == 0) goto L24
                int r5 = r5.intValue()     // Catch: java.lang.Throwable -> L3c
                r1 = 2
                if (r5 != r1) goto L24
                r5 = 1
                goto L25
            L24:
                r5 = 0
            L25:
                androidx.camera.camera2.internal.TorchControl r1 = androidx.camera.camera2.internal.TorchControl.this     // Catch: java.lang.Throwable -> L3c
                boolean r1 = r1.mTargetTorchEnabled     // Catch: java.lang.Throwable -> L3c
                if (r5 != r1) goto L34
                androidx.camera.camera2.internal.TorchControl r5 = androidx.camera.camera2.internal.TorchControl.this     // Catch: java.lang.Throwable -> L3c
                androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.lang.Void> r5 = r5.mEnableTorchCompleter     // Catch: java.lang.Throwable -> L3c
                androidx.camera.camera2.internal.TorchControl r1 = androidx.camera.camera2.internal.TorchControl.this     // Catch: java.lang.Throwable -> L3c
                r1.mEnableTorchCompleter = r3     // Catch: java.lang.Throwable -> L3c
                goto L35
            L34:
                r5 = r3
            L35:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L3c
                if (r5 == 0) goto L3b
                r5.set(r3)
            L3b:
                return r2
            L3c:
                r5 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L3c
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.TorchControl.AnonymousClass1.onCaptureResult(android.hardware.camera2.TotalCaptureResult):boolean");
        }
    };

    TorchControl(@NonNull Camera2CameraControl camera2CameraControl, @NonNull CameraCharacteristics cameraCharacteristics) {
        this.mCamera2CameraControl = camera2CameraControl;
        Boolean bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        this.mHasFlashUnit = bool != null && bool.booleanValue();
        this.mTorchState = new MutableLiveData<>(0);
        this.mCamera2CameraControl.addCaptureResultListener(this.mCaptureResultListener);
    }

    private <T> void setLiveDataValue(@NonNull MutableLiveData<T> mutableLiveData, T t) {
        if (Threads.isMainThread()) {
            mutableLiveData.setValue(t);
        } else {
            mutableLiveData.postValue(t);
        }
    }

    public /* synthetic */ Object a(boolean z, CallbackToFutureAdapter.Completer completer) throws Exception {
        CallbackToFutureAdapter.Completer<Void> completer2;
        synchronized (this.mEnableTorchLock) {
            completer2 = this.mEnableTorchCompleter != null ? this.mEnableTorchCompleter : null;
            this.mEnableTorchCompleter = completer;
            this.mTargetTorchEnabled = z;
            this.mCamera2CameraControl.enableTorchInternal(z);
        }
        setLiveDataValue(this.mTorchState, Integer.valueOf(z ? 1 : 0));
        if (completer2 != null) {
            completer2.setException(new CameraControl.OperationCanceledException("There is a new enableTorch being set"));
        }
        return "enableTorch: " + z;
    }

    c.b.b.a.a.a<Void> enableTorch(final boolean z) {
        if (!this.mHasFlashUnit) {
            return Futures.immediateFailedFuture(new IllegalStateException("No flash unit"));
        }
        synchronized (this.mActiveLock) {
            if (this.mIsActive) {
                return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.internal.y
                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                        return this.f1441a.a(z, completer);
                    }
                });
            }
            return Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active."));
        }
    }

    @NonNull
    LiveData<Integer> getTorchState() {
        return this.mTorchState;
    }

    void setActive(boolean z) {
        CallbackToFutureAdapter.Completer<Void> completer;
        boolean z2;
        synchronized (this.mActiveLock) {
            if (this.mIsActive == z) {
                return;
            }
            this.mIsActive = z;
            synchronized (this.mEnableTorchLock) {
                completer = null;
                if (!z) {
                    if (this.mEnableTorchCompleter != null) {
                        CallbackToFutureAdapter.Completer<Void> completer2 = this.mEnableTorchCompleter;
                        this.mEnableTorchCompleter = null;
                        completer = completer2;
                    }
                    if (this.mTargetTorchEnabled) {
                        z2 = true;
                        this.mTargetTorchEnabled = false;
                        this.mCamera2CameraControl.enableTorchInternal(false);
                    }
                }
                z2 = false;
            }
            if (z2) {
                setLiveDataValue(this.mTorchState, 0);
            }
            if (completer != null) {
                completer.setException(new CameraControl.OperationCanceledException("Camera is not active."));
            }
        }
    }
}
