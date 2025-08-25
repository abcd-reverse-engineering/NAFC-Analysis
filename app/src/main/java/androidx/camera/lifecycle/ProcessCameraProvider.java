package androidx.camera.lifecycle;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LifecycleOwner;

/* loaded from: classes.dex */
public final class ProcessCameraProvider implements LifecycleCameraProvider {
    private static final ProcessCameraProvider sAppInstance = new ProcessCameraProvider();

    private ProcessCameraProvider() {
    }

    @NonNull
    public static c.b.b.a.a.a<ProcessCameraProvider> getInstance(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        return Futures.transform(CameraX.getOrCreateInstance(context), new Function() { // from class: androidx.camera.lifecycle.a
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return ProcessCameraProvider.sAppInstance;
            }
        }, CameraXExecutors.directExecutor());
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public static void initializeInstance(@NonNull Context context, @NonNull CameraXConfig cameraXConfig) {
        Futures.addCallback(CameraX.initialize(context, cameraXConfig), new FutureCallback<Void>() { // from class: androidx.camera.lifecycle.ProcessCameraProvider.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                throw new RuntimeException(th);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable Void r1) {
            }
        }, CameraXExecutors.directExecutor());
    }

    @NonNull
    @MainThread
    public Camera bindToLifecycle(@NonNull LifecycleOwner lifecycleOwner, @NonNull CameraSelector cameraSelector, @NonNull UseCase... useCaseArr) {
        return CameraX.bindToLifecycle(lifecycleOwner, cameraSelector, useCaseArr);
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public boolean hasCamera(@NonNull CameraSelector cameraSelector) throws CameraInfoUnavailableException {
        return CameraX.hasCamera(cameraSelector);
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public boolean isBound(@NonNull UseCase useCase) {
        return CameraX.isBound(useCase);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.TESTS})
    public c.b.b.a.a.a<Void> shutdown() {
        return CameraX.shutdown();
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    @MainThread
    public void unbind(@NonNull UseCase... useCaseArr) {
        CameraX.unbind(useCaseArr);
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    @MainThread
    public void unbindAll() {
        CameraX.unbindAll();
    }
}
