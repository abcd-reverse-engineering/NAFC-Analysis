package ui.activity;

import adapter.CiminalSocialAdapter;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.CriminalSocialBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import ui.callview.CriminalSocialCallView;
import ui.presenter.CriminalSocinalPresenter;

/* loaded from: classes2.dex */
public class CriminalSocialActivity extends BaseActivity implements CriminalSocialCallView, BaseQuickAdapter.i {
    private CiminalSocialAdapter mAdapter;

    @BindView(R.id.btn_commit)
    Button mBtnCommit;

    @BindView(R.id.inc_complete)
    LinearLayout mIncComplete;

    @BindView(R.id.ll_select)
    LinearLayout mLlSelect;
    private CriminalSocinalPresenter mPresenter;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.tv_commit_tip)
    TextView mTvCommit;

    @BindView(R.id.tv_select_tip)
    TextView mTvSelectTip;

    @BindView(R.id.tv_tip)
    TextView mTvTip;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private String mCaseInfoId = "";
    private List<CriminalSocialBean> mSocialList = new ArrayList();
    private boolean mOnlyShow = false;

    class a implements BaseQuickAdapter.k {
        a() {
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.k
        public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
            Intent intent = new Intent(CriminalSocialActivity.this.mActivity, (Class<?>) CriminalSocialEditActivity.class);
            intent.putExtra(util.k1.C0, CriminalSocialActivity.this.mCaseInfoId);
            if (i2 != -1) {
                intent.putExtra(util.k1.v, i2);
                intent.putExtra(util.k1.w, (Serializable) CriminalSocialActivity.this.mSocialList.get(i2));
            }
            intent.putExtra(util.k1.f20846d, CriminalSocialActivity.this.mOnlyShow);
            CriminalSocialActivity.this.startActivity(intent);
        }
    }

    private void forceActivity(int i2) {
        Intent intent = new Intent(this.mActivity, (Class<?>) CriminalSocialEditActivity.class);
        intent.putExtra(util.k1.C0, this.mCaseInfoId);
        if (i2 != -1) {
            intent.putExtra(util.k1.v, i2);
            intent.putExtra(util.k1.w, this.mSocialList.get(i2));
        }
        startActivity(intent);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        int i2;
        this.mTvTitle.setText("添加互联网账号");
        this.mTvSelectTip.setText("添加");
        this.mTvCommit.setText("最多可添加20个涉诈社交账号");
        this.mBtnCommit.setText("确定");
        this.mCaseInfoId = getIntent().getStringExtra(util.k1.C0);
        this.mOnlyShow = getIntent().getBooleanExtra(util.k1.f20846d, false);
        this.mPresenter = new CriminalSocinalPresenter(this.mActivity, this);
        if (this.mOnlyShow) {
            i2 = R.layout.item_criminal_social_show;
            this.mTvTitle.setText("互联网账号");
            this.mLlSelect.setVisibility(8);
            this.mIncComplete.setVisibility(8);
            this.mTvTip.setVisibility(8);
        } else {
            i2 = R.layout.item_criminal_social;
        }
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter = new CiminalSocialAdapter(i2, this.mSocialList);
        this.mAdapter.a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.mAdapter);
        if (this.mOnlyShow) {
            this.mAdapter.setOnItemClickListener(new a());
        } else {
            this.mAdapter.setOnItemChildClickListener(this);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        int id = view.getId();
        if (id == R.id.iv_delete) {
            this.mPresenter.socialDeleteHttp(this.mCaseInfoId, this.mSocialList.get(i2).getNetAccountInfoID(), i2);
        } else {
            if (id != R.id.iv_edit) {
                return;
            }
            forceActivity(i2);
        }
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mPresenter.socialHttp(this.mCaseInfoId);
    }

    @Override // ui.callview.CriminalSocialCallView
    public void onSuccess(List<CriminalSocialBean> list) {
        if (this.mActivity.isFinishing()) {
            return;
        }
        this.mSocialList.clear();
        this.mSocialList.addAll(list);
        CiminalSocialAdapter ciminalSocialAdapter = this.mAdapter;
        if (ciminalSocialAdapter != null) {
            ciminalSocialAdapter.notifyDataSetChanged();
        }
    }

    @Override // ui.callview.CriminalSocialCallView
    public void onSuccessDelete(int i2) {
        if (this.mActivity.isFinishing()) {
            return;
        }
        this.mSocialList.remove(i2);
        CiminalSocialAdapter ciminalSocialAdapter = this.mAdapter;
        if (ciminalSocialAdapter != null) {
            ciminalSocialAdapter.notifyDataSetChanged();
        }
    }

    @OnClick({R.id.iv_back, R.id.ll_select, R.id.btn_commit})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.btn_commit) {
            finish();
            return;
        }
        if (id == R.id.iv_back) {
            finish();
        } else {
            if (id != R.id.ll_select) {
                return;
            }
            if (this.mSocialList.size() >= 20) {
                util.w1.a("最多可添加20个涉诈社交账号");
            } else {
                forceActivity(-1);
            }
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_criminal_social;
    }
}
