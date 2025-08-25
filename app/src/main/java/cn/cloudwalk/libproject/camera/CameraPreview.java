package cn.cloudwalk.libproject.camera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import cn.cloudwalk.libproject.Contants;
import cn.cloudwalk.libproject.util.SystemUtil;
import cn.cloudwalk.util.LogUtils;
import java.io.IOException;

/* loaded from: classes.dex */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback, Camera.PreviewCallback {
    private static final int DEFAULT_EXPOSURE = 0;
    private static final int DEFAULT_EXPOSURE_STEP = 1;
    private static final String TAG = LogUtils.makeLogTag("CameraPreview");
    int caremaId;
    Context context;
    int imageAngle;
    private CWPreviewCallback mCWPreviewCallback;
    private Camera mCamera;
    private CameraConfigurationManager mCameraConfigurationManager;
    Delegate mDelegate;
    private int mFrameCount;
    private boolean mPreviewing;
    private boolean mPushFrame;
    private boolean mSurfaceCreated;
    private int orientation;
    int reqPrevH;
    int reqPrevW;
    private TextureView.SurfaceTextureListener textureListener;
    private TextureView textureView;

    public interface CWPreviewCallback {
        void onCWPreviewFrame(byte[] bArr, int i2, int i3, int i4, int i5, int i6);
    }

    public CameraPreview(Context context) {
        super(context);
        this.mFrameCount = 0;
        this.imageAngle = 0;
        this.mPushFrame = true;
        this.caremaId = 1;
        this.mPreviewing = true;
        this.mSurfaceCreated = false;
        this.reqPrevW = Contants.PREVIEW_W;
        this.reqPrevH = 480;
        this.textureListener = new TextureView.SurfaceTextureListener() { // from class: cn.cloudwalk.libproject.camera.CameraPreview.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) throws IOException {
                if (CameraPreview.this.mCamera != null) {
                    try {
                        CameraPreview.this.mCamera.setPreviewTexture(surfaceTexture);
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
                String unused = CameraPreview.TAG;
                String str = "onSurfaceTextureSizeChanged: " + i2 + "  " + i3;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.context = context;
        this.mFrameCount = 0;
    }

    private boolean flashLightAvaliable() {
        return this.mCamera != null && this.mPreviewing && this.mSurfaceCreated && getContext().getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    }

    private int getImageAngle(int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (i2 == 90) {
            return 3;
        }
        if (i2 != 180) {
            return i2 != 270 ? 0 : 1;
        }
        return 2;
    }

    public void closeFlashlight() {
        if (flashLightAvaliable()) {
            this.mCameraConfigurationManager.closeFlashlight(this.mCamera);
        }
    }

    public void cwStartCamera() throws IOException {
        if (this.mCamera != null) {
            return;
        }
        try {
            this.mCamera = Camera.open(this.caremaId);
        } catch (Exception unused) {
            Delegate delegate = this.mDelegate;
            if (delegate != null) {
                delegate.onOpenCameraError();
            }
        }
        setCamera(this.mCamera);
    }

    public void cwStopCamera() {
        if (this.mCamera != null) {
            stopCameraPreview();
            this.mCamera.release();
            this.mCamera = null;
        }
    }

    public void decreaseExposure() {
        int exposureCompensation;
        Camera camera = this.mCamera;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            if (!(parameters.getMaxExposureCompensation() == 0 && parameters.getMinExposureCompensation() == 0) && parameters.getExposureCompensation() - 1 >= parameters.getMinExposureCompensation()) {
                parameters.setExposureCompensation(exposureCompensation);
                this.mCamera.setParameters(parameters);
            }
        }
    }

    public int getCaremaId() {
        return this.caremaId;
    }

    public Camera.Size getPreviewSize() {
        return this.mCamera.getParameters().getPreviewSize();
    }

    public void increaseExposure() {
        int exposureCompensation;
        try {
            if (this.mCamera != null) {
                Camera.Parameters parameters = this.mCamera.getParameters();
                if (!(parameters.getMaxExposureCompensation() == 0 && parameters.getMinExposureCompensation() == 0) && (exposureCompensation = parameters.getExposureCompensation() + 1) <= parameters.getMaxExposureCompensation()) {
                    parameters.setExposureCompensation(exposureCompensation);
                    this.mCamera.setParameters(parameters);
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        CWPreviewCallback cWPreviewCallback;
        this.mFrameCount++;
        if (this.mFrameCount >= 10 && (cWPreviewCallback = this.mCWPreviewCallback) != null) {
            if (this.caremaId == 1) {
                if (1 == this.orientation) {
                    cWPreviewCallback.onCWPreviewFrame(bArr, this.reqPrevW, this.reqPrevH, 5, this.imageAngle, 1);
                    return;
                } else {
                    cWPreviewCallback.onCWPreviewFrame(bArr, this.reqPrevW, this.reqPrevH, 5, this.imageAngle, 1);
                    return;
                }
            }
            if (1 == this.orientation) {
                if (Camera.getNumberOfCameras() != 1) {
                    this.mCWPreviewCallback.onCWPreviewFrame(bArr, this.reqPrevW, this.reqPrevH, 5, this.imageAngle, 2);
                    return;
                }
                String systemModel = SystemUtil.getSystemModel();
                LogUtils.LOGE(TAG, "phone = " + systemModel);
                if ("ATH-AL00".equals(systemModel) || "ATH-TL00H".equals(systemModel)) {
                    this.mCWPreviewCallback.onCWPreviewFrame(bArr, this.reqPrevW, this.reqPrevH, 5, this.imageAngle, 0);
                    return;
                } else {
                    this.mCWPreviewCallback.onCWPreviewFrame(bArr, this.reqPrevW, this.reqPrevH, 5, this.imageAngle, 2);
                    return;
                }
            }
            if (Camera.getNumberOfCameras() != 1) {
                this.mCWPreviewCallback.onCWPreviewFrame(bArr, this.reqPrevW, this.reqPrevH, 5, this.imageAngle, 1);
                return;
            }
            String systemModel2 = SystemUtil.getSystemModel();
            LogUtils.LOGE(TAG, "phone = " + systemModel2);
            if ("ATH-AL00".equals(systemModel2) || "ATH-TL00H".equals(systemModel2)) {
                this.mCWPreviewCallback.onCWPreviewFrame(bArr, this.reqPrevW, this.reqPrevH, 5, this.imageAngle, 0);
            } else {
                this.mCWPreviewCallback.onCWPreviewFrame(bArr, this.reqPrevW, this.reqPrevH, 5, this.imageAngle, 1);
            }
        }
    }

    public void openFlashlight() {
        if (flashLightAvaliable()) {
            this.mCameraConfigurationManager.openFlashlight(this.mCamera);
        }
    }

    public void setCWPreviewCallback(CWPreviewCallback cWPreviewCallback) {
        this.mCWPreviewCallback = cWPreviewCallback;
    }

    public void setCamera(Camera camera) throws IOException {
        this.mCamera = camera;
        if (this.mCamera != null) {
            this.mCameraConfigurationManager = new CameraConfigurationManager(getContext());
            getHolder().addCallback(this);
            if (this.mPreviewing) {
                requestLayout();
            } else {
                showCameraPreview();
            }
        }
    }

    public void setCaremaId(int i2) {
        this.caremaId = i2;
    }

    public void setDelegate(Delegate delegate) {
        this.mDelegate = delegate;
    }

    public void setPreviewTexture(TextureView textureView) {
        this.textureView = textureView;
        try {
            this.textureView.setSurfaceTextureListener(this.textureListener);
        } catch (Exception unused) {
        }
    }

    public void setPushFrame(boolean z) {
        this.mPushFrame = z;
    }

    public void setReqPrevWH(int i2, int i3) {
        this.reqPrevW = i2;
        this.reqPrevH = i3;
    }

    public void setScreenOrientation(int i2) {
        this.orientation = i2;
    }

    public void showCameraPreview() throws IOException {
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                this.mPreviewing = true;
                camera.setPreviewDisplay(getHolder());
                this.imageAngle = getImageAngle(this.mCameraConfigurationManager.setCameraParametersForPreviewCallBack(this.mCamera, this.caremaId, this.reqPrevW, this.reqPrevH));
                if (this.textureView == null) {
                    this.mCamera.setPreviewDisplay(getHolder());
                } else {
                    this.mCamera.setPreviewTexture(this.textureView.getSurfaceTexture());
                }
                this.mCamera.setPreviewCallback(this);
                this.mCamera.startPreview();
                if (this.mDelegate != null) {
                    this.mDelegate.startPreview();
                }
            } catch (IOException e2) {
                LogUtils.LOGE(LogUtils.LOG_EXCEPTION, e2.getMessage());
            }
        }
    }

    public void stopCameraPreview() {
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                this.mPreviewing = false;
                camera.cancelAutoFocus();
                this.mCamera.setPreviewCallback(null);
                this.mCamera.stopPreview();
            } catch (Exception e2) {
                LogUtils.LOGE(TAG, e2.toString());
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) throws IOException {
        if (surfaceHolder.getSurface() == null) {
            return;
        }
        stopCameraPreview();
        showCameraPreview();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceCreated = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.mSurfaceCreated = false;
        stopCameraPreview();
    }

    public int switchCarema() throws IOException {
        cwStopCamera();
        if (this.caremaId == 1) {
            this.caremaId = 0;
        } else {
            this.caremaId = 1;
        }
        cwStartCamera();
        return this.caremaId;
    }

    public CameraPreview(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mFrameCount = 0;
        this.imageAngle = 0;
        this.mPushFrame = true;
        this.caremaId = 1;
        this.mPreviewing = true;
        this.mSurfaceCreated = false;
        this.reqPrevW = Contants.PREVIEW_W;
        this.reqPrevH = 480;
        this.textureListener = new TextureView.SurfaceTextureListener() { // from class: cn.cloudwalk.libproject.camera.CameraPreview.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i22, int i3) throws IOException {
                if (CameraPreview.this.mCamera != null) {
                    try {
                        CameraPreview.this.mCamera.setPreviewTexture(surfaceTexture);
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i22, int i3) {
                String unused = CameraPreview.TAG;
                String str = "onSurfaceTextureSizeChanged: " + i22 + "  " + i3;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.context = context;
        this.mFrameCount = 0;
    }

    public CameraPreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFrameCount = 0;
        this.imageAngle = 0;
        this.mPushFrame = true;
        this.caremaId = 1;
        this.mPreviewing = true;
        this.mSurfaceCreated = false;
        this.reqPrevW = Contants.PREVIEW_W;
        this.reqPrevH = 480;
        this.textureListener = new TextureView.SurfaceTextureListener() { // from class: cn.cloudwalk.libproject.camera.CameraPreview.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i22, int i3) throws IOException {
                if (CameraPreview.this.mCamera != null) {
                    try {
                        CameraPreview.this.mCamera.setPreviewTexture(surfaceTexture);
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i22, int i3) {
                String unused = CameraPreview.TAG;
                String str = "onSurfaceTextureSizeChanged: " + i22 + "  " + i3;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        };
        this.context = context;
        this.mFrameCount = 0;
    }
}
