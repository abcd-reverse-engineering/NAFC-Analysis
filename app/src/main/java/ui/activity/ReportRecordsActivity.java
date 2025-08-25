package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.ReportCaseBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import ui.callview.ReportRecordView;
import ui.presenter.ReportRecordPresenter;
import ui.view.swip.SwipBackLayout;

/* compiled from: ReportRecordsActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010.\u001a\u00020/H\u0016J\u0006\u00100\u001a\u00020/J\u0010\u00101\u001a\u00020/2\u0006\u00102\u001a\u00020\u0011H\u0007J\u0012\u00103\u001a\u00020/2\b\u00104\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u00105\u001a\u00020/H\u0016J\b\u00106\u001a\u000207H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u00020)8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u00068"}, d2 = {"Lui/activity/ReportRecordsActivity;", "Lui/activity/BaseActivity;", "Lui/callview/ReportRecordView;", "()V", "caseBean", "Lbean/ReportCaseBean;", "getCaseBean", "()Lbean/ReportCaseBean;", "setCaseBean", "(Lbean/ReportCaseBean;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mLlNodata", "Landroid/view/View;", "getMLlNodata", "()Landroid/view/View;", "setMLlNodata", "(Landroid/view/View;)V", "mPresenter", "Lui/presenter/ReportRecordPresenter;", "getMPresenter", "()Lui/presenter/ReportRecordPresenter;", "setMPresenter", "(Lui/presenter/ReportRecordPresenter;)V", "mRefreshLayout", "Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "getMRefreshLayout", "()Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "setMRefreshLayout", "(Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;)V", "mRvList", "Landroidx/recyclerview/widget/RecyclerView;", "getMRvList", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRvList", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "initPage", "", "initView", "onClick", "view", "onSuccessRequest", "beans", "onfailRequest", "setLayoutView", "", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class ReportRecordsActivity extends BaseActivity implements ReportRecordView {

    @i.c.a.e
    private ReportCaseBean caseBean;

    @BindView(R.id.iv_back)
    @i.c.a.d
    public ImageView mIvBack;

    @BindView(R.id.ll_nodata)
    @i.c.a.d
    public View mLlNodata;

    @i.c.a.e
    private ReportRecordPresenter mPresenter;

    @BindView(R.id.swipe_refresh)
    @i.c.a.d
    public SmartRefreshLayout mRefreshLayout;

    @BindView(R.id.recyclerview)
    @i.c.a.d
    public RecyclerView mRvList;

    @BindView(R.id.tv_title)
    @i.c.a.d
    public TextView mTvTitle;

    /* compiled from: ReportRecordsActivity.kt */
    static final class a implements com.scwang.smartrefresh.layout.d.d {
        a() {
        }

        @Override // com.scwang.smartrefresh.layout.d.d
        public final void a(@i.c.a.d com.scwang.smartrefresh.layout.b.j jVar) {
            h.q2.t.i0.f(jVar, "it");
            ReportRecordPresenter mPresenter = ReportRecordsActivity.this.getMPresenter();
            if (mPresenter != null) {
                mPresenter.reportUserCases();
            }
        }
    }

    @i.c.a.e
    public final ReportCaseBean getCaseBean() {
        return this.caseBean;
    }

    @i.c.a.d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            h.q2.t.i0.k("mIvBack");
        }
        return imageView;
    }

    @i.c.a.d
    public final View getMLlNodata() {
        View view = this.mLlNodata;
        if (view == null) {
            h.q2.t.i0.k("mLlNodata");
        }
        return view;
    }

    @i.c.a.e
    public final ReportRecordPresenter getMPresenter() {
        return this.mPresenter;
    }

    @i.c.a.d
    public final SmartRefreshLayout getMRefreshLayout() {
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        if (smartRefreshLayout == null) {
            h.q2.t.i0.k("mRefreshLayout");
        }
        return smartRefreshLayout;
    }

    @i.c.a.d
    public final RecyclerView getMRvList() {
        RecyclerView recyclerView = this.mRvList;
        if (recyclerView == null) {
            h.q2.t.i0.k("mRvList");
        }
        return recyclerView;
    }

    @i.c.a.d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        return textView;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        textView.setText("报案记录");
        initView();
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        if (smartRefreshLayout == null) {
            h.q2.t.i0.k("mRefreshLayout");
        }
        smartRefreshLayout.e();
    }

    public final void initView() {
        this.mPresenter = new ReportRecordPresenter(this.mActivity, this);
        ReportRecordPresenter reportRecordPresenter = this.mPresenter;
        if (reportRecordPresenter != null) {
            RecyclerView recyclerView = this.mRvList;
            if (recyclerView == null) {
                h.q2.t.i0.k("mRvList");
            }
            reportRecordPresenter.initRecyclePeop(recyclerView);
        }
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        if (smartRefreshLayout == null) {
            h.q2.t.i0.k("mRefreshLayout");
        }
        smartRefreshLayout.a((com.scwang.smartrefresh.layout.b.g) new ClassicsHeader(this));
        SmartRefreshLayout smartRefreshLayout2 = this.mRefreshLayout;
        if (smartRefreshLayout2 == null) {
            h.q2.t.i0.k("mRefreshLayout");
        }
        smartRefreshLayout2.a((com.scwang.smartrefresh.layout.b.f) new ClassicsFooter(this));
        SmartRefreshLayout smartRefreshLayout3 = this.mRefreshLayout;
        if (smartRefreshLayout3 == null) {
            h.q2.t.i0.k("mRefreshLayout");
        }
        smartRefreshLayout3.s(false);
        SmartRefreshLayout smartRefreshLayout4 = this.mRefreshLayout;
        if (smartRefreshLayout4 == null) {
            h.q2.t.i0.k("mRefreshLayout");
        }
        smartRefreshLayout4.a((com.scwang.smartrefresh.layout.d.d) new a());
    }

    @OnClick({R.id.iv_back})
    public final void onClick(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        if (!isDouble() && view.getId() == R.id.iv_back) {
            a();
        }
    }

    @Override // ui.callview.ReportRecordView
    public void onSuccessRequest(@i.c.a.e ReportCaseBean reportCaseBean) {
        this.caseBean = reportCaseBean;
        if (reportCaseBean != null && reportCaseBean.getTotal() > 0) {
            View view = this.mLlNodata;
            if (view == null) {
                h.q2.t.i0.k("mLlNodata");
            }
            view.setVisibility(8);
        }
        ReportRecordPresenter reportRecordPresenter = this.mPresenter;
        if (reportRecordPresenter != null) {
            reportRecordPresenter.setListData(reportCaseBean != null ? reportCaseBean.getRows() : null);
        }
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        if (smartRefreshLayout == null) {
            h.q2.t.i0.k("mRefreshLayout");
        }
        smartRefreshLayout.g();
    }

    @Override // ui.callview.ReportRecordView
    public void onfailRequest() {
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        if (smartRefreshLayout == null) {
            h.q2.t.i0.k("mRefreshLayout");
        }
        smartRefreshLayout.g();
    }

    public final void setCaseBean(@i.c.a.e ReportCaseBean reportCaseBean) {
        this.caseBean = reportCaseBean;
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_report_record;
    }

    public final void setMIvBack(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMLlNodata(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "<set-?>");
        this.mLlNodata = view;
    }

    public final void setMPresenter(@i.c.a.e ReportRecordPresenter reportRecordPresenter) {
        this.mPresenter = reportRecordPresenter;
    }

    public final void setMRefreshLayout(@i.c.a.d SmartRefreshLayout smartRefreshLayout) {
        h.q2.t.i0.f(smartRefreshLayout, "<set-?>");
        this.mRefreshLayout = smartRefreshLayout;
    }

    public final void setMRvList(@i.c.a.d RecyclerView recyclerView) {
        h.q2.t.i0.f(recyclerView, "<set-?>");
        this.mRvList = recyclerView;
    }

    public final void setMTvTitle(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }
}
