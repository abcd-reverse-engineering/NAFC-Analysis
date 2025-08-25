package ui.activity;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import bean.module.LocalModuelConfig;
import bean.module.RegionMudelBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import interfaces.IResultCallback;
import java.util.ArrayList;
import manager.AccountManager;
import network.account.AccountInfo;
import network.http.AddressHttp;
import network.http.RegionConfigHttp;
import network.http.StatisticsHttp;
import org.greenrobot.eventbus.ThreadMode;
import ui.callview.AddressCallview;
import ui.presenter.AddressPresenter;
import ui.presenter.RegisterPresenter;
import ui.view.RegionWheelView;
import util.y1;

/* loaded from: classes2.dex */
public class AddressActivity extends BaseActivity {

    /* renamed from: a, reason: collision with root package name */
    protected b.a.a.d.e f17630a = null;

    /* renamed from: b, reason: collision with root package name */
    protected b.a.a.d.d f17631b = null;

    /* renamed from: c, reason: collision with root package name */
    protected int f17632c;

    /* renamed from: d, reason: collision with root package name */
    private AddressPresenter f17633d;

    @BindView(R.id.confirm)
    TextView mConfirm;

    @BindView(R.id.ll_region)
    RegionWheelView mLlRegion;

    class a extends AddressHttp.MyPicker {
        a() {
        }

        @Override // network.http.AddressHttp.MyPicker
        public void onData(ArrayList<b.a.a.d.k> arrayList) {
            if (AddressActivity.this.mLlRegion == null || 1 >= AddressHttp.getMaxAddressVersion()) {
                return;
            }
            AddressActivity.this.mLlRegion.a(arrayList);
        }
    }

    class b implements AddressCallview {
        b() {
        }

        @Override // ui.callview.AddressCallview
        public void onSuccessRegister(@i.c.a.d AccountInfo accountInfo, @i.c.a.d String str, @i.c.a.d String str2) {
            if (accountInfo != null) {
                accountInfo.setRegisterRegionName(str);
                accountInfo.setRegisterRegionCode(str2);
                AccountManager.saveAccount(accountInfo);
            }
            ui.c.i().e();
            y1.a((Context) AddressActivity.this.mActivity, (Class<?>) MainActivity.class);
            AddressActivity.this.finish();
        }
    }

    private void b() {
        int i2 = this.f17632c;
        if ((i2 == 1 || i2 == 5) && this.f17633d == null) {
            this.f17633d = new AddressPresenter(this.mActivity, new b());
        }
    }

    public /* synthetic */ void a(RegionMudelBean regionMudelBean) {
        startActivity(RegisterActivity.class);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        org.greenrobot.eventbus.c.f().e(this);
        StatisticsHttp.getInstance().pageOpenHttp(e.d.f13588f);
        this.f17632c = getIntent().getIntExtra(util.k1.X0, 0);
        AddressHttp.getAddSint(this.mActivity).getPickData(new a());
        getPushData();
        b();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventWornThread(util.c2.a aVar) {
        if (aVar == null || aVar.a() != 211) {
            return;
        }
        finish();
    }

    @OnClick({R.id.confirm})
    public void onViewClicked(View view) {
        hideSoftInput();
        if (!isDouble() && view.getId() == R.id.confirm) {
            this.f17630a = this.mLlRegion.getCounty();
            this.f17631b = this.mLlRegion.getCity();
            b.a.a.d.e eVar = this.f17630a;
            if (eVar == null || TextUtils.isEmpty(eVar.getAreaId())) {
                util.w1.a("请选择您的注册地区");
                return;
            }
            RegionConfigHttp.setNodeRegion(this.mLlRegion.getSelectedProvince().getAreaName(), this.f17630a.getAreaName(), this.f17630a.getAreaId());
            int i2 = this.f17632c;
            if (i2 == 1) {
                a();
                return;
            }
            if (i2 == 5) {
                a();
                return;
            }
            if (i2 == 6) {
                a();
            } else if (i2 == 3) {
                finish();
            } else {
                LocalModuelConfig.getInstance().getConfigMude(this.f17630a.getAreaId(), new IResultCallback() { // from class: ui.activity.a
                    @Override // interfaces.IResultCallback
                    public final void onIRSuccess(RegionMudelBean regionMudelBean) {
                        this.f19401a.a(regionMudelBean);
                    }
                });
            }
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_address;
    }

    private void a() {
        final AccountInfo accountInfo = (AccountInfo) getIntent().getSerializableExtra(util.k1.f20845c);
        LocalModuelConfig.getInstance().getConfigMude(this.f17630a.getAreaId(), new IResultCallback() { // from class: ui.activity.b
            @Override // interfaces.IResultCallback
            public final void onIRSuccess(RegionMudelBean regionMudelBean) {
                this.f19404a.a(accountInfo, regionMudelBean);
            }
        });
    }

    public /* synthetic */ void a(AccountInfo accountInfo, RegionMudelBean regionMudelBean) {
        AddressPresenter addressPresenter;
        int i2 = this.f17632c;
        if (i2 == 6) {
            new RegisterPresenter(this.mActivity, null).silentlyreg(accountInfo);
        } else {
            if ((i2 != 1 && i2 != 5) || (addressPresenter = this.f17633d) == null || accountInfo == null) {
                return;
            }
            addressPresenter.addRegisterRegion(accountInfo, this.f17630a.getAreaName(), this.f17630a.getAreaId());
        }
    }
}
