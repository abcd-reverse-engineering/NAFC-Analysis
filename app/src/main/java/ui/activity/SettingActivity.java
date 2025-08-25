package ui.activity;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import bean.CheckTimeBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import interfaces.IClickListener;
import manager.AccountManager;
import manager.LoginManager;
import manager.NotificationHelper;
import network.account.APIresult;
import network.http.StatisticsHttp;
import ui.Hicore;
import ui.callview.SettingView;
import ui.presenter.SettingPresenter;
import ui.presenter.WelocmPresenter;
import ui.view.SwitchButton;
import ui.view.swip.SwipBackLayout;
import util.a2;

/* loaded from: classes2.dex */
public class SettingActivity extends BaseActivity implements SettingView {
    private util.v0 alarmUtil = new util.v0();
    private boolean goOpenNotification;
    private boolean goOpenPush;
    private CheckTimeBean mCurrentTime;
    private SettingPresenter mPresenter;

    @BindView(R.id.rl_cache_calean)
    View mRlCache;

    @BindView(R.id.switchShow_check)
    SwitchButton mSwitchCheck;

    @BindView(R.id.switchShow_push)
    SwitchButton mSwitchPush;

    @BindView(R.id.time_setting)
    Group mTimeSetting;

    @BindView(R.id.time_txt)
    TextView mTimeTxt;

    @BindView(R.id.cache_num)
    TextView mTvCacheNum;

    @BindView(R.id.tv_push_tips)
    TextView mTvPushTips;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    class a implements IClickListener {
        a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            int loginType;
            if (AccountManager.getAccountInfo() != null && (loginType = AccountManager.getAccountInfo().getLoginType()) > 0) {
                SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
                if (loginType == AccountManager.LOGIN_QQ) {
                    share_media = SHARE_MEDIA.QQ;
                } else if (loginType == AccountManager.LOGIN_WX) {
                    share_media = SHARE_MEDIA.WEIXIN;
                } else if (loginType == AccountManager.LOGIN_SINA) {
                    share_media = SHARE_MEDIA.SINA;
                }
                UMShareAPI.get(SettingActivity.this.mActivity).deleteOauth(SettingActivity.this.mActivity, share_media, null);
            }
            SettingActivity.this.mPresenter.requestLoginOut();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    class b implements IClickListener {
        b() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            SettingActivity.this.goOpenNotification = false;
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            SettingActivity.this.goOpenNotification = true;
            util.v1.k(SettingActivity.this.mActivity);
        }
    }

    private void checkPrimissDialog() {
        util.b1.b(this.mActivity, R.drawable.iv_flow_primiss, "开启宣传及功能消息推送", (Build.VERSION.SDK_INT >= 26 || !(Build.BRAND.equalsIgnoreCase("vivo") || Build.BRAND.equalsIgnoreCase("oppo"))) ? "可至”设置-通知栏与状态“中开启”允许通知、类别通知“权限" : "可至”设置-通知栏与状态“中开启”允许通知、更多通知“权限", "放弃使用", "去开启", new b());
    }

    private void initCheckView() {
        CheckTimeBean checkTimeBean = (CheckTimeBean) util.u1.a(util.u1.I0, CheckTimeBean.class);
        if (checkTimeBean != null && isOpenCheckNotification()) {
            this.mSwitchCheck.setChecked(true);
            this.mTimeTxt.setText(checkTimeBean.getContent());
            this.mTimeSetting.setVisibility(0);
        } else {
            this.mSwitchCheck.setChecked(false);
        }
        this.mSwitchCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ui.activity.d1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f19416a.a(compoundButton, z);
            }
        });
    }

    private void initPushView() {
        this.mSwitchPush.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ui.activity.c1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f19410a.b(compoundButton, z);
            }
        });
    }

    private boolean isOpenCheckNotification() {
        return NotificationHelper.isNotificationEnabled(this.mActivity, a2.f20717g, a2.f20718h);
    }

    private void openPushBySetting(boolean z) {
        if (this.goOpenPush && z) {
            util.u1.b(util.u1.C, true);
            this.goOpenPush = false;
        }
    }

    private void setPushState(boolean z) {
        if (z) {
            receiver.e.c(this.mActivity);
            this.mTvPushTips.setText("有重要资讯和功能消息时通知我");
        } else {
            receiver.e.b(this.mActivity);
            this.mTvPushTips.setText("你可能错过重要资讯通知，点击开启消息通知");
        }
        this.mSwitchPush.setChecked(z);
        util.u1.b(util.u1.C, z);
    }

    private void startAlarm(int i2) {
        this.alarmUtil.b(this.mActivity, i2);
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        if (TextUtils.equals(WelocmPresenter.VIRAPPCHECK, "0")) {
            this.mSwitchCheck.setChecked(!z);
            util.w1.a(WelocmPresenter.VIRSTMSG);
            return;
        }
        if (!z) {
            this.mTimeSetting.setVisibility(8);
            this.mPresenter.closeTimeDlg();
            util.u1.a((Object) null, util.u1.I0);
            util.u1.b(util.u1.J0, 0L);
            util.u1.b(util.u1.K0, 0L);
            return;
        }
        if (!isOpenCheckNotification()) {
            checkPrimissDialog();
            this.mSwitchCheck.setChecked(false);
            return;
        }
        this.mTimeTxt.setText(this.mPresenter.mDefaultStr);
        this.mTimeSetting.setVisibility(0);
        util.u1.a(new CheckTimeBean(this.mPresenter.mDefaultStr, 1), util.u1.I0);
        startAlarm(1);
        StatisticsHttp.getInstance().trackPageClick("2");
    }

    public /* synthetic */ void b(CompoundButton compoundButton, boolean z) {
        if (!z) {
            setPushState(false);
        } else {
            if (receiver.e.d(this.mActivity)) {
                setPushState(true);
                return;
            }
            setPushState(false);
            receiver.e.e(this.mActivity);
            this.goOpenPush = true;
        }
    }

    @Override // ui.callview.SettingView
    public void cancleTimeDlg() {
        this.mCurrentTime = null;
    }

    @Override // ui.callview.SettingView
    public void ensureTimeDlg() {
        if (this.mCurrentTime != null) {
            CheckTimeBean checkTimeBean = (CheckTimeBean) util.u1.a(util.u1.I0, CheckTimeBean.class);
            if (checkTimeBean != null && this.mCurrentTime.getCode() == checkTimeBean.getCode() && TextUtils.equals(this.mCurrentTime.getContent(), checkTimeBean.getContent())) {
                return;
            }
            this.mTimeTxt.setText(this.mCurrentTime.getContent());
            util.u1.a(this.mCurrentTime, util.u1.I0);
            startAlarm(this.mCurrentTime.getCode());
        }
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        this.mTvTitle.setText("设置");
        this.mPresenter = new SettingPresenter(this.mActivity, this);
        initCheckView();
        initPushView();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.mPresenter.closeTimeDlg();
        super.onBackPressed();
    }

    @Override // ui.callview.SettingView
    public void onItemClick(CheckTimeBean checkTimeBean) {
        this.mCurrentTime = checkTimeBean;
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mTvCacheNum.setText(util.a1.h(this.mActivity));
        boolean zD = receiver.e.d(this.mActivity);
        openPushBySetting(zD);
        if (util.u1.a(util.u1.C, true) && zD) {
            util.u1.b(util.u1.C, true);
            setPushState(true);
        } else {
            util.u1.b(util.u1.C, false);
            setPushState(false);
        }
        if (this.goOpenNotification) {
            this.goOpenNotification = false;
            if (isOpenCheckNotification()) {
                this.mSwitchCheck.setChecked(true);
                return;
            } else {
                this.mSwitchCheck.setChecked(false);
                return;
            }
        }
        CheckTimeBean checkTimeBean = (CheckTimeBean) util.u1.a(util.u1.I0, CheckTimeBean.class);
        if (!isOpenCheckNotification() || checkTimeBean == null) {
            this.mSwitchCheck.setChecked(false);
        } else {
            this.mSwitchCheck.setChecked(true);
        }
    }

    @Override // ui.callview.SettingView
    public void onSuccessLoginOut(APIresult aPIresult) {
        LoginManager.getInstance().exitToLogin();
    }

    @OnClick({R.id.iv_back, R.id.rl_account, R.id.time_txt, R.id.rl_cache_calean, R.id.logout_btn})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case R.id.iv_back /* 2131296762 */:
                onBackPressed();
                break;
            case R.id.logout_btn /* 2131297010 */:
                util.b1.a(this.mActivity, "您确认要退出登录吗？", "", "确定", "取消", -1, -1, true, (IClickListener) new a());
                break;
            case R.id.rl_account /* 2131297183 */:
                if (AccountManager.isLogin()) {
                    startActivity(SettingAccountActivity.class);
                    break;
                }
                break;
            case R.id.rl_cache_calean /* 2131297188 */:
                org.greenrobot.eventbus.c.f().d(new util.c2.a(105, null));
                util.a1.d(this.mActivity);
                this.mTvCacheNum.setText("0KB");
                break;
            case R.id.time_txt /* 2131297357 */:
                if (!TextUtils.equals(WelocmPresenter.VIRAPPCHECK, "0")) {
                    this.mPresenter.showSelectTimeDlg();
                    break;
                } else {
                    util.w1.a(WelocmPresenter.VIRSTMSG);
                    break;
                }
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_setting;
    }
}
