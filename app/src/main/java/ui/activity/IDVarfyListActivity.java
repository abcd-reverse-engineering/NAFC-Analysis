package ui.activity;

import adapter.IDVarfyListAdapter;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.IDVarfyBean;
import bean.VerifyAcceptBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import java.util.ArrayList;
import java.util.List;
import ui.callview.IdVartyCallView;
import ui.presenter.IDVarfyPresenter;
import ui.view.swip.SwipBackLayout;

/* loaded from: classes2.dex */
public class IDVarfyListActivity extends BaseActivity implements IdVartyCallView {
    private IDVarfyListAdapter mAdapter;

    @BindView(R.id.ll_nodata)
    View mLlNodata;
    private IDVarfyPresenter mPresenter;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.sm_refresh)
    SmartRefreshLayout mRefreshLayout;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private List<IDVarfyBean.Rows> callBeans = new ArrayList();
    public boolean isLoadmore = false;
    public int pageIndex = 1;
    public int pageSize = 10;

    private void initListener() {
        this.mRefreshLayout.a((com.scwang.smartrefresh.layout.b.g) new ClassicsHeader(this));
        this.mRefreshLayout.s(false);
        this.mRefreshLayout.a(new com.scwang.smartrefresh.layout.d.d() { // from class: ui.activity.a0
            @Override // com.scwang.smartrefresh.layout.d.d
            public final void a(com.scwang.smartrefresh.layout.b.j jVar) {
                this.f19402a.a(jVar);
            }
        });
        this.mRefreshLayout.a(new com.scwang.smartrefresh.layout.d.b() { // from class: ui.activity.b0
            @Override // com.scwang.smartrefresh.layout.d.b
            public final void b(com.scwang.smartrefresh.layout.b.j jVar) {
                this.f19406a.b(jVar);
            }
        });
    }

    public /* synthetic */ void a(com.scwang.smartrefresh.layout.b.j jVar) {
        pullToRefresh();
    }

    public /* synthetic */ void b(com.scwang.smartrefresh.layout.b.j jVar) {
        pullToLoadMore();
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        this.mTvTitle.setText("核实记录");
        this.mPresenter = new IDVarfyPresenter(this, this);
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter = new IDVarfyListAdapter(this.callBeans);
        this.mAdapter.a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.mAdapter);
        initListener();
        this.mRefreshLayout.e();
    }

    @Override // ui.callview.IdVartyCallView
    public void onSuccessAccRequest(List<VerifyAcceptBean> list) {
    }

    @Override // ui.callview.IdVartyCallView
    public void onSuccessRequest(List<IDVarfyBean.Rows> list) {
        this.mRefreshLayout.g();
        this.mRefreshLayout.b();
        if (list != null && list.size() > 0) {
            if (this.isLoadmore) {
                this.mAdapter.c().addAll(list);
                this.mAdapter.notifyDataSetChanged();
            } else {
                this.mAdapter.a(list);
                this.mRefreshLayout.s(true);
            }
            if (list.size() >= this.pageSize && list.size() <= this.pageSize) {
                this.mRefreshLayout.s(true);
            } else {
                this.mRefreshLayout.s(false);
            }
        } else if (this.isLoadmore) {
            this.mRefreshLayout.s(false);
        }
        if (this.mAdapter.c().size() > 0) {
            this.mLlNodata.setVisibility(8);
        } else {
            this.mLlNodata.setVisibility(0);
        }
        this.isLoadmore = false;
    }

    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        if (!isDouble() && view.getId() == R.id.iv_back) {
            finish();
        }
    }

    @Override // ui.callview.IdVartyCallView
    public void onfailRequest() {
        this.mRefreshLayout.g();
    }

    public void pullToLoadMore() {
        if (this.mRefreshLayout == null || this.mPresenter == null) {
            return;
        }
        this.isLoadmore = true;
        int size = this.callBeans.size();
        int i2 = this.pageSize;
        this.pageIndex = (size / i2) + 1;
        this.mPresenter.ListPrincipalHttp(this.pageIndex, i2);
    }

    public void pullToRefresh() {
        IDVarfyPresenter iDVarfyPresenter;
        if (this.mRefreshLayout == null || (iDVarfyPresenter = this.mPresenter) == null) {
            return;
        }
        this.pageIndex = 1;
        this.isLoadmore = false;
        iDVarfyPresenter.ListPrincipalHttp(this.pageIndex, this.pageSize);
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_idvarify_list;
    }
}
