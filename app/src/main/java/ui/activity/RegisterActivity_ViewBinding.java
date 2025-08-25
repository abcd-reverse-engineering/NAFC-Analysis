package ui.activity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import ui.view.CodeCutTimeTextView;

/* loaded from: classes2.dex */
public class RegisterActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private RegisterActivity f18627a;

    /* renamed from: b, reason: collision with root package name */
    private View f18628b;

    /* renamed from: c, reason: collision with root package name */
    private View f18629c;

    /* renamed from: d, reason: collision with root package name */
    private View f18630d;

    /* renamed from: e, reason: collision with root package name */
    private View f18631e;

    /* renamed from: f, reason: collision with root package name */
    private View f18632f;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RegisterActivity f18633a;

        a(RegisterActivity registerActivity) {
            this.f18633a = registerActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18633a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RegisterActivity f18635a;

        b(RegisterActivity registerActivity) {
            this.f18635a = registerActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18635a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RegisterActivity f18637a;

        c(RegisterActivity registerActivity) {
            this.f18637a = registerActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18637a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RegisterActivity f18639a;

        d(RegisterActivity registerActivity) {
            this.f18639a = registerActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18639a.onViewClicked(view);
        }
    }

    class e extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RegisterActivity f18641a;

        e(RegisterActivity registerActivity) {
            this.f18641a = registerActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18641a.onViewClicked(view);
        }
    }

    @UiThread
    public RegisterActivity_ViewBinding(RegisterActivity registerActivity) {
        this(registerActivity, registerActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RegisterActivity registerActivity = this.f18627a;
        if (registerActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18627a = null;
        registerActivity.mTvRegion = null;
        registerActivity.mUserPwd = null;
        registerActivity.mConfirm = null;
        registerActivity.mClause = null;
        registerActivity.mTCbSelect = null;
        registerActivity.mAccount = null;
        registerActivity.mIvClean = null;
        registerActivity.mPwdEye = null;
        registerActivity.mIvClearAccount = null;
        registerActivity.mTvResend = null;
        registerActivity.mUserVerification = null;
        registerActivity.mLlToLogin = null;
        this.f18628b.setOnClickListener(null);
        this.f18628b = null;
        this.f18629c.setOnClickListener(null);
        this.f18629c = null;
        this.f18630d.setOnClickListener(null);
        this.f18630d = null;
        this.f18631e.setOnClickListener(null);
        this.f18631e = null;
        this.f18632f.setOnClickListener(null);
        this.f18632f = null;
    }

    @UiThread
    public RegisterActivity_ViewBinding(RegisterActivity registerActivity, View view) {
        this.f18627a = registerActivity;
        registerActivity.mTvRegion = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_region, "field 'mTvRegion'", TextView.class);
        registerActivity.mUserPwd = (EditText) Utils.findRequiredViewAsType(view, R.id.user_pwd, "field 'mUserPwd'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.confirm, "field 'mConfirm' and method 'onViewClicked'");
        registerActivity.mConfirm = (TextView) Utils.castView(viewFindRequiredView, R.id.confirm, "field 'mConfirm'", TextView.class);
        this.f18628b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(registerActivity));
        registerActivity.mClause = (TextView) Utils.findRequiredViewAsType(view, R.id.clause, "field 'mClause'", TextView.class);
        registerActivity.mTCbSelect = (CheckBox) Utils.findRequiredViewAsType(view, R.id.cb_select, "field 'mTCbSelect'", CheckBox.class);
        registerActivity.mAccount = (EditText) Utils.findRequiredViewAsType(view, R.id.account, "field 'mAccount'", EditText.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_clear, "field 'mIvClean' and method 'onViewClicked'");
        registerActivity.mIvClean = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_clear, "field 'mIvClean'", ImageView.class);
        this.f18629c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(registerActivity));
        registerActivity.mPwdEye = (ImageView) Utils.findRequiredViewAsType(view, R.id.pwd_eye, "field 'mPwdEye'", ImageView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_clear_account, "field 'mIvClearAccount' and method 'onViewClicked'");
        registerActivity.mIvClearAccount = (ImageView) Utils.castView(viewFindRequiredView3, R.id.iv_clear_account, "field 'mIvClearAccount'", ImageView.class);
        this.f18630d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(registerActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_resend, "field 'mTvResend' and method 'onViewClicked'");
        registerActivity.mTvResend = (CodeCutTimeTextView) Utils.castView(viewFindRequiredView4, R.id.tv_resend, "field 'mTvResend'", CodeCutTimeTextView.class);
        this.f18631e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(registerActivity));
        registerActivity.mUserVerification = (EditText) Utils.findRequiredViewAsType(view, R.id.user_verification, "field 'mUserVerification'", EditText.class);
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.ll_to_login, "field 'mLlToLogin' and method 'onViewClicked'");
        registerActivity.mLlToLogin = (LinearLayout) Utils.castView(viewFindRequiredView5, R.id.ll_to_login, "field 'mLlToLogin'", LinearLayout.class);
        this.f18632f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(registerActivity));
    }
}
