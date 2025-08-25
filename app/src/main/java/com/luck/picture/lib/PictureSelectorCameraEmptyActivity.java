package com.luck.picture.lib;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.immersive.ImmersiveManage;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.tools.BitmapUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.ToastUtils;
import com.luck.picture.lib.tools.ValueOf;
import com.yalantis.ucrop.UCrop;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PictureSelectorCameraEmptyActivity extends PictureBaseActivity {
    private void cameraHandleResult(LocalMedia localMedia, String str) {
        boolean zEqImage = PictureMimeType.eqImage(str);
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.enableCrop && zEqImage) {
            String str2 = pictureSelectionConfig.cameraPath;
            pictureSelectionConfig.originalPath = str2;
            startCrop(str2, str);
            return;
        }
        PictureSelectionConfig pictureSelectionConfig2 = this.config;
        if (pictureSelectionConfig2.isCompress && zEqImage && !pictureSelectionConfig2.isCheckOriginalImage) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(localMedia);
            compressImage(arrayList);
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(localMedia);
            onResult(arrayList2);
        }
    }

    private void onTakePhoto() {
        if (!PermissionChecker.checkSelfPermission(this, util.permissionutil.a.f20909c)) {
            PermissionChecker.requestPermissions(this, new String[]{util.permissionutil.a.f20909c}, 2);
            return;
        }
        if (this.config.isUseCustomCamera ? PermissionChecker.checkSelfPermission(this, util.permissionutil.a.f20915i) : true) {
            startCamera();
        } else {
            PermissionChecker.requestPermissions(this, new String[]{util.permissionutil.a.f20915i}, 4);
        }
    }

    private void startCamera() {
        int i2 = this.config.chooseMode;
        if (i2 == 0 || i2 == 1) {
            startOpenCamera();
        } else if (i2 == 2) {
            startOpenCameraVideo();
        } else {
            if (i2 != 3) {
                return;
            }
            startOpenCameraAudio();
        }
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    public int getResourceId() {
        return R.layout.picture_empty;
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    public void immersive() {
        ImmersiveManage.immersiveAboveAPI23(this, ContextCompat.getColor(this, R.color.picture_color_transparent), ContextCompat.getColor(this, R.color.picture_color_transparent), this.openWhiteStatusBar);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, @Nullable Intent intent) throws Throwable {
        OnResultCallbackListener onResultCallbackListener;
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            if (i2 == 69) {
                singleCropHandleResult(intent);
                return;
            } else {
                if (i2 != 909) {
                    return;
                }
                requestCamera(intent);
                return;
            }
        }
        if (i3 == 0) {
            if (this.config != null && (onResultCallbackListener = PictureSelectionConfig.listener) != null) {
                onResultCallbackListener.onCancel();
            }
            closeActivity();
            return;
        }
        if (i3 != 96 || intent == null) {
            return;
        }
        ToastUtils.s(getContext(), ((Throwable) intent.getSerializableExtra(UCrop.EXTRA_ERROR)).getMessage());
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void a() {
        super.a();
        closeActivity();
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (!this.config.isUseCustomCamera && PictureSelectionConfig.onPictureSelectorInterfaceListener == null) {
            if (bundle == null) {
                if (PermissionChecker.checkSelfPermission(this, util.permissionutil.a.z) && PermissionChecker.checkSelfPermission(this, util.permissionutil.a.A)) {
                    onTakePhoto();
                } else {
                    PermissionChecker.requestPermissions(this, new String[]{util.permissionutil.a.z, util.permissionutil.a.A}, 1);
                }
            }
            setTheme(R.style.Picture_Theme_Translucent);
        }
        super.onCreate(bundle);
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 1) {
            if (iArr.length > 0 && iArr[0] == 0) {
                PermissionChecker.requestPermissions(this, new String[]{util.permissionutil.a.f20909c}, 2);
                return;
            } else {
                ToastUtils.s(getContext(), getString(R.string.picture_jurisdiction));
                closeActivity();
                return;
            }
        }
        if (i2 == 2) {
            if (iArr.length > 0 && iArr[0] == 0) {
                onTakePhoto();
                return;
            } else {
                closeActivity();
                ToastUtils.s(getContext(), getString(R.string.picture_camera));
                return;
            }
        }
        if (i2 != 4) {
            return;
        }
        if (iArr.length > 0 && iArr[0] == 0) {
            onTakePhoto();
        } else {
            closeActivity();
            ToastUtils.s(getContext(), getString(R.string.picture_audio));
        }
    }

    protected void requestCamera(Intent intent) {
        String mimeType;
        long jExtractDuration;
        int lastImageId;
        int[] videoSizeForUrl;
        int[] videoSizeForUri;
        long jExtractDuration2;
        boolean zCheckedAndroid_Q = SdkVersionUtils.checkedAndroid_Q();
        long length = 0;
        if (this.config.chooseMode == PictureMimeType.ofAudio()) {
            this.config.cameraPath = getAudioPath(intent);
            if (TextUtils.isEmpty(this.config.cameraPath)) {
                return;
            }
            jExtractDuration = MediaUtils.extractDuration(getContext(), zCheckedAndroid_Q, this.config.cameraPath);
            mimeType = PictureMimeType.MIME_TYPE_AUDIO;
        } else {
            mimeType = null;
            jExtractDuration = 0;
        }
        if (TextUtils.isEmpty(this.config.cameraPath)) {
            return;
        }
        new File(this.config.cameraPath);
        int[] iArr = new int[2];
        if (!zCheckedAndroid_Q) {
            PictureSelectionConfig pictureSelectionConfig = this.config;
            if (pictureSelectionConfig.isFallbackVersion3) {
                new PictureMediaScannerConnection(getContext(), this.config.cameraPath);
            } else {
                sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(pictureSelectionConfig.cameraPath))));
            }
        }
        LocalMedia localMedia = new LocalMedia();
        if (this.config.chooseMode != PictureMimeType.ofAudio()) {
            if (PictureMimeType.isContent(this.config.cameraPath)) {
                String path = PictureFileUtils.getPath(getApplicationContext(), Uri.parse(this.config.cameraPath));
                long length2 = new File(path).length();
                String mimeType2 = PictureMimeType.getMimeType(this.config.cameraMimeType);
                if (PictureMimeType.eqImage(mimeType2)) {
                    long j2 = jExtractDuration;
                    videoSizeForUri = MediaUtils.getImageSizeForUrlToAndroidQ(this, this.config.cameraPath);
                    jExtractDuration2 = j2;
                } else {
                    videoSizeForUri = MediaUtils.getVideoSizeForUri(this, Uri.parse(this.config.cameraPath));
                    jExtractDuration2 = MediaUtils.extractDuration(getContext(), true, this.config.cameraPath);
                }
                int iLastIndexOf = this.config.cameraPath.lastIndexOf("/") + 1;
                localMedia.setId(iLastIndexOf > 0 ? ValueOf.toLong(this.config.cameraPath.substring(iLastIndexOf)) : -1L);
                localMedia.setRealPath(path);
                if (this.config.isUseCustomCamera && intent != null) {
                    localMedia.setAndroidQToPath(intent.getStringExtra(PictureConfig.EXTRA_MEDIA_PATH));
                }
                length = length2;
                mimeType = mimeType2;
                iArr = videoSizeForUri;
                jExtractDuration = jExtractDuration2;
            } else {
                File file = new File(this.config.cameraPath);
                mimeType = PictureMimeType.getMimeType(this.config.cameraMimeType);
                length = file.length();
                if (PictureMimeType.eqImage(mimeType)) {
                    BitmapUtils.rotateImage(PictureFileUtils.readPictureDegree(this, this.config.cameraPath), this.config.cameraPath);
                    videoSizeForUrl = MediaUtils.getImageSizeForUrl(this.config.cameraPath);
                } else {
                    videoSizeForUrl = MediaUtils.getVideoSizeForUrl(this.config.cameraPath);
                    jExtractDuration = MediaUtils.extractDuration(getContext(), false, this.config.cameraPath);
                }
                iArr = videoSizeForUrl;
                localMedia.setId(System.currentTimeMillis());
            }
        }
        localMedia.setDuration(jExtractDuration);
        localMedia.setWidth(iArr[0]);
        localMedia.setHeight(iArr[1]);
        localMedia.setPath(this.config.cameraPath);
        localMedia.setMimeType(mimeType);
        localMedia.setSize(length);
        localMedia.setChooseModel(this.config.chooseMode);
        MediaUtils.setOrientation(getContext(), localMedia);
        cameraHandleResult(localMedia, mimeType);
        if (zCheckedAndroid_Q || !PictureMimeType.eqImage(localMedia.getMimeType()) || (lastImageId = MediaUtils.getLastImageId(getContext(), localMedia.getMimeType())) == -1) {
            return;
        }
        MediaUtils.removeMedia(getContext(), lastImageId);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0142  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void singleCropHandleResult(android.content.Intent r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.PictureSelectorCameraEmptyActivity.singleCropHandleResult(android.content.Intent):void");
    }
}
