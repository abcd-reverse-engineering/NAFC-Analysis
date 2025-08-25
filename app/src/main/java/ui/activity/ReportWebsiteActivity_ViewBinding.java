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

/* loaded from: classes2.dex */
public final class ReportWebsiteActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private ReportWebsiteActivity f18810a;

    /* renamed from: b, reason: collision with root package name */
    private View f18811b;

    /* renamed from: c, reason: collision with root package name */
    private View f18812c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ReportWebsiteActivity f18813a;

        a(ReportWebsiteActivity reportWebsiteActivity) {
            this.f18813a = reportWebsiteActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18813a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ReportWebsiteActivity f18815a;

        b(ReportWebsiteActivity reportWebsiteActivity) {
            this.f18815a = reportWebsiteActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18815a.onClick(view);
        }
    }

    @UiThread
    public ReportWebsiteActivity_ViewBinding(ReportWebsiteActivity reportWebsiteActivity) {
        this(reportWebsiteActivity, reportWebsiteActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReportWebsiteActivity reportWebsiteActivity = this.f18810a;
        if (reportWebsiteActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18810a = null;
        reportWebsiteActivity.mIvBack = null;
        reportWebsiteActivity.mTvTitle = null;
        reportWebsiteActivity.mLlAddLayout = null;
        reportWebsiteActivity.mTvAdd = null;
        reportWebsiteActivity.mRecycleView = null;
        this.f18811b.setOnClickListener(null);
        this.f18811b = null;
        this.f18812c.setOnClickListener(null);
        this.f18812c = null;
    }

    @UiThread
    public ReportWebsiteActivity_ViewBinding(ReportWebsiteActivity reportWebsiteActivity, View view) {
        this.f18810a = reportWebsiteActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        reportWebsiteActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18811b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(reportWebsiteActivity));
        reportWebsiteActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_add, "field 'mLlAddLayout' and method 'onClick'");
        reportWebsiteActivity.mLlAddLayout = viewFindRequiredView2;
        this.f18812c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(reportWebsiteActivity));
        reportWebsiteActivity.mTvAdd = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_add, "field 'mTvAdd'", TextView.class);
        reportWebsiteActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
    }
}
