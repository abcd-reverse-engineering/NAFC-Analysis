package com.luck.picture.lib;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.core.view.ViewCompat;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.style.PictureParameterStyle;
import com.luck.picture.lib.style.PictureWindowAnimationStyle;
import com.luck.picture.lib.tools.SdkVersionUtils;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PictureVideoPlayActivity extends PictureBaseActivity implements MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, View.OnClickListener {
    private ImageButton ibLeftBack;
    private ImageView iv_play;
    private MediaController mMediaController;
    private int mPositionWhenPaused = -1;
    private VideoView mVideoView;
    private TextView tvConfirm;
    private String videoPath;

    public /* synthetic */ boolean a(MediaPlayer mediaPlayer, int i2, int i3) {
        if (i2 != 3) {
            return false;
        }
        this.mVideoView.setBackgroundColor(0);
        return true;
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(new ContextWrapper(context) { // from class: com.luck.picture.lib.PictureVideoPlayActivity.1
            @Override // android.content.ContextWrapper, android.content.Context
            public Object getSystemService(String str) {
                return "audio".equals(str) ? getApplicationContext().getSystemService(str) : super.getSystemService(str);
            }
        });
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    public int getResourceId() {
        return R.layout.picture_activity_video_play;
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    protected void initPictureSelectorStyle() {
        int i2;
        PictureParameterStyle pictureParameterStyle = this.config.style;
        if (pictureParameterStyle == null || (i2 = pictureParameterStyle.pictureLeftBackIcon) == 0) {
            return;
        }
        this.ibLeftBack.setImageResource(i2);
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    protected void initWidgets() {
        super.initWidgets();
        this.videoPath = getIntent().getStringExtra("videoPath");
        boolean booleanExtra = getIntent().getBooleanExtra(PictureConfig.EXTRA_PREVIEW_VIDEO, false);
        boolean booleanExtra2 = getIntent().getBooleanExtra(PictureConfig.EXTRA_PREVIEW_BTN, false);
        if (TextUtils.isEmpty(this.videoPath)) {
            LocalMedia localMedia = (LocalMedia) getIntent().getParcelableExtra(PictureConfig.EXTRA_MEDIA_KEY);
            if (localMedia == null || TextUtils.isEmpty(localMedia.getPath())) {
                finish();
                return;
            }
            this.videoPath = localMedia.getPath();
        }
        if (TextUtils.isEmpty(this.videoPath)) {
            closeActivity();
            return;
        }
        this.ibLeftBack = (ImageButton) findViewById(R.id.picture_left_back);
        this.mVideoView = (VideoView) findViewById(R.id.video_view);
        this.tvConfirm = (TextView) findViewById(R.id.tv_confirm);
        this.mVideoView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.iv_play = (ImageView) findViewById(R.id.iv_play);
        this.mMediaController = new MediaController(this);
        this.mVideoView.setOnCompletionListener(this);
        this.mVideoView.setOnPreparedListener(this);
        this.mVideoView.setMediaController(this.mMediaController);
        this.ibLeftBack.setOnClickListener(this);
        this.iv_play.setOnClickListener(this);
        this.tvConfirm.setOnClickListener(this);
        TextView textView = this.tvConfirm;
        PictureSelectionConfig pictureSelectionConfig = this.config;
        textView.setVisibility((pictureSelectionConfig.selectionMode == 1 && pictureSelectionConfig.enPreviewVideo && !booleanExtra) ? 0 : 8);
        if (booleanExtra2) {
            this.ibLeftBack.setImageResource(R.drawable.picture_icon_back);
        }
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, android.app.Activity
    public boolean isImmersive() {
        return false;
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    public boolean isRequestedOrientation() {
        return false;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        int i2;
        PictureWindowAnimationStyle pictureWindowAnimationStyle = this.config.windowAnimationStyle;
        if (pictureWindowAnimationStyle == null || pictureWindowAnimationStyle.activityPreviewExitAnimation == 0) {
            closeActivity();
            return;
        }
        finish();
        PictureWindowAnimationStyle pictureWindowAnimationStyle2 = this.config.windowAnimationStyle;
        if (pictureWindowAnimationStyle2 == null || (i2 = pictureWindowAnimationStyle2.activityPreviewExitAnimation) == 0) {
            i2 = R.anim.picture_anim_exit;
        }
        overridePendingTransition(0, i2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.picture_left_back) {
            onBackPressed();
            return;
        }
        if (id == R.id.iv_play) {
            this.mVideoView.start();
            this.iv_play.setVisibility(4);
        } else if (id == R.id.tv_confirm) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            arrayList.add(getIntent().getParcelableExtra(PictureConfig.EXTRA_MEDIA_KEY));
            setResult(-1, new Intent().putParcelableArrayListExtra(PictureConfig.EXTRA_SELECT_LIST, arrayList));
            onBackPressed();
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        ImageView imageView = this.iv_play;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        getWindow().addFlags(c.c.a.b.a.a.B1);
        super.onCreate(bundle);
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.mMediaController = null;
        this.mVideoView = null;
        this.iv_play = null;
        super.onDestroy();
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        this.mPositionWhenPaused = this.mVideoView.getCurrentPosition();
        this.mVideoView.stopPlayback();
        super.onPause();
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.luck.picture.lib.x
            @Override // android.media.MediaPlayer.OnInfoListener
            public final boolean onInfo(MediaPlayer mediaPlayer2, int i2, int i3) {
                return this.f7828a.a(mediaPlayer2, i2, i3);
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        int i2 = this.mPositionWhenPaused;
        if (i2 >= 0) {
            this.mVideoView.seekTo(i2);
            this.mPositionWhenPaused = -1;
        }
        super.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isContent(this.videoPath)) {
            this.mVideoView.setVideoURI(Uri.parse(this.videoPath));
        } else {
            this.mVideoView.setVideoPath(this.videoPath);
        }
        this.mVideoView.start();
        super.onStart();
    }
}
