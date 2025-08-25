package ui.fragment;

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
public class LocalWebFragment_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private LocalWebFragment f19633a;

    /* renamed from: b, reason: collision with root package name */
    private View f19634b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LocalWebFragment f19635a;

        a(LocalWebFragment localWebFragment) {
            this.f19635a = localWebFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f19635a.onViewClicked(view);
        }
    }

    @UiThread
    public LocalWebFragment_ViewBinding(LocalWebFragment localWebFragment, View view) {
        this.f19633a = localWebFragment;
        localWebFragment.mLinearLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.web_container, "field 'mLinearLayout'", LinearLayout.class);
        localWebFragment.mProgressBar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.progress_bar, "field 'mProgressBar'", ProgressBar.class);
        localWebFragment.mProgressLoad = Utils.findRequiredView(view, R.id.ll_progress, "field 'mProgressLoad'");
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ll_network_no, "field 'mLlNetworkNo' and method 'onViewClicked'");
        localWebFragment.mLlNetworkNo = viewFindRequiredView;
        this.f19634b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(localWebFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LocalWebFragment localWebFragment = this.f19633a;
        if (localWebFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19633a = null;
        localWebFragment.mLinearLayout = null;
        localWebFragment.mProgressBar = null;
        localWebFragment.mProgressLoad = null;
        localWebFragment.mLlNetworkNo = null;
        this.f19634b.setOnClickListener(null);
        this.f19634b = null;
    }
}
