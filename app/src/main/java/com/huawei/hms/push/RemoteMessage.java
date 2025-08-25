package com.huawei.hms.push;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.DateUtil;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.support.api.push.PushException;
import com.huawei.hms.support.log.HMSLog;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class RemoteMessage implements Parcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f7169c;

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f7170d;

    /* renamed from: e, reason: collision with root package name */
    private static final long[] f7171e;

    /* renamed from: f, reason: collision with root package name */
    private static final HashMap<String, Object> f7172f;

    /* renamed from: g, reason: collision with root package name */
    private static final HashMap<String, Object> f7173g;

    /* renamed from: h, reason: collision with root package name */
    private static final HashMap<String, Object> f7174h;

    /* renamed from: i, reason: collision with root package name */
    private static final HashMap<String, Object> f7175i;

    /* renamed from: j, reason: collision with root package name */
    private static final HashMap<String, Object> f7176j;

    /* renamed from: a, reason: collision with root package name */
    private Bundle f7177a;

    /* renamed from: b, reason: collision with root package name */
    private Notification f7178b;

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final Bundle f7179a;

        /* renamed from: b, reason: collision with root package name */
        private final Map<String, String> f7180b;

        public Builder(String str) {
            Bundle bundle = new Bundle();
            this.f7179a = bundle;
            this.f7180b = new HashMap();
            bundle.putString("to", str);
        }

        public Builder addData(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("add data failed, key is null.");
            }
            this.f7180b.put(str, str2);
            return this;
        }

        public RemoteMessage build() throws JSONException {
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : this.f7180b.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                try {
                    String string = jSONObject.toString();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(RemoteMessageConst.COLLAPSE_KEY, this.f7179a.getString(RemoteMessageConst.COLLAPSE_KEY));
                    jSONObject2.put(RemoteMessageConst.TTL, this.f7179a.getInt(RemoteMessageConst.TTL));
                    jSONObject2.put(RemoteMessageConst.SEND_MODE, this.f7179a.getInt(RemoteMessageConst.SEND_MODE));
                    jSONObject2.put(RemoteMessageConst.RECEIPT_MODE, this.f7179a.getInt(RemoteMessageConst.RECEIPT_MODE));
                    JSONObject jSONObject3 = new JSONObject();
                    if (jSONObject.length() != 0) {
                        jSONObject3.put("data", string);
                    }
                    jSONObject3.put(RemoteMessageConst.MSGID, this.f7179a.getString(RemoteMessageConst.MSGID));
                    jSONObject2.put(RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject3);
                    bundle.putByteArray(RemoteMessageConst.MSGBODY, jSONObject2.toString().getBytes(m.f7206a));
                    bundle.putString("to", this.f7179a.getString("to"));
                    bundle.putString("message_type", this.f7179a.getString("message_type"));
                    return new RemoteMessage(bundle);
                } catch (JSONException unused) {
                    HMSLog.w("RemoteMessage", "JSONException: parse message body failed.");
                    throw new PushException(PushException.EXCEPTION_SEND_FAILED);
                }
            } catch (JSONException unused2) {
                HMSLog.w("RemoteMessage", "JSONException: parse data to json failed.");
                throw new PushException(PushException.EXCEPTION_SEND_FAILED);
            }
        }

        public Builder clearData() {
            this.f7180b.clear();
            return this;
        }

        public Builder setCollapseKey(String str) {
            this.f7179a.putString(RemoteMessageConst.COLLAPSE_KEY, str);
            return this;
        }

        public Builder setData(Map<String, String> map) {
            this.f7180b.clear();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f7180b.put(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public Builder setMessageId(String str) {
            this.f7179a.putString(RemoteMessageConst.MSGID, str);
            return this;
        }

        public Builder setMessageType(String str) {
            this.f7179a.putString("message_type", str);
            return this;
        }

        public Builder setReceiptMode(int i2) {
            if (i2 != 1 && i2 != 0) {
                throw new IllegalArgumentException("receipt mode can only be 0 or 1.");
            }
            this.f7179a.putInt(RemoteMessageConst.RECEIPT_MODE, i2);
            return this;
        }

        public Builder setSendMode(int i2) {
            if (i2 != 0 && i2 != 1) {
                throw new IllegalArgumentException("send mode can only be 0 or 1.");
            }
            this.f7179a.putInt(RemoteMessageConst.SEND_MODE, i2);
            return this;
        }

        public Builder setTtl(int i2) {
            if (i2 < 1 || i2 > 1296000) {
                throw new IllegalArgumentException("ttl must be greater than or equal to 1 and less than or equal to 1296000");
            }
            this.f7179a.putInt(RemoteMessageConst.TTL, i2);
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MessagePriority {
    }

    public static class Notification implements Serializable {
        private final long[] A;
        private final String B;

        /* renamed from: a, reason: collision with root package name */
        private final String f7181a;

        /* renamed from: b, reason: collision with root package name */
        private final String f7182b;

        /* renamed from: c, reason: collision with root package name */
        private final String[] f7183c;

        /* renamed from: d, reason: collision with root package name */
        private final String f7184d;

        /* renamed from: e, reason: collision with root package name */
        private final String f7185e;

        /* renamed from: f, reason: collision with root package name */
        private final String[] f7186f;

        /* renamed from: g, reason: collision with root package name */
        private final String f7187g;

        /* renamed from: h, reason: collision with root package name */
        private final String f7188h;

        /* renamed from: i, reason: collision with root package name */
        private final String f7189i;

        /* renamed from: j, reason: collision with root package name */
        private final String f7190j;

        /* renamed from: k, reason: collision with root package name */
        private final String f7191k;

        /* renamed from: l, reason: collision with root package name */
        private final String f7192l;

        /* renamed from: m, reason: collision with root package name */
        private final String f7193m;
        private final Uri n;
        private final int o;
        private final String p;
        private final int q;
        private final int r;
        private final int s;
        private final int[] t;
        private final String u;
        private final int v;
        private final String w;
        private final int x;
        private final String y;
        private final String z;

        /* synthetic */ Notification(Bundle bundle, a aVar) {
            this(bundle);
        }

        private Integer a(String str) {
            if (str != null) {
                try {
                    return Integer.valueOf(str);
                } catch (NumberFormatException unused) {
                    HMSLog.w("RemoteMessage", "NumberFormatException: get " + str + " failed.");
                }
            }
            return null;
        }

        public Integer getBadgeNumber() {
            return a(this.w);
        }

        public String getBody() {
            return this.f7184d;
        }

        public String[] getBodyLocalizationArgs() {
            String[] strArr = this.f7186f;
            return strArr == null ? new String[0] : (String[]) strArr.clone();
        }

        public String getBodyLocalizationKey() {
            return this.f7185e;
        }

        public String getChannelId() {
            return this.f7193m;
        }

        public String getClickAction() {
            return this.f7191k;
        }

        public String getColor() {
            return this.f7190j;
        }

        public String getIcon() {
            return this.f7187g;
        }

        public Uri getImageUrl() {
            String str = this.p;
            if (str == null) {
                return null;
            }
            return Uri.parse(str);
        }

        public Integer getImportance() {
            return a(this.y);
        }

        public String getIntentUri() {
            return this.f7192l;
        }

        public int[] getLightSettings() {
            int[] iArr = this.t;
            return iArr == null ? new int[0] : (int[]) iArr.clone();
        }

        public Uri getLink() {
            return this.n;
        }

        public int getNotifyId() {
            return this.o;
        }

        public String getSound() {
            return this.f7188h;
        }

        public String getTag() {
            return this.f7189i;
        }

        public String getTicker() {
            return this.z;
        }

        public String getTitle() {
            return this.f7181a;
        }

        public String[] getTitleLocalizationArgs() {
            String[] strArr = this.f7183c;
            return strArr == null ? new String[0] : (String[]) strArr.clone();
        }

        public String getTitleLocalizationKey() {
            return this.f7182b;
        }

        public long[] getVibrateConfig() {
            long[] jArr = this.A;
            return jArr == null ? new long[0] : (long[]) jArr.clone();
        }

        public Integer getVisibility() {
            return a(this.B);
        }

        public Long getWhen() {
            if (!TextUtils.isEmpty(this.u)) {
                try {
                    return Long.valueOf(DateUtil.parseUtcToMillisecond(this.u));
                } catch (StringIndexOutOfBoundsException unused) {
                    HMSLog.w("RemoteMessage", "StringIndexOutOfBoundsException: parse when failed.");
                } catch (ParseException unused2) {
                    HMSLog.w("RemoteMessage", "ParseException: parse when failed.");
                }
            }
            return null;
        }

        public boolean isAutoCancel() {
            return this.x == 1;
        }

        public boolean isDefaultLight() {
            return this.q == 1;
        }

        public boolean isDefaultSound() {
            return this.r == 1;
        }

        public boolean isDefaultVibrate() {
            return this.s == 1;
        }

        public boolean isLocalOnly() {
            return this.v == 1;
        }

        private Notification(Bundle bundle) {
            this.f7181a = bundle.getString(RemoteMessageConst.Notification.NOTIFY_TITLE);
            this.f7184d = bundle.getString("content");
            this.f7182b = bundle.getString(RemoteMessageConst.Notification.TITLE_LOC_KEY);
            this.f7185e = bundle.getString(RemoteMessageConst.Notification.BODY_LOC_KEY);
            this.f7183c = bundle.getStringArray(RemoteMessageConst.Notification.TITLE_LOC_ARGS);
            this.f7186f = bundle.getStringArray(RemoteMessageConst.Notification.BODY_LOC_ARGS);
            this.f7187g = bundle.getString(RemoteMessageConst.Notification.ICON);
            this.f7190j = bundle.getString(RemoteMessageConst.Notification.COLOR);
            this.f7188h = bundle.getString(RemoteMessageConst.Notification.SOUND);
            this.f7189i = bundle.getString("tag");
            this.f7193m = bundle.getString(RemoteMessageConst.Notification.CHANNEL_ID);
            this.f7191k = bundle.getString(RemoteMessageConst.Notification.CLICK_ACTION);
            this.f7192l = bundle.getString(RemoteMessageConst.Notification.INTENT_URI);
            this.o = bundle.getInt(RemoteMessageConst.Notification.NOTIFY_ID);
            String string = bundle.getString("url");
            this.n = !TextUtils.isEmpty(string) ? Uri.parse(string) : null;
            this.p = bundle.getString(RemoteMessageConst.Notification.NOTIFY_ICON);
            this.q = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_LIGHT_SETTINGS);
            this.r = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_SOUND);
            this.s = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_VIBRATE_TIMINGS);
            this.t = bundle.getIntArray(RemoteMessageConst.Notification.LIGHT_SETTINGS);
            this.u = bundle.getString(RemoteMessageConst.Notification.WHEN);
            this.v = bundle.getInt(RemoteMessageConst.Notification.LOCAL_ONLY);
            this.w = bundle.getString(RemoteMessageConst.Notification.BADGE_SET_NUM, null);
            this.x = bundle.getInt(RemoteMessageConst.Notification.AUTO_CANCEL);
            this.y = bundle.getString(RemoteMessageConst.Notification.PRIORITY, null);
            this.z = bundle.getString(RemoteMessageConst.Notification.TICKER);
            this.A = bundle.getLongArray(RemoteMessageConst.Notification.VIBRATE_TIMINGS);
            this.B = bundle.getString(RemoteMessageConst.Notification.VISIBILITY, null);
        }
    }

    class a implements Parcelable.Creator<RemoteMessage> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RemoteMessage createFromParcel(Parcel parcel) {
            return new RemoteMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RemoteMessage[] newArray(int i2) {
            return new RemoteMessage[i2];
        }
    }

    static {
        String[] strArr = new String[0];
        f7169c = strArr;
        int[] iArr = new int[0];
        f7170d = iArr;
        long[] jArr = new long[0];
        f7171e = jArr;
        HashMap<String, Object> map = new HashMap<>(8);
        f7172f = map;
        map.put("from", "");
        map.put(RemoteMessageConst.COLLAPSE_KEY, "");
        map.put(RemoteMessageConst.SEND_TIME, "");
        map.put(RemoteMessageConst.TTL, Integer.valueOf(RemoteMessageConst.DEFAULT_TTL));
        map.put(RemoteMessageConst.URGENCY, 2);
        map.put(RemoteMessageConst.ORI_URGENCY, 2);
        map.put(RemoteMessageConst.SEND_MODE, 0);
        map.put(RemoteMessageConst.RECEIPT_MODE, 0);
        HashMap<String, Object> map2 = new HashMap<>(8);
        f7173g = map2;
        map2.put(RemoteMessageConst.Notification.TITLE_LOC_KEY, "");
        map2.put(RemoteMessageConst.Notification.BODY_LOC_KEY, "");
        map2.put(RemoteMessageConst.Notification.NOTIFY_ICON, "");
        map2.put(RemoteMessageConst.Notification.TITLE_LOC_ARGS, strArr);
        map2.put(RemoteMessageConst.Notification.BODY_LOC_ARGS, strArr);
        map2.put(RemoteMessageConst.Notification.TICKER, "");
        map2.put(RemoteMessageConst.Notification.NOTIFY_TITLE, "");
        map2.put("content", "");
        HashMap<String, Object> map3 = new HashMap<>(8);
        f7174h = map3;
        map3.put(RemoteMessageConst.Notification.ICON, "");
        map3.put(RemoteMessageConst.Notification.COLOR, "");
        map3.put(RemoteMessageConst.Notification.SOUND, "");
        map3.put(RemoteMessageConst.Notification.DEFAULT_LIGHT_SETTINGS, 1);
        map3.put(RemoteMessageConst.Notification.LIGHT_SETTINGS, iArr);
        map3.put(RemoteMessageConst.Notification.DEFAULT_SOUND, 1);
        map3.put(RemoteMessageConst.Notification.DEFAULT_VIBRATE_TIMINGS, 1);
        map3.put(RemoteMessageConst.Notification.VIBRATE_TIMINGS, jArr);
        HashMap<String, Object> map4 = new HashMap<>(8);
        f7175i = map4;
        map4.put("tag", "");
        map4.put(RemoteMessageConst.Notification.WHEN, "");
        map4.put(RemoteMessageConst.Notification.LOCAL_ONLY, 1);
        map4.put(RemoteMessageConst.Notification.BADGE_SET_NUM, "");
        map4.put(RemoteMessageConst.Notification.PRIORITY, "");
        map4.put(RemoteMessageConst.Notification.AUTO_CANCEL, 1);
        map4.put(RemoteMessageConst.Notification.VISIBILITY, "");
        map4.put(RemoteMessageConst.Notification.CHANNEL_ID, "");
        HashMap<String, Object> map5 = new HashMap<>(3);
        f7176j = map5;
        map5.put(RemoteMessageConst.Notification.CLICK_ACTION, "");
        map5.put(RemoteMessageConst.Notification.INTENT_URI, "");
        map5.put("url", "");
        CREATOR = new a();
    }

    public RemoteMessage(Bundle bundle) {
        this.f7177a = a(bundle);
    }

    private Bundle a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        JSONObject jSONObjectB = b(bundle);
        JSONObject jSONObjectA = a(jSONObjectB);
        String string = JsonUtil.getString(jSONObjectA, "data", null);
        bundle2.putString(RemoteMessageConst.ANALYTIC_INFO, JsonUtil.getString(jSONObjectA, RemoteMessageConst.ANALYTIC_INFO, null));
        bundle2.putString(RemoteMessageConst.DEVICE_TOKEN, bundle.getString(RemoteMessageConst.DEVICE_TOKEN));
        JSONObject jSONObjectD = d(jSONObjectA);
        JSONObject jSONObjectB2 = b(jSONObjectD);
        JSONObject jSONObjectC = c(jSONObjectD);
        if (bundle.getInt(RemoteMessageConst.INPUT_TYPE) == 1 && d.a(jSONObjectA, jSONObjectD, string)) {
            bundle2.putString("data", com.huawei.hms.push.a.a(bundle.getByteArray(RemoteMessageConst.MSGBODY)));
            return bundle2;
        }
        String string2 = bundle.getString("to");
        String string3 = bundle.getString("message_type");
        String string4 = JsonUtil.getString(jSONObjectA, RemoteMessageConst.MSGID, null);
        bundle2.putString("to", string2);
        bundle2.putString("data", string);
        bundle2.putString(RemoteMessageConst.MSGID, string4);
        bundle2.putString("message_type", string3);
        JsonUtil.transferJsonObjectToBundle(jSONObjectB, bundle2, f7172f);
        bundle2.putBundle("notification", a(jSONObjectB, jSONObjectA, jSONObjectD, jSONObjectB2, jSONObjectC));
        return bundle2;
    }

    private static JSONObject b(Bundle bundle) {
        try {
            return new JSONObject(com.huawei.hms.push.a.a(bundle.getByteArray(RemoteMessageConst.MSGBODY)));
        } catch (JSONException unused) {
            HMSLog.w("RemoteMessage", "JSONException:parse message body failed.");
            return null;
        }
    }

    private static JSONObject c(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.PARAM);
        }
        return null;
    }

    private static JSONObject d(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public String getAnalyticInfo() {
        return this.f7177a.getString(RemoteMessageConst.ANALYTIC_INFO);
    }

    public Map<String, String> getAnalyticInfoMap() {
        HashMap map = new HashMap();
        String string = this.f7177a.getString(RemoteMessageConst.ANALYTIC_INFO);
        if (string != null && !string.trim().isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String strValueOf = String.valueOf(itKeys.next());
                    map.put(strValueOf, String.valueOf(jSONObject.get(strValueOf)));
                }
            } catch (JSONException unused) {
                HMSLog.w("RemoteMessage", "JSONException: get analyticInfo from map failed.");
            }
        }
        return map;
    }

    public String getCollapseKey() {
        return this.f7177a.getString(RemoteMessageConst.COLLAPSE_KEY);
    }

    public String getData() {
        return this.f7177a.getString("data");
    }

    public Map<String, String> getDataOfMap() {
        HashMap map = new HashMap();
        String string = this.f7177a.getString("data");
        if (string != null && !string.trim().isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String strValueOf = String.valueOf(itKeys.next());
                    map.put(strValueOf, String.valueOf(jSONObject.get(strValueOf)));
                }
            } catch (JSONException unused) {
                HMSLog.w("RemoteMessage", "JSONException: get data from map failed");
            }
        }
        return map;
    }

    public String getFrom() {
        return this.f7177a.getString("from");
    }

    public String getMessageId() {
        return this.f7177a.getString(RemoteMessageConst.MSGID);
    }

    public String getMessageType() {
        return this.f7177a.getString("message_type");
    }

    public Notification getNotification() {
        Bundle bundle = this.f7177a.getBundle("notification");
        a aVar = null;
        if (this.f7178b == null && bundle != null) {
            this.f7178b = new Notification(bundle, aVar);
        }
        if (this.f7178b == null) {
            this.f7178b = new Notification(new Bundle(), aVar);
        }
        return this.f7178b;
    }

    public int getOriginalUrgency() {
        int i2 = this.f7177a.getInt(RemoteMessageConst.ORI_URGENCY);
        if (i2 == 1 || i2 == 2) {
            return i2;
        }
        return 0;
    }

    public int getReceiptMode() {
        return this.f7177a.getInt(RemoteMessageConst.RECEIPT_MODE);
    }

    public int getSendMode() {
        return this.f7177a.getInt(RemoteMessageConst.SEND_MODE);
    }

    public long getSentTime() {
        try {
            String string = this.f7177a.getString(RemoteMessageConst.SEND_TIME);
            if (TextUtils.isEmpty(string)) {
                return 0L;
            }
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            HMSLog.w("RemoteMessage", "NumberFormatException: get sendTime error.");
            return 0L;
        }
    }

    public String getTo() {
        return this.f7177a.getString("to");
    }

    public String getToken() {
        return this.f7177a.getString(RemoteMessageConst.DEVICE_TOKEN);
    }

    public int getTtl() {
        return this.f7177a.getInt(RemoteMessageConst.TTL);
    }

    public int getUrgency() {
        int i2 = this.f7177a.getInt(RemoteMessageConst.URGENCY);
        if (i2 == 1 || i2 == 2) {
            return i2;
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeBundle(this.f7177a);
        parcel.writeSerializable(this.f7178b);
    }

    public RemoteMessage(Parcel parcel) {
        this.f7177a = parcel.readBundle();
        this.f7178b = (Notification) parcel.readSerializable();
    }

    private static JSONObject b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.NOTIFY_DETAIL);
        }
        return null;
    }

    private Bundle a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5) {
        Bundle bundle = new Bundle();
        JsonUtil.transferJsonObjectToBundle(jSONObject3, bundle, f7173g);
        JsonUtil.transferJsonObjectToBundle(jSONObject4, bundle, f7174h);
        JsonUtil.transferJsonObjectToBundle(jSONObject, bundle, f7175i);
        JsonUtil.transferJsonObjectToBundle(jSONObject5, bundle, f7176j);
        bundle.putInt(RemoteMessageConst.Notification.NOTIFY_ID, JsonUtil.getInt(jSONObject2, RemoteMessageConst.Notification.NOTIFY_ID, 0));
        return bundle;
    }

    private static JSONObject a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
        }
        return null;
    }
}
