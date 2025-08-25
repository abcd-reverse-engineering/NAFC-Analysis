package db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import ui.Hicore;

/* loaded from: classes2.dex */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "phoneNumber_db";
    public static final int DB_VERSION = 3;

    public MySQLiteOpenHelper() {
        super(Hicore.getApp(), DB_NAME, (SQLiteDatabase.CursorFactory) null, 3);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        try {
            sQLiteDatabase.execSQL("drop table file_info");
        } catch (SQLException unused) {
        }
        sQLiteDatabase.execSQL("create table user(number varchar(20))");
        sQLiteDatabase.execSQL("create table user1(number varchar(20))");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS file_info(_id integer PRIMARY KEY AUTOINCREMENT, file_name TEXT,file_md5 TEXT,file_path TEXT,file_local_path TEXT,file_id TEXT,source INTEGER,source_id TEXT)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }

    public MySQLiteOpenHelper(String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(Hicore.getApp(), str, cursorFactory, i2);
    }

    public MySQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(Hicore.getApp(), str, cursorFactory, i2);
    }
}
