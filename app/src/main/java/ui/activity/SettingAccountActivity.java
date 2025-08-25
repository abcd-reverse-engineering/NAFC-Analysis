package ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import manager.AccountManager;
import ui.Hicore;
import ui.callview.MineChangePwdView;
import ui.presenter.MineChangePwdPresenter;
import ui.view.swip.SwipBackLayout;
import util.y1;

/* loaded from: classes2.dex */
public class SettingAccountActivity extends BaseActivity implements MineChangePwdView {
    MineChangePwdPresenter mPresenter;

    @BindView(R.id.tv_phone)
    TextView mTvPhone;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    String phoneNum;

    private String getPhoneNmb() {
        this.phoneNum = AccountManager.getAccountPhone();
        return y1.l(this.phoneNum);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        this.mTvTitle.setText("账号与安全");
        this.mPresenter = new MineChangePwdPresenter(this, this);
    }

    @Override // ui.callview.MineChangePwdView
    public void onHasPwdSuccRequest(boolean z) {
        Intent intent = new Intent();
        if (z) {
            intent.setClass(this.mActivity, ResetPwdActivity.class);
        } else {
            intent.setClass(this.mActivity, ForgetPdwResetActivity.class);
            intent.putExtra(util.k1.F, this.phoneNum);
            intent.putExtra(util.k1.G, "");
        }
        startActivity(intent);
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mTvPhone.setText(getPhoneNmb());
    }

    @OnClick({R.id.iv_back, R.id.tv_ed_phone, R.id.tv_ed_pwd, R.id.rl_logout_view})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case R.id.iv_back /* 2131296762 */:
                onBackPressed();
                break;
            case R.id.rl_logout_view /* 2131297194 */:
                startActivity(LogoutActivity.class);
                break;
            case R.id.tv_ed_phone /* 2131297545 */:
                Intent intent = new Intent(this.mActivity, (Class<?>) ResetPhoneNumActivity.class);
                intent.putExtra(util.k1.F, this.phoneNum);
                startActivity(intent);
                break;
            case R.id.tv_ed_pwd /* 2131297546 */:
                this.mPresenter.getAccHasPwd();
                break;
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_setting_account;
    }
}
