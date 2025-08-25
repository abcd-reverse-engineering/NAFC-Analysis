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
public final class SignCommitWebsiteActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private SignCommitWebsiteActivity f18942a;

    /* renamed from: b, reason: collision with root package name */
    private View f18943b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SignCommitWebsiteActivity f18944a;

        a(SignCommitWebsiteActivity signCommitWebsiteActivity) {
            this.f18944a = signCommitWebsiteActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18944a.onClick(view);
        }
    }

    @UiThread
    public SignCommitWebsiteActivity_ViewBinding(SignCommitWebsiteActivity signCommitWebsiteActivity) {
        this(signCommitWebsiteActivity, signCommitWebsiteActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignCommitWebsiteActivity signCommitWebsiteActivity = this.f18942a;
        if (signCommitWebsiteActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18942a = null;
        signCommitWebsiteActivity.mIvBack = null;
        signCommitWebsiteActivity.mTvTitle = null;
        signCommitWebsiteActivity.mRecycleView = null;
        this.f18943b.setOnClickListener(null);
        this.f18943b = null;
    }

    @UiThread
    public SignCommitWebsiteActivity_ViewBinding(SignCommitWebsiteActivity signCommitWebsiteActivity, View view) {
        this.f18942a = signCommitWebsiteActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        signCommitWebsiteActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18943b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(signCommitWebsiteActivity));
        signCommitWebsiteActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signCommitWebsiteActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
    }
}
