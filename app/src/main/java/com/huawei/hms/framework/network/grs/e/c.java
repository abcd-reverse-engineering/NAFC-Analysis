package com.huawei.hms.framework.network.grs.e;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static final String f6839b = "c";

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, PLSharedPreferences> f6840c = new ConcurrentHashMap(16);

    /* renamed from: a, reason: collision with root package name */
    private final PLSharedPreferences f6841a;

    public c(Context context, String str) {
        String packageName = context.getPackageName();
        Logger.d(f6839b, "get pkgname from context is{%s}", packageName);
        if (f6840c.containsKey(str + packageName)) {
            this.f6841a = f6840c.get(str + packageName);
        } else {
            this.f6841a = new PLSharedPreferences(context, str + packageName);
            f6840c.put(str + packageName, this.f6841a);
        }
        a(context);
    }

    private void a(Context context) {
        Logger.i(f6839b, "ContextHolder.getAppContext() from GRS is:" + ContextHolder.getAppContext());
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        try {
            String string = Long.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode);
            String strA = a("version", "");
            if (string.equals(strA)) {
                return;
            }
            Logger.i(f6839b, "app version changed! old version{%s} and new version{%s}", strA, string);
            b();
            b("version", string);
        } catch (PackageManager.NameNotFoundException unused) {
            Logger.w(f6839b, "get app version failed and catch NameNotFoundException");
        }
    }

    public String a(String str, String str2) {
        String string;
        PLSharedPreferences pLSharedPreferences = this.f6841a;
        if (pLSharedPreferences == null) {
            return str2;
        }
        synchronized (pLSharedPreferences) {
            string = this.f6841a.getString(str, str2);
        }
        return string;
    }

    public Map<String, ?> a() {
        Map<String, ?> all;
        PLSharedPreferences pLSharedPreferences = this.f6841a;
        if (pLSharedPreferences == null) {
            return new HashMap();
        }
        synchronized (pLSharedPreferences) {
            all = this.f6841a.getAll();
        }
        return all;
    }

    public void a(String str) {
        PLSharedPreferences pLSharedPreferences = this.f6841a;
        if (pLSharedPreferences == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.f6841a.remove(str);
        }
    }

    public void b() {
        PLSharedPreferences pLSharedPreferences = this.f6841a;
        if (pLSharedPreferences == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.f6841a.clear();
        }
    }

    public void b(String str, String str2) {
        PLSharedPreferences pLSharedPreferences = this.f6841a;
        if (pLSharedPreferences == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.f6841a.putString(str, str2);
        }
    }
}
