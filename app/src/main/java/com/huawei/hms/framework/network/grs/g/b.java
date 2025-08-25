package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import org.json.JSONException;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f6860a;

    /* renamed from: b, reason: collision with root package name */
    private final GrsBaseInfo f6861b;

    /* renamed from: c, reason: collision with root package name */
    private final com.huawei.hms.framework.network.grs.e.a f6862c;

    public b(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo) {
        this.f6860a = context;
        this.f6861b = grsBaseInfo;
        this.f6862c = aVar;
    }

    public String a(boolean z) {
        String str = com.huawei.hms.framework.network.grs.a.a(this.f6862c.a().a("geoipCountryCode", ""), "geoip.countrycode").get("ROOT");
        Logger.i("GeoipCountry", "geoIpCountry is: " + str);
        String strA = this.f6862c.a().a("geoipCountryCodetime", "0");
        long j2 = 0;
        if (!TextUtils.isEmpty(strA) && strA.matches("\\d+")) {
            try {
                j2 = Long.parseLong(strA);
            } catch (NumberFormatException e2) {
                Logger.w("GeoipCountry", "convert urlParamKey from String to Long catch NumberFormatException.", e2);
            }
        }
        if (TextUtils.isEmpty(str) || com.huawei.hms.framework.network.grs.h.e.a(Long.valueOf(j2))) {
            com.huawei.hms.framework.network.grs.g.j.c cVar = new com.huawei.hms.framework.network.grs.g.j.c(this.f6861b, this.f6860a);
            cVar.a("geoip.countrycode");
            com.huawei.hms.framework.network.grs.e.c cVarC = this.f6862c.c();
            if (cVarC != null) {
                String strA2 = null;
                try {
                    strA2 = h.a(cVarC.a("services", ""), cVar.c());
                } catch (JSONException e3) {
                    Logger.w("GeoipCountry", "getGeoipCountry merge services occure jsonException. %s", StringUtils.anonymizeMessage(e3.getMessage()));
                }
                if (!TextUtils.isEmpty(strA2)) {
                    cVarC.b("services", strA2);
                }
            }
            if (z) {
                d dVarA = this.f6862c.b().a(cVar, "geoip.countrycode", cVarC, -1);
                if (dVarA != null) {
                    str = com.huawei.hms.framework.network.grs.a.a(dVarA.j(), "geoip.countrycode").get("ROOT");
                }
                Logger.i("GeoipCountry", "sync request to query geoip.countrycode is:" + str);
            } else {
                Logger.i("GeoipCountry", "async request to query geoip.countrycode");
                this.f6862c.b().a(cVar, null, "geoip.countrycode", cVarC, -1);
            }
        }
        return str;
    }
}
