package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.service.XMJobService;

/* loaded from: classes2.dex */
public final class dz {

    /* renamed from: a, reason: collision with other field name */
    private static a f417a;

    /* renamed from: a, reason: collision with other field name */
    private static final String f418a = XMJobService.class.getCanonicalName();

    /* renamed from: a, reason: collision with root package name */
    private static int f12726a = 0;

    interface a {
        void a();

        void a(boolean z);

        /* renamed from: a, reason: collision with other method in class */
        boolean mo372a();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0065 A[Catch: Exception -> 0x007c, PHI: r5
  0x0065: PHI (r5v6 boolean) = (r5v5 boolean), (r5v8 boolean) binds: [B:12:0x003c, B:20:0x0062] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #1 {Exception -> 0x007c, blocks: (B:11:0x0034, B:13:0x003e, B:22:0x0065, B:24:0x006f), top: B:44:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009a A[EDGE_INSN: B:49:0x009a->B:34:0x009a BREAK  A[LOOP:0: B:10:0x0032->B:27:0x0079], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r9) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            java.lang.String r0 = "android.permission.BIND_JOB_SERVICE"
            android.content.Context r9 = r9.getApplicationContext()
            java.lang.String r1 = r9.getPackageName()
            java.lang.String r2 = "com.xiaomi.xmsf"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L1b
            com.xiaomi.push.ea r0 = new com.xiaomi.push.ea
            r0.<init>(r9)
            com.xiaomi.push.dz.f417a = r0
            goto Ld4
        L1b:
            android.content.pm.PackageManager r1 = r9.getPackageManager()
            r2 = 0
            java.lang.String r3 = r9.getPackageName()     // Catch: java.lang.Exception -> L80
            r4 = 4
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r3, r4)     // Catch: java.lang.Exception -> L80
            android.content.pm.ServiceInfo[] r3 = r1.services     // Catch: java.lang.Exception -> L80
            r4 = 1
            if (r3 == 0) goto L7e
            android.content.pm.ServiceInfo[] r1 = r1.services     // Catch: java.lang.Exception -> L80
            int r3 = r1.length     // Catch: java.lang.Exception -> L80
            r5 = 0
        L32:
            if (r2 >= r3) goto L9a
            r6 = r1[r2]     // Catch: java.lang.Exception -> L7c
            java.lang.String r7 = r6.permission     // Catch: java.lang.Exception -> L7c
            boolean r7 = r0.equals(r7)     // Catch: java.lang.Exception -> L7c
            if (r7 == 0) goto L65
            java.lang.String r7 = com.xiaomi.push.dz.f418a     // Catch: java.lang.Exception -> L7c
            java.lang.String r8 = r6.name     // Catch: java.lang.Exception -> L7c
            boolean r7 = r7.equals(r8)     // Catch: java.lang.Exception -> L7c
            if (r7 == 0) goto L4a
        L48:
            r5 = 1
            goto L62
        L4a:
            java.lang.String r7 = r6.name     // Catch: java.lang.Exception -> L61
            java.lang.Class r7 = com.xiaomi.push.C0343r.a(r9, r7)     // Catch: java.lang.Exception -> L61
            java.lang.String r8 = com.xiaomi.push.dz.f418a     // Catch: java.lang.Exception -> L61
            java.lang.Class r7 = r7.getSuperclass()     // Catch: java.lang.Exception -> L61
            java.lang.String r7 = r7.getCanonicalName()     // Catch: java.lang.Exception -> L61
            boolean r7 = r8.equals(r7)     // Catch: java.lang.Exception -> L61
            if (r7 == 0) goto L62
            goto L48
        L61:
        L62:
            if (r5 != r4) goto L65
            goto L9a
        L65:
            java.lang.String r7 = com.xiaomi.push.dz.f418a     // Catch: java.lang.Exception -> L7c
            java.lang.String r8 = r6.name     // Catch: java.lang.Exception -> L7c
            boolean r7 = r7.equals(r8)     // Catch: java.lang.Exception -> L7c
            if (r7 == 0) goto L79
            java.lang.String r6 = r6.permission     // Catch: java.lang.Exception -> L7c
            boolean r6 = r0.equals(r6)     // Catch: java.lang.Exception -> L7c
            if (r6 == 0) goto L79
            r5 = 1
            goto L9a
        L79:
            int r2 = r2 + 1
            goto L32
        L7c:
            r1 = move-exception
            goto L82
        L7e:
            r5 = 0
            goto L9a
        L80:
            r1 = move-exception
            r5 = 0
        L82:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "check service err : "
            r2.append(r3)
            java.lang.String r1 = r1.getMessage()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.xiaomi.channel.commonutils.logger.b.m50a(r1)
        L9a:
            if (r5 != 0) goto Lc9
            boolean r1 = com.xiaomi.push.C0343r.m639a(r9)
            if (r1 != 0) goto La3
            goto Lc9
        La3:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Should export service: "
            r1.append(r2)
            java.lang.String r2 = com.xiaomi.push.dz.f418a
            r1.append(r2)
            java.lang.String r2 = " with permission "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = " in AndroidManifest.xml file"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r9.<init>(r0)
            throw r9
        Lc9:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            com.xiaomi.push.ea r0 = new com.xiaomi.push.ea
            r0.<init>(r9)
            com.xiaomi.push.dz.f417a = r0
        Ld4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dz.a(android.content.Context):void");
    }

    public static synchronized void a(Context context, int i2) {
        int i3 = f12726a;
        if (!"com.xiaomi.xmsf".equals(context.getPackageName())) {
            if (i2 == 2) {
                f12726a = 2;
            } else {
                f12726a = 0;
            }
        }
        if (i3 != f12726a && f12726a == 2) {
            a();
            f417a = new ec(context);
        }
    }

    public static synchronized void a(boolean z) {
        if (f417a == null) {
            com.xiaomi.channel.commonutils.logger.b.m50a("timer is not initialized");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("[Alarm] register alarm. (" + z + ")");
        f417a.a(z);
    }

    public static synchronized void a() {
        if (f417a == null) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("[Alarm] stop alarm.");
        f417a.a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static synchronized boolean m371a() {
        if (f417a == null) {
            return false;
        }
        return f417a.mo372a();
    }
}
