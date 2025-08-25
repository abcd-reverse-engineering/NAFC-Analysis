package com.xiaomi.push.service;

import android.content.SharedPreferences;
import android.util.Base64;
import com.xiaomi.push.C0343r;
import com.xiaomi.push.Cdo;
import com.xiaomi.push.af;
import com.xiaomi.push.ci;
import com.xiaomi.push.dp;
import com.xiaomi.push.fy;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class ax {

    /* renamed from: a, reason: collision with root package name */
    private static ax f13397a = new ax();

    /* renamed from: a, reason: collision with other field name */
    private static String f1015a;

    /* renamed from: a, reason: collision with other field name */
    private af.b f1016a;

    /* renamed from: a, reason: collision with other field name */
    private Cdo.a f1017a;

    /* renamed from: a, reason: collision with other field name */
    private List<a> f1018a = new ArrayList();

    public static abstract class a {
        public void a(Cdo.a aVar) {
        }

        public void a(dp.b bVar) {
        }
    }

    private ax() {
    }

    private void b() throws Throwable {
        if (this.f1017a == null) {
            d();
        }
    }

    private void c() {
        if (this.f1016a != null) {
            return;
        }
        this.f1016a = new af.b() { // from class: com.xiaomi.push.service.ax.1

            /* renamed from: a, reason: collision with other field name */
            boolean f1019a = false;

            @Override // com.xiaomi.push.af.b
            public void b() {
                try {
                    Cdo.a aVarA = Cdo.a.a(Base64.decode(ci.a(C0343r.m636a(), "https://resolver.msg.xiaomi.net/psc/?t=a", (List<com.xiaomi.push.at>) null), 10));
                    if (aVarA != null) {
                        ax.this.f1017a = aVarA;
                        this.f1019a = true;
                        ax.this.e();
                    }
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("fetch config failure: " + e2.getMessage());
                }
            }

            @Override // com.xiaomi.push.af.b
            /* renamed from: c */
            public void mo265c() {
                a[] aVarArr;
                ax.this.f1016a = null;
                if (this.f1019a) {
                    synchronized (ax.this) {
                        aVarArr = (a[]) ax.this.f1018a.toArray(new a[ax.this.f1018a.size()]);
                    }
                    for (a aVar : aVarArr) {
                        aVar.a(ax.this.f1017a);
                    }
                }
            }
        };
        fy.a(this.f1016a);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d() throws java.lang.Throwable {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.xiaomi.push.C0343r.m636a()     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            java.lang.String r2 = "XMCloudCfg"
            java.io.FileInputStream r1 = r1.openFileInput(r2)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            com.xiaomi.push.b r0 = com.xiaomi.push.b.a(r2)     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L25
            com.xiaomi.push.do$a r0 = com.xiaomi.push.Cdo.a.b(r0)     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L25
            r4.f1017a = r0     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L25
            r2.close()     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L25
            com.xiaomi.push.w.a(r2)
            goto L47
        L21:
            r0 = move-exception
            r1 = r0
            r0 = r2
            goto L53
        L25:
            r0 = move-exception
            r1 = r0
            r0 = r2
            goto L2c
        L29:
            r1 = move-exception
            goto L53
        L2b:
            r1 = move-exception
        L2c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L29
            r2.<init>()     // Catch: java.lang.Throwable -> L29
            java.lang.String r3 = "load config failure: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L29
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L29
            r2.append(r1)     // Catch: java.lang.Throwable -> L29
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L29
            com.xiaomi.channel.commonutils.logger.b.m50a(r1)     // Catch: java.lang.Throwable -> L29
            com.xiaomi.push.w.a(r0)
        L47:
            com.xiaomi.push.do$a r0 = r4.f1017a
            if (r0 != 0) goto L52
            com.xiaomi.push.do$a r0 = new com.xiaomi.push.do$a
            r0.<init>()
            r4.f1017a = r0
        L52:
            return
        L53:
            com.xiaomi.push.w.a(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ax.d():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            if (this.f1017a != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(C0343r.m636a().openFileOutput("XMCloudCfg", 0));
                com.xiaomi.push.c cVarA = com.xiaomi.push.c.a(bufferedOutputStream);
                this.f1017a.a(cVarA);
                cVarA.m196a();
                bufferedOutputStream.close();
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m50a("save config failure: " + e2.getMessage());
        }
    }

    public static ax a() {
        return f13397a;
    }

    public synchronized void a(a aVar) {
        this.f1018a.add(aVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    synchronized void m710a() {
        this.f1018a.clear();
    }

    /* renamed from: a, reason: collision with other method in class */
    int m708a() throws Throwable {
        b();
        Cdo.a aVar = this.f1017a;
        if (aVar != null) {
            return aVar.c();
        }
        return 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public Cdo.a m709a() throws Throwable {
        b();
        return this.f1017a;
    }

    void a(dp.b bVar) {
        a[] aVarArr;
        if (bVar.m300d() && bVar.d() > m708a()) {
            c();
        }
        synchronized (this) {
            aVarArr = (a[]) this.f1018a.toArray(new a[this.f1018a.size()]);
        }
        for (a aVar : aVarArr) {
            aVar.a(bVar);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static synchronized String m705a() {
        if (f1015a == null) {
            SharedPreferences sharedPreferences = C0343r.m636a().getSharedPreferences("XMPushServiceConfig", 0);
            f1015a = sharedPreferences.getString("DeviceUUID", null);
            if (f1015a == null) {
                f1015a = com.xiaomi.push.i.a(C0343r.m636a(), false);
                if (f1015a != null) {
                    sharedPreferences.edit().putString("DeviceUUID", f1015a).commit();
                }
            }
        }
        return f1015a;
    }
}
