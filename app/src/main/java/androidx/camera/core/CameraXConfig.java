package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.internal.TargetConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class CameraXConfig implements TargetConfig<CameraX>, Config {
    private final OptionsBundle mConfig;
    static final Config.Option<CameraFactory.Provider> OPTION_CAMERA_FACTORY_PROVIDER = Config.Option.create("camerax.core.appConfig.cameraFactoryProvider", CameraFactory.Provider.class);
    static final Config.Option<CameraDeviceSurfaceManager.Provider> OPTION_DEVICE_SURFACE_MANAGER_PROVIDER = Config.Option.create("camerax.core.appConfig.deviceSurfaceManagerProvider", CameraDeviceSurfaceManager.Provider.class);
    static final Config.Option<UseCaseConfigFactory.Provider> OPTION_USECASE_CONFIG_FACTORY_PROVIDER = Config.Option.create("camerax.core.appConfig.useCaseConfigFactoryProvider", UseCaseConfigFactory.Provider.class);
    static final Config.Option<Executor> OPTION_CAMERA_EXECUTOR = Config.Option.create("camerax.core.appConfig.cameraExecutor", Executor.class);

    public static final class Builder implements TargetConfig.Builder<CameraX, Builder> {
        private final MutableOptionsBundle mMutableConfig;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder() {
            this(MutableOptionsBundle.create());
        }

        @NonNull
        public static Builder fromConfig(@NonNull CameraXConfig cameraXConfig) {
            return new Builder(MutableOptionsBundle.from((Config) cameraXConfig));
        }

        @NonNull
        private MutableConfig getMutableConfig() {
            return this.mMutableConfig;
        }

        @NonNull
        public CameraXConfig build() {
            return new CameraXConfig(OptionsBundle.from(this.mMutableConfig));
        }

        @NonNull
        public Builder setCameraExecutor(@NonNull Executor executor) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_CAMERA_EXECUTOR, executor);
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setCameraFactoryProvider(@NonNull CameraFactory.Provider provider) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_CAMERA_FACTORY_PROVIDER, provider);
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setDeviceSurfaceManagerProvider(@NonNull CameraDeviceSurfaceManager.Provider provider) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_DEVICE_SURFACE_MANAGER_PROVIDER, provider);
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setUseCaseConfigFactoryProvider(@NonNull UseCaseConfigFactory.Provider provider) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_USECASE_CONFIG_FACTORY_PROVIDER, provider);
            return this;
        }

        private Builder(MutableOptionsBundle mutableOptionsBundle) {
            this.mMutableConfig = mutableOptionsBundle;
            Class cls = (Class) mutableOptionsBundle.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
            if (cls == null || cls.equals(CameraX.class)) {
                setTargetClass(CameraX.class);
                return;
            }
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.internal.TargetConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setTargetClass(@NonNull Class<CameraX> cls) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_CLASS, cls);
            if (getMutableConfig().retrieveOption(TargetConfig.OPTION_TARGET_NAME, null) == null) {
                setTargetName(cls.getCanonicalName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + UUID.randomUUID());
            }
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.internal.TargetConfig.Builder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder setTargetName(@NonNull String str) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_NAME, str);
            return this;
        }
    }

    public interface Provider {
        @NonNull
        CameraXConfig getCameraXConfig();
    }

    CameraXConfig(OptionsBundle optionsBundle) {
        this.mConfig = optionsBundle;
    }

    @Override // androidx.camera.core.impl.Config
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean containsOption(@NonNull Config.Option<?> option) {
        return this.mConfig.containsOption(option);
    }

    @Override // androidx.camera.core.impl.Config
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void findOptions(@NonNull String str, @NonNull Config.OptionMatcher optionMatcher) {
        this.mConfig.findOptions(str, optionMatcher);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Executor getCameraExecutor(@Nullable Executor executor) {
        return (Executor) this.mConfig.retrieveOption(OPTION_CAMERA_EXECUTOR, executor);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraFactory.Provider getCameraFactoryProvider(@Nullable CameraFactory.Provider provider) {
        return (CameraFactory.Provider) this.mConfig.retrieveOption(OPTION_CAMERA_FACTORY_PROVIDER, provider);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraDeviceSurfaceManager.Provider getDeviceSurfaceManagerProvider(@Nullable CameraDeviceSurfaceManager.Provider provider) {
        return (CameraDeviceSurfaceManager.Provider) this.mConfig.retrieveOption(OPTION_DEVICE_SURFACE_MANAGER_PROVIDER, provider);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Class<CameraX> getTargetClass(@Nullable Class<CameraX> cls) {
        return (Class) retrieveOption(TargetConfig.OPTION_TARGET_CLASS, cls);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getTargetName(@Nullable String str) {
        return (String) retrieveOption(TargetConfig.OPTION_TARGET_NAME, str);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfigFactory.Provider getUseCaseConfigFactoryProvider(@Nullable UseCaseConfigFactory.Provider provider) {
        return (UseCaseConfigFactory.Provider) this.mConfig.retrieveOption(OPTION_USECASE_CONFIG_FACTORY_PROVIDER, provider);
    }

    @Override // androidx.camera.core.impl.Config
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Set<Config.Option<?>> listOptions() {
        return this.mConfig.listOptions();
    }

    @Override // androidx.camera.core.impl.Config
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public <ValueT> ValueT retrieveOption(@NonNull Config.Option<ValueT> option) {
        return (ValueT) this.mConfig.retrieveOption(option);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Class<CameraX> getTargetClass() {
        return (Class) retrieveOption(TargetConfig.OPTION_TARGET_CLASS);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getTargetName() {
        return (String) retrieveOption(TargetConfig.OPTION_TARGET_NAME);
    }

    @Override // androidx.camera.core.impl.Config
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public <ValueT> ValueT retrieveOption(@NonNull Config.Option<ValueT> option, @Nullable ValueT valuet) {
        return (ValueT) this.mConfig.retrieveOption(option, valuet);
    }
}
