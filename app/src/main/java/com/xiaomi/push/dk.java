package com.xiaomi.push;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.push.ae;

/* loaded from: classes2.dex */
public class dk {

    /* renamed from: a, reason: collision with root package name */
    private static volatile dk f12644a;

    /* renamed from: a, reason: collision with other field name */
    private Context f328a;

    /* renamed from: a, reason: collision with other field name */
    private a f329a;

    public interface a {
        void a();
    }

    private dk(Context context) {
        this.f328a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        a aVar;
        ae aeVarA = ae.a(this.f328a);
        com.xiaomi.push.service.ah ahVarA = com.xiaomi.push.service.ah.a(this.f328a);
        SharedPreferences sharedPreferences = this.f328a.getSharedPreferences("mipush_extra", 0);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = sharedPreferences.getLong("first_try_ts", jCurrentTimeMillis);
        if (j2 == jCurrentTimeMillis) {
            sharedPreferences.edit().putLong("first_try_ts", jCurrentTimeMillis).commit();
        }
        if (Math.abs(jCurrentTimeMillis - j2) < 172800000) {
            return;
        }
        a(ahVarA, aeVarA, false);
        if (ahVarA.a(gk.StorageCollectionSwitch.a(), true)) {
            int iA = a(ahVarA.a(gk.StorageCollectionFrequency.a(), RemoteMessageConst.DEFAULT_TTL));
            aeVarA.a(new dm(this.f328a, iA), iA, 0);
        }
        if (j.m627a(this.f328a) && (aVar = this.f329a) != null) {
            aVar.a();
        }
        if (ahVarA.a(gk.ActivityTSSwitch.a(), false)) {
            a();
        }
        a(ahVarA, aeVarA, true);
    }

    public static dk a(Context context) {
        if (f12644a == null) {
            synchronized (dk.class) {
                if (f12644a == null) {
                    f12644a = new dk(context);
                }
            }
        }
        return f12644a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m270a() {
        ae.a(this.f328a).a(new Runnable() { // from class: com.xiaomi.push.dk.1
            @Override // java.lang.Runnable
            public void run() {
                dk.this.b();
            }
        });
    }

    private void a(com.xiaomi.push.service.ah ahVar, ae aeVar, boolean z) {
        if (ahVar.a(gk.UploadSwitch.a(), true)) {
            dn dnVar = new dn(this.f328a);
            if (z) {
                aeVar.a((ae.a) dnVar, a(ahVar.a(gk.UploadFrequency.a(), RemoteMessageConst.DEFAULT_TTL)));
            } else {
                aeVar.m130a((ae.a) dnVar);
            }
        }
    }

    public static int a(int i2) {
        return Math.max(60, i2);
    }

    private boolean a() {
        Application application;
        try {
            if (this.f328a instanceof Application) {
                application = (Application) this.f328a;
            } else {
                application = (Application) this.f328a.getApplicationContext();
            }
            application.registerActivityLifecycleCallbacks(new de(this.f328a, String.valueOf(System.currentTimeMillis() / 1000)));
            return true;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return false;
        }
    }
}
