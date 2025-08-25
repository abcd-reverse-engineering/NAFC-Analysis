package com.taobao.accs.utl;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class p {

    /* compiled from: Taobao */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        JSONObject f8695a = new JSONObject();

        public a a(String str, String str2) throws JSONException {
            if (str2 != null && str != null) {
                try {
                    this.f8695a.put(str, str2);
                } catch (JSONException unused) {
                }
            }
            return this;
        }

        public a a(String str, Integer num) throws JSONException {
            if (num == null) {
                return this;
            }
            try {
                this.f8695a.put(str, num);
            } catch (JSONException unused) {
            }
            return this;
        }

        public a a(String str, Long l2) throws JSONException {
            if (l2 == null) {
                return this;
            }
            try {
                this.f8695a.put(str, l2);
            } catch (JSONException unused) {
            }
            return this;
        }

        public JSONObject a() {
            return this.f8695a;
        }
    }

    public static String a(JSONObject jSONObject, String str, String str2) throws JSONException {
        return (jSONObject != null && jSONObject.has(str)) ? jSONObject.getString(str) : str2;
    }
}
