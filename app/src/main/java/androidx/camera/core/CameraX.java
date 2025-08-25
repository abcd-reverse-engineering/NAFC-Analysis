package androidx.camera.core;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.util.Size;
import androidx.annotation.GuardedBy;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.UseCaseGroupRepository;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraIdFilter;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraRepository;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.UseCaseGroup;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@MainThread
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class CameraX {
    private static final String TAG = "CameraX";
    private static final long WAIT_INITIALIZED_TIMEOUT = 3;

    @Nullable
    @GuardedBy("sInitializeLock")
    static CameraX sInstance = null;

    @GuardedBy("sInitializeLock")
    private static boolean sTargetInitialized = false;
    private final Executor mCameraExecutor;
    private CameraFactory mCameraFactory;
    private Context mContext;
    private UseCaseConfigFactory mDefaultConfigFactory;
    private CameraDeviceSurfaceManager mSurfaceManager;
    static final Object sInitializeLock = new Object();

    @NonNull
    @GuardedBy("sInitializeLock")
    private static c.b.b.a.a.a<Void> sInitializeFuture = Futures.immediateFailedFuture(new IllegalStateException("CameraX is not initialized."));

    @NonNull
    @GuardedBy("sInitializeLock")
    private static c.b.b.a.a.a<Void> sShutdownFuture = Futures.immediateFuture(null);
    final CameraRepository mCameraRepository = new CameraRepository();
    private final Object mInitializeLock = new Object();
    private final UseCaseGroupRepository mUseCaseGroupRepository = new UseCaseGroupRepository();

    @GuardedBy("mInitializeLock")
    private InternalInitState mInitState = InternalInitState.UNINITIALIZED;

    @GuardedBy("mInitializeLock")
    private c.b.b.a.a.a<Void> mShutdownInternalFuture = Futures.immediateFuture(null);

    /* renamed from: androidx.camera.core.CameraX$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$CameraX$InternalInitState = new int[InternalInitState.values().length];

        static {
            try {
                $SwitchMap$androidx$camera$core$CameraX$InternalInitState[InternalInitState.UNINITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$core$CameraX$InternalInitState[InternalInitState.INITIALIZING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$core$CameraX$InternalInitState[InternalInitState.INITIALIZED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$camera$core$CameraX$InternalInitState[InternalInitState.SHUTDOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private enum InternalInitState {
        UNINITIALIZED,
        INITIALIZING,
        INITIALIZED,
        SHUTDOWN
    }

    CameraX(@NonNull Executor executor) {
        Preconditions.checkNotNull(executor);
        this.mCameraExecutor = executor;
    }

    static /* synthetic */ CameraX a(CameraX cameraX, Void r1) {
        return cameraX;
    }

    static /* synthetic */ Object a(final CameraX cameraX, final Context context, final CameraXConfig cameraXConfig, final CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (sInitializeLock) {
            Futures.addCallback(FutureChain.from(sShutdownFuture).transformAsync(new AsyncFunction() { // from class: androidx.camera.core.h
                @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                public final c.b.b.a.a.a apply(Object obj) {
                    return this.f1477a.initInternal(context, cameraXConfig);
                }
            }, CameraXExecutors.directExecutor()), new FutureCallback<Void>() { // from class: androidx.camera.core.CameraX.1
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(Throwable th) {
                    synchronized (CameraX.sInitializeLock) {
                        if (CameraX.sInstance == cameraX) {
                            CameraX.shutdown();
                        }
                    }
                    completer.setException(th);
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(@Nullable Void r2) {
                    completer.set(null);
                }
            }, CameraXExecutors.directExecutor());
        }
        return "CameraX-initialize";
    }

    private static void attach(String str, UseCase useCase) {
        CameraInternal camera = checkInitialized().getCameraRepository().getCamera(str);
        useCase.addStateChangeCallback(camera);
        useCase.attachCameraControl(str, camera.getCameraControlInternal());
    }

    static /* synthetic */ Object b(final CameraX cameraX, final CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (sInitializeLock) {
            sInitializeFuture.addListener(new Runnable() { // from class: androidx.camera.core.e
                @Override // java.lang.Runnable
                public final void run() {
                    Futures.propagate(this.f1465a.shutdownInternal(), completer);
                }
            }, CameraXExecutors.directExecutor());
        }
        return "CameraX shutdown";
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Camera bindToLifecycle(@NonNull LifecycleOwner lifecycleOwner, @NonNull CameraSelector cameraSelector, @NonNull UseCase... useCaseArr) {
        Threads.checkMainThread();
        CameraX cameraXCheckInitialized = checkInitialized();
        UseCaseGroupLifecycleController orCreateUseCaseGroup = cameraXCheckInitialized.getOrCreateUseCaseGroup(lifecycleOwner);
        UseCaseGroup useCaseGroup = orCreateUseCaseGroup.getUseCaseGroup();
        Collection<UseCaseGroupLifecycleController> useCaseGroups = cameraXCheckInitialized.mUseCaseGroupRepository.getUseCaseGroups();
        for (UseCase useCase : useCaseArr) {
            Iterator<UseCaseGroupLifecycleController> it = useCaseGroups.iterator();
            while (it.hasNext()) {
                UseCaseGroup useCaseGroup2 = it.next().getUseCaseGroup();
                if (useCaseGroup2.contains(useCase) && useCaseGroup2 != useCaseGroup) {
                    throw new IllegalStateException(String.format("Use case %s already bound to a different lifecycle.", useCase));
                }
            }
        }
        CameraSelector.Builder builderFromSelector = CameraSelector.Builder.fromSelector(cameraSelector);
        for (UseCase useCase2 : useCaseArr) {
            CameraSelector cameraSelector2 = useCase2.getUseCaseConfig().getCameraSelector(null);
            if (cameraSelector2 != null) {
                Iterator<CameraIdFilter> it2 = cameraSelector2.getCameraFilterSet().iterator();
                while (it2.hasNext()) {
                    builderFromSelector.appendFilter(it2.next());
                }
            }
        }
        String cameraWithCameraSelector = getCameraWithCameraSelector(builderFromSelector.build());
        CameraInternal camera = cameraXCheckInitialized.getCameraRepository().getCamera(cameraWithCameraSelector);
        for (UseCase useCase3 : useCaseArr) {
            useCase3.onBind(camera);
        }
        calculateSuggestedResolutions(lifecycleOwner, cameraWithCameraSelector, useCaseArr);
        for (UseCase useCase4 : useCaseArr) {
            useCaseGroup.addUseCase(useCase4);
            Iterator<String> it3 = useCase4.getAttachedCameraIds().iterator();
            while (it3.hasNext()) {
                attach(it3.next(), useCase4);
            }
        }
        orCreateUseCaseGroup.notifyState();
        return camera;
    }

    private static void calculateSuggestedResolutions(@NonNull LifecycleOwner lifecycleOwner, @NonNull String str, @NonNull UseCase... useCaseArr) {
        UseCaseGroup useCaseGroup = checkInitialized().getOrCreateUseCaseGroup(lifecycleOwner).getUseCaseGroup();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        for (UseCase useCase : useCaseGroup.getUseCases()) {
            for (String str2 : useCase.getAttachedCameraIds()) {
                List arrayList = (List) map.get(str2);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(str2, arrayList);
                }
                arrayList.add(useCase);
            }
        }
        for (UseCase useCase2 : useCaseArr) {
            List arrayList2 = (List) map2.get(str);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                map2.put(str, arrayList2);
            }
            arrayList2.add(useCase2);
        }
        for (String str3 : map2.keySet()) {
            Map<UseCase, Size> suggestedResolutions = getSurfaceManager().getSuggestedResolutions(str3, (List) map.get(str3), (List) map2.get(str3));
            for (UseCase useCase3 : (List) map2.get(str3)) {
                Size size = suggestedResolutions.get(useCase3);
                HashMap map3 = new HashMap();
                map3.put(str3, size);
                useCase3.updateSuggestedResolution(map3);
            }
        }
    }

    @NonNull
    private static CameraX checkInitialized() {
        CameraX cameraXWaitInitialized = waitInitialized();
        Preconditions.checkState(cameraXWaitInitialized.isInitializedInternal(), "Must call CameraX.initialize() first");
        return cameraXWaitInitialized;
    }

    private static void detach(String str, List<UseCase> list) {
        CameraInternal camera = checkInitialized().getCameraRepository().getCamera(str);
        for (UseCase useCase : list) {
            useCase.removeStateChangeCallback(camera);
            useCase.detachCameraControl(str);
        }
        camera.removeOnlineUseCase(list);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Collection<UseCase> getActiveUseCases() {
        for (UseCaseGroupLifecycleController useCaseGroupLifecycleController : checkInitialized().mUseCaseGroupRepository.getUseCaseGroups()) {
            if (useCaseGroupLifecycleController.getUseCaseGroup().isActive()) {
                return useCaseGroupLifecycleController.getUseCaseGroup().getUseCases();
            }
        }
        return null;
    }

    private CameraDeviceSurfaceManager getCameraDeviceSurfaceManager() {
        CameraDeviceSurfaceManager cameraDeviceSurfaceManager = this.mSurfaceManager;
        if (cameraDeviceSurfaceManager != null) {
            return cameraDeviceSurfaceManager;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static CameraFactory getCameraFactory() {
        CameraFactory cameraFactory = checkInitialized().mCameraFactory;
        if (cameraFactory != null) {
            return cameraFactory;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static CameraInfoInternal getCameraInfo(String str) {
        return checkInitialized().getCameraRepository().getCamera(str).getCameraInfoInternal();
    }

    private CameraRepository getCameraRepository() {
        return this.mCameraRepository;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static String getCameraWithCameraSelector(@NonNull CameraSelector cameraSelector) {
        checkInitialized();
        try {
            return cameraSelector.select(getCameraFactory().getAvailableCameraIds());
        } catch (CameraInfoUnavailableException unused) {
            return null;
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static String getCameraWithLensFacing(int i2) throws CameraInfoUnavailableException {
        checkInitialized();
        return getCameraFactory().cameraIdForLensFacing(i2);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Context getContext() {
        return checkInitialized().mContext;
    }

    private UseCaseConfigFactory getDefaultConfigFactory() {
        UseCaseConfigFactory useCaseConfigFactory = this.mDefaultConfigFactory;
        if (useCaseConfigFactory != null) {
            return useCaseConfigFactory;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static int getDefaultLensFacing() throws CameraInfoUnavailableException {
        Integer num;
        checkInitialized();
        Iterator it = Arrays.asList(1, 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                num = null;
                break;
            }
            num = (Integer) it.next();
            if (getCameraFactory().cameraIdForLensFacing(num.intValue()) != null) {
                break;
            }
        }
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("Unable to get default lens facing.");
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static <C extends UseCaseConfig<?>> C getDefaultUseCaseConfig(Class<C> cls, @Nullable CameraInfo cameraInfo) {
        return (C) checkInitialized().getDefaultConfigFactory().getConfig(cls, cameraInfo);
    }

    @NonNull
    private static c.b.b.a.a.a<CameraX> getInstance() {
        c.b.b.a.a.a<CameraX> instanceLocked;
        synchronized (sInitializeLock) {
            instanceLocked = getInstanceLocked();
        }
        return instanceLocked;
    }

    @NonNull
    @GuardedBy("sInitializeLock")
    private static c.b.b.a.a.a<CameraX> getInstanceLocked() {
        if (!sTargetInitialized) {
            return Futures.immediateFailedFuture(new IllegalStateException("Must call CameraX.initialize() first"));
        }
        final CameraX cameraX = sInstance;
        return Futures.transform(sInitializeFuture, new Function() { // from class: androidx.camera.core.f
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                CameraX cameraX2 = this.f1471a;
                CameraX.a(cameraX2, (Void) obj);
                return cameraX2;
            }
        }, CameraXExecutors.directExecutor());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static c.b.b.a.a.a<CameraX> getOrCreateInstance(@NonNull Context context) {
        c.b.b.a.a.a<CameraX> instanceLocked;
        Preconditions.checkNotNull(context, "Context must not be null.");
        synchronized (sInitializeLock) {
            instanceLocked = getInstanceLocked();
            CameraXConfig.Provider provider = null;
            if (instanceLocked.isDone()) {
                try {
                    instanceLocked.get();
                } catch (InterruptedException e2) {
                    throw new RuntimeException("Unexpected thread interrupt. Should not be possible since future is already complete.", e2);
                } catch (ExecutionException unused) {
                    shutdownLocked();
                    instanceLocked = null;
                }
            }
            if (instanceLocked == null) {
                Application application = (Application) context.getApplicationContext();
                if (application instanceof CameraXConfig.Provider) {
                    provider = (CameraXConfig.Provider) application;
                } else {
                    try {
                        provider = (CameraXConfig.Provider) Class.forName(application.getResources().getString(R.string.androidx_camera_default_config_provider)).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    } catch (Resources.NotFoundException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused2) {
                    }
                }
                if (provider == null) {
                    throw new IllegalStateException("CameraX is not initialized properly. Either the CameraXConfig.Provider interface must be implemented by your Application class or a CameraXConfig must be explicitly provided for initialization.");
                }
                initializeLocked(application, provider.getCameraXConfig());
                instanceLocked = getInstanceLocked();
            }
        }
        return instanceLocked;
    }

    private UseCaseGroupLifecycleController getOrCreateUseCaseGroup(LifecycleOwner lifecycleOwner) {
        return this.mUseCaseGroupRepository.getOrCreateUseCaseGroup(lifecycleOwner, new UseCaseGroupRepository.UseCaseGroupSetup() { // from class: androidx.camera.core.CameraX.2
            @Override // androidx.camera.core.UseCaseGroupRepository.UseCaseGroupSetup
            public void setup(UseCaseGroup useCaseGroup) {
                useCaseGroup.setListener(CameraX.this.mCameraRepository);
            }
        });
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static CameraDeviceSurfaceManager getSurfaceManager() {
        return checkInitialized().getCameraDeviceSurfaceManager();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static boolean hasCamera(@NonNull CameraSelector cameraSelector) throws CameraInfoUnavailableException {
        checkInitialized();
        try {
            cameraSelector.select(getCameraFactory().getAvailableCameraIds());
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.b.b.a.a.a<Void> initInternal(final Context context, final CameraXConfig cameraXConfig) {
        c.b.b.a.a.a<Void> future;
        synchronized (this.mInitializeLock) {
            Preconditions.checkState(this.mInitState == InternalInitState.UNINITIALIZED, "CameraX.initInternal() should only be called once per instance");
            this.mInitState = InternalInitState.INITIALIZING;
            future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.b
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return this.f1447a.a(context, cameraXConfig, completer);
                }
            });
        }
        return future;
    }

    @NonNull
    public static c.b.b.a.a.a<Void> initialize(@NonNull Context context, @NonNull CameraXConfig cameraXConfig) {
        c.b.b.a.a.a<Void> aVarInitializeLocked;
        synchronized (sInitializeLock) {
            aVarInitializeLocked = initializeLocked(context, cameraXConfig);
        }
        return aVarInitializeLocked;
    }

    @NonNull
    @GuardedBy("sInitializeLock")
    private static c.b.b.a.a.a<Void> initializeLocked(@NonNull final Context context, @NonNull final CameraXConfig cameraXConfig) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(cameraXConfig);
        Preconditions.checkState(!sTargetInitialized, "Must call CameraX.shutdown() first.");
        sTargetInitialized = true;
        Executor cameraExecutor = cameraXConfig.getCameraExecutor(null);
        if (cameraExecutor == null) {
            cameraExecutor = new CameraExecutor();
        }
        final CameraX cameraX = new CameraX(cameraExecutor);
        sInstance = cameraX;
        sInitializeFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.d
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return CameraX.a(this.f1460a, context, cameraXConfig, completer);
            }
        });
        return sInitializeFuture;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static boolean isBound(@NonNull UseCase useCase) {
        Iterator<UseCaseGroupLifecycleController> it = checkInitialized().mUseCaseGroupRepository.getUseCaseGroups().iterator();
        while (it.hasNext()) {
            if (it.next().getUseCaseGroup().contains(useCase)) {
                return true;
            }
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static boolean isInitialized() {
        boolean z;
        synchronized (sInitializeLock) {
            z = sInstance != null && sInstance.isInitializedInternal();
        }
        return z;
    }

    private boolean isInitializedInternal() {
        boolean z;
        synchronized (this.mInitializeLock) {
            z = this.mInitState == InternalInitState.INITIALIZED;
        }
        return z;
    }

    @NonNull
    public static c.b.b.a.a.a<Void> shutdown() {
        c.b.b.a.a.a<Void> aVarShutdownLocked;
        synchronized (sInitializeLock) {
            aVarShutdownLocked = shutdownLocked();
        }
        return aVarShutdownLocked;
    }

    @NonNull
    private c.b.b.a.a.a<Void> shutdownInternal() {
        synchronized (this.mInitializeLock) {
            int i2 = AnonymousClass3.$SwitchMap$androidx$camera$core$CameraX$InternalInitState[this.mInitState.ordinal()];
            if (i2 == 1) {
                this.mInitState = InternalInitState.SHUTDOWN;
                return Futures.immediateFuture(null);
            }
            if (i2 == 2) {
                throw new IllegalStateException("CameraX could not be shutdown when it is initializing.");
            }
            if (i2 == 3) {
                this.mInitState = InternalInitState.SHUTDOWN;
                this.mShutdownInternalFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.i
                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                        return this.f1481a.b(completer);
                    }
                });
            }
            return this.mShutdownInternalFuture;
        }
    }

    @NonNull
    @GuardedBy("sInitializeLock")
    private static c.b.b.a.a.a<Void> shutdownLocked() {
        if (!sTargetInitialized) {
            return sShutdownFuture;
        }
        sTargetInitialized = false;
        final CameraX cameraX = sInstance;
        sInstance = null;
        sShutdownFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.a
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return CameraX.b(this.f1444a, completer);
            }
        });
        return sShutdownFuture;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void unbind(@NonNull UseCase... useCaseArr) {
        Threads.checkMainThread();
        Collection<UseCaseGroupLifecycleController> useCaseGroups = checkInitialized().mUseCaseGroupRepository.getUseCaseGroups();
        HashMap map = new HashMap();
        for (UseCase useCase : useCaseArr) {
            Iterator<UseCaseGroupLifecycleController> it = useCaseGroups.iterator();
            while (it.hasNext()) {
                if (it.next().getUseCaseGroup().removeUseCase(useCase)) {
                    for (String str : useCase.getAttachedCameraIds()) {
                        List arrayList = (List) map.get(str);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            map.put(str, arrayList);
                        }
                        arrayList.add(useCase);
                    }
                }
            }
        }
        for (String str2 : map.keySet()) {
            detach(str2, (List) map.get(str2));
        }
        for (UseCase useCase2 : useCaseArr) {
            useCase2.clear();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void unbindAll() {
        Threads.checkMainThread();
        Collection<UseCaseGroupLifecycleController> useCaseGroups = checkInitialized().mUseCaseGroupRepository.getUseCaseGroups();
        ArrayList arrayList = new ArrayList();
        Iterator<UseCaseGroupLifecycleController> it = useCaseGroups.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getUseCaseGroup().getUseCases());
        }
        unbind((UseCase[]) arrayList.toArray(new UseCase[0]));
    }

    @NonNull
    private static CameraX waitInitialized() {
        try {
            return getInstance().get(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e2) {
            throw new IllegalStateException(e2);
        } catch (ExecutionException e3) {
            throw new IllegalStateException(e3);
        } catch (TimeoutException e4) {
            throw new IllegalStateException(e4);
        }
    }

    public /* synthetic */ void b(Context context, CameraXConfig cameraXConfig, CallbackToFutureAdapter.Completer completer) {
        try {
            this.mContext = context.getApplicationContext();
            CameraFactory.Provider cameraFactoryProvider = cameraXConfig.getCameraFactoryProvider(null);
            if (cameraFactoryProvider == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid app configuration provided. Missing CameraFactory.");
                synchronized (this.mInitializeLock) {
                    this.mInitState = InternalInitState.INITIALIZED;
                }
                completer.setException(illegalArgumentException);
                return;
            }
            this.mCameraFactory = cameraFactoryProvider.newInstance(context);
            CameraDeviceSurfaceManager.Provider deviceSurfaceManagerProvider = cameraXConfig.getDeviceSurfaceManagerProvider(null);
            if (deviceSurfaceManagerProvider == null) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Invalid app configuration provided. Missing CameraDeviceSurfaceManager.");
                synchronized (this.mInitializeLock) {
                    this.mInitState = InternalInitState.INITIALIZED;
                }
                completer.setException(illegalArgumentException2);
                return;
            }
            this.mSurfaceManager = deviceSurfaceManagerProvider.newInstance(context);
            UseCaseConfigFactory.Provider useCaseConfigFactoryProvider = cameraXConfig.getUseCaseConfigFactoryProvider(null);
            if (useCaseConfigFactoryProvider == null) {
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Invalid app configuration provided. Missing UseCaseConfigFactory.");
                synchronized (this.mInitializeLock) {
                    this.mInitState = InternalInitState.INITIALIZED;
                }
                completer.setException(illegalArgumentException3);
                return;
            }
            this.mDefaultConfigFactory = useCaseConfigFactoryProvider.newInstance(context);
            if (this.mCameraExecutor instanceof CameraExecutor) {
                ((CameraExecutor) this.mCameraExecutor).init(this.mCameraFactory);
            }
            this.mCameraRepository.init(this.mCameraFactory);
            synchronized (this.mInitializeLock) {
                this.mInitState = InternalInitState.INITIALIZED;
            }
            completer.set(null);
        } catch (Throwable th) {
            synchronized (this.mInitializeLock) {
                this.mInitState = InternalInitState.INITIALIZED;
                completer.set(null);
                throw th;
            }
        }
    }

    public /* synthetic */ Object a(final Context context, final CameraXConfig cameraXConfig, final CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mCameraExecutor.execute(new Runnable() { // from class: androidx.camera.core.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f1454a.b(context, cameraXConfig, completer);
            }
        });
        return "CameraX initInternal";
    }

    public /* synthetic */ void a(CallbackToFutureAdapter.Completer completer) {
        Executor executor = this.mCameraExecutor;
        if (executor instanceof CameraExecutor) {
            ((CameraExecutor) executor).deinit();
        }
        completer.set(null);
    }

    public /* synthetic */ Object b(final CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mCameraRepository.deinit().addListener(new Runnable() { // from class: androidx.camera.core.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f1473a.a(completer);
            }
        }, this.mCameraExecutor);
        return "CameraX shutdownInternal";
    }
}
