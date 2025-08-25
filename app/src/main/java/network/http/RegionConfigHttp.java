package network.http;

import android.app.Activity;
import android.text.TextUtils;
import ui.basemvp.BaseView;
import ui.model.ModelPresent;
import util.p1;

/* loaded from: classes2.dex */
public class RegionConfigHttp extends ModelPresent {
    private static RegionConfigHttp regionConfigHttp;

    private RegionConfigHttp(Activity activity, BaseView baseView) {
        super(activity, baseView);
    }

    public static boolean existNodeRegion() {
        return (TextUtils.isEmpty(getNodeRegionName()) || TextUtils.isEmpty(getNodeRegionId())) ? false : true;
    }

    public static RegionConfigHttp getInstance() {
        if (regionConfigHttp == null) {
            synchronized (RegionConfigHttp.class) {
                if (regionConfigHttp == null) {
                    regionConfigHttp = new RegionConfigHttp(null, null);
                }
            }
        }
        return regionConfigHttp;
    }

    public static String getNodeProvinceName() {
        String strA = p1.a(p1.f20896f);
        return TextUtils.isEmpty(strA) ? "" : strA;
    }

    public static String getNodeRegionId() {
        String strA = p1.a(p1.f20895e);
        return TextUtils.isEmpty(strA) ? "" : strA;
    }

    public static String getNodeRegionName() {
        String strA = p1.a(p1.f20897g);
        return TextUtils.isEmpty(strA) ? "" : strA;
    }

    public static void setNodeRegion(String str, String str2, String str3) {
        p1.a(p1.f20896f, str);
        p1.a(p1.f20897g, str2);
        p1.a(p1.f20895e, str3);
    }
}
