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
public class RecordHelpVideoActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private RecordHelpVideoActivity f18620a;

    /* renamed from: b, reason: collision with root package name */
    private View f18621b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecordHelpVideoActivity f18622a;

        a(RecordHelpVideoActivity recordHelpVideoActivity) {
            this.f18622a = recordHelpVideoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18622a.onViewClicked(view);
        }
    }

    @UiThread
    public RecordHelpVideoActivity_ViewBinding(RecordHelpVideoActivity recordHelpVideoActivity) {
        this(recordHelpVideoActivity, recordHelpVideoActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RecordHelpVideoActivity recordHelpVideoActivity = this.f18620a;
        if (recordHelpVideoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18620a = null;
        recordHelpVideoActivity.mIvBack = null;
        recordHelpVideoActivity.mTvTitle = null;
        this.f18621b.setOnClickListener(null);
        this.f18621b = null;
    }

    @UiThread
    public RecordHelpVideoActivity_ViewBinding(RecordHelpVideoActivity recordHelpVideoActivity, View view) {
        this.f18620a = recordHelpVideoActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        recordHelpVideoActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18621b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(recordHelpVideoActivity));
        recordHelpVideoActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
    }
}
