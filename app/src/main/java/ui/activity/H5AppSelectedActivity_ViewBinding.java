package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class H5AppSelectedActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private H5AppSelectedActivity f18196a;

    /* renamed from: b, reason: collision with root package name */
    private View f18197b;

    /* renamed from: c, reason: collision with root package name */
    private View f18198c;

    /* renamed from: d, reason: collision with root package name */
    private View f18199d;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ H5AppSelectedActivity f18200a;

        a(H5AppSelectedActivity h5AppSelectedActivity) {
            this.f18200a = h5AppSelectedActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18200a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ H5AppSelectedActivity f18202a;

        b(H5AppSelectedActivity h5AppSelectedActivity) {
            this.f18202a = h5AppSelectedActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18202a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ H5AppSelectedActivity f18204a;

        c(H5AppSelectedActivity h5AppSelectedActivity) {
            this.f18204a = h5AppSelectedActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18204a.onViewClicked(view);
        }
    }

    @UiThread
    public H5AppSelectedActivity_ViewBinding(H5AppSelectedActivity h5AppSelectedActivity) {
        this(h5AppSelectedActivity, h5AppSelectedActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        H5AppSelectedActivity h5AppSelectedActivity = this.f18196a;
        if (h5AppSelectedActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18196a = null;
        h5AppSelectedActivity.mIvBack = null;
        h5AppSelectedActivity.mTvTitle = null;
        h5AppSelectedActivity.mIvRight = null;
        h5AppSelectedActivity.mExpandableList = null;
        h5AppSelectedActivity.mBtnReport = null;
        this.f18197b.setOnClickListener(null);
        this.f18197b = null;
        this.f18198c.setOnClickListener(null);
        this.f18198c = null;
        this.f18199d.setOnClickListener(null);
        this.f18199d = null;
    }

    @UiThread
    public H5AppSelectedActivity_ViewBinding(H5AppSelectedActivity h5AppSelectedActivity, View view) {
        this.f18196a = h5AppSelectedActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        h5AppSelectedActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18197b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(h5AppSelectedActivity));
        h5AppSelectedActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_right, "field 'mIvRight' and method 'onViewClicked'");
        h5AppSelectedActivity.mIvRight = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_right, "field 'mIvRight'", ImageView.class);
        this.f18198c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(h5AppSelectedActivity));
        h5AppSelectedActivity.mExpandableList = (ExpandableListView) Utils.findRequiredViewAsType(view, R.id.recyclerview_app, "field 'mExpandableList'", ExpandableListView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_report, "field 'mBtnReport' and method 'onViewClicked'");
        h5AppSelectedActivity.mBtnReport = (Button) Utils.castView(viewFindRequiredView3, R.id.btn_report, "field 'mBtnReport'", Button.class);
        this.f18199d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(h5AppSelectedActivity));
    }
}
