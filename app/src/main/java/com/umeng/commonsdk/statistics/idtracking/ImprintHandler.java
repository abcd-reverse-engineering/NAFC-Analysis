package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.bz;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public class ImprintHandler implements FileLockCallback {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10905a = "ImprintHandler";

    /* renamed from: k, reason: collision with root package name */
    private static Context f10912k = null;

    /* renamed from: l, reason: collision with root package name */
    private static FileLockUtil f10913l = null;

    /* renamed from: m, reason: collision with root package name */
    private static final int f10914m = 0;
    private static final int n = 1;

    /* renamed from: e, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.internal.d f10915e;

    /* renamed from: h, reason: collision with root package name */
    private a f10916h = new a();

    /* renamed from: i, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.proto.d f10917i = null;

    /* renamed from: b, reason: collision with root package name */
    private static Object f10906b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static final String f10907c = at.b().b(at.f10069c);

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f10908d = "pbl0".getBytes();

    /* renamed from: f, reason: collision with root package name */
    private static Map<String, ArrayList<UMImprintChangeCallback>> f10909f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    private static Object f10910g = new Object();

    /* renamed from: j, reason: collision with root package name */
    private static ImprintHandler f10911j = null;
    private static Map<String, UMImprintPreProcessCallback> o = new HashMap();
    private static Object p = new Object();

    private ImprintHandler(Context context) {
        f10912k = context.getApplicationContext();
    }

    private static void a(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        synchronized (f10910g) {
            try {
                int i2 = 0;
                if (f10909f.containsKey(str)) {
                    ArrayList<UMImprintChangeCallback> arrayList = f10909f.get(str);
                    int size = arrayList.size();
                    ULog.i("--->>> addCallback: before add: callbacks size is: " + size);
                    while (i2 < size) {
                        if (uMImprintChangeCallback == arrayList.get(i2)) {
                            ULog.i("--->>> addCallback: callback has exist, just exit");
                            return;
                        }
                        i2++;
                    }
                    arrayList.add(uMImprintChangeCallback);
                    ULog.i("--->>> addCallback: after add: callbacks size is: " + arrayList.size());
                } else {
                    ArrayList<UMImprintChangeCallback> arrayList2 = new ArrayList<>();
                    int size2 = arrayList2.size();
                    ULog.i("--->>> addCallback: before add: callbacks size is: " + size2);
                    while (i2 < size2) {
                        if (uMImprintChangeCallback == arrayList2.get(i2)) {
                            ULog.i("--->>> addCallback: callback has exist, just exit");
                            return;
                        }
                        i2++;
                    }
                    arrayList2.add(uMImprintChangeCallback);
                    ULog.i("--->>> addCallback: after add: callbacks size is: " + arrayList2.size());
                    f10909f.put(str, arrayList2);
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(f10912k, th);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009f A[Catch: all -> 0x00a1, DONT_GENERATE, TryCatch #0 {, blocks: (B:26:0x009f, B:25:0x009a, B:8:0x000d, B:10:0x0015, B:12:0x001f, B:14:0x0025, B:16:0x0040, B:18:0x0046, B:19:0x005e, B:20:0x0061, B:22:0x007f), top: B:32:0x000d, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(java.lang.String r5, com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto La4
            if (r6 != 0) goto La
            goto La4
        La:
            java.lang.Object r0 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f10910g
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.util.ArrayList<com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback>> r1 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f10909f     // Catch: java.lang.Throwable -> L99
            boolean r1 = r1.containsKey(r5)     // Catch: java.lang.Throwable -> L99
            if (r1 == 0) goto L9f
            java.util.Map<java.lang.String, java.util.ArrayList<com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback>> r1 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f10909f     // Catch: java.lang.Throwable -> L99
            java.lang.Object r1 = r1.get(r5)     // Catch: java.lang.Throwable -> L99
            java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch: java.lang.Throwable -> L99
            if (r6 == 0) goto L9f
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L99
            if (r2 <= 0) goto L9f
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L99
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99
            r3.<init>()     // Catch: java.lang.Throwable -> L99
            java.lang.String r4 = "--->>> removeCallback: before remove: callbacks size is: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L99
            r3.append(r2)     // Catch: java.lang.Throwable -> L99
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L99
            com.umeng.commonsdk.statistics.common.ULog.i(r3)     // Catch: java.lang.Throwable -> L99
            r3 = 0
        L3e:
            if (r3 >= r2) goto L61
            java.lang.Object r4 = r1.get(r3)     // Catch: java.lang.Throwable -> L99
            if (r6 != r4) goto L5e
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99
            r6.<init>()     // Catch: java.lang.Throwable -> L99
            java.lang.String r2 = "--->>> removeCallback: remove index "
            r6.append(r2)     // Catch: java.lang.Throwable -> L99
            r6.append(r3)     // Catch: java.lang.Throwable -> L99
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L99
            com.umeng.commonsdk.statistics.common.ULog.i(r6)     // Catch: java.lang.Throwable -> L99
            r1.remove(r3)     // Catch: java.lang.Throwable -> L99
            goto L61
        L5e:
            int r3 = r3 + 1
            goto L3e
        L61:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99
            r6.<init>()     // Catch: java.lang.Throwable -> L99
            java.lang.String r2 = "--->>> removeCallback: after remove: callbacks size is: "
            r6.append(r2)     // Catch: java.lang.Throwable -> L99
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L99
            r6.append(r2)     // Catch: java.lang.Throwable -> L99
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L99
            com.umeng.commonsdk.statistics.common.ULog.i(r6)     // Catch: java.lang.Throwable -> L99
            int r6 = r1.size()     // Catch: java.lang.Throwable -> L99
            if (r6 != 0) goto L9f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99
            r6.<init>()     // Catch: java.lang.Throwable -> L99
            java.lang.String r1 = "--->>> removeCallback: remove key from map: key = "
            r6.append(r1)     // Catch: java.lang.Throwable -> L99
            r6.append(r5)     // Catch: java.lang.Throwable -> L99
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L99
            com.umeng.commonsdk.statistics.common.ULog.i(r6)     // Catch: java.lang.Throwable -> L99
            java.util.Map<java.lang.String, java.util.ArrayList<com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback>> r6 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f10909f     // Catch: java.lang.Throwable -> L99
            r6.remove(r5)     // Catch: java.lang.Throwable -> L99
            goto L9f
        L99:
            r5 = move-exception
            android.content.Context r6 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f10912k     // Catch: java.lang.Throwable -> La1
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r5)     // Catch: java.lang.Throwable -> La1
        L9f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La1
            return
        La1:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La1
            throw r5
        La4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.ImprintHandler.b(java.lang.String, com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback):void");
    }

    private boolean c(com.umeng.commonsdk.statistics.proto.d dVar) {
        if (!dVar.i().equals(a(dVar))) {
            return false;
        }
        for (com.umeng.commonsdk.statistics.proto.e eVar : dVar.c().values()) {
            String strH = eVar.h();
            if (!TextUtils.isEmpty(strH)) {
                byte[] bArrReverseHexString = DataHelper.reverseHexString(strH);
                byte[] bArrA = a(eVar);
                for (int i2 = 0; i2 < 4; i2++) {
                    if (bArrReverseHexString[i2] != bArrA[i2]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private com.umeng.commonsdk.statistics.proto.d d(com.umeng.commonsdk.statistics.proto.d dVar) {
        Map<String, com.umeng.commonsdk.statistics.proto.e> mapC = dVar.c();
        if (mapC.containsKey(bh.f10121f)) {
            mapC.remove(bh.f10121f);
            this.f10916h.a(bh.f10121f);
            dVar.a(dVar.f());
            dVar.a(a(dVar));
        }
        return dVar;
    }

    private com.umeng.commonsdk.statistics.proto.d e(com.umeng.commonsdk.statistics.proto.d dVar) {
        ArrayList<UMImprintChangeCallback> arrayList;
        boolean z;
        ArrayList<UMImprintChangeCallback> arrayList2;
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        Map<String, com.umeng.commonsdk.statistics.proto.e> mapC = dVar.c();
        ArrayList<String> arrayList3 = new ArrayList(mapC.size() / 2);
        Iterator<Map.Entry<String, com.umeng.commonsdk.statistics.proto.e>> it = mapC.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> next = it.next();
            if (next.getValue().d()) {
                String key = next.getKey();
                String str = next.getValue().f11062a;
                synchronized (p) {
                    z = !TextUtils.isEmpty(key) && o.containsKey(key) && (uMImprintPreProcessCallback = o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str);
                }
                if (z) {
                    arrayList3.add(key);
                }
                synchronized (f10910g) {
                    if (!TextUtils.isEmpty(key) && f10909f.containsKey(key) && (arrayList2 = f10909f.get(key)) != null) {
                        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                            arrayList2.get(i2).onImprintValueChanged(key, str);
                        }
                    }
                }
            } else {
                arrayList3.add(next.getKey());
            }
        }
        for (String str2 : arrayList3) {
            synchronized (f10910g) {
                if (!TextUtils.isEmpty(str2) && f10909f.containsKey(str2) && (arrayList = f10909f.get(str2)) != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        arrayList.get(i3).onImprintValueChanged(str2, null);
                    }
                }
            }
            mapC.remove(str2);
        }
        return dVar;
    }

    public static synchronized ImprintHandler getImprintService(Context context) {
        if (f10911j == null) {
            f10911j = new ImprintHandler(context);
            f10913l = new FileLockUtil();
            if (f10913l != null) {
                f10913l.doFileOperateion(new File(f10912k.getFilesDir(), f10907c), f10911j, 0);
            }
        }
        return f10911j;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(File file, int i2) {
        if (i2 == 0) {
            f10911j.e();
        } else if (i2 == 1) {
            f10911j.a(file);
        }
        return true;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str) {
        return false;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str, Object obj) {
        return false;
    }

    public void registImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        a(str, uMImprintChangeCallback);
    }

    public void registPreProcessCallback(String str, UMImprintPreProcessCallback uMImprintPreProcessCallback) {
        if (TextUtils.isEmpty(str) || uMImprintPreProcessCallback == null) {
            return;
        }
        synchronized (p) {
            try {
                if (o.containsKey(str)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> key : " + str + " PreProcesser has registed!");
                } else {
                    o.put(str, uMImprintPreProcessCallback);
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> registPreProcessCallback: key : " + str + " regist success.");
                }
            } finally {
            }
        }
    }

    public void unregistImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        b(str, uMImprintChangeCallback);
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private Map<String, String> f10918a = new HashMap();

        a() {
        }

        private synchronized void b(com.umeng.commonsdk.statistics.proto.d dVar) {
            com.umeng.commonsdk.statistics.proto.e eVar;
            if (dVar != null) {
                if (dVar.e()) {
                    Map<String, com.umeng.commonsdk.statistics.proto.e> mapC = dVar.c();
                    for (String str : mapC.keySet()) {
                        if (!TextUtils.isEmpty(str) && (eVar = mapC.get(str)) != null) {
                            String strB = eVar.b();
                            if (!TextUtils.isEmpty(strB)) {
                                this.f10918a.put(str, strB);
                                if (AnalyticsConstants.UM_DEBUG) {
                                    String str2 = "imKey is " + str + ", imValue is " + strB;
                                }
                            }
                        }
                    }
                }
            }
        }

        public synchronized void a(String str) {
            if (this.f10918a != null && this.f10918a.size() > 0 && !TextUtils.isEmpty(str) && this.f10918a.containsKey(str)) {
                this.f10918a.remove(str);
            }
        }

        a(com.umeng.commonsdk.statistics.proto.d dVar) {
            a(dVar);
        }

        public void a(com.umeng.commonsdk.statistics.proto.d dVar) {
            if (dVar == null) {
                return;
            }
            b(dVar);
        }

        public synchronized String a(String str, String str2) {
            if (!TextUtils.isEmpty(str) && this.f10918a.size() > 0) {
                String str3 = this.f10918a.get(str);
                return !TextUtils.isEmpty(str3) ? str3 : str2;
            }
            return str2;
        }
    }

    public void d() throws IOException {
        if (this.f10917i == null || f10913l == null) {
            return;
        }
        File file = new File(f10912k.getFilesDir(), f10907c);
        if (!file.exists()) {
            try {
                try {
                    file.createNewFile();
                } catch (IOException unused) {
                    file.createNewFile();
                }
            } catch (IOException e2) {
                UMCrashManager.reportCrash(f10912k, e2);
            }
        }
        f10913l.doFileOperateion(file, f10911j, 1);
    }

    public a c() {
        return this.f10916h;
    }

    public void b(com.umeng.commonsdk.statistics.proto.d dVar) {
        com.umeng.commonsdk.statistics.proto.d dVarA;
        boolean z;
        if (dVar == null) {
            if (AnalyticsConstants.UM_DEBUG) {
                UMRTLog.d(UMRTLog.RTLOG_TAG, "Imprint is null");
                return;
            }
            return;
        }
        if (!c(dVar)) {
            if (AnalyticsConstants.UM_DEBUG) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "Imprint is not valid");
                return;
            }
            return;
        }
        boolean z2 = AnalyticsConstants.UM_DEBUG;
        HashMap map = new HashMap();
        synchronized (this) {
            com.umeng.commonsdk.statistics.proto.d dVar2 = this.f10917i;
            com.umeng.commonsdk.statistics.proto.d dVarD = d(dVar);
            String strI = null;
            String strI2 = dVar2 == null ? null : dVar2.i();
            if (dVar2 == null) {
                dVarA = e(dVarD);
            } else {
                dVarA = a(dVar2, dVarD, map);
            }
            this.f10917i = dVarA;
            if (dVarA != null) {
                strI = dVarA.i();
            }
            z = !a(strI2, strI);
        }
        com.umeng.commonsdk.statistics.proto.d dVar3 = this.f10917i;
        if (dVar3 != null) {
            boolean z3 = AnalyticsConstants.UM_DEBUG;
            if (z) {
                this.f10916h.a(dVar3);
                com.umeng.commonsdk.statistics.internal.d dVar4 = this.f10915e;
                if (dVar4 != null) {
                    dVar4.onImprintChanged(this.f10916h);
                }
            }
        }
        if (map.size() > 0) {
            synchronized (f10910g) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && f10909f.containsKey(key)) {
                        ULog.i("--->>> target imprint key is: " + key + "; value is: " + value);
                        ArrayList<UMImprintChangeCallback> arrayList = f10909f.get(key);
                        if (arrayList != null) {
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                arrayList.get(i2).onImprintValueChanged(key, value);
                            }
                        }
                    }
                }
            }
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (p) {
            try {
                if (o.containsKey(str)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: unregist [" + str + "] success.");
                    f10909f.remove(str);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: can't find [" + str + "], pls regist first.");
                }
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0035 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e() {
        /*
            r5 = this;
            java.io.File r0 = new java.io.File
            android.content.Context r1 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f10912k
            java.io.File r1 = r1.getFilesDir()
            java.lang.String r2 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f10907c
            r0.<init>(r1, r2)
            java.lang.Object r1 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f10906b
            monitor-enter(r1)
            boolean r0 = r0.exists()     // Catch: java.lang.Throwable -> L60
            if (r0 != 0) goto L18
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L60
            return
        L18:
            r0 = 0
            android.content.Context r2 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f10912k     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
            java.lang.String r3 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f10907c     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
            java.io.FileInputStream r2 = r2.openFileInput(r3)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
            byte[] r0 = com.umeng.commonsdk.statistics.common.HelperUtils.readStreamToByteArray(r2)     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L58
        L25:
            com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(r2)     // Catch: java.lang.Throwable -> L60
            goto L33
        L29:
            r3 = move-exception
            goto L2f
        L2b:
            r2 = move-exception
            goto L5c
        L2d:
            r3 = move-exception
            r2 = r0
        L2f:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L58
            goto L25
        L33:
            if (r0 == 0) goto L56
            com.umeng.commonsdk.statistics.proto.d r2 = new com.umeng.commonsdk.statistics.proto.d     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L60
            r2.<init>()     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L60
            com.umeng.analytics.pro.bt r3 = new com.umeng.analytics.pro.bt     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L60
            r3.<init>()     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L60
            r3.a(r2, r0)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L60
            r5.f10917i = r2     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L60
            com.umeng.commonsdk.statistics.idtracking.ImprintHandler$a r0 = r5.f10916h     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L60
            r0.a(r2)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L60
            com.umeng.commonsdk.statistics.proto.d r0 = r5.f10917i     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L60
            com.umeng.commonsdk.statistics.proto.d r0 = r5.d(r0)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L60
            r5.f10917i = r0     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L60
            goto L56
        L52:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L60
        L56:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L60
            return
        L58:
            r0 = move-exception
            r4 = r2
            r2 = r0
            r0 = r4
        L5c:
            com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(r0)     // Catch: java.lang.Throwable -> L60
            throw r2     // Catch: java.lang.Throwable -> L60
        L60:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L60
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.ImprintHandler.e():void");
    }

    public void a(com.umeng.commonsdk.statistics.internal.d dVar) {
        this.f10915e = dVar;
    }

    public String a(com.umeng.commonsdk.statistics.proto.d dVar) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : new TreeMap(dVar.c()).entrySet()) {
            sb.append((String) entry.getKey());
            if (((com.umeng.commonsdk.statistics.proto.e) entry.getValue()).d()) {
                sb.append(((com.umeng.commonsdk.statistics.proto.e) entry.getValue()).b());
            }
        }
        sb.append(dVar.f11044b);
        return HelperUtils.MD5(sb.toString()).toLowerCase(Locale.US);
    }

    public byte[] a(com.umeng.commonsdk.statistics.proto.e eVar) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(null);
        byteBufferAllocate.putLong(eVar.e());
        byte[] bArrArray = byteBufferAllocate.array();
        byte[] bArr = f10908d;
        byte[] bArr2 = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr2[i2] = (byte) (bArrArray[i2] ^ bArr[i2]);
        }
        return bArr2;
    }

    public byte[] a() {
        try {
            synchronized (this) {
                if (this.f10917i == null) {
                    return null;
                }
                if (this.f10917i.b() <= 0) {
                    return null;
                }
                return new bz().a(this.f10917i);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f10912k, th);
            return null;
        }
    }

    public synchronized com.umeng.commonsdk.statistics.proto.d b() {
        return this.f10917i;
    }

    private boolean a(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    private com.umeng.commonsdk.statistics.proto.d a(com.umeng.commonsdk.statistics.proto.d dVar, com.umeng.commonsdk.statistics.proto.d dVar2, Map<String, String> map) {
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        ArrayList<UMImprintChangeCallback> arrayList;
        if (dVar2 == null) {
            return dVar;
        }
        Map<String, com.umeng.commonsdk.statistics.proto.e> mapC = dVar.c();
        for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar2.c().entrySet()) {
            int i2 = 0;
            if (entry.getValue().d()) {
                String key = entry.getKey();
                String str = entry.getValue().f11062a;
                synchronized (p) {
                    if (!TextUtils.isEmpty(key) && o.containsKey(key) && (uMImprintPreProcessCallback = o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str)) {
                        i2 = 1;
                    }
                }
                if (i2 == 0) {
                    mapC.put(entry.getKey(), entry.getValue());
                    synchronized (f10910g) {
                        if (!TextUtils.isEmpty(key) && f10909f.containsKey(key) && f10909f.get(key) != null) {
                            map.put(key, str);
                        }
                    }
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> merge: [" + key + "] should be ignored.");
                }
            } else {
                String key2 = entry.getKey();
                synchronized (f10910g) {
                    if (!TextUtils.isEmpty(key2) && f10909f.containsKey(key2) && (arrayList = f10909f.get(key2)) != null) {
                        while (i2 < arrayList.size()) {
                            arrayList.get(i2).onImprintValueChanged(key2, null);
                            i2++;
                        }
                    }
                }
                mapC.remove(key2);
                this.f10916h.a(key2);
            }
        }
        dVar.a(dVar2.f());
        dVar.a(a(dVar));
        return dVar;
    }

    private void a(File file) {
        if (this.f10917i == null) {
            return;
        }
        try {
            synchronized (f10906b) {
                byte[] bArrA = new bz().a(this.f10917i);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(bArrA);
                    fileOutputStream.flush();
                } finally {
                    HelperUtils.safeClose(fileOutputStream);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
