package ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import bean.AccountListBean;
import bean.CaseDetailBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import interfaces.IFaceLiveCallBack;
import interfaces.PermissionsListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ui.Hicore;
import ui.callview.CaseHistoryCallView;
import ui.callview.CaseVerifyCallview;
import ui.presenter.CaseHistoryPresenter;
import ui.presenter.CaseVerifyPresenter;
import ui.presenter.YCLicencePresenter;
import util.y1;

/* loaded from: classes2.dex */
public class CaseVerifyActivity extends BaseActivity implements CaseVerifyCallview {

    @BindView(R.id.et_ID)
    EditText mEtID;

    @BindView(R.id.et_name)
    EditText mEtName;
    private YCLicencePresenter mFacePresenter;
    private CaseVerifyPresenter mPresenter;
    private String mStrIDNumber;
    private String mStrName;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private IFaceLiveCallBack mFaceCallBack = null;
    private String mCaseInfoId = "";
    private ArrayList<AccountListBean> mAccountList = null;

    class a implements PermissionsListener {
        a() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            CaseVerifyActivity.this.camerPrimssDlg(z);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            if (!"vivo".equals(Build.BRAND) || Build.VERSION.SDK_INT != 23) {
                CaseVerifyActivity.this.intentFace();
            } else if (util.permissionutil.c.f()) {
                CaseVerifyActivity.this.intentFace();
            } else {
                CaseVerifyActivity.this.camerPrimssDlg(false);
            }
        }
    }

    class b implements IClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f17898a;

        b(boolean z) {
            this.f17898a = z;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            if (this.f17898a) {
                util.k1.j(CaseVerifyActivity.this.mActivity);
            } else {
                CaseVerifyActivity.this.varCamerPrims();
            }
        }
    }

    class c implements IFaceLiveCallBack {
        c() {
        }

        @Override // interfaces.IFaceLiveCallBack
        public void onLivenessFail(int i2) {
        }

        @Override // interfaces.IFaceLiveCallBack
        public void onLivenessSuccess(byte[] bArr) throws IOException {
            CaseVerifyActivity.this.pctureTaken(bArr);
        }
    }

    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f17901a;

        d(String str) {
            this.f17901a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            CaseVerifyActivity.this.confirm(this.f17901a);
        }
    }

    class e implements CaseHistoryCallView {
        e() {
        }

        @Override // ui.callview.CaseHistoryCallView
        public void onSuccessBack() {
        }

        @Override // ui.callview.CaseHistoryCallView
        public void onSuccessCommit() {
            CaseVerifyActivity.this.setResult(-1);
            CaseVerifyActivity.this.mActivity.finish();
        }

        @Override // ui.callview.CaseHistoryCallView
        public void onSuccessDetail(CaseDetailBean caseDetailBean) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void camerPrimssDlg(boolean z) {
        util.b1.f(this.mActivity, "权限开启", "国家反诈中心未取得权限，这样会导致此功能无法使用。", "取消", "去授权", new b(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirm(String str) {
        if (TextUtils.isEmpty(str)) {
            util.w1.a("请重拍");
            return;
        }
        if (TextUtils.isEmpty(this.mStrName) || TextUtils.isEmpty(this.mStrIDNumber)) {
            util.w1.a("请重新填入个人信息");
            finish();
        } else {
            util.b1.a("人脸识别中，请耐心等待...", false, this.mActivity);
            this.mPresenter.createInvited(this.mStrName, this.mStrIDNumber, str);
        }
    }

    private void getIntentData() {
        this.mCaseInfoId = getIntent().getStringExtra(util.k1.C0);
        this.mAccountList = (ArrayList) getIntent().getSerializableExtra(util.k1.f20845c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void intentFace() {
        if (this.mFaceCallBack == null) {
            this.mFaceCallBack = new c();
        }
        this.mFacePresenter.startLiveFace(this.mFaceCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pctureTaken(byte[] bArr) throws IOException {
        Bitmap bitmapA = bArr != null ? util.f1.a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length)) : null;
        if (bitmapA != null) {
            ByteArrayOutputStream byteArrayOutputStreamA = util.f1.a(bitmapA, d.d.C);
            String strA = util.x0.a(byteArrayOutputStreamA);
            try {
                byteArrayOutputStreamA.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            runOnUiThread(new d(strA));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void varCamerPrims() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.A, util.permissionutil.a.z, util.permissionutil.a.f20909c}, new a());
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("安全认证");
        this.mPresenter = new CaseVerifyPresenter(this.mActivity, this);
        this.mFacePresenter = new YCLicencePresenter(this.mActivity);
    }

    @Override // ui.callview.CaseVerifyCallview
    public void onFail() {
        startActivity(new Intent(this.mActivity, (Class<?>) IDVarfyFaceActivity.class));
    }

    @Override // ui.callview.CaseVerifyCallview
    public void onSuccess() {
        getIntentData();
        new CaseHistoryPresenter(this.mActivity, new e()).submitCase(this.mCaseInfoId, this.mAccountList);
    }

    @Override // ui.callview.CaseVerifyCallview
    public void onSuccessID() {
        varCamerPrims();
    }

    @OnClick({R.id.iv_back, R.id.btn_start})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.btn_start) {
            if (id != R.id.iv_back) {
                return;
            }
            finish();
            return;
        }
        Editable text = this.mEtName.getText();
        this.mStrName = TextUtils.isEmpty(text) ? "" : text.toString();
        Editable text2 = this.mEtID.getText();
        this.mStrIDNumber = TextUtils.isEmpty(text2) ? "" : text2.toString();
        if (this.mStrName.length() < 2 || this.mStrName.length() > 20 || !y1.x(this.mStrName)) {
            util.w1.a("姓名格式不正确，请重新输入");
        } else if (util.i1.b(this.mStrIDNumber)) {
            this.mPresenter.checkID(this.mStrIDNumber);
        } else {
            util.w1.a("请填写正确的身份证号");
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_case_verify;
    }
}
