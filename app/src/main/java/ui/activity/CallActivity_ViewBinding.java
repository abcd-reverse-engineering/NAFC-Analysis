package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public final class CallActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private CallActivity f17729a;

    /* renamed from: b, reason: collision with root package name */
    private View f17730b;

    /* renamed from: c, reason: collision with root package name */
    private View f17731c;

    /* renamed from: d, reason: collision with root package name */
    private View f17732d;

    /* renamed from: e, reason: collision with root package name */
    private View f17733e;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CallActivity f17734a;

        a(CallActivity callActivity) {
            this.f17734a = callActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17734a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CallActivity f17736a;

        b(CallActivity callActivity) {
            this.f17736a = callActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17736a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CallActivity f17738a;

        c(CallActivity callActivity) {
            this.f17738a = callActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17738a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CallActivity f17740a;

        d(CallActivity callActivity) {
            this.f17740a = callActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17740a.onViewClicked(view);
        }
    }

    @UiThread
    public CallActivity_ViewBinding(CallActivity callActivity) {
        this(callActivity, callActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CallActivity callActivity = this.f17729a;
        if (callActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f17729a = null;
        callActivity.mTvTitle = null;
        callActivity.mRecyclerview = null;
        callActivity.mTvSelectTip = null;
        callActivity.mTvCommitTip = null;
        callActivity.mBtnCommit = null;
        callActivity.mTvInputTip = null;
        this.f17730b.setOnClickListener(null);
        this.f17730b = null;
        this.f17731c.setOnClickListener(null);
        this.f17731c = null;
        this.f17732d.setOnClickListener(null);
        this.f17732d = null;
        this.f17733e.setOnClickListener(null);
        this.f17733e = null;
    }

    @UiThread
    public CallActivity_ViewBinding(CallActivity callActivity, View view) {
        this.f17729a = callActivity;
        callActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        callActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        callActivity.mTvSelectTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_select_tip, "field 'mTvSelectTip'", TextView.class);
        callActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        callActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f17730b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(callActivity));
        callActivity.mTvInputTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_input_tip, "field 'mTvInputTip'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f17731c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(callActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_select, "method 'onViewClicked'");
        this.f17732d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(callActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.ll_input, "method 'onViewClicked'");
        this.f17733e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(callActivity));
    }
}
