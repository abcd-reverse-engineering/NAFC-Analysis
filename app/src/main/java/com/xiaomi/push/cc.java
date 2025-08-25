package com.xiaomi.push;

import android.text.TextUtils;
import com.hihonor.honorid.core.data.UserInfo;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.mipush.sdk.Constants;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class cc {

    /* renamed from: a, reason: collision with other field name */
    private long f248a;

    /* renamed from: a, reason: collision with other field name */
    public String f249a;

    /* renamed from: b, reason: collision with other field name */
    public String f251b;

    /* renamed from: c, reason: collision with root package name */
    public String f12541c;

    /* renamed from: d, reason: collision with root package name */
    public String f12542d;

    /* renamed from: e, reason: collision with root package name */
    public String f12543e;

    /* renamed from: f, reason: collision with root package name */
    public String f12544f;

    /* renamed from: g, reason: collision with root package name */
    public String f12545g;

    /* renamed from: h, reason: collision with root package name */
    protected String f12546h;

    /* renamed from: i, reason: collision with root package name */
    private String f12547i;

    /* renamed from: a, reason: collision with other field name */
    private ArrayList<cj> f250a = new ArrayList<>();

    /* renamed from: a, reason: collision with root package name */
    private double f12539a = 0.1d;

    /* renamed from: j, reason: collision with root package name */
    private String f12548j = "s.mi1.cc";

    /* renamed from: b, reason: collision with root package name */
    private long f12540b = 86400000;

    public cc(String str) {
        this.f249a = "";
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f248a = System.currentTimeMillis();
        this.f250a.add(new cj(str, -1));
        this.f249a = cg.m227a();
        this.f251b = str;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m221a() {
        return TextUtils.equals(this.f249a, cg.m227a());
    }

    public boolean b() {
        return System.currentTimeMillis() - this.f248a < this.f12540b;
    }

    boolean c() {
        long j2 = this.f12540b;
        if (864000000 >= j2) {
            j2 = 864000000;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j3 = this.f248a;
        return jCurrentTimeMillis - j3 > j2 || (jCurrentTimeMillis - j3 > this.f12540b && this.f249a.startsWith("WIFI-"));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f249a);
        sb.append("\n");
        sb.append(a());
        Iterator<cj> it = this.f250a.iterator();
        while (it.hasNext()) {
            cj next = it.next();
            sb.append("\n");
            sb.append(next.toString());
        }
        sb.append("\n");
        return sb.toString();
    }

    public boolean a(cc ccVar) {
        return TextUtils.equals(this.f249a, ccVar.f249a);
    }

    public void b(String str, long j2, long j3) {
        a(str, 0, j2, j3, null);
    }

    public void a(long j2) {
        if (j2 > 0) {
            this.f12540b = j2;
            return;
        }
        throw new IllegalArgumentException("the duration is invalid " + j2);
    }

    public void b(String str, long j2, long j3, Exception exc) {
        a(str, -1, j2, j3, exc);
    }

    public void b(String str) {
        this.f12548j = str;
    }

    private synchronized void c(String str) {
        Iterator<cj> it = this.f250a.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f267a, str)) {
                it.remove();
            }
        }
    }

    public ArrayList<String> a(String str) throws NumberFormatException {
        if (!TextUtils.isEmpty(str)) {
            URL url = new URL(str);
            if (TextUtils.equals(url.getHost(), this.f251b)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<String> it = a(true).iterator();
                while (it.hasNext()) {
                    ce ceVarA = ce.a(it.next(), url.getPort());
                    arrayList.add(new URL(url.getProtocol(), ceVarA.m226a(), ceVarA.a(), url.getFile()).toString());
                }
                return arrayList;
            }
            throw new IllegalArgumentException("the url is not supported by the fallback");
        }
        throw new IllegalArgumentException("the url is empty.");
    }

    public void a(String str, long j2, long j3) {
        try {
            b(new URL(str).getHost(), j2, j3);
        } catch (MalformedURLException unused) {
        }
    }

    public void a(String str, long j2, long j3, Exception exc) {
        try {
            b(new URL(str).getHost(), j2, j3, exc);
        } catch (MalformedURLException unused) {
        }
    }

    public void a(String str, int i2, long j2, long j3, Exception exc) {
        a(str, new cb(i2, j2, j3, exc));
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
    
        r1.a(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a(java.lang.String r4, com.xiaomi.push.cb r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.ArrayList<com.xiaomi.push.cj> r0 = r3.f250a     // Catch: java.lang.Throwable -> L20
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L20
        L7:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L1e
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L20
            com.xiaomi.push.cj r1 = (com.xiaomi.push.cj) r1     // Catch: java.lang.Throwable -> L20
            java.lang.String r2 = r1.f267a     // Catch: java.lang.Throwable -> L20
            boolean r2 = android.text.TextUtils.equals(r4, r2)     // Catch: java.lang.Throwable -> L20
            if (r2 == 0) goto L7
            r1.a(r5)     // Catch: java.lang.Throwable -> L20
        L1e:
            monitor-exit(r3)
            return
        L20:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.cc.a(java.lang.String, com.xiaomi.push.cb):void");
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized ArrayList<String> m218a() {
        return a(false);
    }

    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        cj[] cjVarArr = new cj[this.f250a.size()];
        this.f250a.toArray(cjVarArr);
        Arrays.sort(cjVarArr);
        arrayList = new ArrayList<>();
        for (cj cjVar : cjVarArr) {
            if (z) {
                arrayList.add(cjVar.f267a);
            } else {
                int iIndexOf = cjVar.f267a.indexOf(Constants.COLON_SEPARATOR);
                if (iIndexOf != -1) {
                    arrayList.add(cjVar.f267a.substring(0, iIndexOf));
                } else {
                    arrayList.add(cjVar.f267a);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m220a(String str) {
        a(new cj(str));
    }

    synchronized void a(cj cjVar) {
        c(cjVar.f267a);
        this.f250a.add(cjVar);
    }

    public synchronized void a(String[] strArr) {
        int i2;
        int size = this.f250a.size() - 1;
        while (true) {
            i2 = 0;
            if (size < 0) {
                break;
            }
            int length = strArr.length;
            while (true) {
                if (i2 < length) {
                    if (TextUtils.equals(this.f250a.get(size).f267a, strArr[i2])) {
                        this.f250a.remove(size);
                        break;
                    }
                    i2++;
                }
            }
            size--;
        }
        Iterator<cj> it = this.f250a.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            cj next = it.next();
            if (next.f12559a > i3) {
                i3 = next.f12559a;
            }
        }
        while (i2 < strArr.length) {
            a(new cj(strArr[i2], (strArr.length + i3) - i2));
            i2++;
        }
    }

    public synchronized String a() {
        if (!TextUtils.isEmpty(this.f12547i)) {
            return this.f12547i;
        }
        if (TextUtils.isEmpty(this.f12543e)) {
            return "hardcode_isp";
        }
        this.f12547i = bb.a(new String[]{this.f12543e, this.f12541c, this.f12542d, this.f12545g, this.f12544f}, c.c.a.b.a.a.s1);
        return this.f12547i;
    }

    public void a(double d2) {
        this.f12539a = d2;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized JSONObject m219a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("net", this.f249a);
        jSONObject.put(RemoteMessageConst.TTL, this.f12540b);
        jSONObject.put("pct", this.f12539a);
        jSONObject.put("ts", this.f248a);
        jSONObject.put(UserInfo.CITY, this.f12542d);
        jSONObject.put("prv", this.f12541c);
        jSONObject.put("cty", this.f12545g);
        jSONObject.put("isp", this.f12543e);
        jSONObject.put("ip", this.f12544f);
        jSONObject.put(com.taobao.accs.common.Constants.KEY_HOST, this.f251b);
        jSONObject.put("xf", this.f12546h);
        JSONArray jSONArray = new JSONArray();
        Iterator<cj> it = this.f250a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public synchronized cc a(JSONObject jSONObject) {
        this.f249a = jSONObject.optString("net");
        this.f12540b = jSONObject.getLong(RemoteMessageConst.TTL);
        this.f12539a = jSONObject.getDouble("pct");
        this.f248a = jSONObject.getLong("ts");
        this.f12542d = jSONObject.optString(UserInfo.CITY);
        this.f12541c = jSONObject.optString("prv");
        this.f12545g = jSONObject.optString("cty");
        this.f12543e = jSONObject.optString("isp");
        this.f12544f = jSONObject.optString("ip");
        this.f251b = jSONObject.optString(com.taobao.accs.common.Constants.KEY_HOST);
        this.f12546h = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            a(new cj().a(jSONArray.getJSONObject(i2)));
        }
        return this;
    }
}
