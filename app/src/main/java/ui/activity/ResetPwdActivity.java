package ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IEditAfterListener;
import interfaces.IOneClickListener;
import manager.AccountManager;
import org.greenrobot.eventbus.ThreadMode;
import ui.Hicore;
import ui.callview.ResetPwdView;
import ui.presenter.ResetPwdPresenter;
import ui.view.swip.SwipBackLayout;
import util.y1;

/* loaded from: classes2.dex */
public class ResetPwdActivity extends BaseActivity implements ResetPwdView {

    @BindView(R.id.confirm)
    TextView mConfim;

    @BindView(R.id.iv_clear)
    ImageView mIvClean;

    @BindView(R.id.phone_code)
    EditText mPhoneCode;

    @BindView(R.id.phone_label)
    TextView mPhoneLable;
    ResetPwdPresenter mPresenter;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    String phoneNum;

    private void initListener() {
        util.d1.a(this.mPhoneCode, new IEditAfterListener() { // from class: ui.activity.b1
            @Override // interfaces.IEditAfterListener
            public final void editLength(int i2) {
                this.f19407a.a(i2);
            }
        });
    }

    public /* synthetic */ void a(int i2) {
        if (i2 > 0) {
            this.mConfim.setEnabled(true);
            this.mIvClean.setVisibility(0);
        } else {
            this.mConfim.setEnabled(false);
            this.mIvClean.setVisibility(4);
        }
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        ui.statusbarcompat.b.a((Activity) this, true, true);
        org.greenrobot.eventbus.c.f().e(this);
        this.mTvTitle.setText("");
        this.mPhoneLable.setTypeface(this.typ_ME);
        this.mPhoneCode.setText(AccountManager.getVisiblePhone());
        this.mPresenter = new ResetPwdPresenter(this.mActivity, this);
        initListener();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(util.c2.a aVar) {
        if (aVar == null || aVar.a() != 23) {
            return;
        }
        finish();
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // ui.callview.ResetPwdView
    public void onSuccRequest(int i2) {
        Intent intent = new Intent(this.mActivity, (Class<?>) VerifyPhoneCodeActivity.class);
        intent.putExtra(util.k1.F, this.phoneNum);
        intent.putExtra(util.k1.H, util.k1.J);
        intent.putExtra(util.k1.E, i2);
        startActivity(intent);
    }

    @OnClick({R.id.iv_back, R.id.iv_clear, R.id.confirm})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.confirm) {
            if (id == R.id.iv_back) {
                finish();
                return;
            } else {
                if (id != R.id.iv_clear) {
                    return;
                }
                this.mPhoneCode.setText("");
                return;
            }
        }
        this.phoneNum = this.mPhoneCode.getText().toString();
        if (this.mPhoneCode.getText().toString().length() != 11) {
            util.w1.a("手机号码格式不正确，请重新输入");
        } else if (y1.a(util.p1.v, true)) {
            toYanzheng(new IOneClickListener() { // from class: ui.activity.a1
                @Override // interfaces.IOneClickListener
                public final void clickOKBtn() {
                    this.f19403a.a();
                }
            });
        } else {
            this.mPresenter.verificationSubmit(3, this.phoneNum);
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_reset_pwd;
    }

    public /* synthetic */ void a() {
        this.mPresenter.verificationSubmit(3, this.phoneNum);
    }
}
