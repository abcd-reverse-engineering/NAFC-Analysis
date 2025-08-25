package ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class WarnActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private WarnActivity f19266a;

    /* renamed from: b, reason: collision with root package name */
    private View f19267b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WarnActivity f19268a;

        a(WarnActivity warnActivity) {
            this.f19268a = warnActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19268a.onViewClicked(view);
        }
    }

    @UiThread
    public WarnActivity_ViewBinding(WarnActivity warnActivity) {
        this(warnActivity, warnActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WarnActivity warnActivity = this.f19266a;
        if (warnActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19266a = null;
        warnActivity.mTvAppVersion = null;
        this.f19267b.setOnClickListener(null);
        this.f19267b = null;
    }

    @UiThread
    public WarnActivity_ViewBinding(WarnActivity warnActivity, View view) {
        this.f19266a = warnActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_dialog_phone, "field 'mTvAppVersion' and method 'onViewClicked'");
        warnActivity.mTvAppVersion = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_dialog_phone, "field 'mTvAppVersion'", TextView.class);
        this.f19267b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(warnActivity));
    }
}
