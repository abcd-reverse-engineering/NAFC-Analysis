package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: classes2.dex */
public final class ReportRecordsActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private ReportRecordsActivity f18753a;

    /* renamed from: b, reason: collision with root package name */
    private View f18754b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ReportRecordsActivity f18755a;

        a(ReportRecordsActivity reportRecordsActivity) {
            this.f18755a = reportRecordsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18755a.onClick(view);
        }
    }

    @UiThread
    public ReportRecordsActivity_ViewBinding(ReportRecordsActivity reportRecordsActivity) {
        this(reportRecordsActivity, reportRecordsActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReportRecordsActivity reportRecordsActivity = this.f18753a;
        if (reportRecordsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18753a = null;
        reportRecordsActivity.mIvBack = null;
        reportRecordsActivity.mTvTitle = null;
        reportRecordsActivity.mRvList = null;
        reportRecordsActivity.mRefreshLayout = null;
        reportRecordsActivity.mLlNodata = null;
        this.f18754b.setOnClickListener(null);
        this.f18754b = null;
    }

    @UiThread
    public ReportRecordsActivity_ViewBinding(ReportRecordsActivity reportRecordsActivity, View view) {
        this.f18753a = reportRecordsActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        reportRecordsActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18754b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(reportRecordsActivity));
        reportRecordsActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        reportRecordsActivity.mRvList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRvList'", RecyclerView.class);
        reportRecordsActivity.mRefreshLayout = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, R.id.swipe_refresh, "field 'mRefreshLayout'", SmartRefreshLayout.class);
        reportRecordsActivity.mLlNodata = Utils.findRequiredView(view, R.id.ll_nodata, "field 'mLlNodata'");
    }
}
