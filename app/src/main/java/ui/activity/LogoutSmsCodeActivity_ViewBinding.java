package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import ui.view.CodeCutTimeTextView;

/* loaded from: classes2.dex */
public final class LogoutSmsCodeActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private LogoutSmsCodeActivity f18329a;

    /* renamed from: b, reason: collision with root package name */
    private View f18330b;

    /* renamed from: c, reason: collision with root package name */
    private View f18331c;

    /* renamed from: d, reason: collision with root package name */
    private View f18332d;

    /* renamed from: e, reason: collision with root package name */
    private View f18333e;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LogoutSmsCodeActivity f18334a;

        a(LogoutSmsCodeActivity logoutSmsCodeActivity) {
            this.f18334a = logoutSmsCodeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18334a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LogoutSmsCodeActivity f18336a;

        b(LogoutSmsCodeActivity logoutSmsCodeActivity) {
            this.f18336a = logoutSmsCodeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18336a.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LogoutSmsCodeActivity f18338a;

        c(LogoutSmsCodeActivity logoutSmsCodeActivity) {
            this.f18338a = logoutSmsCodeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18338a.onClick(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LogoutSmsCodeActivity f18340a;

        d(LogoutSmsCodeActivity logoutSmsCodeActivity) {
            this.f18340a = logoutSmsCodeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18340a.onClick(view);
        }
    }

    @UiThread
    public LogoutSmsCodeActivity_ViewBinding(LogoutSmsCodeActivity logoutSmsCodeActivity) {
        this(logoutSmsCodeActivity, logoutSmsCodeActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LogoutSmsCodeActivity logoutSmsCodeActivity = this.f18329a;
        if (logoutSmsCodeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18329a = null;
        logoutSmsCodeActivity.mIvBack = null;
        logoutSmsCodeActivity.mTvTitle = null;
        logoutSmsCodeActivity.mEtPhoneNum = null;
        logoutSmsCodeActivity.mPhoneCode = null;
        logoutSmsCodeActivity.mTvReSend = null;
        logoutSmsCodeActivity.mConfim = null;
        this.f18330b.setOnClickListener(null);
        this.f18330b = null;
        this.f18331c.setOnClickListener(null);
        this.f18331c = null;
        this.f18332d.setOnClickListener(null);
        this.f18332d = null;
        this.f18333e.setOnClickListener(null);
        this.f18333e = null;
    }

    @UiThread
    public LogoutSmsCodeActivity_ViewBinding(LogoutSmsCodeActivity logoutSmsCodeActivity, View view) {
        this.f18329a = logoutSmsCodeActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        logoutSmsCodeActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18330b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(logoutSmsCodeActivity));
        logoutSmsCodeActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        logoutSmsCodeActivity.mEtPhoneNum = (EditText) Utils.findRequiredViewAsType(view, R.id.et_phone_num, "field 'mEtPhoneNum'", EditText.class);
        logoutSmsCodeActivity.mPhoneCode = (EditText) Utils.findRequiredViewAsType(view, R.id.phone_code, "field 'mPhoneCode'", EditText.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_resend, "field 'mTvReSend' and method 'onClick'");
        logoutSmsCodeActivity.mTvReSend = (CodeCutTimeTextView) Utils.castView(viewFindRequiredView2, R.id.tv_resend, "field 'mTvReSend'", CodeCutTimeTextView.class);
        this.f18331c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(logoutSmsCodeActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.confirm, "field 'mConfim' and method 'onClick'");
        logoutSmsCodeActivity.mConfim = (Button) Utils.castView(viewFindRequiredView3, R.id.confirm, "field 'mConfim'", Button.class);
        this.f18332d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(logoutSmsCodeActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.iv_clear, "method 'onClick'");
        this.f18333e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(logoutSmsCodeActivity));
    }
}
