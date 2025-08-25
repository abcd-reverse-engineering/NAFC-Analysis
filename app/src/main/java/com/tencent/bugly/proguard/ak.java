package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.util.Base64;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import javax.crypto.NoSuchPaddingException;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class ak {

    /* renamed from: c, reason: collision with root package name */
    private static ak f9213c;

    /* renamed from: a, reason: collision with root package name */
    public aj f9214a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9215b;

    /* renamed from: e, reason: collision with root package name */
    private final Context f9217e;

    /* renamed from: g, reason: collision with root package name */
    private long f9219g;

    /* renamed from: h, reason: collision with root package name */
    private long f9220h;

    /* renamed from: l, reason: collision with root package name */
    private String f9224l;

    /* renamed from: f, reason: collision with root package name */
    private Map<Integer, Long> f9218f = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    private LinkedBlockingQueue<Runnable> f9221i = new LinkedBlockingQueue<>();

    /* renamed from: j, reason: collision with root package name */
    private LinkedBlockingQueue<Runnable> f9222j = new LinkedBlockingQueue<>();

    /* renamed from: k, reason: collision with root package name */
    private final Object f9223k = new Object();

    /* renamed from: m, reason: collision with root package name */
    private byte[] f9225m = null;
    private long n = 0;
    private byte[] o = null;
    private long p = 0;
    private String q = null;
    private long r = 0;
    private final Object s = new Object();
    private boolean t = false;
    private final Object u = new Object();
    private int v = 0;

    /* renamed from: d, reason: collision with root package name */
    private final ae f9216d = ae.a();

    protected ak(Context context) throws ClassNotFoundException {
        this.f9224l = null;
        this.f9215b = true;
        this.f9217e = context;
        try {
            Class.forName("android.util.Base64");
        } catch (ClassNotFoundException unused) {
            an.a("[UploadManager] Error: Can not find Base64 class, will not use stronger security way to upload", new Object[0]);
            this.f9215b = false;
        }
        if (this.f9215b) {
            this.f9224l = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDP9x32s5pPtZBXzJBz2GWM/sbTvVO2+RvW0PH01IdaBxc/fB6fbHZocC9T3nl1+J5eAFjIRVuV8vHDky7Qo82Mnh0PVvcZIEQvMMVKU8dsMQopxgsOs2gkSHJwgWdinKNS8CmWobo6pFwPUW11lMv714jAUZRq2GBOqiO2vQI6iwIDAQAB";
        }
    }

    static /* synthetic */ int b(ak akVar) {
        int i2 = akVar.v - 1;
        akVar.v = i2;
        return i2;
    }

    private boolean c() {
        an.c("[UploadManager] Drop security info of database (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            ae aeVarA = ae.a();
            if (aeVarA != null) {
                return aeVarA.a(555, "security_info", (ad) null, true);
            }
            an.d("[UploadManager] Failed to get Database", new Object[0]);
            return false;
        } catch (Throwable th) {
            an.a(th);
            return false;
        }
    }

    private boolean d() {
        an.c("[UploadManager] Record security info to database (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            ae aeVarA = ae.a();
            if (aeVarA == null) {
                an.d("[UploadManager] Failed to get database", new Object[0]);
                return false;
            }
            StringBuilder sb = new StringBuilder();
            if (this.o == null) {
                an.c("[UploadManager] AES key is null, will not record", new Object[0]);
                return false;
            }
            sb.append(Base64.encodeToString(this.o, 0));
            sb.append("#");
            if (this.p != 0) {
                sb.append(Long.toString(this.p));
            } else {
                sb.append(c.c.a.b.a.a.f3101h);
            }
            sb.append("#");
            if (this.q != null) {
                sb.append(this.q);
            } else {
                sb.append(c.c.a.b.a.a.f3101h);
            }
            sb.append("#");
            if (this.r != 0) {
                sb.append(Long.toString(this.r));
            } else {
                sb.append(c.c.a.b.a.a.f3101h);
            }
            aeVarA.a(555, "security_info", sb.toString().getBytes(), (ad) null, true);
            return true;
        } catch (Throwable th) {
            an.a(th);
            c();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00de A[Catch: all -> 0x00e2, TRY_LEAVE, TryCatch #0 {all -> 0x00e2, blocks: (B:3:0x0020, B:5:0x0026, B:7:0x002e, B:9:0x0037, B:11:0x003d, B:13:0x0052, B:16:0x005c, B:21:0x006e, B:24:0x0076, B:26:0x007e, B:31:0x0090, B:33:0x0096, B:35:0x009e, B:37:0x00a6, B:39:0x00ac, B:41:0x00b5, B:46:0x00c7, B:50:0x00de, B:47:0x00cb, B:43:0x00bd, B:18:0x0064, B:28:0x0086), top: B:55:0x0020, inners: #1, #2, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean e() {
        /*
            Method dump skipped, instructions count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ak.e():boolean");
    }

    public boolean b(int i2) {
        if (com.tencent.bugly.b.f8759c) {
            an.c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - a(i2);
        an.c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf(jCurrentTimeMillis / 1000), Integer.valueOf(i2));
        if (jCurrentTimeMillis >= 30000) {
            return true;
        }
        an.a("[UploadManager] Data only be uploaded once in %d seconds.", 30L);
        return false;
    }

    /* compiled from: BUGLY */
    class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private final Context f9232b;

        /* renamed from: c, reason: collision with root package name */
        private final Runnable f9233c;

        /* renamed from: d, reason: collision with root package name */
        private final long f9234d;

        public a(Context context) {
            this.f9232b = context;
            this.f9233c = null;
            this.f9234d = 0L;
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            if (!aq.a(this.f9232b, "security_info", 30000L)) {
                an.c("[UploadManager] Sleep %d try to lock security file again (pid=%d | tid=%d)", 5000, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                aq.b(com.heytap.mcssdk.constant.a.r);
                if (aq.a(this, "BUGLY_ASYNC_UPLOAD") == null) {
                    an.d("[UploadManager] Failed to start a thread to execute task of initializing security context, try to post it into thread pool.", new Object[0]);
                    am amVarA = am.a();
                    if (amVarA != null) {
                        amVarA.a(this);
                        return;
                    } else {
                        an.e("[UploadManager] Asynchronous thread pool is unavailable now, try next time.", new Object[0]);
                        return;
                    }
                }
                return;
            }
            if (!ak.this.e()) {
                an.d("[UploadManager] Failed to load security info from database", new Object[0]);
                ak.this.b(false);
            }
            if (ak.this.q != null) {
                if (ak.this.b()) {
                    an.c("[UploadManager] Sucessfully got session ID, try to execute upload tasks now (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    Runnable runnable = this.f9233c;
                    if (runnable != null) {
                        ak.this.a(runnable, this.f9234d);
                    }
                    ak.this.c(0);
                    aq.c(this.f9232b, "security_info");
                    synchronized (ak.this.u) {
                        ak.this.t = false;
                    }
                    return;
                }
                an.a("[UploadManager] Session ID is expired, drop it.", new Object[0]);
                ak.this.b(true);
            }
            byte[] bArrA = aq.a(128);
            if (bArrA == null || bArrA.length * 8 != 128) {
                an.d("[UploadManager] Failed to create AES key (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                ak.this.b(false);
                aq.c(this.f9232b, "security_info");
                synchronized (ak.this.u) {
                    ak.this.t = false;
                }
                return;
            }
            ak.this.o = bArrA;
            an.c("[UploadManager] Execute one upload task for requesting session ID (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            Runnable runnable2 = this.f9233c;
            if (runnable2 != null) {
                ak.this.a(runnable2, this.f9234d);
            } else {
                ak.this.c(1);
            }
        }

        public a(Context context, Runnable runnable, long j2) {
            this.f9232b = context;
            this.f9233c = runnable;
            this.f9234d = j2;
        }
    }

    public static synchronized ak a(Context context) {
        if (f9213c == null) {
            f9213c = new ak(context);
        }
        return f9213c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006d A[Catch: all -> 0x015d, TRY_LEAVE, TryCatch #4 {, blocks: (B:8:0x001c, B:11:0x0049, B:12:0x0050, B:23:0x0063, B:28:0x006d, B:35:0x008f, B:34:0x0082, B:38:0x0095, B:45:0x00b7, B:44:0x00aa, B:46:0x00ba, B:18:0x005a, B:20:0x005e, B:31:0x0078, B:41:0x00a0), top: B:95:0x001c, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0095 A[Catch: all -> 0x015d, TRY_LEAVE, TryCatch #4 {, blocks: (B:8:0x001c, B:11:0x0049, B:12:0x0050, B:23:0x0063, B:28:0x006d, B:35:0x008f, B:34:0x0082, B:38:0x0095, B:45:0x00b7, B:44:0x00aa, B:46:0x00ba, B:18:0x005a, B:20:0x005e, B:31:0x0078, B:41:0x00a0), top: B:95:0x001c, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(int r13) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ak.c(int):void");
    }

    public static synchronized ak a() {
        return f9213c;
    }

    public void a(int i2, int i3, byte[] bArr, String str, String str2, aj ajVar, long j2, boolean z) {
        try {
            b(new al(this.f9217e, i2, i3, bArr, str, str2, ajVar, this.f9215b, z), true, true, j2);
        } catch (Throwable th) {
            if (an.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    protected boolean b() {
        if (this.q == null || this.r == 0) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() + this.n;
        long j2 = this.r;
        if (j2 >= jCurrentTimeMillis) {
            return true;
        }
        an.c("[UploadManager] Session ID expired time from server is: %d(%s), but now is: %d(%s)", Long.valueOf(j2), new Date(this.r).toString(), Long.valueOf(jCurrentTimeMillis), new Date(jCurrentTimeMillis).toString());
        return false;
    }

    public void a(int i2, bh bhVar, String str, String str2, aj ajVar, long j2, boolean z) {
        a(i2, bhVar.f9328g, ah.a((Object) bhVar), str, str2, ajVar, j2, z);
    }

    public void a(int i2, int i3, byte[] bArr, String str, String str2, aj ajVar, int i4, int i5, boolean z, Map<String, String> map) {
        try {
            b(new al(this.f9217e, i2, i3, bArr, str, str2, ajVar, this.f9215b, i4, i5, false, map), z, false, 0L);
        } catch (Throwable th) {
            if (an.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public void b(boolean z) {
        synchronized (this.s) {
            an.c("[UploadManager] Clear security context (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            this.o = null;
            this.q = null;
            this.r = 0L;
        }
        if (z) {
            c();
        }
    }

    public void a(int i2, int i3, byte[] bArr, String str, String str2, aj ajVar, boolean z, Map<String, String> map) {
        a(i2, i3, bArr, str, str2, ajVar, 0, 0, z, map);
    }

    public void a(int i2, bh bhVar, String str, String str2, aj ajVar, boolean z) {
        a(i2, bhVar.f9328g, ah.a((Object) bhVar), str, str2, ajVar, 0, 0, z, null);
    }

    public long a(boolean z) {
        long jC;
        long jB = aq.b();
        int i2 = z ? 5 : 3;
        List<ag> listA = this.f9216d.a(i2);
        if (listA != null && listA.size() > 0) {
            jC = 0;
            try {
                ag agVar = listA.get(0);
                if (agVar.f9207e >= jB) {
                    jC = aq.c(agVar.f9209g);
                    if (i2 == 3) {
                        this.f9219g = jC;
                    } else {
                        this.f9220h = jC;
                    }
                    listA.remove(agVar);
                }
            } catch (Throwable th) {
                an.a(th);
            }
            if (listA.size() > 0) {
                this.f9216d.a(listA);
            }
        } else {
            jC = z ? this.f9220h : this.f9219g;
        }
        an.c("[UploadManager] Local network consume: %d KB", Long.valueOf(jC / 1024));
        return jC;
    }

    private void b(Runnable runnable, boolean z, boolean z2, long j2) {
        if (runnable == null) {
            an.d("[UploadManager] Upload task should not be null", new Object[0]);
        }
        an.c("[UploadManager] Add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (this.q != null) {
            if (b()) {
                an.c("[UploadManager] Sucessfully got session ID, try to execute upload task now (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                if (z2) {
                    a(runnable, j2);
                    return;
                } else {
                    a(runnable, z);
                    c(0);
                    return;
                }
            }
            an.a("[UploadManager] Session ID is expired, drop it (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            b(false);
        }
        synchronized (this.u) {
            if (this.t) {
                a(runnable, z);
            } else {
                this.t = true;
                a(runnable, z, z2, j2);
            }
        }
    }

    protected synchronized void a(long j2, boolean z) {
        int i2 = z ? 5 : 3;
        ag agVar = new ag();
        agVar.f9204b = i2;
        agVar.f9207e = aq.b();
        agVar.f9205c = "";
        agVar.f9206d = "";
        agVar.f9209g = aq.c(j2);
        this.f9216d.b(i2);
        this.f9216d.a(agVar);
        if (z) {
            this.f9220h = j2;
        } else {
            this.f9219g = j2;
        }
        an.c("[UploadManager] Network total consume: %d KB", Long.valueOf(j2 / 1024));
    }

    public synchronized void a(int i2, long j2) {
        if (i2 >= 0) {
            this.f9218f.put(Integer.valueOf(i2), Long.valueOf(j2));
            ag agVar = new ag();
            agVar.f9204b = i2;
            agVar.f9207e = j2;
            agVar.f9205c = "";
            agVar.f9206d = "";
            agVar.f9209g = new byte[0];
            this.f9216d.b(i2);
            this.f9216d.a(agVar);
            an.c("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i2), aq.a(j2));
        } else {
            an.e("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i2));
        }
    }

    public byte[] b(byte[] bArr) {
        byte[] bArr2 = this.o;
        if (bArr2 != null && bArr2.length * 8 == 128) {
            return aq.a(2, bArr, bArr2);
        }
        an.d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        return null;
    }

    public synchronized long a(int i2) {
        long j2 = 0;
        if (i2 >= 0) {
            Long l2 = this.f9218f.get(Integer.valueOf(i2));
            if (l2 != null) {
                return l2.longValue();
            }
            List<ag> listA = this.f9216d.a(i2);
            if (listA != null && listA.size() > 0) {
                if (listA.size() > 1) {
                    for (ag agVar : listA) {
                        if (agVar.f9207e > j2) {
                            j2 = agVar.f9207e;
                        }
                    }
                    this.f9216d.b(i2);
                } else {
                    try {
                        j2 = listA.get(0).f9207e;
                    } catch (Throwable th) {
                        an.a(th);
                    }
                }
            }
        } else {
            an.e("[UploadManager] Unknown upload ID: %d", Integer.valueOf(i2));
        }
        return j2;
    }

    private boolean a(Runnable runnable, boolean z) {
        if (runnable == null) {
            an.a("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            an.c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.f9223k) {
                if (z) {
                    this.f9221i.put(runnable);
                } else {
                    this.f9222j.put(runnable);
                }
            }
            return true;
        } catch (Throwable th) {
            an.e("[UploadManager] Failed to add upload task to queue: %s", th.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Runnable runnable, long j2) {
        if (runnable == null) {
            an.d("[UploadManager] Upload task should not be null", new Object[0]);
            return;
        }
        an.c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        Thread threadA = aq.a(runnable, "BUGLY_SYNC_UPLOAD");
        if (threadA == null) {
            an.e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
            a(runnable, true);
            return;
        }
        try {
            threadA.join(j2);
        } catch (Throwable th) {
            an.e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th.getMessage());
            a(runnable, true);
            c(0);
        }
    }

    private void a(Runnable runnable, boolean z, boolean z2, long j2) {
        an.c("[UploadManager] Initialize security context now (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (z2) {
            a(new a(this.f9217e, runnable, j2), 0L);
            return;
        }
        a(runnable, z);
        a aVar = new a(this.f9217e);
        an.a("[UploadManager] Create and start a new thread to execute a task of initializing security context: %s", "BUGLY_ASYNC_UPLOAD");
        if (aq.a(aVar, "BUGLY_ASYNC_UPLOAD") == null) {
            an.d("[UploadManager] Failed to start a thread to execute task of initializing security context, try to post it into thread pool.", new Object[0]);
            am amVarA = am.a();
            if (amVarA != null) {
                amVarA.a(aVar);
                return;
            }
            an.e("[UploadManager] Asynchronous thread pool is unavailable now, try next time.", new Object[0]);
            synchronized (this.u) {
                this.t = false;
            }
        }
    }

    public void a(int i2, bi biVar) {
        if (this.f9215b) {
            boolean z = true;
            if (i2 == 2) {
                an.c("[UploadManager] Session ID is invalid, will clear security context (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                b(true);
            } else {
                synchronized (this.u) {
                    if (!this.t) {
                        return;
                    }
                    if (biVar != null) {
                        an.c("[UploadManager] Record security context (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                        try {
                            Map<String, String> map = biVar.f9344h;
                            if (map != null && map.containsKey("S1") && map.containsKey("S2")) {
                                this.n = biVar.f9341e - System.currentTimeMillis();
                                an.c("[UploadManager] Time lag of server is: %d", Long.valueOf(this.n));
                                this.q = map.get("S1");
                                an.c("[UploadManager] Session ID from server is: %s", this.q);
                                if (this.q.length() > 0) {
                                    try {
                                        this.r = Long.parseLong(map.get("S2"));
                                        an.c("[UploadManager] Session expired time from server is: %d(%s)", Long.valueOf(this.r), new Date(this.r).toString());
                                        if (this.r < 1000) {
                                            an.d("[UploadManager] Session expired time from server is less than 1 second, will set to default value", new Object[0]);
                                            this.r = 259200000L;
                                        }
                                    } catch (NumberFormatException unused) {
                                        an.d("[UploadManager] Session expired time is invalid, will set to default value", new Object[0]);
                                        this.r = 259200000L;
                                    }
                                    if (d()) {
                                        z = false;
                                    } else {
                                        an.c("[UploadManager] Failed to record database", new Object[0]);
                                    }
                                    c(0);
                                } else {
                                    an.c("[UploadManager] Session ID from server is invalid, try next time", new Object[0]);
                                }
                            }
                        } catch (Throwable th) {
                            an.a(th);
                        }
                        if (z) {
                            b(false);
                        }
                    } else {
                        an.c("[UploadManager] Fail to init security context and clear local info (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                        b(false);
                    }
                }
            }
            synchronized (this.u) {
                if (this.t) {
                    this.t = false;
                    aq.c(this.f9217e, "security_info");
                }
            }
        }
    }

    public byte[] a(byte[] bArr) {
        byte[] bArr2 = this.o;
        if (bArr2 != null && bArr2.length * 8 == 128) {
            return aq.a(1, bArr, bArr2);
        }
        an.d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        return null;
    }

    public boolean a(Map<String, String> map) throws InvalidKeySpecException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        if (map == null) {
            return false;
        }
        an.c("[UploadManager] Integrate security to HTTP headers (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        String str = this.q;
        if (str != null) {
            map.put("secureSessionId", str);
            return true;
        }
        byte[] bArr = this.o;
        if (bArr != null && bArr.length * 8 == 128) {
            if (this.f9225m == null) {
                this.f9225m = Base64.decode(this.f9224l, 0);
                if (this.f9225m == null) {
                    an.d("[UploadManager] Failed to decode RSA public key", new Object[0]);
                    return false;
                }
            }
            byte[] bArrB = aq.b(1, this.o, this.f9225m);
            if (bArrB == null) {
                an.d("[UploadManager] Failed to encrypt AES key", new Object[0]);
                return false;
            }
            String strEncodeToString = Base64.encodeToString(bArrB, 0);
            if (strEncodeToString == null) {
                an.d("[UploadManager] Failed to encode AES key", new Object[0]);
                return false;
            }
            map.put("raKey", strEncodeToString);
            return true;
        }
        an.d("[UploadManager] AES key is invalid", new Object[0]);
        return false;
    }
}
