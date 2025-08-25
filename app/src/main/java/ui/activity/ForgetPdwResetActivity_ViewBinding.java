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

/* loaded from: classes2.dex */
public class ForgetPdwResetActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private ForgetPdwResetActivity f18179a;

    /* renamed from: b, reason: collision with root package name */
    private View f18180b;

    /* renamed from: c, reason: collision with root package name */
    private View f18181c;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ForgetPdwResetActivity f18182a;

        a(ForgetPdwResetActivity forgetPdwResetActivity) {
            this.f18182a = forgetPdwResetActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18182a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ForgetPdwResetActivity f18184a;

        b(ForgetPdwResetActivity forgetPdwResetActivity) {
            this.f18184a = forgetPdwResetActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18184a.onViewClicked(view);
        }
    }

    @UiThread
    public ForgetPdwResetActivity_ViewBinding(ForgetPdwResetActivity forgetPdwResetActivity) {
        this(forgetPdwResetActivity, forgetPdwResetActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ForgetPdwResetActivity forgetPdwResetActivity = this.f18179a;
        if (forgetPdwResetActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18179a = null;
        forgetPdwResetActivity.mTvTitle = null;
        forgetPdwResetActivity.mEtNewPwd = null;
        forgetPdwResetActivity.mPwdEye = null;
        forgetPdwResetActivity.mConfim = null;
        this.f18180b.setOnClickListener(null);
        this.f18180b = null;
        this.f18181c.setOnClickListener(null);
        this.f18181c = null;
    }

    @UiThread
    public ForgetPdwResetActivity_ViewBinding(ForgetPdwResetActivity forgetPdwResetActivity, View view) {
        this.f18179a = forgetPdwResetActivity;
        forgetPdwResetActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        forgetPdwResetActivity.mEtNewPwd = (EditText) Utils.findRequiredViewAsType(view, R.id.et_new_pwd, "field 'mEtNewPwd'", EditText.class);
        forgetPdwResetActivity.mPwdEye = (ImageView) Utils.findRequiredViewAsType(view, R.id.pwd_eye, "field 'mPwdEye'", ImageView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.confirm, "field 'mConfim' and method 'onViewClicked'");
        forgetPdwResetActivity.mConfim = (TextView) Utils.castView(viewFindRequiredView, R.id.confirm, "field 'mConfim'", TextView.class);
        this.f18180b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(forgetPdwResetActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18181c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(forgetPdwResetActivity));
    }
}
