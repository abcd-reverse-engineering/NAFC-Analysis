package ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import interfaces.ITextCallBackListener;
import interfaces.PermissionsListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import manager.AccountManager;
import ui.Hicore;
import ui.callview.HandleIDVarfyFaceView;
import ui.presenter.HandleIDVarfyFacePresenter;
import ui.presenter.HelperPresenter;
import util.y1;

/* loaded from: classes2.dex */
public class HandleIDVerifyActivity extends BaseActivity implements HandleIDVarfyFaceView {

    @BindView(R.id.btn_idvrfy_start)
    Button mConfirm;

    @BindView(R.id.user_name)
    EditText mEtName;

    @BindView(R.id.user_ID)
    EditText mEtUserId;

    @SuppressLint({"HandlerLeak"})
    private Handler mHandler = new d();

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    private HelperPresenter mPresent;
    private HandleIDVarfyFacePresenter mPresenter;

    @BindView(R.id.cb_select)
    CheckBox mTCbSelect;

    @BindView(R.id.tv_right)
    TextView mTvRight;

    @BindView(R.id.tv_select_tip)
    TextView mTvSelectTips;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    String strIDNumber;
    String strName;
    String verifyId;
    String verifyNameFrid;

    class a implements PermissionsListener {
        a() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            HandleIDVerifyActivity.this.camerPrimssDlg(z);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            if (!"vivo".equals(Build.BRAND) || Build.VERSION.SDK_INT != 23) {
                HandleIDVerifyActivity.this.intentFace();
            } else if (util.permissionutil.c.f()) {
                HandleIDVerifyActivity.this.intentFace();
            } else {
                HandleIDVerifyActivity.this.camerPrimssDlg(false);
            }
        }
    }

    class b implements IClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f18207a;

        b(boolean z) {
            this.f18207a = z;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            if (this.f18207a) {
                util.k1.j(HandleIDVerifyActivity.this.mActivity);
            } else {
                HandleIDVerifyActivity.this.varCamerPrims();
            }
        }
    }

    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f18209a;

        c(String str) {
            this.f18209a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            HandleIDVerifyActivity.this.confirm(this.f18209a);
        }
    }

    class d extends Handler {
        d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != -2) {
                HandleIDVerifyActivity.this.hideProgressDialog();
            }
            if (i2 == 999) {
                HandleIDVerifyActivity.this.startActivity(IDVarfyFaceActivity.class);
            }
            switch (i2) {
                case 1:
                    util.w1.a("核验成功");
                    org.greenrobot.eventbus.c.f().d(new util.c2.a(38, null));
                    HandleIDVerifyActivity handleIDVerifyActivity = HandleIDVerifyActivity.this;
                    AccountManager.setVerified(true, handleIDVerifyActivity.strName, handleIDVerifyActivity.strIDNumber);
                    Intent intent = new Intent(HandleIDVerifyActivity.this.mActivity, (Class<?>) IDVarfySuccessActivity.class);
                    intent.putExtra(util.k1.k0, HandleIDVerifyActivity.this.verifyNameFrid);
                    HandleIDVerifyActivity.this.startActivity(intent);
                    HandleIDVerifyActivity.this.mActivity.finish();
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    HandleIDVerifyActivity.this.startActivity(IDVarfyFaceActivity.class);
                    break;
                case 8:
                    org.greenrobot.eventbus.c.f().d(new util.c2.a(39, null));
                    util.w1.a("核验数据已过期~");
                    HandleIDVerifyActivity.this.finish();
                    break;
                default:
                    HandleIDVerifyActivity.this.startActivity(IDVarfyFaceActivity.class);
                    break;
            }
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
        if (TextUtils.isEmpty(this.strName) || TextUtils.isEmpty(this.strIDNumber)) {
            util.w1.a("请重新填入个人信息");
            finish();
        } else {
            util.b1.a("人脸识别中，请耐心等待...", false, this.mActivity);
            this.mPresenter.verifyAction(str, this.strName, this.strIDNumber, this.verifyId);
        }
    }

    private void getIntentData() {
        this.verifyId = getIntent().getStringExtra(util.k1.c0);
        this.verifyNameFrid = getIntent().getStringExtra(util.k1.b0);
    }

    private void initCluse() {
        String str = "您同意通过国家反诈中心APP传达本人身份核实信息给请求方查看协议详情>";
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ui.view.o(str, new ITextCallBackListener() { // from class: ui.activity.u
            @Override // interfaces.ITextCallBackListener
            public final void onResult(String str2) {
                this.f19476a.a(str2);
            }
        }), 28, str.length(), 33);
        this.mTvSelectTips.setMovementMethod(LinkMovementMethod.getInstance());
        this.mTvSelectTips.setText(spannableString);
        this.mTCbSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ui.activity.v
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f19480a.a(compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void intentFace() {
        Editable text = this.mEtName.getText();
        this.strName = TextUtils.isEmpty(text) ? "" : text.toString();
        Editable text2 = this.mEtUserId.getText();
        this.strIDNumber = TextUtils.isEmpty(text2) ? "" : text2.toString();
        if (this.strName.length() < 2 || this.strName.length() > 22 || !y1.x(this.strName)) {
            util.w1.a("姓名格式不正确，请重新输入");
        } else if (util.i1.b(this.strIDNumber)) {
            this.mPresenter.startLive();
        } else {
            util.w1.a("身份证号不正确，请重新输入");
        }
    }

    private void pctureTaken(byte[] bArr) throws IOException {
        Bitmap bitmapA = bArr != null ? util.f1.a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length)) : null;
        if (bitmapA != null) {
            ByteArrayOutputStream byteArrayOutputStreamA = util.f1.a(bitmapA, d.d.C);
            String strA = util.x0.a(byteArrayOutputStreamA);
            try {
                byteArrayOutputStreamA.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            runOnUiThread(new c(strA));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void varCamerPrims() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.A, util.permissionutil.a.z, util.permissionutil.a.f20909c}, new a());
    }

    public /* synthetic */ void a(String str) {
        Intent intent = new Intent(this.mActivity, (Class<?>) WebActivity.class);
        intent.putExtra(util.k1.P, "协议详情");
        intent.putExtra(util.k1.Q, this.mPresent.getXY_verification());
        startActivity(intent);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("身份核实");
        this.mPresent = new HelperPresenter((Activity) this);
        this.mPresenter = new HandleIDVarfyFacePresenter(this.mActivity, this);
        getIntentData();
        initCluse();
        this.mPresent.requestVerificationXY();
    }

    @Override // ui.callview.HandleIDVarfyFaceView
    public void onSuccImaggRequest(byte[] bArr) throws IOException {
        pctureTaken(bArr);
    }

    @Override // ui.callview.HandleIDVarfyFaceView
    public void onSuccRequest(Message message) {
        util.b1.a();
        this.mHandler.sendMessage(message);
    }

    @OnClick({R.id.iv_back, R.id.btn_idvrfy_start})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.btn_idvrfy_start) {
            if (id != R.id.iv_back) {
                return;
            }
            finish();
        } else if (this.mTCbSelect.isChecked()) {
            varCamerPrims();
        } else {
            util.w1.a("请先阅读并同意底部协议");
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_id_handle;
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        this.mTCbSelect.setChecked(z);
    }
}
