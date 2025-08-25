package ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IEditAfterListener;
import interfaces.IOneClickListener;
import org.greenrobot.eventbus.ThreadMode;
import ui.Hicore;
import ui.callview.ForgetPwdCallView;
import ui.presenter.ForgetPresenter;
import ui.view.swip.SwipBackLayout;
import util.y1;

/* loaded from: classes2.dex */
public class ResetPhoneNumActivity extends BaseActivity implements ForgetPwdCallView {
    ForgetPresenter forgetPresenter;

    @BindView(R.id.confirm)
    TextView mConfim;

    @BindView(R.id.iv_clear)
    ImageView mIvClean;

    @BindView(R.id.phone_code)
    EditText mPhoneCode;

    @BindView(R.id.phone_label)
    TextView mPhoneLable;

    @BindView(R.id.tv_bom_tips)
    TextView mTvBomTips;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    String phoneNum;

    private void initListener() {
        util.d1.a(this.mPhoneCode, new IEditAfterListener() { // from class: ui.activity.y0
            @Override // interfaces.IEditAfterListener
            public final void editLength(int i2) {
                this.f19489a.a(i2);
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
        this.forgetPresenter = new ForgetPresenter(this.mActivity, this);
        this.phoneNum = getIntent().getStringExtra(util.k1.F);
        this.mTvBomTips.setText("修改后账号信息不变，下次需使用新手机号登录。当前手机号：" + y1.l(this.phoneNum));
        initListener();
    }

    @Override // ui.callview.ForgetPwdCallView
    public void onChangeMobileSuccRequest() {
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

    @Override // ui.callview.ForgetPwdCallView
    public void onSuccRequest(int i2) {
        Intent intent = new Intent(this.mActivity, (Class<?>) VerifyPhoneCodeActivity.class);
        intent.putExtra(util.k1.F, this.mPhoneCode.getText().toString());
        intent.putExtra(util.k1.H, util.k1.L);
        intent.putExtra(util.k1.E, i2);
        startActivity(intent);
    }

    @Override // ui.callview.ForgetPwdCallView
    public void onSuccessLoginOut() {
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
        if (TextUtils.equals(this.phoneNum, this.mPhoneCode.getText().toString())) {
            util.b1.b(this.mActivity, "该手机与当前绑定手机号相同", "确定", null);
        } else if (y1.a(util.p1.u, true)) {
            toYanzheng(new IOneClickListener() { // from class: ui.activity.z0
                @Override // interfaces.IOneClickListener
                public final void clickOKBtn() {
                    this.f19491a.a();
                }
            });
        } else {
            this.forgetPresenter.verificationResetPhone(this.mPhoneCode.getText().toString(), util.k1.L);
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_reset_phone;
    }

    public /* synthetic */ void a() {
        this.forgetPresenter.verificationResetPhone(this.mPhoneCode.getText().toString(), util.k1.L);
    }
}
