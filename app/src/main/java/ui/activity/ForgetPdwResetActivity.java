package ui.activity;

import android.app.Activity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IEditAfterListener;
import manager.LoginManager;
import ui.callview.ForgetPwdCallView;
import ui.presenter.ForgetPresenter;
import ui.view.swip.SwipBackLayout;

/* loaded from: classes2.dex */
public class ForgetPdwResetActivity extends BaseActivity implements IEditAfterListener, ForgetPwdCallView {
    private ForgetPresenter forgetPresenter;

    @BindView(R.id.confirm)
    TextView mConfim;

    @BindView(R.id.et_new_pwd)
    EditText mEtNewPwd;

    @BindView(R.id.pwd_eye)
    ImageView mPwdEye;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private String phoneCode;
    private String phoneNum;
    private boolean pwdIsVisible = true;

    private void initListener() {
        this.mPwdEye.setOnClickListener(new View.OnClickListener() { // from class: ui.activity.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19457a.a(view);
            }
        });
    }

    public /* synthetic */ void a(View view) {
        if (this.pwdIsVisible) {
            this.mPwdEye.setImageResource(R.mipmap.eye_sel);
            this.mEtNewPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            this.mPwdEye.setImageResource(R.mipmap.eye_nor);
            this.mEtNewPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        this.pwdIsVisible = !this.pwdIsVisible;
        if (!this.mEtNewPwd.isFocused()) {
            this.mEtNewPwd.setFocusable(true);
            this.mEtNewPwd.setFocusableInTouchMode(true);
            this.mEtNewPwd.requestFocus();
            this.mEtNewPwd.requestFocusFromTouch();
        }
        EditText editText = this.mEtNewPwd;
        editText.setSelection(editText.getText().toString().length());
    }

    @Override // interfaces.IEditAfterListener
    public void editLength(int i2) {
        if (this.mEtNewPwd.getText().toString().length() >= 6) {
            this.mConfim.setEnabled(true);
        } else {
            this.mConfim.setEnabled(false);
        }
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        ui.statusbarcompat.b.a((Activity) this, true, true);
        this.mTvTitle.setText("");
        initListener();
        this.forgetPresenter = new ForgetPresenter(this.mActivity, this);
        util.d1.a(this.mEtNewPwd, this);
        util.d1.b(this.mEtNewPwd);
        showSoftInput(this.mEtNewPwd);
        this.phoneNum = getIntent().getStringExtra(util.k1.F);
        this.phoneCode = getIntent().getStringExtra(util.k1.G);
    }

    @Override // ui.callview.ForgetPwdCallView
    public void onChangeMobileSuccRequest() {
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // ui.callview.ForgetPwdCallView
    public void onSuccRequest(int i2) {
        util.w1.a("密码设置成功，请重新登录");
        LoginManager.getInstance().exitToLogin();
    }

    @Override // ui.callview.ForgetPwdCallView
    public void onSuccessLoginOut() {
    }

    @OnClick({R.id.iv_back, R.id.confirm})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.confirm) {
            if (id != R.id.iv_back) {
                return;
            }
            finish();
        } else {
            this.forgetPresenter.resetPwd(this.phoneNum, this.phoneCode, this.mEtNewPwd.getText().toString());
            hideSoftInput();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_forger_reset;
    }
}
