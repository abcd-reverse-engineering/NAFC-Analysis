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
public final class SignCommitAppActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private SignCommitAppActivity f18930a;

    /* renamed from: b, reason: collision with root package name */
    private View f18931b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SignCommitAppActivity f18932a;

        a(SignCommitAppActivity signCommitAppActivity) {
            this.f18932a = signCommitAppActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18932a.onClick(view);
        }
    }

    @UiThread
    public SignCommitAppActivity_ViewBinding(SignCommitAppActivity signCommitAppActivity) {
        this(signCommitAppActivity, signCommitAppActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignCommitAppActivity signCommitAppActivity = this.f18930a;
        if (signCommitAppActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18930a = null;
        signCommitAppActivity.mIvBack = null;
        signCommitAppActivity.mTvTitle = null;
        signCommitAppActivity.mRecycleView = null;
        this.f18931b.setOnClickListener(null);
        this.f18931b = null;
    }

    @UiThread
    public SignCommitAppActivity_ViewBinding(SignCommitAppActivity signCommitAppActivity, View view) {
        this.f18930a = signCommitAppActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        signCommitAppActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18931b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(signCommitAppActivity));
        signCommitAppActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signCommitAppActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
    }
}
