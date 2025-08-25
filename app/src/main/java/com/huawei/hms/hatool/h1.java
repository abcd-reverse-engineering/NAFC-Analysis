package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class h1 implements o1 {

    /* renamed from: a, reason: collision with root package name */
    private List<b1> f6999a;

    /* renamed from: b, reason: collision with root package name */
    private k0 f7000b;

    /* renamed from: c, reason: collision with root package name */
    private t0 f7001c;

    /* renamed from: d, reason: collision with root package name */
    private o1 f7002d;

    /* renamed from: e, reason: collision with root package name */
    private String f7003e = "";

    /* renamed from: f, reason: collision with root package name */
    private String f7004f;

    public h1(String str) {
        this.f7004f = str;
    }

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() throws JSONException {
        String str;
        List<b1> list = this.f6999a;
        if (list == null || list.size() == 0) {
            str = "Not have actionEvent to send";
        } else if (this.f7000b == null || this.f7001c == null || this.f7002d == null) {
            str = "model in wrong format";
        } else {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("header", this.f7000b.a());
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObjectA = this.f7002d.a();
            jSONObjectA.put("properties", this.f7001c.a());
            try {
                jSONObjectA.put("events_global_properties", new JSONObject(this.f7003e));
            } catch (JSONException unused) {
                jSONObjectA.put("events_global_properties", this.f7003e);
            }
            jSONObject2.put("events_common", jSONObjectA);
            JSONArray jSONArray = new JSONArray();
            Iterator<b1> it = this.f6999a.iterator();
            while (it.hasNext()) {
                JSONObject jSONObjectA2 = it.next().a();
                if (jSONObjectA2 != null) {
                    jSONArray.put(jSONObjectA2);
                } else {
                    v.e("hmsSdk", "custom event is empty,delete this event");
                }
            }
            jSONObject2.put(com.umeng.analytics.pro.d.ar, jSONArray);
            try {
                String strA = n.a(k1.a(jSONObject2.toString().getBytes("UTF-8")), this.f7004f);
                if (TextUtils.isEmpty(strA)) {
                    v.e("hmsSdk", "eventInfo encrypt failed,report over!");
                    return null;
                }
                jSONObject.put("event", strA);
                return jSONObject;
            } catch (UnsupportedEncodingException unused2) {
                str = "getBitZip(): Unsupported coding : utf-8";
            }
        }
        v.e("hmsSdk", str);
        return null;
    }

    public void a(k0 k0Var) {
        this.f7000b = k0Var;
    }

    public void a(l lVar) {
        this.f7002d = lVar;
    }

    public void a(t0 t0Var) {
        this.f7001c = t0Var;
    }

    public void a(String str) {
        if (str != null) {
            this.f7003e = str;
        }
    }

    public void a(List<b1> list) {
        this.f6999a = list;
    }
}
