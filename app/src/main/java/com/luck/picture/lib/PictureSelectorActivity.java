package com.luck.picture.lib;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.luck.picture.lib.adapter.PictureImageGridAdapter;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.decoration.GridSpacingItemDecoration;
import com.luck.picture.lib.dialog.PhotoItemSelectedDialog;
import com.luck.picture.lib.dialog.PictureCustomDialog;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.listener.OnAlbumItemClickListener;
import com.luck.picture.lib.listener.OnItemClickListener;
import com.luck.picture.lib.listener.OnPhotoSelectChangedListener;
import com.luck.picture.lib.listener.OnPictureSelectorInterfaceListener;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.luck.picture.lib.listener.OnVideoSelectedPlayCallback;
import com.luck.picture.lib.model.LocalMediaLoader;
import com.luck.picture.lib.observable.ImagesObservable;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.style.PictureParameterStyle;
import com.luck.picture.lib.style.PictureWindowAnimationStyle;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.tools.AndroidQTransformUtils;
import com.luck.picture.lib.tools.AttrsUtils;
import com.luck.picture.lib.tools.BitmapUtils;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.DoubleUtils;
import com.luck.picture.lib.tools.JumpUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.ScreenUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.StringUtils;
import com.luck.picture.lib.tools.ToastUtils;
import com.luck.picture.lib.tools.ValueOf;
import com.luck.picture.lib.widget.FolderPopWindow;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.model.CutInfo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class PictureSelectorActivity extends PictureBaseActivity implements View.OnClickListener, OnAlbumItemClickListener, OnPhotoSelectChangedListener<LocalMedia>, OnItemClickListener {
    protected PictureCustomDialog audioDialog;
    protected FolderPopWindow folderWindow;
    protected boolean isEnterSetting;
    protected PictureImageGridAdapter mAdapter;
    protected RelativeLayout mBottomLayout;
    protected CheckBox mCbOriginal;
    protected ImageView mIvArrow;
    protected ImageView mIvPictureLeftBack;
    protected RecyclerView mPictureRecycler;
    protected TextView mTvEmpty;
    protected TextView mTvMusicStatus;
    protected TextView mTvMusicTime;
    protected TextView mTvMusicTotal;
    protected TextView mTvPictureImgNum;
    protected TextView mTvPictureOk;
    protected TextView mTvPicturePreview;
    protected TextView mTvPictureRight;
    protected TextView mTvPictureTitle;
    protected TextView mTvPlayPause;
    protected TextView mTvQuit;
    protected TextView mTvStop;
    protected MediaPlayer mediaPlayer;
    protected SeekBar musicSeekBar;
    protected int oldCurrentListSize;
    protected View titleViewBg;
    protected List<LocalMedia> images = new ArrayList();
    protected List<LocalMediaFolder> foldersList = new ArrayList();
    protected Animation animation = null;
    protected boolean isStartAnimation = false;
    protected boolean isPlayAudio = false;
    protected boolean isFirstEnterActivity = false;
    public Runnable mRunnable = new Runnable() { // from class: com.luck.picture.lib.PictureSelectorActivity.3
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (PictureSelectorActivity.this.mediaPlayer != null) {
                    PictureSelectorActivity.this.mTvMusicTime.setText(DateUtils.formatDurationTime(PictureSelectorActivity.this.mediaPlayer.getCurrentPosition()));
                    PictureSelectorActivity.this.musicSeekBar.setProgress(PictureSelectorActivity.this.mediaPlayer.getCurrentPosition());
                    PictureSelectorActivity.this.musicSeekBar.setMax(PictureSelectorActivity.this.mediaPlayer.getDuration());
                    PictureSelectorActivity.this.mTvMusicTotal.setText(DateUtils.formatDurationTime(PictureSelectorActivity.this.mediaPlayer.getDuration()));
                    if (PictureSelectorActivity.this.mHandler != null) {
                        PictureSelectorActivity.this.mHandler.postDelayed(PictureSelectorActivity.this.mRunnable, 200L);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    };

    public class audioOnClick implements View.OnClickListener {
        private String path;

        public audioOnClick(String str) {
            this.path = str;
        }

        public /* synthetic */ void a() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
            PictureSelectorActivity.this.b(this.path);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
            Handler handler;
            int id = view.getId();
            if (id == R.id.tv_PlayPause) {
                PictureSelectorActivity.this.playAudio();
            }
            if (id == R.id.tv_Stop) {
                PictureSelectorActivity pictureSelectorActivity = PictureSelectorActivity.this;
                pictureSelectorActivity.mTvMusicStatus.setText(pictureSelectorActivity.getString(R.string.picture_stop_audio));
                PictureSelectorActivity pictureSelectorActivity2 = PictureSelectorActivity.this;
                pictureSelectorActivity2.mTvPlayPause.setText(pictureSelectorActivity2.getString(R.string.picture_play_audio));
                PictureSelectorActivity.this.b(this.path);
            }
            if (id != R.id.tv_Quit || (handler = PictureSelectorActivity.this.mHandler) == null) {
                return;
            }
            handler.postDelayed(new Runnable() { // from class: com.luck.picture.lib.t
                @Override // java.lang.Runnable
                public final void run() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                    this.f7818a.a();
                }
            }, 30L);
            try {
                if (PictureSelectorActivity.this.audioDialog != null && PictureSelectorActivity.this.audioDialog.isShowing()) {
                    PictureSelectorActivity.this.audioDialog.dismiss();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            PictureSelectorActivity pictureSelectorActivity3 = PictureSelectorActivity.this;
            pictureSelectorActivity3.mHandler.removeCallbacks(pictureSelectorActivity3.mRunnable);
        }
    }

    private String androidQpath(LocalMedia localMedia) {
        if (localMedia == null || TextUtils.isEmpty(localMedia.getPath())) {
            return "";
        }
        if (PictureMimeType.isContent(localMedia.getPath())) {
            localMedia.setAndroidQToPath(AndroidQTransformUtils.copyPathToAndroidQ(getContext(), localMedia.getPath(), localMedia.getWidth(), localMedia.getHeight(), localMedia.getMimeType(), this.config.cameraFileName));
        }
        return localMedia.getAndroidQToPath();
    }

    private void audioDialog(LocalMedia localMedia) {
        final String path = localMedia.getPath();
        if (SdkVersionUtils.checkedAndroid_Q()) {
            path = androidQpath(localMedia);
        }
        if (isFinishing()) {
            return;
        }
        this.audioDialog = new PictureCustomDialog(getContext(), R.layout.picture_audio_dialog);
        if (this.audioDialog.getWindow() != null) {
            this.audioDialog.getWindow().setWindowAnimations(R.style.Picture_Theme_Dialog_AudioStyle);
        }
        this.mTvMusicStatus = (TextView) this.audioDialog.findViewById(R.id.tv_musicStatus);
        this.mTvMusicTime = (TextView) this.audioDialog.findViewById(R.id.tv_musicTime);
        this.musicSeekBar = (SeekBar) this.audioDialog.findViewById(R.id.musicSeekBar);
        this.mTvMusicTotal = (TextView) this.audioDialog.findViewById(R.id.tv_musicTotal);
        this.mTvPlayPause = (TextView) this.audioDialog.findViewById(R.id.tv_PlayPause);
        this.mTvStop = (TextView) this.audioDialog.findViewById(R.id.tv_Stop);
        this.mTvQuit = (TextView) this.audioDialog.findViewById(R.id.tv_Quit);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: com.luck.picture.lib.u
                @Override // java.lang.Runnable
                public final void run() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                    this.f7819a.a(path);
                }
            }, 30L);
        }
        this.mTvPlayPause.setOnClickListener(new audioOnClick(path));
        this.mTvStop.setOnClickListener(new audioOnClick(path));
        this.mTvQuit.setOnClickListener(new audioOnClick(path));
        this.musicSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.luck.picture.lib.PictureSelectorActivity.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) throws IllegalStateException {
                if (z) {
                    PictureSelectorActivity.this.mediaPlayer.seekTo(i2);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.audioDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.luck.picture.lib.r
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f7815a.a(path, dialogInterface);
            }
        });
        Handler handler2 = this.mHandler;
        if (handler2 != null) {
            handler2.post(this.mRunnable);
        }
        this.audioDialog.show();
    }

    private void bothMimeTypeWith(boolean z, List<LocalMedia> list) throws Resources.NotFoundException {
        int i2 = 0;
        LocalMedia localMedia = list.size() > 0 ? list.get(0) : null;
        if (localMedia == null) {
            return;
        }
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (!pictureSelectionConfig.enableCrop) {
            if (!pictureSelectionConfig.isCompress) {
                onResult(list);
                return;
            }
            int size = list.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                if (PictureMimeType.eqImage(list.get(i3).getMimeType())) {
                    i2 = 1;
                    break;
                }
                i3++;
            }
            if (i2 <= 0) {
                onResult(list);
                return;
            } else {
                compressImage(list);
                return;
            }
        }
        if (pictureSelectionConfig.selectionMode == 1 && z) {
            pictureSelectionConfig.originalPath = localMedia.getPath();
            startCrop(this.config.originalPath, localMedia.getMimeType());
            return;
        }
        ArrayList<CutInfo> arrayList = new ArrayList<>();
        int size2 = list.size();
        int i4 = 0;
        while (i2 < size2) {
            LocalMedia localMedia2 = list.get(i2);
            if (localMedia2 != null && !TextUtils.isEmpty(localMedia2.getPath())) {
                if (PictureMimeType.eqImage(localMedia2.getMimeType())) {
                    i4++;
                }
                CutInfo cutInfo = new CutInfo();
                cutInfo.setId(localMedia2.getId());
                cutInfo.setPath(localMedia2.getPath());
                cutInfo.setImageWidth(localMedia2.getWidth());
                cutInfo.setImageHeight(localMedia2.getHeight());
                cutInfo.setMimeType(localMedia2.getMimeType());
                cutInfo.setDuration(localMedia2.getDuration());
                cutInfo.setRealPath(localMedia2.getRealPath());
                arrayList.add(cutInfo);
            }
            i2++;
        }
        if (i4 <= 0) {
            onResult(list);
        } else {
            startCrop(arrayList);
        }
    }

    private boolean checkVideoLegitimacy(LocalMedia localMedia) {
        if (PictureMimeType.eqVideo(localMedia.getMimeType())) {
            PictureSelectionConfig pictureSelectionConfig = this.config;
            if (pictureSelectionConfig.videoMinSecond <= 0 || pictureSelectionConfig.videoMaxSecond <= 0) {
                PictureSelectionConfig pictureSelectionConfig2 = this.config;
                if (pictureSelectionConfig2.videoMinSecond > 0) {
                    if (localMedia.getDuration() < this.config.videoMinSecond) {
                        ToastUtils.s(getContext(), getString(R.string.picture_choose_min_seconds, new Object[]{Integer.valueOf(this.config.videoMinSecond / 1000)}));
                        return false;
                    }
                } else if (pictureSelectionConfig2.videoMaxSecond > 0 && localMedia.getDuration() > this.config.videoMaxSecond) {
                    ToastUtils.s(getContext(), getString(R.string.picture_choose_max_seconds, new Object[]{Integer.valueOf(this.config.videoMaxSecond / 1000)}));
                    return false;
                }
            } else if (localMedia.getDuration() < this.config.videoMinSecond || localMedia.getDuration() > this.config.videoMaxSecond) {
                ToastUtils.s(getContext(), getString(R.string.picture_choose_limit_seconds, new Object[]{Integer.valueOf(this.config.videoMinSecond / 1000), Integer.valueOf(this.config.videoMaxSecond / 1000)}));
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initPlayer, reason: merged with bridge method [inline-methods] */
    public void a(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        this.mediaPlayer = new MediaPlayer();
        try {
            this.mediaPlayer.setDataSource(str);
            this.mediaPlayer.prepare();
            this.mediaPlayer.setLooping(true);
            playAudio();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void isNumComplete(boolean z) {
        if (z) {
            initCompleteText(0);
        }
    }

    private void loadAllMediaData() {
        if (PermissionChecker.checkSelfPermission(this, util.permissionutil.a.z) && PermissionChecker.checkSelfPermission(this, util.permissionutil.a.A)) {
            readLocalMedia();
        } else {
            PermissionChecker.requestPermissions(this, new String[]{util.permissionutil.a.z, util.permissionutil.a.A}, 1);
        }
    }

    private void manualSaveFolder(LocalMedia localMedia) {
        try {
            createNewFolder(this.foldersList);
            LocalMediaFolder imageFolder = getImageFolder(localMedia.getPath(), this.foldersList);
            LocalMediaFolder localMediaFolder = this.foldersList.size() > 0 ? this.foldersList.get(0) : null;
            if (localMediaFolder == null || imageFolder == null) {
                return;
            }
            localMedia.setParentFolderName(imageFolder.getName());
            localMediaFolder.setFirstImagePath(localMedia.getPath());
            localMediaFolder.setImages(this.images);
            localMediaFolder.setImageNum(localMediaFolder.getImageNum() + 1);
            imageFolder.setImageNum(imageFolder.getImageNum() + 1);
            imageFolder.getImages().add(0, localMedia);
            imageFolder.setFirstImagePath(this.config.cameraPath);
            this.folderWindow.bindFolder(this.foldersList);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @SuppressLint({"StringFormatMatches"})
    private void onComplete() throws Resources.NotFoundException {
        int i2;
        int i3;
        List<LocalMedia> selectedImages = this.mAdapter.getSelectedImages();
        int size = selectedImages.size();
        LocalMedia localMedia = selectedImages.size() > 0 ? selectedImages.get(0) : null;
        String mimeType = localMedia != null ? localMedia.getMimeType() : "";
        boolean zEqImage = PictureMimeType.eqImage(mimeType);
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.isWithVideoImage) {
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                if (PictureMimeType.eqVideo(selectedImages.get(i6).getMimeType())) {
                    i5++;
                } else {
                    i4++;
                }
            }
            PictureSelectionConfig pictureSelectionConfig2 = this.config;
            if (pictureSelectionConfig2.selectionMode == 2) {
                int i7 = pictureSelectionConfig2.minSelectNum;
                if (i7 > 0 && i4 < i7) {
                    ToastUtils.s(getContext(), getString(R.string.picture_min_img_num, new Object[]{Integer.valueOf(this.config.minSelectNum)}));
                    return;
                }
                int i8 = this.config.minVideoSelectNum;
                if (i8 > 0 && i5 < i8) {
                    ToastUtils.s(getContext(), getString(R.string.picture_min_video_num, new Object[]{Integer.valueOf(this.config.minVideoSelectNum)}));
                    return;
                }
            }
        } else if (pictureSelectionConfig.selectionMode == 2) {
            if (PictureMimeType.eqImage(mimeType) && (i3 = this.config.minSelectNum) > 0 && size < i3) {
                ToastUtils.s(getContext(), getString(R.string.picture_min_img_num, new Object[]{Integer.valueOf(i3)}));
                return;
            } else if (PictureMimeType.eqVideo(mimeType) && (i2 = this.config.minVideoSelectNum) > 0 && size < i2) {
                ToastUtils.s(getContext(), getString(R.string.picture_min_video_num, new Object[]{Integer.valueOf(i2)}));
                return;
            }
        }
        PictureSelectionConfig pictureSelectionConfig3 = this.config;
        if (!pictureSelectionConfig3.returnEmpty || size != 0) {
            PictureSelectionConfig pictureSelectionConfig4 = this.config;
            if (pictureSelectionConfig4.isCheckOriginalImage) {
                onResult(selectedImages);
                return;
            } else if (pictureSelectionConfig4.chooseMode == PictureMimeType.ofAll() && this.config.isWithVideoImage) {
                bothMimeTypeWith(zEqImage, selectedImages);
                return;
            } else {
                separateMimeTypeWith(zEqImage, selectedImages);
                return;
            }
        }
        if (pictureSelectionConfig3.selectionMode == 2) {
            int i9 = pictureSelectionConfig3.minSelectNum;
            if (i9 > 0 && size < i9) {
                ToastUtils.s(getContext(), getString(R.string.picture_min_img_num, new Object[]{Integer.valueOf(i9)}));
                return;
            }
            int i10 = this.config.minVideoSelectNum;
            if (i10 > 0 && size < i10) {
                ToastUtils.s(getContext(), getString(R.string.picture_min_video_num, new Object[]{Integer.valueOf(i10)}));
                return;
            }
        }
        OnResultCallbackListener onResultCallbackListener = PictureSelectionConfig.listener;
        if (onResultCallbackListener != null) {
            onResultCallbackListener.onResult(selectedImages);
        } else {
            setResult(-1, PictureSelector.putIntentResult(selectedImages));
        }
        closeActivity();
    }

    private void onPreview() {
        int i2;
        List<LocalMedia> selectedImages = this.mAdapter.getSelectedImages();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        int size = selectedImages.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(selectedImages.get(i3));
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(PictureConfig.EXTRA_PREVIEW_SELECT_LIST, arrayList);
        bundle.putParcelableArrayList(PictureConfig.EXTRA_SELECT_LIST, (ArrayList) selectedImages);
        bundle.putBoolean(PictureConfig.EXTRA_BOTTOM_PREVIEW, true);
        bundle.putBoolean(PictureConfig.EXTRA_CHANGE_ORIGINAL, this.config.isCheckOriginalImage);
        bundle.putBoolean(PictureConfig.EXTRA_SHOW_CAMERA, this.mAdapter.isShowCamera());
        bundle.putString(PictureConfig.EXTRA_IS_CURRENT_DIRECTORY, this.mTvPictureTitle.getText().toString());
        Context context = getContext();
        PictureSelectionConfig pictureSelectionConfig = this.config;
        JumpUtils.startPicturePreviewActivity(context, pictureSelectionConfig.isWeChatStyle, bundle, pictureSelectionConfig.selectionMode == 1 ? 69 : UCrop.REQUEST_MULTI_CROP);
        PictureWindowAnimationStyle pictureWindowAnimationStyle = this.config.windowAnimationStyle;
        if (pictureWindowAnimationStyle == null || (i2 = pictureWindowAnimationStyle.activityPreviewEnterAnimation) == 0) {
            i2 = R.anim.picture_anim_enter;
        }
        overridePendingTransition(i2, R.anim.picture_anim_fade_in);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playAudio() throws IllegalStateException {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            this.musicSeekBar.setProgress(mediaPlayer.getCurrentPosition());
            this.musicSeekBar.setMax(this.mediaPlayer.getDuration());
        }
        if (this.mTvPlayPause.getText().toString().equals(getString(R.string.picture_play_audio))) {
            this.mTvPlayPause.setText(getString(R.string.picture_pause_audio));
            this.mTvMusicStatus.setText(getString(R.string.picture_play_audio));
            playOrPause();
        } else {
            this.mTvPlayPause.setText(getString(R.string.picture_play_audio));
            this.mTvMusicStatus.setText(getString(R.string.picture_pause_audio));
            playOrPause();
        }
        if (this.isPlayAudio) {
            return;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(this.mRunnable);
        }
        this.isPlayAudio = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void previewCallback(android.content.Intent r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L3
            return
        L3:
            com.luck.picture.lib.config.PictureSelectionConfig r0 = r5.config
            boolean r1 = r0.isOriginalControl
            if (r1 == 0) goto L1c
            boolean r1 = r0.isCheckOriginalImage
            java.lang.String r2 = "isOriginal"
            boolean r1 = r6.getBooleanExtra(r2, r1)
            r0.isCheckOriginalImage = r1
            android.widget.CheckBox r0 = r5.mCbOriginal
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r5.config
            boolean r1 = r1.isCheckOriginalImage
            r0.setChecked(r1)
        L1c:
            java.lang.String r0 = "selectList"
            java.util.ArrayList r0 = r6.getParcelableArrayListExtra(r0)
            com.luck.picture.lib.adapter.PictureImageGridAdapter r1 = r5.mAdapter
            if (r1 == 0) goto La5
            if (r0 == 0) goto La5
            r1 = 0
            java.lang.String r2 = "isCompleteOrSelected"
            boolean r6 = r6.getBooleanExtra(r2, r1)
            r2 = 1
            if (r6 == 0) goto L99
            r5.onChangeData(r0)
            com.luck.picture.lib.config.PictureSelectionConfig r6 = r5.config
            boolean r6 = r6.isWithVideoImage
            if (r6 == 0) goto L6c
            int r6 = r0.size()
            r3 = 0
        L40:
            if (r3 >= r6) goto L57
            java.lang.Object r4 = r0.get(r3)
            com.luck.picture.lib.entity.LocalMedia r4 = (com.luck.picture.lib.entity.LocalMedia) r4
            java.lang.String r4 = r4.getMimeType()
            boolean r4 = com.luck.picture.lib.config.PictureMimeType.eqImage(r4)
            if (r4 == 0) goto L54
            r1 = 1
            goto L57
        L54:
            int r3 = r3 + 1
            goto L40
        L57:
            if (r1 <= 0) goto L68
            com.luck.picture.lib.config.PictureSelectionConfig r6 = r5.config
            boolean r1 = r6.isCompress
            if (r1 == 0) goto L68
            boolean r6 = r6.isCheckOriginalImage
            if (r6 == 0) goto L64
            goto L68
        L64:
            r5.compressImage(r0)
            goto L9b
        L68:
            r5.onResult(r0)
            goto L9b
        L6c:
            int r6 = r0.size()
            if (r6 <= 0) goto L7d
            java.lang.Object r6 = r0.get(r1)
            com.luck.picture.lib.entity.LocalMedia r6 = (com.luck.picture.lib.entity.LocalMedia) r6
            java.lang.String r6 = r6.getMimeType()
            goto L7f
        L7d:
            java.lang.String r6 = ""
        L7f:
            com.luck.picture.lib.config.PictureSelectionConfig r1 = r5.config
            boolean r1 = r1.isCompress
            if (r1 == 0) goto L95
            boolean r6 = com.luck.picture.lib.config.PictureMimeType.eqImage(r6)
            if (r6 == 0) goto L95
            com.luck.picture.lib.config.PictureSelectionConfig r6 = r5.config
            boolean r6 = r6.isCheckOriginalImage
            if (r6 != 0) goto L95
            r5.compressImage(r0)
            goto L9b
        L95:
            r5.onResult(r0)
            goto L9b
        L99:
            r5.isStartAnimation = r2
        L9b:
            com.luck.picture.lib.adapter.PictureImageGridAdapter r6 = r5.mAdapter
            r6.bindSelectImages(r0)
            com.luck.picture.lib.adapter.PictureImageGridAdapter r6 = r5.mAdapter
            r6.notifyDataSetChanged()
        La5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.PictureSelectorActivity.previewCallback(android.content.Intent):void");
    }

    private void requestCamera(Intent intent) throws Throwable {
        String mimeType;
        long jExtractDuration;
        int lastImageId;
        int i2;
        int[] videoSizeForUri;
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
        int[] videoSizeForUrl = new int[2];
        if (!zCheckedAndroid_Q) {
            PictureSelectionConfig pictureSelectionConfig = this.config;
            if (pictureSelectionConfig.isFallbackVersion3) {
                new PictureMediaScannerConnection(getContext(), this.config.cameraPath);
            } else {
                sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(pictureSelectionConfig.cameraPath))));
            }
        }
        LocalMedia localMedia = new LocalMedia();
        localMedia.setPath(this.config.cameraPath);
        if (this.config.chooseMode == PictureMimeType.ofAudio()) {
            localMedia.setFileName(new File(this.config.cameraPath).getName());
        } else if (PictureMimeType.isContent(this.config.cameraPath)) {
            String path = PictureFileUtils.getPath(getApplicationContext(), Uri.parse(this.config.cameraPath));
            if (!TextUtils.isEmpty(path)) {
                File file = new File(path);
                long length2 = file.length();
                String mimeType2 = PictureMimeType.getMimeType(this.config.cameraMimeType);
                localMedia.setFileName(file.getName());
                length = length2;
                mimeType = mimeType2;
            }
            if (PictureMimeType.eqImage(mimeType)) {
                videoSizeForUri = MediaUtils.getImageSizeForUrlToAndroidQ(this, this.config.cameraPath);
            } else {
                videoSizeForUri = MediaUtils.getVideoSizeForUri(this, Uri.parse(this.config.cameraPath));
                jExtractDuration = MediaUtils.extractDuration(getContext(), true, this.config.cameraPath);
            }
            int iLastIndexOf = this.config.cameraPath.lastIndexOf("/") + 1;
            localMedia.setId(iLastIndexOf > 0 ? ValueOf.toLong(this.config.cameraPath.substring(iLastIndexOf)) : -1L);
            localMedia.setRealPath(path);
            if (this.config.isUseCustomCamera && intent != null) {
                localMedia.setAndroidQToPath(intent.getStringExtra(PictureConfig.EXTRA_MEDIA_PATH));
            }
            videoSizeForUrl = videoSizeForUri;
        } else {
            File file2 = new File(this.config.cameraPath);
            mimeType = PictureMimeType.getMimeType(this.config.cameraMimeType);
            length = file2.length();
            if (PictureMimeType.eqImage(mimeType)) {
                BitmapUtils.rotateImage(PictureFileUtils.readPictureDegree(this, this.config.cameraPath), this.config.cameraPath);
                videoSizeForUrl = MediaUtils.getImageSizeForUrl(this.config.cameraPath);
            } else {
                videoSizeForUrl = MediaUtils.getVideoSizeForUrl(this.config.cameraPath);
                jExtractDuration = MediaUtils.extractDuration(getContext(), false, this.config.cameraPath);
            }
            localMedia.setId(System.currentTimeMillis());
            localMedia.setFileName(file2.getName());
        }
        localMedia.setDuration(jExtractDuration);
        localMedia.setMimeType(mimeType);
        localMedia.setWidth(videoSizeForUrl[0]);
        localMedia.setHeight(videoSizeForUrl[1]);
        localMedia.setSize(length);
        localMedia.setChooseModel(this.config.chooseMode);
        MediaUtils.setOrientation(getContext(), localMedia);
        if (this.mAdapter != null) {
            this.images.add(0, localMedia);
            if (checkVideoLegitimacy(localMedia)) {
                PictureSelectionConfig pictureSelectionConfig2 = this.config;
                if (pictureSelectionConfig2.selectionMode != 1) {
                    List<LocalMedia> selectedImages = this.mAdapter.getSelectedImages();
                    int size = selectedImages.size();
                    String mimeType3 = size > 0 ? selectedImages.get(0).getMimeType() : "";
                    boolean zIsMimeTypeSame = PictureMimeType.isMimeTypeSame(mimeType3, localMedia.getMimeType());
                    if (this.config.isWithVideoImage) {
                        int i3 = 0;
                        int i4 = 0;
                        for (int i5 = 0; i5 < size; i5++) {
                            if (PictureMimeType.eqVideo(selectedImages.get(i5).getMimeType())) {
                                i4++;
                            } else {
                                i3++;
                            }
                        }
                        if (PictureMimeType.eqVideo(localMedia.getMimeType())) {
                            int i6 = this.config.maxVideoSelectNum;
                            if (i6 <= 0) {
                                ToastUtils.s(getContext(), getString(R.string.picture_rule));
                            } else if (i4 < i6) {
                                selectedImages.add(0, localMedia);
                                this.mAdapter.bindSelectImages(selectedImages);
                            } else {
                                ToastUtils.s(getContext(), StringUtils.getMsg(getContext(), localMedia.getMimeType(), this.config.maxVideoSelectNum));
                            }
                        } else if (i3 < this.config.maxSelectNum) {
                            selectedImages.add(0, localMedia);
                            this.mAdapter.bindSelectImages(selectedImages);
                        } else {
                            ToastUtils.s(getContext(), StringUtils.getMsg(getContext(), localMedia.getMimeType(), this.config.maxSelectNum));
                        }
                    } else if (!PictureMimeType.eqVideo(mimeType3) || (i2 = this.config.maxVideoSelectNum) <= 0) {
                        if (size >= this.config.maxSelectNum) {
                            ToastUtils.s(getContext(), StringUtils.getMsg(getContext(), mimeType3, this.config.maxSelectNum));
                        } else if (zIsMimeTypeSame || size == 0) {
                            selectedImages.add(0, localMedia);
                            this.mAdapter.bindSelectImages(selectedImages);
                        }
                    } else if (size >= i2) {
                        ToastUtils.s(getContext(), StringUtils.getMsg(getContext(), mimeType3, this.config.maxVideoSelectNum));
                    } else if ((zIsMimeTypeSame || size == 0) && selectedImages.size() < this.config.maxVideoSelectNum) {
                        selectedImages.add(0, localMedia);
                        this.mAdapter.bindSelectImages(selectedImages);
                    }
                } else if (pictureSelectionConfig2.isSingleDirectReturn) {
                    List<LocalMedia> selectedImages2 = this.mAdapter.getSelectedImages();
                    selectedImages2.add(localMedia);
                    this.mAdapter.bindSelectImages(selectedImages2);
                    singleDirectReturnCameraHandleResult(mimeType);
                } else {
                    List<LocalMedia> selectedImages3 = this.mAdapter.getSelectedImages();
                    if (PictureMimeType.isMimeTypeSame(selectedImages3.size() > 0 ? selectedImages3.get(0).getMimeType() : "", localMedia.getMimeType()) || selectedImages3.size() == 0) {
                        singleRadioMediaImage();
                        selectedImages3.add(localMedia);
                        this.mAdapter.bindSelectImages(selectedImages3);
                    }
                }
            }
            this.mAdapter.notifyItemInserted(this.config.isCamera ? 1 : 0);
            this.mAdapter.notifyItemRangeChanged(this.config.isCamera ? 1 : 0, this.images.size());
            manualSaveFolder(localMedia);
            if (!zCheckedAndroid_Q && PictureMimeType.eqImage(localMedia.getMimeType()) && (lastImageId = MediaUtils.getLastImageId(getContext(), localMedia.getMimeType())) != -1) {
                MediaUtils.removeMedia(getContext(), lastImageId);
            }
            this.mTvEmpty.setVisibility((this.images.size() > 0 || this.config.isSingleDirectReturn) ? 4 : 0);
        }
    }

    private void separateMimeTypeWith(boolean z, List<LocalMedia> list) throws Resources.NotFoundException {
        LocalMedia localMedia = list.size() > 0 ? list.get(0) : null;
        if (localMedia == null) {
            return;
        }
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (!pictureSelectionConfig.enableCrop || !z) {
            if (this.config.isCompress && z) {
                compressImage(list);
                return;
            } else {
                onResult(list);
                return;
            }
        }
        if (pictureSelectionConfig.selectionMode == 1) {
            pictureSelectionConfig.originalPath = localMedia.getPath();
            startCrop(this.config.originalPath, localMedia.getMimeType());
            return;
        }
        ArrayList<CutInfo> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            LocalMedia localMedia2 = list.get(i2);
            if (localMedia2 != null && !TextUtils.isEmpty(localMedia2.getPath())) {
                CutInfo cutInfo = new CutInfo();
                cutInfo.setId(localMedia2.getId());
                cutInfo.setPath(localMedia2.getPath());
                cutInfo.setImageWidth(localMedia2.getWidth());
                cutInfo.setImageHeight(localMedia2.getHeight());
                cutInfo.setMimeType(localMedia2.getMimeType());
                cutInfo.setDuration(localMedia2.getDuration());
                cutInfo.setRealPath(localMedia2.getRealPath());
                arrayList.add(cutInfo);
            }
        }
        startCrop(arrayList);
    }

    private void singleCropHandleResult(Intent intent) {
        Uri output;
        if (intent == null || (output = UCrop.getOutput(intent)) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        String path = output.getPath();
        if (this.mAdapter != null) {
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(PictureConfig.EXTRA_SELECT_LIST);
            if (parcelableArrayListExtra != null) {
                this.mAdapter.bindSelectImages(parcelableArrayListExtra);
                this.mAdapter.notifyDataSetChanged();
            }
            List<LocalMedia> selectedImages = this.mAdapter.getSelectedImages();
            LocalMedia localMedia = null;
            LocalMedia localMedia2 = (selectedImages == null || selectedImages.size() <= 0) ? null : selectedImages.get(0);
            if (localMedia2 != null) {
                this.config.originalPath = localMedia2.getPath();
                localMedia2.setCutPath(path);
                localMedia2.setChooseModel(this.config.chooseMode);
                if (TextUtils.isEmpty(path)) {
                    if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isContent(localMedia2.getPath())) {
                        String path2 = PictureFileUtils.getPath(this, Uri.parse(localMedia2.getPath()));
                        localMedia2.setSize(TextUtils.isEmpty(path2) ? 0L : new File(path2).length());
                    } else {
                        localMedia2.setSize(new File(localMedia2.getPath()).length());
                    }
                    localMedia2.setCut(false);
                } else {
                    localMedia2.setSize(new File(path).length());
                    localMedia2.setAndroidQToPath(path);
                    localMedia2.setCut(true);
                }
                arrayList.add(localMedia2);
                handlerResult(arrayList);
                return;
            }
            if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() > 0) {
                localMedia = (LocalMedia) parcelableArrayListExtra.get(0);
            }
            if (localMedia != null) {
                this.config.originalPath = localMedia.getPath();
                localMedia.setCutPath(path);
                localMedia.setChooseModel(this.config.chooseMode);
                localMedia.setSize(new File(TextUtils.isEmpty(path) ? localMedia.getPath() : path).length());
                if (TextUtils.isEmpty(path)) {
                    if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isContent(localMedia.getPath())) {
                        String path3 = PictureFileUtils.getPath(this, Uri.parse(localMedia.getPath()));
                        localMedia.setSize(TextUtils.isEmpty(path3) ? 0L : new File(path3).length());
                    } else {
                        localMedia.setSize(new File(localMedia.getPath()).length());
                    }
                    localMedia.setCut(false);
                } else {
                    localMedia.setSize(new File(path).length());
                    localMedia.setAndroidQToPath(path);
                    localMedia.setCut(true);
                }
                arrayList.add(localMedia);
                handlerResult(arrayList);
            }
        }
    }

    private void singleDirectReturnCameraHandleResult(String str) {
        boolean zEqImage = PictureMimeType.eqImage(str);
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.enableCrop && zEqImage) {
            String str2 = pictureSelectionConfig.cameraPath;
            pictureSelectionConfig.originalPath = str2;
            startCrop(str2, str);
        } else if (this.config.isCompress && zEqImage) {
            compressImage(this.mAdapter.getSelectedImages());
        } else {
            onResult(this.mAdapter.getSelectedImages());
        }
    }

    private void singleRadioMediaImage() {
        List<LocalMedia> selectedImages = this.mAdapter.getSelectedImages();
        if (selectedImages == null || selectedImages.size() <= 0) {
            return;
        }
        int position = selectedImages.get(0).getPosition();
        selectedImages.clear();
        this.mAdapter.notifyItemChanged(position);
    }

    private void startCustomCamera() {
        int i2;
        if (!PermissionChecker.checkSelfPermission(this, util.permissionutil.a.f20915i)) {
            PermissionChecker.requestPermissions(this, new String[]{util.permissionutil.a.f20915i}, 4);
            return;
        }
        startActivityForResult(new Intent(this, (Class<?>) PictureCustomCameraActivity.class), PictureConfig.REQUEST_CAMERA);
        PictureWindowAnimationStyle pictureWindowAnimationStyle = this.config.windowAnimationStyle;
        if (pictureWindowAnimationStyle == null || (i2 = pictureWindowAnimationStyle.activityEnterAnimation) == 0) {
            i2 = R.anim.picture_anim_enter;
        }
        overridePendingTransition(i2, R.anim.picture_anim_fade_in);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMediaFolder(List<LocalMediaFolder> list, LocalMedia localMedia) {
        File parentFile = new File(PictureMimeType.isContent(localMedia.getPath()) ? (String) Objects.requireNonNull(PictureFileUtils.getPath(getContext(), Uri.parse(localMedia.getPath()))) : localMedia.getPath()).getParentFile();
        if (parentFile == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            LocalMediaFolder localMediaFolder = list.get(i2);
            String name = localMediaFolder.getName();
            if (!TextUtils.isEmpty(name) && name.equals(parentFile.getName())) {
                localMediaFolder.setFirstImagePath(this.config.cameraPath);
                localMediaFolder.setImageNum(localMediaFolder.getImageNum() + 1);
                localMediaFolder.setCheckedNum(1);
                localMediaFolder.getImages().add(0, localMedia);
                return;
            }
        }
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        this.config.isCheckOriginalImage = z;
    }

    protected void changeImageNumber(List<LocalMedia> list) {
        if (!(list.size() != 0)) {
            this.mTvPictureOk.setEnabled(this.config.returnEmpty);
            this.mTvPictureOk.setSelected(false);
            this.mTvPicturePreview.setEnabled(false);
            this.mTvPicturePreview.setSelected(false);
            PictureParameterStyle pictureParameterStyle = this.config.style;
            if (pictureParameterStyle != null) {
                int i2 = pictureParameterStyle.pictureUnCompleteTextColor;
                if (i2 != 0) {
                    this.mTvPictureOk.setTextColor(i2);
                }
                int i3 = this.config.style.pictureUnPreviewTextColor;
                if (i3 != 0) {
                    this.mTvPicturePreview.setTextColor(i3);
                }
            }
            PictureParameterStyle pictureParameterStyle2 = this.config.style;
            if (pictureParameterStyle2 == null || TextUtils.isEmpty(pictureParameterStyle2.pictureUnPreviewText)) {
                this.mTvPicturePreview.setText(getString(R.string.picture_preview));
            } else {
                this.mTvPicturePreview.setText(this.config.style.pictureUnPreviewText);
            }
            if (this.numComplete) {
                initCompleteText(list.size());
                return;
            }
            this.mTvPictureImgNum.setVisibility(4);
            PictureParameterStyle pictureParameterStyle3 = this.config.style;
            if (pictureParameterStyle3 == null || TextUtils.isEmpty(pictureParameterStyle3.pictureUnCompleteText)) {
                this.mTvPictureOk.setText(getString(R.string.picture_please_select));
                return;
            } else {
                this.mTvPictureOk.setText(this.config.style.pictureUnCompleteText);
                return;
            }
        }
        this.mTvPictureOk.setEnabled(true);
        this.mTvPictureOk.setSelected(true);
        this.mTvPicturePreview.setEnabled(true);
        this.mTvPicturePreview.setSelected(true);
        PictureParameterStyle pictureParameterStyle4 = this.config.style;
        if (pictureParameterStyle4 != null) {
            int i4 = pictureParameterStyle4.pictureCompleteTextColor;
            if (i4 != 0) {
                this.mTvPictureOk.setTextColor(i4);
            }
            int i5 = this.config.style.picturePreviewTextColor;
            if (i5 != 0) {
                this.mTvPicturePreview.setTextColor(i5);
            }
        }
        PictureParameterStyle pictureParameterStyle5 = this.config.style;
        if (pictureParameterStyle5 == null || TextUtils.isEmpty(pictureParameterStyle5.picturePreviewText)) {
            this.mTvPicturePreview.setText(getString(R.string.picture_preview_num, new Object[]{Integer.valueOf(list.size())}));
        } else {
            this.mTvPicturePreview.setText(this.config.style.picturePreviewText);
        }
        if (this.numComplete) {
            initCompleteText(list.size());
            return;
        }
        if (!this.isStartAnimation) {
            this.mTvPictureImgNum.startAnimation(this.animation);
        }
        this.mTvPictureImgNum.setVisibility(0);
        this.mTvPictureImgNum.setText(String.valueOf(list.size()));
        PictureParameterStyle pictureParameterStyle6 = this.config.style;
        if (pictureParameterStyle6 == null || TextUtils.isEmpty(pictureParameterStyle6.pictureCompleteText)) {
            this.mTvPictureOk.setText(getString(R.string.picture_completed));
        } else {
            this.mTvPictureOk.setText(this.config.style.pictureCompleteText);
        }
        this.isStartAnimation = false;
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    public int getResourceId() {
        return R.layout.picture_selector;
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    protected void initCompleteText(int i2) {
        String string;
        boolean z = this.config.style != null;
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.selectionMode == 1) {
            if (i2 <= 0) {
                this.mTvPictureOk.setText((!z || TextUtils.isEmpty(pictureSelectionConfig.style.pictureUnCompleteText)) ? getString(R.string.picture_please_select) : this.config.style.pictureUnCompleteText);
                return;
            }
            if (!(z && pictureSelectionConfig.style.isCompleteReplaceNum) || TextUtils.isEmpty(this.config.style.pictureCompleteText)) {
                this.mTvPictureOk.setText((!z || TextUtils.isEmpty(this.config.style.pictureCompleteText)) ? getString(R.string.picture_done) : this.config.style.pictureCompleteText);
                return;
            } else {
                this.mTvPictureOk.setText(String.format(this.config.style.pictureCompleteText, Integer.valueOf(i2), 1));
                return;
            }
        }
        boolean z2 = z && pictureSelectionConfig.style.isCompleteReplaceNum;
        if (i2 <= 0) {
            TextView textView = this.mTvPictureOk;
            if (!z || TextUtils.isEmpty(this.config.style.pictureUnCompleteText)) {
                int i3 = R.string.picture_done_front_num;
                PictureSelectionConfig pictureSelectionConfig2 = this.config;
                string = getString(i3, new Object[]{Integer.valueOf(i2), Integer.valueOf(pictureSelectionConfig2.maxVideoSelectNum + pictureSelectionConfig2.maxSelectNum)});
            } else {
                string = this.config.style.pictureUnCompleteText;
            }
            textView.setText(string);
            return;
        }
        if (!z2 || TextUtils.isEmpty(this.config.style.pictureCompleteText)) {
            TextView textView2 = this.mTvPictureOk;
            int i4 = R.string.picture_done_front_num;
            PictureSelectionConfig pictureSelectionConfig3 = this.config;
            textView2.setText(getString(i4, new Object[]{Integer.valueOf(i2), Integer.valueOf(pictureSelectionConfig3.maxVideoSelectNum + pictureSelectionConfig3.maxSelectNum)}));
            return;
        }
        TextView textView3 = this.mTvPictureOk;
        String str = this.config.style.pictureCompleteText;
        PictureSelectionConfig pictureSelectionConfig4 = this.config;
        textView3.setText(String.format(str, Integer.valueOf(i2), Integer.valueOf(pictureSelectionConfig4.maxVideoSelectNum + pictureSelectionConfig4.maxSelectNum)));
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    public void initPictureSelectorStyle() throws Resources.NotFoundException {
        PictureSelectionConfig pictureSelectionConfig = this.config;
        PictureParameterStyle pictureParameterStyle = pictureSelectionConfig.style;
        if (pictureParameterStyle != null) {
            int i2 = pictureParameterStyle.pictureTitleDownResId;
            if (i2 != 0) {
                this.mIvArrow.setImageDrawable(ContextCompat.getDrawable(this, i2));
            }
            int i3 = this.config.style.pictureTitleTextColor;
            if (i3 != 0) {
                this.mTvPictureTitle.setTextColor(i3);
            }
            int i4 = this.config.style.pictureTitleTextSize;
            if (i4 != 0) {
                this.mTvPictureTitle.setTextSize(i4);
            }
            PictureParameterStyle pictureParameterStyle2 = this.config.style;
            int i5 = pictureParameterStyle2.pictureRightDefaultTextColor;
            if (i5 != 0) {
                this.mTvPictureRight.setTextColor(i5);
            } else {
                int i6 = pictureParameterStyle2.pictureCancelTextColor;
                if (i6 != 0) {
                    this.mTvPictureRight.setTextColor(i6);
                }
            }
            int i7 = this.config.style.pictureRightTextSize;
            if (i7 != 0) {
                this.mTvPictureRight.setTextSize(i7);
            }
            int i8 = this.config.style.pictureLeftBackIcon;
            if (i8 != 0) {
                this.mIvPictureLeftBack.setImageResource(i8);
            }
            int i9 = this.config.style.pictureUnPreviewTextColor;
            if (i9 != 0) {
                this.mTvPicturePreview.setTextColor(i9);
            }
            int i10 = this.config.style.picturePreviewTextSize;
            if (i10 != 0) {
                this.mTvPicturePreview.setTextSize(i10);
            }
            int i11 = this.config.style.pictureCheckNumBgStyle;
            if (i11 != 0) {
                this.mTvPictureImgNum.setBackgroundResource(i11);
            }
            int i12 = this.config.style.pictureUnCompleteTextColor;
            if (i12 != 0) {
                this.mTvPictureOk.setTextColor(i12);
            }
            int i13 = this.config.style.pictureCompleteTextSize;
            if (i13 != 0) {
                this.mTvPictureOk.setTextSize(i13);
            }
            int i14 = this.config.style.pictureBottomBgColor;
            if (i14 != 0) {
                this.mBottomLayout.setBackgroundColor(i14);
            }
            int i15 = this.config.style.pictureContainerBackgroundColor;
            if (i15 != 0) {
                this.container.setBackgroundColor(i15);
            }
            if (!TextUtils.isEmpty(this.config.style.pictureRightDefaultText)) {
                this.mTvPictureRight.setText(this.config.style.pictureRightDefaultText);
            }
            if (!TextUtils.isEmpty(this.config.style.pictureUnCompleteText)) {
                this.mTvPictureOk.setText(this.config.style.pictureUnCompleteText);
            }
            if (!TextUtils.isEmpty(this.config.style.pictureUnPreviewText)) {
                this.mTvPicturePreview.setText(this.config.style.pictureUnPreviewText);
            }
        } else {
            int i16 = pictureSelectionConfig.downResId;
            if (i16 != 0) {
                this.mIvArrow.setImageDrawable(ContextCompat.getDrawable(this, i16));
            }
            int typeValueColor = AttrsUtils.getTypeValueColor(getContext(), R.attr.picture_bottom_bg);
            if (typeValueColor != 0) {
                this.mBottomLayout.setBackgroundColor(typeValueColor);
            }
        }
        this.titleViewBg.setBackgroundColor(this.colorPrimary);
        PictureSelectionConfig pictureSelectionConfig2 = this.config;
        if (pictureSelectionConfig2.isOriginalControl) {
            PictureParameterStyle pictureParameterStyle3 = pictureSelectionConfig2.style;
            if (pictureParameterStyle3 != null) {
                int i17 = pictureParameterStyle3.pictureOriginalControlStyle;
                if (i17 != 0) {
                    this.mCbOriginal.setButtonDrawable(i17);
                } else {
                    this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable(this, R.drawable.picture_original_checkbox));
                }
                int i18 = this.config.style.pictureOriginalFontColor;
                if (i18 != 0) {
                    this.mCbOriginal.setTextColor(i18);
                } else {
                    this.mCbOriginal.setTextColor(ContextCompat.getColor(this, R.color.picture_color_53575e));
                }
                int i19 = this.config.style.pictureOriginalTextSize;
                if (i19 != 0) {
                    this.mCbOriginal.setTextSize(i19);
                }
            } else {
                this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable(this, R.drawable.picture_original_checkbox));
                this.mCbOriginal.setTextColor(ContextCompat.getColor(this, R.color.picture_color_53575e));
            }
        }
        this.mAdapter.bindSelectImages(this.selectionMedias);
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    protected void initWidgets() {
        super.initWidgets();
        this.container = findViewById(R.id.container);
        this.titleViewBg = findViewById(R.id.titleViewBg);
        this.mIvPictureLeftBack = (ImageView) findViewById(R.id.picture_left_back);
        this.mTvPictureTitle = (TextView) findViewById(R.id.picture_title);
        this.mTvPictureRight = (TextView) findViewById(R.id.picture_right);
        this.mTvPictureOk = (TextView) findViewById(R.id.picture_tv_ok);
        this.mCbOriginal = (CheckBox) findViewById(R.id.cb_original);
        this.mIvArrow = (ImageView) findViewById(R.id.ivArrow);
        this.mTvPicturePreview = (TextView) findViewById(R.id.picture_id_preview);
        this.mTvPictureImgNum = (TextView) findViewById(R.id.picture_tv_img_num);
        this.mPictureRecycler = (RecyclerView) findViewById(R.id.picture_recycler);
        this.mBottomLayout = (RelativeLayout) findViewById(R.id.rl_bottom);
        this.mTvEmpty = (TextView) findViewById(R.id.tv_empty);
        isNumComplete(this.numComplete);
        if (!this.numComplete) {
            this.animation = AnimationUtils.loadAnimation(this, R.anim.picture_anim_modal_in);
        }
        this.mTvPicturePreview.setOnClickListener(this);
        this.mTvPicturePreview.setVisibility((this.config.chooseMode == PictureMimeType.ofAudio() || !this.config.enablePreview) ? 8 : 0);
        RelativeLayout relativeLayout = this.mBottomLayout;
        PictureSelectionConfig pictureSelectionConfig = this.config;
        relativeLayout.setVisibility((pictureSelectionConfig.selectionMode == 1 && pictureSelectionConfig.isSingleDirectReturn) ? 8 : 0);
        this.mIvPictureLeftBack.setOnClickListener(this);
        this.mTvPictureRight.setOnClickListener(this);
        this.mTvPictureOk.setOnClickListener(this);
        this.mTvPictureImgNum.setOnClickListener(this);
        this.mTvPictureTitle.setOnClickListener(this);
        this.mIvArrow.setOnClickListener(this);
        this.mTvPictureTitle.setText(getString(this.config.chooseMode == PictureMimeType.ofAudio() ? R.string.picture_all_audio : R.string.picture_camera_roll));
        this.folderWindow = new FolderPopWindow(this, this.config);
        this.folderWindow.setArrowImageView(this.mIvArrow);
        this.folderWindow.setOnAlbumItemClickListener(this);
        this.mPictureRecycler.setHasFixedSize(true);
        this.mPictureRecycler.addItemDecoration(new GridSpacingItemDecoration(this.config.imageSpanCount, ScreenUtils.dip2px(this, 2.0f), false));
        this.mPictureRecycler.setLayoutManager(new GridLayoutManager(getContext(), this.config.imageSpanCount));
        RecyclerView.ItemAnimator itemAnimator = this.mPictureRecycler.getItemAnimator();
        if (itemAnimator != null) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        }
        if (this.config.isFallbackVersion2 || Build.VERSION.SDK_INT <= 19) {
            loadAllMediaData();
        }
        this.mTvEmpty.setText(this.config.chooseMode == PictureMimeType.ofAudio() ? getString(R.string.picture_audio_empty) : getString(R.string.picture_empty));
        StringUtils.tempTextFont(this.mTvEmpty, this.config.chooseMode);
        this.mAdapter = new PictureImageGridAdapter(getContext(), this.config);
        this.mAdapter.setOnPhotoSelectChangedListener(this);
        this.mPictureRecycler.setAdapter(this.mAdapter);
        if (this.config.isOriginalControl) {
            this.mCbOriginal.setVisibility(0);
            this.mCbOriginal.setChecked(this.config.isCheckOriginalImage);
            this.mCbOriginal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.luck.picture.lib.s
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    this.f7817a.a(compoundButton, z);
                }
            });
        }
    }

    protected void multiCropHandleResult(Intent intent) {
        List<CutInfo> multipleOutput;
        if (intent == null || (multipleOutput = UCrop.getMultipleOutput(intent)) == null || multipleOutput.size() == 0) {
            return;
        }
        int size = multipleOutput.size();
        boolean zCheckedAndroid_Q = SdkVersionUtils.checkedAndroid_Q();
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(PictureConfig.EXTRA_SELECT_LIST);
        if (parcelableArrayListExtra != null) {
            this.mAdapter.bindSelectImages(parcelableArrayListExtra);
            this.mAdapter.notifyDataSetChanged();
        }
        PictureImageGridAdapter pictureImageGridAdapter = this.mAdapter;
        int i2 = 0;
        if ((pictureImageGridAdapter != null ? pictureImageGridAdapter.getSelectedImages().size() : 0) == size) {
            List<LocalMedia> selectedImages = this.mAdapter.getSelectedImages();
            while (i2 < size) {
                CutInfo cutInfo = multipleOutput.get(i2);
                LocalMedia localMedia = selectedImages.get(i2);
                localMedia.setCut(!TextUtils.isEmpty(cutInfo.getCutPath()));
                localMedia.setPath(cutInfo.getPath());
                localMedia.setMimeType(cutInfo.getMimeType());
                localMedia.setCutPath(cutInfo.getCutPath());
                localMedia.setWidth(cutInfo.getImageWidth());
                localMedia.setHeight(cutInfo.getImageHeight());
                localMedia.setAndroidQToPath(zCheckedAndroid_Q ? cutInfo.getCutPath() : localMedia.getAndroidQToPath());
                localMedia.setSize(!TextUtils.isEmpty(cutInfo.getCutPath()) ? new File(cutInfo.getCutPath()).length() : localMedia.getSize());
                i2++;
            }
            handlerResult(selectedImages);
            return;
        }
        ArrayList arrayList = new ArrayList();
        while (i2 < size) {
            CutInfo cutInfo2 = multipleOutput.get(i2);
            LocalMedia localMedia2 = new LocalMedia();
            localMedia2.setId(cutInfo2.getId());
            localMedia2.setCut(!TextUtils.isEmpty(cutInfo2.getCutPath()));
            localMedia2.setPath(cutInfo2.getPath());
            localMedia2.setCutPath(cutInfo2.getCutPath());
            localMedia2.setMimeType(cutInfo2.getMimeType());
            localMedia2.setWidth(cutInfo2.getImageWidth());
            localMedia2.setHeight(cutInfo2.getImageHeight());
            localMedia2.setDuration(cutInfo2.getDuration());
            localMedia2.setChooseModel(this.config.chooseMode);
            localMedia2.setAndroidQToPath(zCheckedAndroid_Q ? cutInfo2.getCutPath() : cutInfo2.getAndroidQToPath());
            if (!TextUtils.isEmpty(cutInfo2.getCutPath())) {
                localMedia2.setSize(new File(cutInfo2.getCutPath()).length());
            } else if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isContent(cutInfo2.getPath())) {
                String path = PictureFileUtils.getPath(this, Uri.parse(cutInfo2.getPath()));
                localMedia2.setSize(!TextUtils.isEmpty(path) ? new File(path).length() : 0L);
            } else {
                localMedia2.setSize(new File(cutInfo2.getPath()).length());
            }
            arrayList.add(localMedia2);
            i2++;
        }
        handlerResult(arrayList);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) throws Throwable {
        Throwable th;
        ArrayList parcelableArrayListExtra;
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            if (i3 == 0) {
                previewCallback(intent);
                return;
            } else {
                if (i3 != 96 || intent == null || (th = (Throwable) intent.getSerializableExtra(UCrop.EXTRA_ERROR)) == null) {
                    return;
                }
                ToastUtils.s(getContext(), th.getMessage());
                return;
            }
        }
        if (i2 == 69) {
            singleCropHandleResult(intent);
            return;
        }
        if (i2 == 166) {
            if (intent == null || (parcelableArrayListExtra = intent.getParcelableArrayListExtra(PictureConfig.EXTRA_SELECT_LIST)) == null || parcelableArrayListExtra.size() <= 0) {
                return;
            }
            onResult(parcelableArrayListExtra);
            return;
        }
        if (i2 == 609) {
            multiCropHandleResult(intent);
        } else {
            if (i2 != 909) {
                return;
            }
            requestCamera(intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void a() {
        OnResultCallbackListener onResultCallbackListener;
        super.a();
        if (this.config != null && (onResultCallbackListener = PictureSelectionConfig.listener) != null) {
            onResultCallbackListener.onCancel();
        }
        closeActivity();
    }

    @Override // com.luck.picture.lib.listener.OnPhotoSelectChangedListener
    public void onChange(List<LocalMedia> list) {
        changeImageNumber(list);
    }

    protected void onChangeData(List<LocalMedia> list) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        int id = view.getId();
        if (id == R.id.picture_left_back || id == R.id.picture_right) {
            FolderPopWindow folderPopWindow = this.folderWindow;
            if (folderPopWindow == null || !folderPopWindow.isShowing()) {
                a();
            } else {
                this.folderWindow.dismiss();
            }
        }
        if (id == R.id.picture_title || id == R.id.ivArrow) {
            if (this.folderWindow.isShowing()) {
                this.folderWindow.dismiss();
            } else {
                List<LocalMedia> list = this.images;
                if (list != null && list.size() > 0) {
                    this.folderWindow.showAsDropDown(this.titleViewBg);
                    if (!this.config.isSingleDirectReturn) {
                        this.folderWindow.updateFolderCheckStatus(this.mAdapter.getSelectedImages());
                    }
                }
            }
        }
        if (id == R.id.picture_id_preview) {
            onPreview();
        }
        if (id == R.id.picture_tv_ok || id == R.id.picture_tv_img_num) {
            onComplete();
        }
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.oldCurrentListSize = bundle.getInt(PictureConfig.EXTRA_OLD_CURRENT_LIST_SIZE, 0);
            this.selectionMedias = PictureSelector.obtainSelectorList(bundle);
            PictureImageGridAdapter pictureImageGridAdapter = this.mAdapter;
            if (pictureImageGridAdapter != null) {
                this.isStartAnimation = true;
                pictureImageGridAdapter.bindSelectImages(this.selectionMedias);
            }
        }
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        Handler handler;
        super.onDestroy();
        Animation animation = this.animation;
        if (animation != null) {
            animation.cancel();
            this.animation = null;
        }
        if (this.mediaPlayer == null || (handler = this.mHandler) == null) {
            return;
        }
        handler.removeCallbacks(this.mRunnable);
        this.mediaPlayer.release();
        this.mediaPlayer = null;
    }

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        if (Build.VERSION.SDK_INT <= 19 || this.config.isFallbackVersion2 || this.isFirstEnterActivity) {
            return;
        }
        loadAllMediaData();
        this.isFirstEnterActivity = true;
    }

    @Override // com.luck.picture.lib.listener.OnAlbumItemClickListener
    public void onItemClick(boolean z, String str, List<LocalMedia> list) {
        this.mAdapter.setShowCamera(this.config.isCamera && z);
        this.mTvPictureTitle.setText(str);
        this.folderWindow.dismiss();
        this.mAdapter.bindImagesData(list);
        this.mPictureRecycler.smoothScrollToPosition(0);
    }

    @Override // com.luck.picture.lib.listener.OnPhotoSelectChangedListener
    public void onPictureClick(LocalMedia localMedia, int i2) {
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.selectionMode != 1 || !pictureSelectionConfig.isSingleDirectReturn) {
            startPreview(this.mAdapter.getImages(), i2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(localMedia);
        if (!this.config.enableCrop || !PictureMimeType.eqImage(localMedia.getMimeType()) || this.config.isCheckOriginalImage) {
            handlerResult(arrayList);
        } else {
            this.mAdapter.bindSelectImages(arrayList);
            startCrop(localMedia.getPath(), localMedia.getMimeType());
        }
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 1) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                showPermissionsDialog(false, getString(R.string.picture_jurisdiction));
                return;
            } else {
                readLocalMedia();
                return;
            }
        }
        if (i2 == 2) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                showPermissionsDialog(true, getString(R.string.picture_camera));
                return;
            } else {
                onTakePhoto();
                return;
            }
        }
        if (i2 == 4) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                showPermissionsDialog(false, getString(R.string.picture_audio));
                return;
            } else {
                startCustomCamera();
                return;
            }
        }
        if (i2 != 5) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            showPermissionsDialog(false, getString(R.string.picture_jurisdiction));
        } else {
            startCamera();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        CheckBox checkBox;
        super.onResume();
        if (this.isEnterSetting) {
            if (!PermissionChecker.checkSelfPermission(this, util.permissionutil.a.z) || !PermissionChecker.checkSelfPermission(this, util.permissionutil.a.A)) {
                showPermissionsDialog(false, getString(R.string.picture_jurisdiction));
            } else if (this.mAdapter.isDataEmpty()) {
                readLocalMedia();
            }
            this.isEnterSetting = false;
        }
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (!pictureSelectionConfig.isOriginalControl || (checkBox = this.mCbOriginal) == null) {
            return;
        }
        checkBox.setChecked(pictureSelectionConfig.isCheckOriginalImage);
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        List<LocalMedia> list = this.images;
        if (list != null) {
            bundle.putInt(PictureConfig.EXTRA_OLD_CURRENT_LIST_SIZE, list.size());
        }
        PictureImageGridAdapter pictureImageGridAdapter = this.mAdapter;
        if (pictureImageGridAdapter == null || pictureImageGridAdapter.getSelectedImages() == null) {
            return;
        }
        PictureSelector.saveSelectorList(bundle, this.mAdapter.getSelectedImages());
    }

    @Override // com.luck.picture.lib.listener.OnPhotoSelectChangedListener
    public void onTakePhoto() {
        if (!PermissionChecker.checkSelfPermission(this, util.permissionutil.a.f20909c)) {
            PermissionChecker.requestPermissions(this, new String[]{util.permissionutil.a.f20909c}, 2);
        } else if (PermissionChecker.checkSelfPermission(this, util.permissionutil.a.z) && PermissionChecker.checkSelfPermission(this, util.permissionutil.a.A)) {
            startCamera();
        } else {
            PermissionChecker.requestPermissions(this, new String[]{util.permissionutil.a.z, util.permissionutil.a.A}, 5);
        }
    }

    public void playOrPause() throws IllegalStateException {
        try {
            if (this.mediaPlayer != null) {
                if (this.mediaPlayer.isPlaying()) {
                    this.mediaPlayer.pause();
                } else {
                    this.mediaPlayer.start();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected void readLocalMedia() {
        showPleaseDialog();
        PictureThreadUtils.executeByCached(new PictureThreadUtils.SimpleTask<List<LocalMediaFolder>>() { // from class: com.luck.picture.lib.PictureSelectorActivity.1
            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public List<LocalMediaFolder> doInBackground() {
                return new LocalMediaLoader(PictureSelectorActivity.this.getContext(), PictureSelectorActivity.this.config).loadAllMedia();
            }

            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public void onSuccess(List<LocalMediaFolder> list) {
                PictureSelectorActivity.this.dismissDialog();
                PictureThreadUtils.cancel(PictureThreadUtils.getCachedPool());
                if (list == null) {
                    PictureSelectorActivity.this.mTvEmpty.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.drawable.picture_icon_data_error, 0, 0);
                    PictureSelectorActivity pictureSelectorActivity = PictureSelectorActivity.this;
                    pictureSelectorActivity.mTvEmpty.setText(pictureSelectorActivity.getString(R.string.picture_data_exception));
                    PictureSelectorActivity pictureSelectorActivity2 = PictureSelectorActivity.this;
                    pictureSelectorActivity2.mTvEmpty.setVisibility(pictureSelectorActivity2.images.size() <= 0 ? 0 : 4);
                    return;
                }
                if (list.size() > 0) {
                    PictureSelectorActivity.this.foldersList = list;
                    LocalMediaFolder localMediaFolder = list.get(0);
                    localMediaFolder.setChecked(true);
                    List<LocalMedia> images = localMediaFolder.getImages();
                    PictureSelectorActivity pictureSelectorActivity3 = PictureSelectorActivity.this;
                    if (pictureSelectorActivity3.images == null) {
                        pictureSelectorActivity3.images = new ArrayList();
                    }
                    int size = PictureSelectorActivity.this.images.size();
                    int size2 = images.size();
                    PictureSelectorActivity pictureSelectorActivity4 = PictureSelectorActivity.this;
                    pictureSelectorActivity4.oldCurrentListSize += size;
                    if (size2 >= size) {
                        if (size <= 0 || size >= size2 || pictureSelectorActivity4.oldCurrentListSize == size2) {
                            PictureSelectorActivity.this.images = images;
                        } else {
                            pictureSelectorActivity4.images.addAll(images);
                            LocalMedia localMedia = PictureSelectorActivity.this.images.get(0);
                            localMediaFolder.setFirstImagePath(localMedia.getPath());
                            localMediaFolder.getImages().add(0, localMedia);
                            localMediaFolder.setCheckedNum(1);
                            localMediaFolder.setImageNum(localMediaFolder.getImageNum() + 1);
                            PictureSelectorActivity pictureSelectorActivity5 = PictureSelectorActivity.this;
                            pictureSelectorActivity5.updateMediaFolder(pictureSelectorActivity5.foldersList, localMedia);
                        }
                        PictureSelectorActivity.this.folderWindow.bindFolder(list);
                    }
                }
                PictureSelectorActivity pictureSelectorActivity6 = PictureSelectorActivity.this;
                PictureImageGridAdapter pictureImageGridAdapter = pictureSelectorActivity6.mAdapter;
                if (pictureImageGridAdapter != null) {
                    pictureImageGridAdapter.bindImagesData(pictureSelectorActivity6.images);
                    boolean z = PictureSelectorActivity.this.images.size() > 0;
                    if (!z) {
                        PictureSelectorActivity pictureSelectorActivity7 = PictureSelectorActivity.this;
                        pictureSelectorActivity7.mTvEmpty.setText(pictureSelectorActivity7.getString(R.string.picture_empty));
                        PictureSelectorActivity.this.mTvEmpty.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.drawable.picture_icon_no_data, 0, 0);
                    }
                    PictureSelectorActivity.this.mTvEmpty.setVisibility(z ? 4 : 0);
                }
            }
        });
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    protected void showPermissionsDialog(final boolean z, String str) {
        if (isFinishing()) {
            return;
        }
        final PictureCustomDialog pictureCustomDialog = new PictureCustomDialog(getContext(), R.layout.picture_wind_base_dialog);
        pictureCustomDialog.setCancelable(false);
        pictureCustomDialog.setCanceledOnTouchOutside(false);
        Button button = (Button) pictureCustomDialog.findViewById(R.id.btn_cancel);
        Button button2 = (Button) pictureCustomDialog.findViewById(R.id.btn_commit);
        button2.setText(getString(R.string.picture_go_setting));
        TextView textView = (TextView) pictureCustomDialog.findViewById(R.id.tv_title);
        TextView textView2 = (TextView) pictureCustomDialog.findViewById(R.id.tv_content);
        textView.setText(getString(R.string.picture_prompt));
        textView2.setText(str);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f7810a.a(pictureCustomDialog, z, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f7821a.a(pictureCustomDialog, view);
            }
        });
        pictureCustomDialog.show();
    }

    public void startCamera() {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        OnPictureSelectorInterfaceListener onPictureSelectorInterfaceListener = PictureSelectionConfig.onPictureSelectorInterfaceListener;
        if (onPictureSelectorInterfaceListener != null) {
            if (this.config.chooseMode == 0) {
                PhotoItemSelectedDialog photoItemSelectedDialogNewInstance = PhotoItemSelectedDialog.newInstance();
                photoItemSelectedDialogNewInstance.setOnItemClickListener(this);
                photoItemSelectedDialogNewInstance.show(getSupportFragmentManager(), "PhotoItemSelectedDialog");
                return;
            } else {
                Context context = getContext();
                PictureSelectionConfig pictureSelectionConfig = this.config;
                onPictureSelectorInterfaceListener.onCameraClick(context, pictureSelectionConfig, pictureSelectionConfig.chooseMode);
                PictureSelectionConfig pictureSelectionConfig2 = this.config;
                pictureSelectionConfig2.cameraMimeType = pictureSelectionConfig2.chooseMode;
                return;
            }
        }
        PictureSelectionConfig pictureSelectionConfig3 = this.config;
        if (pictureSelectionConfig3.isUseCustomCamera) {
            startCustomCamera();
            return;
        }
        int i2 = pictureSelectionConfig3.chooseMode;
        if (i2 == 0) {
            PhotoItemSelectedDialog photoItemSelectedDialogNewInstance2 = PhotoItemSelectedDialog.newInstance();
            photoItemSelectedDialogNewInstance2.setOnItemClickListener(this);
            photoItemSelectedDialogNewInstance2.show(getSupportFragmentManager(), "PhotoItemSelectedDialog");
        } else if (i2 == 1) {
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

    public void startPreview(List<LocalMedia> list, int i2) {
        int i3;
        LocalMedia localMedia = list.get(i2);
        String mimeType = localMedia.getMimeType();
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        if (PictureMimeType.eqVideo(mimeType)) {
            PictureSelectionConfig pictureSelectionConfig = this.config;
            if (pictureSelectionConfig.selectionMode == 1 && !pictureSelectionConfig.enPreviewVideo) {
                arrayList.add(localMedia);
                onResult(arrayList);
                return;
            }
            OnVideoSelectedPlayCallback onVideoSelectedPlayCallback = PictureSelectionConfig.customVideoPlayCallback;
            if (onVideoSelectedPlayCallback != null) {
                onVideoSelectedPlayCallback.startPlayVideo(localMedia);
                return;
            } else {
                bundle.putParcelable(PictureConfig.EXTRA_MEDIA_KEY, localMedia);
                JumpUtils.startPictureVideoPlayActivity(getContext(), bundle, PictureConfig.PREVIEW_VIDEO_CODE);
                return;
            }
        }
        if (PictureMimeType.eqAudio(mimeType)) {
            if (this.config.selectionMode != 1) {
                audioDialog(localMedia);
                return;
            } else {
                arrayList.add(localMedia);
                onResult(arrayList);
                return;
            }
        }
        List<LocalMedia> selectedImages = this.mAdapter.getSelectedImages();
        ImagesObservable.getInstance().savePreviewMediaData(new ArrayList(list));
        bundle.putParcelableArrayList(PictureConfig.EXTRA_SELECT_LIST, (ArrayList) selectedImages);
        bundle.putInt("position", i2);
        bundle.putBoolean(PictureConfig.EXTRA_CHANGE_ORIGINAL, this.config.isCheckOriginalImage);
        bundle.putBoolean(PictureConfig.EXTRA_SHOW_CAMERA, this.mAdapter.isShowCamera());
        bundle.putString(PictureConfig.EXTRA_IS_CURRENT_DIRECTORY, this.mTvPictureTitle.getText().toString());
        Context context = getContext();
        PictureSelectionConfig pictureSelectionConfig2 = this.config;
        JumpUtils.startPicturePreviewActivity(context, pictureSelectionConfig2.isWeChatStyle, bundle, pictureSelectionConfig2.selectionMode == 1 ? 69 : UCrop.REQUEST_MULTI_CROP);
        PictureWindowAnimationStyle pictureWindowAnimationStyle = this.config.windowAnimationStyle;
        if (pictureWindowAnimationStyle == null || (i3 = pictureWindowAnimationStyle.activityPreviewEnterAnimation) == 0) {
            i3 = R.anim.picture_anim_enter;
        }
        overridePendingTransition(i3, R.anim.picture_anim_fade_in);
    }

    /* renamed from: stop, reason: merged with bridge method [inline-methods] */
    public void b(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
                this.mediaPlayer.reset();
                this.mediaPlayer.setDataSource(str);
                this.mediaPlayer.prepare();
                this.mediaPlayer.seekTo(0);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public /* synthetic */ void a(final String str, DialogInterface dialogInterface) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mRunnable);
        }
        new Handler().postDelayed(new Runnable() { // from class: com.luck.picture.lib.q
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                this.f7813a.b(str);
            }
        }, 30L);
        try {
            if (this.audioDialog == null || !this.audioDialog.isShowing()) {
                return;
            }
            this.audioDialog.dismiss();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.luck.picture.lib.listener.OnItemClickListener
    public void onItemClick(View view, int i2) {
        if (i2 == 0) {
            OnPictureSelectorInterfaceListener onPictureSelectorInterfaceListener = PictureSelectionConfig.onPictureSelectorInterfaceListener;
            if (onPictureSelectorInterfaceListener != null) {
                onPictureSelectorInterfaceListener.onCameraClick(getContext(), this.config, 1);
                this.config.cameraMimeType = PictureMimeType.ofImage();
                return;
            }
            startOpenCamera();
            return;
        }
        if (i2 != 1) {
            return;
        }
        OnPictureSelectorInterfaceListener onPictureSelectorInterfaceListener2 = PictureSelectionConfig.onPictureSelectorInterfaceListener;
        if (onPictureSelectorInterfaceListener2 != null) {
            onPictureSelectorInterfaceListener2.onCameraClick(getContext(), this.config, 2);
            this.config.cameraMimeType = PictureMimeType.ofVideo();
            return;
        }
        startOpenCameraVideo();
    }

    public /* synthetic */ void a(PictureCustomDialog pictureCustomDialog, boolean z, View view) {
        if (!isFinishing()) {
            pictureCustomDialog.dismiss();
        }
        if (z) {
            return;
        }
        closeActivity();
    }

    public /* synthetic */ void a(PictureCustomDialog pictureCustomDialog, View view) {
        if (!isFinishing()) {
            pictureCustomDialog.dismiss();
        }
        PermissionChecker.launchAppDetailsSettings(getContext());
        this.isEnterSetting = true;
    }
}
