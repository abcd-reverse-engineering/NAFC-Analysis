package network.http;

import android.text.TextUtils;
import bean.AppInfoBean;
import bean.AppSignBean;
import bean.SearchVirusAppBean;
import bean.SearchVirusAppResultBean;
import bean.module.ModuelConfig;
import bean.module.RegionMudelBean;
import e.b;
import h.q2.s.a;
import h.q2.t.i0;
import h.s;
import h.v;
import h.x;
import h.y;
import i.c.a.d;
import i.c.a.e;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import manager.LoginManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.model.ModelPresent;
import util.o1;
import util.r1;

/* compiled from: SearchVirusAppHttp.kt */
@y(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0002\u0013\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J&\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J$\u0010\u0012\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006\u0015"}, d2 = {"Lnetwork/http/SearchVirusAppHttp;", "", "()V", "getMd5", "", "oldMd5", "filePath", "getSignVirus", "", "virusBean", "Lbean/SearchVirusAppBean;", "installSearchAppHttp", "appInfoBean", "Lbean/AppInfoBean;", "list", "", "callback", "Lnetwork/http/SearchVirusAppHttp$Callback;", "principalHttp", "Callback", "Companion", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SearchVirusAppHttp {
    public static final Companion Companion = new Companion(null);

    @d
    private static final s instance$delegate = v.a(x.SYNCHRONIZED, (a) SearchVirusAppHttp$Companion$instance$2.INSTANCE);

    /* compiled from: SearchVirusAppHttp.kt */
    @y(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&¨\u0006\t"}, d2 = {"Lnetwork/http/SearchVirusAppHttp$Callback;", "", "principalResult", "", "appInfoBean", "Lbean/AppInfoBean;", "result", "", "Lbean/SearchVirusAppResultBean;", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
    public interface Callback {
        void principalResult(@e AppInfoBean appInfoBean, @e List<SearchVirusAppResultBean> list);
    }

    /* compiled from: SearchVirusAppHttp.kt */
    @y(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lnetwork/http/SearchVirusAppHttp$Companion;", "", "()V", "instance", "Lnetwork/http/SearchVirusAppHttp;", "getInstance", "()Lnetwork/http/SearchVirusAppHttp;", "instance$delegate", "Lkotlin/Lazy;", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        @d
        public final SearchVirusAppHttp getInstance() {
            s sVar = SearchVirusAppHttp.instance$delegate;
            Companion companion = SearchVirusAppHttp.Companion;
            return (SearchVirusAppHttp) sVar.getValue();
        }

        public /* synthetic */ Companion(h.q2.t.v vVar) {
            this();
        }
    }

    private SearchVirusAppHttp() {
    }

    private final String getMd5(String str, String str2) throws NoSuchAlgorithmException, IOException {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            String strA = o1.a(new File(str2));
            i0.a((Object) strA, "MD5Utils.getFileMD5(File(filePath))");
            return strA;
        }
        if (str != null) {
            return str;
        }
        i0.f();
        return str;
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

    private final void installSearchAppHttp(final AppInfoBean appInfoBean, List<SearchVirusAppBean> list, final Callback callback) {
        RegionMudelBean regionMudelBeanJ = d.a.j();
        String str = b.h0;
        if (regionMudelBeanJ != null && TextUtils.equals(d.a.b(ModuelConfig.MODEL_WARN), "1")) {
            str = b.i0;
        }
        ModelPresent.searchVirusApp(d.a.a(ModuelConfig.MODEL_WARN, 6, str), list, new MiddleSubscriber<APIresult<List<? extends SearchVirusAppResultBean>>>() { // from class: network.http.SearchVirusAppHttp.installSearchAppHttp.1
            @Override // network.MiddleSubscriber
            @d
            protected Type getType() {
                Type type = new com.google.gson.d0.a<List<? extends SearchVirusAppResultBean>>() { // from class: network.http.SearchVirusAppHttp$installSearchAppHttp$1$getType$1
                }.getType();
                i0.a((Object) type, "object : TypeToken<List<…AppResultBean>>() {}.type");
                return type;
            }

            @Override // network.MiddleSubscriber
            protected void onErrorMiddle(@d APIException aPIException) {
                i0.f(aPIException, "e");
                callback.principalResult(null, null);
            }

            @Override // network.MiddleSubscriber
            protected void onNextMiddle(@e APIresult<List<SearchVirusAppResultBean>> aPIresult) {
                if (aPIresult == null) {
                    APIException apiExcept = APIException.getApiExcept();
                    i0.a((Object) apiExcept, "APIException.getApiExcept()");
                    onErrorMiddle(apiExcept);
                    return;
                }
                int code = aPIresult.getCode();
                if (code == -1) {
                    LoginManager.getInstance().exit();
                } else if (code != 0) {
                    callback.principalResult(null, null);
                } else {
                    callback.principalResult(appInfoBean, aPIresult.getData());
                }
            }
        });
    }

    public final void principalHttp(@d AppInfoBean appInfoBean, @d List<SearchVirusAppBean> list, @d Callback callback) {
        i0.f(appInfoBean, "appInfoBean");
        i0.f(list, "list");
        i0.f(callback, "callback");
        if (!list.isEmpty()) {
            for (SearchVirusAppBean searchVirusAppBean : list) {
                getSignVirus(searchVirusAppBean);
                try {
                    if (TextUtils.isEmpty(searchVirusAppBean.getFileMd5())) {
                        searchVirusAppBean.setFileMd5(getMd5(appInfoBean.getAppMD5(), searchVirusAppBean.getFilePath()));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        installSearchAppHttp(appInfoBean, list, callback);
    }

    public /* synthetic */ SearchVirusAppHttp(h.q2.t.v vVar) {
        this();
    }
}
