package androidx.camera.camera2;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.camera.camera2.internal.Camera2CameraFactory;
import androidx.camera.camera2.internal.Camera2DeviceSurfaceManager;
import androidx.camera.camera2.internal.ImageAnalysisConfigProvider;
import androidx.camera.camera2.internal.ImageCaptureConfigProvider;
import androidx.camera.camera2.internal.PreviewConfigProvider;
import androidx.camera.camera2.internal.VideoCaptureConfigProvider;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.ExtendableUseCaseConfigFactory;
import androidx.camera.core.impl.ImageAnalysisConfig;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.VideoCaptureConfig;

/* loaded from: classes.dex */
public final class Camera2Config {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final class DefaultProvider implements CameraXConfig.Provider {
        @Override // androidx.camera.core.CameraXConfig.Provider
        @NonNull
        public CameraXConfig getCameraXConfig() {
            return Camera2Config.defaultConfig();
        }
    }

    private Camera2Config() {
    }

    static /* synthetic */ UseCaseConfigFactory a(Context context) {
        ExtendableUseCaseConfigFactory extendableUseCaseConfigFactory = new ExtendableUseCaseConfigFactory();
        extendableUseCaseConfigFactory.installDefaultProvider(ImageAnalysisConfig.class, new ImageAnalysisConfigProvider(context));
        extendableUseCaseConfigFactory.installDefaultProvider(ImageCaptureConfig.class, new ImageCaptureConfigProvider(context));
        extendableUseCaseConfigFactory.installDefaultProvider(VideoCaptureConfig.class, new VideoCaptureConfigProvider(context));
        extendableUseCaseConfigFactory.installDefaultProvider(PreviewConfig.class, new PreviewConfigProvider(context));
        return extendableUseCaseConfigFactory;
    }

    @NonNull
    public static CameraXConfig defaultConfig() {
        c cVar = new CameraFactory.Provider() { // from class: androidx.camera.camera2.c
            @Override // androidx.camera.core.impl.CameraFactory.Provider
            public final CameraFactory newInstance(Context context) {
                return new Camera2CameraFactory(context);
            }
        };
        b bVar = new CameraDeviceSurfaceManager.Provider() { // from class: androidx.camera.camera2.b
            @Override // androidx.camera.core.impl.CameraDeviceSurfaceManager.Provider
            public final CameraDeviceSurfaceManager newInstance(Context context) {
                return new Camera2DeviceSurfaceManager(context);
            }
        };
        return new CameraXConfig.Builder().setCameraFactoryProvider(cVar).setDeviceSurfaceManagerProvider(bVar).setUseCaseConfigFactoryProvider(new UseCaseConfigFactory.Provider() { // from class: androidx.camera.camera2.a
            @Override // androidx.camera.core.impl.UseCaseConfigFactory.Provider
            public final UseCaseConfigFactory newInstance(Context context) {
                return Camera2Config.a(context);
            }
        }).build();
    }
}
