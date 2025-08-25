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
public final class SignCommitCriminalActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private SignCommitCriminalActivity f18934a;

    /* renamed from: b, reason: collision with root package name */
    private View f18935b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SignCommitCriminalActivity f18936a;

        a(SignCommitCriminalActivity signCommitCriminalActivity) {
            this.f18936a = signCommitCriminalActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18936a.onClick(view);
        }
    }

    @UiThread
    public SignCommitCriminalActivity_ViewBinding(SignCommitCriminalActivity signCommitCriminalActivity) {
        this(signCommitCriminalActivity, signCommitCriminalActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignCommitCriminalActivity signCommitCriminalActivity = this.f18934a;
        if (signCommitCriminalActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18934a = null;
        signCommitCriminalActivity.mIvBack = null;
        signCommitCriminalActivity.mTvTitle = null;
        signCommitCriminalActivity.mRecycleView = null;
        this.f18935b.setOnClickListener(null);
        this.f18935b = null;
    }

    @UiThread
    public SignCommitCriminalActivity_ViewBinding(SignCommitCriminalActivity signCommitCriminalActivity, View view) {
        this.f18934a = signCommitCriminalActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        signCommitCriminalActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18935b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(signCommitCriminalActivity));
        signCommitCriminalActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signCommitCriminalActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
    }
}
