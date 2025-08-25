package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class PayStopListActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private PayStopListActivity f18459a;

    /* renamed from: b, reason: collision with root package name */
    private View f18460b;

    /* renamed from: c, reason: collision with root package name */
    private View f18461c;

    /* renamed from: d, reason: collision with root package name */
    private View f18462d;

    /* renamed from: e, reason: collision with root package name */
    private View f18463e;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PayStopListActivity f18464a;

        a(PayStopListActivity payStopListActivity) {
            this.f18464a = payStopListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18464a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PayStopListActivity f18466a;

        b(PayStopListActivity payStopListActivity) {
            this.f18466a = payStopListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18466a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PayStopListActivity f18468a;

        c(PayStopListActivity payStopListActivity) {
            this.f18468a = payStopListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18468a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PayStopListActivity f18470a;

        d(PayStopListActivity payStopListActivity) {
            this.f18470a = payStopListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18470a.onViewClicked(view);
        }
    }

    @UiThread
    public PayStopListActivity_ViewBinding(PayStopListActivity payStopListActivity) {
        this(payStopListActivity, payStopListActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PayStopListActivity payStopListActivity = this.f18459a;
        if (payStopListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18459a = null;
        payStopListActivity.mTvTitle = null;
        payStopListActivity.mLine = null;
        payStopListActivity.mLlSelect = null;
        payStopListActivity.mLlInput = null;
        payStopListActivity.mRecyclerview = null;
        payStopListActivity.mBtnCommit = null;
        this.f18460b.setOnClickListener(null);
        this.f18460b = null;
        this.f18461c.setOnClickListener(null);
        this.f18461c = null;
        this.f18462d.setOnClickListener(null);
        this.f18462d = null;
        this.f18463e.setOnClickListener(null);
        this.f18463e = null;
    }

    @UiThread
    public PayStopListActivity_ViewBinding(PayStopListActivity payStopListActivity, View view) {
        this.f18459a = payStopListActivity;
        payStopListActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        payStopListActivity.mLine = Utils.findRequiredView(view, R.id.v_line, "field 'mLine'");
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_select, "field 'mLlSelect' and method 'onViewClicked'");
        payStopListActivity.mLlSelect = viewFindRequiredView;
        this.f18460b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(payStopListActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_input, "field 'mLlInput' and method 'onViewClicked'");
        payStopListActivity.mLlInput = viewFindRequiredView2;
        this.f18461c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(payStopListActivity));
        payStopListActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        payStopListActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView3, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f18462d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(payStopListActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18463e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(payStopListActivity));
    }
}
