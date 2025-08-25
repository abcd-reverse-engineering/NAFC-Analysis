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
public class AppSelectedActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private AppSelectedActivity f17665a;

    /* renamed from: b, reason: collision with root package name */
    private View f17666b;

    /* renamed from: c, reason: collision with root package name */
    private View f17667c;

    /* renamed from: d, reason: collision with root package name */
    private View f17668d;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppSelectedActivity f17669a;

        a(AppSelectedActivity appSelectedActivity) {
            this.f17669a = appSelectedActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17669a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppSelectedActivity f17671a;

        b(AppSelectedActivity appSelectedActivity) {
            this.f17671a = appSelectedActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17671a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppSelectedActivity f17673a;

        c(AppSelectedActivity appSelectedActivity) {
            this.f17673a = appSelectedActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17673a.onViewClicked(view);
        }
    }

    @UiThread
    public AppSelectedActivity_ViewBinding(AppSelectedActivity appSelectedActivity) {
        this(appSelectedActivity, appSelectedActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AppSelectedActivity appSelectedActivity = this.f17665a;
        if (appSelectedActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f17665a = null;
        appSelectedActivity.mIvBack = null;
        appSelectedActivity.mTvTitle = null;
        appSelectedActivity.mIvRight = null;
        appSelectedActivity.mExpandableList = null;
        appSelectedActivity.mBtnReport = null;
        this.f17666b.setOnClickListener(null);
        this.f17666b = null;
        this.f17667c.setOnClickListener(null);
        this.f17667c = null;
        this.f17668d.setOnClickListener(null);
        this.f17668d = null;
    }

    @UiThread
    public AppSelectedActivity_ViewBinding(AppSelectedActivity appSelectedActivity, View view) {
        this.f17665a = appSelectedActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        appSelectedActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f17666b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(appSelectedActivity));
        appSelectedActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_right, "field 'mIvRight' and method 'onViewClicked'");
        appSelectedActivity.mIvRight = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_right, "field 'mIvRight'", ImageView.class);
        this.f17667c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(appSelectedActivity));
        appSelectedActivity.mExpandableList = (ExpandableListView) Utils.findRequiredViewAsType(view, R.id.recyclerview_app, "field 'mExpandableList'", ExpandableListView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_report, "field 'mBtnReport' and method 'onViewClicked'");
        appSelectedActivity.mBtnReport = (Button) Utils.castView(viewFindRequiredView3, R.id.btn_report, "field 'mBtnReport'", Button.class);
        this.f17668d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(appSelectedActivity));
    }
}
