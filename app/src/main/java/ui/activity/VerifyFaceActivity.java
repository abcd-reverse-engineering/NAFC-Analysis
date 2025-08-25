package ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.a.e.h;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import interfaces.PermissionsListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import manager.AccountManager;
import manager.BaseDialog;
import org.greenrobot.eventbus.ThreadMode;
import ui.Hicore;
import ui.callview.VerifyFaceCallview;
import ui.presenter.VerifyFacePresenter;
import util.y1;
import util.z1;

/* loaded from: classes2.dex */
public class VerifyFaceActivity extends BaseActivity implements TextWatcher, VerifyFaceCallview {

    @BindView(R.id.confirm)
    TextView mConfirm;

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    private VerifyFacePresenter mPresenter;

    @BindView(R.id.tv_card_type)
    TextView mTvCardType;

    @BindView(R.id.tv_right)
    TextView mTvRight;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @BindView(R.id.user_ID)
    EditText mUserID;

    @BindView(R.id.user_name)
    EditText mUserName;
    private boolean isIDCardType = true;
    String strName = "";
    String strIDNumber = "";
    private BaseDialog mDlgRed = null;

    @SuppressLint({"HandlerLeak"})
    private Handler mHandler = new e();
    Dialog dialog = null;

    class a extends h.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f19164a;

        a(TextView textView) {
            this.f19164a = textView;
        }

        @Override // b.a.a.e.h.a
        public void b(int i2, String str) {
            if (i2 == 0) {
                VerifyFaceActivity.this.isIDCardType = true;
                VerifyFaceActivity.this.mConfirm.setText("去人脸识别");
            } else {
                VerifyFaceActivity.this.isIDCardType = false;
                VerifyFaceActivity.this.mConfirm.setText("去人工审核");
            }
            this.f19164a.setText(str);
        }
    }

    class b implements PermissionsListener {
        b() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            VerifyFaceActivity.this.camerPrimssDlg(z);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            if (!"vivo".equals(Build.BRAND) || Build.VERSION.SDK_INT != 23) {
                VerifyFaceActivity.this.intentFace();
            } else if (util.permissionutil.c.f()) {
                VerifyFaceActivity.this.intentFace();
            } else {
                VerifyFaceActivity.this.camerPrimssDlg(false);
            }
        }
    }

    class c implements IClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f19167a;

        c(boolean z) {
            this.f19167a = z;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            if (this.f19167a) {
                util.k1.j(VerifyFaceActivity.this.mActivity);
            } else {
                VerifyFaceActivity.this.varCamerPrims();
            }
        }
    }

    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f19169a;

        d(String str) {
            this.f19169a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VerifyFaceActivity.this.confirm(this.f19169a);
        }
    }

    class e extends Handler {
        e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (VerifyFaceActivity.this.isFinishing()) {
            }
            int i2 = message.what;
            if (i2 != -2) {
                VerifyFaceActivity.this.hideProgressDialog();
            }
            if (i2 != -2) {
                if (i2 == -1) {
                    VerifyFaceActivity.this.showManualCheck("注册失败,您可通过人工审核提交信息，并联系民警审核");
                    return;
                }
                if (i2 == 30) {
                    VerifyFaceActivity.this.overrunDialog();
                    return;
                }
                if (i2 == 31) {
                    Object obj = message.obj;
                    if (obj != null) {
                        util.b1.b(VerifyFaceActivity.this.mActivity, obj.toString(), "确定", null);
                        return;
                    }
                    return;
                }
                switch (i2) {
                    case 1:
                        util.w1.a("实名认证成功");
                        VerifyFacePresenter verifyFacePresenter = VerifyFaceActivity.this.mPresenter;
                        VerifyFaceActivity verifyFaceActivity = VerifyFaceActivity.this;
                        verifyFacePresenter.resultSuccess(verifyFaceActivity.strName, verifyFaceActivity.strIDNumber);
                        break;
                    case 2:
                    case 3:
                        VerifyFaceActivity.this.showManualCheck("人脸识别未通过,您可通过人工审核提交信息，并联系民警审核");
                        break;
                    case 4:
                        VerifyFaceActivity.this.showManualCheck("身份核验不一致,您可通过人工审核提交信息，并联系民警审核");
                        break;
                    case 5:
                    case 6:
                        VerifyFaceActivity.this.showManualCheck("抱歉，您的人脸信息不在公安的人脸库中，您可通过人工审核提交信息，并联系民警审核，或者尝试重新输入");
                        break;
                    case 7:
                        VerifyFaceActivity.this.showManualCheck("人脸拍摄不合格,您可通过人工审核提交信息，并联系民警审核");
                        break;
                    default:
                        VerifyFaceActivity.this.showManualCheck("核验失败,您可通过人工审核提交信息，并联系民警审核");
                        break;
                }
            }
        }
    }

    class f implements IClickListener {
        f() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            VerifyFacePresenter verifyFacePresenter = VerifyFaceActivity.this.mPresenter;
            VerifyFaceActivity verifyFaceActivity = VerifyFaceActivity.this;
            verifyFacePresenter.unbind(verifyFaceActivity.strName, verifyFaceActivity.strIDNumber, "", "");
        }
    }

    class g implements IClickListener {
        g() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            VerifyFaceActivity.this.turnManualPage(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void camerPrimssDlg(boolean z) {
        util.b1.f(this.mActivity, "权限开启", "国家反诈中心未取得权限，这样会导致此功能无法使用。", "取消", "去授权", new c(z));
    }

    private void clearVeifiedUseData() {
        z1.v = null;
        if (z1.w) {
            startActivity(new Intent(this, (Class<?>) MainActivity.class));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirm(String str) {
        if (isFinishing()) {
            return;
        }
        if (TextUtils.isEmpty(this.strName) || TextUtils.isEmpty(this.strIDNumber)) {
            util.w1.a("请重新填入个人信息");
            finish();
        } else {
            util.b1.a("人脸识别中，请耐心等待...", false, this.mActivity);
            this.mPresenter.verify(str, this.strName, this.strIDNumber, "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void intentFace() {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        this.strName = this.mUserName.getText().toString().trim();
        this.strIDNumber = this.mUserID.getText().toString().trim().toUpperCase();
        if (this.isIDCardType) {
            turnFacePage();
        } else {
            turnManualPage(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void overrunDialog() {
        this.mDlgRed = util.b1.c(this.mActivity, "当前身份信息已实名其他账号，是否换绑新账号？", "注意：换绑后，老账号将被注销！", "取消", "确定", new f());
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
            runOnUiThread(new d(strA));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showManualCheck(String str) {
        showManualCheck(str, "重新输入");
    }

    private void turnFacePage() {
        if (this.strName.length() < 2 || this.strName.length() > 22 || !y1.x(this.strName)) {
            util.w1.a("姓名格式不正确，请重新输入");
        } else if (util.i1.b(this.strIDNumber)) {
            this.mPresenter.redName(this.strName, this.strIDNumber, "1");
        } else {
            util.w1.a("身份证号不正确，请重新输入");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void turnManualPage(boolean z) {
        Intent intent;
        if (this.strName.trim().length() < 1) {
            util.w1.a("姓名格式不正确，请重新输入");
            return;
        }
        if (this.strIDNumber.trim().length() < 1) {
            util.w1.a("证件号不正确，请重新输入");
            return;
        }
        if (TextUtils.isEmpty(AccountManager.getVisiblePhone())) {
            intent = new Intent(this.mActivity, (Class<?>) ManualPhoneActivity.class);
        } else {
            intent = new Intent(this.mActivity, (Class<?>) ManualCheckActivity.class);
            intent.putExtra(util.k1.e0, AccountManager.getVisiblePhone());
        }
        intent.putExtra(util.k1.b0, this.strName);
        intent.putExtra(util.k1.f20846d, z);
        intent.putExtra(util.k1.d0, this.strIDNumber);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void varCamerPrims() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.A, util.permissionutil.a.z, util.permissionutil.a.f20909c}, new b());
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String strTrim = this.mUserName.getText().toString().trim();
        String strTrim2 = this.mUserID.getText().toString().trim();
        if (TextUtils.isEmpty(strTrim) || TextUtils.isEmpty(strTrim2)) {
            this.mConfirm.setEnabled(false);
        } else {
            this.mConfirm.setEnabled(true);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        org.greenrobot.eventbus.c.f().e(this);
        this.mTvTitle.setText("");
        this.mPresenter = new VerifyFacePresenter(this.mActivity, this);
        this.mUserName.addTextChangedListener(this);
        this.mUserID.addTextChangedListener(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        clearVeifiedUseData();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(util.c2.a aVar) {
        if (aVar == null || aVar.a() != 200) {
            return;
        }
        finish();
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventWornThread(util.c2.a aVar) {
        if (aVar == null || aVar.a() != 211) {
            return;
        }
        finish();
    }

    @Override // ui.callview.VerifyFaceCallview
    public void onSuccImaggRequest(byte[] bArr) throws IOException {
        pctureTaken(bArr);
    }

    @Override // ui.callview.VerifyFaceCallview
    public void onSuccRequest(Message message) {
        util.b1.a();
        this.mHandler.sendMessage(message);
    }

    @Override // ui.callview.VerifyFaceCallview
    public void onSuccessRedName(boolean z) {
        if (z) {
            showManualCheck("身份认证不通过", "我知道了");
        } else {
            this.mPresenter.startLive();
        }
    }

    @Override // ui.callview.VerifyFaceCallview
    public void onSuccessUnbind() {
        BaseDialog baseDialog = this.mDlgRed;
        if (baseDialog != null) {
            baseDialog.dismiss();
        }
        this.mPresenter.resultSuccess(this.strName, this.strIDNumber);
    }

    @Override // ui.callview.VerifyFaceCallview
    public void onSuccessUnbindOverrun() {
        BaseDialog baseDialog = this.mDlgRed;
        if (baseDialog != null) {
            baseDialog.dismiss();
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @OnClick({R.id.iv_back, R.id.tv_right, R.id.tv_card_type, R.id.confirm})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.confirm) {
            varCamerPrims();
        } else if (id == R.id.iv_back) {
            onBackPressed();
        } else {
            if (id != R.id.tv_card_type) {
                return;
            }
            showCredentPiker(this.mTvCardType);
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_register_personal;
    }

    public void showCredentPiker(TextView textView) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("身份证");
        arrayList.add("护照");
        if (arrayList.size() == 0) {
            return;
        }
        b.a.a.e.h hVar = new b.a.a.e.h(this.mActivity, arrayList);
        hVar.x(3);
        hVar.E(0);
        hVar.C(15);
        hVar.setOnOptionPickListener(new a(textView));
        hVar.m();
    }

    private void showManualCheck(String str, String str2) {
        Dialog dialog = this.dialog;
        if (dialog == null || !dialog.isShowing()) {
            this.dialog = util.b1.b(this.mActivity, str, "", str2, "人工审核", new g());
        }
    }
}
