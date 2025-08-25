package bean.module;

import bean.WhiteTelBean;
import com.google.gson.d0.a;
import com.google.gson.e;
import interfaces.IResultCallback;
import interfaces.IResultMuCallback;
import java.io.IOException;
import java.util.List;
import manager.AccountManager;
import ui.presenter.WelocmPresenter;
import util.f1;
import util.p1;

/* loaded from: classes.dex */
public class LocalModuelConfig extends ModuelConfig {
    public static String ISHAVE_LOCAL = "sucess_get_config";
    public static String LASTCONFIG = "lastConfig";

    private static class SingleHodle {
        private static final LocalModuelConfig mConfig = new LocalModuelConfig();

        private SingleHodle() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void collectWhiteList(RegionMudelBean regionMudelBean) {
        List<WhiteTelBean> whiteTelList;
        if (regionMudelBean == null || (whiteTelList = regionMudelBean.getWhiteTelList()) == null || whiteTelList.size() <= 0) {
            return;
        }
        List<WhiteTelBean> list = WelocmPresenter.whiteTelList;
        if (list == null) {
            WelocmPresenter.whiteTelList = whiteTelList;
            return;
        }
        list.clear();
        WelocmPresenter.whiteTelList.addAll(WelocmPresenter.whiteList);
        WelocmPresenter.whiteTelList.addAll(whiteTelList);
    }

    public static LocalModuelConfig getInstance() {
        return SingleHodle.mConfig;
    }

    public RegionMudelBean getConfigJson() throws IOException {
        RegionMudelBean regionMudelBean = (RegionMudelBean) new e().a(f1.a("config.json", "UTF-8"), new a<RegionMudelBean>() { // from class: bean.module.LocalModuelConfig.1
        }.getType());
        p1.b(ISHAVE_LOCAL, 1);
        p1.a(regionMudelBean.getJsonRegionCode(), regionMudelBean);
        p1.a(LASTCONFIG, regionMudelBean);
        d.a.c();
        d.a.d();
        collectWhiteList(regionMudelBean);
        return regionMudelBean;
    }

    public void getConfigMude(String str, final IResultCallback iResultCallback) {
        getConfigMude(str, new IResultMuCallback() { // from class: bean.module.LocalModuelConfig.2
            @Override // interfaces.IResultMuCallback
            public void onIRFail() {
            }

            @Override // interfaces.IResultMuCallback
            public void onIRSuccess(RegionMudelBean regionMudelBean, boolean z) {
                if (z) {
                    p1.b(LocalModuelConfig.ISHAVE_LOCAL, 1);
                    p1.a(LocalModuelConfig.LASTCONFIG, regionMudelBean);
                } else {
                    p1.b(LocalModuelConfig.ISHAVE_LOCAL, 1);
                    p1.a(regionMudelBean.getJsonRegionCode(), regionMudelBean);
                    p1.a(LocalModuelConfig.LASTCONFIG, regionMudelBean);
                }
                d.a.c();
                d.a.d();
                iResultCallback.onIRSuccess(regionMudelBean);
                LocalModuelConfig.this.collectWhiteList(regionMudelBean);
            }
        });
    }

    private LocalModuelConfig() {
    }

    public void getConfigMude(boolean z, final IResultCallback iResultCallback) {
        getConfigMude(z, AccountManager.getRegisterRegionCode(), new IResultMuCallback() { // from class: bean.module.LocalModuelConfig.3
            @Override // interfaces.IResultMuCallback
            public void onIRFail() {
            }

            @Override // interfaces.IResultMuCallback
            public void onIRSuccess(RegionMudelBean regionMudelBean, boolean z2) {
                if (z2) {
                    p1.b(LocalModuelConfig.ISHAVE_LOCAL, 1);
                    p1.a(LocalModuelConfig.LASTCONFIG, regionMudelBean);
                } else {
                    p1.b(LocalModuelConfig.ISHAVE_LOCAL, 1);
                    p1.a(regionMudelBean.getJsonRegionCode(), regionMudelBean);
                    p1.a(LocalModuelConfig.LASTCONFIG, regionMudelBean);
                }
                d.a.c();
                d.a.d();
                iResultCallback.onIRSuccess(regionMudelBean);
                LocalModuelConfig.this.collectWhiteList(regionMudelBean);
            }
        });
    }
}
