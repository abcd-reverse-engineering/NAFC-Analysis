package ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.AppInfoBean;
import bean.AppVirusBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import interfaces.IOneClickListener;
import java.io.File;
import java.util.ArrayList;
import org.greenrobot.eventbus.ThreadMode;
import ui.Hicore;
import ui.callview.VirusKillingCallView;
import ui.presenter.VirusKillingPresenter;
import ui.view.swip.SwipBackLayout;

/* loaded from: classes2.dex */
public class VirusDetailActivity extends BaseActivity {

    /* renamed from: a, reason: collision with root package name */
    private AppInfoBean f19220a = null;

    /* renamed from: b, reason: collision with root package name */
    private VirusKillingPresenter f19221b = null;

    @BindView(R.id.imageview)
    ImageView mImageview;

    @BindView(R.id.tv_app_name)
    TextView mTvAppName;

    @BindView(R.id.tv_app_version)
    TextView mTvAppVersion;

    @BindView(R.id.tv_delete)
    TextView mTvDelete;

    @BindView(R.id.tv_describe)
    TextView mTvDescribe;

    @BindView(R.id.tv_risk_flag)
    TextView mTvRiskFlag;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @BindView(R.id.tv_name)
    TextView mTvVirusName;

    class a implements VirusKillingCallView {
        a() {
        }

        @Override // ui.callview.VirusKillingCallView
        public void onAppealSuccess() {
            util.b1.a((Activity) VirusDetailActivity.this, false, 1, "错误信息上报成功", R.drawable.iv_comit_succ);
        }
    }

    class b implements IClickListener {
        b() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            ArrayList arrayList = new ArrayList();
            AppVirusBean appVirusBean = new AppVirusBean();
            appVirusBean.setAppName(VirusDetailActivity.this.f19220a.getName());
            appVirusBean.setFileMd5(VirusDetailActivity.this.f19220a.getAppMD5());
            appVirusBean.setVersionCode(VirusDetailActivity.this.f19220a.getVersionCode() + "");
            appVirusBean.setPkgName(VirusDetailActivity.this.f19220a.getPkgName());
            appVirusBean.setSignHash(VirusDetailActivity.this.f19220a.getSignHash());
            appVirusBean.setFindTime(util.v1.a(System.currentTimeMillis()));
            appVirusBean.setVirusDescription(VirusDetailActivity.this.f19220a.getVirusDescription());
            appVirusBean.setVirusName(VirusDetailActivity.this.f19220a.getVirusName());
            int virusLevel = VirusDetailActivity.this.f19220a.getVirusLevel();
            if (virusLevel == 1) {
                appVirusBean.setVirusLevel(1);
                appVirusBean.setIllegalType("病毒");
            } else if (virusLevel == 2) {
                appVirusBean.setVirusLevel(2);
                appVirusBean.setIllegalType("风险");
            }
            arrayList.add(appVirusBean);
            VirusDetailActivity.this.f19221b.appealApp(arrayList);
        }
    }

    class c implements IOneClickListener {
        c() {
        }

        @Override // interfaces.IOneClickListener
        public void clickOKBtn() {
            VirusDetailActivity.this.a();
        }
    }

    private void appealSelect() {
        util.b1.a(this.mActivity, "确定上报应用错误信息吗", "", "取消", "确定", R.color._A8B4F7, R.color.blue_dark, (IClickListener) new b());
    }

    private void deleteSelect() {
        AppInfoBean appInfoBean = this.f19220a;
        if (appInfoBean == null) {
            return;
        }
        if (appInfoBean.isTypeIsApp()) {
            uninstall(this.f19220a.getPkgName());
            return;
        }
        File file = new File(this.f19220a.getPkgPath());
        try {
            if (file.exists() && file.isFile() && file.delete()) {
                util.b1.b(this.mActivity, "已删除“" + this.f19220a.getName() + "”安装包", "确定", new c());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void uninstall(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.DELETE");
        intent.setData(Uri.parse("package:" + str));
        startActivityForResult(intent, 1000);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        this.mTvTitle.setText("风险详情");
        org.greenrobot.eventbus.c.f().e(this);
        AppInfoBean appInfoBean = VirusKillingActivity.mIntentBean;
        if (appInfoBean != null) {
            this.f19220a = appInfoBean;
            if (this.f19220a.isTypeIsApp()) {
                this.mTvDelete.setText("卸载应用");
            } else {
                this.mTvDelete.setText("删除安装包");
            }
            if (this.f19220a.getVirusLevel() == 1) {
                this.mTvRiskFlag.setText("高危");
                this.mTvRiskFlag.setTextColor(getResources().getColor(R.color.colorRedRiskFlag));
                this.mTvRiskFlag.setBackgroundResource(R.drawable.shape_red);
            } else {
                this.mTvRiskFlag.setText("风险");
                this.mTvRiskFlag.setTextColor(getResources().getColor(R.color.dark_orange));
                this.mTvRiskFlag.setBackgroundResource(R.drawable.shape_orange);
            }
            this.mImageview.setImageDrawable(this.f19220a.getAppIcon());
            this.mTvAppName.setText(this.f19220a.getName());
            this.mTvAppVersion.setText("版本号：" + this.f19220a.getVersionName());
            this.mTvVirusName.setText(this.f19220a.getDealVirusName());
            this.mTvDescribe.setText(this.f19220a.getDealVirusDescription());
        }
        this.f19221b = new VirusKillingPresenter((Activity) this, (VirusKillingCallView) new a());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        AppInfoBean appInfoBean;
        super.onActivityResult(i2, i3, intent);
        if (i2 != 1000 || (appInfoBean = this.f19220a) == null || util.r1.d(appInfoBean.getPkgName())) {
            return;
        }
        a();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventWornThread(util.c2.a aVar) {
        if (aVar == null || aVar.a() != 26) {
            return;
        }
        org.greenrobot.eventbus.c.f().f(aVar);
    }

    @OnClick({R.id.iv_back, R.id.tv_delete, R.id.tv_appeal})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.iv_back) {
            finish();
        } else if (id == R.id.tv_appeal) {
            appealSelect();
        } else {
            if (id != R.id.tv_delete) {
                return;
            }
            deleteSelect();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_risk_detail;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        setResult(-1);
        finish();
    }
}
