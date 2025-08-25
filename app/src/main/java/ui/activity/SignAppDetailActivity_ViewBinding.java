package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public final class SignAppDetailActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private SignAppDetailActivity f18908a;

    /* renamed from: b, reason: collision with root package name */
    private View f18909b;

    /* renamed from: c, reason: collision with root package name */
    private View f18910c;

    /* renamed from: d, reason: collision with root package name */
    private View f18911d;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SignAppDetailActivity f18912a;

        a(SignAppDetailActivity signAppDetailActivity) {
            this.f18912a = signAppDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18912a.onClick(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SignAppDetailActivity f18914a;

        b(SignAppDetailActivity signAppDetailActivity) {
            this.f18914a = signAppDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18914a.onClick(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SignAppDetailActivity f18916a;

        c(SignAppDetailActivity signAppDetailActivity) {
            this.f18916a = signAppDetailActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18916a.onClick(view);
        }
    }

    @UiThread
    public SignAppDetailActivity_ViewBinding(SignAppDetailActivity signAppDetailActivity) {
        this(signAppDetailActivity, signAppDetailActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignAppDetailActivity signAppDetailActivity = this.f18908a;
        if (signAppDetailActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18908a = null;
        signAppDetailActivity.mIvBack = null;
        signAppDetailActivity.mTvTitle = null;
        signAppDetailActivity.mFlAppInfo = null;
        signAppDetailActivity.mTvAppName = null;
        signAppDetailActivity.mTvAppPkg = null;
        signAppDetailActivity.mTvAppVers = null;
        signAppDetailActivity.mIvAppIcon = null;
        signAppDetailActivity.mFlAppMnInfo = null;
        signAppDetailActivity.mTvAppNameMn = null;
        signAppDetailActivity.mFlAppZxing = null;
        signAppDetailActivity.mIvAppZxing = null;
        signAppDetailActivity.mFlAppLogo = null;
        signAppDetailActivity.mIvAppLogo = null;
        signAppDetailActivity.mEtVictimAccount = null;
        signAppDetailActivity.mEtVictimPwd = null;
        signAppDetailActivity.mEtInvitationCode = null;
        signAppDetailActivity.mLlInvitationCode = null;
        this.f18909b.setOnClickListener(null);
        this.f18909b = null;
        this.f18910c.setOnClickListener(null);
        this.f18910c = null;
        this.f18911d.setOnClickListener(null);
        this.f18911d = null;
    }

    @UiThread
    public SignAppDetailActivity_ViewBinding(SignAppDetailActivity signAppDetailActivity, View view) {
        this.f18908a = signAppDetailActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'mIvBack' and method 'onClick'");
        signAppDetailActivity.mIvBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        this.f18909b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(signAppDetailActivity));
        signAppDetailActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        signAppDetailActivity.mFlAppInfo = Utils.findRequiredView(view, R.id.fl_app_view, "field 'mFlAppInfo'");
        signAppDetailActivity.mTvAppName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_app_name, "field 'mTvAppName'", TextView.class);
        signAppDetailActivity.mTvAppPkg = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_app_pkg, "field 'mTvAppPkg'", TextView.class);
        signAppDetailActivity.mTvAppVers = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_app_vers, "field 'mTvAppVers'", TextView.class);
        signAppDetailActivity.mIvAppIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_app_icon, "field 'mIvAppIcon'", ImageView.class);
        signAppDetailActivity.mFlAppMnInfo = Utils.findRequiredView(view, R.id.fl_app_mini, "field 'mFlAppMnInfo'");
        signAppDetailActivity.mTvAppNameMn = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_app_name_mini, "field 'mTvAppNameMn'", TextView.class);
        signAppDetailActivity.mFlAppZxing = Utils.findRequiredView(view, R.id.fl_app_zxing, "field 'mFlAppZxing'");
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_zxing, "field 'mIvAppZxing' and method 'onClick'");
        signAppDetailActivity.mIvAppZxing = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_zxing, "field 'mIvAppZxing'", ImageView.class);
        this.f18910c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(signAppDetailActivity));
        signAppDetailActivity.mFlAppLogo = Utils.findRequiredView(view, R.id.fl_app_logo, "field 'mFlAppLogo'");
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.iv_app_logo, "field 'mIvAppLogo' and method 'onClick'");
        signAppDetailActivity.mIvAppLogo = (ImageView) Utils.castView(viewFindRequiredView3, R.id.iv_app_logo, "field 'mIvAppLogo'", ImageView.class);
        this.f18911d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(signAppDetailActivity));
        signAppDetailActivity.mEtVictimAccount = (TextView) Utils.findRequiredViewAsType(view, R.id.et_app_victimAccount, "field 'mEtVictimAccount'", TextView.class);
        signAppDetailActivity.mEtVictimPwd = (TextView) Utils.findRequiredViewAsType(view, R.id.et_app_victimPwd, "field 'mEtVictimPwd'", TextView.class);
        signAppDetailActivity.mEtInvitationCode = (TextView) Utils.findRequiredViewAsType(view, R.id.et_app_invitationCode, "field 'mEtInvitationCode'", TextView.class);
        signAppDetailActivity.mLlInvitationCode = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_invitationCode, "field 'mLlInvitationCode'", LinearLayout.class);
    }
}
