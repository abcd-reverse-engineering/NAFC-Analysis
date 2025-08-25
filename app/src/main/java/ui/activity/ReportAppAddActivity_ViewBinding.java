package ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.core.widget.NestedScrollView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import ui.view.SwitchButton;

/* loaded from: classes2.dex */
public final class ReportAppAddActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private ReportAppAddActivity f18680a;

    @UiThread
    public ReportAppAddActivity_ViewBinding(ReportAppAddActivity reportAppAddActivity) {
        this(reportAppAddActivity, reportAppAddActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReportAppAddActivity reportAppAddActivity = this.f18680a;
        if (reportAppAddActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18680a = null;
        reportAppAddActivity.mIvBack = null;
        reportAppAddActivity.mTvTitle = null;
        reportAppAddActivity.mTvAddApp = null;
        reportAppAddActivity.mFlAppInfo = null;
        reportAppAddActivity.mSwitchApp = null;
        reportAppAddActivity.mLlAddAppName = null;
        reportAppAddActivity.mLlAddAppLogo = null;
        reportAppAddActivity.mEtAppName = null;
        reportAppAddActivity.mIvAppLogo = null;
        reportAppAddActivity.mTvAppName = null;
        reportAppAddActivity.mTvAppPkg = null;
        reportAppAddActivity.mTvAppVers = null;
        reportAppAddActivity.mIvAppIcon = null;
        reportAppAddActivity.mSwitchZxing = null;
        reportAppAddActivity.mFlAppZxing = null;
        reportAppAddActivity.mIvAppZxingPic = null;
        reportAppAddActivity.mEtVictimAccount = null;
        reportAppAddActivity.mEtVictimPwd = null;
        reportAppAddActivity.mEtInvitationCode = null;
        reportAppAddActivity.mBtnCommit = null;
        reportAppAddActivity.scrollView = null;
    }

    @UiThread
    public ReportAppAddActivity_ViewBinding(ReportAppAddActivity reportAppAddActivity, View view) {
        this.f18680a = reportAppAddActivity;
        reportAppAddActivity.mIvBack = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_back, "field 'mIvBack'", ImageView.class);
        reportAppAddActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        reportAppAddActivity.mTvAddApp = Utils.findRequiredView(view, R.id.fl_add_app, "field 'mTvAddApp'");
        reportAppAddActivity.mFlAppInfo = Utils.findRequiredView(view, R.id.fl_app_view, "field 'mFlAppInfo'");
        reportAppAddActivity.mSwitchApp = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.switchShow_app, "field 'mSwitchApp'", SwitchButton.class);
        reportAppAddActivity.mLlAddAppName = Utils.findRequiredView(view, R.id.fl_add_name, "field 'mLlAddAppName'");
        reportAppAddActivity.mLlAddAppLogo = Utils.findRequiredView(view, R.id.fl_app_logo, "field 'mLlAddAppLogo'");
        reportAppAddActivity.mEtAppName = (EditText) Utils.findRequiredViewAsType(view, R.id.et_app_name, "field 'mEtAppName'", EditText.class);
        reportAppAddActivity.mIvAppLogo = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_add_logo, "field 'mIvAppLogo'", ImageView.class);
        reportAppAddActivity.mTvAppName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_app_name, "field 'mTvAppName'", TextView.class);
        reportAppAddActivity.mTvAppPkg = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_app_pkg, "field 'mTvAppPkg'", TextView.class);
        reportAppAddActivity.mTvAppVers = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_app_vers, "field 'mTvAppVers'", TextView.class);
        reportAppAddActivity.mIvAppIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_icon, "field 'mIvAppIcon'", ImageView.class);
        reportAppAddActivity.mSwitchZxing = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.switchShow_zxing, "field 'mSwitchZxing'", SwitchButton.class);
        reportAppAddActivity.mFlAppZxing = Utils.findRequiredView(view, R.id.fl_app_zxing, "field 'mFlAppZxing'");
        reportAppAddActivity.mIvAppZxingPic = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_add_zxing, "field 'mIvAppZxingPic'", ImageView.class);
        reportAppAddActivity.mEtVictimAccount = (EditText) Utils.findRequiredViewAsType(view, R.id.et_app_victimAccount, "field 'mEtVictimAccount'", EditText.class);
        reportAppAddActivity.mEtVictimPwd = (EditText) Utils.findRequiredViewAsType(view, R.id.et_app_victimPwd, "field 'mEtVictimPwd'", EditText.class);
        reportAppAddActivity.mEtInvitationCode = (EditText) Utils.findRequiredViewAsType(view, R.id.et_app_invitationCode, "field 'mEtInvitationCode'", EditText.class);
        reportAppAddActivity.mBtnCommit = (Button) Utils.findRequiredViewAsType(view, R.id.btn_commit, "field 'mBtnCommit'", Button.class);
        reportAppAddActivity.scrollView = (NestedScrollView) Utils.findRequiredViewAsType(view, R.id.scrollView, "field 'scrollView'", NestedScrollView.class);
    }
}
