package ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class PaymentTypeActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private PaymentTypeActivity f18481a;

    /* renamed from: b, reason: collision with root package name */
    private View f18482b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PaymentTypeActivity f18483a;

        a(PaymentTypeActivity paymentTypeActivity) {
            this.f18483a = paymentTypeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18483a.onViewClicked(view);
        }
    }

    @UiThread
    public PaymentTypeActivity_ViewBinding(PaymentTypeActivity paymentTypeActivity) {
        this(paymentTypeActivity, paymentTypeActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PaymentTypeActivity paymentTypeActivity = this.f18481a;
        if (paymentTypeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18481a = null;
        paymentTypeActivity.mTvTitle = null;
        paymentTypeActivity.mRecyclerview = null;
        this.f18482b.setOnClickListener(null);
        this.f18482b = null;
    }

    @UiThread
    public PaymentTypeActivity_ViewBinding(PaymentTypeActivity paymentTypeActivity, View view) {
        this.f18481a = paymentTypeActivity;
        paymentTypeActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        paymentTypeActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18482b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(paymentTypeActivity));
    }
}
