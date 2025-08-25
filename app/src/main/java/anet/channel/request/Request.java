package anet.channel.request;

import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import h.z2.h0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONException;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class Request {
    public static final String DEFAULT_CHARSET = "UTF-8";

    /* renamed from: a, reason: collision with root package name */
    public final RequestStatistic f1841a;

    /* renamed from: b, reason: collision with root package name */
    private HttpUrl f1842b;

    /* renamed from: c, reason: collision with root package name */
    private HttpUrl f1843c;

    /* renamed from: d, reason: collision with root package name */
    private HttpUrl f1844d;

    /* renamed from: e, reason: collision with root package name */
    private URL f1845e;

    /* renamed from: f, reason: collision with root package name */
    private String f1846f;

    /* renamed from: g, reason: collision with root package name */
    private Map<String, String> f1847g;

    /* renamed from: h, reason: collision with root package name */
    private Map<String, String> f1848h;

    /* renamed from: i, reason: collision with root package name */
    private String f1849i;

    /* renamed from: j, reason: collision with root package name */
    private BodyEntry f1850j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f1851k;

    /* renamed from: l, reason: collision with root package name */
    private String f1852l;

    /* renamed from: m, reason: collision with root package name */
    private String f1853m;
    private int n;
    private int o;
    private int p;
    private HostnameVerifier q;
    private SSLSocketFactory r;
    private boolean s;

    /* compiled from: Taobao */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private HttpUrl f1854a;

        /* renamed from: b, reason: collision with root package name */
        private HttpUrl f1855b;

        /* renamed from: e, reason: collision with root package name */
        private Map<String, String> f1858e;

        /* renamed from: f, reason: collision with root package name */
        private String f1859f;

        /* renamed from: g, reason: collision with root package name */
        private BodyEntry f1860g;

        /* renamed from: j, reason: collision with root package name */
        private HostnameVerifier f1863j;

        /* renamed from: k, reason: collision with root package name */
        private SSLSocketFactory f1864k;

        /* renamed from: l, reason: collision with root package name */
        private String f1865l;

        /* renamed from: m, reason: collision with root package name */
        private String f1866m;
        private boolean q;

        /* renamed from: c, reason: collision with root package name */
        private String f1856c = "GET";

        /* renamed from: d, reason: collision with root package name */
        private Map<String, String> f1857d = new HashMap();

        /* renamed from: h, reason: collision with root package name */
        private boolean f1861h = true;

        /* renamed from: i, reason: collision with root package name */
        private int f1862i = 0;
        private int n = 10000;
        private int o = 10000;
        private RequestStatistic p = null;

        public Builder addHeader(String str, String str2) {
            this.f1857d.put(str, str2);
            return this;
        }

        public Builder addParam(String str, String str2) {
            if (this.f1858e == null) {
                this.f1858e = new HashMap();
            }
            this.f1858e.put(str, str2);
            this.f1855b = null;
            return this;
        }

        public Request build() {
            if (this.f1860g == null && this.f1858e == null && Method.a(this.f1856c)) {
                ALog.e("awcn.Request", "method " + this.f1856c + " must have a request body", null, new Object[0]);
            }
            if (this.f1860g != null && !Method.b(this.f1856c)) {
                ALog.e("awcn.Request", "method " + this.f1856c + " should not have a request body", null, new Object[0]);
                this.f1860g = null;
            }
            BodyEntry bodyEntry = this.f1860g;
            if (bodyEntry != null && bodyEntry.getContentType() != null) {
                addHeader("Content-Type", this.f1860g.getContentType());
            }
            return new Request(this);
        }

        public Builder setAllowRequestInBg(boolean z) {
            this.q = z;
            return this;
        }

        public Builder setBizId(String str) {
            this.f1865l = str;
            return this;
        }

        public Builder setBody(BodyEntry bodyEntry) {
            this.f1860g = bodyEntry;
            return this;
        }

        public Builder setCharset(String str) {
            this.f1859f = str;
            this.f1855b = null;
            return this;
        }

        public Builder setConnectTimeout(int i2) {
            if (i2 > 0) {
                this.n = i2;
            }
            return this;
        }

        public Builder setHeaders(Map<String, String> map) {
            this.f1857d.clear();
            if (map != null) {
                this.f1857d.putAll(map);
            }
            return this;
        }

        public Builder setHostnameVerifier(HostnameVerifier hostnameVerifier) {
            this.f1863j = hostnameVerifier;
            return this;
        }

        public Builder setMethod(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("method is null or empty");
            }
            if ("GET".equalsIgnoreCase(str)) {
                this.f1856c = "GET";
            } else if ("POST".equalsIgnoreCase(str)) {
                this.f1856c = "POST";
            } else if (Method.OPTION.equalsIgnoreCase(str)) {
                this.f1856c = Method.OPTION;
            } else if (Method.HEAD.equalsIgnoreCase(str)) {
                this.f1856c = Method.HEAD;
            } else if (Method.PUT.equalsIgnoreCase(str)) {
                this.f1856c = Method.PUT;
            } else if (Method.DELETE.equalsIgnoreCase(str)) {
                this.f1856c = Method.DELETE;
            } else {
                this.f1856c = "GET";
            }
            return this;
        }

        public Builder setParams(Map<String, String> map) {
            this.f1858e = map;
            this.f1855b = null;
            return this;
        }

        public Builder setReadTimeout(int i2) {
            if (i2 > 0) {
                this.o = i2;
            }
            return this;
        }

        public Builder setRedirectEnable(boolean z) {
            this.f1861h = z;
            return this;
        }

        public Builder setRedirectTimes(int i2) {
            this.f1862i = i2;
            return this;
        }

        public Builder setRequestStatistic(RequestStatistic requestStatistic) {
            this.p = requestStatistic;
            return this;
        }

        public Builder setSeq(String str) {
            this.f1866m = str;
            return this;
        }

        public Builder setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.f1864k = sSLSocketFactory;
            return this;
        }

        public Builder setUrl(HttpUrl httpUrl) {
            this.f1854a = httpUrl;
            this.f1855b = null;
            return this;
        }

        public Builder setUrl(String str) {
            this.f1854a = HttpUrl.parse(str);
            this.f1855b = null;
            if (this.f1854a != null) {
                return this;
            }
            throw new IllegalArgumentException("toURL is invalid! toURL = " + str);
        }
    }

    /* compiled from: Taobao */
    public static final class Method {
        public static final String DELETE = "DELETE";
        public static final String GET = "GET";
        public static final String HEAD = "HEAD";
        public static final String OPTION = "OPTIONS";
        public static final String POST = "POST";
        public static final String PUT = "PUT";

        static boolean a(String str) {
            return str.equals("POST") || str.equals(PUT);
        }

        static boolean b(String str) {
            return a(str) || str.equals(DELETE) || str.equals(OPTION);
        }
    }

    private Map<String, String> a() {
        return AwcnConfig.isCookieHeaderRedundantFix() ? new HashMap(this.f1847g) : this.f1847g;
    }

    private void b() {
        String strA = anet.channel.strategy.utils.c.a(this.f1848h, getContentEncoding());
        if (!TextUtils.isEmpty(strA)) {
            if (Method.a(this.f1846f) && this.f1850j == null) {
                try {
                    this.f1850j = new ByteArrayEntry(strA.getBytes(getContentEncoding()));
                    this.f1847g.put("Content-Type", "application/x-www-form-urlencoded; charset=" + getContentEncoding());
                } catch (UnsupportedEncodingException unused) {
                }
            } else {
                String strUrlString = this.f1842b.urlString();
                StringBuilder sb = new StringBuilder(strUrlString);
                if (sb.indexOf("?") == -1) {
                    sb.append('?');
                } else if (strUrlString.charAt(strUrlString.length() - 1) != '&') {
                    sb.append(h0.f16706c);
                }
                sb.append(strA);
                HttpUrl httpUrl = HttpUrl.parse(sb.toString());
                if (httpUrl != null) {
                    this.f1843c = httpUrl;
                }
            }
        }
        if (this.f1843c == null) {
            this.f1843c = this.f1842b;
        }
    }

    public boolean containsBody() {
        return this.f1850j != null;
    }

    public String getBizId() {
        return this.f1852l;
    }

    public byte[] getBodyBytes() {
        if (this.f1850j == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(128);
        try {
            postBody(byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }

    public int getConnectTimeout() {
        return this.o;
    }

    public String getContentEncoding() {
        String str = this.f1849i;
        return str != null ? str : "UTF-8";
    }

    public Map<String, String> getHeaders() {
        return Collections.unmodifiableMap(this.f1847g);
    }

    public String getHost() {
        return this.f1843c.host();
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.q;
    }

    public HttpUrl getHttpUrl() {
        return this.f1843c;
    }

    public String getMethod() {
        return this.f1846f;
    }

    public int getReadTimeout() {
        return this.p;
    }

    public int getRedirectTimes() {
        return this.n;
    }

    public String getSeq() {
        return this.f1853m;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.r;
    }

    public URL getUrl() {
        if (this.f1845e == null) {
            HttpUrl httpUrl = this.f1844d;
            if (httpUrl == null) {
                httpUrl = this.f1843c;
            }
            this.f1845e = httpUrl.toURL();
        }
        return this.f1845e;
    }

    public String getUrlString() {
        return this.f1843c.urlString();
    }

    public boolean isAllowRequestInBg() {
        return this.s;
    }

    public boolean isRedirectEnable() {
        return this.f1851k;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.f1856c = this.f1846f;
        builder.f1857d = a();
        builder.f1858e = this.f1848h;
        builder.f1860g = this.f1850j;
        builder.f1859f = this.f1849i;
        builder.f1861h = this.f1851k;
        builder.f1862i = this.n;
        builder.f1863j = this.q;
        builder.f1864k = this.r;
        builder.f1854a = this.f1842b;
        builder.f1855b = this.f1843c;
        builder.f1865l = this.f1852l;
        builder.f1866m = this.f1853m;
        builder.n = this.o;
        builder.o = this.p;
        builder.p = this.f1841a;
        builder.q = this.s;
        return builder;
    }

    public int postBody(OutputStream outputStream) throws IOException {
        BodyEntry bodyEntry = this.f1850j;
        if (bodyEntry != null) {
            return bodyEntry.writeTo(outputStream);
        }
        return 0;
    }

    public void setDnsOptimize(String str, int i2) throws JSONException {
        if (str != null) {
            if (this.f1844d == null) {
                this.f1844d = new HttpUrl(this.f1843c);
            }
            this.f1844d.replaceIpAndPort(str, i2);
        } else {
            this.f1844d = null;
        }
        this.f1845e = null;
        this.f1841a.setIPAndPort(str, i2);
    }

    public void setUrlScheme(boolean z) {
        if (this.f1844d == null) {
            this.f1844d = new HttpUrl(this.f1843c);
        }
        this.f1844d.setScheme(z ? HttpConstant.HTTPS : HttpConstant.HTTP);
        this.f1845e = null;
    }

    private Request(Builder builder) {
        this.f1846f = "GET";
        this.f1851k = true;
        this.n = 0;
        this.o = 10000;
        this.p = 10000;
        this.f1846f = builder.f1856c;
        this.f1847g = builder.f1857d;
        this.f1848h = builder.f1858e;
        this.f1850j = builder.f1860g;
        this.f1849i = builder.f1859f;
        this.f1851k = builder.f1861h;
        this.n = builder.f1862i;
        this.q = builder.f1863j;
        this.r = builder.f1864k;
        this.f1852l = builder.f1865l;
        this.f1853m = builder.f1866m;
        this.o = builder.n;
        this.p = builder.o;
        this.f1842b = builder.f1854a;
        this.f1843c = builder.f1855b;
        if (this.f1843c == null) {
            b();
        }
        this.f1841a = builder.p != null ? builder.p : new RequestStatistic(getHost(), this.f1852l);
        this.s = builder.q;
    }
}
