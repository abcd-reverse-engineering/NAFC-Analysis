package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public final class ReportSuccessActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private ReportSuccessActivity f18801a;

    /* renamed from: b, reason: collision with root package name */
    private View f18802b;

    /* renamed from: c, reason: collision with root package name */
    private View f18803c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ReportSuccessActivity f18804a;

        a(ReportSuccessActivity reportSuccessActivity) {
            this.f18804a = reportSuccessActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18804a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ReportSuccessActivity f18806a;

        b(ReportSuccessActivity reportSuccessActivity) {
            this.f18806a = reportSuccessActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18806a.onClick(view);
        }
    }

    @UiThread
    public ReportSuccessActivity_ViewBinding(ReportSuccessActivity reportSuccessActivity) {
        this(reportSuccessActivity, reportSuccessActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReportSuccessActivity reportSuccessActivity = this.f18801a;
        if (reportSuccessActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18801a = null;
        reportSuccessActivity.mIvBack = null;
        reportSuccessActivity.mTvTitle = null;
        this.f18802b.setOnClickListener(null);
        this.f18802b = null;
        this.f18803c.setOnClickListener(null);
        this.f18803c = null;
    }

    @UiThread
    public ReportSuccessActivity_ViewBinding(ReportSuccessActivity reportSuccessActivity, View view) {
        this.f18801a = reportSuccessActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        reportSuccessActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18802b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(reportSuccessActivity));
        reportSuccessActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.fl_confirm, "method 'onClick'");
        this.f18803c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(reportSuccessActivity));
    }
}
