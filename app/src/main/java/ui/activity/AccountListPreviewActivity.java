package ui.activity;

import adapter.AccountAdapter;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.AccountListBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import java.util.ArrayList;
import java.util.List;
import ui.callview.AccountListCallView;
import ui.presenter.AccountListPresenter;
import ui.view.swip.SwipBackLayout;

/* loaded from: classes2.dex */
public class AccountListPreviewActivity extends BaseActivity implements AccountListCallView, BaseQuickAdapter.k {

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private String mCaseInfoId = "";
    private AccountListPresenter mPresenter = null;
    private List<AccountListBean> mList = new ArrayList();
    private AccountAdapter mAdapter = null;

    private void initView() {
        this.mCaseInfoId = getIntent().getStringExtra(util.k1.C0);
        this.mPresenter = new AccountListPresenter(this, this);
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter = new AccountAdapter(R.layout.item_account_preview, this.mList);
        this.mAdapter.setOnItemClickListener(this);
        this.mRecyclerview.setAdapter(this.mAdapter);
    }

    private void intentChild(AccountListBean accountListBean) {
        Intent intent = new Intent(this, (Class<?>) AccountPreviewActivity.class);
        if (accountListBean != null) {
            intent.putExtra(util.k1.f20845c, accountListBean);
        }
        intent.putExtra(util.k1.C0, this.mCaseInfoId);
        startActivityForResult(intent, 1);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this).a();
        this.mTvTitle.setText("涉案账户");
        initView();
        this.mPresenter.getPayment(this.mCaseInfoId);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            this.mPresenter.getPayment(this.mCaseInfoId);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // ui.callview.AccountListCallView
    public void onDeleteSuccess(AccountListBean accountListBean) {
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.k
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (isDouble()) {
            return;
        }
        intentChild(this.mList.get(i2));
    }

    @Override // ui.callview.AccountListCallView
    public void onSuccess(List<AccountListBean> list) {
        this.mList.clear();
        if (list.size() > 0) {
            this.mList.addAll(list);
        }
        this.mAdapter.notifyDataSetChanged();
    }

    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        if (!isDouble() && view.getId() == R.id.iv_back) {
            onBackPressed();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_account_list_preview;
    }
}
