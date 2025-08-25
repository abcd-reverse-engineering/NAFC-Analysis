package ui.activity;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import ui.view.SwitchButton;

/* loaded from: classes2.dex */
public class VirusKillingActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private VirusKillingActivity f19244a;

    /* renamed from: b, reason: collision with root package name */
    private View f19245b;

    /* renamed from: c, reason: collision with root package name */
    private View f19246c;

    /* renamed from: d, reason: collision with root package name */
    private View f19247d;

    /* renamed from: e, reason: collision with root package name */
    private View f19248e;

    /* renamed from: f, reason: collision with root package name */
    private View f19249f;

    /* renamed from: g, reason: collision with root package name */
    private View f19250g;

    /* renamed from: h, reason: collision with root package name */
    private View f19251h;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VirusKillingActivity f19252a;

        a(VirusKillingActivity virusKillingActivity) {
            this.f19252a = virusKillingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws Resources.NotFoundException {
            this.f19252a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VirusKillingActivity f19254a;

        b(VirusKillingActivity virusKillingActivity) {
            this.f19254a = virusKillingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws Resources.NotFoundException {
            this.f19254a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VirusKillingActivity f19256a;

        c(VirusKillingActivity virusKillingActivity) {
            this.f19256a = virusKillingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws Resources.NotFoundException {
            this.f19256a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VirusKillingActivity f19258a;

        d(VirusKillingActivity virusKillingActivity) {
            this.f19258a = virusKillingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws Resources.NotFoundException {
            this.f19258a.onViewClicked(view);
        }
    }

    class e extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VirusKillingActivity f19260a;

        e(VirusKillingActivity virusKillingActivity) {
            this.f19260a = virusKillingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws Resources.NotFoundException {
            this.f19260a.onViewClicked(view);
        }
    }

    class f extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VirusKillingActivity f19262a;

        f(VirusKillingActivity virusKillingActivity) {
            this.f19262a = virusKillingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws Resources.NotFoundException {
            this.f19262a.onViewClicked(view);
        }
    }

    class g extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VirusKillingActivity f19264a;

        g(VirusKillingActivity virusKillingActivity) {
            this.f19264a = virusKillingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws Resources.NotFoundException {
            this.f19264a.onViewClicked(view);
        }
    }

    @UiThread
    public VirusKillingActivity_ViewBinding(VirusKillingActivity virusKillingActivity) {
        this(virusKillingActivity, virusKillingActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        VirusKillingActivity virusKillingActivity = this.f19244a;
        if (virusKillingActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19244a = null;
        virusKillingActivity.mIvCircle = null;
        virusKillingActivity.mIvCircleCenter = null;
        virusKillingActivity.mScanResultTip = null;
        virusKillingActivity.mScanState = null;
        virusKillingActivity.mLayoutRiskBtn = null;
        virusKillingActivity.mRecyclerview = null;
        virusKillingActivity.mTvTitle = null;
        virusKillingActivity.mRecyclerview1 = null;
        virusKillingActivity.mStopScan = null;
        virusKillingActivity.mScanAppCount = null;
        virusKillingActivity.mScanPackageCount = null;
        virusKillingActivity.mIvAppStates = null;
        virusKillingActivity.mIvApkStates = null;
        virusKillingActivity.mViewBg = null;
        virusKillingActivity.mRecyclerviewRisk = null;
        virusKillingActivity.mTvAppeal = null;
        virusKillingActivity.mTvDelete = null;
        virusKillingActivity.mScanApp = null;
        virusKillingActivity.mScanPackage = null;
        virusKillingActivity.mScanLayout = null;
        virusKillingActivity.mTvAppCount = null;
        virusKillingActivity.mTvPackageCount = null;
        virusKillingActivity.mRlSafeResult = null;
        virusKillingActivity.mSafeSpace = null;
        virusKillingActivity.mRlRiskResult = null;
        virusKillingActivity.mTvApp = null;
        virusKillingActivity.mSwitchApp = null;
        this.f19245b.setOnClickListener(null);
        this.f19245b = null;
        this.f19246c.setOnClickListener(null);
        this.f19246c = null;
        this.f19247d.setOnClickListener(null);
        this.f19247d = null;
        this.f19248e.setOnClickListener(null);
        this.f19248e = null;
        this.f19249f.setOnClickListener(null);
        this.f19249f = null;
        this.f19250g.setOnClickListener(null);
        this.f19250g = null;
        this.f19251h.setOnClickListener(null);
        this.f19251h = null;
    }

    @UiThread
    public VirusKillingActivity_ViewBinding(VirusKillingActivity virusKillingActivity, View view) {
        this.f19244a = virusKillingActivity;
        virusKillingActivity.mIvCircle = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_circle, "field 'mIvCircle'", ImageView.class);
        virusKillingActivity.mIvCircleCenter = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_circle_center, "field 'mIvCircleCenter'", ImageView.class);
        virusKillingActivity.mScanResultTip = (TextView) Utils.findRequiredViewAsType(view, R.id.scan_result_tip, "field 'mScanResultTip'", TextView.class);
        virusKillingActivity.mScanState = (TextView) Utils.findRequiredViewAsType(view, R.id.scan_state, "field 'mScanState'", TextView.class);
        virusKillingActivity.mLayoutRiskBtn = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.layout_risk_btn, "field 'mLayoutRiskBtn'", ConstraintLayout.class);
        virusKillingActivity.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        virusKillingActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        virusKillingActivity.mRecyclerview1 = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview1, "field 'mRecyclerview1'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.stop_scan, "field 'mStopScan' and method 'onViewClicked'");
        virusKillingActivity.mStopScan = (TextView) Utils.castView(viewFindRequiredView, R.id.stop_scan, "field 'mStopScan'", TextView.class);
        this.f19245b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(virusKillingActivity));
        virusKillingActivity.mScanAppCount = (TextView) Utils.findRequiredViewAsType(view, R.id.scan_app_count, "field 'mScanAppCount'", TextView.class);
        virusKillingActivity.mScanPackageCount = (TextView) Utils.findRequiredViewAsType(view, R.id.scan_package_count, "field 'mScanPackageCount'", TextView.class);
        virusKillingActivity.mIvAppStates = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_app_states, "field 'mIvAppStates'", ImageView.class);
        virusKillingActivity.mIvApkStates = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_apk_states, "field 'mIvApkStates'", ImageView.class);
        virusKillingActivity.mViewBg = Utils.findRequiredView(view, R.id.view_bg, "field 'mViewBg'");
        virusKillingActivity.mRecyclerviewRisk = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview_risk, "field 'mRecyclerviewRisk'", RecyclerView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_appeal, "field 'mTvAppeal' and method 'onViewClicked'");
        virusKillingActivity.mTvAppeal = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_appeal, "field 'mTvAppeal'", TextView.class);
        this.f19246c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(virusKillingActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_delete, "field 'mTvDelete' and method 'onViewClicked'");
        virusKillingActivity.mTvDelete = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_delete, "field 'mTvDelete'", TextView.class);
        this.f19247d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(virusKillingActivity));
        virusKillingActivity.mScanApp = (TextView) Utils.findRequiredViewAsType(view, R.id.scan_app, "field 'mScanApp'", TextView.class);
        virusKillingActivity.mScanPackage = (TextView) Utils.findRequiredViewAsType(view, R.id.scan_package, "field 'mScanPackage'", TextView.class);
        virusKillingActivity.mScanLayout = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.scan_layout, "field 'mScanLayout'", ConstraintLayout.class);
        virusKillingActivity.mTvAppCount = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_app_count, "field 'mTvAppCount'", TextView.class);
        virusKillingActivity.mTvPackageCount = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_package_count, "field 'mTvPackageCount'", TextView.class);
        virusKillingActivity.mRlSafeResult = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_safe_result, "field 'mRlSafeResult'", RelativeLayout.class);
        virusKillingActivity.mSafeSpace = (Group) Utils.findRequiredViewAsType(view, R.id.safe_space, "field 'mSafeSpace'", Group.class);
        virusKillingActivity.mRlRiskResult = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_risk_result, "field 'mRlRiskResult'", RelativeLayout.class);
        virusKillingActivity.mTvApp = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_app, "field 'mTvApp'", TextView.class);
        virusKillingActivity.mSwitchApp = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.switch_app, "field 'mSwitchApp'", SwitchButton.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f19248e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(virusKillingActivity));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.layout_app, "method 'onViewClicked'");
        this.f19249f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(virusKillingActivity));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.layout_apk, "method 'onViewClicked'");
        this.f19250g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(virusKillingActivity));
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.tv_appeal_wb, "method 'onViewClicked'");
        this.f19251h = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new g(virusKillingActivity));
    }
}
