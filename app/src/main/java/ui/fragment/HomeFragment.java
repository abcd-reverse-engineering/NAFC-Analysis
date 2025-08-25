package ui.fragment;

import adapter.HomeNewCaseAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.HomeNewCaseBean;
import bean.NoteDlgBean;
import bean.module.HomeToolBean;
import bean.module.LocalModuelConfig;
import bean.module.ModuelConfig;
import bean.module.RegionMudelBean;
import butterknife.BindView;
import com.hicorenational.antifraud.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import interfaces.IOneClickListener;
import interfaces.IResultCallback;
import interfaces.IVerifyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import manager.AccountManager;
import manager.GrayManager;
import network.BannerInfo;
import network.http.ReportNumHttp;
import network.http.StatisticsHttp;
import org.greenrobot.eventbus.ThreadMode;
import ui.activity.CheckIDActivity;
import ui.activity.NoteListActivity;
import ui.activity.PoliceInfoActivity;
import ui.activity.PoliceLoginActivity;
import ui.activity.ReportNewActivity;
import ui.activity.ReporterAidActivity;
import ui.activity.WarnSettingActivity;
import ui.activity.WebActivity;
import ui.activity.WebFullActivity;
import ui.callview.HomeCallView;
import ui.fragment.ToolView;
import ui.presenter.BasePagePresenter;
import ui.presenter.HomePresenter;
import ui.view.drag.RemovableView;
import util.b1;
import util.k1;
import util.n1;
import util.p1;
import util.u1;
import util.y1;
import util.z1;

/* loaded from: classes2.dex */
public class HomeFragment extends BaseFragment implements HomeCallView, View.OnClickListener, ToolView.b {
    public static boolean mIsVisibleToUser;
    private boolean isForceFresh;
    public HomeNewCaseAdapter mAdapter;

    @BindView(R.id.banner)
    Banner mBanner;

    @BindView(R.id.cl_banner_view)
    View mClBannerView;
    RemovableView mDragImageView;

    @BindView(R.id.fl_note_view)
    View mFlNoteView;

    @BindView(R.id.home_top_name)
    TextView mHomeTopName;
    ImageView mIvDrag;

    @BindView(R.id.iv_polic_ent)
    ImageView mIvPolicEnt;

    @BindView(R.id.ll_last)
    View mLlLast;
    private HomePresenter mPresenter;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.sm_refresh)
    SmartRefreshLayout mRefreshLayout;
    private StandardView mStandardView;
    private ToolView mToolitemsView;

    @BindView(R.id.tv_more_case)
    TextView mTvMoreCase;

    @BindView(R.id.tv_new_case)
    TextView mTvNewCase;

    @BindView(R.id.tv_num_tip)
    TextView mTvNoteNum;

    @BindView(R.id.tv_region)
    TextView mTvRegion;

    @BindView(R.id.view_stub)
    ViewStub mViewStub;
    private BasePagePresenter presenter;
    private List<HomeNewCaseBean.RowsBean> mNewCaseList = new ArrayList();
    private List<BannerInfo> mBannerList = new ArrayList();
    public boolean isLoadmore = false;
    public int pageIndex = 1;
    public int pageSize = 10;

    class a implements ViewStub.OnInflateListener {
        a() {
        }

        @Override // android.view.ViewStub.OnInflateListener
        public void onInflate(ViewStub viewStub, View view) {
            n1.b("ViewStub加载");
            HomeFragment homeFragment = HomeFragment.this;
            homeFragment.mDragImageView = (RemovableView) view;
            homeFragment.mIvDrag = (ImageView) view.findViewById(R.id.iv_drag);
            HomeFragment homeFragment2 = HomeFragment.this;
            homeFragment2.mDragImageView.setOnClickListener(homeFragment2);
        }
    }

    class b implements IResultCallback {
        b() {
        }

        @Override // interfaces.IResultCallback
        public void onIRSuccess(RegionMudelBean regionMudelBean) {
            if (regionMudelBean != null) {
                HomeFragment.this.refreshRegionData();
                if (HomeFragment.this.isForceFresh) {
                    org.greenrobot.eventbus.c.f().d(new util.c2.a(util.c2.a.B0));
                }
            }
            HomeFragment homeFragment = HomeFragment.this;
            homeFragment.pageIndex = 1;
            homeFragment.mPresenter.getBanner();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (HomeFragment.this.mStandardView != null) {
                HomeFragment.this.mStandardView.a();
            }
        }
    }

    class d implements StatisticsHttp.CallbackComplete {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f19619a;

        class a implements StatisticsHttp.CallbackComplete {

            /* renamed from: ui.fragment.HomeFragment$d$a$a, reason: collision with other inner class name */
            class C0290a implements StatisticsHttp.CallbackComplete {
                C0290a() {
                }

                @Override // network.http.StatisticsHttp.CallbackComplete
                public void onComplete() {
                    HomeFragment.this.mPresenter.getVerifyPoint();
                }
            }

            a() {
            }

            @Override // network.http.StatisticsHttp.CallbackComplete
            public void onComplete() {
                StatisticsHttp.getInstance().trackWarnApp((d.this.f19619a && u1.a(u1.H, false)) ? "1" : "0", new C0290a());
            }
        }

        d(boolean z) {
            this.f19619a = z;
        }

        @Override // network.http.StatisticsHttp.CallbackComplete
        public void onComplete() {
            HomeFragment homeFragment = HomeFragment.this;
            StatisticsHttp.getInstance().trackWarnSms((this.f19619a && util.permissionutil.c.a(homeFragment.mActivity, homeFragment.presenter.checkPermissionSms()) && u1.a(u1.G, false)) ? "1" : "0", new a());
        }
    }

    private void changeCenterView(RegionMudelBean regionMudelBean) {
        this.mToolitemsView.setDataChange(regionMudelBean);
        this.mStandardView.setDataChange(regionMudelBean);
    }

    private void checkPolice() {
        RegionMudelBean regionMudelBean = BaseFragment.mRegionBean;
        if (regionMudelBean == null || TextUtils.isEmpty(regionMudelBean.getLocalApi()) || !TextUtils.equals(BaseFragment.mRegionBean.getUseLocalPolice(), "1")) {
            return;
        }
        this.mPresenter.checkPolice(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: goTools, reason: merged with bridge method [inline-methods] */
    public void a(String str) {
        if (TextUtils.equals(str, ModuelConfig.MODEL_REPORT)) {
            ReportNumHttp.getInstance().principalHttp(new ReportNumHttp.Callback() { // from class: ui.fragment.j
                @Override // network.http.ReportNumHttp.Callback
                public final void onNumSuccess() {
                    this.f19723a.d();
                }
            });
            return;
        }
        if (TextUtils.equals(str, ModuelConfig.MODEL_CASEXC)) {
            startActivity(ReporterAidActivity.class);
            return;
        }
        if (TextUtils.equals(str, ModuelConfig.MODEL_WARN)) {
            startActivity(WarnSettingActivity.class);
        } else if (TextUtils.equals(str, ModuelConfig.MODEL_IDVERIFY)) {
            Intent intent = new Intent(this.mActivity, (Class<?>) CheckIDActivity.class);
            intent.putExtra(k1.f20845c, this.mPresenter.getVerifyPointBean());
            startActivity(intent);
        }
    }

    private void initBanner() {
        ArrayList arrayList = new ArrayList();
        this.mBanner.setBannerStyle(1);
        this.mBanner.setImageLoader(ui.view.q.getImageLoader(this.mActivity));
        this.mBanner.setImages(arrayList);
        this.mBanner.setOnBannerListener(new OnBannerListener() { // from class: ui.fragment.a
            @Override // com.youth.banner.listener.OnBannerListener
            public final void OnBannerClick(int i2) {
                this.f19709a.a(i2);
            }
        });
        if (Build.VERSION.SDK_INT >= 23 || !Build.MANUFACTURER.contains("NUBIA")) {
            this.mBanner.start();
        }
        j.d.a(this.mBanner, 20);
    }

    private void initListener() {
        this.mRefreshLayout.a((com.scwang.smartrefresh.layout.b.g) new ClassicsHeader(this.mActivity));
        this.mRefreshLayout.s(false);
        this.mRefreshLayout.h(true);
        this.mRefreshLayout.a(new com.scwang.smartrefresh.layout.d.d() { // from class: ui.fragment.d
            @Override // com.scwang.smartrefresh.layout.d.d
            public final void a(com.scwang.smartrefresh.layout.b.j jVar) {
                this.f19713a.a(jVar);
            }
        });
        this.mRefreshLayout.a(new com.scwang.smartrefresh.layout.d.b() { // from class: ui.fragment.f
            @Override // com.scwang.smartrefresh.layout.d.b
            public final void b(com.scwang.smartrefresh.layout.b.j jVar) {
                this.f19715a.b(jVar);
            }
        });
    }

    private void initRegionView() {
        BaseFragment.mRegionBean = d.a.j();
        changeCenterView(BaseFragment.mRegionBean);
        this.mPresenter.getBanner();
    }

    private void initViewNewCaseList() {
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new HomeNewCaseAdapter(this.mActivity, this.mNewCaseList);
        this.mToolitemsView = (ToolView) this.mActivity.findViewById(R.id.view_tool);
        this.mToolitemsView.setItemClick(this);
        this.mStandardView = (StandardView) this.mActivity.findViewById(R.id.view_standard);
        this.mHomeTopName.setTypeface(this.typ_ME);
        this.mStandardView.setTypeface(this.typ_ME);
        this.mTvNewCase.setTypeface(this.typ_ME);
        this.mTvMoreCase.setOnClickListener(new View.OnClickListener() { // from class: ui.fragment.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                org.greenrobot.eventbus.c.f().d(new util.c2.a(104, null));
            }
        });
        this.mRecyclerview.setAdapter(this.mAdapter);
        if (AccountManager.getAccountInfo().isPolice()) {
            this.mIvPolicEnt.setVisibility(0);
        }
        this.mFlNoteView.setOnClickListener(this);
        this.mIvPolicEnt.setOnClickListener(this);
        this.mViewStub.setOnInflateListener(new a());
    }

    private void itemTurnPage(final String str, String str2, String str3, String str4, int i2) {
        if (this.mToolitemsView.a(str)) {
            if (i2 == 1) {
                z1.a(this.mActivity).a(Integer.parseInt(str), new IVerifyListener() { // from class: ui.fragment.g
                    @Override // interfaces.IVerifyListener
                    public final void onSuccessVerify() {
                        this.f19716a.a(str);
                    }
                });
                return;
            } else {
                a(str);
                return;
            }
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (i2 == 1) {
            urlOpenVerified(str, str2, str3, str4);
        } else {
            urlOpen(str, str3, str4);
        }
    }

    private void loadNewCaseCache() {
        List<HomeNewCaseBean.RowsBean> listB = p1.b(p1.o, HomeNewCaseBean.RowsBean.class);
        if (listB != null) {
            this.mAdapter.a(listB);
            this.mAdapter.notifyDataSetChanged();
            this.mRefreshLayout.s(false);
            this.pageIndex = 1;
            if (listB.size() > 0) {
                showMoreBtn(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshRegionData() {
        BaseFragment.mRegionBean = d.a.j();
        this.mPresenter.changeBottomView(BaseFragment.mRegionBean);
        changeCenterView(BaseFragment.mRegionBean);
    }

    private void showMoreBtn(boolean z) {
        if (z) {
            this.mRefreshLayout.s(false);
            this.mTvMoreCase.setVisibility(0);
        } else {
            this.mTvMoreCase.setVisibility(8);
            this.mLlLast.postDelayed(new c(), 2000L);
        }
    }

    private void showRegistionRegion() {
        if (this.mTvRegion != null) {
            String registerRegionName = AccountManager.getRegisterRegionName();
            if (TextUtils.isEmpty(registerRegionName)) {
                this.mTvRegion.setText("");
                return;
            }
            if (registerRegionName.length() <= 4) {
                this.mTvRegion.setText(registerRegionName);
                return;
            }
            this.mTvRegion.setText(registerRegionName.substring(0, 3) + "...");
        }
    }

    private boolean toH5NoteView() {
        RegionMudelBean regionMudelBean = BaseFragment.mRegionBean;
        if (regionMudelBean == null || TextUtils.isEmpty(regionMudelBean.getBroadcast())) {
            return false;
        }
        Intent intent = new Intent(getActivity(), (Class<?>) WebFullActivity.class);
        intent.putExtra(k1.Q, BaseFragment.mRegionBean.getH5Url() + BaseFragment.mRegionBean.getBroadcast());
        startActivity(intent);
        return true;
    }

    private void urlOpen(String str, String str2, String str3) {
        if (TextUtils.equals(str2, ModuelConfig.OTYPE1)) {
            Intent intent = new Intent(getActivity(), (Class<?>) WebActivity.class);
            intent.putExtra(k1.P, y1.t(str3));
            intent.putExtra(k1.Q, str + AccountManager.getShareParam());
            startActivity(intent);
            return;
        }
        if (TextUtils.equals(str2, ModuelConfig.OTYPE2)) {
            Intent intent2 = new Intent(getActivity(), (Class<?>) WebActivity.class);
            intent2.putExtra(k1.P, y1.t(str3));
            intent2.putExtra(k1.Q, str);
            startActivity(intent2);
            return;
        }
        if (TextUtils.equals(str2, ModuelConfig.OTYPE3)) {
            k1.a((Context) this.mActivity, str);
        } else {
            k1.a(this.mActivity, str);
        }
    }

    private void urlOpenVerified(final String str, final String str2, String str3, final String str4) {
        if (TextUtils.equals(str3, ModuelConfig.OTYPE1) || TextUtils.equals(str3, ModuelConfig.OTYPE2)) {
            HashMap map = new HashMap();
            map.put(k1.P, y1.t(str4));
            map.put(k1.Q, str + AccountManager.getShareParam());
            z1.a(this.mActivity).a(18, map, new IVerifyListener() { // from class: ui.fragment.k
                @Override // interfaces.IVerifyListener
                public final void onSuccessVerify() {
                    this.f19724a.b(str4, str);
                }
            });
            return;
        }
        if (TextUtils.equals(str3, ModuelConfig.OTYPE3)) {
            HashMap map2 = new HashMap();
            map2.put(k1.Q, str);
            z1.a(this.mActivity).a(19, map2, new IVerifyListener() { // from class: ui.fragment.b
                @Override // interfaces.IVerifyListener
                public final void onSuccessVerify() {
                    this.f19710a.c(str);
                }
            });
        } else {
            HashMap map3 = new HashMap();
            map3.put(k1.Q, str);
            z1.a(this.mActivity).a(20, map3, new IVerifyListener() { // from class: ui.fragment.i
                @Override // interfaces.IVerifyListener
                public final void onSuccessVerify() {
                    this.f19720a.a(str2, str);
                }
            });
        }
    }

    public void autoForceRefresh() {
        this.isForceFresh = true;
        this.mRefreshLayout.e();
    }

    public /* synthetic */ void b(com.scwang.smartrefresh.layout.b.j jVar) {
        pullToLoadMore();
    }

    public /* synthetic */ void c(String str) {
        k1.a((Context) this.mActivity, str);
    }

    public /* synthetic */ void d() {
        y1.a((Context) this.mActivity, (Class<?>) ReportNewActivity.class);
    }

    public /* synthetic */ void e() {
        RegionMudelBean regionMudelBean = BaseFragment.mRegionBean;
        if (regionMudelBean == null || TextUtils.isEmpty(regionMudelBean.getAssistantPolice())) {
            if (d.b.d()) {
                startActivity(PoliceInfoActivity.class);
                return;
            } else {
                startActivity(PoliceLoginActivity.class);
                return;
            }
        }
        k1.a(this.mActivity, BaseFragment.mRegionBean.getH5Url() + BaseFragment.mRegionBean.getAssistantPolice());
    }

    @Override // ui.fragment.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override // ui.fragment.BaseFragment
    protected void initPage() {
        org.greenrobot.eventbus.c.f().e(this);
        GrayManager.Companion.getInstance().setLayerGray(((BaseFragment) this).mView);
        this.mPresenter = new HomePresenter(this.mActivity, this);
        showRegistionRegion();
        initViewNewCaseList();
        initBanner();
        initListener();
        initRegionView();
    }

    @Override // ui.callview.HomeCallView
    public void onBannerSuccRequest(List<BannerInfo> list) {
        if (list != null && list.size() > 0) {
            this.mBannerList.clear();
            this.mBannerList = list;
            List<BannerInfo> list2 = this.mBannerList;
            if (list2 != null && list2.size() > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator<BannerInfo> it = this.mBannerList.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getImgPath());
                }
                if (arrayList.size() > 0) {
                    this.mBanner.update(arrayList);
                }
            }
        }
        this.mPresenter.getNewCase(this.pageIndex, this.pageSize, this.mLlLast.isShown(), true);
    }

    @Override // ui.callview.HomeCallView
    public void onCheckPolice(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.mIvPolicEnt.setVisibility(0);
            } else {
                this.mIvPolicEnt.setVisibility(8);
            }
        }
        RegionMudelBean regionMudelBean = BaseFragment.mRegionBean;
        if (regionMudelBean == null || TextUtils.isEmpty(regionMudelBean.getLocalApi()) || this.presenter != null) {
            this.mPresenter.getVerifyPoint();
            return;
        }
        this.presenter = new BasePagePresenter(this.mActivity);
        boolean zIsOpenFlowPrim = this.presenter.isOpenFlowPrim();
        StatisticsHttp.getInstance().trackWarnCall((zIsOpenFlowPrim && util.permissionutil.c.a(this.mActivity, this.presenter.checkPermissionCall()) && u1.a(u1.F, false)) ? "1" : "0", new d(zIsOpenFlowPrim));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.fl_note_view) {
            if (id != R.id.iv_polic_ent) {
                return;
            }
            z1.a(this.mActivity).a(13, new IVerifyListener() { // from class: ui.fragment.e
                @Override // interfaces.IVerifyListener
                public final void onSuccessVerify() {
                    this.f19714a.e();
                }
            });
        } else {
            if (toH5NoteView()) {
                return;
            }
            this.mTvNoteNum.setVisibility(8);
            startActivity(NoteListActivity.class);
        }
    }

    @Override // ui.fragment.ToolView.b
    public void onClickToolItem(HomeToolBean homeToolBean) {
        itemTurnPage(homeToolBean.getModule(), homeToolBean.getId(), "", "", homeToolBean.getIsNeedVerified());
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventWornThread(util.c2.a aVar) {
        if (aVar != null) {
            int iA = aVar.a();
            if (iA == 38 || iA == 39) {
                this.mPresenter.getVerifyHomePoint(null);
            }
        }
    }

    @Override // ui.callview.HomeCallView
    public void onNewCaseFail(boolean z) {
        this.mRefreshLayout.g();
        this.mRefreshLayout.b();
        if (!z) {
            this.mAdapter.a().clear();
            this.mAdapter.notifyDataSetChanged();
        } else if (this.mAdapter.a().size() <= 0) {
            loadNewCaseCache();
        }
        this.mPresenter.requestNoteDlg();
    }

    @Override // ui.callview.HomeCallView
    public void onNewCaseRequest(List<HomeNewCaseBean.RowsBean> list) {
        try {
            this.mRefreshLayout.g();
            this.mRefreshLayout.b();
            boolean z = true;
            if (list == null || list.size() <= 0) {
                if (this.isLoadmore) {
                    this.mRefreshLayout.s(false);
                } else {
                    z = false;
                }
                this.isLoadmore = false;
                p1.a(p1.o, (List) this.mAdapter.a());
                showMoreBtn(z);
            } else {
                if (this.isLoadmore) {
                    this.mAdapter.a().addAll(list);
                    this.mAdapter.notifyDataSetChanged();
                } else {
                    this.mAdapter.a(list);
                    this.mRefreshLayout.s(true);
                }
                if (list.size() >= this.pageSize && list.size() <= this.pageSize) {
                    this.mRefreshLayout.s(true);
                    z = false;
                    this.isLoadmore = false;
                    p1.a(p1.o, (List) this.mAdapter.a());
                    showMoreBtn(z);
                }
                this.mRefreshLayout.s(false);
                this.isLoadmore = false;
                p1.a(p1.o, (List) this.mAdapter.a());
                showMoreBtn(z);
            }
        } catch (Exception unused) {
        }
        this.mPresenter.requestNoteDlg();
    }

    @Override // ui.callview.HomeCallView
    public void onNoteDlgRequest(NoteDlgBean noteDlgBean) {
        if (noteDlgBean != null) {
            if (!TextUtils.isEmpty(noteDlgBean.getTitle())) {
                b1.a(this.mActivity, noteDlgBean, (IOneClickListener) null);
            }
            if (noteDlgBean.isRedDot()) {
                this.mTvNoteNum.setVisibility(0);
            } else {
                this.mTvNoteNum.setVisibility(8);
            }
        } else {
            this.mTvNoteNum.setVisibility(8);
        }
        checkPolice();
    }

    @Override // ui.callview.HomeCallView
    public void onRedDotStatus(boolean z) {
        ToolView toolView = this.mToolitemsView;
        if (toolView != null) {
            toolView.a(z);
        }
    }

    public void pullToLoadMore() {
        if (this.mRefreshLayout == null || this.mPresenter == null) {
            return;
        }
        this.isLoadmore = true;
        int size = this.mNewCaseList.size();
        int i2 = this.pageSize;
        int i3 = (size / i2) + 1;
        if (this.pageIndex >= i3) {
            this.mRefreshLayout.b();
        } else {
            this.pageIndex = i3;
            this.mPresenter.getNewCase(this.pageIndex, i2, this.mLlLast.isShown(), true);
        }
    }

    public void pullToRefresh() {
        LocalModuelConfig.getInstance().getConfigMude(this.isForceFresh, new b());
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        mIsVisibleToUser = z;
        if (z) {
            StatisticsHttp.getInstance().pageOpenHttp(e.d.f13589g);
        }
    }

    public void virusFinish() {
        this.mStandardView.b();
    }

    public void virusStatus() {
        this.mStandardView.b();
    }

    public /* synthetic */ void a(com.scwang.smartrefresh.layout.b.j jVar) {
        this.isForceFresh = false;
        pullToRefresh();
    }

    public /* synthetic */ void b(String str, String str2) {
        Intent intent = new Intent(getActivity(), (Class<?>) WebActivity.class);
        intent.putExtra(k1.P, y1.t(str));
        intent.putExtra(k1.Q, str2 + AccountManager.getShareParam());
        startActivity(intent);
    }

    public /* synthetic */ void a(int i2) {
        List<BannerInfo> list;
        BannerInfo bannerInfo;
        if (isDouble() || (list = this.mBannerList) == null || list.size() <= 0 || this.mBannerList.size() - 1 < i2 || (bannerInfo = this.mBannerList.get(i2)) == null) {
            return;
        }
        itemTurnPage(bannerInfo.getUrl(), "", bannerInfo.getOpenType(), bannerInfo.getTitle(), bannerInfo.getIsNeedVerified());
    }

    public /* synthetic */ void b(String str) {
        k1.a(this.mActivity, str);
    }

    public /* synthetic */ void a(String str, final String str2) {
        if (TextUtils.equals(str, ModuelConfig.MODEL_REPORT)) {
            ReportNumHttp.getInstance().principalHttp(new ReportNumHttp.Callback() { // from class: ui.fragment.h
                @Override // network.http.ReportNumHttp.Callback
                public final void onNumSuccess() {
                    this.f19718a.b(str2);
                }
            });
        } else {
            k1.a(this.mActivity, str2);
        }
    }
}
