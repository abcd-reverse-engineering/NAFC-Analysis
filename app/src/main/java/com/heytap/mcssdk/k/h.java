package com.heytap.mcssdk.k;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* loaded from: classes.dex */
public class h {

    /* renamed from: d, reason: collision with root package name */
    private static final String f5908d = "shared_msg_sdk";

    /* renamed from: e, reason: collision with root package name */
    private static final String f5909e = "hasDefaultChannelCreated";

    /* renamed from: f, reason: collision with root package name */
    private static final String f5910f = "decryptTag";

    /* renamed from: a, reason: collision with root package name */
    private Context f5911a;

    /* renamed from: b, reason: collision with root package name */
    private SharedPreferences f5912b;

    /* renamed from: c, reason: collision with root package name */
    private Object f5913c;

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        static h f5914a = new h();

        private b() {
        }
    }

    private h() {
        this.f5913c = new Object();
        Context contextK = com.heytap.mcssdk.a.w().k();
        if (contextK != null) {
            this.f5911a = a(contextK);
        }
        Context context = this.f5911a;
        if (context != null) {
            this.f5912b = context.getSharedPreferences(f5908d, 0);
        }
    }

    private Context a(Context context) {
        boolean zA = d.a();
        g.b("fbeVersion is " + zA);
        return (!zA || Build.VERSION.SDK_INT < 24) ? context.getApplicationContext() : context.createDeviceProtectedStorageContext();
    }

    public static h c() {
        return b.f5914a;
    }

    private SharedPreferences d() {
        SharedPreferences sharedPreferences = this.f5912b;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        synchronized (this.f5913c) {
            if (this.f5912b != null || this.f5911a == null) {
                return this.f5912b;
            }
            this.f5912b = this.f5911a.getSharedPreferences(f5908d, 0);
            return this.f5912b;
        }
    }

    public void a(String str) {
        SharedPreferences sharedPreferencesD = d();
        if (sharedPreferencesD != null) {
            sharedPreferencesD.edit().putString(f5910f, str).commit();
        }
    }

    public void a(boolean z) {
        SharedPreferences sharedPreferencesD = d();
        if (sharedPreferencesD != null) {
            sharedPreferencesD.edit().putBoolean(f5909e, z).commit();
        }
    }

    public boolean a() {
        SharedPreferences sharedPreferencesD = d();
        if (sharedPreferencesD != null) {
            return sharedPreferencesD.getBoolean(f5909e, false);
        }
        return false;
    }

    public String b() {
        SharedPreferences sharedPreferencesD = d();
        return sharedPreferencesD != null ? sharedPreferencesD.getString(f5910f, "DES") : "DES";
    }
}
