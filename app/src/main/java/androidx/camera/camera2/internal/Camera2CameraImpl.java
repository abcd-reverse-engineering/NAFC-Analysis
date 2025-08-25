package androidx.camera.camera2.internal;

import android.annotation.SuppressLint;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Rational;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.camera.camera2.internal.CaptureSession;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.LiveDataObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseAttachState;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import cn.cloudwalk.libproject.Contants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
final class Camera2CameraImpl implements CameraInternal {
    private static final int ERROR_NONE = 0;
    private static final String TAG = "Camera";
    private final Observable<Integer> mAvailableCamerasObservable;
    private final CameraAvailability mCameraAvailability;
    private final Camera2CameraControl mCameraControlInternal;

    @Nullable
    CameraDevice mCameraDevice;

    @NonNull
    final CameraInfoInternal mCameraInfoInternal;
    private final CameraManagerCompat mCameraManager;
    CaptureSession mCaptureSession;
    private final Executor mExecutor;
    final Handler mHandler;
    private final UseCaseAttachState mUseCaseAttachState;
    c.b.b.a.a.a<Void> mUserReleaseFuture;
    CallbackToFutureAdapter.Completer<Void> mUserReleaseNotifier;
    volatile InternalState mState = InternalState.INITIALIZED;
    private final LiveDataObservable<CameraInternal.State> mObservableState = new LiveDataObservable<>();
    private final StateCallback mStateCallback = new StateCallback();
    int mCameraDeviceError = 0;
    private CaptureSession.Builder mCaptureSessionBuilder = new CaptureSession.Builder();
    SessionConfig mCameraControlSessionConfig = SessionConfig.defaultEmptySessionConfig();
    final AtomicInteger mReleaseRequestCount = new AtomicInteger(0);
    final Map<CaptureSession, c.b.b.a.a.a<Void>> mReleasedCaptureSessions = new LinkedHashMap();
    final Set<CaptureSession> mConfiguringForClose = new HashSet();

    /* renamed from: androidx.camera.camera2.internal.Camera2CameraImpl$15, reason: invalid class name */
    static /* synthetic */ class AnonymousClass15 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState = new int[InternalState.values().length];

        static {
            try {
                $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[InternalState.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[InternalState.CLOSING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[InternalState.OPENED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[InternalState.OPENING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[InternalState.REOPENING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[InternalState.PENDING_OPEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[InternalState.RELEASING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[InternalState.RELEASED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    final class CameraAvailability extends CameraManager.AvailabilityCallback implements Observable.Observer<Integer> {
        private final String mCameraId;
        private boolean mCameraAvailable = true;
        private int mNumAvailableCameras = 0;

        CameraAvailability(String str) {
            this.mCameraId = str;
        }

        boolean isCameraAvailable() {
            return this.mCameraAvailable && this.mNumAvailableCameras > 0;
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraAvailable(@NonNull String str) {
            if (this.mCameraId.equals(str)) {
                this.mCameraAvailable = true;
                if (Camera2CameraImpl.this.mState == InternalState.PENDING_OPEN) {
                    Camera2CameraImpl.this.openCameraDevice();
                }
            }
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraUnavailable(@NonNull String str) {
            if (this.mCameraId.equals(str)) {
                this.mCameraAvailable = false;
            }
        }

        @Override // androidx.camera.core.impl.Observable.Observer
        public void onError(@NonNull Throwable th) {
        }

        @Override // androidx.camera.core.impl.Observable.Observer
        public void onNewData(@Nullable Integer num) {
            Preconditions.checkNotNull(num);
            if (num.intValue() != this.mNumAvailableCameras) {
                this.mNumAvailableCameras = num.intValue();
                if (Camera2CameraImpl.this.mState == InternalState.PENDING_OPEN) {
                    Camera2CameraImpl.this.openCameraDevice();
                }
            }
        }
    }

    final class ControlUpdateListenerInternal implements CameraControlInternal.ControlUpdateCallback {
        ControlUpdateListenerInternal() {
        }

        @Override // androidx.camera.core.impl.CameraControlInternal.ControlUpdateCallback
        public void onCameraControlCaptureRequests(@NonNull List<CaptureConfig> list) {
            Camera2CameraImpl.this.submitCaptureRequests((List) Preconditions.checkNotNull(list));
        }

        @Override // androidx.camera.core.impl.CameraControlInternal.ControlUpdateCallback
        public void onCameraControlUpdateSessionConfig(@NonNull SessionConfig sessionConfig) {
            Camera2CameraImpl.this.mCameraControlSessionConfig = (SessionConfig) Preconditions.checkNotNull(sessionConfig);
            Camera2CameraImpl.this.updateCaptureSessionConfig();
        }
    }

    enum InternalState {
        INITIALIZED,
        PENDING_OPEN,
        OPENING,
        OPENED,
        CLOSING,
        REOPENING,
        RELEASING,
        RELEASED
    }

    final class StateCallback extends CameraDevice.StateCallback {
        StateCallback() {
        }

        private void handleErrorOnOpen(@NonNull CameraDevice cameraDevice, int i2) {
            Preconditions.checkState(Camera2CameraImpl.this.mState == InternalState.OPENING || Camera2CameraImpl.this.mState == InternalState.OPENED || Camera2CameraImpl.this.mState == InternalState.REOPENING, "Attempt to handle open error from non open state: " + Camera2CameraImpl.this.mState);
            if (i2 == 1 || i2 == 2 || i2 == 4) {
                reopenCameraAfterError();
                return;
            }
            String str = "Error observed on open (or opening) camera device " + cameraDevice.getId() + ": " + Camera2CameraImpl.getErrorMessage(i2);
            Camera2CameraImpl.this.setState(InternalState.CLOSING);
            Camera2CameraImpl.this.closeCamera(false);
        }

        private void reopenCameraAfterError() {
            Preconditions.checkState(Camera2CameraImpl.this.mCameraDeviceError != 0, "Can only reopen camera device after error if the camera device is actually in an error state.");
            Camera2CameraImpl.this.setState(InternalState.REOPENING);
            Camera2CameraImpl.this.closeCamera(false);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(CameraDevice cameraDevice) {
            String str = "CameraDevice.onClosed(): " + cameraDevice.getId();
            Preconditions.checkState(Camera2CameraImpl.this.mCameraDevice == null, "Unexpected onClose callback on camera device: " + cameraDevice);
            int i2 = AnonymousClass15.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[Camera2CameraImpl.this.mState.ordinal()];
            if (i2 != 2) {
                if (i2 == 5) {
                    Camera2CameraImpl.this.openCameraDevice();
                    return;
                } else if (i2 != 7) {
                    throw new IllegalStateException("Camera closed while in state: " + Camera2CameraImpl.this.mState);
                }
            }
            Preconditions.checkState(Camera2CameraImpl.this.isSessionCloseComplete());
            Camera2CameraImpl.this.finishClose();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            String str = "CameraDevice.onDisconnected(): " + cameraDevice.getId();
            Iterator<CaptureSession> it = Camera2CameraImpl.this.mReleasedCaptureSessions.keySet().iterator();
            while (it.hasNext()) {
                it.next().forceClose();
            }
            Camera2CameraImpl.this.mCaptureSession.forceClose();
            onError(cameraDevice, 1);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(@NonNull CameraDevice cameraDevice, int i2) {
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            camera2CameraImpl.mCameraDevice = cameraDevice;
            camera2CameraImpl.mCameraDeviceError = i2;
            int i3 = AnonymousClass15.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[camera2CameraImpl.mState.ordinal()];
            if (i3 != 2) {
                if (i3 == 3 || i3 == 4 || i3 == 5) {
                    handleErrorOnOpen(cameraDevice, i2);
                    return;
                } else if (i3 != 7) {
                    throw new IllegalStateException("onError() should not be possible from state: " + Camera2CameraImpl.this.mState);
                }
            }
            String str = "CameraDevice.onError(): " + cameraDevice.getId() + " with error: " + Camera2CameraImpl.getErrorMessage(i2);
            Camera2CameraImpl.this.closeCamera(false);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) throws CameraAccessException {
            String str = "CameraDevice.onOpened(): " + cameraDevice.getId();
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            camera2CameraImpl.mCameraDevice = cameraDevice;
            camera2CameraImpl.updateDefaultRequestBuilderToCameraControl(cameraDevice);
            Camera2CameraImpl camera2CameraImpl2 = Camera2CameraImpl.this;
            camera2CameraImpl2.mCameraDeviceError = 0;
            int i2 = AnonymousClass15.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[camera2CameraImpl2.mState.ordinal()];
            if (i2 == 2 || i2 == 7) {
                Preconditions.checkState(Camera2CameraImpl.this.isSessionCloseComplete());
                Camera2CameraImpl.this.mCameraDevice.close();
                Camera2CameraImpl.this.mCameraDevice = null;
            } else if (i2 == 4 || i2 == 5) {
                Camera2CameraImpl.this.setState(InternalState.OPENED);
                Camera2CameraImpl.this.openCaptureSession();
            } else {
                throw new IllegalStateException("onOpened() should not be possible from state: " + Camera2CameraImpl.this.mState);
            }
        }
    }

    Camera2CameraImpl(CameraManagerCompat cameraManagerCompat, String str, @NonNull Observable<Integer> observable, Handler handler) throws CameraAccessException {
        this.mCameraManager = cameraManagerCompat;
        this.mAvailableCamerasObservable = observable;
        this.mHandler = handler;
        ScheduledExecutorService scheduledExecutorServiceNewHandlerExecutor = CameraXExecutors.newHandlerExecutor(this.mHandler);
        this.mExecutor = scheduledExecutorServiceNewHandlerExecutor;
        this.mUseCaseAttachState = new UseCaseAttachState(str);
        this.mObservableState.postValue(CameraInternal.State.CLOSED);
        try {
            CameraCharacteristics cameraCharacteristics = this.mCameraManager.unwrap().getCameraCharacteristics(str);
            this.mCameraControlInternal = new Camera2CameraControl(cameraCharacteristics, scheduledExecutorServiceNewHandlerExecutor, scheduledExecutorServiceNewHandlerExecutor, new ControlUpdateListenerInternal());
            this.mCameraInfoInternal = new Camera2CameraInfoImpl(str, cameraCharacteristics, this.mCameraControlInternal.getZoomControl(), this.mCameraControlInternal.getTorchControl());
            this.mCaptureSessionBuilder.setSupportedHardwareLevel(((Camera2CameraInfoImpl) this.mCameraInfoInternal).getSupportedHardwareLevel());
            this.mCaptureSessionBuilder.setExecutor(this.mExecutor);
            this.mCaptureSessionBuilder.setScheduledExecutorService(scheduledExecutorServiceNewHandlerExecutor);
            this.mCaptureSession = this.mCaptureSessionBuilder.build();
            this.mCameraAvailability = new CameraAvailability(str);
            this.mAvailableCamerasObservable.addObserver(this.mExecutor, this.mCameraAvailability);
            this.mCameraManager.registerAvailabilityCallback(this.mExecutor, this.mCameraAvailability);
        } catch (CameraAccessException e2) {
            throw new IllegalStateException("Cannot access camera", e2);
        }
    }

    private boolean checkAndAttachRepeatingSurface(CaptureConfig.Builder builder) {
        if (!builder.getSurfaces().isEmpty()) {
            return false;
        }
        Iterator<UseCase> it = this.mUseCaseAttachState.getActiveAndOnlineUseCases().iterator();
        while (it.hasNext()) {
            List<DeferrableSurface> surfaces = it.next().getSessionConfig(this.mCameraInfoInternal.getCameraId()).getRepeatingCaptureConfig().getSurfaces();
            if (!surfaces.isEmpty()) {
                Iterator<DeferrableSurface> it2 = surfaces.iterator();
                while (it2.hasNext()) {
                    builder.addSurface(it2.next());
                }
            }
        }
        return !builder.getSurfaces().isEmpty();
    }

    private void clearCameraControlPreviewAspectRatio(Collection<UseCase> collection) {
        Iterator<UseCase> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof Preview) {
                this.mCameraControlInternal.setPreviewAspectRatio(null);
                return;
            }
        }
    }

    @WorkerThread
    private void configAndClose(boolean z) {
        final CaptureSession captureSessionBuild = this.mCaptureSessionBuilder.build();
        this.mConfiguringForClose.add(captureSessionBuild);
        resetCaptureSession(z);
        final SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(Contants.PREVIEW_W, 480);
        final Surface surface = new Surface(surfaceTexture);
        final Runnable runnable = new Runnable() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl.3
            @Override // java.lang.Runnable
            public void run() {
                surface.release();
                surfaceTexture.release();
            }
        };
        SessionConfig.Builder builder = new SessionConfig.Builder();
        builder.addNonRepeatingSurface(new ImmediateSurface(surface));
        builder.setTemplateType(1);
        Futures.addCallback(captureSessionBuild.open(builder.build(), this.mCameraDevice), new FutureCallback<Void>() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl.4
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                String str = "Unable to configure camera " + Camera2CameraImpl.this.mCameraInfoInternal.getCameraId() + " due to " + th.getMessage();
                Camera2CameraImpl.this.releaseDummySession(captureSessionBuild, runnable);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable Void r3) {
                Camera2CameraImpl.this.closeStaleCaptureSessions(captureSessionBuild);
                Camera2CameraImpl.this.releaseDummySession(captureSessionBuild, runnable);
            }
        }, this.mExecutor);
    }

    @WorkerThread
    private CameraDevice.StateCallback createDeviceStateCallback() {
        ArrayList arrayList = new ArrayList(this.mUseCaseAttachState.getOnlineBuilder().build().getDeviceStateCallbacks());
        arrayList.add(this.mStateCallback);
        return CameraDeviceStateCallbacks.createComboCallback(arrayList);
    }

    static String getErrorMessage(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "UNKNOWN ERROR" : "ERROR_CAMERA_SERVICE" : "ERROR_CAMERA_DEVICE" : "ERROR_CAMERA_DISABLED" : "ERROR_MAX_CAMERAS_IN_USE" : "ERROR_CAMERA_IN_USE" : "ERROR_NONE";
    }

    private void notifyStateOfflineToUseCases(final List<UseCase> list) {
        CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.camera2.internal.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f1402a.a(list);
            }
        });
    }

    private void notifyStateOnlineToUseCases(final List<UseCase> list) {
        CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.camera2.internal.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f1398a.b(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: tryAddOnlineUseCases, reason: merged with bridge method [inline-methods] */
    public void a(@NonNull Collection<UseCase> collection) {
        ArrayList arrayList = new ArrayList();
        String cameraId = this.mCameraInfoInternal.getCameraId();
        for (UseCase useCase : collection) {
            if (!this.mUseCaseAttachState.isUseCaseOnline(useCase)) {
                arrayList.add(useCase);
                this.mUseCaseAttachState.setUseCaseOnline(useCase);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        String str = "Use cases [" + TextUtils.join(", ", arrayList) + "] now ONLINE for camera " + cameraId;
        notifyStateOnlineToUseCases(arrayList);
        updateCaptureSessionConfig();
        resetCaptureSession(false);
        if (this.mState == InternalState.OPENED) {
            openCaptureSession();
        } else {
            open();
        }
        updateCameraControlPreviewAspectRatio(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: tryRemoveOnlineUseCases, reason: merged with bridge method [inline-methods] */
    public void b(@NonNull Collection<UseCase> collection) {
        List<UseCase> arrayList = new ArrayList<>();
        for (UseCase useCase : collection) {
            if (this.mUseCaseAttachState.isUseCaseOnline(useCase)) {
                this.mUseCaseAttachState.setUseCaseOffline(useCase);
                arrayList.add(useCase);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        String str = "Use cases [" + TextUtils.join(", ", arrayList) + "] now OFFLINE for camera " + this.mCameraInfoInternal.getCameraId();
        clearCameraControlPreviewAspectRatio(arrayList);
        notifyStateOfflineToUseCases(arrayList);
        if (this.mUseCaseAttachState.getOnlineUseCases().isEmpty()) {
            this.mCameraControlInternal.setActive(false);
            resetCaptureSession(false);
            close();
        } else {
            updateCaptureSessionConfig();
            resetCaptureSession(false);
            if (this.mState == InternalState.OPENED) {
                openCaptureSession();
            }
        }
    }

    private void updateCameraControlPreviewAspectRatio(Collection<UseCase> collection) {
        for (UseCase useCase : collection) {
            if (useCase instanceof Preview) {
                Size attachedSurfaceResolution = useCase.getAttachedSurfaceResolution(this.mCameraInfoInternal.getCameraId());
                this.mCameraControlInternal.setPreviewAspectRatio(new Rational(attachedSurfaceResolution.getWidth(), attachedSurfaceResolution.getHeight()));
                return;
            }
        }
    }

    public /* synthetic */ Object a(final UseCase useCase, final CallbackToFutureAdapter.Completer completer) throws Exception {
        if (this.mHandler.post(new Runnable() { // from class: androidx.camera.camera2.internal.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f1406a.a(completer, useCase);
            }
        })) {
            return "isUseCaseOnline";
        }
        completer.setException(new RuntimeException("Unable to check if use case is online. Camera handler shut down."));
        return "isUseCaseOnline";
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void addOnlineUseCase(@NonNull final Collection<UseCase> collection) {
        if (collection.isEmpty()) {
            return;
        }
        this.mCameraControlInternal.setActive(true);
        this.mHandler.post(new Runnable() { // from class: androidx.camera.camera2.internal.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f1404a.a(collection);
            }
        });
    }

    public /* synthetic */ void b(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((UseCase) it.next()).onStateOnline(this.mCameraInfoInternal.getCameraId());
        }
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void close() {
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    Camera2CameraImpl.this.close();
                }
            });
            return;
        }
        String str = "Closing camera: " + this.mCameraInfoInternal.getCameraId();
        int i2 = AnonymousClass15.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[this.mState.ordinal()];
        if (i2 == 3) {
            setState(InternalState.CLOSING);
            closeCamera(false);
            return;
        }
        if (i2 == 4 || i2 == 5) {
            setState(InternalState.CLOSING);
            return;
        }
        if (i2 == 6) {
            Preconditions.checkState(this.mCameraDevice == null);
            setState(InternalState.INITIALIZED);
        } else {
            String str2 = "close() ignored due to being in state: " + this.mState;
        }
    }

    @WorkerThread
    void closeCamera(boolean z) {
        Preconditions.checkState(this.mState == InternalState.CLOSING || this.mState == InternalState.RELEASING || (this.mState == InternalState.REOPENING && this.mCameraDeviceError != 0), "closeCamera should only be called in a CLOSING, RELEASING or REOPENING (with error) state. Current state: " + this.mState + " (error: " + getErrorMessage(this.mCameraDeviceError) + ")");
        boolean z2 = ((Camera2CameraInfoImpl) getCameraInfoInternal()).getSupportedHardwareLevel() == 2;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 <= 23 || i2 >= 29 || !z2 || this.mCameraDeviceError != 0) {
            resetCaptureSession(z);
        } else {
            configAndClose(z);
        }
        this.mCaptureSession.cancelIssuedCaptureRequests();
    }

    void closeStaleCaptureSessions(CaptureSession captureSession) {
        if (Build.VERSION.SDK_INT < 23) {
            for (CaptureSession captureSession2 : (CaptureSession[]) this.mReleasedCaptureSessions.keySet().toArray(new CaptureSession[this.mReleasedCaptureSessions.size()])) {
                if (captureSession == captureSession2) {
                    return;
                }
                captureSession2.forceClose();
            }
        }
    }

    @Nullable
    UseCase findUseCaseForSurface(@NonNull DeferrableSurface deferrableSurface) {
        for (UseCase useCase : this.mUseCaseAttachState.getOnlineUseCases()) {
            if (useCase.getSessionConfig(this.mCameraInfoInternal.getCameraId()).getSurfaces().contains(deferrableSurface)) {
                return useCase;
            }
        }
        return null;
    }

    @WorkerThread
    void finishClose() {
        Preconditions.checkState(this.mState == InternalState.RELEASING || this.mState == InternalState.CLOSING);
        Preconditions.checkState(this.mReleasedCaptureSessions.isEmpty());
        this.mCameraDevice = null;
        if (this.mState == InternalState.CLOSING) {
            setState(InternalState.INITIALIZED);
            return;
        }
        setState(InternalState.RELEASED);
        this.mAvailableCamerasObservable.removeObserver(this.mCameraAvailability);
        this.mCameraManager.unregisterAvailabilityCallback(this.mCameraAvailability);
        CallbackToFutureAdapter.Completer<Void> completer = this.mUserReleaseNotifier;
        if (completer != null) {
            completer.set(null);
            this.mUserReleaseNotifier = null;
        }
    }

    @Override // androidx.camera.core.Camera
    @NonNull
    public CameraControl getCameraControl() {
        return getCameraControlInternal();
    }

    @Override // androidx.camera.core.impl.CameraInternal
    @NonNull
    public CameraControlInternal getCameraControlInternal() {
        return this.mCameraControlInternal;
    }

    @Override // androidx.camera.core.Camera
    @NonNull
    public CameraInfo getCameraInfo() {
        return getCameraInfoInternal();
    }

    @Override // androidx.camera.core.impl.CameraInternal
    @NonNull
    public CameraInfoInternal getCameraInfoInternal() {
        return this.mCameraInfoInternal;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    @NonNull
    public Observable<CameraInternal.State> getCameraState() {
        return this.mObservableState;
    }

    @WorkerThread
    c.b.b.a.a.a<Void> getOrCreateUserReleaseFuture() {
        if (this.mUserReleaseFuture == null) {
            if (this.mState != InternalState.RELEASED) {
                this.mUserReleaseFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver<Void>() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl.8
                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public Object attachCompleter(@NonNull CallbackToFutureAdapter.Completer<Void> completer) {
                        Preconditions.checkState(Camera2CameraImpl.this.mUserReleaseNotifier == null, "Camera can only be released once, so release completer should be null on creation.");
                        Camera2CameraImpl.this.mUserReleaseNotifier = completer;
                        return "Release[camera=" + Camera2CameraImpl.this + "]";
                    }
                });
            } else {
                this.mUserReleaseFuture = Futures.immediateFuture(null);
            }
        }
        return this.mUserReleaseFuture;
    }

    @WorkerThread
    boolean isSessionCloseComplete() {
        return this.mReleasedCaptureSessions.isEmpty() && this.mConfiguringForClose.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.TESTS})
    boolean isUseCaseOnline(@NonNull final UseCase useCase) {
        try {
            return ((Boolean) CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.internal.h
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return this.f1400a.a(useCase, completer);
                }
            }).get()).booleanValue();
        } catch (InterruptedException | ExecutionException e2) {
            throw new RuntimeException("Unable to check if use case is online.", e2);
        }
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseActive(@NonNull final UseCase useCase) {
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl.9
                @Override // java.lang.Runnable
                public void run() {
                    Camera2CameraImpl.this.onUseCaseActive(useCase);
                }
            });
            return;
        }
        String str = "Use case " + useCase + " ACTIVE for camera " + this.mCameraInfoInternal.getCameraId();
        this.mUseCaseAttachState.setUseCaseActive(useCase);
        this.mUseCaseAttachState.updateUseCase(useCase);
        updateCaptureSessionConfig();
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseInactive(@NonNull final UseCase useCase) {
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl.10
                @Override // java.lang.Runnable
                public void run() {
                    Camera2CameraImpl.this.onUseCaseInactive(useCase);
                }
            });
            return;
        }
        String str = "Use case " + useCase + " INACTIVE for camera " + this.mCameraInfoInternal.getCameraId();
        this.mUseCaseAttachState.setUseCaseInactive(useCase);
        updateCaptureSessionConfig();
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseReset(@NonNull final UseCase useCase) {
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl.12
                @Override // java.lang.Runnable
                public void run() {
                    Camera2CameraImpl.this.onUseCaseReset(useCase);
                }
            });
            return;
        }
        String str = "Use case " + useCase + " RESET for camera " + this.mCameraInfoInternal.getCameraId();
        this.mUseCaseAttachState.updateUseCase(useCase);
        resetCaptureSession(false);
        updateCaptureSessionConfig();
        openCaptureSession();
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseUpdated(@NonNull final UseCase useCase) {
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl.11
                @Override // java.lang.Runnable
                public void run() {
                    Camera2CameraImpl.this.onUseCaseUpdated(useCase);
                }
            });
            return;
        }
        String str = "Use case " + useCase + " UPDATED for camera " + this.mCameraInfoInternal.getCameraId();
        this.mUseCaseAttachState.updateUseCase(useCase);
        updateCaptureSessionConfig();
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void open() {
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    Camera2CameraImpl.this.open();
                }
            });
            return;
        }
        int i2 = AnonymousClass15.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[this.mState.ordinal()];
        if (i2 == 1) {
            openCameraDevice();
            return;
        }
        if (i2 != 2) {
            String str = "open() ignored due to being in state: " + this.mState;
            return;
        }
        setState(InternalState.REOPENING);
        if (isSessionCloseComplete() || this.mCameraDeviceError != 0) {
            return;
        }
        Preconditions.checkState(this.mCameraDevice != null, "Camera Device should be open if session close is not complete");
        setState(InternalState.OPENED);
        openCaptureSession();
    }

    @SuppressLint({"MissingPermission"})
    @WorkerThread
    void openCameraDevice() {
        if (!this.mCameraAvailability.isCameraAvailable()) {
            String str = "No cameras available. Waiting for available camera before opening camera: " + this.mCameraInfoInternal.getCameraId();
            setState(InternalState.PENDING_OPEN);
            return;
        }
        setState(InternalState.OPENING);
        String str2 = "Opening camera: " + this.mCameraInfoInternal.getCameraId();
        try {
            this.mCameraManager.openCamera(this.mCameraInfoInternal.getCameraId(), this.mExecutor, createDeviceStateCallback());
        } catch (CameraAccessException e2) {
            String str3 = "Unable to open camera " + this.mCameraInfoInternal.getCameraId() + " due to " + e2.getMessage();
        }
    }

    @WorkerThread
    void openCaptureSession() {
        Preconditions.checkState(this.mState == InternalState.OPENED);
        SessionConfig.ValidatingBuilder onlineBuilder = this.mUseCaseAttachState.getOnlineBuilder();
        if (onlineBuilder.isValid()) {
            final CaptureSession captureSession = this.mCaptureSession;
            Futures.addCallback(captureSession.open(onlineBuilder.build(), this.mCameraDevice), new FutureCallback<Void>() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl.13
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(Throwable th) {
                    if (th instanceof CameraAccessException) {
                        String str = "Unable to configure camera " + Camera2CameraImpl.this.mCameraInfoInternal.getCameraId() + " due to " + th.getMessage();
                        return;
                    }
                    if (th instanceof CancellationException) {
                        String str2 = "Unable to configure camera " + Camera2CameraImpl.this.mCameraInfoInternal.getCameraId() + " cancelled";
                        return;
                    }
                    if (th instanceof DeferrableSurface.SurfaceClosedException) {
                        UseCase useCaseFindUseCaseForSurface = Camera2CameraImpl.this.findUseCaseForSurface(((DeferrableSurface.SurfaceClosedException) th).getDeferrableSurface());
                        if (useCaseFindUseCaseForSurface != null) {
                            Camera2CameraImpl.this.postSurfaceClosedError(useCaseFindUseCaseForSurface);
                            return;
                        }
                        return;
                    }
                    if (!(th instanceof TimeoutException)) {
                        throw new RuntimeException(th);
                    }
                    String str3 = "Unable to configure camera " + Camera2CameraImpl.this.mCameraInfoInternal.getCameraId() + ", timeout!";
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(@Nullable Void r2) {
                    Camera2CameraImpl.this.closeStaleCaptureSessions(captureSession);
                }
            }, this.mExecutor);
        }
    }

    void postSurfaceClosedError(@NonNull UseCase useCase) {
        ScheduledExecutorService scheduledExecutorServiceMainThreadExecutor = CameraXExecutors.mainThreadExecutor();
        final SessionConfig sessionConfig = useCase.getSessionConfig(this.mCameraInfoInternal.getCameraId());
        List<SessionConfig.ErrorListener> errorListeners = sessionConfig.getErrorListeners();
        if (errorListeners.isEmpty()) {
            return;
        }
        final SessionConfig.ErrorListener errorListener = errorListeners.get(0);
        new Throwable();
        scheduledExecutorServiceMainThreadExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl.14
            @Override // java.lang.Runnable
            public void run() {
                errorListener.onError(sessionConfig, SessionConfig.SessionError.SESSION_ERROR_SURFACE_NEEDS_RESET);
            }
        });
    }

    @Override // androidx.camera.core.impl.CameraInternal
    @NonNull
    public c.b.b.a.a.a<Void> release() {
        c.b.b.a.a.a<Void> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver<Void>() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl.6
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public Object attachCompleter(@NonNull final CallbackToFutureAdapter.Completer<Void> completer) {
                Camera2CameraImpl.this.mHandler.post(new Runnable() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Futures.propagate(Camera2CameraImpl.this.getOrCreateUserReleaseFuture(), completer);
                    }
                });
                return "Release[request=" + Camera2CameraImpl.this.mReleaseRequestCount.getAndIncrement() + "]";
            }
        });
        if (Looper.myLooper() != this.mHandler.getLooper()) {
            this.mHandler.post(new Runnable() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl.7
                @Override // java.lang.Runnable
                public void run() {
                    Camera2CameraImpl.this.releaseInternal();
                }
            });
        } else {
            releaseInternal();
        }
        return future;
    }

    void releaseDummySession(CaptureSession captureSession, Runnable runnable) {
        this.mConfiguringForClose.remove(captureSession);
        releaseSession(captureSession, false).addListener(runnable, CameraXExecutors.directExecutor());
    }

    @WorkerThread
    void releaseInternal() {
        switch (AnonymousClass15.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[this.mState.ordinal()]) {
            case 1:
            case 6:
                Preconditions.checkState(this.mCameraDevice == null);
                setState(InternalState.RELEASING);
                Preconditions.checkState(isSessionCloseComplete());
                finishClose();
                break;
            case 2:
            case 4:
            case 5:
            case 7:
                setState(InternalState.RELEASING);
                break;
            case 3:
                setState(InternalState.RELEASING);
                closeCamera(true);
                break;
            default:
                String str = "release() ignored due to being in state: " + this.mState;
                break;
        }
    }

    @WorkerThread
    c.b.b.a.a.a<Void> releaseSession(@NonNull final CaptureSession captureSession, boolean z) {
        captureSession.close();
        c.b.b.a.a.a<Void> aVarRelease = captureSession.release(z);
        String str = "releasing session in state " + this.mState.name();
        this.mReleasedCaptureSessions.put(captureSession, aVarRelease);
        Futures.addCallback(aVarRelease, new FutureCallback<Void>() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl.5
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            @WorkerThread
            public void onSuccess(@Nullable Void r2) {
                CameraDevice cameraDevice;
                Camera2CameraImpl.this.mReleasedCaptureSessions.remove(captureSession);
                int i2 = AnonymousClass15.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[Camera2CameraImpl.this.mState.ordinal()];
                if (i2 != 2) {
                    if (i2 != 5) {
                        if (i2 != 7) {
                            return;
                        }
                    } else if (Camera2CameraImpl.this.mCameraDeviceError == 0) {
                        return;
                    }
                }
                if (!Camera2CameraImpl.this.isSessionCloseComplete() || (cameraDevice = Camera2CameraImpl.this.mCameraDevice) == null) {
                    return;
                }
                cameraDevice.close();
                Camera2CameraImpl.this.mCameraDevice = null;
            }
        }, CameraXExecutors.directExecutor());
        return aVarRelease;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void removeOnlineUseCase(@NonNull final Collection<UseCase> collection) {
        if (collection.isEmpty()) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: androidx.camera.camera2.internal.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f1409a.b(collection);
            }
        });
    }

    @WorkerThread
    void resetCaptureSession(boolean z) {
        Preconditions.checkState(this.mCaptureSession != null);
        CaptureSession captureSession = this.mCaptureSession;
        SessionConfig sessionConfig = captureSession.getSessionConfig();
        List<CaptureConfig> captureConfigs = captureSession.getCaptureConfigs();
        this.mCaptureSession = this.mCaptureSessionBuilder.build();
        this.mCaptureSession.setSessionConfig(sessionConfig);
        this.mCaptureSession.issueCaptureRequests(captureConfigs);
        releaseSession(captureSession, z);
    }

    @WorkerThread
    void setState(InternalState internalState) {
        String str = "Transitioning camera internal state: " + this.mState + " --> " + internalState;
        this.mState = internalState;
        switch (AnonymousClass15.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState[internalState.ordinal()]) {
            case 1:
                this.mObservableState.postValue(CameraInternal.State.CLOSED);
                break;
            case 2:
                this.mObservableState.postValue(CameraInternal.State.CLOSING);
                break;
            case 3:
                this.mObservableState.postValue(CameraInternal.State.OPEN);
                break;
            case 4:
            case 5:
                this.mObservableState.postValue(CameraInternal.State.OPENING);
                break;
            case 6:
                this.mObservableState.postValue(CameraInternal.State.PENDING_OPEN);
                break;
            case 7:
                this.mObservableState.postValue(CameraInternal.State.RELEASING);
                break;
            case 8:
                this.mObservableState.postValue(CameraInternal.State.RELEASED);
                break;
        }
    }

    void submitCaptureRequests(@NonNull List<CaptureConfig> list) {
        ArrayList arrayList = new ArrayList();
        for (CaptureConfig captureConfig : list) {
            CaptureConfig.Builder builderFrom = CaptureConfig.Builder.from(captureConfig);
            if (!captureConfig.getSurfaces().isEmpty() || !captureConfig.isUseRepeatingSurface() || checkAndAttachRepeatingSurface(builderFrom)) {
                arrayList.add(builderFrom.build());
            }
        }
        String str = "issue capture request for camera " + this.mCameraInfoInternal.getCameraId();
        this.mCaptureSession.issueCaptureRequests(arrayList);
    }

    @NonNull
    public String toString() {
        return String.format(Locale.US, "Camera@%x[id=%s]", Integer.valueOf(hashCode()), this.mCameraInfoInternal.getCameraId());
    }

    void updateCaptureSessionConfig() {
        SessionConfig.ValidatingBuilder activeAndOnlineBuilder = this.mUseCaseAttachState.getActiveAndOnlineBuilder();
        if (activeAndOnlineBuilder.isValid()) {
            activeAndOnlineBuilder.add(this.mCameraControlSessionConfig);
            this.mCaptureSession.setSessionConfig(activeAndOnlineBuilder.build());
        }
    }

    void updateDefaultRequestBuilderToCameraControl(@NonNull CameraDevice cameraDevice) throws CameraAccessException {
        try {
            this.mCameraControlInternal.setDefaultRequestBuilder(cameraDevice.createCaptureRequest(this.mCameraControlInternal.getDefaultTemplate()));
        } catch (CameraAccessException unused) {
        }
    }

    public /* synthetic */ void a(CallbackToFutureAdapter.Completer completer, UseCase useCase) {
        completer.set(Boolean.valueOf(this.mUseCaseAttachState.isUseCaseOnline(useCase)));
    }

    public /* synthetic */ void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((UseCase) it.next()).onStateOffline(this.mCameraInfoInternal.getCameraId());
        }
    }
}
