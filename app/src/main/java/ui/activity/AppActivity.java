package ui.activity;

import adapter.AppDeleteAdapter;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.AppInfoBean;
import bean.UploadStateInfo;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import event.AppEventBean;
import interfaces.PermissionsListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import manager.LoginManager;
import network.ReportAppInfo;
import org.greenrobot.eventbus.ThreadMode;
import ui.presenter.AppPresenter;

/* loaded from: classes2.dex */
public class AppActivity extends BaseUploadActivity implements BaseQuickAdapter.i {
    private AppDeleteAdapter mAdapter;

    @BindView(R.id.btn_commit)
    Button mBtnCommit;
    private AppPresenter mPresenter;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.tv_commit_tip)
    TextView mTvCommitTip;

    @BindView(R.id.tv_select_tip)
    TextView mTvSelectTip;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private List<AppInfoBean> mAppBeans = new ArrayList();
    private int mMaxSelectNum = 2;
    private String mEndStr = "个APP应用程序";

    class a implements PermissionsListener {
        a() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(AppActivity.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            int size = AppActivity.this.mAppBeans.size();
            Intent intent = new Intent(AppActivity.this, (Class<?>) AppSelectedActivity.class);
            intent.putExtra(AppSelectedActivity.f17651h, 2);
            intent.putExtra(AppSelectedActivity.f17653j, size);
            intent.putExtra("extra_select_limite", AppActivity.this.mMaxSelectNum);
            AppActivity.this.startActivity(intent);
        }
    }

    private void checkPermission() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.z}, new a());
    }

    private ReportAppInfo createReport(AppInfoBean appInfoBean) {
        int i2;
        ReportAppInfo reportAppInfo = new ReportAppInfo();
        String pkgPath = appInfoBean.getPkgPath();
        reportAppInfo.setOccurTime(util.v1.a(this.mAppBeans.get(this.mCurrentUploadIndex).getLastTime()));
        reportAppInfo.setSource(getChildSource());
        reportAppInfo.setFileLocalPath(pkgPath);
        reportAppInfo.setAppName(appInfoBean.getName());
        reportAppInfo.setAppPackage(appInfoBean.getPkgName());
        reportAppInfo.setAppVersion(appInfoBean.getVersionName());
        reportAppInfo.setAppVirus(appInfoBean.getVirusName());
        List<UploadStateInfo> list = this.mUploadStateList;
        if (list != null && list.size() > 0 && (i2 = this.mCurrentUploadIndex) > -1) {
            reportAppInfo.setFilePath(this.mUploadStateList.get(i2).getFilePath());
        }
        reportAppInfo.setFileMd5(appInfoBean.getAppMD5());
        return reportAppInfo;
    }

    private void deleteDoubleElement(List<AppInfoBean> list, AppInfoBean appInfoBean) {
        if (this.mAppBeans == null) {
            this.mAppBeans = new ArrayList();
        }
        if (list == null || (list.size() <= 0 && appInfoBean != null)) {
            list = new ArrayList<>();
            list.add(appInfoBean);
        }
        Iterator<AppInfoBean> it = list.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            AppInfoBean next = it.next();
            List<AppInfoBean> list2 = this.mAppBeans;
            if (list2 != null) {
                if (list2.size() > 0) {
                    for (AppInfoBean appInfoBean2 : this.mAppBeans) {
                        if (next.getPkgName().equals(appInfoBean2.getPkgName()) && next.getPkgPath().equals(appInfoBean2.getPkgPath())) {
                            String activityName = next.getActivityName();
                            if (TextUtils.isEmpty(activityName) || activityName.equals(appInfoBean2.getActivityName())) {
                                z = true;
                                break;
                            }
                        }
                    }
                    if (!z) {
                        next.setAddNew(true);
                        this.mAppBeans.add(next);
                    }
                } else {
                    next.setAddNew(true);
                    this.mAppBeans.add(next);
                }
            }
        }
        for (int i2 = 0; i2 < this.mAppBeans.size(); i2++) {
            AppInfoBean appInfoBean3 = this.mAppBeans.get(i2);
            if (appInfoBean3.isAddNew()) {
                appInfoBean3.setAddNew(false);
                this.mUploadStateList.add(i2, new UploadStateInfo());
            }
        }
    }

    private void scanVirus() {
        int i2;
        AppInfoBean appInfoBean = this.mAppBeans.get(this.mCurrentUploadIndex);
        List<UploadStateInfo> list = this.mUploadStateList;
        if (list != null && list.size() > 0 && (i2 = this.mCurrentUploadIndex) > -1) {
            appInfoBean.setAppMD5(this.mUploadStateList.get(i2).getFileMd5());
        }
        util.n1.a("mCurrentUploadIndex-->-1 文件上传请求   1" + this.mCurrentUploadIndex);
        int i3 = this.mCurrentUploadIndex;
        if (i3 <= -1 || appInfoBean != this.mAppBeans.get(i3)) {
            return;
        }
        util.n1.a("mCurrentUploadIndex-->-1 文件上传请求   2" + this.mCurrentUploadIndex);
        this.mPresenter.doAudioUpload(createReport(appInfoBean), this.info);
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
        scanVirus();
    }

    @Override // ui.activity.BaseUploadActivity
    public String getChildPath() {
        return this.mAppBeans.get(this.mCurrentUploadIndex).getPkgPath();
    }

    @Override // ui.activity.BaseUploadActivity
    public int getChildSource() {
        return 1;
    }

    @Override // ui.activity.BaseUploadActivity, ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("添加APP应用程序");
        this.mTvSelectTip.setText("添加");
        this.mTvCommitTip.setText(getResources().getString(R.string.commit_tip_start_str) + this.mMaxSelectNum + this.mEndStr);
        this.mPresenter = new AppPresenter(this);
        this.mPresenter.attachView(this);
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter = new AppDeleteAdapter(R.layout.recyclerview_app_record_select, this.mAppBeans, this.mUploadStateList);
        this.mAdapter.a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.mAdapter);
        this.mAdapter.setOnItemChildClickListener(this);
    }

    @Override // ui.activity.BaseUploadActivity
    public void notifyAdapter() {
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (backPressedUpload()) {
            return;
        }
        super.onBackPressed();
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEvent(AppEventBean appEventBean) {
        org.greenrobot.eventbus.c.f().f(appEventBean);
        deleteDoubleElement(appEventBean.getAppBeans(), null);
        if (this.mUploadStateList.size() <= 0) {
            for (int i2 = 0; i2 < this.mAppBeans.size(); i2++) {
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

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (view.getId() != R.id.iv_clear) {
            return;
        }
        deleteDialog(i2);
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
            List<AppInfoBean> list = this.mAppBeans;
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
            List<AppInfoBean> list2 = this.mAppBeans;
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
            this.mAppBeans.addAll(list);
        }
        List<UploadStateInfo> list2 = (List) aVar.d();
        if (list2 != null && list2.size() > 0) {
            for (UploadStateInfo uploadStateInfo : list2) {
                if (uploadStateInfo.getUploadState() == 1) {
                    uploadStateInfo.setUploadState(3);
                }
            }
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
        this.mAppBeans.remove(i2);
    }

    @Override // ui.activity.BaseUploadActivity
    public void sendData() {
        org.greenrobot.eventbus.c.f().d(new util.c2.a(5, this.mAppBeans, this.mUploadStateList));
    }

    @Override // ui.activity.BaseUploadActivity, ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_audio;
    }
}
