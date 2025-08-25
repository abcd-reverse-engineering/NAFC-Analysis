package ui.activity;

import adapter.IDVarfyAceptListAdapter;
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
import network.http.StatisticsHttp;
import org.greenrobot.eventbus.ThreadMode;
import ui.callview.IdVartyCallView;
import ui.presenter.IDVarfyPresenter;
import ui.view.swip.SwipBackLayout;

/* loaded from: classes2.dex */
public class IDVarfyAceptListActivity extends BaseActivity implements IdVartyCallView {
    private List<VerifyAcceptBean> callBeans = new ArrayList();
    private IDVarfyAceptListAdapter mAdapter;

    @BindView(R.id.ll_nodata)
    View mLlNodata;
    private IDVarfyPresenter mPresenter;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.sm_refresh)
    SmartRefreshLayout mRefreshLayout;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    private void initListener() {
        StatisticsHttp.getInstance().pageOpenHttp(e.d.f13584b);
        this.mRefreshLayout.a((com.scwang.smartrefresh.layout.b.g) new ClassicsHeader(this));
        this.mRefreshLayout.s(false);
        this.mRefreshLayout.a(new com.scwang.smartrefresh.layout.d.d() { // from class: ui.activity.z
            @Override // com.scwang.smartrefresh.layout.d.d
            public final void a(com.scwang.smartrefresh.layout.b.j jVar) {
                this.f19490a.a(jVar);
            }
        });
    }

    public /* synthetic */ void a(com.scwang.smartrefresh.layout.b.j jVar) {
        this.mPresenter.getVerifyAcceptList();
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        org.greenrobot.eventbus.c.f().e(this);
        SwipBackLayout.a(this.mActivity).a();
        this.mTvTitle.setText("身份核实请求列表");
        this.mPresenter = new IDVarfyPresenter(this, this);
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter = new IDVarfyAceptListAdapter(this.callBeans);
        this.mAdapter.a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.mAdapter);
        initListener();
        this.mRefreshLayout.e();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventThread(util.c2.a aVar) {
        if (aVar == null || aVar.a() != 39) {
            return;
        }
        this.mPresenter.getVerifyAcceptList();
    }

    @Override // ui.callview.IdVartyCallView
    public void onSuccessAccRequest(List<VerifyAcceptBean> list) {
        this.mRefreshLayout.g();
        if (list != null) {
            if (list.size() > 0) {
                this.mAdapter.a(list);
            } else {
                this.mAdapter.G();
            }
        }
        if (this.mAdapter.c().size() > 0) {
            this.mLlNodata.setVisibility(8);
        } else {
            this.mLlNodata.setVisibility(0);
        }
    }

    @Override // ui.callview.IdVartyCallView
    public void onSuccessRequest(List<IDVarfyBean.Rows> list) {
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
        this.mAdapter.G();
        this.mLlNodata.setVisibility(0);
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_idvarify_acept_list;
    }
}
