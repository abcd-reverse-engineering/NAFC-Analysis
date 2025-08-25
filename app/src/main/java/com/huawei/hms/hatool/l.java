package com.huawei.hms.hatool;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class l extends t {

    /* renamed from: b, reason: collision with root package name */
    private String f7033b = "";

    /* renamed from: c, reason: collision with root package name */
    private String f7034c = "";

    /* renamed from: d, reason: collision with root package name */
    private String f7035d = "";

    /* renamed from: e, reason: collision with root package name */
    private String f7036e = "";

    /* renamed from: f, reason: collision with root package name */
    protected String f7037f = "";

    /* renamed from: g, reason: collision with root package name */
    private String f7038g;

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("androidid", this.f7098a);
        jSONObject.put("oaid", this.f7038g);
        jSONObject.put("uuid", this.f7037f);
        jSONObject.put("upid", this.f7036e);
        jSONObject.put("imei", this.f7033b);
        jSONObject.put("sn", this.f7034c);
        jSONObject.put("udid", this.f7035d);
        return jSONObject;
    }

    public void b(String str) {
        this.f7033b = str;
    }

    public void c(String str) {
        this.f7038g = str;
    }

    public void d(String str) {
        this.f7034c = str;
    }

    public void e(String str) {
        this.f7035d = str;
    }

    public void f(String str) {
        this.f7036e = str;
    }

    public void g(String str) {
        this.f7037f = str;
    }
}
