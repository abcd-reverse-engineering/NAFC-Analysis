package com.alibaba.sdk.android.httpdns.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class d extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f4006a = new Object();

    d(Context context) {
        super(context, "aliclound_httpdns.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    private long a(SQLiteDatabase sQLiteDatabase, g gVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("host_id", Long.valueOf(gVar.f4010i));
        contentValues.put("ip", gVar.o);
        contentValues.put(RemoteMessageConst.TTL, gVar.p);
        try {
            return sQLiteDatabase.insert("ip", null, contentValues);
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008d A[PHI: r10
  0x008d: PHI (r10v4 android.database.sqlite.SQLiteDatabase) = (r10v3 android.database.sqlite.SQLiteDatabase), (r10v5 android.database.sqlite.SQLiteDatabase) binds: [B:28:0x008b, B:13:0x0071] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.alibaba.sdk.android.httpdns.b.g> a(long r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r10 = r11.getWritableDatabase()     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L85
            java.lang.String r3 = "ip"
            r4 = 0
            java.lang.String r5 = "host_id=?"
            r2 = 1
            java.lang.String[] r6 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r2 = 0
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r6[r2] = r12     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r10
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            if (r1 == 0) goto L6c
            int r12 = r1.getCount()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            if (r12 <= 0) goto L6c
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
        L2c:
            com.alibaba.sdk.android.httpdns.b.g r12 = new com.alibaba.sdk.android.httpdns.b.g     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r12.<init>()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r13 = "id"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            int r13 = r1.getInt(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            long r2 = (long) r13     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r12.id = r2     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r13 = "host_id"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            int r13 = r1.getInt(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            long r2 = (long) r13     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r12.f4010i = r2     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r13 = "ip"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r13 = r1.getString(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r12.o = r13     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r13 = "ttl"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r13 = r1.getString(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r12.p = r13     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r0.add(r12)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            boolean r12 = r1.moveToNext()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            if (r12 != 0) goto L2c
        L6c:
            if (r1 == 0) goto L71
            r1.close()
        L71:
            if (r10 == 0) goto L90
            goto L8d
        L74:
            r12 = move-exception
            goto L7a
        L76:
            goto L86
        L78:
            r12 = move-exception
            r10 = r1
        L7a:
            if (r1 == 0) goto L7f
            r1.close()
        L7f:
            if (r10 == 0) goto L84
            r10.close()
        L84:
            throw r12
        L85:
            r10 = r1
        L86:
            if (r1 == 0) goto L8b
            r1.close()
        L8b:
            if (r10 == 0) goto L90
        L8d:
            r10.close()
        L90:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.b.d.a(long):java.util.List");
    }

    private List<g> a(e eVar) {
        return a(eVar.id);
    }

    /* renamed from: a, reason: collision with other method in class */
    private void m10a(long j2) {
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = getWritableDatabase();
            writableDatabase.delete(Constants.KEY_HOST, "id = ?", new String[]{String.valueOf(j2)});
            if (writableDatabase == null) {
                return;
            }
        } catch (Exception unused) {
            if (writableDatabase == null) {
                return;
            }
        } catch (Throwable th) {
            if (writableDatabase != null) {
                writableDatabase.close();
            }
            throw th;
        }
        writableDatabase.close();
    }

    private void a(g gVar) {
        m11b(gVar.id);
    }

    private long b(SQLiteDatabase sQLiteDatabase, g gVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("host_id", Long.valueOf(gVar.f4010i));
        contentValues.put("ip", gVar.o);
        contentValues.put(RemoteMessageConst.TTL, gVar.p);
        try {
            return sQLiteDatabase.insert("ipv6", null, contentValues);
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008d A[PHI: r10
  0x008d: PHI (r10v4 android.database.sqlite.SQLiteDatabase) = (r10v3 android.database.sqlite.SQLiteDatabase), (r10v5 android.database.sqlite.SQLiteDatabase) binds: [B:28:0x008b, B:13:0x0071] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.alibaba.sdk.android.httpdns.b.g> b(long r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r10 = r11.getWritableDatabase()     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L85
            java.lang.String r3 = "ipv6"
            r4 = 0
            java.lang.String r5 = "host_id=?"
            r2 = 1
            java.lang.String[] r6 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r2 = 0
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r6[r2] = r12     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r10
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            if (r1 == 0) goto L6c
            int r12 = r1.getCount()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            if (r12 <= 0) goto L6c
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
        L2c:
            com.alibaba.sdk.android.httpdns.b.g r12 = new com.alibaba.sdk.android.httpdns.b.g     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r12.<init>()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r13 = "id"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            int r13 = r1.getInt(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            long r2 = (long) r13     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r12.id = r2     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r13 = "host_id"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            int r13 = r1.getInt(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            long r2 = (long) r13     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r12.f4010i = r2     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r13 = "ip"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r13 = r1.getString(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r12.o = r13     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r13 = "ttl"
            int r13 = r1.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            java.lang.String r13 = r1.getString(r13)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r12.p = r13     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            r0.add(r12)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            boolean r12 = r1.moveToNext()     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L76
            if (r12 != 0) goto L2c
        L6c:
            if (r1 == 0) goto L71
            r1.close()
        L71:
            if (r10 == 0) goto L90
            goto L8d
        L74:
            r12 = move-exception
            goto L7a
        L76:
            goto L86
        L78:
            r12 = move-exception
            r10 = r1
        L7a:
            if (r1 == 0) goto L7f
            r1.close()
        L7f:
            if (r10 == 0) goto L84
            r10.close()
        L84:
            throw r12
        L85:
            r10 = r1
        L86:
            if (r1 == 0) goto L8b
            r1.close()
        L8b:
            if (r10 == 0) goto L90
        L8d:
            r10.close()
        L90:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.b.d.b(long):java.util.List");
    }

    private List<g> b(e eVar) {
        return b(eVar.id);
    }

    /* renamed from: b, reason: collision with other method in class */
    private void m11b(long j2) {
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = getWritableDatabase();
            writableDatabase.delete("ip", "id = ?", new String[]{String.valueOf(j2)});
            if (writableDatabase == null) {
                return;
            }
        } catch (Exception unused) {
            if (writableDatabase == null) {
                return;
            }
        } catch (Throwable th) {
            if (writableDatabase != null) {
                writableDatabase.close();
            }
            throw th;
        }
        writableDatabase.close();
    }

    private void b(g gVar) {
        c(gVar.id);
    }

    private void c(long j2) {
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = getWritableDatabase();
            writableDatabase.delete("ipv6", "id = ?", new String[]{String.valueOf(j2)});
            if (writableDatabase == null) {
                return;
            }
        } catch (Exception unused) {
            if (writableDatabase == null) {
                return;
            }
        } catch (Throwable th) {
            if (writableDatabase != null) {
                writableDatabase.close();
            }
            throw th;
        }
        writableDatabase.close();
    }

    private void c(e eVar) {
        m10a(eVar.id);
    }

    /* renamed from: a, reason: collision with other method in class */
    long m12a(e eVar) {
        SQLiteDatabase writableDatabase;
        synchronized (f4006a) {
            b(eVar.f4009m, eVar.host);
            ContentValues contentValues = new ContentValues();
            try {
                writableDatabase = getWritableDatabase();
                try {
                    writableDatabase.beginTransaction();
                    contentValues.put(Constants.KEY_HOST, eVar.host);
                    contentValues.put("sp", eVar.f4009m);
                    contentValues.put("time", c.c(eVar.n));
                    contentValues.put("extra", eVar.f4007a);
                    contentValues.put("cache_key", eVar.f4008b);
                    long jInsert = writableDatabase.insert(Constants.KEY_HOST, null, contentValues);
                    eVar.id = jInsert;
                    if (eVar.f7a != null) {
                        Iterator<g> it = eVar.f7a.iterator();
                        while (it.hasNext()) {
                            g next = it.next();
                            next.f4010i = jInsert;
                            next.id = a(writableDatabase, next);
                        }
                    }
                    if (eVar.f8b != null) {
                        Iterator<g> it2 = eVar.f8b.iterator();
                        while (it2.hasNext()) {
                            g next2 = it2.next();
                            next2.f4010i = jInsert;
                            next2.id = b(writableDatabase, next2);
                        }
                    }
                    writableDatabase.setTransactionSuccessful();
                    if (writableDatabase != null) {
                        writableDatabase.endTransaction();
                        writableDatabase.close();
                    }
                    return jInsert;
                } catch (Exception unused) {
                    if (writableDatabase != null) {
                        writableDatabase.endTransaction();
                        writableDatabase.close();
                    }
                    return 0L;
                } catch (Throwable th) {
                    th = th;
                    if (writableDatabase != null) {
                        writableDatabase.endTransaction();
                        writableDatabase.close();
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                writableDatabase = null;
            } catch (Throwable th2) {
                th = th2;
                writableDatabase = null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.alibaba.sdk.android.httpdns.b.e a(java.lang.String r12, java.lang.String r13) {
        /*
            r11 = this;
            java.lang.Object r0 = com.alibaba.sdk.android.httpdns.b.d.f4006a
            monitor-enter(r0)
            r1 = 0
            android.database.sqlite.SQLiteDatabase r10 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> Lb2
            java.lang.String r3 = "host"
            r4 = 0
            java.lang.String r5 = "sp=? AND host=?"
            r2 = 2
            java.lang.String[] r6 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La1
            r2 = 0
            r6[r2] = r12     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La1
            r12 = 1
            r6[r12] = r13     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La1
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r10
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La1
            if (r12 == 0) goto L92
            int r13 = r12.getCount()     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            if (r13 <= 0) goto L92
            r12.moveToFirst()     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            com.alibaba.sdk.android.httpdns.b.e r13 = new com.alibaba.sdk.android.httpdns.b.e     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            r13.<init>()     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            java.lang.String r1 = "id"
            int r1 = r12.getColumnIndex(r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            int r1 = r12.getInt(r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            long r1 = (long) r1     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            r13.id = r1     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.lang.String r1 = "host"
            int r1 = r12.getColumnIndex(r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.lang.String r1 = r12.getString(r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            r13.host = r1     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.lang.String r1 = "sp"
            int r1 = r12.getColumnIndex(r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.lang.String r1 = r12.getString(r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            r13.f4009m = r1     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.lang.String r1 = "time"
            int r1 = r12.getColumnIndex(r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.lang.String r1 = r12.getString(r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.lang.String r1 = com.alibaba.sdk.android.httpdns.b.c.d(r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            r13.n = r1     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.util.List r1 = r11.a(r13)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            r13.f7a = r1     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.util.List r1 = r11.b(r13)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            r13.f8b = r1     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.lang.String r1 = "extra"
            int r1 = r12.getColumnIndex(r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.lang.String r1 = r12.getString(r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            r13.f4007a = r1     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.lang.String r1 = "cache_key"
            int r1 = r12.getColumnIndex(r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.lang.String r1 = r12.getString(r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            r13.f4008b = r1     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            goto L93
        L8c:
            goto Lb5
        L8e:
            r13 = move-exception
            goto La7
        L90:
            r13 = r1
            goto Lb5
        L92:
            r13 = r1
        L93:
            if (r12 == 0) goto L98
            r12.close()     // Catch: java.lang.Throwable -> Lbb
        L98:
            if (r10 == 0) goto Lc0
        L9a:
            r10.close()     // Catch: java.lang.Throwable -> Lbb
            goto Lc0
        L9e:
            r13 = move-exception
            r12 = r1
            goto La7
        La1:
            r12 = r1
            r13 = r12
            goto Lb5
        La4:
            r13 = move-exception
            r12 = r1
            r10 = r12
        La7:
            if (r12 == 0) goto Lac
            r12.close()     // Catch: java.lang.Throwable -> Lbb
        Lac:
            if (r10 == 0) goto Lb1
            r10.close()     // Catch: java.lang.Throwable -> Lbb
        Lb1:
            throw r13     // Catch: java.lang.Throwable -> Lbb
        Lb2:
            r12 = r1
            r13 = r12
            r10 = r13
        Lb5:
            if (r12 == 0) goto Lbd
            r12.close()     // Catch: java.lang.Throwable -> Lbb
            goto Lbd
        Lbb:
            r12 = move-exception
            goto Lc2
        Lbd:
            if (r10 == 0) goto Lc0
            goto L9a
        Lc0:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lbb
            return r13
        Lc2:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lbb
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.b.d.a(java.lang.String, java.lang.String):com.alibaba.sdk.android.httpdns.b.e");
    }

    List<e> b() {
        ArrayList arrayList;
        SQLiteDatabase readableDatabase;
        synchronized (f4006a) {
            arrayList = new ArrayList();
            Cursor cursorQuery = null;
            try {
                readableDatabase = getReadableDatabase();
            } catch (Exception unused) {
                readableDatabase = null;
            } catch (Throwable th) {
                th = th;
                readableDatabase = null;
            }
            try {
                cursorQuery = readableDatabase.query(Constants.KEY_HOST, null, null, null, null, null, null);
                if (cursorQuery != null && cursorQuery.getCount() > 0) {
                    cursorQuery.moveToFirst();
                    do {
                        e eVar = new e();
                        eVar.id = cursorQuery.getInt(cursorQuery.getColumnIndex("id"));
                        eVar.host = cursorQuery.getString(cursorQuery.getColumnIndex(Constants.KEY_HOST));
                        eVar.f4009m = cursorQuery.getString(cursorQuery.getColumnIndex("sp"));
                        eVar.n = c.d(cursorQuery.getString(cursorQuery.getColumnIndex("time")));
                        eVar.f7a = (ArrayList) a(eVar);
                        eVar.f8b = (ArrayList) b(eVar);
                        eVar.f4007a = cursorQuery.getString(cursorQuery.getColumnIndex("extra"));
                        eVar.f4008b = cursorQuery.getString(cursorQuery.getColumnIndex("cache_key"));
                        arrayList.add(eVar);
                    } while (cursorQuery.moveToNext());
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception unused2) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (readableDatabase != null) {
                    readableDatabase.close();
                }
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (readableDatabase != null) {
                    readableDatabase.close();
                }
                throw th;
            }
            if (readableDatabase != null) {
                readableDatabase.close();
            }
        }
        return arrayList;
    }

    void b(String str, String str2) {
        synchronized (f4006a) {
            e eVarA = a(str, str2);
            if (eVarA != null) {
                c(eVarA);
                if (eVarA.f7a != null) {
                    Iterator<g> it = eVarA.f7a.iterator();
                    while (it.hasNext()) {
                        a(it.next());
                    }
                }
                if (eVarA.f8b != null) {
                    Iterator<g> it2 = eVarA.f8b.iterator();
                    while (it2.hasNext()) {
                        b(it2.next());
                    }
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE host (id INTEGER PRIMARY KEY,host TEXT,sp TEXT,time TEXT,extra TEXT,cache_key TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE ip (id INTEGER PRIMARY KEY,host_id INTEGER,ip TEXT,ttl TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE ipv6 (id INTEGER PRIMARY KEY,host_id INTEGER,ip TEXT,ttl TEXT);");
        } catch (Exception unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) throws SQLException {
        if (i2 != i3) {
            try {
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS host;");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ip;");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ipv6;");
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                onCreate(sQLiteDatabase);
            } catch (Exception unused) {
            }
        }
    }
}
