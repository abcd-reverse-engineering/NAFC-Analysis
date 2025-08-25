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
public final class SignDeliveryActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private SignDeliveryActivity f18953a;

    /* renamed from: b, reason: collision with root package name */
    private View f18954b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SignDeliveryActivity f18955a;

        a(SignDeliveryActivity signDeliveryActivity) {
            this.f18955a = signDeliveryActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18955a.onClick(view);
        }
    }

    @UiThread
    public SignDeliveryActivity_ViewBinding(SignDeliveryActivity signDeliveryActivity) {
        this(signDeliveryActivity, signDeliveryActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignDeliveryActivity signDeliveryActivity = this.f18953a;
        if (signDeliveryActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18953a = null;
        signDeliveryActivity.mIvBack = null;
        signDeliveryActivity.mTvTitle = null;
        signDeliveryActivity.mRecycleView = null;
        this.f18954b.setOnClickListener(null);
        this.f18954b = null;
    }

    @UiThread
    public SignDeliveryActivity_ViewBinding(SignDeliveryActivity signDeliveryActivity, View view) {
        this.f18953a = signDeliveryActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        signDeliveryActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18954b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(signDeliveryActivity));
        signDeliveryActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signDeliveryActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
    }
}
