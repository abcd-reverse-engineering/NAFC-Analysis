package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import androidx.core.app.NotificationCompat;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class al implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public int f9235a;

    /* renamed from: b, reason: collision with root package name */
    public int f9236b;

    /* renamed from: c, reason: collision with root package name */
    protected int f9237c;

    /* renamed from: d, reason: collision with root package name */
    protected long f9238d;

    /* renamed from: e, reason: collision with root package name */
    protected long f9239e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f9240f;

    /* renamed from: g, reason: collision with root package name */
    private final Context f9241g;

    /* renamed from: h, reason: collision with root package name */
    private final int f9242h;

    /* renamed from: i, reason: collision with root package name */
    private final byte[] f9243i;

    /* renamed from: j, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.info.a f9244j;

    /* renamed from: k, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.strategy.a f9245k;

    /* renamed from: l, reason: collision with root package name */
    private final ai f9246l;

    /* renamed from: m, reason: collision with root package name */
    private final ak f9247m;
    private final int n;
    private final aj o;
    private final aj p;
    private String q;
    private final String r;
    private final Map<String, String> s;
    private boolean t;

    public al(Context context, int i2, int i3, byte[] bArr, String str, String str2, aj ajVar, boolean z, boolean z2) {
        this(context, i2, i3, bArr, str, str2, ajVar, z, 2, BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH, z2, null);
    }

    protected void a() {
        this.f9247m.a(this.n, System.currentTimeMillis());
        aj ajVar = this.o;
        if (ajVar != null) {
            ajVar.a(this.f9242h);
        }
        aj ajVar2 = this.p;
        if (ajVar2 != null) {
            ajVar2.a(this.f9242h);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        byte[] bArrA;
        Map<String, String> map;
        int i2;
        long j2;
        int length = 0;
        try {
            this.f9237c = 0;
            this.f9238d = 0L;
            this.f9239e = 0L;
            byte[] bArrA2 = this.f9243i;
            if (com.tencent.bugly.crashreport.common.info.b.f(this.f9241g) == null) {
                a(null, false, 0, "network is not available", 0);
                return;
            }
            if (bArrA2 != null && bArrA2.length != 0) {
                an.c("[Upload] Run upload task with cmd: %d", Integer.valueOf(this.f9242h));
                if (this.f9241g != null && this.f9244j != null && this.f9245k != null && this.f9246l != null) {
                    StrategyBean strategyBeanC = this.f9245k.c();
                    if (strategyBeanC == null) {
                        a(null, false, 0, "illegal local strategy", 0);
                        return;
                    }
                    HashMap map2 = new HashMap();
                    map2.put("prodId", this.f9244j.f());
                    map2.put("bundleId", this.f9244j.f8977d);
                    map2.put("appVer", this.f9244j.p);
                    if (this.s != null) {
                        map2.putAll(this.s);
                    }
                    if (this.f9240f) {
                        map2.put(com.taobao.agoo.a.a.b.JSON_CMD, Integer.toString(this.f9242h));
                        map2.put(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, Byte.toString((byte) 1));
                        map2.put("sdkVer", this.f9244j.f8983j);
                        map2.put("strategylastUpdateTime", Long.toString(strategyBeanC.p));
                        if (!this.f9247m.a(map2)) {
                            a(null, false, 0, "failed to add security info to HTTP headers", 0);
                            return;
                        }
                        byte[] bArrA3 = aq.a(bArrA2, 2);
                        if (bArrA3 == null) {
                            a(null, false, 0, "failed to zip request body", 0);
                            return;
                        }
                        bArrA2 = this.f9247m.a(bArrA3);
                        if (bArrA2 == null) {
                            a(null, false, 0, "failed to encrypt request body", 0);
                            return;
                        }
                    }
                    a();
                    String strA = this.q;
                    int i3 = 0;
                    int i4 = 0;
                    int i5 = -1;
                    while (true) {
                        int i6 = i3 + 1;
                        if (i3 >= this.f9235a) {
                            a(null, false, i4, "failed after many attempts", 0);
                            return;
                        }
                        if (i6 > 1) {
                            an.d("[Upload] Failed to upload last time, wait and try(%d) again.", Integer.valueOf(i6));
                            aq.b(this.f9236b);
                            if (i6 == this.f9235a) {
                                an.d("[Upload] Use the back-up url at the last time: %s", this.r);
                                strA = this.r;
                            }
                        }
                        an.c("[Upload] Send %d bytes", Integer.valueOf(bArrA2.length));
                        if (this.f9240f) {
                            strA = a(strA);
                        }
                        an.c("[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).", strA, Integer.valueOf(this.f9242h), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                        bArrA = this.f9246l.a(strA, bArrA2, this, map2);
                        if (bArrA != null) {
                            map = this.f9246l.f9212b;
                            if (!this.f9240f) {
                                i2 = i5;
                                break;
                            }
                            if (a(map)) {
                                try {
                                    i2 = Integer.parseInt(map.get(NotificationCompat.CATEGORY_STATUS));
                                } catch (Throwable unused) {
                                    j2 = 0;
                                }
                                try {
                                    an.c("[Upload] Status from server is %d (pid=%d | tid=%d).", Integer.valueOf(i2), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                    if (i2 != 0) {
                                        if (i2 != 2) {
                                            a(null, false, 1, "status of server is " + i2, i2);
                                            return;
                                        }
                                        if (this.f9238d + this.f9239e > 0) {
                                            this.f9247m.a(this.f9247m.a(this.t) + this.f9238d + this.f9239e, this.t);
                                        }
                                        this.f9247m.a(i2, (bi) null);
                                        an.a("[Upload] Session ID is invalid, will try again immediately (pid=%d | tid=%d).", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                        this.f9247m.a(this.n, this.f9242h, this.f9243i, this.q, this.r, this.o, this.f9235a, this.f9236b, true, this.s);
                                        return;
                                    }
                                } catch (Throwable unused2) {
                                    j2 = 0;
                                    i5 = i2;
                                    a(1, "[Upload] Failed to upload for format of status header is invalid: " + Integer.toString(i5));
                                    i3 = i6;
                                    i4 = 1;
                                }
                            } else {
                                an.c("[Upload] Headers from server is not valid, just try again (pid=%d | tid=%d).", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                                a(1, "[Upload] Failed to upload for no status header.");
                                if (map != null) {
                                    for (Map.Entry<String, String> entry : map.entrySet()) {
                                        an.c(String.format("[key]: %s, [value]: %s", entry.getKey(), entry.getValue()), new Object[0]);
                                    }
                                }
                                an.c("[Upload] Failed to upload for no status header.", new Object[0]);
                            }
                        } else {
                            a(1, "Failed to upload for no response!");
                        }
                        i3 = i6;
                        i4 = 1;
                    }
                    an.c("[Upload] Received %d bytes", Integer.valueOf(bArrA.length));
                    if (this.f9240f) {
                        if (bArrA.length == 0) {
                            for (Map.Entry<String, String> entry2 : map.entrySet()) {
                                an.c("[Upload] HTTP headers from server: key = %s, value = %s", entry2.getKey(), entry2.getValue());
                            }
                            a(null, false, 1, "response data from server is empty", 0);
                            return;
                        }
                        byte[] bArrB = this.f9247m.b(bArrA);
                        if (bArrB == null) {
                            a(null, false, 1, "failed to decrypt response from server", 0);
                            return;
                        }
                        bArrA = aq.b(bArrB, 2);
                        if (bArrA == null) {
                            a(null, false, 1, "failed unzip(Gzip) response from server", 0);
                            return;
                        }
                    }
                    bi biVarA = ah.a(bArrA, strategyBeanC, this.f9240f);
                    if (biVarA == null) {
                        a(null, false, 1, "failed to decode response package", 0);
                        return;
                    }
                    if (this.f9240f) {
                        this.f9247m.a(i2, biVarA);
                    }
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(biVarA.f9338b);
                    if (biVarA.f9339c != null) {
                        length = biVarA.f9339c.length;
                    }
                    objArr[1] = Integer.valueOf(length);
                    an.c("[Upload] Response cmd is: %d, length of sBuffer is: %d", objArr);
                    if (a(biVarA, this.f9244j, this.f9245k)) {
                        a(biVarA, true, 2, "successfully uploaded", 0);
                        return;
                    } else {
                        a(biVarA, false, 2, "failed to process response package", 0);
                        return;
                    }
                }
                a(null, false, 0, "illegal access error", 0);
                return;
            }
            a(null, false, 0, "request package is empty!", 0);
        } catch (Throwable th) {
            if (an.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public al(Context context, int i2, int i3, byte[] bArr, String str, String str2, aj ajVar, boolean z, int i4, int i5, boolean z2, Map<String, String> map) {
        this.f9235a = 2;
        this.f9236b = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
        this.q = null;
        this.f9237c = 0;
        this.f9238d = 0L;
        this.f9239e = 0L;
        this.f9240f = true;
        this.t = false;
        this.f9241g = context;
        this.f9244j = com.tencent.bugly.crashreport.common.info.a.a(context);
        this.f9243i = bArr;
        this.f9245k = com.tencent.bugly.crashreport.common.strategy.a.a();
        this.f9246l = ai.a(context);
        this.f9247m = ak.a();
        this.n = i2;
        this.q = str;
        this.r = str2;
        this.o = ajVar;
        this.p = this.f9247m.f9214a;
        this.f9240f = z;
        this.f9242h = i3;
        if (i4 > 0) {
            this.f9235a = i4;
        }
        if (i5 > 0) {
            this.f9236b = i5;
        }
        this.t = z2;
        this.s = map;
    }

    protected void a(int i2, String str) {
        an.e("[Upload] Failed to upload(%d): %s", Integer.valueOf(i2), str);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void a(com.tencent.bugly.proguard.bi r14, boolean r15, int r16, java.lang.String r17, int r18) {
        /*
            r13 = this;
            r0 = r13
            int r1 = r0.f9242h
            r2 = 630(0x276, float:8.83E-43)
            if (r1 == r2) goto L1b
            r2 = 640(0x280, float:8.97E-43)
            if (r1 == r2) goto L18
            r2 = 830(0x33e, float:1.163E-42)
            if (r1 == r2) goto L1b
            r2 = 840(0x348, float:1.177E-42)
            if (r1 == r2) goto L18
            java.lang.String r1 = java.lang.String.valueOf(r1)
            goto L1d
        L18:
            java.lang.String r1 = "userinfo"
            goto L1d
        L1b:
            java.lang.String r1 = "crash"
        L1d:
            r2 = 1
            r3 = 0
            if (r15 == 0) goto L2b
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r1
            java.lang.String r1 = "[Upload] Success: %s"
            com.tencent.bugly.proguard.an.a(r1, r2)
            goto L4a
        L2b:
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r16)
            r4[r3] = r5
            r4[r2] = r1
            r1 = 2
            r4[r1] = r17
            java.lang.String r1 = "[Upload] Failed to upload(%d) %s: %s"
            com.tencent.bugly.proguard.an.e(r1, r4)
            boolean r1 = r0.f9240f
            if (r1 == 0) goto L4a
            com.tencent.bugly.proguard.ak r1 = r0.f9247m
            r2 = 0
            r3 = r18
            r1.a(r3, r2)
        L4a:
            long r1 = r0.f9238d
            long r3 = r0.f9239e
            long r1 = r1 + r3
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L6a
            com.tencent.bugly.proguard.ak r1 = r0.f9247m
            boolean r2 = r0.t
            long r1 = r1.a(r2)
            long r3 = r0.f9238d
            long r1 = r1 + r3
            long r3 = r0.f9239e
            long r1 = r1 + r3
            com.tencent.bugly.proguard.ak r3 = r0.f9247m
            boolean r4 = r0.t
            r3.a(r1, r4)
        L6a:
            com.tencent.bugly.proguard.aj r4 = r0.o
            if (r4 == 0) goto L7b
            int r5 = r0.f9242h
            long r7 = r0.f9238d
            long r9 = r0.f9239e
            r6 = r14
            r11 = r15
            r12 = r17
            r4.a(r5, r6, r7, r9, r11, r12)
        L7b:
            com.tencent.bugly.proguard.aj r4 = r0.p
            if (r4 == 0) goto L8c
            int r5 = r0.f9242h
            long r7 = r0.f9238d
            long r9 = r0.f9239e
            r6 = r14
            r11 = r15
            r12 = r17
            r4.a(r5, r6, r7, r9, r11, r12)
        L8c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.al.a(com.tencent.bugly.proguard.bi, boolean, int, java.lang.String, int):void");
    }

    protected boolean a(bi biVar, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.common.strategy.a aVar2) throws NumberFormatException {
        if (biVar == null) {
            an.d("resp == null!", new Object[0]);
            return false;
        }
        byte b2 = biVar.f9337a;
        if (b2 != 0) {
            an.e("resp result error %d", Byte.valueOf(b2));
            return false;
        }
        try {
            if (!aq.a(biVar.f9340d) && !com.tencent.bugly.crashreport.common.info.a.b().i().equals(biVar.f9340d)) {
                ae.a().a(com.tencent.bugly.crashreport.common.strategy.a.f9005a, "gateway", biVar.f9340d.getBytes("UTF-8"), (ad) null, true);
                aVar.d(biVar.f9340d);
            }
            if (!aq.a(biVar.f9343g) && !com.tencent.bugly.crashreport.common.info.a.b().j().equals(biVar.f9343g)) {
                ae.a().a(com.tencent.bugly.crashreport.common.strategy.a.f9005a, "device", biVar.f9343g.getBytes("UTF-8"), (ad) null, true);
                aVar.e(biVar.f9343g);
            }
        } catch (Throwable th) {
            an.a(th);
        }
        aVar.o = biVar.f9341e;
        int i2 = biVar.f9338b;
        if (i2 == 510) {
            byte[] bArr = biVar.f9339c;
            if (bArr == null) {
                an.e("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(i2));
                return false;
            }
            bk bkVar = (bk) ah.a(bArr, bk.class);
            if (bkVar == null) {
                an.e("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(biVar.f9338b));
                return false;
            }
            aVar2.a(bkVar);
        }
        return true;
    }

    public void a(String str, long j2, String str2) {
        this.f9237c++;
        this.f9238d += j2;
    }

    public void a(long j2) {
        this.f9239e += j2;
    }

    private static String a(String str) {
        if (aq.a(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th) {
            an.a(th);
            return str;
        }
    }

    private static boolean a(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            if (!map.containsKey(NotificationCompat.CATEGORY_STATUS)) {
                an.d("[Upload] Headers does not contain %s", NotificationCompat.CATEGORY_STATUS);
                return false;
            }
            if (!map.containsKey("Bugly-Version")) {
                an.d("[Upload] Headers does not contain %s", "Bugly-Version");
                return false;
            }
            String str = map.get("Bugly-Version");
            if (!str.contains("bugly")) {
                an.d("[Upload] Bugly version is not valid: %s", str);
                return false;
            }
            an.c("[Upload] Bugly version from headers is: %s", str);
            return true;
        }
        an.d("[Upload] Headers is empty.", new Object[0]);
        return false;
    }
}
