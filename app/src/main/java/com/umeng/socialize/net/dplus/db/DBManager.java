package com.umeng.socialize.net.dplus.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.umeng.socialize.utils.ContextUtil;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class DBManager {

    /* renamed from: a, reason: collision with root package name */
    private static DBManager f11805a;

    /* renamed from: b, reason: collision with root package name */
    private static StandardDBHelper f11806b;

    private DBManager() {
        f11806b = new StandardDBHelper(ContextUtil.getContext());
    }

    public static synchronized DBManager get(Context context) {
        if (f11805a == null) {
            f11805a = new DBManager();
        }
        return f11805a;
    }

    public synchronized void closeDatabase() {
        f11806b.close();
    }

    public synchronized void delete(ArrayList<Integer> arrayList, String str) {
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = f11806b.getWritableDatabase();
            writableDatabase.beginTransaction();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                writableDatabase.execSQL("delete from " + str + " where Id='" + arrayList.get(i2) + "' ");
            }
            writableDatabase.setTransactionSuccessful();
        } catch (Throwable unused) {
            if (writableDatabase != null) {
            }
        }
        if (writableDatabase != null) {
            try {
                writableDatabase.endTransaction();
            } catch (Throwable unused2) {
            }
        }
    }

    public synchronized void deleteTable(String str) {
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = f11806b.getWritableDatabase();
            writableDatabase.beginTransaction();
            writableDatabase.execSQL("DELETE FROM " + str + ";");
            writableDatabase.setTransactionSuccessful();
        } catch (Throwable unused) {
            if (writableDatabase != null) {
            }
        }
        if (writableDatabase != null) {
            try {
                writableDatabase.endTransaction();
            } catch (Throwable unused2) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0027 A[EXC_TOP_SPLITTER, PHI: r1
  0x0027: PHI (r1v2 android.database.sqlite.SQLiteDatabase) = (r1v1 android.database.sqlite.SQLiteDatabase), (r1v4 android.database.sqlite.SQLiteDatabase) binds: [B:13:0x002c, B:9:0x0025] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void insertAuth(org.json.JSONObject r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 != 0) goto L5
            monitor-exit(r4)
            return
        L5:
            r0 = 0
            com.umeng.socialize.net.dplus.db.StandardDBHelper r1 = com.umeng.socialize.net.dplus.db.DBManager.f11806b     // Catch: java.lang.Throwable -> L2b
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L2b
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L2c
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L2c
            r2.<init>()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r3 = "_json"
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L2c
            r2.put(r3, r5)     // Catch: java.lang.Throwable -> L2c
            java.lang.String r5 = "auth"
            r1.insert(r5, r0, r2)     // Catch: java.lang.Throwable -> L2c
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L2f
        L27:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L2f
            goto L2f
        L2b:
            r1 = r0
        L2c:
            if (r1 == 0) goto L2f
            goto L27
        L2f:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.db.DBManager.insertAuth(org.json.JSONObject):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0027 A[EXC_TOP_SPLITTER, PHI: r1
  0x0027: PHI (r1v2 android.database.sqlite.SQLiteDatabase) = (r1v1 android.database.sqlite.SQLiteDatabase), (r1v4 android.database.sqlite.SQLiteDatabase) binds: [B:13:0x002c, B:9:0x0025] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void insertDau(org.json.JSONObject r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 != 0) goto L5
            monitor-exit(r4)
            return
        L5:
            r0 = 0
            com.umeng.socialize.net.dplus.db.StandardDBHelper r1 = com.umeng.socialize.net.dplus.db.DBManager.f11806b     // Catch: java.lang.Throwable -> L2b
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L2b
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L2c
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L2c
            r2.<init>()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r3 = "_json"
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L2c
            r2.put(r3, r5)     // Catch: java.lang.Throwable -> L2c
            java.lang.String r5 = "dau"
            r1.insert(r5, r0, r2)     // Catch: java.lang.Throwable -> L2c
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L2f
        L27:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L2f
            goto L2f
        L2b:
            r1 = r0
        L2c:
            if (r1 == 0) goto L2f
            goto L27
        L2f:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.db.DBManager.insertDau(org.json.JSONObject):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0027 A[EXC_TOP_SPLITTER, PHI: r1
  0x0027: PHI (r1v2 android.database.sqlite.SQLiteDatabase) = (r1v1 android.database.sqlite.SQLiteDatabase), (r1v4 android.database.sqlite.SQLiteDatabase) binds: [B:13:0x002c, B:9:0x0025] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void insertS_E(org.json.JSONObject r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 != 0) goto L5
            monitor-exit(r4)
            return
        L5:
            r0 = 0
            com.umeng.socialize.net.dplus.db.StandardDBHelper r1 = com.umeng.socialize.net.dplus.db.DBManager.f11806b     // Catch: java.lang.Throwable -> L2b
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L2b
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L2c
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L2c
            r2.<init>()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r3 = "_json"
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L2c
            r2.put(r3, r5)     // Catch: java.lang.Throwable -> L2c
            java.lang.String r5 = "s_e"
            r1.insert(r5, r0, r2)     // Catch: java.lang.Throwable -> L2c
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L2f
        L27:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L2f
            goto L2f
        L2b:
            r1 = r0
        L2c:
            if (r1 == 0) goto L2f
            goto L27
        L2f:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.db.DBManager.insertS_E(org.json.JSONObject):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0027 A[EXC_TOP_SPLITTER, PHI: r1
  0x0027: PHI (r1v2 android.database.sqlite.SQLiteDatabase) = (r1v1 android.database.sqlite.SQLiteDatabase), (r1v4 android.database.sqlite.SQLiteDatabase) binds: [B:13:0x002c, B:9:0x0025] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void insertStats(org.json.JSONObject r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 != 0) goto L5
            monitor-exit(r4)
            return
        L5:
            r0 = 0
            com.umeng.socialize.net.dplus.db.StandardDBHelper r1 = com.umeng.socialize.net.dplus.db.DBManager.f11806b     // Catch: java.lang.Throwable -> L2b
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L2b
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L2c
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L2c
            r2.<init>()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r3 = "_json"
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L2c
            r2.put(r3, r5)     // Catch: java.lang.Throwable -> L2c
            java.lang.String r5 = "stats"
            r1.insert(r5, r0, r2)     // Catch: java.lang.Throwable -> L2c
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L2f
        L27:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L2f
            goto L2f
        L2b:
            r1 = r0
        L2c:
            if (r1 == 0) goto L2f
            goto L27
        L2f:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.db.DBManager.insertStats(org.json.JSONObject):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0027 A[EXC_TOP_SPLITTER, PHI: r1
  0x0027: PHI (r1v2 android.database.sqlite.SQLiteDatabase) = (r1v1 android.database.sqlite.SQLiteDatabase), (r1v4 android.database.sqlite.SQLiteDatabase) binds: [B:13:0x002c, B:9:0x0025] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void insertUserInfo(org.json.JSONObject r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 != 0) goto L5
            monitor-exit(r4)
            return
        L5:
            r0 = 0
            com.umeng.socialize.net.dplus.db.StandardDBHelper r1 = com.umeng.socialize.net.dplus.db.DBManager.f11806b     // Catch: java.lang.Throwable -> L2b
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L2b
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L2c
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L2c
            r2.<init>()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r3 = "_json"
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L2c
            r2.put(r3, r5)     // Catch: java.lang.Throwable -> L2c
            java.lang.String r5 = "userinfo"
            r1.insert(r5, r0, r2)     // Catch: java.lang.Throwable -> L2c
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L2f
        L27:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L2f
            goto L2f
        L2b:
            r1 = r0
        L2c:
            if (r1 == 0) goto L2f
            goto L27
        L2f:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.db.DBManager.insertUserInfo(org.json.JSONObject):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0068 A[Catch: all -> 0x0077, PHI: r3
  0x0068: PHI (r3v4 android.database.sqlite.SQLiteDatabase) = (r3v2 android.database.sqlite.SQLiteDatabase), (r3v6 android.database.sqlite.SQLiteDatabase) binds: [B:28:0x0074, B:21:0x0066] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0077, blocks: (B:20:0x0063, B:22:0x0068, B:27:0x0071), top: B:48:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized org.json.JSONArray select(java.lang.String r13, java.util.ArrayList<java.lang.Integer> r14, double r15, boolean r17) throws org.json.JSONException {
        /*
            r12 = this;
            r0 = r14
            monitor-enter(r12)
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L89
            r1.<init>()     // Catch: java.lang.Throwable -> L89
            r2 = 0
            com.umeng.socialize.net.dplus.db.StandardDBHelper r3 = com.umeng.socialize.net.dplus.db.DBManager.f11806b     // Catch: java.lang.Throwable -> L6e org.json.JSONException -> L79
            android.database.sqlite.SQLiteDatabase r3 = r3.getWritableDatabase()     // Catch: java.lang.Throwable -> L6e org.json.JSONException -> L79
            r3.beginTransaction()     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r4 = r3
            r5 = r13
            android.database.Cursor r2 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
        L1d:
            boolean r4 = r2.moveToNext()     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            if (r4 == 0) goto L5e
            r4 = 0
            int r4 = r2.getInt(r4)     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            r5 = 1
            java.lang.String r5 = r2.getString(r5)     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            if (r17 == 0) goto L44
            java.lang.String r6 = r1.toString()     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            byte[] r6 = r6.getBytes()     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            int r6 = r6.length     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            byte[] r7 = r5.getBytes()     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            int r7 = r7.length     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            int r6 = r6 + r7
            double r6 = (double) r6     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            int r8 = (r6 > r15 ? 1 : (r6 == r15 ? 0 : -1))
            if (r8 <= 0) goto L44
            goto L5e
        L44:
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            r6.<init>(r5)     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            r1.put(r6)     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            boolean r5 = r14.contains(r5)     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            if (r5 != 0) goto L1d
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            r14.add(r4)     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            goto L1d
        L5e:
            r3.setTransactionSuccessful()     // Catch: org.json.JSONException -> L6c java.lang.Throwable -> L6f
            if (r2 == 0) goto L66
            r2.close()     // Catch: java.lang.Throwable -> L77
        L66:
            if (r3 == 0) goto L77
        L68:
            r3.endTransaction()     // Catch: java.lang.Throwable -> L77
            goto L77
        L6c:
            r0 = move-exception
            goto L7b
        L6e:
            r3 = r2
        L6f:
            if (r2 == 0) goto L74
            r2.close()     // Catch: java.lang.Throwable -> L77
        L74:
            if (r3 == 0) goto L77
            goto L68
        L77:
            monitor-exit(r12)
            return r1
        L79:
            r0 = move-exception
            r3 = r2
        L7b:
            throw r0     // Catch: java.lang.Throwable -> L7c
        L7c:
            r0 = move-exception
            r1 = r0
            if (r2 == 0) goto L83
            r2.close()     // Catch: java.lang.Throwable -> L88
        L83:
            if (r3 == 0) goto L88
            r3.endTransaction()     // Catch: java.lang.Throwable -> L88
        L88:
            throw r1     // Catch: java.lang.Throwable -> L89
        L89:
            r0 = move-exception
            monitor-exit(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.db.DBManager.select(java.lang.String, java.util.ArrayList, double, boolean):org.json.JSONArray");
    }
}
