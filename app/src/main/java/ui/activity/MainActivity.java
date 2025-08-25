package ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import bean.PushEntity;
import bean.SmsBean;
import bean.module.BottomLocalBean;
import bean.module.RegionMudelBean;
import butterknife.BindView;
import butterknife.OnClick;
import cn.jzvd.Jzvd;
import com.hicorenational.antifraud.R;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import interfaces.IOneClickListener;
import java.util.ArrayList;
import java.util.List;
import manager.AccountManager;
import manager.LoginManager;
import org.greenrobot.eventbus.ThreadMode;
import receiver.AppReceiver;
import ui.callview.MainCallview;
import ui.fragment.HomeFragment;
import ui.fragment.LocalWebFragment;
import ui.fragment.MineFragment;
import ui.fragment.WebFragment;
import ui.presenter.MainPagePresenter;
import ui.view.BottomBar;
import ui.view.NoSlideViewPager;
import ui.view.ZoomOutPageTransformer;
import util.y1;

/* loaded from: classes2.dex */
public class MainActivity extends BaseActivity implements MainCallview {
    private static String pushType = "";
    private static String pushUrl = "";
    private FragmentStatePagerAdapter mAdapter;
    private AppReceiver mAppReceiver;

    @BindView(R.id.bottomBar)
    BottomBar mBottomBar;

    @BindView(R.id.full_screen)
    View mFullScreen;
    private HomeFragment mHomeFragment;

    @BindView(R.id.iv_guide_main_1)
    ImageView mIvGuideMain1;
    private MineFragment mMineFragment;
    private MainPagePresenter mPresenter;

    @BindView(R.id.viewpager)
    NoSlideViewPager mViewpager;
    private LocalWebFragment mWebFragLocal;
    private WebFragment mWebFragment;
    private int prePos;
    private RegionMudelBean regionBean;
    private boolean webFullScreen;
    private List<Fragment> mTabs = new ArrayList();
    private List<SmsBean> smsBean = new ArrayList();
    private String moduleLocal = "";

    class a extends FragmentStatePagerAdapter {
        a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return MainActivity.this.mTabs.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i2) {
            return (Fragment) MainActivity.this.mTabs.get(i2);
        }

        public long getItemId(int i2) {
            return ((Fragment) MainActivity.this.mTabs.get(i2)).hashCode();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public static void getPushIntent(Intent intent) {
        pushType = intent.getStringExtra(util.k1.f20846d);
        pushUrl = intent.getStringExtra(util.k1.Q);
    }

    private void initAdapter() {
        this.mViewpager.setOffscreenPageLimit(this.mTabs.size());
        this.mViewpager.setPageTransformer(true, new ZoomOutPageTransformer());
        this.mAdapter = new a(getSupportFragmentManager());
        this.mViewpager.setAdapter(this.mAdapter);
        this.mBottomBar.setOnTabSelectedListener(new BottomBar.a() { // from class: ui.activity.i0
            @Override // ui.view.BottomBar.a
            public final void a(BottomLocalBean bottomLocalBean, int i2, int i3) {
                this.f19433a.a(bottomLocalBean, i2, i3);
            }
        });
    }

    private void initTabIndicators(BottomLocalBean bottomLocalBean) {
        if (bottomLocalBean != null) {
            this.mBottomBar.a(bottomLocalBean);
        } else {
            this.mBottomBar.a();
        }
        this.mBottomBar.setCurrentItem(0);
    }

    private void initViewPager(BottomLocalBean bottomLocalBean) {
        this.mTabs.add(this.mHomeFragment);
        this.mTabs.add(this.mWebFragment);
        this.mTabs.add(this.mMineFragment);
        if (bottomLocalBean != null) {
            this.moduleLocal = bottomLocalBean.getModule();
            this.mWebFragLocal = LocalWebFragment.getInstance(bottomLocalBean.getModule());
            this.mTabs.add(2, this.mWebFragLocal);
        }
        initAdapter();
    }

    private void intentHome() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(CommonNetImpl.FLAG_AUTH);
        intent.addCategory("android.intent.category.HOME");
        startActivity(intent);
    }

    private void localFreshTab(BottomLocalBean bottomLocalBean) {
        if (bottomLocalBean != null) {
            if (TextUtils.equals(this.moduleLocal, bottomLocalBean.getModule())) {
                return;
            }
            this.moduleLocal = bottomLocalBean.getModule();
            this.mWebFragLocal = LocalWebFragment.getInstance(bottomLocalBean.getModule());
            this.mTabs.set(2, this.mWebFragLocal);
            this.mAdapter.notifyDataSetChanged();
        } else {
            if (this.mTabs.size() == 3) {
                return;
            }
            this.mTabs.remove(2);
            this.mAdapter.notifyDataSetChanged();
        }
        initTabIndicators(bottomLocalBean);
    }

    private void mineRedState(boolean z) {
        this.mBottomBar.a(z);
    }

    private void registerAppReceiver() {
        this.mAppReceiver = new AppReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        registerReceiver(this.mAppReceiver, intentFilter);
    }

    public /* synthetic */ void a() {
        if (this.mWebFragLocal == null || TextUtils.isEmpty(pushType) || !pushType.equals(receiver.e.f17548d)) {
            return;
        }
        this.mViewpager.setCurrentItem(2, true);
        this.mBottomBar.setCurrentItem(2);
        LocalWebFragment.setPushUrl(pushUrl);
        pushType = "";
    }

    public List<SmsBean> getBean() {
        return this.smsBean;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        ui.statusbarcompat.b.a((Activity) this, true, true);
        org.greenrobot.eventbus.c.f().e(this);
        registerAppReceiver();
        this.mPresenter = new MainPagePresenter(this.mActivity, this);
        Jzvd.r0 = 1;
        getPushData();
        this.mHomeFragment = new HomeFragment();
        this.mWebFragment = new WebFragment();
        this.mMineFragment = new MineFragment();
        this.regionBean = d.a.j();
        RegionMudelBean regionMudelBean = this.regionBean;
        if (regionMudelBean != null) {
            initViewPager(regionMudelBean.getLocal());
            initTabIndicators(this.regionBean.getLocal());
        } else {
            initViewPager(null);
            initTabIndicators(null);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        UMShareAPI.get(this).onActivityResult(i2, i3, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mTabs.get(this.mViewpager.getCurrentItem()) instanceof WebFragment) {
            WebFragment webFragment = this.mWebFragment;
            if (webFragment == null) {
                intentHome();
                return;
            } else {
                if (webFragment.onBackPressed()) {
                    return;
                }
                intentHome();
                return;
            }
        }
        if (!(this.mTabs.get(this.mViewpager.getCurrentItem()) instanceof LocalWebFragment)) {
            intentHome();
            return;
        }
        LocalWebFragment localWebFragment = this.mWebFragLocal;
        if (localWebFragment == null) {
            intentHome();
        } else {
            if (localWebFragment.onBackPressed()) {
                return;
            }
            intentHome();
        }
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
        unregisterReceiver(this.mAppReceiver);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(util.c2.a aVar) {
        if (aVar != null) {
            int iA = aVar.a();
            if (iA == 110) {
                PushEntity pushEntity = (PushEntity) aVar.b();
                if (pushEntity != null) {
                    receiver.e.a(pushEntity.getExtra(), this);
                }
                return;
            }
            if (iA == 231) {
                this.mMineFragment.forceFreshListSize();
                return;
            }
            if (iA == 235) {
                mineRedState(((Boolean) aVar.b()).booleanValue());
                return;
            }
            if (iA == 153) {
                org.greenrobot.eventbus.c.f().f(aVar);
                HomeFragment homeFragment = this.mHomeFragment;
                if (homeFragment != null) {
                    homeFragment.virusStatus();
                    return;
                }
                return;
            }
            if (iA == 154) {
                org.greenrobot.eventbus.c.f().f(aVar);
                HomeFragment homeFragment2 = this.mHomeFragment;
                if (homeFragment2 != null) {
                    homeFragment2.virusFinish();
                    return;
                }
                return;
            }
            if (iA == 221) {
                localFreshTab((BottomLocalBean) aVar.b());
                return;
            }
            if (iA == 222) {
                this.mViewpager.setCurrentItem(this.prePos, true);
                this.mBottomBar.setCurrentItem(this.prePos);
                return;
            }
            switch (iA) {
                case 100:
                    org.greenrobot.eventbus.c.f().f(aVar);
                    this.mBottomBar.setVisibility(8);
                    this.webFullScreen = true;
                    ui.statusbarcompat.b.a((Activity) this, true, false);
                    break;
                case 101:
                    org.greenrobot.eventbus.c.f().f(aVar);
                    this.mBottomBar.setVisibility(0);
                    this.webFullScreen = false;
                    ui.statusbarcompat.b.a((Activity) this, true, true);
                    break;
                case 102:
                    org.greenrobot.eventbus.c.f().f(aVar);
                    this.mBottomBar.setVisibility(8);
                    this.webFullScreen = true;
                    ui.statusbarcompat.b.a((Activity) this, true, true);
                    break;
                case 103:
                    org.greenrobot.eventbus.c.f().f(aVar);
                    this.mBottomBar.setVisibility(8);
                    this.webFullScreen = true;
                    ui.statusbarcompat.b.a((Activity) this, true, false);
                    break;
                case 104:
                    if (this.mWebFragment != null) {
                        this.mBottomBar.setCurrentItem(1);
                        this.mViewpager.setCurrentItem(1);
                        this.mWebFragment.turnPage();
                        break;
                    }
                    break;
                case 105:
                    WebFragment webFragment = this.mWebFragment;
                    if (webFragment != null) {
                        webFragment.clearH5localData();
                        break;
                    }
                    break;
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (this.webFullScreen && i2 == 4) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        Bundle extras = getIntent().getExtras();
        if (extras == null || extras.getInt(util.k1.f20846d, 0) != 480) {
            return;
        }
        this.mHomeFragment.autoForceRefresh();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (AccountManager.isLogin()) {
            this.mPresenter.getH5SchmeData(this.mBottomBar);
        } else {
            LoginManager.getInstance().exitToLogin();
        }
        if (y1.f()) {
            util.b1.b(this, "本应用不支持ROOT设备", "确定", new IOneClickListener() { // from class: ui.activity.j0
                @Override // interfaces.IOneClickListener
                public final void clickOKBtn() {
                    ui.c.i().a();
                }
            });
        }
        this.mBottomBar.postDelayed(new Runnable() { // from class: ui.activity.k0
            @Override // java.lang.Runnable
            public final void run() {
                this.f19439a.a();
            }
        }, 1000L);
    }

    @OnClick({R.id.iv_guide_main_1})
    public void onViewClicked(View view) {
        view.getId();
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_main;
    }

    public /* synthetic */ void a(BottomLocalBean bottomLocalBean, int i2, int i3) {
        this.mViewpager.setCurrentItem(i2, false);
        this.prePos = i2;
    }
}
