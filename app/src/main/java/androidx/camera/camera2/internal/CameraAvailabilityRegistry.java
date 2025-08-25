package androidx.camera.camera2.internal;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.LiveDataObservable;
import androidx.camera.core.impl.Observable;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class CameraAvailabilityRegistry {
    private static final boolean DEBUG = false;
    private static final String TAG = "AvailabilityRegistry";
    private final Executor mExecutor;
    final int mMaxAllowedOpenedCameras;
    private StringBuilder mDebugString = null;
    private final Object mLock = new Object();

    @GuardedBy("mLock")
    private final Map<CameraInternal, CameraInternal.State> mCameraStates = new HashMap();
    private final LiveDataObservable<Integer> mAvailableCameras = new LiveDataObservable<>();

    CameraAvailabilityRegistry(int i2, @NonNull Executor executor) {
        this.mMaxAllowedOpenedCameras = i2;
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        this.mAvailableCameras.postValue(Integer.valueOf(i2));
    }

    @GuardedBy("mLock")
    @WorkerThread
    private int recalculateAvailableCameras() {
        int i2 = 0;
        for (Map.Entry<CameraInternal, CameraInternal.State> entry : this.mCameraStates.entrySet()) {
            if (entry.getValue() != CameraInternal.State.CLOSED && entry.getValue() != CameraInternal.State.OPENING && entry.getValue() != CameraInternal.State.PENDING_OPEN) {
                i2++;
            }
        }
        return Math.max(this.mMaxAllowedOpenedCameras - i2, 0);
    }

    Observable<Integer> getAvailableCameraCount() {
        return this.mAvailableCameras;
    }

    void registerCamera(@NonNull final CameraInternal cameraInternal) {
        synchronized (this.mLock) {
            if (!this.mCameraStates.containsKey(cameraInternal)) {
                this.mCameraStates.put(cameraInternal, null);
                cameraInternal.getCameraState().addObserver(this.mExecutor, new Observable.Observer<CameraInternal.State>() { // from class: androidx.camera.camera2.internal.CameraAvailabilityRegistry.1
                    @Override // androidx.camera.core.impl.Observable.Observer
                    public void onError(@NonNull Throwable th) {
                    }

                    @Override // androidx.camera.core.impl.Observable.Observer
                    public void onNewData(@Nullable CameraInternal.State state) {
                        if (state == CameraInternal.State.RELEASED) {
                            CameraAvailabilityRegistry.this.unregisterCamera(cameraInternal, this);
                        } else {
                            CameraAvailabilityRegistry.this.updateState(cameraInternal, state);
                        }
                    }
                });
            }
        }
    }

    @WorkerThread
    void unregisterCamera(CameraInternal cameraInternal, Observable.Observer<CameraInternal.State> observer) {
        synchronized (this.mLock) {
            cameraInternal.getCameraState().removeObserver(observer);
            if (this.mCameraStates.remove(cameraInternal) == null) {
                return;
            }
            this.mAvailableCameras.postValue(Integer.valueOf(recalculateAvailableCameras()));
        }
    }

    @WorkerThread
    void updateState(CameraInternal cameraInternal, CameraInternal.State state) {
        synchronized (this.mLock) {
            if (this.mCameraStates.containsKey(cameraInternal) && this.mCameraStates.put(cameraInternal, state) != state) {
                this.mAvailableCameras.postValue(Integer.valueOf(recalculateAvailableCameras()));
            }
        }
    }
}
