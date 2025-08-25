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
public class PayStopSelectActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private PayStopSelectActivity f18474a;

    /* renamed from: b, reason: collision with root package name */
    private View f18475b;

    /* renamed from: c, reason: collision with root package name */
    private View f18476c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PayStopSelectActivity f18477a;

        a(PayStopSelectActivity payStopSelectActivity) {
            this.f18477a = payStopSelectActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18477a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PayStopSelectActivity f18479a;

        b(PayStopSelectActivity payStopSelectActivity) {
            this.f18479a = payStopSelectActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18479a.onViewClicked(view);
        }
    }

    @UiThread
    public PayStopSelectActivity_ViewBinding(PayStopSelectActivity payStopSelectActivity) {
        this(payStopSelectActivity, payStopSelectActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PayStopSelectActivity payStopSelectActivity = this.f18474a;
        if (payStopSelectActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18474a = null;
        payStopSelectActivity.mTvTitle = null;
        payStopSelectActivity.mRecyclerview = null;
        payStopSelectActivity.mBtnCommit = null;
        this.f18475b.setOnClickListener(null);
        this.f18475b = null;
        this.f18476c.setOnClickListener(null);
        this.f18476c = null;
    }

    @UiThread
    public PayStopSelectActivity_ViewBinding(PayStopSelectActivity payStopSelectActivity, View view) {
        this.f18474a = payStopSelectActivity;
        payStopSelectActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        payStopSelectActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_commit, "field 'mBtnCommit' and method 'onViewClicked'");
        payStopSelectActivity.mBtnCommit = (Button) Utils.castView(viewFindRequiredView, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        this.f18475b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(payStopSelectActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18476c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(payStopSelectActivity));
    }
}
