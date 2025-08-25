package com.tencent.bugly.beta.utils;

import h.q2.t.n;
import java.io.IOException;
import java.util.HashMap;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private String f8884a;

    /* renamed from: c, reason: collision with root package name */
    private long f8886c;

    /* renamed from: d, reason: collision with root package name */
    private long f8887d;

    /* renamed from: b, reason: collision with root package name */
    private a f8885b = null;

    /* renamed from: e, reason: collision with root package name */
    private String f8888e = null;

    /* renamed from: f, reason: collision with root package name */
    private final HashMap<Long, String> f8889f = new HashMap<>();

    public b(String str, long j2, long j3) {
        this.f8884a = null;
        this.f8886c = 0L;
        this.f8887d = 0L;
        this.f8889f.put(1L, "armeabi-v4");
        this.f8889f.put(2L, "armeabi-v4t");
        this.f8889f.put(3L, "armeabi-v5t");
        this.f8889f.put(4L, "armeabi-v5te");
        this.f8889f.put(5L, "armeabi-v5tej");
        this.f8889f.put(6L, "armeabi-v6");
        this.f8889f.put(7L, "armeabi-v6kz");
        this.f8889f.put(8L, "armeabi-v6t2");
        this.f8889f.put(9L, "armeabi-v6k");
        this.f8889f.put(10L, "armeabi-v7a");
        this.f8889f.put(11L, "armeabi-v6-m");
        this.f8889f.put(12L, "armeabi-v6s-m");
        this.f8889f.put(13L, "armeabi-v7e-m");
        this.f8889f.put(14L, "armeabi-v8a");
        this.f8884a = str;
        this.f8886c = j2;
        this.f8887d = j3;
    }

    private boolean a() {
        return 0 != this.f8887d;
    }

    private synchronized void b() {
        if (this.f8885b == null) {
            return;
        }
        if (this.f8885b.a()) {
            this.f8885b = null;
        }
    }

    private synchronized boolean c() {
        if (!a()) {
            return false;
        }
        if (this.f8885b != null) {
            b();
        }
        try {
            this.f8885b = new a(this.f8884a, this.f8886c);
            return this.f8885b.b(this.f8887d);
        } catch (Exception e2) {
            e2.getMessage();
            return false;
        }
    }

    private synchronized String d() {
        StringBuilder sb;
        sb = new StringBuilder();
        while (true) {
            try {
                char cB = (char) this.f8885b.b();
                if (cB != 0) {
                    sb.append(cB);
                }
            } catch (IOException e2) {
                e2.getMessage();
                return null;
            }
        }
        return sb.toString();
    }

    private String e() {
        return d();
    }

    private synchronized boolean f() {
        try {
            if (65 != this.f8885b.f()) {
                return false;
            }
            long jH = this.f8885b.h();
            String strE = e();
            if (strE != null && strE.equals("aeabi")) {
                long length = jH - strE.length();
                while (length > 0) {
                    long jF = this.f8885b.f();
                    long jH2 = this.f8885b.h() - 5;
                    if (1 == jF) {
                        return a(jH2);
                    }
                    this.f8885b.b(jH2);
                }
                return true;
            }
            return false;
        } catch (IOException e2) {
            e2.getMessage();
            return false;
        }
    }

    private boolean g() {
        if (!c()) {
            b();
            return false;
        }
        f();
        b();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x004c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0001 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized boolean a(long r5) {
        /*
            r4 = this;
            monitor-enter(r4)
        L1:
            r0 = 0
            r2 = 0
            int r3 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r3 <= 0) goto L63
            com.tencent.bugly.beta.utils.a r0 = r4.f8885b     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            long r0 = a(r0)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            int r1 = (int) r0
            r0 = 34
            if (r1 == r0) goto L53
            r0 = 36
            if (r1 == r0) goto L53
            r0 = 38
            if (r1 == r0) goto L53
            r0 = 42
            if (r1 == r0) goto L53
            r0 = 44
            if (r1 == r0) goto L53
            r0 = 70
            if (r1 == r0) goto L53
            switch(r1) {
                case 4: goto L46;
                case 5: goto L46;
                case 6: goto L2f;
                case 7: goto L53;
                case 8: goto L53;
                case 9: goto L53;
                case 10: goto L53;
                case 11: goto L53;
                case 12: goto L53;
                case 13: goto L53;
                case 14: goto L53;
                case 15: goto L53;
                case 16: goto L53;
                case 17: goto L53;
                case 18: goto L53;
                case 19: goto L53;
                case 20: goto L53;
                case 21: goto L53;
                case 22: goto L53;
                case 23: goto L53;
                case 24: goto L53;
                case 25: goto L53;
                case 26: goto L53;
                case 27: goto L53;
                case 28: goto L53;
                case 29: goto L53;
                case 30: goto L53;
                case 31: goto L53;
                case 32: goto L46;
                default: goto L2a;
            }
        L2a:
            switch(r1) {
                case 64: goto L53;
                case 65: goto L46;
                case 66: goto L53;
                case 67: goto L46;
                case 68: goto L53;
                default: goto L2d;
            }
        L2d:
            monitor-exit(r4)
            return r2
        L2f:
            com.tencent.bugly.beta.utils.a r5 = r4.f8885b     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            long r5 = a(r5)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            java.util.HashMap<java.lang.Long, java.lang.String> r0 = r4.f8889f     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            java.lang.Object r5 = r0.get(r5)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            r4.f8888e = r5     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            r5 = 1
            monitor-exit(r4)
            return r5
        L46:
            java.lang.String r0 = r4.d()     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            if (r0 == 0) goto L1
            int r0 = r0.length()     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            long r0 = (long) r0     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            long r5 = r5 - r0
            goto L1
        L53:
            com.tencent.bugly.beta.utils.a r0 = r4.f8885b     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            a(r0)     // Catch: java.lang.Throwable -> L59 java.io.IOException -> L5b
            goto L1
        L59:
            r5 = move-exception
            goto L61
        L5b:
            r5 = move-exception
            r5.getMessage()     // Catch: java.lang.Throwable -> L59
            monitor-exit(r4)
            return r2
        L61:
            monitor-exit(r4)
            throw r5
        L63:
            monitor-exit(r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.utils.b.a(long):boolean");
    }

    public static String a(String str, long j2, long j3) {
        b bVar = new b(str, j2, j3);
        if (bVar.g()) {
            return bVar.f8888e;
        }
        return null;
    }

    public static synchronized long a(a aVar) throws IOException {
        long j2;
        byte b2;
        j2 = 0;
        long j3 = 0;
        do {
            b2 = aVar.b();
            j2 |= (b2 & 127) << ((int) j3);
            j3 += 7;
        } while ((b2 & n.f16413a) != 0);
        return j2;
    }
}
