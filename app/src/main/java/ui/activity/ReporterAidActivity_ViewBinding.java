package ui.activity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public final class ReporterAidActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private ReporterAidActivity f18834a;

    /* renamed from: b, reason: collision with root package name */
    private View f18835b;

    /* renamed from: c, reason: collision with root package name */
    private View f18836c;

    /* renamed from: d, reason: collision with root package name */
    private View f18837d;

    /* renamed from: e, reason: collision with root package name */
    private View f18838e;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ReporterAidActivity f18839a;

        a(ReporterAidActivity reporterAidActivity) {
            this.f18839a = reporterAidActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18839a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ReporterAidActivity f18841a;

        b(ReporterAidActivity reporterAidActivity) {
            this.f18841a = reporterAidActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18841a.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ReporterAidActivity f18843a;

        c(ReporterAidActivity reporterAidActivity) {
            this.f18843a = reporterAidActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18843a.onClick(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ReporterAidActivity f18845a;

        d(ReporterAidActivity reporterAidActivity) {
            this.f18845a = reporterAidActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18845a.onClick(view);
        }
    }

    @UiThread
    public ReporterAidActivity_ViewBinding(ReporterAidActivity reporterAidActivity) {
        this(reporterAidActivity, reporterAidActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReporterAidActivity reporterAidActivity = this.f18834a;
        if (reporterAidActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18834a = null;
        reporterAidActivity.mIvBack = null;
        reporterAidActivity.mTvTitle = null;
        reporterAidActivity.mTCbSelect = null;
        reporterAidActivity.mRedDot = null;
        this.f18835b.setOnClickListener(null);
        this.f18835b = null;
        this.f18836c.setOnClickListener(null);
        this.f18836c = null;
        this.f18837d.setOnClickListener(null);
        this.f18837d = null;
        this.f18838e.setOnClickListener(null);
        this.f18838e = null;
    }

    @UiThread
    public ReporterAidActivity_ViewBinding(ReporterAidActivity reporterAidActivity, View view) {
        this.f18834a = reporterAidActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        reporterAidActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18835b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(reporterAidActivity));
        reporterAidActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        reporterAidActivity.mTCbSelect = (CheckBox) Utils.findRequiredViewAsType(view, R.id.cb_select, "field 'mTCbSelect'", CheckBox.class);
        reporterAidActivity.mRedDot = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_red_dot, "field 'mRedDot'", ImageView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_report_record, "method 'onClick'");
        this.f18836c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(reporterAidActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_rule, "method 'onClick'");
        this.f18837d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(reporterAidActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.fl_confirm, "method 'onClick'");
        this.f18838e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(reporterAidActivity));
    }
}
