package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.ae;

/* loaded from: classes2.dex */
public abstract class dl extends ae.a {

    /* renamed from: a, reason: collision with root package name */
    protected int f12646a;

    /* renamed from: a, reason: collision with other field name */
    protected Context f330a;

    public dl(Context context, int i2) {
        this.f12646a = i2;
        this.f330a = context;
    }

    private String c() {
        return "dc_job_result_time_" + mo183a();
    }

    private String d() {
        return "dc_job_result_" + mo183a();
    }

    public abstract gh a();

    /* renamed from: a, reason: collision with other method in class */
    protected boolean m271a() {
        return di.a(this.f330a, String.valueOf(mo183a()), this.f12646a);
    }

    public abstract String b();

    /* renamed from: b, reason: collision with other method in class */
    protected boolean m272b() {
        return true;
    }

    /* renamed from: c, reason: collision with other method in class */
    protected boolean m273c() {
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        String strB = b();
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        if (m271a()) {
            com.xiaomi.channel.commonutils.logger.b.m50a("DC run job mutual: " + mo183a());
            return;
        }
        df dfVarM269a = dg.a().m269a();
        String strA = dfVarM269a == null ? "" : dfVarM269a.a();
        if (!TextUtils.isEmpty(strA) && m272b()) {
            if (m273c()) {
                SharedPreferences sharedPreferences = this.f330a.getSharedPreferences("mipush_extra", 0);
                if (bb.a(strB).equals(sharedPreferences.getString(d(), null))) {
                    long j2 = sharedPreferences.getLong(c(), 0L);
                    int iA = com.xiaomi.push.service.ah.a(this.f330a).a(gk.DCJobUploadRepeatedInterval.a(), 604800);
                    if ((System.currentTimeMillis() - j2) / 1000 < this.f12646a) {
                        return;
                    }
                    if ((System.currentTimeMillis() - j2) / 1000 < iA) {
                        strB = "same_" + j2;
                    }
                }
            }
            gn gnVar = new gn();
            gnVar.a(strB);
            gnVar.a(System.currentTimeMillis());
            gnVar.a(a());
            a(this.f330a, gnVar, strA);
        }
    }

    public static void a(Context context, gn gnVar) {
        df dfVarM269a = dg.a().m269a();
        String strA = dfVarM269a == null ? "" : dfVarM269a.a();
        if (TextUtils.isEmpty(strA) || TextUtils.isEmpty(gnVar.a())) {
            return;
        }
        a(context, gnVar, strA);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00a3 A[Catch: all -> 0x00b3, TRY_LEAVE, TryCatch #7 {, blocks: (B:23:0x0067, B:25:0x006d, B:26:0x0070, B:27:0x0073, B:48:0x009c, B:54:0x00a3, B:56:0x00a9, B:57:0x00ac, B:58:0x00b2, B:44:0x008f, B:46:0x0095, B:47:0x0098), top: B:72:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(android.content.Context r6, com.xiaomi.push.gn r7, java.lang.String r8) {
        /*
            byte[] r7 = com.xiaomi.push.hp.a(r7)
            byte[] r7 = com.xiaomi.push.di.b(r8, r7)
            if (r7 == 0) goto Lb6
            int r8 = r7.length
            if (r8 != 0) goto Lf
            goto Lb6
        Lf:
            java.lang.Object r8 = com.xiaomi.push.dj.f12642a
            monitor-enter(r8)
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L87
            java.io.File r2 = r6.getFilesDir()     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L87
            java.lang.String r3 = "push_cdata.lock"
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L87
            com.xiaomi.push.w.m765a(r1)     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L87
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L87
            java.lang.String r3 = "rw"
            r2.<init>(r1, r3)     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L87
            java.nio.channels.FileChannel r1 = r2.getChannel()     // Catch: java.lang.Throwable -> L7d java.io.IOException -> L80
            java.nio.channels.FileLock r1 = r1.lock()     // Catch: java.lang.Throwable -> L7d java.io.IOException -> L80
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L79
            java.io.File r6 = r6.getFilesDir()     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L79
            java.lang.String r4 = "push_cdata.data"
            r3.<init>(r6, r4)     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L79
            boolean r6 = com.xiaomi.push.v.m764a(r3)     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L79
            if (r6 == 0) goto L64
            java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L79
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L79
            r5 = 1
            r4.<init>(r3, r5)     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L79
            r6.<init>(r4)     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L79
            int r0 = r7.length     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            byte[] r0 = com.xiaomi.push.y.a(r0)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            r6.write(r0)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            r6.write(r7)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            r6.flush()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            r4 = 0
            r3.setLastModified(r4)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            goto L65
        L60:
            r7 = move-exception
            goto La0
        L62:
            r7 = move-exception
            goto L7b
        L64:
            r6 = r0
        L65:
            if (r1 == 0) goto L70
            boolean r7 = r1.isValid()     // Catch: java.lang.Throwable -> Lb3
            if (r7 == 0) goto L70
            r1.release()     // Catch: java.io.IOException -> L70 java.lang.Throwable -> Lb3
        L70:
            com.xiaomi.push.w.a(r6)     // Catch: java.lang.Throwable -> Lb3
        L73:
            com.xiaomi.push.w.a(r2)     // Catch: java.lang.Throwable -> Lb3
            goto L9c
        L77:
            r7 = move-exception
            goto La1
        L79:
            r7 = move-exception
            r6 = r0
        L7b:
            r0 = r1
            goto L8a
        L7d:
            r7 = move-exception
            r1 = r0
            goto La1
        L80:
            r7 = move-exception
            r6 = r0
            goto L8a
        L83:
            r7 = move-exception
            r1 = r0
            r2 = r1
            goto La1
        L87:
            r7 = move-exception
            r6 = r0
            r2 = r6
        L8a:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L9e
            if (r0 == 0) goto L98
            boolean r7 = r0.isValid()     // Catch: java.lang.Throwable -> Lb3
            if (r7 == 0) goto L98
            r0.release()     // Catch: java.io.IOException -> L98 java.lang.Throwable -> Lb3
        L98:
            com.xiaomi.push.w.a(r6)     // Catch: java.lang.Throwable -> Lb3
            goto L73
        L9c:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> Lb3
            return
        L9e:
            r7 = move-exception
            r1 = r0
        La0:
            r0 = r6
        La1:
            if (r1 == 0) goto Lac
            boolean r6 = r1.isValid()     // Catch: java.lang.Throwable -> Lb3
            if (r6 == 0) goto Lac
            r1.release()     // Catch: java.io.IOException -> Lac java.lang.Throwable -> Lb3
        Lac:
            com.xiaomi.push.w.a(r0)     // Catch: java.lang.Throwable -> Lb3
            com.xiaomi.push.w.a(r2)     // Catch: java.lang.Throwable -> Lb3
            throw r7     // Catch: java.lang.Throwable -> Lb3
        Lb3:
            r6 = move-exception
            monitor-exit(r8)     // Catch: java.lang.Throwable -> Lb3
            throw r6
        Lb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dl.a(android.content.Context, com.xiaomi.push.gn, java.lang.String):void");
    }
}
