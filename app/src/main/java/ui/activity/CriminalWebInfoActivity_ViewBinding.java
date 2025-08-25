package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public final class CriminalWebInfoActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private CriminalWebInfoActivity f18072a;

    /* renamed from: b, reason: collision with root package name */
    private View f18073b;

    /* renamed from: c, reason: collision with root package name */
    private View f18074c;

    /* renamed from: d, reason: collision with root package name */
    private View f18075d;

    /* renamed from: e, reason: collision with root package name */
    private View f18076e;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CriminalWebInfoActivity f18077a;

        a(CriminalWebInfoActivity criminalWebInfoActivity) {
            this.f18077a = criminalWebInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18077a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CriminalWebInfoActivity f18079a;

        b(CriminalWebInfoActivity criminalWebInfoActivity) {
            this.f18079a = criminalWebInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18079a.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CriminalWebInfoActivity f18081a;

        c(CriminalWebInfoActivity criminalWebInfoActivity) {
            this.f18081a = criminalWebInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18081a.onClick(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CriminalWebInfoActivity f18083a;

        d(CriminalWebInfoActivity criminalWebInfoActivity) {
            this.f18083a = criminalWebInfoActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18083a.onClick(view);
        }
    }

    @UiThread
    public CriminalWebInfoActivity_ViewBinding(CriminalWebInfoActivity criminalWebInfoActivity) {
        this(criminalWebInfoActivity, criminalWebInfoActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CriminalWebInfoActivity criminalWebInfoActivity = this.f18072a;
        if (criminalWebInfoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18072a = null;
        criminalWebInfoActivity.mIvBack = null;
        criminalWebInfoActivity.mTvTitle = null;
        criminalWebInfoActivity.mTvSocialNum = null;
        criminalWebInfoActivity.mTvAppNum = null;
        criminalWebInfoActivity.mTvWebsiteNum = null;
        this.f18073b.setOnClickListener(null);
        this.f18073b = null;
        this.f18074c.setOnClickListener(null);
        this.f18074c = null;
        this.f18075d.setOnClickListener(null);
        this.f18075d = null;
        this.f18076e.setOnClickListener(null);
        this.f18076e = null;
    }

    @UiThread
    public CriminalWebInfoActivity_ViewBinding(CriminalWebInfoActivity criminalWebInfoActivity, View view) {
        this.f18072a = criminalWebInfoActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        criminalWebInfoActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18073b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(criminalWebInfoActivity));
        criminalWebInfoActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        criminalWebInfoActivity.mTvSocialNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_social_num, "field 'mTvSocialNum'", TextView.class);
        criminalWebInfoActivity.mTvAppNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_app_num, "field 'mTvAppNum'", TextView.class);
        criminalWebInfoActivity.mTvWebsiteNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_website_num, "field 'mTvWebsiteNum'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.cl_social, "method 'onClick'");
        this.f18074c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(criminalWebInfoActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.cl_app, "method 'onClick'");
        this.f18075d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(criminalWebInfoActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.cl_website, "method 'onClick'");
        this.f18076e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(criminalWebInfoActivity));
    }
}
