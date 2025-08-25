package ui.activity;

import adapter.RiskAppSelectAdapter;
import adapter.ScanAppAdapter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.AppBean;
import bean.AppInfoBean;
import bean.AppVirusBean;
import bean.ScanResultInfo;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import interfaces.IOneClickListener;
import interfaces.PermissionsListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import manager.AccountManager;
import network.http.StatisticsHttp;
import org.greenrobot.eventbus.ThreadMode;
import ui.Hicore;
import ui.callview.VirusKillingCallView;
import ui.presenter.BasePagePresenter;
import ui.presenter.VirusKillingPresenter;
import ui.presenter.WelocmPresenter;
import ui.view.SwitchButton;
import util.y1;

/* loaded from: classes2.dex */
public class VirusKillingActivity extends BaseActivity implements VirusKillingCallView, BaseQuickAdapter.i {
    public static final int LIMITE_APK = 9;
    private static final int SCAN_STATE_FINISH = 3;
    private static final int SCAN_STATE_FINISH_RISK = 4;
    public static final int SCAN_STATE_LOADING = -1;
    public static final int SCAN_STATE_RISK = 2;
    public static final int SCAN_STATE_SAFE = 0;
    private static final int SCAN_STATE_SCAN = 1;
    private static final int SCAN_STATE_UNFINISH = 2;
    public static final int SCAN_STATE_VIRUS = 1;
    private static final int SCAN_STATE_WAIT = 0;
    public static AppInfoBean mIntentBean;
    private ScanAppAdapter mAdapter;
    private ScanAppAdapter mAdapter1;
    BasePagePresenter mBasePresenter;

    @BindView(R.id.iv_apk_states)
    ImageView mIvApkStates;

    @BindView(R.id.iv_app_states)
    ImageView mIvAppStates;

    @BindView(R.id.iv_circle)
    ImageView mIvCircle;

    @BindView(R.id.iv_circle_center)
    ImageView mIvCircleCenter;

    @BindView(R.id.layout_risk_btn)
    ConstraintLayout mLayoutRiskBtn;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.recyclerview1)
    RecyclerView mRecyclerview1;

    @BindView(R.id.recyclerview_risk)
    RecyclerView mRecyclerviewRisk;

    @BindView(R.id.rl_risk_result)
    RelativeLayout mRlRiskResult;

    @BindView(R.id.rl_safe_result)
    RelativeLayout mRlSafeResult;

    @BindView(R.id.safe_space)
    Group mSafeSpace;

    @BindView(R.id.scan_app)
    TextView mScanApp;

    @BindView(R.id.scan_app_count)
    TextView mScanAppCount;

    @BindView(R.id.scan_layout)
    ConstraintLayout mScanLayout;

    @BindView(R.id.scan_package)
    TextView mScanPackage;

    @BindView(R.id.scan_package_count)
    TextView mScanPackageCount;

    @BindView(R.id.scan_result_tip)
    TextView mScanResultTip;

    @BindView(R.id.scan_state)
    TextView mScanState;

    @BindView(R.id.stop_scan)
    TextView mStopScan;

    @BindView(R.id.switch_app)
    SwitchButton mSwitchApp;

    @BindView(R.id.tv_app)
    TextView mTvApp;

    @BindView(R.id.tv_app_count)
    TextView mTvAppCount;

    @BindView(R.id.tv_appeal)
    TextView mTvAppeal;

    @BindView(R.id.tv_delete)
    TextView mTvDelete;

    @BindView(R.id.tv_package_count)
    TextView mTvPackageCount;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @BindView(R.id.view_bg)
    View mViewBg;
    com.bumptech.glide.r.h options;
    private VirusKillingPresenter mPresenter = null;
    private ArrayList<ScanResultInfo> mAppParent = new ArrayList<>();
    private ArrayList<ScanResultInfo> mPackageParent = new ArrayList<>();
    private ArrayList<ArrayList<AppInfoBean>> mAppChild = new ArrayList<>();
    private ArrayList<ArrayList<AppInfoBean>> mPackageChild = new ArrayList<>();
    private ArrayList<AppInfoBean> virusList = null;
    private ArrayList<AppInfoBean> warnList = null;
    private ArrayList<AppInfoBean> okList = null;
    private ui.e.c mAppScanListener = null;
    private ui.e.c mPackageScanListener = null;
    private int currentState = -1;
    private boolean isStopScan = false;
    private boolean isAllFinishScan = false;
    private boolean isAppScanning = false;
    private boolean isPackageScanning = false;
    private RiskAppSelectAdapter mRiskAdapter = null;
    private int mSelectLimit = 9;
    private ArrayList<AppInfoBean> mAllSelectList = new ArrayList<>();
    private int mUninstallPosition = -1;
    private ArrayList<AppInfoBean> mAllRiskList = new ArrayList<>();
    private boolean isReportBack = false;
    private boolean isToOpenFlow = false;
    private boolean isToOpenStorage = false;

    class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (TextUtils.equals(WelocmPresenter.VIRAPWARN, "0")) {
                VirusKillingActivity.this.mSwitchApp.setChecked(!z);
                util.w1.a(WelocmPresenter.VIRSTMSG);
                return;
            }
            if (z) {
                VirusKillingActivity.this.mSwitchApp.setChecked(false);
                VirusKillingActivity.this.isToOpenFlow = true;
                VirusKillingActivity.this.checkPermissionSwitch();
            } else {
                VirusKillingActivity.this.isToOpenFlow = false;
                util.u1.b(util.u1.H, false);
            }
            StatisticsHttp.getInstance().trackWarnApp(VirusKillingActivity.this.mSwitchApp.isChecked() ? "1" : "0", null);
        }
    }

    class b implements PermissionsListener {

        class a implements IOneClickListener {
            a() {
            }

            @Override // interfaces.IOneClickListener
            public void clickOKBtn() {
                VirusKillingActivity.this.isToOpenStorage = true;
            }
        }

        b() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.u1.b(util.u1.H, false);
            util.permissionutil.c.a(VirusKillingActivity.this.mActivity, list, z, true, this, new a());
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() throws Resources.NotFoundException {
            VirusKillingActivity.this.isToOpenStorage = false;
            VirusKillingActivity.this.dealCheck();
        }
    }

    class c implements PermissionsListener {
        c() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.u1.b(util.u1.H, false);
            VirusKillingActivity.this.mSwitchApp.setChecked(false);
            util.permissionutil.c.a(VirusKillingActivity.this.mActivity, list, z, false, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            if (!VirusKillingActivity.this.mBasePresenter.isOpenFlowPrim()) {
                util.permissionutil.c.a(VirusKillingActivity.this.mActivity, false, "", "", "", "", null);
                return;
            }
            VirusKillingActivity.this.mSwitchApp.setChecked(true);
            util.u1.b(util.u1.H, true);
            StatisticsHttp.getInstance().trackPageClick("1");
        }
    }

    class d implements RiskAppSelectAdapter.b {
        d() {
        }

        @Override // adapter.RiskAppSelectAdapter.b
        public void onItemClickListener(int i2, List<AppInfoBean> list) {
            if (Hicore.getApp().isDouble()) {
                return;
            }
            VirusKillingActivity.mIntentBean = list.get(i2);
            VirusKillingActivity.this.startActivityForResult(new Intent(VirusKillingActivity.this, (Class<?>) VirusDetailActivity.class), 1001);
        }
    }

    class e implements IClickListener {
        e() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            if (VirusKillingActivity.this.hasSelect()) {
                ArrayList arrayList = new ArrayList();
                Iterator it = VirusKillingActivity.this.mAllSelectList.iterator();
                while (it.hasNext()) {
                    AppInfoBean appInfoBean = (AppInfoBean) it.next();
                    AppVirusBean appVirusBean = new AppVirusBean();
                    appVirusBean.setAppName(appInfoBean.getName());
                    appVirusBean.setFileMd5(appInfoBean.getAppMD5());
                    appVirusBean.setVersionCode(appInfoBean.getVersionCode() + "");
                    appVirusBean.setPkgName(appInfoBean.getPkgName());
                    appVirusBean.setSignHash(appInfoBean.getSignHash());
                    appVirusBean.setFindTime(util.v1.a(System.currentTimeMillis()));
                    appVirusBean.setVirusDescription(appInfoBean.getVirusDescription());
                    appVirusBean.setVirusName(appInfoBean.getVirusName());
                    int virusLevel = appInfoBean.getVirusLevel();
                    if (virusLevel == 1) {
                        appVirusBean.setVirusLevel(1);
                        appVirusBean.setIllegalType("病毒");
                    } else if (virusLevel == 2) {
                        appVirusBean.setVirusLevel(2);
                        appVirusBean.setIllegalType("风险");
                    }
                    arrayList.add(appVirusBean);
                }
                VirusKillingActivity.this.mPresenter.appealApp(arrayList);
            }
        }
    }

    class f implements IOneClickListener {
        f() {
        }

        @Override // interfaces.IOneClickListener
        public void clickOKBtn() {
            VirusKillingActivity.this.nextUninstall();
        }
    }

    private void appealSelect() {
        util.b1.a(this.mActivity, "确定上报应用错误信息吗", "", "取消", "确定", R.color._A8B4F7, R.color.blue_dark, (IClickListener) new e());
    }

    private void beginScan() throws Resources.NotFoundException {
        ArrayList<ScanResultInfo> arrayList;
        this.isStopScan = false;
        this.isAllFinishScan = false;
        changeScanState(1);
        RecyclerView recyclerView = this.mRecyclerview;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        RecyclerView recyclerView2 = this.mRecyclerview1;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(0);
        }
        if (!this.isAppScanning && !this.isPackageScanning && this.mRiskAdapter != null && this.mRecyclerviewRisk != null && (arrayList = this.mAppParent) != null && this.mAppChild != null && this.mPackageParent != null && this.mPackageChild != null) {
            arrayList.clear();
            this.mAppChild.clear();
            this.mPackageParent.clear();
            this.mPackageChild.clear();
            this.mRecyclerviewRisk.setVisibility(8);
        }
        if (this.isPackageScanning) {
            scanPackage();
        } else {
            scanApp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnDeal() throws Resources.NotFoundException {
        if (this.mScanState == null || this.mStopScan == null) {
            return;
        }
        int i2 = this.currentState;
        if (i2 == 1) {
            changeScanState(2);
            this.isStopScan = true;
            pauseScanApp();
        } else if (i2 == 2) {
            beginScan();
        } else if (i2 == 3) {
            finish();
        } else {
            if (i2 != 4) {
                return;
            }
            riskLayoutDeal();
        }
    }

    private void changeReportState(boolean z) {
        if (z) {
            this.mTvAppeal.setBackgroundResource(R.drawable.button_bg_blue_ligth_1);
            this.mTvAppeal.setTextColor(getResources().getColor(R.color.blue_dark));
            this.mTvAppeal.setEnabled(true);
            this.mTvDelete.setAlpha(1.0f);
            this.mTvDelete.setEnabled(true);
            return;
        }
        this.mTvAppeal.setBackgroundResource(R.drawable.button_bg_gray);
        this.mTvAppeal.setTextColor(getResources().getColor(R.color.colorGray));
        this.mTvAppeal.setEnabled(false);
        this.mTvDelete.setAlpha(0.5f);
        this.mTvDelete.setEnabled(false);
    }

    private void changeScanState(int i2) throws Resources.NotFoundException {
        TextView textView;
        if (this.mScanState == null || (textView = this.mStopScan) == null) {
            return;
        }
        textView.setTextColor(getResources().getColor(R.color.colorWhite));
        this.mIvCircleCenter.setVisibility(8);
        this.mScanResultTip.setVisibility(8);
        this.mScanState.setVisibility(8);
        this.mStopScan.setVisibility(8);
        this.mLayoutRiskBtn.setVisibility(8);
        if (i2 == 0) {
            this.mScanState.setText("等待检测");
            this.mScanState.setVisibility(0);
            this.mIvCircleCenter.setVisibility(0);
            stopGif2Img(R.mipmap.ic_scan_rotate);
            return;
        }
        if (i2 == 1) {
            this.mViewBg.setBackground(getResources().getDrawable(R.mipmap.ic_blue_bg_big));
            this.mIvCircleCenter.setVisibility(0);
            this.mIvCircle.setImageResource(R.mipmap.ic_scan_rotate);
            y1.a(this.mActivity, R.anim.scan_app_anim, this.mIvCircle);
            this.mStopScan.setText("停止检测");
            this.mStopScan.setTextColor(getResources().getColor(R.color.black_dark));
            this.mStopScan.setBackground(getResources().getDrawable(R.drawable.button_bg_gray));
            this.mStopScan.setVisibility(0);
            this.currentState = 1;
            return;
        }
        if (i2 == 2) {
            this.mViewBg.setBackground(getResources().getDrawable(R.mipmap.ic_blue_bg_big));
            stopGif2Img(R.mipmap.ic_scan_unfinish);
            this.mScanResultTip.setText("暂停检测应用/安装包");
            this.mScanResultTip.setVisibility(0);
            this.mStopScan.setText("继续检测");
            this.mStopScan.setBackground(getResources().getDrawable(R.drawable.button_bg_them));
            this.mStopScan.setVisibility(0);
            this.currentState = 2;
            return;
        }
        if (i2 != 3) {
            if (i2 != 4) {
                return;
            }
            stopGif2Img(R.mipmap.ic_scan_finish_virus);
            this.mViewBg.setBackgroundTintList(ColorStateList.valueOf(-1289424));
            this.mScanState.setText("建议定期检测清理，国家反诈中心实时守护您的网络安全");
            this.mScanState.setBackground(getResources().getDrawable(R.drawable.button_bg_red_dark));
            this.mScanState.setVisibility(0);
            this.mScanLayout.setVisibility(8);
            this.mRlRiskResult.setVisibility(0);
            this.mLayoutRiskBtn.setVisibility(0);
            this.mTvDelete.setText("一键清除");
            riskLayoutDeal();
            refreshRiskCount();
            this.mScanResultTip.setVisibility(0);
            this.currentState = 4;
            return;
        }
        this.mViewBg.setBackground(getResources().getDrawable(R.mipmap.ic_blue_bg_big));
        this.mViewBg.setBackgroundTintList(ColorStateList.valueOf(-13479169));
        stopGif2Img(R.mipmap.ic_scan_finish);
        this.mScanResultTip.setText("安全");
        this.mScanResultTip.setVisibility(0);
        this.mScanState.setText("建议定期检测清理，国家反诈中心实时守护您的网络安全");
        this.mScanState.setBackground(getResources().getDrawable(R.drawable.button_bg_blue_dark));
        this.mScanState.setVisibility(0);
        this.mStopScan.setText("安全返回");
        this.mStopScan.setBackground(getResources().getDrawable(R.drawable.button_bg_them));
        this.mStopScan.setVisibility(0);
        this.mScanLayout.setVisibility(8);
        this.mRlRiskResult.setVisibility(8);
        this.mRlSafeResult.setVisibility(0);
        this.mSafeSpace.setVisibility(0);
        int size = hasSingleData(this.mAppChild, 2) ? this.mAppChild.get(2).size() : 0;
        this.mTvAppCount.setText(size + "");
        int size2 = hasSingleData(this.mPackageChild, 2) ? this.mPackageChild.get(2).size() : 0;
        this.mTvPackageCount.setText(size2 + "");
        this.currentState = 3;
    }

    private void checkPermission() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.z}, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPermissionSwitch() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.z}, new c());
    }

    private void cleanCacheData() {
        util.u1.a((List) null, util.u1.C0);
        util.u1.a((List) null, util.u1.D0);
        util.u1.a((List) null, util.u1.E0);
        util.u1.a((List) null, util.u1.F0);
        util.u1.a((List) null, util.u1.G0);
        util.u1.a((List) null, util.u1.H0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealCheck() throws Resources.NotFoundException {
        boolean zA = util.u1.a(util.u1.A0, false);
        boolean zA2 = util.u1.a(util.u1.B0, false);
        if (zA && zA2) {
            util.u1.b(util.u1.B0, false);
            getRiskDate();
            scanResult();
        } else {
            util.u1.b(util.u1.A0, true);
            if (zA2) {
                util.u1.b(util.u1.B0, false);
                cleanCacheData();
            }
            beginScan();
        }
    }

    private void dealScanBegin(ArrayList<ScanResultInfo> arrayList, ArrayList<ArrayList<AppInfoBean>> arrayList2, String str) {
        try {
            arrayList2.add(new ArrayList<>());
            arrayList2.add(new ArrayList<>());
            arrayList2.add(new ArrayList<>());
            arrayList.add(new ScanResultInfo("恶意" + str, 0));
            arrayList.add(new ScanResultInfo("风险" + str, 0));
            arrayList.add(new ScanResultInfo("安全" + str, 0));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealScanResult(ArrayList<ScanResultInfo> arrayList, ArrayList<ArrayList<AppInfoBean>> arrayList2, ArrayList<AppInfoBean> arrayList3, ArrayList<AppInfoBean> arrayList4, ArrayList<AppInfoBean> arrayList5, String str) {
        try {
            arrayList.add(new ScanResultInfo("恶意" + str, arrayList3.size()));
            arrayList.add(new ScanResultInfo("风险" + str, arrayList4.size()));
            arrayList.add(new ScanResultInfo("安全" + str, arrayList5.size()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void deleteSelect() throws Resources.NotFoundException {
        if (hasSelect()) {
            Iterator it = ((ArrayList) this.mAllSelectList.clone()).iterator();
            String str = "";
            while (it.hasNext()) {
                AppInfoBean appInfoBean = (AppInfoBean) it.next();
                if (!appInfoBean.isTypeIsApp()) {
                    File file = new File(appInfoBean.getPkgPath());
                    try {
                        if (needDelete(appInfoBean) && file.exists() && file.isFile() && file.delete()) {
                            str = str + "“" + appInfoBean.getName() + "”、";
                            this.mAllSelectList.remove(appInfoBean);
                            this.mAllRiskList.remove(appInfoBean);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            if (TextUtils.isEmpty(str)) {
                nextUninstall();
                return;
            }
            refreshAfterDelete();
            String strSubstring = str.substring(0, str.length() - 1);
            util.b1.b(this.mActivity, "已删除" + strSubstring + "安装包", "确定", new f());
        }
    }

    private ArrayList<AppInfoBean> getRiskData(String str, boolean z) {
        ArrayList<AppInfoBean> arrayList = new ArrayList<>();
        for (AppBean appBean : util.u1.b(str, AppBean.class)) {
            arrayList.add(AppBean.AppBean2AppInfoBean(appBean, z ? new BitmapDrawable(j.c.a(appBean.getName(), appBean.getVersionName(), j.c.f17005c)) : null, appBean.getVirusName(), appBean.getVirusDescription(), appBean.isScaned(), appBean.getLastTime()));
        }
        return arrayList;
    }

    private void getRiskDate() {
        this.mAppChild.clear();
        this.mPackageChild.clear();
        this.mAppChild.add(getRiskData(util.u1.C0, true));
        this.mAppChild.add(getRiskData(util.u1.D0, true));
        this.mAppChild.add(getRiskData(util.u1.E0, false));
        this.mPackageChild.add(getRiskData(util.u1.F0, true));
        this.mPackageChild.add(getRiskData(util.u1.G0, true));
        this.mPackageChild.add(getRiskData(util.u1.H0, false));
        cleanCacheData();
    }

    private boolean hasRiskData(ArrayList<ArrayList<AppInfoBean>> arrayList) {
        if (arrayList != null && arrayList.size() == 3) {
            if (arrayList.get(0) != null && arrayList.get(0).size() > 0) {
                return true;
            }
            if (arrayList.get(1) != null && arrayList.get(1).size() > 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasSelect() {
        ArrayList<AppInfoBean> arrayList = this.mAllSelectList;
        return arrayList != null && arrayList.size() > 0;
    }

    private boolean hasSingleData(ArrayList<ArrayList<AppInfoBean>> arrayList, int i2) {
        return arrayList != null && arrayList.size() == 3 && arrayList.get(i2) != null && arrayList.get(i2).size() > 0;
    }

    private RiskAppSelectAdapter initRecycleView(RecyclerView recyclerView, List<AppInfoBean> list) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        RiskAppSelectAdapter riskAppSelectAdapter = new RiskAppSelectAdapter(R.layout.recyclerview_app_select_risk, list);
        riskAppSelectAdapter.a(recyclerView);
        recyclerView.setAdapter(riskAppSelectAdapter);
        riskAppSelectAdapter.setOnItemChildClickListener(this);
        riskAppSelectAdapter.setOnItemClickListener(new d());
        return riskAppSelectAdapter;
    }

    private void initReport() {
    }

    private void initRiskLayout() {
        this.mRiskAdapter = initRecycleView(this.mRecyclerviewRisk, new ArrayList());
    }

    private void initWarn() {
        this.mBasePresenter = new BasePagePresenter(this.mActivity);
        this.mTvApp.setTypeface(this.typ_ME);
        boolean zA = util.u1.a(util.u1.H, false);
        if (ContextCompat.checkSelfPermission(this, util.permissionutil.a.z) == 0 && this.mBasePresenter.isOpenFlowPrim() && zA) {
            this.mSwitchApp.setChecked(true);
        } else {
            this.mSwitchApp.setChecked(false);
            util.u1.b(util.u1.H, false);
        }
        this.mSwitchApp.setOnCheckedChangeListener(new a());
    }

    private void itemClick(int i2, List<AppInfoBean> list, RiskAppSelectAdapter riskAppSelectAdapter) {
        AppInfoBean appInfoBean = list.get(i2);
        if (appInfoBean.getFileSize() > 209715200) {
            util.w1.a("200M以上文件不可选择");
            return;
        }
        if (appInfoBean.isSelect()) {
            appInfoBean.setSelect(false);
            this.mAllSelectList.remove(appInfoBean);
        } else {
            if (this.mAllSelectList.size() == this.mSelectLimit) {
                util.w1.a("最多选择" + this.mSelectLimit + "个");
                return;
            }
            appInfoBean.setSelect(true);
            if (!this.mAllSelectList.contains(appInfoBean)) {
                this.mAllSelectList.add(appInfoBean);
            }
        }
        riskAppSelectAdapter.notifyDataSetChanged();
        if (hasSelect()) {
            changeReportState(true);
        } else {
            changeReportState(false);
        }
    }

    private boolean needDelete(AppInfoBean appInfoBean) {
        return !this.isReportBack || appInfoBean.getSource() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nextUninstall() {
        boolean z;
        if (!hasSelect()) {
            changeReportState(false);
            return;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.mAllSelectList.size()) {
                z = false;
                break;
            }
            AppInfoBean appInfoBean = this.mAllSelectList.get(i2);
            if (needDelete(appInfoBean) && appInfoBean.isTypeIsApp() && !appInfoBean.isCancleUninstall()) {
                uninstall(appInfoBean.getPkgName());
                this.mUninstallPosition = i2;
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            return;
        }
        this.isReportBack = false;
        this.mUninstallPosition = -1;
        if (!hasSelect()) {
            changeReportState(false);
            return;
        }
        Iterator<AppInfoBean> it = this.mAllSelectList.iterator();
        while (it.hasNext()) {
            AppInfoBean next = it.next();
            if (next.isTypeIsApp()) {
                next.setCancleUninstall(false);
            }
        }
        changeReportState(true);
    }

    private void pauseScanApp() {
        ui.e.b.e().c();
    }

    private void refreshAfterDelete() throws Resources.NotFoundException {
        this.mRiskAdapter.setNewData(this.mAllRiskList);
        ArrayList<AppInfoBean> arrayList = this.mAllRiskList;
        if (arrayList != null) {
            if (arrayList.size() > 0) {
                refreshRiskCount();
            } else {
                this.isReportBack = false;
                changeScanState(3);
            }
        }
    }

    private void refreshRiskCount() {
        ArrayList<AppInfoBean> arrayList = this.mAllRiskList;
        int size = (arrayList == null || arrayList.size() <= 0) ? 0 : this.mAllRiskList.size();
        this.mScanResultTip.setText("发现" + size + "项可疑应用");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI(TextView textView, ScanAppAdapter scanAppAdapter, RecyclerView recyclerView, List<AppInfoBean> list, AppInfoBean appInfoBean) {
        if (list == null) {
            scanAppAdapter.a((ScanAppAdapter) appInfoBean);
        } else {
            scanAppAdapter.a((Collection) list);
        }
        textView.setText(scanAppAdapter.getItemCount() + "");
        scanAppAdapter.notifyDataSetChanged();
        recyclerView.scrollToPosition(scanAppAdapter.getItemCount() + (-1));
    }

    private void riskLayoutDeal() {
        this.mAllRiskList.clear();
        this.mAllRiskList.addAll(this.mAppChild.get(0));
        this.mAllRiskList.addAll(this.mAppChild.get(1));
        this.mAllRiskList.addAll(this.mPackageChild.get(0));
        this.mAllRiskList.addAll(this.mPackageChild.get(1));
        updataRidkLayout(this.mRiskAdapter, this.mAllRiskList);
        this.mRecyclerviewRisk.setVisibility(0);
        changeReportState(false);
    }

    private void scanApp() {
        if (!this.isAppScanning) {
            this.isAppScanning = true;
            j.d.a(this.mIvAppStates, Integer.valueOf(R.mipmap.ic_scan_wait));
            dealScanBegin(this.mAppParent, this.mAppChild, "应用");
            this.virusList = this.mAppChild.get(0);
            this.warnList = this.mAppChild.get(1);
            this.okList = this.mAppChild.get(2);
            RecyclerView recyclerView = this.mRecyclerview;
            if (recyclerView != null) {
                recyclerView.setVisibility(0);
            }
        }
        if (this.mAppScanListener == null) {
            this.mAppScanListener = new g();
        }
        ui.e.b.e().a(this, 1, this.mAppScanListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scanPackage() {
        if (isFinishing()) {
            return;
        }
        this.isAppScanning = false;
        if (!this.isPackageScanning) {
            this.isPackageScanning = true;
            j.d.a(this.mIvApkStates, Integer.valueOf(R.mipmap.ic_scan_wait));
            dealScanBegin(this.mPackageParent, this.mPackageChild, "安装包");
            this.virusList = this.mPackageChild.get(0);
            this.warnList = this.mPackageChild.get(1);
            this.okList = this.mPackageChild.get(2);
        }
        if (this.mPackageScanListener == null) {
            this.mPackageScanListener = new h();
        }
        ui.e.b.e().b(this, 1, this.mPackageScanListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scanResult() throws Resources.NotFoundException {
        RecyclerView recyclerView = this.mRecyclerview;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        RecyclerView recyclerView2 = this.mRecyclerview1;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(8);
        }
        if (hasRiskData(this.mAppChild) || hasRiskData(this.mPackageChild)) {
            changeScanState(4);
        } else {
            changeScanState(3);
        }
    }

    private void stopGif2Img(int i2) {
        try {
            if (this.mIvCircle != null) {
                if (this.mIvCircle.getDrawable() != null) {
                    this.mIvCircle.clearAnimation();
                }
                this.mIvCircle.setImageResource(i2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            this.mIvCircle.setImageResource(i2);
        }
    }

    private void stopScanApp() {
        this.isStopScan = true;
        ui.e.b.e().b();
    }

    private void uninstall(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.DELETE");
        intent.setData(Uri.parse("package:" + str));
        startActivityForResult(intent, 1000);
    }

    private void updataRidkLayout(RiskAppSelectAdapter riskAppSelectAdapter, List<AppInfoBean> list) {
        for (AppInfoBean appInfoBean : list) {
            appInfoBean.setSelect(false);
            appInfoBean.setCancleUninstall(false);
        }
        if (riskAppSelectAdapter == null || list == null || list.size() <= 0) {
            return;
        }
        riskAppSelectAdapter.setNewData(list);
    }

    public /* synthetic */ void a() {
        if (isFinishing()) {
            return;
        }
        boolean zIsOpenFlowPrim = this.mBasePresenter.isOpenFlowPrim();
        if (this.isToOpenFlow && zIsOpenFlowPrim) {
            this.isToOpenFlow = false;
            if (ContextCompat.checkSelfPermission(this, util.permissionutil.a.z) == 0) {
                this.mSwitchApp.setChecked(true);
                util.u1.b(util.u1.H, true);
            } else {
                this.mSwitchApp.setChecked(false);
                util.u1.b(util.u1.H, false);
            }
        }
    }

    @Override // ui.activity.BaseActivity
    public void initPage() throws Resources.NotFoundException {
        if (!AccountManager.isLogin()) {
            finish();
            return;
        }
        StatisticsHttp.getInstance().pageOpenHttp(e.d.p);
        this.mTvTitle.setText("APP自检");
        this.mTvTitle.setTypeface(this.typ_ME);
        ui.statusbarcompat.b.a((Activity) this, true, false);
        initRiskLayout();
        org.greenrobot.eventbus.c.f().e(this);
        this.mPresenter = new VirusKillingPresenter((Activity) this, (VirusKillingCallView) this);
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter = new ScanAppAdapter(R.layout.recyclerview_app_scan);
        this.mAdapter.a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.mAdapter);
        this.mRecyclerview1.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter1 = new ScanAppAdapter(R.layout.recyclerview_app_scan);
        this.mAdapter1.a(this.mRecyclerview1);
        this.mRecyclerview1.setAdapter(this.mAdapter1);
        this.options = new com.bumptech.glide.r.h();
        this.options.a(com.bumptech.glide.load.p.j.f4571b);
        changeScanState(0);
        try {
            this.mScanApp.setText("等待检测应用");
            this.mScanPackage.setText("等待检测安装包");
            j.d.a(this.mIvAppStates, Integer.valueOf(R.mipmap.ic_scan_wait));
            j.d.a(this.mIvApkStates, Integer.valueOf(R.mipmap.ic_scan_wait));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        initWarn();
        checkPermission();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) throws Resources.NotFoundException {
        ArrayList<AppInfoBean> arrayList;
        super.onActivityResult(i2, i3, intent);
        if (i2 != 1000) {
            if (i2 == 1001 && i3 == -1) {
                this.mAllSelectList.remove(mIntentBean);
                this.mAllRiskList.remove(mIntentBean);
                mIntentBean = null;
                refreshAfterDelete();
                return;
            }
            return;
        }
        if (this.mUninstallPosition == -1 || (arrayList = this.mAllSelectList) == null) {
            return;
        }
        int size = arrayList.size();
        int i4 = this.mUninstallPosition;
        if (size > i4) {
            AppInfoBean appInfoBean = this.mAllSelectList.get(i4);
            if (util.r1.d(appInfoBean.getPkgName())) {
                appInfoBean.setCancleUninstall(true);
                if (this.isReportBack) {
                    appInfoBean.setSource(0);
                }
            } else {
                this.mAllSelectList.remove(appInfoBean);
                this.mAllRiskList.remove(appInfoBean);
                this.mUninstallPosition = -1;
                refreshAfterDelete();
            }
            nextUninstall();
        }
    }

    @Override // ui.callview.VirusKillingCallView
    public void onAppealSuccess() throws Resources.NotFoundException {
        util.b1.a((Activity) this, false, 1, "错误信息上报成功", R.drawable.iv_comit_succ);
        this.mAllSelectList.clear();
        changeReportState(false);
        Iterator<AppInfoBean> it = this.mAllRiskList.iterator();
        while (it.hasNext()) {
            it.next().setSelect(false);
        }
        refreshAfterDelete();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void a() {
        stopScanApp();
        finish();
        super.a();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
        j.c.a(j.c.f17005c);
        this.isStopScan = true;
        ui.e.b.e().b();
    }

    @org.greenrobot.eventbus.m(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventWornThread(util.c2.a aVar) {
        if (aVar == null || aVar.a() != 26) {
            return;
        }
        org.greenrobot.eventbus.c.f().f(aVar);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (!Hicore.getApp().isDouble() && view.getId() == R.id.iv_checkbox) {
            itemClick(i2, this.mAllRiskList, this.mRiskAdapter);
        }
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        super.onResume();
        y1.f21027b.postDelayed(new Runnable() { // from class: ui.activity.m1
            @Override // java.lang.Runnable
            public final void run() {
                this.f19446a.a();
            }
        }, 500L);
        if (this.isToOpenStorage && ContextCompat.checkSelfPermission(this, util.permissionutil.a.z) == 0) {
            this.isToOpenStorage = false;
            dealCheck();
        }
    }

    @OnClick({R.id.iv_back, R.id.layout_app, R.id.layout_apk, R.id.stop_scan, R.id.tv_appeal, R.id.tv_delete, R.id.tv_appeal_wb})
    public void onViewClicked(View view) throws Resources.NotFoundException {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.iv_back /* 2131296762 */:
                a();
                break;
            case R.id.layout_apk /* 2131296880 */:
                if (this.isAllFinishScan && (recyclerView = this.mRecyclerview1) != null) {
                    if (recyclerView.getVisibility() != 8) {
                        this.mRecyclerview1.setVisibility(8);
                        break;
                    } else {
                        this.mRecyclerview1.setVisibility(0);
                        break;
                    }
                }
                break;
            case R.id.layout_app /* 2131296881 */:
                if (this.isAllFinishScan && (recyclerView2 = this.mRecyclerview) != null) {
                    if (recyclerView2.getVisibility() != 8) {
                        this.mRecyclerview.setVisibility(8);
                        break;
                    } else {
                        this.mRecyclerview.setVisibility(0);
                        break;
                    }
                }
                break;
            case R.id.stop_scan /* 2131297304 */:
                btnDeal();
                break;
            case R.id.tv_appeal /* 2131297426 */:
                appealSelect();
                break;
            case R.id.tv_appeal_wb /* 2131297427 */:
                util.b1.a(this.mActivity);
                break;
            case R.id.tv_delete /* 2131297512 */:
                deleteSelect();
                break;
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        if (AccountManager.isLogin()) {
            return R.layout.activity_virus_killing;
        }
        finish();
        return R.layout.activity_virus_killing;
    }

    class g implements ui.e.c {
        g() {
        }

        @Override // ui.e.c
        public void a(int i2) {
            if (VirusKillingActivity.this.isStopScan) {
                return;
            }
            util.n1.c("Scanner", "APP总数=" + i2);
        }

        @Override // ui.e.c
        public void b() {
            util.n1.c("Scanner", "检测应用-----------------scanStop");
            try {
                VirusKillingActivity.this.btnDeal();
                if (VirusKillingActivity.this.mIvAppStates != null) {
                    j.d.a(VirusKillingActivity.this.mIvAppStates, Integer.valueOf(R.mipmap.ic_scan_wait));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // ui.e.c
        public void c() {
            if (VirusKillingActivity.this.isStopScan) {
                return;
            }
            util.n1.c("Scanner", "开始检测");
            try {
                VirusKillingActivity.this.mScanApp.setText("正在检测应用");
                VirusKillingActivity.this.mScanPackage.setText("等待检测安装包");
                j.d.a(VirusKillingActivity.this.mIvAppStates, Integer.valueOf(R.mipmap.ic_scan_loading));
                j.d.a(VirusKillingActivity.this.mIvApkStates, Integer.valueOf(R.mipmap.ic_scan_wait));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // ui.e.c
        public void a(List<AppInfoBean> list, AppInfoBean appInfoBean) {
            if (VirusKillingActivity.this.isStopScan) {
                return;
            }
            VirusKillingActivity virusKillingActivity = VirusKillingActivity.this;
            virusKillingActivity.refreshUI(virusKillingActivity.mScanAppCount, virusKillingActivity.mAdapter, VirusKillingActivity.this.mRecyclerview, list, appInfoBean);
            util.n1.b("scanSingleIng-->", "data " + VirusKillingActivity.this.mAdapter.c().size());
        }

        @Override // ui.e.c
        public void a(List<AppInfoBean> list) {
            try {
                for (AppInfoBean appInfoBean : list) {
                    appInfoBean.setFlag(1);
                    appInfoBean.setSelect(false);
                    appInfoBean.setTypeIsApp(true);
                    int virusLevel = appInfoBean.getVirusLevel();
                    if (virusLevel == 1) {
                        VirusKillingActivity.this.virusList.add(appInfoBean);
                    } else if (virusLevel == 2) {
                        VirusKillingActivity.this.warnList.add(appInfoBean);
                    } else {
                        appInfoBean.setVirusLevel(0);
                        VirusKillingActivity.this.okList.add(appInfoBean);
                    }
                    util.n1.c("Scanner", "检测完成应用=======" + appInfoBean.getName() + "==" + appInfoBean.getPkgName());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // ui.e.c
        public void a() {
            if (VirusKillingActivity.this.isStopScan) {
                return;
            }
            util.n1.c("Scanner", "检测完成");
            VirusKillingActivity.this.mAdapter.notifyDataSetChanged();
            VirusKillingActivity virusKillingActivity = VirusKillingActivity.this;
            virusKillingActivity.dealScanResult(virusKillingActivity.mAppParent, VirusKillingActivity.this.mAppChild, VirusKillingActivity.this.virusList, VirusKillingActivity.this.warnList, VirusKillingActivity.this.okList, "应用");
            VirusKillingActivity virusKillingActivity2 = VirusKillingActivity.this;
            TextView textView = virusKillingActivity2.mScanApp;
            if (textView != null && virusKillingActivity2.mIvAppStates != null) {
                textView.setText("检测应用完成");
                j.d.b(VirusKillingActivity.this.mIvAppStates, Integer.valueOf(R.mipmap.ic_scan_ok));
            }
            VirusKillingActivity.this.scanPackage();
        }
    }

    class h implements ui.e.c {
        h() {
        }

        @Override // ui.e.c
        public void a(int i2) {
            if (VirusKillingActivity.this.isStopScan) {
                return;
            }
            util.n1.c("Scanner", "开始检测安装包个数=====" + i2);
        }

        @Override // ui.e.c
        public void b() {
            util.n1.c("Scanner", "检测安装包       scanStop=====");
            try {
                VirusKillingActivity.this.btnDeal();
                if (VirusKillingActivity.this.mIvApkStates != null) {
                    j.d.a(VirusKillingActivity.this.mIvApkStates, Integer.valueOf(R.mipmap.ic_scan_wait));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // ui.e.c
        public void c() {
            util.n1.c("Scanner", "开始检测安装包=====");
            if (VirusKillingActivity.this.isStopScan) {
                return;
            }
            RecyclerView recyclerView = VirusKillingActivity.this.mRecyclerview;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            try {
                VirusKillingActivity.this.mScanPackage.setText("正在检测安装包");
                j.d.a(VirusKillingActivity.this.mIvApkStates, Integer.valueOf(R.mipmap.ic_scan_loading));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // ui.e.c
        public void a(List<AppInfoBean> list, AppInfoBean appInfoBean) {
            if (VirusKillingActivity.this.isStopScan) {
                return;
            }
            VirusKillingActivity virusKillingActivity = VirusKillingActivity.this;
            virusKillingActivity.refreshUI(virusKillingActivity.mScanPackageCount, virusKillingActivity.mAdapter1, VirusKillingActivity.this.mRecyclerview1, list, appInfoBean);
        }

        @Override // ui.e.c
        public void a(List<AppInfoBean> list) {
            try {
                for (AppInfoBean appInfoBean : list) {
                    appInfoBean.setFlag(1);
                    appInfoBean.setSelect(false);
                    appInfoBean.setTypeIsApp(false);
                    int virusLevel = appInfoBean.getVirusLevel();
                    if (virusLevel == 1) {
                        VirusKillingActivity.this.virusList.add(appInfoBean);
                    } else if (virusLevel == 2) {
                        VirusKillingActivity.this.warnList.add(appInfoBean);
                    } else {
                        appInfoBean.setVirusLevel(0);
                        if (appInfoBean.getAppIcon() != null && !TextUtils.isEmpty(appInfoBean.getName())) {
                            VirusKillingActivity.this.okList.add(appInfoBean);
                        }
                    }
                    util.n1.c("Scanner", "检测完成安装包=======" + appInfoBean.getName() + "==" + appInfoBean.getPkgName());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // ui.e.c
        @SuppressLint({"RestrictedApi"})
        public void a() {
            if (VirusKillingActivity.this.isStopScan) {
                return;
            }
            try {
                VirusKillingActivity.this.mScanPackage.setText("检测安装包完成");
                j.d.b(VirusKillingActivity.this.mIvApkStates, Integer.valueOf(R.mipmap.ic_scan_ok));
                VirusKillingActivity.this.dealScanResult(VirusKillingActivity.this.mPackageParent, VirusKillingActivity.this.mPackageChild, VirusKillingActivity.this.virusList, VirusKillingActivity.this.warnList, VirusKillingActivity.this.okList, "安装包");
                VirusKillingActivity.this.scanResult();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            VirusKillingActivity.this.isPackageScanning = false;
            VirusKillingActivity.this.isAllFinishScan = true;
        }
    }
}
