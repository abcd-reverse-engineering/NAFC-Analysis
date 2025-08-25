package ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public final class SignCallActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private SignCallActivity f18918a;

    /* renamed from: b, reason: collision with root package name */
    private View f18919b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SignCallActivity f18920a;

        a(SignCallActivity signCallActivity) {
            this.f18920a = signCallActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18920a.onViewClicked(view);
        }
    }

    @UiThread
    public SignCallActivity_ViewBinding(SignCallActivity signCallActivity) {
        this(signCallActivity, signCallActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignCallActivity signCallActivity = this.f18918a;
        if (signCallActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18918a = null;
        signCallActivity.mTvTitle = null;
        signCallActivity.mRecyclerview = null;
        this.f18919b.setOnClickListener(null);
        this.f18919b = null;
    }

    @UiThread
    public SignCallActivity_ViewBinding(SignCallActivity signCallActivity, View view) {
        this.f18918a = signCallActivity;
        signCallActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signCallActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18919b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(signCallActivity));
    }
}
