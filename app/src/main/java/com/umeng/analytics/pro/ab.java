package com.umeng.analytics.pro;

import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: AplAction.java */
/* loaded from: classes2.dex */
public class ab extends z {

    /* renamed from: a, reason: collision with root package name */
    private String f10019a;

    /* renamed from: b, reason: collision with root package name */
    private String f10020b;

    public ab(String str, ArrayList<aa> arrayList) {
        super(str, arrayList);
        this.f10019a = "";
        this.f10020b = "";
    }

    @Override // com.umeng.analytics.pro.z, com.umeng.analytics.pro.ag
    public JSONObject a(String str, JSONObject jSONObject) {
        JSONObject jSONObjectA = super.a(str, jSONObject);
        if (jSONObjectA != null) {
            try {
                jSONObjectA.put(com.umeng.ccg.a.s, this.f10019a);
                jSONObjectA.put("action", this.f10020b);
            } catch (Throwable unused) {
            }
        }
        return jSONObjectA;
    }

    public void c(String str) {
        this.f10019a = str;
    }

    public String d() {
        return this.f10019a;
    }

    public String e() {
        return this.f10020b;
    }

    public void d(String str) {
        this.f10020b = str;
    }
}
