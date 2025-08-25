package com.umeng.analytics.pro;

import com.umeng.commonsdk.service.UMGlobalContext;
import org.json.JSONObject;

/* compiled from: HttpPostThread.java */
/* loaded from: classes2.dex */
public class ao implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10051a = "https://ucc.umeng.com/v2/inn/fetch";

    /* renamed from: b, reason: collision with root package name */
    private String f10052b;

    /* renamed from: c, reason: collision with root package name */
    private String f10053c;

    /* renamed from: d, reason: collision with root package name */
    private String f10054d;

    public ao(String str, JSONObject jSONObject, String str2) {
        this.f10052b = str;
        this.f10053c = jSONObject.toString();
        this.f10054d = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONObject jSONObject = null;
        try {
            byte[] bArrA = am.a(this.f10052b, this.f10053c);
            if (bArrA != null) {
                JSONObject jSONObject2 = new JSONObject(new String(bArrA));
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("sourceIucc", this.f10054d);
                    jSONObject3.put("config", jSONObject2);
                } catch (Throwable unused) {
                }
                jSONObject = jSONObject3;
            }
        } catch (Throwable unused2) {
        }
        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 102, com.umeng.ccg.d.a(), jSONObject);
    }
}
