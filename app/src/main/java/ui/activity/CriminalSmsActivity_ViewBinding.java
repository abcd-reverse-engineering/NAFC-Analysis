package ui.activity;

import android.view.View;
import android.widget.Button;
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
public class CriminalSmsActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private CriminalSmsActivity f18014a;

    /* renamed from: b, reason: collision with root package name */
    private View f18015b;

    /* renamed from: c, reason: collision with root package name */
    private View f18016c;

    /* renamed from: d, reason: collision with root package name */
    private View f18017d;

    /* renamed from: e, reason: collision with root package name */
    private View f18018e;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CriminalSmsActivity f18019a;

        a(CriminalSmsActivity criminalSmsActivity) {
            this.f18019a = criminalSmsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18019a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CriminalSmsActivity f18021a;

        b(CriminalSmsActivity criminalSmsActivity) {
            this.f18021a = criminalSmsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18021a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CriminalSmsActivity f18023a;

        c(CriminalSmsActivity criminalSmsActivity) {
            this.f18023a = criminalSmsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18023a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CriminalSmsActivity f18025a;

        d(CriminalSmsActivity criminalSmsActivity) {
            this.f18025a = criminalSmsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18025a.onViewClicked(view);
        }
    }

    @UiThread
    public CriminalSmsActivity_ViewBinding(CriminalSmsActivity criminalSmsActivity) {
        this(criminalSmsActivity, criminalSmsActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CriminalSmsActivity criminalSmsActivity = this.f18014a;
        if (criminalSmsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18014a = null;
        criminalSmsActivity.mTvTitle = null;
        criminalSmsActivity.mRecyclerview = null;
        criminalSmsActivity.mTvSelectTip = null;
        criminalSmsActivity.mTvCommitTip = null;
        criminalSmsActivity.mBtnCommit = null;
        criminalSmsActivity.mTvInputTip = null;
        criminalSmsActivity.mIncInput = null;
        criminalSmsActivity.mIncComplete = null;
        this.f18015b.setOnClickListener(null);
        this.f18015b = null;
        this.f18016c.setOnClickListener(null);
        this.f18016c = null;
        this.f18017d.setOnClickListener(null);
        this.f18017d = null;
        this.f18018e.setOnClickListener(null);
        this.f18018e = null;
    }

    @UiThread
    public CriminalSmsActivity_ViewBinding(CriminalSmsActivity criminalSmsActivity, View view) {
        this.f18014a = criminalSmsActivity;
        criminalSmsActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        criminalSmsActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        criminalSmsActivity.mTvSelectTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_select_tip, "field 'mTvSelectTip'", TextView.class);
        criminalSmsActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        criminalSmsActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f18015b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(criminalSmsActivity));
        criminalSmsActivity.mTvInputTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_input_tip, "field 'mTvInputTip'", TextView.class);
        criminalSmsActivity.mIncInput = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.inc_input, "field 'mIncInput'", LinearLayout.class);
        criminalSmsActivity.mIncComplete = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.inc_complete, "field 'mIncComplete'", LinearLayout.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18016c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(criminalSmsActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_select, "method 'onViewClicked'");
        this.f18017d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(criminalSmsActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.ll_input, "method 'onViewClicked'");
        this.f18018e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(criminalSmsActivity));
    }
}
