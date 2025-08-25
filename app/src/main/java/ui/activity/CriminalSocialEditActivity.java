package ui.activity;

import adapter.SmsPictureAdapter;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.CriminalSocialBean;
import bean.CriminalSocialFileBean;
import bean.CriminalSocialTypeBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;
import interfaces.PermissionsListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ui.callview.CriminalSocialEditCallView;
import ui.presenter.CriminalSocialEditPresenter;
import util.y1;

/* loaded from: classes2.dex */
public class CriminalSocialEditActivity extends BaseActivity implements CriminalSocialEditCallView, SmsPictureAdapter.b, BaseQuickAdapter.i {
    private SmsPictureAdapter mAdapter;
    private CriminalSocialBean mBean;

    @BindView(R.id.btn_commit)
    Button mBtnCommit;

    @BindView(R.id.et_account)
    EditText mEtAccount;

    @BindView(R.id.et_account_other)
    EditText mEtAccountOther;

    @BindView(R.id.et_tag_other)
    EditText mEtTagOther;

    @BindView(R.id.flow_layout)
    TagFlowLayout mFlowLayout;

    @BindView(R.id.v_flow_uncheck)
    View mFlowUncheck;

    @BindView(R.id.ll_acc_nomar)
    View mLlAccNorm;

    @BindView(R.id.ll_acc_other)
    View mLlAccOther;

    @BindView(R.id.ll_picture)
    LinearLayout mLlPicture;
    private CriminalSocialEditPresenter mPresenter;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.tv_account_label)
    TextView mTvAccountLabel;

    @BindView(R.id.tv_account_other_label)
    TextView mTvAccountOtherLabel;

    @BindView(R.id.tv_tag_other_label)
    TextView mTvTagOtherLabel;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private int pos;
    private com.zhy.view.flowlayout.b mTagAdapter = null;
    private CriminalSocialTypeBean mTypeBean = new CriminalSocialTypeBean();
    private List<CriminalSocialTypeBean> mTypeList = new ArrayList();
    private String mCaseInfoId = "";
    private int mMaxSelectNum = 6;
    private List<LocalMedia> mLocalMedia = new ArrayList();
    private boolean mOnlyShow = false;

    class a extends com.zhy.view.flowlayout.b<CriminalSocialTypeBean> {
        a(List list) {
            super(list);
        }

        @Override // com.zhy.view.flowlayout.b
        public View a(FlowLayout flowLayout, int i2, CriminalSocialTypeBean criminalSocialTypeBean) {
            TextView textView = (TextView) LayoutInflater.from(CriminalSocialEditActivity.this.mActivity).inflate(R.layout.tag_flow, (ViewGroup) CriminalSocialEditActivity.this.mFlowLayout, false);
            textView.setText(((CriminalSocialTypeBean) CriminalSocialEditActivity.this.mTypeList.get(i2)).getPlatformText());
            textView.setTextColor(CriminalSocialEditActivity.this.getResources().getColorStateList(R.color.text_choose_one));
            return textView;
        }
    }

    class b implements PermissionsListener {
        b() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(CriminalSocialEditActivity.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            j.e.a(CriminalSocialEditActivity.this.mActivity, 200L, PictureMimeType.ofImage(), CriminalSocialEditActivity.this.mMaxSelectNum - CriminalSocialEditActivity.this.mLocalMedia.size()).forResult(PictureConfig.CHOOSE_REQUEST);
        }
    }

    private void change(CriminalSocialTypeBean criminalSocialTypeBean, CriminalSocialBean criminalSocialBean) {
        int ex = criminalSocialTypeBean.getEx();
        if (ex == 1) {
            this.mLlAccOther.setVisibility(0);
            this.mLlAccNorm.setVisibility(8);
            this.mTvTagOtherLabel.setText("平台名称");
            this.mEtTagOther.setHint("请输入平台名称");
            this.mTvAccountOtherLabel.setText("平台账号");
            this.mEtAccountOther.setHint("请输入平台账号");
            if (criminalSocialBean != null) {
                this.mEtTagOther.setText(criminalSocialBean.getPlatformText());
                this.mEtAccountOther.setText(criminalSocialBean.getSuspectAccount());
                return;
            }
            return;
        }
        if (ex == 2) {
            this.mLlAccOther.setVisibility(0);
            this.mLlAccNorm.setVisibility(8);
            this.mTvTagOtherLabel.setText("公众号/服务号名称");
            this.mEtTagOther.setHint("请输入公众号/服务号名称");
            this.mTvAccountOtherLabel.setText("公众号/服务号账号");
            this.mEtAccountOther.setHint("请输入公众号/服务号账号");
            if (criminalSocialBean != null) {
                this.mEtTagOther.setText(criminalSocialBean.getPlatformText());
                this.mEtAccountOther.setText(criminalSocialBean.getSuspectAccount());
                return;
            }
            return;
        }
        this.mLlAccOther.setVisibility(8);
        this.mLlAccNorm.setVisibility(0);
        this.mTvAccountLabel.setText(criminalSocialTypeBean.getPlatformText() + "账号");
        this.mEtAccount.setHint("请输入账号");
        if (criminalSocialBean != null) {
            this.mEtAccount.setText(criminalSocialBean.getSuspectAccount());
        }
    }

    private void checkPermission() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.A, util.permissionutil.a.z}, new b());
    }

    private int contains(List<CriminalSocialTypeBean> list, String str) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (TextUtils.equals(list.get(i2).getPlatform(), str)) {
                return i2;
            }
        }
        return -10;
    }

    private String dealName(String str) {
        for (int i2 = 0; i2 < this.mTypeList.size(); i2++) {
            CriminalSocialTypeBean criminalSocialTypeBean = this.mTypeList.get(i2);
            if (str.equalsIgnoreCase(criminalSocialTypeBean.getPlatformText())) {
                String platformText = criminalSocialTypeBean.getPlatformText();
                this.mTypeBean = criminalSocialTypeBean;
                return platformText;
            }
        }
        return str;
    }

    private void getIntentData() {
        List<CriminalSocialFileBean> netAccountDetails;
        this.mCaseInfoId = getIntent().getStringExtra(util.k1.C0);
        this.pos = getIntent().getIntExtra(util.k1.v, 0);
        this.mOnlyShow = getIntent().getBooleanExtra(util.k1.f20846d, false);
        this.mBean = (CriminalSocialBean) getIntent().getSerializableExtra(util.k1.w);
        CriminalSocialBean criminalSocialBean = this.mBean;
        if (criminalSocialBean == null || (netAccountDetails = criminalSocialBean.getNetAccountDetails()) == null || netAccountDetails.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < netAccountDetails.size(); i2++) {
            CriminalSocialFileBean criminalSocialFileBean = netAccountDetails.get(i2);
            LocalMedia localMedia = new LocalMedia();
            localMedia.setPath(criminalSocialFileBean.getLocalPath());
            localMedia.setCompressPath(criminalSocialFileBean.getFilePath());
            localMedia.setOriginalPath(criminalSocialFileBean.getNetAccountDetailInfoID());
            this.mLocalMedia.add(localMedia);
        }
    }

    private void initRecycle() {
        this.mRecyclerview.setLayoutManager(new GridLayoutManager(this.mActivity, 3));
        this.mAdapter = new SmsPictureAdapter(R.layout.recyclerview_feedback, this.mLocalMedia, this.mMaxSelectNum, this.mOnlyShow);
        this.mAdapter.a(this.mRecyclerview);
        this.mAdapter.setOnItemClickListener(new SmsPictureAdapter.b() { // from class: ui.activity.t0
            @Override // adapter.SmsPictureAdapter.b
            public final void onItemClickListener(int i2, List list) {
                this.f19473a.onItemClickListener(i2, list);
            }
        });
        this.mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.i() { // from class: ui.activity.y
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                this.f19488a.onItemChildClick(baseQuickAdapter, view, i2);
            }
        });
        this.mRecyclerview.setAdapter(this.mAdapter);
    }

    public /* synthetic */ boolean a(View view, int i2, FlowLayout flowLayout) {
        CriminalSocialTypeBean criminalSocialTypeBean = this.mTypeList.get(i2);
        change(criminalSocialTypeBean, null);
        this.mTypeBean = criminalSocialTypeBean;
        return true;
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
    public void initPage() {
        this.mTvTitle.setText("添加互联网账号");
        this.mPresenter = new CriminalSocialEditPresenter(this.mActivity, this);
        getIntentData();
        if (this.mOnlyShow) {
            this.mTvTitle.setText("互联网账号详情");
            this.mBtnCommit.setVisibility(8);
            this.mEtAccount.setEnabled(false);
            this.mEtAccountOther.setEnabled(false);
            this.mEtTagOther.setEnabled(false);
            this.mFlowUncheck.setVisibility(0);
            if (this.mLocalMedia.size() <= 0) {
                this.mLlPicture.setVisibility(8);
            }
        }
        initTagAdapter();
        initRecycle();
        this.mPresenter.typeHttp();
    }

    protected void initTagAdapter() {
        this.mTagAdapter = new a(this.mTypeList);
        this.mFlowLayout.setAdapter(this.mTagAdapter);
        this.mFlowLayout.setOnTagClickListener(new TagFlowLayout.c() { // from class: ui.activity.o
            @Override // com.zhy.view.flowlayout.TagFlowLayout.c
            public final boolean a(View view, int i2, FlowLayout flowLayout) {
                return this.f19450a.a(view, i2, flowLayout);
            }
        });
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
        List<CriminalSocialFileBean> netAccountDetails;
        if (view.getId() != R.id.iv_clear) {
            return;
        }
        CriminalSocialBean criminalSocialBean = this.mBean;
        if (criminalSocialBean != null && (netAccountDetails = criminalSocialBean.getNetAccountDetails()) != null && netAccountDetails.size() > 0 && netAccountDetails.size() > i2) {
            netAccountDetails.remove(i2);
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

    @Override // ui.callview.CriminalSocialEditCallView
    public void onSuccessType(List<CriminalSocialTypeBean> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mTypeList.clear();
        this.mTypeList.addAll(list);
        this.mTagAdapter.c();
        CriminalSocialBean criminalSocialBean = this.mBean;
        if (criminalSocialBean == null) {
            CriminalSocialTypeBean criminalSocialTypeBean = list.get(0);
            this.mTypeBean = criminalSocialTypeBean;
            this.mTagAdapter.a(0);
            change(criminalSocialTypeBean, null);
            return;
        }
        int iContains = contains(list, criminalSocialBean.getPlatform());
        if (iContains >= 0) {
            CriminalSocialTypeBean criminalSocialTypeBean2 = list.get(iContains);
            this.mTypeBean = criminalSocialTypeBean2;
            change(criminalSocialTypeBean2, this.mBean);
            this.mTagAdapter.a(iContains);
            return;
        }
        int size = list.size() - 1;
        CriminalSocialTypeBean criminalSocialTypeBean3 = list.get(size);
        this.mTypeBean = criminalSocialTypeBean3;
        change(criminalSocialTypeBean3, this.mBean);
        this.mTagAdapter.a(size);
    }

    @OnClick({R.id.iv_back, R.id.btn_commit})
    public void onViewClicked(View view) {
        String string;
        String string2;
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.btn_commit) {
            if (id != R.id.iv_back) {
                return;
            }
            finish();
            return;
        }
        if (this.mTypeList.size() > 0) {
            int ex = this.mTypeBean.getEx();
            if (ex == 1) {
                string = this.mEtTagOther.getText().toString();
                if (TextUtils.isEmpty(string)) {
                    util.w1.a("请输入平台名称");
                    return;
                }
                string2 = this.mEtAccountOther.getText().toString();
                if (TextUtils.isEmpty(string2)) {
                    util.w1.a("请输入平台账号");
                    return;
                }
            } else if (ex != 2) {
                string = this.mTypeBean.getPlatformText();
                string2 = this.mEtAccount.getText().toString();
                if (TextUtils.isEmpty(string2)) {
                    util.w1.a("请输入账号");
                    return;
                }
            } else {
                string = this.mEtTagOther.getText().toString();
                if (TextUtils.isEmpty(string)) {
                    util.w1.a("请输入公众号/服务号名称");
                    return;
                }
                string2 = this.mEtAccountOther.getText().toString();
                if (TextUtils.isEmpty(string2)) {
                    util.w1.a("请输入公众号/服务号账号");
                    return;
                }
            }
            if (y1.u(string2) || string2.contains(c.c.a.b.a.a.f3100g)) {
                util.w1.a("账号不得纯文字、不得含空格");
                return;
            }
            if (this.mTypeBean.getEx() == 1 || this.mTypeBean.getEx() == 2) {
                dealName(string);
            }
            CriminalSocialBean criminalSocialBean = new CriminalSocialBean();
            criminalSocialBean.setCaseInfoId(this.mCaseInfoId);
            criminalSocialBean.setPlatformText(string);
            criminalSocialBean.setPlatform(this.mTypeBean.getPlatform());
            criminalSocialBean.setSuspectAccount(string2);
            if (this.mBean == null) {
                showProgressDialog("提交中...");
                this.mPresenter.confirm(criminalSocialBean, this.mLocalMedia);
                return;
            }
            showProgressDialog("提交中...");
            this.mBean.setCaseInfoId(this.mCaseInfoId);
            this.mBean.setPlatformText(string);
            this.mBean.setPlatform(this.mTypeBean.getPlatform());
            this.mBean.setSuspectAccount(string2);
            this.mPresenter.confirm(this.mBean, this.mLocalMedia);
        }
    }

    @Override // ui.callview.CriminalSocialEditCallView
    public void onfail() {
        hideProgressDialog();
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_criminal_social_edit;
    }
}
