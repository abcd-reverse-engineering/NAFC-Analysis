package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.e;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: UMStoreManager.java */
/* loaded from: classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public static final int f10404a = 2049;

    /* renamed from: b, reason: collision with root package name */
    public static final int f10405b = 2050;

    /* renamed from: c, reason: collision with root package name */
    private static final int f10406c = 1000;

    /* renamed from: d, reason: collision with root package name */
    private static Context f10407d = null;

    /* renamed from: e, reason: collision with root package name */
    private static String f10408e = null;

    /* renamed from: f, reason: collision with root package name */
    private static final String f10409f = "umeng+";

    /* renamed from: g, reason: collision with root package name */
    private static final String f10410g = "ek__id";

    /* renamed from: h, reason: collision with root package name */
    private static final String f10411h = "ek_key";

    /* renamed from: i, reason: collision with root package name */
    private List<String> f10412i;

    /* renamed from: j, reason: collision with root package name */
    private List<Integer> f10413j;

    /* renamed from: k, reason: collision with root package name */
    private String f10414k;

    /* renamed from: l, reason: collision with root package name */
    private List<String> f10415l;

    /* compiled from: UMStoreManager.java */
    public enum a {
        AUTOPAGE,
        PAGE,
        BEGIN,
        END,
        NEWSESSION,
        INSTANTSESSIONBEGIN
    }

    /* compiled from: UMStoreManager.java */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final i f10423a = new i();

        private b() {
        }
    }

    public static i a(Context context) {
        i iVar = b.f10423a;
        if (f10407d == null && context != null) {
            f10407d = context.getApplicationContext();
            iVar.k();
        }
        return iVar;
    }

    private void k() {
        synchronized (this) {
            l();
            this.f10412i.clear();
            this.f10415l.clear();
            this.f10413j.clear();
        }
    }

    private void l() {
        try {
            if (TextUtils.isEmpty(f10408e)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(f10407d, f10410g);
                if (TextUtils.isEmpty(multiProcessSP)) {
                    multiProcessSP = PreferenceWrapper.getDefault(f10407d).getString(f10410g, null);
                    if (TextUtils.isEmpty(multiProcessSP)) {
                        multiProcessSP = UMUtils.genId();
                    }
                    if (!TextUtils.isEmpty(multiProcessSP)) {
                        UMUtils.setMultiProcessSP(f10407d, f10410g, multiProcessSP);
                    }
                }
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    String strSubstring = multiProcessSP.substring(1, 9);
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < strSubstring.length(); i2++) {
                        char cCharAt = strSubstring.charAt(i2);
                        if (!Character.isDigit(cCharAt)) {
                            sb.append(cCharAt);
                        } else if (Integer.parseInt(Character.toString(cCharAt)) == 0) {
                            sb.append(0);
                        } else {
                            sb.append(10 - Integer.parseInt(Character.toString(cCharAt)));
                        }
                    }
                    f10408e = sb.toString();
                }
                if (TextUtils.isEmpty(f10408e)) {
                    return;
                }
                f10408e += new StringBuilder(f10408e).reverse().toString();
                String multiProcessSP2 = UMUtils.getMultiProcessSP(f10407d, f10411h);
                if (TextUtils.isEmpty(multiProcessSP2)) {
                    UMUtils.setMultiProcessSP(f10407d, f10411h, c(f10409f));
                } else {
                    if (f10409f.equals(d(multiProcessSP2))) {
                        return;
                    }
                    b(true, false);
                    a(true, false);
                    h();
                    i();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void b() {
        this.f10415l.clear();
    }

    public boolean c() {
        return this.f10415l.isEmpty();
    }

    public void d() {
        String strC;
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = g.a(f10407d).a();
                sQLiteDatabaseA.beginTransaction();
                strC = u.a().c();
            } catch (SQLiteDatabaseCorruptException unused) {
                h.a(f10407d);
                if (sQLiteDatabaseA != null) {
                }
            } catch (Throwable unused2) {
                if (sQLiteDatabaseA != null) {
                }
            }
            if (TextUtils.isEmpty(strC)) {
                return;
            }
            for (String str : new String[]{"", "-1"}) {
                sQLiteDatabaseA.execSQL("update __et set __i=\"" + strC + "\" where __i=\"" + str + "\"");
            }
            sQLiteDatabaseA.setTransactionSuccessful();
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused3) {
                }
            }
            g.a(f10407d).b();
        } finally {
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused4) {
                }
            }
            g.a(f10407d).b();
        }
    }

    public boolean e() {
        return this.f10412i.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0088 A[EXC_TOP_SPLITTER, PHI: r2 r5
  0x0088: PHI (r2v5 android.database.sqlite.SQLiteDatabase) = (r2v4 android.database.sqlite.SQLiteDatabase), (r2v6 android.database.sqlite.SQLiteDatabase) binds: [B:28:0x0086, B:35:0x00a1] A[DONT_GENERATE, DONT_INLINE]
  0x0088: PHI (r5v3 org.json.JSONObject) = (r5v2 org.json.JSONObject), (r5v5 org.json.JSONObject) binds: [B:28:0x0086, B:35:0x00a1] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v11, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16, types: [org.json.JSONObject] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject f() {
        /*
            r14 = this;
            java.lang.String r0 = "__vc"
            java.lang.String r1 = "__av"
            java.util.List<java.lang.String> r2 = r14.f10415l
            boolean r2 = r2.isEmpty()
            r3 = 0
            if (r2 == 0) goto Le
            return r3
        Le:
            android.content.Context r2 = com.umeng.analytics.pro.i.f10407d     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteDatabaseCorruptException -> L95
            com.umeng.analytics.pro.g r2 = com.umeng.analytics.pro.g.a(r2)     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteDatabaseCorruptException -> L95
            android.database.sqlite.SQLiteDatabase r2 = r2.a()     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteDatabaseCorruptException -> L95
            r2.beginTransaction()     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            java.util.List<java.lang.String> r4 = r14.f10415l     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            r5 = 0
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            java.lang.String r6 = "__is"
            r7 = 0
            java.lang.String r8 = "__ii=? "
            r9 = 1
            java.lang.String[] r9 = new java.lang.String[r9]     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            r9[r5] = r4     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r4 = r14
            r5 = r6
            r6 = r2
            android.database.Cursor r4 = r4.a(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            if (r4 == 0) goto L5d
            boolean r5 = r4.moveToNext()     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            if (r5 == 0) goto L5d
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r5.<init>()     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            int r3 = r4.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteDatabaseCorruptException -> L79
            java.lang.String r3 = r4.getString(r3)     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteDatabaseCorruptException -> L79
            int r6 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteDatabaseCorruptException -> L79
            java.lang.String r6 = r4.getString(r6)     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteDatabaseCorruptException -> L79
            r5.put(r1, r3)     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteDatabaseCorruptException -> L79
            r5.put(r0, r6)     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteDatabaseCorruptException -> L79
            r3 = r5
        L5d:
            r2.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            if (r4 == 0) goto L65
            r4.close()
        L65:
            if (r2 == 0) goto L6a
            r2.endTransaction()     // Catch: java.lang.Throwable -> L6a
        L6a:
            android.content.Context r0 = com.umeng.analytics.pro.i.f10407d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            r5 = r3
            goto La4
        L75:
            r5 = r3
        L76:
            r3 = r4
            goto L81
        L78:
            r5 = r3
        L79:
            r3 = r4
            goto L97
        L7b:
            r5 = r3
            goto L81
        L7d:
            r5 = r3
            goto L97
        L7f:
            r2 = r3
            r5 = r2
        L81:
            if (r3 == 0) goto L86
            r3.close()
        L86:
            if (r2 == 0) goto L8b
        L88:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L8b
        L8b:
            android.content.Context r0 = com.umeng.analytics.pro.i.f10407d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto La4
        L95:
            r2 = r3
            r5 = r2
        L97:
            android.content.Context r0 = com.umeng.analytics.pro.i.f10407d     // Catch: java.lang.Throwable -> La5
            com.umeng.analytics.pro.h.a(r0)     // Catch: java.lang.Throwable -> La5
            if (r3 == 0) goto La1
            r3.close()
        La1:
            if (r2 == 0) goto L8b
            goto L88
        La4:
            return r5
        La5:
            r0 = move-exception
            if (r3 == 0) goto Lab
            r3.close()
        Lab:
            if (r2 == 0) goto Lb0
            r2.endTransaction()     // Catch: java.lang.Throwable -> Lb0
        Lb0:
            android.content.Context r1 = com.umeng.analytics.pro.i.f10407d
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)
            r1.b()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.f():org.json.JSONObject");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0088 A[EXC_TOP_SPLITTER, PHI: r2 r5
  0x0088: PHI (r2v5 android.database.sqlite.SQLiteDatabase) = (r2v4 android.database.sqlite.SQLiteDatabase), (r2v6 android.database.sqlite.SQLiteDatabase) binds: [B:28:0x0086, B:35:0x00a1] A[DONT_GENERATE, DONT_INLINE]
  0x0088: PHI (r5v3 org.json.JSONObject) = (r5v2 org.json.JSONObject), (r5v5 org.json.JSONObject) binds: [B:28:0x0086, B:35:0x00a1] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v11, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16, types: [org.json.JSONObject] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject g() {
        /*
            r14 = this;
            java.lang.String r0 = "__vc"
            java.lang.String r1 = "__av"
            java.util.List<java.lang.String> r2 = r14.f10412i
            boolean r2 = r2.isEmpty()
            r3 = 0
            if (r2 == 0) goto Le
            return r3
        Le:
            android.content.Context r2 = com.umeng.analytics.pro.i.f10407d     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteDatabaseCorruptException -> L95
            com.umeng.analytics.pro.g r2 = com.umeng.analytics.pro.g.a(r2)     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteDatabaseCorruptException -> L95
            android.database.sqlite.SQLiteDatabase r2 = r2.a()     // Catch: java.lang.Throwable -> L7f android.database.sqlite.SQLiteDatabaseCorruptException -> L95
            r2.beginTransaction()     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            java.util.List<java.lang.String> r4 = r14.f10412i     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            r5 = 0
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            java.lang.String r6 = "__sd"
            r7 = 0
            java.lang.String r8 = "__ii=? "
            r9 = 1
            java.lang.String[] r9 = new java.lang.String[r9]     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            r9[r5] = r4     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r4 = r14
            r5 = r6
            r6 = r2
            android.database.Cursor r4 = r4.a(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L7d
            if (r4 == 0) goto L5d
            boolean r5 = r4.moveToNext()     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            if (r5 == 0) goto L5d
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r5.<init>()     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            int r3 = r4.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteDatabaseCorruptException -> L79
            java.lang.String r3 = r4.getString(r3)     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteDatabaseCorruptException -> L79
            int r6 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteDatabaseCorruptException -> L79
            java.lang.String r6 = r4.getString(r6)     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteDatabaseCorruptException -> L79
            r5.put(r1, r3)     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteDatabaseCorruptException -> L79
            r5.put(r0, r6)     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteDatabaseCorruptException -> L79
            r3 = r5
        L5d:
            r2.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            if (r4 == 0) goto L65
            r4.close()
        L65:
            if (r2 == 0) goto L6a
            r2.endTransaction()     // Catch: java.lang.Throwable -> L6a
        L6a:
            android.content.Context r0 = com.umeng.analytics.pro.i.f10407d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            r5 = r3
            goto La4
        L75:
            r5 = r3
        L76:
            r3 = r4
            goto L81
        L78:
            r5 = r3
        L79:
            r3 = r4
            goto L97
        L7b:
            r5 = r3
            goto L81
        L7d:
            r5 = r3
            goto L97
        L7f:
            r2 = r3
            r5 = r2
        L81:
            if (r3 == 0) goto L86
            r3.close()
        L86:
            if (r2 == 0) goto L8b
        L88:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L8b
        L8b:
            android.content.Context r0 = com.umeng.analytics.pro.i.f10407d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto La4
        L95:
            r2 = r3
            r5 = r2
        L97:
            android.content.Context r0 = com.umeng.analytics.pro.i.f10407d     // Catch: java.lang.Throwable -> La5
            com.umeng.analytics.pro.h.a(r0)     // Catch: java.lang.Throwable -> La5
            if (r3 == 0) goto La1
            r3.close()
        La1:
            if (r2 == 0) goto L8b
            goto L88
        La4:
            return r5
        La5:
            r0 = move-exception
            if (r3 == 0) goto Lab
            r3.close()
        Lab:
            if (r2 == 0) goto Lb0
            r2.endTransaction()     // Catch: java.lang.Throwable -> Lb0
        Lb0:
            android.content.Context r1 = com.umeng.analytics.pro.i.f10407d
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)
            r1.b()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.g():org.json.JSONObject");
    }

    public void h() {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = g.a(f10407d).a();
                sQLiteDatabaseA.beginTransaction();
                if (this.f10413j.size() > 0) {
                    for (int i2 = 0; i2 < this.f10413j.size(); i2++) {
                        sQLiteDatabaseA.execSQL("delete from __et where rowid=" + this.f10413j.get(i2));
                    }
                }
                this.f10413j.clear();
                sQLiteDatabaseA.setTransactionSuccessful();
            } catch (SQLiteDatabaseCorruptException unused) {
                h.a(f10407d);
                if (sQLiteDatabaseA != null) {
                }
            } catch (Throwable unused2) {
                if (sQLiteDatabaseA != null) {
                }
            }
        } finally {
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused3) {
                }
            }
            g.a(f10407d).b();
        }
    }

    public void i() {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = g.a(f10407d).a();
                sQLiteDatabaseA.beginTransaction();
                sQLiteDatabaseA.execSQL("delete from __er");
                sQLiteDatabaseA.setTransactionSuccessful();
            } catch (SQLiteDatabaseCorruptException unused) {
                h.a(f10407d);
                if (sQLiteDatabaseA != null) {
                }
            } catch (Throwable unused2) {
                if (sQLiteDatabaseA != null) {
                }
            }
        } finally {
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused3) {
                }
            }
            g.a(f10407d).b();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0053 A[EXC_TOP_SPLITTER, PHI: r1
  0x0053: PHI (r1v8 android.database.sqlite.SQLiteDatabase) = 
  (r1v4 android.database.sqlite.SQLiteDatabase)
  (r1v5 android.database.sqlite.SQLiteDatabase)
  (r1v11 android.database.sqlite.SQLiteDatabase)
 binds: [B:9:0x0051, B:14:0x0066, B:6:0x004d] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j() {
        /*
            r5 = this;
            java.lang.String r0 = "\""
            java.lang.String r1 = r5.f10414k
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 0
            if (r1 != 0) goto L79
            android.content.Context r1 = com.umeng.analytics.pro.i.f10407d     // Catch: java.lang.Throwable -> L50 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L50 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch: java.lang.Throwable -> L50 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            r3.<init>()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            java.lang.String r4 = "delete from __er where __i=\""
            r3.append(r4)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            java.lang.String r4 = r5.f10414k     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            r3.append(r4)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            r3.append(r0)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            r1.execSQL(r3)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            r3.<init>()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            java.lang.String r4 = "delete from __et where __i=\""
            r3.append(r4)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            java.lang.String r4 = r5.f10414k     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            r3.append(r4)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            r3.append(r0)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            r1.execSQL(r0)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            if (r1 == 0) goto L56
            goto L53
        L50:
            r1 = r2
        L51:
            if (r1 == 0) goto L56
        L53:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L56
        L56:
            android.content.Context r0 = com.umeng.analytics.pro.i.f10407d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto L79
        L60:
            r1 = r2
        L61:
            android.content.Context r0 = com.umeng.analytics.pro.i.f10407d     // Catch: java.lang.Throwable -> L69
            com.umeng.analytics.pro.h.a(r0)     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L56
            goto L53
        L69:
            r0 = move-exception
            if (r1 == 0) goto L6f
            r1.endTransaction()     // Catch: java.lang.Throwable -> L6f
        L6f:
            android.content.Context r1 = com.umeng.analytics.pro.i.f10407d
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)
            r1.b()
            throw r0
        L79:
            r5.f10414k = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.j():void");
    }

    private i() {
        this.f10412i = new ArrayList();
        this.f10413j = new ArrayList();
        this.f10414k = null;
        this.f10415l = new ArrayList();
    }

    private void b(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long jLongValue = ((Long) jSONObject.get("__e")).longValue();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("__pp");
            String strC = "";
            String strC2 = (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.length() <= 0) ? "" : c(jSONObjectOptJSONObject.toString());
            if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.length() > 0) {
                strC = c(jSONObjectOptJSONObject2.toString());
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("__ii", str);
            contentValues.put("__e", String.valueOf(jLongValue));
            contentValues.put("__sp", strC2);
            contentValues.put("__pp", strC);
            contentValues.put("__av", UMGlobalContext.getInstance(f10407d).getAppVersion());
            contentValues.put("__vc", UMUtils.getAppVersionCode(f10407d));
            sQLiteDatabase.insert(e.c.f10358a, null, contentValues);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(java.lang.String r20, org.json.JSONObject r21, android.database.sqlite.SQLiteDatabase r22) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.c(java.lang.String, org.json.JSONObject, android.database.sqlite.SQLiteDatabase):void");
    }

    private Cursor a(String str, SQLiteDatabase sQLiteDatabase, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        if (sQLiteDatabase == null) {
            return null;
        }
        try {
            if (sQLiteDatabase.isOpen()) {
                return sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a() {
        this.f10412i.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0090, code lost:
    
        if (r3 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0096, code lost:
    
        if (r3 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0098, code lost:
    
        r3.endTransaction();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(org.json.JSONArray r11) {
        /*
            r10 = this;
            java.lang.String r0 = "__t"
            java.lang.String r1 = "__i"
            r2 = 0
            android.content.Context r3 = com.umeng.analytics.pro.i.f10407d     // Catch: java.lang.Throwable -> L95 android.database.sqlite.SQLiteDatabaseCorruptException -> La5
            com.umeng.analytics.pro.g r3 = com.umeng.analytics.pro.g.a(r3)     // Catch: java.lang.Throwable -> L95 android.database.sqlite.SQLiteDatabaseCorruptException -> La5
            android.database.sqlite.SQLiteDatabase r3 = r3.a()     // Catch: java.lang.Throwable -> L95 android.database.sqlite.SQLiteDatabaseCorruptException -> La5
            r3.beginTransaction()     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> L93 java.lang.Throwable -> L96
            r4 = 0
        L13:
            int r5 = r11.length()     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> L93 java.lang.Throwable -> L96
            if (r4 >= r5) goto L8d
            org.json.JSONObject r5 = r11.getJSONObject(r4)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            r6.<init>()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            java.lang.String r7 = r5.optString(r1)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            java.lang.String r9 = "-1"
            if (r8 != 0) goto L34
            boolean r8 = r9.equals(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            if (r8 == 0) goto L43
        L34:
            com.umeng.analytics.pro.u r7 = com.umeng.analytics.pro.u.a()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            java.lang.String r7 = r7.b()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            if (r8 == 0) goto L43
            r7 = r9
        L43:
            r6.put(r1, r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            java.lang.String r7 = "__e"
            java.lang.String r8 = "id"
            java.lang.String r8 = r5.optString(r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            r6.put(r7, r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            int r7 = r5.optInt(r0)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            r6.put(r0, r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            java.lang.String r7 = "__av"
            android.content.Context r8 = com.umeng.analytics.pro.i.f10407d     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            r6.put(r7, r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            java.lang.String r7 = "__vc"
            android.content.Context r8 = com.umeng.analytics.pro.i.f10407d     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            r6.put(r7, r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            r5.remove(r1)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            r5.remove(r0)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            java.lang.String r7 = "__s"
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            java.lang.String r5 = r10.c(r5)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            r6.put(r7, r5)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
            java.lang.String r5 = "__et"
            r3.insert(r5, r2, r6)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L96
        L8a:
            int r4 = r4 + 1
            goto L13
        L8d:
            r3.setTransactionSuccessful()     // Catch: android.database.sqlite.SQLiteDatabaseCorruptException -> L93 java.lang.Throwable -> L96
            if (r3 == 0) goto L9b
            goto L98
        L93:
            r2 = r3
            goto La5
        L95:
            r3 = r2
        L96:
            if (r3 == 0) goto L9b
        L98:
            r3.endTransaction()     // Catch: java.lang.Throwable -> L9b
        L9b:
            android.content.Context r11 = com.umeng.analytics.pro.i.f10407d
            com.umeng.analytics.pro.g r11 = com.umeng.analytics.pro.g.a(r11)
            r11.b()
            goto Lb0
        La5:
            android.content.Context r11 = com.umeng.analytics.pro.i.f10407d     // Catch: java.lang.Throwable -> Lb1
            com.umeng.analytics.pro.h.a(r11)     // Catch: java.lang.Throwable -> Lb1
            if (r2 == 0) goto L9b
            r2.endTransaction()     // Catch: java.lang.Throwable -> L9b
            goto L9b
        Lb0:
            return
        Lb1:
            r11 = move-exception
            if (r2 == 0) goto Lb7
            r2.endTransaction()     // Catch: java.lang.Throwable -> Lb7
        Lb7:
            android.content.Context r0 = com.umeng.analytics.pro.i.f10407d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(org.json.JSONArray):void");
    }

    public JSONObject b(boolean z) {
        JSONObject jSONObject = new JSONObject();
        b(jSONObject, z);
        return jSONObject;
    }

    public String d(String str) {
        try {
            return TextUtils.isEmpty(f10408e) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f10408e.getBytes()));
        } catch (Exception unused) {
            if (Build.VERSION.SDK_INT >= 29 && !TextUtils.isEmpty(str)) {
                try {
                    new JSONObject(str);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> UMStoreManager decrypt failed, return origin data.");
                    return str;
                } catch (Throwable unused2) {
                    return null;
                }
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0098 A[PHI: r0 r1
  0x0098: PHI (r0v4 android.database.Cursor) = (r0v2 android.database.Cursor), (r0v3 android.database.Cursor), (r0v5 android.database.Cursor) binds: [B:28:0x0085, B:34:0x0093, B:35:0x0095] A[DONT_GENERATE, DONT_INLINE]
  0x0098: PHI (r1v5 android.database.sqlite.SQLiteDatabase) = 
  (r1v3 android.database.sqlite.SQLiteDatabase)
  (r1v4 android.database.sqlite.SQLiteDatabase)
  (r1v6 android.database.sqlite.SQLiteDatabase)
 binds: [B:28:0x0085, B:34:0x0093, B:35:0x0095] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0095 A[EXC_TOP_SPLITTER, PHI: r0 r1
  0x0095: PHI (r0v5 android.database.Cursor) = (r0v2 android.database.Cursor), (r0v3 android.database.Cursor), (r0v8 android.database.Cursor) binds: [B:28:0x0085, B:34:0x0093, B:22:0x0077] A[DONT_GENERATE, DONT_INLINE]
  0x0095: PHI (r1v6 android.database.sqlite.SQLiteDatabase) = 
  (r1v3 android.database.sqlite.SQLiteDatabase)
  (r1v4 android.database.sqlite.SQLiteDatabase)
  (r1v9 android.database.sqlite.SQLiteDatabase)
 binds: [B:28:0x0085, B:34:0x0093, B:22:0x0077] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(org.json.JSONObject r13, java.lang.String r14) {
        /*
            r12 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.f10407d     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L88
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L88
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteDatabaseCorruptException -> L88
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            boolean r2 = android.text.TextUtils.isEmpty(r14)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            if (r2 != 0) goto L2a
            java.lang.String r3 = "__er"
            r5 = 0
            java.lang.String r6 = "__i=? "
            r2 = 1
            java.lang.String[] r7 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            r2 = 0
            r7[r2] = r14     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r2 = r12
            r4 = r1
            android.database.Cursor r14 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            goto L39
        L2a:
            java.lang.String r3 = "__er"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r2 = r12
            r4 = r1
            android.database.Cursor r14 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
        L39:
            r0 = r14
            if (r0 == 0) goto L6f
            org.json.JSONArray r14 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            r14.<init>()     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
        L41:
            boolean r2 = r0.moveToNext()     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            if (r2 == 0) goto L64
            java.lang.String r2 = "__a"
            int r2 = r0.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            java.lang.String r2 = r0.getString(r2)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            if (r3 != 0) goto L41
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            java.lang.String r2 = r12.d(r2)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            r14.put(r3)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            goto L41
        L64:
            int r2 = r14.length()     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            if (r2 <= 0) goto L6f
            java.lang.String r2 = "error"
            r13.put(r2, r14)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
        L6f:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteDatabaseCorruptException -> L89
            if (r0 == 0) goto L77
            r0.close()
        L77:
            if (r1 == 0) goto L98
            goto L95
        L7a:
            r1 = r0
        L7b:
            android.content.Context r13 = com.umeng.analytics.pro.i.f10407d     // Catch: java.lang.Throwable -> La2
            com.umeng.analytics.pro.h.a(r13)     // Catch: java.lang.Throwable -> La2
            if (r0 == 0) goto L85
            r0.close()
        L85:
            if (r1 == 0) goto L98
            goto L95
        L88:
            r1 = r0
        L89:
            android.content.Context r13 = com.umeng.analytics.pro.i.f10407d     // Catch: java.lang.Throwable -> La2
            com.umeng.analytics.pro.h.a(r13)     // Catch: java.lang.Throwable -> La2
            if (r0 == 0) goto L93
            r0.close()
        L93:
            if (r1 == 0) goto L98
        L95:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L98
        L98:
            android.content.Context r13 = com.umeng.analytics.pro.i.f10407d
            com.umeng.analytics.pro.g r13 = com.umeng.analytics.pro.g.a(r13)
            r13.b()
            return
        La2:
            r13 = move-exception
            if (r0 == 0) goto La8
            r0.close()
        La8:
            if (r1 == 0) goto Lad
            r1.endTransaction()     // Catch: java.lang.Throwable -> Lad
        Lad:
            android.content.Context r14 = com.umeng.analytics.pro.i.f10407d
            com.umeng.analytics.pro.g r14 = com.umeng.analytics.pro.g.a(r14)
            r14.b()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.b(org.json.JSONObject, java.lang.String):void");
    }

    public String c(String str) {
        try {
            return TextUtils.isEmpty(f10408e) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), f10408e.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0054 A[EXC_TOP_SPLITTER, PHI: r1
  0x0054: PHI (r1v4 android.database.sqlite.SQLiteDatabase) = 
  (r1v2 android.database.sqlite.SQLiteDatabase)
  (r1v3 android.database.sqlite.SQLiteDatabase)
  (r1v7 android.database.sqlite.SQLiteDatabase)
 binds: [B:11:0x0052, B:16:0x0067, B:8:0x004e] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.lang.String r5, java.lang.String r6, int r7) {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.f10407d     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            r2.<init>()     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            java.lang.String r3 = "__i"
            r2.put(r3, r5)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            java.lang.String r5 = r4.c(r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            if (r6 != 0) goto L4b
            java.lang.String r6 = "__a"
            r2.put(r6, r5)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            java.lang.String r5 = "__t"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            java.lang.String r5 = "__av"
            android.content.Context r6 = com.umeng.analytics.pro.i.f10407d     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            java.lang.String r5 = "__vc"
            android.content.Context r6 = com.umeng.analytics.pro.i.f10407d     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            java.lang.String r5 = "__er"
            r1.insert(r5, r0, r2)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
        L4b:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L62
            if (r1 == 0) goto L57
            goto L54
        L51:
            r1 = r0
        L52:
            if (r1 == 0) goto L57
        L54:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L57
        L57:
            android.content.Context r5 = com.umeng.analytics.pro.i.f10407d
            com.umeng.analytics.pro.g r5 = com.umeng.analytics.pro.g.a(r5)
            r5.b()
            goto L6a
        L61:
            r1 = r0
        L62:
            android.content.Context r5 = com.umeng.analytics.pro.i.f10407d     // Catch: java.lang.Throwable -> L6c
            com.umeng.analytics.pro.h.a(r5)     // Catch: java.lang.Throwable -> L6c
            if (r1 == 0) goto L57
            goto L54
        L6a:
            r5 = 0
            return r5
        L6c:
            r5 = move-exception
            if (r1 == 0) goto L72
            r1.endTransaction()     // Catch: java.lang.Throwable -> L72
        L72:
            android.content.Context r6 = com.umeng.analytics.pro.i.f10407d
            com.umeng.analytics.pro.g r6 = com.umeng.analytics.pro.g.a(r6)
            r6.b()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(java.lang.String, java.lang.String, int):boolean");
    }

    private JSONArray b(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("duration") > 0) {
                jSONArray2.put(jSONObjectOptJSONObject);
            }
        }
        return jSONArray2;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00d9 A[PHI: r0 r1 r2
  0x00d9: PHI (r0v3 java.lang.String) = (r0v1 java.lang.String), (r0v2 java.lang.String), (r0v4 java.lang.String) binds: [B:35:0x00c5, B:41:0x00d4, B:42:0x00d6] A[DONT_GENERATE, DONT_INLINE]
  0x00d9: PHI (r1v5 android.database.sqlite.SQLiteDatabase) = 
  (r1v3 android.database.sqlite.SQLiteDatabase)
  (r1v4 android.database.sqlite.SQLiteDatabase)
  (r1v6 android.database.sqlite.SQLiteDatabase)
 binds: [B:35:0x00c5, B:41:0x00d4, B:42:0x00d6] A[DONT_GENERATE, DONT_INLINE]
  0x00d9: PHI (r2v5 android.database.Cursor) = (r2v3 android.database.Cursor), (r2v4 android.database.Cursor), (r2v6 android.database.Cursor) binds: [B:35:0x00c5, B:41:0x00d4, B:42:0x00d6] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d6 A[EXC_TOP_SPLITTER, PHI: r0 r1 r2
  0x00d6: PHI (r0v4 java.lang.String) = (r0v1 java.lang.String), (r0v2 java.lang.String), (r0v11 java.lang.String) binds: [B:35:0x00c5, B:41:0x00d4, B:27:0x00b2] A[DONT_GENERATE, DONT_INLINE]
  0x00d6: PHI (r1v6 android.database.sqlite.SQLiteDatabase) = 
  (r1v3 android.database.sqlite.SQLiteDatabase)
  (r1v4 android.database.sqlite.SQLiteDatabase)
  (r1v9 android.database.sqlite.SQLiteDatabase)
 binds: [B:35:0x00c5, B:41:0x00d4, B:27:0x00b2] A[DONT_GENERATE, DONT_INLINE]
  0x00d6: PHI (r2v6 android.database.Cursor) = (r2v3 android.database.Cursor), (r2v4 android.database.Cursor), (r2v10 android.database.Cursor) binds: [B:35:0x00c5, B:41:0x00d4, B:27:0x00b2] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(org.json.JSONObject r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.b(org.json.JSONObject, boolean):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0083 A[EXC_TOP_SPLITTER, PHI: r3
  0x0083: PHI (r3v4 android.database.sqlite.SQLiteDatabase) = 
  (r3v2 android.database.sqlite.SQLiteDatabase)
  (r3v3 android.database.sqlite.SQLiteDatabase)
  (r3v7 android.database.sqlite.SQLiteDatabase)
 binds: [B:29:0x0081, B:34:0x0096, B:26:0x007d] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.lang.String r7, org.json.JSONObject r8, com.umeng.analytics.pro.i.a r9) {
        /*
            r6 = this;
            java.lang.String r0 = "__e"
            r1 = 0
            if (r8 != 0) goto L6
            return r1
        L6:
            r2 = 0
            android.content.Context r3 = com.umeng.analytics.pro.i.f10407d     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L90
            com.umeng.analytics.pro.g r3 = com.umeng.analytics.pro.g.a(r3)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L90
            android.database.sqlite.SQLiteDatabase r3 = r3.a()     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteDatabaseCorruptException -> L90
            r3.beginTransaction()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            com.umeng.analytics.pro.i$a r4 = com.umeng.analytics.pro.i.a.BEGIN     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            if (r9 != r4) goto L4f
            java.lang.Object r8 = r8.opt(r0)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            java.lang.Long r8 = (java.lang.Long) r8     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            long r8 = r8.longValue()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            r4.<init>()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            java.lang.String r5 = "__ii"
            r4.put(r5, r7)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            java.lang.String r7 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            r4.put(r0, r7)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            java.lang.String r7 = "__av"
            android.content.Context r8 = com.umeng.analytics.pro.i.f10407d     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r8)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            r4.put(r7, r8)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            java.lang.String r7 = "__vc"
            android.content.Context r8 = com.umeng.analytics.pro.i.f10407d     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r8)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            r4.put(r7, r8)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            java.lang.String r7 = "__sd"
            r3.insert(r7, r2, r4)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            goto L7a
        L4f:
            com.umeng.analytics.pro.i$a r0 = com.umeng.analytics.pro.i.a.INSTANTSESSIONBEGIN     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            if (r9 != r0) goto L57
            r6.b(r7, r8, r3)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            goto L7a
        L57:
            com.umeng.analytics.pro.i$a r0 = com.umeng.analytics.pro.i.a.END     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            if (r9 != r0) goto L5f
            r6.a(r7, r8, r3)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            goto L7a
        L5f:
            com.umeng.analytics.pro.i$a r0 = com.umeng.analytics.pro.i.a.PAGE     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            if (r9 != r0) goto L69
            java.lang.String r9 = "__a"
            r6.a(r7, r8, r3, r9)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            goto L7a
        L69:
            com.umeng.analytics.pro.i$a r0 = com.umeng.analytics.pro.i.a.AUTOPAGE     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            if (r9 != r0) goto L73
            java.lang.String r9 = "__b"
            r6.a(r7, r8, r3, r9)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            goto L7a
        L73:
            com.umeng.analytics.pro.i$a r0 = com.umeng.analytics.pro.i.a.NEWSESSION     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            if (r9 != r0) goto L7a
            r6.c(r7, r8, r3)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L91
        L7a:
            r3.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L91
            if (r3 == 0) goto L86
            goto L83
        L80:
            r3 = r2
        L81:
            if (r3 == 0) goto L86
        L83:
            r3.endTransaction()     // Catch: java.lang.Throwable -> L86
        L86:
            android.content.Context r7 = com.umeng.analytics.pro.i.f10407d
            com.umeng.analytics.pro.g r7 = com.umeng.analytics.pro.g.a(r7)
            r7.b()
            goto L99
        L90:
            r3 = r2
        L91:
            android.content.Context r7 = com.umeng.analytics.pro.i.f10407d     // Catch: java.lang.Throwable -> L9a
            com.umeng.analytics.pro.h.a(r7)     // Catch: java.lang.Throwable -> L9a
            if (r3 == 0) goto L86
            goto L83
        L99:
            return r1
        L9a:
            r7 = move-exception
            if (r3 == 0) goto La0
            r3.endTransaction()     // Catch: java.lang.Throwable -> La0
        La0:
            android.content.Context r8 = com.umeng.analytics.pro.i.f10407d
            com.umeng.analytics.pro.g r8 = com.umeng.analytics.pro.g.a(r8)
            r8.b()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(java.lang.String, org.json.JSONObject, com.umeng.analytics.pro.i$a):boolean");
    }

    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long jLongValue = ((Long) jSONObject.opt(e.d.a.f10378g)).longValue();
            long jLongValue2 = 0;
            Object objOpt = jSONObject.opt(e.d.a.f10379h);
            if (objOpt != null && (objOpt instanceof Long)) {
                jLongValue2 = ((Long) objOpt).longValue();
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("__pp");
            String strC = "";
            String strC2 = (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.length() <= 0) ? "" : c(jSONObjectOptJSONObject.toString());
            if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.length() > 0) {
                strC = c(jSONObjectOptJSONObject2.toString());
            }
            sQLiteDatabase.execSQL("update __sd set __f=\"" + jLongValue + "\", " + e.d.a.f10379h + "=\"" + jLongValue2 + "\", __sp=\"" + strC2 + "\", __pp=\"" + strC + "\" where __ii=\"" + str + "\"");
        } catch (Throwable unused) {
        }
    }

    public void b(boolean z, boolean z2) {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = g.a(f10407d).a();
                sQLiteDatabaseA.beginTransaction();
                if (z2) {
                    if (z) {
                        sQLiteDatabaseA.execSQL("delete from __sd");
                    }
                } else if (this.f10412i.size() > 0) {
                    for (int i2 = 0; i2 < this.f10412i.size(); i2++) {
                        sQLiteDatabaseA.execSQL("delete from __sd where __ii=\"" + this.f10412i.get(i2) + "\"");
                    }
                }
                sQLiteDatabaseA.setTransactionSuccessful();
            } catch (SQLiteDatabaseCorruptException unused) {
                h.a(f10407d);
                if (sQLiteDatabaseA != null) {
                }
            } catch (Throwable unused2) {
                if (sQLiteDatabaseA != null) {
                }
            }
        } finally {
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused3) {
                }
            }
            g.a(f10407d).b();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005f A[Catch: Exception -> 0x0062, PHI: r2 r4
  0x005f: PHI (r2v3 long) = (r2v0 long), (r2v6 long) binds: [B:24:0x005d, B:9:0x003c] A[DONT_GENERATE, DONT_INLINE]
  0x005f: PHI (r4v4 android.database.sqlite.SQLiteDatabase) = (r4v3 android.database.sqlite.SQLiteDatabase), (r4v7 android.database.sqlite.SQLiteDatabase) binds: [B:24:0x005d, B:9:0x003c] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #4 {Exception -> 0x0062, blocks: (B:8:0x0039, B:25:0x005f, B:23:0x005a), top: B:33:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long a(java.lang.String r16) throws java.lang.Throwable {
        /*
            r15 = this;
            java.lang.String r0 = "__f"
            r1 = 0
            r2 = 0
            android.content.Context r4 = com.umeng.analytics.pro.i.f10407d     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L57
            com.umeng.analytics.pro.g r4 = com.umeng.analytics.pro.g.a(r4)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L57
            android.database.sqlite.SQLiteDatabase r4 = r4.a()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L57
            r4.beginTransaction()     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L58
            java.lang.String[] r8 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L58
            java.lang.String r6 = "__sd"
            java.lang.String r9 = "__ii=? "
            r5 = 1
            java.lang.String[] r10 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L58
            r5 = 0
            r10[r5] = r16     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L58
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r5 = r15
            r7 = r4
            android.database.Cursor r1 = r5.a(r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L58
            if (r1 == 0) goto L37
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L58
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L58
            long r2 = r1.getLong(r0)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L58
        L37:
            if (r1 == 0) goto L3c
            r1.close()     // Catch: java.lang.Exception -> L62
        L3c:
            if (r4 == 0) goto L62
            goto L5f
        L3f:
            r0 = move-exception
            goto L43
        L41:
            r0 = move-exception
            r4 = r1
        L43:
            if (r1 == 0) goto L48
            r1.close()     // Catch: java.lang.Exception -> L4d
        L48:
            if (r4 == 0) goto L4d
            r4.endTransaction()     // Catch: java.lang.Exception -> L4d
        L4d:
            android.content.Context r1 = com.umeng.analytics.pro.i.f10407d
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)
            r1.b()
            throw r0
        L57:
            r4 = r1
        L58:
            if (r1 == 0) goto L5d
            r1.close()     // Catch: java.lang.Exception -> L62
        L5d:
            if (r4 == 0) goto L62
        L5f:
            r4.endTransaction()     // Catch: java.lang.Exception -> L62
        L62:
            android.content.Context r0 = com.umeng.analytics.pro.i.f10407d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(java.lang.String):long");
    }

    public void b(String str) {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = g.a(f10407d).a();
                sQLiteDatabaseA.beginTransaction();
                if (!TextUtils.isEmpty(str)) {
                    sQLiteDatabaseA.execSQL("delete from __is where __ii=\"" + str + "\"");
                }
                sQLiteDatabaseA.setTransactionSuccessful();
            } catch (SQLiteDatabaseCorruptException unused) {
                h.a(f10407d);
                if (sQLiteDatabaseA != null) {
                }
            } catch (Throwable unused2) {
                if (sQLiteDatabaseA != null) {
                }
            }
        } finally {
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused3) {
                }
            }
            g.a(f10407d).b();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0077 A[Catch: all -> 0x0069, TryCatch #1 {all -> 0x0069, blocks: (B:22:0x0056, B:24:0x005c, B:26:0x006c, B:28:0x0077, B:29:0x007c, B:36:0x008b, B:38:0x0091, B:40:0x0097, B:42:0x009d, B:44:0x00ab, B:41:0x009a), top: B:54:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0056 A[EXC_TOP_SPLITTER, LOOP:1: B:54:0x0056->B:24:0x005c, LOOP_START, PHI: r14
  0x0056: PHI (r14v1 java.lang.String) = (r14v0 java.lang.String), (r14v2 java.lang.String) binds: [B:21:0x0054, B:24:0x005c] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.String r18, org.json.JSONObject r19, android.database.sqlite.SQLiteDatabase r20, java.lang.String r21) throws org.json.JSONException {
        /*
            r17 = this;
            r10 = r17
            r11 = r18
            r0 = r19
            r12 = r21
            java.lang.String r13 = "=\""
            java.lang.String r1 = "__b"
            java.lang.String r2 = "__a"
            r14 = 0
            boolean r3 = r2.equals(r12)     // Catch: java.lang.Throwable -> Ldf
            if (r3 == 0) goto L25
            org.json.JSONArray r0 = r0.optJSONArray(r2)     // Catch: java.lang.Throwable -> Ldf
            if (r0 == 0) goto L24
            int r1 = r0.length()     // Catch: java.lang.Throwable -> Ldf
            if (r1 > 0) goto L22
            goto L24
        L22:
            r15 = r0
            goto L39
        L24:
            return
        L25:
            boolean r2 = r1.equals(r12)     // Catch: java.lang.Throwable -> Ldf
            if (r2 == 0) goto L38
            org.json.JSONArray r0 = r0.optJSONArray(r1)     // Catch: java.lang.Throwable -> Ldf
            if (r0 == 0) goto L37
            int r1 = r0.length()     // Catch: java.lang.Throwable -> Ldf
            if (r1 > 0) goto L22
        L37:
            return
        L38:
            r15 = r14
        L39:
            r0 = 1
            java.lang.String[] r3 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> Ldf
            r16 = 0
            r3[r16] = r12     // Catch: java.lang.Throwable -> Ldf
            java.lang.String r1 = "__sd"
            java.lang.String r4 = "__ii=? "
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> Ldf
            r5[r16] = r11     // Catch: java.lang.Throwable -> Ldf
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r0 = r17
            r2 = r20
            android.database.Cursor r0 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> Ldf
            if (r0 == 0) goto L6c
        L56:
            boolean r1 = r0.moveToNext()     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L6c
            int r1 = r0.getColumnIndex(r12)     // Catch: java.lang.Throwable -> L69
            java.lang.String r1 = r0.getString(r1)     // Catch: java.lang.Throwable -> L69
            java.lang.String r14 = r10.d(r1)     // Catch: java.lang.Throwable -> L69
            goto L56
        L69:
            goto Le0
        L6c:
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L69
            r1.<init>()     // Catch: java.lang.Throwable -> L69
            boolean r2 = android.text.TextUtils.isEmpty(r14)     // Catch: java.lang.Throwable -> L69
            if (r2 != 0) goto L7c
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L69
            r1.<init>(r14)     // Catch: java.lang.Throwable -> L69
        L7c:
            int r2 = r1.length()     // Catch: java.lang.Throwable -> L69
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r2 <= r3) goto L8a
            if (r0 == 0) goto L89
            r0.close()
        L89:
            return
        L8a:
            r2 = 0
        L8b:
            int r3 = r15.length()     // Catch: java.lang.Throwable -> L69
            if (r2 >= r3) goto L9d
            org.json.JSONObject r3 = r15.getJSONObject(r2)     // Catch: java.lang.Throwable -> L69 org.json.JSONException -> L9a
            if (r3 == 0) goto L9a
            r1.put(r3)     // Catch: java.lang.Throwable -> L69
        L9a:
            int r2 = r2 + 1
            goto L8b
        L9d:
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L69
            java.lang.String r1 = r10.c(r1)     // Catch: java.lang.Throwable -> L69
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L69
            if (r2 != 0) goto Ldc
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L69
            r2.<init>()     // Catch: java.lang.Throwable -> L69
            java.lang.String r3 = "update __sd set "
            r2.append(r3)     // Catch: java.lang.Throwable -> L69
            r2.append(r12)     // Catch: java.lang.Throwable -> L69
            r2.append(r13)     // Catch: java.lang.Throwable -> L69
            r2.append(r1)     // Catch: java.lang.Throwable -> L69
            java.lang.String r1 = "\" where "
            r2.append(r1)     // Catch: java.lang.Throwable -> L69
            java.lang.String r1 = "__ii"
            r2.append(r1)     // Catch: java.lang.Throwable -> L69
            r2.append(r13)     // Catch: java.lang.Throwable -> L69
            r2.append(r11)     // Catch: java.lang.Throwable -> L69
            java.lang.String r1 = "\""
            r2.append(r1)     // Catch: java.lang.Throwable -> L69
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L69
            r2 = r20
            r2.execSQL(r1)     // Catch: java.lang.Throwable -> L69
        Ldc:
            if (r0 == 0) goto Le5
            goto Le2
        Ldf:
            r0 = r14
        Le0:
            if (r0 == 0) goto Le5
        Le2:
            r0.close()
        Le5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(java.lang.String, org.json.JSONObject, android.database.sqlite.SQLiteDatabase, java.lang.String):void");
    }

    public JSONObject a(boolean z) {
        a();
        this.f10413j.clear();
        JSONObject jSONObject = new JSONObject();
        if (!z) {
            a(jSONObject, z);
            b(jSONObject, (String) null);
            a(jSONObject, (String) null);
        } else {
            String strA = a(jSONObject, z);
            if (!TextUtils.isEmpty(strA)) {
                b(jSONObject, strA);
                a(jSONObject, strA);
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:91:0x0192 A[EXC_TOP_SPLITTER, PHI: r0 r1
  0x0192: PHI (r0v5 android.database.Cursor) = (r0v2 android.database.Cursor), (r0v3 android.database.Cursor), (r0v8 android.database.Cursor) binds: [B:70:0x0182, B:76:0x0190, B:64:0x0174] A[DONT_GENERATE, DONT_INLINE]
  0x0192: PHI (r1v6 android.database.sqlite.SQLiteDatabase) = 
  (r1v3 android.database.sqlite.SQLiteDatabase)
  (r1v4 android.database.sqlite.SQLiteDatabase)
  (r1v9 android.database.sqlite.SQLiteDatabase)
 binds: [B:70:0x0182, B:76:0x0190, B:64:0x0174] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0195 A[PHI: r0 r1
  0x0195: PHI (r0v4 android.database.Cursor) = (r0v2 android.database.Cursor), (r0v3 android.database.Cursor), (r0v5 android.database.Cursor) binds: [B:70:0x0182, B:76:0x0190, B:77:0x0192] A[DONT_GENERATE, DONT_INLINE]
  0x0195: PHI (r1v5 android.database.sqlite.SQLiteDatabase) = 
  (r1v3 android.database.sqlite.SQLiteDatabase)
  (r1v4 android.database.sqlite.SQLiteDatabase)
  (r1v6 android.database.sqlite.SQLiteDatabase)
 binds: [B:70:0x0182, B:76:0x0190, B:77:0x0192] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(org.json.JSONObject r14, java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 436
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(org.json.JSONObject, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x0238 A[PHI: r0 r12 r14
  0x0238: PHI (r0v4 java.lang.String) = (r0v2 java.lang.String), (r0v3 java.lang.String), (r0v5 java.lang.String) binds: [B:94:0x0224, B:100:0x0233, B:101:0x0235] A[DONT_GENERATE, DONT_INLINE]
  0x0238: PHI (r12v5 android.database.sqlite.SQLiteDatabase) = 
  (r12v3 android.database.sqlite.SQLiteDatabase)
  (r12v4 android.database.sqlite.SQLiteDatabase)
  (r12v6 android.database.sqlite.SQLiteDatabase)
 binds: [B:94:0x0224, B:100:0x0233, B:101:0x0235] A[DONT_GENERATE, DONT_INLINE]
  0x0238: PHI (r14v5 android.database.Cursor) = (r14v3 android.database.Cursor), (r14v4 android.database.Cursor), (r14v6 android.database.Cursor) binds: [B:94:0x0224, B:100:0x0233, B:101:0x0235] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0235 A[EXC_TOP_SPLITTER, PHI: r0 r12 r14
  0x0235: PHI (r0v5 java.lang.String) = (r0v2 java.lang.String), (r0v3 java.lang.String), (r0v38 java.lang.String) binds: [B:94:0x0224, B:100:0x0233, B:86:0x0211] A[DONT_GENERATE, DONT_INLINE]
  0x0235: PHI (r12v6 android.database.sqlite.SQLiteDatabase) = 
  (r12v3 android.database.sqlite.SQLiteDatabase)
  (r12v4 android.database.sqlite.SQLiteDatabase)
  (r12v7 android.database.sqlite.SQLiteDatabase)
 binds: [B:94:0x0224, B:100:0x0233, B:86:0x0211] A[DONT_GENERATE, DONT_INLINE]
  0x0235: PHI (r14v6 android.database.Cursor) = (r14v3 android.database.Cursor), (r14v4 android.database.Cursor), (r14v33 android.database.Cursor) binds: [B:94:0x0224, B:100:0x0233, B:86:0x0211] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0230  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(org.json.JSONObject r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 599
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(org.json.JSONObject, boolean):java.lang.String");
    }

    public void a(boolean z, boolean z2) {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                try {
                    sQLiteDatabaseA = g.a(f10407d).a();
                    sQLiteDatabaseA.beginTransaction();
                    if (!z2) {
                        int size = this.f10415l.size();
                        int i2 = 0;
                        if (size > 0) {
                            int i3 = 0;
                            while (i2 < size) {
                                String str = this.f10415l.get(i2);
                                if (str == null) {
                                    i3 = 1;
                                }
                                sQLiteDatabaseA.execSQL("delete from __is where __ii=\"" + str + "\"");
                                i2++;
                            }
                            i2 = i3;
                        }
                        if (i2 != 0) {
                            sQLiteDatabaseA.execSQL("delete from __is where __ii is null");
                        }
                    } else if (z) {
                        sQLiteDatabaseA.execSQL("delete from __is");
                    }
                    sQLiteDatabaseA.setTransactionSuccessful();
                } catch (SQLiteDatabaseCorruptException unused) {
                    h.a(f10407d);
                    if (sQLiteDatabaseA != null) {
                    }
                }
            } catch (Throwable unused2) {
                h.a(f10407d);
                if (sQLiteDatabaseA != null) {
                }
            }
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused3) {
                }
            }
            g.a(f10407d).b();
        } catch (Throwable th) {
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused4) {
                }
            }
            g.a(f10407d).b();
            throw th;
        }
    }

    public void a(boolean z, String str) {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                sQLiteDatabaseA = g.a(f10407d).a();
                sQLiteDatabaseA.beginTransaction();
                if (!TextUtils.isEmpty(str)) {
                    sQLiteDatabaseA.execSQL("delete from __er where __i=\"" + str + "\"");
                    sQLiteDatabaseA.execSQL("delete from __et where __i=\"" + str + "\"");
                    this.f10413j.clear();
                    sQLiteDatabaseA.execSQL("delete from __sd where __ii=\"" + str + "\"");
                }
                sQLiteDatabaseA.setTransactionSuccessful();
            } catch (SQLiteDatabaseCorruptException unused) {
                h.a(f10407d);
                if (sQLiteDatabaseA != null) {
                }
            } catch (Throwable unused2) {
                if (sQLiteDatabaseA != null) {
                }
            }
        } finally {
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused3) {
                }
            }
            g.a(f10407d).b();
        }
    }
}
