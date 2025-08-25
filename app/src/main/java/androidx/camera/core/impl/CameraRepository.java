package androidx.camera.core.impl;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.UseCaseGroup;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class CameraRepository implements UseCaseGroup.StateChangeCallback {
    private static final String TAG = "CameraRepository";

    @GuardedBy("mCamerasLock")
    private CallbackToFutureAdapter.Completer<Void> mDeinitCompleter;

    @GuardedBy("mCamerasLock")
    private c.b.b.a.a.a<Void> mDeinitFuture;
    private final Object mCamerasLock = new Object();

    @GuardedBy("mCamerasLock")
    private final Map<String, CameraInternal> mCameras = new HashMap();

    @GuardedBy("mCamerasLock")
    private final Set<CameraInternal> mReleasingCameras = new HashSet();

    @GuardedBy("mCamerasLock")
    private void attachUseCasesToCamera(CameraInternal cameraInternal, Set<UseCase> set) {
        cameraInternal.addOnlineUseCase(set);
    }

    @GuardedBy("mCamerasLock")
    private void detachUseCasesFromCamera(CameraInternal cameraInternal, Set<UseCase> set) {
        cameraInternal.removeOnlineUseCase(set);
    }

    public /* synthetic */ Object a(CallbackToFutureAdapter.Completer completer) throws Exception {
        Preconditions.checkState(Thread.holdsLock(this.mCamerasLock));
        this.mDeinitCompleter = completer;
        return "CameraRepository-deinit";
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public c.b.b.a.a.a<Void> deinit() {
        synchronized (this.mCamerasLock) {
            if (this.mCameras.isEmpty()) {
                return this.mDeinitFuture == null ? Futures.immediateFuture(null) : this.mDeinitFuture;
            }
            c.b.b.a.a.a<Void> future = this.mDeinitFuture;
            if (future == null) {
                future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.impl.a
                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                        return this.f1484a.a(completer);
                    }
                });
                this.mDeinitFuture = future;
            }
            this.mReleasingCameras.addAll(this.mCameras.values());
            for (final CameraInternal cameraInternal : this.mCameras.values()) {
                cameraInternal.release().addListener(new Runnable() { // from class: androidx.camera.core.impl.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f1485a.a(cameraInternal);
                    }
                }, CameraXExecutors.directExecutor());
            }
            this.mCameras.clear();
            return future;
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraInternal getCamera(@NonNull String str) {
        CameraInternal cameraInternal;
        synchronized (this.mCamerasLock) {
            cameraInternal = this.mCameras.get(str);
            if (cameraInternal == null) {
                throw new IllegalArgumentException("Invalid camera: " + str);
            }
        }
        return cameraInternal;
    }

    @NonNull
    Set<String> getCameraIds() {
        HashSet hashSet;
        synchronized (this.mCamerasLock) {
            hashSet = new HashSet(this.mCameras.keySet());
        }
        return hashSet;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void init(@NonNull CameraFactory cameraFactory) {
        synchronized (this.mCamerasLock) {
            try {
                try {
                    for (String str : cameraFactory.getAvailableCameraIds()) {
                        String str2 = "Added camera: " + str;
                        this.mCameras.put(str, cameraFactory.getCamera(str));
                    }
                } catch (Exception e2) {
                    throw new IllegalStateException("Unable to enumerate cameras", e2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.impl.UseCaseGroup.StateChangeCallback
    public void onGroupActive(@NonNull UseCaseGroup useCaseGroup) {
        synchronized (this.mCamerasLock) {
            for (Map.Entry<String, Set<UseCase>> entry : useCaseGroup.getCameraIdToUseCaseMap().entrySet()) {
                attachUseCasesToCamera(getCamera(entry.getKey()), entry.getValue());
            }
        }
    }

    @Override // androidx.camera.core.impl.UseCaseGroup.StateChangeCallback
    public void onGroupInactive(@NonNull UseCaseGroup useCaseGroup) {
        synchronized (this.mCamerasLock) {
            for (Map.Entry<String, Set<UseCase>> entry : useCaseGroup.getCameraIdToUseCaseMap().entrySet()) {
                detachUseCasesFromCamera(getCamera(entry.getKey()), entry.getValue());
            }
        }
    }

    public /* synthetic */ void a(CameraInternal cameraInternal) {
        synchronized (this.mCamerasLock) {
            this.mReleasingCameras.remove(cameraInternal);
            if (this.mReleasingCameras.isEmpty()) {
                Preconditions.checkNotNull(this.mDeinitCompleter);
                this.mDeinitCompleter.set(null);
                this.mDeinitCompleter = null;
                this.mDeinitFuture = null;
            }
        }
    }
}
