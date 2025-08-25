package ui.activity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.Group;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class LoginActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private LoginActivity f18274a;

    /* renamed from: b, reason: collision with root package name */
    private View f18275b;

    /* renamed from: c, reason: collision with root package name */
    private View f18276c;

    /* renamed from: d, reason: collision with root package name */
    private View f18277d;

    /* renamed from: e, reason: collision with root package name */
    private View f18278e;

    /* renamed from: f, reason: collision with root package name */
    private View f18279f;

    /* renamed from: g, reason: collision with root package name */
    private View f18280g;

    /* renamed from: h, reason: collision with root package name */
    private View f18281h;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LoginActivity f18282a;

        a(LoginActivity loginActivity) {
            this.f18282a = loginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18282a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LoginActivity f18284a;

        b(LoginActivity loginActivity) {
            this.f18284a = loginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18284a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LoginActivity f18286a;

        c(LoginActivity loginActivity) {
            this.f18286a = loginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18286a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LoginActivity f18288a;

        d(LoginActivity loginActivity) {
            this.f18288a = loginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18288a.onViewClicked(view);
        }
    }

    class e extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LoginActivity f18290a;

        e(LoginActivity loginActivity) {
            this.f18290a = loginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18290a.onViewClicked(view);
        }
    }

    class f extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LoginActivity f18292a;

        f(LoginActivity loginActivity) {
            this.f18292a = loginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18292a.onViewClicked(view);
        }
    }

    class g extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LoginActivity f18294a;

        g(LoginActivity loginActivity) {
            this.f18294a = loginActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18294a.onViewClicked(view);
        }
    }

    @UiThread
    public LoginActivity_ViewBinding(LoginActivity loginActivity) {
        this(loginActivity, loginActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LoginActivity loginActivity = this.f18274a;
        if (loginActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18274a = null;
        loginActivity.mLoginLabel = null;
        loginActivity.mAccountLabel = null;
        loginActivity.mAccount = null;
        loginActivity.mUserPwd = null;
        loginActivity.mIvClean = null;
        loginActivity.mPwdEye = null;
        loginActivity.mConfirm = null;
        loginActivity.mLoginChange = null;
        loginActivity.mClause = null;
        loginActivity.mTCbSelect = null;
        loginActivity.mPwdGroup = null;
        loginActivity.mForgetPwd = null;
        loginActivity.mLineV = null;
        this.f18275b.setOnClickListener(null);
        this.f18275b = null;
        this.f18276c.setOnClickListener(null);
        this.f18276c = null;
        this.f18277d.setOnClickListener(null);
        this.f18277d = null;
        this.f18278e.setOnClickListener(null);
        this.f18278e = null;
        this.f18279f.setOnClickListener(null);
        this.f18279f = null;
        this.f18280g.setOnClickListener(null);
        this.f18280g = null;
        this.f18281h.setOnClickListener(null);
        this.f18281h = null;
    }

    @UiThread
    public LoginActivity_ViewBinding(LoginActivity loginActivity, View view) {
        this.f18274a = loginActivity;
        loginActivity.mLoginLabel = (TextView) Utils.findRequiredViewAsType(view, R.id.login_label, "field 'mLoginLabel'", TextView.class);
        loginActivity.mAccountLabel = (TextView) Utils.findRequiredViewAsType(view, R.id.account_label, "field 'mAccountLabel'", TextView.class);
        loginActivity.mAccount = (EditText) Utils.findRequiredViewAsType(view, R.id.account, "field 'mAccount'", EditText.class);
        loginActivity.mUserPwd = (EditText) Utils.findRequiredViewAsType(view, R.id.user_pwd, "field 'mUserPwd'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_clear, "field 'mIvClean' and method 'onViewClicked'");
        loginActivity.mIvClean = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_clear, "field 'mIvClean'", ImageView.class);
        this.f18275b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(loginActivity));
        loginActivity.mPwdEye = (ImageView) Utils.findRequiredViewAsType(view, R.id.pwd_eye, "field 'mPwdEye'", ImageView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.confirm, "field 'mConfirm' and method 'onViewClicked'");
        loginActivity.mConfirm = (TextView) Utils.castView(viewFindRequiredView2, R.id.confirm, "field 'mConfirm'", TextView.class);
        this.f18276c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(loginActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.login_change, "field 'mLoginChange' and method 'onViewClicked'");
        loginActivity.mLoginChange = (TextView) Utils.castView(viewFindRequiredView3, R.id.login_change, "field 'mLoginChange'", TextView.class);
        this.f18277d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(loginActivity));
        loginActivity.mClause = (TextView) Utils.findRequiredViewAsType(view, R.id.clause, "field 'mClause'", TextView.class);
        loginActivity.mTCbSelect = (CheckBox) Utils.findRequiredViewAsType(view, R.id.cb_select, "field 'mTCbSelect'", CheckBox.class);
        loginActivity.mPwdGroup = (Group) Utils.findRequiredViewAsType(view, R.id.pwd_group, "field 'mPwdGroup'", Group.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.forget_pwd, "field 'mForgetPwd' and method 'onViewClicked'");
        loginActivity.mForgetPwd = (TextView) Utils.castView(viewFindRequiredView4, R.id.forget_pwd, "field 'mForgetPwd'", TextView.class);
        this.f18278e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(loginActivity));
        loginActivity.mLineV = Utils.findRequiredView(view, R.id.line_v, "field 'mLineV'");
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.iv_wx_login, "method 'onViewClicked'");
        this.f18279f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(loginActivity));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.iv_qq_login, "method 'onViewClicked'");
        this.f18280g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(loginActivity));
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.iv_sina_login, "method 'onViewClicked'");
        this.f18281h = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new g(loginActivity));
    }
}
