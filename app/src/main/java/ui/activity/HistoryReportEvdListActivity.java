package ui.activity;

import adapter.HistoryReportEvdAdapter;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import interfaces.IOneClickListener;
import java.util.ArrayList;
import java.util.List;
import network.HistoryListInfo;
import ui.callview.HistoryReportEvdCallView;
import ui.presenter.HistoryReportEvdPresenter;
import ui.view.swip.SwipBackLayout;

/* loaded from: classes2.dex */
public class HistoryReportEvdListActivity extends BaseActivity implements HistoryReportEvdCallView, HistoryReportEvdAdapter.b {
    private HistoryReportEvdAdapter mAdapter;

    @BindView(R.id.iv_right)
    ImageView mIvRight;
    private HistoryReportEvdPresenter mPresenter;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.swipe_refresh)
    SmartRefreshLayout mRefreshLayout;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private List<HistoryListInfo.RowsBean> mList = new ArrayList();
    boolean isLoadmore = false;
    public int pageIndex = 1;
    public int pageSize = 10;

    private void initListener() {
        this.mRefreshLayout.a((com.scwang.smartrefresh.layout.b.g) new ClassicsHeader(this));
        this.mRefreshLayout.a((com.scwang.smartrefresh.layout.b.f) new ClassicsFooter(this));
        this.mRefreshLayout.a(new com.scwang.smartrefresh.layout.d.d() { // from class: ui.activity.x
            @Override // com.scwang.smartrefresh.layout.d.d
            public final void a(com.scwang.smartrefresh.layout.b.j jVar) {
                this.f19486a.a(jVar);
            }
        });
        this.mRefreshLayout.a(new com.scwang.smartrefresh.layout.d.b() { // from class: ui.activity.w
            @Override // com.scwang.smartrefresh.layout.d.b
            public final void b(com.scwang.smartrefresh.layout.b.j jVar) {
                this.f19483a.b(jVar);
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
        this.mTvTitle.setText("举报记录");
        this.mIvRight.setBackgroundResource(R.mipmap.ic_help_blue);
        this.mPresenter = new HistoryReportEvdPresenter(this, this);
        initListener();
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.mAdapter = new HistoryReportEvdAdapter(this.mList);
        this.mAdapter.setOnItemClickListener(this);
        this.mAdapter.a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.mAdapter);
        this.mRefreshLayout.e();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.g();
            this.mRefreshLayout.b();
        }
    }

    @Override // adapter.HistoryReportEvdAdapter.b
    public void onItemClickListener(HistoryListInfo.RowsBean rowsBean) {
        Intent intent = new Intent(this.mActivity, (Class<?>) HistoryDetailActivity.class);
        intent.putExtra(util.k1.B, rowsBean);
        startActivity(intent);
    }

    @Override // ui.callview.HistoryReportEvdCallView
    public void onSuccessRequest(HistoryListInfo historyListInfo) {
        this.mRefreshLayout.g();
        this.mRefreshLayout.b();
        if (historyListInfo != null) {
            List<HistoryListInfo.RowsBean> rows = historyListInfo.getRows();
            if (rows != null && rows.size() > 0) {
                if (this.isLoadmore) {
                    this.mAdapter.c().addAll(rows);
                    this.mAdapter.notifyDataSetChanged();
                } else {
                    this.mAdapter.a(rows);
                    this.mRefreshLayout.s(true);
                }
                if (rows.size() < this.pageSize || rows.size() > this.pageSize) {
                    this.mRefreshLayout.s(false);
                } else {
                    this.mRefreshLayout.s(true);
                }
            } else if (this.isLoadmore) {
                this.mRefreshLayout.s(false);
            }
        }
        this.isLoadmore = false;
    }

    @OnClick({R.id.iv_back, R.id.iv_right})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.iv_back) {
            finish();
        } else {
            if (id != R.id.iv_right) {
                return;
            }
            util.b1.a(this, 0, "110", getString(R.string.report_time_tips), "", "我知道了", (IOneClickListener) null);
        }
    }

    @Override // ui.callview.HistoryReportEvdCallView
    public void onfailRequest() {
        this.isLoadmore = false;
        this.mRefreshLayout.g();
        this.mRefreshLayout.b();
    }

    public void pullToLoadMore() {
        if (this.mRefreshLayout == null || this.mPresenter == null) {
            return;
        }
        this.isLoadmore = true;
        int size = this.mList.size();
        int i2 = this.pageSize;
        this.pageIndex = (size / i2) + 1;
        this.mPresenter.getReportList(this.pageIndex, i2);
    }

    public void pullToRefresh() {
        HistoryReportEvdPresenter historyReportEvdPresenter;
        if (this.mRefreshLayout == null || (historyReportEvdPresenter = this.mPresenter) == null) {
            return;
        }
        this.pageIndex = 1;
        this.isLoadmore = false;
        historyReportEvdPresenter.getReportList(this.pageIndex, this.pageSize);
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_history_report;
    }
}
