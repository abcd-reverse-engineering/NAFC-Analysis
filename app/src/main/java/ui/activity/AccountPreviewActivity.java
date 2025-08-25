package ui.activity;

import adapter.PicturePreviewAdapter;
import adapter.ReportPictureSelAdapter;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.AccountListBean;
import bean.CaseDivisonBean;
import bean.UploadFileBean;
import bean.module.RegionMudelBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.ArrayList;
import java.util.List;
import ui.callview.AccountCallView;
import ui.presenter.AccountPresenter;
import ui.view.swip.SwipBackLayout;

/* loaded from: classes2.dex */
public class AccountPreviewActivity extends BaseActivity implements AccountCallView, ReportPictureSelAdapter.a {

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

    @BindView(R.id.group_amount)
    Group mGroupAmount;

    @BindView(R.id.group_suspect)
    Group mGroupSuspect;

    @BindView(R.id.group_suspect_name)
    View mGroupSuspectName;

    @BindView(R.id.group_victim)
    Group mGroupVictim;

    @BindView(R.id.ll_pictures)
    View mLlPictures;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.tv_amount)
    TextView mTvAmount;

    @BindView(R.id.tv_payment_type)
    TextView mTvPaymentType;

    @BindView(R.id.tv_suspect_type)
    TextView mTvSuspectType;

    @BindView(R.id.tv_time)
    TextView mTvTime;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @BindView(R.id.tv_victim_account_tag)
    TextView mTvVictimAccXing;

    @BindView(R.id.tv_victim_type)
    TextView mTvVictimType;

    @BindView(R.id.tv_victim_type_tag)
    TextView mTvVictimTypeXing;
    private final String ACCOUNT_TYPE_ID_OTHER = "156299792136409088";
    private final String ACCOUNT_TYPE_ID_BANK = "156299792098660353";
    private AccountPresenter mPresenter = null;
    private String mCaseInfoId = "";
    private String mPaymentInfoId = "";
    private AccountListBean mItem = null;
    private ArrayList<UploadFileBean> mUploadPicList = new ArrayList<>();
    private ArrayList<LocalMedia> mLocalMedia = new ArrayList<>();
    private PicturePreviewAdapter mAdapter = null;

    private void redisplay() {
        AccountListBean accountListBean = this.mItem;
        if (accountListBean != null) {
            this.mTvPaymentType.setText(accountListBean.getPaymentTypeText());
            this.mTvPaymentType.setTag(this.mItem.getPaymentType());
            this.mTvTime.setText(this.mItem.getPaymentTime());
            RegionMudelBean regionMudelBeanJ = d.a.j();
            if (regionMudelBeanJ == null || !TextUtils.equals(regionMudelBeanJ.getStopPayment(), "1")) {
                this.mGroupAmount.setVisibility(8);
            } else {
                this.mGroupAmount.setVisibility(0);
                this.mTvAmount.setText(util.d1.a(this.mItem.getTransferAmount(), 2));
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
            this.mEtSuspectAccountName.setEnabled(false);
            this.mGroupSuspectName.setVisibility(0);
            this.mEtSuspectAccount.setText(this.mItem.getSuspectAccount());
            transFilt();
            redisplayPicture();
        }
    }

    private void redisplayPicture() {
        List<UploadFileBean> paymentDetails = this.mItem.getPaymentDetails();
        if (paymentDetails == null || paymentDetails.size() <= 0) {
            this.mLlPictures.setVisibility(8);
            return;
        }
        this.mUploadPicList.addAll(paymentDetails);
        for (UploadFileBean uploadFileBean : paymentDetails) {
            LocalMedia localMedia = new LocalMedia();
            localMedia.setPath(uploadFileBean.getLocalPath());
            localMedia.setFileName(uploadFileBean.getFileName());
            this.mLocalMedia.add(localMedia);
        }
        this.mAdapter.setData(this.mUploadPicList);
    }

    private boolean transFilt() {
        String string = this.mTvPaymentType.getText().toString();
        this.mTvVictimAccXing.setVisibility(0);
        this.mTvVictimTypeXing.setVisibility(0);
        if (!TextUtils.equals("柜面现金转账", string) && !TextUtils.equals("ATM机无卡存款", string)) {
            return false;
        }
        this.mTvVictimAccXing.setVisibility(4);
        this.mTvVictimTypeXing.setVisibility(4);
        return true;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        this.mTvTitle.setText("涉案账户详情");
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
        this.mRecyclerview.setLayoutManager(new GridLayoutManager(this.mActivity, 4));
        this.mAdapter = new PicturePreviewAdapter(this.mActivity, this.mUploadPicList);
        this.mRecyclerview.setAdapter(this.mAdapter);
        redisplay();
    }

    @Override // adapter.ReportPictureSelAdapter.a
    public void onItemClickListener(int i2, ArrayList<LocalMedia> arrayList) {
        if (isDouble()) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) PreviewPictureActivity.class);
        intent.putParcelableArrayListExtra(PreviewPictureActivity.f18539f, arrayList);
        intent.putExtra(PreviewPictureActivity.f18540g, i2);
        startActivityForResult(intent, 1000);
    }

    @Override // ui.callview.AccountCallView
    public void onSuccessAccountType(List<CaseDivisonBean> list) {
    }

    @Override // ui.callview.AccountCallView
    public void onSuccessSave(String str) {
    }

    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        if (!isDouble() && view.getId() == R.id.iv_back) {
            finish();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_account_preview;
    }
}
