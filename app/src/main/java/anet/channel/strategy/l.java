package anet.channel.strategy;

import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.util.ALog;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.BaseMonitor;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class l {

    /* compiled from: Taobao */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f1989a;

        /* renamed from: b, reason: collision with root package name */
        public final String f1990b;

        /* renamed from: c, reason: collision with root package name */
        public final int f1991c;

        /* renamed from: d, reason: collision with root package name */
        public final int f1992d;

        /* renamed from: e, reason: collision with root package name */
        public final int f1993e;

        /* renamed from: f, reason: collision with root package name */
        public final int f1994f;

        /* renamed from: g, reason: collision with root package name */
        public final String f1995g;

        /* renamed from: h, reason: collision with root package name */
        public final String f1996h;

        public a(JSONObject jSONObject) {
            this.f1989a = jSONObject.optInt("port");
            this.f1990b = jSONObject.optString("protocol");
            this.f1991c = jSONObject.optInt("cto");
            this.f1992d = jSONObject.optInt("rto");
            this.f1993e = jSONObject.optInt("retry");
            this.f1994f = jSONObject.optInt("heartbeat");
            this.f1995g = jSONObject.optString("rtt", "");
            this.f1996h = jSONObject.optString("publickey");
        }
    }

    /* compiled from: Taobao */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f1997a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1998b;

        /* renamed from: c, reason: collision with root package name */
        public final String f1999c;

        /* renamed from: d, reason: collision with root package name */
        public final String f2000d;

        /* renamed from: e, reason: collision with root package name */
        public final String f2001e;

        /* renamed from: f, reason: collision with root package name */
        public final String[] f2002f;

        /* renamed from: g, reason: collision with root package name */
        public final String[] f2003g;

        /* renamed from: h, reason: collision with root package name */
        public final a[] f2004h;

        /* renamed from: i, reason: collision with root package name */
        public final e[] f2005i;

        /* renamed from: j, reason: collision with root package name */
        public final boolean f2006j;

        /* renamed from: k, reason: collision with root package name */
        public final boolean f2007k;

        /* renamed from: l, reason: collision with root package name */
        public final int f2008l;

        public b(JSONObject jSONObject) {
            this.f1997a = jSONObject.optString(Constants.KEY_HOST);
            this.f1998b = jSONObject.optInt(RemoteMessageConst.TTL);
            this.f1999c = jSONObject.optString("safeAisles");
            this.f2000d = jSONObject.optString("cname", null);
            this.f2001e = jSONObject.optString("unit", null);
            this.f2006j = jSONObject.optInt("clear") == 1;
            this.f2007k = jSONObject.optBoolean("effectNow");
            this.f2008l = jSONObject.optInt("version");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ips");
            if (jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                this.f2002f = new String[length];
                for (int i2 = 0; i2 < length; i2++) {
                    this.f2002f[i2] = jSONArrayOptJSONArray.optString(i2);
                }
            } else {
                this.f2002f = null;
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("sips");
            if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() <= 0) {
                this.f2003g = null;
            } else {
                int length2 = jSONArrayOptJSONArray2.length();
                this.f2003g = new String[length2];
                for (int i3 = 0; i3 < length2; i3++) {
                    this.f2003g[i3] = jSONArrayOptJSONArray2.optString(i3);
                }
            }
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("aisles");
            if (jSONArrayOptJSONArray3 != null) {
                int length3 = jSONArrayOptJSONArray3.length();
                this.f2004h = new a[length3];
                for (int i4 = 0; i4 < length3; i4++) {
                    this.f2004h[i4] = new a(jSONArrayOptJSONArray3.optJSONObject(i4));
                }
            } else {
                this.f2004h = null;
            }
            JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("strategies");
            if (jSONArrayOptJSONArray4 == null || jSONArrayOptJSONArray4.length() <= 0) {
                this.f2005i = null;
                return;
            }
            int length4 = jSONArrayOptJSONArray4.length();
            this.f2005i = new e[length4];
            for (int i5 = 0; i5 < length4; i5++) {
                this.f2005i[i5] = new e(jSONArrayOptJSONArray4.optJSONObject(i5));
            }
        }
    }

    /* compiled from: Taobao */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f2009a;

        /* renamed from: b, reason: collision with root package name */
        public final e[] f2010b;

        public c(JSONObject jSONObject) {
            this.f2009a = jSONObject.optString(Constants.KEY_HOST);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("strategies");
            if (jSONArrayOptJSONArray == null) {
                this.f2010b = null;
                return;
            }
            int length = jSONArrayOptJSONArray.length();
            this.f2010b = new e[length];
            for (int i2 = 0; i2 < length; i2++) {
                this.f2010b[i2] = new e(jSONArrayOptJSONArray.optJSONObject(i2));
            }
        }
    }

    /* compiled from: Taobao */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final String f2011a;

        /* renamed from: b, reason: collision with root package name */
        public final b[] f2012b;

        /* renamed from: c, reason: collision with root package name */
        public final c[] f2013c;

        /* renamed from: d, reason: collision with root package name */
        public final String f2014d;

        /* renamed from: e, reason: collision with root package name */
        public final String f2015e;

        /* renamed from: f, reason: collision with root package name */
        public final int f2016f;

        /* renamed from: g, reason: collision with root package name */
        public final int f2017g;

        /* renamed from: h, reason: collision with root package name */
        public final int f2018h;

        public d(JSONObject jSONObject) {
            this.f2011a = jSONObject.optString("ip");
            this.f2014d = jSONObject.optString("uid", null);
            this.f2015e = jSONObject.optString("utdid", null);
            this.f2016f = jSONObject.optInt(DispatchConstants.CONFIG_VERSION);
            this.f2017g = jSONObject.optInt("fcl");
            this.f2018h = jSONObject.optInt("fct");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(BaseMonitor.COUNT_POINT_DNS);
            if (jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                this.f2012b = new b[length];
                for (int i2 = 0; i2 < length; i2++) {
                    this.f2012b[i2] = new b(jSONArrayOptJSONArray.optJSONObject(i2));
                }
            } else {
                this.f2012b = null;
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("hrTask");
            if (jSONArrayOptJSONArray2 == null) {
                this.f2013c = null;
                return;
            }
            int length2 = jSONArrayOptJSONArray2.length();
            this.f2013c = new c[length2];
            for (int i3 = 0; i3 < length2; i3++) {
                this.f2013c[i3] = new c(jSONArrayOptJSONArray2.optJSONObject(i3));
            }
        }
    }

    /* compiled from: Taobao */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final String f2019a;

        /* renamed from: b, reason: collision with root package name */
        public final a f2020b;

        /* renamed from: c, reason: collision with root package name */
        public final String f2021c;

        public e(JSONObject jSONObject) {
            this.f2019a = jSONObject.optString("ip");
            this.f2021c = jSONObject.optString("path");
            this.f2020b = new a(jSONObject);
        }
    }

    public static d a(JSONObject jSONObject) {
        try {
            return new d(jSONObject);
        } catch (Exception e2) {
            ALog.e("StrategyResultParser", "Parse HttpDns response failed.", null, e2, "JSON Content", jSONObject.toString());
            return null;
        }
    }
}
