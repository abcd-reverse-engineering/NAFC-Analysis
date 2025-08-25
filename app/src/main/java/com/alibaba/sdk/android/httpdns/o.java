package com.alibaba.sdk.android.httpdns;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class o {

    /* renamed from: d, reason: collision with root package name */
    private String[] f4078d;
    private boolean enabled;

    o(String str) throws JSONException {
        this.enabled = true;
        try {
            JSONObject jSONObject = new JSONObject(str);
            i.d("StartIp Schedule center response:" + jSONObject.toString());
            if (jSONObject.has("service_status")) {
                this.enabled = jSONObject.getString("service_status").equals("disable") ? false : true;
            }
            if (jSONObject.has("service_ip")) {
                JSONArray jSONArray = jSONObject.getJSONArray("service_ip");
                this.f4078d = new String[jSONArray.length()];
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.f4078d[i2] = (String) jSONArray.get(i2);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String[] b() {
        return this.f4078d;
    }

    public boolean isEnabled() {
        return this.enabled;
    }
}
