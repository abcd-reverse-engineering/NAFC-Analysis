package ui.activity;

import adapter.PictureSelectAdapter;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
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
import java.util.ArrayList;
import java.util.List;
import manager.LoginManager;
import network.ReportAppInfo;
import ui.presenter.PicturePresenter;
import util.y1;

/* loaded from: classes2.dex */
public class PictureActivity extends BaseUploadActivity implements PictureSelectAdapter.b, BaseQuickAdapter.i {
    public static final int CODE_PREVIEW = 1001;
    private PictureSelectAdapter mAdapter;

    @BindView(R.id.btn_commit)
    Button mBtnCommit;
    private PicturePresenter mPresenter;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.tv_commit_tip)
    TextView mTvCommitTip;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private List<LocalMedia> mLocalMedia = new ArrayList();
    private int previewPosition = -1;
    private int mMaxSelectNum = 6;

    class a implements PermissionsListener {
        a() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(PictureActivity.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            j.e.a(PictureActivity.this.mActivity, 200L, PictureMimeType.ofImage(), PictureActivity.this.mMaxSelectNum - PictureActivity.this.mLocalMedia.size()).forResult(PictureConfig.CHOOSE_REQUEST);
        }
    }

    private void checkPermission() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.z}, new a());
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
        return 3;
    }

    @Override // ui.activity.BaseUploadActivity, ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("添加图片");
        this.mTvCommitTip.setText(getResources().getString(R.string.commit_tip_start_str) + this.mMaxSelectNum + "张图片");
        this.mPresenter = new PicturePresenter(this);
        this.mPresenter.attachView(this);
        this.mRecyclerview.setLayoutManager(new GridLayoutManager(this, 3));
        this.mAdapter = new PictureSelectAdapter(R.layout.recyclerview_picture, this.mLocalMedia, PictureSelectAdapter.c0, this.mMaxSelectNum, this.mUploadStateList);
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
        int i4;
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            if (i2 != 188) {
                if (i2 == 1001 && (i4 = this.previewPosition) != -1) {
                    deleteDialog(i4);
                    this.previewPosition = -1;
                    return;
                }
                return;
            }
            List<LocalMedia> listObtainMultipleResult = PictureSelector.obtainMultipleResult(intent);
            if (listObtainMultipleResult == null || listObtainMultipleResult.size() <= 0) {
                return;
            }
            if (Build.VERSION.SDK_INT > 28) {
                changePath(listObtainMultipleResult);
            }
            deleteDoubleElement(this.mLocalMedia, y1.a(listObtainMultipleResult), null);
            if (this.mUploadStateList.size() <= 0) {
                for (int i5 = 0; i5 < this.mLocalMedia.size(); i5++) {
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
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (backPressedUpload()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (view.getId() != R.id.iv_clear) {
            return;
        }
        deleteDialog(i2);
    }

    @Override // adapter.PictureSelectAdapter.b
    public void onItemClickListener(int i2, List<LocalMedia> list) {
        if (isDouble()) {
            return;
        }
        ArrayList<? extends Parcelable> arrayList = (ArrayList) list;
        if (i2 == arrayList.size()) {
            if (rejuctOperation(false)) {
                return;
            }
            checkPermission();
            return;
        }
        this.previewPosition = i2;
        String path = ((LocalMedia) arrayList.get(i2)).getPath();
        Intent intent = new Intent(this, (Class<?>) PreviewPictureActivity.class);
        intent.putParcelableArrayListExtra(PreviewPictureActivity.f18539f, arrayList);
        intent.putExtra(PreviewPictureActivity.f18540g, i2);
        intent.putExtra(PreviewPictureActivity.f18541h, arrayList.size());
        intent.putExtra(PreviewPictureActivity.f18542i, path);
        startActivityForResult(intent, 1001);
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
        this.mLocalMedia.remove(i2);
    }

    @Override // ui.activity.BaseUploadActivity
    public void sendData() {
        org.greenrobot.eventbus.c.f().d(new util.c2.a(6, this.mLocalMedia, this.mUploadStateList));
    }

    @Override // ui.activity.BaseUploadActivity, ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_picture;
    }
}
