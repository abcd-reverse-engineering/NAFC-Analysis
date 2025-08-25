package com.umeng.message.common.inter;

import com.umeng.analytics.pro.bh;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public interface ITagManager {
    public static final String FAIL = "fail";
    public static final String SUCCESS = "ok";

    Result addTags(JSONObject jSONObject, String... strArr) throws Exception;

    Result deleteTags(JSONObject jSONObject, String... strArr) throws Exception;

    List<String> getTags(JSONObject jSONObject) throws Exception;

    public static class Result {
        public String errors;
        public long interval;
        public String jsonString;
        public int remain;
        public String status;

        public Result() {
            this.status = "fail";
            this.remain = 0;
            this.interval = 0L;
            this.errors = "";
            this.jsonString = "";
        }

        public void setErrors(String str) {
            this.errors = str;
        }

        public String toString() {
            return this.jsonString;
        }

        public Result(JSONObject jSONObject) {
            this.status = "fail";
            this.remain = 0;
            this.interval = 0L;
            this.errors = "";
            this.jsonString = "";
            if (jSONObject == null) {
                return;
            }
            this.jsonString = jSONObject.toString();
            this.status = jSONObject.optString("success", "fail");
            this.remain = jSONObject.optInt("remain", 0);
            this.interval = jSONObject.optLong(bh.aX, 0L);
            this.errors = jSONObject.optString("errors");
        }
    }
}
