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
public final class ReportCaseInfoActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private ReportCaseInfoActivity f18682a;

    /* renamed from: b, reason: collision with root package name */
    private View f18683b;

    /* renamed from: c, reason: collision with root package name */
    private View f18684c;

    /* renamed from: d, reason: collision with root package name */
    private View f18685d;

    /* renamed from: e, reason: collision with root package name */
    private View f18686e;

    /* renamed from: f, reason: collision with root package name */
    private View f18687f;

    /* renamed from: g, reason: collision with root package name */
    private View f18688g;

    /* renamed from: h, reason: collision with root package name */
    private View f18689h;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ReportCaseInfoActivity f18690a;

        a(ReportCaseInfoActivity reportCaseInfoActivity) {
            this.f18690a = reportCaseInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18690a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ReportCaseInfoActivity f18692a;

        b(ReportCaseInfoActivity reportCaseInfoActivity) {
            this.f18692a = reportCaseInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18692a.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ReportCaseInfoActivity f18694a;

        c(ReportCaseInfoActivity reportCaseInfoActivity) {
            this.f18694a = reportCaseInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18694a.onClick(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ReportCaseInfoActivity f18696a;

        d(ReportCaseInfoActivity reportCaseInfoActivity) {
            this.f18696a = reportCaseInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18696a.onClick(view);
        }
    }

    class e extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ReportCaseInfoActivity f18698a;

        e(ReportCaseInfoActivity reportCaseInfoActivity) {
            this.f18698a = reportCaseInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18698a.onClick(view);
        }
    }

    class f extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ReportCaseInfoActivity f18700a;

        f(ReportCaseInfoActivity reportCaseInfoActivity) {
            this.f18700a = reportCaseInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18700a.onClick(view);
        }
    }

    class g extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ReportCaseInfoActivity f18702a;

        g(ReportCaseInfoActivity reportCaseInfoActivity) {
            this.f18702a = reportCaseInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18702a.onClick(view);
        }
    }

    @UiThread
    public ReportCaseInfoActivity_ViewBinding(ReportCaseInfoActivity reportCaseInfoActivity) {
        this(reportCaseInfoActivity, reportCaseInfoActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReportCaseInfoActivity reportCaseInfoActivity = this.f18682a;
        if (reportCaseInfoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18682a = null;
        reportCaseInfoActivity.mIvBack = null;
        reportCaseInfoActivity.mTvTitle = null;
        reportCaseInfoActivity.mTvAdd = null;
        reportCaseInfoActivity.mRvList = null;
        reportCaseInfoActivity.mInvolveAccTip = null;
        reportCaseInfoActivity.mIvCallTip = null;
        reportCaseInfoActivity.mIvSmsTip = null;
        reportCaseInfoActivity.mIvWebNetTip = null;
        reportCaseInfoActivity.mFlBottomView = null;
        this.f18683b.setOnClickListener(null);
        this.f18683b = null;
        this.f18684c.setOnClickListener(null);
        this.f18684c = null;
        this.f18685d.setOnClickListener(null);
        this.f18685d = null;
        this.f18686e.setOnClickListener(null);
        this.f18686e = null;
        this.f18687f.setOnClickListener(null);
        this.f18687f = null;
        this.f18688g.setOnClickListener(null);
        this.f18688g = null;
        this.f18689h.setOnClickListener(null);
        this.f18689h = null;
    }

    @UiThread
    public ReportCaseInfoActivity_ViewBinding(ReportCaseInfoActivity reportCaseInfoActivity, View view) {
        this.f18682a = reportCaseInfoActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        reportCaseInfoActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18683b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(reportCaseInfoActivity));
        reportCaseInfoActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        reportCaseInfoActivity.mTvAdd = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_add, "field 'mTvAdd'", TextView.class);
        reportCaseInfoActivity.mRvList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRvList'", RecyclerView.class);
        reportCaseInfoActivity.mInvolveAccTip = (ImageView) Utils.findRequiredViewAsType(view, R.id.involved_acc_tip, "field 'mInvolveAccTip'", ImageView.class);
        reportCaseInfoActivity.mIvCallTip = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_call_tip, "field 'mIvCallTip'", ImageView.class);
        reportCaseInfoActivity.mIvSmsTip = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_sms_tip, "field 'mIvSmsTip'", ImageView.class);
        reportCaseInfoActivity.mIvWebNetTip = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_webnet_tip, "field 'mIvWebNetTip'", ImageView.class);
        reportCaseInfoActivity.mFlBottomView = Utils.findRequiredView(view, R.id.fl_bottom_view, "field 'mFlBottomView'");
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_add, "method 'onClick'");
        this.f18684c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(reportCaseInfoActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.rl_involved_acc, "method 'onClick'");
        this.f18685d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(reportCaseInfoActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.rl_crime_phone, "method 'onClick'");
        this.f18686e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(reportCaseInfoActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.rl_sms_item, "method 'onClick'");
        this.f18687f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(reportCaseInfoActivity));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.rl_webnet_item, "method 'onClick'");
        this.f18688g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(reportCaseInfoActivity));
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.btn_commit, "method 'onClick'");
        this.f18689h = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new g(reportCaseInfoActivity));
    }
}
