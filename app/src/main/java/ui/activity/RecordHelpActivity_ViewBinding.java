package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class RecordHelpActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private RecordHelpActivity f18616a;

    /* renamed from: b, reason: collision with root package name */
    private View f18617b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecordHelpActivity f18618a;

        a(RecordHelpActivity recordHelpActivity) {
            this.f18618a = recordHelpActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18618a.onViewClicked(view);
        }
    }

    @UiThread
    public RecordHelpActivity_ViewBinding(RecordHelpActivity recordHelpActivity) {
        this(recordHelpActivity, recordHelpActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RecordHelpActivity recordHelpActivity = this.f18616a;
        if (recordHelpActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18616a = null;
        recordHelpActivity.mIvBack = null;
        recordHelpActivity.mTvTitle = null;
        this.f18617b.setOnClickListener(null);
        this.f18617b = null;
    }

    @UiThread
    public RecordHelpActivity_ViewBinding(RecordHelpActivity recordHelpActivity, View view) {
        this.f18616a = recordHelpActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        recordHelpActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18617b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(recordHelpActivity));
        recordHelpActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
    }
}
