package com.huawei.agconnect.core.a;

import android.content.Context;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.AGConnectOptionsBuilder;
import com.huawei.agconnect.CustomAuthProvider;
import com.huawei.agconnect.CustomCredentialsProvider;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.impl.Utils;
import com.huawei.agconnect.core.Service;
import com.huawei.agconnect.core.service.auth.AuthProvider;
import com.huawei.agconnect.core.service.auth.CredentialsProvider;
import com.huawei.agconnect.core.service.auth.OnTokenListener;
import com.huawei.agconnect.core.service.auth.Token;
import com.huawei.hmf.tasks.Task;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class b extends AGConnectInstance {

    /* renamed from: a, reason: collision with root package name */
    private static List<Service> f6428a;

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, AGConnectInstance> f6429b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private static String f6430c;

    /* renamed from: d, reason: collision with root package name */
    private final AGConnectOptions f6431d;

    /* renamed from: e, reason: collision with root package name */
    private final d f6432e;

    /* renamed from: f, reason: collision with root package name */
    private final d f6433f;

    public b(AGConnectOptions aGConnectOptions) {
        this.f6431d = aGConnectOptions;
        List<Service> list = f6428a;
        this.f6432e = new d(f6428a, aGConnectOptions.getContext());
        this.f6433f = new d(null, aGConnectOptions.getContext());
        if (aGConnectOptions instanceof com.huawei.agconnect.config.impl.b) {
            this.f6433f.a(((com.huawei.agconnect.config.impl.b) aGConnectOptions).a(), aGConnectOptions.getContext());
        }
    }

    public static AGConnectInstance a() {
        String str = f6430c;
        if (str == null) {
            str = Utils.DEFAULT_NAME;
        }
        return a(str);
    }

    public static AGConnectInstance a(AGConnectOptions aGConnectOptions) {
        return a(aGConnectOptions, false);
    }

    private static synchronized AGConnectInstance a(AGConnectOptions aGConnectOptions, boolean z) {
        AGConnectInstance bVar;
        bVar = f6429b.get(aGConnectOptions.getIdentifier());
        if (bVar == null || z) {
            bVar = new b(aGConnectOptions);
            f6429b.put(aGConnectOptions.getIdentifier(), bVar);
        }
        return bVar;
    }

    public static synchronized AGConnectInstance a(String str) {
        AGConnectInstance aGConnectInstance;
        aGConnectInstance = f6429b.get(str);
        if (aGConnectInstance == null && !Utils.DEFAULT_NAME.equals(str)) {
            String str2 = "not find instance for : " + str;
        }
        return aGConnectInstance;
    }

    public static synchronized void a(Context context) {
        if (f6429b.size() > 0) {
            return;
        }
        a(context, AGConnectServicesConfig.fromContext(context));
    }

    private static synchronized void a(Context context, AGConnectOptions aGConnectOptions) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        b();
        if (f6428a == null) {
            f6428a = new c(context).a();
        }
        a(aGConnectOptions, true);
        f6430c = aGConnectOptions.getIdentifier();
        a.a();
    }

    public static synchronized void a(Context context, AGConnectOptionsBuilder aGConnectOptionsBuilder) {
        b(context, aGConnectOptionsBuilder);
        a(context, aGConnectOptionsBuilder.build(context));
    }

    private static void b() {
        JsonProcessingFactory.registerProcessor("/agcgw/url", new JsonProcessingFactory.JsonProcessor() { // from class: com.huawei.agconnect.core.a.b.1
            @Override // com.huawei.agconnect.JsonProcessingFactory.JsonProcessor
            public String processOption(AGConnectOptions aGConnectOptions) {
                String str;
                if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.CHINA)) {
                    str = "/agcgw_all/CN";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.RUSSIA)) {
                    str = "/agcgw_all/RU";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.GERMANY)) {
                    str = "/agcgw_all/DE";
                } else {
                    if (!aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.SINGAPORE)) {
                        return null;
                    }
                    str = "/agcgw_all/SG";
                }
                return aGConnectOptions.getString(str);
            }
        });
        JsonProcessingFactory.registerProcessor("/agcgw/backurl", new JsonProcessingFactory.JsonProcessor() { // from class: com.huawei.agconnect.core.a.b.2
            @Override // com.huawei.agconnect.JsonProcessingFactory.JsonProcessor
            public String processOption(AGConnectOptions aGConnectOptions) {
                String str;
                if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.CHINA)) {
                    str = "/agcgw_all/CN_back";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.RUSSIA)) {
                    str = "/agcgw_all/RU_back";
                } else if (aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.GERMANY)) {
                    str = "/agcgw_all/DE_back";
                } else {
                    if (!aGConnectOptions.getRoutePolicy().equals(AGCRoutePolicy.SINGAPORE)) {
                        return null;
                    }
                    str = "/agcgw_all/SG_back";
                }
                return aGConnectOptions.getString(str);
            }
        });
    }

    private static void b(Context context, AGConnectOptionsBuilder aGConnectOptionsBuilder) throws IOException {
        AGConnectServicesConfig aGConnectServicesConfigFromContext = AGConnectServicesConfig.fromContext(context);
        if (aGConnectOptionsBuilder.getInputStream() != null) {
            try {
                String string = Utils.toString(aGConnectOptionsBuilder.getInputStream(), "UTF-8");
                aGConnectOptionsBuilder.getInputStream().reset();
                aGConnectServicesConfigFromContext.overlayWith(new ByteArrayInputStream(string.getBytes(Charset.forName("UTF-8"))));
            } catch (IOException unused) {
            }
        }
        for (Map.Entry<String, String> entry : aGConnectOptionsBuilder.getCustomConfigMap().entrySet()) {
            aGConnectServicesConfigFromContext.setParam(entry.getKey(), entry.getValue());
        }
        if (aGConnectOptionsBuilder.getRoutePolicy() != AGCRoutePolicy.UNKNOWN) {
            aGConnectServicesConfigFromContext.setRoutePolicy(aGConnectOptionsBuilder.getRoutePolicy());
        }
    }

    public void a(final CustomAuthProvider customAuthProvider) {
        this.f6433f.a(Collections.singletonList(Service.builder((Class<?>) AuthProvider.class, new AuthProvider() { // from class: com.huawei.agconnect.core.a.b.4
            @Override // com.huawei.agconnect.core.service.auth.AuthProvider
            public void addTokenListener(OnTokenListener onTokenListener) {
            }

            @Override // com.huawei.agconnect.core.service.auth.AuthProvider
            public Task<Token> getTokens() {
                return customAuthProvider.getTokens(false);
            }

            @Override // com.huawei.agconnect.core.service.auth.AuthProvider
            public Task<Token> getTokens(boolean z) {
                return customAuthProvider.getTokens(z);
            }

            @Override // com.huawei.agconnect.core.service.auth.AuthProvider
            public String getUid() {
                return "";
            }

            @Override // com.huawei.agconnect.core.service.auth.AuthProvider
            public void removeTokenListener(OnTokenListener onTokenListener) {
            }
        }).build()), this.f6431d.getContext());
    }

    public void a(final CustomCredentialsProvider customCredentialsProvider) {
        this.f6433f.a(Collections.singletonList(Service.builder((Class<?>) CredentialsProvider.class, new CredentialsProvider() { // from class: com.huawei.agconnect.core.a.b.3
            @Override // com.huawei.agconnect.core.service.auth.CredentialsProvider
            public Task<Token> getTokens() {
                return customCredentialsProvider.getTokens(false);
            }

            @Override // com.huawei.agconnect.core.service.auth.CredentialsProvider
            public Task<Token> getTokens(boolean z) {
                return customCredentialsProvider.getTokens(z);
            }
        }).build()), this.f6431d.getContext());
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public Context getContext() {
        return this.f6431d.getContext();
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public String getIdentifier() {
        return this.f6431d.getIdentifier();
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public AGConnectOptions getOptions() {
        return this.f6431d;
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public <T> T getService(Class<? super T> cls) {
        T t = (T) this.f6433f.a(this, cls);
        return t != null ? t : (T) this.f6432e.a(this, cls);
    }
}
