package ui.activity;

import adapter.AccountAdapter;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.AccountListBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import java.util.ArrayList;
import java.util.List;
import ui.callview.AccountListCallView;
import ui.presenter.AccountListPresenter;
import ui.view.swip.SwipBackLayout;

/* loaded from: classes2.dex */
public class AccountListActivity extends BaseActivity implements AccountListCallView, BaseQuickAdapter.i, BaseQuickAdapter.k {

    @BindView(R.id.ll_add)
    LinearLayout mLlAdd;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.tv_add)
    TextView mTvAdd;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private String mCaseInfoId = "";
    private AccountListPresenter mPresenter = null;
    private List<AccountListBean> mList = new ArrayList();
    private AccountAdapter mAdapter = null;
    private int mMaxNum = 10;

    class a implements IClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f17594a;

        a(int i2) {
            this.f17594a = i2;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            AccountListActivity.this.mPresenter.deleteAccount((AccountListBean) AccountListActivity.this.mList.get(this.f17594a));
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    private void initView() {
        this.mCaseInfoId = getIntent().getStringExtra(util.k1.C0);
        this.mPresenter = new AccountListPresenter(this, this);
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter = new AccountAdapter(R.layout.item_account, this.mList);
        this.mAdapter.setOnItemClickListener(this);
        this.mAdapter.setOnItemChildClickListener(this);
        this.mRecyclerview.setAdapter(this.mAdapter);
    }

    private void intentChild(AccountListBean accountListBean) {
        Intent intent = new Intent(this, (Class<?>) AccountActivity.class);
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
        this.mTvAdd.setText("涉案账户信息");
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
        this.mList.remove(accountListBean);
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (!isDouble() && view.getId() == R.id.iv_clear) {
            util.b1.b(this.mActivity, "删除当前账户信息？", "", "确定", "取消", new a(i2));
        }
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

    @OnClick({R.id.iv_back, R.id.ll_add})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.iv_back) {
            onBackPressed();
            return;
        }
        if (id != R.id.ll_add) {
            return;
        }
        List<AccountListBean> list = this.mList;
        if (list == null || list.size() < this.mMaxNum) {
            intentChild(null);
            return;
        }
        util.w1.a("最多添加" + this.mMaxNum + "组涉案账户");
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_account_list;
    }
}
