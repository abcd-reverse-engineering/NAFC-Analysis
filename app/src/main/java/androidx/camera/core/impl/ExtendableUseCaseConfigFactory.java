package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraInfo;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class ExtendableUseCaseConfigFactory implements UseCaseConfigFactory {
    private final Map<Class<?>, ConfigProvider<?>> mDefaultProviders = new HashMap();

    @Override // androidx.camera.core.impl.UseCaseConfigFactory
    @Nullable
    public <C extends UseCaseConfig<?>> C getConfig(@NonNull Class<C> cls, @Nullable CameraInfo cameraInfo) {
        ConfigProvider<?> configProvider = this.mDefaultProviders.get(cls);
        if (configProvider != null) {
            return (C) configProvider.getConfig(cameraInfo);
        }
        return null;
    }

    public <C extends Config> void installDefaultProvider(@NonNull Class<C> cls, @NonNull ConfigProvider<C> configProvider) {
        this.mDefaultProviders.put(cls, configProvider);
    }
}
