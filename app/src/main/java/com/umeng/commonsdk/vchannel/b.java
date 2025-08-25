package com.umeng.commonsdk.vchannel;

import android.content.Context;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Event.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private String f11121b;

    /* renamed from: a, reason: collision with root package name */
    private String f11120a = "_$unknown";

    /* renamed from: c, reason: collision with root package name */
    private long f11122c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f11123d = 0;

    /* renamed from: e, reason: collision with root package name */
    private String f11124e = a.f11119j;

    /* renamed from: f, reason: collision with root package name */
    private Map<String, Object> f11125f = null;

    public b(Context context) {
        this.f11121b = UMGlobalContext.getInstance(context).getProcessName(context);
    }

    public String a() {
        return this.f11120a;
    }

    public long b() {
        return this.f11122c;
    }

    public Map<String, Object> c() {
        return this.f11125f;
    }

    public JSONObject d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.f11120a);
            jSONObject.put("pn", this.f11121b);
            jSONObject.put("ds", this.f11123d);
            jSONObject.put("ts", this.f11122c);
            if (this.f11125f != null && this.f11125f.size() > 0) {
                for (String str : this.f11125f.keySet()) {
                    jSONObject.put(str, this.f11125f.get(str));
                }
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(this.f11124e, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ekv", jSONArray2);
            return jSONObject3;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append("id:" + this.f11120a + Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("pn:" + this.f11121b + Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("ts:" + this.f11122c + Constants.ACCEPT_TIME_SEPARATOR_SP);
        Map<String, Object> map = this.f11125f;
        if (map != null && map.size() > 0) {
            for (String str : this.f11125f.keySet()) {
                Object obj = this.f11125f.get(str);
                sb.append(obj == null ? str + ": null," : str + ": " + obj.toString() + Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        sb.append("ds:" + this.f11123d + "]");
        return sb.toString();
    }

    public void a(String str) {
        this.f11120a = str;
    }

    public void a(long j2) {
        this.f11122c = j2;
    }

    public void a(Map<String, Object> map) {
        this.f11125f = map;
    }
}
