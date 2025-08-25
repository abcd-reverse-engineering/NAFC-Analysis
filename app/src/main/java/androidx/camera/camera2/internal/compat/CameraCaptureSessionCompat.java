package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;
import java.util.concurrent.Executor;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class CameraCaptureSessionCompat {
    private static final CameraCaptureSessionCompatImpl IMPL = chooseImplementation();

    interface CameraCaptureSessionCompatImpl {
        int captureBurstRequests(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull List<CaptureRequest> list, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

        int captureSingleRequest(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

        int setRepeatingBurstRequests(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull List<CaptureRequest> list, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

        int setSingleRepeatingRequest(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;
    }

    static final class CaptureCallbackExecutorWrapper extends CameraCaptureSession.CaptureCallback {
        private final Executor mExecutor;
        final CameraCaptureSession.CaptureCallback mWrappedCallback;

        CaptureCallbackExecutorWrapper(@NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) {
            this.mExecutor = executor;
            this.mWrappedCallback = captureCallback;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        @RequiresApi(24)
        public void onCaptureBufferLost(@NonNull final CameraCaptureSession cameraCaptureSession, @NonNull final CaptureRequest captureRequest, @NonNull final Surface surface, final long j2) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper.7
                @Override // java.lang.Runnable
                public void run() {
                    CaptureCallbackExecutorWrapper.this.mWrappedCallback.onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, j2);
                }
            });
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(@NonNull final CameraCaptureSession cameraCaptureSession, @NonNull final CaptureRequest captureRequest, @NonNull final TotalCaptureResult totalCaptureResult) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper.3
                @Override // java.lang.Runnable
                public void run() {
                    CaptureCallbackExecutorWrapper.this.mWrappedCallback.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
                }
            });
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureFailed(@NonNull final CameraCaptureSession cameraCaptureSession, @NonNull final CaptureRequest captureRequest, @NonNull final CaptureFailure captureFailure) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper.4
                @Override // java.lang.Runnable
                public void run() {
                    CaptureCallbackExecutorWrapper.this.mWrappedCallback.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                }
            });
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(@NonNull final CameraCaptureSession cameraCaptureSession, @NonNull final CaptureRequest captureRequest, @NonNull final CaptureResult captureResult) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper.2
                @Override // java.lang.Runnable
                public void run() {
                    CaptureCallbackExecutorWrapper.this.mWrappedCallback.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
                }
            });
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceAborted(@NonNull final CameraCaptureSession cameraCaptureSession, final int i2) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper.6
                @Override // java.lang.Runnable
                public void run() {
                    CaptureCallbackExecutorWrapper.this.mWrappedCallback.onCaptureSequenceAborted(cameraCaptureSession, i2);
                }
            });
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceCompleted(@NonNull final CameraCaptureSession cameraCaptureSession, final int i2, final long j2) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper.5
                @Override // java.lang.Runnable
                public void run() {
                    CaptureCallbackExecutorWrapper.this.mWrappedCallback.onCaptureSequenceCompleted(cameraCaptureSession, i2, j2);
                }
            });
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(@NonNull final CameraCaptureSession cameraCaptureSession, @NonNull final CaptureRequest captureRequest, final long j2, final long j3) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper.1
                @Override // java.lang.Runnable
                public void run() {
                    CaptureCallbackExecutorWrapper.this.mWrappedCallback.onCaptureStarted(cameraCaptureSession, captureRequest, j2, j3);
                }
            });
        }
    }

    static final class StateCallbackExecutorWrapper extends CameraCaptureSession.StateCallback {
        private final Executor mExecutor;
        final CameraCaptureSession.StateCallback mWrappedCallback;

        StateCallbackExecutorWrapper(@NonNull Executor executor, @NonNull CameraCaptureSession.StateCallback stateCallback) {
            this.mExecutor = executor;
            this.mWrappedCallback = stateCallback;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onActive(@NonNull final CameraCaptureSession cameraCaptureSession) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.StateCallbackExecutorWrapper.4
                @Override // java.lang.Runnable
                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onActive(cameraCaptureSession);
                }
            });
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        @RequiresApi(26)
        public void onCaptureQueueEmpty(@NonNull final CameraCaptureSession cameraCaptureSession) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.StateCallbackExecutorWrapper.5
                @Override // java.lang.Runnable
                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onCaptureQueueEmpty(cameraCaptureSession);
                }
            });
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onClosed(@NonNull final CameraCaptureSession cameraCaptureSession) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.StateCallbackExecutorWrapper.6
                @Override // java.lang.Runnable
                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onClosed(cameraCaptureSession);
                }
            });
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(@NonNull final CameraCaptureSession cameraCaptureSession) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.StateCallbackExecutorWrapper.2
                @Override // java.lang.Runnable
                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onConfigureFailed(cameraCaptureSession);
                }
            });
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(@NonNull final CameraCaptureSession cameraCaptureSession) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.StateCallbackExecutorWrapper.1
                @Override // java.lang.Runnable
                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onConfigured(cameraCaptureSession);
                }
            });
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onReady(@NonNull final CameraCaptureSession cameraCaptureSession) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.StateCallbackExecutorWrapper.3
                @Override // java.lang.Runnable
                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onReady(cameraCaptureSession);
                }
            });
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        @RequiresApi(23)
        public void onSurfacePrepared(@NonNull final CameraCaptureSession cameraCaptureSession, @NonNull final Surface surface) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.StateCallbackExecutorWrapper.7
                @Override // java.lang.Runnable
                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onSurfacePrepared(cameraCaptureSession, surface);
                }
            });
        }
    }

    private CameraCaptureSessionCompat() {
    }

    public static int captureBurstRequests(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull List<CaptureRequest> list, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return IMPL.captureBurstRequests(cameraCaptureSession, list, executor, captureCallback);
    }

    public static int captureSingleRequest(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return IMPL.captureSingleRequest(cameraCaptureSession, captureRequest, executor, captureCallback);
    }

    private static CameraCaptureSessionCompatImpl chooseImplementation() {
        return Build.VERSION.SDK_INT >= 28 ? new CameraCaptureSessionCompatApi28Impl() : new CameraCaptureSessionCompatBaseImpl();
    }

    public static int setRepeatingBurstRequests(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull List<CaptureRequest> list, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return IMPL.setRepeatingBurstRequests(cameraCaptureSession, list, executor, captureCallback);
    }

    public static int setSingleRepeatingRequest(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return IMPL.setSingleRepeatingRequest(cameraCaptureSession, captureRequest, executor, captureCallback);
    }
}
