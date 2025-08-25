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
public class CallNewActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private CallNewActivity f17767a;

    /* renamed from: b, reason: collision with root package name */
    private View f17768b;

    /* renamed from: c, reason: collision with root package name */
    private View f17769c;

    /* renamed from: d, reason: collision with root package name */
    private View f17770d;

    /* renamed from: e, reason: collision with root package name */
    private View f17771e;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CallNewActivity f17772a;

        a(CallNewActivity callNewActivity) {
            this.f17772a = callNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17772a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CallNewActivity f17774a;

        b(CallNewActivity callNewActivity) {
            this.f17774a = callNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17774a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CallNewActivity f17776a;

        c(CallNewActivity callNewActivity) {
            this.f17776a = callNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17776a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CallNewActivity f17778a;

        d(CallNewActivity callNewActivity) {
            this.f17778a = callNewActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17778a.onViewClicked(view);
        }
    }

    @UiThread
    public CallNewActivity_ViewBinding(CallNewActivity callNewActivity) {
        this(callNewActivity, callNewActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CallNewActivity callNewActivity = this.f17767a;
        if (callNewActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f17767a = null;
        callNewActivity.mTvTitle = null;
        callNewActivity.mRecyclerview = null;
        callNewActivity.mTvSelectTip = null;
        callNewActivity.mTvCommitTip = null;
        callNewActivity.mBtnCommit = null;
        callNewActivity.mTvInputTip = null;
        this.f17768b.setOnClickListener(null);
        this.f17768b = null;
        this.f17769c.setOnClickListener(null);
        this.f17769c = null;
        this.f17770d.setOnClickListener(null);
        this.f17770d = null;
        this.f17771e.setOnClickListener(null);
        this.f17771e = null;
    }

    @UiThread
    public CallNewActivity_ViewBinding(CallNewActivity callNewActivity, View view) {
        this.f17767a = callNewActivity;
        callNewActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        callNewActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        callNewActivity.mTvSelectTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_select_tip, "field 'mTvSelectTip'", TextView.class);
        callNewActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        callNewActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f17768b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(callNewActivity));
        callNewActivity.mTvInputTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_input_tip, "field 'mTvInputTip'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f17769c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(callNewActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_select, "method 'onViewClicked'");
        this.f17770d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(callNewActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.ll_input, "method 'onViewClicked'");
        this.f17771e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(callNewActivity));
    }
}
