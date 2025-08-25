package ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.airbnb.lottie.LottieAnimationView;
import com.hicorenational.antifraud.R;
import manager.AccountManager;
import network.http.StatisticsHttp;
import ui.Hicore;
import ui.presenter.BasePagePresenter;
import ui.view.SwitchButton;
import ui.view.swip.SwipBackLayout;
import util.y1;

/* loaded from: classes2.dex */
public class WarnSettingActivity extends BaseActivity {

    /* renamed from: a, reason: collision with root package name */
    BasePagePresenter f19323a;

    /* renamed from: b, reason: collision with root package name */
    private LottieAnimationView f19324b;

    /* renamed from: c, reason: collision with root package name */
    private String f19325c = "";

    @BindView(R.id.iv_back)
    ImageView mIvBack;

    @BindView(R.id.iv_right)
    ImageView mIvRight;

    @BindView(R.id.layout_open)
    ConstraintLayout mLayoutOpen;

    @BindView(R.id.switch_app)
    SwitchButton mSwitchApp;

    @BindView(R.id.switch_call)
    SwitchButton mSwitchCall;

    @BindView(R.id.switch_sms)
    SwitchButton mSwitchSms;

    @BindView(R.id.tv_app)
    TextView mTvApp;

    @BindView(R.id.tv_call)
    TextView mTvCall;

    @BindView(R.id.tv_content)
    TextView mTvContent;

    @BindView(R.id.tv_content_second)
    TextView mTvContentSecond;

    @BindView(R.id.tv_go_permission)
    TextView mTvGoPermission;

    @BindView(R.id.tv_sms)
    TextView mTvSms;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    class a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f19326a;

        a(String str) {
            this.f19326a = str;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            util.u1.b(this.f19326a, z);
            if (z) {
                WarnSettingActivity.this.b(true);
            } else {
                WarnSettingActivity.this.b();
            }
            switch (compoundButton.getId()) {
                case R.id.switch_call /* 2131297323 */:
                    StatisticsHttp.getInstance().trackWarnCall(z ? "1" : "0", null);
                    break;
                case R.id.switch_sms /* 2131297324 */:
                    StatisticsHttp.getInstance().trackWarnSms(z ? "1" : "0", null);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        b(util.u1.a(util.u1.F, false) || util.u1.a(util.u1.G, false));
    }

    private void checkPermission() {
        if (!util.permissionutil.c.a(this.mActivity, this.f19323a.checkPermission()) || !this.f19323a.isOpenFlowPrim()) {
            this.mSwitchCall.setVisibility(8);
            this.mSwitchSms.setVisibility(8);
            this.mTvGoPermission.setVisibility(0);
            b(false);
            util.u1.b(util.u1.F, false);
            util.u1.b(util.u1.G, false);
            return;
        }
        this.mSwitchCall.setVisibility(0);
        this.mSwitchSms.setVisibility(0);
        this.mTvGoPermission.setVisibility(8);
        boolean zA = util.u1.a(util.u1.F, false);
        boolean zA2 = util.u1.a(util.u1.G, false);
        boolean zA3 = util.u1.a(util.u1.H, false);
        if (!zA && !zA2) {
            b(false);
            return;
        }
        if (zA) {
            this.mSwitchCall.setChecked(true);
        }
        if (zA2) {
            this.mSwitchSms.setChecked(true);
        }
        if (zA3) {
            StatisticsHttp.getInstance().trackWarnApp(zA3 ? "1" : "0", null);
        }
        b(true);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        StatisticsHttp.getInstance().pageOpenHttp(e.d.n);
        ui.statusbarcompat.b.a((Activity) this, true, false);
        SwipBackLayout.a(this.mActivity).a();
        this.mTvTitle.setText("来电预警");
        this.mIvRight.setImageResource(R.mipmap.ic_warn_setting);
        this.mTvCall.setTypeface(this.typ_ME);
        this.mTvSms.setTypeface(this.typ_ME);
        this.mTvApp.setTypeface(this.typ_ME);
        this.f19323a = new BasePagePresenter(this.mActivity);
        a(this.mSwitchCall, util.u1.F);
        a(this.mSwitchSms, util.u1.G);
        a();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        LottieAnimationView lottieAnimationView = this.f19324b;
        if (lottieAnimationView != null) {
            lottieAnimationView.a();
            this.f19324b.clearAnimation();
            this.f19324b.clearFocus();
        }
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        LottieAnimationView lottieAnimationView = this.f19324b;
        if (lottieAnimationView != null) {
            lottieAnimationView.g();
        }
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        LottieAnimationView lottieAnimationView = this.f19324b;
        if (lottieAnimationView != null) {
            lottieAnimationView.h();
        }
        checkPermission();
    }

    @OnClick({R.id.iv_back, R.id.iv_right, R.id.tv_go_permission, R.id.tv_error_free})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case R.id.iv_back /* 2131296762 */:
                finish();
                break;
            case R.id.iv_right /* 2131296826 */:
            case R.id.tv_go_permission /* 2131297560 */:
                y1.a((Context) this.mActivity, (Class<?>) WarnPrimessActivity.class);
                break;
            case R.id.tv_error_free /* 2131297548 */:
                String str = d.a.f13521g + e.b.z;
                Intent intent = new Intent(this.mActivity, (Class<?>) WebActivity.class);
                intent.putExtra(util.k1.P, "错误上报");
                intent.putExtra(util.k1.Q, str + AccountManager.getShareParam());
                startActivity(intent);
                break;
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_warn_setting;
    }

    private void a() {
        this.f19324b = (LottieAnimationView) findViewById(R.id.lottie_likeanim);
        this.f19324b.setRenderMode(com.airbnb.lottie.t.SOFTWARE);
        this.f19324b.setImageAssetsFolder("images/");
        this.f19324b.setAnimation("lottie_on.json");
        this.f19324b.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (a(z)) {
            return;
        }
        if (z) {
            this.mTvContent.setText("来电预警守护中");
            this.mTvContentSecond.setText("准确识别电信诈骗");
        } else {
            this.mTvContent.setText("来电预警未开启");
            this.mTvContentSecond.setText("无法准确识别电信诈骗，请立即开启");
        }
    }

    private void a(SwitchButton switchButton, String str) {
        switchButton.setOnCheckedChangeListener(new a(str));
    }

    private boolean a(boolean z) {
        String str = z ? "lottie_on.json" : "lottie_off.json";
        if (TextUtils.equals(str, this.f19325c)) {
            return true;
        }
        this.f19325c = str;
        this.f19324b.setAnimation(str);
        this.f19324b.h();
        return false;
    }
}
