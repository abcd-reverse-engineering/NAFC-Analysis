package ui.activity;

import adapter.RiskAppUploadAdapter;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.AppInfoBean;
import bean.ReportPersonBean;
import bean.UploadStateInfo;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import interfaces.IVerifyListener;
import interfaces.PermissionsListener;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import manager.LoginManager;
import network.ReportAppInfo;
import network.account.APIresult;
import network.request.ReportCaseInfo;
import ui.Hicore;
import ui.presenter.AppUploadPresenter;
import util.z1;

/* loaded from: classes2.dex */
public class AppUploadActivity extends BaseUploadActivity implements BaseQuickAdapter.i {
    private RiskAppUploadAdapter mAdapter;
    private AppUploadPresenter mPresenter;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private List<AppInfoBean> mAppBeans = new ArrayList();
    private String description = "";
    private boolean isUploading = false;

    class a implements IVerifyListener {
        a() {
        }

        @Override // interfaces.IVerifyListener
        public void onSuccessVerify() {
            AppUploadActivity.this.isUploading = true;
            AppUploadActivity.this.upload();
        }
    }

    class b implements IClickListener {
        b() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            if (AppUploadActivity.this.isHasUpload()) {
                AppUploadActivity.this.stopUpload();
            }
            AppUploadActivity.this.cleanList();
            AppUploadActivity.this.finish();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    class c implements PermissionsListener {
        c() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            AppUploadActivity.this.mPresenter.reportSubmit(AppUploadActivity.this.mPresenter.getAppFileIDs(AppUploadActivity.this.mUploadStateList), AppUploadActivity.this.buildDiscCache());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ReportPersonBean buildDiscCache() {
        ReportPersonBean reportPersonBean = new ReportPersonBean();
        reportPersonBean.setReportDic("");
        reportPersonBean.setReportAdd("");
        reportPersonBean.setDupery("其他诈骗");
        reportPersonBean.setDefraudType(22);
        reportPersonBean.setCaseDis(this.description);
        return reportPersonBean;
    }

    private void checkPermission() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.f20916j}, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanList() {
        ReportNewActivity.REPORT_UP_ID = "";
        this.mUploadStateList = null;
        this.mAppBeans = null;
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
            reportAppInfo.setFileMd5(this.mUploadStateList.get(i2).getFileMd5());
            reportAppInfo.setFilePath(this.mUploadStateList.get(this.mCurrentUploadIndex).getFilePath());
        }
        return reportAppInfo;
    }

    private void initRecycleriew() {
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter = new RiskAppUploadAdapter(R.layout.recyclerview_app_upload_risk, this.mAppBeans, this.mUploadStateList);
        this.mAdapter.a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.mAdapter);
        this.mAdapter.setOnItemChildClickListener(this);
    }

    private String logoBase64(Drawable drawable) {
        try {
            Bitmap bitmapA = j.d.a(drawable);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmapA.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return util.x0.a(byteArrayOutputStream);
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void upload() {
        List<AppInfoBean> list;
        if (LoginManager.getInstance().isLogOut() || (list = this.mAppBeans) == null || list.size() <= 0) {
            return;
        }
        commitDeal();
    }

    private void warnUpload() {
        z1.a(this.mActivity).a(8, new a());
    }

    @Override // ui.activity.BaseUploadActivity
    public void changeBtnCommit(String str, boolean z) {
        if (TextUtils.equals("确定", str)) {
            checkPermission();
        }
    }

    @Override // ui.activity.BaseUploadActivity
    public void createCaseInfo() {
        util.n1.a("AppUploadActivity-->>createCaseInfo");
        if (this.info == null) {
            this.info = new ReportCaseInfo();
            this.info.setCaseCategory(22);
            this.info.setCaseCategoryText("其他诈骗");
            this.info.setRegion("");
            this.info.setCaseDescription(this.description);
            setUpId();
            this.info.setCommonParams();
        }
    }

    @Override // ui.activity.BaseUploadActivity
    public void doUpload() {
        this.mPresenter.doAudioUpload(createReport(this.mAppBeans.get(this.mCurrentUploadIndex)), this.info);
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
        this.mTvTitle.setText("一键举报");
        this.mPresenter = new AppUploadPresenter(this, this);
        initRecycleriew();
        Hicore.fromPageReport = true;
        if (TextUtils.equals(util.k1.A, getIntent().getStringExtra(util.k1.y))) {
            this.description = "APP安装预警一键举报";
        } else {
            this.description = "防诈检测一键举报";
        }
    }

    @Override // ui.activity.BaseUploadActivity
    public void networkFail() {
        if (isHasFail()) {
            this.mAdapter.notifyDataSetChanged();
            return;
        }
        nextUploadIndex();
        int i2 = this.mCurrentUploadIndex;
        if (i2 != -1) {
            this.mUploadStateList.get(i2).setUploadState(3);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    @Override // ui.activity.BaseUploadActivity
    public void notifyAdapter() {
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (isAllSuccess()) {
            super.onBackPressed();
        } else {
            util.b1.a(this.mActivity, "是否停止文件上传并取消我要举报？", "", "是", "否", -1, -1, true, (IClickListener) new b());
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (view.getId() == R.id.iv_checkbox && this.mUploadStateList.get(i2).getUploadState() == 3 && !isHasUpload()) {
            this.mUploadStateList.get(i2).setUploadState(0);
            upload();
        }
    }

    @Override // ui.activity.BaseUploadActivity, ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        List<AppInfoBean> list;
        super.onResume();
        if (this.isUploading || (list = this.mAppBeans) == null || list.size() <= 0) {
            return;
        }
        warnUpload();
    }

    @Override // ui.activity.BaseUploadActivity, ui.callview.AudioCallView
    public void onSuccessRequest(APIresult aPIresult) {
        hideProgressDialog();
        org.greenrobot.eventbus.c.f().d(new util.c2.a(26, this.mAppBeans));
        cleanList();
        this.isUploading = false;
        util.b1.a((Activity) this, true, 1, "提交成功", R.drawable.iv_comit_succ);
    }

    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        if (!isDouble() && view.getId() == R.id.iv_back) {
            onBackPressed();
        }
    }

    @Override // ui.activity.BaseUploadActivity, ui.callview.AudioCallView
    public void onfailRequest() {
        util.b1.a((Activity) this, false, 1, "提交失败请重新提交", R.drawable.iv_comit_fail);
    }

    @Override // ui.activity.BaseUploadActivity
    public void redisplayData(util.c2.a aVar) {
        List list = (List) aVar.b();
        if (list != null && list.size() > 0) {
            this.mAppBeans.addAll(list);
        }
        for (AppInfoBean appInfoBean : this.mAppBeans) {
            this.mUploadStateList.add(new UploadStateInfo());
        }
        RiskAppUploadAdapter riskAppUploadAdapter = this.mAdapter;
        if (riskAppUploadAdapter != null) {
            riskAppUploadAdapter.notifyDataSetChanged();
        }
        List<AppInfoBean> list2 = this.mAppBeans;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        warnUpload();
    }

    @Override // ui.activity.BaseUploadActivity
    public void removeLocalData(int i2) {
        this.mAppBeans.remove(i2);
    }

    @Override // ui.activity.BaseUploadActivity
    public void sendData() {
    }

    @Override // ui.activity.BaseUploadActivity, ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_app_upload;
    }
}
