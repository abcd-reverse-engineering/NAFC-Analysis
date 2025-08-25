package com.huawei.hms.push;

import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;
import com.tencent.connect.common.Constants;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PushSelfShowMessage.java */
/* loaded from: classes.dex */
public class o {
    private int B;
    private String D;

    /* renamed from: b, reason: collision with root package name */
    private int f7211b;

    /* renamed from: c, reason: collision with root package name */
    private String f7212c;

    /* renamed from: d, reason: collision with root package name */
    private String f7213d;

    /* renamed from: l, reason: collision with root package name */
    private String f7221l;

    /* renamed from: m, reason: collision with root package name */
    private String f7222m;
    private String n;
    private String o;
    private String p;
    private String r;
    private String s;
    private String z;

    /* renamed from: a, reason: collision with root package name */
    private String f7210a = "";

    /* renamed from: e, reason: collision with root package name */
    private String f7214e = "";

    /* renamed from: f, reason: collision with root package name */
    private String f7215f = "";

    /* renamed from: g, reason: collision with root package name */
    private String f7216g = "";

    /* renamed from: h, reason: collision with root package name */
    private String f7217h = "";

    /* renamed from: i, reason: collision with root package name */
    private String f7218i = "";

    /* renamed from: j, reason: collision with root package name */
    private String f7219j = "";

    /* renamed from: k, reason: collision with root package name */
    private String f7220k = "";
    private String q = "";
    private int t = k.STYLE_DEFAULT.ordinal();
    private String u = "";
    private String v = "";
    private String w = "";
    private int x = 0;
    private int y = 0;
    private String A = "";
    private String C = "";
    private String E = "";
    private String F = "";

    public o(byte[] bArr, byte[] bArr2) {
        Charset charset = m.f7206a;
        this.r = new String(bArr, charset);
        this.s = new String(bArr2, charset);
    }

    private JSONObject a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject);
        jSONObject2.put("group", this.f7210a);
        jSONObject2.put("tag", this.A);
        jSONObject2.put(RemoteMessageConst.Notification.AUTO_CANCEL, this.x);
        jSONObject2.put(RemoteMessageConst.Notification.VISIBILITY, this.y);
        jSONObject2.put(RemoteMessageConst.Notification.WHEN, this.z);
        return jSONObject2;
    }

    private JSONObject b(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(com.taobao.agoo.a.a.b.JSON_CMD, this.f7216g);
        jSONObject2.put("content", this.f7217h);
        jSONObject2.put(RemoteMessageConst.Notification.NOTIFY_ICON, this.f7218i);
        jSONObject2.put(RemoteMessageConst.Notification.NOTIFY_TITLE, this.f7219j);
        jSONObject2.put("notifySummary", this.f7220k);
        jSONObject2.put(RemoteMessageConst.MessageBody.PARAM, jSONObject);
        return jSONObject2;
    }

    private void c(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("ap")) {
            String string = jSONObject.getString("ap");
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(string) || string.length() >= 48) {
                this.f7213d = string.substring(0, 48);
                return;
            }
            int length = 48 - string.length();
            for (int i2 = 0; i2 < length; i2++) {
                sb.append("0");
            }
            sb.append(string);
            this.f7213d = sb.toString();
        }
    }

    private boolean d(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has(RemoteMessageConst.Notification.CLICK_ACTION)) {
            this.f7222m = jSONObject.getString(RemoteMessageConst.Notification.CLICK_ACTION);
        }
        if (jSONObject.has(RemoteMessageConst.Notification.INTENT_URI)) {
            this.f7212c = jSONObject.getString(RemoteMessageConst.Notification.INTENT_URI);
        }
        if (jSONObject.has("appPackageName")) {
            this.f7221l = jSONObject.getString("appPackageName");
            return true;
        }
        HMSLog.d("PushSelfShowLog", "appPackageName is null");
        return false;
    }

    private boolean e(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.has(RemoteMessageConst.MSGID)) {
            HMSLog.i("PushSelfShowLog", "msgId == null");
            return false;
        }
        Object obj = jSONObject.get(RemoteMessageConst.MSGID);
        if (obj instanceof String) {
            this.f7214e = (String) obj;
            return true;
        }
        if (!(obj instanceof Integer)) {
            return true;
        }
        this.f7214e = String.valueOf(((Integer) obj).intValue());
        return true;
    }

    private boolean f(JSONObject jSONObject) throws JSONException {
        HMSLog.d("PushSelfShowLog", "enter parseNotifyParam");
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.NOTIFY_DETAIL);
            if (jSONObject2.has("style")) {
                this.t = jSONObject2.getInt("style");
            }
            this.u = jSONObject2.optString("bigTitle");
            this.v = jSONObject2.optString("bigContent");
            this.E = jSONObject2.optString(RemoteMessageConst.Notification.ICON);
            return true;
        } catch (JSONException e2) {
            HMSLog.i("PushSelfShowLog", e2.toString());
            return false;
        }
    }

    private void g(JSONObject jSONObject) {
        this.f7210a = jSONObject.optString("group");
        HMSLog.d("PushSelfShowLog", "NOTIFY_GROUP:" + this.f7210a);
        this.x = jSONObject.optInt(RemoteMessageConst.Notification.AUTO_CANCEL, 1);
        HMSLog.d("PushSelfShowLog", "autoCancel: " + this.x);
        this.y = jSONObject.optInt(RemoteMessageConst.Notification.VISIBILITY, 0);
        this.z = jSONObject.optString(RemoteMessageConst.Notification.WHEN);
        this.A = jSONObject.optString("tag");
    }

    private boolean h(JSONObject jSONObject) throws JSONException {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.PARAM);
            if (jSONObject2.has("autoClear")) {
                this.f7211b = jSONObject2.getInt("autoClear");
            } else {
                this.f7211b = 0;
            }
            if (!Constants.JumpUrlConstants.SRC_TYPE_APP.equals(this.f7216g) && !"cosa".equals(this.f7216g)) {
                if ("url".equals(this.f7216g)) {
                    k(jSONObject2);
                    return true;
                }
                if (!"rp".equals(this.f7216g)) {
                    return true;
                }
                j(jSONObject2);
                return true;
            }
            d(jSONObject2);
            return true;
        } catch (Exception e2) {
            HMSLog.e("PushSelfShowLog", "ParseParam error ", e2);
            return false;
        }
    }

    private boolean i(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(RemoteMessageConst.MessageBody.PS_CONTENT)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
            this.f7216g = jSONObject2.getString(com.taobao.agoo.a.a.b.JSON_CMD);
            this.f7217h = jSONObject2.optString("content");
            this.f7218i = jSONObject2.optString(RemoteMessageConst.Notification.NOTIFY_ICON);
            this.f7219j = jSONObject2.optString(RemoteMessageConst.Notification.NOTIFY_TITLE);
            this.f7220k = jSONObject2.optString("notifySummary");
            this.D = jSONObject2.optString(RemoteMessageConst.Notification.TICKER);
            if ((!jSONObject2.has(RemoteMessageConst.MessageBody.NOTIFY_DETAIL) || f(jSONObject2)) && jSONObject2.has(RemoteMessageConst.MessageBody.PARAM)) {
                return h(jSONObject2);
            }
        }
        return false;
    }

    private boolean j(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has("appPackageName")) {
            this.f7221l = jSONObject.getString("appPackageName");
        }
        if (!jSONObject.has("rpt") || !jSONObject.has("rpl")) {
            HMSLog.d("PushSelfShowLog", "rpl or rpt is null");
            return false;
        }
        this.o = jSONObject.getString("rpl");
        this.p = jSONObject.getString("rpt");
        if (!jSONObject.has("rpct")) {
            return true;
        }
        this.q = jSONObject.getString("rpct");
        return true;
    }

    private boolean k(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (!jSONObject.has("url")) {
            HMSLog.d("PushSelfShowLog", "url is null");
            return false;
        }
        this.n = jSONObject.getString("url");
        if (jSONObject.has("appPackageName")) {
            this.f7221l = jSONObject.getString("appPackageName");
        }
        if (!jSONObject.has("rpt") || !jSONObject.has("rpl")) {
            return true;
        }
        this.o = jSONObject.getString("rpl");
        this.p = jSONObject.getString("rpt");
        if (!jSONObject.has("rpct")) {
            return true;
        }
        this.q = jSONObject.getString("rpct");
        return true;
    }

    private JSONObject q() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("style", this.t);
        jSONObject.put("bigTitle", this.u);
        jSONObject.put("bigContent", this.v);
        jSONObject.put("bigPic", this.w);
        return jSONObject;
    }

    private JSONObject u() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("autoClear", this.f7211b);
        jSONObject.put("url", this.n);
        jSONObject.put("rpl", this.o);
        jSONObject.put("rpt", this.p);
        jSONObject.put("rpct", this.q);
        jSONObject.put("appPackageName", this.f7221l);
        jSONObject.put(RemoteMessageConst.Notification.CLICK_ACTION, this.f7222m);
        jSONObject.put(RemoteMessageConst.Notification.INTENT_URI, this.f7212c);
        return jSONObject;
    }

    public String l() {
        return this.E;
    }

    public String m() {
        return this.f7212c;
    }

    public byte[] n() {
        try {
            return a(a(b(u()), q())).toString().getBytes(m.f7206a);
        } catch (JSONException e2) {
            HMSLog.e("PushSelfShowLog", "getMsgData failed JSONException:", e2);
            return new byte[0];
        }
    }

    public String o() {
        HMSLog.d("PushSelfShowLog", "msgId =" + this.f7214e);
        return this.f7214e;
    }

    public String p() {
        return this.A;
    }

    public int r() {
        return this.B;
    }

    public String s() {
        return this.f7220k;
    }

    public String t() {
        return this.f7219j;
    }

    public int v() {
        return this.t;
    }

    public String w() {
        return this.D;
    }

    public byte[] x() {
        return this.s.getBytes(m.f7206a);
    }

    public boolean y() throws JSONException {
        try {
            if (TextUtils.isEmpty(this.r)) {
                HMSLog.d("PushSelfShowLog", "msg is null");
                return false;
            }
            JSONObject jSONObject = new JSONObject(this.r);
            g(jSONObject);
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
            if (!e(jSONObject2)) {
                return false;
            }
            this.f7215f = jSONObject2.optString("dispPkgName");
            c(jSONObject2);
            this.B = jSONObject2.optInt(RemoteMessageConst.Notification.NOTIFY_ID, -1);
            this.C = jSONObject2.optString("data");
            this.F = jSONObject2.optString(RemoteMessageConst.ANALYTIC_INFO);
            return i(jSONObject2);
        } catch (JSONException unused) {
            HMSLog.d("PushSelfShowLog", "parse message exception.");
            return false;
        } catch (Exception e2) {
            HMSLog.d("PushSelfShowLog", e2.toString());
            return false;
        }
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("dispPkgName", this.f7215f);
        jSONObject3.put(RemoteMessageConst.MSGID, this.f7214e);
        jSONObject3.put("ap", this.f7213d);
        jSONObject3.put(RemoteMessageConst.Notification.NOTIFY_ID, this.B);
        jSONObject3.put(RemoteMessageConst.MessageBody.PS_CONTENT, jSONObject);
        jSONObject3.put(RemoteMessageConst.MessageBody.NOTIFY_DETAIL, jSONObject2);
        jSONObject3.put(RemoteMessageConst.Notification.TICKER, this.D);
        jSONObject3.put("data", this.C);
        return jSONObject3;
    }

    public String b() {
        return this.F;
    }

    public int d() {
        return this.x;
    }

    public String g() {
        return this.u;
    }

    public int e() {
        return this.f7211b;
    }

    public String f() {
        return this.v;
    }

    public String j() {
        return this.f7215f;
    }

    public String c() {
        return this.f7221l;
    }

    public String k() {
        return this.f7210a;
    }

    public String h() {
        return this.f7216g;
    }

    public String i() {
        return this.f7217h;
    }

    public String a() {
        return this.f7222m;
    }

    public void a(int i2) {
        this.B = i2;
    }
}
