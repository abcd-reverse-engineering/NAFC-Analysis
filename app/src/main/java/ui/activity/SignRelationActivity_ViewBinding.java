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
public final class SignRelationActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private SignRelationActivity f18973a;

    /* renamed from: b, reason: collision with root package name */
    private View f18974b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SignRelationActivity f18975a;

        a(SignRelationActivity signRelationActivity) {
            this.f18975a = signRelationActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18975a.onViewClicked(view);
        }
    }

    @UiThread
    public SignRelationActivity_ViewBinding(SignRelationActivity signRelationActivity) {
        this(signRelationActivity, signRelationActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignRelationActivity signRelationActivity = this.f18973a;
        if (signRelationActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18973a = null;
        signRelationActivity.mTvTitle = null;
        signRelationActivity.mRecyclerview = null;
        this.f18974b.setOnClickListener(null);
        this.f18974b = null;
    }

    @UiThread
    public SignRelationActivity_ViewBinding(SignRelationActivity signRelationActivity, View view) {
        this.f18973a = signRelationActivity;
        signRelationActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signRelationActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18974b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(signRelationActivity));
    }
}
