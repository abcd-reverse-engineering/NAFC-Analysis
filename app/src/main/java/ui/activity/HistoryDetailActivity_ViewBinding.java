package ui.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class HistoryDetailActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private HistoryDetailActivity f18223a;

    /* renamed from: b, reason: collision with root package name */
    private View f18224b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HistoryDetailActivity f18225a;

        a(HistoryDetailActivity historyDetailActivity) {
            this.f18225a = historyDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18225a.onViewClicked(view);
        }
    }

    @UiThread
    public HistoryDetailActivity_ViewBinding(HistoryDetailActivity historyDetailActivity) {
        this(historyDetailActivity, historyDetailActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        HistoryDetailActivity historyDetailActivity = this.f18223a;
        if (historyDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18223a = null;
        historyDetailActivity.mTvTitle = null;
        historyDetailActivity.mExpendList = null;
        historyDetailActivity.mCaseTip = null;
        historyDetailActivity.mCaseTegory = null;
        historyDetailActivity.mTvReportInfo = null;
        historyDetailActivity.mTvReportNum = null;
        historyDetailActivity.mTvSelf = null;
        historyDetailActivity.mTvCaseNum = null;
        historyDetailActivity.mTvReportTime = null;
        historyDetailActivity.mLlProgress = null;
        historyDetailActivity.mLlReportProgress = null;
        historyDetailActivity.mLlReportView = null;
        this.f18224b.setOnClickListener(null);
        this.f18224b = null;
    }

    @UiThread
    public HistoryDetailActivity_ViewBinding(HistoryDetailActivity historyDetailActivity, View view) {
        this.f18223a = historyDetailActivity;
        historyDetailActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        historyDetailActivity.mExpendList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mExpendList'", RecyclerView.class);
        historyDetailActivity.mCaseTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_case_type, "field 'mCaseTip'", TextView.class);
        historyDetailActivity.mCaseTegory = (TextView) Utils.findRequiredViewAsType(view, R.id.casecategory, "field 'mCaseTegory'", TextView.class);
        historyDetailActivity.mTvReportInfo = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_report_name, "field 'mTvReportInfo'", TextView.class);
        historyDetailActivity.mTvReportNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_report_num, "field 'mTvReportNum'", TextView.class);
        historyDetailActivity.mTvSelf = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_self, "field 'mTvSelf'", TextView.class);
        historyDetailActivity.mTvCaseNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_case_num, "field 'mTvCaseNum'", TextView.class);
        historyDetailActivity.mTvReportTime = (TextView) Utils.findRequiredViewAsType(view, R.id.report_time, "field 'mTvReportTime'", TextView.class);
        historyDetailActivity.mLlProgress = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_progress, "field 'mLlProgress'", LinearLayout.class);
        historyDetailActivity.mLlReportProgress = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_report_progress, "field 'mLlReportProgress'", LinearLayout.class);
        historyDetailActivity.mLlReportView = Utils.findRequiredView(view, R.id.ll_report_view, "field 'mLlReportView'");
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18224b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(historyDetailActivity));
    }
}
