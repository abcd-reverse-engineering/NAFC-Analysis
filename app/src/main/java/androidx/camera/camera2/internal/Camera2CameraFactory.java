package androidx.camera.camera2.internal;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraXThreads;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.LensFacingCameraIdFilter;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class Camera2CameraFactory implements CameraFactory {
    private static final int DEFAULT_ALLOWED_CONCURRENT_OPEN_CAMERAS = 1;
    private static final Handler sHandler;
    private static final HandlerThread sHandlerThread = new HandlerThread(CameraXThreads.TAG);
    private final CameraAvailabilityRegistry mAvailabilityRegistry = new CameraAvailabilityRegistry(1, CameraXExecutors.newHandlerExecutor(sHandler));
    private final CameraManagerCompat mCameraManager;

    static {
        sHandlerThread.start();
        sHandler = new Handler(sHandlerThread.getLooper());
    }

    public Camera2CameraFactory(@NonNull Context context) {
        this.mCameraManager = CameraManagerCompat.from(context);
    }

    @Override // androidx.camera.core.impl.CameraFactory
    @Nullable
    public String cameraIdForLensFacing(int i2) throws CameraInfoUnavailableException {
        Set<String> setFilter = getLensFacingCameraIdFilter(i2).filter(getAvailableCameraIds());
        if (setFilter.isEmpty()) {
            return null;
        }
        return setFilter.iterator().next();
    }

    @Override // androidx.camera.core.impl.CameraFactory
    @NonNull
    public Set<String> getAvailableCameraIds() throws CameraInfoUnavailableException {
        try {
            return new LinkedHashSet(Arrays.asList(this.mCameraManager.unwrap().getCameraIdList()));
        } catch (CameraAccessException e2) {
            throw new CameraInfoUnavailableException("Unable to retrieve list of cameras on device.", e2);
        }
    }

    @Override // androidx.camera.core.impl.CameraFactory
    @NonNull
    public CameraInternal getCamera(@NonNull String str) throws CameraInfoUnavailableException {
        if (!getAvailableCameraIds().contains(str)) {
            throw new IllegalArgumentException("The given camera id is not on the available camera id list.");
        }
        Camera2CameraImpl camera2CameraImpl = new Camera2CameraImpl(this.mCameraManager, str, this.mAvailabilityRegistry.getAvailableCameraCount(), sHandler);
        this.mAvailabilityRegistry.registerCamera(camera2CameraImpl);
        return camera2CameraImpl;
    }

    @Override // androidx.camera.core.impl.CameraFactory
    @NonNull
    public LensFacingCameraIdFilter getLensFacingCameraIdFilter(int i2) {
        return new Camera2LensFacingCameraIdFilter(i2, this.mCameraManager.unwrap());
    }
}
