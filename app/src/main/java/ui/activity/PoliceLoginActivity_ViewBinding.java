package ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import ui.view.CodeCutTimeTextView;

/* loaded from: classes2.dex */
public class PoliceLoginActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private PoliceLoginActivity f18522a;

    /* renamed from: b, reason: collision with root package name */
    private View f18523b;

    /* renamed from: c, reason: collision with root package name */
    private View f18524c;

    /* renamed from: d, reason: collision with root package name */
    private View f18525d;

    /* renamed from: e, reason: collision with root package name */
    private View f18526e;

    /* renamed from: f, reason: collision with root package name */
    private View f18527f;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PoliceLoginActivity f18528a;

        a(PoliceLoginActivity policeLoginActivity) {
            this.f18528a = policeLoginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18528a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PoliceLoginActivity f18530a;

        b(PoliceLoginActivity policeLoginActivity) {
            this.f18530a = policeLoginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18530a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PoliceLoginActivity f18532a;

        c(PoliceLoginActivity policeLoginActivity) {
            this.f18532a = policeLoginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18532a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PoliceLoginActivity f18534a;

        d(PoliceLoginActivity policeLoginActivity) {
            this.f18534a = policeLoginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18534a.onViewClicked(view);
        }
    }

    class e extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PoliceLoginActivity f18536a;

        e(PoliceLoginActivity policeLoginActivity) {
            this.f18536a = policeLoginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18536a.onViewClicked(view);
        }
    }

    @UiThread
    public PoliceLoginActivity_ViewBinding(PoliceLoginActivity policeLoginActivity) {
        this(policeLoginActivity, policeLoginActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PoliceLoginActivity policeLoginActivity = this.f18522a;
        if (policeLoginActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18522a = null;
        policeLoginActivity.mIvBack = null;
        policeLoginActivity.mTvTitle = null;
        policeLoginActivity.mConfirm = null;
        policeLoginActivity.mPhone = null;
        policeLoginActivity.mIvclean = null;
        policeLoginActivity.mTvReset = null;
        policeLoginActivity.mCode = null;
        policeLoginActivity.mIvClearCode = null;
        this.f18523b.setOnClickListener(null);
        this.f18523b = null;
        this.f18524c.setOnClickListener(null);
        this.f18524c = null;
        this.f18525d.setOnClickListener(null);
        this.f18525d = null;
        this.f18526e.setOnClickListener(null);
        this.f18526e = null;
        this.f18527f.setOnClickListener(null);
        this.f18527f = null;
    }

    @UiThread
    public PoliceLoginActivity_ViewBinding(PoliceLoginActivity policeLoginActivity, View view) {
        this.f18522a = policeLoginActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
        policeLoginActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18523b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(policeLoginActivity));
        policeLoginActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.confirm, "field 'mConfirm' and method 'onViewClicked'");
        policeLoginActivity.mConfirm = (TextView) Utils.castView(viewFindRequiredView2, R.id.confirm, "field 'mConfirm'", TextView.class);
        this.f18524c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(policeLoginActivity));
        policeLoginActivity.mPhone = (EditText) Utils.findRequiredViewAsType(view, R.id.phone, "field 'mPhone'", EditText.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_clear, "field 'mIvclean' and method 'onViewClicked'");
        policeLoginActivity.mIvclean = (ImageView) Utils.castView(viewFindRequiredView3, R.id.iv_clear, "field 'mIvclean'", ImageView.class);
        this.f18525d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(policeLoginActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_resend, "field 'mTvReset' and method 'onViewClicked'");
        policeLoginActivity.mTvReset = (CodeCutTimeTextView) Utils.castView(viewFindRequiredView4, R.id.tv_resend, "field 'mTvReset'", CodeCutTimeTextView.class);
        this.f18526e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(policeLoginActivity));
        policeLoginActivity.mCode = (EditText) Utils.findRequiredViewAsType(view, R.id.code, "field 'mCode'", EditText.class);
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.iv_clear_code, "field 'mIvClearCode' and method 'onViewClicked'");
        policeLoginActivity.mIvClearCode = (ImageView) Utils.castView(viewFindRequiredView5, R.id.iv_clear_code, "field 'mIvClearCode'", ImageView.class);
        this.f18527f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(policeLoginActivity));
    }
}
