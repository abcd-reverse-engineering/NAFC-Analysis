package ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import bean.PolicBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IEditAfterListener;
import interfaces.IOneClickListener;
import network.http.StatisticsHttp;
import ui.callview.PoliceLoginCallView;
import ui.presenter.PoliceLoginPresenter;
import ui.view.CodeCutTimeTextView;
import ui.view.swip.SwipBackLayout;
import util.y1;

/* loaded from: classes2.dex */
public class PoliceLoginActivity extends BaseActivity implements PoliceLoginCallView {

    @BindView(R.id.code)
    EditText mCode;

    @BindView(R.id.confirm)
    TextView mConfirm;

    @BindView(R.id.iv_back)
    ImageView mIvBack;

    @BindView(R.id.iv_clear_code)
    ImageView mIvClearCode;

    @BindView(R.id.iv_clear)
    ImageView mIvclean;

    @BindView(R.id.phone)
    EditText mPhone;

    @BindView(R.id.tv_resend)
    CodeCutTimeTextView mTvReset;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private PoliceLoginPresenter mPresenter = null;
    private boolean isAlreadySend = false;

    private void confirmClick() {
        String string = this.mPhone.getText().toString();
        if (TextUtils.isEmpty(string)) {
            util.w1.a("请输入手机号");
            return;
        }
        if (string.length() != 11) {
            util.w1.a("手机号码格式不正确，请重新输入");
            return;
        }
        String string2 = this.mCode.getText().toString();
        if (TextUtils.isEmpty(string2)) {
            util.w1.a("请输入验证码");
        } else {
            this.mPresenter.smsVerify(string, string2);
        }
    }

    private void initView() {
        this.mPresenter = new PoliceLoginPresenter(this, this);
        this.mTvReset.a(true);
        util.d1.a(this.mPhone, new IEditAfterListener() { // from class: ui.activity.q0
            @Override // interfaces.IEditAfterListener
            public final void editLength(int i2) {
                this.f19458a.a(i2);
            }
        });
        util.d1.a(this.mCode, new IEditAfterListener() { // from class: ui.activity.p0
            @Override // interfaces.IEditAfterListener
            public final void editLength(int i2) {
                this.f19454a.b(i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: resetClick, reason: merged with bridge method [inline-methods] */
    public void a() {
        String string = this.mPhone.getText().toString();
        if (TextUtils.isEmpty(string)) {
            util.w1.a("请输入手机号");
        } else if (string.length() != 11) {
            util.w1.a("手机号码格式不正确，请重新输入");
        } else {
            this.isAlreadySend = true;
            this.mPresenter.sendSms(string);
        }
    }

    public /* synthetic */ void a(int i2) {
        if (this.mPhone.getText().toString().trim().length() > 0) {
            this.mIvclean.setVisibility(0);
        } else {
            this.mIvclean.setVisibility(8);
        }
    }

    public /* synthetic */ void b(int i2) {
        if (this.mCode.getText().toString().trim().length() > 0) {
            this.mIvClearCode.setVisibility(0);
        } else {
            this.mIvClearCode.setVisibility(8);
        }
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        StatisticsHttp.getInstance().pageOpenHttp(e.d.f13590h);
        ui.statusbarcompat.b.a((Activity) this, true, false);
        SwipBackLayout.a(this.mActivity).a();
        initView();
    }

    @Override // ui.callview.PoliceLoginCallView
    public void onSendFailRequest() {
        util.w1.a("验证码发送失败，请重试");
        this.isAlreadySend = false;
    }

    @Override // ui.callview.PoliceLoginCallView
    public void onSendSuccessRequest() {
        util.w1.a("验证码已发送，请查收");
        this.isAlreadySend = false;
        CodeCutTimeTextView codeCutTimeTextView = this.mTvReset;
        if (codeCutTimeTextView != null) {
            codeCutTimeTextView.a(this.mActivity, 60);
        }
    }

    @Override // ui.callview.PoliceLoginCallView
    public void onVerifySuccessRequest(PolicBean policBean) {
        policBean.setTelNumber(this.mPhone.getText().toString());
        d.b.a(policBean);
        startActivity(new Intent(this, (Class<?>) PoliceInfoActivity.class));
        finish();
    }

    @OnClick({R.id.iv_back, R.id.iv_clear, R.id.tv_resend, R.id.iv_clear_code, R.id.confirm})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.confirm /* 2131296476 */:
                confirmClick();
                break;
            case R.id.iv_back /* 2131296762 */:
                finish();
                break;
            case R.id.iv_clear /* 2131296772 */:
                this.mPhone.setText("");
                break;
            case R.id.iv_clear_code /* 2131296774 */:
                this.mCode.setText("");
                break;
            case R.id.tv_resend /* 2131297692 */:
                if (!this.isAlreadySend) {
                    if (!y1.a(util.p1.x, true)) {
                        a();
                        break;
                    } else {
                        toYanzheng(new IOneClickListener() { // from class: ui.activity.o0
                            @Override // interfaces.IOneClickListener
                            public final void clickOKBtn() {
                                this.f19451a.a();
                            }
                        });
                        break;
                    }
                } else {
                    util.w1.a("验证码获取中，请稍等");
                    break;
                }
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_police_login;
    }
}
