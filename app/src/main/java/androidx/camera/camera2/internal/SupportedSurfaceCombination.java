package androidx.camera.camera2.internal;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.CameraX;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.SurfaceCombination;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.SurfaceSizeDefinition;
import androidx.core.util.Preconditions;
import cn.cloudwalk.FaceInterface;
import cn.cloudwalk.libproject.Contants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class SupportedSurfaceCombination {
    private static final int ALIGN16 = 16;
    private CamcorderProfileHelper mCamcorderProfileHelper;
    private String mCameraId;
    private CameraCharacteristics mCharacteristics;
    private SurfaceSizeDefinition mSurfaceSizeDefinition;
    private static final Size MAX_PREVIEW_SIZE = new Size(1920, 1080);
    private static final Size DEFAULT_SIZE = new Size(Contants.PREVIEW_W, 480);
    private static final Size ZERO_SIZE = new Size(0, 0);
    private static final Size QUALITY_2160P_SIZE = new Size(3840, 2160);
    private static final Size QUALITY_1080P_SIZE = new Size(1920, 1080);
    private static final Size QUALITY_720P_SIZE = new Size(1280, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_AUTH_ERROR);
    private static final Size QUALITY_480P_SIZE = new Size(FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_AUTH_ERROR, 480);
    private static final Rational ASPECT_RATIO_4_3 = new Rational(4, 3);
    private static final Rational ASPECT_RATIO_3_4 = new Rational(3, 4);
    private static final Rational ASPECT_RATIO_16_9 = new Rational(16, 9);
    private static final Rational ASPECT_RATIO_9_16 = new Rational(9, 16);
    private final List<SurfaceCombination> mSurfaceCombinations = new ArrayList();
    private final Map<Integer, Size> mMaxSizeCache = new HashMap();
    private int mHardwareLevel = 2;
    private boolean mIsRawSupported = false;
    private boolean mIsBurstCaptureSupported = false;

    static final class CompareSizesByArea implements Comparator<Size> {
        private boolean mReverse;

        CompareSizesByArea() {
            this.mReverse = false;
        }

        @Override // java.util.Comparator
        public int compare(Size size, Size size2) {
            int iSignum = Long.signum((size.getWidth() * size.getHeight()) - (size2.getWidth() * size2.getHeight()));
            return this.mReverse ? iSignum * (-1) : iSignum;
        }

        CompareSizesByArea(boolean z) {
            this.mReverse = false;
            this.mReverse = z;
        }
    }

    static final class CompareSizesByDistanceToTargetRatio implements Comparator<Size> {
        private Float mTargetRatio;

        CompareSizesByDistanceToTargetRatio(Float f2) {
            this.mTargetRatio = f2;
        }

        @Override // java.util.Comparator
        public int compare(Size size, Size size2) {
            if (SupportedSurfaceCombination.hasMatchingAspectRatio(size, new Rational(size2.getWidth(), size2.getHeight()))) {
                return 0;
            }
            return (int) Math.signum(Float.valueOf(Math.abs(Float.valueOf((size.getWidth() * 1.0f) / size.getHeight()).floatValue() - this.mTargetRatio.floatValue())).floatValue() - Float.valueOf(Math.abs(Float.valueOf((size2.getWidth() * 1.0f) / size2.getHeight()).floatValue() - this.mTargetRatio.floatValue())).floatValue());
        }
    }

    SupportedSurfaceCombination(Context context, String str, CamcorderProfileHelper camcorderProfileHelper) {
        this.mCameraId = str;
        this.mCamcorderProfileHelper = camcorderProfileHelper;
        init(context);
    }

    private void checkCustomization() {
    }

    private Size fetchMaxSize(int i2) {
        Size size = this.mMaxSizeCache.get(Integer.valueOf(i2));
        if (size != null) {
            return size;
        }
        Size maxOutputSizeByFormat = getMaxOutputSizeByFormat(i2);
        this.mMaxSizeCache.put(Integer.valueOf(i2), maxOutputSizeByFormat);
        return maxOutputSizeByFormat;
    }

    private void generateSupportedCombinationList(CameraManager cameraManager) throws CameraAccessException {
        this.mCharacteristics = cameraManager.getCameraCharacteristics(this.mCameraId);
        Integer num = (Integer) this.mCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (num != null) {
            this.mHardwareLevel = num.intValue();
        }
        this.mSurfaceCombinations.addAll(getLegacySupportedCombinationList());
        int i2 = this.mHardwareLevel;
        if (i2 == 0 || i2 == 1 || i2 == 3) {
            this.mSurfaceCombinations.addAll(getLimitedSupportedCombinationList());
        }
        int i3 = this.mHardwareLevel;
        if (i3 == 1 || i3 == 3) {
            this.mSurfaceCombinations.addAll(getFullSupportedCombinationList());
        }
        int[] iArr = (int[]) this.mCharacteristics.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr != null) {
            for (int i4 : iArr) {
                if (i4 == 3) {
                    this.mIsRawSupported = true;
                } else if (i4 == 6) {
                    this.mIsBurstCaptureSupported = true;
                }
            }
        }
        if (this.mIsRawSupported) {
            this.mSurfaceCombinations.addAll(getRAWSupportedCombinationList());
        }
        if (this.mIsBurstCaptureSupported && this.mHardwareLevel == 0) {
            this.mSurfaceCombinations.addAll(getBurstSupportedCombinationList());
        }
        if (this.mHardwareLevel == 3) {
            this.mSurfaceCombinations.addAll(getLevel3SupportedCombinationList());
        }
    }

    private void generateSurfaceSizeDefinition(WindowManager windowManager) {
        this.mSurfaceSizeDefinition = SurfaceSizeDefinition.create(new Size(Contants.PREVIEW_W, 480), getPreviewSize(windowManager), getRecordSize());
    }

    @Nullable
    private Size[] getAllOutputSizesByFormat(int i2) {
        return getAllOutputSizesByFormat(i2, null);
    }

    private List<List<Size>> getAllPossibleSizeArrangements(List<List<Size>> list) {
        Iterator<List<Size>> it = list.iterator();
        int size = 1;
        while (it.hasNext()) {
            size *= it.next().size();
        }
        if (size == 0) {
            throw new IllegalArgumentException("Failed to find supported resolutions.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new ArrayList());
        }
        int i3 = size;
        int size2 = size / list.get(0).size();
        for (int i4 = 0; i4 < list.size(); i4++) {
            List<Size> list2 = list.get(i4);
            for (int i5 = 0; i5 < size; i5++) {
                ((List) arrayList.get(i5)).add(list2.get((i5 % i3) / size2));
            }
            if (i4 < list.size() - 1) {
                int i6 = size2;
                size2 /= list.get(i4 + 1).size();
                i3 = i6;
            }
        }
        return arrayList;
    }

    private int getArea(Size size) {
        return size.getWidth() * size.getHeight();
    }

    private Size getPreviewSize(WindowManager windowManager) {
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        int i2 = point.x;
        int i3 = point.y;
        Size size = i2 > i3 ? new Size(i2, i3) : new Size(i3, i2);
        return (Size) Collections.min(Arrays.asList(new Size(size.getWidth(), size.getHeight()), MAX_PREVIEW_SIZE), new CompareSizesByArea());
    }

    private Size getRecordSize() {
        return this.mCamcorderProfileHelper.hasProfile(Integer.parseInt(this.mCameraId), 8) ? QUALITY_2160P_SIZE : this.mCamcorderProfileHelper.hasProfile(Integer.parseInt(this.mCameraId), 6) ? QUALITY_1080P_SIZE : this.mCamcorderProfileHelper.hasProfile(Integer.parseInt(this.mCameraId), 5) ? QUALITY_720P_SIZE : this.mCamcorderProfileHelper.hasProfile(Integer.parseInt(this.mCameraId), 4) ? QUALITY_480P_SIZE : QUALITY_480P_SIZE;
    }

    private List<Integer> getUseCasesPriorityOrder(List<UseCase> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<UseCase> it = list.iterator();
        while (it.hasNext()) {
            int surfaceOccupancyPriority = it.next().getUseCaseConfig().getSurfaceOccupancyPriority(0);
            if (!arrayList2.contains(Integer.valueOf(surfaceOccupancyPriority))) {
                arrayList2.add(Integer.valueOf(surfaceOccupancyPriority));
            }
        }
        Collections.sort(arrayList2);
        Collections.reverse(arrayList2);
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            int iIntValue = ((Integer) it2.next()).intValue();
            for (UseCase useCase : list) {
                if (iIntValue == useCase.getUseCaseConfig().getSurfaceOccupancyPriority(0)) {
                    arrayList.add(Integer.valueOf(list.indexOf(useCase)));
                }
            }
        }
        return arrayList;
    }

    static boolean hasMatchingAspectRatio(Size size, Rational rational) {
        if (rational == null) {
            return false;
        }
        if (rational.equals(new Rational(size.getWidth(), size.getHeight()))) {
            return true;
        }
        return isPossibleMod16FromAspectRatio(size, rational);
    }

    private void init(Context context) {
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        try {
            generateSupportedCombinationList(cameraManager);
            generateSurfaceSizeDefinition(windowManager);
            checkCustomization();
        } catch (CameraAccessException e2) {
            throw new IllegalArgumentException("Generate supported combination list and size definition fail - CameraId:" + this.mCameraId, e2);
        }
    }

    private static boolean isPossibleMod16FromAspectRatio(Size size, Rational rational) {
        int width = size.getWidth();
        int height = size.getHeight();
        Rational rational2 = new Rational(rational.getDenominator(), rational.getNumerator());
        int i2 = width % 16;
        if (i2 == 0 && height % 16 == 0) {
            return ratioIntersectsMod16Segment(Math.max(0, height + (-16)), width, rational) || ratioIntersectsMod16Segment(Math.max(0, width + (-16)), height, rational2);
        }
        if (i2 == 0) {
            return ratioIntersectsMod16Segment(height, width, rational);
        }
        if (height % 16 == 0) {
            return ratioIntersectsMod16Segment(width, height, rational2);
        }
        return false;
    }

    private boolean isRotationNeeded(int i2) {
        int sensorRotationDegrees = CameraX.getCameraInfo(this.mCameraId).getSensorRotationDegrees(i2);
        return sensorRotationDegrees == 90 || sensorRotationDegrees == 270;
    }

    private static boolean ratioIntersectsMod16Segment(int i2, int i3, Rational rational) {
        Preconditions.checkArgument(i3 % 16 == 0);
        double numerator = (i2 * rational.getNumerator()) / rational.getDenominator();
        return numerator > ((double) Math.max(0, i3 + (-16))) && numerator < ((double) (i3 + 16));
    }

    private void removeSupportedSizesByTargetSize(List<Size> list, Size size) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = -1;
        for (int i3 = 0; i3 < list.size(); i3++) {
            Size size2 = list.get(i3);
            if (size2.getWidth() < size.getWidth() || size2.getHeight() < size.getHeight()) {
                break;
            }
            if (i2 >= 0) {
                arrayList.add(list.get(i2));
            }
            i2 = i3;
        }
        list.removeAll(arrayList);
    }

    private void removeSupportedSizesByTargetSizeAndAspectRatio(List<Size> list, Size size) {
        if (list == null || list.isEmpty()) {
            return;
        }
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        Rational rational = null;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Size size2 = list.get(i2);
            if (size2.getWidth() >= size.getWidth() && size2.getHeight() >= size.getHeight()) {
                Rational rational2 = new Rational(size2.getWidth(), size2.getHeight());
                if (rational == null || !hasMatchingAspectRatio(size2, rational)) {
                    rational = rational2;
                }
                Size size3 = (Size) map.get(rational);
                if (size3 != null) {
                    arrayList.add(size3);
                }
                map.put(rational, size2);
            }
        }
        list.removeAll(arrayList);
    }

    private Rational rotateAspectRatioByRotation(Rational rational, int i2) {
        return (rational == null || !isRotationNeeded(i2)) ? rational : new Rational(rational.getDenominator(), rational.getNumerator());
    }

    boolean checkSupported(List<SurfaceConfig> list) {
        Iterator<SurfaceCombination> it = this.mSurfaceCombinations.iterator();
        boolean zIsSupported = false;
        while (it.hasNext() && !(zIsSupported = it.next().isSupported(list))) {
        }
        return zIsSupported;
    }

    List<SurfaceCombination> getBurstSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination3);
        return arrayList;
    }

    String getCameraId() {
        return this.mCameraId;
    }

    Rational getCorrectedAspectRatio(int i2) {
        if (this.mHardwareLevel != 2 || Build.VERSION.SDK_INT != 21) {
            return null;
        }
        Size sizeFetchMaxSize = fetchMaxSize(256);
        return rotateAspectRatioByRotation(new Rational(sizeFetchMaxSize.getWidth(), sizeFetchMaxSize.getHeight()), i2);
    }

    List<SurfaceCombination> getFullSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.ANALYSIS));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.ANALYSIS));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination6);
        return arrayList;
    }

    List<SurfaceCombination> getLegacySupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        arrayList.add(surfaceCombination6);
        SurfaceCombination surfaceCombination7 = new SurfaceCombination();
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW));
        arrayList.add(surfaceCombination7);
        SurfaceCombination surfaceCombination8 = new SurfaceCombination();
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination8);
        return arrayList;
    }

    List<SurfaceCombination> getLevel3SupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.ANALYSIS));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.ANALYSIS));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination2);
        return arrayList;
    }

    List<SurfaceCombination> getLimitedSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.RECORD));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.RECORD));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.RECORD));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.RECORD));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.RECORD));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.RECORD));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.RECORD));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination6);
        return arrayList;
    }

    Size getMaxOutputSizeByFormat(int i2) {
        return (Size) Collections.max(Arrays.asList(getAllOutputSizesByFormat(i2)), new CompareSizesByArea());
    }

    List<SurfaceCombination> getRAWSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination6);
        SurfaceCombination surfaceCombination7 = new SurfaceCombination();
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM));
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination7);
        SurfaceCombination surfaceCombination8 = new SurfaceCombination();
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, SurfaceConfig.ConfigSize.MAXIMUM));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.RAW, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(surfaceCombination8);
        return arrayList;
    }

    Map<UseCase, Size> getSuggestedResolutions(List<UseCase> list, List<UseCase> list2) {
        HashMap map = new HashMap();
        List<Integer> useCasesPriorityOrder = getUseCasesPriorityOrder(list2);
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = useCasesPriorityOrder.iterator();
        while (it.hasNext()) {
            arrayList.add(getSupportedOutputSizes(list2.get(it.next().intValue())));
        }
        Iterator<List<Size>> it2 = getAllPossibleSizeArrangements(arrayList).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            List<Size> next = it2.next();
            ArrayList arrayList2 = new ArrayList();
            if (list != null) {
                for (UseCase useCase : list) {
                    arrayList2.add(transformSurfaceConfig(useCase.getImageFormat(), useCase.getAttachedSurfaceResolution(useCase.getBoundCamera().getCameraInfoInternal().getCameraId())));
                }
            }
            for (int i2 = 0; i2 < next.size(); i2++) {
                arrayList2.add(transformSurfaceConfig(list2.get(useCasesPriorityOrder.get(i2).intValue()).getImageFormat(), next.get(i2)));
            }
            if (checkSupported(arrayList2)) {
                for (UseCase useCase2 : list2) {
                    map.put(useCase2, next.get(useCasesPriorityOrder.indexOf(Integer.valueOf(list2.indexOf(useCase2)))));
                }
            }
        }
        return map;
    }

    @VisibleForTesting
    List<Size> getSupportedOutputSizes(UseCase useCase) {
        Rational rational;
        int imageFormat = useCase.getImageFormat();
        Size[] allOutputSizesByFormat = getAllOutputSizesByFormat(imageFormat, useCase);
        ArrayList<Size> arrayList = new ArrayList();
        ImageOutputConfig imageOutputConfig = (ImageOutputConfig) useCase.getUseCaseConfig();
        Size maxResolution = imageOutputConfig.getMaxResolution(getMaxOutputSizeByFormat(imageFormat));
        int targetRotation = imageOutputConfig.getTargetRotation(0);
        Arrays.sort(allOutputSizesByFormat, new CompareSizesByArea(true));
        Size targetResolution = imageOutputConfig.getTargetResolution(ZERO_SIZE);
        if (isRotationNeeded(targetRotation)) {
            targetResolution = new Size(targetResolution.getHeight(), targetResolution.getWidth());
        }
        Size size = DEFAULT_SIZE;
        if (!targetResolution.equals(ZERO_SIZE) && getArea(targetResolution) < getArea(DEFAULT_SIZE)) {
            size = targetResolution;
        }
        for (Size size2 : allOutputSizesByFormat) {
            if (getArea(size2) <= getArea(maxResolution) && getArea(size2) >= getArea(size)) {
                arrayList.add(size2);
            }
        }
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("Can not get supported output size under supported maximum for the format: " + imageFormat);
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Rational rationalRotateAspectRatioByRotation = null;
        if (imageOutputConfig.hasTargetAspectRatio()) {
            boolean zIsRotationNeeded = isRotationNeeded(0);
            int targetAspectRatio = imageOutputConfig.getTargetAspectRatio();
            if (targetAspectRatio == 0) {
                rational = zIsRotationNeeded ? ASPECT_RATIO_4_3 : ASPECT_RATIO_3_4;
            } else if (targetAspectRatio == 1) {
                rational = zIsRotationNeeded ? ASPECT_RATIO_16_9 : ASPECT_RATIO_9_16;
            }
            rationalRotateAspectRatioByRotation = rational;
        } else {
            rationalRotateAspectRatioByRotation = rotateAspectRatioByRotation(imageOutputConfig.getTargetAspectRatioCustom(null), targetRotation);
        }
        for (Size size3 : arrayList) {
            if (rationalRotateAspectRatioByRotation == null || hasMatchingAspectRatio(size3, rationalRotateAspectRatioByRotation)) {
                if (!arrayList2.contains(size3)) {
                    arrayList2.add(size3);
                }
            } else if (!arrayList3.contains(size3)) {
                arrayList3.add(size3);
            }
        }
        if (rationalRotateAspectRatioByRotation != null) {
            Collections.sort(arrayList3, new CompareSizesByDistanceToTargetRatio(Float.valueOf(rationalRotateAspectRatioByRotation.floatValue())));
        }
        if (targetResolution.equals(ZERO_SIZE)) {
            targetResolution = imageOutputConfig.getDefaultResolution(ZERO_SIZE);
        }
        if (!targetResolution.equals(ZERO_SIZE)) {
            removeSupportedSizesByTargetSize(arrayList2, targetResolution);
            removeSupportedSizesByTargetSizeAndAspectRatio(arrayList3, targetResolution);
        }
        ArrayList arrayList4 = new ArrayList();
        arrayList4.addAll(arrayList2);
        arrayList4.addAll(arrayList3);
        return arrayList4;
    }

    SurfaceSizeDefinition getSurfaceSizeDefinition() {
        return this.mSurfaceSizeDefinition;
    }

    boolean isBurstCaptureSupported() {
        return this.mIsBurstCaptureSupported;
    }

    boolean isRawSupported() {
        return this.mIsRawSupported;
    }

    boolean requiresCorrectedAspectRatio() {
        return this.mHardwareLevel == 2 && Build.VERSION.SDK_INT == 21;
    }

    SurfaceConfig transformSurfaceConfig(int i2, Size size) {
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.NOT_SUPPORT;
        if (getAllOutputSizesByFormat(i2) == null) {
            throw new IllegalArgumentException("Can not get supported output size for the format: " + i2);
        }
        SurfaceConfig.ConfigType configType = i2 == 35 ? SurfaceConfig.ConfigType.YUV : i2 == 256 ? SurfaceConfig.ConfigType.JPEG : i2 == 32 ? SurfaceConfig.ConfigType.RAW : SurfaceConfig.ConfigType.PRIV;
        Size sizeFetchMaxSize = fetchMaxSize(i2);
        if (size.getWidth() * size.getHeight() <= this.mSurfaceSizeDefinition.getAnalysisSize().getWidth() * this.mSurfaceSizeDefinition.getAnalysisSize().getHeight()) {
            configSize = SurfaceConfig.ConfigSize.ANALYSIS;
        } else if (size.getWidth() * size.getHeight() <= this.mSurfaceSizeDefinition.getPreviewSize().getWidth() * this.mSurfaceSizeDefinition.getPreviewSize().getHeight()) {
            configSize = SurfaceConfig.ConfigSize.PREVIEW;
        } else if (size.getWidth() * size.getHeight() <= this.mSurfaceSizeDefinition.getRecordSize().getWidth() * this.mSurfaceSizeDefinition.getRecordSize().getHeight()) {
            configSize = SurfaceConfig.ConfigSize.RECORD;
        } else if (size.getWidth() * size.getHeight() <= sizeFetchMaxSize.getWidth() * sizeFetchMaxSize.getHeight()) {
            configSize = SurfaceConfig.ConfigSize.MAXIMUM;
        }
        return SurfaceConfig.create(configType, configSize);
    }

    @Nullable
    private Size[] getAllOutputSizesByFormat(int i2, @Nullable UseCase useCase) {
        Size[] outputSizes = null;
        List<Pair<Integer, Size[]>> supportedResolutions = useCase != null ? ((ImageOutputConfig) useCase.getUseCaseConfig()).getSupportedResolutions(null) : null;
        if (supportedResolutions != null) {
            Iterator<Pair<Integer, Size[]>> it = supportedResolutions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Pair<Integer, Size[]> next = it.next();
                if (((Integer) next.first).intValue() == i2) {
                    outputSizes = (Size[]) next.second;
                    break;
                }
            }
        }
        if (outputSizes == null) {
            CameraCharacteristics cameraCharacteristics = this.mCharacteristics;
            if (cameraCharacteristics == null) {
                throw new IllegalStateException("CameraCharacteristics is null.");
            }
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap == null) {
                throw new IllegalArgumentException("Can not get supported output size for the format: " + i2);
            }
            outputSizes = (Build.VERSION.SDK_INT >= 23 || i2 != 34) ? streamConfigurationMap.getOutputSizes(i2) : streamConfigurationMap.getOutputSizes(SurfaceTexture.class);
        }
        if (outputSizes != null) {
            Arrays.sort(outputSizes, new CompareSizesByArea(true));
            return outputSizes;
        }
        throw new IllegalArgumentException("Can not get supported output size for the format: " + i2);
    }

    private SupportedSurfaceCombination() {
    }
}
