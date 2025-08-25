package ui.activity;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import interfaces.IClickListener;
import interfaces.IOneClickListener;
import interfaces.PermissionsListener;
import java.util.List;
import manager.AccountManager;
import network.account.APIresult;
import network.account.AccountInfo;
import network.http.RegionConfigHttp;
import ui.Hicore;
import ui.callview.RegisterlView;
import ui.presenter.RegisterPresenter;
import ui.view.CodeCutTimeTextView;
import util.y1;

/* loaded from: classes2.dex */
public class OauthRegisterActivity extends BaseActivity implements TextWatcher, RegisterlView {
    private boolean isChecked;

    @BindView(R.id.account)
    EditText mAccount;

    @BindView(R.id.clause)
    TextView mClause;

    @BindView(R.id.confirm)
    TextView mConfirm;

    @BindView(R.id.iv_clear)
    ImageView mIvClean;
    RegisterPresenter mPresenter;
    private String mStrAccount;

    @BindView(R.id.cb_select)
    CheckBox mTCbSelect;

    @BindView(R.id.tv_resend)
    CodeCutTimeTextView mTvReset;

    @BindView(R.id.user_code)
    EditText mUserCode;
    private String openId;
    private int pltmId;

    class a implements PermissionsListener {
        a() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            OauthRegisterActivity.this.registerSubmit();
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            OauthRegisterActivity.this.registerSubmit();
        }
    }

    class b implements IClickListener {
        b() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            if (OauthRegisterActivity.this.pltmId > 0) {
                SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
                if (OauthRegisterActivity.this.pltmId == AccountManager.LOGIN_QQ) {
                    share_media = SHARE_MEDIA.QQ;
                } else if (OauthRegisterActivity.this.pltmId == AccountManager.LOGIN_WX) {
                    share_media = SHARE_MEDIA.WEIXIN;
                } else if (OauthRegisterActivity.this.pltmId == AccountManager.LOGIN_SINA) {
                    share_media = SHARE_MEDIA.SINA;
                }
                UMShareAPI.get(OauthRegisterActivity.this.mActivity).deleteOauth(OauthRegisterActivity.this.mActivity, share_media, null);
                OauthRegisterActivity.this.mActivity.finish();
            }
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    private void checkPermission() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.f20916j}, new a());
    }

    private void enableConfirm() {
        this.mStrAccount = this.mAccount.getText().toString().trim();
        if (TextUtils.isEmpty(this.mUserCode.getText().toString().trim()) || TextUtils.isEmpty(this.mStrAccount)) {
            this.mIvClean.setVisibility(4);
            this.mConfirm.setEnabled(false);
            this.mIvClean.setVisibility(8);
        } else {
            this.mIvClean.setVisibility(0);
            this.mConfirm.setEnabled(true);
            this.mIvClean.setVisibility(0);
        }
    }

    private void initCluse() {
        CharSequence charSequenceA = y1.a(this, "注册即同意", "和", "", "《服务协议》", "《隐私政策》");
        this.mClause.setMovementMethod(LinkMovementMethod.getInstance());
        this.mClause.setText(charSequenceA);
        this.mTCbSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ui.activity.m0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f19445a.a(compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerSubmit() {
        this.mStrAccount = this.mAccount.getText().toString().trim();
        String strTrim = this.mUserCode.getText().toString().trim();
        String nodeRegionId = RegionConfigHttp.getNodeRegionId();
        if (this.mStrAccount.length() != 11) {
            util.w1.a("请输入正确手机号");
        } else if (strTrim.length() < 4) {
            util.w1.a("请输入正确验证码");
        } else {
            this.mPresenter.oauthBindAccount(this.mStrAccount, strTrim, nodeRegionId, this.pltmId, this.openId);
        }
    }

    private void showCancleDlg() {
        util.b1.a(this.mActivity, "确认放弃登录?", "必须绑定手机号才能登录，为了您的账号安全建议绑定", "放弃登录", "继续绑定", -1, -1, true, (IClickListener) new b());
    }

    public /* synthetic */ void a() {
        this.mPresenter.verificationSubmit(5, this.mStrAccount, this.mTvReset);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        enableConfirm();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        this.mPresenter = new RegisterPresenter(this, this);
        this.pltmId = getIntent().getIntExtra(util.k1.M, 0);
        this.openId = getIntent().getStringExtra("open_id");
        this.mTvReset.a(true);
        this.mUserCode.addTextChangedListener(this);
        initCluse();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        showCancleDlg();
        return true;
    }

    @Override // ui.callview.RegisterlView
    public void onOauthSuccRequest(APIresult<AccountInfo> aPIresult) {
        int code = aPIresult.getCode();
        if (code == 0) {
            AccountInfo data = aPIresult.getData();
            data.setLoginType(this.pltmId);
            data.setVisiblePhone(this.mStrAccount);
            AccountManager.saveAccount(data);
            y1.a((Context) this.mActivity, (Class<?>) MainActivity.class);
            receiver.e.a(data.getTags());
            this.mActivity.finish();
            return;
        }
        if (code != 11) {
            String msg = aPIresult.getMsg();
            if (TextUtils.isEmpty(msg)) {
                util.w1.a(Hicore.getApp().getResources().getString(R.string.err_system));
                return;
            } else {
                util.w1.a(msg);
                return;
            }
        }
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setLoginType(this.pltmId);
        accountInfo.setOpenId(this.openId);
        accountInfo.setPhoneNum(this.mStrAccount);
        Intent intent = new Intent(this.mActivity, (Class<?>) AddressActivity.class);
        intent.putExtra(util.k1.f20845c, accountInfo);
        intent.putExtra(util.k1.X0, 6);
        startActivity(intent);
    }

    @Override // ui.callview.RegisterlView
    public void onSuccRequest(APIresult<AccountInfo> aPIresult) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @OnClick({R.id.iv_back, R.id.iv_clear, R.id.confirm, R.id.tv_resend})
    public void onViewClicked(View view) {
        hideSoftInput();
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.confirm /* 2131296476 */:
                if (!this.isChecked) {
                    util.w1.a("请先勾选同意协议政策后再确定");
                    break;
                } else {
                    checkPermission();
                    break;
                }
            case R.id.iv_back /* 2131296762 */:
                showCancleDlg();
                break;
            case R.id.iv_clear /* 2131296772 */:
                this.mUserCode.setText("");
                break;
            case R.id.tv_resend /* 2131297692 */:
                this.mStrAccount = this.mAccount.getText().toString().trim();
                if (!TextUtils.isEmpty(this.mStrAccount) && this.mStrAccount.length() == 11) {
                    if (!y1.a(util.p1.r, true)) {
                        this.mPresenter.verificationSubmit(5, this.mStrAccount, this.mTvReset);
                        break;
                    } else {
                        toYanzheng(new IOneClickListener() { // from class: ui.activity.n0
                            @Override // interfaces.IOneClickListener
                            public final void clickOKBtn() {
                                this.f19448a.a();
                            }
                        });
                        break;
                    }
                } else {
                    util.w1.a("请输入正确手机号~");
                    break;
                }
                break;
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_oauth_register;
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        this.isChecked = z;
    }
}
