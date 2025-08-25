package com.xiaomi.push.providers;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.bh;
import com.xiaomi.channel.commonutils.logger.b;

/* loaded from: classes2.dex */
public class a extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    private static int f13264a = 1;

    /* renamed from: a, reason: collision with other field name */
    public static final Object f918a = new Object();

    /* renamed from: a, reason: collision with other field name */
    private static final String[] f919a = {"package_name", "TEXT", "message_ts", " LONG DEFAULT 0 ", "bytes", " LONG DEFAULT 0 ", bh.T, " INT DEFAULT -1 ", "rcv", " INT DEFAULT -1 ", Constants.KEY_IMSI, "TEXT"};

    public a(Context context) {
        super(context, "traffic.db", (SQLiteDatabase.CursorFactory) null, f13264a);
    }

    private void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
        StringBuilder sb = new StringBuilder("CREATE TABLE traffic(_id INTEGER  PRIMARY KEY ,");
        for (int i2 = 0; i2 < f919a.length - 1; i2 += 2) {
            if (i2 != 0) {
                sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb.append(f919a[i2]);
            sb.append(c.c.a.b.a.a.f3100g);
            sb.append(f919a[i2 + 1]);
        }
        sb.append(");");
        sQLiteDatabase.execSQL(sb.toString());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (f918a) {
            try {
                a(sQLiteDatabase);
            } catch (SQLException e2) {
                b.a(e2);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
