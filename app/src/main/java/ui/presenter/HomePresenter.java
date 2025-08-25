package ui.presenter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import bean.HomeNewCaseBean;
import bean.NoteDlgBean;
import bean.VerifyHomePointBean;
import bean.module.ModuelConfig;
import bean.module.RegionMudelBean;
import com.tencent.open.SocialConstants;
import g.a.i0;
import interfaces.IClickListener;
import interfaces.IOneClickListener;
import interfaces.IVerifyListener;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import manager.AccountManager;
import network.APIException;
import network.BannerInfo;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.activity.IDVarfyAceptListActivity;
import ui.callview.HomeCallView;
import ui.fragment.HomeFragment;
import ui.model.ModelPresent;
import util.b1;
import util.k1;
import util.p1;
import util.y1;
import util.z1;

/* loaded from: classes2.dex */
public class HomePresenter extends ModelPresent<HomeCallView> {

    /* renamed from: bean, reason: collision with root package name */
    private VerifyHomePointBean f19927bean;
    private Dialog verifyDlg;

    class a extends MiddleSubscriber<APIresult<List<BannerInfo>>> {

        /* renamed from: ui.presenter.HomePresenter$a$a, reason: collision with other inner class name */
        class C0301a extends com.google.gson.d0.a<List<BannerInfo>> {
            C0301a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0301a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((HomeCallView) HomePresenter.this.mvpView).onBannerSuccRequest(null);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<BannerInfo>> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept());
            } else {
                ((HomeCallView) HomePresenter.this.mvpView).onBannerSuccRequest(aPIresult.getData());
            }
        }
    }

    class b implements i0<List<HomeNewCaseBean.RowsBean>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f19930a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f19931b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f19932c;

        b(int i2, int i3, boolean z) {
            this.f19930a = i2;
            this.f19931b = i3;
            this.f19932c = z;
        }

        @Override // g.a.i0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List<HomeNewCaseBean.RowsBean> list) {
            if (list != null || list.size() > 0) {
                ((HomeCallView) HomePresenter.this.mvpView).onNewCaseRequest(list);
            } else {
                onError(null);
            }
        }

        @Override // g.a.i0
        public void onComplete() {
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            HomePresenter.this.getNewCaseApi(this.f19930a, this.f19931b, this.f19932c);
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
        }
    }

    class c extends MiddleSubscriber<APIresult<HomeNewCaseBean>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f19934a;

        c(boolean z) {
            this.f19934a = z;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return HomeNewCaseBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((HomeCallView) HomePresenter.this.mvpView).onNewCaseFail(this.f19934a);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<HomeNewCaseBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept());
            } else {
                ((HomeCallView) HomePresenter.this.mvpView).onNewCaseRequest(aPIresult.getData().getRows());
            }
        }
    }

    class d extends MiddleSubscriber<APIresult<Boolean>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f19936a;

        d(boolean z) {
            this.f19936a = z;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return Boolean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((HomeCallView) HomePresenter.this.mvpView).onCheckPolice(false, this.f19936a);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<Boolean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() == 0) {
                ((HomeCallView) HomePresenter.this.mvpView).onCheckPolice(aPIresult.getData().booleanValue(), this.f19936a);
            } else {
                onErrorMiddle(APIException.getApiExcept());
            }
        }
    }

    class e extends MiddleSubscriber<APIresult<VerifyHomePointBean>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IOneClickListener f19938a;

        e(IOneClickListener iOneClickListener) {
            this.f19938a = iOneClickListener;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return VerifyHomePointBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            HomePresenter.this.f19927bean = null;
            HomePresenter.this.notifyVerifyHomePointBean();
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<VerifyHomePointBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                onErrorMiddle(APIException.getApiExcept());
                return;
            }
            HomePresenter.this.f19927bean = aPIresult.getData();
            HomePresenter.this.notifyVerifyHomePointBean();
            IOneClickListener iOneClickListener = this.f19938a;
            if (iOneClickListener != null) {
                iOneClickListener.clickOKBtn();
            }
        }
    }

    class f implements IOneClickListener {
        f() {
        }

        @Override // interfaces.IOneClickListener
        public void clickOKBtn() {
            HomePresenter.this.showIDVerifyDlg();
        }
    }

    class g implements IClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f19941a;

        g(String str) {
            this.f19941a = str;
        }

        public /* synthetic */ void a() {
            if (TextUtils.isEmpty(HomePresenter.this.f19927bean.getVerificationPath())) {
                HomePresenter.this.mActivity.startActivity(new Intent(HomePresenter.this.mActivity, (Class<?>) IDVarfyAceptListActivity.class));
            } else {
                HomePresenter homePresenter = HomePresenter.this;
                k1.a(homePresenter.mActivity, homePresenter.f19927bean.getVerificationPath());
            }
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            p1.a("update_home", this.f19941a);
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            z1.a(HomePresenter.this.mActivity).a(15, new IVerifyListener() { // from class: ui.presenter.f
                @Override // interfaces.IVerifyListener
                public final void onSuccessVerify() {
                    this.f20220a.a();
                }
            });
        }
    }

    class h extends MiddleSubscriber<APIresult<NoteDlgBean>> {
        h() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return NoteDlgBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((HomeCallView) HomePresenter.this.mvpView).onNoteDlgRequest(null);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<NoteDlgBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() == 0) {
                ((HomeCallView) HomePresenter.this.mvpView).onNoteDlgRequest(aPIresult.getData());
            } else {
                onErrorMiddle(APIException.getApiExcept());
            }
        }
    }

    public HomePresenter(Activity activity, HomeCallView homeCallView) {
        super(activity, homeCallView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getNewCaseApi(int i2, int i3, boolean z) {
        String strA = d.a.a(ModuelConfig.MODEL_LOCALNEWS, 8, e.b.B);
        HashMap<String, String> map = new HashMap<>();
        map.put("Page", i2 + "");
        map.put("Rows", i3 + "");
        map.put("Sort", "releasetime");
        map.put("Order", SocialConstants.PARAM_APP_DESC);
        getNewCaseList(strA, map, new c(z));
    }

    private String getOssPath() {
        RegionMudelBean regionMudelBeanJ = d.a.j();
        return (regionMudelBeanJ == null || !TextUtils.equals(d.a.b(ModuelConfig.MODEL_LOCALNEWS), "1")) ? d.a.f13515a : regionMudelBeanJ.getOssPath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showIDVerifyDlg() {
        VerifyHomePointBean verifyHomePointBean = this.f19927bean;
        if (verifyHomePointBean == null || verifyHomePointBean.getToVerificationCount() <= 0) {
            return;
        }
        Dialog dialog = this.verifyDlg;
        if ((dialog == null || !dialog.isShowing()) && HomeFragment.mIsVisibleToUser) {
            String strA = p1.a("update_home");
            String strD = y1.d("yyyy-MM-dd");
            if (TextUtils.equals(strA, strD)) {
                return;
            }
            this.verifyDlg = b1.a(this.mActivity, new g(strD));
        }
    }

    public void changeBottomView(RegionMudelBean regionMudelBean) {
        if (regionMudelBean != null) {
            org.greenrobot.eventbus.c.f().d(new util.c2.a(221, regionMudelBean.getLocal()));
        }
    }

    public void checkPolice(boolean z) {
        getAccHasPwd(d.a.a("", 8, e.b.T), new d(z));
    }

    public void getBanner() {
        getBanner(d.a.f13517c + e.b.f13571i, new a());
    }

    public void getNewCase(int i2, int i3, boolean z, boolean z2) {
        if (z) {
            getNewCaseOss(i2, i3, z2);
        } else {
            ((HomeCallView) this.mvpView).onNewCaseFail(false);
        }
    }

    public void getNewCaseOss(int i2, int i3, boolean z) {
        String str;
        if (i2 == 1) {
            str = getOssPath() + "h5/news/index/index-1.json";
        } else {
            if (i2 != 2) {
                ((HomeCallView) this.mvpView).onNewCaseRequest(null);
                return;
            }
            str = getOssPath() + "h5/news/index/index-2.json";
        }
        getNewCaseListOss(str, new b(i2, i3, z));
    }

    public void getVerifyHomePoint(IOneClickListener iOneClickListener) {
        getVerifyHomePoint(d.a.f13517c + e.b.p0, new e(iOneClickListener));
    }

    public void getVerifyPoint() {
        if (AccountManager.isLogin()) {
            getVerifyHomePoint(new f());
        }
    }

    public VerifyHomePointBean getVerifyPointBean() {
        return this.f19927bean;
    }

    public void notifyVerifyHomePointBean() {
        VerifyHomePointBean verifyHomePointBean = this.f19927bean;
        if (verifyHomePointBean != null) {
            ((HomeCallView) this.mvpView).onRedDotStatus(verifyHomePointBean.getToVerificationCount() > 0 || this.f19927bean.getPendingVerificationCount() > 0);
        } else {
            ((HomeCallView) this.mvpView).onRedDotStatus(false);
        }
    }

    public void requestNoteDlg() {
        requestNewNote(d.a.f13517c + e.b.s, new h());
    }
}
