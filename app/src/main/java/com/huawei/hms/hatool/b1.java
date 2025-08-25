package com.huawei.hms.hatool;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b1 implements o1 {

    /* renamed from: a, reason: collision with root package name */
    private String f6956a;

    /* renamed from: b, reason: collision with root package name */
    private String f6957b;

    /* renamed from: c, reason: collision with root package name */
    private String f6958c;

    /* renamed from: d, reason: collision with root package name */
    private String f6959d;

    /* renamed from: e, reason: collision with root package name */
    private String f6960e;

    /* renamed from: f, reason: collision with root package name */
    private String f6961f;

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", this.f6956a);
        jSONObject.put("eventtime", this.f6959d);
        jSONObject.put("event", this.f6957b);
        jSONObject.put("event_session_name", this.f6960e);
        jSONObject.put("first_session_event", this.f6961f);
        if (TextUtils.isEmpty(this.f6958c)) {
            return null;
        }
        jSONObject.put("properties", new JSONObject(this.f6958c));
        return jSONObject;
    }

    public void a(String str) {
        this.f6958c = str;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f6957b = jSONObject.optString("event");
        this.f6958c = n.a(jSONObject.optString("properties"), o0.d().a());
        this.f6956a = jSONObject.optString("type");
        this.f6959d = jSONObject.optString("eventtime");
        this.f6960e = jSONObject.optString("event_session_name");
        this.f6961f = jSONObject.optString("first_session_event");
    }

    public String b() {
        return this.f6959d;
    }

    public void b(String str) {
        this.f6957b = str;
    }

    public String c() {
        return this.f6956a;
    }

    public void c(String str) {
        this.f6959d = str;
    }

    public JSONObject d() throws JSONException {
        JSONObject jSONObjectA = a();
        jSONObjectA.put("properties", n.b(this.f6958c, o0.d().a()));
        return jSONObjectA;
    }

    public void d(String str) {
        this.f6956a = str;
    }

    public void e(String str) {
        this.f6961f = str;
    }

    public void f(String str) {
        this.f6960e = str;
    }
}
