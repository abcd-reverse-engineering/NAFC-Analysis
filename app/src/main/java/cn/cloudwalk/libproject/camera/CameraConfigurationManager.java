package cn.cloudwalk.libproject.camera;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.media.ToneGenerator;
import android.view.Display;
import android.view.WindowManager;
import cn.cloudwalk.FaceInterface;
import cn.cloudwalk.libproject.callback.OnCaptureCallback;
import cn.cloudwalk.util.LogUtils;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
final class CameraConfigurationManager {
    private static final Pattern COMMA_PATTERN = Pattern.compile(Constants.ACCEPT_TIME_SEPARATOR_SP);
    private static final String TAG = "CameraConfigurationManager";
    private static final int TEN_DESIRED_ZOOM = 27;
    private Point cameraResolution;
    private final Context mContext;
    private Point mScreenResolution;
    private ToneGenerator tone;

    class PreviewComparator implements Comparator<Camera.Size> {

        /* renamed from: h, reason: collision with root package name */
        int f3184h;
        int w;

        public PreviewComparator(int i2, int i3) {
            this.w = i2;
            this.f3184h = i3;
        }

        @Override // java.util.Comparator
        public int compare(Camera.Size size, Camera.Size size2) {
            return Math.abs((size.width * size.height) - (this.w * this.f3184h)) - Math.abs((size2.width * size2.height) - (this.w * this.f3184h));
        }
    }

    public CameraConfigurationManager(Context context) {
        this.mContext = context;
    }

    private void doSetTorch(Camera camera, boolean z) {
        Camera.Parameters parameters = camera.getParameters();
        String strFindSettableValue = z ? findSettableValue(parameters.getSupportedFlashModes(), "torch", "on") : findSettableValue(parameters.getSupportedFlashModes(), "off");
        if (strFindSettableValue != null) {
            parameters.setFlashMode(strFindSettableValue);
        }
        camera.setParameters(parameters);
    }

    private static int findBestMotZoomValue(CharSequence charSequence, int i2) throws NumberFormatException {
        int i3 = 0;
        for (String str : COMMA_PATTERN.split(charSequence)) {
            try {
                double d2 = Double.parseDouble(str.trim());
                int i4 = (int) (10.0d * d2);
                if (Math.abs(i2 - d2) < Math.abs(i2 - i3)) {
                    i3 = i4;
                }
            } catch (NumberFormatException unused) {
                return i2;
            }
        }
        return i3;
    }

    private static Point findBestPreviewSizeValue(CharSequence charSequence, Point point) throws NumberFormatException {
        String[] strArrSplit = COMMA_PATTERN.split(charSequence);
        int length = strArrSplit.length;
        int i2 = 0;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            String strTrim = strArrSplit[i2].trim();
            int iIndexOf = strTrim.indexOf(120);
            if (iIndexOf >= 0) {
                try {
                    int i6 = Integer.parseInt(strTrim.substring(0, iIndexOf));
                    int i7 = Integer.parseInt(strTrim.substring(iIndexOf + 1));
                    int iAbs = Math.abs(i6 - point.x) + Math.abs(i7 - point.y);
                    if (iAbs == 0) {
                        i4 = i7;
                        i5 = i6;
                        break;
                    }
                    if (iAbs < i3) {
                        i4 = i7;
                        i3 = iAbs;
                        i5 = i6;
                    }
                } catch (NumberFormatException unused) {
                    continue;
                }
            }
            i2++;
        }
        if (i5 <= 0 || i4 <= 0) {
            return null;
        }
        return new Point(i5, i4);
    }

    private static String findSettableValue(Collection<String> collection, String... strArr) {
        if (collection != null) {
            for (String str : strArr) {
                if (collection.contains(str)) {
                    return str;
                }
            }
        }
        return null;
    }

    private static Point getCameraResolution(Camera.Parameters parameters, Point point) {
        String str = parameters.get("preview-size-values");
        if (str == null) {
            str = parameters.get("preview-size-value");
        }
        Point pointFindBestPreviewSizeValue = str != null ? findBestPreviewSizeValue(str, point) : null;
        return pointFindBestPreviewSizeValue == null ? new Point((point.x >> 3) << 3, (point.y >> 3) << 3) : pointFindBestPreviewSizeValue;
    }

    private Camera.Size getOptimalPreviewSize(List<Camera.Size> list, int i2, int i3) {
        try {
            ArrayList arrayList = new ArrayList();
            for (Camera.Size size : list) {
                if (size.width > size.height) {
                    arrayList.add(size);
                }
            }
            Collections.sort(arrayList, new PreviewComparator(i2, i3));
            return (Camera.Size) arrayList.get(0);
        } catch (Exception e2) {
            LogUtils.LOGE(LogUtils.LOG_EXCEPTION, e2.getMessage());
            return null;
        }
    }

    private ArrayList<Camera.Size> getOptimalSpecialPreviewSize(List<Camera.Size> list, int i2, int i3) {
        ArrayList<Camera.Size> arrayList = new ArrayList<>();
        try {
            for (Camera.Size size : list) {
                if (size.width > size.height && (size.width != i2 || size.height != i3)) {
                    if (size.width <= 800 && size.height <= 600 && size.width >= 480 && size.height >= 320) {
                        arrayList.add(size);
                    }
                }
            }
            Collections.sort(arrayList, new PreviewComparator(i2, i3));
        } catch (Exception unused) {
        }
        return arrayList;
    }

    private boolean isLocalSizeContains(List<Camera.Size> list, int i2, int i3) {
        if (list == null) {
            return false;
        }
        for (Camera.Size size : list) {
            if (size.width == i2 && size.height == i3) {
                return true;
            }
        }
        return false;
    }

    private void setZoom(Camera.Parameters parameters) throws NumberFormatException {
        String str = parameters.get("zoom-supported");
        if (str == null || Boolean.parseBoolean(str)) {
            int iFindBestMotZoomValue = 27;
            String str2 = parameters.get("max-zoom");
            if (str2 != null) {
                try {
                    int i2 = (int) (Double.parseDouble(str2) * 10.0d);
                    if (27 > i2) {
                        iFindBestMotZoomValue = i2;
                    }
                } catch (NumberFormatException e2) {
                    LogUtils.LOGE(LogUtils.LOG_EXCEPTION, e2.getMessage());
                }
            }
            String str3 = parameters.get("taking-picture-zoom-max");
            if (str3 != null) {
                try {
                    int i3 = Integer.parseInt(str3);
                    if (iFindBestMotZoomValue > i3) {
                        iFindBestMotZoomValue = i3;
                    }
                } catch (NumberFormatException e3) {
                    LogUtils.LOGE(LogUtils.LOG_EXCEPTION, e3.getMessage());
                }
            }
            String str4 = parameters.get("mot-zoom-values");
            if (str4 != null) {
                iFindBestMotZoomValue = findBestMotZoomValue(str4, iFindBestMotZoomValue);
            }
            String str5 = parameters.get("mot-zoom-step");
            if (str5 != null) {
                try {
                    int i4 = (int) (Double.parseDouble(str5.trim()) * 10.0d);
                    if (i4 > 1) {
                        iFindBestMotZoomValue -= iFindBestMotZoomValue % i4;
                    }
                } catch (NumberFormatException unused) {
                }
            }
            if (str2 != null || str4 != null) {
                parameters.set("zoom", String.valueOf(iFindBestMotZoomValue / 10.0d));
            }
            if (str3 != null) {
                parameters.set("taking-picture-zoom", iFindBestMotZoomValue);
            }
        }
    }

    private ArrayList<Camera.Size> sortPicSize(List<Camera.Size> list, int i2, int i3) {
        ArrayList<Camera.Size> arrayList = new ArrayList<>();
        try {
            Iterator<Camera.Size> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            Collections.sort(arrayList, new PreviewComparator(i2, i3));
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public void closeFlashlight(Camera camera) {
        doSetTorch(camera, false);
    }

    public int getDisplayOrientation(int i2) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i2, cameraInfo);
        int rotation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        int i3 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i3 = 90;
            } else if (rotation == 2) {
                i3 = 180;
            } else if (rotation == 3) {
                i3 = SubsamplingScaleImageView.ORIENTATION_270;
            }
        }
        return cameraInfo.facing == 1 ? (360 - ((cameraInfo.orientation + i3) % 360)) % 360 : ((cameraInfo.orientation - i3) + 360) % 360;
    }

    public void initFromCameraParameters(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        Display defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
        this.mScreenResolution = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        Point point = new Point();
        Point point2 = this.mScreenResolution;
        point.x = point2.x;
        point.y = point2.y;
        int i2 = point2.x;
        int i3 = point2.y;
        if (i2 < i3) {
            point.x = i3;
            point.y = point2.x;
        }
        this.cameraResolution = getCameraResolution(parameters, point);
    }

    public void openFlashlight(Camera camera) {
        doSetTorch(camera, true);
    }

    public int setCameraParametersForPreviewCallBack(Camera camera, int i2, int i3, int i4) throws NumberFormatException {
        Camera.Parameters parameters = camera.getParameters();
        if (parameters.getSupportedFocusModes().contains("continuous-video")) {
            parameters.setFocusMode("continuous-picture");
        }
        Camera.Size optimalPreviewSize = getOptimalPreviewSize(parameters.getSupportedPreviewSizes(), i3, i4);
        if (optimalPreviewSize != null) {
            parameters.setPreviewSize(optimalPreviewSize.width, optimalPreviewSize.height);
        } else {
            LogUtils.LOGE(TAG, "设置预览失败");
        }
        parameters.setPreviewFormat(17);
        setZoom(parameters);
        int displayOrientation = getDisplayOrientation(i2);
        camera.setDisplayOrientation(displayOrientation);
        try {
            camera.setParameters(parameters);
        } catch (Exception e2) {
            e2.printStackTrace();
            ArrayList<Camera.Size> optimalSpecialPreviewSize = getOptimalSpecialPreviewSize(parameters.getSupportedPreviewSizes(), i3, i4);
            if (optimalSpecialPreviewSize.size() != 0) {
                for (int i5 = 0; i5 < optimalSpecialPreviewSize.size(); i5++) {
                    parameters.setPreviewSize(optimalSpecialPreviewSize.get(i5).width, optimalSpecialPreviewSize.get(i5).height);
                    try {
                        camera.setParameters(parameters);
                        break;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            } else if (isLocalSizeContains(parameters.getSupportedPreviewSizes(), 864, 480)) {
                parameters.setPreviewSize(864, 480);
                try {
                    camera.setParameters(parameters);
                } catch (Exception unused) {
                    if (isLocalSizeContains(parameters.getSupportedPreviewSizes(), 960, 480)) {
                        parameters.setPreviewSize(960, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_AUTH_ERROR);
                        camera.setParameters(parameters);
                    }
                }
            }
        }
        return displayOrientation;
    }

    public void setDesiredCameraParameters(Camera camera, int i2) throws NumberFormatException {
        Camera.Parameters parameters = camera.getParameters();
        parameters.setPreviewFormat(17);
        Point point = this.cameraResolution;
        parameters.setPreviewSize(point.x, point.y);
        setZoom(parameters);
        camera.setDisplayOrientation(getDisplayOrientation(i2));
        Display defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        ArrayList<Camera.Size> arrayListSortPicSize = (supportedPictureSizes == null || supportedPictureSizes.size() <= 0) ? null : sortPicSize(supportedPictureSizes, defaultDisplay.getWidth(), defaultDisplay.getHeight());
        if (arrayListSortPicSize == null) {
            camera.setParameters(parameters);
            return;
        }
        for (int i3 = 0; i3 < arrayListSortPicSize.size(); i3++) {
            try {
                parameters.setPictureSize(arrayListSortPicSize.get(i3).width, arrayListSortPicSize.get(i3).height);
                camera.setParameters(parameters);
                return;
            } catch (Exception unused) {
            }
        }
    }

    public void tackPicture(Camera camera, final OnCaptureCallback onCaptureCallback) throws Exception {
        camera.cancelAutoFocus();
        camera.autoFocus(new Camera.AutoFocusCallback() { // from class: cn.cloudwalk.libproject.camera.CameraConfigurationManager.1
            @Override // android.hardware.Camera.AutoFocusCallback
            public void onAutoFocus(boolean z, Camera camera2) {
                camera2.takePicture(new Camera.ShutterCallback() { // from class: cn.cloudwalk.libproject.camera.CameraConfigurationManager.1.1
                    @Override // android.hardware.Camera.ShutterCallback
                    public void onShutter() {
                        if (CameraConfigurationManager.this.tone == null) {
                            CameraConfigurationManager.this.tone = new ToneGenerator(3, 100);
                        }
                        CameraConfigurationManager.this.tone.startTone(24);
                    }
                }, null, new Camera.PictureCallback() { // from class: cn.cloudwalk.libproject.camera.CameraConfigurationManager.1.2
                    @Override // android.hardware.Camera.PictureCallback
                    public void onPictureTaken(byte[] bArr, Camera camera3) {
                        Camera.Size previewSize = camera3.getParameters().getPreviewSize();
                        onCaptureCallback.onCapture(bArr, previewSize.width, previewSize.height);
                    }
                });
            }
        });
    }

    public Point getCameraResolution() {
        return this.cameraResolution;
    }
}
