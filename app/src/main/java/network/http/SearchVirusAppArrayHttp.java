package network.http;

import android.text.TextUtils;
import bean.AppInfoBean;
import bean.AppSignBean;
import bean.SearchVirusAppBean;
import bean.SearchVirusAppResultBean;
import bean.module.ModuelConfig;
import e.b;
import h.e1;
import h.q2.s.a;
import h.q2.t.i0;
import h.s;
import h.v;
import h.x;
import h.y;
import i.c.a.d;
import i.c.a.e;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import manager.LoginManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.model.ModelPresent;
import util.n1;
import util.r1;

/* compiled from: SearchVirusAppArrayHttp.kt */
@y(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bJ \u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u001c\u0010\u0012\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u000bJ,\u0010\u0013\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\u0017"}, d2 = {"Lnetwork/http/SearchVirusAppArrayHttp;", "", "()V", "dealResult", "", "appList", "", "Lbean/AppInfoBean;", "result", "Lbean/SearchVirusAppResultBean;", "callback", "Lnetwork/http/SearchVirusAppArrayHttp$Callback;", "dealResultItem", "appInfoBean", "searchVirusAppResultBean", "getSignVirus", "virusBean", "Lbean/SearchVirusAppBean;", "principalHttp", "searchAppHttp", "list", "Callback", "Companion", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SearchVirusAppArrayHttp {
    public static final Companion Companion = new Companion(null);

    @d
    private static final s instance$delegate = v.a(x.SYNCHRONIZED, (a) SearchVirusAppArrayHttp$Companion$instance$2.INSTANCE);
    public static final int mApiArrayCount = 30;

    /* compiled from: SearchVirusAppArrayHttp.kt */
    @y(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\nH&¨\u0006\r"}, d2 = {"Lnetwork/http/SearchVirusAppArrayHttp$Callback;", "", "principalFail", "", "msg", "", "principalRequestFinish", "originCount", "", "noRisk", "", "principalRiskResult", "isRefresh", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
    public interface Callback {
        void principalFail(@e String str);

        void principalRequestFinish(int i2, boolean z);

        void principalRiskResult(boolean z);
    }

    /* compiled from: SearchVirusAppArrayHttp.kt */
    @y(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lnetwork/http/SearchVirusAppArrayHttp$Companion;", "", "()V", "instance", "Lnetwork/http/SearchVirusAppArrayHttp;", "getInstance", "()Lnetwork/http/SearchVirusAppArrayHttp;", "instance$delegate", "Lkotlin/Lazy;", "mApiArrayCount", "", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        @d
        public final SearchVirusAppArrayHttp getInstance() {
            s sVar = SearchVirusAppArrayHttp.instance$delegate;
            Companion companion = SearchVirusAppArrayHttp.Companion;
            return (SearchVirusAppArrayHttp) sVar.getValue();
        }

        public /* synthetic */ Companion(h.q2.t.v vVar) {
            this();
        }
    }

    private SearchVirusAppArrayHttp() {
    }

    private final void dealResultItem(AppInfoBean appInfoBean, SearchVirusAppResultBean searchVirusAppResultBean, Callback callback) {
        int riskLevel = searchVirusAppResultBean.getRiskLevel();
        if (riskLevel == 1) {
            appInfoBean.setVirusLevel(2);
            appInfoBean.setVirusName(searchVirusAppResultBean.getVirusName());
            appInfoBean.setVirusDescription(searchVirusAppResultBean.getVirusDesc());
        } else {
            if (riskLevel != 2) {
                return;
            }
            appInfoBean.setVirusLevel(1);
            appInfoBean.setVirusName(searchVirusAppResultBean.getVirusName());
            appInfoBean.setVirusDescription(searchVirusAppResultBean.getVirusDesc());
        }
    }

    private final void getSignVirus(SearchVirusAppBean searchVirusAppBean) {
        AppSignBean appSignBeanD;
        if (searchVirusAppBean == null || (appSignBeanD = r1.d(searchVirusAppBean.getPkgName(), searchVirusAppBean.getFilePath())) == null) {
            return;
        }
        searchVirusAppBean.setSignMd5(appSignBeanD.getSignMD5());
        searchVirusAppBean.setSignSha1(appSignBeanD.getSignSha1());
        searchVirusAppBean.setSignSha256(appSignBeanD.getSignSha256());
    }

    private final void searchAppHttp(final List<? extends AppInfoBean> list, List<SearchVirusAppBean> list2, final Callback callback) {
        ModelPresent.searchVirusApp(d.a.a(ModuelConfig.MODEL_WARN, 6, b.h0), list2, new MiddleSubscriber<APIresult<List<? extends SearchVirusAppResultBean>>>() { // from class: network.http.SearchVirusAppArrayHttp.searchAppHttp.1
            @Override // network.MiddleSubscriber
            @d
            protected Type getType() {
                Type type = new com.google.gson.d0.a<List<? extends SearchVirusAppResultBean>>() { // from class: network.http.SearchVirusAppArrayHttp$searchAppHttp$1$getType$1
                }.getType();
                i0.a((Object) type, "object : TypeToken<List<…AppResultBean>>() {}.type");
                return type;
            }

            @Override // network.MiddleSubscriber
            protected void onErrorMiddle(@d APIException aPIException) {
                i0.f(aPIException, "e");
                callback.principalFail(aPIException.getMessage());
            }

            @Override // network.MiddleSubscriber
            protected void onNextMiddle(@e APIresult<List<SearchVirusAppResultBean>> aPIresult) {
                String msg;
                if (aPIresult != null) {
                    try {
                        int code = aPIresult.getCode();
                        if (code == -1) {
                            LoginManager.getInstance().exit();
                        } else if (code == 0) {
                            List<SearchVirusAppResultBean> data = aPIresult.getData();
                            Callback callback2 = callback;
                            List list3 = list;
                            callback2.principalRequestFinish(!(list3 == null || list3.isEmpty()) ? list.size() : 0, data == null || data.isEmpty());
                            if (!list.isEmpty()) {
                                if (data == null || data.isEmpty()) {
                                    return;
                                }
                                SearchVirusAppArrayHttp.this.dealResult(list, data, callback);
                                return;
                            }
                            return;
                        }
                        msg = aPIresult.getMsg();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    msg = "";
                }
                callback.principalFail(msg);
            }
        });
    }

    public final void dealResult(@e List<? extends AppInfoBean> list, @e List<SearchVirusAppResultBean> list2, @d Callback callback) {
        i0.f(callback, "callback");
        if (list == null || list.isEmpty()) {
            return;
        }
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        if (list.size() == 1 && list2.size() == 1) {
            dealResultItem(list.get(0), list2.get(0), callback);
            return;
        }
        HashMap map = new HashMap();
        int i2 = 0;
        for (AppInfoBean appInfoBean : list) {
            if (!TextUtils.isEmpty(appInfoBean.getAppMD5())) {
                String appMD5 = appInfoBean.getAppMD5();
                i0.a((Object) appMD5, "element.appMD5");
                Locale locale = Locale.getDefault();
                i0.a((Object) locale, "Locale.getDefault()");
                if (appMD5 == null) {
                    throw new e1("null cannot be cast to non-null type java.lang.String");
                }
                String upperCase = appMD5.toUpperCase(locale);
                i0.a((Object) upperCase, "(this as java.lang.String).toUpperCase(locale)");
                map.put(upperCase, Integer.valueOf(i2));
            }
            i2++;
        }
        boolean z = false;
        for (SearchVirusAppResultBean searchVirusAppResultBean : list2) {
            if (!map.isEmpty()) {
                Integer num = -1;
                String fileMd5 = searchVirusAppResultBean.getFileMd5();
                Locale locale2 = Locale.getDefault();
                i0.a((Object) locale2, "Locale.getDefault()");
                if (fileMd5 == null) {
                    throw new e1("null cannot be cast to non-null type java.lang.String");
                }
                String upperCase2 = fileMd5.toUpperCase(locale2);
                i0.a((Object) upperCase2, "(this as java.lang.String).toUpperCase(locale)");
                if (map.get(upperCase2) != null) {
                    num = (Integer) map.get(upperCase2);
                    z = true;
                }
                if (num != null && num.intValue() > -1) {
                    dealResultItem(list.get(num.intValue()), searchVirusAppResultBean, callback);
                }
            }
        }
        if (z) {
            callback.principalRiskResult(true);
        } else {
            callback.principalRequestFinish(list == null || list.isEmpty() ? 0 : list.size(), true);
        }
    }

    public final void principalHttp(@d List<? extends AppInfoBean> list, @d Callback callback) {
        i0.f(list, "appList");
        i0.f(callback, "callback");
        n1.b("本次扫描app个数-->" + list.size());
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            AppInfoBean appInfoBean = list.get(i2);
            try {
                SearchVirusAppBean searchVirusAppBean = new SearchVirusAppBean(appInfoBean.getName(), appInfoBean.getPkgName(), appInfoBean.getPkgPath(), appInfoBean.getAppMD5());
                getSignVirus(searchVirusAppBean);
                arrayList.add(searchVirusAppBean);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        searchAppHttp(list, arrayList, callback);
    }

    public /* synthetic */ SearchVirusAppArrayHttp(h.q2.t.v vVar) {
        this();
    }
}
