package ui.activity;

import adapter.CommitSmsAdapter;
import adapter.CriminalSmsAdapter;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.CriminalSmsBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import interfaces.PermissionsListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import manager.LoginManager;
import org.greenrobot.eventbus.ThreadMode;
import ui.Hicore;
import ui.callview.CriminalSmsCallView;
import ui.presenter.CriminalSmsPresenter;

/* loaded from: classes2.dex */
public class CriminalSmsActivity extends BaseActivity implements CriminalSmsCallView, BaseQuickAdapter.i {
    private CriminalSmsAdapter mAdapter;

    @BindView(R.id.btn_commit)
    Button mBtnCommit;
    private String mCaseInfoId;

    @BindView(R.id.inc_complete)
    LinearLayout mIncComplete;

    @BindView(R.id.inc_input)
    LinearLayout mIncInput;
    private CriminalSmsPresenter mPresenter;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    private CommitSmsAdapter mShowAdapter;

    @BindView(R.id.tv_commit_tip)
    TextView mTvCommitTip;

    @BindView(R.id.tv_input_tip)
    TextView mTvInputTip;

    @BindView(R.id.tv_select_tip)
    TextView mTvSelectTip;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private List<CriminalSmsBean> mSmsList = new ArrayList();
    private int mMaxSelectNum = 20;
    private String mEndStr = "条涉诈短信";
    private String mSelectWarnStartStr = "最多可添加";
    private boolean mOnlyShow = false;

    class a implements BaseQuickAdapter.k {
        a() {
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.k
        public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
            Intent intent = new Intent(CriminalSmsActivity.this, (Class<?>) (((CriminalSmsBean) CriminalSmsActivity.this.mSmsList.get(i2)).getIsInput() == 2 ? CriminalSmsSelectActivity.class : CriminalSmsAddActivity.class));
            intent.putExtra(util.k1.f20845c, (Serializable) CriminalSmsActivity.this.mSmsList);
            intent.putExtra(util.k1.f20847e, i2);
            intent.putExtra(util.k1.C0, CriminalSmsActivity.this.mCaseInfoId);
            intent.putExtra(util.k1.f20846d, true);
            CriminalSmsActivity.this.startActivity(intent);
        }
    }

    class b implements PermissionsListener {
        b() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(CriminalSmsActivity.this.mActivity, list, z, false, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            Intent intent = new Intent(CriminalSmsActivity.this, (Class<?>) SmsRecordSelectActivity.class);
            intent.putExtra(SmsRecordSelectActivity.f19028h, 1);
            intent.putExtra("extra_select_can", 1);
            intent.putExtra(SmsRecordSelectActivity.f19031k, SmsRecordSelectActivity.f19032l);
            CriminalSmsActivity.this.startActivity(intent);
        }
    }

    private void checkPermission() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.w, util.permissionutil.a.v, util.permissionutil.a.A, util.permissionutil.a.z}, new b());
    }

    private CriminalSmsAdapter initRecycler(RecyclerView recyclerView) {
        this.mIncInput.setVisibility(0);
        this.mIncComplete.setVisibility(0);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        CriminalSmsAdapter criminalSmsAdapter = new CriminalSmsAdapter(this.mSmsList);
        criminalSmsAdapter.a(recyclerView);
        recyclerView.setAdapter(criminalSmsAdapter);
        criminalSmsAdapter.setOnItemChildClickListener(this);
        return criminalSmsAdapter;
    }

    private CommitSmsAdapter showInitRecycler(RecyclerView recyclerView) {
        this.mIncInput.setVisibility(8);
        this.mIncComplete.setVisibility(8);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        CommitSmsAdapter commitSmsAdapter = new CommitSmsAdapter(this.mSmsList);
        commitSmsAdapter.a(recyclerView);
        recyclerView.setAdapter(commitSmsAdapter);
        commitSmsAdapter.setOnItemClickListener(new a());
        return commitSmsAdapter;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        org.greenrobot.eventbus.c.f().e(this);
        this.mTvTitle.setText("添加涉诈短信");
        this.mTvSelectTip.setText("选择短信");
        this.mTvSelectTip.setTextColor(Color.parseColor("#2D4AEB"));
        this.mTvInputTip.setText("手动输入");
        this.mTvInputTip.setTextColor(Color.parseColor("#2D4AEB"));
        this.mTvCommitTip.setText(this.mSelectWarnStartStr + this.mMaxSelectNum + this.mEndStr);
        this.mCaseInfoId = getIntent().getStringExtra(util.k1.C0);
        this.mOnlyShow = getIntent().getBooleanExtra(util.k1.f20846d, false);
        this.mPresenter = new CriminalSmsPresenter(this.mActivity, this);
        if (!this.mOnlyShow) {
            this.mAdapter = initRecycler(this.mRecyclerview);
        } else {
            this.mTvTitle.setText("涉诈短信");
            this.mShowAdapter = showInitRecycler(this.mRecyclerview);
        }
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEvent(util.c2.a aVar) {
        if (aVar == null || aVar.a() != 302) {
            return;
        }
        org.greenrobot.eventbus.c.f().f(aVar);
        List list = (List) aVar.b();
        if (list == null || list.size() <= 0) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) CriminalSmsSelectActivity.class);
        intent.putExtra(util.k1.f20845c, (Serializable) this.mSmsList);
        intent.putExtra(util.k1.f20844b, (Serializable) list.get(0));
        intent.putExtra(util.k1.C0, this.mCaseInfoId);
        startActivity(intent);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.iv_clear) {
            CriminalSmsBean criminalSmsBean = this.mSmsList.get(i2);
            criminalSmsBean.setCaseInfoID(this.mCaseInfoId);
            this.mPresenter.deleteHttp(criminalSmsBean, i2);
        } else {
            if (id != R.id.iv_edit) {
                return;
            }
            Intent intent = new Intent(this, (Class<?>) (this.mSmsList.get(i2).getIsInput() == 2 ? CriminalSmsSelectActivity.class : CriminalSmsAddActivity.class));
            intent.putExtra(util.k1.f20845c, (Serializable) this.mSmsList);
            intent.putExtra(util.k1.f20847e, i2);
            intent.putExtra(util.k1.C0, this.mCaseInfoId);
            intent.putExtra(util.k1.f20846d, this.mOnlyShow);
            startActivity(intent);
        }
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mPresenter.http(this.mCaseInfoId);
    }

    @Override // ui.callview.CriminalSmsCallView
    public void onSuccess(List<CriminalSmsBean> list) {
        if (list != null) {
            this.mSmsList.clear();
            this.mSmsList.addAll(list);
            if (this.mOnlyShow) {
                this.mShowAdapter.notifyDataSetChanged();
            } else {
                this.mAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override // ui.callview.CriminalSmsCallView
    public void onSuccessDelete(int i2) {
        this.mSmsList.remove(i2);
        CriminalSmsAdapter criminalSmsAdapter = this.mAdapter;
        if (criminalSmsAdapter != null) {
            criminalSmsAdapter.notifyDataSetChanged();
        }
    }

    @OnClick({R.id.iv_back, R.id.ll_select, R.id.ll_input, R.id.btn_commit})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.btn_commit /* 2131296395 */:
                if (!LoginManager.getInstance().isLogOut()) {
                    finish();
                    break;
                }
                break;
            case R.id.iv_back /* 2131296762 */:
                onBackPressed();
                break;
            case R.id.ll_input /* 2131296950 */:
                if (!rejuctOperation()) {
                    Intent intent = new Intent(this, (Class<?>) CriminalSmsAddActivity.class);
                    intent.putExtra(util.k1.f20845c, (Serializable) this.mSmsList);
                    intent.putExtra(util.k1.C0, this.mCaseInfoId);
                    startActivity(intent);
                    break;
                }
                break;
            case R.id.ll_select /* 2131296984 */:
                if (!rejuctOperation()) {
                    checkPermission();
                    break;
                }
                break;
        }
    }

    public boolean rejuctOperation() {
        List<CriminalSmsBean> list = this.mSmsList;
        if (list == null || list.size() != this.mMaxSelectNum) {
            return false;
        }
        util.w1.a(this.mSelectWarnStartStr + this.mMaxSelectNum + this.mEndStr);
        return true;
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_criminal_sms;
    }
}
