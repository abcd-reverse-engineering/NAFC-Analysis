package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f12355a;

    /* renamed from: a, reason: collision with other field name */
    private Context f106a;

    /* renamed from: a, reason: collision with other field name */
    private a f107a;

    /* renamed from: a, reason: collision with other field name */
    String f108a;

    /* renamed from: a, reason: collision with other field name */
    private Map<String, a> f109a;

    private b(Context context) {
        this.f106a = context;
        c();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static b m75a(Context context) {
        if (f12355a == null) {
            synchronized (b.class) {
                if (f12355a == null) {
                    f12355a = new b(context);
                }
            }
        }
        return f12355a;
    }

    private void c() {
        this.f107a = new a(this.f106a);
        this.f109a = new HashMap();
        SharedPreferences sharedPreferencesA = a(this.f106a);
        this.f107a.f111a = sharedPreferencesA.getString("appId", null);
        this.f107a.f12357b = sharedPreferencesA.getString("appToken", null);
        this.f107a.f12358c = sharedPreferencesA.getString("regId", null);
        this.f107a.f12359d = sharedPreferencesA.getString("regSec", null);
        this.f107a.f12361f = sharedPreferencesA.getString("devId", null);
        if (!TextUtils.isEmpty(this.f107a.f12361f) && com.xiaomi.push.i.a(this.f107a.f12361f)) {
            this.f107a.f12361f = com.xiaomi.push.i.h(this.f106a);
            sharedPreferencesA.edit().putString("devId", this.f107a.f12361f).commit();
        }
        this.f107a.f12360e = sharedPreferencesA.getString("vName", null);
        this.f107a.f112a = sharedPreferencesA.getBoolean("valid", true);
        this.f107a.f113b = sharedPreferencesA.getBoolean("paused", false);
        this.f107a.f12356a = sharedPreferencesA.getInt("envType", 1);
        this.f107a.f12362g = sharedPreferencesA.getString("regResource", null);
        this.f107a.f12363h = sharedPreferencesA.getString("appRegion", null);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m82b() {
        if (this.f107a.m89a()) {
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("Don't send message before initialization succeeded!");
        return false;
    }

    public String d() {
        return this.f107a.f12359d;
    }

    public String e() {
        return this.f107a.f12362g;
    }

    public String f() {
        return this.f107a.f12363h;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m85d() {
        return (TextUtils.isEmpty(this.f107a.f111a) || TextUtils.isEmpty(this.f107a.f12357b) || TextUtils.isEmpty(this.f107a.f12358c) || TextUtils.isEmpty(this.f107a.f12359d)) ? false : true;
    }

    /* renamed from: e, reason: collision with other method in class */
    public boolean m86e() {
        return this.f107a.f113b;
    }

    /* renamed from: f, reason: collision with other method in class */
    public boolean m87f() {
        return !this.f107a.f112a;
    }

    public String b() {
        return this.f107a.f12357b;
    }

    public void b(String str, String str2, String str3) {
        this.f107a.b(str, str2, str3);
    }

    public void b(String str) {
        this.f109a.remove(str);
        a(this.f106a).edit().remove("hybrid_app_info_" + str).commit();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m79a() {
        Context context = this.f106a;
        return !TextUtils.equals(com.xiaomi.push.g.m451a(context, context.getPackageName()), this.f107a.f12360e);
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m81b() {
        this.f107a.b();
    }

    public static class a {

        /* renamed from: a, reason: collision with other field name */
        private Context f110a;

        /* renamed from: a, reason: collision with other field name */
        public String f111a;

        /* renamed from: b, reason: collision with root package name */
        public String f12357b;

        /* renamed from: c, reason: collision with root package name */
        public String f12358c;

        /* renamed from: d, reason: collision with root package name */
        public String f12359d;

        /* renamed from: e, reason: collision with root package name */
        public String f12360e;

        /* renamed from: f, reason: collision with root package name */
        public String f12361f;

        /* renamed from: g, reason: collision with root package name */
        public String f12362g;

        /* renamed from: h, reason: collision with root package name */
        public String f12363h;

        /* renamed from: a, reason: collision with other field name */
        public boolean f112a = true;

        /* renamed from: b, reason: collision with other field name */
        public boolean f113b = false;

        /* renamed from: a, reason: collision with root package name */
        public int f12356a = 1;

        public a(Context context) {
            this.f110a = context;
        }

        public void a(String str, String str2, String str3) {
            this.f111a = str;
            this.f12357b = str2;
            this.f12362g = str3;
            SharedPreferences.Editor editorEdit = b.a(this.f110a).edit();
            editorEdit.putString("appId", this.f111a);
            editorEdit.putString("appToken", str2);
            editorEdit.putString("regResource", str3);
            editorEdit.commit();
        }

        public void b(String str, String str2, String str3) {
            this.f12358c = str;
            this.f12359d = str2;
            this.f12361f = com.xiaomi.push.i.h(this.f110a);
            this.f12360e = a();
            this.f112a = true;
            this.f12363h = str3;
            SharedPreferences.Editor editorEdit = b.a(this.f110a).edit();
            editorEdit.putString("regId", str);
            editorEdit.putString("regSec", str2);
            editorEdit.putString("devId", this.f12361f);
            editorEdit.putString("vName", a());
            editorEdit.putBoolean("valid", true);
            editorEdit.putString("appRegion", str3);
            editorEdit.commit();
        }

        public void c(String str, String str2, String str3) {
            this.f111a = str;
            this.f12357b = str2;
            this.f12362g = str3;
        }

        public void a(String str, String str2) {
            this.f12358c = str;
            this.f12359d = str2;
            this.f12361f = com.xiaomi.push.i.h(this.f110a);
            this.f12360e = a();
            this.f112a = true;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m90a(String str, String str2) {
            boolean zEquals = TextUtils.equals(this.f111a, str);
            boolean zEquals2 = TextUtils.equals(this.f12357b, str2);
            boolean z = !TextUtils.isEmpty(this.f12358c);
            boolean z2 = !TextUtils.isEmpty(this.f12359d);
            boolean z3 = TextUtils.isEmpty(com.xiaomi.push.i.b(this.f110a)) || TextUtils.equals(this.f12361f, com.xiaomi.push.i.h(this.f110a)) || TextUtils.equals(this.f12361f, com.xiaomi.push.i.g(this.f110a));
            boolean z4 = zEquals && zEquals2 && z && z2 && z3;
            if (!z4) {
                com.xiaomi.channel.commonutils.logger.b.e(String.format("register invalid, aid=%s;atn=%s;rid=%s;rse=%s;did=%s", Boolean.valueOf(zEquals), Boolean.valueOf(zEquals2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)));
            }
            return z4;
        }

        public void b() {
            this.f112a = false;
            b.a(this.f110a).edit().putBoolean("valid", this.f112a).commit();
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m89a() {
            return m90a(this.f111a, this.f12357b);
        }

        private String a() {
            Context context = this.f110a;
            return com.xiaomi.push.g.m451a(context, context.getPackageName());
        }

        /* renamed from: a, reason: collision with other method in class */
        public void m88a() {
            b.a(this.f110a).edit().clear().commit();
            this.f111a = null;
            this.f12357b = null;
            this.f12358c = null;
            this.f12359d = null;
            this.f12361f = null;
            this.f12360e = null;
            this.f112a = false;
            this.f113b = false;
            this.f12363h = null;
            this.f12356a = 1;
        }

        public void a(boolean z) {
            this.f113b = z;
        }

        public void a(int i2) {
            this.f12356a = i2;
        }

        public static a a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.f111a = jSONObject.getString("appId");
                aVar.f12357b = jSONObject.getString("appToken");
                aVar.f12358c = jSONObject.getString("regId");
                aVar.f12359d = jSONObject.getString("regSec");
                aVar.f12361f = jSONObject.getString("devId");
                aVar.f12360e = jSONObject.getString("vName");
                aVar.f112a = jSONObject.getBoolean("valid");
                aVar.f113b = jSONObject.getBoolean("paused");
                aVar.f12356a = jSONObject.getInt("envType");
                aVar.f12362g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        public static String a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", aVar.f111a);
                jSONObject.put("appToken", aVar.f12357b);
                jSONObject.put("regId", aVar.f12358c);
                jSONObject.put("regSec", aVar.f12359d);
                jSONObject.put("devId", aVar.f12361f);
                jSONObject.put("vName", aVar.f12360e);
                jSONObject.put("valid", aVar.f112a);
                jSONObject.put("paused", aVar.f113b);
                jSONObject.put("envType", aVar.f12356a);
                jSONObject.put("regResource", aVar.f12362g);
                return jSONObject.toString();
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m78a(String str) {
        SharedPreferences.Editor editorEdit = a(this.f106a).edit();
        editorEdit.putString("vName", str);
        editorEdit.commit();
        this.f107a.f12360e = str;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m76a() {
        return this.f107a.f111a;
    }

    public boolean a(String str, String str2) {
        return this.f107a.m90a(str, str2);
    }

    public void a(String str, String str2, String str3) {
        this.f107a.a(str, str2, str3);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m77a() {
        this.f107a.m88a();
    }

    public a a(String str) {
        if (this.f109a.containsKey(str)) {
            return this.f109a.get(str);
        }
        String str2 = "hybrid_app_info_" + str;
        SharedPreferences sharedPreferencesA = a(this.f106a);
        if (!sharedPreferencesA.contains(str2)) {
            return null;
        }
        a aVarA = a.a(this.f106a, sharedPreferencesA.getString(str2, ""));
        this.f109a.put(str2, aVarA);
        return aVarA;
    }

    /* renamed from: c, reason: collision with other method in class */
    public String m83c() {
        return this.f107a.f12358c;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m84c() {
        return this.f107a.m89a();
    }

    public void a(String str, a aVar) {
        this.f109a.put(str, aVar);
        a(this.f106a).edit().putString("hybrid_app_info_" + str, a.a(aVar)).commit();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m80a(String str, String str2, String str3) {
        a aVarA = a(str3);
        return aVarA != null && TextUtils.equals(str, aVarA.f111a) && TextUtils.equals(str2, aVarA.f12357b);
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    public int a() {
        return this.f107a.f12356a;
    }

    public void a(boolean z) {
        this.f107a.a(z);
        a(this.f106a).edit().putBoolean("paused", z).commit();
    }

    public void a(int i2) {
        this.f107a.a(i2);
        a(this.f106a).edit().putInt("envType", i2).commit();
    }
}
