package ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.Nullable;
import bean.APIH5Bean;
import bean.CheckFraudBean;
import bean.CheckFraudCountBean;
import bean.ShareConfigBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.IEditAfterListener;
import interfaces.PermissionsListener;
import java.util.ArrayList;
import java.util.List;
import network.account.APIresult;
import network.http.StatisticsHttp;
import network.http.StatisticsShareHttp;
import ui.Hicore;
import ui.callview.CheckFraudCallView;
import ui.f.c;
import ui.presenter.CheckFraudPresenter;
import ui.view.swip.SwipBackLayout;
import util.y1;

/* loaded from: classes2.dex */
public class CheckFraudActivity extends BaseActivity implements CheckFraudCallView {

    @BindView(R.id.et_content)
    EditText mEtContent;

    @BindView(R.id.iv_back)
    ImageView mIvBack;

    @BindView(R.id.iv_clear)
    ImageView mIvClear;

    @BindView(R.id.iv_right)
    ImageView mIvRight;
    private CheckFraudPresenter mPresenter;

    @BindView(R.id.rb_chat)
    RadioButton mRbChat;

    @BindView(R.id.rb_pay)
    RadioButton mRbPay;

    @BindView(R.id.rb_url)
    RadioButton mRbUrl;
    private ui.f.c mShareDialog;

    @BindView(R.id.tv_count_tip)
    TextView mTvCount_tip;

    @BindView(R.id.ll_scan)
    LinearLayout mTvScan;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private ArrayList<Integer> source;
    private ShareConfigBean shareBean = new ShareConfigBean();
    private int model = 0;

    class a implements IEditAfterListener {
        a() {
        }

        @Override // interfaces.IEditAfterListener
        public void editLength(int i2) {
            if (i2 > 0) {
                CheckFraudActivity.this.mIvClear.setVisibility(0);
            } else {
                CheckFraudActivity.this.mIvClear.setVisibility(8);
            }
        }
    }

    class b implements PermissionsListener {
        b() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(CheckFraudActivity.this.mActivity, list, z, true, this);
            if (z) {
                CheckFraudActivity.this.resetPerssionChecking();
            }
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            j.e.a(CheckFraudActivity.this.mActivity, 200L, PictureMimeType.ofImage(), 1).forResult(1);
        }
    }

    private void changeState(boolean z) {
        this.mEtContent.setText("");
        int i2 = this.model;
        if (i2 == 1) {
            radioState(this.mRbUrl, this.mRbPay, this.mRbChat, R.mipmap.ic_fraud_radio_center);
            this.mEtContent.setHint("请输入或粘贴要查询的IP或URL网址");
            this.mTvScan.setVisibility(0);
        } else if (i2 == 2) {
            radioState(this.mRbChat, this.mRbPay, this.mRbUrl, R.mipmap.ic_fraud_radio_right);
            this.mEtContent.setHint("请输入或粘贴要查询的QQ或微信账号");
            this.mTvScan.setVisibility(8);
        } else {
            radioState(this.mRbPay, this.mRbUrl, this.mRbChat, R.mipmap.ic_fraud_radio_left);
            this.mEtContent.setHint("请输入或粘贴要查询的银行卡号或支付账户");
            this.mTvScan.setVisibility(8);
        }
        if (z) {
            return;
        }
        this.mPresenter.checkFraudCount(this.model);
    }

    private void checkPermission() {
        this.isPerssionChecking = true;
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.A, util.permissionutil.a.z, util.permissionutil.a.f20909c}, new b());
    }

    private String getColorStr(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("<font color=");
        sb.append(i2 > 0 ? "#1A57F3" : "#FF0000");
        sb.append(">");
        sb.append(i2);
        sb.append("</font>");
        return sb.toString();
    }

    private String getTruePath(String str) throws IllegalArgumentException {
        Uri uri = Uri.parse(str);
        if (TextUtils.isEmpty(uri.getAuthority())) {
            return uri.getPath();
        }
        Cursor cursorQuery = getContentResolver().query(uri, null, null, null, null);
        if (cursorQuery != null) {
            int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_data");
            if (cursorQuery.moveToFirst()) {
                String string = cursorQuery.getString(columnIndexOrThrow);
                cursorQuery.close();
                return string;
            }
        }
        return "";
    }

    private void initView() {
        this.mRbPay.setTypeface(this.typ_ME);
        this.mRbUrl.setTypeface(this.typ_ME);
        this.mRbChat.setTypeface(this.typ_ME);
        this.mEtContent.setTypeface(this.typ_ME);
        this.mIvClear.setVisibility(8);
        util.d1.a(this.mEtContent, new a());
        this.mPresenter = new CheckFraudPresenter(this.mActivity, this);
        this.mPresenter.requestShareConfig();
    }

    private void radioState(RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, int i2) {
        radioButton.setBackground(getResources().getDrawable(i2));
        radioButton.setTextColor(getResources().getColor(R.color.black_dark));
        radioButton2.setBackground(null);
        radioButton2.setTextColor(getResources().getColor(R.color.colorWhite));
        radioButton3.setBackground(null);
        radioButton3.setTextColor(getResources().getColor(R.color.colorWhite));
    }

    private void showCount(CheckFraudCountBean checkFraudCountBean) {
        int usableToWeekCount;
        int usableToDayCount = 0;
        if (checkFraudCountBean != null) {
            usableToDayCount = checkFraudCountBean.getUsableToDayCount();
            usableToWeekCount = checkFraudCountBean.getUsableToWeekCount();
        } else {
            usableToWeekCount = 0;
        }
        String str = "今日剩余可查询次数" + getColorStr(usableToDayCount) + "次，本周剩余可查询次数" + getColorStr(usableToWeekCount) + "次";
        util.n1.a("fromHtml-->>" + str);
        this.mTvCount_tip.setText(Html.fromHtml(str));
    }

    private void showDialog(String str) {
        util.b1.b(this.mActivity, str, "确定", null);
    }

    private void startResultPage(CheckFraudBean checkFraudBean) {
        hideProgressDialog();
        checkFraudBean.setContent(this.mEtContent.getText().toString());
        checkFraudBean.setSource(this.source);
        Intent intent = new Intent(this, (Class<?>) CheckFraudResultActivity.class);
        intent.putExtra(util.k1.m0, checkFraudBean);
        intent.putExtra(util.k1.n0, this.shareBean);
        intent.putExtra(util.k1.o0, this.model);
        startActivity(intent);
    }

    @Override // ui.activity.BaseActivity
    public void changePath(List<LocalMedia> list) throws IllegalArgumentException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            list.get(i2).setPath(getTruePath(list.get(i2).getPath()));
        }
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        StatisticsHttp.getInstance().pageOpenHttp(e.d.q);
        SwipBackLayout.a(this.mActivity).a();
        ui.statusbarcompat.b.a((Activity) this, true, false);
        this.mTvTitle.setText("风险查询");
        this.mIvRight.setImageResource(R.drawable.iv_share_white);
        initView();
        changeState(true);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, @Nullable Intent intent) throws IllegalArgumentException {
        List<LocalMedia> listObtainMultipleResult;
        super.onActivityResult(i2, i3, intent);
        if (intent == null || (listObtainMultipleResult = PictureSelector.obtainMultipleResult(intent)) == null || listObtainMultipleResult.size() <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT > 28) {
            changePath(listObtainMultipleResult);
        }
        String path = listObtainMultipleResult.get(0).getPath();
        util.n1.a("扫描二维码--文件路径-->>" + path);
        c.b.c.r rVarA = y1.a(util.y0.a(path));
        if (rVarA == null) {
            util.b1.b(this.mActivity, "未识别出二维码中的内容", "确定", null);
            return;
        }
        util.n1.a("扫描二维码-->>" + rVarA.e());
        this.mEtContent.setText(rVarA.e());
        this.mPresenter.checkFraudIpUrl(this.mEtContent.getText().toString());
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mPresenter.checkFraudCount(this.model);
    }

    @Override // ui.callview.CheckFraudCallView
    public void onSuccessRequest(APIresult<CheckFraudBean> aPIresult) {
        hideProgressDialog();
        String msg = aPIresult.getMsg();
        if (aPIresult.getCode() != 0) {
            util.w1.a(msg);
        } else {
            if (aPIresult.getData() == null) {
                showDialog(aPIresult.getMsg());
                return;
            }
            CheckFraudBean data = aPIresult.getData();
            this.mEtContent.getText().toString();
            startResultPage(data);
        }
    }

    @Override // ui.callview.CheckFraudCallView
    public void onSuccessRequestCount(CheckFraudCountBean checkFraudCountBean) {
        showCount(checkFraudCountBean);
    }

    @Override // ui.callview.CheckFraudCallView
    public void onSuccessShareConfig(APIH5Bean aPIH5Bean) {
        if (aPIH5Bean != null) {
            try {
                if (TextUtils.isEmpty(aPIH5Bean.getValue())) {
                    return;
                }
                this.shareBean = (ShareConfigBean) new com.google.gson.e().a(aPIH5Bean.getValue(), ShareConfigBean.class);
            } catch (Exception unused) {
            }
        }
    }

    @OnClick({R.id.iv_back, R.id.iv_right, R.id.rb_pay, R.id.rb_url, R.id.rb_chat, R.id.iv_clear, R.id.ll_scan, R.id.confirm})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
        }
        switch (view.getId()) {
            case R.id.confirm /* 2131296476 */:
                String string = this.mEtContent.getText().toString();
                if (!TextUtils.isEmpty(string)) {
                    showProgressDialog("查询中...");
                    int i2 = this.model;
                    if (i2 != 1) {
                        if (i2 != 2) {
                            this.mPresenter.checkFraud(string);
                            break;
                        } else {
                            this.mPresenter.checkFraudChat(string);
                            break;
                        }
                    } else {
                        this.mPresenter.checkFraudIpUrl(string);
                        break;
                    }
                } else {
                    util.w1.a("查询内容不能为空");
                    break;
                }
            case R.id.iv_back /* 2131296762 */:
                finish();
                break;
            case R.id.iv_clear /* 2131296772 */:
                this.mEtContent.setText("");
                break;
            case R.id.iv_right /* 2131296826 */:
                ShareConfigBean shareConfigBean = this.shareBean;
                if (shareConfigBean != null && !TextUtils.isEmpty(shareConfigBean.downloadUrl)) {
                    ShareConfigBean shareConfigBean2 = this.shareBean;
                    shareConfigBean2.downloadUrl = shareConfigBean2.downloadUrl.replace("{0}", d.a.m() + "");
                }
                this.mShareDialog = new ui.f.c(this.mActivity, this.shareBean, 2, new c.b() { // from class: ui.activity.m
                    @Override // ui.f.c.b
                    public final void a() {
                        StatisticsShareHttp.getInstance().shareOtherHttp("3");
                    }
                });
                this.mShareDialog.show();
                break;
            case R.id.ll_scan /* 2131296983 */:
                this.model = 1;
                this.mEtContent.setText("");
                checkPermission();
                break;
            case R.id.rb_chat /* 2131297130 */:
                if (this.model != 2) {
                    this.model = 2;
                    changeState(false);
                    break;
                }
                break;
            case R.id.rb_pay /* 2131297134 */:
                if (this.model != 0) {
                    this.model = 0;
                    changeState(false);
                    break;
                }
                break;
            case R.id.rb_url /* 2131297140 */:
                if (this.model != 1) {
                    this.model = 1;
                    changeState(false);
                    break;
                }
                break;
        }
    }

    @Override // ui.callview.CheckFraudCallView
    public void onfailRequest() {
        hideProgressDialog();
        util.w1.a(Hicore.getApp().getResources().getString(R.string.err_system));
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_check_fraud;
    }
}
