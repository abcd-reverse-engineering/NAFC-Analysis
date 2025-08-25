package com.huawei.hms.activity.internal;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ForegroundInnerHeader {

    /* renamed from: a, reason: collision with root package name */
    private int f6536a;

    /* renamed from: b, reason: collision with root package name */
    private String f6537b;

    /* renamed from: c, reason: collision with root package name */
    private String f6538c;

    public void fromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f6536a = JsonUtil.getIntValue(jSONObject, "apkVersion");
            this.f6537b = JsonUtil.getStringValue(jSONObject, "action");
            this.f6538c = JsonUtil.getStringValue(jSONObject, "responseCallbackKey");
        } catch (JSONException e2) {
            HMSLog.e("ForegroundInnerHeader", "fromJson failed: " + e2.getMessage());
        }
    }

    public String getAction() {
        return this.f6537b;
    }

    public int getApkVersion() {
        return this.f6536a;
    }

    public String getResponseCallbackKey() {
        return this.f6538c;
    }

    public void setAction(String str) {
        this.f6537b = str;
    }

    public void setApkVersion(int i2) {
        this.f6536a = i2;
    }

    public void setResponseCallbackKey(String str) {
        this.f6538c = str;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apkVersion", this.f6536a);
            jSONObject.put("action", this.f6537b);
            jSONObject.put("responseCallbackKey", this.f6538c);
        } catch (JSONException e2) {
            HMSLog.e("ForegroundInnerHeader", "ForegroundInnerHeader toJson failed: " + e2.getMessage());
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "apkVersion:" + this.f6536a + ", action:" + this.f6537b + ", responseCallbackKey:" + this.f6538c;
    }
}
