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
public final class CriminalListActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private CriminalListActivity f18005a;

    /* renamed from: b, reason: collision with root package name */
    private View f18006b;

    /* renamed from: c, reason: collision with root package name */
    private View f18007c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CriminalListActivity f18008a;

        a(CriminalListActivity criminalListActivity) {
            this.f18008a = criminalListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18008a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CriminalListActivity f18010a;

        b(CriminalListActivity criminalListActivity) {
            this.f18010a = criminalListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18010a.onClick(view);
        }
    }

    @UiThread
    public CriminalListActivity_ViewBinding(CriminalListActivity criminalListActivity) {
        this(criminalListActivity, criminalListActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CriminalListActivity criminalListActivity = this.f18005a;
        if (criminalListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18005a = null;
        criminalListActivity.mIvBack = null;
        criminalListActivity.mTvTitle = null;
        criminalListActivity.mRecycleView = null;
        criminalListActivity.mTvAdd = null;
        this.f18006b.setOnClickListener(null);
        this.f18006b = null;
        this.f18007c.setOnClickListener(null);
        this.f18007c = null;
    }

    @UiThread
    public CriminalListActivity_ViewBinding(CriminalListActivity criminalListActivity, View view) {
        this.f18005a = criminalListActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        criminalListActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18006b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(criminalListActivity));
        criminalListActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        criminalListActivity.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecycleView'", RecyclerView.class);
        criminalListActivity.mTvAdd = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_add, "field 'mTvAdd'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ll_add, "method 'onClick'");
        this.f18007c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(criminalListActivity));
    }
}
