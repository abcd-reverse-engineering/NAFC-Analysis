package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.impl.CameraEventCallbacks;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;
import androidx.camera.camera2.internal.compat.CameraDeviceCompat;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.DeferrableSurfaces;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
final class CaptureSession {
    private static final String TAG = "CaptureSession";
    private static final long TIMEOUT_GET_SURFACE_IN_MS = 5000;

    @Nullable
    CameraCaptureSession mCameraCaptureSession;

    @Nullable
    volatile Config mCameraEventOnRepeatingOptions;
    private final Executor mExecutor;
    private final boolean mIsLegacyDevice;

    @GuardedBy("mStateLock")
    CallbackToFutureAdapter.Completer<Void> mOpenCaptureSessionCompleter;

    @GuardedBy("mStateLock")
    c.b.b.a.a.a<Void> mOpenFuture;

    @GuardedBy("mStateLock")
    CallbackToFutureAdapter.Completer<Void> mReleaseCompleter;

    @GuardedBy("mStateLock")
    c.b.b.a.a.a<Void> mReleaseFuture;
    private final ScheduledExecutorService mScheduleExecutor;

    @Nullable
    volatile SessionConfig mSessionConfig;

    @GuardedBy("mStateLock")
    State mState;
    final Object mStateLock = new Object();
    private final List<CaptureConfig> mCaptureConfigs = new ArrayList();
    private final CameraCaptureSession.CaptureCallback mCaptureCallback = new CameraCaptureSession.CaptureCallback() { // from class: androidx.camera.camera2.internal.CaptureSession.1
        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        }
    };
    private final StateCallback mCaptureSessionStateCallback = new StateCallback();
    private Map<DeferrableSurface, Surface> mConfiguredSurfaceMap = new HashMap();

    @GuardedBy("mStateLock")
    List<DeferrableSurface> mConfiguredDeferrableSurfaces = Collections.emptyList();

    /* renamed from: androidx.camera.camera2.internal.CaptureSession$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State = new int[State.values().length];

        static {
            try {
                $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[State.UNINITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[State.INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[State.GET_SURFACE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[State.OPENING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[State.OPENED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[State.CLOSED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[State.RELEASING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[State.RELEASED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    static final class Builder {
        private Executor mExecutor;
        private ScheduledExecutorService mScheduledExecutorService;
        private int mSupportedHardwareLevel = -1;

        Builder() {
        }

        CaptureSession build() {
            Executor executor = this.mExecutor;
            if (executor == null) {
                throw new IllegalStateException("Missing camera executor. Executor must be set with setExecutor()");
            }
            ScheduledExecutorService scheduledExecutorService = this.mScheduledExecutorService;
            if (scheduledExecutorService != null) {
                return new CaptureSession(executor, scheduledExecutorService, this.mSupportedHardwareLevel == 2);
            }
            throw new IllegalStateException("Missing ScheduledExecutorService. ScheduledExecutorService must be set with setScheduledExecutorService()");
        }

        void setExecutor(@NonNull Executor executor) {
            this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        }

        void setScheduledExecutorService(@NonNull ScheduledExecutorService scheduledExecutorService) {
            this.mScheduledExecutorService = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService);
        }

        void setSupportedHardwareLevel(int i2) {
            this.mSupportedHardwareLevel = i2;
        }
    }

    enum State {
        UNINITIALIZED,
        INITIALIZED,
        GET_SURFACE,
        OPENING,
        OPENED,
        CLOSED,
        RELEASING,
        RELEASED
    }

    final class StateCallback extends CameraCaptureSession.StateCallback {
        StateCallback() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onClosed(@NonNull CameraCaptureSession cameraCaptureSession) {
            synchronized (CaptureSession.this.mStateLock) {
                if (CaptureSession.this.mState == State.UNINITIALIZED) {
                    throw new IllegalStateException("onClosed() should not be possible in state: " + CaptureSession.this.mState);
                }
                if (CaptureSession.this.mState == State.RELEASED) {
                    return;
                }
                CaptureSession.this.closeConfiguredDeferrableSurfaces();
                CaptureSession.this.mState = State.RELEASED;
                CaptureSession.this.mCameraCaptureSession = null;
                CaptureSession.this.clearConfiguredSurfaces();
                if (CaptureSession.this.mReleaseCompleter != null) {
                    CaptureSession.this.mReleaseCompleter.set(null);
                    CaptureSession.this.mReleaseCompleter = null;
                }
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
            synchronized (CaptureSession.this.mStateLock) {
                Preconditions.checkNotNull(CaptureSession.this.mOpenCaptureSessionCompleter, "OpenCaptureSession completer should not null");
                CaptureSession.this.mOpenCaptureSessionCompleter.setException(new CancellationException("onConfigureFailed"));
                CaptureSession.this.mOpenCaptureSessionCompleter = null;
                switch (AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[CaptureSession.this.mState.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                    case 8:
                        throw new IllegalStateException("onConfiguredFailed() should not be possible in state: " + CaptureSession.this.mState);
                    case 4:
                    case 6:
                        CaptureSession.this.mState = State.RELEASED;
                        CaptureSession.this.mCameraCaptureSession = null;
                        break;
                    case 7:
                        CaptureSession.this.mState = State.RELEASING;
                        cameraCaptureSession.close();
                        break;
                }
                String str = "CameraCaptureSession.onConfiguredFailed() " + CaptureSession.this.mState;
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
            synchronized (CaptureSession.this.mStateLock) {
                Preconditions.checkNotNull(CaptureSession.this.mOpenCaptureSessionCompleter, "OpenCaptureSession completer should not null");
                CaptureSession.this.mOpenCaptureSessionCompleter.set(null);
                CaptureSession.this.mOpenCaptureSessionCompleter = null;
                switch (AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[CaptureSession.this.mState.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                    case 8:
                        throw new IllegalStateException("onConfigured() should not be possible in state: " + CaptureSession.this.mState);
                    case 4:
                        CaptureSession.this.mState = State.OPENED;
                        CaptureSession.this.mCameraCaptureSession = cameraCaptureSession;
                        if (CaptureSession.this.mSessionConfig != null) {
                            List<CaptureConfig> listOnEnableSession = new Camera2ImplConfig(CaptureSession.this.mSessionConfig.getImplementationOptions()).getCameraEventCallback(CameraEventCallbacks.createEmptyCallback()).createComboCallback().onEnableSession();
                            if (!listOnEnableSession.isEmpty()) {
                                CaptureSession.this.issueBurstCaptureRequest(CaptureSession.this.setupConfiguredSurface(listOnEnableSession));
                            }
                        }
                        CaptureSession.this.issueRepeatingCaptureRequests();
                        CaptureSession.this.issuePendingCaptureRequest();
                        break;
                    case 6:
                        CaptureSession.this.mCameraCaptureSession = cameraCaptureSession;
                        break;
                    case 7:
                        cameraCaptureSession.close();
                        break;
                }
                String str = "CameraCaptureSession.onConfigured() mState=" + CaptureSession.this.mState;
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onReady(@NonNull CameraCaptureSession cameraCaptureSession) {
            synchronized (CaptureSession.this.mStateLock) {
                if (AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[CaptureSession.this.mState.ordinal()] == 1) {
                    throw new IllegalStateException("onReady() should not be possible in state: " + CaptureSession.this.mState);
                }
                String str = "CameraCaptureSession.onReady() " + CaptureSession.this.mState;
            }
        }
    }

    CaptureSession(@NonNull Executor executor, @NonNull ScheduledExecutorService scheduledExecutorService, boolean z) {
        this.mState = State.UNINITIALIZED;
        this.mState = State.INITIALIZED;
        this.mExecutor = executor;
        this.mScheduleExecutor = scheduledExecutorService;
        this.mIsLegacyDevice = z;
    }

    private CameraCaptureSession.CaptureCallback createCamera2CaptureCallback(List<CameraCaptureCallback> list, CameraCaptureSession.CaptureCallback... captureCallbackArr) {
        ArrayList arrayList = new ArrayList(list.size() + captureCallbackArr.length);
        Iterator<CameraCaptureCallback> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CaptureCallbackConverter.toCaptureCallback(it.next()));
        }
        Collections.addAll(arrayList, captureCallbackArr);
        return Camera2CaptureCallbacks.createComboCallback(arrayList);
    }

    @NonNull
    private Executor getExecutor() {
        return this.mExecutor;
    }

    @NonNull
    private static Config mergeOptions(List<CaptureConfig> list) {
        MutableOptionsBundle mutableOptionsBundleCreate = MutableOptionsBundle.create();
        Iterator<CaptureConfig> it = list.iterator();
        while (it.hasNext()) {
            Config implementationOptions = it.next().getImplementationOptions();
            for (Config.Option<?> option : implementationOptions.listOptions()) {
                Object objRetrieveOption = implementationOptions.retrieveOption(option, null);
                if (mutableOptionsBundleCreate.containsOption(option)) {
                    Object objRetrieveOption2 = mutableOptionsBundleCreate.retrieveOption(option, null);
                    if (!Objects.equals(objRetrieveOption2, objRetrieveOption)) {
                        String str = "Detect conflicting option " + option.getId() + " : " + objRetrieveOption + " != " + objRetrieveOption2;
                    }
                } else {
                    mutableOptionsBundleCreate.insertOption(option, objRetrieveOption);
                }
            }
        }
        return mutableOptionsBundleCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    /* renamed from: openCaptureSession, reason: merged with bridge method [inline-methods] */
    public c.b.b.a.a.a<Void> a(final List<Surface> list, final SessionConfig sessionConfig, final CameraDevice cameraDevice) {
        synchronized (this.mStateLock) {
            int i2 = AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[this.mState.ordinal()];
            if (i2 != 1 && i2 != 2) {
                if (i2 == 3) {
                    return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.internal.n
                        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                        public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                            return this.f1414a.a(list, sessionConfig, cameraDevice, completer);
                        }
                    });
                }
                if (i2 != 5) {
                    return Futures.immediateFailedFuture(new CancellationException("openCaptureSession() not execute in state: " + this.mState));
                }
            }
            return Futures.immediateFailedFuture(new IllegalStateException("openCaptureSession() should not be possible in state: " + this.mState));
        }
    }

    void cancelIssuedCaptureRequests() {
        if (this.mCaptureConfigs.isEmpty()) {
            return;
        }
        Iterator<CaptureConfig> it = this.mCaptureConfigs.iterator();
        while (it.hasNext()) {
            Iterator<CameraCaptureCallback> it2 = it.next().getCameraCaptureCallbacks().iterator();
            while (it2.hasNext()) {
                it2.next().onCaptureCancelled();
            }
        }
        this.mCaptureConfigs.clear();
    }

    @GuardedBy("mStateLock")
    void clearConfiguredSurfaces() {
        DeferrableSurfaces.decrementAll(this.mConfiguredDeferrableSurfaces);
        this.mConfiguredDeferrableSurfaces.clear();
    }

    void close() {
        synchronized (this.mStateLock) {
            int i2 = AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[this.mState.ordinal()];
            if (i2 == 1) {
                throw new IllegalStateException("close() should not be possible in state: " + this.mState);
            }
            if (i2 == 2) {
                this.mState = State.RELEASED;
            } else if (i2 == 3) {
                if (this.mOpenFuture != null) {
                    this.mOpenFuture.cancel(true);
                }
                this.mState = State.RELEASED;
            } else if (i2 == 4) {
                this.mState = State.CLOSED;
                this.mSessionConfig = null;
                this.mCameraEventOnRepeatingOptions = null;
                closeConfiguredDeferrableSurfaces();
            } else if (i2 == 5) {
                if (this.mSessionConfig != null) {
                    List<CaptureConfig> listOnDisableSession = new Camera2ImplConfig(this.mSessionConfig.getImplementationOptions()).getCameraEventCallback(CameraEventCallbacks.createEmptyCallback()).createComboCallback().onDisableSession();
                    if (!listOnDisableSession.isEmpty()) {
                        try {
                            issueCaptureRequests(setupConfiguredSurface(listOnDisableSession));
                        } catch (IllegalStateException unused) {
                        }
                    }
                }
                this.mState = State.CLOSED;
                this.mSessionConfig = null;
                this.mCameraEventOnRepeatingOptions = null;
                closeConfiguredDeferrableSurfaces();
            }
        }
    }

    void closeConfiguredDeferrableSurfaces() {
        if (this.mIsLegacyDevice || Build.VERSION.SDK_INT <= 23) {
            Iterator<DeferrableSurface> it = this.mConfiguredDeferrableSurfaces.iterator();
            while (it.hasNext()) {
                it.next().close();
            }
        }
    }

    void forceClose() {
        this.mCaptureSessionStateCallback.onClosed(this.mCameraCaptureSession);
    }

    List<CaptureConfig> getCaptureConfigs() {
        List<CaptureConfig> listUnmodifiableList;
        synchronized (this.mStateLock) {
            listUnmodifiableList = Collections.unmodifiableList(this.mCaptureConfigs);
        }
        return listUnmodifiableList;
    }

    @Nullable
    SessionConfig getSessionConfig() {
        SessionConfig sessionConfig;
        synchronized (this.mStateLock) {
            sessionConfig = this.mSessionConfig;
        }
        return sessionConfig;
    }

    State getState() {
        State state;
        synchronized (this.mStateLock) {
            state = this.mState;
        }
        return state;
    }

    void issueBurstCaptureRequest(List<CaptureConfig> list) {
        if (list.isEmpty()) {
            return;
        }
        try {
            CameraBurstCaptureCallback cameraBurstCaptureCallback = new CameraBurstCaptureCallback();
            ArrayList arrayList = new ArrayList();
            for (CaptureConfig captureConfig : list) {
                if (!captureConfig.getSurfaces().isEmpty()) {
                    boolean z = true;
                    Iterator<DeferrableSurface> it = captureConfig.getSurfaces().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        DeferrableSurface next = it.next();
                        if (!this.mConfiguredSurfaceMap.containsKey(next)) {
                            String str = "Skipping capture request with invalid surface: " + next;
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        CaptureConfig.Builder builderFrom = CaptureConfig.Builder.from(captureConfig);
                        if (this.mSessionConfig != null) {
                            builderFrom.addImplementationOptions(this.mSessionConfig.getRepeatingCaptureConfig().getImplementationOptions());
                        }
                        if (this.mCameraEventOnRepeatingOptions != null) {
                            builderFrom.addImplementationOptions(this.mCameraEventOnRepeatingOptions);
                        }
                        builderFrom.addImplementationOptions(captureConfig.getImplementationOptions());
                        CaptureRequest captureRequestBuild = Camera2CaptureRequestBuilder.build(builderFrom.build(), this.mCameraCaptureSession.getDevice(), this.mConfiguredSurfaceMap);
                        if (captureRequestBuild == null) {
                            return;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        Iterator<CameraCaptureCallback> it2 = captureConfig.getCameraCaptureCallbacks().iterator();
                        while (it2.hasNext()) {
                            CaptureCallbackConverter.toCaptureCallback(it2.next(), arrayList2);
                        }
                        cameraBurstCaptureCallback.addCamera2Callbacks(captureRequestBuild, arrayList2);
                        arrayList.add(captureRequestBuild);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            CameraCaptureSessionCompat.captureBurstRequests(this.mCameraCaptureSession, arrayList, this.mExecutor, cameraBurstCaptureCallback);
        } catch (CameraAccessException e2) {
            String str2 = "Unable to access camera: " + e2.getMessage();
            Thread.dumpStack();
        }
    }

    void issueCaptureRequests(List<CaptureConfig> list) {
        synchronized (this.mStateLock) {
            switch (AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[this.mState.ordinal()]) {
                case 1:
                    throw new IllegalStateException("issueCaptureRequests() should not be possible in state: " + this.mState);
                case 2:
                case 3:
                case 4:
                    this.mCaptureConfigs.addAll(list);
                    break;
                case 5:
                    this.mCaptureConfigs.addAll(list);
                    issuePendingCaptureRequest();
                    break;
                case 6:
                case 7:
                case 8:
                    throw new IllegalStateException("Cannot issue capture request on a closed/released session.");
            }
        }
    }

    void issuePendingCaptureRequest() {
        if (this.mCaptureConfigs.isEmpty()) {
            return;
        }
        try {
            issueBurstCaptureRequest(this.mCaptureConfigs);
        } finally {
            this.mCaptureConfigs.clear();
        }
    }

    void issueRepeatingCaptureRequests() {
        if (this.mSessionConfig == null) {
            return;
        }
        CaptureConfig repeatingCaptureConfig = this.mSessionConfig.getRepeatingCaptureConfig();
        try {
            CaptureConfig.Builder builderFrom = CaptureConfig.Builder.from(repeatingCaptureConfig);
            this.mCameraEventOnRepeatingOptions = mergeOptions(new Camera2ImplConfig(this.mSessionConfig.getImplementationOptions()).getCameraEventCallback(CameraEventCallbacks.createEmptyCallback()).createComboCallback().onRepeating());
            if (this.mCameraEventOnRepeatingOptions != null) {
                builderFrom.addImplementationOptions(this.mCameraEventOnRepeatingOptions);
            }
            CaptureRequest captureRequestBuild = Camera2CaptureRequestBuilder.build(builderFrom.build(), this.mCameraCaptureSession.getDevice(), this.mConfiguredSurfaceMap);
            if (captureRequestBuild == null) {
                return;
            }
            CameraCaptureSessionCompat.setSingleRepeatingRequest(this.mCameraCaptureSession, captureRequestBuild, this.mExecutor, createCamera2CaptureCallback(repeatingCaptureConfig.getCameraCaptureCallbacks(), this.mCaptureCallback));
        } catch (CameraAccessException e2) {
            String str = "Unable to access camera: " + e2.getMessage();
            Thread.dumpStack();
        }
    }

    @NonNull
    c.b.b.a.a.a<Void> open(final SessionConfig sessionConfig, final CameraDevice cameraDevice) {
        synchronized (this.mStateLock) {
            if (AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[this.mState.ordinal()] == 2) {
                this.mState = State.GET_SURFACE;
                this.mConfiguredDeferrableSurfaces = new ArrayList(sessionConfig.getSurfaces());
                this.mOpenFuture = FutureChain.from(DeferrableSurfaces.surfaceListWithTimeout(this.mConfiguredDeferrableSurfaces, false, 5000L, this.mExecutor, this.mScheduleExecutor)).transformAsync(new AsyncFunction() { // from class: androidx.camera.camera2.internal.m
                    @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                    public final c.b.b.a.a.a apply(Object obj) {
                        return this.f1411a.a(sessionConfig, cameraDevice, (List) obj);
                    }
                }, this.mExecutor);
                this.mOpenFuture.addListener(new Runnable() { // from class: androidx.camera.camera2.internal.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f1418a.a();
                    }
                }, this.mExecutor);
                return Futures.nonCancellationPropagating(this.mOpenFuture);
            }
            String str = "Open not allowed in state: " + this.mState;
            return Futures.immediateFailedFuture(new IllegalStateException("open() should not allow the state: " + this.mState));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0029 A[Catch: all -> 0x0067, TryCatch #1 {, blocks: (B:4:0x0003, B:5:0x000d, B:25:0x0060, B:7:0x0011, B:10:0x0017, B:11:0x001c, B:12:0x0021, B:13:0x0025, B:15:0x0029, B:16:0x0034, B:17:0x0036, B:19:0x0038, B:21:0x003c, B:22:0x0042, B:23:0x0047, B:24:0x005f), top: B:34:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    c.b.b.a.a.a<java.lang.Void> release(boolean r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mStateLock
            monitor-enter(r0)
            int[] r1 = androidx.camera.camera2.internal.CaptureSession.AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State     // Catch: java.lang.Throwable -> L67
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.mState     // Catch: java.lang.Throwable -> L67
            int r2 = r2.ordinal()     // Catch: java.lang.Throwable -> L67
            r1 = r1[r2]     // Catch: java.lang.Throwable -> L67
            switch(r1) {
                case 1: goto L47;
                case 2: goto L42;
                case 3: goto L38;
                case 4: goto L21;
                case 5: goto L11;
                case 6: goto L11;
                case 7: goto L25;
                default: goto L10;
            }     // Catch: java.lang.Throwable -> L67
        L10:
            goto L60
        L11:
            android.hardware.camera2.CameraCaptureSession r1 = r3.mCameraCaptureSession     // Catch: java.lang.Throwable -> L67
            if (r1 == 0) goto L21
            if (r4 == 0) goto L1c
            android.hardware.camera2.CameraCaptureSession r4 = r3.mCameraCaptureSession     // Catch: android.hardware.camera2.CameraAccessException -> L1c java.lang.Throwable -> L67
            r4.abortCaptures()     // Catch: android.hardware.camera2.CameraAccessException -> L1c java.lang.Throwable -> L67
        L1c:
            android.hardware.camera2.CameraCaptureSession r4 = r3.mCameraCaptureSession     // Catch: java.lang.Throwable -> L67
            r4.close()     // Catch: java.lang.Throwable -> L67
        L21:
            androidx.camera.camera2.internal.CaptureSession$State r4 = androidx.camera.camera2.internal.CaptureSession.State.RELEASING     // Catch: java.lang.Throwable -> L67
            r3.mState = r4     // Catch: java.lang.Throwable -> L67
        L25:
            c.b.b.a.a.a<java.lang.Void> r4 = r3.mReleaseFuture     // Catch: java.lang.Throwable -> L67
            if (r4 != 0) goto L34
            androidx.camera.camera2.internal.CaptureSession$2 r4 = new androidx.camera.camera2.internal.CaptureSession$2     // Catch: java.lang.Throwable -> L67
            r4.<init>()     // Catch: java.lang.Throwable -> L67
            c.b.b.a.a.a r4 = androidx.concurrent.futures.CallbackToFutureAdapter.getFuture(r4)     // Catch: java.lang.Throwable -> L67
            r3.mReleaseFuture = r4     // Catch: java.lang.Throwable -> L67
        L34:
            c.b.b.a.a.a<java.lang.Void> r4 = r3.mReleaseFuture     // Catch: java.lang.Throwable -> L67
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L67
            return r4
        L38:
            c.b.b.a.a.a<java.lang.Void> r4 = r3.mOpenFuture     // Catch: java.lang.Throwable -> L67
            if (r4 == 0) goto L42
            c.b.b.a.a.a<java.lang.Void> r4 = r3.mOpenFuture     // Catch: java.lang.Throwable -> L67
            r1 = 1
            r4.cancel(r1)     // Catch: java.lang.Throwable -> L67
        L42:
            androidx.camera.camera2.internal.CaptureSession$State r4 = androidx.camera.camera2.internal.CaptureSession.State.RELEASED     // Catch: java.lang.Throwable -> L67
            r3.mState = r4     // Catch: java.lang.Throwable -> L67
            goto L60
        L47:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L67
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L67
            r1.<init>()     // Catch: java.lang.Throwable -> L67
            java.lang.String r2 = "release() should not be possible in state: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L67
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.mState     // Catch: java.lang.Throwable -> L67
            r1.append(r2)     // Catch: java.lang.Throwable -> L67
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L67
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L67
            throw r4     // Catch: java.lang.Throwable -> L67
        L60:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L67
            r4 = 0
            c.b.b.a.a.a r4 = androidx.camera.core.impl.utils.futures.Futures.immediateFuture(r4)
            return r4
        L67:
            r4 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L67
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.CaptureSession.release(boolean):c.b.b.a.a.a");
    }

    void setSessionConfig(SessionConfig sessionConfig) {
        synchronized (this.mStateLock) {
            switch (AnonymousClass3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State[this.mState.ordinal()]) {
                case 1:
                    throw new IllegalStateException("setSessionConfig() should not be possible in state: " + this.mState);
                case 2:
                case 3:
                case 4:
                    this.mSessionConfig = sessionConfig;
                    break;
                case 5:
                    this.mSessionConfig = sessionConfig;
                    if (this.mConfiguredSurfaceMap.keySet().containsAll(sessionConfig.getSurfaces())) {
                        issueRepeatingCaptureRequests();
                        break;
                    } else {
                        return;
                    }
                case 6:
                case 7:
                case 8:
                    throw new IllegalStateException("Session configuration cannot be set on a closed/released session.");
            }
        }
    }

    List<CaptureConfig> setupConfiguredSurface(List<CaptureConfig> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<CaptureConfig> it = list.iterator();
        while (it.hasNext()) {
            CaptureConfig.Builder builderFrom = CaptureConfig.Builder.from(it.next());
            builderFrom.setTemplateType(1);
            Iterator<DeferrableSurface> it2 = this.mSessionConfig.getRepeatingCaptureConfig().getSurfaces().iterator();
            while (it2.hasNext()) {
                builderFrom.addSurface(it2.next());
            }
            arrayList.add(builderFrom.build());
        }
        return arrayList;
    }

    public /* synthetic */ void a() {
        synchronized (this.mStateLock) {
            this.mOpenFuture = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Object a(List list, SessionConfig sessionConfig, CameraDevice cameraDevice, CallbackToFutureAdapter.Completer completer) throws Exception {
        Preconditions.checkState(Thread.holdsLock(this.mStateLock));
        if (list.contains(null)) {
            DeferrableSurface deferrableSurface = this.mConfiguredDeferrableSurfaces.get(list.indexOf(null));
            this.mConfiguredDeferrableSurfaces.clear();
            completer.setException(new DeferrableSurface.SurfaceClosedException("Surface closed", deferrableSurface));
            return "openCaptureSession-cancelled[session=" + this + "]";
        }
        if (list.isEmpty()) {
            completer.setException(new IllegalArgumentException("Unable to open capture session with no surfaces."));
            return "openCaptureSession-cancelled[session=" + this + "]";
        }
        try {
            DeferrableSurfaces.incrementAll(this.mConfiguredDeferrableSurfaces);
            this.mConfiguredSurfaceMap.clear();
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.mConfiguredSurfaceMap.put(this.mConfiguredDeferrableSurfaces.get(i2), list.get(i2));
            }
            ArrayList arrayList = new ArrayList(new HashSet(list));
            Preconditions.checkState(this.mOpenCaptureSessionCompleter == null, "The openCaptureSessionCompleter can only set once!");
            this.mState = State.OPENING;
            ArrayList arrayList2 = new ArrayList(sessionConfig.getSessionStateCallbacks());
            arrayList2.add(this.mCaptureSessionStateCallback);
            CameraCaptureSession.StateCallback stateCallbackCreateComboCallback = CameraCaptureSessionStateCallbacks.createComboCallback(arrayList2);
            List<CaptureConfig> listOnPresetSession = new Camera2ImplConfig(sessionConfig.getImplementationOptions()).getCameraEventCallback(CameraEventCallbacks.createEmptyCallback()).createComboCallback().onPresetSession();
            CaptureConfig.Builder builderFrom = CaptureConfig.Builder.from(sessionConfig.getRepeatingCaptureConfig());
            Iterator<CaptureConfig> it = listOnPresetSession.iterator();
            while (it.hasNext()) {
                builderFrom.addImplementationOptions(it.next().getImplementationOptions());
            }
            LinkedList linkedList = new LinkedList();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                linkedList.add(new OutputConfigurationCompat((Surface) it2.next()));
            }
            SessionConfigurationCompat sessionConfigurationCompat = new SessionConfigurationCompat(0, linkedList, getExecutor(), stateCallbackCreateComboCallback);
            CaptureRequest captureRequestBuildWithoutTarget = Camera2CaptureRequestBuilder.buildWithoutTarget(builderFrom.build(), cameraDevice);
            if (captureRequestBuildWithoutTarget != null) {
                sessionConfigurationCompat.setSessionParameters(captureRequestBuildWithoutTarget);
            }
            this.mOpenCaptureSessionCompleter = completer;
            CameraDeviceCompat.createCaptureSession(cameraDevice, sessionConfigurationCompat);
            return "openCaptureSession[session=" + this + "]";
        } catch (DeferrableSurface.SurfaceClosedException e2) {
            this.mConfiguredDeferrableSurfaces.clear();
            completer.setException(e2);
            return "openCaptureSession-cancelled[session=" + this + "]";
        }
    }
}
