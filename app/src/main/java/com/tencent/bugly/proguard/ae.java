package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class ae {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f9183a = false;

    /* renamed from: b, reason: collision with root package name */
    private static ae f9184b;

    /* renamed from: c, reason: collision with root package name */
    private static af f9185c;

    private ae(Context context, List<com.tencent.bugly.a> list) {
        f9185c = new af(context, list);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00cb A[Catch: all -> 0x00cf, PHI: r1
  0x00cb: PHI (r1v2 android.database.sqlite.SQLiteDatabase) = (r1v1 android.database.sqlite.SQLiteDatabase), (r1v4 android.database.sqlite.SQLiteDatabase) binds: [B:57:0x00e6, B:43:0x00c9] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #5 {, blocks: (B:9:0x002c, B:10:0x002f, B:13:0x0035, B:30:0x00b2, B:31:0x00b5, B:34:0x00bb, B:54:0x00df, B:55:0x00e2, B:44:0x00cb, B:63:0x00ee, B:64:0x00f1, B:67:0x00f7, B:68:0x00fa, B:41:0x00c5, B:50:0x00d4, B:52:0x00da), top: B:81:0x0002, inners: #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized java.util.List<com.tencent.bugly.proguard.ag> c(int r12) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ae.c(int):java.util.List");
    }

    private synchronized boolean d(ag agVar) {
        ContentValues contentValuesC;
        if (agVar == null) {
            return false;
        }
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = f9185c.getWritableDatabase();
            if (writableDatabase == null || (contentValuesC = c(agVar)) == null) {
                if (f9183a && writableDatabase != null) {
                    writableDatabase.close();
                }
                return false;
            }
            long jReplace = writableDatabase.replace("t_pf", com.umeng.analytics.pro.bl.f10170d, contentValuesC);
            if (jReplace >= 0) {
                an.c("[Database] insert %s success.", "t_pf");
                agVar.f9203a = jReplace;
                return true;
            }
            if (f9183a && writableDatabase != null) {
                writableDatabase.close();
            }
            return false;
        } catch (Throwable th) {
            try {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
                if (f9183a && writableDatabase != null) {
                    writableDatabase.close();
                }
                return false;
            } finally {
                if (f9183a && writableDatabase != null) {
                    writableDatabase.close();
                }
            }
        }
    }

    public synchronized void b(int i2) {
        String str;
        SQLiteDatabase writableDatabase = f9185c.getWritableDatabase();
        if (writableDatabase != null) {
            if (i2 >= 0) {
                try {
                    str = "_tp = " + i2;
                } catch (Throwable th) {
                    try {
                        if (!an.a(th)) {
                            th.printStackTrace();
                        }
                        if (f9183a && writableDatabase != null) {
                        }
                    } finally {
                        if (f9183a && writableDatabase != null) {
                            writableDatabase.close();
                        }
                    }
                }
            } else {
                str = null;
            }
            an.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", str, null)));
        }
    }

    /* compiled from: BUGLY */
    class a extends Thread {

        /* renamed from: b, reason: collision with root package name */
        private int f9187b;

        /* renamed from: c, reason: collision with root package name */
        private ad f9188c;

        /* renamed from: d, reason: collision with root package name */
        private String f9189d;

        /* renamed from: e, reason: collision with root package name */
        private ContentValues f9190e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f9191f;

        /* renamed from: g, reason: collision with root package name */
        private String[] f9192g;

        /* renamed from: h, reason: collision with root package name */
        private String f9193h;

        /* renamed from: i, reason: collision with root package name */
        private String[] f9194i;

        /* renamed from: j, reason: collision with root package name */
        private String f9195j;

        /* renamed from: k, reason: collision with root package name */
        private String f9196k;

        /* renamed from: l, reason: collision with root package name */
        private String f9197l;

        /* renamed from: m, reason: collision with root package name */
        private String f9198m;
        private String n;
        private String[] o;
        private int p;
        private String q;
        private byte[] r;

        public a(int i2, ad adVar) {
            this.f9187b = i2;
            this.f9188c = adVar;
        }

        public void a(String str, ContentValues contentValues) {
            this.f9189d = str;
            this.f9190e = contentValues;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            switch (this.f9187b) {
                case 1:
                    ae.this.a(this.f9189d, this.f9190e, this.f9188c);
                    break;
                case 2:
                    ae.this.a(this.f9189d, this.n, this.o, this.f9188c);
                    break;
                case 3:
                    Cursor cursorA = ae.this.a(this.f9191f, this.f9189d, this.f9192g, this.f9193h, this.f9194i, this.f9195j, this.f9196k, this.f9197l, this.f9198m, this.f9188c);
                    if (cursorA != null) {
                        cursorA.close();
                        break;
                    }
                    break;
                case 4:
                    ae.this.a(this.p, this.q, this.r, this.f9188c);
                    break;
                case 5:
                    ae.this.a(this.p, this.f9188c);
                    break;
                case 6:
                    ae.this.a(this.p, this.q, this.f9188c);
                    break;
            }
        }

        public void a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
            this.f9191f = z;
            this.f9189d = str;
            this.f9192g = strArr;
            this.f9193h = str2;
            this.f9194i = strArr2;
            this.f9195j = str3;
            this.f9196k = str4;
            this.f9197l = str5;
            this.f9198m = str6;
        }

        public void a(String str, String str2, String[] strArr) {
            this.f9189d = str;
            this.n = str2;
            this.o = strArr;
        }

        public void a(int i2, String str, byte[] bArr) {
            this.p = i2;
            this.q = str;
            this.r = bArr;
        }

        public void a(int i2) {
            this.p = i2;
        }

        public void a(int i2, String str) {
            this.p = i2;
            this.q = str;
        }
    }

    public static synchronized ae a(Context context, List<com.tencent.bugly.a> list) {
        if (f9184b == null) {
            f9184b = new ae(context, list);
        }
        return f9184b;
    }

    public static synchronized ae a() {
        return f9184b;
    }

    public long a(String str, ContentValues contentValues, ad adVar, boolean z) {
        if (!z) {
            a aVar = new a(1, adVar);
            aVar.a(str, contentValues);
            am.a().a(aVar);
            return 0L;
        }
        return a(str, contentValues, adVar);
    }

    protected ContentValues b(ag agVar) {
        if (agVar == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (agVar.f9203a > 0) {
                contentValues.put(com.umeng.analytics.pro.bl.f10170d, Long.valueOf(agVar.f9203a));
            }
            contentValues.put(com.umeng.analytics.pro.bl.f10171e, Integer.valueOf(agVar.f9204b));
            contentValues.put("_pc", agVar.f9205c);
            contentValues.put("_th", agVar.f9206d);
            contentValues.put("_tm", Long.valueOf(agVar.f9207e));
            if (agVar.f9209g != null) {
                contentValues.put("_dt", agVar.f9209g);
            }
            return contentValues;
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public Cursor a(String str, String[] strArr, String str2, String[] strArr2, ad adVar, boolean z) {
        return a(false, str, strArr, str2, strArr2, (String) null, (String) null, (String) null, (String) null, adVar, z);
    }

    public Cursor a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, ad adVar, boolean z2) {
        if (!z2) {
            a aVar = new a(3, adVar);
            aVar.a(z, str, strArr, str2, strArr2, str3, str4, str5, str6);
            am.a().a(aVar);
            return null;
        }
        return a(z, str, strArr, str2, strArr2, str3, str4, str5, str6, adVar);
    }

    public int a(String str, String str2, String[] strArr, ad adVar, boolean z) {
        if (!z) {
            a aVar = new a(2, adVar);
            aVar.a(str, str2, strArr);
            am.a().a(aVar);
            return 0;
        }
        return a(str, str2, strArr, adVar);
    }

    protected ag b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            ag agVar = new ag();
            agVar.f9203a = cursor.getLong(cursor.getColumnIndex(com.umeng.analytics.pro.bl.f10170d));
            agVar.f9207e = cursor.getLong(cursor.getColumnIndex("_tm"));
            agVar.f9208f = cursor.getString(cursor.getColumnIndex(com.umeng.analytics.pro.bl.f10171e));
            agVar.f9209g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return agVar;
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized long a(String str, ContentValues contentValues, ad adVar) {
        long j2;
        SQLiteDatabase writableDatabase = null;
        j2 = 0;
        try {
            writableDatabase = f9185c.getWritableDatabase();
            if (writableDatabase != null && contentValues != null) {
                long jReplace = writableDatabase.replace(str, com.umeng.analytics.pro.bl.f10170d, contentValues);
                if (jReplace >= 0) {
                    an.c("[Database] insert %s success.", str);
                } else {
                    an.d("[Database] replace %s error.", str);
                }
                j2 = jReplace;
            }
        } catch (Throwable th) {
            try {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
                if (adVar != null) {
                    adVar.a(0L);
                }
                if (f9183a && 0 != 0) {
                }
            } finally {
                if (adVar != null) {
                    adVar.a(0L);
                }
                if (f9183a && 0 != 0) {
                    writableDatabase.close();
                }
            }
        }
        return j2;
    }

    protected ContentValues c(ag agVar) {
        if (agVar != null && !aq.a(agVar.f9208f)) {
            try {
                ContentValues contentValues = new ContentValues();
                if (agVar.f9203a > 0) {
                    contentValues.put(com.umeng.analytics.pro.bl.f10170d, Long.valueOf(agVar.f9203a));
                }
                contentValues.put(com.umeng.analytics.pro.bl.f10171e, agVar.f9208f);
                contentValues.put("_tm", Long.valueOf(agVar.f9207e));
                if (agVar.f9209g != null) {
                    contentValues.put("_dt", agVar.f9209g);
                }
                return contentValues;
            } catch (Throwable th) {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Cursor a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, ad adVar) {
        Cursor cursorQuery;
        try {
            SQLiteDatabase writableDatabase = f9185c.getWritableDatabase();
            cursorQuery = writableDatabase != null ? writableDatabase.query(z, str, strArr, str2, strArr2, str3, str4, str5, str6) : null;
        } catch (Throwable th) {
            try {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
                if (adVar != null) {
                }
            } finally {
                if (adVar != null) {
                    adVar.a(null);
                }
            }
        }
        return cursorQuery;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int a(String str, String str2, String[] strArr, ad adVar) {
        int iDelete;
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = f9185c.getWritableDatabase();
            iDelete = writableDatabase != null ? writableDatabase.delete(str, str2, strArr) : 0;
        } catch (Throwable th) {
            try {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
                if (adVar != null) {
                    adVar.a(0);
                }
                if (f9183a && writableDatabase != null) {
                }
            } finally {
                if (adVar != null) {
                    adVar.a(0);
                }
                if (f9183a && writableDatabase != null) {
                    writableDatabase.close();
                }
            }
        }
        return iDelete;
    }

    public boolean a(int i2, String str, byte[] bArr, ad adVar, boolean z) {
        if (!z) {
            a aVar = new a(4, adVar);
            aVar.a(i2, str, bArr);
            am.a().a(aVar);
            return true;
        }
        return a(i2, str, bArr, adVar);
    }

    public Map<String, byte[]> a(int i2, ad adVar, boolean z) {
        if (!z) {
            a aVar = new a(5, adVar);
            aVar.a(i2);
            am.a().a(aVar);
            return null;
        }
        return a(i2, adVar);
    }

    public boolean a(int i2, String str, ad adVar, boolean z) {
        if (!z) {
            a aVar = new a(6, adVar);
            aVar.a(i2, str);
            am.a().a(aVar);
            return false;
        }
        return a(i2, str, adVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i2, String str, byte[] bArr, ad adVar) {
        boolean zD = false;
        try {
            ag agVar = new ag();
            agVar.f9203a = i2;
            agVar.f9208f = str;
            agVar.f9207e = System.currentTimeMillis();
            agVar.f9209g = bArr;
            zD = d(agVar);
        } catch (Throwable th) {
            try {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
                if (adVar != null) {
                }
            } finally {
                if (adVar != null) {
                    adVar.a(false);
                }
            }
        }
        return zD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002d A[DONT_GENERATE, PHI: r0
  0x002d: PHI (r0v1 java.util.HashMap) = (r0v3 java.util.HashMap), (r0v4 java.util.HashMap) binds: [B:22:0x003b, B:16:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Map<java.lang.String, byte[]> a(int r4, com.tencent.bugly.proguard.ad r5) {
        /*
            r3 = this;
            r0 = 0
            java.util.List r4 = r3.c(r4)     // Catch: java.lang.Throwable -> L31
            if (r4 == 0) goto L2b
            java.util.HashMap r1 = new java.util.HashMap     // Catch: java.lang.Throwable -> L31
            r1.<init>()     // Catch: java.lang.Throwable -> L31
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L28
        L10:
            boolean r0 = r4.hasNext()     // Catch: java.lang.Throwable -> L28
            if (r0 == 0) goto L26
            java.lang.Object r0 = r4.next()     // Catch: java.lang.Throwable -> L28
            com.tencent.bugly.proguard.ag r0 = (com.tencent.bugly.proguard.ag) r0     // Catch: java.lang.Throwable -> L28
            byte[] r2 = r0.f9209g     // Catch: java.lang.Throwable -> L28
            if (r2 == 0) goto L10
            java.lang.String r0 = r0.f9208f     // Catch: java.lang.Throwable -> L28
            r1.put(r0, r2)     // Catch: java.lang.Throwable -> L28
            goto L10
        L26:
            r0 = r1
            goto L2b
        L28:
            r4 = move-exception
            r0 = r1
            goto L32
        L2b:
            if (r5 == 0) goto L3e
        L2d:
            r5.a(r0)
            goto L3e
        L31:
            r4 = move-exception
        L32:
            boolean r1 = com.tencent.bugly.proguard.an.a(r4)     // Catch: java.lang.Throwable -> L3f
            if (r1 != 0) goto L3b
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L3f
        L3b:
            if (r5 == 0) goto L3e
            goto L2d
        L3e:
            return r0
        L3f:
            r4 = move-exception
            if (r5 == 0) goto L45
            r5.a(r0)
        L45:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ae.a(int, com.tencent.bugly.proguard.ad):java.util.Map");
    }

    public synchronized boolean a(ag agVar) {
        ContentValues contentValuesB;
        if (agVar == null) {
            return false;
        }
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = f9185c.getWritableDatabase();
            if (writableDatabase != null && (contentValuesB = b(agVar)) != null) {
                long jReplace = writableDatabase.replace("t_lr", com.umeng.analytics.pro.bl.f10170d, contentValuesB);
                if (jReplace >= 0) {
                    an.c("[Database] insert %s success.", "t_lr");
                    agVar.f9203a = jReplace;
                    return true;
                }
                if (f9183a && writableDatabase != null) {
                    writableDatabase.close();
                }
                return false;
            }
            if (f9183a && writableDatabase != null) {
                writableDatabase.close();
            }
            return false;
        } catch (Throwable th) {
            try {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
                if (f9183a && writableDatabase != null) {
                    writableDatabase.close();
                }
                return false;
            } finally {
                if (f9183a && writableDatabase != null) {
                    writableDatabase.close();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00c2 A[Catch: all -> 0x00d4, TRY_LEAVE, TryCatch #0 {all -> 0x00d4, blocks: (B:43:0x00bc, B:45:0x00c2), top: B:65:0x00bc, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c7 A[Catch: all -> 0x00e6, TRY_ENTER, TryCatch #1 {, blocks: (B:3:0x0001, B:14:0x0035, B:15:0x0038, B:18:0x003e, B:35:0x00ad, B:36:0x00b0, B:39:0x00b6, B:47:0x00c7, B:48:0x00ca, B:51:0x00d0, B:54:0x00d7, B:55:0x00da, B:58:0x00e0, B:59:0x00e3, B:43:0x00bc, B:45:0x00c2), top: B:67:0x0001, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.util.List<com.tencent.bugly.proguard.ag> a(int r11) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ae.a(int):java.util.List");
    }

    public synchronized void a(List<ag> list) {
        if (list != null) {
            if (list.size() != 0) {
                SQLiteDatabase writableDatabase = f9185c.getWritableDatabase();
                if (writableDatabase != null) {
                    StringBuilder sb = new StringBuilder();
                    for (ag agVar : list) {
                        sb.append(" or ");
                        sb.append(com.umeng.analytics.pro.bl.f10170d);
                        sb.append(" = ");
                        sb.append(agVar.f9203a);
                    }
                    String string = sb.toString();
                    if (string.length() > 0) {
                        string = string.substring(4);
                    }
                    sb.setLength(0);
                    try {
                        an.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", string, null)));
                    } catch (Throwable th) {
                        try {
                            if (!an.a(th)) {
                                th.printStackTrace();
                            }
                            if (f9183a) {
                            }
                        } finally {
                            if (f9183a) {
                                writableDatabase.close();
                            }
                        }
                    }
                }
            }
        }
    }

    protected ag a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            ag agVar = new ag();
            agVar.f9203a = cursor.getLong(cursor.getColumnIndex(com.umeng.analytics.pro.bl.f10170d));
            agVar.f9204b = cursor.getInt(cursor.getColumnIndex(com.umeng.analytics.pro.bl.f10171e));
            agVar.f9205c = cursor.getString(cursor.getColumnIndex("_pc"));
            agVar.f9206d = cursor.getString(cursor.getColumnIndex("_th"));
            agVar.f9207e = cursor.getLong(cursor.getColumnIndex("_tm"));
            agVar.f9209g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return agVar;
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0079 A[Catch: all -> 0x007d, DONT_GENERATE, PHI: r1 r2
  0x0079: PHI (r1v2 boolean) = (r1v0 boolean), (r1v4 boolean) binds: [B:33:0x0097, B:19:0x0077] A[DONT_GENERATE, DONT_INLINE]
  0x0079: PHI (r2v2 android.database.sqlite.SQLiteDatabase) = (r2v1 android.database.sqlite.SQLiteDatabase), (r2v4 android.database.sqlite.SQLiteDatabase) binds: [B:33:0x0097, B:19:0x0077] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #2 {, blocks: (B:16:0x006c, B:17:0x0073, B:20:0x0079, B:30:0x008c, B:31:0x0093, B:39:0x009f, B:40:0x00a6, B:43:0x00ac, B:44:0x00af, B:26:0x0081, B:28:0x0087), top: B:51:0x0003, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean a(int r6, java.lang.String r7, com.tencent.bugly.proguard.ad r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r1 = 0
            com.tencent.bugly.proguard.af r2 = com.tencent.bugly.proguard.ae.f9185c     // Catch: java.lang.Throwable -> L7f
            android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()     // Catch: java.lang.Throwable -> L7f
            if (r2 == 0) goto L6a
            boolean r3 = com.tencent.bugly.proguard.aq.a(r7)     // Catch: java.lang.Throwable -> L68
            if (r3 == 0) goto L23
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L68
            r7.<init>()     // Catch: java.lang.Throwable -> L68
            java.lang.String r3 = "_id = "
            r7.append(r3)     // Catch: java.lang.Throwable -> L68
            r7.append(r6)     // Catch: java.lang.Throwable -> L68
            java.lang.String r6 = r7.toString()     // Catch: java.lang.Throwable -> L68
            goto L4b
        L23:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L68
            r3.<init>()     // Catch: java.lang.Throwable -> L68
            java.lang.String r4 = "_id = "
            r3.append(r4)     // Catch: java.lang.Throwable -> L68
            r3.append(r6)     // Catch: java.lang.Throwable -> L68
            java.lang.String r6 = " and "
            r3.append(r6)     // Catch: java.lang.Throwable -> L68
            java.lang.String r6 = "_tp"
            r3.append(r6)     // Catch: java.lang.Throwable -> L68
            java.lang.String r6 = " = \""
            r3.append(r6)     // Catch: java.lang.Throwable -> L68
            r3.append(r7)     // Catch: java.lang.Throwable -> L68
            java.lang.String r6 = "\""
            r3.append(r6)     // Catch: java.lang.Throwable -> L68
            java.lang.String r6 = r3.toString()     // Catch: java.lang.Throwable -> L68
        L4b:
            java.lang.String r7 = "t_pf"
            int r6 = r2.delete(r7, r6, r0)     // Catch: java.lang.Throwable -> L68
            java.lang.String r7 = "[Database] deleted %s data %d"
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L68
            java.lang.String r3 = "t_pf"
            r0[r1] = r3     // Catch: java.lang.Throwable -> L68
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L68
            r4 = 1
            r0[r4] = r3     // Catch: java.lang.Throwable -> L68
            com.tencent.bugly.proguard.an.c(r7, r0)     // Catch: java.lang.Throwable -> L68
            if (r6 <= 0) goto L6a
            r1 = 1
            goto L6a
        L68:
            r6 = move-exception
            goto L81
        L6a:
            if (r8 == 0) goto L73
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> L7d
            r8.a(r6)     // Catch: java.lang.Throwable -> L7d
        L73:
            boolean r6 = com.tencent.bugly.proguard.ae.f9183a     // Catch: java.lang.Throwable -> L7d
            if (r6 == 0) goto L9a
            if (r2 == 0) goto L9a
        L79:
            r2.close()     // Catch: java.lang.Throwable -> L7d
            goto L9a
        L7d:
            r6 = move-exception
            goto Lb0
        L7f:
            r6 = move-exception
            r2 = r0
        L81:
            boolean r7 = com.tencent.bugly.proguard.an.a(r6)     // Catch: java.lang.Throwable -> L9c
            if (r7 != 0) goto L8a
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L9c
        L8a:
            if (r8 == 0) goto L93
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> L7d
            r8.a(r6)     // Catch: java.lang.Throwable -> L7d
        L93:
            boolean r6 = com.tencent.bugly.proguard.ae.f9183a     // Catch: java.lang.Throwable -> L7d
            if (r6 == 0) goto L9a
            if (r2 == 0) goto L9a
            goto L79
        L9a:
            monitor-exit(r5)
            return r1
        L9c:
            r6 = move-exception
            if (r8 == 0) goto La6
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> L7d
            r8.a(r7)     // Catch: java.lang.Throwable -> L7d
        La6:
            boolean r7 = com.tencent.bugly.proguard.ae.f9183a     // Catch: java.lang.Throwable -> L7d
            if (r7 == 0) goto Laf
            if (r2 == 0) goto Laf
            r2.close()     // Catch: java.lang.Throwable -> L7d
        Laf:
            throw r6     // Catch: java.lang.Throwable -> L7d
        Lb0:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ae.a(int, java.lang.String, com.tencent.bugly.proguard.ad):boolean");
    }
}
