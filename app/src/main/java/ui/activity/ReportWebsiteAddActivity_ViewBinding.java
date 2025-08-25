package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public final class ReportWebsiteAddActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private ReportWebsiteAddActivity f18822a;

    /* renamed from: b, reason: collision with root package name */
    private View f18823b;

    /* renamed from: c, reason: collision with root package name */
    private View f18824c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ReportWebsiteAddActivity f18825a;

        a(ReportWebsiteAddActivity reportWebsiteAddActivity) {
            this.f18825a = reportWebsiteAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18825a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ReportWebsiteAddActivity f18827a;

        b(ReportWebsiteAddActivity reportWebsiteAddActivity) {
            this.f18827a = reportWebsiteAddActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18827a.onClick(view);
        }
    }

    @UiThread
    public ReportWebsiteAddActivity_ViewBinding(ReportWebsiteAddActivity reportWebsiteAddActivity) {
        this(reportWebsiteAddActivity, reportWebsiteAddActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReportWebsiteAddActivity reportWebsiteAddActivity = this.f18822a;
        if (reportWebsiteAddActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18822a = null;
        reportWebsiteAddActivity.mIvBack = null;
        reportWebsiteAddActivity.mTvTitle = null;
        reportWebsiteAddActivity.mTvTip = null;
        reportWebsiteAddActivity.mEtWebUrl = null;
        reportWebsiteAddActivity.mBtnCommit = null;
        reportWebsiteAddActivity.scrollView = null;
        reportWebsiteAddActivity.mRecyView = null;
        this.f18823b.setOnClickListener(null);
        this.f18823b = null;
        this.f18824c.setOnClickListener(null);
        this.f18824c = null;
    }

    @UiThread
    public ReportWebsiteAddActivity_ViewBinding(ReportWebsiteAddActivity reportWebsiteAddActivity, View view) {
        this.f18822a = reportWebsiteAddActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        reportWebsiteAddActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18823b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(reportWebsiteAddActivity));
        reportWebsiteAddActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        reportWebsiteAddActivity.mTvTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tip, "field 'mTvTip'", TextView.class);
        reportWebsiteAddActivity.mEtWebUrl = (EditText) Utils.findRequiredViewAsType(view, R.id.et_weburl, "field 'mEtWebUrl'", EditText.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onClick'");
        reportWebsiteAddActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView2, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f18824c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(reportWebsiteAddActivity));
        reportWebsiteAddActivity.scrollView = (NestedScrollView) Utils.findRequiredViewAsType(view, R.id.ns_layout, "field 'scrollView'", NestedScrollView.class);
        reportWebsiteAddActivity.mRecyView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyView'", RecyclerView.class);
    }
}
