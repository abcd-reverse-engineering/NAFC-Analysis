package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.ReplyBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import h.q2.t.g1;
import java.util.List;
import ui.callview.ReportRecordsReplyCallview;
import ui.presenter.ReportRecordsReplyPresenter;
import ui.view.swip.SwipBackLayout;

/* compiled from: ReportRecordsReplyActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010)\u001a\u00020*H\u0016J\u0006\u0010+\u001a\u00020*J\u0010\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020.H\u0007J\u0018\u0010/\u001a\u00020*2\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\b\u00101\u001a\u00020*H\u0016J\b\u00102\u001a\u000203H\u0016R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00064"}, d2 = {"Lui/activity/ReportRecordsReplyActivity;", "Lui/activity/BaseActivity;", "Lui/callview/ReportRecordsReplyCallview;", "()V", "mData", "", "Lbean/ReplyBean;", "getMData", "()Ljava/util/List;", "setMData", "(Ljava/util/List;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mPresenter", "Lui/presenter/ReportRecordsReplyPresenter;", "getMPresenter", "()Lui/presenter/ReportRecordsReplyPresenter;", "setMPresenter", "(Lui/presenter/ReportRecordsReplyPresenter;)V", "mRefreshLayout", "Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "getMRefreshLayout", "()Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "setMRefreshLayout", "(Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;)V", "mRvList", "Landroidx/recyclerview/widget/RecyclerView;", "getMRvList", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRvList", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "initPage", "", "initView", "onClick", "view", "Landroid/view/View;", "onSuccessRequest", "result", "onfailRequest", "setLayoutView", "", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class ReportRecordsReplyActivity extends BaseActivity implements ReportRecordsReplyCallview {

    @i.c.a.e
    private List<ReplyBean> mData;

    @BindView(R.id.iv_back)
    @i.c.a.d
    public ImageView mIvBack;

    @i.c.a.e
    private ReportRecordsReplyPresenter mPresenter;

    @BindView(R.id.swipe_refresh)
    @i.c.a.d
    public SmartRefreshLayout mRefreshLayout;

    @BindView(R.id.recyclerview)
    @i.c.a.d
    public RecyclerView mRvList;

    @BindView(R.id.tv_title)
    @i.c.a.d
    public TextView mTvTitle;

    /* compiled from: ReportRecordsReplyActivity.kt */
    static final class a implements com.scwang.smartrefresh.layout.d.d {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ g1.h f18758b;

        a(g1.h hVar) {
            this.f18758b = hVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.scwang.smartrefresh.layout.d.d
        public final void a(@i.c.a.d com.scwang.smartrefresh.layout.b.j jVar) {
            h.q2.t.i0.f(jVar, "it");
            ReportRecordsReplyPresenter mPresenter = ReportRecordsReplyActivity.this.getMPresenter();
            if (mPresenter != null) {
                mPresenter.getReply((String) this.f18758b.element);
            }
        }
    }

    @i.c.a.e
    public final List<ReplyBean> getMData() {
        return this.mData;
    }

    @i.c.a.d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            h.q2.t.i0.k("mIvBack");
        }
        return imageView;
    }

    @i.c.a.e
    public final ReportRecordsReplyPresenter getMPresenter() {
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
        textView.setText("报案反馈");
        initView();
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        if (smartRefreshLayout == null) {
            h.q2.t.i0.k("mRefreshLayout");
        }
        smartRefreshLayout.e();
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.String] */
    public final void initView() {
        this.mPresenter = new ReportRecordsReplyPresenter(this.mActivity, this);
        ReportRecordsReplyPresenter reportRecordsReplyPresenter = this.mPresenter;
        if (reportRecordsReplyPresenter != null) {
            RecyclerView recyclerView = this.mRvList;
            if (recyclerView == null) {
                h.q2.t.i0.k("mRvList");
            }
            reportRecordsReplyPresenter.initRecyclePeop(recyclerView);
        }
        g1.h hVar = new g1.h();
        hVar.element = getIntent().getStringExtra(util.k1.C0);
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
        smartRefreshLayout4.a((com.scwang.smartrefresh.layout.d.d) new a(hVar));
    }

    @OnClick({R.id.iv_back})
    public final void onClick(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        if (!isDouble() && view.getId() == R.id.iv_back) {
            a();
        }
    }

    @Override // ui.callview.ReportRecordsReplyCallview
    public void onSuccessRequest(@i.c.a.e List<ReplyBean> list) {
        this.mData = list;
        ReportRecordsReplyPresenter reportRecordsReplyPresenter = this.mPresenter;
        if (reportRecordsReplyPresenter != null) {
            reportRecordsReplyPresenter.setListData(list);
        }
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        if (smartRefreshLayout == null) {
            h.q2.t.i0.k("mRefreshLayout");
        }
        smartRefreshLayout.g();
    }

    @Override // ui.callview.ReportRecordsReplyCallview
    public void onfailRequest() {
        SmartRefreshLayout smartRefreshLayout = this.mRefreshLayout;
        if (smartRefreshLayout == null) {
            h.q2.t.i0.k("mRefreshLayout");
        }
        smartRefreshLayout.g();
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_report_records_reply;
    }

    public final void setMData(@i.c.a.e List<ReplyBean> list) {
        this.mData = list;
    }

    public final void setMIvBack(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMPresenter(@i.c.a.e ReportRecordsReplyPresenter reportRecordsReplyPresenter) {
        this.mPresenter = reportRecordsReplyPresenter;
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
