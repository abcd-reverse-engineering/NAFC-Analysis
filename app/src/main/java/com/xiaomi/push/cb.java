package com.xiaomi.push;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class cb {

    /* renamed from: a, reason: collision with root package name */
    private int f12536a;

    /* renamed from: a, reason: collision with other field name */
    private long f246a;

    /* renamed from: a, reason: collision with other field name */
    private String f247a;

    /* renamed from: b, reason: collision with root package name */
    private long f12537b;

    /* renamed from: c, reason: collision with root package name */
    private long f12538c;

    public cb() {
        this(0, 0L, 0L, null);
    }

    public int a() {
        return this.f12536a;
    }

    public cb(int i2, long j2, long j3, Exception exc) {
        this.f12536a = i2;
        this.f246a = j2;
        this.f12538c = j3;
        this.f12537b = System.currentTimeMillis();
        if (exc != null) {
            this.f247a = exc.getClass().getSimpleName();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public JSONObject m217a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.f246a);
        jSONObject.put("size", this.f12538c);
        jSONObject.put("ts", this.f12537b);
        jSONObject.put("wt", this.f12536a);
        jSONObject.put("expt", this.f247a);
        return jSONObject;
    }

    public cb a(JSONObject jSONObject) {
        this.f246a = jSONObject.getLong("cost");
        this.f12538c = jSONObject.getLong("size");
        this.f12537b = jSONObject.getLong("ts");
        this.f12536a = jSONObject.getInt("wt");
        this.f247a = jSONObject.optString("expt");
        return this;
    }
}
