package ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import bean.VerifyHomePointBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.umeng.socialize.UMShareAPI;
import interfaces.IClickListener;
import ui.callview.IDCheckView;
import ui.presenter.IDCheckPresenter;
import ui.view.swip.SwipBackLayout;

/* loaded from: classes2.dex */
public class CheckIDActivity extends BaseActivity implements IDCheckView {

    @BindView(R.id.et_check_phone)
    EditText mEtCheckPhone;

    @BindView(R.id.idvrfy_list)
    View mIdVrfyList;

    @BindView(R.id.btn_idvrfy_send)
    Button mIdVrfySend;

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    private IDCheckPresenter mPresenter;

    @BindView(R.id.rl_acept_view)
    View mRlAceptRead;

    @BindView(R.id.tv_acept_read)
    TextView mTvAceptRead;

    @BindView(R.id.tv_no_read)
    TextView mTvNoReadNum;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private VerifyHomePointBean pointBean;

    class a implements IClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f17966a;

        a(String str) {
            this.f17966a = str;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            Intent intent = new Intent(CheckIDActivity.this.mActivity, (Class<?>) BeforIdVerifyActivity.class);
            intent.putExtra(util.k1.e0, this.f17966a);
            CheckIDActivity.this.startActivityForResult(intent, 100);
        }
    }

    private void initRedNum() {
        VerifyHomePointBean verifyHomePointBean = this.pointBean;
        if (verifyHomePointBean != null) {
            if (verifyHomePointBean.getToVerificationCount() > 0) {
                this.mRlAceptRead.setVisibility(0);
                this.mTvAceptRead.setVisibility(0);
                this.mTvAceptRead.setText("" + this.pointBean.getToVerificationCount());
            }
            if (this.pointBean.getPendingVerificationCount() > 0) {
                this.mTvNoReadNum.setVisibility(0);
                this.mTvNoReadNum.setText("" + this.pointBean.getPendingVerificationCount());
            }
        }
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        ui.statusbarcompat.b.a((Activity) this, true, true);
        this.mTvTitle.setText("身份核实");
        this.mPresenter = new IDCheckPresenter(this, this);
        try {
            this.pointBean = (VerifyHomePointBean) getIntent().getSerializableExtra(util.k1.f20845c);
        } catch (Exception unused) {
        }
        initRedNum();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        UMShareAPI.get(this).onActivityResult(i2, i3, intent);
        if (i2 == -1) {
            this.mEtCheckPhone.setText("");
        }
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mPresenter.getVerifyHomePoint();
    }

    @Override // ui.callview.IDCheckView
    public void onSuccCreateCheckRequest() {
        String string = this.mEtCheckPhone.getText().toString();
        util.b1.a(this.mActivity, "为确保您本人操作，完成身份认证后即可向该号码发送身份核实请求" + string, "", "取消", "前往验证", R.color._A8B4F7, R.color.blue_dark, (IClickListener) new a(string));
    }

    @Override // ui.callview.IDCheckView
    public void onSuccCreateRequest(VerifyHomePointBean verifyHomePointBean) {
        this.pointBean = verifyHomePointBean;
        initRedNum();
    }

    @OnClick({R.id.iv_back, R.id.rl_acept_view, R.id.btn_idvrfy_send, R.id.idvrfy_list})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.btn_idvrfy_send /* 2131296399 */:
                String string = this.mEtCheckPhone.getText().toString();
                if (string.trim().length() >= 11) {
                    this.mPresenter.verifyCreateCheck(string);
                    break;
                } else {
                    util.w1.a("请输入正确手机号~");
                    break;
                }
            case R.id.idvrfy_list /* 2131296700 */:
                startActivity(IDVarfyListActivity.class);
                this.mTvNoReadNum.setVisibility(8);
                break;
            case R.id.iv_back /* 2131296762 */:
                finish();
                break;
            case R.id.rl_acept_view /* 2131297185 */:
                startActivity(IDVarfyAceptListActivity.class);
                this.mTvAceptRead.setVisibility(8);
                break;
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_id_check;
    }
}
