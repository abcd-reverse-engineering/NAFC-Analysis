package com.huawei.hms.common.internal;

import android.text.TextUtils;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.tencent.connect.common.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ResponseWrap {

    /* renamed from: a, reason: collision with root package name */
    private String f6775a;

    /* renamed from: b, reason: collision with root package name */
    private ResponseHeader f6776b;

    public ResponseWrap(ResponseHeader responseHeader) {
        this.f6776b = responseHeader;
    }

    public boolean fromJson(String str) {
        if (this.f6776b == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f6776b.setStatusCode(JsonUtil.getIntValue(jSONObject, "status_code"));
            this.f6776b.setErrorCode(JsonUtil.getIntValue(jSONObject, "error_code"));
            this.f6776b.setErrorReason(JsonUtil.getStringValue(jSONObject, "error_reason"));
            this.f6776b.setSrvName(JsonUtil.getStringValue(jSONObject, "srv_name"));
            this.f6776b.setApiName(JsonUtil.getStringValue(jSONObject, "api_name"));
            this.f6776b.setAppID(JsonUtil.getStringValue(jSONObject, "app_id"));
            this.f6776b.setPkgName(JsonUtil.getStringValue(jSONObject, Constants.PARAM_PKG_NAME));
            this.f6776b.setSessionId(JsonUtil.getStringValue(jSONObject, "session_id"));
            this.f6776b.setTransactionId(JsonUtil.getStringValue(jSONObject, CommonCode.MapKey.TRANSACTION_ID));
            this.f6776b.setResolution(JsonUtil.getStringValue(jSONObject, "resolution"));
            this.f6775a = JsonUtil.getStringValue(jSONObject, "body");
            return true;
        } catch (JSONException e2) {
            HMSLog.e("ResponseWrap", "fromJson failed: " + e2.getMessage());
            return false;
        }
    }

    public String getBody() {
        if (TextUtils.isEmpty(this.f6775a)) {
            this.f6775a = new JSONObject().toString();
        }
        return this.f6775a;
    }

    public ResponseHeader getResponseHeader() {
        return this.f6776b;
    }

    public void setBody(String str) {
        this.f6775a = str;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.f6776b = responseHeader;
    }

    public String toJson() throws JSONException {
        if (this.f6776b == null) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status_code", this.f6776b.getStatusCode());
            jSONObject.put("error_code", this.f6776b.getErrorCode());
            jSONObject.put("error_reason", this.f6776b.getErrorReason());
            jSONObject.put("srv_name", this.f6776b.getSrvName());
            jSONObject.put("api_name", this.f6776b.getApiName());
            jSONObject.put("app_id", this.f6776b.getAppID());
            jSONObject.put(Constants.PARAM_PKG_NAME, this.f6776b.getPkgName());
            jSONObject.put(CommonCode.MapKey.TRANSACTION_ID, this.f6776b.getTransactionId());
            jSONObject.put("resolution", this.f6776b.getResolution());
            String sessionId = this.f6776b.getSessionId();
            if (!TextUtils.isEmpty(sessionId)) {
                jSONObject.put("session_id", sessionId);
            }
            if (!TextUtils.isEmpty(this.f6775a)) {
                jSONObject.put("body", this.f6775a);
            }
        } catch (JSONException e2) {
            HMSLog.e("ResponseWrap", "toJson failed: " + e2.getMessage());
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "ResponseWrap{body='" + this.f6775a + "', responseHeader=" + this.f6776b + '}';
    }
}
