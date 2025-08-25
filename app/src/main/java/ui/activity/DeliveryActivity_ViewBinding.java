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
public final class DeliveryActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private DeliveryActivity f18087a;

    /* renamed from: b, reason: collision with root package name */
    private View f18088b;

    /* renamed from: c, reason: collision with root package name */
    private View f18089c;

    /* renamed from: d, reason: collision with root package name */
    private View f18090d;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DeliveryActivity f18091a;

        a(DeliveryActivity deliveryActivity) {
            this.f18091a = deliveryActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18091a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DeliveryActivity f18093a;

        b(DeliveryActivity deliveryActivity) {
            this.f18093a = deliveryActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18093a.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DeliveryActivity f18095a;

        c(DeliveryActivity deliveryActivity) {
            this.f18095a = deliveryActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18095a.onClick(view);
        }
    }

    @UiThread
    public DeliveryActivity_ViewBinding(DeliveryActivity deliveryActivity) {
        this(deliveryActivity, deliveryActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        DeliveryActivity deliveryActivity = this.f18087a;
        if (deliveryActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18087a = null;
        deliveryActivity.mIvBack = null;
        deliveryActivity.mTvTitle = null;
        deliveryActivity.mLlAddLayout = null;
        deliveryActivity.mTvAdd = null;
        deliveryActivity.mRecycleView = null;
        deliveryActivity.mTvCommitTip = null;
        this.f18088b.setOnClickListener(null);
        this.f18088b = null;
        this.f18089c.setOnClickListener(null);
        this.f18089c = null;
        this.f18090d.setOnClickListener(null);
        this.f18090d = null;
    }

    @UiThread
    public DeliveryActivity_ViewBinding(DeliveryActivity deliveryActivity, View view) {
        this.f18087a = deliveryActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        deliveryActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18088b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(deliveryActivity));
        deliveryActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_add, "field 'mLlAddLayout' and method 'onClick'");
        deliveryActivity.mLlAddLayout = viewFindRequiredView2;
        this.f18089c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(deliveryActivity));
        deliveryActivity.mTvAdd = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_add, "field 'mTvAdd'", TextView.class);
        deliveryActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
        deliveryActivity.mTvCommitTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_commit_tip, "field 'mTvCommitTip'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_commit, "method 'onClick'");
        this.f18090d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(deliveryActivity));
    }
}
