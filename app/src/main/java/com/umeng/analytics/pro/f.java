package com.umeng.analytics.pro;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.umeng.analytics.pro.e;

/* compiled from: UMDBCreater.java */
/* loaded from: classes2.dex */
class f extends SQLiteOpenHelper {

    /* renamed from: b, reason: collision with root package name */
    private static Context f10396b;

    /* renamed from: a, reason: collision with root package name */
    private String f10397a;

    /* compiled from: UMDBCreater.java */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final f f10398a = new f(f.f10396b, h.b(f.f10396b), e.f10330b, null, 2);

        private a() {
        }
    }

    public static f a(Context context) {
        if (f10396b == null) {
            f10396b = context.getApplicationContext();
        }
        return a.f10398a;
    }

    private void c(SQLiteDatabase sQLiteDatabase) throws SQLException {
        try {
            this.f10397a = "create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL(this.f10397a);
        } catch (SQLException unused) {
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase) throws SQLException {
        try {
            this.f10397a = "create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL(this.f10397a);
        } catch (SQLException unused) {
        }
    }

    private void e(SQLiteDatabase sQLiteDatabase) throws SQLException {
        if (!h.a(sQLiteDatabase, e.d.f10371a, "__av")) {
            h.a(sQLiteDatabase, e.d.f10371a, "__sp", "TEXT");
            h.a(sQLiteDatabase, e.d.f10371a, "__pp", "TEXT");
            h.a(sQLiteDatabase, e.d.f10371a, "__av", "TEXT");
            h.a(sQLiteDatabase, e.d.f10371a, "__vc", "TEXT");
        }
        if (!h.a(sQLiteDatabase, e.b.f10345a, "__av")) {
            h.a(sQLiteDatabase, e.b.f10345a, "__av", "TEXT");
            h.a(sQLiteDatabase, e.b.f10345a, "__vc", "TEXT");
        }
        if (h.a(sQLiteDatabase, e.a.f10334a, "__av")) {
            return;
        }
        h.a(sQLiteDatabase, e.a.f10334a, "__av", "TEXT");
        h.a(sQLiteDatabase, e.a.f10334a, "__vc", "TEXT");
    }

    private void f(SQLiteDatabase sQLiteDatabase) throws SQLException {
        a(sQLiteDatabase, e.d.f10371a);
        a(sQLiteDatabase, e.b.f10345a);
        a(sQLiteDatabase, e.a.f10334a);
        a();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                c(sQLiteDatabase);
                d(sQLiteDatabase);
                b(sQLiteDatabase);
                a(sQLiteDatabase);
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase == null) {
                    return;
                }
            } catch (SQLiteDatabaseCorruptException unused) {
                h.a(f10396b);
                if (sQLiteDatabase == null) {
                    return;
                }
            } catch (Throwable unused2) {
                if (sQLiteDatabase == null) {
                    return;
                }
            }
            try {
                sQLiteDatabase.endTransaction();
            } catch (Throwable unused3) {
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused4) {
                }
            }
            throw th;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) throws SQLException {
        if (i3 <= i2 || i2 != 1) {
            return;
        }
        try {
            try {
                e(sQLiteDatabase);
            } catch (Exception unused) {
                e(sQLiteDatabase);
            }
        } catch (Exception unused2) {
            f(sQLiteDatabase);
        }
    }

    private f(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        this(new c(context, str), str2, cursorFactory, i2);
    }

    private void b(SQLiteDatabase sQLiteDatabase) throws SQLException {
        try {
            this.f10397a = "create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL(this.f10397a);
        } catch (SQLException unused) {
        }
    }

    private f(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, TextUtils.isEmpty(str) ? e.f10330b : str, cursorFactory, i2);
        this.f10397a = null;
        a();
    }

    public void a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!h.a(e.d.f10371a, writableDatabase)) {
                c(writableDatabase);
            }
            if (!h.a(e.c.f10358a, writableDatabase)) {
                d(writableDatabase);
            }
            if (!h.a(e.b.f10345a, writableDatabase)) {
                b(writableDatabase);
            }
            if (h.a(e.a.f10334a, writableDatabase)) {
                return;
            }
            a(writableDatabase);
        } catch (Exception unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
        try {
            this.f10397a = "create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL(this.f10397a);
        } catch (SQLException unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str) throws SQLException {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        } catch (SQLException unused) {
        }
    }
}
