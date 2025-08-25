package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.g.g;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    private static final String f6798e = "a";

    /* renamed from: a, reason: collision with root package name */
    private final GrsBaseInfo f6799a;

    /* renamed from: b, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.a f6800b;

    /* renamed from: c, reason: collision with root package name */
    private g f6801c;

    /* renamed from: d, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.c f6802d;

    /* renamed from: com.huawei.hms.framework.network.grs.a$a, reason: collision with other inner class name */
    private static class C0105a implements com.huawei.hms.framework.network.grs.b {

        /* renamed from: a, reason: collision with root package name */
        String f6803a;

        /* renamed from: b, reason: collision with root package name */
        Map<String, String> f6804b;

        /* renamed from: c, reason: collision with root package name */
        IQueryUrlsCallBack f6805c;

        /* renamed from: d, reason: collision with root package name */
        Context f6806d;

        /* renamed from: e, reason: collision with root package name */
        GrsBaseInfo f6807e;

        /* renamed from: f, reason: collision with root package name */
        com.huawei.hms.framework.network.grs.e.a f6808f;

        C0105a(String str, Map<String, String> map, IQueryUrlsCallBack iQueryUrlsCallBack, Context context, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar) {
            this.f6803a = str;
            this.f6804b = map;
            this.f6805c = iQueryUrlsCallBack;
            this.f6806d = context;
            this.f6807e = grsBaseInfo;
            this.f6808f = aVar;
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a() {
            Map<String, String> map = this.f6804b;
            if (map != null && !map.isEmpty()) {
                Logger.i(a.f6798e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f6803a, StringUtils.anonymizeMessage(new JSONObject(this.f6804b).toString()));
                this.f6805c.onCallBackSuccess(this.f6804b);
                return;
            }
            if (this.f6804b != null) {
                Logger.i(a.f6798e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", this.f6803a);
                this.f6805c.onCallBackFail(-3);
                return;
            }
            Logger.i(a.f6798e, "GrsClientManager.ayncGetGrsUrls: Get URL from Local JSON File");
            Map<String, String> mapA = com.huawei.hms.framework.network.grs.f.b.a(this.f6806d.getPackageName()).a(this.f6806d, this.f6808f, this.f6807e, this.f6803a, true);
            if (mapA == null || mapA.isEmpty()) {
                Logger.e(a.f6798e, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", this.f6803a);
            }
            if (mapA == null) {
                mapA = new ConcurrentHashMap<>();
            }
            Logger.i(a.f6798e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f6803a, StringUtils.anonymizeMessage(new JSONObject(mapA).toString()));
            this.f6805c.onCallBackSuccess(mapA);
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a(com.huawei.hms.framework.network.grs.g.d dVar) {
            IQueryUrlsCallBack iQueryUrlsCallBack;
            String strJ = dVar.j();
            Map<String, String> mapA = a.a(strJ, this.f6803a);
            if (mapA.isEmpty()) {
                Map<String, String> map = this.f6804b;
                if (map == null || map.isEmpty()) {
                    if (this.f6804b != null) {
                        Logger.i(a.f6798e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", this.f6803a);
                        this.f6805c.onCallBackFail(-5);
                        return;
                    }
                    if (!TextUtils.isEmpty(strJ)) {
                        Logger.e(a.f6798e, "The serviceName[%s] is not configured on the GRS server.", this.f6803a);
                    }
                    Logger.i(a.f6798e, "GrsClientManager.ayncGetGrsUrls: Get URL from Local JSON File");
                    Map<String, String> mapA2 = com.huawei.hms.framework.network.grs.f.b.a(this.f6806d.getPackageName()).a(this.f6806d, this.f6808f, this.f6807e, this.f6803a, true);
                    if (mapA2 == null || mapA2.isEmpty()) {
                        Logger.e(a.f6798e, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", this.f6803a);
                    }
                    if (mapA2 == null) {
                        mapA2 = new ConcurrentHashMap<>();
                    }
                    Logger.i(a.f6798e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f6803a, StringUtils.anonymizeMessage(new JSONObject(mapA2).toString()));
                    this.f6805c.onCallBackSuccess(mapA2);
                    return;
                }
                Logger.i(a.f6798e, "GrsClientManager.ayncGetGrsUrls: Return [%s][%s] Url: %s", this.f6803a, StringUtils.anonymizeMessage(new JSONObject(this.f6804b).toString()));
                iQueryUrlsCallBack = this.f6805c;
                mapA = this.f6804b;
            } else {
                Logger.i(a.f6798e, "GrsClientManager.ayncGetGrsUrls: Get URL from Current Called GRS Server Return [%s] Urls: %s", this.f6803a, StringUtils.anonymizeMessage(new JSONObject(mapA).toString()));
                iQueryUrlsCallBack = this.f6805c;
            }
            iQueryUrlsCallBack.onCallBackSuccess(mapA);
        }
    }

    private static class b implements com.huawei.hms.framework.network.grs.b {

        /* renamed from: a, reason: collision with root package name */
        String f6809a;

        /* renamed from: b, reason: collision with root package name */
        String f6810b;

        /* renamed from: c, reason: collision with root package name */
        IQueryUrlCallBack f6811c;

        /* renamed from: d, reason: collision with root package name */
        String f6812d;

        /* renamed from: e, reason: collision with root package name */
        Context f6813e;

        /* renamed from: f, reason: collision with root package name */
        GrsBaseInfo f6814f;

        /* renamed from: g, reason: collision with root package name */
        com.huawei.hms.framework.network.grs.e.a f6815g;

        b(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, String str3, Context context, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar) {
            this.f6809a = str;
            this.f6810b = str2;
            this.f6811c = iQueryUrlCallBack;
            this.f6812d = str3;
            this.f6813e = context;
            this.f6814f = grsBaseInfo;
            this.f6815g = aVar;
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a() {
            if (!TextUtils.isEmpty(this.f6812d)) {
                Logger.i(a.f6798e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f6809a, this.f6810b, StringUtils.anonymizeMessage(this.f6812d));
                this.f6811c.onCallBackSuccess(this.f6812d);
                return;
            }
            if (!TextUtils.isEmpty(this.f6812d)) {
                Logger.i(a.f6798e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", this.f6809a, this.f6810b);
                this.f6811c.onCallBackFail(-3);
                return;
            }
            Logger.i(a.f6798e, "GrsClientManager.ayncGetGrsUrl: Get URL from Local JSON File");
            String strA = com.huawei.hms.framework.network.grs.f.b.a(this.f6813e.getPackageName()).a(this.f6813e, this.f6815g, this.f6814f, this.f6809a, this.f6810b, true);
            if (strA == null || strA.isEmpty()) {
                Logger.e(a.f6798e, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", this.f6809a, this.f6810b);
            }
            Logger.i(a.f6798e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f6809a, this.f6810b, StringUtils.anonymizeMessage(strA));
            this.f6811c.onCallBackSuccess(strA);
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a(com.huawei.hms.framework.network.grs.g.d dVar) {
            IQueryUrlCallBack iQueryUrlCallBack;
            String str;
            String strJ = dVar.j();
            Map<String, String> mapA = a.a(strJ, this.f6809a);
            if (mapA.containsKey(this.f6810b)) {
                String str2 = a.f6798e;
                String str3 = this.f6810b;
                Logger.i(str2, "GrsClientManager.ayncGetGrsUrl: Get URL from Current Called GRS Server, Return [%s][%s] Url: %s", this.f6809a, str3, StringUtils.anonymizeMessage(mapA.get(str3)));
                iQueryUrlCallBack = this.f6811c;
                str = mapA.get(this.f6810b);
            } else {
                if (TextUtils.isEmpty(this.f6812d)) {
                    if (!TextUtils.isEmpty(this.f6812d)) {
                        Logger.i(a.f6798e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", this.f6809a, this.f6810b);
                        this.f6811c.onCallBackFail(-5);
                        return;
                    }
                    if (!TextUtils.isEmpty(strJ)) {
                        Logger.e(a.f6798e, "The serviceName[%s][%s] is not configured on the GRS server.", this.f6809a, this.f6810b);
                    }
                    Logger.i(a.f6798e, "GrsClientManager.ayncGetGrsUrl: Get URL from Local JSON File");
                    String strA = com.huawei.hms.framework.network.grs.f.b.a(this.f6813e.getPackageName()).a(this.f6813e, this.f6815g, this.f6814f, this.f6809a, this.f6810b, true);
                    if (strA == null || strA.isEmpty()) {
                        Logger.e(a.f6798e, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", this.f6809a, this.f6810b);
                    }
                    Logger.i(a.f6798e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f6809a, this.f6810b, StringUtils.anonymizeMessage(strA));
                    this.f6811c.onCallBackSuccess(strA);
                    return;
                }
                String str4 = a.f6798e;
                String str5 = this.f6810b;
                Logger.i(str4, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f6809a, str5, StringUtils.anonymizeMessage(mapA.get(str5)));
                iQueryUrlCallBack = this.f6811c;
                str = this.f6812d;
            }
            iQueryUrlCallBack.onCallBackSuccess(str);
        }
    }

    public a(GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar, g gVar, com.huawei.hms.framework.network.grs.e.c cVar) {
        this.f6799a = grsBaseInfo;
        this.f6800b = aVar;
        this.f6801c = gVar;
        this.f6802d = cVar;
    }

    public static CountryCodeBean a(Context context, boolean z) {
        return new CountryCodeBean(context, z);
    }

    public static Map<String, Map<String, String>> a(String str) throws JSONException {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        if (TextUtils.isEmpty(str)) {
            Logger.v(f6798e, "isSpExpire jsonValue is null.");
            return concurrentHashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                if (!TextUtils.isEmpty(next)) {
                    concurrentHashMap.put(next, a(jSONObject2));
                }
            }
            return concurrentHashMap;
        } catch (JSONException e2) {
            Logger.w(f6798e, "getServicesUrlsMap occur a JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return concurrentHashMap;
        }
    }

    private Map<String, String> a(String str, com.huawei.hms.framework.network.grs.e.b bVar, Context context) {
        Map<String, String> mapA = this.f6800b.a(this.f6799a, str, bVar, context);
        if (mapA != null && !mapA.isEmpty()) {
            Logger.i(f6798e, "GrsClientManager.getUrlsLocal: Get URL from GRS Server Cache");
            return mapA;
        }
        Map<String, String> mapA2 = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName()).a(context, this.f6800b, this.f6799a, str, false);
        Logger.i(f6798e, "GrsClientManager.getUrlsLocal: Get URL from Local JSON File");
        return mapA2 != null ? mapA2 : new HashMap();
    }

    public static Map<String, String> a(String str, String str2) {
        HashMap map = new HashMap();
        if (TextUtils.isEmpty(str)) {
            Logger.w(f6798e, "isSpExpire jsonValue from server is null.");
            return map;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.has(str2) ? jSONObject.getJSONObject(str2) : null;
            if (jSONObject2 == null) {
                Logger.w(f6798e, "getServiceNameUrls: paser null from server json data by {%s}.", str2);
                return map;
            }
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject2.get(next).toString());
            }
            return map;
        } catch (JSONException e2) {
            Logger.w(f6798e, "Method{getServiceNameUrls} query url from SP occur an JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return map;
        }
    }

    public static Map<String, String> a(JSONObject jSONObject) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String string = jSONObject.get(next).toString();
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string)) {
                    concurrentHashMap.put(next, string);
                }
            }
            return concurrentHashMap;
        } catch (JSONException e2) {
            Logger.w(f6798e, "getServiceUrls occur a JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return concurrentHashMap;
        }
    }

    public String a(Context context, String str, int i2) {
        com.huawei.hms.framework.network.grs.g.d dVarA = this.f6801c.a(new com.huawei.hms.framework.network.grs.g.j.c(this.f6799a, context), str, this.f6802d, i2);
        return dVarA == null ? "" : dVarA.m() ? this.f6800b.a().a(this.f6799a.getGrsParasKey(true, true, context), "") : dVarA.j();
    }

    public String a(String str, String str2, Context context, int i2) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        String strA = a(str, bVar, context).get(str2);
        if (bVar.a() && !TextUtils.isEmpty(strA)) {
            Logger.i(f6798e, "GrsClientManager.synGetGrsUrl: Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(strA));
            return strA;
        }
        String strA2 = a(context, str, i2);
        String str3 = a(strA2, str).get(str2);
        if (!TextUtils.isEmpty(str3)) {
            Logger.i(f6798e, "GrsClientManager.synGetGrsUrl: Get URL from Current Called GRS Server, Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(str3));
            return str3;
        }
        if (TextUtils.isEmpty(strA)) {
            if (!TextUtils.isEmpty(strA2)) {
                Logger.e(f6798e, "The serviceName[%s][%s] is not configured on the GRS server.", str, str2);
            }
            Logger.i(f6798e, "GrsClientManager.synGetGrsUrl: Get URL from Local JSON File.");
            strA = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName()).a(context, this.f6800b, this.f6799a, str, str2, true);
            if (strA == null || strA.isEmpty()) {
                Logger.e(f6798e, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", str, str2);
            }
        }
        Logger.i(f6798e, "GrsClientManager.synGetGrsUrl: Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(strA));
        return strA;
    }

    public Map<String, String> a(String str, Context context, int i2) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        Map<String, String> mapA = a(str, bVar, context);
        if (bVar.a() && !mapA.isEmpty()) {
            Logger.i(f6798e, "Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(mapA).toString()));
            return mapA;
        }
        String strA = a(context, str, i2);
        Map<String, String> mapA2 = a(strA, str);
        if (!mapA2.isEmpty()) {
            Logger.i(f6798e, "GrsClientManager.synGetGrsUrls: Get URL from Current Called GRS Server Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(mapA2).toString()));
            return mapA2;
        }
        if (mapA.isEmpty()) {
            if (!TextUtils.isEmpty(strA)) {
                Logger.e(f6798e, "The serviceName[%s] is not configured on the GRS server.", str);
            }
            Logger.i(f6798e, "GrsClientManager.synGetGrsUrls: Get URL from Local JSON File.");
            mapA = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName()).a(context, this.f6800b, this.f6799a, str, true);
            if (mapA == null || mapA.isEmpty()) {
                Logger.e(f6798e, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", str);
            }
        }
        String str2 = f6798e;
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = StringUtils.anonymizeMessage(mapA != null ? new JSONObject(mapA).toString() : "");
        Logger.i(str2, "GrsClientManager.synGetGrsUrls: Return [%s] Urls: %s", objArr);
        return mapA;
    }

    public void a(String str, IQueryUrlsCallBack iQueryUrlsCallBack, Context context, int i2) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        Map<String, String> mapA = a(str, bVar, context);
        if (!bVar.a()) {
            this.f6801c.a(new com.huawei.hms.framework.network.grs.g.j.c(this.f6799a, context), new C0105a(str, mapA, iQueryUrlsCallBack, context, this.f6799a, this.f6800b), str, this.f6802d, i2);
            return;
        }
        if (mapA.isEmpty()) {
            Logger.i(f6798e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", str);
            iQueryUrlsCallBack.onCallBackFail(-5);
        } else {
            Logger.i(f6798e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(mapA).toString()));
            Logger.i(f6798e, "ayncGetGrsUrls: %s", StringUtils.anonymizeMessage(new JSONObject(mapA).toString()));
            iQueryUrlsCallBack.onCallBackSuccess(mapA);
        }
    }

    public void a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, Context context, int i2) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        String str3 = a(str, bVar, context).get(str2);
        if (!bVar.a()) {
            this.f6801c.a(new com.huawei.hms.framework.network.grs.g.j.c(this.f6799a, context), new b(str, str2, iQueryUrlCallBack, str3, context, this.f6799a, this.f6800b), str, this.f6802d, i2);
        } else if (TextUtils.isEmpty(str3)) {
            Logger.i(f6798e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", str, str2);
            iQueryUrlCallBack.onCallBackFail(-5);
        } else {
            Logger.i(f6798e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(str3));
            iQueryUrlCallBack.onCallBackSuccess(str3);
        }
    }
}
