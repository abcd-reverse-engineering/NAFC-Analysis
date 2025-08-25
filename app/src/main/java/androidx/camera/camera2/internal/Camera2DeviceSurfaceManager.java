package androidx.camera.camera2.internal;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.CamcorderProfile;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.core.util.Preconditions;
import cn.cloudwalk.libproject.Contants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class Camera2DeviceSurfaceManager implements CameraDeviceSurfaceManager {
    private static final Size MAXIMUM_PREVIEW_SIZE = new Size(1920, 1080);
    private static final String TAG = "Camera2DeviceSurfaceManager";
    private final CamcorderProfileHelper mCamcorderProfileHelper;
    private final Map<String, SupportedSurfaceCombination> mCameraSupportedSurfaceCombinationMap;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Camera2DeviceSurfaceManager(@NonNull Context context) {
        this(context, new CamcorderProfileHelper() { // from class: androidx.camera.camera2.internal.z
            @Override // androidx.camera.camera2.internal.CamcorderProfileHelper
            public final boolean hasProfile(int i2, int i3) {
                return CamcorderProfile.hasProfile(i2, i3);
            }
        });
    }

    private void init(@NonNull Context context) throws CameraAccessException {
        Preconditions.checkNotNull(context);
        try {
            for (String str : ((CameraManager) Preconditions.checkNotNull((CameraManager) context.getSystemService("camera"))).getCameraIdList()) {
                this.mCameraSupportedSurfaceCombinationMap.put(str, new SupportedSurfaceCombination(context, str, this.mCamcorderProfileHelper));
            }
        } catch (CameraAccessException e2) {
            throw new IllegalArgumentException("Fail to get camera id list", e2);
        }
    }

    @Override // androidx.camera.core.impl.CameraDeviceSurfaceManager
    public boolean checkSupported(@NonNull String str, @Nullable List<SurfaceConfig> list) {
        if (list == null || list.isEmpty()) {
            return true;
        }
        SupportedSurfaceCombination supportedSurfaceCombination = this.mCameraSupportedSurfaceCombinationMap.get(str);
        if (supportedSurfaceCombination != null) {
            return supportedSurfaceCombination.checkSupported(list);
        }
        return false;
    }

    @Override // androidx.camera.core.impl.CameraDeviceSurfaceManager
    @Nullable
    public Rational getCorrectedAspectRatio(@NonNull String str, int i2) {
        SupportedSurfaceCombination supportedSurfaceCombination = this.mCameraSupportedSurfaceCombinationMap.get(str);
        if (supportedSurfaceCombination != null) {
            return supportedSurfaceCombination.getCorrectedAspectRatio(i2);
        }
        throw new IllegalArgumentException("Fail to find supported surface info - CameraId:" + str);
    }

    @Override // androidx.camera.core.impl.CameraDeviceSurfaceManager
    @NonNull
    public Size getMaxOutputSize(@NonNull String str, int i2) {
        SupportedSurfaceCombination supportedSurfaceCombination = this.mCameraSupportedSurfaceCombinationMap.get(str);
        if (supportedSurfaceCombination != null) {
            return supportedSurfaceCombination.getMaxOutputSizeByFormat(i2);
        }
        throw new IllegalArgumentException("Fail to find supported surface info - CameraId:" + str);
    }

    @Override // androidx.camera.core.impl.CameraDeviceSurfaceManager
    @NonNull
    public Size getPreviewSize() {
        Size size = MAXIMUM_PREVIEW_SIZE;
        if (this.mCameraSupportedSurfaceCombinationMap.isEmpty()) {
            return size;
        }
        return this.mCameraSupportedSurfaceCombinationMap.get((String) this.mCameraSupportedSurfaceCombinationMap.keySet().toArray()[0]).getSurfaceSizeDefinition().getPreviewSize();
    }

    @Override // androidx.camera.core.impl.CameraDeviceSurfaceManager
    @NonNull
    public Map<UseCase, Size> getSuggestedResolutions(@NonNull String str, @Nullable List<UseCase> list, @NonNull List<UseCase> list2) {
        Preconditions.checkNotNull(list2, "No new use cases to be bound.");
        Preconditions.checkArgument(!list2.isEmpty(), "No new use cases to be bound.");
        UseCaseSurfaceOccupancyManager.checkUseCaseLimitNotExceeded(list, list2);
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (UseCase useCase : list) {
                arrayList.add(transformSurfaceConfig(str, useCase.getImageFormat(), useCase.getAttachedSurfaceResolution(((CameraInternal) Preconditions.checkNotNull(useCase.getBoundCamera())).getCameraInfoInternal().getCameraId())));
            }
        }
        Iterator<UseCase> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(transformSurfaceConfig(str, it.next().getImageFormat(), new Size(Contants.PREVIEW_W, 480)));
        }
        SupportedSurfaceCombination supportedSurfaceCombination = this.mCameraSupportedSurfaceCombinationMap.get(str);
        if (supportedSurfaceCombination != null && supportedSurfaceCombination.checkSupported(arrayList)) {
            return supportedSurfaceCombination.getSuggestedResolutions(list, list2);
        }
        throw new IllegalArgumentException("No supported surface combination is found for camera device - Id : " + str + ".  May be attempting to bind too many use cases.");
    }

    @Override // androidx.camera.core.impl.CameraDeviceSurfaceManager
    public boolean requiresCorrectedAspectRatio(@NonNull String str) {
        SupportedSurfaceCombination supportedSurfaceCombination = this.mCameraSupportedSurfaceCombinationMap.get(str);
        if (supportedSurfaceCombination != null) {
            return supportedSurfaceCombination.requiresCorrectedAspectRatio();
        }
        throw new IllegalArgumentException("Fail to find supported surface info - CameraId:" + str);
    }

    @Override // androidx.camera.core.impl.CameraDeviceSurfaceManager
    @Nullable
    public SurfaceConfig transformSurfaceConfig(@NonNull String str, int i2, @NonNull Size size) {
        SupportedSurfaceCombination supportedSurfaceCombination = this.mCameraSupportedSurfaceCombinationMap.get(str);
        if (supportedSurfaceCombination != null) {
            return supportedSurfaceCombination.transformSurfaceConfig(i2, size);
        }
        return null;
    }

    Camera2DeviceSurfaceManager(@NonNull Context context, @NonNull CamcorderProfileHelper camcorderProfileHelper) throws CameraAccessException {
        this.mCameraSupportedSurfaceCombinationMap = new HashMap();
        Preconditions.checkNotNull(camcorderProfileHelper);
        this.mCamcorderProfileHelper = camcorderProfileHelper;
        init(context);
    }
}
