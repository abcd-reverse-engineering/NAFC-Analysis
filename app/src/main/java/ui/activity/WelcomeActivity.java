package ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import bean.AdBean;
import bean.PushEntity;
import bean.module.LocalModuelConfig;
import bean.module.RegionMudelBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.airbnb.lottie.LottieAnimationView;
import com.hicorenational.antifraud.R;
import com.umeng.message.UmengNotifyClickActivity;
import interfaces.IBaseBeanCall;
import interfaces.IClickListener;
import interfaces.IOneClickListener;
import interfaces.IResultCallback;
import interfaces.PermissionsListener;
import java.util.List;
import manager.AccountManager;
import network.DownloadInfo;
import network.account.APIresult;
import network.http.StatisticsHttp;
import ui.Hicore;
import ui.callview.WelcomeCallView;
import ui.presenter.JNIHandStamp;
import ui.presenter.WelocmPresenter;
import util.UpdateUtil;
import util.y1;

/* loaded from: classes2.dex */
public class WelcomeActivity extends UmengNotifyClickActivity implements WelcomeCallView {
    private ui.view.p downTimer;
    private PushEntity entity;
    private AdBean mAdBean = null;

    @BindView(R.id.cl_layout)
    ConstraintLayout mClLayout;

    @BindView(R.id.image)
    ImageView mImage;

    @BindView(R.id.lottie_likeanim)
    LottieAnimationView mLottieLike;

    @BindView(R.id.tv_next)
    TextView mTvNext;
    private WelocmPresenter presenter;

    class a implements IOneClickListener {
        a() {
        }

        @Override // interfaces.IOneClickListener
        public void clickOKBtn() {
            WelcomeActivity.this.finishPage();
        }
    }

    class b implements IOneClickListener {
        b() {
        }

        @Override // interfaces.IOneClickListener
        public void clickOKBtn() {
            WelcomeActivity.this.presenter.requestPartDircly();
        }
    }

    class c implements PermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f19388a;

        c(long j2) {
            this.f19388a = j2;
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            WelcomeActivity.this.showUpdateDlg(this.f19388a);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            WelcomeActivity.this.showUpdateDlg(this.f19388a);
        }
    }

    class d implements IBaseBeanCall<APIresult<DownloadInfo>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f19390a;

        d(long j2) {
            this.f19390a = j2;
        }

        @Override // interfaces.IBaseBeanCall
        public void onClose() {
            WelcomeActivity.this.judageAdPage(this.f19390a);
        }

        @Override // interfaces.IBaseBeanCall
        public void onfail() {
            WelcomeActivity.this.judageAdPage(this.f19390a);
        }

        @Override // interfaces.IBaseBeanCall
        public void onsuccess(APIresult<DownloadInfo> aPIresult) {
        }
    }

    class e implements IClickListener {
        e() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            ui.c.i().d();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            util.u1.b(util.p1.y, false);
            WelcomeActivity.this.checkPermission(100L);
            util.p1.b(util.p1.n, true);
        }
    }

    class f extends ui.view.p {
        f(long j2, long j3) {
            super(j2, j3);
        }

        @Override // ui.view.p
        public void a(long j2) {
            WelcomeActivity welcomeActivity = WelcomeActivity.this;
            if (welcomeActivity == null || welcomeActivity.isFinishing()) {
                return;
            }
            int i2 = (int) (j2 / 1000);
            WelcomeActivity.this.mTvNext.setText("跳过 " + i2);
        }

        @Override // ui.view.p
        public void d() {
            if (WelcomeActivity.this.isFinishing()) {
                return;
            }
            WelcomeActivity.this.turnPage(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPermission(long j2) {
        if (!util.p1.a(util.p1.n, false)) {
            Hicore.getApp().initSDK();
        }
        util.permissionutil.c.a(this, new String[]{util.permissionutil.a.A, util.permissionutil.a.z, util.permissionutil.a.f20916j, "android.permission.RECEIVE_BOOT_COMPLETED"}, new c(j2));
    }

    private void countTime() {
        if (this.downTimer == null) {
            this.downTimer = new f(this.mAdBean.getShowTime() * 1000, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishPage() {
        if (isFinishing()) {
            return;
        }
        finish();
    }

    private void handleTurnPage() {
        if (util.u1.a(util.p1.y, true)) {
            showAgreement();
        } else {
            checkPermission(100L);
        }
    }

    private boolean isDoubleStart() {
        if ((getIntent().getFlags() & 4194304) <= 0) {
            return false;
        }
        finishPage();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void judageAdPage(long j2) {
        this.presenter.otherPartDictionary();
        this.presenter.getAd(j2);
    }

    private void lottieInit() {
        this.mLottieLike.setRenderMode(com.airbnb.lottie.t.SOFTWARE);
        this.mLottieLike.setAnimation("lottie_ad.json");
        this.mLottieLike.h();
    }

    private void showAgreement() {
        util.b1.a((Activity) this, "服务协议和隐私政策", y1.a(this, getString(R.string.clause_befor), "与", getString(R.string.clause_end), "《服务协议》", "《隐私政策》"), true, "不同意", "同意", (IClickListener) new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUpdateDlg(long j2) {
        updateAppWithTime(new d(j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void turnPage(long j2) {
        y1.f21027b.postDelayed(new Runnable() { // from class: ui.activity.u1
            @Override // java.lang.Runnable
            public final void run() {
                this.f19479a.a();
            }
        }, 0L);
    }

    public /* synthetic */ void a() {
        final Intent intent = new Intent();
        PushEntity pushEntity = this.entity;
        if (pushEntity != null) {
            intent.putExtra(util.k1.f20845c, pushEntity);
        }
        if (!AccountManager.isLogin()) {
            intent.setClass(this, LoginActivity.class);
            startActivity(intent);
            finishPage();
        } else {
            if (util.p1.a(LocalModuelConfig.ISHAVE_LOCAL, -1) != -1) {
                LocalModuelConfig.getInstance().getConfigMude(AccountManager.getRegisterRegionCode(), new IResultCallback() { // from class: ui.activity.t1
                    @Override // interfaces.IResultCallback
                    public final void onIRSuccess(RegionMudelBean regionMudelBean) {
                        this.f19474a.a(intent, regionMudelBean);
                    }
                });
                return;
            }
            intent.setClass(this, LoginActivity.class);
            startActivity(intent);
            finishPage();
        }
    }

    public void initPage() {
        Hicore.schemeString = getIntent().getDataString();
        if (isDoubleStart()) {
            return;
        }
        StatisticsHttp.getInstance().pageOpenHttp(e.d.f13584b);
        this.presenter = new WelocmPresenter(this, this);
        JNIHandStamp.getInstance().handsharkKeyAsyn(new b());
        this.mClLayout.setVisibility(8);
    }

    @Override // ui.callview.WelcomeCallView
    public void onAdRequest(AdBean adBean, long j2) {
        if (adBean == null || TextUtils.isEmpty(adBean.getImageUrl())) {
            this.mAdBean = null;
            turnPage(j2);
        } else {
            this.mAdBean = adBean;
            showAd();
        }
    }

    @Override // com.umeng.message.UmengNotifyClickActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ui.statusbarcompat.b.a((Activity) this, true, false);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        if (y1.f()) {
            util.b1.b(this, "本应用不支持ROOT设备", "确定", new a());
        } else {
            initPage();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        LottieAnimationView lottieAnimationView = this.mLottieLike;
        if (lottieAnimationView != null) {
            lottieAnimationView.a();
            this.mLottieLike.clearAnimation();
            this.mLottieLike.clearFocus();
        }
        ui.view.p pVar = this.downTimer;
        if (pVar != null) {
            pVar.a();
        }
    }

    @Override // com.umeng.message.UmengNotifyClickActivity
    public void onMessage(Intent intent) {
        super.onMessage(intent);
        try {
            String stringExtra = intent.getStringExtra("body");
            if (y1.p(stringExtra)) {
                return;
            }
            this.entity = (PushEntity) new com.google.gson.e().a(stringExtra, PushEntity.class);
            org.greenrobot.eventbus.c.f().d(new util.c2.a(110, this.entity));
        } catch (Exception unused) {
        }
    }

    @Override // com.umeng.message.UmengNotifyClickActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        LottieAnimationView lottieAnimationView = this.mLottieLike;
        if (lottieAnimationView != null) {
            lottieAnimationView.g();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        ui.view.p pVar = this.downTimer;
        if (pVar != null && pVar.b()) {
            this.downTimer.d();
        }
        LottieAnimationView lottieAnimationView = this.mLottieLike;
        if (lottieAnimationView != null) {
            lottieAnimationView.h();
        }
        util.n1.d("tt", "hahahahahhaha");
    }

    @Override // ui.callview.WelcomeCallView
    public void onSuccessRequest() {
        util.u1.b(util.p1.y, true);
        showAgreement();
    }

    @OnClick({R.id.tv_next, R.id.lottie_likeanim})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.lottie_likeanim) {
            if (id != R.id.tv_next) {
                return;
            }
            ui.view.p pVar = this.downTimer;
            if (pVar != null) {
                pVar.a();
            }
            turnPage(0L);
            return;
        }
        if (this.mAdBean == null) {
            return;
        }
        ui.view.p pVar2 = this.downTimer;
        if (pVar2 != null) {
            pVar2.a();
        }
        String openUrl = this.mAdBean.getOpenUrl();
        if (TextUtils.isEmpty(openUrl)) {
            return;
        }
        if (this.mAdBean.getOpenType() != 1) {
            if (this.mAdBean.getOpenType() == 2) {
                util.k1.a((Context) this, openUrl);
                return;
            }
            return;
        }
        String title = this.mAdBean.getTitle();
        Intent intent = new Intent(this, (Class<?>) WebActivity.class);
        if (TextUtils.isEmpty(title)) {
            title = "";
        }
        intent.putExtra(util.k1.P, title);
        intent.putExtra(util.k1.Q, openUrl + AccountManager.getShareParam());
        intent.putExtra(util.k1.Z, util.k1.a0);
        startActivity(intent);
        finish();
    }

    @Override // ui.callview.WelcomeCallView
    public void onfailRequest() {
        handleTurnPage();
    }

    public void showAd() {
        try {
            com.bumptech.glide.b.a((Activity) this).a(this.mAdBean.getImageUrl()).a(this.mImage);
        } catch (Exception unused) {
        }
        this.mClLayout.setAlpha(0.0f);
        this.mClLayout.setVisibility(0);
        this.mClLayout.animate().alpha(1.0f).setDuration(1000L).setListener(null);
        if (TextUtils.isEmpty(this.mAdBean.getOpenUrl())) {
            this.mLottieLike.setVisibility(8);
        } else {
            lottieInit();
            this.mLottieLike.setVisibility(0);
        }
        if (this.mAdBean.getShowTime() > 0) {
            countTime();
        }
    }

    public void updateAppWithTime(IBaseBeanCall iBaseBeanCall) {
        if (UpdateUtil.isCheckUpdateAlready) {
            if (iBaseBeanCall != null) {
                iBaseBeanCall.onfail();
                return;
            }
            return;
        }
        if (!TextUtils.equals(y1.d("yyyy-MM-dd"), util.u1.a("update_home", ""))) {
            UpdateUtil.updateAppOnly(this, iBaseBeanCall);
        } else if (iBaseBeanCall != null) {
            iBaseBeanCall.onfail();
        }
    }

    public /* synthetic */ void a(Intent intent, RegionMudelBean regionMudelBean) {
        if (regionMudelBean != null) {
            intent.setClass(this, MainActivity.class);
            startActivity(intent);
            finishPage();
        }
    }
}
