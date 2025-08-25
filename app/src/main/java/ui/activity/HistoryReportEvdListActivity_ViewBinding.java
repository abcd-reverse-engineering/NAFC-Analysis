package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: classes2.dex */
public class HistoryReportEvdListActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private HistoryReportEvdListActivity f18227a;

    /* renamed from: b, reason: collision with root package name */
    private View f18228b;

    /* renamed from: c, reason: collision with root package name */
    private View f18229c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HistoryReportEvdListActivity f18230a;

        a(HistoryReportEvdListActivity historyReportEvdListActivity) {
            this.f18230a = historyReportEvdListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18230a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HistoryReportEvdListActivity f18232a;

        b(HistoryReportEvdListActivity historyReportEvdListActivity) {
            this.f18232a = historyReportEvdListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18232a.onViewClicked(view);
        }
    }

    @UiThread
    public HistoryReportEvdListActivity_ViewBinding(HistoryReportEvdListActivity historyReportEvdListActivity) {
        this(historyReportEvdListActivity, historyReportEvdListActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        HistoryReportEvdListActivity historyReportEvdListActivity = this.f18227a;
        if (historyReportEvdListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18227a = null;
        historyReportEvdListActivity.mTvTitle = null;
        historyReportEvdListActivity.mIvRight = null;
        historyReportEvdListActivity.mRecyclerview = null;
        historyReportEvdListActivity.mRefreshLayout = null;
        this.f18228b.setOnClickListener(null);
        this.f18228b = null;
        this.f18229c.setOnClickListener(null);
        this.f18229c = null;
    }

    @UiThread
    public HistoryReportEvdListActivity_ViewBinding(HistoryReportEvdListActivity historyReportEvdListActivity, View view) {
        this.f18227a = historyReportEvdListActivity;
        historyReportEvdListActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_right, "field 'mIvRight' and method 'onViewClicked'");
        historyReportEvdListActivity.mIvRight = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_right, "field 'mIvRight'", ImageView.class);
        this.f18228b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(historyReportEvdListActivity));
        historyReportEvdListActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        historyReportEvdListActivity.mRefreshLayout = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, R.id.swipe_refresh, "field 'mRefreshLayout'", SmartRefreshLayout.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18229c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(historyReportEvdListActivity));
    }
}
