package com.luck.picture.lib;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.luck.picture.lib.compress.Luban;
import com.luck.picture.lib.compress.OnCompressListener;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.dialog.PictureLoadingDialog;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.immersive.ImmersiveManage;
import com.luck.picture.lib.immersive.NavBarUtils;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.style.PictureCropParameterStyle;
import com.luck.picture.lib.style.PictureParameterStyle;
import com.luck.picture.lib.style.PictureWindowAnimationStyle;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.tools.AndroidQTransformUtils;
import com.luck.picture.lib.tools.AttrsUtils;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.StringUtils;
import com.luck.picture.lib.tools.ToastUtils;
import com.luck.picture.lib.tools.VoiceUtils;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.model.CutInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class PictureBaseActivity extends AppCompatActivity {
    protected int colorPrimary;
    protected int colorPrimaryDark;
    protected PictureSelectionConfig config;
    protected View container;
    private int index = 0;
    protected boolean isOnSaveInstanceState;
    protected Handler mHandler;
    protected PictureLoadingDialog mLoadingDialog;
    protected boolean numComplete;
    protected boolean openWhiteStatusBar;
    protected List<LocalMedia> selectionMedias;

    private UCrop.Options basicOptions() {
        return basicOptions(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void compressToLuban(final List<LocalMedia> list) {
        if (this.config.synOrAsy) {
            PictureThreadUtils.executeByCached(new PictureThreadUtils.SimpleTask<List<File>>() { // from class: com.luck.picture.lib.PictureBaseActivity.2
                @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
                public List<File> doInBackground() throws Exception {
                    return Luban.with(PictureBaseActivity.this.getContext()).loadMediaData(list).isCamera(PictureBaseActivity.this.config.camera).setTargetDir(PictureBaseActivity.this.config.compressSavePath).setCompressQuality(PictureBaseActivity.this.config.compressQuality).setFocusAlpha(PictureBaseActivity.this.config.focusAlpha).setNewCompressFileName(PictureBaseActivity.this.config.renameCompressFileName).ignoreBy(PictureBaseActivity.this.config.minimumCompressSize).get();
                }

                @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
                public void onSuccess(List<File> list2) {
                    PictureThreadUtils.cancel(PictureThreadUtils.getCachedPool());
                    if (list2 == null || list2.size() <= 0 || list2.size() != list.size()) {
                        PictureBaseActivity.this.onResult(list);
                    } else {
                        PictureBaseActivity.this.handleCompressCallBack(list, list2);
                    }
                }
            });
        } else {
            Luban.with(this).loadMediaData(list).ignoreBy(this.config.minimumCompressSize).isCamera(this.config.camera).setCompressQuality(this.config.compressQuality).setTargetDir(this.config.compressSavePath).setFocusAlpha(this.config.focusAlpha).setNewCompressFileName(this.config.renameCompressFileName).setCompressListener(new OnCompressListener() { // from class: com.luck.picture.lib.PictureBaseActivity.3
                @Override // com.luck.picture.lib.compress.OnCompressListener
                public void onError(Throwable th) {
                    PictureBaseActivity.this.onResult(list);
                }

                @Override // com.luck.picture.lib.compress.OnCompressListener
                public void onStart() {
                }

                @Override // com.luck.picture.lib.compress.OnCompressListener
                public void onSuccess(List<LocalMedia> list2) {
                    PictureBaseActivity.this.onResult(list2);
                }
            }).launch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCompressCallBack(List<LocalMedia> list, List<File> list2) {
        if (list == null || list2 == null) {
            closeActivity();
            return;
        }
        boolean zCheckedAndroid_Q = SdkVersionUtils.checkedAndroid_Q();
        int size = list.size();
        if (list2.size() == size) {
            for (int i2 = 0; i2 < size; i2++) {
                String absolutePath = list2.get(i2).getAbsolutePath();
                LocalMedia localMedia = list.get(i2);
                boolean z = !TextUtils.isEmpty(absolutePath) && PictureMimeType.isHttp(absolutePath);
                boolean zEqVideo = PictureMimeType.eqVideo(localMedia.getMimeType());
                localMedia.setCompressed((zEqVideo || z) ? false : true);
                localMedia.setCompressPath((zEqVideo || z) ? "" : absolutePath);
                if (zCheckedAndroid_Q) {
                    if (zEqVideo) {
                        absolutePath = null;
                    }
                    localMedia.setAndroidQToPath(absolutePath);
                }
            }
        }
        onResult(list);
    }

    private void initConfig() {
        List<LocalMedia> arrayList = this.config.selectionMedias;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.selectionMedias = arrayList;
        PictureSelectionConfig pictureSelectionConfig = this.config;
        PictureParameterStyle pictureParameterStyle = pictureSelectionConfig.style;
        if (pictureParameterStyle != null) {
            this.openWhiteStatusBar = pictureParameterStyle.isChangeStatusBarFontColor;
            int i2 = pictureParameterStyle.pictureTitleBarBackgroundColor;
            if (i2 != 0) {
                this.colorPrimary = i2;
            }
            int i3 = this.config.style.pictureStatusBarColor;
            if (i3 != 0) {
                this.colorPrimaryDark = i3;
            }
            PictureSelectionConfig pictureSelectionConfig2 = this.config;
            PictureParameterStyle pictureParameterStyle2 = pictureSelectionConfig2.style;
            this.numComplete = pictureParameterStyle2.isOpenCompletedNumStyle;
            pictureSelectionConfig2.checkNumMode = pictureParameterStyle2.isOpenCheckNumStyle;
        } else {
            this.openWhiteStatusBar = pictureSelectionConfig.isChangeStatusBarFontColor;
            if (!this.openWhiteStatusBar) {
                this.openWhiteStatusBar = AttrsUtils.getTypeValueBoolean(this, R.attr.picture_statusFontColor);
            }
            this.numComplete = this.config.isOpenStyleNumComplete;
            if (!this.numComplete) {
                this.numComplete = AttrsUtils.getTypeValueBoolean(this, R.attr.picture_style_numComplete);
            }
            PictureSelectionConfig pictureSelectionConfig3 = this.config;
            pictureSelectionConfig3.checkNumMode = pictureSelectionConfig3.isOpenStyleCheckNumMode;
            if (!pictureSelectionConfig3.checkNumMode) {
                pictureSelectionConfig3.checkNumMode = AttrsUtils.getTypeValueBoolean(this, R.attr.picture_style_checkNumMode);
            }
            int i4 = this.config.titleBarBackgroundColor;
            if (i4 != 0) {
                this.colorPrimary = i4;
            } else {
                this.colorPrimary = AttrsUtils.getTypeValueColor(this, R.attr.colorPrimary);
            }
            int i5 = this.config.pictureStatusBarColor;
            if (i5 != 0) {
                this.colorPrimaryDark = i5;
            } else {
                this.colorPrimaryDark = AttrsUtils.getTypeValueColor(this, R.attr.colorPrimaryDark);
            }
        }
        if (this.config.openClickSound) {
            VoiceUtils.getInstance().init(getContext());
        }
    }

    private void isCheckConfigNull() {
        if (this.config == null) {
            this.config = PictureSelectionConfig.getInstance();
        }
    }

    private void onResultToAndroidAsy(final List<LocalMedia> list) {
        PictureThreadUtils.executeByCached(new PictureThreadUtils.SimpleTask<List<LocalMedia>>() { // from class: com.luck.picture.lib.PictureBaseActivity.6
            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public List<LocalMedia> doInBackground() {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    LocalMedia localMedia = (LocalMedia) list.get(i2);
                    if (localMedia != null && !TextUtils.isEmpty(localMedia.getPath())) {
                        if (((localMedia.isCut() || localMedia.isCompressed() || !TextUtils.isEmpty(localMedia.getAndroidQToPath())) ? false : true) && PictureMimeType.isContent(localMedia.getPath())) {
                            localMedia.setAndroidQToPath(AndroidQTransformUtils.copyPathToAndroidQ(PictureBaseActivity.this.getContext(), localMedia.getPath(), localMedia.getWidth(), localMedia.getHeight(), localMedia.getMimeType(), PictureBaseActivity.this.config.cameraFileName));
                        } else if (localMedia.isCut() && localMedia.isCompressed()) {
                            localMedia.setAndroidQToPath(localMedia.getCompressPath());
                        }
                        if (PictureBaseActivity.this.config.isCheckOriginalImage) {
                            localMedia.setOriginal(true);
                            localMedia.setOriginalPath(localMedia.getAndroidQToPath());
                        }
                    }
                }
                return list;
            }

            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public void onSuccess(List<LocalMedia> list2) {
                PictureThreadUtils.cancel(PictureThreadUtils.getCachedPool());
                PictureBaseActivity.this.dismissDialog();
                if (list2 != null) {
                    PictureBaseActivity pictureBaseActivity = PictureBaseActivity.this;
                    PictureSelectionConfig pictureSelectionConfig = pictureBaseActivity.config;
                    if (pictureSelectionConfig.camera && pictureSelectionConfig.selectionMode == 2 && pictureBaseActivity.selectionMedias != null) {
                        list2.addAll(list2.size() > 0 ? list2.size() - 1 : 0, PictureBaseActivity.this.selectionMedias);
                    }
                    OnResultCallbackListener onResultCallbackListener = PictureSelectionConfig.listener;
                    if (onResultCallbackListener != null) {
                        onResultCallbackListener.onResult(list2);
                    } else {
                        PictureBaseActivity.this.setResult(-1, PictureSelector.putIntentResult(list2));
                    }
                    PictureBaseActivity.this.closeActivity();
                }
            }
        });
    }

    private void releaseResultListener() {
        if (this.config != null) {
            PictureSelectionConfig.destroy();
            PictureThreadUtils.cancel(PictureThreadUtils.getCachedPool());
            PictureThreadUtils.cancel(PictureThreadUtils.getSinglePool());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startMultipleCropActivity(CutInfo cutInfo, UCrop.Options options) {
        String strRename;
        String path = cutInfo.getPath();
        String mimeType = cutInfo.getMimeType();
        Uri uriFromFile = !TextUtils.isEmpty(cutInfo.getAndroidQToPath()) ? Uri.fromFile(new File(cutInfo.getAndroidQToPath())) : (PictureMimeType.isHttp(path) || SdkVersionUtils.checkedAndroid_Q()) ? Uri.parse(path) : Uri.fromFile(new File(path));
        String strReplace = mimeType.replace("image/", ".");
        String diskCacheDir = PictureFileUtils.getDiskCacheDir(this);
        if (TextUtils.isEmpty(this.config.renameCropFileName)) {
            strRename = DateUtils.getCreateFileName("IMG_") + strReplace;
        } else {
            PictureSelectionConfig pictureSelectionConfig = this.config;
            boolean z = pictureSelectionConfig.camera;
            strRename = pictureSelectionConfig.renameCropFileName;
            if (!z) {
                strRename = StringUtils.rename(strRename);
            }
        }
        UCrop uCropWithOptions = UCrop.of(uriFromFile, Uri.fromFile(new File(diskCacheDir, strRename))).withOptions(options);
        PictureWindowAnimationStyle pictureWindowAnimationStyle = this.config.windowAnimationStyle;
        uCropWithOptions.startAnimationMultipleCropActivity(this, pictureWindowAnimationStyle != null ? pictureWindowAnimationStyle.activityCropEnterAnimation : R.anim.picture_anim_enter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSingleCropActivity(String str, String str2, String str3, UCrop.Options options) {
        String str4;
        boolean zIsHttp = PictureMimeType.isHttp(str);
        String strReplace = str3.replace("image/", ".");
        String diskCacheDir = PictureFileUtils.getDiskCacheDir(getContext());
        if (TextUtils.isEmpty(this.config.renameCropFileName)) {
            str4 = DateUtils.getCreateFileName("IMG_") + strReplace;
        } else {
            str4 = this.config.renameCropFileName;
        }
        UCrop uCropWithOptions = UCrop.of(!TextUtils.isEmpty(str2) ? Uri.fromFile(new File(str2)) : (zIsHttp || SdkVersionUtils.checkedAndroid_Q()) ? Uri.parse(str) : Uri.fromFile(new File(str)), Uri.fromFile(new File(diskCacheDir, str4))).withOptions(options);
        PictureWindowAnimationStyle pictureWindowAnimationStyle = this.config.windowAnimationStyle;
        uCropWithOptions.startAnimationActivity(this, pictureWindowAnimationStyle != null ? pictureWindowAnimationStyle.activityCropEnterAnimation : R.anim.picture_anim_enter);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        this.config = PictureSelectionConfig.getInstance();
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig != null) {
            super.attachBaseContext(PictureContextWrapper.wrap(context, pictureSelectionConfig.language));
        }
    }

    protected void closeActivity() {
        int i2;
        finish();
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.camera) {
            overridePendingTransition(0, R.anim.picture_anim_fade_out);
        } else {
            PictureWindowAnimationStyle pictureWindowAnimationStyle = pictureSelectionConfig.windowAnimationStyle;
            if (pictureWindowAnimationStyle == null || (i2 = pictureWindowAnimationStyle.activityExitAnimation) == 0) {
                i2 = R.anim.picture_anim_exit;
            }
            overridePendingTransition(0, i2);
        }
        if (this.config.camera) {
            if ((getContext() instanceof PictureSelectorCameraEmptyActivity) || (getContext() instanceof PictureCustomCameraActivity)) {
                releaseResultListener();
                return;
            }
            return;
        }
        if (getContext() instanceof PictureSelectorActivity) {
            releaseResultListener();
            if (this.config.openClickSound) {
                VoiceUtils.getInstance().releaseSoundPool();
            }
        }
    }

    protected void compressImage(final List<LocalMedia> list) {
        showPleaseDialog();
        if (PictureSelectionConfig.cacheResourcesEngine != null) {
            PictureThreadUtils.executeByCached(new PictureThreadUtils.SimpleTask<List<LocalMedia>>() { // from class: com.luck.picture.lib.PictureBaseActivity.1
                @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
                public List<LocalMedia> doInBackground() {
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        LocalMedia localMedia = (LocalMedia) list.get(i2);
                        if (localMedia != null) {
                            localMedia.setAndroidQToPath(PictureSelectionConfig.cacheResourcesEngine.onCachePath(PictureBaseActivity.this.getContext(), localMedia.getPath()));
                        }
                    }
                    return list;
                }

                @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
                public void onSuccess(List<LocalMedia> list2) {
                    PictureThreadUtils.cancel(PictureThreadUtils.getCachedPool());
                    PictureBaseActivity.this.compressToLuban(list2);
                }
            });
        } else {
            compressToLuban(list);
        }
    }

    protected void createNewFolder(List<LocalMediaFolder> list) {
        if (list.size() == 0) {
            LocalMediaFolder localMediaFolder = new LocalMediaFolder();
            localMediaFolder.setName(getString(this.config.chooseMode == PictureMimeType.ofAudio() ? R.string.picture_all_audio : R.string.picture_camera_roll));
            localMediaFolder.setFirstImagePath("");
            list.add(localMediaFolder);
        }
    }

    protected void dismissDialog() {
        if (isFinishing()) {
            return;
        }
        try {
            if (this.mLoadingDialog == null || !this.mLoadingDialog.isShowing()) {
                return;
            }
            this.mLoadingDialog.dismiss();
        } catch (Exception e2) {
            this.mLoadingDialog = null;
            e2.printStackTrace();
        }
    }

    protected String getAudioPath(Intent intent) {
        boolean z = Build.VERSION.SDK_INT <= 19;
        if (intent == null || this.config.chooseMode != PictureMimeType.ofAudio()) {
            return "";
        }
        try {
            Uri data = intent.getData();
            return data != null ? z ? data.getPath() : MediaUtils.getAudioFilePathFromUri(getContext(), data) : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    protected Context getContext() {
        return this;
    }

    @Nullable
    protected LocalMediaFolder getImageFolder(String str, List<LocalMediaFolder> list) {
        File parentFile = new File(PictureMimeType.isContent(str) ? (String) Objects.requireNonNull(PictureFileUtils.getPath(getContext(), Uri.parse(str))) : str).getParentFile();
        for (LocalMediaFolder localMediaFolder : list) {
            if (parentFile != null && localMediaFolder.getName().equals(parentFile.getName())) {
                return localMediaFolder;
            }
        }
        LocalMediaFolder localMediaFolder2 = new LocalMediaFolder();
        localMediaFolder2.setName(parentFile != null ? parentFile.getName() : "");
        localMediaFolder2.setFirstImagePath(str);
        list.add(localMediaFolder2);
        return localMediaFolder2;
    }

    public abstract int getResourceId();

    protected void handlerResult(List<LocalMedia> list) {
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (!pictureSelectionConfig.isCompress || pictureSelectionConfig.isCheckOriginalImage) {
            onResult(list);
        } else {
            compressImage(list);
        }
    }

    public void immersive() {
        ImmersiveManage.immersiveAboveAPI23(this, this.colorPrimaryDark, this.colorPrimary, this.openWhiteStatusBar);
    }

    protected void initCompleteText(int i2) {
    }

    protected void initCompleteText(List<LocalMedia> list) {
    }

    protected void initPictureSelectorStyle() {
    }

    protected void initWidgets() {
    }

    @Override // android.app.Activity
    public boolean isImmersive() {
        return true;
    }

    public boolean isRequestedOrientation() {
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        int i2;
        if (bundle != null) {
            this.config = (PictureSelectionConfig) bundle.getParcelable(PictureConfig.EXTRA_CONFIG);
        }
        isCheckConfigNull();
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (!pictureSelectionConfig.camera) {
            setTheme(pictureSelectionConfig.themeStyleId);
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        super.onCreate(bundle);
        if (isRequestedOrientation()) {
            setNewRequestedOrientation();
        }
        this.mHandler = new Handler(Looper.getMainLooper());
        initConfig();
        if (isImmersive()) {
            immersive();
        }
        PictureParameterStyle pictureParameterStyle = this.config.style;
        if (pictureParameterStyle != null && (i2 = pictureParameterStyle.pictureNavBarColor) != 0) {
            NavBarUtils.setNavBarColor(this, i2);
        }
        int resourceId = getResourceId();
        if (resourceId != 0) {
            setContentView(resourceId);
        }
        initWidgets();
        initPictureSelectorStyle();
        this.isOnSaveInstanceState = false;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        dismissDialog();
        this.mLoadingDialog = null;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 3) {
            return;
        }
        if (iArr[0] != 0) {
            ToastUtils.s(getContext(), getString(R.string.picture_audio));
            return;
        }
        Intent intent = new Intent("android.provider.MediaStore.RECORD_SOUND");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, PictureConfig.REQUEST_CAMERA);
        }
    }

    protected void onResult(List<LocalMedia> list) {
        if (SdkVersionUtils.checkedAndroid_Q() && this.config.isAndroidQTransform) {
            showPleaseDialog();
            onResultToAndroidAsy(list);
            return;
        }
        dismissDialog();
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.camera && pictureSelectionConfig.selectionMode == 2 && this.selectionMedias != null) {
            list.addAll(list.size() > 0 ? list.size() - 1 : 0, this.selectionMedias);
        }
        if (this.config.isCheckOriginalImage) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                LocalMedia localMedia = list.get(i2);
                localMedia.setOriginal(true);
                localMedia.setOriginalPath(localMedia.getPath());
            }
        }
        OnResultCallbackListener onResultCallbackListener = PictureSelectionConfig.listener;
        if (onResultCallbackListener != null) {
            onResultCallbackListener.onResult(list);
        } else {
            setResult(-1, PictureSelector.putIntentResult(list));
        }
        closeActivity();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(@i.c.a.d Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.isOnSaveInstanceState = true;
        bundle.putParcelable(PictureConfig.EXTRA_CONFIG, this.config);
    }

    protected void setNewRequestedOrientation() {
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig == null || pictureSelectionConfig.camera) {
            return;
        }
        setRequestedOrientation(pictureSelectionConfig.requestedOrientation);
    }

    protected void showPermissionsDialog(boolean z, String str) {
    }

    protected void showPleaseDialog() {
        if (isFinishing()) {
            return;
        }
        if (this.mLoadingDialog == null) {
            this.mLoadingDialog = new PictureLoadingDialog(getContext());
        }
        if (this.mLoadingDialog.isShowing()) {
            this.mLoadingDialog.dismiss();
        }
        this.mLoadingDialog.show();
    }

    protected void startCrop(final String str, final String str2) {
        if (TextUtils.isEmpty(str)) {
            ToastUtils.s(this, getString(R.string.picture_not_crop_data));
            return;
        }
        final UCrop.Options optionsBasicOptions = basicOptions();
        if (PictureSelectionConfig.cacheResourcesEngine != null) {
            PictureThreadUtils.executeByCached(new PictureThreadUtils.SimpleTask<String>() { // from class: com.luck.picture.lib.PictureBaseActivity.4
                @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
                public String doInBackground() {
                    return PictureSelectionConfig.cacheResourcesEngine.onCachePath(PictureBaseActivity.this.getContext(), str);
                }

                @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
                public void onSuccess(String str3) {
                    PictureThreadUtils.cancel(PictureThreadUtils.getCachedPool());
                    PictureBaseActivity.this.startSingleCropActivity(str, str3, str2, optionsBasicOptions);
                }
            });
        } else {
            startSingleCropActivity(str, null, str2, optionsBasicOptions);
        }
    }

    protected void startOpenCamera() {
        String strRename;
        Uri uriParUri;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(getPackageManager()) != null) {
            if (SdkVersionUtils.checkedAndroid_Q()) {
                uriParUri = MediaUtils.createImageUri(getApplicationContext());
                if (uriParUri == null) {
                    ToastUtils.s(getContext(), "open is camera error，the uri is empty ");
                    if (this.config.camera) {
                        closeActivity();
                        return;
                    }
                    return;
                }
                this.config.cameraPath = uriParUri.toString();
            } else {
                int i2 = this.config.chooseMode;
                if (i2 == 0) {
                    i2 = 1;
                }
                if (TextUtils.isEmpty(this.config.cameraFileName)) {
                    strRename = "";
                } else {
                    boolean zIsSuffixOfImage = PictureMimeType.isSuffixOfImage(this.config.cameraFileName);
                    PictureSelectionConfig pictureSelectionConfig = this.config;
                    pictureSelectionConfig.cameraFileName = !zIsSuffixOfImage ? StringUtils.renameSuffix(pictureSelectionConfig.cameraFileName, ".jpg") : pictureSelectionConfig.cameraFileName;
                    PictureSelectionConfig pictureSelectionConfig2 = this.config;
                    boolean z = pictureSelectionConfig2.camera;
                    strRename = pictureSelectionConfig2.cameraFileName;
                    if (!z) {
                        strRename = StringUtils.rename(strRename);
                    }
                }
                Context applicationContext = getApplicationContext();
                PictureSelectionConfig pictureSelectionConfig3 = this.config;
                File fileCreateCameraFile = PictureFileUtils.createCameraFile(applicationContext, i2, strRename, pictureSelectionConfig3.suffixType, pictureSelectionConfig3.outPutCameraPath);
                if (fileCreateCameraFile == null) {
                    ToastUtils.s(getContext(), "open is camera error，the uri is empty ");
                    if (this.config.camera) {
                        closeActivity();
                        return;
                    }
                    return;
                }
                this.config.cameraPath = fileCreateCameraFile.getAbsolutePath();
                uriParUri = PictureFileUtils.parUri(this, fileCreateCameraFile);
            }
            this.config.cameraMimeType = PictureMimeType.ofImage();
            if (this.config.isCameraAroundState) {
                intent.putExtra(PictureConfig.CAMERA_FACING, 1);
            }
            intent.putExtra("output", uriParUri);
            startActivityForResult(intent, PictureConfig.REQUEST_CAMERA);
        }
    }

    public void startOpenCameraAudio() {
        if (!PermissionChecker.checkSelfPermission(this, util.permissionutil.a.f20915i)) {
            PermissionChecker.requestPermissions(this, new String[]{util.permissionutil.a.f20915i}, 3);
            return;
        }
        Intent intent = new Intent("android.provider.MediaStore.RECORD_SOUND");
        if (intent.resolveActivity(getPackageManager()) != null) {
            this.config.cameraMimeType = PictureMimeType.ofAudio();
            startActivityForResult(intent, PictureConfig.REQUEST_CAMERA);
        }
    }

    protected void startOpenCameraVideo() {
        String strRename;
        Uri uriParUri;
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        if (intent.resolveActivity(getPackageManager()) != null) {
            if (SdkVersionUtils.checkedAndroid_Q()) {
                uriParUri = MediaUtils.createVideoUri(getApplicationContext());
                if (uriParUri == null) {
                    ToastUtils.s(getContext(), "open is camera error，the uri is empty ");
                    if (this.config.camera) {
                        closeActivity();
                        return;
                    }
                    return;
                }
                this.config.cameraPath = uriParUri.toString();
            } else {
                int i2 = this.config.chooseMode;
                if (i2 == 0) {
                    i2 = 2;
                }
                if (TextUtils.isEmpty(this.config.cameraFileName)) {
                    strRename = "";
                } else {
                    boolean zIsSuffixOfImage = PictureMimeType.isSuffixOfImage(this.config.cameraFileName);
                    PictureSelectionConfig pictureSelectionConfig = this.config;
                    pictureSelectionConfig.cameraFileName = zIsSuffixOfImage ? StringUtils.renameSuffix(pictureSelectionConfig.cameraFileName, ".mp4") : pictureSelectionConfig.cameraFileName;
                    PictureSelectionConfig pictureSelectionConfig2 = this.config;
                    boolean z = pictureSelectionConfig2.camera;
                    strRename = pictureSelectionConfig2.cameraFileName;
                    if (!z) {
                        strRename = StringUtils.rename(strRename);
                    }
                }
                Context applicationContext = getApplicationContext();
                PictureSelectionConfig pictureSelectionConfig3 = this.config;
                File fileCreateCameraFile = PictureFileUtils.createCameraFile(applicationContext, i2, strRename, pictureSelectionConfig3.suffixType, pictureSelectionConfig3.outPutCameraPath);
                if (fileCreateCameraFile == null) {
                    ToastUtils.s(getContext(), "open is camera error，the uri is empty ");
                    if (this.config.camera) {
                        closeActivity();
                        return;
                    }
                    return;
                }
                this.config.cameraPath = fileCreateCameraFile.getAbsolutePath();
                uriParUri = PictureFileUtils.parUri(this, fileCreateCameraFile);
            }
            this.config.cameraMimeType = PictureMimeType.ofVideo();
            intent.putExtra("output", uriParUri);
            if (this.config.isCameraAroundState) {
                intent.putExtra(PictureConfig.CAMERA_FACING, 1);
            }
            intent.putExtra("android.intent.extra.durationLimit", this.config.recordVideoSecond);
            intent.putExtra("android.intent.extra.videoQuality", this.config.videoQuality);
            startActivityForResult(intent, PictureConfig.REQUEST_CAMERA);
        }
    }

    private UCrop.Options basicOptions(ArrayList<CutInfo> arrayList) throws Resources.NotFoundException {
        int typeValueColor;
        int typeValueColor2;
        int typeValueColor3;
        boolean typeValueBoolean;
        int i2;
        PictureSelectionConfig pictureSelectionConfig = this.config;
        PictureCropParameterStyle pictureCropParameterStyle = pictureSelectionConfig.cropStyle;
        if (pictureCropParameterStyle != null) {
            typeValueColor = pictureCropParameterStyle.cropTitleBarBackgroundColor;
            if (typeValueColor == 0) {
                typeValueColor = 0;
            }
            typeValueColor2 = this.config.cropStyle.cropStatusBarColorPrimaryDark;
            if (typeValueColor2 == 0) {
                typeValueColor2 = 0;
            }
            typeValueColor3 = this.config.cropStyle.cropTitleColor;
            if (typeValueColor3 == 0) {
                typeValueColor3 = 0;
            }
            typeValueBoolean = this.config.cropStyle.isChangeStatusBarFontColor;
        } else {
            typeValueColor = pictureSelectionConfig.cropTitleBarBackgroundColor;
            if (typeValueColor == 0) {
                typeValueColor = AttrsUtils.getTypeValueColor(this, R.attr.picture_crop_toolbar_bg);
            }
            typeValueColor2 = this.config.cropStatusBarColorPrimaryDark;
            if (typeValueColor2 == 0) {
                typeValueColor2 = AttrsUtils.getTypeValueColor(this, R.attr.picture_crop_status_color);
            }
            typeValueColor3 = this.config.cropTitleColor;
            if (typeValueColor3 == 0) {
                typeValueColor3 = AttrsUtils.getTypeValueColor(this, R.attr.picture_crop_title_color);
            }
            typeValueBoolean = this.config.isChangeStatusBarFontColor;
            if (!typeValueBoolean) {
                typeValueBoolean = AttrsUtils.getTypeValueBoolean(this, R.attr.picture_statusFontColor);
            }
        }
        UCrop.Options options = this.config.uCropOptions;
        if (options == null) {
            options = new UCrop.Options();
        }
        options.isOpenWhiteStatusBar(typeValueBoolean);
        options.setToolbarColor(typeValueColor);
        options.setStatusBarColor(typeValueColor2);
        options.setToolbarWidgetColor(typeValueColor3);
        options.setCircleDimmedLayer(this.config.circleDimmedLayer);
        options.setDimmedLayerColor(this.config.circleDimmedColor);
        options.setDimmedLayerBorderColor(this.config.circleDimmedBorderColor);
        options.setCircleStrokeWidth(this.config.circleStrokeWidth);
        options.setShowCropFrame(this.config.showCropFrame);
        options.setDragFrameEnabled(this.config.isDragFrame);
        options.setShowCropGrid(this.config.showCropGrid);
        options.setScaleEnabled(this.config.scaleEnabled);
        options.setRotateEnabled(this.config.rotateEnabled);
        options.isMultipleSkipCrop(this.config.isMultipleSkipCrop);
        options.setHideBottomControls(this.config.hideBottomControls);
        options.setCompressionQuality(this.config.cropCompressQuality);
        options.setRenameCropFileName(this.config.renameCropFileName);
        options.isCamera(this.config.camera);
        options.setCutListData(arrayList);
        options.isWithVideoImage(this.config.isWithVideoImage);
        options.setFreeStyleCropEnabled(this.config.freeStyleCropEnabled);
        PictureWindowAnimationStyle pictureWindowAnimationStyle = this.config.windowAnimationStyle;
        options.setCropExitAnimation(pictureWindowAnimationStyle != null ? pictureWindowAnimationStyle.activityCropExitAnimation : 0);
        PictureCropParameterStyle pictureCropParameterStyle2 = this.config.cropStyle;
        options.setNavBarColor(pictureCropParameterStyle2 != null ? pictureCropParameterStyle2.cropNavBarColor : 0);
        PictureSelectionConfig pictureSelectionConfig2 = this.config;
        options.withAspectRatio(pictureSelectionConfig2.aspect_ratio_x, pictureSelectionConfig2.aspect_ratio_y);
        options.isMultipleRecyclerAnimation(this.config.isMultipleRecyclerAnimation);
        PictureSelectionConfig pictureSelectionConfig3 = this.config;
        int i3 = pictureSelectionConfig3.cropWidth;
        if (i3 > 0 && (i2 = pictureSelectionConfig3.cropHeight) > 0) {
            options.withMaxResultSize(i3, i2);
        }
        return options;
    }

    protected void startCrop(final ArrayList<CutInfo> arrayList) throws Resources.NotFoundException {
        if (arrayList != null && arrayList.size() != 0) {
            final UCrop.Options optionsBasicOptions = basicOptions(arrayList);
            final int size = arrayList.size();
            int i2 = 0;
            this.index = 0;
            if (this.config.chooseMode == PictureMimeType.ofAll() && this.config.isWithVideoImage) {
                if (PictureMimeType.eqVideo(size > 0 ? arrayList.get(this.index).getMimeType() : "")) {
                    while (true) {
                        if (i2 < size) {
                            CutInfo cutInfo = arrayList.get(i2);
                            if (cutInfo != null && PictureMimeType.eqImage(cutInfo.getMimeType())) {
                                this.index = i2;
                                break;
                            }
                            i2++;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (PictureSelectionConfig.cacheResourcesEngine != null) {
                PictureThreadUtils.executeByCached(new PictureThreadUtils.SimpleTask<List<CutInfo>>() { // from class: com.luck.picture.lib.PictureBaseActivity.5
                    @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
                    public List<CutInfo> doInBackground() {
                        for (int i3 = 0; i3 < size; i3++) {
                            CutInfo cutInfo2 = (CutInfo) arrayList.get(i3);
                            String strOnCachePath = PictureSelectionConfig.cacheResourcesEngine.onCachePath(PictureBaseActivity.this.getContext(), cutInfo2.getPath());
                            if (!TextUtils.isEmpty(strOnCachePath)) {
                                cutInfo2.setAndroidQToPath(strOnCachePath);
                            }
                        }
                        return arrayList;
                    }

                    @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
                    public void onSuccess(List<CutInfo> list) {
                        PictureThreadUtils.cancel(PictureThreadUtils.getCachedPool());
                        if (PictureBaseActivity.this.index < size) {
                            PictureBaseActivity pictureBaseActivity = PictureBaseActivity.this;
                            pictureBaseActivity.startMultipleCropActivity(list.get(pictureBaseActivity.index), optionsBasicOptions);
                        }
                    }
                });
                return;
            }
            int i3 = this.index;
            if (i3 < size) {
                startMultipleCropActivity(arrayList.get(i3), optionsBasicOptions);
                return;
            }
            return;
        }
        ToastUtils.s(this, getString(R.string.picture_not_crop_data));
    }
}
