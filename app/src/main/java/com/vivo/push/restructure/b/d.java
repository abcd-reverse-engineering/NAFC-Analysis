package com.vivo.push.restructure.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.vivo.push.PushConfig;
import com.vivo.push.util.aa;
import com.vivo.push.util.g;
import com.vivo.push.util.u;
import com.vivo.push.util.z;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: PushRelyImpl.java */
/* loaded from: classes2.dex */
public final class d implements a {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, c> f12171a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private String f12172b;

    /* renamed from: c, reason: collision with root package name */
    private z f12173c;

    /* renamed from: d, reason: collision with root package name */
    private volatile PushConfig f12174d;

    public d(z zVar) {
        this.f12173c = zVar;
    }

    @Override // com.vivo.push.restructure.b.a
    public final String a(Context context, String str) {
        if (!TextUtils.isEmpty(this.f12172b)) {
            return this.f12172b;
        }
        if (context == null || TextUtils.isEmpty(str)) {
            u.a("PushRelyImpl", "getReceiverClassName() params error, context = " + context + ", action = " + str);
            return "";
        }
        String packageName = context.getPackageName();
        this.f12172b = a(context, packageName, str);
        if (TextUtils.isEmpty(this.f12172b)) {
            u.d("PushRelyImpl", " reflectReceiver error: receiver for: " + str + " not found, package: " + packageName);
        }
        return this.f12172b;
    }

    @Override // com.vivo.push.restructure.b.a
    public final void b() {
        a("");
    }

    @Override // com.vivo.push.restructure.b.a
    public final String c() throws PackageManager.NameNotFoundException {
        c cVar = f12171a.get(com.vivo.push.restructure.a.a().b().getPackageName());
        if (cVar != null) {
            String strB = cVar.b();
            if (!TextUtils.isEmpty(strB)) {
                return strB;
            }
        }
        String strC = this.f12173c.c();
        if (!TextUtils.isEmpty(strC)) {
            if (cVar == null) {
                cVar = new c();
            }
            cVar.b(strC);
            f12171a.put(com.vivo.push.restructure.a.a().b().getPackageName(), cVar);
        }
        return strC;
    }

    @Override // com.vivo.push.restructure.b.a
    public final void d() {
        b("");
    }

    @Override // com.vivo.push.restructure.b.a
    public final void e() {
        this.f12173c.a();
        f12171a.clear();
    }

    @Override // com.vivo.push.restructure.b.a
    public final String f() {
        return this.f12173c.b("APP_TOKEN", (String) null);
    }

    @Override // com.vivo.push.restructure.b.a
    public final String g() {
        return this.f12173c.b("APP_TAGS", (String) null);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void h() {
        this.f12173c.a("APP_TAGS");
    }

    @Override // com.vivo.push.restructure.b.a
    public final String i() {
        return this.f12173c.b("APP_ALIAS", (String) null);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void j() {
        this.f12173c.a("APP_ALIAS");
    }

    @Override // com.vivo.push.restructure.b.a
    public final String k() throws PackageManager.NameNotFoundException {
        com.vivo.push.model.b bVarA = aa.a(com.vivo.push.restructure.a.a().b(), com.vivo.push.restructure.a.a().f());
        if (bVarA == null || bVarA.c()) {
            return null;
        }
        return bVarA.a();
    }

    @Override // com.vivo.push.restructure.b.a
    public final PushConfig l() {
        if (this.f12174d != null) {
            return this.f12174d;
        }
        int iB = this.f12173c.b("PUSH_CLIENT_CONFIG", 1) & 1;
        return new PushConfig.Builder().agreePrivacyStatement(iB != 0).openMultiUserMode(iB != 0).build();
    }

    @Override // com.vivo.push.restructure.b.a
    public final void b(String str) {
        this.f12173c.a("APP_APIKEY", str);
        c cVar = f12171a.get(com.vivo.push.restructure.a.a().b().getPackageName());
        if (cVar == null) {
            cVar = new c();
        }
        cVar.b(str);
        f12171a.put(com.vivo.push.restructure.a.a().b().getPackageName(), cVar);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void d(String str) {
        this.f12173c.a("APP_TAGS", str);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void e(String str) {
        this.f12173c.a("APP_ALIAS", str);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void c(String str) {
        this.f12173c.a("APP_TOKEN", str);
    }

    private static String a(Context context, String str, String str2) {
        List<ResolveInfo> listQueryBroadcastReceivers;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 64)) == null || listQueryBroadcastReceivers.size() <= 0) {
                return null;
            }
            return listQueryBroadcastReceivers.get(0).activityInfo.name;
        } catch (Exception e2) {
            u.a("PushRelyImpl", "error  " + e2.getMessage());
            return null;
        }
    }

    @Override // com.vivo.push.restructure.b.a
    public final String a() throws PackageManager.NameNotFoundException {
        c cVar = f12171a.get(com.vivo.push.restructure.a.a().b().getPackageName());
        if (cVar != null) {
            String strA = cVar.a();
            if (!TextUtils.isEmpty(strA)) {
                return strA;
            }
        }
        String strB = this.f12173c.b();
        if (!TextUtils.isEmpty(strB)) {
            if (cVar == null) {
                cVar = new c();
            }
            cVar.a(strB);
            f12171a.put(com.vivo.push.restructure.a.a().b().getPackageName(), cVar);
        }
        return strB;
    }

    @Override // com.vivo.push.restructure.b.a
    public final void a(String str) {
        this.f12173c.a("APP_APPID", str);
        c cVar = f12171a.get(com.vivo.push.restructure.a.a().b().getPackageName());
        if (cVar == null) {
            cVar = new c();
        }
        cVar.a(str);
        f12171a.put(com.vivo.push.restructure.a.a().b().getPackageName(), cVar);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void a(PushConfig pushConfig) {
        int i2;
        if (pushConfig == null) {
            return;
        }
        this.f12174d = null;
        Context contextB = com.vivo.push.restructure.a.a().b();
        if (pushConfig == null) {
            i2 = 1;
        } else {
            i2 = (pushConfig.isAgreePrivacyStatement() ? 1 : 0) | (pushConfig.isOpenMultiUser() ? 1 : 0);
        }
        this.f12173c.a("PUSH_CLIENT_CONFIG", i2);
        g.a().execute(new e(this, contextB, pushConfig));
        this.f12174d = pushConfig;
    }
}
