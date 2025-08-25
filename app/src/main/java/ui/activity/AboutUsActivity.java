package ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IBaseBeanCall;
import network.DownloadInfo;
import network.account.APIresult;
import ui.Hicore;
import ui.callview.AboutUsView;
import ui.presenter.AboutUsPresenter;
import ui.presenter.WelocmPresenter;
import ui.view.swip.SwipBackLayout;
import util.UpdateUtil;

/* loaded from: classes2.dex */
public class AboutUsActivity extends BaseActivity implements AboutUsView {

    @BindView(R.id.check_upadte)
    Button mChenkBtn;
    AboutUsPresenter mPresent;

    @BindView(R.id.tv_new_tips)
    TextView mTvAppTip;

    @BindView(R.id.tv_app_version)
    TextView mTvAppVersion;

    @BindView(R.id.tv_owner_tip)
    TextView mTvOwnerTip;

    @BindView(R.id.tv_sdk_version)
    TextView mTvSdk;

    @BindView(R.id.tv_tech_sup)
    TextView mTvTechSupor;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    class a implements IBaseBeanCall<APIresult<DownloadInfo>> {
        a() {
        }

        @Override // interfaces.IBaseBeanCall
        public void onClose() {
        }

        @Override // interfaces.IBaseBeanCall
        public void onfail() {
            util.w1.a("已是最新版本");
        }

        @Override // interfaces.IBaseBeanCall
        public void onsuccess(APIresult<DownloadInfo> aPIresult) {
            util.b1.a();
        }
    }

    public static void callPhone(Context context, String str) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:" + str));
        context.startActivity(intent);
    }

    private void testTip() {
        String str;
        if (!com.hicorenational.antifraud.a.n.booleanValue()) {
            this.mTvSdk.setVisibility(8);
            return;
        }
        this.mTvSdk.setVisibility(0);
        try {
            str = util.r1.f() + "";
        } catch (Exception e2) {
            e2.printStackTrace();
            str = a.a.u.a.n;
        }
        this.mTvSdk.setText("国家反诈v2.0.17.0224.149(code " + str + ")\n" + ("渠道：" + Hicore.getApp().getChannel()) + c.c.a.b.a.a.f3100g + com.hicorenational.antifraud.a.o + "release");
    }

    private void updateDlg() {
        util.b1.a("检测中...", true, this.mActivity);
        UpdateUtil.updateAppOnly(this.mActivity, new a());
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        ui.statusbarcompat.b.a((Activity) this, true, false);
        this.mTvTitle.setText("关于我们");
        this.mPresent = new AboutUsPresenter(this.mActivity, this);
        String strB = util.r1.b(this);
        this.mTvAppVersion.setText("v" + strB);
        testTip();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @OnClick({R.id.iv_back, R.id.ll_agreement, R.id.ll_policy, R.id.check_upadte})
    public void onViewClicked(View view) {
        String str;
        String str2;
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case R.id.check_upadte /* 2131296444 */:
                updateDlg();
                break;
            case R.id.iv_back /* 2131296762 */:
                finish();
                break;
            case R.id.ll_agreement /* 2131296916 */:
                if (TextUtils.isEmpty(WelocmPresenter.XY_service)) {
                    str = d.a.f13520f + e.b.x;
                } else {
                    str = WelocmPresenter.XY_service;
                }
                String str3 = str + "?time=" + d.a.m();
                Intent intent = new Intent(this.mActivity, (Class<?>) WebActivity.class);
                intent.putExtra(util.k1.P, "服务协议");
                intent.putExtra(util.k1.Q, str3);
                startActivity(intent);
                break;
            case R.id.ll_policy /* 2131296966 */:
                if (TextUtils.isEmpty(WelocmPresenter.XY_conceal)) {
                    str2 = d.a.f13520f + e.b.w;
                } else {
                    str2 = WelocmPresenter.XY_conceal;
                }
                String str4 = str2 + "?time=" + d.a.m();
                Intent intent2 = new Intent(this.mActivity, (Class<?>) WebActivity.class);
                intent2.putExtra(util.k1.P, "隐私政策");
                intent2.putExtra(util.k1.Q, str4);
                startActivity(intent2);
                break;
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_about_us;
    }
}
