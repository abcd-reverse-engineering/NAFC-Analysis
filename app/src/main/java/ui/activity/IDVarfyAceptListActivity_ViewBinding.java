package ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: classes2.dex */
public class IDVarfyAceptListActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private IDVarfyAceptListActivity f18234a;

    /* renamed from: b, reason: collision with root package name */
    private View f18235b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IDVarfyAceptListActivity f18236a;

        a(IDVarfyAceptListActivity iDVarfyAceptListActivity) {
            this.f18236a = iDVarfyAceptListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18236a.onViewClicked(view);
        }
    }

    @UiThread
    public IDVarfyAceptListActivity_ViewBinding(IDVarfyAceptListActivity iDVarfyAceptListActivity) {
        this(iDVarfyAceptListActivity, iDVarfyAceptListActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        IDVarfyAceptListActivity iDVarfyAceptListActivity = this.f18234a;
        if (iDVarfyAceptListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18234a = null;
        iDVarfyAceptListActivity.mTvTitle = null;
        iDVarfyAceptListActivity.mLlNodata = null;
        iDVarfyAceptListActivity.mRecyclerview = null;
        iDVarfyAceptListActivity.mRefreshLayout = null;
        this.f18235b.setOnClickListener(null);
        this.f18235b = null;
    }

    @UiThread
    public IDVarfyAceptListActivity_ViewBinding(IDVarfyAceptListActivity iDVarfyAceptListActivity, View view) {
        this.f18234a = iDVarfyAceptListActivity;
        iDVarfyAceptListActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        iDVarfyAceptListActivity.mLlNodata = Utils.findRequiredView(view, R.id.ll_nodata, "field 'mLlNodata'");
        iDVarfyAceptListActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        iDVarfyAceptListActivity.mRefreshLayout = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, R.id.sm_refresh, "field 'mRefreshLayout'", SmartRefreshLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18235b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(iDVarfyAceptListActivity));
    }
}
