package ui.activity;

import adapter.SmsPictureAdapter;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.e.i;
import bean.BrandBean;
import bean.CriminalSmsBean;
import bean.SmsBean;
import bean.SmsPictureBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.IClickListener;
import interfaces.PermissionsListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import manager.AccountManager;
import ui.callview.CriminalSmsAddCallView;
import ui.presenter.CriminalSmsAddPresenter;

/* loaded from: classes2.dex */
public class CriminalSmsSelectActivity extends BaseActivity implements CriminalSmsAddCallView, SmsPictureAdapter.b, BaseQuickAdapter.i {
    private SmsPictureAdapter mAdapter;

    @BindView(R.id.confirm)
    TextView mBtnCommit;
    private String mCaseInfoId;

    @BindView(R.id.et_phone)
    EditText mEtPhone;

    @BindView(R.id.tv_victim_phone)
    EditText mEtVictimPhone;

    @BindView(R.id.ll_picture)
    LinearLayout mLlPicture;
    private CriminalSmsAddPresenter mPresenter;

    @BindView(R.id.rb_no)
    RadioButton mRbNo;

    @BindView(R.id.rb_yes)
    RadioButton mRbYes;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.tv_describe)
    TextView mTvDescribe;

    @BindView(R.id.tv_time)
    TextView mTvTime;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private CriminalSmsBean mCriminalSmsBean = null;
    private List<CriminalSmsBean> mList = new ArrayList();
    private int mPosition = -1;
    private int mMaxSelectNum = 6;
    private List<LocalMedia> mLocalMedia = new ArrayList();
    private boolean mOnlyShow = false;

    class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                int id = compoundButton.getId();
                if (id == R.id.rb_no) {
                    CriminalSmsSelectActivity.this.mRbYes.setChecked(false);
                } else {
                    if (id != R.id.rb_yes) {
                        return;
                    }
                    CriminalSmsSelectActivity.this.mRbNo.setChecked(false);
                }
            }
        }
    }

    class b implements PermissionsListener {
        b() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(CriminalSmsSelectActivity.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            j.e.a(CriminalSmsSelectActivity.this.mActivity, 200L, PictureMimeType.ofImage(), CriminalSmsSelectActivity.this.mMaxSelectNum - CriminalSmsSelectActivity.this.mLocalMedia.size()).forResult(PictureConfig.CHOOSE_REQUEST);
        }
    }

    class c implements IClickListener {
        c() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            CriminalSmsSelectActivity.this.showProgressDialog("提交中...");
            CriminalSmsSelectActivity.this.mPresenter.confirm(CriminalSmsSelectActivity.this.mCriminalSmsBean, CriminalSmsSelectActivity.this.mLocalMedia);
        }
    }

    private void checkPermission() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.A, util.permissionutil.a.z}, new b());
    }

    private void initRecycle() {
        this.mRecyclerview.setLayoutManager(new GridLayoutManager(this.mActivity, 3));
        this.mAdapter = new SmsPictureAdapter(R.layout.recyclerview_feedback, this.mLocalMedia, this.mMaxSelectNum, this.mOnlyShow);
        this.mAdapter.a(this.mRecyclerview);
        this.mAdapter.setOnItemClickListener(new SmsPictureAdapter.b() { // from class: ui.activity.c0
            @Override // adapter.SmsPictureAdapter.b
            public final void onItemClickListener(int i2, List list) {
                this.f19409a.onItemClickListener(i2, list);
            }
        });
        this.mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.i() { // from class: ui.activity.v1
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.f19482a.onItemChildClick(baseQuickAdapter, view, i2);
            }
        });
        this.mRecyclerview.setAdapter(this.mAdapter);
    }

    private void onlyShow() {
        this.mEtVictimPhone.setEnabled(false);
        this.mEtPhone.setEnabled(false);
        this.mTvDescribe.setEnabled(false);
        this.mTvTime.setCompoundDrawables(null, null, null, null);
        this.mTvTime.setEnabled(false);
        this.mRbYes.setEnabled(false);
        this.mRbNo.setEnabled(false);
        if (this.mLocalMedia.size() <= 0) {
            this.mLlPicture.setVisibility(8);
        }
        this.mBtnCommit.setVisibility(8);
    }

    public void confirm() {
        String string = this.mEtPhone.getText().toString();
        String string2 = this.mTvDescribe.getText().toString();
        if (this.mEtVictimPhone.length() == 0) {
            util.w1.a("请输入接收短信号码");
            return;
        }
        if (TextUtils.isEmpty(string)) {
            util.w1.a("请输入涉诈短信号码");
            return;
        }
        if (this.mTvTime.length() == 0) {
            util.w1.a("请选择涉诈短信接收时间");
            return;
        }
        if (TextUtils.isEmpty(string2)) {
            util.w1.a("请输入涉诈短信内容");
            return;
        }
        if (this.mCriminalSmsBean == null) {
            this.mCriminalSmsBean = new CriminalSmsBean();
        }
        this.mCriminalSmsBean.setCaseInfoID(this.mCaseInfoId);
        this.mCriminalSmsBean.setVictimMobile(this.mEtVictimPhone.getText().toString());
        this.mCriminalSmsBean.setSuspectMobile(string);
        this.mCriminalSmsBean.setDeliveryTime(this.mTvTime.getText().toString());
        this.mCriminalSmsBean.setContent(string2);
        this.mCriminalSmsBean.setVictimMobile(this.mEtVictimPhone.getText().toString());
        this.mCriminalSmsBean.setDeliveryTime(this.mTvTime.getText().toString());
        this.mCriminalSmsBean.setIsInput(2);
        List<CriminalSmsBean> list = this.mList;
        if (list == null) {
            this.mList = new ArrayList();
            this.mList.add(this.mCriminalSmsBean);
        } else if (this.mPosition < 0) {
            list.add(this.mCriminalSmsBean);
        }
        if (this.mRbYes.isChecked()) {
            this.mCriminalSmsBean.setSmsType(2);
            this.mCriminalSmsBean.setSmsTypeText("彩信");
        } else {
            this.mCriminalSmsBean.setSmsType(1);
            this.mCriminalSmsBean.setSmsTypeText("短信");
        }
        if (this.mList.size() == 0) {
            util.w1.a("还没有填写信息");
        } else if (TextUtils.equals(string, AccountManager.getVisiblePhone())) {
            util.b1.a(this.mActivity, "添加的涉诈短信中包含您的登录号码，确定添加个人发送短信为涉诈短信？", "", "取消", "确定", R.color._A8B4F7, R.color.blue, true, (IClickListener) new c());
        } else {
            showProgressDialog("提交中...");
            this.mPresenter.confirm(this.mCriminalSmsBean, this.mLocalMedia);
        }
    }

    public void deleteDoubleElement(List<LocalMedia> list, List<LocalMedia> list2, LocalMedia localMedia) {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (list2 == null || (list2.size() <= 0 && localMedia != null)) {
            list2 = new ArrayList<>();
            list2.add(localMedia);
        }
        Iterator<LocalMedia> it = list2.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            LocalMedia next = it.next();
            if (list.size() > 0) {
                for (LocalMedia localMedia2 : list) {
                    if (!next.getPath().equals(localMedia2.getPath())) {
                        if (Build.VERSION.SDK_INT > 28) {
                            try {
                                String path = localMedia2.getPath();
                                String path2 = next.getPath();
                                if (util.o1.a(new File(path)).equals(util.o1.a(new File(path2)))) {
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    z = true;
                }
                if (!z) {
                    next.setChecked(true);
                    list.add(next);
                }
            } else {
                next.setChecked(true);
                list.add(next);
            }
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            LocalMedia localMedia3 = list.get(i2);
            if (localMedia3.isChecked()) {
                localMedia3.setChecked(false);
            }
        }
    }

    @Override // ui.activity.BaseActivity
    public void initPage() throws Throwable {
        this.mTvTitle.setText("涉诈短信详情");
        this.mPresenter = new CriminalSmsAddPresenter(this.mActivity, this);
        try {
            this.mCaseInfoId = getIntent().getStringExtra(util.k1.C0);
            this.mOnlyShow = getIntent().getBooleanExtra(util.k1.f20846d, false);
            this.mList = (List) getIntent().getSerializableExtra(util.k1.f20845c);
            this.mPosition = getIntent().getIntExtra(util.k1.f20847e, -1);
            SmsBean smsBean = (SmsBean) getIntent().getSerializableExtra(util.k1.f20844b);
            if (this.mList != null && this.mPosition >= 0 && this.mPosition < this.mList.size()) {
                this.mCriminalSmsBean = this.mList.get(this.mPosition);
            } else if (smsBean != null) {
                this.mCriminalSmsBean = new CriminalSmsBean();
                this.mCriminalSmsBean.setVictimMobile(smsBean.getVictimTel());
                this.mCriminalSmsBean.setSuspectMobile(smsBean.getSmsNum());
                this.mCriminalSmsBean.setContent(smsBean.getSmsContent());
                this.mCriminalSmsBean.setDeliveryTime(smsBean.getStringDate().substring(0, r3.length() - 3));
                this.mCriminalSmsBean.setIsInput(2);
                this.mCriminalSmsBean.setIndex(smsBean.getIndex());
                if (!TextUtils.isEmpty(smsBean.getFileUri())) {
                    this.mCriminalSmsBean.setSmsType(2);
                    this.mCriminalSmsBean.setSmsTypeText("彩信");
                    util.n1.b("tempPath", "彩信==>" + util.f1.a(this.mActivity, smsBean.getFileUri()));
                    String strA = SmsRecordSelectActivity.a(this.mActivity, smsBean.getFileUri(), smsBean.getType());
                    smsBean.setSmsFilePath(strA);
                    LocalMedia localMedia = new LocalMedia();
                    localMedia.setPath(strA);
                    this.mLocalMedia.add(localMedia);
                    this.mRbYes.setChecked(true);
                    this.mRbNo.setChecked(false);
                    this.mRbNo.setEnabled(false);
                }
            }
            if (this.mCriminalSmsBean != null) {
                if (this.mCriminalSmsBean.getIsInput() == 2) {
                    this.mEtPhone.setEnabled(false);
                    this.mTvTime.setEnabled(false);
                    this.mTvTime.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.mTvDescribe.setEnabled(false);
                    this.mEtPhone.setTextColor(getResources().getColor(R.color.colorGray));
                    this.mTvTime.setTextColor(getResources().getColor(R.color.colorGray));
                    this.mTvDescribe.setTextColor(getResources().getColor(R.color.colorGray));
                }
                String victimMobile = this.mCriminalSmsBean.getVictimMobile();
                String suspectMobile = this.mCriminalSmsBean.getSuspectMobile();
                String deliveryTime = this.mCriminalSmsBean.getDeliveryTime();
                String content = this.mCriminalSmsBean.getContent();
                if (!TextUtils.isEmpty(victimMobile)) {
                    this.mEtVictimPhone.setText(victimMobile);
                }
                if (!TextUtils.isEmpty(suspectMobile)) {
                    this.mEtPhone.setText(suspectMobile);
                }
                if (!TextUtils.isEmpty(deliveryTime)) {
                    this.mTvTime.setText(deliveryTime);
                }
                if (!TextUtils.isEmpty(content)) {
                    this.mTvDescribe.setText(content);
                }
                List<SmsPictureBean> smsDetails = this.mCriminalSmsBean.getSmsDetails();
                if (smsDetails != null && smsDetails.size() > 0) {
                    for (int i2 = 0; i2 < smsDetails.size(); i2++) {
                        SmsPictureBean smsPictureBean = smsDetails.get(i2);
                        LocalMedia localMedia2 = new LocalMedia();
                        localMedia2.setPath(smsPictureBean.getLocalPath());
                        localMedia2.setCompressPath(smsPictureBean.getFilePath());
                        localMedia2.setOriginalPath(smsPictureBean.getSmsDetailID());
                        this.mLocalMedia.add(localMedia2);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.mCriminalSmsBean == null) {
            this.mCriminalSmsBean = new CriminalSmsBean();
        }
        initRecycle();
        a aVar = new a();
        this.mRbYes.setOnCheckedChangeListener(aVar);
        this.mRbNo.setOnCheckedChangeListener(aVar);
        if (this.mCriminalSmsBean.getSmsType() == 2) {
            this.mRbYes.setChecked(true);
        } else {
            this.mRbNo.setChecked(true);
        }
        if (this.mOnlyShow) {
            onlyShow();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) throws IllegalArgumentException {
        List<LocalMedia> listObtainMultipleResult;
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1 || i2 != 188 || (listObtainMultipleResult = PictureSelector.obtainMultipleResult(intent)) == null || listObtainMultipleResult.size() <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT > 28) {
            changePath(listObtainMultipleResult);
        }
        deleteDoubleElement(this.mLocalMedia, listObtainMultipleResult, null);
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        List<SmsPictureBean> smsDetails;
        if (view.getId() != R.id.iv_clear) {
            return;
        }
        CriminalSmsBean criminalSmsBean = this.mCriminalSmsBean;
        if (criminalSmsBean != null && (smsDetails = criminalSmsBean.getSmsDetails()) != null && smsDetails.size() > 0 && smsDetails.size() > i2) {
            smsDetails.remove(i2);
        }
        this.mLocalMedia.remove(i2);
        baseQuickAdapter.notifyDataSetChanged();
    }

    @Override // adapter.SmsPictureAdapter.b
    public void onItemClickListener(int i2, List<LocalMedia> list) {
        if (isDouble()) {
            return;
        }
        ArrayList<? extends Parcelable> arrayList = (ArrayList) list;
        if (i2 == arrayList.size()) {
            checkPermission();
            return;
        }
        String path = ((LocalMedia) arrayList.get(i2)).getPath();
        Intent intent = new Intent(this, (Class<?>) PreviewPictureActivity.class);
        intent.putParcelableArrayListExtra(PreviewPictureActivity.f18539f, arrayList);
        intent.putExtra(PreviewPictureActivity.f18540g, i2);
        intent.putExtra(PreviewPictureActivity.f18541h, arrayList.size());
        intent.putExtra(PreviewPictureActivity.f18542i, path);
        startActivityForResult(intent, 1000);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        hideProgressDialog();
    }

    @Override // ui.callview.CriminalSmsAddCallView
    public void onSuccessBrand(List<BrandBean> list, i.b<BrandBean> bVar) {
    }

    @OnClick({R.id.iv_back, R.id.tv_time, R.id.confirm})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.confirm) {
            confirm();
        } else if (id == R.id.iv_back) {
            onBackPressed();
        } else {
            if (id != R.id.tv_time) {
                return;
            }
            util.s1.a(this.mActivity, this.mTvTime);
        }
    }

    @Override // ui.callview.CriminalSmsAddCallView
    public void onfail() {
        hideProgressDialog();
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_criminal_sms_select;
    }
}
