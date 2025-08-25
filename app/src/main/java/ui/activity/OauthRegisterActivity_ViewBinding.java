package ui.activity;

import android.view.View;
import android.widget.CheckBox;
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
public class OauthRegisterActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private OauthRegisterActivity f18425a;

    /* renamed from: b, reason: collision with root package name */
    private View f18426b;

    /* renamed from: c, reason: collision with root package name */
    private View f18427c;

    /* renamed from: d, reason: collision with root package name */
    private View f18428d;

    /* renamed from: e, reason: collision with root package name */
    private View f18429e;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OauthRegisterActivity f18430a;

        a(OauthRegisterActivity oauthRegisterActivity) {
            this.f18430a = oauthRegisterActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18430a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OauthRegisterActivity f18432a;

        b(OauthRegisterActivity oauthRegisterActivity) {
            this.f18432a = oauthRegisterActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18432a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OauthRegisterActivity f18434a;

        c(OauthRegisterActivity oauthRegisterActivity) {
            this.f18434a = oauthRegisterActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18434a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OauthRegisterActivity f18436a;

        d(OauthRegisterActivity oauthRegisterActivity) {
            this.f18436a = oauthRegisterActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18436a.onViewClicked(view);
        }
    }

    @UiThread
    public OauthRegisterActivity_ViewBinding(OauthRegisterActivity oauthRegisterActivity) {
        this(oauthRegisterActivity, oauthRegisterActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        OauthRegisterActivity oauthRegisterActivity = this.f18425a;
        if (oauthRegisterActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18425a = null;
        oauthRegisterActivity.mUserCode = null;
        oauthRegisterActivity.mConfirm = null;
        oauthRegisterActivity.mClause = null;
        oauthRegisterActivity.mTCbSelect = null;
        oauthRegisterActivity.mAccount = null;
        oauthRegisterActivity.mIvClean = null;
        oauthRegisterActivity.mTvReset = null;
        this.f18426b.setOnClickListener(null);
        this.f18426b = null;
        this.f18427c.setOnClickListener(null);
        this.f18427c = null;
        this.f18428d.setOnClickListener(null);
        this.f18428d = null;
        this.f18429e.setOnClickListener(null);
        this.f18429e = null;
    }

    @UiThread
    public OauthRegisterActivity_ViewBinding(OauthRegisterActivity oauthRegisterActivity, View view) {
        this.f18425a = oauthRegisterActivity;
        oauthRegisterActivity.mUserCode = (EditText) Utils.findRequiredViewAsType(view, R.id.user_code, "field 'mUserCode'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.confirm, "field 'mConfirm' and method 'onViewClicked'");
        oauthRegisterActivity.mConfirm = (TextView) Utils.castView(viewFindRequiredView, R.id.confirm, "field 'mConfirm'", TextView.class);
        this.f18426b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(oauthRegisterActivity));
        oauthRegisterActivity.mClause = (TextView) Utils.findRequiredViewAsType(view, R.id.clause, "field 'mClause'", TextView.class);
        oauthRegisterActivity.mTCbSelect = (CheckBox) Utils.findRequiredViewAsType(view, R.id.cb_select, "field 'mTCbSelect'", CheckBox.class);
        oauthRegisterActivity.mAccount = (EditText) Utils.findRequiredViewAsType(view, R.id.account, "field 'mAccount'", EditText.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_clear, "field 'mIvClean' and method 'onViewClicked'");
        oauthRegisterActivity.mIvClean = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_clear, "field 'mIvClean'", ImageView.class);
        this.f18427c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(oauthRegisterActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_resend, "field 'mTvReset' and method 'onViewClicked'");
        oauthRegisterActivity.mTvReset = (CodeCutTimeTextView) Utils.castView(viewFindRequiredView3, R.id.tv_resend, "field 'mTvReset'", CodeCutTimeTextView.class);
        this.f18428d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(oauthRegisterActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18429e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(oauthRegisterActivity));
    }
}
