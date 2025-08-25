package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class g0 {

    /* renamed from: c, reason: collision with root package name */
    private static g0 f6981c;

    /* renamed from: a, reason: collision with root package name */
    private Context f6982a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f6983b = new Object();

    private g0() {
    }

    public static g0 a() {
        if (f6981c == null) {
            b();
        }
        return f6981c;
    }

    private JSONObject a(Map<String, String> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException unused) {
                v.b("hmsSdk", "Exception occured when transferring bundle to json");
            }
        }
        return jSONObject;
    }

    private static synchronized void b() {
        if (f6981c == null) {
            f6981c = new g0();
        }
    }

    public void a(Context context) {
        synchronized (this.f6983b) {
            if (this.f6982a != null) {
                return;
            }
            this.f6982a = context;
            e.a().a(context);
        }
    }

    public void a(String str, int i2) {
        e.a().a(str, i2);
    }

    public void a(String str, int i2, String str2, LinkedHashMap<String, String> linkedHashMap) throws JSONException {
        e.a().a(str, i2, str2, a(linkedHashMap));
    }

    public void a(String str, Context context, String str2, String str3) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_constants", str3);
            e.a().a(str, 0, str2, jSONObject);
        } catch (JSONException unused) {
            v.f("hmsSdk", "onEvent():JSON structure Exception!");
        }
    }

    public void b(String str, int i2, String str2, LinkedHashMap<String, String> linkedHashMap) throws JSONException {
        e.a().a(str, i2, str2, a(linkedHashMap), System.currentTimeMillis());
    }
}
