package ui.activity;

import adapter.PictureSelectAdapter;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.UploadStateInfo;
import butterknife.BindView;
import butterknife.OnClick;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.PermissionsListener;
import java.util.ArrayList;
import java.util.List;
import manager.LoginManager;
import network.ReportAppInfo;
import ui.presenter.VideoPresenter;
import util.y1;

/* loaded from: classes2.dex */
public class VideoActivity extends BaseUploadActivity implements PictureSelectAdapter.b, BaseQuickAdapter.i {
    private PictureSelectAdapter mAdapter;

    @BindView(R.id.btn_commit)
    Button mBtnCommit;
    private List<LocalMedia> mLocalMedia = new ArrayList();
    private int mMaxSelectNum = 9;
    private VideoPresenter mPresenter;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.tv_commit_tip)
    TextView mTvCommitTip;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    class a implements PermissionsListener {
        a() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(VideoActivity.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            j.e.a(VideoActivity.this.mActivity, 200L, PictureMimeType.ofVideo(), VideoActivity.this.mMaxSelectNum - VideoActivity.this.mLocalMedia.size()).forResult(PictureConfig.CHOOSE_REQUEST);
        }
    }

    private void checkPermission() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.z}, new a());
    }

    private ReportAppInfo createReport() {
        int i2;
        ReportAppInfo reportAppInfo = new ReportAppInfo();
        String childPath = getChildPath();
        reportAppInfo.setSource(5);
        reportAppInfo.setSource(getChildSource());
        reportAppInfo.setFileLocalPath(childPath);
        List<UploadStateInfo> list = this.mUploadStateList;
        if (list != null && list.size() > 0 && (i2 = this.mCurrentUploadIndex) > -1) {
            reportAppInfo.setFilePath(this.mUploadStateList.get(i2).getFilePath());
            reportAppInfo.setFileMd5(this.mUploadStateList.get(this.mCurrentUploadIndex).getFileMd5());
        }
        return reportAppInfo;
    }

    private void stopPlayVedio(int i2) {
        try {
            ((JzvdStd) this.mAdapter.a(i2, R.id.image_view)).o();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
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
        return this.mLocalMedia.get(this.mCurrentUploadIndex).getPath();
    }

    @Override // ui.activity.BaseUploadActivity
    public int getChildSource() {
        return 5;
    }

    @Override // ui.activity.BaseUploadActivity, ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("添加视频");
        this.mTvCommitTip.setText(getResources().getString(R.string.commit_tip_start_str) + this.mMaxSelectNum + "个视频");
        this.mPresenter = new VideoPresenter(this);
        this.mPresenter.attachView(this);
        this.mRecyclerview.setLayoutManager(new GridLayoutManager(this, 3));
        this.mAdapter = new PictureSelectAdapter(R.layout.layout_cell_video, this.mLocalMedia, PictureSelectAdapter.b0, this.mMaxSelectNum, this.mUploadStateList);
        this.mAdapter.a(this.mRecyclerview);
        this.mAdapter.setOnItemClickListener(this);
        this.mRecyclerview.setAdapter(this.mAdapter);
        this.mAdapter.setOnItemChildClickListener(this);
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

    @Override // ui.activity.BaseUploadActivity, ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Jzvd.F();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (view.getId() != R.id.iv_clear) {
            return;
        }
        deleteDialog(i2);
        Jzvd.D();
    }

    @Override // adapter.PictureSelectAdapter.b
    public void onItemClickListener(int i2, List<LocalMedia> list) {
        if (i2 != list.size() || rejuctOperation(false)) {
            return;
        }
        checkPermission();
    }

    @OnClick({R.id.iv_back, R.id.btn_commit})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.btn_commit) {
            if (id != R.id.iv_back) {
                return;
            }
            onBackPressed();
        } else {
            if (LoginManager.getInstance().isLogOut()) {
                return;
            }
            List<LocalMedia> list = this.mLocalMedia;
            if (list == null || list.size() <= 0) {
                onBackPressed();
            } else {
                Jzvd.F();
                commitDeal();
            }
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
    public void removeLocalData(int i2) {
        stopPlayVedio(i2);
        this.mLocalMedia.remove(i2);
    }

    @Override // ui.activity.BaseUploadActivity
    public void sendData() {
        org.greenrobot.eventbus.c.f().d(new util.c2.a(7, this.mLocalMedia, this.mUploadStateList));
    }

    @Override // ui.activity.BaseUploadActivity, ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_picture;
    }
}
