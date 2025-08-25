package com.huawei.hms.hatool;

import android.os.Build;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class y0 extends t0 {

    /* renamed from: f, reason: collision with root package name */
    String f7116f;

    /* renamed from: g, reason: collision with root package name */
    String f7117g;

    /* renamed from: h, reason: collision with root package name */
    private String f7118h;

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_rom_ver", this.f7118h);
        jSONObject.put("_emui_ver", this.f7099a);
        jSONObject.put("_model", Build.MODEL);
        jSONObject.put("_mcc", this.f7116f);
        jSONObject.put("_mnc", this.f7117g);
        jSONObject.put("_package_name", this.f7100b);
        jSONObject.put("_app_ver", this.f7101c);
        jSONObject.put("_lib_ver", "2.2.0.314");
        jSONObject.put("_channel", this.f7102d);
        jSONObject.put("_lib_name", "hianalytics");
        jSONObject.put("_oaid_tracking_flag", this.f7103e);
        return jSONObject;
    }

    public void f(String str) {
        this.f7116f = str;
    }

    public void g(String str) {
        this.f7117g = str;
    }

    public void h(String str) {
        this.f7118h = str;
    }
}
