package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.config.ConfigReader;
import com.huawei.agconnect.core.Service;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b implements AGConnectOptions {

    /* renamed from: a, reason: collision with root package name */
    private final String f6374a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f6375b;

    /* renamed from: c, reason: collision with root package name */
    private final String f6376c;

    /* renamed from: d, reason: collision with root package name */
    private final AGCRoutePolicy f6377d;

    /* renamed from: e, reason: collision with root package name */
    private final ConfigReader f6378e;

    /* renamed from: f, reason: collision with root package name */
    private final e f6379f;

    /* renamed from: g, reason: collision with root package name */
    private final Map<String, String> f6380g;

    /* renamed from: h, reason: collision with root package name */
    private final List<Service> f6381h;

    /* renamed from: i, reason: collision with root package name */
    private final Map<String, String> f6382i = new HashMap();

    public b(Context context, String str, AGCRoutePolicy aGCRoutePolicy, InputStream inputStream, Map<String, String> map, List<Service> list, String str2) throws IOException {
        this.f6375b = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        str = str == null ? this.f6375b.getPackageName() : str;
        this.f6376c = str;
        if (inputStream != null) {
            this.f6378e = new i(inputStream, str);
            Utils.closeQuietly(inputStream);
        } else {
            this.f6378e = new m(this.f6375b, str);
        }
        this.f6379f = new e(this.f6378e);
        if (aGCRoutePolicy != AGCRoutePolicy.UNKNOWN && "1.0".equals(this.f6378e.getString("/configuration_version", null))) {
            throw new RuntimeException("The file version does not match,please download the latest agconnect-services.json from the AGC website.");
        }
        this.f6377d = (aGCRoutePolicy == null || aGCRoutePolicy == AGCRoutePolicy.UNKNOWN) ? Utils.getRoutePolicyFromJson(this.f6378e.getString("/region", null), this.f6378e.getString("/agcgw/url", null)) : aGCRoutePolicy;
        this.f6380g = Utils.fixKeyPathMap(map);
        this.f6381h = list;
        this.f6374a = str2 == null ? b() : str2;
    }

    private String a(String str) {
        Map<String, JsonProcessingFactory.JsonProcessor> processors = JsonProcessingFactory.getProcessors();
        if (!processors.containsKey(str)) {
            return null;
        }
        if (this.f6382i.containsKey(str)) {
            return this.f6382i.get(str);
        }
        JsonProcessingFactory.JsonProcessor jsonProcessor = processors.get(str);
        if (jsonProcessor == null) {
            return null;
        }
        String strProcessOption = jsonProcessor.processOption(this);
        this.f6382i.put(str, strProcessOption);
        return strProcessOption;
    }

    private String b() {
        return String.valueOf(("{packageName='" + this.f6376c + "', routePolicy=" + this.f6377d + ", reader=" + this.f6378e.toString().hashCode() + ", customConfigMap=" + new JSONObject(this.f6380g).toString().hashCode() + '}').hashCode());
    }

    public List<Service> a() {
        return this.f6381h;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public boolean getBoolean(String str, boolean z) {
        return Boolean.parseBoolean(getString(str, String.valueOf(z)));
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public Context getContext() {
        return this.f6375b;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getIdentifier() {
        return this.f6374a;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public int getInt(String str) {
        return getInt(str, 0);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public int getInt(String str, int i2) {
        try {
            return Integer.parseInt(getString(str, String.valueOf(i2)));
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getPackageName() {
        return this.f6376c;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public AGCRoutePolicy getRoutePolicy() {
        AGCRoutePolicy aGCRoutePolicy = this.f6377d;
        return aGCRoutePolicy == null ? AGCRoutePolicy.UNKNOWN : aGCRoutePolicy;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getString(String str) {
        return getString(str, null);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getString(String str, String str2) {
        if (str == null) {
            return str2;
        }
        String strFixPath = Utils.fixPath(str);
        String str3 = this.f6380g.get(strFixPath);
        if (str3 != null) {
            return str3;
        }
        String strA = a(strFixPath);
        if (strA != null) {
            return strA;
        }
        String string = this.f6378e.getString(strFixPath, str2);
        return e.a(string) ? this.f6379f.decrypt(string, str2) : string;
    }
}
