package bean.module;

import android.app.Activity;
import android.text.TextUtils;
import bean.RegionConfigBean;
import com.google.gson.e;
import d.a;
import e.b;
import interfaces.IResultMuCallback;
import java.lang.reflect.Type;
import java.util.HashMap;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.basemvp.BaseView;
import ui.model.ModelPresent;
import util.p1;
import util.w1;

/* loaded from: classes.dex */
public class ModuelConfig extends ModelPresent {
    public static final String MODEL_CASEXC = "1012";
    public static final String MODEL_FEEDBACK = "1018";
    public static final String MODEL_FRAUDCHECK = "1015";
    public static final String MODEL_IDVERIFY = "1014";
    public static final String MODEL_LOCALNEWS = "1019";
    public static final String MODEL_MANUAL = "1016";
    public static final String MODEL_REPORT = "1011";
    public static final String MODEL_VIRUS_KILL = "1017";
    public static final String MODEL_WARN = "1013";
    public static String OTYPE1 = "1";
    public static String OTYPE2 = "2";
    public static String OTYPE3 = "3";
    public static String OTYPE4 = "4";

    public ModuelConfig() {
        super((Activity) null, (BaseView) null);
    }

    public void getConfigMude(String str, IResultMuCallback iResultMuCallback) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        getRegionJsonApi(false, str, iResultMuCallback);
    }

    public void getRegionJsonApi(final boolean z, String str, final IResultMuCallback iResultMuCallback) {
        String str2 = a.f13518d + b.f13567e;
        HashMap<String, String> map = new HashMap<>();
        map.put("regionCode", str);
        getRegionJson(str2, map, new MiddleSubscriber<APIresult<RegionConfigBean>>() { // from class: bean.module.ModuelConfig.1
            @Override // network.MiddleSubscriber
            protected Type getType() {
                return RegionConfigBean.class;
            }

            @Override // network.MiddleSubscriber
            protected void onErrorMiddle(APIException aPIException) {
                super.onErrorMiddle(aPIException);
                w1.a(aPIException.getMessage());
                iResultMuCallback.onIRFail();
            }

            @Override // network.MiddleSubscriber
            protected void onNextMiddle(APIresult<RegionConfigBean> aPIresult) {
                super.onNextMiddle(aPIresult);
                if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                    onErrorMiddle(APIException.getApiExcept());
                    return;
                }
                RegionConfigBean data = aPIresult.getData();
                if (TextUtils.isEmpty(data.getJsonRegionCode())) {
                    data.setJsonRegionCode("default_nation");
                }
                if (z) {
                    ModuelConfig.this.getRegionJsonData(data, iResultMuCallback);
                    return;
                }
                RegionMudelBean regionMudelBean = (RegionMudelBean) p1.a(data.getJsonRegionCode(), RegionMudelBean.class);
                if (regionMudelBean == null) {
                    ModuelConfig.this.getRegionJsonData(data, iResultMuCallback);
                } else if (TextUtils.equals(data.getJsonVersion(), regionMudelBean.getJsonVersion())) {
                    iResultMuCallback.onIRSuccess(regionMudelBean, true);
                } else {
                    ModuelConfig.this.getRegionJsonData(data, iResultMuCallback);
                }
            }
        });
    }

    public void getRegionJsonData(final RegionConfigBean regionConfigBean, final IResultMuCallback iResultMuCallback) {
        String str = a.f13518d + b.f13568f;
        HashMap<String, String> map = new HashMap<>();
        map.put("jsonRegionCode", regionConfigBean.getJsonRegionCode());
        map.put("jsonVersion", regionConfigBean.getJsonVersion());
        getRegionJsonData(str, map, new MiddleSubscriber<APIresult<String>>() { // from class: bean.module.ModuelConfig.2
            @Override // network.MiddleSubscriber
            protected Type getType() {
                return String.class;
            }

            @Override // network.MiddleSubscriber
            protected void onErrorMiddle(APIException aPIException) {
                super.onErrorMiddle(aPIException);
                w1.a(aPIException.getMessage());
                iResultMuCallback.onIRFail();
            }

            @Override // network.MiddleSubscriber
            protected void onNextMiddle(APIresult<String> aPIresult) {
                RegionMudelBean regionMudelBean;
                super.onNextMiddle(aPIresult);
                if (aPIresult.getCode() != 0) {
                    onErrorMiddle(APIException.getApiExcept());
                    return;
                }
                String data = aPIresult.getData();
                try {
                    if (!TextUtils.isEmpty(data) && (regionMudelBean = (RegionMudelBean) new e().a(data, new com.google.gson.d0.a<RegionMudelBean>() { // from class: bean.module.ModuelConfig.2.1
                    }.getType())) != null) {
                        regionMudelBean.setJsonRegionCode(regionConfigBean.getJsonRegionCode());
                        regionMudelBean.setJsonVersion(regionConfigBean.getJsonVersion());
                        iResultMuCallback.onIRSuccess(regionMudelBean, false);
                        return;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                iResultMuCallback.onIRSuccess(new RegionMudelBean(), false);
            }
        });
    }

    public void getConfigMude(boolean z, String str, IResultMuCallback iResultMuCallback) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        getRegionJsonApi(z, str, iResultMuCallback);
    }
}
