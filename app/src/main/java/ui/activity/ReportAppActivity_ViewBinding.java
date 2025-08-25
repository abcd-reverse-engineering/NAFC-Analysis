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
public final class ReportAppActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private ReportAppActivity f18669a;

    /* renamed from: b, reason: collision with root package name */
    private View f18670b;

    /* renamed from: c, reason: collision with root package name */
    private View f18671c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ReportAppActivity f18672a;

        a(ReportAppActivity reportAppActivity) {
            this.f18672a = reportAppActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18672a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ReportAppActivity f18674a;

        b(ReportAppActivity reportAppActivity) {
            this.f18674a = reportAppActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18674a.onClick(view);
        }
    }

    @UiThread
    public ReportAppActivity_ViewBinding(ReportAppActivity reportAppActivity) {
        this(reportAppActivity, reportAppActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReportAppActivity reportAppActivity = this.f18669a;
        if (reportAppActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18669a = null;
        reportAppActivity.mIvBack = null;
        reportAppActivity.mTvTitle = null;
        reportAppActivity.mTvAdd = null;
        reportAppActivity.mRecycleView = null;
        this.f18670b.setOnClickListener(null);
        this.f18670b = null;
        this.f18671c.setOnClickListener(null);
        this.f18671c = null;
    }

    @UiThread
    public ReportAppActivity_ViewBinding(ReportAppActivity reportAppActivity, View view) {
        this.f18669a = reportAppActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        reportAppActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18670b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(reportAppActivity));
        reportAppActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        reportAppActivity.mTvAdd = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_add, "field 'mTvAdd'", TextView.class);
        reportAppActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_add, "method 'onClick'");
        this.f18671c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(reportAppActivity));
    }
}
