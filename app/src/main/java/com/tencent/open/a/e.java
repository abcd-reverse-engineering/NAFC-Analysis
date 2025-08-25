package com.tencent.open.a;

import android.os.Build;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.tencent.open.log.SLog;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.ConnectionSpec;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.Version;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
class e implements com.tencent.open.a.a {

    /* renamed from: a, reason: collision with root package name */
    private OkHttpClient f9769a;

    /* compiled from: ProGuard */
    private static class a implements Interceptor {

        /* renamed from: a, reason: collision with root package name */
        private final String f9770a;

        public a(String str) {
            this.f9770a = str;
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            return chain.proceed(chain.request().newBuilder().header(HttpHeaders.USER_AGENT, this.f9770a).build());
        }
    }

    public e(String str) throws NoClassDefFoundError {
        a(str);
    }

    private void a(String str) {
        String strUserAgent = Version.userAgent();
        if (strUserAgent == null || !strUserAgent.startsWith("okhttp/3")) {
            throw new NoClassDefFoundError();
        }
        OkHttpClient.Builder builderAddInterceptor = new OkHttpClient.Builder().connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS)).connectTimeout(15000L, TimeUnit.MILLISECONDS).readTimeout(30000L, TimeUnit.MILLISECONDS).writeTimeout(30000L, TimeUnit.MILLISECONDS).cache(null).addInterceptor(new a(str));
        a(builderAddInterceptor);
        this.f9769a = builderAddInterceptor.build();
    }

    @Override // com.tencent.open.a.a
    public void a(long j2, long j3) {
        if (j2 <= 0 || j3 <= 0) {
            return;
        }
        if (this.f9769a.connectTimeoutMillis() == j2 && this.f9769a.readTimeoutMillis() == j3) {
            return;
        }
        SLog.i("OkHttpServiceImpl", "setTimeout changed.");
        this.f9769a = this.f9769a.newBuilder().connectTimeout(j2, TimeUnit.MILLISECONDS).readTimeout(j3, TimeUnit.MILLISECONDS).writeTimeout(j3, TimeUnit.MILLISECONDS).build();
    }

    @Override // com.tencent.open.a.a
    public g a(String str, String str2) throws IOException {
        SLog.i("OkHttpServiceImpl", "get.");
        if (!TextUtils.isEmpty(str2)) {
            int iIndexOf = str2.indexOf("?");
            if (iIndexOf == -1) {
                str = str + "?";
            } else if (iIndexOf != str.length() - 1) {
                str = str + "&";
            }
            str = str + str2;
        }
        return new d(this.f9769a.newCall(new Request.Builder().url(str).get().build()).execute(), str2.length());
    }

    @Override // com.tencent.open.a.a
    public g a(String str, Map<String, String> map) throws IOException {
        SLog.i("OkHttpServiceImpl", "post data");
        FormBody.Builder builder = new FormBody.Builder();
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                if (str3 != null) {
                    builder.add(str2, str3);
                }
            }
        }
        FormBody formBodyBuild = builder.build();
        return new d(this.f9769a.newCall(new Request.Builder().url(str).post(formBodyBuild).build()).execute(), (int) formBodyBuild.contentLength());
    }

    @Override // com.tencent.open.a.a
    public g a(String str, Map<String, String> map, Map<String, byte[]> map2) throws IOException {
        if (map2 != null && map2.size() != 0) {
            SLog.i("OkHttpServiceImpl", "post data, has byte data");
            MultipartBody.Builder builder = new MultipartBody.Builder();
            if (map != null && map.size() > 0) {
                for (String str2 : map.keySet()) {
                    String str3 = map.get(str2);
                    if (str3 != null) {
                        builder.addFormDataPart(str2, str3);
                    }
                }
            }
            for (String str4 : map2.keySet()) {
                byte[] bArr = map2.get(str4);
                if (bArr != null && bArr.length > 0) {
                    builder.addFormDataPart(str4, str4, RequestBody.create(MediaType.get("content/unknown"), bArr));
                    SLog.w("OkHttpServiceImpl", "post byte data.");
                }
            }
            MultipartBody multipartBodyBuild = builder.build();
            return new d(this.f9769a.newCall(new Request.Builder().url(str).post(multipartBodyBuild).build()).execute(), (int) multipartBodyBuild.contentLength());
        }
        return a(str, map);
    }

    private void a(OkHttpClient.Builder builder) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 16 || i2 >= 21) {
            return;
        }
        try {
            h hVar = new h();
            TrustManager trustManagerA = hVar.a();
            if (trustManagerA == null) {
                return;
            }
            builder.sslSocketFactory(hVar, (X509TrustManager) trustManagerA);
            SLog.i("OkHttpServiceImpl", "enableTls2: enabled.");
        } catch (KeyManagementException e2) {
            SLog.e("OkHttpServiceImpl", "enableTls2: failed.", e2);
        } catch (KeyStoreException e3) {
            SLog.e("OkHttpServiceImpl", "enableTls2: failed.", e3);
        } catch (NoSuchAlgorithmException e4) {
            SLog.e("OkHttpServiceImpl", "enableTls2: failed.", e4);
        }
    }
}
