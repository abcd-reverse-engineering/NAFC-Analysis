package com.umeng.ut.b.b;

import org.json.JSONObject;

/* loaded from: classes2.dex */
class b {

    /* renamed from: d, reason: collision with root package name */
    int f11918d = -1;

    b() {
    }

    static b a(String str) {
        JSONObject jSONObject;
        b bVar = new b();
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.has("code")) {
                bVar.f11918d = jSONObject2.getInt("code");
            }
            if (jSONObject2.has("data") && (jSONObject = jSONObject2.getJSONObject("data")) != null && jSONObject.has("id") && jSONObject.has("d_ts")) {
                d.a(com.umeng.ut.a.a.a().m41a()).a(jSONObject.getString("id"), jSONObject.getLong("d_ts"));
            }
            com.umeng.ut.a.c.e.m44a("BizResponse", "content", str);
        } catch (Throwable th) {
            com.umeng.ut.a.c.e.m44a("", th.toString());
        }
        return bVar;
    }

    static boolean a(int i2) {
        return i2 >= 0 && i2 != 10012;
    }
}
