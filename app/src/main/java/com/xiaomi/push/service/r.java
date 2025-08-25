package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private static r f13452a;

    /* renamed from: a, reason: collision with other field name */
    private Context f1069a;

    /* renamed from: a, reason: collision with other field name */
    private List<String> f1070a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final List<String> f13453b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final List<String> f13454c = new ArrayList();

    private r(Context context) {
        this.f1069a = context.getApplicationContext();
        if (this.f1069a == null) {
            this.f1069a = context;
        }
        SharedPreferences sharedPreferences = this.f1069a.getSharedPreferences("mipush_app_info", 0);
        for (String str : sharedPreferences.getString("unregistered_pkg_names", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (TextUtils.isEmpty(str)) {
                this.f1070a.add(str);
            }
        }
        for (String str2 : sharedPreferences.getString("disable_push_pkg_names", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (!TextUtils.isEmpty(str2)) {
                this.f13453b.add(str2);
            }
        }
        for (String str3 : sharedPreferences.getString("disable_push_pkg_names_cache", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (!TextUtils.isEmpty(str3)) {
                this.f13454c.add(str3);
            }
        }
    }

    public static r a(Context context) {
        if (f13452a == null) {
            f13452a = new r(context);
        }
        return f13452a;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m746b(String str) {
        boolean zContains;
        synchronized (this.f13453b) {
            zContains = this.f13453b.contains(str);
        }
        return zContains;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m747c(String str) {
        boolean zContains;
        synchronized (this.f13454c) {
            zContains = this.f13454c.contains(str);
        }
        return zContains;
    }

    public void d(String str) {
        synchronized (this.f1070a) {
            if (this.f1070a.contains(str)) {
                this.f1070a.remove(str);
                this.f1069a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.bb.a(this.f1070a, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    public void e(String str) {
        synchronized (this.f13453b) {
            if (this.f13453b.contains(str)) {
                this.f13453b.remove(str);
                this.f1069a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.bb.a(this.f13453b, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    public void f(String str) {
        synchronized (this.f13454c) {
            if (this.f13454c.contains(str)) {
                this.f13454c.remove(str);
                this.f1069a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.bb.a(this.f13454c, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m745a(String str) {
        boolean zContains;
        synchronized (this.f1070a) {
            zContains = this.f1070a.contains(str);
        }
        return zContains;
    }

    public void b(String str) {
        synchronized (this.f13453b) {
            if (!this.f13453b.contains(str)) {
                this.f13453b.add(str);
                this.f1069a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.bb.a(this.f13453b, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    public void c(String str) {
        synchronized (this.f13454c) {
            if (!this.f13454c.contains(str)) {
                this.f13454c.add(str);
                this.f1069a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.bb.a(this.f13454c, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    public void a(String str) {
        synchronized (this.f1070a) {
            if (!this.f1070a.contains(str)) {
                this.f1070a.add(str);
                this.f1069a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.bb.a(this.f1070a, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }
}
