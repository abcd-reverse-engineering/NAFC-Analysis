package androidx.camera.core;

import android.util.Size;
import androidx.annotation.CallSuper;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class UseCase {

    @GuardedBy("mBoundCameraLock")
    private CameraInternal mBoundCamera;
    private UseCaseConfig<?> mUseCaseConfig;
    private final Set<StateChangeCallback> mStateChangeCallbacks = new HashSet();
    private final Map<String, CameraControlInternal> mAttachedCameraControlMap = new HashMap();
    private final Map<String, SessionConfig> mAttachedCameraIdToSessionConfigMap = new HashMap();
    private final Map<String, Size> mAttachedSurfaceResolutionMap = new HashMap();
    private State mState = State.INACTIVE;
    private final Object mBoundCameraLock = new Object();
    private int mImageFormat = 34;

    /* renamed from: androidx.camera.core.UseCase$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$UseCase$State = new int[State.values().length];

        static {
            try {
                $SwitchMap$androidx$camera$core$UseCase$State[State.INACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$core$UseCase$State[State.ACTIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface EventCallback {
        void onBind(@NonNull String str);

        void onUnbind();
    }

    enum State {
        ACTIVE,
        INACTIVE
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface StateChangeCallback {
        void onUseCaseActive(@NonNull UseCase useCase);

        void onUseCaseInactive(@NonNull UseCase useCase);

        void onUseCaseReset(@NonNull UseCase useCase);

        void onUseCaseUpdated(@NonNull UseCase useCase);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected UseCase(@NonNull UseCaseConfig<?> useCaseConfig) {
        updateUseCaseConfig(useCaseConfig);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void addStateChangeCallback(@NonNull StateChangeCallback stateChangeCallback) {
        this.mStateChangeCallbacks.add(stateChangeCallback);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected UseCaseConfig<?> applyDefaults(@NonNull UseCaseConfig<?> useCaseConfig, @Nullable UseCaseConfig.Builder<?, ?, ?> builder) {
        if (builder == null) {
            return useCaseConfig;
        }
        MutableConfig mutableConfig = builder.getMutableConfig();
        if (useCaseConfig.containsOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO) && mutableConfig.containsOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO_CUSTOM)) {
            mutableConfig.removeOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO_CUSTOM);
        }
        for (Config.Option<?> option : useCaseConfig.listOptions()) {
            mutableConfig.insertOption(option, useCaseConfig.retrieveOption(option));
        }
        return builder.getUseCaseConfig();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void attachCameraControl(String str, CameraControlInternal cameraControlInternal) {
        this.mAttachedCameraControlMap.put(str, cameraControlInternal);
        onCameraControlReady(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void attachToCamera(String str, SessionConfig sessionConfig) {
        this.mAttachedCameraIdToSessionConfigMap.put(str, sessionConfig);
    }

    @CallSuper
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void clear() {
        EventCallback useCaseEventCallback = this.mUseCaseConfig.getUseCaseEventCallback(null);
        if (useCaseEventCallback != null) {
            useCaseEventCallback.onUnbind();
        }
        synchronized (this.mBoundCameraLock) {
            this.mBoundCamera = null;
        }
        this.mStateChangeCallbacks.clear();
    }

    final void detachCameraControl(String str) {
        this.mAttachedCameraControlMap.remove(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Set<String> getAttachedCameraIds() {
        return this.mAttachedCameraIdToSessionConfigMap.keySet();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Size getAttachedSurfaceResolution(String str) {
        return this.mAttachedSurfaceResolutionMap.get(str);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraInternal getBoundCamera() {
        CameraInternal cameraInternal;
        synchronized (this.mBoundCameraLock) {
            cameraInternal = this.mBoundCamera;
        }
        return cameraInternal;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected String getBoundCameraId() {
        return ((CameraInternal) Preconditions.checkNotNull(getBoundCamera(), "No camera bound to use case: " + this)).getCameraInfoInternal().getCameraId();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected CameraControlInternal getCameraControl(String str) {
        CameraControlInternal cameraControlInternal = this.mAttachedCameraControlMap.get(str);
        return cameraControlInternal == null ? CameraControlInternal.DEFAULT_EMPTY_INSTANCE : cameraControlInternal;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected UseCaseConfig.Builder<?, ?, ?> getDefaultBuilder(@Nullable CameraInfo cameraInfo) {
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getImageFormat() {
        return this.mImageFormat;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getName() {
        return this.mUseCaseConfig.getTargetName("<UnknownUseCase-" + hashCode() + ">");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public SessionConfig getSessionConfig(String str) {
        SessionConfig sessionConfig = this.mAttachedCameraIdToSessionConfigMap.get(str);
        if (sessionConfig != null) {
            return sessionConfig;
        }
        throw new IllegalArgumentException("Invalid camera: " + str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfig<?> getUseCaseConfig() {
        return this.mUseCaseConfig;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected boolean isCurrentlyBoundCamera(@NonNull String str) {
        if (getBoundCamera() == null) {
            return false;
        }
        return Objects.equals(str, getBoundCameraId());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected final void notifyActive() {
        this.mState = State.ACTIVE;
        notifyState();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected final void notifyInactive() {
        this.mState = State.INACTIVE;
        notifyState();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected final void notifyReset() {
        Iterator<StateChangeCallback> it = this.mStateChangeCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onUseCaseReset(this);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected final void notifyState() {
        int i2 = AnonymousClass1.$SwitchMap$androidx$camera$core$UseCase$State[this.mState.ordinal()];
        if (i2 == 1) {
            Iterator<StateChangeCallback> it = this.mStateChangeCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onUseCaseInactive(this);
            }
        } else {
            if (i2 != 2) {
                return;
            }
            Iterator<StateChangeCallback> it2 = this.mStateChangeCallbacks.iterator();
            while (it2.hasNext()) {
                it2.next().onUseCaseActive(this);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected final void notifyUpdated() {
        Iterator<StateChangeCallback> it = this.mStateChangeCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onUseCaseUpdated(this);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void onBind(@NonNull CameraInternal cameraInternal) {
        synchronized (this.mBoundCameraLock) {
            this.mBoundCamera = cameraInternal;
        }
        updateUseCaseConfig(this.mUseCaseConfig);
        EventCallback useCaseEventCallback = this.mUseCaseConfig.getUseCaseEventCallback(null);
        if (useCaseEventCallback != null) {
            useCaseEventCallback.onBind(cameraInternal.getCameraInfoInternal().getCameraId());
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void onCameraControlReady(String str) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onStateOffline(@NonNull String str) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onStateOnline(@NonNull String str) {
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected abstract Map<String, Size> onSuggestedResolutionUpdated(@NonNull Map<String, Size> map);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void removeStateChangeCallback(@NonNull StateChangeCallback stateChangeCallback) {
        this.mStateChangeCallbacks.remove(stateChangeCallback);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void setImageFormat(int i2) {
        this.mImageFormat = i2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void updateSuggestedResolution(Map<String, Size> map) {
        for (Map.Entry<String, Size> entry : onSuggestedResolutionUpdated(map).entrySet()) {
            this.mAttachedSurfaceResolutionMap.put(entry.getKey(), entry.getValue());
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected final void updateUseCaseConfig(@NonNull UseCaseConfig<?> useCaseConfig) {
        this.mUseCaseConfig = applyDefaults(useCaseConfig, getDefaultBuilder(getBoundCamera() == null ? null : getBoundCamera().getCameraInfo()));
    }
}
