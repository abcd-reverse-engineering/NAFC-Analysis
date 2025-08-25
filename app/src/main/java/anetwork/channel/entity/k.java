package anetwork.channel.entity;

import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;
import anet.channel.util.Utils;
import anetwork.channel.aidl.ParcelableRequest;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private ParcelableRequest f2221a;

    /* renamed from: b, reason: collision with root package name */
    private Request f2222b;

    /* renamed from: d, reason: collision with root package name */
    private int f2224d;

    /* renamed from: f, reason: collision with root package name */
    public RequestStatistic f2226f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2227g;

    /* renamed from: h, reason: collision with root package name */
    public final int f2228h;

    /* renamed from: i, reason: collision with root package name */
    public final String f2229i;

    /* renamed from: j, reason: collision with root package name */
    public final int f2230j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f2231k;

    /* renamed from: c, reason: collision with root package name */
    private int f2223c = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f2225e = 0;

    public k(ParcelableRequest parcelableRequest, int i2, boolean z) {
        this.f2222b = null;
        this.f2224d = 0;
        if (parcelableRequest == null) {
            throw new IllegalArgumentException("request is null");
        }
        this.f2221a = parcelableRequest;
        this.f2230j = i2;
        this.f2231k = z;
        this.f2229i = a.a.u.b.a(parcelableRequest.f2102m, this.f2230j == 0 ? "HTTP" : "DGRD");
        int i3 = parcelableRequest.f2099j;
        this.f2227g = i3 <= 0 ? (int) (Utils.getNetworkTimeFactor() * 12000.0f) : i3;
        int i4 = parcelableRequest.f2100k;
        this.f2228h = i4 <= 0 ? (int) (Utils.getNetworkTimeFactor() * 12000.0f) : i4;
        int i5 = parcelableRequest.f2092c;
        this.f2224d = (i5 < 0 || i5 > 3) ? 2 : i5;
        HttpUrl httpUrlL = l();
        this.f2226f = new RequestStatistic(httpUrlL.host(), String.valueOf(parcelableRequest.f2101l));
        this.f2226f.url = httpUrlL.simpleUrlString();
        this.f2222b = b(httpUrlL);
    }

    private Request b(HttpUrl httpUrl) {
        Request.Builder requestStatistic = new Request.Builder().setUrl(httpUrl).setMethod(this.f2221a.f2096g).setBody(this.f2221a.f2091b).setReadTimeout(this.f2228h).setConnectTimeout(this.f2227g).setRedirectEnable(this.f2221a.f2095f).setRedirectTimes(this.f2223c).setBizId(this.f2221a.f2101l).setSeq(this.f2229i).setRequestStatistic(this.f2226f);
        requestStatistic.setParams(this.f2221a.f2098i);
        String str = this.f2221a.f2094e;
        if (str != null) {
            requestStatistic.setCharset(str);
        }
        requestStatistic.setHeaders(c(httpUrl));
        return requestStatistic.build();
    }

    private HttpUrl l() {
        HttpUrl httpUrl = HttpUrl.parse(this.f2221a.f2093d);
        if (httpUrl == null) {
            throw new IllegalArgumentException("url is invalid. url=" + this.f2221a.f2093d);
        }
        if (!a.a.k.b.q()) {
            ALog.i("anet.RequestConfig", "request ssl disabled.", this.f2229i, new Object[0]);
            httpUrl.downgradeSchemeAndLock();
        } else if (a.a.u.a.f1254k.equalsIgnoreCase(this.f2221a.a(a.a.u.a.f1249f))) {
            httpUrl.lockScheme();
        }
        return httpUrl;
    }

    public Request a() {
        return this.f2222b;
    }

    public boolean c() {
        return this.f2231k;
    }

    public boolean d() {
        return this.f2225e < this.f2224d;
    }

    public boolean e() {
        return a.a.k.b.m() && !a.a.u.a.f1254k.equalsIgnoreCase(this.f2221a.a(a.a.u.a.f1250g)) && (a.a.k.b.e() || this.f2225e == 0);
    }

    public HttpUrl f() {
        return this.f2222b.getHttpUrl();
    }

    public String g() {
        return this.f2222b.getUrlString();
    }

    public Map<String, String> h() {
        return this.f2222b.getHeaders();
    }

    public boolean i() {
        return !a.a.u.a.f1254k.equalsIgnoreCase(this.f2221a.a(a.a.u.a.f1247d));
    }

    public boolean j() {
        return a.a.u.a.f1253j.equals(this.f2221a.a(a.a.u.a.f1251h));
    }

    public void k() {
        this.f2225e++;
        this.f2226f.retryTimes = this.f2225e;
    }

    private Map<String, String> c(HttpUrl httpUrl) {
        String strHost = httpUrl.host();
        boolean z = !anet.channel.strategy.utils.c.a(strHost);
        if (strHost.length() > 2 && strHost.charAt(0) == '[' && strHost.charAt(strHost.length() - 1) == ']' && anet.channel.strategy.utils.c.b(strHost.substring(1, strHost.length() - 1))) {
            z = false;
        }
        HashMap map = new HashMap();
        Map<String, String> map2 = this.f2221a.f2097h;
        if (map2 != null) {
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                String key = entry.getKey();
                if (!"Host".equalsIgnoreCase(key) && !":host".equalsIgnoreCase(key)) {
                    boolean zEqualsIgnoreCase = a.a.u.a.f1253j.equalsIgnoreCase(this.f2221a.a(a.a.u.a.f1248e));
                    if (!"Cookie".equalsIgnoreCase(key) || zEqualsIgnoreCase) {
                        map.put(key, entry.getValue());
                    }
                } else if (!z) {
                    map.put("Host", entry.getValue());
                }
            }
        }
        return map;
    }

    public void a(Request request) {
        this.f2222b = request;
    }

    public String a(String str) {
        return this.f2221a.a(str);
    }

    public void a(HttpUrl httpUrl) {
        ALog.i("anet.RequestConfig", "redirect", this.f2229i, "to url", httpUrl.toString());
        this.f2223c++;
        this.f2226f.url = httpUrl.simpleUrlString();
        this.f2222b = b(httpUrl);
    }

    public int b() {
        return this.f2228h * (this.f2224d + 1);
    }
}
