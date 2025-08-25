package com.xiaomi.clientreport.data;

import com.heytap.mcssdk.constant.b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class EventClientReport extends a {
    public String eventContent;
    public String eventId;
    public long eventTime;
    public int eventType;

    public static EventClientReport getBlankInstance() {
        return new EventClientReport();
    }

    @Override // com.xiaomi.clientreport.data.a
    public JSONObject toJson() throws JSONException {
        try {
            JSONObject json = super.toJson();
            if (json == null) {
                return null;
            }
            json.put(b.f5833k, this.eventId);
            json.put("eventType", this.eventType);
            json.put("eventTime", this.eventTime);
            json.put("eventContent", this.eventContent == null ? "" : this.eventContent);
            return json;
        } catch (JSONException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return null;
        }
    }

    @Override // com.xiaomi.clientreport.data.a
    public String toJsonString() {
        return super.toJsonString();
    }
}
