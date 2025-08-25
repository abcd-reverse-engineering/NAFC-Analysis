package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: classes2.dex */
public final class ManualListActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private ManualListActivity f18382a;

    /* renamed from: b, reason: collision with root package name */
    private View f18383b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ManualListActivity f18384a;

        a(ManualListActivity manualListActivity) {
            this.f18384a = manualListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18384a.onClick(view);
        }
    }

    @UiThread
    public ManualListActivity_ViewBinding(ManualListActivity manualListActivity) {
        this(manualListActivity, manualListActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ManualListActivity manualListActivity = this.f18382a;
        if (manualListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18382a = null;
        manualListActivity.mIvBack = null;
        manualListActivity.mTvTitle = null;
        manualListActivity.mNoImg = null;
        manualListActivity.mNoTip = null;
        manualListActivity.mClNoData = null;
        manualListActivity.mRvList = null;
        manualListActivity.mRefreshLayout = null;
        this.f18383b.setOnClickListener(null);
        this.f18383b = null;
    }

    @UiThread
    public ManualListActivity_ViewBinding(ManualListActivity manualListActivity, View view) {
        this.f18382a = manualListActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        manualListActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18383b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(manualListActivity));
        manualListActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        manualListActivity.mNoImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_img, "field 'mNoImg'", ImageView.class);
        manualListActivity.mNoTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tip, "field 'mNoTip'", TextView.class);
        manualListActivity.mClNoData = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.cl_no_data, "field 'mClNoData'", ConstraintLayout.class);
        manualListActivity.mRvList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRvList'", RecyclerView.class);
        manualListActivity.mRefreshLayout = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, R.id.swipe_refresh, "field 'mRefreshLayout'", SmartRefreshLayout.class);
    }
}
