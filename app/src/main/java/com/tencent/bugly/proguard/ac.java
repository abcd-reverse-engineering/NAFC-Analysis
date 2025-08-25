package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class ac {

    /* renamed from: a, reason: collision with root package name */
    public static final long f9172a = System.currentTimeMillis();

    /* renamed from: b, reason: collision with root package name */
    private static ac f9173b;

    /* renamed from: c, reason: collision with root package name */
    private Context f9174c;

    /* renamed from: f, reason: collision with root package name */
    private SharedPreferences f9177f;

    /* renamed from: e, reason: collision with root package name */
    private Map<Integer, Map<String, ab>> f9176e = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private String f9175d = com.tencent.bugly.crashreport.common.info.a.b().f8978e;

    public ac(Context context) {
        this.f9174c = context;
        this.f9177f = context.getSharedPreferences("crashrecord", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004b A[Catch: all -> 0x0061, Exception -> 0x0063, PHI: r6
  0x004b: PHI (r6v11 java.io.ObjectInputStream) = (r6v10 java.io.ObjectInputStream), (r6v12 java.io.ObjectInputStream) binds: [B:17:0x0049, B:22:0x0057] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x0063, blocks: (B:4:0x0003, B:10:0x0039, B:18:0x004b, B:26:0x005d, B:27:0x0060), top: B:37:0x0003, outer: #0 }] */
    /* JADX WARN: Type inference failed for: r6v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized <T extends java.util.List<?>> T c(int r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            android.content.Context r3 = r5.f9174c     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            java.lang.String r4 = "crashrecord"
            java.io.File r3 = r3.getDir(r4, r1)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            r4.<init>()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            r4.append(r6)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            java.lang.String r6 = ""
            r4.append(r6)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            java.lang.String r6 = r4.toString()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            r2.<init>(r3, r6)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            boolean r6 = r2.exists()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            if (r6 != 0) goto L29
            monitor-exit(r5)
            return r0
        L29:
            java.io.ObjectInputStream r6 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L3e java.lang.ClassNotFoundException -> L41 java.io.IOException -> L4f
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3e java.lang.ClassNotFoundException -> L41 java.io.IOException -> L4f
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L3e java.lang.ClassNotFoundException -> L41 java.io.IOException -> L4f
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L3e java.lang.ClassNotFoundException -> L41 java.io.IOException -> L4f
            java.lang.Object r2 = r6.readObject()     // Catch: java.lang.ClassNotFoundException -> L42 java.io.IOException -> L50 java.lang.Throwable -> L5a
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.ClassNotFoundException -> L42 java.io.IOException -> L50 java.lang.Throwable -> L5a
            r6.close()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            monitor-exit(r5)
            return r2
        L3e:
            r2 = move-exception
            r6 = r0
            goto L5b
        L41:
            r6 = r0
        L42:
            java.lang.String r2 = "get object error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L5a
            com.tencent.bugly.proguard.an.a(r2, r3)     // Catch: java.lang.Throwable -> L5a
            if (r6 == 0) goto L6a
        L4b:
            r6.close()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            goto L6a
        L4f:
            r6 = r0
        L50:
            java.lang.String r2 = "open record file error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L5a
            com.tencent.bugly.proguard.an.a(r2, r3)     // Catch: java.lang.Throwable -> L5a
            if (r6 == 0) goto L6a
            goto L4b
        L5a:
            r2 = move-exception
        L5b:
            if (r6 == 0) goto L60
            r6.close()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
        L60:
            throw r2     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
        L61:
            r6 = move-exception
            goto L6c
        L63:
            java.lang.String r6 = "readCrashRecord error"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L61
            com.tencent.bugly.proguard.an.e(r6, r1)     // Catch: java.lang.Throwable -> L61
        L6a:
            monitor-exit(r5)
            return r0
        L6c:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ac.c(int):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean b(int i2) {
        try {
            List<ab> listC = c(i2);
            if (listC == null) {
                return false;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (ab abVar : listC) {
                if (abVar.f9166b != null && abVar.f9166b.equalsIgnoreCase(this.f9175d) && abVar.f9168d > 0) {
                    arrayList.add(abVar);
                }
                if (abVar.f9167c + 86400000 < jCurrentTimeMillis) {
                    arrayList2.add(abVar);
                }
            }
            Collections.sort(arrayList);
            if (arrayList.size() >= 2) {
                if (arrayList.size() <= 0 || ((ab) arrayList.get(arrayList.size() - 1)).f9167c + 86400000 >= jCurrentTimeMillis) {
                    return true;
                }
                listC.clear();
                a(i2, (int) listC);
                return false;
            }
            listC.removeAll(arrayList2);
            a(i2, (int) listC);
            return false;
        } catch (Exception unused) {
            an.e("isFrequentCrash failed", new Object[0]);
            return false;
        }
    }

    public static synchronized ac a(Context context) {
        if (f9173b == null) {
            f9173b = new ac(context);
        }
        return f9173b;
    }

    public static synchronized ac a() {
        return f9173b;
    }

    public void a(final int i2, final int i3) {
        am.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.ac.1
            @Override // java.lang.Runnable
            public void run() {
                ab abVar;
                try {
                    if (TextUtils.isEmpty(ac.this.f9175d)) {
                        return;
                    }
                    List<ab> listC = ac.this.c(i2);
                    if (listC == null) {
                        listC = new ArrayList();
                    }
                    if (ac.this.f9176e.get(Integer.valueOf(i2)) == null) {
                        ac.this.f9176e.put(Integer.valueOf(i2), new HashMap());
                    }
                    if (((Map) ac.this.f9176e.get(Integer.valueOf(i2))).get(ac.this.f9175d) == null) {
                        abVar = new ab();
                        abVar.f9165a = i2;
                        abVar.f9171g = ac.f9172a;
                        abVar.f9166b = ac.this.f9175d;
                        abVar.f9170f = com.tencent.bugly.crashreport.common.info.a.b().p;
                        abVar.f9169e = com.tencent.bugly.crashreport.common.info.a.b().f8983j;
                        abVar.f9167c = System.currentTimeMillis();
                        abVar.f9168d = i3;
                        ((Map) ac.this.f9176e.get(Integer.valueOf(i2))).put(ac.this.f9175d, abVar);
                    } else {
                        abVar = (ab) ((Map) ac.this.f9176e.get(Integer.valueOf(i2))).get(ac.this.f9175d);
                        abVar.f9168d = i3;
                    }
                    ArrayList arrayList = new ArrayList();
                    boolean z = false;
                    for (ab abVar2 : listC) {
                        if (abVar2.f9171g == abVar.f9171g && abVar2.f9166b != null && abVar2.f9166b.equalsIgnoreCase(abVar.f9166b)) {
                            z = true;
                            abVar2.f9168d = abVar.f9168d;
                        }
                        if ((abVar2.f9169e != null && !abVar2.f9169e.equalsIgnoreCase(abVar.f9169e)) || ((abVar2.f9170f != null && !abVar2.f9170f.equalsIgnoreCase(abVar.f9170f)) || abVar2.f9168d <= 0)) {
                            arrayList.add(abVar2);
                        }
                    }
                    listC.removeAll(arrayList);
                    if (!z) {
                        listC.add(abVar);
                    }
                    ac.this.a(i2, (int) listC);
                } catch (Exception unused) {
                    an.e("saveCrashRecord failed", new Object[0]);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized <T extends List<?>> void a(int i2, T t) {
        if (t == null) {
            return;
        }
        try {
            ObjectOutputStream objectOutputStream = null;
            try {
                try {
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(new File(this.f9174c.getDir("crashrecord", 0), i2 + "")));
                    try {
                        objectOutputStream2.writeObject(t);
                        objectOutputStream2.close();
                    } catch (IOException e2) {
                        e = e2;
                        objectOutputStream = objectOutputStream2;
                        e.printStackTrace();
                        an.a("open record file error", new Object[0]);
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        objectOutputStream = objectOutputStream2;
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (Exception unused) {
            an.e("writeCrashRecord error", new Object[0]);
        }
    }

    public synchronized boolean a(final int i2) {
        boolean z;
        z = true;
        try {
            z = this.f9177f.getBoolean(i2 + c.c.a.b.a.a.s1 + this.f9175d, true);
            am.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.ac.2
                @Override // java.lang.Runnable
                public void run() {
                    boolean zB = ac.this.b(i2);
                    ac.this.f9177f.edit().putBoolean(i2 + c.c.a.b.a.a.s1 + ac.this.f9175d, !zB).commit();
                }
            });
        } catch (Exception unused) {
            an.e("canInit error", new Object[0]);
            return z;
        }
        return z;
    }
}
