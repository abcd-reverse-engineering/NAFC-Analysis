package com.umeng.analytics.pro;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: HttpPostDataThread.java */
/* loaded from: classes2.dex */
public class an implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10048a = "https://aspect-upush.umeng.com/occa/v1/event/report";

    /* renamed from: b, reason: collision with root package name */
    private String f10049b;

    /* renamed from: c, reason: collision with root package name */
    private String f10050c;

    public an(String str, JSONObject jSONObject) {
        this.f10049b = str;
        this.f10050c = jSONObject.toString();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (TextUtils.isEmpty(this.f10050c)) {
                return;
            }
            am.b(this.f10049b, this.f10050c.getBytes());
        } catch (Throwable unused) {
        }
    }
}
