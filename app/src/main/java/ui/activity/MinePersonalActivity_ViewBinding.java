package ui.activity;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class MinePersonalActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private MinePersonalActivity f18399a;

    /* renamed from: b, reason: collision with root package name */
    private View f18400b;

    /* renamed from: c, reason: collision with root package name */
    private View f18401c;

    /* renamed from: d, reason: collision with root package name */
    private View f18402d;

    /* renamed from: e, reason: collision with root package name */
    private View f18403e;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MinePersonalActivity f18404a;

        a(MinePersonalActivity minePersonalActivity) {
            this.f18404a = minePersonalActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18404a.onViewClicked(view);
        }
    }

    class b extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MinePersonalActivity f18406a;

        b(MinePersonalActivity minePersonalActivity) {
            this.f18406a = minePersonalActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18406a.onViewClicked(view);
        }
    }

    class c extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MinePersonalActivity f18408a;

        c(MinePersonalActivity minePersonalActivity) {
            this.f18408a = minePersonalActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18408a.onViewClicked(view);
        }
    }

    class d extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MinePersonalActivity f18410a;

        d(MinePersonalActivity minePersonalActivity) {
            this.f18410a = minePersonalActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f18410a.onViewClicked(view);
        }
    }

    @UiThread
    public MinePersonalActivity_ViewBinding(MinePersonalActivity minePersonalActivity) {
        this(minePersonalActivity, minePersonalActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MinePersonalActivity minePersonalActivity = this.f18399a;
        if (minePersonalActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18399a = null;
        minePersonalActivity.mTvTitle = null;
        minePersonalActivity.mTvIdFineVar = null;
        minePersonalActivity.mUserName = null;
        minePersonalActivity.mLlIdFineVar = null;
        minePersonalActivity.mIdentityCardNum = null;
        minePersonalActivity.mArea = null;
        minePersonalActivity.mAreaDetail = null;
        minePersonalActivity.mTvRegArea = null;
        minePersonalActivity.mTvProgress = null;
        minePersonalActivity.mProgress = null;
        minePersonalActivity.mTopCoinTip = null;
        minePersonalActivity.mTvNameLable = null;
        minePersonalActivity.mTvIdLable = null;
        minePersonalActivity.mTvAreaLable = null;
        this.f18400b.setOnClickListener(null);
        this.f18400b = null;
        this.f18401c.setOnClickListener(null);
        this.f18401c = null;
        this.f18402d.setOnClickListener(null);
        this.f18402d = null;
        this.f18403e.setOnClickListener(null);
        this.f18403e = null;
    }

    @UiThread
    public MinePersonalActivity_ViewBinding(MinePersonalActivity minePersonalActivity, View view) {
        this.f18399a = minePersonalActivity;
        minePersonalActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_idfine_var, "field 'mTvIdFineVar' and method 'onViewClicked'");
        minePersonalActivity.mTvIdFineVar = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_idfine_var, "field 'mTvIdFineVar'", TextView.class);
        this.f18400b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(minePersonalActivity));
        minePersonalActivity.mUserName = (TextView) Utils.findRequiredViewAsType(view, R.id.user_name, "field 'mUserName'", TextView.class);
        minePersonalActivity.mLlIdFineVar = Utils.findRequiredView(view, R.id.ll_idfine_var, "field 'mLlIdFineVar'");
        minePersonalActivity.mIdentityCardNum = (TextView) Utils.findRequiredViewAsType(view, R.id.user_ID, "field 'mIdentityCardNum'", TextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.area, "field 'mArea' and method 'onViewClicked'");
        minePersonalActivity.mArea = (TextView) Utils.castView(viewFindRequiredView2, R.id.area, "field 'mArea'", TextView.class);
        this.f18401c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(minePersonalActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.area_detail, "field 'mAreaDetail' and method 'onViewClicked'");
        minePersonalActivity.mAreaDetail = (TextView) Utils.castView(viewFindRequiredView3, R.id.area_detail, "field 'mAreaDetail'", TextView.class);
        this.f18402d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(minePersonalActivity));
        minePersonalActivity.mTvRegArea = (TextView) Utils.findRequiredViewAsType(view, R.id.reg_area, "field 'mTvRegArea'", TextView.class);
        minePersonalActivity.mTvProgress = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_progress, "field 'mTvProgress'", TextView.class);
        minePersonalActivity.mProgress = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pb_progress, "field 'mProgress'", ProgressBar.class);
        minePersonalActivity.mTopCoinTip = Utils.findRequiredView(view, R.id.ll_top_cointips, "field 'mTopCoinTip'");
        minePersonalActivity.mTvNameLable = (TextView) Utils.findRequiredViewAsType(view, R.id.name_label, "field 'mTvNameLable'", TextView.class);
        minePersonalActivity.mTvIdLable = (TextView) Utils.findRequiredViewAsType(view, R.id.ID_label, "field 'mTvIdLable'", TextView.class);
        minePersonalActivity.mTvAreaLable = (TextView) Utils.findRequiredViewAsType(view, R.id.area_label, "field 'mTvAreaLable'", TextView.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f18403e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(minePersonalActivity));
    }
}
