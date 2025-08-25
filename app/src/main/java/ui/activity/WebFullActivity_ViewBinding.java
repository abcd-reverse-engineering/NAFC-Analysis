package ui.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class WebFullActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private WebFullActivity f19364a;

    /* renamed from: b, reason: collision with root package name */
    private View f19365b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebFullActivity f19366a;

        a(WebFullActivity webFullActivity) {
            this.f19366a = webFullActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19366a.onViewClicked(view);
        }
    }

    @UiThread
    public WebFullActivity_ViewBinding(WebFullActivity webFullActivity) {
        this(webFullActivity, webFullActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WebFullActivity webFullActivity = this.f19364a;
        if (webFullActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19364a = null;
        webFullActivity.mProgressBar = null;
        webFullActivity.mLinearLayout = null;
        webFullActivity.mLlNetworkNo = null;
        this.f19365b.setOnClickListener(null);
        this.f19365b = null;
    }

    @UiThread
    public WebFullActivity_ViewBinding(WebFullActivity webFullActivity, View view) {
        this.f19364a = webFullActivity;
        webFullActivity.mProgressBar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.progress_bar, "field 'mProgressBar'", ProgressBar.class);
        webFullActivity.mLinearLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.web_container, "field 'mLinearLayout'", LinearLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_network_no, "field 'mLlNetworkNo' and method 'onViewClicked'");
        webFullActivity.mLlNetworkNo = viewFindRequiredView;
        this.f19365b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(webFullActivity));
    }
}
