package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class AboutUsActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private AboutUsActivity f17554a;

    /* renamed from: b, reason: collision with root package name */
    private View f17555b;

    /* renamed from: c, reason: collision with root package name */
    private View f17556c;

    /* renamed from: d, reason: collision with root package name */
    private View f17557d;

    /* renamed from: e, reason: collision with root package name */
    private View f17558e;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AboutUsActivity f17559a;

        a(AboutUsActivity aboutUsActivity) {
            this.f17559a = aboutUsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17559a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AboutUsActivity f17561a;

        b(AboutUsActivity aboutUsActivity) {
            this.f17561a = aboutUsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17561a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AboutUsActivity f17563a;

        c(AboutUsActivity aboutUsActivity) {
            this.f17563a = aboutUsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17563a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AboutUsActivity f17565a;

        d(AboutUsActivity aboutUsActivity) {
            this.f17565a = aboutUsActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17565a.onViewClicked(view);
        }
    }

    @UiThread
    public AboutUsActivity_ViewBinding(AboutUsActivity aboutUsActivity) {
        this(aboutUsActivity, aboutUsActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AboutUsActivity aboutUsActivity = this.f17554a;
        if (aboutUsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f17554a = null;
        aboutUsActivity.mTvAppVersion = null;
        aboutUsActivity.mTvTitle = null;
        aboutUsActivity.mTvOwnerTip = null;
        aboutUsActivity.mTvTechSupor = null;
        aboutUsActivity.mTvAppTip = null;
        aboutUsActivity.mChenkBtn = null;
        aboutUsActivity.mTvSdk = null;
        this.f17555b.setOnClickListener(null);
        this.f17555b = null;
        this.f17556c.setOnClickListener(null);
        this.f17556c = null;
        this.f17557d.setOnClickListener(null);
        this.f17557d = null;
        this.f17558e.setOnClickListener(null);
        this.f17558e = null;
    }

    @UiThread
    public AboutUsActivity_ViewBinding(AboutUsActivity aboutUsActivity, View view) {
        this.f17554a = aboutUsActivity;
        aboutUsActivity.mTvAppVersion = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_app_version, "field 'mTvAppVersion'", TextView.class);
        aboutUsActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        aboutUsActivity.mTvOwnerTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_owner_tip, "field 'mTvOwnerTip'", TextView.class);
        aboutUsActivity.mTvTechSupor = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tech_sup, "field 'mTvTechSupor'", TextView.class);
        aboutUsActivity.mTvAppTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_new_tips, "field 'mTvAppTip'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.check_upadte, "field 'mChenkBtn' and method 'onViewClicked'");
        aboutUsActivity.mChenkBtn = (Button) Utils.castView(viewFindRequiredView, R.id.check_upadte, "field 'mChenkBtn'", Button.class);
        this.f17555b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(aboutUsActivity));
        aboutUsActivity.mTvSdk = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_sdk_version, "field 'mTvSdk'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f17556c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(aboutUsActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.ll_agreement, "method 'onViewClicked'");
        this.f17557d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(aboutUsActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.ll_policy, "method 'onViewClicked'");
        this.f17558e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(aboutUsActivity));
    }
}
