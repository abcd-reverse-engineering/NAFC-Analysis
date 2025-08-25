package ui.activity;

import adapter.AudioRecordDeleteAdapter;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.UploadStateInfo;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.PermissionsListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import manager.LoginManager;
import manager.MediaPlayerManager;
import network.ReportAppInfo;
import ui.presenter.AudioPresenter;
import util.y1;

/* loaded from: classes2.dex */
public class AudioActivity extends BaseUploadActivity implements BaseQuickAdapter.i, MediaPlayer.OnCompletionListener {
    private AudioRecordDeleteAdapter mAdapter;

    @BindView(R.id.btn_commit)
    Button mBtnCommit;
    private MediaPlayer mMediaPlayer;
    private AudioPresenter mPresenter;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.tv_commit_tip)
    TextView mTvCommitTip;

    @BindView(R.id.tv_select_tip)
    TextView mTvSelectTip;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private List<LocalMedia> mLocalMedia = new ArrayList();
    private int mMaxSelectNum = 9;
    public int oldClickPosition = -1;
    private ImageView mCurrentPlay = null;
    private String mEndStr = "条录音";

    class a implements MediaPlayer.OnPreparedListener {
        a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
            util.n1.c(a.a.u.a.n, "onPrepared        开始播放          ");
            AudioActivity.this.mMediaPlayer.start();
        }
    }

    class b implements PermissionsListener {
        b() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(AudioActivity.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            j.e.a(AudioActivity.this.mActivity, 200L, PictureMimeType.ofAudio(), AudioActivity.this.mMaxSelectNum - AudioActivity.this.mLocalMedia.size()).forResult(PictureConfig.CHOOSE_REQUEST);
        }
    }

    private void checkPermission() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.z}, new b());
    }

    private ReportAppInfo createReport() {
        int i2;
        ReportAppInfo reportAppInfo = new ReportAppInfo();
        String childPath = getChildPath();
        reportAppInfo.setSource(getChildSource());
        reportAppInfo.setFileLocalPath(childPath);
        List<UploadStateInfo> list = this.mUploadStateList;
        if (list != null && list.size() > 0 && (i2 = this.mCurrentUploadIndex) > -1) {
            reportAppInfo.setFilePath(this.mUploadStateList.get(i2).getFilePath());
            reportAppInfo.setFileMd5(this.mUploadStateList.get(this.mCurrentUploadIndex).getFileMd5());
        }
        return reportAppInfo;
    }

    private void playAudio(int i2, ImageView imageView) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        int i3 = this.oldClickPosition;
        if (i3 == i2) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    stopPlay(i2, imageView);
                    return;
                }
                this.mMediaPlayer.start();
                this.mUploadStateList.get(i2).setPlayState(true);
                ((AnimationDrawable) imageView.getBackground()).start();
                return;
            }
            return;
        }
        if (i3 != -1) {
            int size = this.mUploadStateList.size();
            int i4 = this.oldClickPosition;
            if (size > i4) {
                this.mUploadStateList.get(i4).setPlayState(false);
            }
        }
        this.oldClickPosition = i2;
        try {
            if (this.mMediaPlayer != null) {
                if (this.mMediaPlayer.isPlaying()) {
                    this.mMediaPlayer.stop();
                }
                this.mMediaPlayer.reset();
                this.mMediaPlayer.setDataSource(this.mLocalMedia.get(i2).getPath());
                this.mMediaPlayer.setAudioStreamType(3);
                this.mMediaPlayer.setOnPreparedListener(new a());
                this.mMediaPlayer.prepareAsync();
                this.mMediaPlayer.setOnCompletionListener(this);
                this.mUploadStateList.get(i2).setPlayState(true);
                this.mAdapter.notifyDataSetChanged();
                ((AnimationDrawable) imageView.getBackground()).start();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void stopPlay(int i2, ImageView imageView) throws IllegalStateException {
        this.oldClickPosition = -1;
        this.mMediaPlayer.pause();
        this.mMediaPlayer.reset();
        this.mUploadStateList.get(i2).setPlayState(false);
        imageView.setBackground(null);
        imageView.setBackground(getResources().getDrawable(R.drawable.anim_defraud_play));
    }

    @Override // ui.activity.BaseUploadActivity
    public void changeBtnCommit(String str, boolean z) {
        if (isFinishing() || this.mBtnCommit == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.mBtnCommit.setText(str);
        }
        this.mBtnCommit.setEnabled(z);
    }

    @Override // ui.activity.BaseUploadActivity
    public void doUpload() {
        this.mPresenter.doAudioUpload(createReport(), this.info);
    }

    @Override // ui.activity.BaseUploadActivity
    public String getChildPath() {
        try {
            return this.mLocalMedia.get(this.mCurrentUploadIndex).getPath();
        } catch (Exception unused) {
            changeBtnCommit("确定", true);
            return "";
        }
    }

    @Override // ui.activity.BaseUploadActivity
    public int getChildSource() {
        return 2;
    }

    @Override // ui.activity.BaseUploadActivity, ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("添加录音");
        this.mTvSelectTip.setText("添加");
        this.mTvCommitTip.setText(getResources().getString(R.string.commit_tip_start_str) + this.mMaxSelectNum + this.mEndStr);
        this.mPresenter = new AudioPresenter(this);
        this.mPresenter.attachView(this);
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter = new AudioRecordDeleteAdapter(R.layout.recyclerview_audio_record, this.mLocalMedia, this.mUploadStateList);
        this.mAdapter.a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.mAdapter);
        this.mAdapter.setOnItemChildClickListener(this);
        MediaPlayerManager.getInstance();
        this.mMediaPlayer = MediaPlayerManager.getMediaPlayer();
    }

    @Override // ui.activity.BaseUploadActivity
    public void notifyAdapter() {
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) throws IllegalArgumentException {
        List<LocalMedia> listObtainMultipleResult;
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1 || i2 != 188 || (listObtainMultipleResult = PictureSelector.obtainMultipleResult(intent)) == null || listObtainMultipleResult.size() <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT > 28) {
            changePath(listObtainMultipleResult);
        }
        deleteDoubleElement(this.mLocalMedia, y1.a(listObtainMultipleResult), null);
        if (this.mUploadStateList.size() <= 0) {
            for (int i4 = 0; i4 < this.mLocalMedia.size(); i4++) {
                this.mUploadStateList.add(new UploadStateInfo());
            }
        }
        this.mAdapter.notifyDataSetChanged();
        if (isAllSuccess()) {
            changeBtnCommit("确定", true);
        } else {
            changeBtnCommit("文件上传", true);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (backPressedUpload()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) throws IllegalStateException {
        util.n1.c(a.a.u.a.n, "onCompletion              音频播放完成 复位");
        mediaPlayer.stop();
        this.mMediaPlayer.reset();
        this.mUploadStateList.get(this.oldClickPosition).setPlayState(false);
        this.oldClickPosition = -1;
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        int id = view.getId();
        if (id == R.id.iv_audio) {
            this.mCurrentPlay = (ImageView) baseQuickAdapter.a(i2, R.id.img_defraud_play);
            playAudio(i2, this.mCurrentPlay);
        } else {
            if (id != R.id.iv_clear) {
                return;
            }
            deleteDialog(i2);
        }
    }

    @Override // ui.activity.BaseUploadActivity, ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() throws IllegalStateException {
        super.onPause();
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.mUploadStateList.get(this.oldClickPosition).setPlayState(false);
        this.mAdapter.notifyDataSetChanged();
        this.oldClickPosition = -1;
        this.mMediaPlayer.pause();
        this.mMediaPlayer.reset();
    }

    @OnClick({R.id.iv_back, R.id.ll_select, R.id.btn_commit})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.btn_commit) {
            if (LoginManager.getInstance().isLogOut()) {
                return;
            }
            List<LocalMedia> list = this.mLocalMedia;
            if (list == null || list.size() <= 0) {
                onBackPressed();
                return;
            } else {
                commitDeal();
                return;
            }
        }
        if (id == R.id.iv_back) {
            onBackPressed();
            return;
        }
        if (id == R.id.ll_select && !rejuctOperation(false)) {
            List<LocalMedia> list2 = this.mLocalMedia;
            if (list2 == null || list2.size() != this.mMaxSelectNum) {
                checkPermission();
                return;
            }
            util.w1.a(getResources().getString(R.string.select_warn_start_str) + this.mMaxSelectNum + this.mEndStr);
        }
    }

    @Override // ui.activity.BaseUploadActivity
    public void redisplayData(util.c2.a aVar) {
        List list = (List) aVar.b();
        if (list != null && list.size() > 0) {
            this.mLocalMedia.addAll(list);
        }
        List list2 = (List) aVar.d();
        if (list2 != null && list2.size() > 0) {
            this.mUploadStateList.addAll(list2);
        }
        this.mAdapter.notifyDataSetChanged();
        if (isAllSuccess()) {
            return;
        }
        changeBtnCommit("上传文件", true);
    }

    @Override // ui.activity.BaseUploadActivity
    public void removeLocalData(int i2) throws IllegalStateException {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            stopPlay(i2, this.mCurrentPlay);
        }
        this.mLocalMedia.remove(i2);
    }

    @Override // ui.activity.BaseUploadActivity
    public void sendData() {
        org.greenrobot.eventbus.c.f().d(new util.c2.a(4, this.mLocalMedia, this.mUploadStateList));
    }

    @Override // ui.activity.BaseUploadActivity, ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_audio;
    }
}
