package ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bean.SurveyAppBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import ui.view.swip.SwipBackLayout;

/* compiled from: SignAppDetailActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010N\u001a\u00020OH\u0016J\u0006\u0010P\u001a\u00020OJ\u0010\u0010Q\u001a\u00020O2\u0006\u0010R\u001a\u00020\u001cH\u0007J\b\u0010S\u001a\u00020TH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001e\u0010$\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001e\u0010'\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 R\u001e\u0010*\u001a\u00020+8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u00100\u001a\u00020+8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R\u001e\u00103\u001a\u00020+8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010-\"\u0004\b5\u0010/R\u001e\u00106\u001a\u00020+8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010-\"\u0004\b8\u0010/R\u001e\u00109\u001a\u00020:8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001e\u0010?\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0012\"\u0004\bA\u0010\u0014R\u001e\u0010B\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0012\"\u0004\bD\u0010\u0014R\u001e\u0010E\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0012\"\u0004\bG\u0010\u0014R\u001e\u0010H\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0012\"\u0004\bJ\u0010\u0014R\u001e\u0010K\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0012\"\u0004\bM\u0010\u0014¨\u0006U"}, d2 = {"Lui/activity/SignAppDetailActivity;", "Lui/activity/BaseActivity;", "()V", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "mAppBean", "Lbean/SurveyAppBean;", "getMAppBean", "()Lbean/SurveyAppBean;", "setMAppBean", "(Lbean/SurveyAppBean;)V", "mEtInvitationCode", "Landroid/widget/TextView;", "getMEtInvitationCode", "()Landroid/widget/TextView;", "setMEtInvitationCode", "(Landroid/widget/TextView;)V", "mEtVictimAccount", "getMEtVictimAccount", "setMEtVictimAccount", "mEtVictimPwd", "getMEtVictimPwd", "setMEtVictimPwd", "mFlAppInfo", "Landroid/view/View;", "getMFlAppInfo", "()Landroid/view/View;", "setMFlAppInfo", "(Landroid/view/View;)V", "mFlAppLogo", "getMFlAppLogo", "setMFlAppLogo", "mFlAppMnInfo", "getMFlAppMnInfo", "setMFlAppMnInfo", "mFlAppZxing", "getMFlAppZxing", "setMFlAppZxing", "mIvAppIcon", "Landroid/widget/ImageView;", "getMIvAppIcon", "()Landroid/widget/ImageView;", "setMIvAppIcon", "(Landroid/widget/ImageView;)V", "mIvAppLogo", "getMIvAppLogo", "setMIvAppLogo", "mIvAppZxing", "getMIvAppZxing", "setMIvAppZxing", "mIvBack", "getMIvBack", "setMIvBack", "mLlInvitationCode", "Landroid/widget/LinearLayout;", "getMLlInvitationCode", "()Landroid/widget/LinearLayout;", "setMLlInvitationCode", "(Landroid/widget/LinearLayout;)V", "mTvAppName", "getMTvAppName", "setMTvAppName", "mTvAppNameMn", "getMTvAppNameMn", "setMTvAppNameMn", "mTvAppPkg", "getMTvAppPkg", "setMTvAppPkg", "mTvAppVers", "getMTvAppVers", "setMTvAppVers", "mTvTitle", "getMTvTitle", "setMTvTitle", "initPage", "", "initViewData", "onClick", "view", "setLayoutView", "", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SignAppDetailActivity extends BaseActivity {

    /* renamed from: a, reason: collision with root package name */
    @i.c.a.e
    private SurveyAppBean f18906a;

    /* renamed from: b, reason: collision with root package name */
    @i.c.a.d
    private String f18907b = "";

    @BindView(R.id.et_app_invitationCode)
    @i.c.a.d
    public TextView mEtInvitationCode;

    @BindView(R.id.et_app_victimAccount)
    @i.c.a.d
    public TextView mEtVictimAccount;

    @BindView(R.id.et_app_victimPwd)
    @i.c.a.d
    public TextView mEtVictimPwd;

    @BindView(R.id.fl_app_view)
    @i.c.a.d
    public View mFlAppInfo;

    @BindView(R.id.fl_app_logo)
    @i.c.a.d
    public View mFlAppLogo;

    @BindView(R.id.fl_app_mini)
    @i.c.a.d
    public View mFlAppMnInfo;

    @BindView(R.id.fl_app_zxing)
    @i.c.a.d
    public View mFlAppZxing;

    @BindView(R.id.iv_app_icon)
    @i.c.a.d
    public ImageView mIvAppIcon;

    @BindView(R.id.iv_app_logo)
    @i.c.a.d
    public ImageView mIvAppLogo;

    @BindView(R.id.iv_zxing)
    @i.c.a.d
    public ImageView mIvAppZxing;

    @BindView(R.id.iv_back)
    @i.c.a.d
    public ImageView mIvBack;

    @BindView(R.id.ll_invitationCode)
    @i.c.a.d
    public LinearLayout mLlInvitationCode;

    @BindView(R.id.tv_app_name)
    @i.c.a.d
    public TextView mTvAppName;

    @BindView(R.id.tv_app_name_mini)
    @i.c.a.d
    public TextView mTvAppNameMn;

    @BindView(R.id.tv_app_pkg)
    @i.c.a.d
    public TextView mTvAppPkg;

    @BindView(R.id.tv_app_vers)
    @i.c.a.d
    public TextView mTvAppVers;

    @BindView(R.id.tv_title)
    @i.c.a.d
    public TextView mTvTitle;

    public final void a(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvAppZxing = imageView;
    }

    @i.c.a.d
    public final View b() {
        View view = this.mFlAppMnInfo;
        if (view == null) {
            h.q2.t.i0.k("mFlAppMnInfo");
        }
        return view;
    }

    @i.c.a.d
    public final ImageView c() {
        ImageView imageView = this.mIvAppZxing;
        if (imageView == null) {
            h.q2.t.i0.k("mIvAppZxing");
        }
        return imageView;
    }

    public final void d(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvAppNameMn = textView;
    }

    @i.c.a.d
    public final TextView e() {
        TextView textView = this.mTvAppNameMn;
        if (textView == null) {
            h.q2.t.i0.k("mTvAppNameMn");
        }
        return textView;
    }

    @i.c.a.d
    public final String getCaseInfoId() {
        return this.f18907b;
    }

    @i.c.a.e
    public final SurveyAppBean getMAppBean() {
        return this.f18906a;
    }

    @i.c.a.d
    public final TextView getMEtInvitationCode() {
        TextView textView = this.mEtInvitationCode;
        if (textView == null) {
            h.q2.t.i0.k("mEtInvitationCode");
        }
        return textView;
    }

    @i.c.a.d
    public final TextView getMEtVictimAccount() {
        TextView textView = this.mEtVictimAccount;
        if (textView == null) {
            h.q2.t.i0.k("mEtVictimAccount");
        }
        return textView;
    }

    @i.c.a.d
    public final TextView getMEtVictimPwd() {
        TextView textView = this.mEtVictimPwd;
        if (textView == null) {
            h.q2.t.i0.k("mEtVictimPwd");
        }
        return textView;
    }

    @i.c.a.d
    public final View getMFlAppInfo() {
        View view = this.mFlAppInfo;
        if (view == null) {
            h.q2.t.i0.k("mFlAppInfo");
        }
        return view;
    }

    @i.c.a.d
    public final View getMFlAppZxing() {
        View view = this.mFlAppZxing;
        if (view == null) {
            h.q2.t.i0.k("mFlAppZxing");
        }
        return view;
    }

    @i.c.a.d
    public final ImageView getMIvAppIcon() {
        ImageView imageView = this.mIvAppIcon;
        if (imageView == null) {
            h.q2.t.i0.k("mIvAppIcon");
        }
        return imageView;
    }

    @i.c.a.d
    public final ImageView getMIvAppLogo() {
        ImageView imageView = this.mIvAppLogo;
        if (imageView == null) {
            h.q2.t.i0.k("mIvAppLogo");
        }
        return imageView;
    }

    @i.c.a.d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            h.q2.t.i0.k("mIvBack");
        }
        return imageView;
    }

    @i.c.a.d
    public final TextView getMTvAppName() {
        TextView textView = this.mTvAppName;
        if (textView == null) {
            h.q2.t.i0.k("mTvAppName");
        }
        return textView;
    }

    @i.c.a.d
    public final TextView getMTvAppPkg() {
        TextView textView = this.mTvAppPkg;
        if (textView == null) {
            h.q2.t.i0.k("mTvAppPkg");
        }
        return textView;
    }

    @i.c.a.d
    public final TextView getMTvAppVers() {
        TextView textView = this.mTvAppVers;
        if (textView == null) {
            h.q2.t.i0.k("mTvAppVers");
        }
        return textView;
    }

    @i.c.a.d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        return textView;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        textView.setText("APP信息");
        initViewData();
    }

    public final void initViewData() {
        this.f18906a = (SurveyAppBean) getIntent().getSerializableExtra(util.k1.f20845c);
        String stringExtra = getIntent().getStringExtra(util.k1.C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.f18907b = stringExtra;
        SurveyAppBean surveyAppBean = this.f18906a;
        if (surveyAppBean != null) {
            if (TextUtils.isEmpty(surveyAppBean != null ? surveyAppBean.getPackageFileUrl() : null)) {
                View view = this.mFlAppInfo;
                if (view == null) {
                    h.q2.t.i0.k("mFlAppInfo");
                }
                view.setVisibility(8);
                View view2 = this.mFlAppMnInfo;
                if (view2 == null) {
                    h.q2.t.i0.k("mFlAppMnInfo");
                }
                view2.setVisibility(0);
                TextView textView = this.mTvAppNameMn;
                if (textView == null) {
                    h.q2.t.i0.k("mTvAppNameMn");
                }
                SurveyAppBean surveyAppBean2 = this.f18906a;
                textView.setText(surveyAppBean2 != null ? surveyAppBean2.getAppName() : null);
            } else {
                View view3 = this.mFlAppInfo;
                if (view3 == null) {
                    h.q2.t.i0.k("mFlAppInfo");
                }
                view3.setVisibility(0);
                View view4 = this.mFlAppMnInfo;
                if (view4 == null) {
                    h.q2.t.i0.k("mFlAppMnInfo");
                }
                view4.setVisibility(8);
                TextView textView2 = this.mTvAppName;
                if (textView2 == null) {
                    h.q2.t.i0.k("mTvAppName");
                }
                SurveyAppBean surveyAppBean3 = this.f18906a;
                textView2.setText(surveyAppBean3 != null ? surveyAppBean3.getAppName() : null);
                TextView textView3 = this.mTvAppVers;
                if (textView3 == null) {
                    h.q2.t.i0.k("mTvAppVers");
                }
                SurveyAppBean surveyAppBean4 = this.f18906a;
                textView3.setText(surveyAppBean4 != null ? surveyAppBean4.getAppVersion() : null);
                TextView textView4 = this.mTvAppPkg;
                if (textView4 == null) {
                    h.q2.t.i0.k("mTvAppPkg");
                }
                SurveyAppBean surveyAppBean5 = this.f18906a;
                textView4.setText(surveyAppBean5 != null ? surveyAppBean5.getPackageName() : null);
                SurveyAppBean surveyAppBean6 = this.f18906a;
                String appName = surveyAppBean6 != null ? surveyAppBean6.getAppName() : null;
                SurveyAppBean surveyAppBean7 = this.f18906a;
                Bitmap bitmapA = j.c.a(appName, surveyAppBean7 != null ? surveyAppBean7.getAppVersion() : null, j.c.f17008f);
                ImageView imageView = this.mIvAppIcon;
                if (imageView == null) {
                    h.q2.t.i0.k("mIvAppIcon");
                }
                imageView.setImageBitmap(bitmapA);
            }
            SurveyAppBean surveyAppBean8 = this.f18906a;
            if (TextUtils.isEmpty(surveyAppBean8 != null ? surveyAppBean8.getAppLogoFileUrl() : null)) {
                View view5 = this.mFlAppLogo;
                if (view5 == null) {
                    h.q2.t.i0.k("mFlAppLogo");
                }
                view5.setVisibility(8);
            } else {
                View view6 = this.mFlAppLogo;
                if (view6 == null) {
                    h.q2.t.i0.k("mFlAppLogo");
                }
                view6.setVisibility(0);
                ImageView imageView2 = this.mIvAppLogo;
                if (imageView2 == null) {
                    h.q2.t.i0.k("mIvAppLogo");
                }
                SurveyAppBean surveyAppBean9 = this.f18906a;
                j.d.b(imageView2, surveyAppBean9 != null ? surveyAppBean9.getAppLogoFileUrl() : null);
            }
            SurveyAppBean surveyAppBean10 = this.f18906a;
            if (TextUtils.isEmpty(surveyAppBean10 != null ? surveyAppBean10.getQrCodeFileUrl() : null)) {
                View view7 = this.mFlAppZxing;
                if (view7 == null) {
                    h.q2.t.i0.k("mFlAppZxing");
                }
                view7.setVisibility(8);
            } else {
                View view8 = this.mFlAppZxing;
                if (view8 == null) {
                    h.q2.t.i0.k("mFlAppZxing");
                }
                view8.setVisibility(0);
                ImageView imageView3 = this.mIvAppZxing;
                if (imageView3 == null) {
                    h.q2.t.i0.k("mIvAppZxing");
                }
                SurveyAppBean surveyAppBean11 = this.f18906a;
                j.d.b(imageView3, surveyAppBean11 != null ? surveyAppBean11.getQrCodeFileUrl() : null);
            }
            SurveyAppBean surveyAppBean12 = this.f18906a;
            if (!TextUtils.isEmpty(surveyAppBean12 != null ? surveyAppBean12.getVictimAccount() : null)) {
                TextView textView5 = this.mEtVictimAccount;
                if (textView5 == null) {
                    h.q2.t.i0.k("mEtVictimAccount");
                }
                SurveyAppBean surveyAppBean13 = this.f18906a;
                textView5.setText(surveyAppBean13 != null ? surveyAppBean13.getVictimAccount() : null);
            }
            SurveyAppBean surveyAppBean14 = this.f18906a;
            if (!TextUtils.isEmpty(surveyAppBean14 != null ? surveyAppBean14.getVictimPwd() : null)) {
                TextView textView6 = this.mEtVictimPwd;
                if (textView6 == null) {
                    h.q2.t.i0.k("mEtVictimPwd");
                }
                SurveyAppBean surveyAppBean15 = this.f18906a;
                textView6.setText(surveyAppBean15 != null ? surveyAppBean15.getVictimPwd() : null);
            }
            SurveyAppBean surveyAppBean16 = this.f18906a;
            if (!TextUtils.isEmpty(surveyAppBean16 != null ? surveyAppBean16.getInvitationCode() : null)) {
                TextView textView7 = this.mEtInvitationCode;
                if (textView7 == null) {
                    h.q2.t.i0.k("mEtInvitationCode");
                }
                SurveyAppBean surveyAppBean17 = this.f18906a;
                textView7.setText(surveyAppBean17 != null ? surveyAppBean17.getInvitationCode() : null);
                return;
            }
            LinearLayout linearLayout = this.mLlInvitationCode;
            if (linearLayout == null) {
                h.q2.t.i0.k("mLlInvitationCode");
            }
            linearLayout.setVisibility(8);
            TextView textView8 = this.mEtInvitationCode;
            if (textView8 == null) {
                h.q2.t.i0.k("mEtInvitationCode");
            }
            textView8.setVisibility(8);
        }
    }

    @OnClick({R.id.iv_back, R.id.iv_zxing, R.id.iv_app_logo})
    public final void onClick(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.iv_app_logo) {
            Intent intent = new Intent(this, (Class<?>) PreviewPictureActivity.class);
            SurveyAppBean surveyAppBean = this.f18906a;
            intent.putExtra(PreviewPictureActivity.f18542i, surveyAppBean != null ? surveyAppBean.getAppLogoFileUrl() : null);
            startActivity(intent);
            return;
        }
        if (id == R.id.iv_back) {
            onBackPressed();
        } else {
            if (id != R.id.iv_zxing) {
                return;
            }
            Intent intent2 = new Intent(this, (Class<?>) PreviewPictureActivity.class);
            SurveyAppBean surveyAppBean2 = this.f18906a;
            intent2.putExtra(PreviewPictureActivity.f18542i, surveyAppBean2 != null ? surveyAppBean2.getQrCodeFileUrl() : null);
            startActivity(intent2);
        }
    }

    public final void setCaseInfoId(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "<set-?>");
        this.f18907b = str;
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_sign_app_detial;
    }

    public final void setMAppBean(@i.c.a.e SurveyAppBean surveyAppBean) {
        this.f18906a = surveyAppBean;
    }

    public final void setMFlAppInfo(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "<set-?>");
        this.mFlAppInfo = view;
    }

    public final void setMFlAppLogo(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "<set-?>");
        this.mFlAppLogo = view;
    }

    public final void setMFlAppMnInfo(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "<set-?>");
        this.mFlAppMnInfo = view;
    }

    public final void setMFlAppZxing(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "<set-?>");
        this.mFlAppZxing = view;
    }

    public final void setMIvAppIcon(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvAppIcon = imageView;
    }

    public final void setMIvAppLogo(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvAppLogo = imageView;
    }

    public final void setMIvBack(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMTvAppName(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvAppName = textView;
    }

    public final void setMTvAppPkg(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvAppPkg = textView;
    }

    public final void setMTvAppVers(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvAppVers = textView;
    }

    public final void setMTvTitle(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    @i.c.a.d
    public final View a() {
        View view = this.mFlAppLogo;
        if (view == null) {
            h.q2.t.i0.k("mFlAppLogo");
        }
        return view;
    }

    public final void b(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mEtVictimAccount = textView;
    }

    public final void c(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mEtVictimPwd = textView;
    }

    @i.c.a.d
    public final LinearLayout d() {
        LinearLayout linearLayout = this.mLlInvitationCode;
        if (linearLayout == null) {
            h.q2.t.i0.k("mLlInvitationCode");
        }
        return linearLayout;
    }

    public final void a(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mEtInvitationCode = textView;
    }

    public final void a(@i.c.a.d LinearLayout linearLayout) {
        h.q2.t.i0.f(linearLayout, "<set-?>");
        this.mLlInvitationCode = linearLayout;
    }
}
