package com.huawei.hms.hatool;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class f0 extends k0 {

    /* renamed from: g, reason: collision with root package name */
    private String f6980g = "";

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("protocol_version", "3");
        jSONObject.put("compress_mode", "1");
        jSONObject.put("serviceid", this.f7030d);
        jSONObject.put("appid", this.f7027a);
        jSONObject.put("hmac", this.f6980g);
        jSONObject.put("chifer", this.f7032f);
        jSONObject.put("timestamp", this.f7028b);
        jSONObject.put("servicetag", this.f7029c);
        jSONObject.put("requestid", this.f7031e);
        return jSONObject;
    }

    public void g(String str) {
        this.f6980g = str;
    }
}
