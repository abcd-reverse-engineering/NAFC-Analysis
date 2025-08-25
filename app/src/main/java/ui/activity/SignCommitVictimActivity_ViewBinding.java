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
public final class SignCommitVictimActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private SignCommitVictimActivity f18938a;

    /* renamed from: b, reason: collision with root package name */
    private View f18939b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SignCommitVictimActivity f18940a;

        a(SignCommitVictimActivity signCommitVictimActivity) {
            this.f18940a = signCommitVictimActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18940a.onClick(view);
        }
    }

    @UiThread
    public SignCommitVictimActivity_ViewBinding(SignCommitVictimActivity signCommitVictimActivity) {
        this(signCommitVictimActivity, signCommitVictimActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignCommitVictimActivity signCommitVictimActivity = this.f18938a;
        if (signCommitVictimActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18938a = null;
        signCommitVictimActivity.mIvBack = null;
        signCommitVictimActivity.mTvTitle = null;
        signCommitVictimActivity.mRecycleView = null;
        this.f18939b.setOnClickListener(null);
        this.f18939b = null;
    }

    @UiThread
    public SignCommitVictimActivity_ViewBinding(SignCommitVictimActivity signCommitVictimActivity, View view) {
        this.f18938a = signCommitVictimActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        signCommitVictimActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18939b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(signCommitVictimActivity));
        signCommitVictimActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signCommitVictimActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
    }
}
