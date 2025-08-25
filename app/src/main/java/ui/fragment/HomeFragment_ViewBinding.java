package ui.fragment;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.youth.banner.Banner;

/* loaded from: classes2.dex */
public class HomeFragment_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private HomeFragment f19623a;

    @UiThread
    public HomeFragment_ViewBinding(HomeFragment homeFragment, View view) {
        this.f19623a = homeFragment;
        homeFragment.mClBannerView = Utils.findRequiredView(view, R.id.cl_banner_view, "field 'mClBannerView'");
        homeFragment.mBanner = (Banner) Utils.findRequiredViewAsType(view, R.id.banner, "field 'mBanner'", Banner.class);
        homeFragment.mIvPolicEnt = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_polic_ent, "field 'mIvPolicEnt'", ImageView.class);
        homeFragment.mTvNoteNum = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_num_tip, "field 'mTvNoteNum'", TextView.class);
        homeFragment.mFlNoteView = Utils.findRequiredView(view, R.id.fl_note_view, "field 'mFlNoteView'");
        homeFragment.mHomeTopName = (TextView) Utils.findRequiredViewAsType(view, R.id.home_top_name, "field 'mHomeTopName'", TextView.class);
        homeFragment.mTvRegion = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_region, "field 'mTvRegion'", TextView.class);
        homeFragment.mRecyclerview = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recyclerview, "field 'mRecyclerview'", RecyclerView.class);
        homeFragment.mRefreshLayout = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, R.id.sm_refresh, "field 'mRefreshLayout'", SmartRefreshLayout.class);
        homeFragment.mViewStub = (ViewStub) Utils.findRequiredViewAsType(view, R.id.view_stub, "field 'mViewStub'", ViewStub.class);
        homeFragment.mTvNewCase = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_new_case, "field 'mTvNewCase'", TextView.class);
        homeFragment.mLlLast = Utils.findRequiredView(view, R.id.ll_last, "field 'mLlLast'");
        homeFragment.mTvMoreCase = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_more_case, "field 'mTvMoreCase'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        HomeFragment homeFragment = this.f19623a;
        if (homeFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f19623a = null;
        homeFragment.mClBannerView = null;
        homeFragment.mBanner = null;
        homeFragment.mIvPolicEnt = null;
        homeFragment.mTvNoteNum = null;
        homeFragment.mFlNoteView = null;
        homeFragment.mHomeTopName = null;
        homeFragment.mTvRegion = null;
        homeFragment.mRecyclerview = null;
        homeFragment.mRefreshLayout = null;
        homeFragment.mViewStub = null;
        homeFragment.mTvNewCase = null;
        homeFragment.mLlLast = null;
        homeFragment.mTvMoreCase = null;
    }
}
