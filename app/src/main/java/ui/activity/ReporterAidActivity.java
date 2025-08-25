package ui.activity;

import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import bean.ReportIDInfoBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IClickListener;
import interfaces.PermissionsListener;
import java.util.List;
import network.http.StatisticsHttp;
import ui.callview.ReportIDInfoView;
import ui.presenter.SurveyReportPresenter;
import ui.view.swip.SwipBackLayout;
import zxing.android.CaptureActivity;

/* compiled from: ReporterAidActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020,H\u0002J\u0006\u00102\u001a\u00020,J\b\u00103\u001a\u00020,H\u0016J\"\u00104\u001a\u00020,2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002062\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0010\u0010:\u001a\u00020,2\u0006\u0010;\u001a\u00020<H\u0007J\b\u0010=\u001a\u00020,H\u0014J\u0010\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u000206H\u0016J\b\u0010@\u001a\u00020,H\u0016J\b\u0010A\u001a\u00020,H\u0016J\b\u0010B\u001a\u000206H\u0016J\b\u0010C\u001a\u00020,H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006D"}, d2 = {"Lui/activity/ReporterAidActivity;", "Lui/activity/BaseActivity;", "Lui/callview/ReportIDInfoView;", "()V", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mPresent", "Lui/presenter/SurveyReportPresenter;", "getMPresent", "()Lui/presenter/SurveyReportPresenter;", "setMPresent", "(Lui/presenter/SurveyReportPresenter;)V", "mRedDot", "getMRedDot", "setMRedDot", "mTCbSelect", "Landroid/widget/CheckBox;", "getMTCbSelect", "()Landroid/widget/CheckBox;", "setMTCbSelect", "(Landroid/widget/CheckBox;)V", "mTvTitle", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "reportIDBean", "Lbean/ReportIDInfoBean;", "getReportIDBean", "()Lbean/ReportIDInfoBean;", "setReportIDBean", "(Lbean/ReportIDInfoBean;)V", "ReportIDInfoBean", "", "result", "camerPrimssDlg", "isNeverAsk", "", "goScan", "initListener", "initPage", "onActivityResult", "requestCode", "", com.taobao.agoo.a.a.b.JSON_ERRORCODE, "data", "Landroid/content/Intent;", "onClick", "view", "Landroid/view/View;", "onResume", "onSuccessCaseNum", "num", "onfailCaseNum", "onsuccessReportID", "setLayoutView", "varCamerPrims", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class ReporterAidActivity extends BaseActivity implements ReportIDInfoView {

    @i.c.a.e
    private String caseInfoId;

    @BindView(R.id.iv_back)
    @i.c.a.d
    public ImageView mIvBack;

    @i.c.a.e
    private SurveyReportPresenter mPresent;

    @BindView(R.id.iv_red_dot)
    @i.c.a.d
    public ImageView mRedDot;

    @BindView(R.id.cb_select)
    @i.c.a.d
    public CheckBox mTCbSelect;

    @BindView(R.id.tv_title)
    @i.c.a.d
    public TextView mTvTitle;

    @i.c.a.e
    private ReportIDInfoBean reportIDBean;

    /* compiled from: ReporterAidActivity.kt */
    public static final class a implements IClickListener {
        a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            SurveyReportPresenter mPresent = ReporterAidActivity.this.getMPresent();
            if (mPresent != null) {
                mPresent.ConfirmCaseInfoById(ReporterAidActivity.this.getCaseInfoId());
            }
        }
    }

    /* compiled from: ReporterAidActivity.kt */
    public static final class b implements IClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f18831b;

        b(boolean z) {
            this.f18831b = z;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            if (this.f18831b) {
                util.k1.j(ReporterAidActivity.this.mActivity);
            } else {
                ReporterAidActivity.this.varCamerPrims();
            }
        }
    }

    /* compiled from: ReporterAidActivity.kt */
    static final class c implements CompoundButton.OnCheckedChangeListener {
        c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            ReporterAidActivity.this.getMTCbSelect().setChecked(z);
        }
    }

    /* compiled from: ReporterAidActivity.kt */
    public static final class d implements PermissionsListener {
        d() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(@i.c.a.d List<String> list, boolean z) {
            h.q2.t.i0.f(list, "deniedPermissions");
            ReporterAidActivity.this.camerPrimssDlg(z);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            if (!h.q2.t.i0.a((Object) "vivo", (Object) Build.BRAND) || Build.VERSION.SDK_INT != 23) {
                ReporterAidActivity.this.goScan();
            } else if (util.permissionutil.c.f()) {
                ReporterAidActivity.this.goScan();
            } else {
                ReporterAidActivity.this.camerPrimssDlg(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void camerPrimssDlg(boolean z) {
        util.b1.f(this.mActivity, "权限开启", "国家反诈中心未取得权限，这样会导致此功能无法使用。", "取消", "去授权", new b(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void goScan() {
        startActivityForResult(new Intent(this.mActivity, (Class<?>) CaptureActivity.class), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void varCamerPrims() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.f20909c}, new d());
    }

    @Override // ui.callview.ReportIDInfoView
    public void ReportIDInfoBean(@i.c.a.e ReportIDInfoBean reportIDInfoBean) {
        this.reportIDBean = reportIDInfoBean;
        util.b1.d(this.mActivity, reportIDInfoBean != null ? reportIDInfoBean.getCaseName() : null, reportIDInfoBean != null ? reportIDInfoBean.getProcessTime() : null, reportIDInfoBean != null ? reportIDInfoBean.getCaseNumber() : null, reportIDInfoBean != null ? reportIDInfoBean.getCaseCategoryText() : null, new a());
    }

    @i.c.a.e
    public final String getCaseInfoId() {
        return this.caseInfoId;
    }

    @i.c.a.d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            h.q2.t.i0.k("mIvBack");
        }
        return imageView;
    }

    @i.c.a.e
    public final SurveyReportPresenter getMPresent() {
        return this.mPresent;
    }

    @i.c.a.d
    public final ImageView getMRedDot() {
        ImageView imageView = this.mRedDot;
        if (imageView == null) {
            h.q2.t.i0.k("mRedDot");
        }
        return imageView;
    }

    @i.c.a.d
    public final CheckBox getMTCbSelect() {
        CheckBox checkBox = this.mTCbSelect;
        if (checkBox == null) {
            h.q2.t.i0.k("mTCbSelect");
        }
        return checkBox;
    }

    @i.c.a.d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        return textView;
    }

    @i.c.a.e
    public final ReportIDInfoBean getReportIDBean() {
        return this.reportIDBean;
    }

    public final void initListener() {
        this.mPresent = new SurveyReportPresenter(this, this);
        CheckBox checkBox = this.mTCbSelect;
        if (checkBox == null) {
            h.q2.t.i0.k("mTCbSelect");
        }
        checkBox.setOnCheckedChangeListener(new c());
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        StatisticsHttp.getInstance().pageOpenHttp(e.d.f13595m);
        SwipBackLayout.a(this.mActivity).a();
        initListener();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        textView.setText("报案助手");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, @i.c.a.e Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 0 && i3 == -1 && intent != null) {
            String stringExtra = intent.getStringExtra(CaptureActivity.f21076l);
            util.n1.a("content==" + stringExtra);
            if (TextUtils.isEmpty(stringExtra)) {
                util.w1.a("二维码错误或已过期");
                return;
            }
            this.caseInfoId = stringExtra;
            SurveyReportPresenter surveyReportPresenter = this.mPresent;
            if (surveyReportPresenter != null) {
                surveyReportPresenter.getCaseInfoById(this.caseInfoId);
            }
        }
    }

    @OnClick({R.id.iv_back, R.id.tv_report_record, R.id.tv_rule, R.id.fl_confirm})
    public final void onClick(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.fl_confirm /* 2131296626 */:
                varCamerPrims();
                break;
            case R.id.iv_back /* 2131296762 */:
                onBackPressed();
                break;
            case R.id.tv_report_record /* 2131297690 */:
                startActivity(new Intent(this.mActivity, (Class<?>) ReportRecordsActivity.class));
                break;
            case R.id.tv_rule /* 2131297695 */:
                startActivity(new Intent(this.mActivity, (Class<?>) SurveyDealActivity.class));
                break;
        }
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        SurveyReportPresenter surveyReportPresenter = this.mPresent;
        if (surveyReportPresenter != null) {
            surveyReportPresenter.getCaseBankNum();
        }
    }

    @Override // ui.callview.ReportIDInfoView
    public void onSuccessCaseNum(int i2) {
        if (i2 > 0) {
            ImageView imageView = this.mRedDot;
            if (imageView == null) {
                h.q2.t.i0.k("mRedDot");
            }
            imageView.setVisibility(0);
            return;
        }
        ImageView imageView2 = this.mRedDot;
        if (imageView2 == null) {
            h.q2.t.i0.k("mRedDot");
        }
        imageView2.setVisibility(8);
    }

    @Override // ui.callview.ReportIDInfoView
    public void onfailCaseNum() {
        ImageView imageView = this.mRedDot;
        if (imageView == null) {
            h.q2.t.i0.k("mRedDot");
        }
        imageView.setVisibility(8);
    }

    @Override // ui.callview.ReportIDInfoView
    public void onsuccessReportID() {
        Intent intent = new Intent(this.mActivity, (Class<?>) ReportCaseInfoActivity.class);
        intent.putExtra(util.k1.C0, this.caseInfoId);
        intent.putExtra(util.k1.f20844b, this.reportIDBean);
        startActivity(intent);
    }

    public final void setCaseInfoId(@i.c.a.e String str) {
        this.caseInfoId = str;
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_aid_report;
    }

    public final void setMIvBack(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMPresent(@i.c.a.e SurveyReportPresenter surveyReportPresenter) {
        this.mPresent = surveyReportPresenter;
    }

    public final void setMRedDot(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mRedDot = imageView;
    }

    public final void setMTCbSelect(@i.c.a.d CheckBox checkBox) {
        h.q2.t.i0.f(checkBox, "<set-?>");
        this.mTCbSelect = checkBox;
    }

    public final void setMTvTitle(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setReportIDBean(@i.c.a.e ReportIDInfoBean reportIDInfoBean) {
        this.reportIDBean = reportIDInfoBean;
    }
}
