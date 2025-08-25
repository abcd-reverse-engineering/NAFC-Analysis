package ui.activity;

import adapter.ReportPictureSelAdapter;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.e.d;
import b.a.a.e.h;
import bean.AccountBean;
import bean.AccountListBean;
import bean.CaseDivisonBean;
import bean.UploadFileBean;
import bean.UploadStateInfo;
import bean.module.ModuelConfig;
import bean.module.RegionMudelBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.xiaomi.mipush.sdk.Constants;
import interfaces.IClickListener;
import interfaces.PermissionsListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import ui.callview.AccountCallView;
import ui.presenter.AccountPresenter;
import ui.view.swip.SwipBackLayout;
import util.y1;

/* loaded from: classes2.dex */
public class AccountActivity extends BasePicUploadActivity implements AccountCallView, ReportPictureSelAdapter.a, BaseQuickAdapter.i {

    @BindView(R.id.et_amount)
    EditText mEtAmount;

    @BindView(R.id.et_suspect_account)
    EditText mEtSuspectAccount;

    @BindView(R.id.et_suspect_account_name)
    EditText mEtSuspectAccountName;

    @BindView(R.id.et_suspect_other)
    EditText mEtSuspectOther;

    @BindView(R.id.et_victim_account)
    EditText mEtVictimAccount;

    @BindView(R.id.et_victim_other)
    EditText mEtVictimOther;

    @BindView(R.id.group_suspect)
    View mGroupSuspect;

    @BindView(R.id.group_victim)
    View mGroupVictim;

    @BindView(R.id.ll_amount)
    LinearLayout mLlAmount;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.tv_confirm)
    TextView mTvConfirm;

    @BindView(R.id.tv_payment_type)
    TextView mTvPaymentType;

    @BindView(R.id.tv_suspect_type)
    TextView mTvSuspectType;

    @BindView(R.id.tv_time)
    TextView mTvTime;

    @BindView(R.id.tv_tip)
    TextView mTvTip;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @BindView(R.id.tv_victim_type)
    TextView mTvVictimType;

    @BindView(R.id.ns_layout)
    NestedScrollView scrollView;
    private final int REQUEST_CODE = 100;
    private final String ACCOUNT_TYPE_ID_OTHER = "156299792136409088";
    private final String ACCOUNT_TYPE_ID_BANK = "156299792098660353";
    private AccountPresenter mPresenter = null;
    private List<CaseDivisonBean> mAccountTypeList = new ArrayList();
    private String mCaseInfoId = "";
    private String mPaymentInfoId = "";
    private AccountListBean mItem = null;
    private int mMaxSelectNum = 6;
    private ArrayList<LocalMedia> mLocalMedia = new ArrayList<>();
    private ReportPictureSelAdapter mAdapter = null;
    private RegionMudelBean mRegionBean = null;
    private int decimalCount = 2;

    class a implements View.OnFocusChangeListener {
        a() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                return;
            }
            String string = AccountActivity.this.mEtAmount.length() > 0 ? AccountActivity.this.mEtAmount.getText().toString() : "";
            AccountActivity accountActivity = AccountActivity.this;
            accountActivity.mEtAmount.setText(util.d1.a(string, accountActivity.decimalCount));
        }
    }

    class b implements PermissionsListener {
        b() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(AccountActivity.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            j.e.a(AccountActivity.this.mActivity, 200L, PictureMimeType.ofImage(), AccountActivity.this.mMaxSelectNum - AccountActivity.this.mLocalMedia.size()).forResult(PictureConfig.CHOOSE_REQUEST);
        }
    }

    class c implements d.m {
        c() {
        }

        @Override // b.a.a.e.d.m
        public void a(String str, String str2, String str3, String str4, String str5) {
            AccountActivity.this.mTvTime.setText(str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str3 + c.c.a.b.a.a.f3100g + str4 + Constants.COLON_SEPARATOR + str5);
        }
    }

    class d extends h.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f17570a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f17571b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f17572c;

        d(TextView textView, List list, View view) {
            this.f17570a = textView;
            this.f17571b = list;
            this.f17572c = view;
        }

        @Override // b.a.a.e.h.a
        public void b(int i2, String str) {
            this.f17570a.setText(str);
            String id = ((CaseDivisonBean) this.f17571b.get(i2)).getId();
            this.f17570a.setTag(id);
            if (this.f17572c != null) {
                if (TextUtils.equals(id, "156299792136409088")) {
                    this.f17572c.setVisibility(0);
                } else {
                    this.f17572c.setVisibility(8);
                }
            }
        }
    }

    class e implements IClickListener {
        e() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            AccountActivity.this.cancleUpLoad();
            AccountActivity.this.finish();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    private void checkPermission() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.z}, new b());
    }

    private boolean compareAccount(String str, String str2) {
        if (TextUtils.isEmpty(str) || !TextUtils.equals(str, str2)) {
            return false;
        }
        this.mEtVictimAccount.setTextColor(ContextCompat.getColor(this.mActivity, R.color.red));
        this.mEtSuspectAccount.setTextColor(ContextCompat.getColor(this.mActivity, R.color.red));
        util.b1.b(this.mActivity, "嫌疑人银行账户与受害人银行账户相同，疑似误录，请再次核实", "确定", null);
        return true;
    }

    private void confirm() {
        String strA;
        String str;
        String string = this.mTvPaymentType.getText().toString();
        Object tag = this.mTvPaymentType.getTag();
        if (TextUtils.isEmpty(string) || tag == null) {
            util.w1.a("请选择转账方式");
            return;
        }
        String string2 = tag.toString();
        String string3 = this.mTvTime.getText().toString();
        if (TextUtils.isEmpty(string3)) {
            util.w1.a("请选择转账时间");
            return;
        }
        if (this.mLlAmount.getVisibility() != 0) {
            strA = "0";
        } else if (this.mEtAmount.length() <= 0) {
            util.w1.a("请输入转账金额");
            return;
        } else {
            strA = util.d1.a(this.mEtAmount.getText().toString(), this.decimalCount);
            this.mEtAmount.setText(strA);
        }
        String string4 = this.mTvVictimType.getText().toString();
        if (!transFilt() && TextUtils.isEmpty(string4)) {
            util.w1.a("请选择受害人账户类型");
            return;
        }
        Object tag2 = this.mTvVictimType.getTag();
        String str2 = "";
        String string5 = tag2 != null ? tag2.toString() : "";
        String string6 = this.mEtVictimOther.getText().toString();
        if (this.mGroupVictim.getVisibility() != 0) {
            string6 = "";
        } else if (TextUtils.isEmpty(string6)) {
            util.w1.a("请输入受害人账户类型");
            return;
        }
        String string7 = this.mEtVictimAccount.getText().toString();
        if (!transFilt() && TextUtils.isEmpty(string7)) {
            util.w1.a("请输入受害人账号");
            return;
        }
        String string8 = this.mTvSuspectType.getText().toString();
        Object tag3 = this.mTvSuspectType.getTag();
        if (TextUtils.isEmpty(string8) && this.mLocalMedia.size() == 0) {
            util.w1.a("请完善嫌疑人账户信息或上传转账汇款凭证");
            return;
        }
        String string9 = tag3 != null ? tag3.toString() : "";
        String string10 = this.mEtSuspectOther.getText().toString();
        String string11 = this.mEtSuspectAccountName.getText().toString();
        String string12 = this.mEtSuspectAccount.getText().toString();
        if (this.mLocalMedia.size() == 0) {
            if (TextUtils.isEmpty(string8) || tag3 == null) {
                util.w1.a("请选择嫌疑人账户类型");
                return;
            }
            if (this.mGroupSuspect.getVisibility() == 0) {
                if (TextUtils.isEmpty(string10)) {
                    util.w1.a("请输入嫌疑人账户类型");
                    return;
                }
                str2 = string10;
            }
            if (TextUtils.isEmpty(string11)) {
                util.w1.a("请输入嫌疑人账户名");
                return;
            } else if (TextUtils.isEmpty(string12)) {
                util.w1.a("请输入嫌疑人账号");
                return;
            } else if (compareAccount(string7, string12)) {
                return;
            }
        } else {
            if (TextUtils.isEmpty(string8) && TextUtils.isEmpty(string11) && TextUtils.isEmpty(string12)) {
                str = string10;
                AccountBean accountBean = new AccountBean();
                accountBean.setId(this.mCaseInfoId);
                accountBean.setPaymentInfoID(this.mPaymentInfoId);
                accountBean.setPaymentType(string2);
                accountBean.setPaymentTypeText(string);
                accountBean.setPaymentTime(string3);
                accountBean.setTransferAmount(strA);
                accountBean.setVictim(string5, string4, string6, string7);
                accountBean.setSuspect(string9, string8, str, string12, string11);
                this.mPresenter.savePayment(accountBean);
            }
            if (TextUtils.isEmpty(string8) || tag3 == null) {
                util.w1.a("请选择嫌疑人账户类型");
                return;
            }
            if (this.mGroupSuspect.getVisibility() == 0) {
                if (TextUtils.isEmpty(string10)) {
                    util.w1.a("请输入嫌疑人账户类型");
                    return;
                }
                str2 = string10;
            }
            if (TextUtils.isEmpty(string11)) {
                util.w1.a("请输入嫌疑人账户名");
                return;
            } else if (TextUtils.isEmpty(string12)) {
                util.w1.a("请输入嫌疑人账号");
                return;
            } else if (compareAccount(string7, string12)) {
                return;
            }
        }
        str = str2;
        AccountBean accountBean2 = new AccountBean();
        accountBean2.setId(this.mCaseInfoId);
        accountBean2.setPaymentInfoID(this.mPaymentInfoId);
        accountBean2.setPaymentType(string2);
        accountBean2.setPaymentTypeText(string);
        accountBean2.setPaymentTime(string3);
        accountBean2.setTransferAmount(strA);
        accountBean2.setVictim(string5, string4, string6, string7);
        accountBean2.setSuspect(string9, string8, str, string12, string11);
        this.mPresenter.savePayment(accountBean2);
    }

    private ReportPictureSelAdapter initRecycle(NestedScrollView nestedScrollView, RecyclerView recyclerView, ArrayList<LocalMedia> arrayList, List<UploadStateInfo> list) {
        recycleViewListener(nestedScrollView, recyclerView);
        return ReportPictureSelAdapter.a(this.mActivity, recyclerView, this.mMaxSelectNum, this, this, arrayList, list);
    }

    private void onkeyback() {
        util.b1.a(this.mActivity, "放弃本次信息编辑？", "", "确定", "取消", -1, -1, true, (IClickListener) new e());
    }

    private void redisplay() {
        AccountListBean accountListBean = this.mItem;
        if (accountListBean != null) {
            this.mTvPaymentType.setText(accountListBean.getPaymentTypeText());
            this.mTvPaymentType.setTag(this.mItem.getPaymentType());
            this.mTvTime.setText(this.mItem.getPaymentTime());
            if (this.mLlAmount.getVisibility() == 0) {
                this.mEtAmount.setText(util.d1.a(this.mItem.getTransferAmount(), this.decimalCount));
            }
            String victimAccountType = this.mItem.getVictimAccountType();
            this.mTvVictimType.setText(this.mItem.getVictimAccountTypeText());
            this.mTvVictimType.setTag(victimAccountType);
            if (TextUtils.equals(victimAccountType, "156299792136409088")) {
                this.mEtVictimOther.setText(this.mItem.getVictimAccountTypeText1());
                this.mGroupVictim.setVisibility(0);
            } else {
                this.mGroupVictim.setVisibility(8);
            }
            this.mEtVictimAccount.setText(this.mItem.getVictimAccount());
            String suspectAccountType = this.mItem.getSuspectAccountType();
            this.mTvSuspectType.setText(this.mItem.getSuspectAccountTypeText());
            this.mTvSuspectType.setTag(suspectAccountType);
            if (TextUtils.equals(suspectAccountType, "156299792136409088")) {
                this.mEtSuspectOther.setText(this.mItem.getSuspectAccountTypeText1());
                this.mGroupSuspect.setVisibility(0);
            } else {
                this.mGroupSuspect.setVisibility(8);
            }
            this.mEtSuspectAccountName.setText(this.mItem.getSuspectName());
            this.mEtSuspectAccount.setText(this.mItem.getSuspectAccount());
            transFilt();
            redisplayPicture();
        }
    }

    private void redisplayPicture() {
        List<UploadFileBean> paymentDetails = this.mItem.getPaymentDetails();
        if (paymentDetails != null && paymentDetails.size() > 0) {
            this.mUploadPicList.addAll(paymentDetails);
            for (UploadFileBean uploadFileBean : paymentDetails) {
                UploadStateInfo uploadStateInfo = new UploadStateInfo();
                uploadStateInfo.setUploadState(2);
                this.mUploadStateList.add(uploadStateInfo);
                LocalMedia localMedia = new LocalMedia();
                localMedia.setPath(uploadFileBean.getFileUrl());
                localMedia.setFileName(uploadFileBean.getFileName());
                this.mLocalMedia.add(localMedia);
            }
        }
        this.mAdapter.notifyDataSetChanged();
    }

    private void showTimePiker() {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(1);
        int i3 = calendar.get(2) + 1;
        int i4 = calendar.get(5);
        int i5 = calendar.get(11);
        int i6 = calendar.get(12);
        b.a.a.e.d dVar = new b.a.a.e.d(this, 0, 3);
        dVar.g(2018, 2055);
        dVar.a(i2, i3, i4, i5, i6);
        dVar.setOnDateTimePickListener(new c());
        dVar.m();
    }

    private void showTypePiker(List<CaseDivisonBean> list, TextView textView, View view) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(list.get(i2).getName());
        }
        if (arrayList.size() == 0) {
            return;
        }
        b.a.a.e.h hVar = new b.a.a.e.h(this.mActivity, arrayList);
        hVar.x(3);
        hVar.E(0);
        hVar.C(15);
        hVar.setOnOptionPickListener(new d(textView, list, view));
        hVar.m();
    }

    private boolean transFilt() {
        String string = this.mTvPaymentType.getText().toString();
        return TextUtils.equals("柜面现金转账", string) || TextUtils.equals("ATM机无卡存款", string);
    }

    @Override // ui.activity.BasePicUploadActivity
    public void changeBtnCommit(String str, boolean z) {
        if (this.mTvConfirm != null) {
            if (!TextUtils.isEmpty(str)) {
                this.mTvConfirm.setText(str);
            }
            this.mTvConfirm.setEnabled(z);
        }
    }

    @Override // ui.activity.BasePicUploadActivity
    public void createUpLoadInfo(UploadFileBean uploadFileBean) {
        uploadFileBean.setId(this.mCaseInfoId);
        uploadFileBean.setPaymentInfoID(this.mPaymentInfoId);
    }

    @Override // ui.activity.BasePicUploadActivity
    public String deLoadFileUrl() {
        return d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.m1);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        this.mTvTitle.setText("涉案账户信息");
        this.mTvTip.setText("最多可选择" + this.mMaxSelectNum + "张图片");
        this.mRegionBean = d.a.j();
        RegionMudelBean regionMudelBean = this.mRegionBean;
        if (regionMudelBean == null || !TextUtils.equals(regionMudelBean.getStopPayment(), "1")) {
            this.mLlAmount.setVisibility(8);
        } else {
            this.mLlAmount.setVisibility(0);
            util.d1.a(this.mEtAmount, this.decimalCount, null);
            this.mEtAmount.setOnFocusChangeListener(new a());
        }
        this.mPresenter = new AccountPresenter(this, this);
        this.mPresenter.accountType();
        this.mCaseInfoId = getIntent().getStringExtra(util.k1.C0);
        try {
            this.mItem = (AccountListBean) getIntent().getSerializableExtra(util.k1.f20845c);
            this.mPaymentInfoId = this.mItem.getId();
        } catch (Exception e2) {
            e2.printStackTrace();
            this.mItem = null;
            this.mPaymentInfoId = "";
        }
        this.mAdapter = initRecycle(this.scrollView, this.mRecyclerview, this.mLocalMedia, this.mUploadStateList);
        util.d1.c(this.mEtSuspectAccountName);
        redisplay();
    }

    @Override // ui.activity.BasePicUploadActivity
    public void notifyAdapter() {
        super.notifyAdapter();
        if (this.mLocalMedia == null || this.isScroll) {
            this.isScrollOver = true;
            return;
        }
        int i2 = this.mCurrentUploadIndex;
        if (i2 < 0) {
            this.mAdapter.notifyDataSetChanged();
        } else if (!this.isScrollOver) {
            this.mAdapter.notifyItemChanged(i2);
        } else {
            this.mAdapter.notifyItemRangeChanged(0, i2);
            this.isScrollOver = false;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) throws IllegalArgumentException {
        CaseDivisonBean caseDivisonBean;
        List listObtainMultipleResult;
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            if (i2 == 100) {
                if (intent == null || (caseDivisonBean = (CaseDivisonBean) intent.getSerializableExtra(util.k1.j1)) == null) {
                    return;
                }
                this.mTvPaymentType.setText(caseDivisonBean.getName());
                this.mTvPaymentType.setTag(caseDivisonBean.getId());
                transFilt();
                return;
            }
            if (i2 == 188 && (listObtainMultipleResult = PictureSelector.obtainMultipleResult(intent)) != null && listObtainMultipleResult.size() > 0) {
                if (Build.VERSION.SDK_INT > 28) {
                    y1.a(this.mActivity, (List<LocalMedia>) listObtainMultipleResult);
                }
                List<LocalMedia> listA = y1.a((List<LocalMedia>) listObtainMultipleResult);
                for (int i4 = 0; i4 < listA.size(); i4++) {
                    LocalMedia localMedia = listA.get(i4);
                    localMedia.setChecked(false);
                    this.mLocalMedia.add(localMedia);
                    this.mUploadStateList.add(new UploadStateInfo());
                    UploadFileBean uploadFileBean = new UploadFileBean();
                    uploadFileBean.setLocalPath(localMedia.getPath());
                    uploadFileBean.setFileName(localMedia.getFileName());
                    this.mUploadPicList.add(uploadFileBean);
                }
                this.mAdapter.notifyDataSetChanged();
                changeBtnCommit("确定", true);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void a() {
        if (this.mItem != null) {
            setResult(-1);
        }
        super.a();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (isDouble() || view.getId() != R.id.iv_clear || rejuctOperation(false)) {
            return;
        }
        deleteDialog(i2);
    }

    @Override // adapter.ReportPictureSelAdapter.a
    public void onItemClickListener(int i2, ArrayList<LocalMedia> arrayList) {
        if (isDouble()) {
            return;
        }
        if (i2 == arrayList.size()) {
            if (rejuctOperation(false)) {
                return;
            }
            checkPermission();
            return;
        }
        String path = arrayList.get(i2).getPath();
        Intent intent = new Intent(this, (Class<?>) PreviewPictureActivity.class);
        intent.putParcelableArrayListExtra(PreviewPictureActivity.f18539f, arrayList);
        intent.putExtra(PreviewPictureActivity.f18540g, i2);
        intent.putExtra(PreviewPictureActivity.f18541h, arrayList.size());
        intent.putExtra(PreviewPictureActivity.f18542i, path);
        startActivityForResult(intent, 1000);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        onkeyback();
        return true;
    }

    @Override // ui.callview.AccountCallView
    public void onSuccessAccountType(List<CaseDivisonBean> list) {
        this.mAccountTypeList = list;
    }

    @Override // ui.callview.AccountCallView
    public void onSuccessSave(String str) {
        this.mPaymentInfoId = str;
        if (this.mLocalMedia.size() > 0) {
            commitDeal();
        } else {
            pageFileFinish();
        }
    }

    @OnClick({R.id.iv_back, R.id.tv_payment_type, R.id.tv_time, R.id.tv_victim_type, R.id.tv_suspect_type, R.id.tv_confirm})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.iv_back /* 2131296762 */:
                onkeyback();
                break;
            case R.id.tv_confirm /* 2131297484 */:
                confirm();
                break;
            case R.id.tv_payment_type /* 2131297634 */:
                startActivityForResult(new Intent(this, (Class<?>) PaymentTypeActivity.class), 100);
                break;
            case R.id.tv_suspect_type /* 2131297741 */:
                showTypePiker(this.mAccountTypeList, this.mTvSuspectType, this.mGroupSuspect);
                break;
            case R.id.tv_time /* 2131297752 */:
                showTimePiker();
                break;
            case R.id.tv_victim_type /* 2131297806 */:
                showTypePiker(this.mAccountTypeList, this.mTvVictimType, this.mGroupVictim);
                break;
        }
    }

    @Override // ui.activity.BasePicUploadActivity
    protected void pageFileFinish() {
        super.pageFileFinish();
        if (this.mItem != null) {
            util.w1.a("修改成功");
        } else {
            util.w1.a("添加成功");
        }
        setResult(-1);
        finish();
    }

    @Override // ui.activity.BasePicUploadActivity
    public void removeLocalData(int i2) {
        this.mLocalMedia.remove(i2);
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_account;
    }

    @Override // ui.activity.BasePicUploadActivity
    public String upLoadFileUrl() {
        return d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.l1);
    }
}
