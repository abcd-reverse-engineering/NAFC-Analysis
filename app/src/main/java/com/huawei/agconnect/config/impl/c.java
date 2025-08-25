package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.ConfigReader;
import com.huawei.agconnect.config.LazyInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class c extends AGConnectServicesConfig {

    /* renamed from: a, reason: collision with root package name */
    private final Context f6383a;

    /* renamed from: b, reason: collision with root package name */
    private final String f6384b;

    /* renamed from: c, reason: collision with root package name */
    private LazyInputStream f6385c;

    /* renamed from: d, reason: collision with root package name */
    private volatile ConfigReader f6386d;

    /* renamed from: e, reason: collision with root package name */
    private final Object f6387e = new Object();

    /* renamed from: f, reason: collision with root package name */
    private AGCRoutePolicy f6388f = AGCRoutePolicy.UNKNOWN;

    /* renamed from: g, reason: collision with root package name */
    private final Map<String, String> f6389g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private volatile e f6390h;

    public c(Context context, String str) {
        this.f6383a = context;
        this.f6384b = str;
    }

    private static LazyInputStream a(Context context, final InputStream inputStream) {
        return new LazyInputStream(context) { // from class: com.huawei.agconnect.config.impl.c.1
            @Override // com.huawei.agconnect.config.LazyInputStream
            public InputStream get(Context context2) {
                return inputStream;
            }
        };
    }

    private static String a(String str) {
        int i2 = 0;
        if (str.length() > 0) {
            while (str.charAt(i2) == '/') {
                i2++;
            }
        }
        return '/' + str.substring(i2);
    }

    private void a() {
        if (this.f6386d == null) {
            synchronized (this.f6387e) {
                if (this.f6386d == null) {
                    if (this.f6385c != null) {
                        this.f6386d = new i(this.f6385c.loadInputStream(), "UTF-8");
                        this.f6385c.close();
                        this.f6385c = null;
                    } else {
                        this.f6386d = new m(this.f6383a, this.f6384b);
                    }
                    this.f6390h = new e(this.f6386d);
                }
                b();
            }
        }
    }

    private String b(String str) {
        JsonProcessingFactory.JsonProcessor jsonProcessor;
        Map<String, JsonProcessingFactory.JsonProcessor> processors = JsonProcessingFactory.getProcessors();
        if (processors.containsKey(str) && (jsonProcessor = processors.get(str)) != null) {
            return jsonProcessor.processOption(this);
        }
        return null;
    }

    private void b() {
        if (this.f6388f != AGCRoutePolicy.UNKNOWN || this.f6386d == null) {
            return;
        }
        this.f6388f = Utils.getRoutePolicyFromJson(this.f6386d.getString("/region", null), this.f6386d.getString("/agcgw/url", null));
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
        return this.f6383a;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getIdentifier() {
        return Utils.DEFAULT_NAME;
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
        return this.f6384b;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public AGCRoutePolicy getRoutePolicy() {
        if (this.f6388f == null) {
            this.f6388f = AGCRoutePolicy.UNKNOWN;
        }
        if (this.f6388f == AGCRoutePolicy.UNKNOWN && this.f6386d == null) {
            a();
        }
        AGCRoutePolicy aGCRoutePolicy = this.f6388f;
        return aGCRoutePolicy == null ? AGCRoutePolicy.UNKNOWN : aGCRoutePolicy;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getString(String str) {
        return getString(str, null);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getString(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("path must not be null.");
        }
        if (this.f6386d == null) {
            a();
        }
        String strA = a(str);
        String str3 = this.f6389g.get(strA);
        if (str3 != null) {
            return str3;
        }
        String strB = b(strA);
        if (strB != null) {
            return strB;
        }
        String string = this.f6386d.getString(strA, str2);
        return e.a(string) ? this.f6390h.decrypt(string, str2) : string;
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void overlayWith(LazyInputStream lazyInputStream) {
        this.f6385c = lazyInputStream;
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void overlayWith(InputStream inputStream) {
        overlayWith(a(this.f6383a, inputStream));
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void setParam(String str, String str2) {
        this.f6389g.put(Utils.fixPath(str), str2);
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void setRoutePolicy(AGCRoutePolicy aGCRoutePolicy) {
        this.f6388f = aGCRoutePolicy;
    }
}
