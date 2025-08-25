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
public final class SignReChargeActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private SignReChargeActivity f18965a;

    /* renamed from: b, reason: collision with root package name */
    private View f18966b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SignReChargeActivity f18967a;

        a(SignReChargeActivity signReChargeActivity) {
            this.f18967a = signReChargeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18967a.onClick(view);
        }
    }

    @UiThread
    public SignReChargeActivity_ViewBinding(SignReChargeActivity signReChargeActivity) {
        this(signReChargeActivity, signReChargeActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignReChargeActivity signReChargeActivity = this.f18965a;
        if (signReChargeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18965a = null;
        signReChargeActivity.mIvBack = null;
        signReChargeActivity.mTvTitle = null;
        signReChargeActivity.mRecycleView = null;
        this.f18966b.setOnClickListener(null);
        this.f18966b = null;
    }

    @UiThread
    public SignReChargeActivity_ViewBinding(SignReChargeActivity signReChargeActivity, View view) {
        this.f18965a = signReChargeActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        signReChargeActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18966b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(signReChargeActivity));
        signReChargeActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signReChargeActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
    }
}
